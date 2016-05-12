package mengka.concurrentMengkaMap_01;

/**
 * 利用分离锁实现的一个线程安全的hashMap
 * 
 * @author mengka.hyy
 * 
 */
public class ConcurrentMengkaMap {

	/**
	 * 16个分段锁，buckets[n]由locks[n%16]守护
	 */
	private static final int N_LOCKS = 16;

	/**
	 * Map的默认容量，超出这个值之后，需要进行rehash操作（map的扩展、重排）
	 */
	private static final int DEFAULT_BUCKET_COUNT = 1000;

	private final Node[] buckets;

	private final Object[] locks;

	public ConcurrentMengkaMap() {
		this.buckets = new Node[DEFAULT_BUCKET_COUNT];
		this.locks = new Object[N_LOCKS];
		for (int i = 0; i < N_LOCKS; i++) {
			locks[i] = new Object();
		}
	}

	public ConcurrentMengkaMap(int count) {
		this.buckets = new Node[count];
		this.locks = new Object[N_LOCKS];
		for (int i = 0; i < N_LOCKS; i++) {
			locks[i] = new Object();
		}
	}

	/**
	 * get数据
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		int bucketCount = calculateBucketCount(key);
		/**
		 * 分离锁：get()，只需要得到一个bucket锁
		 */
		synchronized (locks[calculateLockCount(bucketCount)]) {
			for (Node node = buckets[bucketCount]; node != null; node = node
					.getNext()) {
				if (node.getKey().equals(key)) {
					return node.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * put数据
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value) {
		remove(key);
		int bucketCount = calculateBucketCount(key);
		synchronized (locks[calculateLockCount(bucketCount)]) {
			Node node = buckets[bucketCount];
			if (node == null) {
				Node insertNode = new Node(key, value);
				buckets[bucketCount] = insertNode;
			} else {
				Node insertNode = new Node(key, value);
				node.setNext(insertNode);
			}
		}
	}

	/**
	 * remove数据
	 * 
	 * @param key
	 */
	public void remove(Object key) {
		int bucketCount = calculateBucketCount(key);
		synchronized (locks[calculateLockCount(bucketCount)]) {
			Node node = buckets[bucketCount];
			if (node == null) {
				return;
			}
			if (node.getKey().equals(key)) {
				buckets[bucketCount] = node.getNext();
			}
			while (node != null) {
				Node nextNode = node.getNext();
				if (nextNode == null) {
					return;
				}
				if (nextNode.getKey().equals(key)) {
					node.next = nextNode.next;
					return;
				}
				node = nextNode;
			}
		}
	}

	/**
	 * 顺序获得所有的分离锁，每个bucket区块都会有一个自己维护的size，将这些size加起来并返回即就是需要的结果
	 * 
	 * @return
	 */
	public int size() {
		return 0;
	}

	/**
	 * 某些方法需要获得所有的分离的锁
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * 计算key对应的bucket[n]
	 * 
	 * @param key
	 * @return
	 */
	private final int calculateBucketCount(Object key) {
		long value = key.hashCode();
		return (int) Math.abs(value % buckets.length);
	}

	/**
	 * bucketCount mod 16,计算每个bucket是归哪一个锁守护
	 * 
	 * @param bucketCount
	 * @return
	 */
	private int calculateLockCount(long bucketCount) {
		return (int) getMod(bucketCount, N_LOCKS);
	}

	/**
	 * 对一个数求模
	 * 
	 * @param value
	 * @param mod
	 * @return
	 */
	private static long getMod(long value, long mod) {
		long table = value % mod;
		return table < 0 ? table + mod : table;
	}

	/**
	 * 节点
	 * 
	 * @author mengka.hyy
	 * 
	 */
	private class Node {

		private Object key;

		private Object value;

		private Node next;

		private Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Object getKey() {
			return key;
		}

		public void setKey(Object key) {
			this.key = key;
		}

	}
}

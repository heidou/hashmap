package mengka.concurrentMengkaMap_01;

/**
 * ���÷�����ʵ�ֵ�һ���̰߳�ȫ��hashMap
 * 
 * @author mengka.hyy
 * 
 */
public class ConcurrentMengkaMap {

	/**
	 * 16���ֶ�����buckets[n]��locks[n%16]�ػ�
	 */
	private static final int N_LOCKS = 16;

	/**
	 * Map��Ĭ���������������ֵ֮����Ҫ����rehash������map����չ�����ţ�
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
	 * get����
	 * 
	 * @param key
	 * @return
	 */
	public Object get(Object key) {
		int bucketCount = calculateBucketCount(key);
		/**
		 * ��������get()��ֻ��Ҫ�õ�һ��bucket��
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
	 * put����
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
	 * remove����
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
	 * ˳�������еķ�������ÿ��bucket���鶼����һ���Լ�ά����size������Щsize�����������ؼ�������Ҫ�Ľ��
	 * 
	 * @return
	 */
	public int size() {
		return 0;
	}

	/**
	 * ĳЩ������Ҫ������еķ������
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return false;
	}

	/**
	 * ����key��Ӧ��bucket[n]
	 * 
	 * @param key
	 * @return
	 */
	private final int calculateBucketCount(Object key) {
		long value = key.hashCode();
		return (int) Math.abs(value % buckets.length);
	}

	/**
	 * bucketCount mod 16,����ÿ��bucket�ǹ���һ�����ػ�
	 * 
	 * @param bucketCount
	 * @return
	 */
	private int calculateLockCount(long bucketCount) {
		return (int) getMod(bucketCount, N_LOCKS);
	}

	/**
	 * ��һ������ģ
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
	 * �ڵ�
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

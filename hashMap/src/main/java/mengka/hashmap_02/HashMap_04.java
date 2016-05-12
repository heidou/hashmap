package mengka.hashmap_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * hashMap线程非安全
 * <hr>
 * 1.hashmap是线程非安全的，若在并发情景下不保持足够的同步，则会在HashMap.get(KEY)时，死循环；<br>
 * 2.HashMap通常会用一个指针数组（假设为table[]）来做分散所有的key，当一个key被加入时，会通过Hash算法通过key算出这个数组的下标i
 * ，然后就把这个<key, value>插到table[i]中，<br>
 * 如果有两个不同的key被算在了同一个i，那么就叫【冲突】，又叫【碰撞】，这样会在table[i]上形成一个链表。<br>
 * 3.如果table[]的尺寸很小，比如只有2个，如果要放进10个keys的话，那么碰撞非常频繁<br>
 * 【注：于是，一个O(1)的查找算法，就变成了链表遍历，性能变成了O(n)，这是Hash表的缺陷。】<br>
 * 4.Hash表这个容器当有数据要插入时，都会检查容量有没有超过设定的thredhold，如果超过，需要增大Hash表的尺寸<br>
 * 【注：这样一来，整个Hash表里的无素都需要被重算一遍。这叫rehash，这个成本相当的大。】
 * 
 * @author mengka.hyy
 * 
 */
public class HashMap_04 {

	/**
	 * hashMap的容量newCapacity=1000，设置的比200大很多，所以rehash的次数相比不设置容量就会减少，<br>
	 * 获取到的obj就不是空的，checkNum就不会增加了 <br>
	 * 0 0 0 0 0 0 0 0 0 0
	 * 
	 * @param newCapacity
	 * @throws Exception
	 */
	static void doit(int newCapacity) throws Exception {
		final int count = 200;
		final AtomicInteger checkNum = new AtomicInteger(0);
		ExecutorService threadPool = Executors.newFixedThreadPool(100);

		final Map<Long, String> map = new HashMap<Long, String>(newCapacity);

		map.put(0L, "http://coolshell.cn/articles/9606.html");
		for (int j = 0; j < count; j++) {
			threadPool.submit(new Runnable() {
				public void run() {
					map.put(System.nanoTime() + new Random().nextLong(),
							"http://coolshell.cn/articles/9606.html");
					String obj = map.get(0L);
					if (obj == null) {
						checkNum.incrementAndGet();
					}
				}
			});
		}
		threadPool.awaitTermination(1, TimeUnit.SECONDS);
		threadPool.shutdown();

		System.out.println(checkNum.get());
	}

	/**
	 * 默认的table[]的尺寸很小，200个线程同时读写map，rehash就会非常频繁，就会导致在某些情况下获取的数据是空的 <br>
	 * 8 0 0 8 0 5 0 1 0 0
	 * 
	 * @throws Exception
	 */
	static void doitUnSafe() throws Exception {
		final int count = 200;
		final AtomicInteger checkNum = new AtomicInteger(0);
		ExecutorService threadPool = Executors.newFixedThreadPool(100);

		final Map<Long, String> map = new HashMap<Long, String>();

		map.put(0L, "http://coolshell.cn/articles/9606.html");
		for (int j = 0; j < count; j++) {
			threadPool.submit(new Runnable() {
				public void run() {
					map.put(System.nanoTime() + new Random().nextLong(),
							"http://coolshell.cn/articles/9606.html");
					String obj = map.get(0L);
					if (obj == null) {
						checkNum.incrementAndGet();
					}
				}
			});
		}
		threadPool.awaitTermination(1, TimeUnit.SECONDS);
		threadPool.shutdown();

		System.out.println(checkNum.get());
	}

	public static void main(String[] args) throws Exception {

		/**
		 * hashMap线程不安全例子，容量大小变化，需要进行rehash
		 */
		for (int i = 0; i < 10; i++) {
			doitUnSafe();
			Thread.sleep(500L);
		}

		System.out.println("======================");

		for (int i = 0; i < 10; i++) {
			doit(1000);
			Thread.sleep(500L);
		}
	}
}

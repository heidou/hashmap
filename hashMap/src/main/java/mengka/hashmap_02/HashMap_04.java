package mengka.hashmap_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * hashMap�̷߳ǰ�ȫ
 * <hr>
 * 1.hashmap���̷߳ǰ�ȫ�ģ����ڲ����龰�²������㹻��ͬ���������HashMap.get(KEY)ʱ����ѭ����<br>
 * 2.HashMapͨ������һ��ָ�����飨����Ϊtable[]��������ɢ���е�key����һ��key������ʱ����ͨ��Hash�㷨ͨ��key������������±�i
 * ��Ȼ��Ͱ����<key, value>�嵽table[i]�У�<br>
 * �����������ͬ��key��������ͬһ��i����ô�ͽС���ͻ�����ֽС���ײ������������table[i]���γ�һ������<br>
 * 3.���table[]�ĳߴ��С������ֻ��2�������Ҫ�Ž�10��keys�Ļ�����ô��ײ�ǳ�Ƶ��<br>
 * ��ע�����ǣ�һ��O(1)�Ĳ����㷨���ͱ����������������ܱ����O(n)������Hash���ȱ�ݡ���<br>
 * 4.Hash�����������������Ҫ����ʱ��������������û�г����趨��thredhold�������������Ҫ����Hash��ĳߴ�<br>
 * ��ע������һ��������Hash��������ض���Ҫ������һ�顣���rehash������ɱ��൱�Ĵ󡣡�
 * 
 * @author mengka.hyy
 * 
 */
public class HashMap_04 {

	/**
	 * hashMap������newCapacity=1000�����õı�200��ܶ࣬����rehash�Ĵ�����Ȳ����������ͻ���٣�<br>
	 * ��ȡ����obj�Ͳ��ǿյģ�checkNum�Ͳ��������� <br>
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
	 * Ĭ�ϵ�table[]�ĳߴ��С��200���߳�ͬʱ��дmap��rehash�ͻ�ǳ�Ƶ�����ͻᵼ����ĳЩ����»�ȡ�������ǿյ� <br>
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
		 * hashMap�̲߳���ȫ���ӣ�������С�仯����Ҫ����rehash
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

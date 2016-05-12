package mengka.hashTable_01;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * HashTable使用：<br>
 * HashTable是一个过时的容器类，通过使用synchronized来保证线程安全，在线程竞争激烈的情况下HashTable的效率非常低下；<br>
 * 所有访问HashTable的线程都必须竞争同一把锁;<br>
 * <hr>
 * ConcurrentHashMap原理：<br>
 * 那假如容器里有多把锁，每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，从而可以有效的提高并发访问效率，
 * 这就是ConcurrentHashMap所使用的锁分段技术。
 * <br><br>
 *  参考：java_52，java_53
 * <br><br>
 * 
 * @author mengka.hyy
 * 
 */
public class hashTable_01 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		Hashtable hashtable = new Hashtable();
		hashtable.put("aa", "baicai AA..");
		hashtable.put("bb", "qingcai AA..");
		hashtable.put("cc", "xigua AA..");

		Enumeration enumeration = hashtable.keys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			Object value = hashtable.get(key);
			System.out.println("<" + key + "," + value + ">");
		}

	}

}

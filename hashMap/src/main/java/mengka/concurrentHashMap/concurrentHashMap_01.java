package mengka.concurrentHashMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <font color="red">【线程安全的HashMap实现】</font>
 * <hr>
 * 当线程数>50后，<br>
 * concurrentHashMap总体性能，比HashMap都有很大优势，<br>
 * 特别在查找元素上，有10倍左右的性能提升。
 * <hr>
 * HashEntry对象数组，对应的变量时volatile类型的，<br>
 * 当put(k,v)时，读操作可看到最新的对象数组的大小
 * <hr>
 * concurrentHashMap原理:<br>
 * <ul>
 * <li>那假如HashTable容器里有多把锁，每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，
 * 从而可以有效的提高并发访问效率， 这就是ConcurrentHashMap所使用的锁分段技术。</li>
 * <li>concurrentHashMap需要跨段的方法：<br>
 * 比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁。
 * 这里“按顺序”是很重要的，否则极有可能出现死锁；</li>
 * <li>concurrentHashMap跨段：为了保证不会出现死锁，获得分段锁的顺序时固定的；（不变性在多线程编程中，占有很重要的地位）</li>
 * <li>concurrentHashMap允许多个读操作同时进行，读操作不需要加锁；</li>
 * </ul>
 * <br><br>
 *  参考：java_52，java_53
 *  <br><br>
 *  
 * @author mengka.hyy
 * 
 */
public class concurrentHashMap_01 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		ConcurrentHashMap conMap = new ConcurrentHashMap();

		conMap.put("aa", "大白菜AAA");
		conMap.put("bb", "大白菜BBB");
		conMap.put("cc", "大白菜CCC");

		Iterator iterator = conMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}
	}

}

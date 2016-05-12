package mengka.concurrentHashMap_03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * threadLocal原理<br>
 * 每个线程都有一个自己独立的变量副本，使其线程安全，效率上也大大提高 <br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class MengkaThreadLocal<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map valueMap = Collections.synchronizedMap(new HashMap());
	
	/**
	 *  key是当前线程
	 * 
	 * @param newValue
	 */
	@SuppressWarnings("unchecked")
	public void set(T newValue) {
		valueMap.put(Thread.currentThread(), newValue);// ①键为线程对象，值为本线程的变量副本
	}

	/**
	 *  获取当前线程的对应的变量副本内容
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public T get() {
		Thread currentThread = Thread.currentThread();
		T o = (T)valueMap.get(currentThread);// ②返回本线程对应的变量
		if (o == null && !valueMap.containsKey(currentThread)) {
			// ③如果在Map中不存在，放到Map中保存起来。
			o = initialValue();
			valueMap.put(currentThread, o);
		}
		return o;
	}

	public void remove() {
		valueMap.remove(Thread.currentThread());
	}

	public T initialValue() {
		return null;
	}
	
}

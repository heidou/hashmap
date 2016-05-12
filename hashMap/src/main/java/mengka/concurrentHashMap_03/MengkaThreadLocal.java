package mengka.concurrentHashMap_03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * threadLocalԭ��<br>
 * ÿ���̶߳���һ���Լ������ı���������ʹ���̰߳�ȫ��Ч����Ҳ������ <br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class MengkaThreadLocal<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Map valueMap = Collections.synchronizedMap(new HashMap());
	
	/**
	 *  key�ǵ�ǰ�߳�
	 * 
	 * @param newValue
	 */
	@SuppressWarnings("unchecked")
	public void set(T newValue) {
		valueMap.put(Thread.currentThread(), newValue);// �ټ�Ϊ�̶߳���ֵΪ���̵߳ı�������
	}

	/**
	 *  ��ȡ��ǰ�̵߳Ķ�Ӧ�ı�����������
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public T get() {
		Thread currentThread = Thread.currentThread();
		T o = (T)valueMap.get(currentThread);// �ڷ��ر��̶߳�Ӧ�ı���
		if (o == null && !valueMap.containsKey(currentThread)) {
			// �������Map�в����ڣ��ŵ�Map�б���������
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

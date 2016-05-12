package mengka.ReentrantReadWriteLock_01;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  ʹ�ö�д��ʵ�ֵĶ�д�����map
 * 
 * @author mengka.hyy
 *
 * @param <K>
 * @param <V>
 */
public class ReadWriteMap<K,V> {

	private final Map<K,V> map;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock readLock = lock.readLock();
	
	private final Lock writeLock = lock.writeLock();
	
	public ReadWriteMap(Map<K,V> map){
		this.map = map;
	}
	
	public V put(K key,V value)throws Exception{
		writeLock.lock();
		try{
			//TODO: ���Զ�д��
			Thread.sleep(3000);
			return map.put(key, value);
		}finally{
			writeLock.unlock();
		}
	}
	
	public V get(Object key){
		readLock.lock();
		try{
			return map.get(key);
		}finally{
			readLock.unlock();
		}
	}
}

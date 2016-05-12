package mengka.copyOnWriteArrayList_02;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  �̰߳�ȫ��remove()������CopyOnWriteArrayList��ʵ��
 * 
 * @author mengka.hyy
 *
 * @param <E>
 */
public class MengkaList<E> implements java.io.Serializable {

	private static final long serialVersionUID = -83136795864676092L;

	/**
	 * transient:
	 *  һ��������transient���Σ������������Ƕ���־û���һ���֣��ñ������������л����޷���÷���
	 */
	transient final ReentrantLock lock = new ReentrantLock();

	private volatile transient Object[] array;

	public int size(){
		return getArray()==null?0:getArray().length;
	}
	
	final Object[] getArray() {
		return array;
	}
	
	final Object get(int index){
		return getArray()[index];
	}

	final void setArray(Object[] a) {
		array = a;
	}

	public boolean add(E e) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			Object[] elements = getArray();
			if(elements==null){
				Object[] newElements = new Object[]{e};
				setArray(newElements);
			}else{
				int len = elements.length;
				Object[] newElements = Arrays.copyOf(elements, len + 1);
				newElements[len] = e;
				setArray(newElements);
			}
			return true;
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			Object[] elements = getArray();
			int len = elements.length;
			E oldValue = (E) elements[index];
			int numMoved = len - index - 1;
			
			/**
			 * �����ɾ���������һ��Ԫ�أ���ֱ��ͨ��Arrays.copyOf()���д���������Ҫ�½�����;
			 * �����½����飬Ȼ��"volatile�����б�ɾ��Ԫ��֮�������Ԫ��"�������������У���󣬽������鸳ֵ��"volatile����";
			 */
			if (numMoved == 0)
				setArray(Arrays.copyOf(elements, len - 1));
			else {
				Object[] newElements = new Object[len - 1];
				System.arraycopy(elements, 0, newElements, 0, index);
				System.arraycopy(elements, index + 1, newElements, index,
						numMoved);
				setArray(newElements);
			}
			return oldValue;
		} finally {
			lock.unlock();//�ͷ���
		}
	}

}

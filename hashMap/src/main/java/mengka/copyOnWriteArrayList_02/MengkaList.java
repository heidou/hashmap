package mengka.copyOnWriteArrayList_02;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  线程安全的remove()方法，CopyOnWriteArrayList的实现
 * 
 * @author mengka.hyy
 *
 * @param <E>
 */
public class MengkaList<E> implements java.io.Serializable {

	private static final long serialVersionUID = -83136795864676092L;

	/**
	 * transient:
	 *  一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问
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
			 * 如果被删除的是最后一个元素，则直接通过Arrays.copyOf()进行处理，而不需要新建数组;
			 * 否则，新建数组，然后将"volatile数组中被删除元素之外的其它元素"拷贝到新数组中；最后，将新数组赋值给"volatile数组";
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
			lock.unlock();//释放锁
		}
	}

}

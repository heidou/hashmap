package mengka.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;


/**
 *  <font color="red">��֧��ԭ�Ӳ�����Integer�ࡿ</font>  
 * 
 *  <hr>
 *  AtomicInteger�����ڴ棬�Ƚϸ�ID�Ƿ��Ѿ����ڣ���ʵ�ֲ�������ID<br><br>
 *  ��CAS��������<br>
 *   CPUԭ��<br>
 *   ��CPU�Ƚ��ڴ�λ���ϣ�ֵ�Ƿ�Ϊ��ǰֵ��������
 *  <hr>
 *  ����1����<br>
 *  ���ö��̻߳�ȡһ��ID
 *  <br><br>
 *  ���٣�<br>
 *    ���߳��£�ÿ�λ�ȡʱ����Ҫ���м������������Ⲣ��ʱ��ȡͬ��ID�������
 *    <br><br>
 *  ���ڣ�<br>
 *    ����atomicInteger,<font color="red">���Ƚ��ڴ桿</font>  
 * 
 * @author mengka.hyy
 *
 */
public class Mengka {

	/**
	 *   atomicInteger�����ܱ�ͬ����Ҫ��
	 *    (����)             (����)
	 */
	public AtomicInteger mkCount;

	
	public AtomicInteger getMkCount() {
		return mkCount;
	}

	public void setMkCount(AtomicInteger mkCount) {
		this.mkCount = mkCount;
	}
	
	
}

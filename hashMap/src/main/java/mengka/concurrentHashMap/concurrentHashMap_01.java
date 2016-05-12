package mengka.concurrentHashMap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <font color="red">���̰߳�ȫ��HashMapʵ�֡�</font>
 * <hr>
 * ���߳���>50��<br>
 * concurrentHashMap�������ܣ���HashMap���кܴ����ƣ�<br>
 * �ر��ڲ���Ԫ���ϣ���10�����ҵ�����������
 * <hr>
 * HashEntry�������飬��Ӧ�ı���ʱvolatile���͵ģ�<br>
 * ��put(k,v)ʱ���������ɿ������µĶ�������Ĵ�С
 * <hr>
 * concurrentHashMapԭ��:<br>
 * <ul>
 * <li>�Ǽ���HashTable�������ж������ÿһ������������������һ�������ݣ���ô�����̷߳��������ﲻͬ���ݶε�����ʱ���̼߳�Ͳ��������������
 * �Ӷ�������Ч����߲�������Ч�ʣ� �����ConcurrentHashMap��ʹ�õ����ֶμ�����</li>
 * <li>concurrentHashMap��Ҫ��εķ�����<br>
 * ����size()��containsValue()�����ǿ�����Ҫ���������������������ĳ���Σ�����Ҫ��˳���������жΣ�������Ϻ��ְ�˳���ͷ����жε�����
 * �����˳���Ǻ���Ҫ�ģ������п��ܳ���������</li>
 * <li>concurrentHashMap��Σ�Ϊ�˱�֤���������������÷ֶ�����˳��ʱ�̶��ģ����������ڶ��̱߳���У�ռ�к���Ҫ�ĵ�λ��</li>
 * <li>concurrentHashMap������������ͬʱ���У�����������Ҫ������</li>
 * </ul>
 * <br><br>
 *  �ο���java_52��java_53
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

		conMap.put("aa", "��ײ�AAA");
		conMap.put("bb", "��ײ�BBB");
		conMap.put("cc", "��ײ�CCC");

		Iterator iterator = conMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}
	}

}

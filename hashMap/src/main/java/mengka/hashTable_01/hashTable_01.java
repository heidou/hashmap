package mengka.hashTable_01;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * HashTableʹ�ã�<br>
 * HashTable��һ����ʱ�������࣬ͨ��ʹ��synchronized����֤�̰߳�ȫ�����߳̾������ҵ������HashTable��Ч�ʷǳ����£�<br>
 * ���з���HashTable���̶߳����뾺��ͬһ����;<br>
 * <hr>
 * ConcurrentHashMapԭ��<br>
 * �Ǽ����������ж������ÿһ������������������һ�������ݣ���ô�����̷߳��������ﲻͬ���ݶε�����ʱ���̼߳�Ͳ���������������Ӷ�������Ч����߲�������Ч�ʣ�
 * �����ConcurrentHashMap��ʹ�õ����ֶμ�����
 * <br><br>
 *  �ο���java_52��java_53
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

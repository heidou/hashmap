package mengka.deque.ArrayDeque_01;

import java.util.ArrayDeque;
import com.mengka.common.StringUtils;

/**
 * ˫�˶���
 * <ul>
 * <li>���е�ͷ��β�����Բ��룬head��tail������ָ�룻</li>
 * <li>���̰߳�ȫ��</li>
 * <li></li>
 * </ul>
 * <hr>
 * ������ӣ�
 * <ul>
 *    <li>add(),�ڶ���tail���Ԫ�أ�</li>
 *    <li>offer(),�ڶ���tail���Ԫ�أ�</li>
 *    <li>push(),�ڶ���head���Ԫ�أ�</li>
 * </ul>
 * 
 * ����ɾ����
 * <ul>
 *   <li>poll(),�ڶ���head�Ƴ�Ԫ�أ�</li>
 *   <li>remove(),�ڶ���head�Ƴ�Ԫ�أ�</li>
 *   <li>removeLast(),�ڶ���tail�Ƴ�Ԫ�أ�</li>
 * </ul>
 * 
 * @author mengka.hyy
 * 
 */
public class arrayDeque_01 {

	/**
	 *  poll(),�ڶ���head�Ƴ�Ԫ�أ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayDeque<String> queue = new ArrayDeque<String>();
		queue.add("AAA..");//tailָ��
		queue.add("BBB..");
		queue.offer("CCC..");
		queue.push("DDD..");//headָ��

		String tmp = queue.poll();//headָ��
		while (StringUtils.isNotBlank(tmp)) {
			System.out.println(tmp);
			tmp = queue.poll();
		}

	}

}

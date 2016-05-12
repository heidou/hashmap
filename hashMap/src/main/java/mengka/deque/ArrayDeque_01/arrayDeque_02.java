package mengka.deque.ArrayDeque_01;

import java.util.ArrayDeque;

import com.mengka.common.StringUtils;

/**
 *  removeLast(),�ڶ���tail�Ƴ�Ԫ�أ�
 * 
 * @author mengka.hyy
 *
 */
public class arrayDeque_02 {

	public static void main(String[] args) {
		
		ArrayDeque<String> queue = new ArrayDeque<String>();
		queue.add("AAA..");//tailָ��
		queue.add("BBB..");
		queue.offer("CCC..");
		queue.push("DDD..");//headָ��

		String tmp = queue.removeLast();//tailָ��
		while (StringUtils.isNotBlank(tmp)) {			
			System.out.println(tmp);
			if(queue.size()<=0){
				break;
			}
			tmp = queue.removeLast();
		}
	}

}

package mengka.deque.ArrayDeque_01;

import java.util.ArrayDeque;

import com.mengka.common.StringUtils;

/**
 *  removeLast(),在队列tail移除元素；
 * 
 * @author mengka.hyy
 *
 */
public class arrayDeque_02 {

	public static void main(String[] args) {
		
		ArrayDeque<String> queue = new ArrayDeque<String>();
		queue.add("AAA..");//tail指针
		queue.add("BBB..");
		queue.offer("CCC..");
		queue.push("DDD..");//head指针

		String tmp = queue.removeLast();//tail指针
		while (StringUtils.isNotBlank(tmp)) {			
			System.out.println(tmp);
			if(queue.size()<=0){
				break;
			}
			tmp = queue.removeLast();
		}
	}

}

package mengka.deque.ArrayDeque_01;

import java.util.ArrayDeque;
import com.mengka.common.StringUtils;

/**
 * 双端队列
 * <ul>
 * <li>队列的头和尾都可以插入，head和tail，两个指针；</li>
 * <li>非线程安全；</li>
 * <li></li>
 * </ul>
 * <hr>
 * 》》添加：
 * <ul>
 *    <li>add(),在队列tail添加元素；</li>
 *    <li>offer(),在队列tail添加元素；</li>
 *    <li>push(),在队列head添加元素；</li>
 * </ul>
 * 
 * 》》删除：
 * <ul>
 *   <li>poll(),在队列head移除元素；</li>
 *   <li>remove(),在队列head移除元素；</li>
 *   <li>removeLast(),在队列tail移除元素；</li>
 * </ul>
 * 
 * @author mengka.hyy
 * 
 */
public class arrayDeque_01 {

	/**
	 *  poll(),在队列head移除元素；
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayDeque<String> queue = new ArrayDeque<String>();
		queue.add("AAA..");//tail指针
		queue.add("BBB..");
		queue.offer("CCC..");
		queue.push("DDD..");//head指针

		String tmp = queue.poll();//head指针
		while (StringUtils.isNotBlank(tmp)) {
			System.out.println(tmp);
			tmp = queue.poll();
		}

	}

}

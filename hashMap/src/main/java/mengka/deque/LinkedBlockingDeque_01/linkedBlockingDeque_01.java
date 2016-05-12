package mengka.deque.LinkedBlockingDeque_01;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;
import com.mengka.common.StringUtils;

/**
 * 》》双向并发阻塞队列linkedBlockingDeque：
 * <ul>
 * <li>线程安全；</li>
 * <li>使用独占锁，性能比linkedBlockingQueue差；</li>
 * </ul>
 * 
 * <br>
 * <br>
 * 
 * <img src=
 * "http://imglf1.ph.126.net/MZL5dbvFiW2bpu_2BXN3qg==/6608887317632225233.png">
 * 
 * 
 * @author mengka.hyy
 * 
 */
public class linkedBlockingDeque_01 {

	public static void main(String[] args) {

		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<String>();
		queue.add("AAA..");
		queue.add("BBB..");
		queue.offer("CCC..");
		queue.push("DDD..");

		String value;
		Iterator<String> iterator = queue.iterator();
		while (iterator.hasNext()) {
			value = (String) iterator.next();
			System.out.println(value);
		}
		
		System.out.println("================");
		
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

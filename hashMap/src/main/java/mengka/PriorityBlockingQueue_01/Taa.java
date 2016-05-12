package mengka.PriorityBlockingQueue_01;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 优先级队列PriorityBlockingQueue
 * <hr>
 * priorityEntity priority = 9 , value = 4<br>
 * priorityEntity priority = 9 , value = 333333<br>
 * priorityEntity priority = 9 , value = 3333333<br>
 * priorityEntity priority = 9 , value = 333<br>
 * priorityEntity priority = 9 , value = 33333<br>
 * priorityEntity priority = 31 , value = 3<br>
 * priorityEntity priority = 33 , value = 5<br>
 * priorityEntity priority = 45 , value = 2<br>
 * priorityEntity priority = 91 , value = 1<br>
 * priorityEntity priority = 99 , value = 0<br>
 * <br>
 * 
 * @author mengka.hyy
 * 
 */
public class Taa {

	public static void main(String[] args) throws Exception {

		PriorityBlockingQueue<PriorityEntity> queue = new PriorityBlockingQueue<PriorityEntity>();
		queue.put(new PriorityEntity(99, 0));
		queue.put(new PriorityEntity(91, 1));
		queue.put(new PriorityEntity(45, 2));
		queue.put(new PriorityEntity(31, 3));
		queue.put(new PriorityEntity(9, 4));
		queue.put(new PriorityEntity(9, 333));
		queue.put(new PriorityEntity(9, 33333));
		queue.put(new PriorityEntity(9, 333333));
		queue.put(new PriorityEntity(9, 3333333));
		queue.put(new PriorityEntity(33, 5));

		PriorityEntity priorityEntity = queue.take();
		while (priorityEntity != null) {
			System.out.println(priorityEntity.toString());
			priorityEntity = queue.take();
		}
	}

}

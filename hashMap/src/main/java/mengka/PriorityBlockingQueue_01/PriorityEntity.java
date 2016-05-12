package mengka.PriorityBlockingQueue_01;

public class PriorityEntity implements Comparable<PriorityEntity> {

	private int priority;

	private int value;

	public PriorityEntity(int priority, int value) {
		this.priority = priority;
		this.value = value;
	}

	/**
	 *  priority值小的权重高
	 * 
	 */
	@Override
	public int compareTo(PriorityEntity entity) {
		return this.priority > entity.priority ? 1
				: this.priority < entity.priority ? -1 : 0;
	}

	
	public String toString(){
		return "priorityEntity priority = "+priority+" , value = "+value;
	}
}

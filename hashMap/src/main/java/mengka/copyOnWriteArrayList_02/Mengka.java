package mengka.copyOnWriteArrayList_02;


public class Mengka {

	public static MengkaList<String> mengkaList = new MengkaList<String>();
	
	public static MengkaList<String> getMengkaList() {
		return mengkaList;
	}

	public static void setMengkaList(MengkaList<String> mengkaList) {
		Mengka.mengkaList = mengkaList;
	}

	/**
	 *  添加一个元素
	 * 
	 * @param baicai
	 */
	public synchronized void add(String baicai) {
		mengkaList.add(baicai);
		notifyAll();
	}

	/**
	 *  移除最后一个添加的元素
	 * 
	 * @return
	 */
	public synchronized int removeLastOne() {
		while (mengkaList.size() <= 0) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println("-----------, RemoveTask wait error = " + e);
			}
		}
		int i = mengkaList.size() - 1;
		mengkaList.remove(i);
		
		notifyAll();
		return i;
	}
}

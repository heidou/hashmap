package mengka.array_01;


/**
 *  数组arrayCopy()方法使用<br>
 *  将a[]的，从0开始的3个元素，复制到b[]的0开始的位置
 *  
 * @author mengka.hyy
 *
 */
public class arrayCopy_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int aa[] = {5,6,32,12};
		int bb[] = {41,52,6,44,56};
		
		
		/**
		 *  将a[]的，从0开始的3个元素，复制到b[]的1开始的位置
		 */
		System.arraycopy(aa, 0, bb, 1, 3);
		
		
		for(int tmp:aa){
			System.out.print(tmp+",");
		}
		System.out.println();
		for(int tmp:bb){
			System.out.print(tmp+",");
		}
		
	}

}

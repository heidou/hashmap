package mengka.array_01;


/**
 *  ����arrayCopy()����ʹ��<br>
 *  ��a[]�ģ���0��ʼ��3��Ԫ�أ����Ƶ�b[]��0��ʼ��λ��
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
		 *  ��a[]�ģ���0��ʼ��3��Ԫ�أ����Ƶ�b[]��1��ʼ��λ��
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

package mengka.array_01;


/**
 *  ����Ļ�������ʵ��
 * 
 * @author mengka.hyy
 *
 */
public class array_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		/**
		 *  �����ʾ������
		 */
		int aa[] = new int[4];
		aa[0] = 11;
		aa[1] = 22;
		aa[2] = 33;
		aa[3] = 44;
		
		for(int temp:aa){
			System.out.print(temp+",");
		}
		
		
		System.out.println("\n**************");
		
		
		/**
		 *  �����ʾ������
		 */
		int[] bb = new int[4];
		bb[0] = 11;
		bb[1] = 22;
		bb[2] = 33;
		bb[3] = 44;
		
		for(int temp:bb){
			System.out.print(temp+",");
		}
	
		
		System.out.println("\n**************");
		
		
		/**
		 *  ��ά����:
		 *        8��4�еĶ�ά����
		 */
		String a[][] = new String[8][4];
		
//		for(int i=0;i<8;i++){
//			a[i] = new int[4];
//		}
		
		for(int i=0;i<8;i++){
			for(int j=0;j<4;j++){
				a[i][j] = "<"+i+","+j+">";
			}
		}
		
		for(int i=0;i<8;i++){
			for(int j=0;j<4;j++){
				System.out.print(a[i][j]+'\t');
			}
			System.out.println();
		}
		
	}

}

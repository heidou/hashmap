package mengka.arrayList_01;

import java.util.ArrayList;

/**
 *  ���̺�Ժ��������֤list���һֱ���Ǽ���list�ĺ���
 * 
 * @author mengka.hyy
 *
 */
public class ArrayList_02 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		ArrayList aaList = new ArrayList();
		aaList.add("aaa");
		aaList.add("bb");
		aaList.add("cc");
		System.out.println(aaList);
		
		aaList.remove(0);
		aaList.add("ddd");
		System.out.println(aaList);
		
		aaList.remove(0);
		aaList.add("wwww");
		System.out.println(aaList);
		
		if(aaList.contains("bb")){
			System.out.println("AAAAAAAAAAAAAAAAAAA");
		}
		
		System.out.println(aaList.indexOf("bb"));
	}

}

package mengka.arrayList_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ��stringת���list
 *  <hr>
 *  "1111,33333" ==>>  list
 * 
 * @author mengka.hyy
 *
 */
public class ArrayList_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 *  arrayתlist
		 */
		String aaString="1111,33333";
		List<String> aaList=Arrays.asList(aaString.split(","));
		System.out.println(aaList);
	
		for(String userIdString:aaList){		
			long userId =Long.parseLong(userIdString);
			System.out.println("userId = "+userId);
		}
		
		/**
		 *  listתarray
		 */
		List<String> strList = new ArrayList<String>();
		strList.add("aa");
		strList.add("bb");
		String[] strs = (String[]) strList.toArray(new String[strList.size()]);
		System.out.println("Arrays = "+Arrays.asList(strs));
	}

}

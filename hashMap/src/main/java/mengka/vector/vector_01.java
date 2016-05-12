package mengka.vector;

import java.util.Enumeration;
import java.util.Vector;

public class vector_01 {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		//向量类
		Vector aaVector=new Vector();
		aaVector.add("baicai");
		aaVector.add("qingcai");
		aaVector.add("xigua");
		aaVector.add(new Integer(22));
		
		System.out.println(aaVector);
		
		
		/**
		 *  指定index，插入元素
		 */
		aaVector.insertElementAt("青菜", 2);
		
		System.out.println(aaVector);
	
				
		/**
		 *  指定index，删除元素
		 */
		aaVector.removeElementAt(1);
		
		System.out.println(aaVector);
		
		
		/**
		 * 【法①】： 
		 *     顺延，枚举类，显示所有元素
		 */
		Enumeration enumeration = aaVector.elements();
		while(enumeration.hasMoreElements()){
			Object object = enumeration.nextElement();
			System.out.println(object);
		}
		
		
		/**
		 * 【法②】：
		 *      枚举列出所有元素
		 */
		for (Enumeration e = aaVector.elements(); e.hasMoreElements();)
		       System.out.println(e.nextElement());
	}

}

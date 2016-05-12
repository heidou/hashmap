package mengka.stack;

import java.util.Stack;


/**
 *  stack继承了vector数组，其入栈和出栈的操作也是封装了vector的相关操作实现的
 *  <hr>
 *  栈：
 *   <ul>
 *      <li>[444]</li>
 *      <li>[333]</li>
 *      <li>[222]</li>
 *      <li>[111]</li>
 *   </ul>   
 *   <BR>
 *   栈顶出栈后：
 *   <ul>
 *      <li>[333]</li>
 *      <li>[222]</li>
 *      <li>[111]</li>
 *   </ul>
 * 
 * @author mengka.hyy
 *
 */
public class stack_01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Stack<String> aaStack = new Stack<String>();

		aaStack.push("111");
		aaStack.push("222");
		aaStack.push("333");
		aaStack.push("444");
	
		System.out.println("size = "+aaStack.size());
		
		
		String removeString = aaStack.pop();
		
		
		System.out.println("size = "+aaStack.size()+" , removeString = "+removeString);
	}
	

}

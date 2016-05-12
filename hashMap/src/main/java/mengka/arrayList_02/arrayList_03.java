package mengka.arrayList_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *  ArrayList和Vector差不多，vector是java1.0遗留下来的一个类（同步的），而Arraylist是不同步的，不过可以使用下面的方法得到一个同步的ArrayList<br>
 *    Collections.synchronizedList(new ArrayList());
 * <hr>
 * <ul>
 *  <li>ArrayList具有快速查找元素的功能，虽然在插入和删除的时候耗费的时间比较长（频繁修改的情况下，list可以采用LinkList）;</li>
 *  <li>ArrayList（包括所有新一代的容器）可以选择性的使用同步，不需要的时候就不使用，而不是像vector那样没有选择;</li>
 * </ul> 
 * 
 * @author mengka.hyy
 *
 */
public class arrayList_03 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		List list = Collections.synchronizedList(new ArrayList());
		

	}

}

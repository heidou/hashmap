package mengka.arrayList_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *  ArrayList��Vector��࣬vector��java1.0����������һ���ࣨͬ���ģ�����Arraylist�ǲ�ͬ���ģ���������ʹ������ķ����õ�һ��ͬ����ArrayList<br>
 *    Collections.synchronizedList(new ArrayList());
 * <hr>
 * <ul>
 *  <li>ArrayList���п��ٲ���Ԫ�صĹ��ܣ���Ȼ�ڲ����ɾ����ʱ��ķѵ�ʱ��Ƚϳ���Ƶ���޸ĵ�����£�list���Բ���LinkList��;</li>
 *  <li>ArrayList������������һ��������������ѡ���Ե�ʹ��ͬ��������Ҫ��ʱ��Ͳ�ʹ�ã���������vector����û��ѡ��;</li>
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

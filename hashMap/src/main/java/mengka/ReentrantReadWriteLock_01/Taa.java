package mengka.ReentrantReadWriteLock_01;

import java.util.HashMap;

/**
 *  ����д������<br>
 *  һ����Դ�ܹ���������߷��ʣ����߱�һ��д�߷��ʣ����߲���ͬʱ���У�
 *  <br>
 *  ��д�������������ܸĽ��ģ����ض�������¾��и��õĲ����ԣ�<br>
 *  <br>
 *  �������ȴ���д����<br>
 *  ���ߺ�д��ͬʱ��������д�����Ȼ������д�߱����������ͷ�д�����󣬶��߲ſ�ʼ����<br>
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	public static void main(String[] args) throws Exception{
		
		ReadWriteMap<String, String> map = new ReadWriteMap<String, String>(new HashMap<String, String>());
		
		new Thread(new WriteTask(map)).start();
		new Thread(new ReadTask(map)).start();
		
	}

}

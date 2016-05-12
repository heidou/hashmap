package mengka.concurrentMengkaMap_01;

import com.mengka.common.TimeUtil;

public class Taa {

	public static void main(String[] args) {
		
		ConcurrentMengkaMap map = new ConcurrentMengkaMap(10000);
		map.put("aa", TimeUtil.toDate("2014-12-21 16:20:27", TimeUtil.format_1));
		map.put("aa", TimeUtil.toDate("2014-12-21 16:20:28", TimeUtil.format_1));
		map.put("bb", TimeUtil.toDate("2014-12-21 10:20:00", TimeUtil.format_1));
		map.put("cc", TimeUtil.toDate("2014-12-22 12:00:00", TimeUtil.format_1));
		
		System.out.println("aa = "+map.get("aa"));
	}

}

package mengka.queue.ConcurrentLinkedQueue_02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  后院中ConcurrentLinkedQueue的使用
 * 
 * @author mengka.hyy
 *
 */
public class Taa {

	private static Log log = LogFactory.getLog(Taa.class);
	
	public static BackyardInitialize backyardInitialize = BackyardInitialize.getInitialize();
	
	public static void main(String[] args) {
		
		for(int i=0;i<1000;i++){
			BackyardDO backyardDO = new BackyardDO();
			backyardDO.setShopId(540000L+i);
			backyardDO.setStatus(0);
			backyardDO.setSlogan("baicai的后院");
			backyardInitialize.initBackyard(backyardDO);
		}
		
		BackyardDO backyardDO = backyardInitialize.get();
		while(backyardDO!=null){
			log.info("backyardDO = "+JsonUtil.toJson(backyardDO));
			log.info("size = "+backyardInitialize.getQueue().size());
			backyardDO = backyardInitialize.get();
		}
	}

}

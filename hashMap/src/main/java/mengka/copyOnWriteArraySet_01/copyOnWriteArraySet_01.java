package mengka.copyOnWriteArraySet_01;



/**
 *   CopyOnWriteArraySetʹ��
 *   <ul>
 *      <li>���ʺ��ھ�������������Ӧ�ó���Set ��Сͨ�����ֺ�С��ֻ������Զ���ڿɱ��������Ҫ�ڱ����ڼ��ֹ�̼߳�ĳ�ͻ��</li>
 *      <li>�̰߳�ȫ</li>
 *      <li>ͨ����Ҫ���������������飬���Կɱ������add()��set() �� remove() �ȵȣ��Ŀ����ܴ�</li>
 *   </ul>
 * 
 * @author mengka.hyy
 *
 */
public class copyOnWriteArraySet_01 {

	public static MengkaRegistry mengkaRegistry = new MengkaRegistry();
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		MengkaDO aaMengkaDO = new MengkaDO();
		aaMengkaDO.setId(205318L);
		aaMengkaDO.setName("�ײ�AAA");
		aaMengkaDO.setWeibo("weibo");
		
		MengkaDO bbMengkaDO = new MengkaDO();
		bbMengkaDO.setId(205319L);
		bbMengkaDO.setName("�ײ�BBB");
		bbMengkaDO.setWeibo("weibo");
		
		MengkaDO ccMengkaDO = new MengkaDO();
		ccMengkaDO.setId(205320L);
		ccMengkaDO.setName("�ײ�CCC");
		ccMengkaDO.setWeibo("weibo");
		
		
		mengkaRegistry.registerMengka(aaMengkaDO);
		mengkaRegistry.registerMengka(bbMengkaDO);
		mengkaRegistry.registerMengka(ccMengkaDO);
		
		for(MengkaDO mengkaDO: mengkaRegistry.getMengkaRegistry()){
			System.out.println("class = "+mengkaDO.getClass().getName()+" , id = "+mengkaDO.getId()+" , name = "+mengkaDO.getName()+" , hashCode = "+mengkaDO.hashCode());
		}
		
		System.out.println("=================");
		
		MengkaDO ddMengkaDO = new MengkaDO();
		ddMengkaDO.setId(205318L);
		ddMengkaDO.setName("�ײ�AAA");
		ddMengkaDO.setWeibo("weibo");
		mengkaRegistry.registerMengka(ddMengkaDO);
		
		
		for(MengkaDO mengkaDO: mengkaRegistry.getMengkaRegistry()){
			System.out.println("class = "+mengkaDO.getClass().getName()+" , id = "+mengkaDO.getId()+" , name = "+mengkaDO.getName()+" , hashCode = "+mengkaDO.hashCode());
		}
		
		
		System.out.println("=================");
		
		mengkaRegistry.unregisterMengka(aaMengkaDO);
		
		for(MengkaDO mengkaDO: mengkaRegistry.getMengkaRegistry()){
			System.out.println("class = "+mengkaDO.getClass().getName()+" , id = "+mengkaDO.getId()+" , name = "+mengkaDO.getName()+" , hashCode = "+mengkaDO.hashCode());
		}
	}

}

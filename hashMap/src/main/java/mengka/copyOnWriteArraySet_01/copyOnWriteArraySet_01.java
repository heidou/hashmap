package mengka.copyOnWriteArraySet_01;



/**
 *   CopyOnWriteArraySet使用
 *   <ul>
 *      <li>最适合于具有以下特征的应用程序：Set 大小通常保持很小，只读操作远多于可变操作，需要在遍历期间防止线程间的冲突。</li>
 *      <li>线程安全</li>
 *      <li>通常需要复制整个基础数组，所以可变操作（add()、set() 和 remove() 等等）的开销很大</li>
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
		aaMengkaDO.setName("白菜AAA");
		aaMengkaDO.setWeibo("weibo");
		
		MengkaDO bbMengkaDO = new MengkaDO();
		bbMengkaDO.setId(205319L);
		bbMengkaDO.setName("白菜BBB");
		bbMengkaDO.setWeibo("weibo");
		
		MengkaDO ccMengkaDO = new MengkaDO();
		ccMengkaDO.setId(205320L);
		ccMengkaDO.setName("白菜CCC");
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
		ddMengkaDO.setName("白菜AAA");
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

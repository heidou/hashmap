package mengka.copyOnWriteArraySet_01;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MengkaRegistry {

    private static CopyOnWriteArraySet<MengkaDO> mengkaRegistrys=new CopyOnWriteArraySet<MengkaDO>();

    public static void registerMengka(MengkaDO mengkaDO){
    	mengkaRegistrys.add(mengkaDO);
    }
    
    public static void unregisterMengka(MengkaDO mengkaDO){
    	mengkaRegistrys.remove(mengkaDO);
    }
    
    public static Set<MengkaDO> getMengkaRegistry(){
    	return mengkaRegistrys;
    }
}

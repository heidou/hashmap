package mengka.stack_03;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *  非阻塞栈ConcurrentStack的使用
 * 
 * @author mengka.hyy
 *
 */
public class Taa {
	
	private static final Log log = LogFactory.getLog(Taa.class);

	public static void main(String[] args) {
		
		ConcurrentStack<MengkaDO> stack = new ConcurrentStack<MengkaDO>();
		stack.push(new MengkaDO(205318L, "mengka"));
		stack.push(new MengkaDO(205319L, "hyy033101331"));
		stack.push(new MengkaDO(205320L, "门卡"));
		
		MengkaDO mengkaDO = stack.pop();
		log.info("mengka = "+ToStringBuilder.reflectionToString(mengkaDO));
		
		int hashCode = stack.hashCode();
		String _16code = Integer.toHexString(hashCode);
		log.info("stack = "+ToStringBuilder.reflectionToString(stack));
		log.info("hashCode = "+hashCode+" , _16code = "+_16code);
	}

	public static class MengkaDO {

		private Long id;
		private String name;

		public MengkaDO(Long id,String name){
			this.id = id;
			this.name = name;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}

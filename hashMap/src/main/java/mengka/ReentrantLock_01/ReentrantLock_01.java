package mengka.ReentrantLock_01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import com.sun.corba.se.pept.encoding.InputObject;
import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.corba.se.pept.protocol.MessageMediator;
import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.ConnectionCache;
import com.sun.corba.se.pept.transport.ContactInfo;
import com.sun.corba.se.pept.transport.EventHandler;

/**
 * 解决并发导致的多次创建连接和锁的现象<br>
 * <br>
 * 【旧方法】
 * <hr>
 * 
 * @author mengka.hyy
 * 
 */
public class ReentrantLock_01 {

	Map<String, Connection> connectionPool = new HashMap<String, Connection>();

	ReentrantLock lock = new ReentrantLock();

	public Connection getConnection(String key) {
		try {

			/**
			 *  step01: 
			 *         加锁
			 */
			lock.lock();

			
			/**
			 * step02:
			 *        获取key对应的连接      
			 */
			if (connectionPool.containsKey(key)) {
				return connectionPool.get(key);
			} else {
				// connection
				Connection connection = initConnection();

				connectionPool.put(key, connection);
				return connection;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {
			
			/**
			 *  step03:
			 *         释放锁
			 */
			lock.unlock();
		}
	}

	/**
	 * 
	 * 初始化一个连接
	 * 
	 * @return
	 */
	public Connection initConnection() {

		Connection connection = new Connection() {

			@Override
			public void writeUnlock() {
				// TODO Auto-generated method stub

			}

			@Override
			public void writeLock() {
				// TODO Auto-generated method stub

			}

			@Override
			public InputObject waitForResponse(MessageMediator messageMediator) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void unregisterWaiter(MessageMediator messageMediator) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean shouldRegisterServerReadEvent() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean shouldRegisterReadEvent() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setTimeStamp(long time) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setState(String state) {
				// TODO Auto-generated method stub

			}

			@Override
			public void setConnectionCache(ConnectionCache connectionCache) {
				// TODO Auto-generated method stub

			}

			@Override
			public void sendWithoutLock(OutputObject outputObject) {
				// TODO Auto-generated method stub

			}

			@Override
			public void registerWaiter(MessageMediator messageMediator) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean read() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isServer() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isBusy() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public long getTimeStamp() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public EventHandler getEventHandler() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ContactInfo getContactInfo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ConnectionCache getConnectionCache() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Acceptor getAcceptor() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub

			}
		};

		return connection;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}

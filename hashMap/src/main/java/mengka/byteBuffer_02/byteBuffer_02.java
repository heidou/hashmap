package mengka.byteBuffer_02;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * User: mengka
 * Date: 15-4-15-����7:52
 */
public class byteBuffer_02 {


    public static void main(String[] args)throws Exception{
        SocketAddress socketAddress = new InetSocketAddress(Constants.SERVER_CONNECT_IP,
                Constants.PORT);
        ByteBuffer byteBuffer = socketAddress2ByteBuffer(socketAddress);

        String result = byteBuffer2String(byteBuffer);
        System.out.println("result = "+result);
    }

    /**
     * SocketAddress ----> ByteBuffer ת����8���ֽ�
     */
    public static ByteBuffer socketAddress2ByteBuffer(SocketAddress socketAddress) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        byteBuffer.put(inetSocketAddress.getAddress().getAddress());
        byteBuffer.putInt(inetSocketAddress.getPort());
        byteBuffer.flip();
        return byteBuffer;
    }


    /**
     *  ��ByteBufferת��Ϊstring
     *
     * @param buffer
     * @return
     */
    public static String byteBuffer2String(ByteBuffer buffer){
        byte[] result = new byte[buffer.limit()];
        buffer.get(result); //��ByteBuffer�ж�ȡ���ݵ�byte������
        return new String(result);
    }
}

package mengka.byteBuffer_02;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * User: mengka
 * Date: 15-4-15-下午7:52
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
     * SocketAddress ----> ByteBuffer 转化成8个字节
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
     *  将ByteBuffer转化为string
     *
     * @param buffer
     * @return
     */
    public static String byteBuffer2String(ByteBuffer buffer){
        byte[] result = new byte[buffer.limit()];
        buffer.get(result); //从ByteBuffer中读取数据到byte数组中
        return new String(result);
    }
}

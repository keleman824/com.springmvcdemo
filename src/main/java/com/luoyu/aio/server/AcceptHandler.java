package com.luoyu.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;  
import java.nio.channels.CompletionHandler;  
//��Ϊhandler���տͻ�������  
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AcceptServer> {  
    @Override  
    public void completed(AsynchronousSocketChannel channel,AcceptServer as) {  
        //�������������ͻ��˵�����  
    	as.clientCount++;  
        System.out.println("���ӵĿͻ�������" +as.clientCount);  
        as.AcceptClient(this);  
        //�����µ�Buffer  
        ByteBuffer buffer = ByteBuffer.allocate(1024);  
        //�첽��  ����������Ϊ������Ϣ�ص���ҵ��Handler  
        channel.read(buffer, buffer, new ReadHandler(channel));  
    }  
    @Override  
    public void failed(Throwable exc, AcceptServer as) {  
        exc.printStackTrace();   
    }  
}  
package com.luoyu.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;  
import java.nio.channels.CompletionHandler;  
//作为handler接收客户端连接  
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AcceptServer> {  
    @Override  
    public void completed(AsynchronousSocketChannel channel,AcceptServer as) {  
        //继续接受其他客户端的请求  
    	as.clientCount++;  
        System.out.println("连接的客户端数：" +as.clientCount);  
        as.AcceptClient(this);  
        //创建新的Buffer  
        ByteBuffer buffer = ByteBuffer.allocate(1024);  
        //异步读  第三个参数为接收消息回调的业务Handler  
        channel.read(buffer, buffer, new ReadHandler(channel));  
    }  
    @Override  
    public void failed(Throwable exc, AcceptServer as) {  
        exc.printStackTrace();   
    }  
}  
package com.luoyu.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AcceptServer {  
	
    public AcceptServer(int dEFAULT_PORT) {
		super();
		DEFAULT_PORT = dEFAULT_PORT;
	}
	private int DEFAULT_PORT ;   
    public volatile long clientCount = 0;  
    public AsynchronousServerSocketChannel serverchannel; 
    CountDownLatch latch;
    
    
    public void AcceptClient(AcceptHandler ah)
    {
    	serverchannel.accept(this, ah);
    }
    
    public  void start(){  
        start(DEFAULT_PORT);  
    }  
    public void start(int port){  
            	 
        try {  
            //���������ͨ��  
        	serverchannel = AsynchronousServerSocketChannel.open();  
            //�󶨶˿�  
        	serverchannel.bind(new InetSocketAddress(port));  
            
        	AcceptClient(new AcceptHandler());  
            
            System.out.println("���������������˿ںţ�" + port);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
       
        latch = new CountDownLatch(1);          
        try {  
            latch.await();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
     
    }  
    
}  

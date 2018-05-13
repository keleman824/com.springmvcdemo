package com.luoyu.aio.server;

public class testserver {
	
	
	public static void  main(String[] args)
	{
		
		AcceptServer as = new AcceptServer(8500);
		
		as.start();
		
	}

}

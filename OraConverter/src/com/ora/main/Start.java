package com.ora.main;

public class Start {

	public static final String SERVER = "server";
	public static final String CLIENT = "client";
	public static void main(String[] args) {

		if(args.length >1 || args.length<1)
		{
			System.out.println("Invalid arguments..");
			System.out.println("Run using command : java -jar OraConverter.jar [client|server] ");
		}
		else if(SERVER.equalsIgnoreCase(args[0].toString()))
		{
			System.out.println("Starting server program..");
			com.ora.server.StoOra.main();
		}
		else if (CLIENT.equalsIgnoreCase(args[0].toString()))
		{
			System.out.println("Starting client program..");
			com.ora.client.StoOra.main();
			
		}
		else{
			System.out.println("Configuration not supported");
			System.out.println("Run using command : java -jar OraConverter.jar [client|server] ");
		}

	}

}

package com.ora.client;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.ora.utils.ORAProperties;

public class StoOra {

	public static void main() {
		// monitor a single file
		TimerTask task = new FileWatcher(
				new File(ORAProperties.getProperty("ClientMonitorFile"))) {
			protected void onChange(File file) {
				// here we code the action on a change
				//System.out.println(ORAProperties.getProperty("sMonitorFile"));
				System.out.println("File " + file.getName() + " have change !");
				if(!file.exists())
				{
					System.out.println("Client Monitor file --"+ file.getAbsolutePath()+"do not exist");
					System.exit(1);
				}
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c",
						ORAProperties.getProperty("ClientBatFile")+ " " +ORAProperties.getConfigFile() + " ");
				File dir = new File(ORAProperties.getProperty("ClientBatFileLoc"));
				if(!dir.exists())
				{
					System.out.println("Batch file location -- " + dir.getAbsolutePath() +" not found");
					System.exit(1);
				}	
				pb.directory(dir);
				try {
					Process p = pb.start();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		};

		Timer timer = new Timer();
		// repeat the check every second
		timer.schedule(task, new Date(), 1000);
		
		TimerTask taskDir = new DirWatcher(ORAProperties.getProperty("includesFolder"), "h" ) {
		      private ProcessBuilder pb;

			protected void onChange( File file, String action ) {
		      
		        System.out.println( "File "+ file.getAbsolutePath() +" action: " + action );
		        // here we code the action on a change
		    	if("delete".equalsIgnoreCase(action)){
		    		 pb = new ProcessBuilder("cmd", "/c",
		    				 ORAProperties.getProperty("includeBatFile") + " delete " + file.getName() + " " +ORAProperties.getConfigFile() + " ");
		    		 
		    	}
		    	else if ("add".equalsIgnoreCase(action))
		    	{
		    		 pb = new ProcessBuilder("cmd", "/c",
		    				 ORAProperties.getProperty("includeBatFile") + " add " + file.getName()+ " " +ORAProperties.getConfigFile() + " ");
		    	}
		    	else if("modify".equalsIgnoreCase(action))
		    	{
		    		 pb = new ProcessBuilder("cmd", "/c",
		    				 ORAProperties.getProperty("includeBatFile") + " modify " + file.getName()+ " " +ORAProperties.getConfigFile() + " ");
		    	}
		    	File dir = new File(ORAProperties.getProperty("ClientBatFileLoc"));
				pb.directory(dir);
				try {
					Process p = pb.start();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
		      }
		    };

		    Timer timerDir = new Timer();
		    timer.schedule( taskDir , new Date(), 1000 );


	}

}

package com.ora.server;

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
				new File(ORAProperties.getProperty("ServerMonitorFile"))) {
			protected void onChange(File file) {
				// here we code the action on a change
				System.out.println("File " + file.getName() + " have change !");
				ProcessBuilder pb = new ProcessBuilder("cmd", "/c",
						ORAProperties.getProperty("ServerBatFile"));
				File dir = new File(ORAProperties.getProperty("ServerBatFileLoc"));
				pb.directory(dir);
				try {
					Process p = pb.start();
					//System.out.println(p.exitValue());
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		};

		Timer timer = new Timer();
		// repeat the check every second
		timer.schedule(task, new Date(), 1000);

	}

}

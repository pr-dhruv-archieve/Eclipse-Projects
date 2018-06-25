package mp.feereport.feereport;

import java.awt.EventQueue;

import mp.feereport.frames.FeeReport;

public class Start {
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			
			public void run() {
				
				try {
					FeeReport frame = FeeReport.createInstance();
					frame.setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});

	}

}

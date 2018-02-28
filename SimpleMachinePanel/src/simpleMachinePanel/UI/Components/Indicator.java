package simpleMachinePanel.UI.Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JProgressBar;

/**
 * Indicators Component, to simulate the different bit on registers
 * @author Ruotong Wu
 *
 */
public class Indicator extends JProgressBar {
	private static final long serialVersionUID = 1L;
	
	/**
	 * if the indicators is available, it will show 0 or 1, and can click it to switch between these two number
	 * other, it will show "-", and cannot be clicked
	 */
	private boolean available=true;
	
	/**
	 * get the availability of this indicator
	 * @return the availability
	 */
	public boolean getAvailable() {
		return available;
	}
	
	/**
	 * set the availability
	 * @param available availability, boolean
	 */
	public void setAvailable(boolean available) {
		this.available=available;
		if(available) {
			this.setString("0");
			this.setForeground(new Color(255, 69, 0));
		}else {
			this.setString("-");
			this.setForeground(new Color(192, 192, 192));
		}
	}
	/**
	 * as default, this indicator is available.
	 */
	private void setDefault() {
		this.setStringPainted(true);
		this.setMaximum(1);
		this.setFont(new Font("SansSerif", Font.PLAIN, 35));
		
		this.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	switchStatus();
                }
        });
	}
	/**
	 * Initializing this indicator with out parameter
	 * this indicator should be available
	 */
	public Indicator() {
		setDefault();
		setAvailable(true);
	}
	/**
	 * Initializing this indicator with parameter available
	 * @param available to indicate if this indicator is available
	 */
	public Indicator(boolean available) {
		setDefault();
		setAvailable(available);
		
	}
	/**
	 * set the value of this indicator
	 * @param n the value of indicator, 1 or 0
	 */
	public void setIndicator(int n) {
		this.setValue(n);
		this.setString(String.valueOf(n));
	}
	
	/**
	 * switch status between 1 or 0
	 */
	private void switchStatus() {
		if(available) {
			int currentValue=this.getValue();
			setIndicator(1-currentValue);
		}
		
	}

}

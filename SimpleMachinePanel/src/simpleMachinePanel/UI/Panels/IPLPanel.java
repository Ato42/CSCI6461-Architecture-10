package simpleMachinePanel.UI.Panels;

import simpleMachinePanel.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class IPLPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public IPLPanel(Machine machine) {
		
		
		JButton tglbtnIPL = new JButton("OFF");
		tglbtnIPL.setBounds(86, 15, 104, 47);
		/**
		 * Click this button to Initialize the machine
		 */
		tglbtnIPL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!tglbtnIPL.isSelected()){
					tglbtnIPL.setText("ON");
					tglbtnIPL.setBackground(new Color(0, 255, 0));
					try {
						IPL.SetON(machine);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
			}
			}
		});
		tglbtnIPL.setFont(new Font("SansSerif", Font.PLAIN, 30));
		setLayout(null);
		
		JLabel lblIpl = new JLabel("IPL:");
		lblIpl.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblIpl.setBounds(21, 8, 92, 61);
		add(lblIpl);
		add(tglbtnIPL);

	}
	


}

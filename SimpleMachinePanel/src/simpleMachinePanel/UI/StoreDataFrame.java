package simpleMachinePanel.UI;
import simpleMachinePanel.*;
import simpleMachinePanel.UI.Panels.RegisterPanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreDataFrame extends JFrame {
	
	Register data=new Register(16);
	Register address=new Register(12);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public StoreDataFrame(Machine machine,String str) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 930, 268);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		RegisterPanel panelData = new RegisterPanel(data,str,150);
		panelData.setBounds(26, 26, 876, 54);
		panelData.getBtn_Display().setVisible(false);
		panelData.getBtn_Store().setVisible(false);
		
		RegisterPanel panelAddress = new RegisterPanel(address,"Address",150);
		panelAddress.setBounds(26, 92, 876, 71);
		panelAddress.getBtn_Display().setVisible(false);
		panelAddress.getBtn_Store().setVisible(false);
		
		/**
		 * Click this button to Store the data to memory. The data can be just data or instruction
		 */
		JButton Save = new JButton("Store");
		Save.setBounds(400, 160, 116, 37);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Save.setFont(new Font("SansSerif", Font.PLAIN, 21));
		Save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					machine.getMemory().setValue(panelAddress.getCode(), panelData.getCode());
					JOptionPane.showMessageDialog(null, str+" is successfully stored in memory!");
					dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Overflow!", "Warning!",0 );
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panelAddress);
		contentPane.add(panelData);
		contentPane.add(Save);
	}
}

package simpleMachinePanel.UI;
import simpleMachinePanel.*;
import simpleMachinePanel.UI.Panels.IPLPanel;
import simpleMachinePanel.UI.Panels.RegisterPanel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;


import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
//import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;


/**
 * the Main Frame of this Program
 * @author Ruotong Wu
 *
 */
public class SimpleMachineFrame extends JFrame {


	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Machine machine=new Machine();

	
	RegisterPanel registerPanelMBR;	
	RegisterPanel registerPanelR0;	
	RegisterPanel registerPanelR1;	
	RegisterPanel registerPanelR2;
	RegisterPanel registerPanelR3;	
	RegisterPanel registerPanelX1;
	RegisterPanel registerPanelX2;	
	RegisterPanel registerPanelX3;	
	RegisterPanel registerPanelCC;
	RegisterPanel registerPanelMFR;
	RegisterPanel registerPanelMAR;
	RegisterPanel RegisterPanelIR;
	private JButton btnShowAll;
	private JLabel lblMar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleMachineFrame frame = new SimpleMachineFrame();
					frame.setVisible(true);
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleMachineFrame() {
		setTitle("Computer Simulator");

		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1433, 865);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel indicatorsPanel = new JPanel();	
		IPLPanel panel_IPL = new IPLPanel(this.machine);
		
		JSeparator separator = new JSeparator();
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		JButton btnStoreData = new JButton("Store Data");
		btnStoreData.setFont(new Font("Tahoma", Font.PLAIN, 25));
		/**
		 * Click this button to open another frame to Store data to Memory
		 */
		btnStoreData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StoreDataFrame dataFrame=new StoreDataFrame(machine,"Data");
				dataFrame.setVisible(true);
			}
		});
		
		JButton btnStoreInstruction = new JButton("Store Instruction");
		/**
		 * Click this button to open another frame to Store Instruction to Memory
		 */
		btnStoreInstruction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StoreDataFrame instructionFrame=new StoreDataFrame(machine,"Instruction");
				instructionFrame.setVisible(true);
			}
		});
		btnStoreInstruction.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JPanel panelUserConsole = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(panel_IPL, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelUserConsole, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnStoreInstruction, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnStoreData, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(indicatorsPanel, GroupLayout.PREFERRED_SIZE, 1090, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 751, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(panel_IPL, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnStoreData)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnStoreInstruction, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(panelUserConsole, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
				.addComponent(indicatorsPanel, GroupLayout.PREFERRED_SIZE, 804, Short.MAX_VALUE)
		);
		
		JLabel lblUserConsole = new JLabel("User Console:");
		lblUserConsole.setBounds(0, 0, 128, 26);
		
		lblMar = new JLabel("MAR:");
		lblMar.setBounds(0, 31, 225, 26);
		panelUserConsole.setLayout(null);
		panelUserConsole.add(lblUserConsole);
		panelUserConsole.add(lblMar);
		

		
		panel_IPL.setLayout(null);
		
		
		
		RegisterPanel registerPanelPC = new RegisterPanel(this.machine.getPC(),"PC");		
		registerPanelPC.getBtn_Store().setText("Run");
		registerPanelPC.getBtn_Store().setFont(new Font("SansSerif", Font.PLAIN, 20));
		registerPanelPC.getBtn_Store().setBounds(927, 9, 100, 40);
		/**
		 * Click this button to run the code on PC Panel
		 */
		registerPanelPC.getBtn_Store().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoadStoreInstruction instruction;
				
				try {
					instruction=new LoadStoreInstruction(machine.getMemory().getValue(registerPanelPC.getCode()), machine);
					instruction.Run();
					refresh();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage() );
				}

			}
		});
		registerPanelMBR = new RegisterPanel(this.machine.getMBR(),"MBR");		
		registerPanelR0 = new RegisterPanel(this.machine.getR()[0],"R0");		
		registerPanelR1 = new RegisterPanel(this.machine.getR()[1],"R1");		
		registerPanelR2 = new RegisterPanel(this.machine.getR()[2],"R2");		
		registerPanelR3 = new RegisterPanel(this.machine.getR()[3],"R3");		
		registerPanelX1 = new RegisterPanel(this.machine.getX()[0],"X1");		
		registerPanelX2 = new RegisterPanel(this.machine.getX()[1],"X2");		
		registerPanelX3 = new RegisterPanel(this.machine.getX()[2],"X3");		
		registerPanelCC = new RegisterPanel(this.machine.getCC(),"CC");	
		registerPanelMFR = new RegisterPanel(this.machine.getMFR(),"MFR");	
		registerPanelMAR = new RegisterPanel(this.machine.getMAR(),"MAR");
		/**
		 * Click this button to show the content of the address in the MAR in User Console
		 */
		registerPanelMAR.getBtn_Store().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					machine.getMAR().setCode(registerPanelMAR.getCode());
					lblMar.setText("MAR: "+machine.getMemory().getValue(machine.getMAR().getCode()));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		RegisterPanelIR = new RegisterPanel(this.machine.getIR(),"IR");
		
		
		
		
		registerPanelCC.getBtn_Store().setVisible(false);	
		registerPanelMFR.getBtn_Store().setVisible(false);
		
		btnShowAll = new JButton("Show ALL");
		btnShowAll.setFont(new Font("SansSerif", Font.PLAIN, 21));
		btnShowAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		
		
		GroupLayout gl_indicatorsPanel = new GroupLayout(indicatorsPanel);
		gl_indicatorsPanel.setHorizontalGroup(
			gl_indicatorsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_indicatorsPanel.createSequentialGroup()
					.addGroup(gl_indicatorsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(RegisterPanelIR, GroupLayout.PREFERRED_SIZE, 1858, GroupLayout.PREFERRED_SIZE)
						.addComponent(registerPanelPC, GroupLayout.PREFERRED_SIZE, 1068, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_indicatorsPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(registerPanelX3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelX2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelX1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelR3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelR2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelR1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelR0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelMBR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(registerPanelMAR, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 1070, GroupLayout.PREFERRED_SIZE))
						.addComponent(registerPanelMFR, GroupLayout.PREFERRED_SIZE, 1858, GroupLayout.PREFERRED_SIZE)
						.addComponent(registerPanelCC, GroupLayout.PREFERRED_SIZE, 1858, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_indicatorsPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnShowAll, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_indicatorsPanel.setVerticalGroup(
			gl_indicatorsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_indicatorsPanel.createSequentialGroup()
					.addComponent(btnShowAll, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(registerPanelPC, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(registerPanelMAR, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(registerPanelMBR, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(registerPanelR0, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(registerPanelR1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(registerPanelR2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(registerPanelR3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(registerPanelX1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(registerPanelX2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(registerPanelX3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(registerPanelCC, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(registerPanelMFR, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(RegisterPanelIR, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		indicatorsPanel.setLayout(gl_indicatorsPanel);
		contentPane.setLayout(gl_contentPane);
		
	}
	/**
	 * Show the current data on Registers
	 */
	public void refresh() {
		registerPanelMBR.showCode();	
		registerPanelR0.showCode();	
		registerPanelR1.showCode();	
		registerPanelR2.showCode();
		registerPanelR3.showCode();	
		registerPanelX1.showCode();
		registerPanelX2.showCode();	
		registerPanelX3.showCode();
		registerPanelCC.showCode();
		registerPanelMFR.showCode();
		registerPanelMAR.showCode();
	}
}

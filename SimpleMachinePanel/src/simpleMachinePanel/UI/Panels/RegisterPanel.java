package simpleMachinePanel.UI.Panels;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import simpleMachinePanel.Register;
import simpleMachinePanel.UI.Components.Indicator;

public class RegisterPanel extends JPanel {
	
	 private JLabel lbl;//the label on the left to indicate the name of this 
	 private Indicator[] indicators;// the indicators in the middle to show the data on this register
	 private JButton btn_Show;//click it to show the data on the Register
	 private JButton btn_Store;//click it to store the data shows on the indicators to the register
	 private Register r;
	 
	 public JButton getBtn_Display() {
		 return btn_Show;
	 }
	 
	 public JButton getBtn_Store() {
		 return btn_Store;
	 }
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public RegisterPanel(Register r,String str) {
		
		this.r=r;

		setLayout(null);
		
		lbl = new JLabel(str+"\uFF1A");
		lbl.setFont(new Font("SansSerif", Font.PLAIN, 25));
		lbl.setBounds(19, 3, 182, 55);
		add(lbl);
		
		
		indicators =new Indicator[16];	
		
		for(int i=0;i<16;i++) {
			if(i<16-r.getLength()) {
				indicators[i]=new Indicator(false);
			}
			else {
				indicators[i]=new Indicator();
			}
			indicators[i].setBounds(90+i*45, 6, 40, 40);
			add(indicators[i]);
		}
		
		btn_Show = new JButton("Show");
		btn_Show.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btn_Show.setBounds(820,8,100,40);
		btn_Show.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	showCode();
                }
        });
		add(btn_Show);
		
		btn_Store = new JButton("Store");
		btn_Store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					getCode();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btn_Store.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btn_Store.setBounds(930,8,100,40);
		add(btn_Store);
		
		showCode();

	}
	/**
	 * the name of the Register may various, to reuse this panel, sometimes, it may need how long the name is
	 * @param r the register
	 * @param str the name of the register
	 * @param w the width of the register's name
	 */
	public RegisterPanel(Register r,String str, int w) {
		
		this.r=r;

		setLayout(null);
		
		lbl = new JLabel(str+"\uFF1A");
		lbl.setFont(new Font("SansSerif", Font.PLAIN, 25));
		lbl.setBounds(19, 3, 182, 55);
		add(lbl);
		
		
		indicators =new Indicator[16];	
		
		for(int i=0;i<16;i++) {
			if(i<16-r.getLength()) {
				indicators[i]=new Indicator(false);
			}
			else {
				indicators[i]=new Indicator();
			}
			indicators[i].setBounds(w+i*45, 6, 40, 40);
			add(indicators[i]);
		}
		
		btn_Show = new JButton("Show");
		btn_Show.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btn_Show.setBounds(w+730,8,100,40);
		btn_Show.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            	showCode();
                }
        });
		add(btn_Show);
		
		btn_Store = new JButton("Store");
		btn_Store.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					getCode();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btn_Store.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btn_Store.setBounds(w+840,8,100,40);
		add(btn_Store);
		
		showCode();

	}
	
	
	/**
	 * show the register's code on the indicators
	 */
	public void showCode() {
		for(int i=0;i<r.getLength();i++) {
			indicators[i+(16-r.getLength())].setIndicator(Integer.parseInt(Character.toString(this.r.getCode().charAt(i))));
		}
	}
	/**
	 * to store the code on the indicators into register and return the code
	 * @return the code on the indicators
	 * @throws Exception the code's length may longer than the register's length
	 */
	public String getCode() throws Exception {
		String result="";
		for(int i=0;i<16;i++)
		{
			if(indicators[i].getAvailable()) {
				result+=indicators[i].getString();
			}
		}
		this.r.setCode(result);
		return result;
	}
}

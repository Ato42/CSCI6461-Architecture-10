package simpleMachinePanel;


/**
 * The LoadStoreInstruction Class, sub of  Instruction
 * 
 * @author Ruotong Wu
 *
 */
public class LoadStoreInstruction extends Instruction {
	
	private String OP;//the OP code of the instruction
	private String R;//the GPR which will be used
	private String IX;//the Index Register which will be used
	private String I;//Indicator of direct addressing
	private String Address;// the Address of instruction
	private Machine Machine;//the Machine which the instruction will be run on
	
	/**
	 * Initializing the Instruction
	 * @param str the code of Instruction
	 * @param ma the machine this Instruction will be run on
	 */
	public LoadStoreInstruction(String str,Machine ma) {
		this.setCode(str);	
		this.Machine=ma;
		Decode();
	}
	
	/**
	 * Decode the Instruction
	 * Figure out the parts of instruction
	 */
	public void Decode() {
		
		OP=this.getCode().substring(0, 6);
		R=this.getCode().substring(6, 8);
		IX=this.getCode().substring(8, 10);
		I=this.getCode().substring(10, 11);
		Address=this.getCode().substring(11);
	}
	
	/**
	 * Run the Instruction
	 * @throws Exception the Address may out of Memory's bound
	 */
	public void Run() throws Exception {
		switch(Integer.parseInt(this.OP, 2)){
		case 1: 
			LDR();
			break;
		case 2:
			STR();
			break;
		case 3:
			LDA();
			break;
		case 41:
			LDX();
			break;
		case 42:
			STX();
			break;
		default:
				break;
		}
	}
	
	/**
	 * Store Index Register to Memory
	 * @throws Exception the Address may out of Memory's bound
	 */
	private void STX() throws Exception {
		
		this.Machine.getMemory().setValue(EA(), this.Machine.getX()[Integer.parseInt(IX,2)-1].getCode());

		
	}

	/**
	 * Load Index Register from Memory
	 * @throws Exception the Address may out of Memory's bound
	 */
	private void LDX() throws Exception {
		
		this.Machine.getX()[Integer.parseInt(IX,2)-1].setCode(this.Machine.getMemory().getValue(EA()));
		
	}

	/**
	 * Load Register with Address
	 * @throws Exception the Address may out of Memory's bound
	 */
	private void LDA() throws Exception {
		
		this.Machine.getR()[Integer.parseInt(R,2)].setCode(EA());
		
	}
	
	/**
	 * Store Register To Memory
	 * @throws Exception the Address may out of Memory's bound
	 */
	private void STR() throws Exception {
		
		this.Machine.getMemory().setValue(EA(), this.Machine.getR()[Integer.parseInt(R,2)].getCode());

	}
	
	/**
	 * Load Register From Memory
	 * @throws Exception the Address may out of Memory's bound
	 */
	private void LDR() throws Exception {
		
		this.Machine.getR()[Integer.parseInt(R, 2)].setCode(this.Machine.getMemory().getValue(EA()));
		
	}

	/**
	 * Compute the Effective Address
	 * 
	 * 	Effective Address (EA) = 
	 * 		if I field = 0: 
	 *			// NO indirect addressing			
	 *			If  IX = 00, EA = contents of the Address field
	 *			// just indexing
	 *			if IX = 1..3, c(Xj) + contents of the Address field, where j = c(IX)
	 *			// that is, the IX field has an index register number, the contents of which are added to the contents of the address field
	 *		if I field  = 1: 
	 *			// indirect addressing, but NO indexing
	 *			if IX = 00, c(Address)
	 *			// both indirect addressing and indexing
	 *			if IX = 1..3, c(c(Xj) + Address), where j = c(IX)
	 *
	 * @return the Effective Address
	 * @throws Exception the Address may out of Memory's bound
	 */
	private String EA() throws Exception {
		if(I.equals("0")) {
			if(IX.equals("00")) {
				return this.Address;
			}else {
				return ALU.add(this.Machine.getX()[Integer.parseInt(IX,2)-1].getCode(), this.Address);
			}
		}else {
			if(IX.equals("00")) {
				return this.Machine.getMemory().getValue(this.Address);
			}else {
				return this.Machine.getMemory().getValue(ALU.add(this.Machine.getX()[Integer.parseInt(IX,2)-1].getCode(), this.Address));
			}
		}
		
	}
}

package simpleMachinePanel;

/*
 * Instruction super class
 */
public class Instruction {
	
	private String code; // the whole code of instruction
	private String OP; //the OP code of instruction
	
	public Instruction() {
		
	}
	/**
	 * 	
	 * initializing the Instruction 
	 * @param str the code of Instruction
	 */
	public Instruction(String str) {
		setCode(str);
	}
	
	/**
	 * set the code of Instruction
	 * @param str the code of Instruction
	 */
	public void setCode(String str) {
		this.code=str;
		this.OP=code.substring(0, 6);//find out the OP of the instruction
	}
	
	/**
	 * return the value of Code
	 * @return Code of Instruction
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * return OP code
	 * @return OP of Instruction
	 */
	public String getOP() {
		return this.OP;
	}
	

}

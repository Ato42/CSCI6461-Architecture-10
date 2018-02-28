package simpleMachinePanel;

public class Register {
	
	private String code;// the code of the register
	private int length;//the length of the register, different register may have different lenght
	
	/**
	 * Initializing the Register
	 * @param length the length of the Register
	 */
	public Register(int length) {
		this.length=length;
		String str="";
		// Initializing the Register with 0
		while(str.length()<this.length) {
			str+="0";
		}
		this.code=str;
		
	}
	/**
	 * get the Register's Current Code
	 * @return Current Code on the Register
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Load Code into Register
	 * @param str the Code 
	 * @throws Exception the code may too long to load
	 */
	public void setCode(String str) throws Exception {
		
		if(str.length()>this.length)
		{
			throw new Exception("Code Invalid!");
		}
		else {
			while(str.length()!=this.length) {
				str="0"+str;
			}
			this.code=str;
		}
	}
	
	/**
	 * get the length of the Register
	 * @return the length
	 */
	public int getLength() {
		return this.length;
	}
	
	

}

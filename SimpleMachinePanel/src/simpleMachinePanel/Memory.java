package simpleMachinePanel;

public class Memory {
	
	/**
	 * Use a Matrix to simulate the Memory
	 */
	int[][] Memory;
	
	/**
	 * Initializing the memory
	 */
	public Memory(){
		Memory=new int[4096][16];
	}
	
	/**
	 * Get data from Memory
	 * @param Address the Address where store the data
	 * @return the data
	 * @throws Exception the Address may out of memory Bound
	 */
	public String getValue(String Address) throws Exception {
		String result="";
		int add=Integer.parseInt(Address, 2);
		
		if(add>=4096) {
			throw new Exception("Out of memory bound!"); //if the address >= 4096, throw exception
		}else {
			for(int i=0;i<16;i++)
			{
				result+=Memory[add][i]; //read the data
			}
			return result;
		}
		
	}
	/**
	 * Store Value to Memory
	 * @param Address the Address where store the data
	 * @param Value the value to store
	 * @throws Exception the Address may out of memory Bound of the data may be too long to store
	 */
	public void setValue(String Address, String Value) throws Exception {
		
		int add=Integer.parseInt(Address, 2);
		if(add>=4096) {
			throw new Exception("Out of memory bound!");//if the address is lager than 4096, throw this exception
		}
		
		int va=Integer.parseInt(Value, 2);
		if(va>=65536) {
			throw new Exception("Overflow!");//if the data is lager than 65536, throw this exception
		}
		
		Value=Value.substring(Value.length()-16);
		
		for(int i=0;i<16;i++)
		{
			Memory[add][i]=Integer.parseInt(Character.toString(Value.charAt(i)));// otherwise, store the data to the address
		}
		
	}

}

package simpleMachinePanel;

public class ALU {
	/*
	 * Add two Binary Address String
	 */
	public static String add(String str1, String str2) throws Exception {
		
		int i=Integer.parseInt(str1, 2)+Integer.parseInt(str2, 2);
		String result=Integer.toBinaryString(i);
		
		if(result.length()<=12){//if the result's length <= 12, return a 12 bits length string, complete it with 0 at the front
			while(result.length()<12) {
				result="0"+result;
			}
			return result;
		}else {
			throw new Exception("Overflow");// if longer than 12, that's means we cannot find the location in memory
		}
	}

}

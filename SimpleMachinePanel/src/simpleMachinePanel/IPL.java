package simpleMachinePanel;

public class IPL {
	
	public boolean isOn;
	
	/**
	 * pre-load a program;
	 * the result show be:
	 * Memory[0]="0000010100000011";
	 * Memory[1]="0000000000000001";
	 * Memory[2]="0000010100000011";
	 * Memory[3]="0000000000000001";
	 * X1="0000000000000001";
	 * X2="0000000000000001";
	 * R0="0000010100000011";
	 * R1="0000000000000011";
	 * @param machine the machine which will be initialize
	 */
	public static void SetON(Machine machine) throws Exception {
		
		machine.getMemory().setValue("000000000011", "0000000000000001");//store address 1 to memory[3];
		machine.getMemory().setValue("000000000010", "0000000000000010");//store address 1 to memory[3];
		machine.getMemory().setValue("000000000000", "0000010100000011");//store instruction (LDR 1,0,3,0) to memory[0];
		machine.getMemory().setValue("000000000100", "0000111100010011");//store instruction (LDA 3,0,19,0) to memory[4];
		machine.getX()[1].setCode("01");//store 01 to X2
		machine.getX()[0].setCode("11");//store 11 to X1
		
		LoadStoreInstruction STX=new LoadStoreInstruction("1010100010100010",machine); //STX with indirect addressing and indexing: store c(X2) to memory[c(x2)];
		STX.Run();
		
		LoadStoreInstruction LDX=new LoadStoreInstruction("1010010001000000",machine);//LDX with direct addressing and indexing: load value from memory[1]  to X1;
		LDX.Run();
		
		LoadStoreInstruction LDR=new LoadStoreInstruction("0000010000000000",machine); //LDR with direct addressing but no indexing: load instruction from memory[00] to R0;
		LDR.Run();
		
		LoadStoreInstruction STR=new LoadStoreInstruction("0000100000100010",machine); //STR with indirect addressing but no indexing: store instruction from R0 to memory[02];
		STR.Run();
		
		LoadStoreInstruction LDA=new LoadStoreInstruction("0000110101000010",machine); //LDA with direct addressing and indexing: load addressing c(X1)+2 to R1;
		LDA.Run();
		
	}

}

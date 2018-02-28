package simpleMachinePanel;
/**
 * The machine this program simulate
 * It contains several different Registers and Memory
 * @author Ruotong Wu
 *
 */
public class Machine {
	private Register PC,MAR,MBR,CC,MFR,IR;//Register PC,MAR,MBR,CC,MFR,IR
	private Register[] R,X;//Register R0-R3,X1-X3. X1=X[0],X2=X[1],X3=X[2];
	private Memory Memory;
	
	/**
	 * Initializing
	 */
	public Machine() {
		PC=new Register(12);
		MAR=new Register(16);
		MBR=new Register(16);
		R=new Register[4];
		for(int i=0;i<4;i++) {
			R[i]=new Register(16);
		}
		X=new Register[3];
		for(int i=0;i<3;i++) {
			X[i]=new Register(16);
		}
		CC=new Register(4);
		MFR=new Register(4);
		IR=new Register(16);
		Memory=new Memory();
	}
	
	/**
	 * return the PC of this machine
	 * @return Program Counter
	 */
	public Register getPC() {
		return this.PC;
	}
	
	/**
	 * return the MAR of this machine
	 * @return Memory Address Register
	 */
	public Register getMAR() {
		return this.MAR;
	}
	
	/**
	 * return the MBR of this machine
	 * @return Memory Buffer Register
	 */
	public Register getMBR() {
		return this.MBR;
	}
	/**
	 * return the R0-R3 of this machine
	 * @return General Purpose Registers
	 */
	public Register[] getR() {
		return this.R;
	}
	
	/**
	 * return the X1-X3 of this machine
	 * @return Index Registers, Xi=X[i+1]
	 */
	public Register[] getX() {
		return this.X;
	}
	
	/**
	 * return the CC of this machine
	 * @return Condition Code
	 */
	public Register getCC() {
		return this.CC;
	}
	
	/**
	 * return the MFR of this machine
	 * @return Machine Fault Register
	 */
	public Register getMFR(){
		return this.MFR;
	}
	
	/**
	 * return the IR of this machine
	 * @return Instruction Register
	 */
	public Register getIR() {
		return this.IR;
	}
	
	/**
	 * return the Memory
	 * @return Memory
	 */
	public Memory getMemory() {
		return this.Memory;
	}
	

}

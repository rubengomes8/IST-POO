package simulation;

import pec.PECs;

public abstract class SimulatorAbs implements Simulator {

	protected double instant;
	protected PECs pec;
	
	@Override
	public abstract void beginSimulation();
	
	@Override
	public abstract PECs getPec();
	
	@Override
	public abstract void setPec(PECs pec);
	
	@Override
	public abstract double getInst();

	@Override
	public abstract void setInst(float instant);
	
	@Override
	public abstract double getFinalInst();
	
	@Override
	public abstract void setFinalInst(float finalInst);

}

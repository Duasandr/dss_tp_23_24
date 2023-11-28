package uminho.grupo3.logic.worker.interfaces;

import uminho.grupo3.logic.workstation.interfaces.IWorkStation;

public interface IWorker {

	boolean isClockedIn();

	/**
	 * 
	 * @param workStation
	 */
	boolean canOperate(IWorkStation workStation);

}
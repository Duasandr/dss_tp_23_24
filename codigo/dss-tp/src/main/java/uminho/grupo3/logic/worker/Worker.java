package uminho.grupo3.logic.worker;

import uminho.grupo3.logic.person.Details;
import uminho.grupo3.logic.worker.interfaces.IWorker;
import uminho.grupo3.logic.workstation.interfaces.IWorkStation;

import java.util.HashSet;
import java.util.Set;

public class Worker implements IWorker {

	private Set<Skill> skillSet;
	private Details details;
	private boolean clockedIn;

	/**
	 * 
	 * @param details
	 * @param skillSet
	 */
	public Worker(Details details, Set<Skill> skillSet) {
		this.details = details;
		this.skillSet = new HashSet<>(skillSet);
	}

	public boolean isClockedIn() {
		return this.clockedIn;
	}

	/**
	 * 
	 * @param workStation
	 */
	public boolean canOperate(IWorkStation workStation) {
		return workStation.getRequiredSkillSet().containsAll(skillSet);
	}

}
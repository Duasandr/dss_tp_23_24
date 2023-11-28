package uminho.grupo3.logic.workstation.interfaces;

import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.worker.Skill;
import uminho.grupo3.logic.workstation.Job;

import java.util.Set;

public interface IWorkStation {

	/**
	 * 
	 * @param service
	 */
	boolean canPerform(IService service);

	Job completeNextJob();

	Job getNextJob();

	Set<Skill> getRequiredSkillSet();
	Set<IService> getPerformedServices();

}
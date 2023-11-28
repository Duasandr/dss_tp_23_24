package uminho.grupo3.logic.workstation;

import uminho.grupo3.logic.service.Service;
import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.worker.Skill;
import uminho.grupo3.logic.worker.interfaces.IWorker;
import uminho.grupo3.logic.workstation.interfaces.IWorkStation;

import java.util.*;
import java.util.stream.Collectors;

public class WorkStation implements IWorkStation {

	private Queue<Job> jobQueue;
	private Map<String, IService> performedServiceMap;
	private Set<Skill> requiredSkillSet;

	/**
	 * 
	 * @param performedServiceSet
	 * @param requiredSkillSet
	 */
	public WorkStation(Set<IService> performedServiceSet, Set<Skill> requiredSkillSet) {
		this.performedServiceMap = performedServiceSet.stream().collect(Collectors.toMap(IService::getDescription, s -> s));
		this.requiredSkillSet = new HashSet<>(requiredSkillSet);
	}

	/**
	 * 
	 * @param service
	 */
	public boolean canPerform(IService service) {
		return performedServiceMap.containsKey(service.getDescription());
	}

	@Override
	public Job completeNextJob() {
		return jobQueue.remove();
	}

	public Job getNextJob() {
		return jobQueue.poll();
	}

	/**
	 * 
	 * @param worker
	 */
	public Set<Job> getAssignedJobs(IWorker worker) {
		return new HashSet<>(jobQueue);
	}

	@Override
	public Set<Skill> getRequiredSkillSet() {
		return new HashSet<>(requiredSkillSet);
	}

	@Override
	public Set<IService> getPerformedServices() {
		return new HashSet<>(performedServiceMap.values());
	}

}
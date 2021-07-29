package com.stuartkruze.services;

import java.util.List;

import org.apache.log4j.Logger;


import com.stuartkruze.models.Employee;
import com.stuartkruze.models.Event;
import com.stuartkruze.models.Training;
import com.stuartkruze.repositories.EmployeeRepo;
import com.stuartkruze.repositories.TrainingRepo;

public class TrainingServiceImpl implements TrainingService {

	public TrainingRepo tr;
	public EmployeeRepo er;
	
	final static Logger log = Logger.getLogger(TrainingServiceImpl.class);
	

	public TrainingServiceImpl(TrainingRepo tr, EmployeeRepo er) {
		this.tr = tr;
		this.er = er;
	}
	
	
	@Override
	public Training addTraining(Training t) {
		return tr.addTraining(t);
	}

	@Override
	public List<Training> getAllTrainings() {
		return tr.getAllTrainings();
	}

	@Override
	public Training getTraining(int id) {
		return tr.getTraining(id);
	}

	@Override
	public Training updateTraining(Training change) {
		return tr.updateTraining(change);
	}

	@Override
	public Training deleteTraining(int id) {
		return tr.deleteTraining(id);
	}

	@Override
	public List<Training> getTrainingsByEmployeeId(int employee_id) {
		return tr.getTrainingsByEmployeeId(employee_id);
	}

	@Override
	public Training computeT(int id) {
		Training t = tr.getTraining(id);
		Employee e = t.getEmployeeId();
		double tu = e.gettReimbur();
		Event ev = t.getEventId();
		double pr = ev.getPendingReimbersment();
		t.setApprovedByBC(true);
		
		
		String type = ev.getType();
		String uni = "University Course";
		String sem = "Seminars";
		String cert1 = "Certification Preparation Class";
		String cert2 = "Certification";
		String tech = "Technical Training";
		String other = "Other";
		
		
		
		if(tu == 0){
		t.setInsufficient(true);
		t.setAwarded(0);
		t.setAdjusted(0);
		tr.updateTraining(t);
		er.updateEmployee(e);
		return t;
		}
		

		if(type.equals(uni)) {
			pr = pr*0.8;
			
			t.setPercent(80);
		} else if(type.equals(sem)) {
			pr = pr*0.6;
			t.setPercent(60);
		} else if(type.equals(cert1)) {
			pr = pr*0.75;
			t.setPercent(75);
		} else if(type.equals(cert2)) {
			t.setPercent(100);
		} else if(type.equals(tech)) {
			pr = pr*0.9;
			t.setPercent(90);
		} else if(type.equals(other)) {
			pr = pr*0.3;
			t.setPercent(30);
		}
		
		
		double ar = tu - pr;
		
		if(ar < 0) {
			double abby = Math.abs(ar);
			if(abby > tu) {
				t.setAwarded(tu);
				t.setAwardedReimbursment(tu);
				t.setAdjusted(tu);
				e.settReimbur(0);
				tr.updateTraining(t);
				er.updateEmployee(e);
				return tr.addResult(t);
			} 
			

		}
		

		
		t.setAwarded(pr);
		t.setAwardedReimbursment(pr);
		e.settReimbur(ar);
		
		tr.updateTraining(t);
		er.updateEmployee(e);
		return tr.addResult(t);
	}

}

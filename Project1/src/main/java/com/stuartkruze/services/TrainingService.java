package com.stuartkruze.services;

import java.util.List;


import com.stuartkruze.models.Training;

public interface TrainingService {

	public Training addTraining(Training t);
	public List<Training> getAllTrainings();
	public Training getTraining(int id);
	public Training updateTraining(Training change);
	public Training deleteTraining(int id);
	public List<Training> getTrainingsByEmployeeId(int employee_id);
	public Training computeT(int id);
}

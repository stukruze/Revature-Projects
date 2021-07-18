package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Training;

public interface TrainingServices {

	public Training addTraining(Training t);
	public List<Training> getAllTrainings();
	public Training getTraining(int id);
	public Training updateTraining(Training change);
	public Training deleteTraining(int id);
}

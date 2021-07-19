package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Training;
import com.stuartkruze.repositories.TrainingRepo;

public class TrainingServiceImpl implements TrainingService {

	public TrainingRepo tr;

	public TrainingServiceImpl(TrainingRepo tr) {
		this.tr = tr;
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

}

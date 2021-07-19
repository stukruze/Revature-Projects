package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Grading;

public interface GradingService {

	public Grading addGrading(Grading g);
	public List<Grading> getAllGradings();
	public Grading getGrading(int id);
	public Grading updateGrading(Grading change);
	public Grading deleteGrading(int id);
}

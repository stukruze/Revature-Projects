package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Grading;

public interface GradingRepo {
	
	public Grading addGrading(Grading g);
	public List<Grading> getAllGradings();
	public Grading getGrading(int id);
	public Grading updateGrading(Grading change);
	public Grading deleteGrading(int id);
}

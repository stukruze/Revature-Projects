package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Grading;
import com.stuartkruze.repositories.GradingRepo;

public class GradingServicesImpl implements GradingServices {

	public GradingRepo gr;

	public GradingServicesImpl(GradingRepo gr) {
		this.gr = gr;
	}
	
	@Override
	public Grading addGrading(Grading g) {
		return gr.addGrading(g);
	}

	@Override
	public List<Grading> getAllGradings() {
		return gr.getAllGradings();
	}

	@Override
	public Grading getGrading(int id) {
		return gr.getGrading(id);
	}

	@Override
	public Grading updateGrading(Grading change) {
		return gr.updateGrading(change);
	}

	@Override
	public Grading deleteGrading(int id) {
		return gr.deleteGrading(id);
	}

}

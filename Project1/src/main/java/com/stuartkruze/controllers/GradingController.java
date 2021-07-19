package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Grading;
import com.stuartkruze.services.GradingService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class GradingController {

	Gson gson = new Gson();
	GradingService gs;

	public GradingController(GradingService gs) {
		this.gs = gs;
	}

	public Handler getGradingById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Grading g = gs.getGrading(id);

		populateResult(context, g);
	};

	public Handler addGrading = (context) -> {

		Grading g = gson.fromJson(context.body(), Grading.class);

		g = gs.addGrading(g);

		populateResult(context, g);
	};

	public Handler getAllGradings = (context) -> {

		List<Grading> gradings = gs.getAllGradings();
		if (gradings != null) {
			context.result(gson.toJson(gradings));
		} else {
			context.result("[]");
		}

	};

	public Handler updateGrading = (context) -> {
		Grading g = gson.fromJson(context.body(), Grading.class);
		g.setId(Integer.parseInt(context.pathParam("id")));

		g = gs.updateGrading(g);

		populateResult(context, g);
	};

	public Handler deleteGrading = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Grading g = gs.deleteGrading(id);

		populateResult(context, g);
	};

	private void populateResult(Context context, Grading g) {
		if (g != null) {
			context.result(gson.toJson(g));
		} else {
			context.result("{}");
		}
	}
}

package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Training;
import com.stuartkruze.services.TrainingService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class TrainingController {

	Gson gson = new Gson();
	TrainingService ts;

	// Please don't ever actually skip the Service layer.
	public TrainingController(TrainingService ts) {
		this.ts = ts;
	}

	public Handler getActorById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Training t = ts.getTraining(id);

		populateResult(context, t);
	};

	public Handler addTraining = (context) -> {

		Training t = gson.fromJson(context.body(), Training.class);

		t = ts.addTraining(t);

		populateResult(context, t);
	};

	public Handler getAllTraining = (context) -> {

		List<Training> trainings = ts.getAllTrainings();
		if (trainings != null) {
			context.result(gson.toJson(trainings));
		} else {
			context.result("[]");
		}

	};

	public Handler updateTraining = (context) -> {
		Training t = gson.fromJson(context.body(), Training.class);
		t.setId(Integer.parseInt(context.pathParam("id")));

		t = ts.updateTraining(t);

		populateResult(context, t);
	};

	public Handler deleteActor = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Training t = ts.deleteTraining(id);

		populateResult(context, t);
	};

	private void populateResult(Context context, Training t) {
		if (t != null) {
			context.result(gson.toJson(t));
		} else {
			context.result("{}");
		}
	}
}

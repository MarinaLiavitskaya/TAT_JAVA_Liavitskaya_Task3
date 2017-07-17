package com.epam.liavitskaya.main.server;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.liavitskaya.main.controller.Controller;

public class RequestDistributor implements Callable<String> {

	private Queue<String> requests = new ConcurrentLinkedQueue<String>();

	public RequestDistributor(Queue<String> requests) {
		this.requests = requests;
	}

	@Override
	public String call() {

		String request;
		String response = null;

		while ((request = requests.poll()) != null) {
			response = Controller.getInstance().executeTask(request);
			// try {
			// Thread.sleep(200);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			System.out.println("Current working thread : 	 " + Thread.currentThread().getName() + "   ***   "
					+ Thread.currentThread().getId() + "  " + response);
		}
		return response;
	}

}

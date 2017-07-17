package com.epam.liavitskaya.main.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

	private static Queue<String> requestsServer = new ConcurrentLinkedQueue<String>();

	static int count = 0;
	static List<String> futureResponseList = new ArrayList<>();
	//static String futureResponse;	

	public static List<String> startServer(String request) {

		count++;
		requestsServer.add(request);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		List<Future<String>> list = new ArrayList<Future<String>>();
		Callable<String> callable = new ExecutionProvider(requestsServer);

		for (int i = 0; i < requestsServer.size(); i++) {
			Future<String> future = executor.submit(callable);
			list.add(future);
		}
		for (Future<String> futureResponse : list) {
			try {
				System.out.println(new Date() + " :: " + futureResponse.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();

		return futureResponseList;
	}
}

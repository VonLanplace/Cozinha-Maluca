package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPrato;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(5);
		Semaphore mutexPrint = new Semaphore(1);
		Semaphore mutexDeliver = new Semaphore(1);

		for (int i = 0; i < 10; i++) {
			ThreadPrato t = new ThreadPrato(i, semaforo, mutexPrint, mutexDeliver);
			t.start();
		}
	}

}

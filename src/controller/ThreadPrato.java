package controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread {
	Semaphore semaforo;
	Semaphore mutexPrint;
	Semaphore mutexDeliver;
	int ID;
	String nome;
	int cookTime;

	public ThreadPrato(int ID, Semaphore semaforo, Semaphore mutexPrint, Semaphore mutexDeliver) {
		this.semaforo = semaforo;
		this.mutexDeliver = mutexDeliver;
		this.mutexPrint = mutexPrint;
		this.ID = ID + 1;
		if (ID % 2 == 1) {
			nome = "Sopa de Cebola";
			cookTime = (int) ((Math.random() * 301) + 500);// 0,5 to 0,8
		} else {
			nome = "Lasanha a Bolonhesa";
			cookTime = (int) ((Math.random() * 601) + 600);// 0,6 to 1,2
		}
	}

	private void safePrint(String texto) throws InterruptedException {
		try {
			mutexPrint.acquire();
			System.out.println(texto);
		} catch (InterruptedException e) {
			throw e;
		} finally {
			mutexPrint.release();
		}
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			cozinhar();
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		} finally {
			semaforo.release();
		}

		try {
			mutexDeliver.acquire();
			entregar();
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		} finally {
			mutexDeliver.release();
		}

	}

	private void cozinhar() throws InterruptedException {
		int tempoForno = 0;
		StringBuffer text = new StringBuffer();
		text.append("Ih, Prato ").append(ID).append(" - ");
		text.append(nome).append(" tá indo pro forno, pô! Já é!");
		safePrint(text.toString());
		while (tempoForno < cookTime) {
			sleep(100);
			tempoForno += 100;
			if (tempoForno > cookTime) {
				tempoForno = cookTime;
			}
			double porcent = ((double) tempoForno / cookTime) * 100;
			text = new StringBuffer();
			text.append("Prato ").append(ID).append(" - ");
			text.append(nome).append(", meu irmão, já tá ");
			text.append(String.format("%.2f", porcent)).append("%");
			text.append(" pronto!");
			safePrint(text.toString());
		}
	}

	private void entregar() throws InterruptedException {
		StringBuffer text = new StringBuffer();
		text.append("Prato ").append(ID).append(" - ");
		text.append(nome).append(" tá no esquema, prontinho pro cliente!");
		safePrint(text.toString());
		sleep(500);
		text = new StringBuffer();
		text.append("Prato ").append(ID).append(" - ");
		text.append(nome).append(" já foi entregue, valeu!");
		safePrint(text.toString());
	}

}

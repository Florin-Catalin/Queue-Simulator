package controller;

import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Customer;
import model.Customers;
import view.View;

public class Simulation {

	Thread t, t2, t3;
	View view;
	int time;
	Operation op = new Operation();
	ArrayList<Customers>queue = new ArrayList<Customers>();
	int id = -1;

	public Simulation(View v) {
		this.view = v;
		this.view.butonStart(new Start());

	}

	class Start implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int n, i;

			op.addString("\t The supermarked has opened at  "+op.computeHour(view.getOpenHour()*60)+"!!!");
			t = new Thread(new Runner());

			t.start();

			n = view.getNumberCashRegisters();

			t3 = new Thread(new ClientGenerator());
			t3.start();

			for (i = 0; i < n; i++) {
				Customers cc = new Customers();
				queue.add(cc);
			}

			for (i = 0; i < n; i++) {
				t2 = new Thread(new Runner2(i));
				t2.start();
				if(time==10) t2.interrupt();
			}
			
			
			

		}
	}

	class Runner implements Runnable {
		public void run() {

			int start = view.getOpenHour();
			int finish = view.getClosedHour();
			time = 60 * start;

			for (int i = 60 * start; i < finish * 60; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time++;

				view.setOraActuala(op.computeHour(time));
				

				if (time==view.getClosedHour()* 60) break;
			}

			op.addString("\n\t  The supermarket has closed at" + op.computeHour(view.getClosedHour()*60) +"!!!");
		}
		

	}

	class Runner2 implements Runnable {

		int kk;

		public Runner2(int kk) {
			this.kk = kk;
		}

		public void run() {

			for (;;) {
				
				if(kk==1){
					op.resetText();
					
					op.setPeakHour(false);
					for (int i=0;i<view.getNumberCashRegisters();i++){
						
						int suma=0;
						for (int j=0;j<queue.get(i).getSize();j++){
							suma+=queue.get(i).getCustomerNumber(j).getService();
							op.addTimeInterval(suma);
							
							if (queue.get(i).getSize()>7) op.setPeakHour(true);
						}
							
					}
					
					
				}
				

				if (queue.get(kk).getSize() != 0) {
					queue.get(kk).getCustomerNumber(0).decrementService();
					if (queue.get(kk).getCustomerNumber(0).getService() == 0){
						String s=">>"+op.computeHour(time)+" The client  "+id+" has exit the queue ";
						op.addString(s);
						queue.get(kk).removeCustomerNr(0);
					
					}
				}else{
					op.emptyQueue(view.getNumberCashRegisters());
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (kk==0){
					for(int i=0;i<view.getNumberCashRegisters();i++){
						op.addQueue(queue.get(i),i);
					}
					view.setScarecase(op.getText());
					view.setRezultate(op.getMessages());
				}
				if (time==view.getClosedHour()* 60) break;

			}
			
		}

	}

	class ClientGenerator implements Runnable {
		public void run() {

			int minserv, maxserv, minaparitie, maxaparitie, i, j, min, index;
			minserv = view.getMinWaiting();
			maxserv = view.getMaxWaiting();
			minaparitie = view.getMinCustomers();
			maxaparitie = view.getMaxCustomers();

			for (;;) {
				Random randomGenerator = new Random();
				int random =randomGenerator.nextInt(3);
				Customer a;

				
				for (i = 0; i < random; i++) {
					id++;

					Random randomGenerator2 = new Random();
					int random2 = minserv + randomGenerator2.nextInt(maxserv - minserv);
					a = new Customer(id, time, random2);
					op.saveServiceSum(random2);

					min = 300;
					index = 0;
					for (j = 0; j < view.getNumberCashRegisters(); j++) {

						if (queue.get(j).getSize() < min) {
							min =queue.get(j).getSize();
							index = j;
						}
					}
					queue.get(index).addCustomer(a);
					String s=">>"+op.computeHour(time)+" Clientul "+id+" s-a asezat la queue "+index+" si are "+random2+" produse in cos";
					op.addString(s);
					

				}

				Random randomGenerator3 = new Random();
				int random3 = minaparitie + randomGenerator3.nextInt(maxaparitie - minaparitie);// [ minaparitie ,maxaparitie] 
				
				try {
					Thread.sleep(random3 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
		
				
				
				if (time==view.getClosedHour()* 60) break;
			}

		}

	}

}

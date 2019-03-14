package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class View {

	private JFrame frame;
	private JTextField maxWaiting;
	private JTextField minWaiting;
	private JTextField minCustomers;
	private JTextField maxCustomers;
	private JTextField numberCashRegisters;
	private JTextField openHour;
	private JTextField closedHour;
	private JTextField oraActuala;
	private JButton butonStart;
	private JTextArea rezultate;
	private JTextArea scarecase;
	
	




	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(10, 11, 696, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel t1 = new JLabel("Queue Simulation");
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		t1.setBounds(164, 0, 358, 43);
		panel.add(t1);
		
		JLabel t13 = new JLabel("Current time:");
		t13.setBounds(551, 16, 80, 14);
		panel.add(t13);
		
		oraActuala = new JTextField();
		oraActuala.setFont(new Font("Tahoma", Font.BOLD, 11));
		oraActuala.setHorizontalAlignment(SwingConstants.CENTER);
		oraActuala.setBackground(new Color(255, 255, 255));
		oraActuala.setEditable(false);
		oraActuala.setBounds(627, 13, 59, 20);
		panel.add(oraActuala);
		oraActuala.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 60, 351, 422);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		maxWaiting = new JTextField("0");
		maxWaiting.setBounds(255, 31, 86, 20);
		panel_1.add(maxWaiting);
		maxWaiting.setColumns(10);
		
		minWaiting = new JTextField("0");
		minWaiting.setBounds(86, 31, 86, 20);
		panel_1.add(minWaiting);
		minWaiting.setColumns(10);
		
		minCustomers = new JTextField("0");
		minCustomers.setBounds(86, 86, 86, 20);
		panel_1.add(minCustomers);
		minCustomers.setColumns(10);
		
		maxCustomers = new JTextField("0");
		maxCustomers.setBounds(255, 86, 86, 20);
		panel_1.add(maxCustomers);
		maxCustomers.setColumns(10);
		
		numberCashRegisters = new JTextField("0");
		numberCashRegisters.setBounds(86, 198, 86, 20);
		panel_1.add(numberCashRegisters);
		numberCashRegisters.setColumns(10);
		
		butonStart = new JButton("Go !!");
		butonStart.setBounds(252, 197, 89, 23);
		butonStart.setForeground(new Color(255, 255, 255));
		butonStart.setBackground(new Color(0, 0, 0));
		butonStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(butonStart);
		
		JLabel t2 = new JLabel("Queueing time of customer");
		t2.setBounds(10, 11, 245, 14);
		t2.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2.setForeground(Color.DARK_GRAY);
		panel_1.add(t2);
		
		JLabel t3 = new JLabel("Minim:");
		t3.setBounds(30, 34, 46, 14);
		panel_1.add(t3);
		
		JLabel t4 = new JLabel("Maxim");
		t4.setBounds(199, 34, 46, 14);
		panel_1.add(t4);
		
		JLabel t5 = new JLabel("The time the customers appear");
		t5.setBounds(10, 58, 245, 14);
		t5.setForeground(Color.DARK_GRAY);
		t5.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(t5);
		
		JLabel t11 = new JLabel("Number of cash registers / queues:");
		t11.setBounds(10, 173, 245, 14);
		t11.setForeground(Color.DARK_GRAY);
		t11.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(t11);
		
		JLabel t6 = new JLabel("Min:");
		t6.setBounds(30, 89, 46, 14);
		panel_1.add(t6);
		
		JLabel t7 = new JLabel("Max:");
		t7.setBounds(199, 89, 46, 14);
		panel_1.add(t7);
		
		JLabel t12 = new JLabel("Number:");
		t12.setBounds(30, 201, 46, 14);
		panel_1.add(t12);
		
		JLabel t8 = new JLabel("Time table of the market:");
		t8.setBounds(10, 117, 245, 14);
		t8.setFont(new Font("Tahoma", Font.BOLD, 11));
		t8.setForeground(Color.DARK_GRAY);
		panel_1.add(t8);
		
		openHour = new JTextField("0");
		openHour.setBounds(86, 142, 86, 20);
		panel_1.add(openHour);
		openHour.setColumns(10);
		
		closedHour = new JTextField("0");
		closedHour.setBounds(255, 142, 86, 20);
		panel_1.add(closedHour);
		closedHour.setColumns(10);
		
		JLabel t9 = new JLabel(" Open :");
		t9.setBounds(30, 148, 46, 14);
		t9.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_1.add(t9);
		
		JLabel t10 = new JLabel("Closed :");
		t10.setBounds(199, 148, 46, 14);
		panel_1.add(t10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 331, 178);
		panel_1.add(scrollPane);
		
		scarecase = new JTextArea("");
		scarecase.setEditable(false);
		scrollPane.setViewportView(scarecase);
		
		JPanel t14 = new JPanel();
		t14.setBackground(new Color(220, 220, 220));
		t14.setBounds(371, 60, 335, 422);
		frame.getContentPane().add(t14);
		t14.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Log events :");
		lblNewLabel_4.setBounds(10, 11, 96, 14);
		t14.add(lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 32, 315, 379);
		t14.add(scrollPane_1);
		
		 rezultate = new JTextArea("");
		rezultate.setEditable(false);
		scrollPane_1.setViewportView(rezultate);
		
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		
	
		frame.setVisible(true);
	}
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int getMaxWaiting() {
		return Integer.parseInt(maxWaiting.getText());
	}

	public void setMaxWaiting(String maxWaiting) {
		this.maxWaiting.setText(maxWaiting);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	public int getMinWaiting() {
		return Integer.parseInt(minWaiting.getText());
	}

	public void setMinWaiting(String minWaiting) {
		this.minWaiting.setText(minWaiting);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getMinCustomers() {
		return Integer.parseInt(minCustomers.getText());
	}

	public void setMinCustomers(String minCustomers) {
		this.minCustomers.setText(minCustomers);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getMaxCustomers() {
		return Integer.parseInt(maxCustomers.getText());
	}

	public void setMaxCustomers(String maxCustomers) {
		this.maxCustomers.setText(maxCustomers);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getNumberCashRegisters() {
		return Integer.parseInt(numberCashRegisters.getText());
	}

	public void setNumberCashRegisters(String numberCashRegisters) {
		this.numberCashRegisters.setText(numberCashRegisters);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getOpenHour() {
		return Integer.parseInt(openHour.getText());
	}

	public void setOpenHour(String openHour) {
		this.openHour.setText(openHour);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int getClosedHour() {
		return Integer.parseInt(closedHour.getText());
	}

	public void setClosedHour(String closedHour) {
		this.closedHour.setText(closedHour);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getRezultate() {
		return rezultate.getText();
	}

	public void setRezultate(String rezultate) {
		this.rezultate.setText(rezultate);
	}

	public String getScarecase() {
		return scarecase.getText();
	}

	public void setScarecase(String scarecase) {
		this.scarecase.setText(scarecase);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void butonStart(ActionListener a) {
		butonStart.addActionListener(a);
	}
	
	
	public void setOraActuala(String ora){
		oraActuala.setText(ora);
	}
}

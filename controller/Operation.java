package controller;
import model.*;

public class Operation {
	
	String text=" ";
	String text2=" ";
	int i=0,j=0;
	int firstSum=0,secondSum=0,empty=0,dim;
	boolean peakHour=false;
	
	
	public Operation(){
	}
	
	public String computeHour(int time){
		
		int minutes,hours;
		String rez;
		
		hours=time/60;
		minutes=time%60;
		
		if (hours <10) rez="0"+hours+":";
			else rez=""+hours+":";
		
		if(minutes<10) rez=rez+"0"+minutes;
			else rez=rez+""+minutes;
		
		return rez;
	}
	public void resetText(){
		this.text="";
	}
	
	
	public void addQueue(Customers c,int i){
		String text2="";
		this.text=this.text+"Cash register "+i+" >>:"+"\n"+"   ";
			for(i=0;i<c.getSize();i++){
				text2=text2+" ID Customer "+c.getCustomerNumber(i).getId()+"("+c.getCustomerNumber(i).getService()+")   ;";
			}
		this.text=this.text+text2+"\n\n";
	}
	
	public String getText(){
		
		if(peakHour) this.text="It's peak hour !!!!"+"\n"+this.text;
		
		this.text="Average time of waiting "+(secondSum*1.0/j)+" ;"+"\n"+this.text;
		this.text="Average time of service "+(firstSum*1.0/i)+" ;"+"\n"+this.text;
		this.text="Average time of empty queues "+(empty*1.0/dim)+" ;"+"\n"+this.text;
		return this.text;
	}
	
	
	public void saveServiceSum(int a){
		this.firstSum+=a;
		i++;
	}
	
	public double getAverageTimeOfService(){
		return firstSum*1.0/i;
	}
	
	public void addTimeInterval(int a){
		this.j++;
		this.secondSum+=a;
	}
	
	public void reset(){
		this.firstSum=0;
		this.i=0;
	}
	
	
	public void emptyQueue(int dim){
		this.empty++;
		this.dim=dim;
	}
	
	public void setPeakHour(boolean a){
		peakHour=a;
	}
	
	public void addString(String s){
		this.text2=text2+"\n"+s;
	}
	
	public String getMessages(){
		return this.text2;
	}
	
	

}


public class Firm {

	public static void main(String[] args) {
		
		Staff poff = new Staff();
		poff.payday();

	}

}

class Staff {
	staffMember [] stafflist;
	
	public Staff() {
		stafflist = new staffMember[8];
		
		stafflist[0] = new Executive ("David","Liberation Crescent Street","0201234567","123",2423.05);
		stafflist[1] = new Employee ("Sam","Airport City","0201266567","456",1246.5);
		stafflist[2] = new Employee ("Kuru","Oxford Street","0201239997","789",1169.12);
		stafflist[3] = new Hourly ("Ernest","Kokomlemle pavillion","02441234567","963",10.55);
		stafflist[4] = new Volunt ("Linda","22 Abofun Street","0241238018");
		stafflist[5] = new Volunt ("Philip","12 kosia crescent","0201234567");
		stafflist[6] = new Commission("Jones","distance street","0208125203","852",6.25,0.2);
		stafflist[7] = new Commission("Origi","112 Anfiled Streets","0208125203","741",9.7,0.15);
		((Executive)stafflist[0]).awardBonus(500.00) ;
		((Hourly)stafflist[3]).addHours(40);
		((Hourly)stafflist[3]).addHours(40);
		((Commission)stafflist[6]).addHours(40);
		((Commission)stafflist[7]).addHours(35);
		((Commission)stafflist[6]).Sales(400);
		((Commission)stafflist[7]).Sales(950);
	}
	void payday() {
		double amount=100;
		for (int number =0; number < stafflist.length; number++) {
			System.out.println(stafflist[number]);
			
			amount = stafflist[number].pay();
			
			if(amount==0)
				System.out.println("Thank you for your Volunteer work. ALL THE BEST");
			else
				System.out.println("Amount Paid = "+amount);
			
			System.out.println("......................................................");
			System.out.println("******************************************************");
			
			
		}
	}
}
abstract class staffMember{
	protected String name;
	protected String address;
	protected String phone;
	
	staffMember(String name,String address,String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "staffMember [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	public  double pay() {
		return 0;
	}
}


class Volunteer extends staffMember{
	Volunteer(String name,String address, String phone){
		super(name,address,phone);
	}
	public double pay() {
		return 0;
	}
}

class Employee extends staffMember{
	protected String socialSecurityNumber;
	protected double payRate;
	
	Employee(String name,String address,String phone,String ssNum, double rate){
		super(name,address,phone);
		socialSecurityNumber = ssNum;
		payRate = rate;
	
	}

	@Override
	public String toString() {
		String results = super.toString();
		return results = results + "\n ssNum ; "+socialSecurityNumber;
	}
	public double pay() {
		return payRate;
	}
}

class Executive extends Employee{
	private double bonus;
	
	Executive(String name,String address,String phone,String ssNum, double rate){
		super(name,address,phone,ssNum,rate);
		bonus = 0;
		
	}
	void awardBonus(double execBonus) {
		bonus = execBonus;
	}
	public double pay() {
		double payment = super.pay() + bonus;
		bonus = 0;
		return payment;
	}
}

class Hourly extends Employee{
	protected double hoursWorked;
	
	Hourly(String name,String address,String phone,String ssNum,double hworked){
		super(name,address,phone,ssNum, hworked);
		hoursWorked = 0;
		
	}
	void addHours(int moreHours) {
		hoursWorked = hoursWorked + moreHours;
	}
	public double pay() {
		double payment = payRate * hoursWorked;
		hoursWorked = 0;
		return payment;
	}
	@Override
	public String toString() {
		return "Hourly [hoursWorked=" + hoursWorked + "]";
	}
}

class Volunt extends staffMember{
	Volunt(String name, String address, String phone) {
		super(name, address, phone);
		// TODO Auto-generated constructor stub
	}
	
	
	public double pay() {
		return 0;
	}
}

class Commission extends Hourly{
	private double totalSales;
	private double comRate;
	
	Commission(String name,String address,String phone,String ssNum, double rate,double comRate){
		super(name,address,phone,ssNum,rate);
		this.comRate = comRate;
	}
	void Sales(double tSales) {
		totalSales = tSales;
	}
	public double pay() {
		double payment = super.pay();
		payment += totalSales * comRate;
		return payment;
	}
	@Override
	public String toString() {
		return "Commission [totalSales=" + totalSales + ", comRate=" + comRate + "]";
	}
}
	
	
	


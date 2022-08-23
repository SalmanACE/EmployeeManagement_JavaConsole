package demo1;
import java.util.*;
class Employee
{
	private int empNo;
	private int empID=0;
	private String empName;
	private float empSalary;
	private String empType;
	private String password;
	Employee(int empID, int empNo, String empName, float empSalary, String empType, String password)
	{
		this.empID=empID;
		this.empNo = empNo;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empType = empType;
		this.password = encrpt(password);
	}
	String encrpt(String a)
	{
		String s1="";
		char ps[] = a.toCharArray();
		
		for(int i=0;i<ps.length;i++)
		    s1 = s1 + ++ps[i];
		
		return s1;
	}
	public int getEmpNo()
	{
		return empNo;
	}
	public String getEmpName()
	{
		return empName;
	}
	public float getEmpSalary()
	{
		return empSalary;
	}
	public String getEmpType()
	{
		return empType;
	}
	public String getPassword()
	{
		String a = password; 
		String s1="";
		char ps[] = a.toCharArray();
		
		for(int i=0;i<ps.length;i++)
		    s1 = s1 + --ps[i];
		
		return s1;
	}
	public String toString()
	{
		return empID+" "+empNo+" "+empName+" "+empSalary+" "+empType+" "+password;
	}
}
public class Main {
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		int choice;
		Scanner s1 =  new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		int empId=0;
		List<Employee> list = new ArrayList<Employee>(); 
		Employee e = new Employee(0,999,"Salman",24578.0f,"Admin","salman");
		for(;;)
		{
			System.out.print("Enter Your No :");
			int No = s1.nextInt();
			System.out.print("Enter Your password :");
			String password =  s2.nextLine();
			if( No == e.getEmpNo() && password.equals(e.getPassword()) )
			{
				do
				{
					System.out.println("1. Add Employee data");
					System.out.println("2. view Employee data");
					System.out.println("3. Search Employee data");
					System.out.println("4. Delete Employee Employee data");
					System.out.println("5. Update Employee Employee data");
					System.out.println("0. To Log Out of the Application");
					System.out.print("Enter your choice : ");
					Iterator<Employee> itr = list.iterator();
					choice =s1.nextInt();
					switch(choice)
					{
						case 1:
							System.out.print("Enter Employee No : ");
							int empNo = s1.nextInt();
							System.out.print("Enter Employee Name : ");
							String empName = s2.nextLine();
							System.out.print("Enter Employee Salary : ");
							float empSalary = s1.nextFloat();
							System.out.print("Enter Employee Type : ");
							String empType = s2.nextLine();
							list.add(new Employee(++empId,empNo, empName, empSalary,empType,empName+empNo));
							break;
						case 2:
							System.out.println("----------------------------------");
							
							while(itr.hasNext())	
							{
								Employee e1 = itr.next();
								System.out.println(e1);
							}
							System.out.println("----------------------------------");
							break;
						case 3:
							System.out.print("Enter the Employee No to be searched :");
							int temp=s1.nextInt();
							System.out.println("----------------------------------");
							int flag=0;
							while(itr.hasNext())	
							{
								Employee e1 = itr.next();
								if(temp== e1.getEmpNo())
								{
									System.out.println("Data Found :"+e);
									flag=1;
								}
							}
							if(flag==0)
								System.out.println("Employee Not Found");	
							System.out.println("----------------------------------");
							break;
						case 4:
							System.out.print("Enter the Employee No to be deleted :");
							int temp1=s1.nextInt();
							System.out.println("----------------------------------");
							int flag1=0;
							while(itr.hasNext())	
							{
								Employee e1 = itr.next();
								if(temp1== e1.getEmpNo())
								{
									itr.remove();
									flag1=1;
								}
							}
							if(flag1==0)
								System.out.println("Employee Not Found");
							else
								System.out.println("Employee Data deleted");
							System.out.println("----------------------------------");
							break;
						case 5:
							System.out.print("Enter the Employee No to be Updated :");
							temp1=s1.nextInt();
							System.out.println("----------------------------------");
							flag1=0;
							ListIterator<Employee> li = list.listIterator();
							while(li.hasNext())	
							{
								Employee e1 = li.next();
								if(temp1== e1.getEmpNo())
								{
									System.out.print("Enter Employee Name :");
									String name = s2.nextLine();
									System.out.print("Enter Employee Salary:");
									float salary = s1.nextFloat();
									System.out.print("Enter Employee Type :");
									String type = s2.nextLine();
									li.set(new Employee(empId,temp1,name, salary, type,name+temp1));
									flag1=1;
								}
							}
							if(flag1==0)
								System.out.println("Employee Not Found");
							else
								System.out.println("Employee Data Updated");
							System.out.println("----------------------------------");
							break;
					}
				}while(choice!=0);
				break;
			}
			else
			{
				System.out.println("Wrong ID or Password");
			}
		}
	}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Mainframe extends Frame implements ActionListener
{
ImageIcon img=new ImageIcon("Stockz.png");
JLabel l=new JLabel("",img,JLabel.CENTER);
MenuBar mb=new MenuBar();
Menu m1=new Menu("login");
Menu m2=new Menu("Customer Details");
Menu m3=new Menu("Employee Details");
Menu m4=new Menu("Attendence Details");
Menu m5=new Menu("Stock Details");
Menu m6=new Menu("Purchase Details");
Menu m7=new Menu("Sale Details");
Menu m8=new Menu("Reports");
MenuItem m1i1=new MenuItem("Create New User");
MenuItem m1i2=new MenuItem("Login/Sign in");
MenuItem m1i3=new MenuItem("Change password");
MenuItem m1i4=new MenuItem("Exit");
MenuItem m2i1=new MenuItem("New Customer Details");
MenuItem m2i2=new MenuItem("Update Customer Details");
MenuItem m3i1=new MenuItem("new Employee Details");
MenuItem m3i2=new MenuItem("update Employee Details");
MenuItem m4i1=new MenuItem("Mark Attendence");
MenuItem m4i2=new MenuItem("Update Attendence");
MenuItem m4i3=new MenuItem("Salary Generation");
MenuItem m5i1=new MenuItem("New Item");
MenuItem m5i2=new MenuItem("Modify Item");
MenuItem m6i1=new MenuItem("Purchase");
MenuItem m7i1=new MenuItem("Bill Generation");
MenuItem m8i1=new MenuItem("All Customer Details");
MenuItem m8i2=new MenuItem("All Employee Details");
MenuItem m8i3=new MenuItem(" Stock Details");
MenuItem m8i4=new MenuItem("Purchase Details");
MenuItem m8i5=new MenuItem("Sale Details");
Font fo=new Font("",1,16);
Mainframe()
{
setLayout(null);
setSize(1000,800);
setLocationRelativeTo(null);
setTitle("Stockz");
setResizable(false);
//mb.setBackground(Color.green);
addWindowListener(new WindowAdapter()
{
	public void windowClosing(WindowEvent e)
		{
			dispose();
		}
});
setMenuBar(mb);
mb.add(m1);
mb.add(m2);
mb.add(m3);
mb.add(m4);
mb.add(m5);
mb.add(m6);
mb.add(m7);
mb.add(m8);
m1.add(m1i1);
m1.add(m1i2);
m1.add(m1i3);
m1.add(m1i4);
m2.add(m2i1);
m2.add(m2i2);
m3.add(m3i1);
m3.add(m3i2);
m4.add(m4i1);
m4.add(m4i2);
m4.add(m4i3);
m5.add(m5i1);
m5.add(m5i2);
m6.add(m6i1);
m7.add(m7i1);
m8.add(m8i1);
m8.add(m8i2);
m8.add(m8i3);
m8.add(m8i4);
m8.add(m8i5);
mb.setFont(fo);
l.setBounds(0,0,1000,800);add(l);
m1i1.addActionListener(this);
m1i2.addActionListener(this);
m1i3.addActionListener(this);
m1i4.addActionListener(this);
m2i1.addActionListener(this);
m2i2.addActionListener(this);
m3i1.addActionListener(this);
m3i2.addActionListener(this);
m4i1.addActionListener(this);
m4i2.addActionListener(this);
m4i3.addActionListener(this);
m5i1.addActionListener(this);
m5i2.addActionListener(this);
m6i1.addActionListener(this);
m7i1.addActionListener(this);
m8i1.addActionListener(this);
m8i2.addActionListener(this);
m8i3.addActionListener(this);
m8i4.addActionListener(this);
m8i5.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==m8i5)
{
SaleDetails1 cd=new SaleDetails1();
}
else if(e.getSource()==m7i1)
{
Saleframe f=new Saleframe();
f.setVisible(true);
}
else if(e.getSource()==m4i3)
{
Salaryslipgeneration f=new Salaryslipgeneration();
f.setVisible(true);
}
else if(e.getSource()==m1i1)
{
Newu f=new Newu();
f.setVisible(true);
}
else if(e.getSource()==m6i1)
{
PurchaseItem f=new PurchaseItem();
f.setVisible(true);
}
else if(e.getSource()==m5i2)
{
StockModify f=new StockModify();
f.setVisible(true);
}
if(e.getSource()==m5i1)
{
NewStock f=new NewStock();
f.setVisible(true);
}
else if(e.getSource()==m4i2)
{
modatt a=new modatt();
a.setVisible(true);
}
else if(e.getSource()==m4i1)
{
NewAttendence f=new NewAttendence();
f.setVisible(true);
}
else if(e.getSource()==m3i2)
{
EmployeeModify f=new EmployeeModify();
f.setVisible(true);
}
else if(e.getSource()==m3i1)
{
NewEmployee f=new NewEmployee();
f.setVisible(true);
}
if(e.getSource()==m2i2)
{
CustomerModify f=new CustomerModify();
f.setVisible(true);
}
else if(e.getSource()==m2i1)
{
NewCustomer f=new NewCustomer();
f.setVisible(true);
}
if(e.getSource()==m8i5)// for sale reports
{

}
/*if(e.getSource()==m2i1);// for new customer
{

}*/
else if(e.getSource()==m8i4)
{
PurchaseDetails1 cd=new PurchaseDetails1();
}
else if(e.getSource()==m8i3)
{
StockDetails1 cd=new StockDetails1();
}
else if(e.getSource()==m8i2)
{
EmployeeDetails1 cd=new EmployeeDetails1();
}
else
if(e.getSource()==m8i1)
{
CustomerDetails1 cd=new CustomerDetails1();

}


else if(e.getSource()==m1i3)
{
FrameCPWD f=new FrameCPWD();
}
else if(e.getSource()==m1i4)
{
dispose();
}

}
}
class Stockzz
{
public static void main(String args[])
{
Mainframe f=new Mainframe();
f.setVisible(true);
}
}
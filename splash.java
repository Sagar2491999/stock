import java.awt.*;
import javax.swing.*;
class Splashframe extends Frame
{
ImageIcon img=new ImageIcon("Splashpic.png");
JLabel il=new JLabel("",img,JLabel.CENTER);
JLabel l1=new JLabel("WELCOME IN STOCKZ.....");
JLabel l2=new JLabel("Developed By Sagar,Tarang,Aayush,Manish....");
JProgressBar jp=new JProgressBar(0,2000);
Font fo=new Font("",2,45);
Font fn=new Font("",2,23);
int i=0,num=0;
Splashframe()
{
setLayout(null);
setSize(950,800);
setLocationRelativeTo(null);
//setResizable(false);
setBackground(Color.WHITE);
setUndecorated(true);
il.setBounds(350,110,230,230);add(il);
l1.setBounds(220,350,600,50);add(l1);
l1.setBackground(Color.WHITE);
l1.setForeground(Color.BLACK);
l1.setFont(fo);add(l1);
l2.setBounds(450,720,500,40);add(l2);
l2.setBackground(Color.GREEN);
l2.setForeground(Color.BLUE);
l2.setFont(fn);add(l2);
jp.setBounds(50,450,850,30);add(jp);
jp.setValue(0);
jp.setStringPainted(true);
add(jp);



}
 public void iterate()
{
while(i<=2000)
{
jp.setValue(i);
i=i+50;
try
{
Thread.sleep(150);
}
catch(Exception e)
{
System.out.print(e);
}
}

Logframe f1=new Logframe();
f1.setVisible(true);
dispose();
}
}
class splash
{
public static void main(String args[])
{
Splashframe f=new Splashframe();
f.setVisible(true);
f.iterate();
}
}
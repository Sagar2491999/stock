import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

class NewCustomer extends Frame implements ActionListener, WindowListener
{
   Label l1=new Label("Customer Details");
   Label l2=new Label("Customer ID :-");   
   Label l3=new Label("Customer Name :-");
   Label l4=new Label("Shop Name :-");
   Label l5=new Label("Address :-");
   Label l6=new Label("Ph.Number :-");

   TextField t1=new TextField("");
   TextField t2=new TextField("");
   TextField t3=new TextField("");
   TextArea ta=new TextArea("");
   TextField t4=new TextField("");

   Button b1=new Button("Add To Cart");
   Button b2=new Button("Reset");
   Button b3=new Button("submit");
   Button b4=new Button("Delete");

   Font f1=new Font ("Arial",Font.BOLD,30);
    Font f2=new Font ("Arial",Font.PLAIN,18);
    
    Connection con;
    PreparedStatement st;
    ResultSet rs;
    int cid,pno;
  String cname,sn,addr;
    JTable jt;
    DefaultTableModel model;
    String
    heads[]={"Customer ID","Customer Name","Shop Name","Address","Ph.Number"};
  
  
                

NewCustomer()
{
	setSize(1100,800);
	setLocationRelativeTo(null);
	setLayout(null);
	setResizable(false);
	addWindowListener(this);
	l1.setForeground(Color.GREEN);


    l1.setBounds(150,50,250,30);add(l1);l1.setFont(f1);
    l2.setBounds(50,120,150,30);add(l2);l2.setFont(f2);
    l3.setBounds(50,180,150,30);add(l3);l3.setFont(f2);
    l4.setBounds(50,240,150,30);add(l4);l4.setFont(f2);
    l5.setBounds(50,300,150,30);add(l5);l5.setFont(f2);
    l6.setBounds(50,380,150,30);add(l6);l6.setFont(f2);
        t1.setBounds(230,120,200,30);add(t1);t1.setFont(f2);
        t2.setBounds(230,180,200,30);add(t2);t2.setFont(f2);
        t3.setBounds(230,240,200,30);add(t3);t3.setFont(f2);
        ta.setBounds(230,300,200,60);add(ta);ta.setFont(f2);
        t4.setBounds(230,380,200,30);add(t4);t4.setFont(f2);
            b1.setBounds(110,520,100,30);add(b1);b1.setFont(f2);
            b1.addActionListener(this);
            b2.setBounds(240,520,100,30);add(b2);b2.setFont(f2);
            b2.addActionListener(this);
            b3.setBounds(570,620,100,30);add(b3);b3.setFont(f2);
            b3.addActionListener(this);
            b4.setBounds(700,620,100,30);add(b4);b4.setFont(f2);
            b4.addActionListener(this);
            

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost/bca","root","");

            }
            catch(Exception e)
            {
                System.out.print(e);
            }

                model=new DefaultTableModel();
                 model.setColumnIdentifiers(heads);
                 jt=new JTable();
                 jt.setModel(model);
	model.setColumnIdentifiers(heads);
                JScrollPane scroll=new JScrollPane(jt);
	jt.setModel(model);
                 scroll.setBounds(500,40,550,550);add(scroll);

                
}    


            
public void windowOpened(WindowEvent we)
{
}

public void windowActivated(WindowEvent we)
{
}
 
public void windowDeactivated(WindowEvent we)
{
}

public void windowIconified(WindowEvent we)
{
}

public void windowDeiconified(WindowEvent we)
{
}

public void windowClosed(WindowEvent we)
{
}

public void windowClosing(WindowEvent we)
{
dispose();
}


                 public void actionPerformed(ActionEvent ae)

     

                 {
                        
                      if(ae.getSource()==b4)

                    {
                        model.removeRow(jt.getSelectedRow());
                    }
                       else if(ae.getSource()==b1)
                        {
                            cid=Integer.parseInt(t1.getText());
                            cname=t2.getText();
                            sn=t3.getText();
                            addr=ta.getText();
                            pno=Integer.parseInt(t4.getText());
                        
                    model.addRow(new Object[]{cid,cname,sn,addr,pno});
                      t1.setText("er");
                        t1.setText("");
                        t2.setText("ds");
                        t2.setText("");
                        t3.setText("er");
                        t3.setText("");
                        t4.setText("gf");
                        t4.setText("");
                        ta.setText("er");
                        ta.setText("");
                        
                        t1.requestFocus();

                    
                       
                        }
            
                   else if (ae.getSource()==b2)
                    {
                        t1.setText("er");
                        t1.setText("");
                        t2.setText("ds");
                        t2.setText("");
                        t3.setText("er");
                        t3.setText("");
                        t4.setText("gf");
                        t4.setText("");
                        ta.setText("er");
                        ta.setText("");
                        
                        t1.requestFocus();


                    }

                   else if(ae.getSource()==b3)
                    {
                        for(int i=0;i<model.getRowCount();i++)
                        {
                            cid=Integer.parseInt(model.getValueAt(i,0).toString());
                            cname=model.getValueAt(i,1).toString();
                            sn=model.getValueAt(i,2).toString();
                            addr=model.getValueAt(i,3).toString();
                            pno=Integer.parseInt(model.getValueAt(i,4).toString());


                                try
                                {
                                        st=con.prepareStatement("insert into custinfo values(?,?,?,?,?)");
                                        st.setInt(1,cid);
                                        st.setString(2,cname);
                                        st.setString(3,sn);
                                        st.setString(4,addr);
	                       st. setInt(5,pno);
               	          st.executeUpdate();                 
                                
                                 }

                                 catch(Exception e)
                                 
                                 {
                                     System.out.print(e);
                                 }
                               
                        }
                         JOptionPane.showMessageDialog(null,"All Customer Add Successfully");
                                model.setRowCount(0);
		t1.setText("er");
                        t1.setText("");
                        t2.setText("ds");
                        t2.setText("");
                        t3.setText("er");
                        t3.setText("");
                        t4.setText("gf");
                        t4.setText("");
                        ta.setText("er");
                        ta.setText("");
                        
                        t1.requestFocus();



                        }
                               
                 }


                    }


	class customer
	{
	    public static void main(String [] args)
		
	{
		NewCustomer f=new NewCustomer();
		f.setVisible(true);


	}
	}
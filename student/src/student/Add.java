package student;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class Add extends JFrame implements ActionListener{
	static Add s;
	/*添加学生信息控件*/
	JPanel jpl = new JPanel();
	JLabel label1 = new JLabel("添加学生信息",JLabel.CENTER);
	JLabel label2 = new JLabel("学号：",JLabel.CENTER);
	JLabel label3 = new JLabel("姓名：",JLabel.CENTER);
	JLabel label4 = new JLabel("性别：",JLabel.CENTER);
	JLabel label5 = new JLabel("班级：",JLabel.CENTER);
	JLabel label6 = new JLabel("生日：",JLabel.CENTER);
	JLabel label7 = new JLabel("政治面貌：",JLabel.CENTER);
	JLabel label8 = new JLabel("入学年份：",JLabel.CENTER);
	JLabel label9 = new JLabel("入学成绩：",JLabel.CENTER);
	JLabel labelA = new JLabel("联系方式：",JLabel.CENTER);
	JLabel labelB = new JLabel("家庭住址：",JLabel.CENTER);
//	JLabel labelC = new JLabel("备注信息：",JLabel.CENTER);
	
	JTextField ID = new JTextField(2);
	JTextField name = new JTextField(4);
	JTextField sex = new JTextField();
	JTextField classID = new JTextField();
	JTextField birth = new JTextField();
	JTextField nation = new JTextField();
	JTextField year = new JTextField();
	JTextField grade = new JTextField();
	JTextField phone = new JTextField();
	JTextField address = new JTextField();
	
	JButton reset = new JButton("重置");
	JButton addmsg = new JButton("添加");

	public Add()
	{
		super("添加学生信息");
		this.setResizable(false);
		this.setSize(500,600);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jpl);
		this.setLocationRelativeTo(null);
		jpl.setLayout(null);
		addmsg.addActionListener(this);
		reset.addActionListener(this);
		/*插入面板*/
		label1.setBounds(100,20,300,20);
		jpl.add(label1);
		
		label2.setBounds(100,50,70,20);
		jpl.add(label2);
		ID.setBounds(190,50,140,20);
		jpl.add(ID);
		
		label3.setBounds(100,90,70,20);
		jpl.add(label3);
		name.setBounds(190,90,140,20);
		jpl.add(name);
		
		label4.setBounds(100,130,70,20);
		jpl.add(label4);
		sex.setBounds(190,130,140,20);
		jpl.add(sex);
		
		label5.setBounds(100,170,70,20);
		jpl.add(label5);
		classID.setBounds(190,170,140,20);
		jpl.add(classID);
		
		label6.setBounds(100,210,70,20);
		jpl.add(label6);
		birth.setBounds(190,210,140,20);
		jpl.add(birth);
		
		label7.setBounds(100,250,70,20);
		jpl.add(label7);
		nation.setBounds(190,250,140,20);
		jpl.add(nation);
		
		label8.setBounds(100,290,70,20);
		jpl.add(label8);
		year.setBounds(190,290,140,20);
		jpl.add(year);
		

		label9.setBounds(100,330,70,20);
		jpl.add(label9);
		grade.setBounds(190,330,140,20);
		jpl.add(grade);
		
		labelA.setBounds(100,370,70,20);
		jpl.add(labelA);
		phone.setBounds(190,370,140,20);
		jpl.add(phone);
		
		labelB.setBounds(100,410,70,20);
		jpl.add(labelB);
		address.setBounds(190,410,140,20);
		jpl.add(address);
		
		
		reset.setBounds(120,450,90,20);
		addmsg.setBounds(240,450,90,20);
		jpl.add(reset);
		jpl.add(addmsg);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addmsg)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}
			catch (ClassNotFoundException ce)
			{
				JOptionPane.showMessageDialog(s,ce.getMessage());
			}
			try
			{
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Student","sa","123");
	            Statement stmt=conn.createStatement();
				int a = stmt.executeUpdate("insert into information(ID , name , sex , classID ,birth , nation , year , grade , phone , address)values('"+ID.getText()+"','"+name.getText()+"','"+sex.getText()+"','"+classID.getText()+"'," +
						"'"+birth.getText()+"','"+nation.getText()+"','"+year.getText()+"'," +
						"'"+grade.getText()+"','"+phone.getText()+"','"+address.getText()+"')");
				System.out.println(a);
				if(a==1)
				{
					JOptionPane.showMessageDialog(s,"已成功添加", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(s,"添加失败", "提示", JOptionPane.ERROR_MESSAGE);
				}
				stmt.close();
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(s,se.getMessage());
				se.printStackTrace();
			}
		}
		else
		{
			ID.setText("");
			name.setText("");
			sex.setText("");
			classID.setText("");
			birth.setText("");
			nation.setText("");
			year.setText("");
			grade.setText("");
			phone.setText("");
			address.setText("");
			ID.requestFocus();
		}
	}

	public static void main(String[] args)
	{
		Add amg = new Add();
	}
}
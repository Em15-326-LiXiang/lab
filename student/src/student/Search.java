package student;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class Search extends JFrame implements ActionListener{
	
	/*查询学生信息控件*/
	static Search s;
	JPanel jpl = new JPanel();
	JLabel SCH = new JLabel("查询学生信息",JLabel.CENTER);
	JLabel label1 = new JLabel("输入学号：",JLabel.CENTER);
	JButton serch = new JButton("查询");
	JLabel label3 = new JLabel("姓名：",JLabel.CENTER);
	JLabel label4 = new JLabel("性别：",JLabel.CENTER);
	JLabel label5 = new JLabel("班级：",JLabel.CENTER);
	JLabel label6 = new JLabel("生日：",JLabel.CENTER);
	JLabel label7 = new JLabel("政治面貌：",JLabel.CENTER);
	JLabel label8 = new JLabel("入学年份：",JLabel.CENTER);
	JLabel label9 = new JLabel("入学成绩：",JLabel.CENTER);
	JLabel labelA = new JLabel("联系方式：",JLabel.CENTER);
	JLabel labelB = new JLabel("家庭住址：",JLabel.CENTER);
	
	JTextField sex = new JTextField();
	JTextField ID = new JTextField(2);
	JTextField name = new JTextField(4);
	JTextField classID = new JTextField();
	JTextField birth = new JTextField();
	JTextField nation = new JTextField();
	JTextField year = new JTextField();
	JTextField grade = new JTextField();
	JTextField phone = new JTextField();
	JTextField address = new JTextField();
	
	JButton reset = new JButton("重置");

	public Search()
	{
		this.setSize(500,600);
		this.setTitle("查询学生信息");
		this.setVisible(true);
		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(jpl);
		jpl.setLayout(null);
		serch.addActionListener(this);
		reset.addActionListener(this);
		/*查询面板*/
		SCH.setBounds(100,20,300,20);
		jpl.add(SCH);
		
		label1.setBounds(100,60,100,20);
		jpl.add(label1);
		ID.setBounds(190,60,140,20);
		jpl.add(ID);
		
		serch.setBounds(120,100,90,20);
		reset.setBounds(260,100,90,20);
		jpl.add(serch);
		jpl.add(reset);
		
		label3.setBounds(100,140,70,20);
		jpl.add(label3);
		name.setBounds(190,140,140,20);
		jpl.add(name);
		
		label4.setBounds(100,180,70,20);
		jpl.add(label4);
		sex.setBounds(190,180,140,20);
		jpl.add(sex);
		
		label5.setBounds(100,220,70,20);
		jpl.add(label5);
		classID.setBounds(190,220,140,20);
		jpl.add(classID);
		
		label6.setBounds(100,260,70,20);
		jpl.add(label6);
		birth.setBounds(190,260,140,20);
		jpl.add(birth);
		
		label7.setBounds(100,300,70,20);
		jpl.add(label7);
		nation.setBounds(190,300,140,20);
		jpl.add(nation);
		
		label8.setBounds(100,340,70,20);
		jpl.add(label8);
		year.setBounds(190,340,140,20);
		jpl.add(year);
		

		label9.setBounds(100,380,70,20);
		jpl.add(label9);
		grade.setBounds(190,380,140,20);
		jpl.add(grade);
		
		labelA.setBounds(100,420,70,20);
		jpl.add(labelA);
		phone.setBounds(190,420,140,20);
		jpl.add(phone);
		
		labelB.setBounds(100,460,70,20);
		jpl.add(labelB);
		address.setBounds(190,460,140,20);
		jpl.add(address);

	}

	public void actionPerformed(ActionEvent e)
	{
		String id = ID.getText();
		if(e.getSource()==serch)//查询
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
				ResultSet rs = stmt.executeQuery("select * from information where ID = '" + id + "'");
				if(rs.next())
				{
					ID.setText(rs.getString("ID"));
					name.setText(rs.getString("name"));
					sex.setText(rs.getString("sex"));
					classID.setText(rs.getString("classID"));
					birth.setText(rs.getString("birth"));
					nation.setText(rs.getString("nation"));
					year.setText(rs.getString("year"));
					grade.setText(rs.getString("grade"));
					phone.setText(rs.getString("phone"));
					address.setText(rs.getString("address"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "没有该学号、请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
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
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(s,se.getMessage());
			}
		}
		else	//重置
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
		Search sch = new Search();
	}
}
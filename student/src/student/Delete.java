package student;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

public class Delete extends JFrame implements ActionListener{
	
	/*查询学生信息控件*/
	static Delete d;
	JPanel jpl = new JPanel();
	JLabel Del = new JLabel("删除学生信息",JLabel.CENTER);
	JLabel label1 = new JLabel("请输入学号：",JLabel.CENTER);
	JButton dele = new JButton("删除");
	JTextField ID = new JTextField(2);
	
	JButton reset = new JButton("重置");

	public Delete()
	{
		this.setSize(400,200);
		this.setTitle("删除界面");
		this.setVisible(true);
		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(jpl);
		jpl.setLayout(null);
		dele.addActionListener(this);
		dele.addActionListener(this);
		/*查询面板*/
		Del.setBounds(20,20,300,20);
		jpl.add(Del);
		
		label1.setBounds(60,60,100,20);
		jpl.add(label1);
		ID.setBounds(190,60,140,20);
		jpl.add(ID);
		
		dele.setBounds(120,100,90,20);
		reset.setBounds(260,100,90,20);
		jpl.add(dele);
		jpl.add(reset);
		

	}

	public void actionPerformed(ActionEvent e)
	{
		String id = ID.getText();
		if(e.getSource()==dele)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			}
			catch (ClassNotFoundException ce)
			{
				JOptionPane.showMessageDialog(d,ce.getMessage());
			}
			try
			{
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Student","sa","123");
	            Statement stmt=conn.createStatement();
				int i=stmt.executeUpdate("delete  from information where ID = '" + id + "'");
				if(i==1){
					JOptionPane.showMessageDialog(d,"删除学生记录成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(d,"没有该学号、请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
					ID.setText("");
					ID.requestFocus();
				}
				stmt.close();
			}
			catch (SQLException se)
			{
				JOptionPane.showMessageDialog(d,se.getMessage());
			}
		}
		else	//重置
		{
			ID.setText("");
			ID.requestFocus();
		}
	}

	public static void main(String[] args)
	{
		Delete dl = new Delete();
	}
}
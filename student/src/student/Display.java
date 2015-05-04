package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.table.JTableHeader;
public class Display extends JFrame {
    String []str={"ID","name","sex","classID","birth","nation","year","grade","phone","address"};
    Object[][] data;
    JTable table;
    JTableHeader head;
    JScrollPane jsp;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Display(){
        super("浏览数据");
        setSize(1000,500); 
        int i=0,j=0;
        int row;
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Connection conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Student","sa","123");
            Statement stmt=conn.createStatement();
            
            rs=stmt.executeQuery("select COUNT(*) as a from information");
            rs.next();
            row=rs.getInt("a");
            rs.close();
            data=new Object[row][10];
            rs=stmt.executeQuery("select * from information");
            while(rs.next()){
                data[i][j++]=rs.getString("ID");
                data[i][j++]=rs.getString("name");
                data[i][j++]=rs.getString("sex");
                data[i][j++]=rs.getString("classID");
                data[i][j++]=rs.getString("birth");
                data[i][j++]=rs.getString("nation");
                data[i][j++]=rs.getString("year");
                data[i][j++]=rs.getString("grade");
                data[i][j++]=rs.getString("phone");
                data[i][j++]=rs.getString("address");
                i++;j=0;
            }
            table=new JTable(data,str);
            head=table.getTableHeader();
            jsp=new JScrollPane(table);
            getContentPane().add(head,"North");
            getContentPane().add(jsp,"Center");
            rs.close();
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
	public static void main(String[] args) {
        new Display();
    }
}
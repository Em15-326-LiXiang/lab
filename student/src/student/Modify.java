package student;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Modify extends JFrame implements ActionListener{
	
    Connection cnn;
    Statement stm;
    ResultSet rs;
    
    
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
   
    JTextField ID = new JTextField(12);
	JTextField name = new JTextField(12);
	JTextField sex = new JTextField(12);
	JTextField classID = new JTextField(12);
	JTextField birth = new JTextField(12);
	JTextField nation = new JTextField(12);
	JTextField year = new JTextField(12);
	JTextField grade = new JTextField(12);
	JTextField phone = new JTextField(12);
	JTextField address = new JTextField(12);
	
	
    JButton btnModify=new JButton("修改");
    JButton btnCancel=new JButton("取消");
    JButton btnQuery=new JButton("查询");
    
    JPanel pan=new JPanel();
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();
    JPanel pan4=new JPanel();
    JPanel pan5=new JPanel();
    JPanel pan6=new JPanel();
    JPanel pan7=new JPanel();
    JPanel pan8=new JPanel();
    JPanel pan9=new JPanel();
    JPanel pan10=new JPanel();
    JPanel pan11=new JPanel();
    
    
    Modify(){
    	
        super("修改学生信息");
        
        setSize(500,600);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        pan.setBorder(BorderFactory.createEtchedBorder());
        pan1.add(label2);
        pan1.add(ID);
        pan2.add(label3);
        pan2.add(name);
        pan3.add(label4);
        pan3.add(sex);
        pan4.add(label5);
        pan4.add(classID);
        pan5.add(label6);
        pan5.add(birth);
        pan6.add(label7);
        pan6.add(nation);
        pan7.add(label8);
        pan7.add(year);
        pan8.add(label9);
        pan8.add(grade);
        pan9.add(labelA);
        pan9.add(phone);
        pan10.add(labelB);
        pan10.add(address);
        
        
        
        pan11.add(btnQuery);
        pan11.add(btnModify);
        pan11.add(btnCancel);
        pan.setLayout(new GridLayout(10,5));
        pan.add(pan1);
        pan.add(pan2);
        pan.add(pan3);
        pan.add(pan4);
        pan.add(pan5);
        pan.add(pan6);
        pan.add(pan7);
        pan.add(pan8);
        pan.add(pan9);
        pan.add(pan10);

        
        getContentPane().add(pan,"Center");
        getContentPane().add(pan11,"South");
        btnQuery.addActionListener(this);
        btnModify.addActionListener(this);
        btnCancel.addActionListener(this);
        btnModify.setEnabled(false);
        name.setEditable(false);
        sex.setEditable(false);
        classID.setEditable(false);
        birth.setEditable(false);
        nation.setEditable(false);
        year.setEditable(false);
        grade.setEditable(false);
        phone.setEditable(false);
        address.setEditable(false);
        
        setVisible(true);
        ID.requestFocus();
        
    }
    public void actionPerformed(ActionEvent ae){
    	String id = ID.getText();
    	
        if(ae.getSource()==btnCancel){
            try {
                if(stm!=null)
                    stm.close();
                if(cnn!=null)
                    cnn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        } else if(ae.getSource()==btnQuery){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	            Connection cnn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Student","sa","123");
	            Statement stmt=cnn.createStatement();

                rs=stmt.executeQuery("select * from information where ID='"+id+"'");
                if(rs.next()){
                	btnModify.setEnabled(true);
                    name.setEditable(true);
                    sex.setEditable(true);
                    classID.setEditable(true);
                    birth.setEditable(true);
                    nation.setEditable(true);
                    year.setEditable(true);
                    grade.setEditable(true);
                    phone.setEditable(true);
                    address.setEditable(true);
                    
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
                else{
                	JOptionPane.showMessageDialog(null, "不存在该记录！", "提示", JOptionPane.ERROR_MESSAGE);

                    btnModify.setEnabled(false);
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
                    name.setEditable(false);
                    sex.setEditable(false);
                    classID.setEditable(false);
                    birth.setEditable(false);
                    nation.setEditable(false);
                    year.setEditable(false);
                    grade.setEditable(false);
                    phone.setEditable(false);
                    address.setEditable(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==btnModify){
            try{
            	 DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
 	            Connection cnn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Student","sa","123");
            	Statement stmt=cnn.createStatement();
            	
                System.out.println("Update  information set name="+name.getText()+",sex="+sex.getText()+",classID="+classID.getText()+",birth="+birth.getText()+",nation="+nation.getText()+",year="+year.getText()+",grade="+grade.getText()+",phone="+phone.getText()+",address="+address.getText()+" where ID='"+ID.getText()+"'");
                stmt.executeUpdate("Update  information set name='"+name.getText()+"',sex='"+sex.getText()+"',classID='"+classID.getText()+"',birth='"+birth.getText()+"',nation='"+nation.getText()+"',year='"+year.getText()+"',grade='"+grade.getText()+"',phone='"+phone.getText()+"',address='"+address.getText()+"' where ID='"+ID.getText()+"'");
                
                JOptionPane.showMessageDialog(null, "记录修改完毕！", "提示", JOptionPane.INFORMATION_MESSAGE);
                
                btnModify.setEnabled(false);
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
                
                name.setEditable(false);
                sex.setEditable(false);
                classID.setEditable(false);
                birth.setEditable(false);
                nation.setEditable(false);
                year.setEditable(false);
                grade.setEditable(false);
                phone.setEditable(false);
                address.setEditable(false);
                
                stmt.close();
                cnn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args) {
        new Modify();
    }
}
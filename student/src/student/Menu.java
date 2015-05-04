package student;

import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import	java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import	java.awt.event.WindowAdapter;

import	java.awt.event.WindowEvent;


public class Menu {

	JFrame jf;
	JButton j1,j2, j3, j4, j5,j6;
	 public	static	void	main(String	args[]){
		 Menu	m =new	Menu();
		 m.go();
	 }
	 
	 public	void	go(){
		 jf=new	JFrame("学生学籍管理系统");
		 jf.setBounds(200, 200, 300, 200);
		 Container	cp=jf.getContentPane();
		 
		 cp.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		 
		 j1=new	JButton("添加学生信息");
		 j2=new	JButton("修改学生信息");
		 j3=new	JButton("查询学生信息");
		 j4=new	JButton("删除学生信息");
		 j5=new	JButton("显示学生信息");
		 j6=new	JButton("退出管理系统");

		 cp.add(j1);
		 cp.add(j2);
		 cp.add(j3);
		 cp.add(j4);
		 cp.add(j5);
		 cp.add(j6);
		 
		j1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
//				jf.dispose();
				new Add();
				
				}
			});
		
		j2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				jf.dispose();
				Modify modify=new Modify();
			}
		});
		
		j3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				jf.dispose();
				Search search=new Search();
			}
		});
		
		j4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				jf.dispose();
				Delete delete=new Delete();
			}
		});
		
		j5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				jf.dispose();
				Display display=new Display();
			}
		});
		
		j6.addActionListener(new ActionListener(){			
//			ActionListener接收动作事件的监听器接口。
//			在处理动作事件感兴趣的类实现这个接口，这个类创建的对象注册一个组件，使用组件的addActionListener方法。
//			动作事件发生时，该对象的actionPerformed方法被调用。
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
		 
		 jf.setVisible(true);
//		 jf.setLocationRelativeTo(null);
//		 jf.setLocationRelativeTo(null)是用来使窗口显示在屏幕正中间
	 }

	

}
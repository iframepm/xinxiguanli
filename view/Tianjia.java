package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import dbutil.ConnectionUtil;

public class Tianjia extends JDialog{
	
	public int tempnum = 1;
	String code = "";
	String name = "";
	String sex = "";
	String age = "";
	String apartment = "";
	String classes = "";
	String jointime = "";
	String jidian = "";
	String gaokao = "";
	String qimo = "";

	JLabel lab0 = new JLabel("学生编号:");	//
	JLabel lab1 = new JLabel("姓名:");//姓名
	JLabel lab2 = new JLabel("性别:");//性别
	JLabel lab3 = new JLabel("年龄:");//年龄
	JLabel lab4 = new JLabel("入学时间:");
	JLabel lab5 = new JLabel("班级:");
	JLabel lab6 = new JLabel("院系:");
	JLabel lab7 = new JLabel("绩点:");
	JLabel lab8 = new JLabel("高考成绩:");
	JLabel lab9 = new JLabel("期末成绩:");
	JTextField t0 = new JTextField();
	JTextField t1 = new JTextField();
//	JTextField jcb = new JTextField();
	JComboBox jcb = null;
	JTextField t3 = new JTextField();
	JTextField t4 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	JTextField t8 = new JTextField();
	JTextField t9 = new JTextField();
	
	JButton but1 = new JButton("保存");
	JButton but2 = new JButton("取消");
	Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
	public Tianjia() throws ClassNotFoundException, SQLException{
		String tempsex[] ={"男","女"}; 
		jcb = new JComboBox(tempsex);
		getendcode();
		this.setLayout(null);
		t0.setBounds(150, 100, 150, 30);	
		t1.setBounds(150, 150, 150, 30);	
		jcb.setBounds(150, 200, 150, 30);	
		t3.setBounds(150, 250, 150, 30);	
		t4.setBounds(150, 300, 150, 30);	
		
		t5.setBounds(420, 100, 150, 30);
		t6.setBounds(420, 150, 150, 30);
		t7.setBounds(420, 200, 150, 30);
		t8.setBounds(420, 250, 150, 30);
		t9.setBounds(420, 300, 150, 30);
		
		lab0.setBounds(60, 100, 90, 30);
		lab1.setBounds(60, 150, 90, 30);
		lab2.setBounds(60, 200, 90, 30);
		lab3.setBounds(60, 250, 90, 30);
		lab4.setBounds(60, 300, 90, 30);
		
		lab5.setBounds(330, 100, 90, 30);
		lab6.setBounds(330, 150, 90, 30);
		lab7.setBounds(330, 200, 90, 30);
		lab8.setBounds(330, 250, 90, 30);
		lab9.setBounds(330, 300, 90, 30);
		but1.setBounds(500, 380, 120, 30);
		but2.setBounds(360, 380, 120, 30);
		
		
		lab0.setFont(new Font("宋体",Font.BOLD,18));
		lab1.setFont(new Font("宋体",Font.BOLD,18));
		lab2.setFont(new Font("宋体",Font.BOLD,18));
		lab3.setFont(new Font("宋体",Font.BOLD,18));
		lab4.setFont(new Font("宋体",Font.BOLD,18));
		lab5.setFont(new Font("宋体",Font.BOLD,18));
		lab6.setFont(new Font("宋体",Font.BOLD,18));
		lab7.setFont(new Font("宋体",Font.BOLD,18));
		lab8.setFont(new Font("宋体",Font.BOLD,18));
		lab9.setFont(new Font("宋体",Font.BOLD,18));

		but1.setFont(new Font("宋体",Font.BOLD,18));
		but2.setFont(new Font("宋体",Font.BOLD,18));
		
		this.add(lab0);
		this.add(lab1);
		this.add(lab2);
		this.add(lab3);
		this.add(lab4);
		this.add(lab5);
		this.add(lab6);
		this.add(lab7);
		this.add(lab8);
		this.add(lab9);
		this.add(t0);
		this.add(jcb);
		this.add(t4);
		this.add(t6);
		this.add(t1);
		this.add(t8);
		this.add(t3);
		this.add(t5);		
		this.add(t7);		
		this.add(t9);
		this.add(but1);
		this.add(but2);
		this.setTitle("编辑学生信息");
		t0.setEditable(false);
		t8.setText("0");
		but2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			Zhujiemian.tj.dispose();		
			}
			
		});	
		 t7.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}
			public void removeUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}

			public void changedUpdate(DocumentEvent e) {
				if(t7.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}
			 
		 });
		 t8.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}
			public void removeUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}

			public void changedUpdate(DocumentEvent e) {
				if(t8.getText().equals("")){
					
				}else{
				t9.setText(t9.getText());
				}
			}
			 
		 });
		 t8.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					t8.setText("");
				}
				
			}
			public void mousePressed(MouseEvent e) {
	
			}

			public void mouseReleased(MouseEvent e) {	
			}

			public void mouseEntered(MouseEvent e) {
	
			}
			public void mouseExited(MouseEvent e) {
	
			}
			 
		 });
		this.setSize(660, 510);//885  715
		this.setLocation(((int) (ds.getWidth())-660)/2, ((int) (ds.getHeight())-510)/2);
		this.setVisible(true);
		this.setResizable(false);
	}
	public void addinfo() throws ClassNotFoundException, SQLException{//添加信息
		getendcode();
		 code = t0.getText();
		 name = t1.getText();
		 sex = jcb.getSelectedItem().toString();
		 age = t3.getText();
		 apartment = t6.getText();
		 classes = t5.getText();
		 jointime = t4.getText();
		 jidian = t7.getText();
		 gaokao = t8.getText();
		 qimo = t9.getText();

		 //下面是插入新数据到数据库的操作
		Connection conn = ConnectionUtil.getConnection(); 
	    Statement sta = conn.createStatement();   //执行sql语句的容器  row 行 column 列
	    String str = "insert into stuInfo (code,name,age,sex,jointime,classes,apartment,jidian,gaokao,qimo) "
	    		+ "values ("+Integer.parseInt(code)+",'"+name+"','"+Integer.parseInt(age)+"','"+
	    		sex+"','"+ jointime +
	    		"','"+classes+"','"+apartment+"',"+
	    		Float.parseFloat(jidian)+","+Float.parseFloat(gaokao)+","+Float.parseFloat(qimo)+") ";
	    sta.executeUpdate(str);	 
	    sta.close();
	    conn.close();

	}
	public void changeinfo() throws ClassNotFoundException, SQLException{//添加信息
		 int i = 0;
		 try{
			i = Zhujiemian.mpan.table.getSelectedRow();
		 }catch(Exception e){
			 
		 }
		 code = Zhujiemian.mpan.tableModel.getValueAt(i, 0).toString();
		 name = Zhujiemian.mpan.tableModel.getValueAt(i, 1).toString();
		 sex = Zhujiemian.mpan.tableModel.getValueAt(i, 2).toString();
		 age = Zhujiemian.mpan.tableModel.getValueAt(i, 3).toString();
		 apartment = Zhujiemian.mpan.tableModel.getValueAt(i, 4).toString();
		 classes = Zhujiemian.mpan.tableModel.getValueAt(i, 5).toString();
		 jointime = Zhujiemian.mpan.tableModel.getValueAt(i, 6).toString();
		 jidian = Zhujiemian.mpan.tableModel.getValueAt(i, 7).toString();
		 gaokao = Zhujiemian.mpan.tableModel.getValueAt(i, 8).toString();
		 
		 System.out.println(sex);
		 System.out.println("0:"+code+"   1:"+name+"   2:"+sex+"   3:"+age+"   4:"+apartment+"   5:"+classes+"   6:"+ jointime +"   "
		 		+ "7:"+jidian+"   8:"+gaokao);
		Connection conn = ConnectionUtil.getConnection(); 
	    Statement sta = conn.createStatement();   //执行sql语句的容器  row 行 column 列
	    String str = "insert into stuInfo (code,name,age,sex,jointime,classes,apartment,jidian,gaokao,qimo) "
	    		+ "values ("+Integer.parseInt(code)+",'"+name+"','"+Integer.parseInt(age)+"','"+
	    		sex+"','"+ jointime +
	    		"','"+classes+"','"+apartment+"',"+
	    		Float.parseFloat(jidian)+","+Float.parseFloat(gaokao)+","+Float.parseFloat(qimo)+") ";
	    sta.executeUpdate(str);	 
	    sta.close();
	    conn.close();
	}
	public int getendcode() throws ClassNotFoundException, SQLException{
		Connection conn = ConnectionUtil.getConnection(); 
	    Statement sta = conn.createStatement();   //执行sql语句的容器  row 行 column 列
	    String str = "select * from stuInfo";
	    ResultSet re = sta.executeQuery(str);   //执行完的结果赋给  ResultSet
	    tempnum=1;
	    while(re.next()){
	    	tempnum++;
	    }	    
	    sta.close();
	    conn.close();
	    t0.setText(String.valueOf(tempnum));
	    return tempnum;
	}
}































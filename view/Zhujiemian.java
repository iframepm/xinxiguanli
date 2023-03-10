package view;
//主界面
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dbutil.ConnectionUtil;

public class Zhujiemian {

	static JFrame frame = new JFrame("学生信息管理系统");
	static JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP) ;// 设置标签在左边显示
	Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();	
	public static GongJuMianBan pan1 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"1.jpg").getImage());//系统主界面
	public static GongJuMianBan pan2 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"蓝色背景.jpg").getImage());
	public static GongJuMianBan pan3 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"白色.jpg").getImage());
	static XinXiGuanLi mpan = new XinXiGuanLi();
	JButton but2 = new JButton("信息管理");
	JButton but3 = new JButton();
	JButton but8 = new JButton();
	

	String jcbitem = "";//下拉框点击后的返回值
	JLabel lab1 = new JLabel("排序方式：");
	JLabel lab2 = new JLabel("编号/姓名/院系/班级：");
	JLabel lab3 = new JLabel("编号/班级：",JLabel.LEFT);
	JTextField jtf = new JTextField();
	JTextField jtf1 = new JTextField();
	JButton but4 = new JButton("查询/刷新界面");
	JButton but5 = new JButton("添加学生");
	JButton but6 = new JButton("编辑信息");
	JButton but7 = new JButton("删除信息");
	JButton but9 = new JButton("删除信息");
	JButton but10 = new JButton("查询");

	
	JLabel t1 = new JLabel("学生信息查询系统",JLabel.CENTER);
	
	public static Tianjia tj = null;
	public static XiuGai xg = null;
	public Zhujiemian() throws ClassNotFoundException, SQLException{
		pan1.setLayout(null);
		pan2.setLayout(null);
		pan3.setLayout(null);
		jtp.add("首页",pan1);	

	
		
		//设置窗体控件的基本属性调大字体
		jtp.setFont(new Font("宋体",Font.BOLD,24));
		but2.setFont(new Font("宋体",Font.BOLD,27));
		t1.setFont(new Font("宋体",Font.BOLD,24));
		lab1.setFont(new Font("宋体",Font.PLAIN,18));
		lab2.setFont(new Font("宋体",Font.BOLD,18));
		lab3.setFont(new Font("宋体",Font.BOLD,18));
		but4.setFont(new Font("宋体",Font.BOLD,18));
		but5.setFont(new Font("宋体",Font.BOLD,15));
		but6.setFont(new Font("宋体",Font.BOLD,15));
		but7.setFont(new Font("宋体",Font.BOLD,15));
		jtf.setFont(new Font("宋体",Font.BOLD,15));
		
		
		
		//查询面板设置控件的位置
		but2.setBounds(400, 230, 148, 60);
		lab1.setBounds(13, 49, 90, 30);
		lab3.setBounds(230, 49, 120, 30);
		jtf1.setBounds(340, 49, 150, 30);		
		but10.setBounds(490, 49, 90, 30);
		t1.setBounds(170, 8, 660, 35);
		but3.setBounds(947, 0, 30, 30);
		but8.setBounds(947, 0, 30, 30);
		lab2.setBounds(3, 30, 205, 30);
		jtf.setBounds(208, 30, 150, 30);
		but4.setBounds(360, 30, 190, 30);
		but5.setBounds(600, 30, 100, 30);
		but6.setBounds(710, 30, 100, 30);
		but7.setBounds(820, 30, 100, 30);
		mpan.setBounds(0, 80, 980, 560);
		
		
		
		but3.setIcon(new ImageIcon("tu"+File.separator+"关闭.png"));
		but8.setIcon(new ImageIcon("tu"+File.separator+"关闭.png"));
		but3.setFont(new Font("宋体",Font.BOLD,18));
		t1.setOpaque(true);
		t1.setBackground(Color.green);
		
		//将控件添加进容器
		pan1.add(but2);
		pan2.add(t1);
		pan2.add(lab1);	
		pan2.add(lab3);	
		pan2.add(but3);
		pan2.add(but10);
		pan2.add(jtf1);
		pan3.add(mpan);
		pan3.add(lab2);
		pan3.add(jtf);
		pan3.add(but4);
		pan3.add(but5);
		pan3.add(but6);
		pan3.add(but7);
		pan3.add(but8);
			
		jtp.add("首页",pan1);

		//事件监听及处理


		jtf1.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
	
			}

			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {

			}
			
		});
		but3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			jtp.remove(pan2);
			jtp.setSelectedIndex(jtp.getSelectedIndex());	
			}	
		});
		but8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			jtp.remove(pan3);
			jtp.setSelectedIndex(jtp.getSelectedIndex());
				
			}
			
		});
		but2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				//这边是点击按钮之后就直接进入管理页面了
				Zhujiemian.jtp.add("信息管理",Zhujiemian.pan3);
				Zhujiemian.jtp.setSelectedComponent(Zhujiemian.pan3);
				//必须加上异常处理，我也不知道为什么要加异常处理，系统提示要加的
				try {
					Zhujiemian.mpan.showinfo("");
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			
		});
		but4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtf.getText().equals("")){
					mpan.infoflag=0;
				}else{
					mpan.infoflag=1;
				}
				try {
					mpan.showinfo(jtf.getText());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		but5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			try {
				tj = new Tianjia();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	//

		tj.but1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					tj.addinfo();
					tj.dispose();
					 JOptionPane.showMessageDialog(null,"添加成功！","系统提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
			
			}
			
		});

		jtf.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					jtf.setText("");
				}else{
					
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
		but6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			try {
				 int i = 0;

			     i = Zhujiemian.mpan.table.getSelectedRow();
				 if(i==-1){
				JOptionPane.showMessageDialog(null,"选择为空！","系统提示",JOptionPane.WARNING_MESSAGE);
				 }else{
				xg = new XiuGai();
				 }
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
			}
			
		});
		jtf.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
	
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10){
					try {
						if(jtf.getText().equals("")){
							mpan.infoflag=0;
						}else{
							mpan.infoflag=1;
						}
						mpan.showinfo(jtf.getText());
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else{
					;
				}
			}

			public void keyReleased(KeyEvent e) {

			}
			
		});
		but7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					String name = null;
					String code= "" ;
					try{
					int sellindex = mpan.table.getSelectedRow();
					 code = mpan.table.getValueAt(sellindex, 0).toString();
					 name = mpan.table.getValueAt(sellindex, 1).toString();
					}catch(NullPointerException a){
						JOptionPane.showMessageDialog(null,"您还未选中任何学生！","系统提示",JOptionPane.INFORMATION_MESSAGE);
						return ;
					}				
					int t = JOptionPane.showConfirmDialog(null,"确定要删除: "+name+" 吗？");
					if(t==0){
					delete(Integer.parseInt(code));
					JOptionPane.showMessageDialog(null,name+" 删除成功！","系统提示",JOptionPane.YES_NO_CANCEL_OPTION);
					}else{
						;
					}
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
			}
			
		});
		frame.add(jtp);
		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.setLocation(((int) (ds.getWidth())-1000)/2, ((int) (ds.getHeight())-800)/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void delete(int a) throws ClassNotFoundException, SQLException{
		int tempnum = a;
		Connection conn = ConnectionUtil.getConnection();
	    Statement sta = conn.createStatement();   //执行sql语句的容器  row 行 column 列
	    String str = "delete from stuInfo where code = "+a+"";
	    sta.execute(str);
	    sta.close();
	    conn.close();	    
	}

}



















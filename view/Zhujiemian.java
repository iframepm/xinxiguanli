package view;
//������
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

	static JFrame frame = new JFrame("ѧ����Ϣ����ϵͳ");
	static JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP) ;// ���ñ�ǩ�������ʾ
	Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();	
	public static GongJuMianBan pan1 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"1.jpg").getImage());//ϵͳ������
	public static GongJuMianBan pan2 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"��ɫ����.jpg").getImage());
	public static GongJuMianBan pan3 = new GongJuMianBan(new ImageIcon("tu"+File.separator+"��ɫ.jpg").getImage());
	static XinXiGuanLi mpan = new XinXiGuanLi();
	JButton but2 = new JButton("��Ϣ����");
	JButton but3 = new JButton();
	JButton but8 = new JButton();
	

	String jcbitem = "";//����������ķ���ֵ
	JLabel lab1 = new JLabel("����ʽ��");
	JLabel lab2 = new JLabel("���/����/Ժϵ/�༶��");
	JLabel lab3 = new JLabel("���/�༶��",JLabel.LEFT);
	JTextField jtf = new JTextField();
	JTextField jtf1 = new JTextField();
	JButton but4 = new JButton("��ѯ/ˢ�½���");
	JButton but5 = new JButton("����ѧ��");
	JButton but6 = new JButton("�༭��Ϣ");
	JButton but7 = new JButton("ɾ����Ϣ");
	JButton but9 = new JButton("ɾ����Ϣ");
	JButton but10 = new JButton("��ѯ");

	
	JLabel t1 = new JLabel("ѧ����Ϣ��ѯϵͳ",JLabel.CENTER);
	
	public static Tianjia tj = null;
	public static XiuGai xg = null;
	public Zhujiemian() throws ClassNotFoundException, SQLException{
		pan1.setLayout(null);
		pan2.setLayout(null);
		pan3.setLayout(null);
		jtp.add("��ҳ",pan1);	

	
		
		//���ô���ؼ��Ļ������Ե�������
		jtp.setFont(new Font("����",Font.BOLD,24));
		but2.setFont(new Font("����",Font.BOLD,27));
		t1.setFont(new Font("����",Font.BOLD,24));
		lab1.setFont(new Font("����",Font.PLAIN,18));
		lab2.setFont(new Font("����",Font.BOLD,18));
		lab3.setFont(new Font("����",Font.BOLD,18));
		but4.setFont(new Font("����",Font.BOLD,18));
		but5.setFont(new Font("����",Font.BOLD,15));
		but6.setFont(new Font("����",Font.BOLD,15));
		but7.setFont(new Font("����",Font.BOLD,15));
		jtf.setFont(new Font("����",Font.BOLD,15));
		
		
		
		//��ѯ������ÿؼ���λ��
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
		
		
		
		but3.setIcon(new ImageIcon("tu"+File.separator+"�ر�.png"));
		but8.setIcon(new ImageIcon("tu"+File.separator+"�ر�.png"));
		but3.setFont(new Font("����",Font.BOLD,18));
		t1.setOpaque(true);
		t1.setBackground(Color.green);
		
		//���ؼ����ӽ�����
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
			
		jtp.add("��ҳ",pan1);

		//�¼�����������


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

				//����ǵ����ť֮���ֱ�ӽ������ҳ����
				Zhujiemian.jtp.add("��Ϣ����",Zhujiemian.pan3);
				Zhujiemian.jtp.setSelectedComponent(Zhujiemian.pan3);
				//��������쳣��������Ҳ��֪��ΪʲôҪ���쳣������ϵͳ��ʾҪ�ӵ�
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
					 JOptionPane.showMessageDialog(null,"���ӳɹ���","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"ѡ��Ϊ�գ�","ϵͳ��ʾ",JOptionPane.WARNING_MESSAGE);
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
						JOptionPane.showMessageDialog(null,"����δѡ���κ�ѧ����","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
						return ;
					}				
					int t = JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ��: "+name+" ��");
					if(t==0){
					delete(Integer.parseInt(code));
					JOptionPane.showMessageDialog(null,name+" ɾ���ɹ���","ϵͳ��ʾ",JOptionPane.YES_NO_CANCEL_OPTION);
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
	    Statement sta = conn.createStatement();   //ִ��sql��������  row �� column ��
	    String str = "delete from stuInfo where code = "+a+"";
	    sta.execute(str);
	    sta.close();
	    conn.close();	    
	}

}


















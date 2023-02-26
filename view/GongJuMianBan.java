package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

public class GongJuMianBan extends JPanel{
	
	private Image image = null;
	private boolean isMoued;
	private Point pre_point;
	private Point end_point;
	
	public GongJuMianBan(Image image){
		this.image = image;
		
		this.setSize(1085, 58);
		this.setBackground(Color.GREEN);
		
	}
	//¹Ì¶¨±³¾°Í¼Æ¬
	protected void  paintComponent(Graphics g){		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(),this);

	}
	
}

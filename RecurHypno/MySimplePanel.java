package RecurHypno;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.MouseInputListener;


public class MySimplePanel extends JPanel implements MouseInputListener, KeyListener {

	
	public double center = 375;
	Spirals spy;
	Graphics2D temp;
	public double theta=0;
	/**
	 * Construct a panel with specified width, height, and background color
	 * @param width
	 * @param height
	 * @param bgColor
	 */
	public MySimplePanel(int width, int height, Color bgColor)  {
		
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor); 
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D)graphicHelper;
		temp = g;
		
		
		if(spy!=null)
		{
			spy.draw(g);
		}
		
		
		//automatic repainting
		long start = System.currentTimeMillis();
		long delta = 0;
		long frameTime = 1000/30;
		while(delta<frameTime) {
			delta = System.currentTimeMillis() - start;
		}
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("Click");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
	}
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent k) {
		if(k.getKeyChar()=='1')
		{
			center=375;
			spy = new Spirals(center, center, 25, 25, 1000, theta, 1);
			
		}
		if(k.getKeyChar()=='2')
		{
			center=300;
			spy = new Spirals(center, center, 500, 500, 1000, theta, 2);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

}
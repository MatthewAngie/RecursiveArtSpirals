package RecurHypno;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Spirals extends Ellipse2D.Double{

	
	public Color color;
	public double size;
	
	public Spirals child;
	public int count;
	Graphics2D g;
	public double center;
	public double theta = 0;
	public int type;
	public boolean hasKids;
	
	/*
	 * the constructor
	 * takes x and y as coordinates for first spiral 
	 * takes count as the amount of circles that will make up your spiral
	 * takes theta to control the angle of the spiral
	 * takes type to determine what kind of spiral to make
	 */
	Spirals(double x, double y, double width, double height, int count, double theta, int type)
	{
		
		super(x, y, width, height);
		this.width= width;
		this.height=height;
		this.count= count;
		this.theta = theta;
		this.type= type;
		this.center= this.getWidth()/2;
		color = new Color((float)Math.random(), (float)Math.random(),
				(float)Math.random());
		
		
		//if statments checks which type of spiral to draw
		if(this.type==1)
		{
		
		
			if (this.width<500)
			{
				theta+=20;
				hasKids=true;
				this.count--;	
				if(width<=505&&height<=505)
				{
					width+=1;
					height+=1;
				}
				System.out.println(width+" is the width and height   the theta is " +  theta);
				child = new Spirals(x+width*Math.cos(theta), y+height*Math.sin(theta), width, height, this.count, theta, 1);
			
			}
			else 
			{
				hasKids=false;
				return;
			}
		}
		
		else if(this.type == 2)
		{
			if (this.width>=5)
			{
				theta+=20;
				hasKids=true;
				this.count--;
				if(width<=500&&height<=500)
				{
					width-=1;
					height-=1;
				}
				System.out.println(width+" is the width and height   the theta is " +  theta);
		        child = new Spirals(x+width*Math.cos(theta), y+height*Math.sin(theta), width, height, this.count, theta, 2);
				
			}
			else 
			{
				hasKids=false;
				return;
			}
		}
		
	}
	

	public void draw(Graphics2D g)
	{
		g.setColor(color);
		g.draw(this);
		g.setColor(color);
		g.fill(this);
		color = new Color((float)Math.random(), (float)Math.random(),
				(float)Math.random());
		
		
		//checks if there are any more circles to draw
		if(hasKids)
		{
		child.draw(g);
		}
		else
		{
			return;
		}
	}

}


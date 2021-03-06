package com.shafts.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jmol.adapter.smarter.SmarterJmolAdapter;
import org.jmol.api.JmolAdapter;
import org.jmol.api.JmolViewer;

public class JmolPanel1 extends JPanel{
	
	private static final long serialVersionUID = -4747481289286342678L;
	
	public static void main(String[] args) {
//		(new JmolTest()).viewer.loadInline(strXyzHOH);
		JmolPanel1 jmolPanel = new JmolPanel1();
		
		JFrame newFrame = new JFrame();
	    newFrame.add(jmolPanel);
	    newFrame.setSize(500, 500);
	    newFrame.setVisible(true);
	}
	
	public JmolPanel1() {
		initialize();
	}
	
	public void initialize() {
		adapter = new SmarterJmolAdapter();
	    viewer = JmolViewer.allocateViewer(this, adapter);
	   // viewer.setColorBackground("black");//*******************2013.11.19
	   // Color color = new Color(245,245,220);
	    viewer.setColorBackground("black");
	   // viewer.
	    String kongzhi = "dots on";
	    viewer.evalString(kongzhi);
	    //viewer
	}
	
	@Override
	public void paint(Graphics g) {
		getSize(currentSize);
		viewer.renderScreenImage(g, currentSize.width, currentSize.height);
	}
	
	public void writeimage(){
		
	}
	
	public JmolViewer viewer;
	private JmolAdapter adapter;
	private Dimension currentSize = new Dimension();
}


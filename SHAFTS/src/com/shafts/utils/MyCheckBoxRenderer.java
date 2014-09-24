package com.shafts.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
  /*public class MyCheckBoxRenderer extends JCheckBox implements TableCellRenderer{    
	     
	
	public MyCheckBoxRenderer () { 
	         this.setBorderPainted(true); 
	     } 
	     @Override 
	     public Component getTableCellRendererComponent(JTable table, Object value, 
	             boolean isSelected, boolean hasFocus, int row, int column) { 
	         // TODO Auto-generated method stub       
	         return this; 
	     }    
	 } 
*/

public class MyCheckBoxRenderer extends JCheckBox implements TableCellRenderer{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public MyCheckBoxRenderer(){
    setBackground(Color.red);
    setForeground(Color.yellow);
    setOpaque(true);
}

 @Override
 public Component getTableCellRendererComponent(JTable table,
   Object value, boolean isSelected, boolean hasFocus, int row,
   int column) {
      
   if(isSelected){
          setBackground(Color.green);
   }
   Boolean b = (Boolean) value;    
            this.setSelected(b.booleanValue());    
            return this;    

 }
}



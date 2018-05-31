package com.kyland;

import com.intellij.ui.components.JBLabel;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class  MyRenderer extends JBLabel implements TableCellRenderer {

        //实现接口的方法:



public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

    setForeground(table.getSelectionForeground());

    setBackground(table.getSelectionBackground());

    setText((value == null) ? "" : value.toString());
    return this;
}



}
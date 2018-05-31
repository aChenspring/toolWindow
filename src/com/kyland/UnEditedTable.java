package com.kyland;

import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.PositionTracker;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/
public class UnEditedTable extends JTable {

    private static UnEditedTable unEditedTable;

    private UnEditedTable(AbstractTableModel model)
    {
        super(model,null,new DefaultListSelectionModel());
    }

    public static UnEditedTable getInstance(AbstractTableModel model)
    {
        if(unEditedTable==null)
        {
            unEditedTable = new UnEditedTable(model);
        }
        return unEditedTable;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

package com.kyland;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by renqiao1 on 2018/3/24.
 */
public class PodTableModel extends AbstractTableModel {

    private static Project _project;

    public PodTableModel(){
    }

    String[] columnNames = {"名称", "状态", "容器IP","主机IP",""};

    public List<Pod> pods;

    @Override
    public int getRowCount() {
        return pods.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
        if(4 == columnIndex){
            return JComponent.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pod pod = pods.get(rowIndex);
        if(0 == columnIndex)
            return pod.getPodName();
        if(1 == columnIndex)
            return pod.getStatus();
        if(2 == columnIndex)
            return pod.getPodIP();
        if(3 == columnIndex)
            return pod.getHostIP();
        if(4 == columnIndex){
            return "";
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
        //return super.isCellEditable(rowIndex, columnIndex);
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public List<Pod> getPods() {
        return pods;
    }

    public void setPods(List<Pod> pods) {
        this.pods = pods;
    }
}


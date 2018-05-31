package com.kyland;

import com.google.common.collect.Lists;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.table.JBTableRow;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.List;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/
public class Webview {
    public static void main(String[] args) {
        JFXPanel jfxPanel = new JFXPanel();
        JFrame jFrame = new JFrame("JDos Browser");
        //jFrame.add(jfxPanel);
//        JBTableRow jTabbedPane = new JBTableRow() {
//            @Override
//            public Object getValueAt(int i) {
//                return null;
//            }
//        };
        final PodTableModel podTableModel = new PodTableModel();
        List<Pod> podList = Lists.newArrayList();
        try {
            for(int ji=0;ji<8;ji++)
            {
                Pod  p = new Pod(ji);
                podList.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        podTableModel.setPods(podList);
        JBTable cluserTable = new JBTable();
//        cluserTable.setRowHeight(30);//指定每一行的行高30
//        cluserTable.setDragEnabled(true);//设置可拖		10.182.79.119>>>>>>>>>>3		拽
//        cluserTable.getTableHeader().setReorderingAllowed(false);/*禁止拖动表格的列，不改变列的顺序*/
//        cluserTable.setCellSelectionEnabled(true);/*设置表格单元格可选*/
//        cluserTable.setColumnSelectionAllowed(false);//false，使得表格以行为单位进行选取
//        cluserTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        DragPicListener dragPicListener = new DragPicListener();
//        cluserTable.addMouseListener(dragPicListener);
//        cluserTable.addMouseMotionListener(dragPicListener);
//        TableColumn column = cluserTable.getColumnModel().getColumn(4);//操作列
//        column.setPreferredWidth(50);//设置操作列的宽度
//        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
//        tcr.setHorizontalAlignment(JBLabel.CENTER);//居中显示
//        ListSelectionModel cellSelectionModel  =  cluserTable.getSelectionModel();/*设置表格的选择模式为单选，默认的为多选*/
//        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent e) {
//                String selectedData = null;
//
//            }
//
//        });
//        cluserTable.add(new JBTable(podTableModel));
//        cluserTable.add(new JBTable(podTableModel));
//        cluserTable.add(new JBTable(podTableModel));
//        cluserTable.add(new JBTable(podTableModel));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
//        cluserTable.add(new JBLabel("ss"));
        jFrame.add(cluserTable);
        //jFrame.add(new JTabbedPane());
//        Platform.runLater(() -> {
//            WebView webView = new WebView();
//            jfxPanel.setScene(new Scene(webView));
//            webView.getEngine().load("http://www.stackoverflow.com/");
//        });
        jFrame.show();
        jFrame.setSize(1000,800);
    }
}

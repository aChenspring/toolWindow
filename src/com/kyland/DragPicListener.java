package com.kyland;

import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseListener;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;
import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/
public class DragPicListener extends MouseInputAdapter implements EditorMouseListener,EditorMouseMotionListener {
    /** 坐标点 */
    Point point = new Point(0, 0);

    private String ip = "";

    @Override
    public void mousePressed(EditorMouseEvent editorMouseEvent) {

    }

    @Override
    public void mouseClicked(EditorMouseEvent editorMouseEvent) {

    }


    @Override
    public void mouseEntered(EditorMouseEvent editorMouseEvent) {
//        try
//        {
//            // 转换坐标系统
//            UnEditedTable dragPicLabel = (UnEditedTable) editorMouseEvent.getMouseEvent().getSource();
//            PodTableModel podTableModel = (PodTableModel)dragPicLabel.getModel();
//            List<Pod> podList = podTableModel.getPods();
//            List<Pod> pods = new ArrayList<Pod>();
//            for(Pod pod :podList )
//            {
//                Pod pod1 = new Pod();
//                pod1.setPodIP(pod.getPodIP());
//                pods.add(pod1);
//            }
//            podTableModel.setPods(pods);
//            //dragPicLabel.setModel(podTableModel);
//            // e.setSource(dragPicLabel);
////            Point newPoint = SwingUtilities.convertPoint(dragPicLabel, editorMouseEvent.getPoint(), dragPicLabel.getParent());
////            // 设置标签的新位置
////            dragPicLabel.setLocation(dragPicLabel.getX()
////                    + (newPoint.x - point.x), dragPicLabel.getY()
////                    + (newPoint.y - point.y));
////            // 更改坐标点
////            point = newPoint;
//            System.out.println(ip+"拖动 ");
//        }
//        catch (Exception e)
//        {
//
//        }
    }

    @Override
    public void mouseExited(EditorMouseEvent editorMouseEvent) {

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 当鼠标拖动时触发该事件。 记录下鼠标按下(开始拖动)的位置。
     */
    public void mouseDragged(MouseEvent e) {
        JBTable dragPicLabel = (JBTable) e.getSource();
        PodTableModel podTableModel = (PodTableModel)dragPicLabel.getModel();
        List<Pod> podList = podTableModel.getPods();
        int fistselectrow = dragPicLabel.getSelectedRow();
        Pod pod= podList.get(fistselectrow);
        Pod pod1 = new Pod();
        String config = "<jsf:consumer id=\"hrOrganizationService\"\n" +
                "              interface=\"com.jd.official.omdm.is.hr.HrOrganizationService\" alias=\"HR_ORGANIZATION_SERVICE_JSF\"\n" +
                "              protocol=\"jsf\" timeout=\"60000\">\n" +
                "</jsf:consumer>\n";
        pod1.setPodIP(config);
        podList.set(dragPicLabel.getRowCount()-1,pod1);
    }


    // 隐藏列
    public void HiddenCell(JTable table, int column) {
        TableColumn tc = table.getTableHeader().getColumnModel().getColumn(
                column);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setWidth(0);
        tc.setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(column)
                .setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(column)
                .setMinWidth(0);
    }


    @Override
    public void mouseMoved(EditorMouseEvent editorMouseEvent) {

    }

    @Override
    public void mouseDragged(EditorMouseEvent editorMouseEvent) {

    }

    public void mouseReleased(EditorMouseEvent editorMouseEvent) {
        try
        {
//            // 转换坐标系统
//            UnEditedTable dragPicLabel = (UnEditedTable) editorMouseEvent.getMouseEvent().getSource();
//            PodTableModel podTableModel = (PodTableModel)dragPicLabel.getModel();
//            List<Pod> podList = podTableModel.getPods();
//            List<Pod> pods = new ArrayList<Pod>();
//            for(Pod pod :podList )
//            {
//                Pod pod1 = new Pod();
//                pod1.setPodIP(pod.getPodIP());
//                pods.add(pod1);
//            }
//            podTableModel.setPods(pods);
//            //dragPicLabel.setModel(podTableModel);
//            // e.setSource(dragPicLabel);
////            Point newPoint = SwingUtilities.convertPoint(dragPicLabel, editorMouseEvent.getPoint(), dragPicLabel.getParent());
////            // 设置标签的新位置
////            dragPicLabel.setLocation(dragPicLabel.getX()
////                    + (newPoint.x - point.x), dragPicLabel.getY()
////                    + (newPoint.y - point.y));
////            // 更改坐标点
////            point = newPoint;
//            System.out.println(ip+"拖动 ");
        }
        catch (Exception e)
        {

        }
    }
}

package com.kyland;

import com.google.common.collect.Lists;
import com.intellij.history.integration.ui.views.RevisionsList;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBPanel;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

/***
 * @Author: achen
 * @Date: ${time} ${date}
 * @Description:
 ***/
public class DragWindowFactory implements ToolWindowFactory {

    private ToolWindow myToolWindow;
    private JPanel panel1;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        myToolWindow = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(initGui(project), "", false);
        toolWindow.getContentManager().addContent(content);
    }

    public JComponent initGui(Project _project) {
        JBPanel jbPanel = new JBPanel();
        jbPanel.setLayout(new GridLayout(3,1,0,0));
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
        UnEditedTable cluserTable = UnEditedTable.getInstance(podTableModel);
        TableColumn column = cluserTable.getColumnModel().getColumn(4);//操作列
        column.setPreferredWidth(50);//设置操作列的宽度
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
        tcr.setHorizontalAlignment(JBLabel.CENTER);//居中显示
        DragSource dragSource = DragSource.getDefaultDragSource();
        dragSource.createDefaultDragGestureRecognizer(cluserTable,
                DnDConstants.ACTION_COPY_OR_MOVE,
                new DragGestureListener()
                {
                    public void dragGestureRecognized(DragGestureEvent event)
                    {
                        //当前选择中单元格的内容
                        //TableModel tableModel = (TableModel) tb1.getModel();
                        //int row = tb1.getSelectedRow();
                        //int col = tb1.getSelectedColumn();
                        //String s = (String)tableModel.getValueAt(row,col);
                        int fistselectrow = cluserTable.getSelectedRow();
                        String config = fistselectrow+"<jsf:consumer id=\"hrOrganizationService\"\n" +
                                "              interface=\"com.jd.official.omdm.is.hr.HrOrganizationService\" alias=\"HR_ORGANIZATION_SERVICE_JSF\"\n" +
                                "              protocol=\"jsf\" timeout=\"60000\">\n" +
                                "</jsf:consumer>\n";
                        Transferable transferable = new StringSelection(config);
                        event.startDrag(
                                DragSource.DefaultCopyDrop,
                                transferable);

                    }
                });

        JScrollPane scrollPane = new JScrollPane (cluserTable);
        scrollPane.setBorder(null);
        return (scrollPane);
    }

}

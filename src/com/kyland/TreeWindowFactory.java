package com.kyland;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.treeStructure.Tree;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;

/***
 * @author achen
 */
public class TreeWindowFactory  implements ToolWindowFactory,MouseListener,ActionListener{
    private ToolWindow myToolWindow;
    private JTree tree;
    private JPanel panel2;

    private JPopupMenu popMenu; //右键菜单
    private JMenuItem addItem;   //各个菜单项
    private JMenuItem delItem;

    /***
     * toolWindow.treeFactory点击事件
     * @param project
     * @param toolWindow
     */
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
            myToolWindow = toolWindow;
            ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
            initTrre();
            initPoPMenu();
            Content content = contentFactory.createContent(panel2, "", false);
            toolWindow.getContentManager().addContent(content);
        }

    /***
     * 创建Tree组件并填充数据
     */
    public void initTrre()
        {
            DefaultMutableTreeNode top = new DefaultMutableTreeNode("职员管理");
            top.add(new DefaultMutableTreeNode(new User("总经理")));
            for(int i=0;i<3;i++)
            {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("部门"+i);
                for(int j=0;j<3;j++)
                {
                    node.add(new DefaultMutableTreeNode(new User("小A"+i)));
                }
                top.add(node);
            }
            tree = new JTree(top);
            tree.setEditable(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            tree.addMouseListener(this);
            tree.setCellEditor(new DefaultTreeCellEditor(tree, new DefaultTreeCellRenderer()));
            panel2 = new JPanel();
            panel2.setLayout(new BorderLayout());
            panel2.add(tree,BorderLayout.CENTER);
            panel2.setFont(new Font("alias", Font.PLAIN, 14));
            tree.setFont(new Font("alias", Font.PLAIN, 14));
        }

    /***
     * 创建右键菜单
     */
    public void initPoPMenu()
        {
            popMenu = new JPopupMenu();
            addItem = new JMenuItem("添加");
            addItem.addActionListener(this);
            delItem = new JMenuItem("删除");
            delItem.addActionListener(this);
            popMenu.add(addItem);
            popMenu.add(delItem);
            popMenu.setBorderPainted(true);
            popMenu.setSize(400,400);
            popMenu.setFont(new Font("alias", Font.PLAIN, 14));
            addItem.setFont(new Font("alias", Font.PLAIN, 14));
            delItem.setFont(new Font("alias", Font.PLAIN, 14));
        }

    /***
     * 全局设置字体
     * @param font
     */
    private  void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    /***
     * 鼠标按下事件
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        TreePath path = tree.getPathForLocation(e.getX(), e.getY());
        if (path == null) {
            return;
        }
        tree.setSelectionPath(path);
        if (e.getButton() == 3) {
            popMenu.show(tree, e.getX(), e.getY());
        }
    }

    /***
     * 右键菜单按钮点击事件
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();  //获得右键选中的节点
        if (e.getSource() == addItem) {
            String name = JOptionPane.showInputDialog("请输入节点名称");
            ((DefaultTreeModel) tree.getModel()).insertNodeInto(new DefaultMutableTreeNode(new User(name)), node, node.getChildCount());
            tree.expandPath(tree.getSelectionPath());
            System.out.println(name+" added");
        }
        else if (e.getSource() == delItem) {
            if (node.isRoot()) {
                return;
            }
            ((DefaultTreeModel) tree.getModel()).removeNodeFromParent(node);
            System.out.println(node.getUserObject().toString()+" deled");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}




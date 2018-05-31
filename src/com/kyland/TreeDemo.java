package com.kyland;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.dom4j.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/***
 * @author achen
 *
 */
public class TreeDemo extends AnAction {

    /***
     * MainMenu.demo点击事件
     * @param event
     */
    @Override
    public void actionPerformed(AnActionEvent event)
    {
        Project project = event.getProject();
        //VirtualFile virtualFile = project.getProjectFile();
        //String projectFilePath = project.getProjectFilePath();
        //VirtualFile workspaceFile = project.getWorkspaceFile();
        VirtualFile baseDir = project.getBaseDir();
        ArrayList list = new ArrayList<>();
        findXmlFiles(baseDir,list);
        System.out.println(list.toString());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            parserXml(iterator.next().toString());
        }
    }

    public void findXmlFiles(VirtualFile baseDir,ArrayList list){
        if(baseDir.isDirectory()&&!baseDir.getName().equals(".idea")&&!baseDir.getName().equals("out")&&!baseDir.getName().equals("target")){
            VirtualFile[] children = baseDir.getChildren();
            for(VirtualFile child : children){
                findXmlFiles(child,list);
            }
        }
        else if(baseDir.getName().endsWith(".xml")||baseDir.getName().endsWith(".XML")){
            list.add(baseDir.getPath());
        }
    }

    public  void parserXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element element = document.getRootElement();
            printXml(element);
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printXml(Element element){

        //self attr
        System.out.println(element.getName());
        Iterator<Attribute> attributeIterator = element.attributeIterator();
        while (attributeIterator.hasNext()){
            Attribute next = attributeIterator.next();
            System.out.println(element.getName()+" attr:"+next.getName()+":"+next.getValue());
        }

        //self text
        // if(node.getName().equals("provider")||node.getName().equals("provider")){
        String text = element.getText();
        if(!(text.equals("")||text.replace("/n+","").trim().equals("")))
            System.out.println(element.getName()+":"+element.getText());
        //}

        //child
        Iterator<Element> elementIterator = element.elementIterator();
        while (elementIterator.hasNext()){
            printXml(elementIterator.next());
        }
    }

    public void printAttr(Element element){
        System.out.println(element.getName());
        //attr
        Iterator<Attribute> attributeIterator = element.attributeIterator();
        while (attributeIterator.hasNext()){
            Attribute next = attributeIterator.next();
            System.out.println(element.getName()+" attr:"+next.getName()+":"+next.getValue());
        }
    }

    @Nullable
    private static Editor getEditor(@NotNull AnActionEvent e) {
        return (Editor) CommonDataKeys.EDITOR.getData(e.getDataContext());
    }

    @Nullable
    private static PsiFile getPsiFile(@NotNull AnActionEvent e) {
        return (PsiFile)CommonDataKeys.PSI_FILE.getData(e.getDataContext());
    }

    public void invoke(Editor editor, PsiFile file) {
//            SqlExpression subquery = SqlSubqueryUtils.smartFindQuery(editor, file);
//            SqlExpression query = SqlSubqueryUtils.findEnclosingQueryWithContext(subquery);
//            if(SqlSubqueryUtils.isSubquery(query, subquery)) {
//                SqlSubqueryUtils.extractCte(editor.getProject(), editor, file, subquery, query);
//            }

    }

    public static void main(String[] args) {
        String s = "E:/code/archimedes-idea/resources/META-INF/plugin.xml";
        String s1 = "E:/butterfly/wangxiaobing18_butterfly/butterfly/jmq.xml";
        String s2 = "E:/butterfly/wangxiaobing18_butterfly/butterfly/provider.xml";
        String s3 = "E:/butterfly/wangxiaobing18_butterfly/butterfly/consumer.xml";
        TreeDemo t = new TreeDemo();
        //t.parserXml(s);
        //t.parserXml(s1);
        t.parserXml(s2);
        //t.parserXml(s3);
    }
}

package cn.roc.plugin.lezizibook.factory;

import cn.roc.plugin.lezizibook.service.BookScanner;
import cn.roc.plugin.lezizibook.service.BookScannerBuilder;
import cn.roc.plugin.lezizibook.service.PersistentState;
import cn.roc.plugin.lezizibook.ui.ReadUI;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @Author roc
 * @Description
 */
public class ReadWindowFactory implements ToolWindowFactory {

    public static ReadUI readUI;
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        //创建出NoteListWindow对象
        readUI = new ReadUI(project, toolWindow);
        //获取内容工厂的实例
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        //获取用于toolWindow显示的内容
        Content content = contentFactory.createContent(readUI.getJcontent(), "", false);
        //给toolWindow设置内容
        toolWindow.getContentManager().addContent(content);
        BookScanner bookScanner = BookScannerBuilder.builder(null);
        if(bookScanner!=null){
            readUI.turnPage(PersistentState.getInstance().getPageNum());
        }
    }
}

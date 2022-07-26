package cn.roc.plugin.lezizibook.service;

import java.util.List;

/**
 * @Author roc
 * @Description
 */
public interface BookScanner {
     String bookName();
     long getBookSize();
     long getTotalLines();
     List<String> getContentForPage(int page, int pageSize);
}

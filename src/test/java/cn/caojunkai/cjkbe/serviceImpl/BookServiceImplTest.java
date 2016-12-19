/* Created by Fitz on 2016/12/19 */

package cn.caojunkai.cjkbe.serviceImpl;

import cn.caojunkai.cjkbe.BaseTest;
import cn.caojunkai.cjkbe.dto.AppointExecution;
import cn.caojunkai.cjkbe.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest{
    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception{
        long bookId = 1000;
        long stuId = 12008083;
        AppointExecution appointExecution = bookService.appoint(bookId,stuId);
        System.out.println(appointExecution);
    }
}

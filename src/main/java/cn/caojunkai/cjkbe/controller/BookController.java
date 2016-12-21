/* Created by Fitz on 2016/12/20 */

package cn.caojunkai.cjkbe.controller;

import cn.caojunkai.cjkbe.dto.AppointExecution;
import cn.caojunkai.cjkbe.dto.Result;
import cn.caojunkai.cjkbe.entity.Book;
import cn.caojunkai.cjkbe.enums.AppointStateEnum;
import cn.caojunkai.cjkbe.exception.BizException;
import cn.caojunkai.cjkbe.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String list(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "list";
    }



    @ResponseBody
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @Param("stuId") Long stuId) {
        if (stuId == null || stuId.equals("")) {
            return new Result<>(false, "学生卡号不能为空");
        }
        AppointExecution appointExecution = null;
        try {
            appointExecution = bookService.appoint(bookId, stuId);
        } catch (BizException e) {
            return new Result<AppointExecution>(false,e.getMessage());
        } catch (Exception e) {
            return new Result<AppointExecution>(false,e.getMessage());
        }
        return new Result<AppointExecution>(true, appointExecution);
    }

}

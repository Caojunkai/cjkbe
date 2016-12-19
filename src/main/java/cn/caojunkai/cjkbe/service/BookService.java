/* Created by Fitz on 2016/12/19 */

package cn.caojunkai.cjkbe.service;

import cn.caojunkai.cjkbe.dto.AppointExecution;
import cn.caojunkai.cjkbe.entity.Book;

import java.util.List;

/**
 * The interface Book service.
 */
public interface BookService {
    /**
     * Gets by id.
     *
     * @param bookId the book id
     * @return the by id
     */
    Book getById(long bookId);

    /**
     * Gets books.
     *
     * @return the books
     */
    List<Book> getBooks();

    /**
     * Appiont appoint execution.
     *
     * @param bookId the book id
     * @param stuId  the stu id
     * @return the appoint execution
     */
    AppointExecution appoint(long bookId,long stuId);

}

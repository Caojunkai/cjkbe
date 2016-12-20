/* Created by Fitz on 2016/12/19 */

package cn.caojunkai.cjkbe.service.impl;

import cn.caojunkai.cjkbe.dao.AppointmentDao;
import cn.caojunkai.cjkbe.dao.BookDao;
import cn.caojunkai.cjkbe.dto.AppointExecution;
import cn.caojunkai.cjkbe.entity.Appointment;
import cn.caojunkai.cjkbe.entity.Book;
import cn.caojunkai.cjkbe.enums.AppointStateEnum;
import cn.caojunkai.cjkbe.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 注入Service依赖
    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.queryAll(0,1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long stuId) {
        try {
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0){
                return new AppointExecution(bookId,AppointStateEnum.NO_NUMBER);
            }
            else {
                int insert = appointmentDao.insertAppointment(bookId,stuId);
                if (insert <= 0){
                    return new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
                }
                else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,stuId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            // 所有编译期异常转换为运行期异常
            return new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
        }
    }
}

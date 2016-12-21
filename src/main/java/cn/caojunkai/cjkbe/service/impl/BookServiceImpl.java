/* Created by Fitz on 2016/12/19 */

package cn.caojunkai.cjkbe.service.impl;

import cn.caojunkai.cjkbe.dao.AppointmentDao;
import cn.caojunkai.cjkbe.dao.BookDao;
import cn.caojunkai.cjkbe.dto.AppointExecution;
import cn.caojunkai.cjkbe.entity.Appointment;
import cn.caojunkai.cjkbe.entity.Book;
import cn.caojunkai.cjkbe.enums.AppointStateEnum;
import cn.caojunkai.cjkbe.exception.BizException;
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
            int update = bookDao.reduceNumber(bookId);
            if (update <= 0){
                throw new BizException(AppointStateEnum.NO_NUMBER.getStateInfo());
            }
            else {
                int insert = appointmentDao.insertAppointment(bookId,stuId);
                if (insert <= 0){
                    throw new BizException(AppointStateEnum.REPEAT_APPOINT.getStateInfo());
                }
                else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,stuId);
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS,appointment);
                }
            }
    }
}
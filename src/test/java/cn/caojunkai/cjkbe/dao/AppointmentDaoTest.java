/* Created by Fitz on 2016/12/19 */

package cn.caojunkai.cjkbe.dao;

import cn.caojunkai.cjkbe.BaseTest;
import cn.caojunkai.cjkbe.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {
    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testInsertAppointment() throws Exception{
        long bookId = 1000;
        long stuId = 12008083;
        int insert = appointmentDao.insertAppointment(bookId,stuId);
        System.out.println(insert);
    }

    @Test
    public void testQueryByKeyWithBook(){
        long bookId = 1000;
        long stuId = 12008083;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,stuId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }
}

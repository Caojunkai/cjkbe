// =========== Created by Fitz on 2016/12/16 ===============

package cn.caojunkai.cjkbe.dao;

import cn.caojunkai.cjkbe.entity.Appointment;
import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {

    int insertAppointment(@Param("bookId") long bookId,@Param("studentId") long studentId);

    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);

}

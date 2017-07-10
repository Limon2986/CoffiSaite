package DAO;


import entity.MarkaCoffi;

import java.util.List;

public interface MarkaCoffiDAO  {
    /**
     * вернуть марку по идентификатору
     * @param id идентификатор марки кофе
     * @return
     */

    MarkaCoffi getMarkaCoffiById(long id);
    List<MarkaCoffi> getAllMarkaCoffi();
    Boolean deleteId(long id);
   Long create(MarkaCoffi markaCoffi);
   Boolean update(MarkaCoffi marka);

}

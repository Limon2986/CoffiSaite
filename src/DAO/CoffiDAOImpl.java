package DAO;

import Util.Helper;
import com.sun.jndi.ldap.Connection;
import entity.Coffi;
import entity.MarkaCoffi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Администратор on 08.07.2017.
 */
public class CoffiDAOImpl extends ConnectSUBD implements CoffiDAO  {

    private String getId = "select id, Name, price, marka from coffi  where id = %d";

    public Coffi getCoffiId(long id) {
        java.sql.Connection dbConnection = getDBConnection();
      Coffi coffi = new Coffi();
        try {

            Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(String.format(getId, id));

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
                //coffi.setId( rs.getLong("ID"));
                coffi.setName(rs.getString("name"));
                coffi.setPrice(rs.getBigDecimal("price"));
                Long mk1 = rs.getLong("marka");
                MarkaCoffiDAOImpl mao = new MarkaCoffiDAOImpl();
                MarkaCoffi mak =  mao.getMarkaCoffiById(mk1);
                coffi.setMarkaCoffi(mak);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return coffi;
    }


}

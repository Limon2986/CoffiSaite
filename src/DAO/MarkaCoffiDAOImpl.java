package DAO;

import Util.Helper;
import entity.MarkaCoffi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 08.07.2017.
 */
public class MarkaCoffiDAOImpl extends ConnectSUBD implements MarkaCoffiDAO {

    private String getId = "select id, Name, Proizvoditel, Type from markacoffi  where id = %d";
    private String getAll = "select id, Name, Proizvoditel, Type from markacoffi";
    private String deleteId = "delete from markacoffi where id = %d";
    private String create = "insert into markacoffi(Name, Proizvoditel, Type) values ('%s', '%s', %d)";
    private String update = "update markacoffi set Name = '%s', Proizvoditel = '%s', Type = %d where id = %d";

    public MarkaCoffi getMarkaCoffiById(long id) {
        Connection dbConnection = getDBConnection();
        MarkaCoffi markaCoffi = new MarkaCoffi();
        try {

           Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(String.format(getId, id));

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
               markaCoffi.setId( rs.getLong("ID"));
                markaCoffi.setName(rs.getString("name"));
                markaCoffi.setProizvoditel(rs.getString("Proizvoditel"));
                markaCoffi.setTypeCoffi(Helper.getTypeCoffi(rs.getInt("type")));

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
        return markaCoffi;
    }

    public List<MarkaCoffi> getAllMarkaCoffi() {
        Connection dbConnection = getDBConnection();
       List<MarkaCoffi> markaCoffis = new ArrayList<MarkaCoffi>();
        try {

            Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(getAll);

            // И если что то было получено то цикл while сработает

            while (rs.next()) {
                MarkaCoffi markaCoffi = new MarkaCoffi();

                markaCoffi.setId( rs.getLong("ID"));
                markaCoffi.setName(rs.getString("name"));
                markaCoffi.setProizvoditel(rs.getString("Proizvoditel"));
                markaCoffi.setTypeCoffi(Helper.getTypeCoffi(rs.getInt("type")));
                markaCoffis.add(markaCoffi);
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
        return markaCoffis;
    }


    public Boolean deleteId(long id) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(deleteId, id));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    public Long create(MarkaCoffi markaCoffi) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(create, markaCoffi.getName(), markaCoffi.getProizvoditel(), markaCoffi.getTypeCoffi().getDb()));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

        return null;
    }

    public Boolean update(MarkaCoffi marka) {
        Connection connection = getDBConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(String.format(update, marka.getName(), marka.getProizvoditel(), marka.getTypeCoffi().getDb(), marka.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
            return true;
        }
    }
}

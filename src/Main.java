import DAO.CoffiDAO;
import DAO.CoffiDAOImpl;
import DAO.MarkaCoffiDAO;
import DAO.MarkaCoffiDAOImpl;
import entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main1(String[] args) {

        MarkaCoffi neskafe = new MarkaCoffi();
        neskafe.setName("Neskafe");
        neskafe.setProizvoditel("Russia");
        neskafe.setTypeCoffi(TypeCoffi.CLASSIC);

        MarkaCoffi ford = new MarkaCoffi("Ford", TypeCoffi.DLY_LOHOV, "Ukraina");

        Coffi coffi = new Coffi();
        coffi.setName("Super");
        coffi.setMarkaCoffi(neskafe);
        coffi.setPrice(new BigDecimal(25.10));

        Coffi coffiF = new Coffi(new BigDecimal(22.20),"Super1",ford);
        String [] names = {"Arabic","Crutoe","Galimoe","EcheGalimee"};
        String [] country = {"Italia","Grecia","Argentina","Ekvador"};

        List <Coffi> list = new ArrayList<Coffi>();
        for (int i = 0; i < 25; i++){
           Coffi coffi1 = new Coffi();
            coffi1.setName(names[((int) (Math.random() * 4))]);
            coffi1.setMarkaCoffi(i % 2 == 0 ? neskafe : ford);
            coffi1.setPrice(new BigDecimal(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP) );
            list.add(coffi1);
        }
        list.add(coffi);
        list.add(coffiF);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        User user = creatUser("name", 25, "password", "login");
        User user1 = creatUser("name1", 255, "password1", "login1");
addcomment(user, list);
addcomment(user1, list);


    }
public static User creatUser(String n,int a, String p, String l ){
    User user = new User();

    user.setName(n);
    user.setAge(a);
    user.setLogin(l);
    user.setPassword(p);

    return user;
}
public static void  addcomment(User user, List <Coffi> list ){
    List<Otziv> otzivs = new ArrayList<Otziv>();
    for (int i = 0; i < 3; i++) {

        Otziv otziv = new Otziv();

        otziv.setCoffi(list.get((int) Math.random() * list.size()));
        otziv.setText("������� � " + (int) (Math.random() * 100));
        otzivs.add(otziv);

    }
    user.setOtzivs(otzivs);
}

    public static void main(String[] args) {
        MarkaCoffiDAO markaCoffiDAO = new MarkaCoffiDAOImpl();

                   MarkaCoffi mkk = new MarkaCoffi();
        mkk.setName("cc");
        mkk.setProizvoditel("df");
        mkk.setTypeCoffi(TypeCoffi.CLASSIC);

       // markaCoffiDAO.create(mkk);
        mkk = markaCoffiDAO.getMarkaCoffiById(1);
        mkk.setName("imz");

        markaCoffiDAO.update(mkk);
       /* List<MarkaCoffi> mk = markaCoffiDAO.getAllMarkaCoffi();
        for (MarkaCoffi markaCoffi : mk) {
            System.out.println(markaCoffi);
        }*/

        CoffiDAO coffiDAO = new CoffiDAOImpl();
        System.out.println(coffiDAO.getCoffiId(1));

    }
}

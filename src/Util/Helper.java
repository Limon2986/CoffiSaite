package Util;

import entity.TypeCoffi;

import java.lang.reflect.Type;

/**
 * Created by Администратор on 08.07.2017.
 */
public class Helper {

    public static TypeCoffi getTypeCoffi (int a){
        switch (a){
            case 1: return TypeCoffi.GOLD;
            case 2: return TypeCoffi.CLASSIC;
            case 3: return TypeCoffi.DLY_LOHOV;

        }
        return null;
    }
}

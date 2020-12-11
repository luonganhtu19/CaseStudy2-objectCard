package TryCatch;

import model.ENUM_STATIC;

import java.util.Scanner;

public class CheckCondition {
    CheckCondition(){}

    public static int getInt(String mess){
        boolean check=true;
        int number=-1;
        while (check){
            try {
                number=Integer.parseInt(ENUM_STATIC.getINPUT().nextLine());
                check=false;
            }catch (Exception e){
                System.out.println("Please try again "+mess);
            }
        }
        return number;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.File;
import java.util.Scanner;


public class LogCheck {
    
    public static String filepath = "ATMmembers.txt";
    
    private static Scanner x;
    
    public static boolean verifyLogin(String username, String password){
        boolean found = false;
        String tempUser = "";
        String tempPass = "";
        try{
            x = new Scanner(new File (filepath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !found){
                tempUser = x.next();
                tempPass = x.next();
                if(tempUser.trim().equals(username.trim()) && tempPass.trim().equals(password.trim()))
                    found = true;
            }
            x.close();
        }catch(Exception e){
            System.out.println("Error");
        }
        
        
        return found;
    }
}

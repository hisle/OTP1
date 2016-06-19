
package ru.otp.mavenproject1;

import java.util.Scanner;
/**
 * @author hisle
 */

public class IpOut  {
    
    static long firstValue = 0;
    static long secondValue = 0;
    
    static String backToIP (long value) {
        String adress="";
        long temp, tmp, tm, t;
        
        temp=(value & (255<<24)) >> 24;
        tmp=(value & (255<<16)) >> 16;
        tm=(value & (255<<8)) >> 8;
        t=value & 255;
        adress = temp+"."+tmp+"."+tm+"."+t;
        
        return adress;
    }

    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("input first IP:");
        String first = input.nextLine();
        System.out.print("input second IP:");
        String second = input.nextLine();
        
        try {

        String[] fip = first.split("\\.");
        String[] sip = second.split("\\.");
        
        firstValue = ((Long.valueOf(fip[0]))<<24)+((Long.valueOf(fip[1]))<<16)+((Long.valueOf(fip[2]))<<8)+(Long.valueOf(fip[3]));
        
        secondValue = ((Long.valueOf(sip[0]))<<24)+((Long.valueOf(sip[1]))<<16)+((Long.valueOf(sip[2]))<<8)+(Long.valueOf(sip[3]));
        
        }catch (NumberFormatException e) {  
        System.err.println("Неверный формат строки!");  
        }
        
        if (secondValue<firstValue) {
            System.out.println("Invalid IP interval");
            return;
        }
        
        while (secondValue - firstValue>1)
            System.out.println(backToIP(++firstValue));
        

        
        
        
    }
    
}

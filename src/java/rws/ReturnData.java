
package rws;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement

public class ReturnData implements Serializable{

    public static final String fileName = "C:\\Users\\valdai\\Desktop\\J210Lab3RS\\AeroScript2011Av20.txt";

    ArrayList <String> al = new ArrayList<>();
    ArrayList <String> airport = new ArrayList<>();
    ArrayList <String> heliport = new ArrayList<>();
    ArrayList <String> coordinat = new ArrayList<>();

    int countAirport;
    int countHeliport;
    public static int count;

    public ReturnData () {
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                 al.add(line);
            }
        } catch (FileNotFoundException ex) {  
            Logger.getLogger(ReturnData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReturnData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0 ; i < al.size();i++){
            if(al.get(i).charAt(4)=='H' && al.get(i).charAt(12)=='A' && al.get(i).charAt(21)=='1'){
                countAirport ++; 
            }  
        } 
        
        for(int i = 0 ; i < al.size();i++){
            if(al.get(i).charAt(4)=='P' && al.get(i).charAt(12)=='A'&& al.get(i).charAt(21)=='1'){
                countHeliport ++ ; 
            }  
        } 
        
        for(int i = 0 ; i < al.size();i++){
            if(al.get(i).charAt(4)=='H' && al.get(i).charAt(12)=='A'&& al.get(i).charAt(21)=='1'){
               
                char[] name = new char[30];
                al.get(i).getChars(92, 122, name, 0);
                String nameTemp = String.valueOf(name);
       
                char[] ICAO = new char[4];
                al.get(i).getChars(6, 10, ICAO, 0);
                String ICAOtemp = String.valueOf(ICAO);
        
                char[] LATITUDE = new char[9];
                al.get(i).getChars(32, 40, LATITUDE, 0);
                String LATITUDEtemp = String.valueOf(LATITUDE);
        
                char[] LONGITUDE = new char[10];
                al.get(i).getChars(41, 50, LONGITUDE, 0);
                String LONGITUDEtemp = String.valueOf(LONGITUDE);
       
                airport.add("AIRPORT NAME:" + nameTemp + "   /ARPT IDENT(ICAO):" + ICAOtemp + "   /LATITUDE:" 
                + LATITUDEtemp + "   /LONGITUDE:" + LONGITUDEtemp);
            }
        } 
        
        for(int i = 0 ; i < al.size();i++){
            if(al.get(i).charAt(4)=='P' && al.get(i).charAt(12)=='A'&& al.get(i).charAt(21)=='1'){
        
                char[] name = new char[30];
                al.get(i).getChars(92, 122, name, 0);
                String nameTemp = String.valueOf(name);
       
                char[] ICAO = new char[4];
                al.get(i).getChars(6, 10, ICAO, 0);
                String ICAOtemp = String.valueOf(ICAO);
        
                char[] LATITUDE = new char[9];
                al.get(i).getChars(32, 40, LATITUDE, 0);
                String LATITUDEtemp = String.valueOf(LATITUDE);
        
                char[] LONGITUDE = new char[9];
                al.get(i).getChars(41, 50, LONGITUDE, 0);
                String LONGITUDEtemp = String.valueOf(LONGITUDE);
       
                heliport.add("HELIPORT NAME:" + nameTemp + "   /HELIPORT IDENT(ICAO):" + ICAOtemp + "   /LATITUDE:" 
                + LATITUDEtemp + "   /LONGITUDE:" + LONGITUDEtemp);
       
            }  
        } 
        
        String resultLATITUDE = null;
        String resultLONGITUDE = null; 
        
        for(int i = 0 ; i < al.size();i++){
 
            if(al.get(i).charAt(4)=='H' && al.get(i).charAt(12)=='A' && al.get(i).charAt(21)=='1'){
       
                char[] LATITUDE = new char[9];
                al.get(i).getChars(32, 41, LATITUDE, 0);
                String LATITUDEtemp = String.valueOf(LATITUDE);
              
                String minLATITUDE = Character.toString(LATITUDEtemp.charAt(3)) + Character.toString(LATITUDEtemp.charAt(4));
                float minFloatLATITUDE = (Float.parseFloat(minLATITUDE))/60;
             
                String secLATITUDE = Character.toString(LATITUDEtemp.charAt(5)) + Character.toString(LATITUDEtemp.charAt(6)) + "." 
                + Character.toString(LATITUDEtemp.charAt(7)) + Character.toString(LATITUDEtemp.charAt(8));
                float secFloatLATITUDE = (Float.parseFloat(secLATITUDE))/3600;
             
                String ostatokLATITUDE = Float.toString(minFloatLATITUDE + secFloatLATITUDE);
             
                String tempResultLATITUDE = Character.toString(ostatokLATITUDE.charAt(2));
             
                if(ostatokLATITUDE.length() > 3){
                    tempResultLATITUDE += Character.toString(ostatokLATITUDE.charAt(3));
                }
             
                if(ostatokLATITUDE.length() > 4){
                    tempResultLATITUDE += Character.toString(ostatokLATITUDE.charAt(4));
                }
             
                if(ostatokLATITUDE.length() > 5){
                    tempResultLATITUDE += Character.toString(ostatokLATITUDE.charAt(5));
                }
             
                if(ostatokLATITUDE.length() > 6){
                    tempResultLATITUDE += Character.toString(ostatokLATITUDE.charAt(6));
                }
             
                if(LATITUDEtemp.charAt(0)=='N' || LATITUDEtemp.charAt(0)=='E') {
                    resultLATITUDE = Character.toString(LATITUDEtemp.charAt(1)) + Character.toString(LATITUDEtemp.charAt(2))+
                    "." + tempResultLATITUDE;} else if (LATITUDEtemp.charAt(0)=='S' || LATITUDEtemp.charAt(0)=='W'){
                    resultLATITUDE = "-" + Character.toString(LATITUDEtemp.charAt(1)) + Character.toString(LATITUDEtemp.charAt(2))+
                    "." + tempResultLATITUDE;
                }
                  
                char[] LONGITUDE = new char[10];
                al.get(i).getChars(41, 51, LONGITUDE, 0);
                String LONGITUDEtemp = String.valueOf(LONGITUDE);     
             
                String minLONGITUDE = Character.toString(LONGITUDEtemp.charAt(4)) + Character.toString(LONGITUDEtemp.charAt(5));
                float  minFloatLONGITUDE = (Float.parseFloat(minLONGITUDE))/60;
             
                String secLONGITUDE = Character.toString(LONGITUDEtemp.charAt(6)) + Character.toString(LONGITUDEtemp.charAt(7)) + "." 
                + Character.toString(LONGITUDEtemp.charAt(8)) + Character.toString(LONGITUDEtemp.charAt(9));
                float secFloatLONGITUDE = (Float.parseFloat(secLONGITUDE))/3600;
             
                String ostatokLONGITUDE = Float.toString(minFloatLONGITUDE + secFloatLONGITUDE);
             
                String tempResultLONGITUDE = Character.toString(ostatokLONGITUDE.charAt(2));
             
                if(ostatokLONGITUDE.length() > 3){
                    tempResultLONGITUDE += Character.toString(ostatokLONGITUDE.charAt(3));
                }
                
                if(ostatokLONGITUDE.length() > 4){
                    tempResultLONGITUDE += Character.toString(ostatokLONGITUDE.charAt(4));
                }
                
                if(ostatokLONGITUDE.length() > 5){
                    tempResultLONGITUDE += Character.toString(ostatokLONGITUDE.charAt(5));
                }
                
                if(ostatokLONGITUDE.length() > 6){
                    tempResultLONGITUDE += Character.toString(ostatokLONGITUDE.charAt(6));
                }
           
                if(LONGITUDEtemp.charAt(0)=='N' || LONGITUDEtemp.charAt(0)=='E') {
                    if(LONGITUDEtemp.charAt(1)=='0'){   
                        resultLONGITUDE = Character.toString(LONGITUDEtemp.charAt(2))+
                        Character.toString(LONGITUDEtemp.charAt(3)) + "." + tempResultLONGITUDE;
                    }else {resultLONGITUDE = Character.toString(LONGITUDEtemp.charAt(1))+ Character.toString(LONGITUDEtemp.charAt(2))+
                        Character.toString(LONGITUDEtemp.charAt(3)) + "." + tempResultLONGITUDE;
                     } 
                   }
                   
        coordinat.add(resultLATITUDE + "," + resultLONGITUDE);  

            }
        }
     
        
    
        this.countAirport = countAirport;
        this.countHeliport = countHeliport;
        this.airport = airport;
        this.heliport = heliport;
        this.coordinat = coordinat;
        this.count = count + 1;
    }
    
    public int getCountAirport() {
        return countAirport;
    }

    public int getCountHeliport() {
        return countHeliport;
    }
    
    public int getCount() {
        return count;
    }
    
    public ArrayList<String> getAirport() {
        return airport;
    }
    
    public ArrayList<String> getHeliport() {
        return heliport;
    }
    
    public ArrayList<String> getCoordinat() {
        return coordinat;
    }
  
}

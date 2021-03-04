package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class workWithLogFile{
    //finds the song on the log file and returns the name 
    public static void getNameOfSong (int songnum ){
        String oldSongname="";
        songnum=songnum-1;
        try {            
            FileReader reader = new FileReader("log.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);            
            for(int i = 0; i < 9; ++i){
                
                if(i==songnum){
                    
                    oldSongname=bufferedReader.readLine();
                }
                else{
                bufferedReader.readLine();
                }
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(oldSongname);
    }
}

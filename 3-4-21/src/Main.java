//   __                  __  __                                          __           
//  /  |                /  |/  |                                        /  |          
//  $$ |____    ______  $$ |$$ |       _____  ____   __    __   _______ $$/   _______ 
//  $$      \  /      \ $$ |$$ |      /     \/    \ /  |  /  | /       |/  | /       |
//  $$$$$$$  |/$$$$$$  |$$ |$$ |      $$$$$$ $$$$  |$$ |  $$ |/$$$$$$$/ $$ |/$$$$$$$/ 
//  $$ |  $$ |$$    $$ |$$ |$$ |      $$ | $$ | $$ |$$ |  $$ |$$      \ $$ |$$ | 
//  $$ |__$$ |$$$$$$$$/ $$ |$$ |      $$ | $$ | $$ |$$ \__$$ | $$$$$$  |$$ |$$ \_____ 
//  $$    $$/ $$       |$$ |$$ |      $$ | $$ | $$ |$$    $$/ /     $$/ $$ |$$       |
//  $$$$$$$/   $$$$$$$/ $$/ $$/       $$/  $$/  $$/  $$$$$$/  $$$$$$$/  $$/  $$$$$$$/ 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static     int numberOfsongs =   9;
    public static boolean SystemTesting =   true;
    public static void main(String[] args) {
        Main refracneCall = new Main();
        boolean running = true;
        
        System.out.println("Bell Music song picker \nProgramed by Isaac Worsencroft");
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter new task to preform");
        Scanner scan = new Scanner(System.in);
        while(running){
        String taskToRun = scan.nextLine();
        if(null == taskToRun){
            System.out.println("ERROR");
        }  
        else switch (taskToRun) {
                case "change the songs":
                case "change songs":
                case "pick songs":
                    picksongs();
                    break;
                case "check song name":
                case "check name of song":
                    System.out.println("enter song number");
                    int songnumb = scan.nextInt();
                    refracneCall.getNameOfSong(songnumb);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
        
        
    }
    public static void picksongs           () {
        Main refracneCall = new Main();
        int numberOfSongs = 9;
        
        System.out.println("change song running");
        System.out.println("-------------------");
        Scanner scan = new Scanner(System.in);
        clearSongSelcection();
        //
        for(int i=0; i<(numberOfSongs-1); i++){
            System.out.println((i+1)+".");
            boolean songPicked=false;
            while(!songPicked){
                System.out.println("Enter song");
                String SongName = scan.nextLine();
                songPicked=refracneCall.changeName(SongName, (i+1));
                refracneCall.logSong(SongName,i);
                if(!songPicked||SystemTesting){
                    System.out.println("ERROR::Song Not Found");
                }
            }
        }
    
    }
    
    public static void clearSongSelcection () {
        Main refracneCall = new Main();
        for (int i=1; i<numberOfsongs; i++){
            File oldName = new File(i+".mp3");
            File newName = new File(refracneCall.getNameOfSong(i-1)+".mp3");
            if(!(oldName.renameTo(newName))) {
            System.out.println("Error"); 
            } 
        }

    }

    public boolean changeName(String SongName, int songNumber){
         
        File oldName = new File(SongName);
        File newName = new File(songNumber+".mp3");
        return (oldName.renameTo(newName));
    }

    public void logSong (String SongName, int sonNumber){
        String oldSongname="";
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            FileReader reader = new FileReader("log.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);
            }
           
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getNameOfSong (int songnum ){
        String oldSongname="";
        //songnum=songnum-1;
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
        }
        System.out.println(oldSongname+" ::returned to old name");
        return oldSongname; 
    }
}

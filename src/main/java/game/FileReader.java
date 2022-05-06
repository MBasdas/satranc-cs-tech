package game;

import model.AbstractTas;

import java.io.*;
import java.util.Scanner;

public class FileReader implements AutoCloseable{

    private static FileReader instance;
    private static final Object obj = new Object();


    private FileReader(){}

    public static FileReader getInstance(){
        if(instance != null){
            return instance;
        }
        synchronized(obj){
            if(instance == null){
                instance = new FileReader();
            }
            return instance;
        }
    }


    public void readFile(String path){
        try {
            File f = new File(path);
            Scanner s = new Scanner(f);
            int y = 0; //satır no
            Board.getInstance().resetTaslar();
            System.out.println("-------------Okunan Data--------------");
            while(s.hasNextLine()){
                String data = s.nextLine();
                String[] splittedData = data.split(" ");
                generateBoard(splittedData, y);
                System.out.println(data);
                y++;
            }
            System.out.println("-------------Okunan Data Sonu----------");
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void generateBoard(String[] splittedData, int y) {
        Board b = Board.getInstance();
        int x = 0; //sütun no
        for(String ss : splittedData){
            //System.out.println(ss);
            String tasTipiVeRengi[] = ss.split("(?<=\\G.)");
            if(!tasTipiVeRengi[0].equals(" ")){
                int color = tasTipiVeRengi[1].equalsIgnoreCase("s") ? Utils.SIYAH : Utils.BEYAZ;
                AbstractTas t = FactoryCreateTas.getTas(tasTipiVeRengi[0], x, y, color);
                b.addTas(t);
            }
            x++;
        }
    }

    public void writeFile(String fileName, String data) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
            writer.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


    @Override
    public void close() throws Exception {

    }
}

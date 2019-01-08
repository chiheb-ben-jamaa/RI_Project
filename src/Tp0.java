/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author labo04
 */
public class Tp0 {
    private  String Str_Doc1,Str_Doc2,Str_Doc3;
    private Double VD1[],VD2[],VD3[];
    private String Q;

    private ArrayList<String> terms1 = new ArrayList<String>();
    private ArrayList<String> terms2 = new ArrayList<String>();
    private ArrayList<String> terms3 = new ArrayList<String>();

    private ArrayList<Double[]> TF_Idf_vectors = new ArrayList<Double[]>();



    
    private void read () throws FileNotFoundException {

        /*
        System.out.println("Enter Doc 1");
        Scanner scanner = new Scanner(System.in);
        String D1 = scanner.nextLine();
        */

        //TODO: Read file from a path and set it into ArrayList :

        try {
            Str_Doc1 = new String(Files.readAllBytes(Paths.get("src/resources/Doc1.txt")));
            Str_Doc2 = new String(Files.readAllBytes(Paths.get("src/resources/Doc2.txt")));
            Str_Doc3 = new String(Files.readAllBytes(Paths.get("src/resources/Doc3.txt")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }





        //TODO: set the ArrayList into String :

        System.out.println("Str_Doc1"+Str_Doc1);

        /*
        //DOC1
        for (int i=0;i<Str_Doc1.length();i++)
         {
             String dj1[]=Str_Doc1.split(" ");
             for (int j=0;j<dj1.length;j++)
             {
               if (!terms1.contains(dj1[j]))
               terms1.add(dj1[j]);

             }
            
         }
         
         for (String t:terms1)
         {
             System.out.println(t);
         }


        */




        Set<String> documents = new LinkedHashSet<>();
        documents.add(Str_Doc1);
        documents.add(Str_Doc2);
        documents.add(Str_Doc3);

        HashMap<String, String> map = new HashMap<>();
        map.put(Str_Doc1, "document1");
        map.put(Str_Doc2, "document2");
        map.put(Str_Doc3, "document3");

        //SearchEngine engine = new SearchEngine(documents);
        SearchEngine e =new SearchEngine((documents));

        while (true) {

            System.out.print("Input: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if ("E".equals(input)) {
                System.out.println("Exit!");
                System.exit(0);
            }

            List<String> resultingDocs = new ArrayList<>();
            for (String s : e.search(input)) {
                resultingDocs.add(map.get(s));
            }
            System.out.println("Result:" + resultingDocs);
        }
    }


















    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Tp0 t=new Tp0();
        t.read();

    }
    
}

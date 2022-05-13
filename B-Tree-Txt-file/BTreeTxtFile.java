/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b.tree.txt.file;
import java.io.*;
/**
 *
 * @author Daniel
 */
public class BTreeTxtFile 
{ 
    public static void main(String[] args)throws Exception
    {
        int maxSize = 0;
        String[] wordList = new String[2050];
        String[] cleanList = new String[2050];
        
        File readFile = new File("/home/daniel/Dropbox/Data Structures/Programs/B-Tree-Txt-file/src/b/tree/txt/file/Project3.txt");
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        
        String newLine;
        while ((newLine = br.readLine()) != null)
        {
            String temp = newLine.split(" ");
            
            cleanList[maxSize] = newLine.split(" ");

            System.out.print(cleanList[0] + "");
            maxSize++;
        }
        

    }
    
}

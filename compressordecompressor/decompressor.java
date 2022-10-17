/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author shivenduac
 */
public class decompressor {
    public static void method(File file) throws IOException{
        String fileDirectory= file.getParent();                   // get the parent directory of file .
        FileInputStream fis= new FileInputStream(file);          // read the file byte data stream 
        GZIPInputStream gzipIS= new GZIPInputStream(fis);       // reading zip file content since file input stream cannot handle it.
       
        FileOutputStream fos=new  FileOutputStream(fileDirectory+"/Decompressedfilecheck.txt");     //creating output stream (i.e - o/p file )
        
        byte[] buffer=new byte[1024];
        
        int len;
        
        while((len=gzipIS.read(buffer)) !=-1){                     // reading the gzip file data line by line till epmty line are reached.  
            System.out.println("length of file"+len);
            fos.write(buffer, 0,len);     
        }
        gzipIS.close();                          // closing the zip file once operation are completed.
        fis.close();                             // closing input stream
        fos.close();                             // closing output stream
    }
    
    public static void main(String[] args) throws IOException{
        File path=new File("C:\\Windows\\Java_Project\\Compressedfile.gz");
        method(path);                                                       //path of file is passed.    
    }
    
    
    
    
}
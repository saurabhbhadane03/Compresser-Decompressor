/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressordecompressor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author shivenduac
 */
public class compressor {
    public static void method(File file) throws IOException{
        String filedirectory= file.getParent();                    //storing parent file directory of the upload file
        FileInputStream fis=new FileInputStream(file);                            //input stream to read the file
        FileOutputStream fos=new FileOutputStream(filedirectory+"/Compressedfile.gz");   // creating output stream to write in given directory
        GZIPOutputStream gzipOS=new GZIPOutputStream(fos);                 // output gzip stream to handle gzip data to be written
        
        byte[] buffer =new byte[1024];                              
        int len;                                        
        
        while((len=fis.read(buffer)) != -1){
            gzipOS.write(buffer,0,len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("C:\\Windows\\Java_Project\\TextFile_uncompressed.txt");      //input file path - example.
        method(path);                                                              //file path of upload file is passed.
    }
    
}
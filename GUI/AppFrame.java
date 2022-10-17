/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressordecompressor.compressor;
import compressordecompressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author shivenduac
 */
public class AppFrame extends JFrame implements ActionListener{                // Jframe is extened  for GUI and ActionListner is implemeted to take the user commands.
    
    JButton compressButton;                                         // defining compressor button object
    JButton decompressButton;                                      // defining decompressor button object                
   
    JLabel GUI_Header;
    
    AppFrame()                                                       // creating a default constructor of AppFrame class 
    {
        
        GUI_Header  = new JLabel("File Compressor-Decompressor ");
        GUI_Header.setOpaque(true);
        GUI_Header.setBounds(150,15,200,40);
      
     //   GUI_Header.setBackground(Color.WHITE);
        GUI_Header.setForeground(Color.BLUE);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           // setting default close operation
        this.setLayout(null);                                       //setting the GUI frame layout to null 
        
        compressButton=new JButton("Select file to compress");             // defining the compressor button object text property.
        compressButton.addActionListener(this);                              // adding actionlister to the compressor button
        compressButton.setBounds(20,100,200,30);                // placing the compress button in layout.
        
        decompressButton=new JButton("Select file to decompress");         // defining the decompressor button object text property
        decompressButton.addActionListener(this);                            // adding actionlister to the decompressor button
        decompressButton.setBounds(250,100,200,30);             // placing the compress button in layout.
        
        this.add(compressButton);                                           // adding the compressor button in GUI
        this.add(decompressButton);                                         // adding the de-compressor button in GUI
        this.add(GUI_Header);
        this.setSize(500,200);                                       // Setting size of GUI pop-up
    //    this.getContentPane().setBackground(Color.black);                     // set the GUI pop background 
        
        this.setVisible(true);                                                 // setting the visibilty of GUI to be true .
    }

    @Override
    public void actionPerformed(ActionEvent e) {                                 // function to work on action performed .
        if(e.getSource()==compressButton){                                       // condition checking if the button selected is compressButton or not.
            JFileChooser filechooser=new JFileChooser();                        // creating an object for file chooser
            int response=filechooser.showSaveDialog(null);                // 
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());        // getting absolute path of the file to compress.
                System.out.println(file);
                try{
                    compressor.method(file);                                    // sending the absolute file path as a paramter to compressor package's methods function.
                    
                }
                catch(IOException excp){                                                   // handling exception and showing whatever the error is on pop up.
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }            
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    
                }
                catch(IOException excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}
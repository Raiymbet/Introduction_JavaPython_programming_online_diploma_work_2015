/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Raiymbet
 */
public class DocumentReader {
        
    public static String readDocxFile(String fileName) {

        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            StringBuffer content = new StringBuffer();        
			
            XWPFDocument document = new XWPFDocument(fis);

            List<XWPFParagraph> paragraphs = document.getParagraphs();
				
            //System.out.println("Total no of paragraph "+paragraphs.size());
		for (XWPFParagraph para : paragraphs) {
                    content.append("<p>"+para.getParagraphText()+"</p>");
		}
            //System.out.println(content);
            fis.close();
            return content.toString();
	} catch (Exception e) {
            return e.toString();
	}
                
    }
    
    public static String readCodeExample(String filename) throws IOException {
        
            int file_size = 0;
            File file = new File(filename);
            FileInputStream fins = new FileInputStream(file.getAbsolutePath());
           
            InputStreamReader isr = new InputStreamReader(fins, "UTF-8");
            
            file_size = fins.available();
            System.out.println("Name of file: "+filename);
            System.out.println("Size of file: "+file_size+" byte");
            
            Reader reader = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            int ch;
            while ((ch = reader.read()) > -1) {
                buffer.append((char)ch);
            }                 
            
            reader.close();
            isr.close();
            System.out.println(buffer.toString());
            
//            byte[] buffer = new byte[file_size];
//            fins.read(buffer, 0, file_size);
//            System.out.println("Содержимое файла: ");
//            for(int i=0; i<buffer.length;i++){
//                System.out.print((char)buffer[i]);
//            }            
            fins.close();  
            return buffer.toString();
    }
}

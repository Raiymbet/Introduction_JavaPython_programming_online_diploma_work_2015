/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.service;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.poi.xwpf.usermodel.IBodyElement;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.drawingml.x2006.picture.PicDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

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
            XWPFStyles styles = document.getStyles();            
            
            List<XWPFParagraph> paragraphs = document.getParagraphs();	
            List<XWPFTable> tables = document.getTables();
            List<XWPFPictureData> pictures = document.getAllPictures();
            
            //int Picture_ID = 0;
            for(XWPFPictureData picture: pictures){
                //XWPFPictureData picture = pictures.get(Picture_ID);
                    System.out.println("Picture: "+picture.getFileName());
                    byte[] pictureData = picture.getData();
                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(pictureData));
                    ImageIO.write(image, picture.getFileName(), file);
                    content.append("<p>");
                    content.append("Here must be image");
                    content.append("</p>");
                    //Picture_ID++;
            }
            
            Iterator<IBodyElement> bodyElementIterator = document.getBodyElementsIterator();
            int Table_ID = 0;
            int Paragraph_ID = 0;
            while(bodyElementIterator.hasNext()){
                
                IBodyElement element = bodyElementIterator.next();
                System.out.println(element.getElementType().name());//prints Element type name
                
                if("TABLE".equalsIgnoreCase(element.getElementType().name())){
                    
                    content.append("<table>");                    
                    XWPFTable table = tables.get(Table_ID);
                    CTTbl cttbl = table.getCTTbl();
                    CTTblPr cttblPr = cttbl.getTblPr();
                    
                    List<XWPFTableRow> tblRows = table.getRows();
                    for(XWPFTableRow tblRow : tblRows){
                        content.append("<tr>");                        
                        List<XWPFTableCell> tblCells = tblRow.getTableCells();
                        for(XWPFTableCell tblCell : tblCells){
                            content.append("<td>");                         
                            content.append(tblCell.getText());
                            content.append("</td>");
                        }                        
                        content.append("</tr>");
                    }                                        
                    content.append("</table>");
                    Table_ID++;
                    
                }else if("PARAGRAPH".equalsIgnoreCase(element.getElementType().name())){
                    
                    XWPFParagraph paragraph = paragraphs.get(Paragraph_ID);
                    
                    String styleClass = null;
                    if(paragraph.getStyleID()!=null){
                        content.append("<p class=''>");
                        XWPFStyle style = styles.getStyle(paragraph.getStyleID());
                        if(style!=null && style.getName()!=null){
                            //here will be code creation of tag with class style
                        }
                    }else{                        
                        content.append("<p>");
                    }
                    content.append(paragraph.getText());
                    content.append("</p>");
                    Paragraph_ID++;
                    
                }
            }
            
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
    
    public static void writeCodeToFile(String filename, String content) throws IOException{
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();
    }
}

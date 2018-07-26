/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;



/**
 *
 * @author dizurieta
 */
public class Config {
    private static String path = System.getProperty("file.separator");
    private static String root = System.getProperty("user.dir").concat(path);
    private static final  org.apache.logging.log4j.Logger logger = LogManager.getLogger("Config");
    private static Session session;

    public static void initializeLog4j2(){
        String  logFile = root.concat("config").concat(path).concat("Log4j2.xml");
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(logFile);
        context.setConfigLocation(file.toURI());
    }
    
    public static String pathResource (){
       String pathTemp  = root.concat("resources").concat(path);
       return pathTemp;
    }
    

    public static String pathImage (){
       String pathTemp  = pathResource().concat("images").concat(path);
       return pathTemp;
    }
    
    public static String pathCertify (){
       String pathTemp  = root.concat("certificacion").concat(path);
       return pathTemp;
    }
    public static String getValue(String Key){
        String setupFile = root.concat("config").concat(path).concat("setup.properties");
        String Value ="";
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(setupFile));
            Value = prop.getProperty(Key).toString();
        } catch (FileNotFoundException ex) {
            logger.error(ex);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return Value;
    }
    
    public static int getIntValue(String Key){
        String setupFile = root.concat("config").concat(path).concat("setup.properties");
        int Value =0;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(setupFile));
            Value = Integer.parseInt(prop.getProperty(Key).toString());
        } catch (FileNotFoundException ex) {
            logger.error(ex);
        } catch (IOException ex) {
            logger.error(ex);
        }
        return Value;
    }
    
    public static int getInt(String value){

        int Value =0;
        try {
            Value = Integer.parseInt(value);
        } catch (Exception ex) {
            logger.error(ex);
        }
        return Value;
    }
    
    public static Cursor cursor (){
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            cursorImg, new Point(0, 0), "blank cursor");
        return  blankCursor;
    }
    
    public static Image iconDefault(){
        String pathDefaultIcon = Config.pathImage().concat("certificado.png");
        Image imageDefaultIcon  = new ImageIcon(pathDefaultIcon).getImage();
        imageDefaultIcon = imageDefaultIcon.getScaledInstance(39, 39, java.awt.Image.SCALE_SMOOTH);
        return imageDefaultIcon;
                
    }
    
    public static void ssh(){
        try{
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session=jsch.getSession(Config.getValue("user"), Config.getValue("host"),Integer.parseInt(Config.getValue("lport")));
            session.setPassword(Config.getValue("password"));
            session.setConfig(config);
            session.connect();
            logger.info("Iniciacializando SSH...");
            int assinged_port=session.setPortForwardingL(Integer.parseInt(Config.getValue("lport")), Config.getValue("rhost"), Integer.parseInt(Config.getValue("rport")));
            logger.info("localhost:"+assinged_port+" -> "+Config.getValue("rhost")+":"+Config.getValue("rport"));
            logger.info("Port Forwarded...");
        }catch (Exception ex){
            logger.error("Exception: ", ex);
        }
    }
    
    public static void message(JFrame frame,String mensaje,String titulo,int option){
        JOptionPane.showMessageDialog(frame,mensaje,titulo,option);
    }
   
}

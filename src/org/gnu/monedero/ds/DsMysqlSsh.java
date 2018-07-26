/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.ds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gnu.monedero.utils.Config;

/**
 *
 * @author dizurieta
 */
public class DsMysqlSsh {
    private static final  Logger logs = LogManager.getLogger("DsMysql");
    private Connection connection = null; 
    
    protected void begin(){
        try {
            logs.info("Iniciacializando begin()...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(Config.getValue("drivermysqlssh"));
            connection.setSchema("academico");
        } catch (SQLException ex) {
            logs.error("SQLException: ",ex);
        } catch (ClassNotFoundException ex) {
            logs.error("ClassNotFoundException: ",ex);
        } catch (InstantiationException ex) {
            logs.error("InstantiationException: ",ex);
        } catch (IllegalAccessException ex) {
            logs.error("IllegalAccessException: ",ex);
        } catch(Exception ex){
                logs.error("Exception: ",ex);
        }
    }
    
    protected Connection getConnection(){
         return connection;
    }
    
    protected void close(){
        try {
            connection.close();
            logs.info("Cerrando close()...");
        } catch(SQLException ex) {
           logs.error("SQLException: ",ex);
        } catch(Exception ex){
                logs.error("Exception: ",ex);
        }
    }
    
}

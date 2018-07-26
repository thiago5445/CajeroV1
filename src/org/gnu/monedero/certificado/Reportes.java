/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.certificado;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gnu.monedero.ds.DsMysql;
import org.gnu.monedero.ds.DsMysqlSsh;
import org.gnu.monedero.utils.Config;

/**
 *
 * @author dizurieta
 */
public class Reportes extends DsMysqlSsh {
    private static final Logger logs = LogManager.getLogger("Reportes");
    
    public Reportes(){
        
    }
    
    public void imprimir(String cedula,String jasper){
        String imprimir = Config.getValue("imprime").toUpperCase();
        String vista = Config.getValue("vista").toUpperCase();
        boolean impresora = false;
        if (vista.equals("S")){
            impresora = true;
        }       
        try{
            begin();
            Connection connection = getConnection();
            if (connection != null) {
                String fileJasper = Config.getValue("certificadopath").concat(Config.getValue(jasper));
                if(Config.getValue("pathPrograma").equals("S")){
                    fileJasper = Config.pathCertify().concat(Config.getValue(jasper));
                }
                JasperReport reporte = (JasperReport) JRLoader.loadObject(new File(fileJasper));
                Map params = new HashMap();
                params.put("id",cedula);
                JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, params, connection);
                if (imprimir.equals("N")){
                    JasperViewer.viewReport(jasperPrint,false);
                }else{
                     JasperPrintManager.printReport( jasperPrint,impresora);
                }
            }
        }catch (Exception ex)
        {
          logs.error("Exception: ", ex);
        }    
        
    }
}

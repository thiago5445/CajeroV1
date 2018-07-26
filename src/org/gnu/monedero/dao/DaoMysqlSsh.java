/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.gnu.monedero.ds.DsMysqlSsh;
import org.gnu.monedero.entity.Estudiante;
import org.gnu.monedero.utils.Config;

public class DaoMysqlSsh
  extends DsMysqlSsh
{
  private static final Logger logs = LogManager.getLogger("DaoMysql");
  private Estudiante estudiante ;
  
  public boolean getValidacion(String id){
    boolean status = false;
    PreparedStatement ps;
    ResultSet rs;
    begin();
    Connection connection = getConnection();
    if (connection != null) {
      try
      {
          String Sql = String.format(Config.getValue("validacion"),id);
          ps = getConnection().prepareStatement(Sql);
          rs = ps.executeQuery();
          if(rs.next()){
              estudiante = new Estudiante(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7));
              status = true;
              
          }
      }catch (SQLException ex)
      {
       
        logs.error("SQLException: ", ex);
      }
      catch (Exception ex)
      {

        logs.error("Exception: ", ex);
      }
    }
    close();
    return status;
  }

    public Estudiante getEstudiante() {
        return estudiante;
    }
  
}
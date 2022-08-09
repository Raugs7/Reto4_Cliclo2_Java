/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rau.reto4.Modelo.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;

/**
 *
 * @author SKAPHE
 */
public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limite)throws SQLException {
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
          
        /**String sql = "SELECT C.ID_Proyecto, sum(C.Cantidad * M.Precio_Unidad) as VALOR " +
                "from Compra" + 
                "JOIN MaterialConstruccion M on C.ID_MaterialConstruccion = M.ID_MaterialConstruccion" +
                "where C.Pagado in ('No')" +
                "GROUP by C.ID_Proyecto" +
                "having sum(C.Cantidad * M.Precio_Unidad) > ?" +
                "order by VALOR DESC";**/
        
        String sql = " SELECT p.ID_Proyecto AS ID, SUM(c.Cantidad * mc.Precio_Unidad) AS VALOR " +
                " FROM Proyecto P " +
                " JOIN Compra c ON (p.ID_Proyecto = c.ID_Proyecto) " +
                " JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion) " + 
                " WHERE c.Pagado = 'No' " +
                " GROUP BY p.ID_Proyecto " +
                " HAVING VALOR > ? " +
                " ORDER BY VALOR DESC; ";
                
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, limite);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                DeudasPorProyectoVo deuda = new DeudasPorProyectoVo();
                
                deuda.setId(rs.getInt("ID"));
                deuda.setValor(rs.getDouble("Valor"));
                                
                respuesta.add(deuda);
            }
        }
        finally {
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if (conn != null){
                conn.close();
            }
        
        }      
                         
        return respuesta;
    }
}

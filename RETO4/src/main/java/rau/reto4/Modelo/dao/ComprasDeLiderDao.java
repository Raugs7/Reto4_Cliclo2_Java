/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import rau.reto4.Modelo.vo.ComprasDeLiderVo;
import rau.reto4.Modelo.vo.DeudasPorProyectoVo;
import util.JDBCUtilities;

/**
 *
 * @author SKAPHE
 */
public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar()throws SQLException {
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;                
        
        String sql = " SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER, sum(m.Precio_Unidad * c.Cantidad) as VALOR " + 
                " FROM Lider l " +
                " JOIN Proyecto p on l.ID_Lider = p.ID_Lider " +
                " JOIN Compra c on p.ID_Proyecto = c.ID_Proyecto " +
                " JOIN MaterialConstruccion m on c.ID_MaterialConstruccion = m.ID_MaterialConstruccion " +
                /**" FORMAT(CAST ((MONEY, VALOR)) " +**/
                " GROUP by LIDER " +
                " ORDER BY VALOR DESC " +
                " LIMIT 10; ";
        
             
                
        try{
            stmt = conn.prepareStatement(sql);            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                ComprasDeLiderVo lider = new ComprasDeLiderVo();                
                
                lider.setLider(rs.getString("Lider"));                
                lider.setValor(rs.getDouble("Valor"));
                                
                respuesta.add(lider);
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


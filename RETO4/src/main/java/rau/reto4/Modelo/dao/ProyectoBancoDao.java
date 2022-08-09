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
import rau.reto4.Modelo.vo.ProyectoBancoVo;
import util.JDBCUtilities;

/**
 *
 * @author SKAPHE
 */
public class ProyectoBancoDao {
    
    public List<ProyectoBancoVo> listar(String banco)throws SQLException {
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
          
        /**String sql = "SELECT ID_Proyecto as ID, Constructora, Ciudad, P.Clasificacion, Estrato, L.Nombre || ' ' || L.Primer_Apellido || ' ' || L.Segundo_Apellido LIDER from Proyecto JOIN Tipo T on P.ID_Tipo = T.ID_Tipo JOIN Lider L on P.ID_Lider = L.ID_Lider WHERE Banco_Vinculado is = ? ORDER by Fecha_Inicio DESC, Ciudad ASC, Constructora";**/
        
        String sql = " SELECT p.ID_Proyecto AS ID, p.Constructora, p.Ciudad, p.Clasificacion, " +
                " t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER " +
                " FROM Proyecto p " +
                " JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo) " +
                " JOIN Lider l ON (p.ID_Lider = l.ID_Lider) " +
                " WHERE p.Banco_Vinculado = ? " +
                " ORDER BY p.Fecha_Inicio DESC, p.Ciudad, p.Constructora; ";
                
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, banco);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                ProyectoBancoVo proyectoBancoVo = new ProyectoBancoVo();
                
                proyectoBancoVo.setId(rs.getInt("ID"));
                proyectoBancoVo.setConstructora(rs.getString("Constructora"));
                proyectoBancoVo.setCiudad(rs.getString("Ciudad"));
                proyectoBancoVo.setClasificacion(rs.getString("Clasificacion"));
                proyectoBancoVo.setEstrato(rs.getInt("Estrato"));
                proyectoBancoVo.setLider(rs.getString("LIDER"));
                
                respuesta.add(proyectoBancoVo);
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

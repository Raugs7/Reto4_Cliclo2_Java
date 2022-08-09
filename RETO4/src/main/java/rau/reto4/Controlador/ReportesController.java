/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Controlador;

import java.sql.SQLException;
import java.util.List;
import rau.reto4.Modelo.dao.ComprasDeLiderDao;
import rau.reto4.Modelo.dao.DeudasPorProyectoDao;
import rau.reto4.Modelo.dao.ProyectoBancoDao;
import rau.reto4.Modelo.vo.ComprasDeLiderVo;
import rau.reto4.Modelo.vo.DeudasPorProyectoVo;
import rau.reto4.Modelo.vo.ProyectoBancoVo;

/**
 *
 * @author SKAPHE
 */
public class ReportesController {
    
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    
    public ReportesController(){
        proyectoBancoDao = new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
    }
    
    public List <ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException{
        return proyectoBancoDao.listar(banco);
    }
    
   public List <DeudasPorProyectoVo> listarTotalAdeudadoProyectos(Double limite) throws SQLException{
        return deudasPorProyectoDao.listar(limite);
    }
   public List <ComprasDeLiderVo> listarLideresQueGastan() throws SQLException{
        return comprasDeLiderDao.listar();
    }
}

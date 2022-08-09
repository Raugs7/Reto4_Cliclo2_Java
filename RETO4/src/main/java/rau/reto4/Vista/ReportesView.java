/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Vista;

import java.util.List;
import rau.reto4.Controlador.ReportesController;
import rau.reto4.Modelo.vo.ComprasDeLiderVo;
import rau.reto4.Modelo.vo.DeudasPorProyectoVo;
import rau.reto4.Modelo.vo.ProyectoBancoVo;

/**
 *
 * @author SKAPHE
 */
public class ReportesView {
    
    private String repitaCaracter(Character caracter, Integer veces) {
    String respuesta = "";
    for (int i = 0; i < veces; i++) {
    respuesta += caracter;
    }
    return respuesta;
    }
    
    private static ReportesController controller;
    
    public ReportesView(){
        controller = new ReportesController();
    }
    
    public void proyectosFinanciadosPorBanco(String banco){
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
        System.out.println(repitaCaracter('-', 105));
        
        try {
            List<ProyectoBancoVo> proyectos = controller.listarProyectosPorBanco(banco);
            for(ProyectoBancoVo proyecto: proyectos){
                System.out.println(proyecto);                
        } 
        
        }catch (Exception e){
                System.out.println("Error: +" + e);
                e.printStackTrace();
                }
                
    }
    }
    
    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior){
            System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
            + repitaCaracter('=', 1));
            if (limiteInferior != null) {
                System.out.println(String.format("%3s %15s", "ID", "VALOR"));
                System.out.println(repitaCaracter('-', 29));

        
        try {
            List<DeudasPorProyectoVo> proyectos = controller.listarTotalAdeudadoProyectos(limiteInferior);
            for(DeudasPorProyectoVo proyecto: proyectos){
                System.out.println(proyecto);                
        } 
        
        }catch (Exception e){
                System.out.println("Error: +" + e);
                e.printStackTrace();
                }
                
    }
    }
    
    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
        + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR"));
        System.out.println(repitaCaracter('-', 41));
    
        try {
            List<ComprasDeLiderVo> proyectos = controller.listarLideresQueGastan();
            for(ComprasDeLiderVo proyecto: proyectos){
                System.out.println(proyecto);                
        } 
        
        }catch (Exception e){
                System.out.println("Error: +" + e);
                e.printStackTrace();
                }
                
    }  
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package rau.reto4;

import rau.reto4.Vista.ReportesView;

/**
 *
 * @author SKAPHE
 */
public class RETO4 {

    public static void main(String[] args) {
        /**var reportesView = new ReportesView();
        String banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco); **/
        
        /**var reportesView = new ReportesView();
        var limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);**/
        
        var reportesView = new ReportesView();
        reportesView. lideresQueMasGastan();
    }
}

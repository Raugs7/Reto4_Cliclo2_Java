/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Modelo.vo;

import java.text.DecimalFormat;

/**
 *
 * @author SKAPHE
 */
public class ComprasDeLiderVo {
    private String lider;
    private Double valor;

    /**
     * @return the lider
     */
    public String getLider() {
        return lider;
    }

    /**
     * @param lider the lider to set
     */
    public void setLider(String lider) {
        this.lider = lider;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        formatea.format(this.valor);
    }
    
    
    
    @Override
    public String toString(){
        
        return String.format("%-25s %15.1f", this.lider, this.valor);
        
    }
}

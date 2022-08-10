/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rau.reto4.Modelo.vo;

/**
 *
 * @author SKAPHE
 */
public class ProyectoBancoVo {
    
    private Integer id;
    private String constructora;
    private String ciudad;
    private String clasificacion;
    private Integer estrato;
    private String lider;
    
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the constructora
     */
    public String getConstructora() {
        return constructora;
    }

    /**
     * @param constructora the constructora to set
     */
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @return the estrato
     */
    public Integer getEstrato() {
        return estrato;
    }

    /**
     * @param estrato the estrato to set
     */
    public void setEstrato(Integer estrato) {
        this.estrato = estrato;
    }

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
    
    @Override
    public String toString(){
        return String.format("%3d %-25s %-20s %-15s %7d %-30s", 
                this.id, this.constructora,this.ciudad,this.clasificacion,this.estrato,this.lider);
        /*return this.id + "%3s" + this.constructora + "%-25s" + this.ciudad + "%-20s" + this.clasificacion + "%-15s" + this.estrato + " " + this.lider;*/
    }
           
    
}

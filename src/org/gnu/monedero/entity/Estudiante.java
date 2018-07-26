/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.entity;

/**
 *
 * @author dizurieta
 */
public class Estudiante {
    private String v_cedula;
    private String v_nombres;
    private String v_apellidos;
    private String v_carrera;
    private String v_nivel;
    private String v_paralelo;
    private String v_jornada;

    public Estudiante(String v_cedula, String v_nombres,String v_apellidos, String v_carrera, String v_nivel, String v_paralelo, String v_jornada) {
        this.v_cedula = v_cedula;
        this.v_nombres = v_nombres;
        this.v_apellidos = v_apellidos;
        this.v_carrera = v_carrera;
        this.v_nivel = v_nivel;
        this.v_paralelo = v_paralelo;
        this.v_jornada = v_jornada;
    }

    public String getV_cedula() {
        return v_cedula;
    }

    public void setV_cedula(String v_cedula) {
        this.v_cedula = v_cedula;
    }

    public String getV_nombres() {
        return v_nombres;
    }

    public void setV_nombres(String v_nombres) {
        this.v_nombres = v_nombres;
    }

    public String getV_apellidos() {
        return v_apellidos;
    }

    public void setV_apellidos(String v_apellidos) {
        this.v_apellidos = v_apellidos;
    }
    
    

    public String getV_carrera() {
        return v_carrera;
    }

    public void setV_carrera(String v_carrera) {
        this.v_carrera = v_carrera;
    }

    public String getV_nivel() {
        return v_nivel;
    }

    public void setV_nivel(String v_nivel) {
        this.v_nivel = v_nivel;
    }

    public String getV_paralelo() {
        return v_paralelo;
    }

    public void setV_paralelo(String v_paralelo) {
        this.v_paralelo = v_paralelo;
    }

    public String getV_jornada() {
        return v_jornada;
    }

    public void setV_jornada(String v_jornada) {
        this.v_jornada = v_jornada;
    }
    
    
    
}

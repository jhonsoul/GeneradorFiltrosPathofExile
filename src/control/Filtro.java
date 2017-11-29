/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Jhon
 */
public class Filtro {
    
    //Filtros
    private String nombre;
    private String visibilidad;
    private String nivelObjeto;
    private String calidad;
    private String rareza;
    private String claseObjeto;
    private String tipoBase;
    private String numeroHuecos;
    private String numeroUniones;
    private String coloresHuecos;
    private String identificado;
    private String corrupto;
    
    //Acciones
    private String colorBorde;
    private String colorTexto;
    private String colorFondo;
    private String sonidoAlerta;
    private String tamañoLetra;

    public Filtro() {
    }

    public Filtro(String nombre, String visibilidad, String nivelObjeto, String calidad, String rareza, String claseObjeto, String tipoBase, String numeroHuecos, String numeroUniones, String coloresHuecos, String identificado, String corrupto, String colorBorde, String colorTexto, String colorFondo, String sonidoAlerta, String tamañoLetra) {
        this.nombre = nombre;
        this.visibilidad = visibilidad;
        this.nivelObjeto = nivelObjeto;
        this.calidad = calidad;
        this.rareza = rareza;
        this.claseObjeto = claseObjeto;
        this.tipoBase = tipoBase;
        this.numeroHuecos = numeroHuecos;
        this.numeroUniones = numeroUniones;
        this.coloresHuecos = coloresHuecos;
        this.identificado = identificado;
        this.corrupto = corrupto;
        this.colorBorde = colorBorde;
        this.colorTexto = colorTexto;
        this.colorFondo = colorFondo;
        this.sonidoAlerta = sonidoAlerta;
        this.tamañoLetra = tamañoLetra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = "##\t" + nombre;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        if (visibilidad.equalsIgnoreCase("si")) {
            this.visibilidad = "Show";
        } else if (visibilidad.equalsIgnoreCase("no")) {
            this.visibilidad = "Hide";
        }
    }

    public String getNivelObjeto() {
        return nivelObjeto;
    }

    public void setNivelObjeto(String operadorUno, String nivel1Objeto, String operadorDos, String nivel2Objeto) {
        if (!operadorUno.isEmpty() && !nivel1Objeto.isEmpty()) {
            nivelObjeto = simplificacionOperadores("ItemLevel", operadorUno, nivel1Objeto);
        } 
        if (!operadorUno.isEmpty() && !nivel1Objeto.isEmpty() && !operadorDos.isEmpty() && !nivel2Objeto.isEmpty()) {
            nivelObjeto += "\n\t";
        }
        if (!operadorDos.isEmpty() && !nivel2Objeto.isEmpty()) {
            if (nivelObjeto == null) {
                nivelObjeto = "";
            }
            nivelObjeto += simplificacionOperadores("ItemLevel", operadorDos, nivel2Objeto);
        }
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String operador, String calidad) {
        if (!operador.isEmpty() && !calidad.isEmpty()) {
            this.calidad = simplificacionOperadores("Quality", operador, calidad);
        }
    }

    public String getRareza() {
        return rareza;
    }

    public void setRareza(String operador, String rareza) {
        if (!operador.isEmpty() && !rareza.isEmpty()) {
            this.rareza = simplificacionOperadores("Rarity", operador, rareza);
        }
    }

    public String getClaseObjeto() {
        return claseObjeto;
    }

    public void setClaseObjeto(String claseObjeto) {
        if (!claseObjeto.isEmpty()) {
            this.claseObjeto = "Class " + claseObjeto;
        }
    }

    public String getTipoBase() {
        return tipoBase;
    }

    public void setTipoBase(String tipoBase) {
        if (!tipoBase.isEmpty()) {
           this.tipoBase = "BaseType " + tipoBase; 
        }
    }

    public String getNumeroHuecos() {
        return numeroHuecos;
    }

    public void setNumeroHuecos(String operador, String numeroHuecos) {
        if (!numeroHuecos.isEmpty()) {
            this.numeroHuecos = simplificacionOperadores("Sockets", operador, numeroHuecos);
        }
    }

    public String getNumeroUniones() {
        return numeroUniones;
    }

    public void setNumeroUniones(String operador, String numeroUniones) {
        if (!numeroUniones.isEmpty()) {
            this.numeroUniones = simplificacionOperadores("LinkedSockets", operador, numeroUniones);
        }
    }

    public String getColoresHuecos() {
        return coloresHuecos;
    }

    public void setColoresHuecos(String color1, String color2, String color3, String color4, String color5, String color6) {
        String conjuntoColores = "";
        if (!color1.isEmpty()) {
            conjuntoColores = simplificarColores(color1);
        }
        if (!color2.isEmpty()) {
            conjuntoColores += simplificarColores(color2);
        }
        if (!color3.isEmpty()) {
            conjuntoColores += simplificarColores(color3);
        }
        if (!color4.isEmpty()) {
            conjuntoColores += simplificarColores(color4);
        }
        if (!color5.isEmpty()) {
            conjuntoColores += simplificarColores(color5);
        }
        if (!color6.isEmpty()) {
            conjuntoColores += simplificarColores(color6);
        }
        coloresHuecos = "SocketGroup " + conjuntoColores;
    }

    public String getIdentificado() {
        return identificado;
    }

    public void setIdentificado(String identificado) {
        if (!identificado.isEmpty()) {
            this.identificado = "Identified " + identificado;
        }
    }

    public String getCorrupto() {
        return corrupto;
    }

    public void setCorrupto(String corrupto) {
        if (!corrupto.isEmpty()) {
            this.corrupto = "Corrupted " + corrupto;
        }
    }

    public String getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(String colorBorde) {
        if (!colorBorde.isEmpty()) {
            this.colorBorde = "SetBorderColor " + colorBorde;
        }
    }

    public String getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(String colorTexto) {
        if (!colorTexto.isEmpty()) {
            this.colorTexto = "SetTextColor " + colorTexto;
        }
    }

    public String getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(String colorFondo) {
        if (!colorFondo.isEmpty()) {
            this.colorFondo = "SetBackgroundColor " + colorFondo;
        }
    }

    public String getSonidoAlerta() {
        return sonidoAlerta;
    }

    public void setSonidoAlerta(String sonidoAlerta, String volumen) {
        if (!sonidoAlerta.isEmpty() && !volumen.isEmpty()) {
            this.sonidoAlerta = "PlayAlertSound " + sonidoAlerta + " " + volumen;
        }
    }

    public String getTamañoLetra() {
        return tamañoLetra;
    }

    public void setTamañoLetra(String tamañoLetra) {
        if (!tamañoLetra.isEmpty()) {
            this.tamañoLetra = "SetFontSize " + tamañoLetra;
        }
    }
    
    private String simplificacionOperadores (String tipo, String operador, String valor) {
        String resultado = tipo;
        switch (operador) {
            case "Igual" :
                resultado += " = " + valor;
                break;
            case "Mayor que" :
                resultado += " > " +valor;
                break;
            case "Menor que" :
                resultado += " < " + valor;
                break;
            case "Mayor o igual que" :
                resultado += " >= " + valor;
                break;
            case "Menor o igual que" :
                resultado += " <= " + valor;
                break;
        }
        return resultado;
    }
    
    private String simplificarColores (String color) {
        String resultado = "";
        switch (color) {
            case "Rojo" :
                resultado = "R";
                break;
            case "Verde" :
                resultado = "G";
                break;
            case "Azul" :
                resultado = "B";
                break;
            case "Blanco" :
                resultado = "W";
                break;
        }
        return resultado;
    }
    
    public String packFiltro () {
        String filtro = nombre + "\n";
        filtro += visibilidad;
        if (nivelObjeto != null) {
            filtro += "\n\t" + nivelObjeto;
        }
        if (calidad != null) {
            filtro += "\n\t" + calidad;
        }
        if (rareza != null) {
            filtro += "\n\t" + rareza;
        }
        if (claseObjeto != null) {
            filtro += "\n\t" + claseObjeto;
        }
        if (tipoBase != null) {
            filtro += "\n\t" + tipoBase;
        }
        if (numeroHuecos != null) {
            filtro += "\n\t" + numeroHuecos;
        }
        if (numeroUniones != null) {
            filtro += "\n\t" + numeroUniones;
        }
        if (coloresHuecos != null) {
            filtro += "\n\t" + coloresHuecos;
        }
        if (identificado != null) {
            filtro += "\n\t" + identificado;
        }
        if (corrupto != null) {
            filtro += "\n\t" + corrupto;
        }
        if (colorBorde != null) {
            filtro += "\n\t" + colorBorde;
        }
        if (colorTexto != null) {
            filtro += "\n\t" + colorTexto;
        }
        if (colorFondo != null) {
            filtro += "\n\t" + colorFondo;
        }
        if (sonidoAlerta != null) {
            filtro += "\n\t" + sonidoAlerta;
        }
        if (tamañoLetra != null) {
            filtro += "\n\t" + tamañoLetra;
        }
        filtro += "\n";
        return filtro;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import vista.VistaMenu;

/**
 *
 * @author Jhon
 */
public class AlmacenaFiltro {

    private VistaMenu menu;
    
    public boolean guardaBloqueFiltro(String ruta, String informacion) {
        boolean guardo = false;
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar las siguiente lineas al filtro?\n\n" + informacion, "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            
            String texto = leerFiltro(ruta);

            if (!texto.isEmpty()) {
                texto += "\n";
            }

            texto += informacion;
            guardo = guardaArchivo(ruta, texto);
        }
        return guardo;
    }
    
    public boolean guardaArchivo (String ruta, String informacion) {
        boolean guardo = false;
        try {
                FileWriter escritura = new FileWriter(ruta);
                escritura.write(informacion);
                escritura.close();
                guardo = true;
                JOptionPane.showMessageDialog(null, "Filtro Guardado", "Operaccion exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(AlmacenaFiltro.class.getName()).log(Level.SEVERE, null, ex);
            }
        return guardo;
    }

    public String rutasGuardar() {
        String ruta = "";
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile().getAbsolutePath();
            if (!ruta.endsWith(".filter")) {
                ruta = ruta + ".filter";
            }
        }
        return ruta;
    }
    
    public String rutasAbrir() {
        String ruta = "";
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile().getAbsolutePath();
            if (!ruta.endsWith(".filter")) {
                ruta = ruta + ".filter";
            }
        }
        return ruta;
    }

    public String leerFiltro(String ruta) {
        File archivo = new File(ruta);
        String texto = "";
        if (archivo.canRead()) {
            try {
                FileReader lector = new FileReader(archivo);
                BufferedReader bufferLector = new BufferedReader(lector);
                String lineaLeida;
                while ((lineaLeida = bufferLector.readLine()) != null) {
                    texto += lineaLeida + "\n";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AlmacenaFiltro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlmacenaFiltro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return texto;
    }
    
    public void setMenu (VistaMenu menu) {
        this.menu = menu;
    }
}

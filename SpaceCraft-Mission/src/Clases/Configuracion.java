package Clases;
 
import java.awt.Color;
 
public class Configuracion {
    //Atributos
    private Color ColorNave;
    private String Teclas;
    //Constructor con Parametros
    public Configuracion(Color colorNave, int teclas) {
        ColorNave = colorNave;
        Teclas = " ";
    }
   
    //Constructor vacío
   
    public Configuracion(){
       
        this.ColorNave = Color.RED;
        this.Teclas = " ";
    }
 
 
   
    //Getter y Setters
    public Color getColorNave() {
        return ColorNave;
    }
 
    public void setColorNave(Color colorNave) {
        ColorNave = colorNave;
    }
 
    public String getTeclas() {
        return Teclas;
    }
 
    public void setTeclas(String teclas) {
        Teclas = teclas;
    }
 
    @Override
 
 
    //ToString
    public String toString() {
        return "Configuracion [ColorNave=" + ColorNave + ", Teclas=" + Teclas + "]";
    }
   
 
   
   
   
   
   
   
 
 
}
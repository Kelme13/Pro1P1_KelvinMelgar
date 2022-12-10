
package pro1p1_kelvinmelgar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kelvi
 */
public class frameLabotify extends JDialog implements ActionListener{
    
    ArrayList<Cancion> canciones = new ArrayList<>();
    
    JButton[] botones = new JButton[6];
    
    JPanel titulo;
    JPanel opciones;
    JLabel lbTitulo;
    
    
    public frameLabotify(Menu parent, boolean modal){
        
        super(parent, modal);
        
       
        this.setSize(450, 500);
        this.setTitle("Labotify");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        titulo = new JPanel();
        titulo.setLayout(null);
        titulo.setPreferredSize(new Dimension(450, 100));
        titulo.setBackground(new Color(234, 192, 183));
        
        lbTitulo = new JLabel("Labotify");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 40));
            lbTitulo.setBounds(125, 30, 300, 50);
        
        titulo.add(lbTitulo);
        
        opciones = new JPanel();
        opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 300,15));
        opciones.setPreferredSize(new Dimension(450, 320));
        for (int i = 0; i < botones.length; i++) {
            
            botones[i] = new JButton();
            
            //modfico cada boton
            switch(i){
                
                case 0:{
                    botones[i].setText("Agregar");
                    botones[i].addActionListener(this);
                    break;
                }
                
                case 1:{
                    botones[i].setText("Eliminar");
                    botones[i].addActionListener(this);
                    break;
                }
                
                case 2:{
                    botones[i].setText("Listar");
                    botones[i].addActionListener(this);
                    break;
                }
                
                case 3:{
                    botones[i].setText("Informacion");
                    botones[i].addActionListener(this);
                    break;
                }
                
                case 4:{
                    botones[i].setText("Modificar cancion");
                    botones[i].addActionListener(this);
                    break;
                }
                
                case 5:{
                    botones[i].setText("Volver Menu");
                    botones[i].addActionListener(this);
                    break;
                    
                }
            }
            
            botones[i].setPreferredSize(new Dimension(150, 35));
            botones[i].setFont(new Font("Candara", Font.PLAIN, 15));
            botones[i].setBackground(new Color(234, 192, 183));
            
            opciones.add(botones[i]);
            
        }//fin del for
        
        
        this.add(titulo, BorderLayout.NORTH);
        this.add(opciones, BorderLayout.SOUTH);
        
        
        this.setVisible(true);
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < botones.length; i++) {

            if (e.getSource() == botones[i]) {
                switch (i) {

                    case 0: {
                        this.agregar();
                        break;
                    }

                    case 1: {
                        this.eliminar();
                        break;
                    }

                    case 2: {
                        this.listar();
                        break;
                    }

                    case 3: {
                        this.informacion();
                        break;
                    }

                    case 4: {
                        this.modificar();
                        break;
                    }

                    case 5: {
                        this.dispose();
                        break;

                    }
                }
            }

        }
    }
    
    public void agregar(){
        String cancion = null;
        String album = null;
        String artista = null;
        int anio = 0;
        int durac = 0;
        
        
        //Validaciones necesarias o talvez no xD pero ahi estan
        cancion = (String) JOptionPane.showInputDialog(null,
                "Ingrese el nombre de la cancion.",
                "Agregar",
                JOptionPane.QUESTION_MESSAGE);

        if (cancion == null) {
            cancion = "";
        }

        if (cancion.length() != 0) {

            album = JOptionPane.showInputDialog(null,
                    "Ingrese el album de la cancion.",
                    "Agregar",
                    JOptionPane.QUESTION_MESSAGE);
            
            if(album == null)
                album = "";
            
            if (album.length() != 0){
                artista = JOptionPane.showInputDialog(null,
                    "Ingrese el nombre del artista.",
                    "Agregar",
                    JOptionPane.QUESTION_MESSAGE);
                
                if(artista == null)
                    artista = "";
                
                if(artista.length() != 0){
                    String sAnio = (JOptionPane.showInputDialog(null,
                    "Ingrese el año de la cancion.",
                    "Agregar",
                    JOptionPane.QUESTION_MESSAGE));
                    
                    if(sAnio == null){
                        sAnio = "0";
                    }
                    
                    anio = Integer.parseInt(sAnio);
                    if(anio > 0){
                        
                        String sDurac = (JOptionPane.showInputDialog(null,
                    "Ingrese la duracion de la cancion.",
                    "Agregar",
                    JOptionPane.QUESTION_MESSAGE));
                        
                        if(sDurac == null){
                            sDurac = "0";
                        }
                        
                        durac = Integer.parseInt(sDurac);
                        if(durac > 0){
                            
                            //Mira si la cancion ya esta en la lista
                            boolean rep = false;
                            Cancion temp = new Cancion(cancion, album, artista, anio, durac);
                            
                            if(!canciones.isEmpty()){
                                
                                for (int i = 0; i < canciones.size(); i++) {
                                    
                                    if(canciones.get(i).getInfo().equals(temp.getInfo())){
                                        rep = true;
                                        break;
                                    }
                                        
                                    
                                }
                            }
                        
                            if (!rep) {
                                //Agrega la cancion a la lista
                                canciones.add(new Cancion(cancion, album, artista, anio, durac));

                                JOptionPane.showMessageDialog(null,
                                        "Cancion agregada",
                                        "Agregar Cancion",
                                        JOptionPane.INFORMATION_MESSAGE);
                            } else{
                                JOptionPane.showMessageDialog(null,
                                        "La cancion ya esta en la lista",
                                        "Agregar Cancion",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            
                            
                            
                            
                        } else
                            JOptionPane.showMessageDialog(null,
                    "Debe ingresar cuanto dura la cancion.",
                    "Error", JOptionPane.OK_OPTION);
                        
                    } else
                        JOptionPane.showMessageDialog(null,
                    "Debe ingresar un año valido.",
                    "Error", JOptionPane.OK_OPTION);
                    
                    
                } else
                    JOptionPane.showMessageDialog(null,
                    "Debe ingresar un artista.",
                    "Error", JOptionPane.OK_OPTION);
                
            } else
                JOptionPane.showMessageDialog(null,
                    "Debe ingresar el album de la cancion",
                    "Error", JOptionPane.OK_OPTION);
        } else
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar el nombre de la cancion",
                    "Error", JOptionPane.OK_OPTION);
    
    
    }
    
    public void eliminar(){
        
        if(canciones.size() != 0){
            String elim_cancion = obtenerOpcion("Eliminar");
            
            if(elim_cancion.length() > 0){
                
                for (int i = 0; i < canciones.size(); i++) {
                    if(canciones.get(i).getCancion().equals(elim_cancion)){
                        canciones.remove(i);
                        
                        JOptionPane.showMessageDialog(null,
                                    "Eliminaste \" " + elim_cancion + " \"",
                                    "Eliminar cancion",
                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
                
            }
            
            
        }else
            JOptionPane.showMessageDialog(null,
                                    "No hay canciones actualmente",
                                    "Eliminar cancion",
                                    JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void listar() {
        
        if (!canciones.isEmpty()) {
            String cadena_canciones = "Cancions que tiene actualmente\n\n";

            for (int i = 0; i < canciones.size(); i++) {

                cadena_canciones += (i + 1) + "." + canciones.get(i).toString();
                cadena_canciones += "\n";

            }
            
            JOptionPane.showMessageDialog(null,
                                    cadena_canciones,
                                    "Listar Canciones",
                                    JOptionPane.INFORMATION_MESSAGE);
            
            
            
            
        }else
            JOptionPane.showMessageDialog(null,
                                    "No tiene canciones actualmente",
                                    "Listar Canciones",
                                    JOptionPane.WARNING_MESSAGE);
        

        
    }
    
    public void modificar(){
        if(canciones.size() != 0){
            String modif_cancion = obtenerOpcion("Modificar");
            
            if(modif_cancion.length() > 0){
                
                for (int i = 0; i < canciones.size(); i++) {
                    if(canciones.get(i).getCancion().equals(modif_cancion)){
                        
                        
                        frameModificar modificar = new frameModificar(this, true, canciones.get(i));
                        
                        //seteo los valores modificados en el frameModificar
                        canciones.get(i).setCancion(modificar.cancion.getCancion());
                        canciones.get(i).setAlbum(modificar.cancion.getAlbum());
                        canciones.get(i).setArtista(modificar.cancion.getArtista());
                        canciones.get(i).setAnio(modificar.cancion.getAnio());
                        canciones.get(i).setDurac(modificar.cancion.getDurac());
                        
                    }
                    
                }
                
            }
            
            
        }else
            JOptionPane.showMessageDialog(null,
                                    "No hay canciones actualmente",
                                    "Modificar cancion",
                                    JOptionPane.INFORMATION_MESSAGE);
        
        
    }
    
    public void informacion(){
        if(!canciones.isEmpty()){
            String inf_cancion = obtenerOpcion("obtener informacion");
            
            if(inf_cancion.length() > 0){
                
                for (int i = 0; i < canciones.size(); i++) {
                    if(canciones.get(i).getCancion().equals(inf_cancion)){
                        
                        JOptionPane.showMessageDialog(null,
                                    canciones.get(i).getInfo(),
                                    "Informacion cancion",
                                    JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
                
            }
            
            
        }else
            JOptionPane.showMessageDialog(null,
                                    "No hay canciones actualmente",
                                    "Informacion",
                                    JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    
    //Metodo que retorna la cancion que el usuario seleccion para su accion correspondiente
    public String obtenerOpcion(String opcion) {
        String cadena_canciones = "Seleccione la cancion que desea "+ opcion+ "\n\n";
        String[] arreglo_canciones = new String[canciones.size()];

        for (int i = 0; i < canciones.size(); i++) {

            cadena_canciones += (i + 1) + "." + canciones.get(i).toString();
            cadena_canciones += "\n";

            arreglo_canciones[i] = canciones.get(i).getCancion();

        }
        cadena_canciones += "\n";

        String opc_cancion;

        opc_cancion = (String) JOptionPane.showInputDialog(null,
                cadena_canciones,
                opcion,
                JOptionPane.QUESTION_MESSAGE,
                null,
                arreglo_canciones,
                arreglo_canciones[0]);

        if (opc_cancion == null) {
            opc_cancion = "";
        }
        
        return opc_cancion;

    }
}

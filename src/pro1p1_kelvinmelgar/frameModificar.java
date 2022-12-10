
package pro1p1_kelvinmelgar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author kelvi
 */
public class frameModificar extends JDialog implements ActionListener{
    Cancion cancion;
    
    JPanel titulo;
    JPanel pl_etiq;
    JPanel pl_campos;
    JLabel lbTitulo;
    JPanel pl_botones;
    JLabel[] etiquetas;
    JTextField[] campos;
    
    JButton btModificar;
    JButton btCancelar;
    
    public frameModificar(frameLabotify parent, boolean modal, Cancion cancion) {
        
        super(parent, modal);
        
        
        this.cancion = cancion;
        this.setSize(450, 500);
        this.setTitle("Labotify");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        
        titulo = new JPanel();
        titulo.setLayout(null);
        titulo.setPreferredSize(new Dimension(450, 100));
        titulo.setBackground(new Color(234, 192, 183));
        
        lbTitulo = new JLabel("Modificar Cancion");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 25));
        lbTitulo.setBounds(125, 30, 300, 50);
        
        titulo.add(lbTitulo);
        
        pl_etiq = new JPanel();
        pl_etiq.setLayout(new FlowLayout(FlowLayout.LEADING, 150,26));
        pl_etiq.setPreferredSize(new Dimension(225, 280));
        
        etiquetas = new JLabel[5];
        
        for (int i = 0; i < etiquetas.length; i++) {
            etiquetas[i] = new JLabel();
            
            switch(i){
                
                case 0:{
                    etiquetas[i].setText("Cancion: ");
                    break;
                }
                
                case 1:{
                    etiquetas[i].setText("Album: ");
                    break;
                }
                
                case 2:{
                    etiquetas[i].setText("Artista: ");
                    break;
                }
                
                case 3:{
                    etiquetas[i].setText("Año: ");
                    break;
                }
                
                case 4:{
                    etiquetas[i].setText("Duracion: ");
                    break;
                }
            }
            
            etiquetas[i].setSize(50, 20);
            etiquetas[i].setFont(new Font("Consolas", Font.PLAIN, 14));
            
            pl_etiq.add(etiquetas[i]);
        }
        
        pl_campos = new JPanel();
        pl_campos.setLayout(new FlowLayout(FlowLayout.LEADING, 25,15));
        pl_campos.setPreferredSize(new Dimension(225, 280));
        campos = new JTextField[5];
        
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField();
            
            switch(i){
                
                case 0:{
                    campos[i].setText(cancion.getCancion());
                    break;
                }
                
                case 1:{
                    campos[i].setText(cancion.getAlbum());
                    break;
                }
                
                case 2:{
                    campos[i].setText(cancion.getArtista());
                    break;
                }
                
                case 3:{
                    campos[i].setText(cancion.getAnio()+"");
                    break;
                }
                
                case 4:{
                    campos[i].setText(cancion.getDurac()+"");
                    break;
                }
            }
            
            campos[i].setPreferredSize(new Dimension(100, 30));
            campos[i].setFont(new Font("Consolas", Font.PLAIN, 13));
            
            pl_campos.add(campos[i]);
        }
        
        pl_botones = new JPanel();
        pl_botones.setLayout(new FlowLayout(FlowLayout.CENTER, 25,15));
        pl_botones.setPreferredSize(new Dimension(225, 100));
        
        btModificar = new JButton("Modificar");
        btModificar.setPreferredSize(new Dimension(150, 35));
        btModificar.setFont(new Font("Candara", Font.PLAIN, 15));
        btModificar.setBackground(new Color(234, 192, 183));
        btModificar.addActionListener(this);
        
        btCancelar = new JButton("Cancelar");
        btCancelar.setPreferredSize(new Dimension(150, 35));
        btCancelar.setFont(new Font("Candara", Font.PLAIN, 15));
        btCancelar.setBackground(new Color(234, 192, 183));
        btCancelar.addActionListener(this);
        
        pl_botones.add(btModificar);
        pl_botones.add(btCancelar);
        
        this.add(titulo, BorderLayout.NORTH);
        this.add(pl_etiq, BorderLayout.WEST);
        this.add(pl_campos, BorderLayout.EAST);
        this.add(pl_botones, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btModificar){
            System.out.println(campos[0].getText());
            cancion.setCancion(campos[0].getText());
            cancion.setAlbum(campos[1].getText());
            cancion.setArtista(campos[2].getText());
            cancion.setAnio(Integer.parseInt(campos[3].getText()));
            cancion.setDurac(Integer.parseInt(campos[4].getText()));
            
            this.dispose();
        }

        if(e.getSource() == btCancelar){
            this.dispose();
        }
    }
    
}

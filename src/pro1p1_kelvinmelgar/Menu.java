
package pro1p1_kelvinmelgar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kelvi
 */
public class Menu extends JFrame implements ActionListener{
    
    JLabel titulo;
    JLabel nombre;
    
    JButton btLabotify;
    JButton btRecursion;
    
    //constructor del menu
    Menu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 500);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(240,234,234));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        JPanel banner = new JPanel();
        banner.setPreferredSize(new Dimension(500,150));
        banner.setLayout(null);
        banner.setBackground(new Color(159, 178, 178));
        
        titulo = new JLabel("Proyecto Programacion I");
        titulo.setFont(new Font("LCDMono2", Font.PLAIN, 33));
        titulo.setBounds(55, 10, 400, 50);
        
        nombre = new JLabel("Kelvin J. Melgar Quiroz");
        nombre.setFont(new Font("Candara", Font.PLAIN, 16));
        nombre.setBounds(160, 60, 200, 50);
        
        banner.add(titulo);
        banner.add(nombre);
        
        JPanel opciones = new JPanel();
        opciones.setPreferredSize(new Dimension(500,220));
        opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 50,25));
        
       
        
        btLabotify = new JButton("Labotify");
        btLabotify.setPreferredSize(new Dimension(150, 55 ));
        btLabotify.setBackground(new Color(234, 192, 183));
        btLabotify.setForeground(new Color(73, 47, 42));
        btLabotify.setFont(new Font("Candara", Font.PLAIN, 18));
        btLabotify.setFocusable(false);
        btLabotify.setHorizontalTextPosition(JButton.CENTER);
        btLabotify.setVerticalTextPosition(JButton.CENTER);
        btLabotify.addActionListener(this);
        
        btRecursion = new JButton("Recursion");
        btRecursion.setFont(new Font("Candara", Font.PLAIN, 18));
        btRecursion.setPreferredSize(new Dimension(150, 55 ));
        btRecursion.setBackground(new Color(234, 192, 183));
        btRecursion.setForeground(new Color(73, 47, 42));
        btRecursion.setFocusable(false);
        btRecursion.addActionListener(this);
        
        
        opciones.add(btLabotify);
        opciones.add(btRecursion);
        
        this.add(banner, BorderLayout.NORTH);
        this.add(opciones, BorderLayout.SOUTH);
        
        this.repaint();
        this.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btLabotify){
            frameLabotify frameLabotify = new frameLabotify(this, true);
        }
        
        if(e.getSource() == btRecursion){
            
            frameRecursion frameRecursion = new frameRecursion(this, true);
            
        }
    }
    
    
}

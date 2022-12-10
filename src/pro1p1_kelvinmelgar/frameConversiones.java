
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kelvi
 */
public class frameConversiones extends JDialog implements ActionListener {
    
    Recursividad recursivos;
    
    JPanel titulo;
    JPanel opciones;
    JLabel lbTitulo;

    JButton btBi_dec;
    JButton btDec_bi;
    JButton btMenu;

    public frameConversiones(Menu parent, boolean modal) {

        super(parent, modal);
        
        recursivos = new Recursividad();

        this.setSize(450, 500);
        this.setTitle("Labotify");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        titulo = new JPanel();
        titulo.setLayout(null);
        titulo.setPreferredSize(new Dimension(450, 100));
        titulo.setBackground(new Color(234, 192, 183));

        lbTitulo = new JLabel("Conversiones");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 40));
        lbTitulo.setBounds(125, 30, 300, 50);

        titulo.add(lbTitulo);

        opciones = new JPanel();
        opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 50));
        opciones.setPreferredSize(new Dimension(450, 320));

        btBi_dec = new JButton("Binario a Decimal");
        btBi_dec.setPreferredSize(new Dimension(150, 35));
        btBi_dec.setFont(new Font("Candara", Font.PLAIN, 15));
        btBi_dec.setBackground(new Color(159, 178, 178));
        btBi_dec.setFocusable(false);
        btBi_dec.addActionListener(this);
        
        btDec_bi = new JButton("Decimal a Binario");
        btDec_bi.setPreferredSize(new Dimension(150, 35));
        btDec_bi.setFont(new Font("Candara", Font.PLAIN, 15));
        btDec_bi.setBackground(new Color(159, 178, 178));
        btDec_bi.setFocusable(false);
        btDec_bi.addActionListener(this);
        
        btMenu = new JButton("Menu");
        btMenu.setPreferredSize(new Dimension(150, 35));
        btMenu.setFont(new Font("Candara", Font.PLAIN, 15));
        btMenu.setBackground(new Color(159, 178, 178));
        btMenu.setFocusable(false);
        btMenu.addActionListener(this);
        
        opciones.add(btBi_dec);
        opciones.add(btDec_bi);
        opciones.add(btMenu);
        
        this.add(titulo, BorderLayout.NORTH);
        this.add(opciones, BorderLayout.SOUTH);
        
        this.setVisible(true);

    
}

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btBi_dec){
            
            String n_usuario = JOptionPane.showInputDialog(null,
                    "Ingrese un numero Binario","Binario a Decimal" 
                    , JOptionPane.QUESTION_MESSAGE);
            
            boolean paso = true;
            for (int i = 0; i < n_usuario.length(); i++) {
                
                if(n_usuario.charAt(i) != '0' && n_usuario.charAt(i) != '1'){
                    
                    System.out.println(n_usuario.charAt(i));
                    paso = false;
                    break;
                }
                    
            }
            
            if(paso){
                recursivos.resetearContador();
                
                JOptionPane.showMessageDialog(null,
                        "Numero Decimal :\n" + recursivos.Binario_Dec(Integer.parseInt(n_usuario)),
                        "Binario a Decimal", JOptionPane.INFORMATION_MESSAGE);
            }else{
                
                JOptionPane.showMessageDialog(null, "ERROORR\n Debe ingresar un numero binario valido",
                        "Binario a Decimal", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        if(e.getSource() == btDec_bi){
            
            String n_usuario = JOptionPane.showInputDialog(null,
                    "Ingrese un numero Decimal","Decimal a Binario" 
                    , JOptionPane.QUESTION_MESSAGE);
            
            boolean paso = true;
            /*for (int i = 0; i < n_usuario.length(); i++) {
                
                if(n_usuario.charAt(i) != '0' && n_usuario.charAt(i) != '1'){
                    
                    System.out.println(n_usuario.charAt(i));
                    paso = false;
                    break;
                }
                    
            }*/
            
            if(paso){
                recursivos.resetearContador();
                
                JOptionPane.showMessageDialog(null,
                        "Numero Binario :\n" + recursivos.Decimal_Bi(Integer.parseInt(n_usuario)),
                        "Decimal a Binario", JOptionPane.INFORMATION_MESSAGE);
            }else{
                
                JOptionPane.showMessageDialog(null, "ERROORR\n Debe ingresar un numero binario valido",
                        "Binario a Decimal", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        
        if(e.getSource() == btMenu){

            
            this.dispose();
            
        
        }
        

    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro1p1_kelvinmelgar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kelvi
 */
public class frameRecursion extends JDialog implements ActionListener{

    Recursividad recursivos;
    
    JPanel titulo;
    JPanel opciones;
    JLabel lbTitulo;

    JButton btConversiones;
    JButton btMatrices;
    JButton btMenu;
    Menu parent;

    public frameRecursion(Menu parent, boolean modal) {

        super(parent, modal);
        this.parent = parent;
        
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

        lbTitulo = new JLabel("Recursion");
        lbTitulo.setFont(new Font("Consolas", Font.PLAIN, 40));
        lbTitulo.setBounds(125, 30, 300, 50);

        titulo.add(lbTitulo);

        opciones = new JPanel();
        opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 50));
        opciones.setPreferredSize(new Dimension(450, 320));

        btConversiones = new JButton("Conversiones");
        btConversiones.setPreferredSize(new Dimension(150, 35));
        btConversiones.setFont(new Font("Candara", Font.PLAIN, 15));
        btConversiones.setBackground(new Color(159, 178, 178));
        btConversiones.setFocusable(false);
        btConversiones.addActionListener(this);
        
        btMatrices = new JButton("Matrices");
        btMatrices.setPreferredSize(new Dimension(150, 35));
        btMatrices.setFont(new Font("Candara", Font.PLAIN, 15));
        btMatrices.setBackground(new Color(159, 178, 178));
        btMatrices.setFocusable(false);
        btMatrices.addActionListener(this);
        
        btMenu = new JButton("Menu");
        btMenu.setPreferredSize(new Dimension(150, 35));
        btMenu.setFont(new Font("Candara", Font.PLAIN, 15));
        btMenu.setBackground(new Color(159, 178, 178));
        btMenu.setFocusable(false);
        btMenu.addActionListener(this);
        
        opciones.add(btConversiones);
        opciones.add(btMatrices);
        opciones.add(btMenu);
        
        this.add(titulo, BorderLayout.NORTH);
        this.add(opciones, BorderLayout.SOUTH);
        
        this.setVisible(true);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == btConversiones){
            this.dispose();
            new frameConversiones(parent, true);
            
        }
        
        if(e.getSource() == btMatrices){
            
            int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de filas de la primer Matriz",
                    "Matriz a", JOptionPane.INFORMATION_MESSAGE));
            
            int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de columnas de la primer Matriz",
                    "Matriz a", JOptionPane.INFORMATION_MESSAGE));
            
            int[][] a = new int[x][y];
            
            x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de filas de la segunda Matriz",
                    "Matriz b", JOptionPane.INFORMATION_MESSAGE));
            
            y = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño de columnas de la segunda Matriz",
                    "Matriz b", JOptionPane.INFORMATION_MESSAGE));
            
            int[][] b = new int[x][y];
            
            if(a[0].length == b.length){
                
                a = recursivos.llenarMatriz(a, a.length-1, a[0].length-1);
                
                b = recursivos.llenarMatriz(b, b.length-1, b[0].length-1);
                
                int[][] c = new int[a.length][b[0].length];
           
                int[][] multiplicacion = recursivos.multiplicacion(a, b, c, 0, 0);


                int n_mayor = 0;

                for (int i = 0; i < c.length; i++) {

                    for (int j = 0; j < c[0].length; j++) {

                        if (n_mayor < c[i][j]) {
                            n_mayor = c[i][j];
                        }

                    }
                }

                String cad = "" + n_mayor;
                int cifras = cad.length();
                
                String cadena = "MATRIZ A\n" + recursivos.imprimirMatriz(a, a.length-1, a[0].length-1, "",1);
                cadena += "\n\nMATRIZ B\n" + recursivos.imprimirMatriz(b, b.length-1, b[0].length-1, "",1);
                cadena += "\n\nMULTIPLICACION\n" + recursivos.imprimirMatriz(multiplicacion, multiplicacion.length-1, multiplicacion[0].length-1, "",cifras);
                
                JOptionPane.showMessageDialog(this, cadena,
                        "Multiplicacion de Matrices Recursivas", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                JOptionPane.showMessageDialog(null, "LAS MATRICES NO SE PUEDEN MULTIPLICAR !!!",
                        "Multiplicar Matrices", 
                        JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
        if(e.getSource() == btMenu){
            this.dispose();
            
        }
       
    }
    
}

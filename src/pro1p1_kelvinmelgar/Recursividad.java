/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro1p1_kelvinmelgar;

/**
 *
 * @author kelvi
 */
import java.util.Random;
public class Recursividad {
    Random rand = new Random();
    
    int cont;                                           //Contador para la conversion de binario a decimal inicia en cero
    
    //Conversiones
    public int Binario_Dec(int n){                      //inicio con el valor de n
                                
        if (n > 0) {                                    //Mientres ese numero sea mayor a cero va bien
            int e = (int) Math.pow(2, cont);       //Primero obtiene el resulta de 2 elevado al valor de contador que inicia en cero y va aumentando 
            int i = n % 10;                            //Obtiene el ultimo digito de n

            cont++;                                    //Aumenta el contador
            return i * e + Binario_Dec(n / 10);        //Retorna i(el ultimo digito de n) y lo multiplica con (2 elevado al actual posicion de ese ultimo digito de n en el numero original
                                                       // que se obtiene gracias al contador y lo suma con lo que retornaria este mismo metodo pero sin el ultimo digito de n.
        } else
            return 0;                                   //cuando n llegue a cero significa que ya no quedan mas valores que sumar
        
    }
    
    public void resetearContador(){
        
        //Metodo para resetear el contador de Binario a decimal
        this.cont = 0;
    }
    
    public String Decimal_Bi(int n){
        
        if (n > 1) {
            String res = n % 2 + "";

            return Decimal_Bi(n / 2) + res;

        } else {
            return 1 + "";
        }


    }
    
    
    //Matrices
    
    public int[][] llenarMatriz(int[][] a, int f, int c){
        
        if(f > 0){
            
            if(c > 0){
                
                a[f][c] = rand.nextInt(10);
                
                return llenarMatriz(a, f, c-1 );
                
            }else{
                
                a[f][c] = rand.nextInt(10);
                return llenarMatriz(a, f - 1, a[0].length-1);
                
            }
            
        }else{
            if(c > 0){
                
                a[f][c] = rand.nextInt(10);
                
                return llenarMatriz(a, f, c-1 );
                
            }else{
                
                a[f][c] = rand.nextInt(10);
                return a;
                
            }
        }
        
    }
    
    
    public String imprimirMatriz(int[][] a, int f, int c, String cadena){
        
        
       if(f > 0){
            
            if(c > 0){
                cadena += a[a.length-1 - f][a[0].length-1 - c] + " ";
                
                return imprimirMatriz(a, f, c-1, cadena);
                
                
            }else{
                
                cadena += a[a.length-1 - f][a[0].length-1 - c] + "\n";
                
                return imprimirMatriz(a, f-1, a[0].length-1, cadena);
                
            }
            
        }else{
            if(c > 0){
                cadena += a[a.length-1 - f][a[0].length-1 - c] + " ";
                
                return imprimirMatriz(a, f, c-1, cadena);
              
                
            }else{
                cadena += a[a.length-1 - f][a[0].length-1 - c];
                return cadena;
                
            }
        }
            
        
        
    }
    
    
    public int rowProduct (int[][] a, int[][] b, int i, int j , int k){
        
        if(k <= a[0].length-1){
            
            
            return (a[i][k] * b[k][j]) + rowProduct(a, b, i, j, k+1);
            
        }else{
            
            return 0;
            
        }
        
        
    }
    
    public int[][] multiplicacion (int[][] a, int[][] b, int[][] c, int i, int j){
        
        if(i < a.length-1){
            
            if(j < b[0].length-1){
                
                System.out.println("["+i+"]"+"["+j+"]");
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                return multiplicacion(a, b, c, i, j+1);
                
            }else{
                System.out.println("\n\n\n");
                c[i][j] = rowProduct(a, b, i, j, 0);
                return multiplicacion(a, b, c,i+1, 0 );
            }
            
            
        }else
            if(j < b[0].length-1){
                
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                System.out.println("["+i+"]"+"["+j+"]");
                
                return multiplicacion(a, b, c, i, j+1);
                
            }else{
                System.out.println("\n\n\n");
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                
                return c;
            }
        
        
    }
}

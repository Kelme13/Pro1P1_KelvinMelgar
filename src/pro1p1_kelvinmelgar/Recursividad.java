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
            
            if(n == 1){
                return 1 + "";
            }else
                return 0 + "";
            
        }
        
        /*
        En cada llamado obtiene el residuo de ese numero que le envia 
        y retorna como retorna un String agrego ese residuo de ultimo 
        para que tengo el orden correcto
        
        pero cada vez que llama al metodo lo hace con el cociente de dividirlo por 2
        
        pero si ese numero llega a 0 o 1 unicamente retorna ese cociente 
        
        */


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
    
    
    public String imprimirMatriz(int[][] a, int f, int c, String cadena, int cifras){
        
        
       if(f > 0){
            
            if(c > 0){
                String formato = "[%0" + cifras + "d]  ";
                cadena += String.format(formato, a[a.length-1 - f][a[0].length-1 - c]);
                
                return imprimirMatriz(a, f, c-1, cadena, cifras);
                
                
            }else{
                String formato = "[%0" + cifras + "d]%n";
                cadena += String.format(formato, a[a.length-1 - f][a[0].length-1 - c]);
                
                return imprimirMatriz(a, f-1, a[0].length-1, cadena, cifras);
                
            }
            
        }else{
            if(c > 0){
                String formato = "[%0" + cifras + "d]  ";
                cadena += String.format(formato, a[a.length-1 - f][a[0].length-1 - c]);
                
                return imprimirMatriz(a, f, c-1, cadena, cifras);
              
                
            }else{
                String formato = "[%0" + cifras + "d]  ";
                cadena += String.format(formato, a[a.length-1 - f][a[0].length-1 - c]);
                return cadena;
                
            }
        }
            
        /*
       agrega un formato agregandole ceros a la izquierda dependiendo del numero mayor
       de cifras, para que se vea simetrica la matriz ^^
       */
        
    }
    
    
    public int rowProduct (int[][] a, int[][] b, int i, int j , int k){
        
        if(k <= a[0].length-1){
            
            
            return (a[i][k] * b[k][j]) + rowProduct(a, b, i, j, k+1);
            
        }else{
            
            return 0;
            
        }
        
        /*
        Se basa en el numero de columnas que cuenta la matriz a para multiplicarlas con 
        las filas de la matriz b (ya que son del mismo tamaño, en cada llamadado
        al metodo retorna la sumatoria de todos en la fila a y en la columna de b 
        gracias al contador "k", cuando este contador sea mayor que el tamaño de
        la columna de la matriz "a", solamente retorna 0, no altera el valor ya que
        solamente se estan sumando estos retornos.
        
        */
        
        
    }
    
    public int[][] multiplicacion (int[][] a, int[][] b, int[][] c, int i, int j){
        
        if(i < a.length-1){
            
            if(j < b[0].length-1){
                
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                return multiplicacion(a, b, c, i, j+1);
                
            }else{
                c[i][j] = rowProduct(a, b, i, j, 0);
                return multiplicacion(a, b, c,i+1, 0 );
            }
            
            
        }else
            if(j < b[0].length-1){
                
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                
                return multiplicacion(a, b, c, i, j+1);
                
            }else{
                
                c[i][j] = rowProduct(a, b, i, j, 0);
                
                
                return c;
            }
        
        
        /*
        Primeramente como en el metodo de imprimir y llenar, recorre toda la 
        matriz "c" y en cada recorrido (llamado) requiere la matriz a, la matriz b, la matriz c
        el indice de la matriz c de la fila y columnas-
        Ya que incialmente estos indice inician en (0, 0)
        
        Primero recorre los elementos en cada fila (columnas) y por eso en el primer caso
        en cada llamado le suma 1 al indice de las columnas, cuando llega al ultimo 
        elemento en la columna, llama al metodo de rowProduct con esos indices
        pero cuando se llama a si mismo le suma 1 a la fila y resetea el indice de la columna
        a 0, para volver a iniciar el recorrido de las columnas pero en la siguiente fila
        
        Ya en el ultimo caso, de las filas recorre las columnas pero en la ultimas ocasion
        solo asigna el valor de rowProduct en esa posicion y retorna la matriz c .
        */
    }
}

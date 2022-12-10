
package pro1p1_kelvinmelgar;

/**
 *
 * @author kelvi
 */
public class Cancion {
    
    private String cancion;
    private String album;
    private String artista;
    private int anio;
    private int durac;
    
    Cancion(String cancion, String album, String artista, int anio, int durac ){
        
        this.cancion = cancion;
        this.album = album;
        this.artista = artista;
        this.anio = anio;
        this.durac = durac;
    }
    
    public String getCancion(){
        return cancion;
    }
    
    public String getAlbum(){
        return album;
    }
    
    public String getArtista(){
        return artista;
    }
    
    public int getAnio(){
        return anio;
    }
    
    public int getDurac(){
        return durac;
    }
    
    public void setCancion(String cancion){
        this.cancion = cancion;
    }
    
    public void setAlbum(String album){
        this.album = album;
    }
    
    public void setArtista(String artista){
        this.artista = artista;
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public void setDurac(int durac){
        this.durac = durac;
    }
    
    public String toString(){
        String cadena;
        
        cadena = this.getCancion() + " - " + this.getArtista();
        
        return cadena;
    }
    
    public String getInfo(){
        
        String cadena;
        
        cadena = String.format("Cancion: %s%nAlbum: %s%nArtista: %s%nAño : %d%nDuracion: %d%n",
                this.cancion, this.album, this.artista, this.anio, this.durac);
        
        return cadena;
    }
}

package paseoperros.Asistida;

// @author camil
public class Calculos {
    
    public int con=0;
    public double cosT;
    public int[] tpPerro={10000,5000,3000};

    
    
    public void calcularCostoTotal(int h, int i){
        cosT+=h*tpPerro[i-1];
        con++;
    }
    
    public void calcularDescuento(){
        cosT-=(cosT*10)/100;
    }

    public double getCosT() {
        return cosT;
    }
    
}
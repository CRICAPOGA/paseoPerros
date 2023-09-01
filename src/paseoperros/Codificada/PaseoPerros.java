package paseoperros.Codificada;

// @author camil

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import paseoperros.Asistida.Calculos;

public class PaseoPerros extends JFrame implements Action{
    
    //Variables
    JLabel l1, l2,l3,l4,numP;
    JTextField t1,t2;
    JButton b1,b2;
    
    int tpPer,hora;
    //Crea el objeto para realizar los calculos
    Calculos calculos = new Calculos();
    
    public static void main(String[] args) {
        PaseoPerros paseo = new PaseoPerros();
    }
    
    //Constructor

    public PaseoPerros(){
        
        
        //Crea la ventana
        setBounds(0,0,300,300);
        setLayout(new FlowLayout());
        
        //Texto y campo
        l1= new JLabel("              REGISTRAR PERRO           ");
        add(l1);
        
        l2= new JLabel("Tipo de Perro (1.G/2.M/3.P)");
        add(l2);
        
        t1= new JTextField(10);//Tamaño del campo
        t1.setText("0");
        add(t1);
        
        l3= new JLabel("Número de horas");
        add(l3);
        
        t2= new JTextField(10);
        t2.setText("0");
        add(t2);
        
        l4= new JLabel("Perros Registrados: ");
        add(l4);
        
        numP= new JLabel(String.valueOf(calculos.con));
        add(numP);
        
        b1= new JButton("REGISTRAR");
        add(b1);
        b1.addActionListener(this);
        
        b2= new JButton("CERRAR");
        add(b2);
        b2.addActionListener(this);
        
        //Todo se hace visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion=e.getActionCommand();//En esta variable se registra si se clickea el boton
        
        tpPer=Integer.parseInt(t1.getText());
        hora=Integer.parseInt(t2.getText());
        
        if (accion.equals("REGISTRAR")){
            if (tpPer>3 || tpPer<1){
                JOptionPane.showMessageDialog(this,"Perro no valido");
            }else{
                calculos.calcularCostoTotal(hora,tpPer);
                if (calculos.con!=1){calculos.calcularDescuento();}
                numP.setText(String.valueOf(calculos.con));
                JOptionPane.showMessageDialog(this,"Valor a pagar:\n"+calculos.cosT);
            }
        }
        if (accion.equals("CERRAR")){
            System.exit(0);
        }
    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

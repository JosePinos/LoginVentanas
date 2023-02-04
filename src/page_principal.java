import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class page_principal extends JFrame{
    private JPanel Panel2;
    private JTabbedPane tabbedPane1;
    private JPanel tab1;
    private JPanel tab2;
    private JPanel tab3;
    private JPanel tab4;
    private JTextField num1;
    private JTextField num2;
    private JTextField suma;
    private JTextField num3;
    private JTextField num4;
    private JTextField resta;
    private JTextField num5;
    private JTextField num6;
    private JTextField multiplic;
    private JTextField num7;
    private JTextField num8;
    private JTextField division;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JLabel labelFecha;
    private JButton fecha1;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JLabel labeelfecha2;
    private JButton fecha2;
    private JButton calcularDiferenciaButton;
    private JLabel labelDiferencia;
    private JPanel tabInic;
    private JTextField ingreseSuPesoTextField;
    private JTextField ingreseSuAlturaTextField;
    private JButton calcularButton;
    private JLabel lblBMI;
    private JTextArea textArea;
    private JButton guardarButton;
    private JTextField txtNombre;


    public page_principal(){
        /*-------------------------------------------------------*/

        suma.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                try{
                    float val = Float.parseFloat(num1.getText()) + Float.parseFloat(num2.getText());
                    suma.setText(Float.toString(val));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es admitido", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        /*-------------------------------------------------------*/
        resta.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                try{
                    float val = Float.parseFloat(num3.getText()) - Float.parseFloat(num4.getText());
                    resta.setText(Float.toString(val));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es admitido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /*-------------------------------------------------------*/


        multiplic.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                try{
                    float val = Float.parseFloat(num5.getText()) * Float.parseFloat(num6.getText());
                    multiplic.setText(Float.toString(val));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es admitido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        /*-------------------------------------------------------*/

        division.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                try{
                    if(Float.parseFloat(num8.getText()) == 0){
                        throw new ArithmeticException("NO se puede dividir para 0");
                    }else{
                        float val = Float.parseFloat(num7.getText()) / Float.parseFloat(num8.getText());
                        division.setText(Float.toString(val));
                    }

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es admitido", "Error", JOptionPane.ERROR_MESSAGE);
                }catch (ArithmeticException exc){
                    JOptionPane.showMessageDialog(null, "No se puede dividir para 0", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        /*--------------------------------------------------------------------------------------------------------------------*/



        fecha1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelFecha.setText( String.valueOf(spinner1.getValue())  + "/" + String.valueOf(spinner2.getValue()) +"/"+ String.valueOf(spinner3.getValue()));
            }
        });

        fecha2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labeelfecha2.setText( String.valueOf(spinner4.getValue())  + "/" + String.valueOf(spinner5.getValue()) +"/"+ String.valueOf(spinner6.getValue()));
            }
        });
        calcularDiferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String f1 = String.valueOf(spinner1.getValue()) + "/" +String.valueOf(spinner2.getValue()) + "/" +String.valueOf(spinner3.getValue());
                String f2 = String.valueOf(spinner4.getValue()) + "/" +String.valueOf(spinner5.getValue()) + "/" +String.valueOf(spinner6.getValue());
                String patron = "dd/mm/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(patron);

                try {
                    Date date1 = sdf.parse(f1);
                    Date date2 = sdf.parse(f2);
                    long elapse = date1.getTime() - date2.getTime();
                    long difer = TimeUnit.DAYS.convert(elapse, TimeUnit.MILLISECONDS);
                    labelDiferencia.setText( Long.toString(difer) + " days");

                }catch(ParseException ex){
                    System.out.printf("Error: "+ex);
                }
            }
        });
        /*--------------------------------------------------------------------------------------------------------------------*/

        
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double respuesta = Double.parseDouble(ingreseSuPesoTextField.getText())/Math.pow(Double.parseDouble(ingreseSuAlturaTextField.getText()),2.0);
                lblBMI.setText("BMI = " + respuesta);
            }
        });

        /*--------------------------------------------------------------------------------------------------------------------*/


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingresoNombre();
            }
        });
    }//FIN DEL CONSTRUCTOR


    public void ingresoNombre(){
        textArea.setText("Tu nombre es: " + txtNombre.getText());
    }





    public static void main(String[] args) {
        JFrame frame = new JFrame("Principal");
        frame.setContentPane( new page_principal().Panel2 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}//fin de la clase page_principal

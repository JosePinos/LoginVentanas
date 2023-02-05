import javax.swing.*;
import java.awt.*;
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

    private JLabel lblNOmbre;
    private JScrollPane scroll1;
    private JTextArea textArea_anything;
    private JComboBox comboBox_color;
    private JComboBox comboBox_size;
    private JComboBox comboBox_font;
    private JButton LOREMButton;
    private JRadioButton RB_Makoto;
    private JRadioButton RB_Ren;
    private JRadioButton RB_Yu;
    private JPanel Character;
    private JPanel Weapon;
    private JPanel Persona;
    private String fuente;
    private int incremento = 1;


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

        /*--------------------------------------------------------------------------------------------------------------------*/

        ImageIcon img2 = new ImageIcon("src/imagenes/hombre.jpg");
        scroll1.setViewportView( new JLabel(img2) );

        comboBox_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox_color.getSelectedItem().toString().equals("Azul"))
                    textArea_anything.setForeground(Color.BLUE);
                else if (comboBox_color.getSelectedItem().toString().equals("Rojo"))
                    textArea_anything.setForeground(Color.RED);
                else if(comboBox_color.getSelectedItem().toString().equals("Verde"))
                    textArea_anything.setForeground(Color.GREEN);
                else if (comboBox_color.getSelectedItem().toString().equals("Negro"))
                    textArea_anything.setForeground(Color.BLACK);
                else if(comboBox_color.getSelectedItem().toString().equals("Gris"))
                    textArea_anything.setForeground(Color.GRAY);
                else if(comboBox_color.getSelectedItem().toString().equals("Blanco"))
                    textArea_anything.setForeground(Color.WHITE);
            }
        });
        comboBox_font.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fuente = comboBox_font.getSelectedItem().toString();
                if (fuente.equals("Times New Roman"))
                    textArea_anything.setFont(new Font("Times New Roman", Font.PLAIN, 15));
                else if (fuente.equals("Calibri"))
                    textArea_anything.setFont(new Font("Calibri", Font.PLAIN, 15));
                else if (fuente.equals("Agency FB"))
                    textArea_anything.setFont(new Font("Agency FB", Font.PLAIN, 15));
            }
        });

        comboBox_size.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String incrementoSTR;

                incrementoSTR = Integer.toString(incremento);
                if (comboBox_size.getSelectedItem().toString().equals(incrementoSTR))
                    textArea_anything.setFont(new Font("Calibri", Font.PLAIN, incremento));
                else
                {
                    incremento++;
                    while (incremento <= 20 && incremento != -1)
                    {
                        incrementoSTR = Integer.toString(incremento);
                        if (comboBox_size.getSelectedItem().toString().equals(incrementoSTR))
                        {
                            textArea_anything.setFont(new Font("Calibri", Font.PLAIN, incremento));
                            incremento = -1;
                        }
                        else
                            incremento++;
                    }
                }
            }
        });
        LOREMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea_anything.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. \n" +
                        "Praesent posuere eu odio rutrum rhoncus. \n" +
                        "Phasellus eget auctor ante, quis bibendum tellus. In hac habitasse platea dictumst. \n" +
                        "Aliquam tincidunt quam elementum vestibulum facilisis. \n" +
                        "Nullam consequat ex ornare mauris sollicitudin sagittis. \n" +
                        "Nullam at diam eu sapien hendrerit laoreet. \n" +
                        "Nulla sodales ex in risus porta blandit at sit amet leo. \n" +
                        "Curabitur aliquam molestie ipsum quis dapibus. \n" +
                        "Nulla ac quam non erat vehicula maximus a a ipsum. \n" +
                        "Vestibulum at velit ac mauris ultricies posuere.");
            }
        });
        RB_Makoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(RB_Makoto.isSelected() == true)
                    {
                        JLabel Personaje = new JLabel();
                        JLabel Arma = new JLabel();
                        JLabel PersonaS = new JLabel();
                        Arma.setIcon(new ImageIcon("src/imagenes/MakotoWeapon.png"));
                        PersonaS.setIcon(new ImageIcon("src/imagenes/Orpheus.png"));
                        Personaje.setIcon(new ImageIcon("src/imagenes/makoto.png"));
                        PersonaS.setBounds(10,20,900,224);
                        Personaje.setBounds(25,50,684,890);
                        Arma.setBounds(10,25,900,954);
                        Character.setLayout(null);
                        Weapon.setLayout(null);
                        Persona.setLayout(null);
                        Character.setLayout(null);
                        Character.add(Personaje);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        RB_Ren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(RB_Ren.isSelected() == true)
                    {

                        JLabel Personaje = new JLabel();
                        JLabel Arma = new JLabel();
                        JLabel PersonaS = new JLabel();
                        Arma.setIcon(new ImageIcon("src/imagenes/JokerWeapon.png"));
                        PersonaS.setIcon(new ImageIcon("src/imagenes/Arsene.png"));
                        Personaje.setIcon(new ImageIcon("src/imagenes/Ren.png"));
                        PersonaS.setBounds(10,20,350,377);
                        Personaje.setBounds(25,50,396,906);
                        Arma.setBounds(10,25,382,350);
                        Character.setLayout(null);
                        Weapon.setLayout(null);
                        Persona.setLayout(null);
                        Persona.add(PersonaS);
                        Weapon.add(Arma);
                        Character.add(Personaje);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        RB_Yu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(RB_Yu.isSelected() == true)
                    {
                        JLabel Personaje = new JLabel();
                        JLabel Arma = new JLabel();
                        JLabel PersonaS = new JLabel();
                        Arma.setIcon(new ImageIcon("src/imagenes/YuWeapon.png"));
                        PersonaS.setIcon(new ImageIcon("src/imagenes/Izanagi.png"));
                        Personaje.setIcon(new ImageIcon("src/imagenes/Yu.png"));
                        PersonaS.setBounds(0,20,512,487);
                        Personaje.setBounds(0,0,845,800);
                        Arma.setBounds(0,25,732,720);
                        Character.setLayout(null);
                        Weapon.setLayout(null);
                        Persona.setLayout(null);
                        Character.setLayout(null);
                        Character.add(Personaje);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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

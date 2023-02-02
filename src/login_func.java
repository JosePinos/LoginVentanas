import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class login_func {
    private JButton registrarseButton;
    private JButton iniciarSesiónButton;
    private JTextField txtusuarios;
    //private JTextField txtcontrasenia;
    private JPanel Panel1;
    private JLabel fotolabel;
    private JPasswordField txtcontrasenia;
    private JButton escogerFotoButton;

    //txtcontrasenia
    public login_func() {

        /*
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //para registrarse se debe añadir un usuario al archivo
                try {
                    FileWriter fwrite = new FileWriter("usuarios.txt",true);
                    fwrite.write(txtusuarios.getText() +" "+txtcontrasenia.getText() + "\n");
                    fwrite.close();
                } catch (IOException ex) {
                    //throw new RuntimeException(ex);
                    JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo","Error",JOptionPane.ERROR_MESSAGE);
                }

                String contenido = "";
                int c = 0;

                try{
                    FileReader freader = new FileReader("usuarios.txt");
                    c=freader.read();

                    while(c != -1){
                        contenido += (char)c;
                        c=freader.read();
                    }

                }catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo","Error",JOptionPane.ERROR_MESSAGE);
                }catch (IOException exe){
                    JOptionPane.showMessageDialog(null,"No se pudo abrir el archivo","Error",JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("El contenido del fichero es:\n " + contenido);
            }
        });
        */


        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo;
                FileWriter escribir;
                PrintWriter linea;
                archivo = new File("usuarios.txt");
                if( !archivo.exists() ){//aquí no existe el archivo
                    try {
                        archivo.createNewFile();

                        escribir = new FileWriter(archivo, true);//con true escribe al final de archivo
                        linea = new PrintWriter(escribir);

                        if( !userRepetido() ){
                            linea.println(txtusuarios.getText() + " " + txtcontrasenia.getText());
                            JOptionPane.showMessageDialog(null, "Usuario Registrado con éxito");
                            System.out.println("Usuario Registrado con éxito");
                        }else{
                            JOptionPane.showMessageDialog(null, "El usuario ya está registrado");
                            System.out.println("El usuario ya está registrado");
                        }


                        escribir.close();
                        linea.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }

                }else{
                    try {
                        escribir = new FileWriter(archivo, true);//con true escribe al final de archivo
                        linea = new PrintWriter(escribir);

                        if( !userRepetido() ){
                            linea.println(txtusuarios.getText() + " " + txtcontrasenia.getText());
                            JOptionPane.showMessageDialog(null, "Usuario Registrado con éxito");
                            System.out.println("Usuario Registrado con éxito");
                        }else{
                            JOptionPane.showMessageDialog(null, "El usuario ya está registrado");
                            System.out.println("El usuario ya está registrado");
                        }


                        escribir.close();
                        linea.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }//fin de action performed
        });


        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File archivo;
                FileReader leer;
                BufferedReader almacenamiento;
                String cadena;

                archivo = new File("usuarios.txt");

                try {
                    leer = new FileReader(archivo);
                    almacenamiento = new BufferedReader(leer);
                    cadena = "";
                    while(cadena != null){
                        try {
                            cadena = almacenamiento.readLine();
                            /*
                            if(cadena != null){
                                JOptionPane.showMessageDialog(null, "Bienvenido " + cadena);
                            }
                            */
                            //si la cadena que lee, es igual a lo que ingresó el usuario, mostrar mensaje
                            //debo usar un catch para null pointer exeption
                            try{
                                if(cadena.equals( (String) (txtusuarios.getText() + " " + txtcontrasenia.getText()) ) ){
                                    System.out.println("ESTE USUARIO EXISTE");
                                    JOptionPane.showMessageDialog(null, "Bienvenido de vuelta " +txtusuarios.getText() );
                                }else{
                                    JOptionPane.showMessageDialog(null, "El usuario ingresado no existe" );
                                }
                            }catch (NullPointerException exc){
                                System.out.println(exc);
                            }

                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    try {
                        almacenamiento.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    try {
                        leer.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });


        escogerFotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameFoto = new JFrame("Elegir foto");
                frameFoto.setContentPane( new elegirFoto().content1 );
                frameFoto.setSize(560,560);
                frameFoto.setLocationRelativeTo(null);
                frameFoto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frameFoto.pack();
                frameFoto.setVisible(true);

            }
        });
    }//fin del constructor de la clase


    public boolean userRepetido(){
        File archivo;
        FileReader leer;
        BufferedReader almacenamiento;
        String cadena;
        boolean seRepite = false;
        archivo = new File("usuarios.txt");

        try {
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            while(cadena != null){
                try {
                    cadena = almacenamiento.readLine();
                    //si la cadena que lee, es igual a lo que ingresó el usuario, mostrar mensaje
                    //debo usar un catch para null pointer exeption
                    try{
                        if(cadena.equals( (String) (txtusuarios.getText() + " " + txtcontrasenia.getText()) ) ){
                            System.out.println("ESTE USUARIO EXISTE");
                            seRepite = true;

                        }
                    }catch (NullPointerException exc){
                        System.out.println(exc);
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            try {
                almacenamiento.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            try {
                leer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }


        return seRepite;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane( new login_func().Panel1 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

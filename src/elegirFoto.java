import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class elegirFoto
{
    public JPanel content1;
    private JButton escogerImágenButton;
    private JLabel lblImagenescogida;
    public elegirFoto() {
        //video bonico https://www.youtube.com/watch?v=oKDPhacXlB8&t=35s
        escogerImágenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta ="";
                JFileChooser jfilechuser = new JFileChooser();
                FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg","png","gif");
                jfilechuser.setFileFilter(filtrado);
                int respuesta = jfilechuser.showOpenDialog(jfilechuser);//almacena si elijo cancelar o aceptar

                if(respuesta == JFileChooser.APPROVE_OPTION){
                    ruta=jfilechuser.getSelectedFile().getPath();
                    Image img = new ImageIcon(ruta).getImage();
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(260,260,Image.SCALE_SMOOTH));
                    lblImagenescogida.setIcon(icon);
                    login_func lf = new login_func(icon);
                    lf.setContentPane( new login_func(icon).Panel1 );
                    //lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    lf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    lf.pack();
                    lf.setVisible(true);

                }

            }
        });
    }
}

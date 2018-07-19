package vista;

import common.dominios.Usuario;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationDialog extends JDialog {

    private JPasswordField jPPassword;
    private JPanel jPanel;
    private JTextField jTUserName;
    private JPasswordField jPPasswordI;
    private JPasswordField jPPasswordII;
    private JTextField jTextFieldNombre;
    private JTextField jTextFieldApellido;
    private JTextField jTextFieldCorreo;
    private JCheckBox jCheckBoxActivo;
    private RegistrationEventListener listener;
    private final JLabel lblError;
    private RequestAccountEventListener reqlistener;
    private boolean accountTaken;

    /**
     * Create the dialog.
     */
    public RegistrationDialog(JDialog parent) {
        super(parent, true);
        setTitle("Registrarse");

        setBounds(100, 100, 418, 457);

        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton okButton = new JButton("Guardar");
        okButton.setActionCommand("Guardar");
        jPanel.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setActionCommand("Cancelar");
        jPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                clearAllFields();
                setVisible(false);
            }
        });
        lblError = new JLabel("");

        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (ValidateRequiredField(jTUserName.getText(), jPPasswordI.getPassword(), jPPasswordII.getPassword())) {
                    if (ValidateName(jTextFieldNombre.getText(), jTextFieldApellido.getText())) {
                        if (ValidateEmail(jTextFieldCorreo.getText())) {
                            String username = jTUserName.getText();
                            String password = new String(jPPasswordI.getPassword());
                            String nombre = jTextFieldNombre.getText();
                            String apellido = jTextFieldApellido.getText();
                            String correo = jTextFieldCorreo.getText();
                            boolean activo = jCheckBoxActivo.isSelected();
                            if (nombre == null) {
                                nombre = "";
                            }
                            if (apellido == null) {
                                apellido = "";
                            }
                            if (correo == null) {
                                correo = "";
                            }
                            RegistrationEvent ev = new RegistrationEvent(this, username, password, nombre, apellido, correo, activo);
                            System.out.println(ev);
                            if (listener != null) {
                                //	System.out.println("in FreeRegDialog, free reg event occured notifying observers");
                                JOptionPane.showMessageDialog(null, "Registrado!");
                                listener.FreeRegistrationEventOccurred(ev);
                            } else {
                                System.out.println("listener is null");
                            }
                            clearAllFields();
                            setVisible(false);
                        }
                    }
                }
            }

            private boolean ValidateEmail(String email) {
                if (email.equals("")) {
                    System.out.println("El correo es nulo");
                    return true;
                }
                final String EMAIL_PATTERN
                    = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                Matcher matcher = pattern.matcher(email);

                if (matcher.matches()) {
                    return true;
                }
                lblError.setText("El correo no es valido");
                return false;
            }

            private boolean ValidateName(String fName, String lName) {
                if (fName.equals("") || lName.equals("")) {
                    System.out.println("nombre o apellido nulo");
                    return true;
                }
                final String NAME_PATTERN = "\\w+";
                Pattern pattern = Pattern.compile(NAME_PATTERN);
                Matcher matcher = pattern.matcher(fName);
                Matcher matcher1 = pattern.matcher(lName);
                if (matcher.matches() && matcher1.matches()) {
                    return true;
                }
                lblError.setText("Nombre contiene caracteres invalidos");
                return false;
            }

            private boolean ValidateRequiredField(String name, char[] pass, char[] cpass) { //validate usuario, pass, confirm pass
                if (reqlistener == null) {
                    System.out.println("Usuario o Clave sin registrar");
                    return false;
                } else {
                    Usuario usuario = new Usuario(name, new String(pass), false);
                    reqlistener.requestAccountEventOccurred(new RequestAccountEvent(this, usuario));
                    if (accountTaken) {
                        JOptionPane.showMessageDialog(null, "Nombre asigando");
                        clearAllFields();
                        return false;
                    }
                }

                Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$"); //pattern for usuario
                Matcher matcher = pattern.matcher(name);
                if (matcher.matches() == true) {
                    String password = new String(pass);
                    String cPassword = new String(cpass);
                    Pattern pattern1 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})");
                    /*  (?=.*\d)		#   must contains one digit from 0-9
                     *  (?=.*[a-z])		#   must contains one lowercase characters
					    (?=.*[A-Z])		#   must contains one uppercase characters
					     .				#   match anything with previous condition checking
					     {6,20}			#   length at least 6 characters and maximum of 20	
                     */
                    Matcher matcher1 = pattern1.matcher(password);
                    if (matcher1.matches() && password.equals(cPassword)) {
                        return true;
                    }
                    lblError.setText("Clave Invalida");
                    JOptionPane.showMessageDialog(null, "\n"
                        + "la Clave debe contener un dígito de 0-9, debe contener un carácter en minúscula, debe contener un carácter en mayúscula, una longitud de al menos 6-20");
                    return false;
                }
                lblError.setText("Usuario invalido");
                return false;
            }
        });

        JLabel jLabelUsuario = new JLabel("Usuario*");
        jLabelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel jLabelClave = new JLabel("Clave*");
        jLabelClave.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel jLabelConfirmarClave = new JLabel("Confirmar Clave*");
        jLabelConfirmarClave.setFont(new Font("Tahoma", Font.BOLD, 11));

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

        jTUserName = new JTextField();
        jTUserName.setColumns(10);


        jCheckBoxActivo = new JCheckBox();


        jPPasswordI = new JPasswordField();

        jPPasswordII = new JPasswordField();

        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Source Sans Pro", Font.PLAIN, 11));

        JLabel jLabelDatosRequeridos = new JLabel("* datos requeridos");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(55)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jLabelClave)
                                        .addComponent(jLabelConfirmarClave)
                                        .addComponent(lblError)
                                        .addComponent(jLabelUsuario))
                                    .addGap(48)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                            .addComponent(jPPasswordII)
                                            .addComponent(jPPasswordI)
                                            .addComponent(jTUserName))
                                        .addComponent(jLabelDatosRequeridos))))))
                    .addContainerGap(22, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(22)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblError)
                        .addComponent(jLabelDatosRequeridos))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jTUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUsuario))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabelClave)
                        .addComponent(jPPasswordI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabelConfirmarClave)
                        .addComponent(jPPasswordII, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        JLabel jLabelNombre = new JLabel("Nombre");

        JLabel jLabelApellidos = new JLabel("Apellidos");
        JLabel jLabelActivo = new JLabel("Activo");

        jTextFieldNombre = new JTextField();
        jTextFieldNombre.setColumns(10);

        jTextFieldApellido = new JTextField();
        jTextFieldApellido.setColumns(10);

        JLabel lblEmail = new JLabel("Correo");

        jTextFieldCorreo = new JTextField();
        jTextFieldCorreo.setColumns(10);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(jLabelNombre)
                        .addComponent(jLabelApellidos)
                        .addComponent(lblEmail)
                        .addComponent(jLabelActivo))
                    .addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(jTextFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBoxActivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(21)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabelNombre)
                        .addComponent(jTextFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabelApellidos)
                        .addComponent(jTextFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(jTextFieldCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(92, Short.MAX_VALUE)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(jLabelActivo)
                        .addComponent(jCheckBoxActivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(92, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        getContentPane().setLayout(groupLayout);
    }

    private void clearAllFields() {
        jTUserName.setText("");
        jPPasswordI.setText("");
        jPPasswordII.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldCorreo.setText("");
    }

    public boolean isAccountTaken(boolean b) {
        accountTaken = b;
        return accountTaken;
    }

    public void setFreeRegistrationEventOberservers(RegistrationEventListener listener) {
        this.listener = listener;
    }

    public void setRequestAccountEventListener(RequestAccountEventListener listener) {

        this.reqlistener = listener;
        System.out.println("\n" +
            "RequestAccountEventListener");
        if (this.reqlistener == null) {
            System.out.println("\n" +
                "reqlistener");
        }
    }

}

package vista;

import common.dominios.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDialog extends JDialog implements RegistrationEventListener, RequestAccountEventListener {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JPasswordField passwordField;
    private RegistrationDialog registrationDialog;
    private LogInEventListener loginListener;
    private RegistrationEventListener freeRegListener;
    private RequestAccountEventListener reqlistener;
    private boolean isExistingAccount;

    /**
     * Create the dialog.
     */
    public LoginDialog(JFrame parent) {
        super(parent, "Ingresar", true);//true sets modal
        registrationDialog = new RegistrationDialog(this);

        setBounds(100, 100, 400, 235);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        JLabel lblUsername = new JLabel("Usuario");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints grigBagUsername = new GridBagConstraints();
        grigBagUsername.insets = new Insets(0, 0, 5, 5);
        grigBagUsername.anchor = GridBagConstraints.EAST;
        grigBagUsername.gridx = 2;
        grigBagUsername.gridy = 1;
        contentPanel.add(lblUsername, grigBagUsername);


        textField = new JTextField();
        GridBagConstraints grigBagTextField = new GridBagConstraints();
        grigBagTextField.insets = new Insets(0, 0, 5, 5);
        grigBagTextField.fill = GridBagConstraints.HORIZONTAL;
        grigBagTextField.gridx = 4;
        grigBagTextField.gridy = 1;
        contentPanel.add(textField, grigBagTextField);
        textField.setColumns(10);



        JLabel lblPassword = new JLabel("Clave");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.gridx = 2;
        gbc_lblPassword.gridy = 2;
        contentPanel.add(lblPassword, gbc_lblPassword);


        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 5);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 4;
        gbc_passwordField.gridy = 2;
        contentPanel.add(passwordField, gbc_passwordField);


        JButton btnLogIn = new JButton("Ingresar");
        btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 11));
        GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
        gbc_btnLogIn.insets = new Insets(0, 0, 5, 5);
        gbc_btnLogIn.gridx = 4;
        gbc_btnLogIn.gridy = 3;
        contentPanel.add(btnLogIn, gbc_btnLogIn);
        btnLogIn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = textField.getText();
                String pass = new String(passwordField.getPassword());
                Usuario cuenta = new Usuario(username, pass, false);
                if (loginListener != null)
                    loginListener.loginEventOccurred(cuenta);
            }
        });

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnRegFree = new JButton("Registrarse");
        btnRegFree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                registrationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                registrationDialog.setFreeRegistrationEventOberservers(LoginDialog.this);
                registrationDialog.setRequestAccountEventListener(LoginDialog.this);
                registrationDialog.setVisible(true);
            }
        });
        buttonPane.add(btnRegFree);

    }

    public void validateUserName() {

    }

    public void validatePassword() {

    }

    public boolean isAccountTaken(boolean b) {
        registrationDialog.isAccountTaken(b);

        return b;
    }

    public void setLogInEventListener(LogInEventListener listener) {
        this.loginListener = listener;
    }

    public void setFreeRegEventListener(RegistrationEventListener listener) {
        this.freeRegListener = listener;
    }


    //RegistrationDialog calling this method, pass event object to MainFrame
    @Override
    public void FreeRegistrationEventOccurred(RegistrationEvent e) {
        if (freeRegListener == null) {
            System.out.println("in Login: freeRegListener = null");
        }
        freeRegListener.FreeRegistrationEventOccurred(e);
    }

    public void setRequestEventAccountListener(RequestAccountEventListener listener) {
        this.reqlistener = listener;
    }

    @Override
    public void requestAccountEventOccurred(RequestAccountEvent e) {
        reqlistener.requestAccountEventOccurred(e);
    }

    public boolean isValidLogin(boolean b) {
        if (b == true) {
            JOptionPane.showMessageDialog(null, "Ingreso correcto");

        } else {
            JOptionPane.showMessageDialog(null, "Ingreso fallido");
        }
        return false;

    }
}

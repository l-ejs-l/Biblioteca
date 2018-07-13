package vista;

import common.dominios.Cuenta;
import common.dominios.FreeCuenta;
import vista.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements LogInEventListener, FreeRegistrationEventListener, RequestAccountEventListener {

    private LoginDialog loginDialog;
    private Controller controller;

    public MainFrame(boolean view) {
        this.setVisible(false);
        controller = new Controller();
        loginDialog = new LoginDialog(this);
        loginDialog.setLogInEventListener(this);
        loginDialog.setFreeRegEventListener(this);
        loginDialog.setRequestEventAccountListener(this);

        loginDialog.setVisible(true);

        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }


    @Override
    public void FreeRegistrationEventOccurred(FreeRegistrationEvent e) {
        String username = e.getUserName();
        String password = e.getPassword();
        boolean member = e.isMember();
        String fName = e.getfName();
        String lName = e.getlName();
        String email = e.getEmail();
        FreeCuenta fa = new FreeCuenta(username, password, fName, lName, email);
        controller.addAccount(fa);
    }


    @Override
    public void requestAccountEventOccurred(RequestAccountEvent e) {
        Cuenta cuenta = e.getCuenta();
        boolean b = false;
        try {
            b = controller.isExistingAccount(cuenta);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        loginDialog.isAccountTaken(b);
    }

    @Override
    public void loginEventOccurred(Cuenta cuenta) {
        try {
            if (controller.isValidLogin(cuenta)) {
                loginDialog.setVisible(false);
                loginDialog.isValidLogin(true);
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new InterfazGrafica_Funcionario().setVisible(true);
                    }
                });
            } else {

                loginDialog.isValidLogin(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

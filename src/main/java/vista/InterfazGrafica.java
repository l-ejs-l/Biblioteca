/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import common.controlladores.RecursoController;
import common.dao.AutorDAOImpl;
import common.dao.EditorialDAOImpl;
import common.dao.TopicoDAOImpl;
import common.dominios.*;
import common.dominios.enums.TipoRecurso;
import common.dominios.enums.TipoTexto;
import common.interfaces.dao.AutorDAO;
import common.interfaces.dao.EditorialDAO;
import common.interfaces.dao.TopicoDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

/**
 * @author claus
 */
public class InterfazGrafica extends javax.swing.JFrame {

    private final ArrayList<JPanel> listaComponentes = new ArrayList<>();
    private final AutorDAO autorDAO;
    private final TopicoDAO topicoDAO;
    private final EditorialDAO editorialDAO;

    /**
     * Creates new form Aplicacion
     */
    public InterfazGrafica() {
        autorDAO = new AutorDAOImpl();
        topicoDAO = new TopicoDAOImpl();
        editorialDAO = new EditorialDAOImpl();
        initComponents();
        initComponentsList();
        setVisibleComponent(pnlIngresoMaterial);
        this.setLocationRelativeTo(null);
    }

    /**
     * Este método void agrega los componentes Jpanel a un ArrayList
     */
    private void initComponentsList() {
        listaComponentes.add(pnlRegistroPrestamos);
        listaComponentes.add(pnlClientes);
        listaComponentes.add(pnlDevolucionMultas);
        listaComponentes.add(pnlIngresoMaterial);
    }

    /**
     * Este metodo acepta un Jpanel y le añade setVisible() a true y el resto de los elementos de la
     * lista los deja en false
     *
     * @param panel
     */
    private void setVisibleComponent(JPanel panel) {
        for (JPanel listaComponente : listaComponentes) {
            if (listaComponente.equals(panel)) {
                panel.setVisible(true);
            } else {
                listaComponente.setVisible(false);
            }
        }
    }

    private Recurso inputToRecurso() throws Exception {
        Recurso recurso = new Recurso();
        Set<Autor> autors = new HashSet<>();
        Set<Topico> topicos = new HashSet<>();

        String editorialName = (String) cboEditorialList.getSelectedItem();
        String tituloRecurso = txtTituloRecurso.getText();
        String tipoRecurso = btnGroupRecurso.getSelection().getActionCommand();
        String tipoTexto = btnGroupTipoTexto.getSelection().getActionCommand();
        int totalPaginas;

        try {
            totalPaginas = Integer.parseInt(txtTotalPaginas.getText().trim());
        } catch (Exception e) {
            throw new Exception("Solo debe ingresar numero en Total Paginas");
        }

        switch (btnGroupRecurso.getSelection().getActionCommand()) {
            case "LIBRO":
                Libro libro = new Libro();
                libro.setIsbn(txtIsbn.getText().trim());
                recurso.setRecurso(libro);
                break;
            case "PERIODICO":
                Periodico periodico = new Periodico();
                periodico.setLema(txtPeriodicoLema.getText().trim());
                try {
                    periodico.setFechaPublicacion(new Date(jDatePeriodicoPublicacion.getDate().getTime()));
                } catch (Exception e) {
                    throw new Exception("Problema al parsear la fecha de publicacion");
                }
                recurso.setRecurso(periodico);
                break;
            case "REVISTA":
                Revista revista = new Revista();
                recurso.setRecurso(revista);
        }

        for (int i = 0; i < listRecursoAutor.getModel().getSize(); i++) {
            String autorString = listRecursoAutor.getModel().getElementAt(i);
            String[] nombre = autorString.trim().split(" ");
            Autor autor = new Autor();
            autor.setNombre(nombre[0]);
            autor.setApellido(nombre[1]);
            autors.add(autor);
        }

        for (int i = 0; i < listRecursoTopico.getModel().getSize(); i++) {
            Topico topico = new Topico();
            topico.setTopico(listRecursoTopico.getModel().getElementAt(i));
            topicos.add(topico);
        }

        Editorial editorial = new Editorial();
        editorial.setEditorial(editorialName.trim());

        recurso.setTitulo(tituloRecurso.trim());
        recurso.setTotalPaginas(totalPaginas);
        recurso.setTipoRecurso(TipoRecurso.valueOf(tipoRecurso));
        recurso.setTipoTexto(TipoTexto.valueOf(tipoTexto));
        recurso.setEditorial(editorial);
        recurso.setAutores(autors);
        recurso.setTopicos(topicos);

        return recurso;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupRecurso = new javax.swing.ButtonGroup();
        btnGroupTipoTexto = new javax.swing.ButtonGroup();
        pnlRegistroPrestamos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txt_Registrar_IdUsuario_Func = new javax.swing.JTextField();
        txt_Registrar_NombreCompleto_Func = new javax.swing.JTextField();
        btn_Registrar_Registrar_Func = new javax.swing.JButton();
        btn_Registrar_Actualizar_Func = new javax.swing.JButton();
        btn_Registrar_LimpiarCampos_Func = new javax.swing.JButton();
        btn_Listar_ListarPrestamos_Func = new javax.swing.JButton();
        btn_Registrar_Eliminar_Func = new javax.swing.JButton();
        rbtRolDocente_Func = new javax.swing.JRadioButton();
        rbtRolEstudiante_Func = new javax.swing.JRadioButton();
        jLabel59 = new javax.swing.JLabel();
        btn_Listar_ListarMultas_Func = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        btn_Registrar_Renovar_Func = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_Listar_PrestamosUsuario_Func = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMultasUsuario = new javax.swing.JTable();
        btn_Listar_ActualizarMultas_Func = new javax.swing.JButton();
        btn_Listar_BorrarMultas_Func = new javax.swing.JButton();
        btn_Listar_ActualizarPrestamos_Func = new javax.swing.JButton();
        btn_Listar_BorrarPrestamos_Func = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        txt_Registrar_IdMaterial_Func = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txt_Registrar_TituloMaterial_Func = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txt_Registrar_FechaPrestamo_Func = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txt_Registrar_FechaDevolucion_Func = new javax.swing.JTextField();
        pnlDevolucionMultas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_Devolucion_IdUsuario_Func = new javax.swing.JTextField();
        txt_Devolucion_Nombre_Func = new javax.swing.JTextField();
        btn_Devolucion_Registrar_Func = new javax.swing.JButton();
        btn_Devolucion_Actualizar_Func = new javax.swing.JButton();
        btn_Devolucion_Limpiar_Func = new javax.swing.JButton();
        btn_Devolucion_Eliminar_Func = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        txt_Devolucion_ApellidoPaterno_Func = new javax.swing.JTextField();
        txt_Devolucion_ApellidoMaterno_Func = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        rbt_Devolucion_RolDocente_Func = new javax.swing.JRadioButton();
        rbt_Devolucion_RolEstududiante_Func = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        btn_Devolucion_Renovar_Func = new javax.swing.JButton();
        btn_Borrar_Multas_Usuarios_Func = new javax.swing.JButton();
        btn_Listar_Multas_Usuarios_Func = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tbl_Listar_Multas_Usuarios_Func = new javax.swing.JTable();
        jLabel77 = new javax.swing.JLabel();
        btn_Actualizar_Multas_Usuarios_Func = new javax.swing.JButton();
        pnlClientes = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtVendedor7 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtNumeroCliente2 = new javax.swing.JTextField();
        txtNombre2 = new javax.swing.JTextField();
        txtEmail2 = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        btnInsertar2 = new javax.swing.JButton();
        btnActualizar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnListar2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaClientes2 = new javax.swing.JTextArea();
        btnEliminar2 = new javax.swing.JButton();
        pnlIngresoMaterial = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblPrecios6 = new javax.swing.JTable();
        tpRecursos = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTituloRecurso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPaginas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbtnLibro = new javax.swing.JRadioButton();
        rbtnPeriodico = new javax.swing.JRadioButton();
        rbtnRevista = new javax.swing.JRadioButton();
        tpTipoRecurso = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtIsbn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtPeriodicoLema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDatePeriodicoPublicacion = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        txtIdRecursoFormated = new javax.swing.JFormattedTextField();
        btnRecursoIngresar = new javax.swing.JButton();
        btnRecursoActualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cboAutorList = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboTopicoList = new javax.swing.JComboBox<>();
        btnAgregarAutor = new javax.swing.JButton();
        btnAgregarTopico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRecursoTopico = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRecursoAutor = new javax.swing.JList<>();
        btnQuitarTopico = new javax.swing.JButton();
        btnQuitarAutor = new javax.swing.JButton();
        rbtnAltaDemanda = new javax.swing.JRadioButton();
        rbtnNormal = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        cboEditorialList = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtIdEditorial = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNombreEditorial = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEditorial = new javax.swing.JTable();
        btnIngresarEditorial = new javax.swing.JButton();
        btnActualizarEditorial = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtIdTopico = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTituloTopico = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblTopico = new javax.swing.JTable();
        btnIngresarTopico = new javax.swing.JButton();
        btnActualizarTopico = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txtIdAutor = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtNombreAutor = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtApellidoAutor = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblAutor = new javax.swing.JTable();
        btnIngresarAutor = new javax.swing.JButton();
        btnActualizarAutor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniDatosCliente = new javax.swing.JMenuItem();
        mniOrden = new javax.swing.JMenuItem();
        mniOrden1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mniProceso = new javax.swing.JMenuItem();
        mniProceso1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 625));

        pnlRegistroPrestamos.setBackground(new java.awt.Color(255, 204, 102));
        pnlRegistroPrestamos.setAlignmentX(0.0F);
        pnlRegistroPrestamos.setAlignmentY(25.0F);
        pnlRegistroPrestamos.setPreferredSize(new java.awt.Dimension(1200, 600));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel9.setText("Nombre Completo:");

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Registrar Préstamos");

        jLabel69.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(102, 102, 102));
        jLabel69.setText("Listar Multas del Usuario");

        jLabel41.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel41.setText("Id Usuario:");

        btn_Registrar_Registrar_Func.setText("Registrar");
        btn_Registrar_Registrar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_Registrar_FuncActionPerformed(evt);
            }
        });

        btn_Registrar_Actualizar_Func.setText("Actualizar");
        btn_Registrar_Actualizar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_Actualizar_FuncActionPerformed(evt);
            }
        });

        btn_Registrar_LimpiarCampos_Func.setText("Limpiar  Campos");
        btn_Registrar_LimpiarCampos_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_LimpiarCampos_FuncActionPerformed(evt);
            }
        });

        btn_Listar_ListarPrestamos_Func.setText("Listar Préstamos");
        btn_Listar_ListarPrestamos_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_ListarPrestamos_FuncActionPerformed(evt);
            }
        });

        btn_Registrar_Eliminar_Func.setText("Eliminar");
        btn_Registrar_Eliminar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_Eliminar_FuncActionPerformed(evt);
            }
        });

        rbtRolDocente_Func.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        rbtRolDocente_Func.setText("Docente");
        rbtRolDocente_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtRolDocente_FuncActionPerformed(evt);
            }
        });

        rbtRolEstudiante_Func.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        rbtRolEstudiante_Func.setText("Estudiante");
        rbtRolEstudiante_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtRolEstudiante_FuncActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel59.setText("Rol:");

        btn_Listar_ListarMultas_Func.setText("Listar Multas");
        btn_Listar_ListarMultas_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_ListarMultas_FuncActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(102, 102, 102));
        jLabel72.setText("Listar Préstamos al Usuario");

        btn_Registrar_Renovar_Func.setText("Renovar");
        btn_Registrar_Renovar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Registrar_Renovar_FuncActionPerformed(evt);
            }
        });

        tbl_Listar_PrestamosUsuario_Func.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo del Material", "Fecha de Préstamo", "Fecha de Devolución"
            }
        ));
        jScrollPane5.setViewportView(tbl_Listar_PrestamosUsuario_Func);

        tblMultasUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Multa", "Material", "Días de Castigo"
            }
        ));
        jScrollPane4.setViewportView(tblMultasUsuario);

        btn_Listar_ActualizarMultas_Func.setText("Actualizar");
        btn_Listar_ActualizarMultas_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_ActualizarMultas_FuncActionPerformed(evt);
            }
        });

        btn_Listar_BorrarMultas_Func.setText("Borrar");
        btn_Listar_BorrarMultas_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_BorrarMultas_FuncActionPerformed(evt);
            }
        });

        btn_Listar_ActualizarPrestamos_Func.setText("Actualizar");
        btn_Listar_ActualizarPrestamos_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_ActualizarPrestamos_FuncActionPerformed(evt);
            }
        });

        btn_Listar_BorrarPrestamos_Func.setText("Borrar");
        btn_Listar_BorrarPrestamos_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_BorrarPrestamos_FuncActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel46.setText("Id Material:");

        jLabel49.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel49.setText("Titulo de Material:");

        jLabel50.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel50.setText("Fecha de Préstamo:");

        jLabel51.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel51.setText("Fecha de Devolución:");

        txt_Registrar_FechaDevolucion_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Registrar_FechaDevolucion_FuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroPrestamosLayout = new javax.swing.GroupLayout(pnlRegistroPrestamos);
        pnlRegistroPrestamos.setLayout(pnlRegistroPrestamosLayout);
        pnlRegistroPrestamosLayout.setHorizontalGroup(
            pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel59)
                                    .addComponent(btn_Registrar_Registrar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                        .addComponent(btn_Registrar_Renovar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_Registrar_Actualizar_Func))
                                    .addComponent(txt_Registrar_NombreCompleto_Func, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                        .addComponent(rbtRolEstudiante_Func)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbtRolDocente_Func))
                                    .addComponent(txt_Registrar_IdUsuario_Func, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel49))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Registrar_IdMaterial_Func)
                                    .addComponent(txt_Registrar_TituloMaterial_Func)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel50)
                                .addGap(18, 18, 18)
                                .addComponent(txt_Registrar_FechaPrestamo_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addComponent(btn_Registrar_Eliminar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Registrar_LimpiarCampos_Func))
                            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Registrar_FechaDevolucion_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addComponent(btn_Listar_ListarPrestamos_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Listar_ActualizarPrestamos_Func)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Listar_BorrarPrestamos_Func))
                    .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addComponent(btn_Listar_ListarMultas_Func)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Listar_ActualizarMultas_Func)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Listar_BorrarMultas_Func)))
                .addContainerGap())
        );
        pnlRegistroPrestamosLayout.setVerticalGroup(
            pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21))
                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Listar_ListarPrestamos_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Listar_ActualizarPrestamos_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Listar_BorrarPrestamos_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel69))
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addComponent(txt_Registrar_IdUsuario_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Registrar_NombreCompleto_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtRolEstudiante_Func)
                            .addComponent(rbtRolDocente_Func)
                            .addComponent(jLabel59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Registrar_IdMaterial_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Registrar_TituloMaterial_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Registrar_FechaPrestamo_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(txt_Registrar_FechaDevolucion_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Listar_BorrarMultas_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Listar_ActualizarMultas_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Listar_ListarMultas_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlRegistroPrestamosLayout.createSequentialGroup()
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Registrar_Registrar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Registrar_Renovar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Registrar_Actualizar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRegistroPrestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Registrar_Eliminar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Registrar_LimpiarCampos_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 164, Short.MAX_VALUE))
        );

        jLabel69.getAccessibleContext().setAccessibleName("Listar Préstamos al Usuario");

        pnlDevolucionMultas.setBackground(new java.awt.Color(255, 204, 102));
        pnlDevolucionMultas.setAlignmentX(0.0F);
        pnlDevolucionMultas.setAlignmentY(25.0F);

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel10.setText("Nombre:");

        jLabel24.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Devolución");

        jLabel42.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel42.setText("Id Usuario:");

        btn_Devolucion_Registrar_Func.setText("Registrar");
        btn_Devolucion_Registrar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Devolucion_Registrar_FuncActionPerformed(evt);
            }
        });

        btn_Devolucion_Actualizar_Func.setText("Actualizar");
        btn_Devolucion_Actualizar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Devolucion_Actualizar_FuncActionPerformed(evt);
            }
        });

        btn_Devolucion_Limpiar_Func.setText("Limpiar");
        btn_Devolucion_Limpiar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Devolucion_Limpiar_FuncActionPerformed(evt);
            }
        });

        btn_Devolucion_Eliminar_Func.setText("Eliminar");
        btn_Devolucion_Eliminar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Devolucion_Eliminar_FuncActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel60.setText("Apellido Paterno:");

        jLabel61.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel61.setText("Apellido Materno:");

        rbt_Devolucion_RolDocente_Func.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        rbt_Devolucion_RolDocente_Func.setText("Docente");
        rbt_Devolucion_RolDocente_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_Devolucion_RolDocente_FuncActionPerformed(evt);
            }
        });

        rbt_Devolucion_RolEstududiante_Func.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        rbt_Devolucion_RolEstududiante_Func.setText("Estudiante");
        rbt_Devolucion_RolEstududiante_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_Devolucion_RolEstududiante_FuncActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel62.setText("Rol:");

        btn_Devolucion_Renovar_Func.setText("Renovar");
        btn_Devolucion_Renovar_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Devolucion_Renovar_FuncActionPerformed(evt);
            }
        });

        btn_Borrar_Multas_Usuarios_Func.setText("Borrar");
        btn_Borrar_Multas_Usuarios_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Borrar_Multas_Usuarios_FuncActionPerformed(evt);
            }
        });

        btn_Listar_Multas_Usuarios_Func.setText("Listar");
        btn_Listar_Multas_Usuarios_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Listar_Multas_Usuarios_FuncActionPerformed(evt);
            }
        });

        tbl_Listar_Multas_Usuarios_Func.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Usuario", "Material Nombre", "Cantidad de Multas"
            }
        ));
        jScrollPane11.setViewportView(tbl_Listar_Multas_Usuarios_Func);

        jLabel77.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("Lista de Multas de Usuarios");

        btn_Actualizar_Multas_Usuarios_Func.setText("Actualizar");
        btn_Actualizar_Multas_Usuarios_Func.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar_Multas_Usuarios_FuncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDevolucionMultasLayout = new javax.swing.GroupLayout(pnlDevolucionMultas);
        pnlDevolucionMultas.setLayout(pnlDevolucionMultasLayout);
        pnlDevolucionMultasLayout.setHorizontalGroup(
            pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Devolucion_Registrar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDevolucionMultasLayout.createSequentialGroup()
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel42)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_Devolucion_Nombre_Func)
                            .addComponent(txt_Devolucion_ApellidoPaterno_Func)
                            .addComponent(txt_Devolucion_ApellidoMaterno_Func, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDevolucionMultasLayout.createSequentialGroup()
                                .addComponent(rbt_Devolucion_RolEstududiante_Func)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbt_Devolucion_RolDocente_Func))
                            .addComponent(txt_Devolucion_IdUsuario_Func)))
                    .addComponent(btn_Devolucion_Renovar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Devolucion_Actualizar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_Devolucion_Eliminar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Devolucion_Limpiar_Func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                        .addComponent(btn_Listar_Multas_Usuarios_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btn_Actualizar_Multas_Usuarios_Func)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Borrar_Multas_Usuarios_Func)))
                .addGap(31, 31, 31))
        );
        pnlDevolucionMultasLayout.setVerticalGroup(
            pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                        .addComponent(jLabel77)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_Borrar_Multas_Usuarios_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Actualizar_Multas_Usuarios_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Listar_Multas_Usuarios_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(17, 17, 17)
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                                .addComponent(txt_Devolucion_IdUsuario_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Devolucion_Nombre_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDevolucionMultasLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDevolucionMultasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Devolucion_ApellidoPaterno_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Devolucion_ApellidoMaterno_Func, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDevolucionMultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbt_Devolucion_RolEstududiante_Func)
                            .addComponent(rbt_Devolucion_RolDocente_Func)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Devolucion_Registrar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Devolucion_Renovar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Devolucion_Actualizar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(btn_Devolucion_Eliminar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Devolucion_Limpiar_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pnlClientes.setBackground(new java.awt.Color(255, 204, 102));
        pnlClientes.setAlignmentX(0.0F);
        pnlClientes.setAlignmentY(25.0F);

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel11.setText("NOMBRE COMPLETO");

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel22.setText("NUMERO CLIENTE");

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("DATOS CLIENTE");

        jLabel70.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(102, 102, 102));
        jLabel70.setText("LISTA CLIENTES");

        jLabel47.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel47.setText("VENDEDOR:");

        txtVendedor7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jLabel48.setText("EMAIL");

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        btnInsertar2.setText("Insertar");
        btnInsertar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertar2ActionPerformed(evt);
            }
        });

        btnActualizar2.setText("Actualizar");
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        btnListar2.setText("Listar");
        btnListar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListar2ActionPerformed(evt);
            }
        });

        txaClientes2.setColumns(20);
        txaClientes2.setRows(5);
        jScrollPane6.setViewportView(txaClientes2);

        btnEliminar2.setText("Eliminar");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                                .addComponent(btnEliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInsertar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlClientesLayout.createSequentialGroup()
                                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(27, 27, 27))
                                    .addGroup(pnlClientesLayout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addGap(22, 22, 22)))
                                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNombre2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlClientesLayout.createSequentialGroup()
                                        .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar2))
                                    .addComponent(txtNumeroCliente2, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlClientesLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel70)
                                    .addGroup(pnlClientesLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(txtVendedor7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlClientesLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnListar2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47)))))
                    .addComponent(jLabel11))
                .addContainerGap(444, Short.MAX_VALUE))
        );
        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumeroCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar2))
                        .addGap(30, 30, 30)
                        .addComponent(btnInsertar2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListar2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnEliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(txtVendedor7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pnlIngresoMaterial.setBackground(new java.awt.Color(255, 204, 102));
        pnlIngresoMaterial.setAlignmentX(0.0F);
        pnlIngresoMaterial.setAlignmentY(25.0F);
        pnlIngresoMaterial.setPreferredSize(new java.awt.Dimension(1200, 600));

        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Recursos");

        tblPrecios6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Material", "Tipo", "Proveedor", "Categoría", "Autor", "Editorial"
            }
        ));
        jScrollPane12.setViewportView(tblPrecios6);

        tpRecursos.setPreferredSize(new java.awt.Dimension(660, 365));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 355));

        jPanel5.setBackground(new java.awt.Color(254, 216, 145));

        jLabel1.setText("id");

        jLabel2.setText("Titulo Recurso");

        jLabel3.setText("Total Paginas");

        btnGroupRecurso.add(rbtnLibro);
        rbtnLibro.setText("Libro");
        rbtnLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLibroActionPerformed(evt);
            }
        });

        btnGroupRecurso.add(rbtnPeriodico);
        rbtnPeriodico.setText("Periodico");
        rbtnPeriodico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPeriodicoActionPerformed(evt);
            }
        });

        btnGroupRecurso.add(rbtnRevista);
        rbtnRevista.setText("Revista");
        rbtnRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRevistaActionPerformed(evt);
            }
        });

        tpTipoRecurso.setBackground(new java.awt.Color(254, 216, 145));

        jPanel2.setBackground(new java.awt.Color(254, 216, 145));

        jLabel4.setText("Isbn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        tpTipoRecurso.addTab("Libro", jPanel2);

        jPanel7.setBackground(new java.awt.Color(254, 216, 145));

        jLabel5.setText("Lema");

        jLabel6.setText("Publicacion");

        jDatePeriodicoPublicacion.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDatePeriodicoPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPeriodicoLema, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPeriodicoLema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDatePeriodicoPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tpTipoRecurso.addTab("Periodico", jPanel7);

        jPanel8.setBackground(new java.awt.Color(254, 216, 145));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        tpTipoRecurso.addTab("Revista", jPanel8);

        try {
            txtIdRecursoFormated.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTituloRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtTotalPaginas, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIdRecursoFormated)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(rbtnLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnPeriodico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnRevista))
                    .addComponent(tpTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdRecursoFormated, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnLibro)
                    .addComponent(rbtnPeriodico)
                    .addComponent(rbtnRevista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rbtnLibro.setActionCommand(TipoRecurso.LIBRO.toString());
        rbtnPeriodico.setActionCommand(TipoRecurso.PERIODICO.toString());
        rbtnRevista.setActionCommand(TipoRecurso.REVISTA.toString());

        btnRecursoIngresar.setText("Ingresar");
        btnRecursoIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecursoIngresarActionPerformed(evt);
            }
        });

        btnRecursoActualizar.setText("Actualizar");

        jPanel6.setBackground(new java.awt.Color(254, 216, 145));

        jLabel7.setText("Autor");

        cboAutorList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- seleccionar" }));

        jLabel8.setText("Topico");

        cboTopicoList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- seleccionar" }));

        btnAgregarAutor.setText("Agregar");
        btnAgregarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutorActionPerformed(evt);
            }
        });

        btnAgregarTopico.setText("Agregar");
        btnAgregarTopico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTopicoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listRecursoTopico);
        DefaultListModel<String> modelListRecursoTopico = new DefaultListModel<>();
        listRecursoTopico.setModel(modelListRecursoTopico);

        jScrollPane2.setViewportView(listRecursoAutor);
        DefaultListModel<String> modelListRecursoAutor = new DefaultListModel<>();
        listRecursoAutor.setModel(modelListRecursoAutor);

        btnQuitarTopico.setText("Quitar");
        btnQuitarTopico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarTopicoActionPerformed(evt);
            }
        });

        btnQuitarAutor.setText("Quitar");
        btnQuitarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAutorActionPerformed(evt);
            }
        });

        btnGroupTipoTexto.add(rbtnAltaDemanda);
        rbtnAltaDemanda.setText("Alta Demanda");

        btnGroupTipoTexto.add(rbtnNormal);
        rbtnNormal.setText("Normal");

        jLabel13.setText("Editorial");

        cboEditorialList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- seleccionar" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbtnAltaDemanda, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnQuitarTopico))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnNormal))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cboEditorialList, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboAutorList, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarAutor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(cboTopicoList, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarTopico, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnQuitarAutor)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(cboTopicoList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(cboAutorList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTopico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarTopico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAltaDemanda)
                    .addComponent(rbtnNormal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboEditorialList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            Set<Autor> recursoAutores = autorDAO.findAll();
            recursoAutores.forEach(a ->
                cboAutorList.addItem(a.getNombre() + " " + a.getApellido()));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            Set<Topico> recursoTopicos = topicoDAO.findAll();
            recursoTopicos.forEach(t ->
                cboTopicoList.addItem(t.getTopico()));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        rbtnAltaDemanda.setActionCommand(TipoTexto.ALTA_DEMANDA.toString());
        rbtnNormal.setActionCommand(TipoTexto.NORMAL.toString());
        try {
            Set<Editorial> recursoEditorial = editorialDAO.findAll();
            recursoEditorial.forEach(a ->
                cboEditorialList.addItem(a.getEditorial()));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(btnRecursoIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecursoActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecursoIngresar)
                    .addComponent(btnRecursoActualizar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tpRecursos.addTab("Recurso", jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 204, 102));

        jPanel3.setBackground(new java.awt.Color(254, 216, 145));

        jLabel12.setText("id");

        jLabel14.setText("Editorial");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtNombreEditorial))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 216, 145));

        tblEditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEditorial);
        if (tblEditorial.getColumnModel().getColumnCount() > 0) {
            tblEditorial.getColumnModel().getColumn(0).setResizable(false);
            tblEditorial.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnIngresarEditorial.setText("Ingresar");
        btnIngresarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEditorialActionPerformed(evt);
            }
        });

        btnActualizarEditorial.setText("Actualizar");
        btnActualizarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnIngresarEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarEditorial)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarEditorial)
                    .addComponent(btnActualizarEditorial))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tpRecursos.addTab("Editorial", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 204, 102));

        jPanel13.setBackground(new java.awt.Color(254, 216, 145));

        jLabel19.setText("id");

        jLabel20.setText("Topico");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTituloTopico, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtIdTopico, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdTopico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloTopico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(254, 216, 145));

        tblTopico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblTopico);
        if (tblTopico.getColumnModel().getColumnCount() > 0) {
            tblTopico.getColumnModel().getColumn(0).setResizable(false);
            tblTopico.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnIngresarTopico.setText("Ingresar");
        btnIngresarTopico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarTopicoActionPerformed(evt);
            }
        });

        btnActualizarTopico.setText("Actualizar");
        btnActualizarTopico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTopicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnIngresarTopico, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarTopico)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarTopico)
                    .addComponent(btnActualizarTopico))
                .addGap(32, 32, 32))
        );

        tpRecursos.addTab("Topico", jPanel10);

        jPanel15.setBackground(new java.awt.Color(255, 204, 102));
        jPanel15.setPreferredSize(new java.awt.Dimension(653, 355));

        jPanel16.setBackground(new java.awt.Color(254, 216, 145));

        jLabel25.setText("id");

        jLabel26.setText("Nombre");

        jLabel28.setText("Apellido");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel26))
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellidoAutor)
                    .addComponent(txtNombreAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtIdAutor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(254, 216, 145));

        tblAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblAutor);
        if (tblAutor.getColumnModel().getColumnCount() > 0) {
            tblAutor.getColumnModel().getColumn(0).setResizable(false);
            tblAutor.getColumnModel().getColumn(1).setResizable(false);
            tblAutor.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnIngresarAutor.setText("Ingresar");
        btnIngresarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAutorActionPerformed(evt);
            }
        });

        btnActualizarAutor.setText("Actualizar");
        btnActualizarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btnIngresarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarAutor)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarAutor)
                    .addComponent(btnActualizarAutor))
                .addGap(32, 32, 32))
        );

        tpRecursos.addTab("Autor", jPanel15);

        javax.swing.GroupLayout pnlIngresoMaterialLayout = new javax.swing.GroupLayout(pnlIngresoMaterial);
        pnlIngresoMaterial.setLayout(pnlIngresoMaterialLayout);
        pnlIngresoMaterialLayout.setHorizontalGroup(
            pnlIngresoMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlIngresoMaterialLayout.setVerticalGroup(
            pnlIngresoMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setAlignmentX(0.0F);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1200, 25));

        jMenu1.setBackground(new java.awt.Color(255, 204, 102));
        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setText("Tareas Funcionario");
        jMenu1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        mniDatosCliente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mniDatosCliente.setText("Préstamos");
        mniDatosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDatosClienteActionPerformed(evt);
            }
        });
        jMenu1.add(mniDatosCliente);

        mniOrden.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mniOrden.setText("Devolución y Multas");
        mniOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOrdenActionPerformed(evt);
            }
        });
        jMenu1.add(mniOrden);

        mniOrden1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mniOrden1.setText("Materiales");
        mniOrden1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOrden1ActionPerformed(evt);
            }
        });
        jMenu1.add(mniOrden1);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Tareas Adminstrador");
        jMenu2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        mniProceso.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mniProceso.setText("Registrar Usuarios");
        mniProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProcesoActionPerformed(evt);
            }
        });
        jMenu2.add(mniProceso);

        mniProceso1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mniProceso1.setText("Registros Generales");
        mniProceso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniProceso1ActionPerformed(evt);
            }
        });
        jMenu2.add(mniProceso1);

        jMenuBar1.add(jMenu2);

        jMenu5.setForeground(new java.awt.Color(51, 51, 51));
        jMenu5.setText("SALIR");
        jMenu5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        mnSalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        mnSalir.setText("CERRAR APLICACION");
        mnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalirActionPerformed(evt);
            }
        });
        jMenu5.add(mnSalir);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlRegistroPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlDevolucionMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlIngresoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 610, Short.MAX_VALUE)
                    .addComponent(pnlClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 610, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRegistroPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlDevolucionMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlIngresoMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnInsertar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertar2ActionPerformed

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnListar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListar2ActionPerformed

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btn_Listar_ListarMultas_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_ListarMultas_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_ListarMultas_FuncActionPerformed

    private void rbtRolEstudiante_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtRolEstudiante_FuncActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_rbtRolEstudiante_FuncActionPerformed

    private void rbtRolDocente_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtRolDocente_FuncActionPerformed

    }//GEN-LAST:event_rbtRolDocente_FuncActionPerformed

    private void btn_Registrar_Eliminar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_Eliminar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Registrar_Eliminar_FuncActionPerformed

    private void btn_Listar_ListarPrestamos_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_ListarPrestamos_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_ListarPrestamos_FuncActionPerformed

    private void btn_Registrar_LimpiarCampos_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_LimpiarCampos_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Registrar_LimpiarCampos_FuncActionPerformed

    private void btn_Registrar_Actualizar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_Actualizar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Registrar_Actualizar_FuncActionPerformed

    private void btn_Registrar_Registrar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_Registrar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Registrar_Registrar_FuncActionPerformed

    private void btn_Registrar_Renovar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Registrar_Renovar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Registrar_Renovar_FuncActionPerformed

    private void btn_Devolucion_Registrar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Devolucion_Registrar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Devolucion_Registrar_FuncActionPerformed

    private void btn_Devolucion_Actualizar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Devolucion_Actualizar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Devolucion_Actualizar_FuncActionPerformed

    private void btn_Devolucion_Limpiar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Devolucion_Limpiar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Devolucion_Limpiar_FuncActionPerformed

    private void btn_Devolucion_Eliminar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Devolucion_Eliminar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Devolucion_Eliminar_FuncActionPerformed

    private void rbt_Devolucion_RolDocente_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_Devolucion_RolDocente_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbt_Devolucion_RolDocente_FuncActionPerformed

    private void rbt_Devolucion_RolEstududiante_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_Devolucion_RolEstududiante_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbt_Devolucion_RolEstududiante_FuncActionPerformed

    private void btn_Devolucion_Renovar_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Devolucion_Renovar_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Devolucion_Renovar_FuncActionPerformed

    private void btn_Listar_Multas_Usuarios_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_Multas_Usuarios_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_Multas_Usuarios_FuncActionPerformed

    private void btn_Actualizar_Multas_Usuarios_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar_Multas_Usuarios_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Actualizar_Multas_Usuarios_FuncActionPerformed

    private void btn_Borrar_Multas_Usuarios_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Borrar_Multas_Usuarios_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Borrar_Multas_Usuarios_FuncActionPerformed

    private void btn_Listar_ActualizarMultas_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_ActualizarMultas_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_ActualizarMultas_FuncActionPerformed

    private void btn_Listar_BorrarMultas_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_BorrarMultas_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_BorrarMultas_FuncActionPerformed

    private void btn_Listar_ActualizarPrestamos_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_ActualizarPrestamos_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_ActualizarPrestamos_FuncActionPerformed

    private void btn_Listar_BorrarPrestamos_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Listar_BorrarPrestamos_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Listar_BorrarPrestamos_FuncActionPerformed

    private void txt_Registrar_FechaDevolucion_FuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Registrar_FechaDevolucion_FuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Registrar_FechaDevolucion_FuncActionPerformed

    private void mniDatosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDatosClienteActionPerformed
        // TODO add your handling code here:
        setVisibleComponent(pnlRegistroPrestamos);

    }//GEN-LAST:event_mniDatosClienteActionPerformed

    private void mniOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniOrdenActionPerformed
        // TODO add your handling code here:
        setVisibleComponent(pnlDevolucionMultas);
    }//GEN-LAST:event_mniOrdenActionPerformed

    private void mniOrden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniOrden1ActionPerformed
        // TODO add your handling code here:
        setVisibleComponent(pnlIngresoMaterial);
    }//GEN-LAST:event_mniOrden1ActionPerformed

    private void mniProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProcesoActionPerformed
        // TODO add your handling code here:
        setVisibleComponent(pnlClientes);
    }//GEN-LAST:event_mniProcesoActionPerformed

    private void mniProceso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniProceso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniProceso1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnSalirActionPerformed

    private void btnRecursoIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecursoIngresarActionPerformed
        RecursoController controller = new RecursoController();
        try {
            if (controller.insertRecurso(inputToRecurso())) {
                JOptionPane.showMessageDialog(null, "Recurso agregado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo ingresar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnRecursoIngresarActionPerformed

    private void btnIngresarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarEditorialActionPerformed

    private void btnActualizarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEditorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarEditorialActionPerformed

    private void btnIngresarTopicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarTopicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarTopicoActionPerformed

    private void btnActualizarTopicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTopicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarTopicoActionPerformed

    private void btnIngresarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarAutorActionPerformed

    private void btnActualizarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarAutorActionPerformed

    private void btnAgregarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutorActionPerformed

        String cboAutorListValue = cboAutorList.getSelectedItem().toString();
        if (cboAutorListValue.equals("- seleccionar") == false) {
            DefaultListModel<String> modelo = (DefaultListModel<String>) listRecursoAutor.getModel();
            modelo.addElement(cboAutorListValue);
        }

    }//GEN-LAST:event_btnAgregarAutorActionPerformed

    private void btnQuitarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAutorActionPerformed
        DefaultListModel<String> modelo = (DefaultListModel<String>) listRecursoAutor.getModel();
        modelo.removeElement(listRecursoAutor.getSelectedValue());
    }//GEN-LAST:event_btnQuitarAutorActionPerformed

    private void btnAgregarTopicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTopicoActionPerformed
        String cboTopicoListValue = cboTopicoList.getSelectedItem().toString();
        if (cboTopicoListValue.equals("- seleccionar") == false) {
            DefaultListModel<String> modelo2 = (DefaultListModel<String>) listRecursoTopico.getModel();
            modelo2.addElement(cboTopicoListValue);
        }
    }//GEN-LAST:event_btnAgregarTopicoActionPerformed

    private void btnQuitarTopicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarTopicoActionPerformed
        DefaultListModel<String> modelo = (DefaultListModel<String>) listRecursoTopico.getModel();
        modelo.removeElement(listRecursoTopico.getSelectedValue());
    }//GEN-LAST:event_btnQuitarTopicoActionPerformed

    private void rbtnLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLibroActionPerformed
        tpTipoRecurso.setSelectedIndex(0);
    }//GEN-LAST:event_rbtnLibroActionPerformed

    private void rbtnPeriodicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPeriodicoActionPerformed
        tpTipoRecurso.setSelectedIndex(1);
    }//GEN-LAST:event_rbtnPeriodicoActionPerformed

    private void rbtnRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRevistaActionPerformed
        tpTipoRecurso.setSelectedIndex(2);
    }//GEN-LAST:event_rbtnRevistaActionPerformed

    public void limpiarControles() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar2;
    private javax.swing.JButton btnActualizarAutor;
    private javax.swing.JButton btnActualizarEditorial;
    private javax.swing.JButton btnActualizarTopico;
    private javax.swing.JButton btnAgregarAutor;
    private javax.swing.JButton btnAgregarTopico;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.ButtonGroup btnGroupRecurso;
    private javax.swing.ButtonGroup btnGroupTipoTexto;
    private javax.swing.JButton btnIngresarAutor;
    private javax.swing.JButton btnIngresarEditorial;
    private javax.swing.JButton btnIngresarTopico;
    private javax.swing.JButton btnInsertar2;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnListar2;
    private javax.swing.JButton btnQuitarAutor;
    private javax.swing.JButton btnQuitarTopico;
    private javax.swing.JButton btnRecursoActualizar;
    private javax.swing.JButton btnRecursoIngresar;
    private javax.swing.JButton btn_Actualizar_Multas_Usuarios_Func;
    private javax.swing.JButton btn_Borrar_Multas_Usuarios_Func;
    private javax.swing.JButton btn_Devolucion_Actualizar_Func;
    private javax.swing.JButton btn_Devolucion_Eliminar_Func;
    private javax.swing.JButton btn_Devolucion_Limpiar_Func;
    private javax.swing.JButton btn_Devolucion_Registrar_Func;
    private javax.swing.JButton btn_Devolucion_Renovar_Func;
    private javax.swing.JButton btn_Listar_ActualizarMultas_Func;
    private javax.swing.JButton btn_Listar_ActualizarPrestamos_Func;
    private javax.swing.JButton btn_Listar_BorrarMultas_Func;
    private javax.swing.JButton btn_Listar_BorrarPrestamos_Func;
    private javax.swing.JButton btn_Listar_ListarMultas_Func;
    private javax.swing.JButton btn_Listar_ListarPrestamos_Func;
    private javax.swing.JButton btn_Listar_Multas_Usuarios_Func;
    private javax.swing.JButton btn_Registrar_Actualizar_Func;
    private javax.swing.JButton btn_Registrar_Eliminar_Func;
    private javax.swing.JButton btn_Registrar_LimpiarCampos_Func;
    private javax.swing.JButton btn_Registrar_Registrar_Func;
    private javax.swing.JButton btn_Registrar_Renovar_Func;
    private javax.swing.JComboBox<String> cboAutorList;
    private javax.swing.JComboBox<String> cboEditorialList;
    private javax.swing.JComboBox<String> cboTopicoList;
    private com.toedter.calendar.JDateChooser jDatePeriodicoPublicacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<String> listRecursoAutor;
    private javax.swing.JList<String> listRecursoTopico;
    private javax.swing.JMenuItem mnSalir;
    private javax.swing.JMenuItem mniDatosCliente;
    private javax.swing.JMenuItem mniOrden;
    private javax.swing.JMenuItem mniOrden1;
    private javax.swing.JMenuItem mniProceso;
    private javax.swing.JMenuItem mniProceso1;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlDevolucionMultas;
    private javax.swing.JPanel pnlIngresoMaterial;
    private javax.swing.JPanel pnlRegistroPrestamos;
    private javax.swing.JRadioButton rbtRolDocente_Func;
    private javax.swing.JRadioButton rbtRolEstudiante_Func;
    private javax.swing.JRadioButton rbt_Devolucion_RolDocente_Func;
    private javax.swing.JRadioButton rbt_Devolucion_RolEstududiante_Func;
    private javax.swing.JRadioButton rbtnAltaDemanda;
    private javax.swing.JRadioButton rbtnLibro;
    private javax.swing.JRadioButton rbtnNormal;
    private javax.swing.JRadioButton rbtnPeriodico;
    private javax.swing.JRadioButton rbtnRevista;
    private javax.swing.JTable tblAutor;
    private javax.swing.JTable tblEditorial;
    private javax.swing.JTable tblMultasUsuario;
    private javax.swing.JTable tblPrecios6;
    private javax.swing.JTable tblTopico;
    private javax.swing.JTable tbl_Listar_Multas_Usuarios_Func;
    private javax.swing.JTable tbl_Listar_PrestamosUsuario_Func;
    private javax.swing.JTabbedPane tpRecursos;
    private javax.swing.JTabbedPane tpTipoRecurso;
    private javax.swing.JTextArea txaClientes2;
    private javax.swing.JTextField txtApellidoAutor;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtIdAutor;
    private javax.swing.JTextField txtIdEditorial;
    private javax.swing.JFormattedTextField txtIdRecursoFormated;
    private javax.swing.JTextField txtIdTopico;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtNombreAutor;
    private javax.swing.JTextField txtNombreEditorial;
    private javax.swing.JTextField txtNumeroCliente2;
    private javax.swing.JTextField txtPeriodicoLema;
    private javax.swing.JTextField txtTituloRecurso;
    private javax.swing.JTextField txtTituloTopico;
    private javax.swing.JTextField txtTotalPaginas;
    private javax.swing.JLabel txtVendedor7;
    private javax.swing.JTextField txt_Devolucion_ApellidoMaterno_Func;
    private javax.swing.JTextField txt_Devolucion_ApellidoPaterno_Func;
    private javax.swing.JTextField txt_Devolucion_IdUsuario_Func;
    private javax.swing.JTextField txt_Devolucion_Nombre_Func;
    private javax.swing.JTextField txt_Registrar_FechaDevolucion_Func;
    private javax.swing.JTextField txt_Registrar_FechaPrestamo_Func;
    private javax.swing.JTextField txt_Registrar_IdMaterial_Func;
    private javax.swing.JTextField txt_Registrar_IdUsuario_Func;
    private javax.swing.JTextField txt_Registrar_NombreCompleto_Func;
    private javax.swing.JTextField txt_Registrar_TituloMaterial_Func;
    // End of variables declaration//GEN-END:variables
}

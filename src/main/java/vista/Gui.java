package vista;

import java.awt.*;
import javax.swing.*;

/**
 * Example Swing GUI.
 * <p>
 * Inspired by
 * <a href="http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm">
 * http://www.java2s.com/Code/Java/Swing-JFC/GUIinvokedfromtheeventdispatchingthread.htm</a>
 *
 * @author Greg Chabala
 * @since Sep 29, 2010
 */
public class Gui {

    private static int count = 1;
    private static JFrame lastFrame = null;

    public Gui() {
        SwingUtilities.invokeLater(this::showFrame);
    }

    private void showFrame() {

// ***************************************
//       /* 1. USUARIOS Y ROLES */
//        ArrayList<Rol> roles = new ArrayList<>();
//        roles.add(Rol.ADMIN);
//        roles.add(Rol.FUNCIONARIO);
//        Usuario usuario = new Usuario();
//        usuario.setActivo(false);
//        usuario.setApellido("Jeldes");
//        usuario.setNombre("Emilio");
//        usuario.setRoles(roles);
//
//        em.getTransaction().begin();
//        em.persist(usuario);
//        em.getTransaction().commit();
//
//        Usuario usuarioSaved = null;
//
//        try {
//            em.getTransaction().begin();
//            usuarioSaved = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.apellido = :apellido")
//                    .setParameter("nombre", "Emilio")
//                    .setParameter("apellido", "Jeldes")
//                    .getSingleResult();
//        } catch (Exception e) {
//        }
//
//        if (usuarioSaved == null) {
//            usuarioSaved.setNombre("No encontrado");
//            usuarioSaved.setApellido("");
//        }
// ***************************************
// ***************************************
        /* 2. Libros con mapeo de super clase */
//        Libro libro = new Libro();
//        libro.setContraportada("Contraportada");
//        libro.setIsbn("123456789");
//        libro.setLomo("lomooo");
//        libro.setPortada("Portada shiaaa");
//        libro.setTitulo("The number of the beast");
//        libro.setTotalPaginas(666);
//        
//        em.getTransaction().begin();
//        em.persist(libro);
//        em.getTransaction().commit();
//        
//        Libro libroSaved = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo")
//                .setParameter("titulo", "The number of the beast")
//                .getSingleResult();
// ***************************************
// ***************************************
        /* 3. Periodicos con mapeo de super clase  */
//        
//        Periodico periodico = new Periodico();
//        periodico.setLema("Por la razon o la fuerza");
//        periodico.setPortada("Portada de periodico");
//        periodico.setTitulo("Diario el sur");
//        periodico.setTotalPaginas(50);
//        
//        em.getTransaction().begin();
//        em.persist(periodico);
//        em.getTransaction().commit();
//        
//        Periodico periodicoSaved = (Periodico) em.createQuery("SELECT p FROM periodico p WHERE p.titulo = :titulo")
//                .setParameter("titulo", "Diario el sur")
//                .getSingleResult();
// ***************************************
// ***************************************
        /* 4. Revista con mapeo de super class */
//        Revista revista = new Revista();
//        revista.setTitulo("Revista qlia");
//        revista.setTotalPaginas(30);
//       
//        em.getTransaction().begin();
//        em.persist(revista);
//        em.getTransaction().commit();
//        
//        Revista revistaSaved = (Revista) em.createQuery("SELECT r FROM Revista r WHERE r.titulo = :titulo")
//                .setParameter("titulo", "Revista qlia")
//                .getSingleResult();
//        
// ***************************************
// ***************************************
//        /* 5. Recurso - Autor - Editorial - Recurso_Autor- Topico - Topico_Recurso - */
//        Autor autor1 = new Autor();
//        autor1.setNombre("Carlos Qliao");
//
//        Autor autor2 = new Autor();
//        autor2.setNombre("Juan Qliao");
//
//        em.getTransaction().begin();
//        em.persist(autor1);
//        em.flush();
//
//        em.persist(autor2);
//        em.flush();
//
//        ArrayList<Autor> autores = new ArrayList<>();
//        autores.add(autor1);
//        autores.add(autor2);
//
//        Editorial editorial = new Editorial();
//        editorial.setEditorial("McgrawHill");
//        em.persist(editorial);
//        em.flush();
//
//        Topico topico1 = new Topico();
//        topico1.setTopico("Fantasia");
//
//        Topico topico2 = new Topico();
//        topico2.setTopico("Epico");
//
//        em.persist(topico1);
//        em.flush();
//        em.persist(topico2);
//        em.flush();
//
//        ArrayList<Topico> topicos = new ArrayList<>();
//        topicos.add(topico1);
//        topicos.add(topico2);
//
//        Recurso recurso = new Recurso();
//        recurso.setAutores(autores);
//        recurso.setEditorial(editorial);
//        recurso.setTipoRecurso(TipoRecurso.LIBRO);
//        recurso.setTipoTexto(TipoTexto.ALTA_DEMANDA);
//        recurso.setTitulo("Metamorfosis");
//        recurso.setTotalPaginas(450);
//        recurso.setTopicos(topicos);
//
//        em.persist(recurso);
//        em.flush();
//        em.getTransaction().commit();
//
//        em.getTransaction().begin();
//        Recurso recursoSaved = em.find(Recurso.class, recurso.getId());
// ***************************************
        JFrame frame = new JFrame("Beeper " + count++);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Hello World"));
        frame.add(new BeepingButton("Click Me"));
//        frame.add(new LabelDisplay(usuarioSaved.getId() + " " + usuarioSaved.getRoles().get(1) + " " + usuarioSaved.getNombre()));
//        frame.add(new LabelDisplay((recursoSaved.getAutores().get(1) + " " + recursoSaved.getEditorial() + " " + recursoSaved.getTipoTexto().toString())));

        frame.pack();
        if (lastFrame == null) {
            frame.setLocationByPlatform(true);
        } else {
            Point p = lastFrame.getLocation();
            p.translate(50, 50);
            frame.setLocation(p);
        }
        lastFrame = frame;
        frame.setVisible(true);

    }

    private static class LabelDisplay extends JLabel {

        public LabelDisplay(final String text) {
            super(text);
            super.setPreferredSize(new Dimension(400, 50));
            super.setText(text);
        }

    }

    private static class BeepingButton extends JButton {

        BeepingButton(final String text) {
            super(text);
            setPreferredSize(new Dimension(140, 60));
            addActionListener((e) -> {
                Tone.sound(2000, 150);
                new Gui();
            });
        }
    }

    public static void main(String[] args) {

        new Gui();

    }

}

package tp3.vista;

import tp3.model.*;
import tp3.persistencia.FileRegistroDeConcursos;
import tp3.persistencia.FileRegistroDeInscripciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
public class PantallaDeInscripcion {
    private RegistroConcursos registroConcursos;
    private RegistroInscripciones registroInscripciones;

    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<Concurso> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    public PantallaDeInscripcion(RegistroConcursos registroConcursos, RegistroInscripciones registroInscripciones) {
        this.registroConcursos = registroConcursos;
        this.registroInscripciones = registroInscripciones;

        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }
    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                saveInscription();
                btnOk.setEnabled(true);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<Concurso>();
        todosLosConcursos();

    }

    private void todosLosConcursos() {
        //carga los concursos disponibles para su inscripcion en el combobox
        Concursos concursos = new Concursos(registroConcursos);
        List<Concurso> concursosAbiertos = concursos.concursosAbiertos();
        for (Concurso c : concursosAbiertos){
            comboBox.addItem(c);
        }
    }
    private void saveInscription() {
            if(!validations()){
                return;
            }
            // Guarda en inscriptos.txt los datos de la persona y el concurso elegido

            String nombre = txtName.getText();
            String apellido = txtLastName.getText();
            String telefono = txtPhone.getText();
            String email = txtEmail.getText();
            String dni = txtId.getText();
            Concurso concurso = (Concurso)comboBox.getSelectedItem();

            Inscripcion insc = new Inscripcion(nombre,apellido,dni,telefono,email,concurso.id());
            try {
                registroInscripciones.registrarInscripcion(insc);
                JOptionPane.showMessageDialog(this.contentPane,"¡Inscripción guardada con éxito!");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this.contentPane, "Error al guardar: " + ex.getMessage());
            }

    }
    private boolean validations() {
        if (this.comboBox.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
            return false;
        }
        return true;
    }

    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        setearGrupoHorizontal(gl_contentPane);
        setearGrupoVertical(gl_contentPane);
    }

    //separe en dos metodos para que sea un poco mas legible
    private void setearGrupoHorizontal(GroupLayout gl_contentPane) {
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane
                                .createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
                                        .createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(
                                                gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtEmail, Alignment.TRAILING)
                                                        .addComponent(txtPhone, Alignment.TRAILING)
                                                        .addComponent(txtId, Alignment.TRAILING)
                                                        .addComponent(txtLastName, Alignment.TRAILING)
                                                        .addComponent(txtName, Alignment.TRAILING,
                                                                GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
    }

    private void setearGrupoVertical(GroupLayout gl_contentPane) {
        gl_contentPane
                .setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblLastName).addComponent(txtLastName,
                                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addComponent(lblId).addComponent(
                                                txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(
                                                gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                                        .addPreferredGap(ComponentPlacement.UNRELATED)
                                                        .addComponent(lblEmail))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED).addGroup(
                                                        gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblCompetition))))
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk)
                                .addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}


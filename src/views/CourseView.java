package views;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class CourseView extends JFrame {
    private JTextField txtID;
    private JTextField txtName;
    private JComboBox<String> comboTcID;
    private JTextField txtCategory;
    private JTable table;
    private JButton btnSave, btnUpdate, btnDelete;

    public CourseView() {
        setTitle("CRUD Operation Swing MySQL");
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Course Management System");
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 259, 60);
        getContentPane().add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(20, 71, 387, 284);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Id");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(21, 46, 46, 24);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("course");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(21, 81, 46, 24);
        panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Teacher");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_2.setBounds(21, 116, 80, 24);
        panel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Category");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_3.setBounds(21, 154, 80, 24);
        panel.add(lblNewLabel_1_3);

        txtID = new JTextField();
        txtID.setEditable(false);
        txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtID.setBounds(111, 46, 254, 24);
        panel.add(txtID);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtName.setBounds(111, 81, 254, 24);

        panel.add(txtName);

        comboTcID = new JComboBox<>();
        comboTcID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboTcID.setBounds(111, 116, 254, 24);
        panel.add(comboTcID);

        txtCategory = new JTextField();
        txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtCategory.setBounds(111, 154, 254, 24);
        panel.add(txtCategory);

        btnSave = new JButton("Save");
        btnSave.setBackground(Color.PINK);
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSave.setBounds(20, 195, 89, 23);
        panel.add(btnSave);

        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.PINK);
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdate.setBounds(142, 195, 89, 23);
        panel.add(btnUpdate);

        btnDelete = new JButton("Delete");
        btnDelete.setBackground(Color.RED);
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDelete.setBounds(276, 195, 89, 23);
        panel.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(417, 71, 467, 284);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setBackground(Color.GREEN);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(30);
        scrollPane.setViewportView(table);

        setBounds(100, 100, 910, 522);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JTextField getTxtID() {
        return txtID;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JComboBox<String> getComboTcID() {
        return comboTcID;
    }

    public JTextField getTxtCategory() {
        return txtCategory;
    }

    public JTable getTable() {
        return table;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }
}

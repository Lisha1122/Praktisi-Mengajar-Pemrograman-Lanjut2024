/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guiproject;

/**
 *
 * @author Lisha Khaerunniswah
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.border.EmptyBorder;

public class GUIProject {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel lbNo;
    private JLabel lbNama;
    private JLabel lbBanyak;
    private JLabel lbTotal;
    private JButton ambilNomorButton;
    private JTextArea txAntri;
    private JButton selanjutnyaButton;
    private JTextField txNama;
    private JButton resetButton;

    private Queue<String> antrian = new LinkedList<>();
    private Queue<String> nama = new LinkedList<>();
    private int nomor = 0;
    private static final String FILE_PATH = "antrian.dat";
    private static final String DOCUMENT_FILE_PATH = "c:/Users/Lisha Khaerunniswah/Documents/NetBeansProjects/OperationFile/src/Documents.txt";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIProject::new);
    }

    public GUIProject() {
        frame = new JFrame(); // Ensure we are using javax.swing.JFrame
        frame.setTitle("Sistem Antrian Puskesmas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // Add title label
        JLabel titleLabel = new JLabel("SISTEM ANTRIAN PUSKESMAS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Main panel with padding
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // GridBagConstraints for layout control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Initialize components
        initializeComponents();

        // Adding components to main panel
        addComponentsToMainPanel(gbc);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);

        // Load existing antrian
        loadAntrian();

        // Set frame visible
        frame.setVisible(true);
    }

    private void initializeComponents() {
        lbNo = new JLabel("Antrian Kosong");
        lbNama = new JLabel("-----------");
        lbBanyak = new JLabel("0");
        lbTotal = new JLabel("0");
        ambilNomorButton = new JButton("Ambil Nomor");
        selanjutnyaButton = new JButton("Selanjutnya");
        resetButton = new JButton("Reset");
        txNama = new JTextField(20);
        txAntri = new JTextArea(10, 30);
        txAntri.setEditable(false);

        ambilNomorButton.addActionListener(e -> ambilNomor());
        selanjutnyaButton.addActionListener(e -> selanjutnya());
        resetButton.addActionListener(e -> reset());
        txNama.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isISOControl(c)) {
                    e.consume();
                }
            }
        });
    }

    private void addComponentsToMainPanel(GridBagConstraints gbc) {
        gbc.gridx = 0; gbc.gridy = 0; mainPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; mainPanel.add(txNama, gbc);
        gbc.gridx = 0; gbc.gridy = 1; mainPanel.add(ambilNomorButton, gbc);
        gbc.gridx = 1; gbc.gridy = 1; mainPanel.add(selanjutnyaButton, gbc);
        gbc.gridx = 0; gbc.gridy = 2; mainPanel.add(resetButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; mainPanel.add(new JScrollPane(txAntri), gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 4; mainPanel.add(new JLabel("Jumlah Antrian:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; mainPanel.add(lbBanyak, gbc);
        gbc.gridx = 0; gbc.gridy = 5; mainPanel.add(new JLabel("Total Nomor:"), gbc);
        gbc.gridx = 1; gbc.gridy = 5; mainPanel.add(lbTotal, gbc);
        gbc.gridx = 0; gbc.gridy = 6; mainPanel.add(new JLabel("Nomor Sekarang:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; mainPanel.add(lbNo, gbc);
        gbc.gridx = 0; gbc.gridy = 7; mainPanel.add(new JLabel("Nama Sekarang:"), gbc);
        gbc.gridx = 1; gbc.gridy = 7; mainPanel.add(lbNama, gbc);
    }

    private void reset() {
        JOptionPane.showMessageDialog(frame, "Antrian ter-reset");
        lbBanyak.setText("0");
        lbTotal.setText("0");
        lbNo.setText("Antrian Kosong");
        lbNama.setText("-----------");
        txAntri.setText("");
        antrian.clear();
        nama.clear();
        nomor = 0;
        saveAntrian();
    }

    private void ambilNomor() {
        if (txNama.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Silakan Masukkan Nama Terlebih Dahulu!");
        } else {
            nomor++;
            String nm = txNama.getText();
            String ant = "Antrian " + nomor;
            antrian.add(ant);
            nama.add(nm);
            lbBanyak.setText(String.valueOf(antrian.size()));
            lbNo.setText(antrian.peek());
            lbTotal.setText(String.valueOf(nomor));
            txAntri.append(nm + "\n");
            lbNama.setText(nama.peek());
            txNama.setText("");
            saveAntrian();
        }
    }

    private void selanjutnya() {
        if (antrian.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Ambil Nomor antrian terlebih dahulu!");
        } else {
            antrian.poll();
            nama.poll();
            lbBanyak.setText(String.valueOf(antrian.size()));
            txAntri.setText("");
            nama.forEach(element -> txAntri.append(element + "\n"));
            if (antrian.isEmpty()) {
                lbNo.setText("Antrian Kosong");
                lbNama.setText("-----------");
            } else {
                lbNo.setText(antrian.peek());
                lbNama.setText(nama.peek());
            }
            saveAntrian();
        }
    }

    private void saveAntrian() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(new LinkedList<>(antrian));
            out.writeObject(new LinkedList<>(nama));
            out.writeInt(nomor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Save to Documents.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCUMENT_FILE_PATH))) {
            writer.write("Nomor: " + nomor + "\n");
            writer.write("Antrian:\n");
            for (String item : antrian) {
                writer.write(item + "\n");
            }
            writer.write("Nama:\n");
            for (String name : nama) {
                writer.write(name + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAntrian() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("File antrian.dat tidak ditemukan, membuat file baru.");
            saveAntrian(); // Membuat file baru jika tidak ada
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            antrian = (Queue<String>) in.readObject();
            nama = (Queue<String>) in.readObject();
            nomor = in.readInt();
            lbBanyak.setText(String.valueOf(antrian.size()));
            lbTotal.setText(String.valueOf(nomor));
            if (!antrian.isEmpty()) {
                lbNo.setText(antrian.peek());
                lbNama.setText(nama.peek());
                txAntri.setText("");
                nama.forEach(element -> txAntri.append(element + "\n"));
            } else {
                lbNo.setText("Antrian Kosong");
                lbNama.setText("-----------");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Load from Documents.txt if available
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCUMENT_FILE_PATH))) {
            String line;
            antrian.clear();
            nama.clear();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nomor: ")) {
                    nomor = Integer.parseInt(line.substring(7));
                } else if (line.equals("Antrian:")) {
                    while ((line = reader.readLine()) != null && !line.equals("Nama:")) {
                        antrian.add(line);
                    }
                } else if (line.equals("Nama:")) {
                    while ((line = reader.readLine()) != null) {
                        nama.add(line);
                    }
                }
            }
            lbBanyak.setText(String.valueOf(antrian.size()));
            lbTotal.setText(String.valueOf(nomor));
            if (!antrian.isEmpty()) {
                lbNo.setText(antrian.peek());
                lbNama.setText(nama.peek());
                txAntri.setText("");
                nama.forEach(element -> txAntri.append(element + "\n"));
            } else {
                lbNo.setText("Antrian Kosong");
                lbNama.setText("-----------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
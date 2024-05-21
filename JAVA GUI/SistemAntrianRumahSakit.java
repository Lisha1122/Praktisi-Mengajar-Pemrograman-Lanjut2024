import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class SistemAntrianRumahSakit {
    private Queue<String> antrianPasien = new LinkedList<>();
    private JLabel labelPasienSaatIni;
    private JLabel labelPasienSelesai;
    private JTextArea textAreaDaftarAntrian;
    private JTextField textFieldNamaPasien;

    public SistemAntrianRumahSakit() {
        JFrame frame = new JFrame("Sistem Antrian Rumah Sakit");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel untuk menambahkan pasien
        JPanel panelTambahPasien = new JPanel();
        panelTambahPasien.setLayout(new FlowLayout());
        textFieldNamaPasien = new JTextField(20);
        JButton tombolTambahPasien = new JButton("Tambah Pasien");
        tombolTambahPasien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahPasien();
            }
        });
        panelTambahPasien.add(new JLabel("Nama Pasien:"));
        panelTambahPasien.add(textFieldNamaPasien);
        panelTambahPasien.add(tombolTambahPasien);

        // Panel untuk daftar antrian
        JPanel panelDaftarAntrian = new JPanel();
        panelDaftarAntrian.setLayout(new BorderLayout());
        panelDaftarAntrian.add(new JLabel("Daftar Antrian:"), BorderLayout.NORTH);
        textAreaDaftarAntrian = new JTextArea();
        textAreaDaftarAntrian.setEditable(false);
        panelDaftarAntrian.add(new JScrollPane(textAreaDaftarAntrian), BorderLayout.CENTER);

        // Panel untuk mereset antrian
        JPanel panelResetAntrian = new JPanel();
        panelResetAntrian.setLayout(new FlowLayout());
        JButton tombolResetAntrian = new JButton("Reset Antrian");
        tombolResetAntrian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAntrian();
            }
        });
        panelResetAntrian.add(tombolResetAntrian);

        // Menambahkan semua panel ke frame
        frame.add(panelTambahPasien, BorderLayout.NORTH);
        frame.add(panelDaftarAntrian, BorderLayout.CENTER);
        frame.add(panelResetAntrian, BorderLayout.AFTER_LAST_LINE);

        frame.setVisible(true);
    }

    private void tambahPasien() {
        String namaPasien = textFieldNamaPasien.getText().trim();
        if (namaPasien.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama pasien tidak boleh kosong.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        antrianPasien.add(namaPasien);
        textFieldNamaPasien.setText("");
        perbaruiDaftarAntrian();
        JOptionPane.showMessageDialog(null, "Pasien " + namaPasien + " telah ditambahkan ke antrian.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetAntrian() {
        antrianPasien.clear();
        labelPasienSaatIni.setText("Tidak ada");
        labelPasienSelesai.setText("Tidak ada");
        perbaruiDaftarAntrian();
    }

    private void perbaruiDaftarAntrian() {
        StringBuilder teksAntrian = new StringBuilder();
        int index = 1;
        for (String pasien : antrianPasien) {
            teksAntrian.append(index).append(". ").append(pasien).append("\n");
            index++;
        }
        textAreaDaftarAntrian.setText(teksAntrian.toString());
    }

    public static void main(String[] args) {
        new SistemAntrianRumahSakit();
    }
}
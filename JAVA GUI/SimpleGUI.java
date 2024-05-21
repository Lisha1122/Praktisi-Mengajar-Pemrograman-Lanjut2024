import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGUI {
    public static void main(String[] args) {
        // Membuat JFrame
        JFrame frame = new JFrame("Simple GUI");

        // Menentukan ukuran JFrame
        frame.setSize(400, 300);

        // Mengatur operasi default ketika frame ditutup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat JButton
        JButton button = new JButton("Click Me");

        // Menambahkan JButton ke JFrame
        frame.add(button);

        // Menampilkan JFrame
        frame.setVisible(true);
    }
}

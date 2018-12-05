import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Window window = new Window("Rivest, Shamir & Adleman (RSA) and ElGamal signature schemes.");
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}

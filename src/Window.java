import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Random;

class Window extends JFrame {
    private JTextArea sourceText;
    private JTextArea outputText;
    private JTextArea signatureText;
    private JCheckBox keyByDefault;
    private JCheckBox isHex;
    private JSpinner p;
    private JSpinner q;
    private JSpinner e;
    private JButton encryptButton;
    private JButton decryptButton;

    Window(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        panel.setLayout(null);
        sourceText = new JTextArea();
        outputText = new JTextArea();
        signatureText = new JTextArea();
        JScrollPane sourceTextScrollPane = new JScrollPane(sourceText);
        JScrollPane outputTextScrollPane = new JScrollPane(outputText);
        JScrollPane signatureTextScrollPane = new JScrollPane(signatureText);
        keyByDefault = new JCheckBox("Key by default");
        isHex = new JCheckBox("Hex");
        p = new JSpinner(new SpinnerNumberModel((Long) 1009L, (Long) 1009L, (Long) 9973L, (Long) 1L));
        q = new JSpinner(new SpinnerNumberModel((Long) 1009L, (Long) 1009L, (Long) 9973L, (Long) 1L));
        e = new JSpinner(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        JRadioButton RSA = new JRadioButton("RSA");
        JRadioButton ElGamal = new JRadioButton("ElGamal");
        JButton clearButton = new JButton("Clear fields");
        JLabel sourceLabel = new JLabel("Input text for encryption here:");
        JLabel outLabel = new JLabel("Your encrypted data:");
        JLabel pLabel = new JLabel("Input prime number p:");
        JLabel qLabel = new JLabel("Input prime number q:");
        JLabel eLabel = new JLabel("Input e parameter:");
        JRadioButton encrypt = new JRadioButton("Encrypt");
        JRadioButton decrypt = new JRadioButton("Decrypt");
        JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\key.png"));
        RSA.setSize(150, 50);
        ElGamal.setSize(150, 50);
        RSA.setLocation(50, 25);
        ElGamal.setLocation(50, 75);
        image.setSize(175, 200);
        image.setLocation(50, 150);
        encrypt.setSize(150, 50);
        encrypt.setLocation(250, 25);
        decrypt.setSize(150, 50);
        decrypt.setLocation(250, 75);
        keyByDefault.setSize(100, 50);
        keyByDefault.setLocation(150, 75);
        isHex.setSize(100, 50);
        isHex.setLocation(150, 25);
        encryptButton.setSize(250, 50);
        encryptButton.setLocation(121, 390);
        encryptButton.setBackground(new Color(100, 200, 225));
        decryptButton.setSize(250, 50);
        decryptButton.setLocation(121, 390);
        decryptButton.setBackground(new Color(100, 200, 225));
        clearButton.setSize(250, 50);
        clearButton.setLocation(863, 390);
        clearButton.setBackground(new Color(225, 100, 100));
        sourceTextScrollPane.setSize(400, 300);
        sourceTextScrollPane.setLocation(350, 50);
        outputTextScrollPane.setSize(400, 300);
        outputTextScrollPane.setLocation(800, 50);
        signatureTextScrollPane.setSize(250, 50);
        signatureTextScrollPane.setLocation(492, 390);
        pLabel.setSize(175, 25);
        pLabel.setLocation(50, 125);
        p.setSize(275, 50);
        p.setLocation(50, 150);
        qLabel.setSize(275, 25);
        qLabel.setLocation(50, 200);
        q.setSize(275, 50);
        q.setLocation(50, 225);
        eLabel.setSize(175, 25);
        eLabel.setLocation(50, 275);
        e.setSize(275, 50);
        e.setLocation(50, 300);
        sourceLabel.setSize(200, 25);
        sourceLabel.setLocation(350, 25);
        outLabel.setSize(200, 25);
        outLabel.setLocation(800, 25);
        encryptButton.setContentAreaFilled(false);
        decryptButton.setContentAreaFilled(false);
        clearButton.setContentAreaFilled(false);
        encryptButton.setOpaque(true);
        decryptButton.setOpaque(true);
        clearButton.setOpaque(true);
        encrypt.setOpaque(false);
        decrypt.setOpaque(false);
        ElGamal.setOpaque(false);
        RSA.setOpaque(false);
        keyByDefault.setOpaque(false);
        isHex.setOpaque(false);
        outputText.setLineWrap(true);
        signatureText.setLineWrap(true);
        sourceText.setLineWrap(true);
        keyByDefault.setSelected(true);
        isHex.setSelected(false);
        encryptButton.setVisible(true);
        decryptButton.setVisible(false);
        encryptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        decryptButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sourceText.setFont(new Font("System Regular", Font.PLAIN, 16));
        outputText.setFont(new Font("System Regular", Font.PLAIN, 16));
        signatureText.setFont(new Font("System Regular", Font.PLAIN, 16));
        p.setFont(new Font("System Regular", Font.PLAIN, 16));
        q.setFont(new Font("System Regular", Font.PLAIN, 16));
        e.setFont(new Font("System Regular", Font.PLAIN, 16));
        panel.add(sourceLabel);
        panel.add(outLabel);
        panel.add(pLabel);
        panel.add(qLabel);
        panel.add(eLabel);
        panel.add(clearButton);
        panel.add(sourceTextScrollPane);
        panel.add(outputTextScrollPane);
        panel.add(signatureTextScrollPane);
        panel.add(p);
        panel.add(q);
        panel.add(e);
        panel.add(image);
        image.setVisible(true);
        panel.add(keyByDefault);
        panel.add(isHex);
        panel.add(encryptButton);
        panel.add(decryptButton);
        outputText.setWrapStyleWord(true);
        sourceText.setWrapStyleWord(true);
        signatureText.setWrapStyleWord(true);
        p.setVisible(false);
        q.setVisible(false);
        e.setVisible(false);
        pLabel.setVisible(false);
        qLabel.setVisible(false);
        eLabel.setVisible(false);
        ButtonGroup group = new ButtonGroup();
        group.add(encrypt);
        group.add(decrypt);
        panel.add(encrypt);
        panel.add(decrypt);
        encrypt.setSelected(true);
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(RSA);
        typeGroup.add(ElGamal);
        panel.add(RSA);
        panel.add(ElGamal);
        RSA.setSelected(true);
        setContentPane(panel);
        setSize(1250, 500);
        keyByDefault.addActionListener(e1 -> {
            if (p.isVisible()) {
                p.setValue(1009L);
                q.setValue(1009L);
                e.setValue(1009L);
            }
            image.setVisible(!image.isVisible());
            pLabel.setVisible(!pLabel.isVisible());
            qLabel.setVisible(!qLabel.isVisible());
            if (encrypt.isSelected()) {
                eLabel.setVisible(!keyByDefault.isSelected());
                e.setVisible(!keyByDefault.isSelected());
            }
            p.setVisible(!p.isVisible());
            q.setVisible(!q.isVisible());
        });
        isHex.addActionListener(e -> {
            if (isHex.isSelected()) {
                String source = sourceText.getText();
                StringBuilder sourceOut = new StringBuilder();
                for (int i = 0; i < source.length(); i++) {
                    sourceOut.append(String.format("%04x", (int) source.charAt(i)).toUpperCase());
                }
                sourceText.setText(sourceOut.toString());
                String output = outputText.getText();
                StringBuilder outputOut = new StringBuilder();
                for (int i = 0; i < output.length(); i++) {
                    outputOut.append(String.format("%04x", (int) output.charAt(i)).toUpperCase());
                }
                outputText.setText(outputOut.toString());
                String signature = signatureText.getText();
                StringBuilder signatureOut = new StringBuilder();
                for (int i = 0; i < signature.length(); i++) {
                    signatureOut.append(String.format("%04x", (int) signature.charAt(i)).toUpperCase());
                }
                signatureText.setText(signatureOut.toString());
            } else {
                String source = sourceText.getText();
                String output = outputText.getText();
                String signature = signatureText.getText();
                StringBuilder sourceOut = new StringBuilder();
                if (source.length() % 4 != 0 || output.length() % 4 != 0 || signature.length() % 4 != 0) {
                    JOptionPane.showMessageDialog(Window.this, "Length not multiple by 4!\n" +
                                    "Try once again...",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    isHex.setSelected(true);
                    return;
                }
                for (int i = 0; i < source.length(); i += 4) {
                    int item;
                    try {
                        item = Integer.parseInt(source.substring(i, i + 4), 16);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Window.this, "Incorrect data was input!\n" +
                                        "Try once again...",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(true);
                        return;
                    }
                    sourceOut.append((char) item);
                }
                sourceText.setText(sourceOut.toString());
                StringBuilder outputOut = new StringBuilder();
                for (int i = 0; i < output.length(); i += 4) {
                    int item;
                    try {
                        item = Integer.parseInt(output.substring(i, i + 4), 16);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Window.this, "Incorrect data was input!\n" +
                                        "Try once again...",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(true);
                        return;
                    }
                    outputOut.append((char) item);
                }
                outputText.setText(outputOut.toString());
                StringBuilder signatureOut = new StringBuilder();
                for (int i = 0; i < signature.length(); i += 4) {
                    int item;
                    try {
                        item = Integer.parseInt(signature.substring(i, i + 4), 16);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Window.this, "Incorrect data was input!\n" +
                                        "Try once again...",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(true);
                        return;
                    }
                    signatureOut.append((char) item);
                }
                signatureText.setText(signatureOut.toString());
            }
        });
        encrypt.addActionListener(e1 -> {
            encryptButton.setVisible(true);
            decryptButton.setVisible(false);
            sourceLabel.setText("Input text for encryption here:");
            outLabel.setText("Your encrypted data:");
            if (!sourceText.getText().equals("") && !outputText.getText().equals("")) {
                String temp = sourceText.getText();
                sourceText.setText(outputText.getText());
                outputText.setText(temp);
            }
            image.setVisible(true);
            keyByDefault.setVisible(true);
            pLabel.setVisible(false);
            qLabel.setVisible(false);
            p.setVisible(false);
            q.setVisible(false);
            e.setVisible(false);
            eLabel.setVisible(false);
            isHex.setLocation(150, 25);
            keyByDefault.setSelected(true);
            pLabel.setText("Input prime number p:");
            qLabel.setText("Input prime number q:");
            p.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) 9973L, (Long) 1L));
            q.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) 9973L, (Long) 1L));
        });
        decrypt.addActionListener(e1 -> {
            encryptButton.setVisible(false);
            decryptButton.setVisible(true);
            sourceLabel.setText("Input text for decryption here:");
            outLabel.setText("Your decrypted data:");
            if (!sourceText.getText().equals("") && !outputText.getText().equals("")) {
                String temp = sourceText.getText();
                sourceText.setText(outputText.getText());
                outputText.setText(temp);
            }
            image.setVisible(false);
            keyByDefault.setVisible(false);
            pLabel.setVisible(true);
            qLabel.setVisible(true);
            p.setVisible(true);
            q.setVisible(true);
            e.setVisible(true);
            eLabel.setVisible(true);
            isHex.setLocation(150, 75);
            pLabel.setText("Input d parameter:");
            qLabel.setText("Input n parameter:");
            p.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
            q.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
        });
        RSA.addActionListener(e1 -> {

        });
        ElGamal.addActionListener(e1 -> {

        });
        clearButton.addActionListener(e1 -> {
            sourceText.setText("");
            outputText.setText("");
            signatureText.setText("");
            p.setValue(1009L);
            q.setValue(1009L);
            e.setValue(1009L);
        });
        ActionListener actionListener = e -> translate(decrypt.isSelected());
        encryptButton.addActionListener(actionListener);
        decryptButton.addActionListener(actionListener);
    }

    public class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth();
            int h = getHeight();
            Color color1 = new Color(255, 242, 130);
            Color color2 = new Color(255, 114, 0);
            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, w, h);
        }
    }

    private void translate(boolean isDecrypt) {
        if (sourceText.getText().equals("")) {
            JOptionPane.showMessageDialog(Window.this, "Input text area is empty!\n" +
                            "Input some data...",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        BigInteger[] key = new BigInteger[2];
        String source = sourceText.getText(), output, signature = signatureText.getText();
        if (isHex.isSelected()) {
            try {
                source = hexToText(source);
                signature = hexToText(signature);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(Window.this, "Incorrect data was input!\n" +
                                "Try once again...",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (!isDecrypt) {
            BigInteger eValue, phi, n, d;
            if (keyByDefault.isSelected()) {
                long p = 0, q = 0;
                Random rand = new Random();
                while (RSA.isNotPrime(new BigInteger(Long.toString(p))) || p < 1000 || p > 9973) {
                    p = rand.nextInt(9973);
                }
                while (RSA.isNotPrime(new BigInteger(Long.toString(q))) || q < 1000 || q > 9973) {
                    q = rand.nextInt(9973);
                }
                key[0] = new BigInteger(Long.toString(p));
                key[1] = new BigInteger(Long.toString(q));
                n = key[0].multiply(key[1]);
                phi = key[0].subtract(BigInteger.ONE).multiply(key[1].subtract(BigInteger.ONE));
                do {
                    eValue = new BigInteger(phi.bitLength(), rand);
                    d = RSA.xgcd(phi, eValue)[1];
                }
                while (eValue.compareTo(phi) >= 0 || RSA.notRelativelyPrime(phi, eValue) || d.compareTo(BigInteger.ZERO) < 0);
            } else {
                key[0] = new BigInteger(p.getValue().toString());
                key[1] = new BigInteger(q.getValue().toString());
                n = key[0].multiply(key[1]);
                phi = key[0].subtract(BigInteger.ONE).multiply(key[1].subtract(BigInteger.ONE));
                eValue = new BigInteger(e.getValue().toString());
                d = RSA.xgcd(phi, eValue)[1];
                if (d.compareTo(BigInteger.ZERO) < 0) {
                    JOptionPane.showMessageDialog(Window.this, "Bad parameters!\n" +
                                    "Try once again...",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (RSA.isNotPrime(key[0]) || RSA.isNotPrime(key[1])) {
                    JOptionPane.showMessageDialog(Window.this, "Numbers are not prime integers!\n" +
                                    "Try once again...",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (RSA.notRelativelyPrime(phi, eValue)) {
                    JOptionPane.showMessageDialog(Window.this, "E is not relatively prime to φ!\n" +
                                    "Try once again...",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            JTextArea ta = new JTextArea(3, 30);
            ta.setText("Your public key is {" + eValue + ", " + n + "}.\n" +
                    "Your private key is {" + d + ", " + n + "}.\n" +
                    "Don't forget it!");
            ta.setFont(new Font("System Regular", Font.PLAIN, 14));
            ta.setWrapStyleWord(true);
            ta.setLineWrap(true);
            ta.setCaretPosition(0);
            ta.setEditable(false);
            JOptionPane.showMessageDialog(Window.this, new JScrollPane(ta),
                    "For your information",
                    JOptionPane.INFORMATION_MESSAGE);
            output = RSA.RSAAlgorithm(source, new BigInteger[]{eValue, n}, false);
            signature = RSA.sign(source, new BigInteger[]{d, n});
            setText(signature, signatureText);
        } else {
            key[0] = new BigInteger(p.getValue().toString());
            key[1] = new BigInteger(q.getValue().toString());
            output = RSA.RSAAlgorithm(source, key, true);
            boolean signed = RSA.verify(output, signature, new BigInteger[]{new BigInteger(e.getValue().toString()), key[1]});
            if (signed) {
                JOptionPane.showMessageDialog(Window.this, "Message was signed correctly!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(Window.this, "Message wasn't signed correctly",
                        "Attention",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        setText(output, outputText);
    }

    private String hexToText(String text) throws NumberFormatException{
        StringBuilder textOut = new StringBuilder();
        if (text.length() % 4 != 0) {
            JOptionPane.showMessageDialog(Window.this, "Length not multiple by 4!\n" +
                            "Try once again...",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            isHex.setSelected(true);
            return null;
        }
        for (int i = 0; i < text.length(); i += 4) {
            int item;
            item = Integer.parseInt(text.substring(i, i + 4), 16);
            textOut.append((char) item);
        }
        return textOut.toString();
    }

    private void setText(String output, JTextArea outputText) {
        if (isHex.isSelected()) {
            StringBuilder outputOut = new StringBuilder();
            for (int i = 0; i < output.length(); i++) {
                outputOut.append(String.format("%04x", (int) output.charAt(i)).toUpperCase());
            }
            outputText.setText(outputOut.toString());
        } else {
            outputText.setText(output);
        }
    }
}

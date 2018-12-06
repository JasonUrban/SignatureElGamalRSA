import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
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
    private JRadioButton RSAMode;
    private JRadioButton ElGamalMode;
    private JRadioButton encrypt;
    private JRadioButton decrypt;

    Window(String name) {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel(null);
        panel.setLayout(null);
        sourceText = new JTextArea();
        outputText = new JTextArea();
        signatureText = new JTextArea();
        JScrollPane sourceTextScrollPane = new JScrollPane(sourceText);
        JScrollPane outputTextScrollPane = new JScrollPane(outputText);
        JScrollPane signatureTextScrollPane = new JScrollPane(signatureText);
        keyByDefault = new JCheckBox("Key by default");
        isHex = new JCheckBox("Hex");
        p = new JSpinner();
        q = new JSpinner();
        e = new JSpinner();
        p.setValue(1009L);
        q.setValue(1009L);
        e.setValue(1009L);
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        RSAMode = new JRadioButton("RSA");
        ElGamalMode = new JRadioButton("ElGamal");
        JButton clearButton = new JButton("Clear fields");
        JLabel sourceLabel = new JLabel("Text for encryption:");
        JLabel outLabel = new JLabel("Your encrypted data:");
        JLabel pLabel = new JLabel("Large prime number p:");
        JLabel qLabel = new JLabel("Large prime number q:");
        JLabel eLabel = new JLabel("Parameter e coprime to the \uD835\uDED7(p⋅q), (1 < e < \uD835\uDED7(p⋅q)):");
        JLabel signatureLabel = new JLabel("Signature:");
        encrypt = new JRadioButton("Encrypt");
        decrypt = new JRadioButton("Decrypt");
        JLabel image = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\key.png"));
        RSAMode.setSize(150, 50);
        ElGamalMode.setSize(150, 50);
        RSAMode.setLocation(50, 25);
        ElGamalMode.setLocation(50, 75);
        image.setSize(175, 200);
        image.setLocation(100, 150);
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
        eLabel.setSize(275, 25);
        eLabel.setLocation(50, 275);
        signatureLabel.setSize(250, 25);
        signatureLabel.setLocation(492, 365);
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
        ElGamalMode.setOpaque(false);
        RSAMode.setOpaque(false);
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
        sourceLabel.setForeground(Color.white);
        RSAMode.setForeground(Color.white);
        ElGamalMode.setForeground(Color.white);
        isHex.setForeground(Color.white);
        keyByDefault.setForeground(Color.white);
        encrypt.setForeground(Color.white);
        decrypt.setForeground(Color.white);
        pLabel.setForeground(Color.white);
        qLabel.setForeground(Color.white);
        eLabel.setForeground(Color.white);
        signatureLabel.setForeground(Color.white);
        sourceText.setFont(new Font("System Regular", Font.PLAIN, 16));
        outputText.setFont(new Font("System Regular", Font.PLAIN, 16));
        signatureText.setFont(new Font("System Regular", Font.PLAIN, 16));
        signatureText.setEditable(false);
        p.setFont(new Font("System Regular", Font.PLAIN, 16));
        q.setFont(new Font("System Regular", Font.PLAIN, 16));
        e.setFont(new Font("System Regular", Font.PLAIN, 16));
        panel.add(sourceLabel);
        panel.add(outLabel);
        panel.add(pLabel);
        panel.add(qLabel);
        panel.add(eLabel);
        panel.add(signatureLabel);
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
        typeGroup.add(RSAMode);
        typeGroup.add(ElGamalMode);
        panel.add(RSAMode);
        panel.add(ElGamalMode);
        RSAMode.setSelected(true);
        setContentPane(panel);
        setSize(1250, 500);
        p.addChangeListener(e1 -> {
            if (ElGamalMode.isSelected()) {
                e.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) ((Long) p.getValue() - 1), (Long) 1L));
            }
        });
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
                if (RSAMode.isSelected()) {
                    String signature = signatureText.getText();
                    StringBuilder signatureOut = new StringBuilder();
                    for (int i = 0; i < signature.length(); i++) {
                        signatureOut.append(String.format("%04x", (int) signature.charAt(i)).toUpperCase());
                    }
                    signatureText.setText(signatureOut.toString());
                } else {
                    String trimmed = signatureText.getText().replaceAll("\\s+", "");
                    String[] vals = trimmed.split(",");
                    if (vals.length != 2) {
                        JOptionPane.showMessageDialog(Window.this, "Signature must consist of 2 values separated by a comma!\n",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(false);
                        return;
                    }
                    if (!trimmed.matches("[0-9,]+")) {
                        JOptionPane.showMessageDialog(Window.this, "Incorrect input!\n" +
                                        "To convert signature to hex it must contain 2 decimals",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(false);
                        return;
                    }
                    BigInteger r = new BigInteger(vals[0], 10), s = new BigInteger(vals[1], 10);
                    signatureText.setText(Integer.toHexString(r.intValue()).toUpperCase() + ", " + Integer.toHexString(s.intValue()).toUpperCase());
                }
            } else {
                String source = sourceText.getText();
                String output = outputText.getText();
                String signature = signatureText.getText();
                StringBuilder sourceOut = new StringBuilder();
                if (source.length() % 4 != 0 || output.length() % 4 != 0 || (RSAMode.isSelected() && signature.length() % 4 != 0)) {
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
                if (RSAMode.isSelected()) {
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
                } else {
                    String trimmed = signatureText.getText().replaceAll("\\s+", "").toUpperCase();
                    String[] vals = trimmed.split(",");
                    if (vals.length != 2) {
                        JOptionPane.showMessageDialog(Window.this, "Signature must consist of 2 values separated by a comma!\n",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(true);
                        return;
                    }
                    if (!trimmed.matches("[0-9A-F,]+")) {
                        JOptionPane.showMessageDialog(Window.this, "Incorrect input!\n" +
                                        "To convert signature to decimal it must contain 2 hexadecimals",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        isHex.setSelected(true);
                        return;
                    }
                    BigInteger r = new BigInteger(vals[0], 16), s = new BigInteger(vals[1], 16);
                    signatureText.setText(r.intValue() + ", " + s.intValue());
                }
            }
        });
        encrypt.addActionListener(e1 -> {
            encryptButton.setVisible(true);
            decryptButton.setVisible(false);
            if (!sourceText.getText().equals("") && !outputText.getText().equals("") && RSAMode.isSelected()) {
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
            keyByDefault.setSelected(true);
            if (RSAMode.isSelected()) {
                pLabel.setText("Large prime number p:");
                qLabel.setText("Large prime number q:");
                eLabel.setText("Parameter e coprime to the \uD835\uDED7(p⋅q), (1 < e < \uD835\uDED7(p⋅q)):");
                sourceLabel.setText("Text for encryption:");
                outLabel.setText("Your encrypted data:");
            } else {
                pLabel.setText("Large prime number p:");
                qLabel.setText("Parameter g - prime root modulo p:");
                eLabel.setText("Parameter x (1 < x < p - 1):");
                sourceTextScrollPane.setSize(400, 300);
                sourceLabel.setText("Text to sign:");
                outLabel.setText("SHA-256 hash of your text:");
                signatureLabel.setText("Signature:");
                outLabel.setVisible(true);
                outputTextScrollPane.setVisible(true);
            }
            signatureText.setEditable(false);
        });
        decrypt.addActionListener(e1 -> {
            encryptButton.setVisible(false);
            decryptButton.setVisible(true);
            if (!sourceText.getText().equals("") && !outputText.getText().equals("") && RSAMode.isSelected()) {
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
            if (RSAMode.isSelected()) {
                pLabel.setText("Parameter d:");
                qLabel.setText("Parameter n:");
                eLabel.setText("Parameter e:");
                sourceLabel.setText("Text for decryption:");
                outLabel.setText("Your decrypted data:");
            } else {
                pLabel.setText("Parameter p:");
                qLabel.setText("Parameter g:");
                eLabel.setText("Parameter y:");
                outputText.setText("");
                sourceTextScrollPane.setSize(850, 300);
                outLabel.setVisible(false);
                sourceLabel.setText("Text to verify signature:");
                outputTextScrollPane.setVisible(false);
                signatureLabel.setText("Parms of the signature separated by a comma");
            }
            signatureText.setEditable(true);
        });
        RSAMode.addActionListener(e1 -> {
            sourceText.setText("");
            outputText.setText("");
            signatureText.setText("");
            isHex.setSelected(false);
            encrypt.setText("Encrypt");
            decrypt.setText("Decrypt");
            if (encrypt.isSelected()) {
                eLabel.setText("Parameter e coprime to the \uD835\uDED7(p⋅q), (1 < e < \uD835\uDED7(p⋅q)):");
                qLabel.setText("Large prime number q:");
                sourceLabel.setText("Text for encryption:");
                outLabel.setText("Your encrypted data:");
            } else {
                pLabel.setText("Parameter d:");
                qLabel.setText("Parameter n:");
                eLabel.setText("Parameter e:");
                sourceTextScrollPane.setSize(400, 300);
                sourceLabel.setText("Text for decryption:");
                outLabel.setText("Your decrypted data:");
                signatureLabel.setText("Signature:");
                outLabel.setVisible(true);
                outputTextScrollPane.setVisible(true);
            }
        });
        ElGamalMode.addActionListener(e1 -> {
            sourceText.setText("");
            outputText.setText("");
            signatureText.setText("");
            isHex.setSelected(false);
            encrypt.setText("Sign");
            decrypt.setText("Verify");
            p.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
            q.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
            e.setModel(new SpinnerNumberModel((Long) 1009L, (Long) 1000L, (Long) Long.MAX_VALUE, (Long) 1L));
            if (encrypt.isSelected()) {
                qLabel.setText("Parameter g - prime root modulo p:");
                eLabel.setText("Parameter x (1 < x < p - 1):");
                sourceLabel.setText("Text to sign:");
                outLabel.setText("SHA-256 hash of your text:");
            } else {
                pLabel.setText("Parameter p:");
                qLabel.setText("Parameter g:");
                eLabel.setText("Parameter y:");
                signatureLabel.setText("Parameters r and s of the signature separated by a comma");
                sourceTextScrollPane.setSize(850, 300);
                sourceLabel.setText("Text to verify signature:");
                outLabel.setVisible(false);
                outputTextScrollPane.setVisible(false);
            }
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
        MyPanel(LayoutManager layout) {
            super(layout);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            int w = getWidth();
            int h = getHeight();
            Color shadeColor = new Color(0, 114, 0),
                    primaryLeft = new Color(0, 0, 250),
                    primaryRight = new Color(255, 255, 255);
            int rC = shadeColor.getRed();
            int gC = shadeColor.getGreen();
            int bC = shadeColor.getBlue();
            GradientPaint primary = new GradientPaint(
                    0f, 0f, primaryLeft, w, 0f, primaryRight);
            GradientPaint shade = new GradientPaint(
                    0f, 0f, new Color(rC, gC, bC, 0),
                    0f, h, shadeColor);
            g2d.setPaint(primary);
            g2d.fillRect(0, 0, w, h);
            g2d.setPaint(shade);
            g2d.fillRect(0, 0, w, h);
        }
    }

    private void translate(boolean isDecrypt) {
        if (sourceText.getText().equals("") && RSAMode.isSelected()) {
            JOptionPane.showMessageDialog(Window.this, "Input text area is empty!\n" +
                            "Input some data...",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        BigInteger[] key = new BigInteger[2];
        String source = sourceText.getText(), output, signature = signatureText.getText();
        if (isHex.isSelected()) {
            if (source.length() % 4 != 0 || signature.length() % 4 != 0) {
                JOptionPane.showMessageDialog(Window.this, "Length not multiple by 4!\n" +
                                "Try once again...",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
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
        assert source != null;
        assert signature != null;
        if ((source.length() % 4 != 0 || signature.length() % 4 != 0) && RSAMode.isSelected() && decrypt.isSelected()) {
            JOptionPane.showMessageDialog(Window.this, "Length of the UTF-8 text not multiple by 4!\n" +
                            "Every 4 symbols result in 1 symbol decoded!\n" +
                            "Try once again...",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isDecrypt) {
            if (RSAMode.isSelected()) {
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
                        JOptionPane.showMessageDialog(Window.this, "E is not coprime to φ!\n" +
                                        "Try once again...",
                                "Error!",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                showTextAreaDialog("Your public key is {" + eValue + ", " + n + "}.\n" +
                        "Your private key is {" + d + ", " + n + "}.\n" +
                        "Don't forget it!");
                output = RSA.RSAAlgorithm(source, new BigInteger[]{eValue, n}, false);
                setText(output, outputText);
                signature = RSA.sign(source, new BigInteger[]{d, n});
                setText(signature, signatureText);
            } else {
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                output = ElGamal.byteArrayToHexString(Objects.requireNonNull(md).digest(source.getBytes()));
                setText(output, outputText);
                BigInteger[] publicKey = ElGamal.getParameters(keyByDefault.isSelected());
                BigInteger[] ElGamalSignature = ElGamal.sign(publicKey, keyByDefault.isSelected(), output);
                signatureText.setText(ElGamalSignature[2].intValue() + ", " + ElGamalSignature[3].intValue());
                BigInteger p = publicKey[0], g = publicKey[1], y = ElGamalSignature[0];
                showTextAreaDialog("Your public key is {" + p.intValue() + ", " + g.intValue() + ", " + y.intValue() + "}.\n" +
                        "Don't forget it!");
            }
        } else {
            if (RSAMode.isSelected()) {
                key[0] = new BigInteger(p.getValue().toString());
                key[1] = new BigInteger(q.getValue().toString());
                output = RSA.RSAAlgorithm(source, key, true);
                setText(output, outputText);
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
            } else {
                Object[] vals = signature.replaceAll("\\s+", "").split(",");
                BigInteger p = new BigInteger(this.p.getValue().toString()), g = new BigInteger(this.q.getValue().toString()), y = new BigInteger(this.e.getValue().toString());
                BigInteger r = new BigInteger((String) vals[0]), s = new BigInteger((String) vals[1]);
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                boolean signed = ElGamal.verify(new BigInteger[]{p, g, y}, new BigInteger[]{r, s}, ElGamal.byteArrayToHexString(Objects.requireNonNull(md).digest(source.getBytes())));
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
        }
    }

    private void showTextAreaDialog(String message) {
        JTextArea ta = new JTextArea(3, 30);
        ta.setText(message);
        ta.setFont(new Font("System Regular", Font.PLAIN, 14));
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setCaretPosition(0);
        ta.setEditable(false);
        JOptionPane.showMessageDialog(Window.this, new JScrollPane(ta),
                "For your information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String hexToText(String text) throws NumberFormatException {
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

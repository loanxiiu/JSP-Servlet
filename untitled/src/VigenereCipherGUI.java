import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VigenereCipherGUI extends JFrame {

    public static String vigenereEncrypt(String plainText, String key) {
        String cipherText = "";
        for (int i = 0, j = 0; i < plainText.length(); i++) {
            if (isAlpha(plainText.charAt(i))) {
                char base = isUpper(plainText.charAt(i)) ? 'A' : 'a';
                int p = plainText.charAt(i) - base;
                int k = toUpper(key.charAt(j % key.length())) - 'A';
                int c = mod((p + k), 26);
                cipherText += (char) (c + base);
                j++;
            } else {
                cipherText += plainText.charAt(i);
            }
        }
        return cipherText;
    }

    public static String vigenereDecrypt(String cipherText, String key) {
        String plainText = "";
        for (int i = 0, j = 0; i < cipherText.length(); i++) {
            if (isAlpha(cipherText.charAt(i))) {
                char base = isUpper(cipherText.charAt(i)) ? 'A' : 'a';
                int c = cipherText.charAt(i) - base;
                int k = toUpper(key.charAt(j % key.length())) - 'A';
                int p = mod((c - k), 26);
                plainText += (char) (p + base);
                j++;
            } else {
                plainText += cipherText.charAt(i);
            }
        }
        return plainText;
    }



    public static boolean isUpper(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 'a' + 'A');
        }
        return ch;
    }

    public static boolean isAlpha(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    public static int mod(int a, int b) {
        return (a % b + b) % b;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(VigenereCipherGUI.class.getName()).log(Level.SEVERE,
            null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VigenereCipherGUI().setVisible(true);
            }
        });
    }







    private JTextArea inputArea, outputArea;
    private JTextField keyField;
    private JButton encryptButton, decryptButton, saveButton, uploadButton, downloadButton;

    public VigenereCipherGUI() {
        setTitle("Vigenère Cipher");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setPreferredSize(new Dimension(400, 150));

        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Nhập văn bản:"), gbc);
        gbc.gridy = 1;
        add(inputScrollPane, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        add(new JLabel("Nhập khóa:"), gbc);
        keyField = new JTextField(20);
        gbc.gridx = 1;
        add(keyField, gbc);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setPreferredSize(new Dimension(400, 150));

        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        add(new JLabel("Văn bản sau khi xử lý:"), gbc);
        gbc.gridy = 4;
        add(outputScrollPane, gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        encryptButton = new JButton("Mã hóa");
        decryptButton = new JButton("Giải mã");
        saveButton = new JButton("Lưu kết quả");
        uploadButton = new JButton("Tải file lên");
        downloadButton = new JButton("Lưu file xuống");

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(uploadButton);
        buttonPanel.add(downloadButton);

        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.weighty = 0.1;
        add(buttonPanel, gbc);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plainText = inputArea.getText();
                String key = keyField.getText();
                if (plainText.isEmpty() || key.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập cả văn bản và khóa!");
                } else {
                    String cipherText = vigenereEncrypt(plainText, key);
                    outputArea.setText(cipherText);
                }
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cipherText = inputArea.getText();
                String key = keyField.getText();
                if (cipherText.isEmpty() || key.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập cả văn bản và khóa!");
                } else {
                    String decryptedText = vigenereDecrypt(cipherText, key);
                    outputArea.setText(decryptedText);
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = outputArea.getText();
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không có nội dung để lưu!");
                } else {
                    saveToFile("result.txt", result);
                }
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = uploadFromFile();
                if (content != null) {
                    inputArea.setText(content);
                }
            }
        });

        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = outputArea.getText();
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không có nội dung để lưu!");
                } else {
                    JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        saveToFile(fileChooser.getSelectedFile().getPath(), result);
                    }
                }
            }
        });
    }

    public static String uploadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                return new String(Files.readAllBytes(Paths.get(fileChooser.getSelectedFile().getPath())));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đọc file: " + e.getMessage());
            }
        }
        return null;
    }

    public static void saveToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            JOptionPane.showMessageDialog(null, "Kết quả đã được lưu vào file: " + filename);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file: " + e.getMessage());
        }
    }


}

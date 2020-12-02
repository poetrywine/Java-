package sudokuGUIvision;

import javax.swing.*;


public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    private static void createGUI() {
        // 创建窗体
        MyFrame frame = new MyFrame("SuDoKu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600,600);

        frame.setVisible(true);

    }
}

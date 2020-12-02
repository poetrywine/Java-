package sudokuGUIvision;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sudokuGUIvision.DataClass.suDoKu;

public class MyFrame extends JFrame {
    GetJTextField jTextField = new GetJTextField();


    JButton button = new JButton("确定");

    public MyFrame(String title){
        super(title);

        //创建窗体
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(10,9));

        // 添加元素
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                contentPane.add(jTextField.jTextField[i][j]);
            }
        }
        contentPane.add(button);

        // 添加按钮点击处理
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent();
                new SuDoKu().backTrace(0,0);
                String s = jTextField.jTextField[0][0].getText();
            }
        });
    }

    // 按钮点击后要处理的事件
    private void buttonEvent(){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (jTextField.jTextField[i][j].getText().length()==0){
                    suDoKu[i][j] = 0;
                }else {
                    suDoKu[i][j] = Integer.parseInt(jTextField.jTextField[i][j].getText());
                }
            }
        }
    }

    class GetJTextField{
        JTextField[][] jTextField = new JTextField[9][9];
        public GetJTextField(){
            for (int i=0;i<9;i++){
                for (int j=0;j<9;j++){
                    jTextField[i][j] = new JTextField(4);
                }
            }
        }
    }
}

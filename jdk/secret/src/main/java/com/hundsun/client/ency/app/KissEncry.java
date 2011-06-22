package com.hundsun.client.ency.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.net.*;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;

public class KissEncry extends JFrame {

    private static final long serialVersionUID = 1L;
    //从资源文件中读出应用程序图片的定义
    public static ImageIcon appIcon;
    private JPanel jContentPane = null;
    private JLabel jLabelTitle = null;
    private JLabel jLabelInput = null;
    private JLabel jLabelOutput = null;
    private JScrollPane jsp = null;
    private JTextField ency = null;
    private JTextArea responseText = null;
    private JTextField des = null;
    private JButton Get = null;
    private JButton copy = null;
    private JButton End = null;
    private JButton dec = null;
    private Action exit;
    private KissEncry.KeyFilter filter = new KissEncry.KeyFilter("key");


    static {

        try {
            // 应用程序左上角显示图标
            String icon = "com/hundsun/client/ency/icon/hsicon.jpg";
            URL url = KissEncry.class.getClassLoader().getResource(icon);
            if (url != null) {
                appIcon = new ImageIcon(url);
            }

            ////设置界面的显示的形状
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exc) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception exc2) {
            }
        }
    }

    public KissEncry() {
        super();
        initialize();

    }

    private void initialize() {
        this.setSize(428, 374);
        this.setBackground(Color.lightGray);
        this.getContentPane().setLayout(new BorderLayout());
        //设置窗口左上角上显示的图标
        if (appIcon != null) {
            this.setIconImage(appIcon.getImage());
        //设置应用程序的窗口
        }

        //WindowConstants接口描述一个用户请求关闭一个窗口时，可能采取的动作
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(createAppCloser());
        this.setContentPane(getJContentPane());
        this.setTitle("KissEncry");

    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabelInput = new JLabel();
            jLabelInput.setBounds(new Rectangle(40, 70, 107, 30));
            jLabelInput.setText("明文或密文");
            jLabelTitle = new JLabel(
                    "<html><font size=6 color =blue>管理平台-密钥生成器</font></html>",
                    SwingConstants.CENTER);
            jLabelTitle.setBounds(new Rectangle(50, 10, 350, 60));
            //jLabel.setText("tamcx2.0密钥生成器");
            // jLabel.setSize(20,30);
            jLabelOutput = new JLabel();
            jLabelOutput.setBounds(new Rectangle(40, 170, 350, 30));
            jLabelOutput.setText("加密或解密结果");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabelTitle, null);
            jContentPane.add(getency(), null);
            jContentPane.add(jLabelInput, null);
            jContentPane.add(jLabelOutput, null);
            jContentPane.add(getEnd(), null);
            jContentPane.add(getCopy(), null);
            jContentPane.add(getGet(), null);
            jContentPane.add(getDec(), null);

            jContentPane.add(getJScrollPane(), null);
        }
        return jContentPane;
    }

    private JScrollPane getJScrollPane() {
        if (jsp == null) {
            jsp = new JScrollPane();
            jsp.setBounds(new Rectangle(40, 200, 250, 110));
            jsp.setViewportView(getReply());
        }
        return jsp;
    }

    private JTextArea getReply() {
        if (responseText == null) {
            responseText = new JTextArea();
            responseText.setLineWrap(true);
            responseText.setEditable(false);
        }
        return responseText;
    }

    private JButton getEnd() {
        if (End == null) {
            End = new JButton();
            End.setBounds(new Rectangle(300, 290, 80, 20));
            End.setText("退出");
            End.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.exit(1);
                }
            });
        }
        return End;
    }

    private JButton getGet() {
        if (Get == null) {
            Get = new JButton();
            Get.setBounds(new Rectangle(300, 200, 80, 20));
            Get.setText("加密");
            Get.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    createEncy();
                }
            });
        }
        return Get;
    }

    private JButton getCopy() {
        if (copy == null) {
            copy = new JButton();
            copy.setBounds(new Rectangle(300, 230, 80, 20));
            copy.setText("复制");
            copy.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    copy();
                }
            });
        }
        return copy;
    }

    private JButton getDec() {
        if (dec == null) {
            dec = new JButton();
            dec.setBounds(new Rectangle(300, 260, 80, 20));
            dec.setText("解密");
            dec.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    dec();
                }
            });
        }
        return dec;
    }

    private JTextField getency() {
        if (ency == null) {
            ency = new JTextField();
            ency.setBounds(new Rectangle(40, 100, 250, 28));

            ency.setText("");

        }
        return ency;
    }

    private void createEncy() {
        if ((ency.getText() == null) || (ency.getText().equals(""))) {

            JOptionPane.showConfirmDialog(this, "没有填写加密密文", "警告!",
                    JOptionPane.CLOSED_OPTION);
            //  ency.setFocusable(true);
            return;
        }
        // HsDes des = new EncryDes();
        String e = ency.getText().trim();

        jLabelOutput.setText("<html><font color=green>加密结果</font></html>");
        responseText.setText(HsDes.enc(e));
    }

    private void copy() { //复制到剪切板

        String e = responseText.getText().trim();
        if ((e == null) || (e.equals(""))) {
            JOptionPane.showMessageDialog(this, "结果没有生成，请先加密或解密", "警告!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        responseText.selectAll();
        responseText.copy();
        jLabelOutput.setText("<html><font size=3 color=green align=center>密文已经复制到剪贴板</font></html>");
    }

    private void dec() { //解密

      if ((ency.getText() == null) || (ency.getText().equals(""))) {

            JOptionPane.showConfirmDialog(this, "请输入加密过的密文", "警告!",
                    JOptionPane.CLOSED_OPTION);
            return;
        }
      String e = ency.getText().trim();
      try{
        responseText.setText(HsDes.dec(e));
        jLabelOutput.setText("<html><font color=blue>解密结果</font></html>");
      }catch(IllegalStateException ise){
          responseText.setText("");
          JOptionPane.showMessageDialog(this, "待解密密文不合法", "密文错误", JOptionPane.ERROR_MESSAGE);
          throw (RuntimeException)ise;
      }catch(Exception ex){
          responseText.setText("");
          JOptionPane.showMessageDialog(this, "待解密密文不合法", "密文错误", JOptionPane.ERROR_MESSAGE);
          throw (RuntimeException)ex;
      }
    }

    protected WindowAdapter createAppCloser() {
        return new KissEncry.AppCloser();
    }

    /**
     * 界面右上角窗口关闭功能的实现
     */
    private final class AppCloser extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            System.exit(1);
        }
    }

    private static final class KeyFilter extends javax.swing.filechooser.FileFilter {

        private String myExtension = null; //工作流后缀名

        KeyFilter(String extension) {
            this.myExtension = extension;
        }

        public String getExtension() {
            return myExtension;
        }

        public boolean accept(File f) {
            if (f != null) {
                if (f.isDirectory()) {
                    return true;
                }
                if (myExtension != null) {
                    String extension = null;
                    String fName = f.getName();
                    int i = fName.lastIndexOf('.');
                    if (i > 0 && i < fName.length() - 1) {
                        extension = fName.substring(i + 1).toLowerCase();
                    }

                    if (extension != null &&
                            extension.equalsIgnoreCase(myExtension)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }

        public String getDescription() {
            if (myExtension != null) {
                return "key";
            } else {
                return "key";
            }
        }
    }

    public static void main(String[] args) {

        KissEncry ss = new KissEncry();
        ss.setVisible(true);
        ss.setResizable(false);
    }
}

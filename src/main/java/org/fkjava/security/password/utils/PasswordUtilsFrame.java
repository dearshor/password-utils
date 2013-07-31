package org.fkjava.security.password.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lwq
 */
public class PasswordUtilsFrame extends javax.swing.JFrame {

    /**
     * Creates new form PasswordUtilsFrame
     */
    public PasswordUtilsFrame() {
        initComponents();

        this.birthdayChooseButton.addMouseListener(new MouseAdapter() {
            /**
             * 单击按钮
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                new DateChooser(birthdayField);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        domainNameField = new javax.swing.JTextField();
        securityQuestionComboBox = new javax.swing.JComboBox();
        securityAnswerField = new javax.swing.JTextField();
        birthdayPanel = new javax.swing.JPanel();
        birthdayChooseButton = new javax.swing.JButton();
        birthdayField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        passwordResultTextArea = new javax.swing.JTextArea();
        calculatePasswordButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        passwordLengthField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("简单密码生成计算工具--Alpha");
        setBounds(new java.awt.Rectangle(0, 0, 650, 350));
        setMaximumSize(new java.awt.Dimension(678, 350));
        setMinimumSize(new java.awt.Dimension(678, 350));
        setPreferredSize(new java.awt.Dimension(678, 350));
        setResizable(false);

        jToolBar1.setRollover(true);

        jLabel1.setText("alpha");
        jToolBar1.add(jLabel1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.SOUTH);

        jLabel2.setText("网站域名");

        jLabel3.setText("安全问题");

        jLabel4.setText("安全答案");

        jLabel5.setText("出生日期");

        securityQuestionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"您的小学名称是什么？", "您的出生地是什么？", "您母亲的名字是什么？"}));

        birthdayPanel.setAlignmentX(0.0F);
        birthdayPanel.setAlignmentY(0.0F);
        birthdayPanel.setPreferredSize(new java.awt.Dimension(0, 21));
        birthdayPanel.setLayout(new java.awt.BorderLayout());

        birthdayChooseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        birthdayChooseButton.setLabel("选择日期");
        birthdayPanel.add(birthdayChooseButton, java.awt.BorderLayout.EAST);

        birthdayField.setEditable(false);
        birthdayField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        birthdayPanel.add(birthdayField, java.awt.BorderLayout.CENTER);

        jLabel6.setText("访问需要注册用户的网站的域名");

        jLabel7.setText("安全问题，计算密码的一部分");

        jLabel8.setText("安全答案，计算密码的一部分");

        jLabel9.setText("您的出生日期，计算密码的一部分");

        jPanel3.setLayout(new java.awt.BorderLayout());

        passwordResultTextArea.setEditable(false);
        passwordResultTextArea.setColumns(20);
        passwordResultTextArea.setRows(5);
        jScrollPane1.setViewportView(passwordResultTextArea);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        calculatePasswordButton.setText("计算密码");
        calculatePasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculatePasswordButtonMouseClicked(evt);
            }
        });
        jPanel3.add(calculatePasswordButton, java.awt.BorderLayout.EAST);

        jLabel10.setText("密码位数");

        passwordLengthField.setText("8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(birthdayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4)
                .addComponent(jLabel2)
                .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(domainNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(securityQuestionComboBox, 0, 317, Short.MAX_VALUE)
                .addComponent(securityAnswerField)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8)
                .addComponent(jLabel9)
                .addComponent(jLabel6)
                .addComponent(jLabel7)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(passwordLengthField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(domainNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(securityQuestionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7))
                .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(securityAnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(birthdayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(passwordLengthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("帮助");

        aboutMenuItem.setText("关于");
        aboutMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutMenuItemMouseClicked(evt);
            }
        });
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(aboutMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
    }

    /**
     * 根据输入条件计算密码
     *
     * @param evt
     */
    private void calculatePasswordButtonMouseClicked(java.awt.event.MouseEvent evt) {
        //
        String domainName = this.domainNameField.getText();
        String securityQuestion = this.securityQuestionComboBox.getSelectedItem().toString();
        String securityAnswer = this.securityAnswerField.getText();
        String birthday = this.birthdayField.getText();
        String passwordLength = this.passwordLengthField.getText();
        StringBuilder error = new StringBuilder();
        if (domainName == null || domainName.equals("") || domainName.trim().equals("")) {
            //未填写域名
            error.append("网站的域名必须填写，为了保证每个网站计算出来的密码都不一样，所以计算密码的时候需要提供域名。\n");
        }

        if (securityQuestion == null || securityQuestion.equals("") || securityQuestion.trim().equals("")) {
            //未选择安全问题
            error.append("必须要选一个安全问题，以便加深密码记忆，方便找回密码\n");
        }

        if (securityAnswer == null || securityAnswer.equals("") || securityAnswer.trim().equals("")) {
            //未填写安全答案
            error.append("安全答案必须填写，用于计算密码\n");
        }

        if (birthday == null || birthday.equals("") || birthday.trim().equals("")) {
            //未填写生日
            error.append("出生日期必须填写\n");
        }

        int length = 0;
        if (passwordLength == null || passwordLength.equals("") || passwordLength.trim().equals("")) {
            //密码长度
            error.append("必须设置密码的长度，该设置是为了生成符合长度的密码\n");
        } else {
            try {
                length = Integer.parseInt(passwordLength);
            } catch (NumberFormatException ex) {
                error.append("密码长度必须是有效的数字\n");
            }
        }
        if (error.length() > 0) {
            //输出错误信息
            if (promptDialog == null) {
                promptDialog = new PromptDialog(this);
            }
            promptDialog.setMessageContent(error.toString());
            promptDialog.setVisible(true);
        } else {
            PasswordGeneratRequest req = new PasswordGeneratRequest();
            req.setBirthday(birthday);
            req.setDomainName(domainName);
            req.setPasswordLength(passwordLength);
            req.setSecurityAnswer(securityAnswer);
            req.setSecurityQuestion(securityQuestion);
            String str = PasswordGenerator.generate(req);

            this.passwordResultTextArea.setText(str);
        }
    }

    private void aboutMenuItemMouseClicked(java.awt.event.MouseEvent evt) {
        AboutDialog dialog = new AboutDialog(this);
        dialog.setVisible(true);
    }

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        AboutDialog dialog = new AboutDialog(this);
        dialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordUtilsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordUtilsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordUtilsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordUtilsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }



        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PasswordUtilsFrame mainFrame = new PasswordUtilsFrame();

                //设置窗口的位置
                Toolkit kit = Toolkit.getDefaultToolkit();
                Dimension screenSize = kit.getScreenSize();
                int width = (int) screenSize.getWidth();
                int height = (int) screenSize.getHeight();
                int w = mainFrame.getWidth();
                int h = mainFrame.getHeight();
                mainFrame.setLocation((width - w) / 2, (height - h) / 2);
                //显示窗口
                mainFrame.setVisible(true);
            }
        });
    }
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton birthdayChooseButton;
    private javax.swing.JTextField birthdayField;
    private javax.swing.JPanel birthdayPanel;
    private javax.swing.JButton calculatePasswordButton;
    private javax.swing.JTextField domainNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField passwordLengthField;
    private javax.swing.JTextArea passwordResultTextArea;
    private javax.swing.JTextField securityAnswerField;
    private javax.swing.JComboBox securityQuestionComboBox;
    private PromptDialog promptDialog;
}

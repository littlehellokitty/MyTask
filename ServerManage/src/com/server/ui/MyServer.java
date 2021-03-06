package com.server.ui;

import com.server.info.IsAuthorized;
import com.server.info.UserInfo;
import com.server.utils.CheckHeaderCellRenderer;
import com.server.utils.CheckTableModle;
import com.server.utils.MyCellRenderer;
import com.server.utils.SendMail;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Little-Kitty
 */
public class MyServer extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates new form MyServer
     */
    public MyServer() {
        setResizable(false);
        UserInfo UI = new UserInfo();
        columnNames = UI.getcolumn();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize = kit.getScreenSize();
        int width = screensize.width;
        int height = screensize.height;
        int x = (width - 800) / 2;
        int y = (height - 350) / 2;
        setLocation(x - 50, y - 100);
        initComponents();
    }

    class TreeMouseHandle extends MouseAdapter { // 处理mouse点选事件

        boolean F = false;

        @Override
        public void mousePressed(final MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 2) {
                    try {
                        JTree tree = (JTree) e.getSource();
                        int rowLocation = tree.getRowForLocation(
                                e.getX(), e.getY());
                        TreePath treepath = tree
                                .getPathForRow(rowLocation);
                        TreeNode treenode = (TreeNode) treepath
                                .getLastPathComponent();
                        nodeName = treenode.toString();
                        if (!nodeName.equals("Online")) {
                            UserInfo UI = new UserInfo();
                            data = UI.getdata(nodeName);
                            jLabel7.setText(nodeName);
                            jTable1 = new JTable();

                            jTable1.setBackground(new java.awt.Color(0, 204, 51));
                            //DefaultTableCellRenderer thr = new DefaultTableCellRenderer();
                            //thr.setHorizontalAlignment(JLabel.CENTER);
                            jTable1.setDefaultRenderer(Object.class,
                                    new MyCellRenderer());
                            // jTable1.getTableHeader().setDefaultRenderer(thr);
                            CheckTableModle ct = new CheckTableModle(data, columnNames);
                            jTable1.setModel(ct);
                            jTable1.getTableHeader().setDefaultRenderer(
                                    new CheckHeaderCellRenderer(jTable1));
                            jScrollPane2.setViewportView(jTable1);
                            jPanel4.removeAll();
                            jPanel4.add(jScrollPane2);
                            jPanel4.updateUI();
                        }
                    } catch (NullPointerException ne) {
                    }

                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable1 = new JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        root1 = new DefaultMutableTreeNode("Online");
        jTree1 = new javax.swing.JTree(root1);
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        jScrollPane2.getViewport().setBackground(new java.awt.Color(0, 204, 0));
        jScrollPane2.setBorder(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jTree1.setBackground(new java.awt.Color(0, 204, 51));
        jTree1.addMouseListener(new TreeMouseHandle());
        jTree1.setBackground(new java.awt.Color(204, 204, 204));
        jTree1.setAutoscrolls(true);
        jScrollPane1.setViewportView(jTree1);

        jLabel2.setText("快速查询：");

        jTextField1.setBackground(new java.awt.Color(0, 204, 51));
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setText("查看");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("统计信息");

        jButton4.setBackground(new java.awt.Color(0, 204, 51));
        jButton4.setText("查看所有");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
            .addComponent(jTextField1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("服务器运行状态：");

        jLabel3.setText("服务器运行时间：");

        jLabel4.setText("未运行");

        jLabel5.setText("0 时");

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setText("启动");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("服务器信息");

        jLabel11.setText("0 分");

        jLabel12.setText("0 秒");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(jLabel10)))
                        .addGap(0, 407, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(9, 9, 9))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("用户名：");

        jLabel7.setText("user");

        jButton3.setBackground(new java.awt.Color(0, 204, 51));
        jButton3.setText("修改");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setText("用户信息");

        jPanel4.setBackground(new java.awt.Color(0, 204, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(new java.awt.GridLayout());

        jPanel5.setBackground(new java.awt.Color(0, 204, 0));

        jLabel13.setFont(new java.awt.Font("微软雅黑", 2, 18)); // NOI18N
        jLabel13.setText("No User Information to Show");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel9)
                .addContainerGap(426, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(499, 499, 499)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String username = jTextField1.getText();
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入查询用户名!");
        } else {
            data = new Vector();
            UserInfo UI = new UserInfo();
            data = UI.getdata(username);
            jTable1 = new JTable();
             jTable1.setBackground(new java.awt.Color(0, 204, 51));
             jTable1.setForeground(new Color(0, 255, 255));
            jTable1.setDefaultRenderer(Object.class,
                    new MyCellRenderer());
            jLabel7.setText(username);
            CheckTableModle ct = new CheckTableModle(data, columnNames);
            jTable1.setModel(ct);
            jTable1.getTableHeader().setDefaultRenderer(
                    new CheckHeaderCellRenderer(jTable1));           
            jScrollPane2.setViewportView(jTable1);
            jScrollPane2.updateUI();
            jPanel4.removeAll();
            jPanel4.add(jScrollPane2);
            jPanel4.updateUI();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String command = jButton2.getText();

        switch (command) {
            case "启动":
                Server = new serverstart();
                Counter = new counter();
                Server.start();
                Counter.start();
                break;
            //serverstop();
            case "停止":
                jButton2.setText("启动");
                jLabel4.setText("已停止...");
                Server.stop();
                try {
                    ss.close();

                } catch (IOException e) {
                }
                Counter.stop();
                break;
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "尚未开放!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "尚未开通!");
    }//GEN-LAST:event_jButton4ActionPerformed

    class serverstart extends Thread {

        @Override
        public void run() {
            try {
                ss = new ServerSocket(port);

                jLabel4.setText("正在运行");
                jButton2.setText("停止");
                CounterFlag = true;
                while (true) {
                    s = ss.accept();
                    inputStreamReader = new DataInputStream(new BufferedInputStream(s.getInputStream()));
                    message = inputStreamReader.readInt();
                    userid = inputStreamReader.readUTF();
                    switch (message) {
                        case 1:
                            /**
                             * 判断是否到期 flag 值： 0：已到期，需付费使用 1：可继续使用 2：数据库问题
                             */
                            IsAuthorized IA = new IsAuthorized();
                            flag = IA.isauthorized(userid);
                            DataOutputStream ps = new DataOutputStream(s.getOutputStream());
                            ps.writeInt(flag);
                            ps.flush();
                            s.close();
                            DefaultMutableTreeNode phone = new DefaultMutableTreeNode(userid);
                            root1.add(phone);
                            jTree1.updateUI();
                            break;
                        //返回剩余天数
                        case 2:
                            IsAuthorized IA1 = new IsAuthorized();
                            days = IA1.getleftdays(userid);
                            if (days != -1) {
                                DataOutputStream ps1 = new DataOutputStream(s.getOutputStream());
                                ps1.writeInt(days);
                                ps1.flush();
                                s.close();
                            }
                            break;

                        case 3:
                            /**
                             * 购买 用户只需购买一次，后续可通过付费来获得更久使用 需获取用户信息，并返回给用户补丁文件
                             */
                            int days = inputStreamReader.readInt();
                            int money = inputStreamReader.readInt();
                            String phonenumber = inputStreamReader.readUTF();
                            String email = inputStreamReader.readUTF();
                            String serial = inputStreamReader.readUTF();
                            IsAuthorized IA2 = new IsAuthorized();
                            String tips = IA2.buypro(money, days, userid, phonenumber, email, serial);
                            DataOutputStream ps2 = new DataOutputStream(s.getOutputStream());
                            if (tips.equals("Success")) {
                                IA2.sendmail(userid);
                            }
                            ps2.writeUTF(tips);
                            ps2.flush();
                            s.close();
                            break;

                        case 4:
                            //续费
                            int days1 = inputStreamReader.readInt();
                            int money1 = inputStreamReader.readInt();
                            IsAuthorized IA3 = new IsAuthorized();
                            String renewsuc = IA3.renew(money1, days1, userid);
                            DataOutputStream ps3 = new DataOutputStream(s.getOutputStream());
                            ps3.writeUTF(renewsuc);
                            ps3.flush();
                            s.close();
                            break;
                        //获取用户联系方式		
                        case 5:
                            IsAuthorized IA4 = new IsAuthorized();
                            String phone1 = IA4.getuserphone(userid);
                            if (phone1 == null) {
                                phone1 = "none";
                            }
                            DataOutputStream ps4 = new DataOutputStream(s.getOutputStream());
                            ps4.writeUTF(phone1);
                            ps4.flush();
                            s.close();
                            break;
                        case 6:
                            String check = new IsAuthorized().getcheck(userid);
                            DataOutputStream ps5 = new DataOutputStream(s.getOutputStream());
                            ps5.writeUTF(check);
                            ps5.flush();
                            s.close();
                            break;
                        //下线信息
                        case 7:
                            DefaultMutableTreeNode phone2 = new DefaultMutableTreeNode(userid);
                            Enumeration list = root1.children();
                            while (list.hasMoreElements()) {
                                DefaultMutableTreeNode node = (DefaultMutableTreeNode) list.nextElement();
                                if (node.equals(phone2)) {
                                    DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
                                    model.removeNodeFromParent(node);
                                    jTree1.updateUI();
                                    break;
                                }
                            }
                            break;
                    }
                }

            } catch (IOException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Exception！");
            }
        }
    }

    void serverstop() {
        try {
            ss.close();
            CounterFlag = false;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "服务器关闭失败！");
        }
    }

    class counter extends Thread {

        long time = 0;
        long hour = 0;
        long minute = 0;

        @Override
        public void run() {
            while (true) {
                if (time == 60) {
                    minute++;
                    time = 0;
                    if (minute == 60) {
                        hour++;
                        minute = 0;
                    }
                }
                jLabel5.setText(hour + "时");
                jLabel11.setText(minute + "分");
                jLabel12.setText(time + "秒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                time++;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyServer f = new MyServer();
                f.setVisible(true);
            }
        });
    }

    Thread Counter;
    Thread Server;
    private boolean CounterFlag = false;
    private final boolean ServerSocketFlag = false;
    private final boolean SSFlag = true;
    private final int port = 8821;
    private DataInputStream inputStreamReader = null;
    private int message;
    private int flag = 0;
    private int days = 0;
    private String userid;  //用户名
    private String nodeName;
    private Socket s = null;
    private ServerSocket ss;
    private DefaultMutableTreeNode root1;
    private JTable jTable1;
    private Vector data;
    private Vector columnNames;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}


import java.math.BigInteger;
import sun.java2d.loops.FillRect;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberto
 */
public class MainWindow extends javax.swing.JFrame {
    
    private RSADetalles fr_rsaDetalles;
    private boolean rsadetIsVisible;
    
    private RSA rsa;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setLocationRelativeTo(null);
        
        fr_rsaDetalles = new RSADetalles();
        rsadetIsVisible = false;
        
        txta_msjOriginal.setText("");
        txta_msjEncriptado.setText("");
        txta_msjDesencriptado.setText("");
        
        rsa = new RSA();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_msjOriginal = new javax.swing.JTextArea();
        cbox_testsDePrimos = new javax.swing.JComboBox();
        rbtn_testsDePrimos = new javax.swing.JRadioButton();
        rbtn_metodoBI = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_encriptar = new javax.swing.JButton();
        btn_desencriptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_limpCampo01 = new javax.swing.JButton();
        lbl_tiempoDesencriptando = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_msjDesencriptado = new javax.swing.JTextArea();
        btn_limpCampo02 = new javax.swing.JButton();
        lbl_tiempoEncriptando = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txta_msjEncriptado = new javax.swing.JTextArea();
        btn_limpCampo03 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbox_tamPrimo = new javax.swing.JComboBox();
        cbox_algosClavePriv = new javax.swing.JComboBox();
        btn_verDetalles = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmo RSA");
        setResizable(false);

        txta_msjOriginal.setColumns(20);
        txta_msjOriginal.setRows(5);
        jScrollPane1.setViewportView(txta_msjOriginal);

        cbox_testsDePrimos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mi test de primos", "Fermat", "Miller-Rabin", "AKS", "Solovay-Strassen" }));
        cbox_testsDePrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_testsDePrimosActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtn_testsDePrimos);
        rbtn_testsDePrimos.setSelected(true);
        rbtn_testsDePrimos.setText("Tests de Primalidad");
        rbtn_testsDePrimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_testsDePrimosActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtn_metodoBI);
        rbtn_metodoBI.setText("probablePrime( )");
        rbtn_metodoBI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_metodoBIActionPerformed(evt);
            }
        });

        jLabel2.setText("Mensaje original");

        jLabel3.setText("Mensaje encriptado");

        btn_encriptar.setBackground(new java.awt.Color(102, 102, 255));
        btn_encriptar.setText("Encriptar con RSA");
        btn_encriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encriptarActionPerformed(evt);
            }
        });

        btn_desencriptar.setBackground(new java.awt.Color(255, 204, 102));
        btn_desencriptar.setText("Desencriptar");
        btn_desencriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desencriptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tiempo :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tiempo :");

        btn_limpCampo01.setText("Limpiar campo");
        btn_limpCampo01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpCampo01ActionPerformed(evt);
            }
        });

        lbl_tiempoDesencriptando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_tiempoDesencriptando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tiempoDesencriptando.setText("-");

        txta_msjDesencriptado.setColumns(20);
        txta_msjDesencriptado.setRows(5);
        jScrollPane2.setViewportView(txta_msjDesencriptado);

        btn_limpCampo02.setText("Limpiar campo");
        btn_limpCampo02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpCampo02ActionPerformed(evt);
            }
        });

        lbl_tiempoEncriptando.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_tiempoEncriptando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tiempoEncriptando.setText("-");

        jLabel7.setText("Mensaje descencriptado");

        txta_msjEncriptado.setColumns(20);
        txta_msjEncriptado.setRows(5);
        jScrollPane3.setViewportView(txta_msjEncriptado);

        btn_limpCampo03.setText("Limpiar campo");
        btn_limpCampo03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpCampo03ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tamaño de los primos :");

        jLabel9.setText("Algor. para la clave privada :");

        cbox_tamPrimo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1024", "512", "256", "128" }));

        cbox_algosClavePriv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "metodo modInverse( )", "Euclides extendido", "Fermat" }));

        btn_verDetalles.setText("Ver detalles");
        btn_verDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verDetallesActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("( Nros: p, q, totient, e, d )");

        jLabel5.setText("(algor. BigInteger)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpCampo01))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbox_tamPrimo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(23, 23, 23)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rbtn_testsDePrimos, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                            .addComponent(cbox_testsDePrimos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(13, 13, 13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_encriptar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbtn_metodoBI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbox_algosClavePriv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_desencriptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_tiempoDesencriptando, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpCampo03))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_limpCampo02))
                            .addComponent(jScrollPane3))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_verDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_tiempoEncriptando, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpCampo01)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cbox_testsDePrimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtn_metodoBI)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtn_testsDePrimos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbox_tamPrimo)
                                .addComponent(cbox_algosClavePriv))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_encriptar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_verDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btn_limpCampo02)
                    .addComponent(jLabel1)
                    .addComponent(lbl_tiempoEncriptando))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_desencriptar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btn_limpCampo03)
                    .addComponent(jLabel4)
                    .addComponent(lbl_tiempoDesencriptando))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtn_testsDePrimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_testsDePrimosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_testsDePrimosActionPerformed

    private void cbox_testsDePrimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_testsDePrimosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_testsDePrimosActionPerformed

    private void btn_encriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encriptarActionPerformed
        String msj = txta_msjOriginal.getText();
        if (!msj.isEmpty()){
            int tamPrimo = Integer.parseInt((String)cbox_tamPrimo.getSelectedItem());
            rsa = new RSA(tamPrimo);
            if (rbtn_testsDePrimos.isSelected()){
                rsa.generaPrimos(cbox_testsDePrimos.getSelectedIndex());
            }else{
                rsa.generaPrimos();
            }
            rsa.generaClaves(cbox_algosClavePriv.getSelectedIndex());
            
            BigInteger encriptado[] = rsa.encriptar(msj);
            
            //Mostrar mensaje encriptado
            String msjEncrip = "";
            for (int i = 0; i < encriptado.length; i++) {
                msjEncrip+=encriptado[i].toString()+"\n";
            }
            txta_msjEncriptado.setText(msjEncrip);
            
            //Mostrar tiempo
            lbl_tiempoEncriptando.setText(Double.toString(rsa.getT_encriptando()));
            
            //Mostrar detalles
            fr_rsaDetalles.setNrosDetallesRSA(rsa.getP(), rsa.getQ(), rsa.getTotient(), rsa.getE(), rsa.getD());
            fr_rsaDetalles.setTiemposRSA(rsa.getT_genPrimos(), rsa.getT_genClaves());
        }
    }//GEN-LAST:event_btn_encriptarActionPerformed

    private void btn_limpCampo01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpCampo01ActionPerformed
        txta_msjOriginal.setText("");
    }//GEN-LAST:event_btn_limpCampo01ActionPerformed

    private void btn_limpCampo02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpCampo02ActionPerformed
        txta_msjEncriptado.setText("");
    }//GEN-LAST:event_btn_limpCampo02ActionPerformed

    private void btn_limpCampo03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpCampo03ActionPerformed
        txta_msjDesencriptado.setText("");
    }//GEN-LAST:event_btn_limpCampo03ActionPerformed

    private void btn_verDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verDetallesActionPerformed
        if (rsadetIsVisible){
            fr_rsaDetalles.setVisible(false);
            rsadetIsVisible = false;
        }else{
            fr_rsaDetalles.setVisible(true);
            rsadetIsVisible = true;
        }
    }//GEN-LAST:event_btn_verDetallesActionPerformed

    private void rbtn_metodoBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_metodoBIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_metodoBIActionPerformed

    private void btn_desencriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desencriptarActionPerformed
        if (!txta_msjEncriptado.getText().isEmpty()){
            String msjDesenc = rsa.desencriptar(rsa.getEncriptado());
            txta_msjDesencriptado.setText(msjDesenc);
            
            lbl_tiempoDesencriptando.setText(Double.toString(rsa.getT_desencriptando()));
        }
    }//GEN-LAST:event_btn_desencriptarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_desencriptar;
    private javax.swing.JButton btn_encriptar;
    private javax.swing.JButton btn_limpCampo01;
    private javax.swing.JButton btn_limpCampo02;
    private javax.swing.JButton btn_limpCampo03;
    private javax.swing.JButton btn_verDetalles;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbox_algosClavePriv;
    private javax.swing.JComboBox cbox_tamPrimo;
    private javax.swing.JComboBox cbox_testsDePrimos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_tiempoDesencriptando;
    private javax.swing.JLabel lbl_tiempoEncriptando;
    private javax.swing.JRadioButton rbtn_metodoBI;
    private javax.swing.JRadioButton rbtn_testsDePrimos;
    private javax.swing.JTextArea txta_msjDesencriptado;
    private javax.swing.JTextArea txta_msjEncriptado;
    private javax.swing.JTextArea txta_msjOriginal;
    // End of variables declaration//GEN-END:variables
}

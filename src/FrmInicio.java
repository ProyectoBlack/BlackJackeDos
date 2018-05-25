
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author missa
 */
public class FrmInicio extends javax.swing.JFrame {

    Conexion conexion;
    boolean seConecto;
    Carta cartas;
    Carta carta[] = new Carta[52];
    int k = 0;
    Mano[] manoJugador = new Mano[2];
    Baraja baraja = new Baraja();
    int contadorMano = 2;
    int puntos=0;
    public String usuario;
    public String cliente;
    public boolean terminado = false;
            

    /**
     * Creates new form FrmInicio
     */
    public FrmInicio() {
        initComponents();
        btnRobar.setVisible(false);
        btnQuedarse.setVisible(false);

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 12; j++) {
                cartas = new Carta(i, j);
                carta[k] = cartas;
                k++;
            }
            baraja.barajar();
        }
        

    }

    private void setvisibleCartas() {

        for (int i = 0; i < 1; i++) {

            manoJugador[i] = new Mano();

            manoJugador[i].cogerCarta(baraja.robar());
            manoJugador[i].cogerCarta(baraja.robar());

            lblCarta1.setText(manoJugador[i].obtenerCarta(i) + "");
            lblCarta2.setText(manoJugador[i].obtenerCarta(i + 1) + "");
            String s = "/Imagenes/Esapdas_As.jpg";

//            lblCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource
//        ("/Imagenes/"+manoJugador[i].obtenerCarta(i)+".jpg")));
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

        btnRobar = new javax.swing.JButton();
        btnQuedarse = new javax.swing.JButton();
        lblCarta2 = new javax.swing.JLabel();
        lblCarta1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCrear = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuUnirse = new javax.swing.JMenuItem();
        mnusalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRobar.setText("Robar");
        btnRobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRobarActionPerformed(evt);
            }
        });

        btnQuedarse.setText("Quedarse");
        btnQuedarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuedarseActionPerformed(evt);
            }
        });

        mnuCrear.setText("Conexion");

        jMenuItem1.setText("Crear Partida");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuCrear.add(jMenuItem1);

        mnuUnirse.setText("Unirse");
        mnuUnirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUnirseActionPerformed(evt);
            }
        });
        mnuCrear.add(mnuUnirse);

        mnusalir.setText("Salir");
        mnusalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnusalirActionPerformed(evt);
            }
        });
        mnuCrear.add(mnusalir);

        jMenuBar1.add(mnuCrear);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(535, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuedarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRobar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(lblCarta2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lblCarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRobar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuedarse, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCarta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnusalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnusalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnusalirActionPerformed

    private void mnuUnirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUnirseActionPerformed
        String ip = JOptionPane.showInputDialog("Ingresa la direccion del servidor");
        usuario = "Cliente";
        conexion = new Conexion();
        seConecto = conexion.conectar(ip, 5000);

        if (seConecto) {
            btnRobar.setVisible(true);
            btnQuedarse.setVisible(true);
            setvisibleCartas();
            bloquearBotones();
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String mensaje = conexion.recibirMensaje();
                        
                    }
                }
            });

            hilo.start();
        } else {
            btnRobar.setVisible(false);
            btnQuedarse.setVisible(false);
        }
    }//GEN-LAST:event_mnuUnirseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        conexion = DialogoIP.mostrarIniciarServidor(this);
        usuario = "Servidor";
        
        if (conexion != null) {
            btnRobar.setVisible(true);
            btnQuedarse.setVisible(true);
            setvisibleCartas();
            
            if(terminado){
                Thread hilo = new Thread(new Runnable(){
                    @Override
                    public void run() {
                       while(true){
                           String rspuesta = conexion.recibirMensaje();
                       }
                    }
                    
                });
                hilo.start();
            }

        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnRobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRobarActionPerformed
        // TODO add your handling code here:
        if (contadorMano < 5) {
            for (int i = 0; i < 1; i++) {
                manoJugador[i].cogerCarta(baraja.robar());
                //  lblCarta1.setText(manoJugador[i].obtenerCarta(i) + "");
                
                System.out.println(manoJugador[i].obtenerCarta(manoJugador[i].contar() - 1) + "");
//            lblCarta2.setIcon(new javax.swing.ImageIcon(getClass().getResource
//        ("/Imagenes/"+manoJugador[i].obtenerCarta(i)+".jpg")));
                contadorMano++;
            }
        }

    }//GEN-LAST:event_btnRobarActionPerformed

    private void btnQuedarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuedarseActionPerformed
        btnRobar.setEnabled(false);
        btnQuedarse.setEnabled(false);
        System.out.println(manoJugador[0].getBlackjackValor());
        terminado = true;
        
    }//GEN-LAST:event_btnQuedarseActionPerformed

    public void bloquearBotones(){
        btnRobar.setEnabled(false);
        btnQuedarse.setEnabled(false);
    }
    public void desbloquearBotones(){
         btnRobar.setEnabled(true);
        btnQuedarse.setEnabled(true);
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
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuedarse;
    private javax.swing.JButton btnRobar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblCarta1;
    private javax.swing.JLabel lblCarta2;
    private javax.swing.JMenu mnuCrear;
    private javax.swing.JMenuItem mnuUnirse;
    private javax.swing.JMenuItem mnusalir;
    // End of variables declaration//GEN-END:variables
}

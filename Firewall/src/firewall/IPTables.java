/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firewall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AlejoP
 */
public class IPTables extends javax.swing.JFrame {

    /**
     * Creates new form IPTables
     */
      
     //
   
    
    
    private static byte[] readFromFile(String filePath, int position, int size)

	            throws IOException {

	 

	        RandomAccessFile file = new RandomAccessFile(filePath, "r");
                
	        file.seek(position);

	        byte[] bytes = new byte[size];

	        file.read(bytes);

	        file.close();

	        return bytes;

	 

	    }
    
 

	    private static void writeToFile(String filePath, String data)

	            throws IOException {

	            RandomAccessFile file = new RandomAccessFile(filePath, "rw");
                    file.seek(file.length()); //Nos situamos al final del fichero
                    file.writeBytes("\r\n"); //Imprimir salto de línea
                    file.writeBytes(data);  //Se deniega el tráfico apartir del tráfico  capturado
         
    }
            
            public void removeLineFromFile(String lineToRemove,String IN_OUT) {

 

    try {

 

        File inFile = new File("/usr/alejo/ips");

 

        if (!inFile.isFile()) {

            System.out.println("no hay file");

            return;

        }

 

        //Construct the new file that will later be renamed to the original filename.

        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

 

        BufferedReader br = new BufferedReader(new FileReader("/usr/alejo/ips"));

        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

 

        String line = null;

 

        //Read from the original file and write to the new

        //unless content matches data to be removed.

        while ((line = br.readLine()) != null) {

 

            if (!line.trim().contains(lineToRemove) || !line.trim().contains(IN_OUT)) {

 

                pw.println(line);

                pw.flush();

            }

        }

        pw.close();

        br.close();

 

        //Delete the original file

        if (!inFile.delete()) {

            System.out.println("Could not delete file");

            return;

        }

 

        //Rename the new file to the filename the original file had.

        if (!tempFile.renameTo(inFile)){

            System.out.println("Could not rename file");

 

        }

    } catch (FileNotFoundException ex) {

        ex.printStackTrace();

    } catch (IOException ex) {

        ex.printStackTrace();

    }

}
            

      
    public IPTables() {
        initComponents();
        working.setVisible(false);
        jComboBox1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
          //   String menu="";           
                        
                        
                       
                            int selection = jComboBox1.getSelectedIndex();
                            System.out.println(selection);
      switch (selection) {
                                
                                case 0:
                                    
                               //     JOptionPane.showMessageDialog(null, "you have selected option 1");
                                    
                              //      System.out.println(menu);
                                    // Se setea texto etiqueta ejemplo
                    
                                    break;
                                    
                                case 1:
                                    
                                //    JOptionPane.showMessageDialog(null, "you have selected option 2");
                                    jLabel3.setText("Ejemplo:192.168.100.222");
                                    
                                    
                                    break;
                                case 2:
                                    jLabel3.setText("Ejemplo:www.facebook.com");
                                    break;
                                case 3:
                                    jLabel3.setText("Ejemplo:22");
                                    break;
                                case 4:
                                    jLabel3.setText("Ejemplo:192.168.100.222");
                                    break;
                                case 5:
                                    jLabel3.setText("MAC-48, EUI-48, y EUI-64");
                                    
                                    
                                default:
                                    
                                    break;
                                    
   
   
                        
                    }}                 
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        encender = new javax.swing.JRadioButton();
        apagar = new javax.swing.JRadioButton();
        txt_IP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        deny = new javax.swing.JButton();
        allow = new javax.swing.JButton();
        goBack = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        working = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Configurar Reglas");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija una opciòn....", "Denegar Internet host LAN", "Denegar Dominio", "Denegar Puerto", "Denegar ping IP", "Denegar ping MAC" }));

        encender.setText("On");
        encender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encenderActionPerformed(evt);
            }
        });

        apagar.setText("Off");
        apagar.setToolTipText("");
        apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarActionPerformed(evt);
            }
        });

        txt_IP.setToolTipText("");
        txt_IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IPActionPerformed(evt);
            }
        });

        jLabel3.setText("Ayuda...");

        jLabel1.setText("IP");

        deny.setText("Denegar");
        deny.setName("addRule"); // NOI18N
        deny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyActionPerformed(evt);
            }
        });

        allow.setText("Permitir");
        allow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowActionPerformed(evt);
            }
        });

        goBack.setText("<---");
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/firewall/descarga.jpg"))); // NOI18N

        working.setIcon(new javax.swing.ImageIcon(getClass().getResource("/firewall/jklugj.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(encender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apagar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(goBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(deny)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(allow, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(working, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(encender)
                    .addComponent(apagar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deny)
                            .addComponent(allow))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(goBack)
                            .addComponent(btnClear)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(working, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(134, 134, 134))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IPActionPerformed

    private void denyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyActionPerformed
      
       String FILEPATH = "/usr/alejo/ips";
       int selection = jComboBox1.getSelectedIndex();
       int menu=-1;
       
     
         String IP=(txt_IP.getText());
         // Se valida que el campo no este nulo o vacío
            if(txt_IP.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Favor llenar el campo vacío para continuar");
              }
              else {
      
         // Se le pregunta al usuario si la regla a definir es de entrada o alida
              menu=Integer.parseInt(JOptionPane.showInputDialog(null,"1-Entrada 2-Salida"));
              
              // Denegar host dentro LAN
              if(selection==1 && menu==1)
                           
                 { 
                     try { 
                        
                        // Se valida que no haya una regla repetida
                         removeLineFromFile("INPUT",IP);
                         // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j DROP");
                       
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              //Denegar Dominio
              else if(selection==2 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -s "+IP+" -j DROP");
                      
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar Puerto
               else if(selection==3 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -p tcp --dport "+IP+" -j DROP");
                        // String[] command = {"gksudo","/usr/test_2.sh"}; 
                        // Process p = Runtime.getRuntime().exec(command);
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar ping
               else if(selection==4 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -s "+IP+" -j DROP");
                       //  String[] command = {"gksudo","/usr/test_2.sh"}; 
                       //  Process p = Runtime.getRuntime().exec(command);
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             // Denegar MAC 
               else if(selection==5 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                        removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -m  mac -mac-source "+IP+" -j DROP");
                        // String[] command = {"gksudo","/usr/test_2.sh"}; 
                        // Process p = Runtime.getRuntime().exec(command);
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar Internet HOST LAN saliente
               else if(selection==1 && menu==2)
                           
                 { 
                     try { 

                         
                         // Se valida que no haya una regla repetida
                         removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j DROP");
   
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar dominio tràfico saliente
               else if(selection==2 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j DROP");
                      
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar puerto HOST saliente
               else if(selection==3 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                        removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -p tcp --dport "+IP+" -j DROP");
                      
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
            // Denegar ping host saliente  
               else if(selection==4 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j DROP");
                  
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             // Denegar MAC saliente 
               else if(selection==5 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -m  mac -mac-source "+IP+" -j DROP");
                      
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
               else{
                   JOptionPane.showMessageDialog(deny, "Seleccione una opciòn valida no sea mk!!!");
               }

            }
    

    }

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
       Menu   menu=new Menu();
       menu.setVisible(true);
       menu.setLocation(100,100);
       
        
    }//GEN-LAST:event_goBackActionPerformed

    private void allowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowActionPerformed
       
       String FILEPATH = "/usr/alejo/ips";
       int selection = jComboBox1.getSelectedIndex();
       int menu=-1;
       
     
         String IP=(txt_IP.getText());
         // Se valida que el campo no este nulo o vacío
            // Se valida que el campo no este nulo o vacío
            if(txt_IP.getText().equals("")){
                      JOptionPane.showMessageDialog(null,"Favor llenar el campo vacío para continuar");
              }
              else {
      
         // Se le pregunta al usuario si la regla a definir es de entrada o alida
              menu=Integer.parseInt(JOptionPane.showInputDialog(null,"1-Entrada 2-Salida"));
              
              // Denegar host dentro LAN
              if(selection==1 && menu==1)
                           
                 { 
                     try { 
                        
                         // Se valida que no haya una regla repetida
                          removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -s "+IP+" -j ACCEPT");
              
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              //Denegar Dominio
              else if(selection==2 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables - INPUT -s "+IP+" -j ACCEPT");
                       
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar Puerto
               else if(selection==3 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -p tcp --dport "+IP+" -j ACCEPT");
                 
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar ping
               else if(selection==4 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -s "+IP+" -j ACCEPT");
                       
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             // Denegar MAC 
               else if(selection==5 && menu==1)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("INPUT",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -A INPUT -m  mac -mac-source "+IP+" -j ACCEPT");
                        
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar Internet HOST LAN saliente
               else if(selection==1 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j ACCEPT");
                  
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar dominio tràfico saliente
               else if(selection==2 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                         removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j ACCEPT");
                         
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              // Denegar puerto HOST saliente
               else if(selection==3 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -p tcp --dport "+IP+" -j ACCEPT");
                       
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
            // Denegar ping host saliente  
               else if(selection==4 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                        Runtime.getRuntime().exec("/usr/alejo/test_3.sh");
                        writeToFile(FILEPATH,"iptables -I FORWARD -d "+IP+" -j ACCEPT");
                
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             // Denegar MAC saliente 
               else if(selection==5 && menu==2)
                           
                 { 
                     try { 

                         // Se valida que no haya una regla repetida
                          removeLineFromFile("FORWARD",IP);
                        // Se crea regla
                         writeToFile(FILEPATH,"iptables -I FORWARD -m  mac -mac-source "+IP+" -j ACCEPT");
            
                     } catch (IOException ex) {
                         Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
              
              else{
                   JOptionPane.showMessageDialog(deny, "Seleccione una opciòn valida no sea mk!!!");
               }

            }
    }//GEN-LAST:event_allowActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txt_IP.setText("");
        
        try { 
            Runtime.getRuntime().exec("/usr/alejo/test_3.sh");
        } catch (IOException ex) {
            Logger.getLogger(IPTables.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
               
        
        
        if   (apagar.isSelected()) {
              encender.setEnabled(false);
        }
        else {
           encender.setEnabled(true);
       }
        
          try {
                    
                 Runtime.getRuntime().exec("/usr/alejo/test_1.sh"); 
                 System.out.println("Entrò!!");
                     

	        } catch (IOException e) {

	            e.printStackTrace();

	        }
     
            

    }//GEN-LAST:event_apagarActionPerformed

    private void encenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encenderActionPerformed
       
       if   (encender.isSelected()) {
              apagar.setEnabled(false);
              working.setVisible(true);
        }
       else {
           apagar.setEnabled(true);
           working.setVisible(false);
       }
       
       try {
                    
                 Runtime.getRuntime().exec("/usr/alejo/test_2.sh"); 
                 System.out.println("Entrò!!");
                     

	        } catch (IOException e) {

	            e.printStackTrace();

	        }
    }//GEN-LAST:event_encenderActionPerformed

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
            java.util.logging.Logger.getLogger(IPTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IPTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IPTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IPTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IPTables().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allow;
    private javax.swing.JRadioButton apagar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton deny;
    private javax.swing.JRadioButton encender;
    private javax.swing.JButton goBack;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_IP;
    private javax.swing.JLabel working;
    // End of variables declaration//GEN-END:variables
}

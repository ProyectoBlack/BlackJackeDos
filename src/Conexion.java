
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author missa
 */
public class Conexion {

    private DataOutputStream salida;
    private DataInputStream entrada;
    private ServerSocket sc;
    public boolean estado = false;

    public boolean conectar(String direccion, int puerto) {
        try {
            Socket so = new Socket(direccion, puerto);
            salida = new DataOutputStream(so.getOutputStream());
            entrada = new DataInputStream(so.getInputStream());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void esperarConexion(int puerto) {
        try {
            
                sc = new ServerSocket(puerto);
                System.out.println("Esperando una conexión");
                Socket so = sc.accept();
                salida = new DataOutputStream(so.getOutputStream());
                entrada = new DataInputStream(so.getInputStream());
                estado = true;

                System.out.println("Cliente conectado");
       

        } catch (Exception ex) {
            System.err.println("Se canceló la espera de conexión");
        }
    }

    public String obtenerIPsLocales() {
        String ip = "";
        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while (e.hasMoreElements()) {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();

                while (ee.hasMoreElements()) {
                    InetAddress i = (InetAddress) ee.nextElement();
                    String nombre = n.getName();

                    if (i instanceof Inet4Address && (nombre.startsWith("eth") || nombre.startsWith("wlan"))) {
                        if (!ip.isEmpty()) {
                            ip += ", ";
                        }

                        ip += i.getHostAddress() + " (" + nombre + ")";
                    }
                }
            }
        } catch (Exception ex) {
        }

        return ip;
        // TODO: Completar este método... 
    }

    public void enviarMensaje(String mensaje) {
        try {
            salida.writeUTF(mensaje);
        } catch (IOException ex) {
            System.err.println("Sucedió un error al enviar");
        }
    }

    public String recibirMensaje() {
        String mensaje = null;
        try {
            mensaje = entrada.readUTF();
        } catch (IOException ex) {
            System.err.println("Sucedió un error al recibir");
        }

        return mensaje;
    }

    public void detenerEsperaConexion() {
        try {
            sc.close();
        } catch (IOException ex) {
            System.err.println("Sucedió un error....");
        }
    }
}

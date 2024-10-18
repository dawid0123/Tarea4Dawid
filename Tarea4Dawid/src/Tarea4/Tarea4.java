package Tarea4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase principal Tarea4. Permite la creación de objetos Alumno con datos 
 * ingresados por el usuario y guarda estos objetos en un archivo binario.
 * 
 * @author Dawid
 * @version 1.0
 */
public class Tarea4 {

    /**
     * Método principal que ejecuta el programa. Solicita los datos de varios alumnos,
     * los crea como objetos de la clase Alumno y los guarda en un archivo.
     * 
     * @param args Argumentos pasados desde la línea de comandos.
     * @throws ParseException Si hay un error al analizar la fecha de nacimiento.
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * Estructura try-catch para manejar posibles excepciones al trabajar con archivos y objetos.
         */
        try {
            System.out.println("Dime el nombre y direccion del fichero");
            String fichero = sc.nextLine();

            /**
             * Inicializamos la escritura de objetos en el archivo binario.
             */
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));

            for (int i = 0; i < 5; i++) {
                System.out.println("Dime los datos del alumno " + (i + 1));

                System.out.println("Dime el nia");
                int nia = Integer.parseInt(sc.nextLine());

                System.out.println("Dime el nombre");
                String nombre = sc.nextLine();

                System.out.println("Dime los apellidos");
                String apellidos = sc.nextLine();

                System.out.println("Dime el genero");
                char genero = sc.nextLine().charAt(0);

                System.out.println("Dime la fecha de nacimiento");
                Date fecha_nacimiento = dateformat.parse(sc.nextLine());

                System.out.println("Dime el ciclo");
                String ciclo = sc.nextLine();

                System.out.println("Dime el curso");
                String curso = sc.nextLine();

                System.out.println("Dime el grupo");
                String grupo = sc.nextLine();

                /**
                 * Creación de un nuevo objeto Alumno con los datos proporcionados.
                 */
                Alumno alumno = new Alumno(nia, nombre, apellidos, genero, fecha_nacimiento, ciclo, curso, grupo);

                /**
                 * Escribimos el objeto Alumno en el archivo.
                 */
                oos.writeObject(alumno);
            }
            /**
             * Cerramos el flujo de salida del archivo.
             */
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}

/**
 * Clase Alumno que implementa Serializable, lo que permite que los objetos de esta clase puedan ser guardados en archivos.
 * Contiene información sobre los alumnos.
 * 
 * @author Dawid
 * @version 1.0
 */
class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;

    private int nia;
    private String nombre;
    private String apellidos;
    private char genero;
    private Date fecha_nacimiento;
    private String ciclo;
    private String curso;
    private String grupo;

    /**
     * Constructor de la clase Alumno que inicializa todos los atributos del alumno.
     * 
     * @param nia Número de Identificación del Alumno.
     * @param nombre Nombre del alumno.
     * @param apellidos Apellidos del alumno.
     * @param genero Género del alumno (M/F).
     * @param fecha_nacimiento Fecha de nacimiento del alumno.
     * @param ciclo Ciclo formativo del alumno.
     * @param curso Curso actual del alumno.
     * @param grupo Grupo asignado al alumno.
     */
    public Alumno(int nia, String nombre, String apellidos, char genero, Date fecha_nacimiento, String ciclo,
            String curso, String grupo) {
        super();
        this.nia = nia;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.genero = genero;
        this.fecha_nacimiento = fecha_nacimiento;
        this.ciclo = ciclo;
        this.curso = curso;
        this.grupo = grupo;
    }

    /**
     * Método toString para devolver una representación en forma de cadena de un objeto Alumno.
     * 
     * @return Cadena con todos los datos del alumno.
     */
    @Override
    public String toString() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        return "Alumno{" +
                "nia=" + nia +
                ", nombre=" + nombre +
                ", apellidos=" + apellidos +
                ", genero=" + genero +
                ", fecha_nacimiento=" + dateformat.format(fecha_nacimiento) +
                ", ciclo=" + ciclo +
                ", curso=" + curso +
                ", grupo=" + grupo + "}";
    }
}

package Tarea4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tarea4 {

	public static void main(String[] args) throws ParseException {
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Dime el nombre y direccion del fichero");
			String fichero=sc.nextLine();
		
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero));
			
			for(int i=0;i<5;i++) {
				System.out.println("Dime los datos del alumno "+(i+1));
				
				System.out.println("Dime la nia");
				int nia=Integer.parseInt(sc.nextLine());
				
				System.out.println("Dime el nombre");
				String nombre=sc.nextLine();
				
				System.out.println("Dime los apellidos");
				String apellidos=sc.nextLine();
				
				System.out.println("Dime el genero");
				char genero=sc.nextLine().charAt(0);
				
				System.out.println("Dime la fecha de nacimiento");
				Date fecha_nacimiento=dateformat.parse(sc.nextLine());
				
				System.out.println("Dime el ciclo");
				String ciclo=sc.nextLine();
				
				System.out.println("Dime el curso");
				String curso=sc.nextLine();
				
				System.out.println("Dime el grupo");
				String grupo=sc.nextLine();
				
				Alumno alumno=new Alumno(nia,nombre,apellidos,genero,fecha_nacimiento,ciclo,curso,grupo);
				
				oos.writeObject(alumno);
				
				
			}
			oos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}
}

class Alumno implements Serializable{
	private static final long serialVersionUID=1L;
	
	private int nia;
	private String nombre;
	private String apellidos;
	private char genero;
	private Date fecha_nacimiento;
	private String ciclo;
	private String curso;
	private String grupo;
	
	
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


	@Override
	public String toString() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		return "Alumno{"+
				"nia"+nia+
				"nombre"+nombre+
				"apellidos"+apellidos+
				"genero"+genero+
				"fecha_nacimiento"+dateformat.format(fecha_nacimiento)+
				"ciclo"+ciclo+
				"curso"+curso+
				"grupo"+grupo+"}"
				;
	}
	
	
	
	
}
	
	
	
	


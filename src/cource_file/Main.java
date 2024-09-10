package cource_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String strPath = "C:\\Users\\User\\Documents\\summary.txt";
		
		File file = new File(strPath);
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String lines = br.readLine();
			String line = lines.trim();
			String s = file.getParent()+"\\subdir";
			boolean succes = new File(s).mkdir();
			System.out.println("Directory create wich sucessfully: "+succes);
			
			if(succes == true) {
				s += "\\summary.csv";
				System.out.println(s);
				BufferedWriter bw = new BufferedWriter(new FileWriter(s));
				while(line != null) {
					
					String s1 = line.substring(0,line.length()-2);
					System.out.println(s1);
					String[] myArray = new String[1];
					myArray[0] = s1;
				
					for(String w : myArray) {
						System.out.println(w);
						bw.write(w);
						bw.newLine();
					}
					line = br.readLine();
				}
				bw.close();
			}
		}
		catch(IOException e) {
			System.out.println("Erro :"+e.getMessage());
		}
		sc.close();
	}

}

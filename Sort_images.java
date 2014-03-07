package Sort_image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;  
import java.util.HashSet;


class List_values {  
    String file_name;   
    float value;   

    public List_values(String n, float i) {  
        file_name = n;
	value = i;  
    }  
}  


class Sort_images {

	final static String NAME_FILE = "IMAGES.txt"; //name of the output file

	public static void main (String args[]) {
		
		if (args.length != 4) {
			System.out.println("It is necessary to inform four parameters"); 
		}
		else{	
			sort(new File(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		}
	}
	
	
	public static void sort(File file_images, int ord, int coord, String word)
	{
		File stat_file = new File(NAME_FILE);
		ArrayList<List_values> List = new ArrayList<List_values>(200);

		ArrayList<String> Red = new ArrayList<String>(200);

		int num_columns = 0;
		int count = 0;
		int count2 = 0;

		ArrayList<String> data_list = read_file(file_images);

		if (ord < coord){
			count = coord;
			coord = ord;
			ord = count;
		}

		char[] letter = word.toCharArray();


		for (count = 1; count < data_list.size(); count++) {
			StringTokenizer parts = new StringTokenizer(data_list.get(count),"\t");

			for (count2 = 1; count2 < coord; count2++)
				parts.nextToken();

			String image_file = parts.nextToken(); //image name

			for (count2 = count2+1; count2 < ord; count2++)
				parts.nextToken();

			String control = parts.nextToken(); //control variable 

			List.add(new List_values(image_file,Float.parseFloat(control)));
		}

		if (letter[0] == 'a') {
 			Collections.sort(List, new Comparator<List_values>() {  
            			public int compare(List_values o1, List_values o2) {	
                			return o1.value < o2.value ? -1 : (o1.value > o2.value ? +1 : 0);  	
				}
			});
		}

		else if (letter[0] == 'd') {
 			Collections.sort(List, new Comparator<List_values>() {  
            			public int compare(List_values o1, List_values o2) {  
                			return o1.value > o2.value ? -1 : (o1.value < o2.value ? +1 : 0);  	
				}
			});
		}

		//remove redundancies
		for (count = 0; count < List.size(); count++) {

			List_values p = List.get(count);
			if (!Red.contains(p.file_name))
				Red.add(p.file_name);
		}

		String output = Red.size() + "\r\n";
		write_file(stat_file,output,false);
		for (count = 0; count < Red.size(); count++) 
			write_file(stat_file,Red.get(count) + "\r\n",true);

	}

	
	public static void file_writer(String conteudo, String filename){
		
		try{
		
			//FileWriter fw = new FileWriter(filename,true);
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(filename,true), "UTF-8");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter saida = new PrintWriter(bw);
			saida.write(conteudo);
			saida.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
    
    
    //method to read file
    public static ArrayList<String> read_file(File file) {
    	
    	ArrayList<String> links = new ArrayList<String>(100);
    	try{   
    		String linha = "";
    		
    		//FileReader reader = new FileReader(file);  
    		InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");  
    		BufferedReader br = new BufferedReader(reader);  
    		
    		while(br.ready()){  
    			linha = br.readLine();  
    			linha = linha.replaceAll("[^\\p{ASCII}]", ""); 
    			links.add(linha);
    			//System.out.println(linha);  
    		}  
    		br.close();  
    		reader.close();
    	}
    	catch(IOException ioe) {ioe.printStackTrace();}
		return links;
    }   
	
    
    //method to write file
    public static void write_file(File file, String texto, boolean concat) {  
    	try {

            //FileWriter fileWriter = new FileWriter(file,concat);
    		OutputStreamWriter fileWriter = new OutputStreamWriter(new FileOutputStream(file,concat), "UTF-8");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(texto);
            printWriter.flush();
 
    		//fileWriter.write(texto);
    		
            printWriter.close();
    		fileWriter.close();
        } 
    	catch (IOException e) {e.printStackTrace();}
    }  
    
}



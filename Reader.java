package basic;
//For Reade------------------
import java.io.FileReader;
import java.io.BufferedReader;
//For Writer
import java.io.File;
import java.io.FileWriter;
//Exception
import java.io.IOException;
//----------------------------
public class Reader{
	private BufferedReader br = null;
	public Boolean fnf = false;//File Not Found
	public Boolean err = false;//Error Occured
	public Boolean wm = false;//Write Mode
	private Boolean b;//Both Read and Write
	private FileWriter pw;
	public Reader(String name){
		wm = false;
		b = false;
		ReaderIntilizer(name);
	}
	public Reader(String name,String opt){
		if(opt == "r"){
			wm = false;
			b = false;
			ReaderIntilizer(name);
		}else if(opt == "w"){
			wm = true;
			b = false;
			WriterIntilizer(name,false);
		}else if(opt=="a"){
			wm = true;
			b = false;
			WriterIntilizer(name,true);
		}else if(opt=="rw"){
			b = true;
			ReaderIntilizer(name);
			WriterIntilizer(name,true);
		}
		else{
			System.out.println("Invalid Mode");
			fnf = true;
			err = true;
		}
	}
	private void ReaderIntilizer(String name){
		try{
		br = new BufferedReader(new FileReader(name));
		}catch (IOException e){
		System.out.println("File Not Found!:"+e);
		fnf = true;
		}
	}
	public String read(){
		if(fnf || (wm && !b)){return "";}
		String txt = "";
		try{
			String line;
			String space = "";
			while(true){
				if((line = br.readLine())!= null){
					txt+=space;
					if(space==""){space = "\n";}
				}else{
					break;
				}
				txt+=line;
			}
			return txt;
		}catch (IOException e) {
			System.out.println(e);
			return txt;
		}
	}
	private void WriterIntilizer(String name,Boolean overwrite){
		try{
			File file = new File(name);
			if(!file.exists()){
				file.createNewFile();
				pw = new FileWriter(file);
			}else{
			if(file.canWrite()){
			pw = new FileWriter(file,overwrite);}
			else{
				System.out.println("Access Denied(Atribute)");
				err = true;
			}
		}
		}catch (IOException e) {
			err = true;
			System.out.println(e);
		}
	}
	public void write(String txt){
		if((txt!=null && !err) && (wm || b)){
			try{
			pw.write(txt);
		}
			catch (IOException e) {
				System.out.println(e);
			}
		}else{
			System.out.println("Error");
		}
	}
	public void close(){
		if (fnf || err) {return;}
		try{
			if (wm) {
				pw.close();
			}
			else {
				if(b){
					pw.close();
				}
				br.close();
			}
		}catch (IOException e) {
			System.out.println("Error");
		}
	}
}
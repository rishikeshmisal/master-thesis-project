import java.io.*;
import java.util.*;

class FileJoin{
public static void main(String args[])throws Exception{
	/*boolean s = (new File("C:\\rishi\\Thesis\\Some")).mkdir();*/
	
	int cnt = 0;
	int size =  1024*1024;
	//byte buffer[] = new byte[size];
	String x = "test.mp3";
	//File f;
	File ff[] = (new File("C:\\rishi\\Thesis")).listFiles();
	File fw[] = new File[10];
	int len = 0;
	
	for(File f: ff){
		if(f.isDirectory()){
			
		}
		else{
			if(f.getAbsolutePath().contains("test")){
				fw[cnt] = new File(f.getAbsolutePath());
				len+=fw[cnt++].length();
			}
		}
	}
	
	byte buffer[] = new byte[1024*1024];
	File ret = new File("C:\\rishi\\Thesis\\Some\\test.mp3");
	for(File f: fw){
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))){
			
			int t = bis.read(buffer);
			
			try(FileOutputStream fos = new FileOutputStream(ret, true)){
				fos.write(buffer,0,t);
			}
			
		}
	}
	
	
}
}
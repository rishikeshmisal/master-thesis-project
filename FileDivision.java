import java.io.*;
import java.util.*;

class FileDivision{
public static void main(String args[])throws Exception{
	/*boolean s = (new File("C:\\rishi\\Thesis\\Some")).mkdir();*/
	
	int cnt = 0;
	int size =  1024*1024;
	byte buffer[] = new byte[size];
	String x = "test.mp3";
	File f = new File(x);

	try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f))){
		int t = 0;
		
		while((t = bis.read(buffer))>0){
			File ff = new File(f.getParent(), x.substring(0,x.lastIndexOf('.'))+"-"+String.format("%03d",++cnt)+x.substring(x.lastIndexOf('.'),x.length()));
			
			try(FileOutputStream out = new FileOutputStream(ff)){
				out.write(buffer,0,t);
			}
		}
	}
	
}

}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

class FixedSizeChunking {
	public Hashtable<String, String> indexTable;
	public Checksum sum;
	public FileList list;
	public int count;
	private FileInputStream fis;
	

	public FixedSizeChunking(String directory) {
		indexTable = new Hashtable<String, String>();
		sum = new Checksum();
		// list = new FileList(Config.DIRECTORY);
		list = new FileList(directory);
		count = 0;
	}

	public void setAll(File[] fileList) {
		
		byte[] chunk = new byte[Config.FIXED_CHUNKING];
		for (File f : fileList) {
			count = 0;
			if (f.isFile() && !f.isHidden()) {
				
				try {
					fis = new FileInputStream(f.getAbsolutePath());
					while (fis.read(chunk) != -1) {
						
						String hashvalue = sum.chunking(chunk);
						
						if (!indexTable.containsKey(hashvalue)) {
							indexTable.put(hashvalue, f.getName());
						} else {
							System.out.println(++count
									+ " duplicate contents found in: "
									+ f.getName());
						}
					}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}

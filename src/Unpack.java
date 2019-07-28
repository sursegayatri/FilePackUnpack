import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Unpack
{

	FileOutputStream outstream = null;
	FileInputStream instream = null;
	
	public Unpack(String src)throws Exception
	{
		unpack(src);		
	}
	public void unpack(String filePath)throws Exception
	{
		
		try {
			
			 instream = new FileInputStream(filePath);
			byte magic[]=new byte[12];
			instream.read(magic,0,magic.length);
			
			String magicstr=new String(magic);
			
			if(!magicstr.equals("Marvellous11"))
			{
				throw new InvalidFileException("Invalid packed file format");
			}
			
			
			byte[] header = new byte[100];
			int length;
	    	    int size;
	    	    
	 
	    	       	
	    	    while ((length = instream.read(header,0,100)) > 0){
		    	    	String name=new String(header);
		    	    	String ext = name.substring(name.lastIndexOf("\\"));
		    	    	ext = ext.substring(1);
		    	    	String [] words = ext.split("\\s");
		    	    	String filename= words[0];
		    	    	
		    	    	System.out.println(filename);
		    	    	 size = Integer.parseInt(words[1]);
		    	    	 byte arr[] =new byte[size];
		    	    	 instream.read(arr,0,size);
		    	    	 FileOutputStream  fout =new FileOutputStream(filename);
		    	    	 fout.write(arr,0,size);
		    	    	System.out.println(size);
		    	    	 //System.out.println();
			    	    // size=instream.toString().substring(instream.toString().lastIndexOf(" ")+1);
			    	     //System.out.println(size);
			    	     //byte[] b=size.getBytes();
		  //  	System.out.println(instream);

		    	    	
		    	    } 
	}
		catch(InvalidFileException obj)
		{
			throw new InvalidFileException("Invalid packed file format");
			
		}
		catch(Exception e) {}
	}
}

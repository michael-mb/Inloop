package mike_class;

import java.io.File;

public class JAttachment extends JContent{

	private File file ;
	
	public JAttachment(String title, String description , File file) {
		super(title, description);
		if(file==null)
			throw new NullPointerException();
		this.file=file;
		// TODO Auto-generated constructor stub
	}

	public File getFile()
	{
		return this.file;
	}
	public void setFile(File file)
	{
		if(file==null)
			throw new NullPointerException();
		
		this.file = file ;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Attachment: "+super.getTitle()+"\n"+super.getDescription();
	}

}

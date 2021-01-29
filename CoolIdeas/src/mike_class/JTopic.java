package mike_class;

public class JTopic extends JContent{

	private int id ;
	public JTopic(String title, String description , int id) {
		super(title, description);
		this.id = id ;
		// TODO Auto-generated constructor stub
	}
	
	public int getId()
	{
		return id ;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Topic: "+super.getTitle()+"\n"+super.getDescription();
	}

}

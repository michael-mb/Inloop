package mike_class;

public class JValuation extends JContent{

	public JValuation(String title, String description) {
		super(title, description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Valuation: "+super.getTitle()+"\n"+super.getDescription();
	}

}

package mike_class;

import java.util.ArrayList;
import java.util.List;

public class JIdea extends JContent{
	
	private List<JAttachment> attachments ;
	private JState state  ;
	
	public JIdea (String title , String description)
	{
		super(title, description);
		attachments = new ArrayList<>();
		this.state = new Draft();
	}
	public void discuss(String text)
	{
		if(text==null)
			throw new NullPointerException();
		if(text.isEmpty())
			throw new IllegalArgumentException();
		
		state.discuss(text);
	}
	public void evaluate(JValuation valuation)
	{
		state.evaluate(valuation);
	}
	public void hold()
	{
	   	state.hold();
	}
	public void release()
	{
		state.release();
	}
	public void decline()
	{
		state.decline();
	}
	
	public boolean isReleased()
	{
		if(state instanceof ReleasedIdea)
		return true;
		
		return false;
	}
	public boolean isDeclined()
	{
		if(state instanceof DeclinedIdea)
		return true;
		
		return false;
	}
	public String getCurrentDiscussion()
	{
		return state.getCurrentDiscussion();
	}
	
	public void setCurrentDiscussion(String currentDiscussion)
	{
		state.setCurrentDiscussion(currentDiscussion);
	}
	public JValuation getValuation()
	{
		return state.getValuation();
	}
	
	public void addAttachment(JAttachment attachment)
	{
		if(attachment==null)
			throw new NullPointerException();
		  attachments.add(attachment);
	}
	public List<JAttachment> getAttachments()
	{
		return attachments ;
	}
	public boolean removeAttachment(JAttachment attachment)
	{
		if(attachment == null )
			throw new NullPointerException();
		
		return attachments.remove(attachment);
	}
	public String toString()
	{
		return "Idea: "+super.getTitle()+"\n"+super.getDescription();
	}
	
	
	// Meine JState !! **************************************************************
public abstract class JState {

	private String currentDiscussion="" ;
	private JValuation valuation ;
	
	public void discuss(String text)
	{
		if(text == null)
			throw new NullPointerException();
		if(text.isEmpty())
			throw new IllegalArgumentException();
		
		currentDiscussion += "\n"+text;
	}
	public void evaluate (JValuation valuation)
	{
		if(valuation==null)
			throw new NullPointerException();
		
		this.valuation.setTitle(valuation.getTitle());
		this.valuation.setDescription(valuation.getDescription());
		
	}
	public void hold()
	{
		if(state instanceof OpenDraft || state instanceof Draft)
		state.hold();
		
		else
			throw new IllegalStateException();
	}
	public void release()
	{
		if(state instanceof ApprovedIdea)
		state.release();
	}
	public void decline()
	{
		if(state instanceof OpenDraft || state instanceof Draft)
		state.decline();
	}
	public String getCurrentDiscussion()
	{
		return this.currentDiscussion;
	}
	
	public void setCurrentDiscussion(String currentDiscussion)
	{
		if(currentDiscussion == null)
			throw new NullPointerException();
		if(currentDiscussion.isEmpty())
			throw new IllegalArgumentException();
		
		 this.currentDiscussion = currentDiscussion;
	}
	
	public JValuation getValuation()
	{
		return valuation;
	}
	public void setValuation(JValuation valuation)
	{
		if(valuation==null)
			throw new NullPointerException();
		
		this.valuation = valuation ;
	}
	
	
}

// Meine UnterKLassen !! **************************************************************

public class ApprovedIdea extends JState{
	
	public void release()
	{
		state = new ReleasedIdea();
	}
	public void discuss(String text)
	{
		throw new IllegalStateException();
	}
	public void evaluate (JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public void decline()
	{
		throw new IllegalStateException();
	}
}


public class Draft extends JState{
	public void hold()
	{
		state = new OpenDraft();
	}
	public void decline()
	{
		state = new DeclinedIdea();
	}
	public void discuss(String text)
	{
		throw new  IllegalStateException();
	}
	public void evaluate (JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public void release()
	{
		throw new  IllegalStateException();
	}
}


public class OpenDraft extends JState{
	
	public void discuss(String text)
	{
		if(text==null)
			throw new NullPointerException();
		if(text.isEmpty())
			throw new IllegalArgumentException();
	
		state.setCurrentDiscussion(state.getCurrentDiscussion()+text+"\n");
	}
	public void evaluate(JValuation valuation)
	{
		state.setValuation(valuation);
	}
	public void hold()
	{
		state = new ApprovedIdea();
	}
	public void decline()
	{
		state = new DeclinedIdea();
	}
	
	public void release()
	{
		throw new IllegalStateException();
	}
}



public class ReleasedIdea extends JState{
	public void discuss(String text)
	{
		throw new IllegalStateException();
	}
	public void evaluate (JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public JValuation getValuation()
	{
		throw new IllegalStateException();
	}
	public void setValuation(JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public void decline()
	{
		throw new IllegalStateException();
	}
	public void release()
	{
		throw new IllegalStateException();
	}
}



public class DeclinedIdea extends JState{
	
	public void discuss(String text)
	{
		throw new IllegalStateException();
	}
	public void evaluate (JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public JValuation getValuation()
	{
		throw new IllegalStateException();
	}
	public void setValuation(JValuation valuation)
	{
		throw new IllegalStateException();
	}
	public void decline()
	{
		throw new IllegalStateException();
	}
	public void release()
	{
		throw new IllegalStateException();
	}
}


}

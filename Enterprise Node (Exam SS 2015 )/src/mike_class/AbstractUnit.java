package mike_class;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUnit extends AbstractEnterpriseUnit{

	private List<AbstractEnterpriseUnit> nodes ;
	public AbstractUnit(String name) {
		super(name);

		nodes = new ArrayList<>();
	}
	public boolean add(AbstractEnterpriseUnit childNode)
	{
		if(childNode == null)
			throw new NullPointerException();
		if(!nodes.contains(childNode))
			return nodes.add(childNode);
			return false ;		
	}
	public boolean remove(AbstractEnterpriseUnit childNode)
	{
		if(childNode == null)
			throw new NullPointerException();
		
		return nodes.remove(childNode);
	}
	public List<AbstractEnterpriseUnit>getChildNodes()
	{
		return nodes ;
	}
}
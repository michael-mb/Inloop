package mike_class;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StructuredObject extends RenovationObject{

	protected Set<RenovationObject> parts ;
	
	public StructuredObject()
	{
		this.parts = new HashSet<RenovationObject>();
	}
	public void add(RenovationObject r)
	{
		if(r==null)
			throw new NullPointerException();
		
		parts.add(r);
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		
		double price = 0.0 ;
		for(RenovationObject r : parts )
		{
			price+= r.getPrice();
		}
		return price;
	}
	@Override
	public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) {
		// TODO Auto-generated method stub
		if (materials==null)
			throw new NullPointerException();
		if(materials.containsValue(null))
			throw new NullPointerException();
		
		
		Map<String, Integer> newMaterials = new TreeMap<String, Integer>();
		
		for (String s : materials.keySet())
		{
			if(s==null)
				throw new NullPointerException();
		}
		newMaterials=materials;
		for(RenovationObject r : parts)
		{
			newMaterials = r.addMaterialReq(newMaterials);
			System.out.println(newMaterials);	
		}
		
		

		System.out.println("Return"+newMaterials);
		return newMaterials;
	}
	
}

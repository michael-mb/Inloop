package mike_class;

import java.util.Map;
import java.util.TreeMap;

public class Surface extends RenovationObject{

	private double length ;
	private double width ;
	private Material selectedMaterial ;
	
	public Surface(double length , double width)
	{
		if(length<=0 || width <=0 )
			throw new IllegalArgumentException();
		this.length = length;
		this.width = width ;
	}
	public void setMaterial(Material m)
	{
		if(m==null)
		throw new NullPointerException();
		
		this.selectedMaterial = m ;
	}
	public double getArea()
	{
		return this.length * this.width ;
	}
	public double getLength()
	{
		return this.length;
	}
	public double getWidth()
	{
		return this.width;
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.selectedMaterial.getPriceOfASurface(this);
	}

	@Override
	public Map<String, Integer> addMaterialReq(Map<String, Integer> materials) {
		// TODO Auto-generated method stub

		if (materials==null)
			throw new NullPointerException();
		
		Map<String, Integer> newMaterials = new TreeMap<String, Integer>();
		
		if(!materials.isEmpty())
		{
			for(String s : materials.keySet())
			{
				if(materials.get(s)==null)
					throw new NullPointerException();
				newMaterials.put(s, materials.get(s));
			}
		}
		
		if(materials.containsKey(this.selectedMaterial.getName()))
		{
			int nbrOfMaterials = newMaterials.get(this.selectedMaterial.getName());
			newMaterials.put(this.selectedMaterial.getName(), this.selectedMaterial.getMaterialReq(this)+nbrOfMaterials);
		}
		else
		{
			newMaterials.put(this.selectedMaterial.getName(), this.selectedMaterial.getMaterialReq(this));
		}

		
		return newMaterials;
	}

}

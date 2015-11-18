package symtable;

import java.util.*;
import symtable.Type;

public class Signature 
{
	public Type return_type;
	public List<Type> formal_parameters;
	public Signature(Type return_type, List<Type> formal_parameters)
	{
		this.return_type = return_type;
		if(formal_parameters == null)
		{
			this.formal_parameters = new LinkedList<Type>();
		}
		this.formal_parameters = formal_parameters;
	}
	
	public Type getReturnType()
	{
		return this.return_type;
	}
	
	public int formalCount()
	{
		return this.formal_parameters.size();
	}
	
	public Type formalType(int num)
	{
		return (Type)this.formal_parameters.get(num);
	}
}

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
}

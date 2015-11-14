package symtable;

import symtable.Scope;
import symtable.Signature;



public class MethodSTE extends STE
{
	public Signature mSignature;
	public Scope mScope;
	public MethodSTE(Signature sig, Scope scope, String name)
	{
		this.mSignature = sig;
		this.mScope = scope;
		this.mName = name;
	}
       
}

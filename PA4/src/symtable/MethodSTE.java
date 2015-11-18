package symtable;

import symtable.Scope;
import symtable.Signature;
import java.io.PrintStream;


public class MethodSTE extends STE
{
	public Signature mSignature;
	public Scope mScope;
	public MethodSTE(Signature sig, String name)
	{
		this.mSignature = sig;
		//this.mScope = scope;
		this.mName = name;
	}
	
	public Signature getSignature()
	{
		return this.mSignature;
	}
	
	public int outputDot(PrintStream printStream, int n) {
		String output1;
		if(this.mSignature == null) output1 = "null";
		else this.mSignature.toString();
        String output2 = "\t" + n + 
						 " [label=\" <f0> MethodSTE " + 
						 "| <f1> mName = " + this.mName + 
						 "| <f2> mSignature = " + string + 
						 "| <f3> mScope \"];";
        printStream.println(string2);
        printStream.println("\t" + n + 
							":<f3> -> " + ++n + 
							":<f0>;");
        return this.mScope.outputDot(printStream, n);
    }
       
}

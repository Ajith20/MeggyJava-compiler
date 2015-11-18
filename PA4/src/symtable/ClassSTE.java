package symtable;

import symtable.Scope;
import java.io.PrintStream;
public class ClassSTE extends STE
{
	
	public boolean mMain;
	public String mSuperClass;
	public Scope mScope;
	public ClassSTE(String mName, boolean mMain, String mSuperClass)
	{
		this.mName = mName;
		this.mMain = mMain;
		this.mSuperClass = mSuperClass;
		//this.mScope = mScope;
		
	}
	public int outputDot(PrintStream printStream, int n) {
        String output = "\t" + n++ + 
						" [label=\" <f0> ClassSTE " +
						"| <f1> mName = " + this.mName +
						"| <f2> mMain = " + this.mMain + 
						"| <f3> mSuperClass = " + this.mSuperClass + 
						"| <f4> mScope \"];";
        printStream.println(output);
        printStream.println("\t" + n++ + 
							":<f4> -> " + n + 
							":<f0>;");
        return this.mScope.outputDot(printStream, n);
    }
}

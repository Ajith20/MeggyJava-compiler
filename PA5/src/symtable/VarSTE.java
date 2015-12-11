
package symtable;

import symtable.STE;
import symtable.Type;
import java.io.PrintStream;
public class VarSTE extends STE
{
	public Type mType;
	public String mBase;
	public int mOffset;
	public VarSTE(String mName, Type mType, int mOffset)
	{
		this.mName = mName;
		this.mType = mType;
		this.mOffset = mOffset;
		this.mBase = "Y";
	}
	
    public int outputDot(PrintStream printStream, int n) {
        String output = "\t" + n + 
						" [label=\" <f0> VarSTE " + 
						"| <f1> mName = " + this.mName + 
						"| <f2> mType = " + this.mType.toString() + 
						"| <f3> mBase = " + this.mBase + 
						"| <f4> mOffset = " + this.mOffset + 
						"\"];";
        printStream.println(output);
        return n++;
    }
}

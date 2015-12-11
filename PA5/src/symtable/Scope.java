package symtable;

import java.util.*;
import java.util.HashMap;
import symtable.STE;
import symtable.ClassSTE;
import symtable.VarSTE;
import java.io.PrintStream;
import symtable.*;
import exceptions.InternalException;
public class Scope
{
	public HashMap<String, STE> mHashMap = new HashMap();
    	public Scope mEnclosing;
	private final List<String> scope_list = new LinkedList<String>();
	 public Scope(Scope scope) 
	{
	        this.mEnclosing = scope;
        }
	public STE lookup(String ste_name) 
	{
		if (mHashMap.containsKey(ste_name)) 
		{
		    return mHashMap.get(ste_name);
		}
		return null;
        }
	public void insert(STE ste) 
	{
		String name = ste.mName;
		boolean ste_status = ste instanceof VarSTE;	
		boolean contains_key = mHashMap.containsKey(name);	
		if (!ste_status && contains_key) 
		{
		    throw new InternalException("Redefined symbol " + name);
		}
		mHashMap.put(name, ste);
		this.scope_list.add(name);
    	}
	 public int outputDot(PrintStream printStream, int n) {
        String string;
        int n2 = n;
        String string2 = "\t" + n2 + " [label=\" <f0> Scope ";
        Iterator<String> iterator = this.scope_list.iterator();
        int n3 = 1;
        while (iterator.hasNext()) {
            string = iterator.next();
            string2 = string2 + "| <f" + n3 + "> " + "mDict\\[" + string + "\\] ";
            ++n3;
        }
        string2 = string2 + "\"];";
        printStream.println(string2);
        iterator = this.scope_list.iterator();
        n3 = 1;
        while (iterator.hasNext()) {
            string = iterator.next();
            STE sTE = this.mHashMap.get(string);
            printStream.println("\t" + n2 + ":<f" + n3 + "> -> " + ++n + ":<f0>;");
            n = sTE.outputDot(printStream, n);
            ++n3;
        }
        return n;
    }
}

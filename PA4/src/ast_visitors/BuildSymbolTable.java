package ast_visitors;

import ast.node.*;
import ast.visitor.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;
import java.io.PrintWriter;
import symtable.SymTable;
import symtable.Type;
import symtable.STE;
import exceptions.InternalException;
import exceptions.SemanticException;
import symtable.Signature;
import symtable.*;


public class BuildSymbolTable extends DepthFirstVisitor
{
	private SymTable mCurrentST = new SymTable();
	private ClassSTE mCurrentClass;
	public int offset;
	private Type getType(IType iType) {
        if (iType == null) {
            throw new InternalException("unexpected null argument");
        }
        Type type = Type.INT;
        if (iType instanceof BoolType) {
            type = Type.BOOL;
        }
        if (iType instanceof ByteType) {
            type = Type.BYTE;
        }
        if (iType instanceof ColorType) {
            type = Type.COLOR;
        }
        if (iType instanceof ButtonType) {
            type = Type.BUTTON;
        }
        if (iType instanceof ToneType) {
            type = Type.TONE;
        }
        if (iType instanceof IntType) {
            type = Type.INT;
        }
        if (iType instanceof VoidType) {
            type = Type.VOID;
        }
        if (iType instanceof ClassType) {
            type = Type.getClassType((String)((ClassType)iType).getName());
        }
        return type;
    }

	
 public void inMethodDecl(MethodDecl node) {
        String method_name = node.getName();
	    Formal formal;
	    STE ste = mCurrentST.lookup(method_name);
	    if(ste != null) {
		throw new SemanticException("Redefined symbol " + method_name);
        }

	    Iterator iterator = node.getFormals().iterator();
        LinkedList<Type> formal_list = new LinkedList<Type>();
        while (iterator.hasNext()) {
            formal = (Formal)iterator.next();
            formal_list.add(this.getType(formal.getType()));
        }
        
	    Signature sig_obj = new Signature(this.getType(node.getType()), formal_list);
	    //Scope scope = new Scope(null);
	    MethodSTE meth_obj = new MethodSTE(sig_obj,node.getName());
	    //ste.mName = node.getName();
	    mCurrentST.insert((STE)meth_obj);
	    meth_obj.mScope = new Scope(mCurrentST.mStackScope.peek());
	    mCurrentST.mStackScope.push(meth_obj.mScope);
	    VarSTE var_obj = new VarSTE("this", Type.getClassType((String)this.mCurrentClass.mName), 1);
        mCurrentST.insert((STE)var_obj);
	    this.offset = 1;
    }

  public void outFormal(Formal node)
    {
	String formal_name = node.getName();
	STE ste1 = mCurrentST.lookup(formal_name);
	if(ste1 != null)
	{
		throw new SemanticException("Formal already present");
	}
	VarSTE var_obj = new VarSTE(node.getName(), this.getType(node.getType()), this.offset);
	//Increment offset based on type: TO DO
	mCurrentST.insert((STE)var_obj);
	
    }

  public void outMethodDecl(MethodDecl node)
    {
	//TO DO: Store number of bytes needed for parameters as size of the method
	this.mCurrentST.popScope();
    }

  public void inTopClassDecl(TopClassDecl node) 
    {
	String class_name = node.getName();
	STE ste = mCurrentST.lookup(class_name);
	if(ste != null)
	{
		throw new SemanticException("Class already present");
	}
	//Scope scope = new Scope(null);
	ClassSTE class_obj = new ClassSTE(node.getName(), false, null);
	//ste.mName = class_name;	
	mCurrentST.insert((STE)class_obj);
	class_obj.mScope = new Scope(mCurrentST.mStackScope.peek());
	mCurrentST.mStackScope.push(class_obj.mScope);
	this.mCurrentClass = class_obj; 
    }

     public void outTopClassDecl(TopClassDecl topClassDecl) {
        this.mCurrentST.popScope();
    }

   public SymTable getSymTable() {
        return this.mCurrentST;
    }
}

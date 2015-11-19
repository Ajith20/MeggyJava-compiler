package ast_visitors;

/** 
 * CheckTypes
 * 
 * This AST visitor traverses a MiniJava Abstract Syntax Tree and checks
 * for a number of type errors.  If a type error is found a SymanticException
 * is thrown
 * 
 * CHANGES to make next year (2012)
 *  - make the error messages between *, +, and - consistent <= ??
 *
 * Bring down the symtab code so that it only does get and set Type
 *  for expressions
 */

import ast.node.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;

import symtable.SymTable;
import symtable.Type;
import symtable.STE;
import symtable.ClassSTE;
import symtable.MethodSTE;
import symtable.Signature;
import exceptions.InternalException;
import exceptions.SemanticException;

public class CheckTypes extends DepthFirstVisitor
{
    
   private SymTable mCurrentST;
   private ClassSTE mCurrentClass;
   
   public CheckTypes(SymTable st) {
     if(st==null) {
          throw new InternalException("unexpected null argument");
      }
      mCurrentST = st;
   }
   
   //========================= Overriding the visitor interface

   public void defaultOut(Node node) {
       System.err.println("Node not implemented in CheckTypes, " + node.getClass());
   }
   
   public void outAndExp(AndExp node)
   {
     if(this.mCurrentST.getExpType(node.getLExp()) != Type.BOOL) {
       throw new SemanticException(
         "Invalid left operand type for operator &&",
         node.getLExp().getLine(), node.getLExp().getPos());
     }

     if(this.mCurrentST.getExpType(node.getRExp()) != Type.BOOL) {
       throw new SemanticException(
         "Invalid right operand type for operator &&",
         node.getRExp().getLine(), node.getRExp().getPos());
     }

     this.mCurrentST.setExpType(node, Type.BOOL);
   }
  
   public void outPlusExp(PlusExp node)
   {
       Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
           (rexpType==Type.INT  || rexpType==Type.BYTE)
          ){
           this.mCurrentST.setExpType(node, Type.INT);
       } else {
           throw new SemanticException(
                   "Operands to + operator must be INT or BYTE",
                   node.getLExp().getLine(),
                   node.getLExp().getPos());
       }
   }
    
    public void outMulExp(MulExp node)
    {
        Type lexpType = this.mCurrentST.getExpType(node.getLExp());
        Type rexpType = this.mCurrentST.getExpType(node.getRExp());
        if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
            (rexpType==Type.INT  || rexpType==Type.BYTE)
            ){
            this.mCurrentST.setExpType(node, Type.INT);
        } else {
            throw new SemanticException(
                                        "Operands to * operator must be INT or BYTE",
                                        node.getLExp().getLine(),
                                        node.getLExp().getPos());
        }
    }
    
    public void outMinusExp(MinusExp node){
        Type lexpType = this.mCurrentST.getExpType(node.getLExp());
        Type rexpType = this.mCurrentST.getExpType(node.getRExp());
        if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
            (rexpType==Type.INT  || rexpType==Type.BYTE)
            ){
            this.mCurrentST.setExpType(node, Type.INT);
        } else {
            throw new SemanticException(
                                        "Operands to - operator must be INT or BYTE ",
                                        node.getLExp().getLine(),
                                        node.getLExp().getPos());
        }
    }
    
    public void outNegExp(NegExp node){
        Type expType = this.mCurrentST.getExpType(node.getExp());
        if (expType==Type.INT  || expType==Type.BYTE){
            this.mCurrentST.setExpType(node, Type.INT);
        } else {
            throw new SemanticException("Uminus operator must be INT or BYTE", node.getExp().getLine(),node.getExp().getPos());
        }
    }

    public void outEqualExp(EqualExp node){
        Type lexpType = this.mCurrentST.getExpType(node.getLExp());
        Type rexpType = this.mCurrentST.getExpType(node.getRExp());
        if ((lexpType==Type.INT  || lexpType==Type.BYTE || lexpType==Type.COLOR  || lexpType==Type.BUTTON|| lexpType==Type.BOOL) &&
            (rexpType==Type.INT  || rexpType==Type.BYTE || rexpType==Type.COLOR  || rexpType==Type.BUTTON|| rexpType==Type.BOOL)
            ){
            this.mCurrentST.setExpType(node, Type.BOOL);
        } else {
            throw new SemanticException(
                                        "Operands to == operator must be INT, BYTE, COLOR, BOOL, or BUTTON",
                                        node.getLExp().getLine(),
                                        node.getLExp().getPos());
        }
    }
    
    public void outMeggyCheckButton(MeggyCheckButton node){
        Type expType = this.mCurrentST.getExpType(node.getExp());
        if (expType==Type.BUTTON){
            this.mCurrentST.setExpType(node, Type.BOOL);
        } else {
            throw new SemanticException(
                                        "The signature of MeggyCheckButton() function is boolean MeggyCheckButton(Button button) ",
                                        node.getExp().getLine(),node.getExp().getPos());
        }
    }
    
    public void outMeggyGetPixel(MeggyGetPixel node){
        Type xexpType = this.mCurrentST.getExpType(node.getXExp());
        Type yexpType = this.mCurrentST.getExpType(node.getYExp());
        if ((xexpType==Type.BYTE ) &&
            (yexpType==Type.BYTE)
            ){
            this.mCurrentST.setExpType(node, Type.COLOR);
        } else {
            throw new SemanticException(
                                        "The signature of MeggyGetPixel() function is void MeggyGetPixel(byte x byte y)",
                                        node.getXExp().getLine(),
                                        node.getXExp().getPos());
        }
    }
    
    public void outByteCast(ByteCast node){
        Type expType = this.mCurrentST.getExpType(node.getExp());
        if (expType==Type.INT || expType==Type.BYTE){
            this.mCurrentST.setExpType(node, Type.BYTE);
        } else {
            throw new SemanticException(
                                        "Operands to Byte cast must be INT " + expType,
                                        node.getExp().getLine(), node.getExp().getPos());
        }
    }
    
    public void outBlockStatement(BlockStatement node){
        //do nothing
    }
	
    public void outMainClass(MainClass node)
    {
        //do nothing
    }
	
    public void outProgram(Program node)
    {
        //do nothing
    }
	
    public void outIntegerExp(IntLiteral node){
        this.mCurrentST.setExpType(node, Type.INT);
    }
	
    public void outColorExp(ColorLiteral node){
        this.mCurrentST.setExpType(node, Type.COLOR);
    }
    
    public void outButtonExp(ButtonLiteral node){
        this.mCurrentST.setExpType(node, Type.BUTTON);
    }
	
    public void outTrueExp(TrueLiteral node){
        this.mCurrentST.setExpType(node, Type.BOOL);
    }
    
    public void outFalseExp(FalseLiteral node){
        this.mCurrentST.setExpType(node, Type.BOOL);
    }
    
    public void outNotExp(NotExp node) {
        if(this.mCurrentST.getExpType(node.getExp()) != Type.BOOL) {
            throw new SemanticException(
                                        "Invalid right operand type for operator ! ",
                                        node.getExp().getLine(), node.getExp().getPos());
        }
        this.mCurrentST.setExpType(node, Type.BOOL);
    }

    public void outIfStatement(IfStatement node, String a, String b)
    {
        if(this.mCurrentST.getExpType(node.getExp()) != Type.BOOL) {
            throw new SemanticException(
                                        "If statement must contain a boolean value ",
                                        node.getExp().getLine(), node.getExp().getPos());
        }
        
        this.mCurrentST.setExpType(node, Type.VOID);
    }
    
    public void outWhileStatement(WhileStatement node){
        if(this.mCurrentST.getExpType(node.getExp()) != Type.BOOL) {
            throw new SemanticException(
                                        "Invalid expression type for While ",
                                        node.getExp().getLine(), node.getExp().getPos());
        }
        
        this.mCurrentST.setExpType(node, Type.BOOL);
    }
    
    public void outMeggySetPixel(MeggySetPixel node)
    {
        Type xexpType = this.mCurrentST.getExpType(node.getXExp());
        Type yexpType = this.mCurrentST.getExpType(node.getYExp());
        Type colorexpType = this.mCurrentST.getExpType(node.getColor());
        if ((xexpType==Type.BYTE) &&
            (yexpType==Type.BYTE) &&
            (colorexpType==Type.COLOR)
            ){
            this.mCurrentST.setExpType(node, Type.VOID);
        } else {
            throw new SemanticException(
                                        "The signature of MeggySetPixel() function is void MeggySetPixel((byte) x, (byte) y, color c)",
                                        node.getXExp().getLine(),
                                        node.getXExp().getPos());
        }
    }
    
    public void outMeggyDelay(MeggyDelay node)
    {
        Type expType = this.mCurrentST.getExpType(node.getExp());
        if (expType==Type.INT){
            this.mCurrentST.setExpType(node, Type.VOID);
        } else {
            throw new SemanticException(
                                        "The signature of MeggyDelay() function is void MeggyDelay(int duration)",
                                        node.getExp().getLine(),
                                        node.getExp().getPos());
        }
    }
	
	//Start of PA4 TypeChecking
	
	private Type typeCheck(IExp nodeExp, String nodeId, int nodeLine, int nodePos, LinkedList<IExp> nodeArgs)
	{

		Type locType1 = this.mCurrentST.getExpType(nodeExp);
		if((locType1 == null) || (!locType1.isRef()))
			throw new SemanticException("Method call receiver must be a class ", nodeLine, nodePos);
		
		ClassSTE locClassSTE = (ClassSTE)this.mCurrentST.lookup(locType1.getClassName());
		
		//MethodSTE locMethodSTE = (MethodSTE)locClassSTE.lookup(nodeId);
        MethodSTE locMethodSTE = (MethodSTE)this.mCurrentST.lookup(nodeId);
		if(locMethodSTE == null)
			throw new SemanticException("The method " + nodeId + " doesn't exist in class " + locClassSTE.mName + nodeLine + nodePos);

		Signature locSignature = locMethodSTE.getSignature();
		int i = nodeArgs.size();
		if(i != locSignature.formalCount())
			throw new SemanticException("The method " + nodeId + " needs " + locSignature.formalCount() + " arguments " + nodeLine + nodePos);
		
		IExp[] tempIExpArray = new IExp[i];
		tempIExpArray = (IExp[])nodeArgs.toArray(tempIExpArray);
		for(int j = 0; j < tempIExpArray.length; j++) {
			Type locType2 = this.mCurrentST.getExpType(tempIExpArray[j]);
			Type locType3 = locSignature.formalType(j);
			if((locType3 != locType2) && ((locType3 != Type.INT) || (locType2 != Type.BYTE))) 
				throw new SemanticException("Argument type for method " + nodeId + " is invalid ", tempIExpArray[j].getLine(), tempIExpArray[j].getPos());
		}
		return locSignature.getReturnType();
	}
	
	public void outMeggyToneStart(MeggyToneStart node)
	{
		Type toneExpType = this.mCurrentST.getExpType(node.getToneExp());
		Type durationExpType = this.mCurrentST.getExpType(node.getDurationExp());
		if ((toneExpType==Type.TONE) &&
			(durationExpType==Type.INT)
			){
			this.mCurrentST.setExpType(node, Type.VOID);
		} else {
			throw new SemanticException(
										 "The signature of MeggyToneStart() function is void MeggyToneStart(Tone tone, int duration)",
										 node.getToneExp().getLine(),
										 node.getToneExp().getLine());	
		}
	}
	
	public void outBoolType(BoolType node)
	{
		// Do nothing 
	}
	
	public void outButtonType(ButtonType node)
	{
		// Do nothing 
	}
	
	public void outByteType(ByteType node)
	{
		// Do nothing 
	}
	
	public void outCallExp(CallExp node)
	{
		//Type locType = typeCheck(node.getExp(), node.getId(), node.getLine(), node.getPos(), node.getArgs());
		//this.mCurrentST.setExpType(node, locType);
	}
	
	public void outCallStatement(CallStatement node)
	{
		//typeCheck(node.getExp(), node.getId(), node.getLine(), node.getPos(), node.getArgs());
	}

    public void outIdLiteral(IdLiteral node)
    {
        /*STE locSTE = this.mCurrentST.lookup(node.getLexeme());
        if(locSTE == null)
            throw new SemanticException("Undeclared variable " + node.getLexeme(), node.getLine(), node.getPos());*/
    }
	
	public void outColorType(ColorType node)
	{
		// Do nothing 
	}
	
	public void outFormal(Formal node)
	{

	}
	
	public void outIntType(IntType node)
	{
		// Do nothing 
	}
	
	public void outLtExp(LtExp node)
	{
	   Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
           (rexpType==Type.INT  || rexpType==Type.BYTE)
          ){
           this.mCurrentST.setExpType(node, Type.BOOL);
       } else {
           throw new SemanticException(
                   "Operands to < operator must be INT or BYTE",
                   node.getLExp().getLine(),
                   node.getLExp().getPos());
       }
	}

    public void inMethodDecl(MethodDecl node)
    {
        //this.mCurrentST.pushScope(node.getName());
    }
	
	public void outMethodDecl(MethodDecl node)
	{
		/*this.mCurrentST.popScope();
		MethodSTE localMethodSTE = (MethodSTE)this.mCurrentST.lookup(node.getName());
		
		Type locType1 = localMethodSTE.getSignature().getReturnType();
		Type locType2 = this.mCurrentST.getExpType(node.getExp());
		if((locType1 == Type.VOID) && (locType2 != null)) 
			throw new SemanticException("Type returned from method is invalid " + node.getName() + node.getLine() + node.getPos());
		if((locType1 != locType2) && (locType2 != null))
			throw new SemanticException("Type returned from method is invalid " + node.getName() + node.getLine() + node.getPos());*/
	}
	
	public void outNewExp(NewExp node)
	{
		/*STE currSTE = this.mCurrentST.lookup(node.getId());
		if(currSTE == null) throw new SemanticException("Class undeclared " + node.getLine() + node.getPos());
		this.mCurrentST.setExpType(node, Type.getClassType(node.getId()));*/
	}
	
	public void outThisExp(ThisLiteral node)
	{
        /*if(this.mCurrentST.lookup(node.getLexeme()) == null) throw new InternalException("'This' being called without a class");
		if(this.mCurrentClass == null) throw new InternalException("'This' being called without a class");
		this.mCurrentST.setExpType(node, Type.getClassType(this.mCurrentClass.getName()));*/
	}
	
	public void outToneExp(ToneLiteral node) {
		this.mCurrentST.setExpType(node, Type.TONE);
	}
	
	public void outToneType(ToneType node)
	{
		// Do nothing 
	}
	
	public void outTopClassDecl(TopClassDecl node)
	{
		//this.mCurrentST.popScope();
	}
	
	public void outVoidType(VoidType node)
	{
		// Do nothing 
	}
}

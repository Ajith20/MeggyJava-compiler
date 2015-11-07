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
import exceptions.InternalException;
import exceptions.SemanticException;

public class CheckTypes extends DepthFirstVisitor
{
    
   private SymTable mCurrentST;
   
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
  
    //ADD All OUTmethods For PA3 by Taghreed
    
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
    public void outIfStatement(IfStatement node)
    {
        if(this.mCurrentST.getExpType(node.getExp()) != Type.BOOL) {
            throw new SemanticException(
                                        "Invalid right operand type for operator &&",
                                        node.getExp().getLine(), node.getExp().getPos());
        }
        
        this.mCurrentST.setExpType(node, Type.BOOL);
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
}
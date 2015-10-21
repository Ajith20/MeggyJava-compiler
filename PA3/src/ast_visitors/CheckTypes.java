package ast_visitors;

/** 
 * CheckTypes
 * 
 * This AST visitor traverses a MiniJava Abstract Syntax Tree and checks
 * for a number of type errors.  If a type error is found a SemanticException
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

   public void outBlockStatement(BlockStatement node)
   {
    this.mCurrentST.setExpType(node, Type.VOID);
   }

   public void outMainClass(MainClass node)
   {
    this.mCurrentST.setExpType(node, Type.VOID);
   }

   public void outProgram(Program node)
   {
    this.mCurrentST.setExpType(node, Type.VOID);
   }

   public void outTrueExp(TrueLiteral node)
   {
    this.mCurrentST.setExpType(node, Type.BOOL);
   }

   public void outFalseExp(FalseLiteral node)
   {
    this.mCurrentST.setExpType(node, Type.BOOL);
   }

   public void outIntegerExp(IntLiteral node)
   {
    this.mCurrentST.setExpType(node, Type.INT);
   }

   public void outButtonExp(ButtonLiteral node)
   {
    this.mCurrentST.setExpType(node, Type.BUTTON);
   }

   public void outColorExp(ColorLiteral node)
   {
    this.mCurrentST.setExpType(node, Type.COLOR);
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

   public void outEqualExp(EqualExp node)
   {
       Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if (lexpType==Type.INT && rexpType==Type.INT)
          this.mCurrentST.setExpType(node, Type.BOOL);
  else if (lexpType==Type.BYTE && rexpType==Type.BYTE)
          this.mCurrentST.setExpType(node, Type.BOOL);
  else if (lexpType==Type.BOOL && rexpType==Type.BOOL)
          this.mCurrentST.setExpType(node, Type.BOOL);
  else if (lexpType==Type.COLOR && rexpType==Type.COLOR)
          this.mCurrentST.setExpType(node, Type.BOOL);
  else if (lexpType==Type.VOID && rexpType==Type.VOID)
          this.mCurrentST.setExpType(node, Type.BOOL);
     else {
       throw new SemanticException(
               "Operands to == operator do not match",
               node.getLExp().getLine(),
               node.getLExp().getPos());
     }
   }

   public void outMinusExp(MinusExp node)
   {
       Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if ((lexpType==Type.INT  || lexpType==Type.BYTE) &&
           (rexpType==Type.INT  || rexpType==Type.BYTE)
          ){
           this.mCurrentST.setExpType(node, Type.INT);
    } else {
       throw new SemanticException(
               "Operands to - operator must be INT or BYTE",
               node.getLExp().getLine(),
               node.getLExp().getPos());
     }
   }

   public void outMulExp(MulExp node)
   {
       Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       if ((lexpType==Type.INT || lexpType==Type.BYTE) &&
           (rexpType==Type.INT || rexpType==Type.BYTE))
          {
           this.mCurrentST.setExpType(node, Type.INT);
         } else {
          throw new SemanticException(
            "Operands to * operator must be INT or BYTE",
            node.getLExp().getLine(),
            node.getLExp().getPos());
        }
   }

   public void outNegExp(NegExp node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.INT || expType==Type.BYTE)
       {
           this.mCurrentST.setExpType(node, Type.INT);
         } else {
          throw new SemanticException(
            "Operand to - (negation) operator must be INT or BYTE",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outNotExp(NotExp node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.BOOL)
       {
           this.mCurrentST.setExpType(node, Type.BOOL);
         } else {
          throw new SemanticException(
            "Operand to ! operator must be BOOL",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outMeggySetPixel(MeggySetPixel node)
   {
       Type xexpType = this.mCurrentST.getExpType(node.getXExp());
       Type yexpType = this.mCurrentST.getExpType(node.getYExp());
       Type cexpType = this.mCurrentST.getExpType(node.getColor());
       if ((xexpType==Type.BYTE || xexpType==Type.INT) &&
          (yexpType==Type.BYTE || yexpType==Type.INT) &&
          (cexpType==Type.COLOR))
       {
           this.mCurrentST.setExpType(node, Type.VOID);
         } else {
          throw new SemanticException(
            "Operands to Meggy.setPixel() must be (BYTE or INT, BYTE or INT, COLOR)",
            node.getXExp().getLine(),
            node.getXExp().getPos());
        }
   }

   public void outMeggyGetPixel(MeggyGetPixel node)
   {
       Type xexpType = this.mCurrentST.getExpType(node.getXExp());
       Type yexpType = this.mCurrentST.getExpType(node.getYExp());
       if (xexpType==Type.BYTE && yexpType==Type.BYTE)
       {
           this.mCurrentST.setExpType(node, Type.COLOR);
         } else {
          throw new SemanticException(
            "Operands to Meggy.getPixel() must be (BYTE, BYTE)",
            node.getXExp().getLine(),
            node.getXExp().getPos());
        }
   }

   public void outMeggyCheckButton(MeggyCheckButton node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.BUTTON)
       {
           this.mCurrentST.setExpType(node, Type.BOOL);
         } else {
          throw new SemanticException(
            "Operand to Meggy.checkButton() must be BUTTON",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outMeggyDelay(MeggyDelay node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.INT)
       {
           this.mCurrentST.setExpType(node, Type.VOID);
         } else {
          throw new SemanticException(
            "Operand to Meggy.delay() must be INT",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outByteCast(ByteCast node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.INT)
       {
           this.mCurrentST.setExpType(node, Type.BYTE);
         } else {
          throw new SemanticException(
            "Operand cast to a BYTE must be INT",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outIfStatement(IfStatement node, String a, String b) 
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.BOOL)
       {
           this.mCurrentST.setExpType(node, Type.VOID);
         } else {
          throw new SemanticException(
            "If statement operator must be of type BOOL",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }

   public void outWhileStatement(WhileStatement node)
   {
       Type expType = this.mCurrentST.getExpType(node.getExp());
       if (expType==Type.BOOL)
       {
           this.mCurrentST.setExpType(node, Type.VOID);
         } else {
          throw new SemanticException(
            "While statement operator must be of type BOOL",
            node.getExp().getLine(),
            node.getExp().getPos());
        }
   }
}
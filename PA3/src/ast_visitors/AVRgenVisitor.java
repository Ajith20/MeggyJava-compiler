package ast_visitors;

import ast.node.*;
import ast.visitor.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;
import java.io.PrintWriter;
import symtable.SymTable;
import symtable.Type;
import exceptions.InternalException;
import exceptions.SemanticException;
import label.*;
public class AVRgenVisitor extends DepthFirstVisitor
{
    private PrintWriter out;
    public AVRgenVisitor(PrintWriter out, SymTable globalST) {
      this.out = out;
      
   }
    public void inProgram(Program node)
    {   System.out.println("IN THE PROGRAM");
        out.println(" .file  \"main.java\" \n __SREG__ = 0x3f \n __SP_H__ = 0x3e \n  __SP_L__ = 0x3d \n __tmp_reg__ = 0 \n __zero_reg__ = 1 \n .global __do_copy_data \n .global __do_clear_bss \n .text \n .global main \n.type   main, @function \n main: \n push r29 \n push r28 \n in r28,__SP_L__ \n in r29,__SP_H__ \n /* prologue: function */ \n call _Z18MeggyJrSimpleSetupv \n /* Need to call this so that the meggy library gets set up */\n\n\n ");
    }

    public void outProgram(Program node)
    {
       out.println("  \n\n\n /* epilogue start */ \n endLabel:\n jmp endLabel \n ret \n .size   main, .-main ");
       out.flush();
    }
   
   public void outAndExp(AndExp node)
   {
     
   }
  
   public void outPlusExp(PlusExp node)
   {
       out.println(" # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # Do add operation \n add    r24, r18 \n adc    r25, r19 \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
   }

   public void outEqualExp(EqualExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
      out.println(" # equality check expression \n # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n cp    r24, r18 \n cpc   r25, r19 \n breq " + b +" \n # result is false \n " + a +": \n ldi     r24, 0 \n jmp      " + c +" \n # result is true \n " + b +": \n ldi     r24, 1 \n # store result of equal expression \n " + c +": \n # push one byte expression onto stack \n push   r24 \n ");
   }

   public void outMinusExp(MinusExp node)
   {
      out.println("  # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # Do INT sub operation \n sub    r24, r18 \n sbc    r25, r19 \n # push hi order byte first \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
   }

   public void outMulExp(MulExp node)
   {
       out.println("  # MulExp \n # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r22 \n # move low byte src into dest reg \n mov    r24, r18 \n # move low byte src into dest reg \n mov    r26, r22 \n # Do mul operation of two input bytes \n muls   r24, r26 \n # push two byte expression onto stack \n push   r1 \n push   r0 \n # clear r0 and r1, thanks Brendan! \n eor    r0,r0 \n eor    r1,r1 ");
   }

   public void outNegExp(NegExp node)
   {
       
   }

   public void outNotExp(NotExp node)
   {
       
   }

   public void outMeggySetPixel(MeggySetPixel node)
   {
     
      out.println(" ### Meggy.setPixel(x,y,color) call \n # load a one byte expression off stack \n pop    r20 \n # load a one byte expression off stack \n pop    r22 \n # load a one byte expression off stack \n pop    r24 \n call   _Z6DrawPxhhh \n call   _Z12DisplaySlatev ");
   }
   public void outMeggyCheckButton(MeggyCheckButton node)
   {
      
   }

   public void outMeggyDelay(MeggyDelay node)
   {
        out.println(" ### Meggy.delay() call \n # load delay parameter \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n call   _Z8delay_msj \n ");
   }

   public void outByteCast(ByteCast node)
   {
       out.print("  # Casting int to byte by popping \n # 2 bytes off stack and only pushing low order bits \n # back on.  Low order bits are on top of stack. \n pop    r24 \n pop    r25 \n push   r24 \n");
   }
    
    public void visitIfStatement(IfStatement node)
    {
        inIfStatement(node);
	//out = out;
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
        if(node.getExp() != null)
        {
            node.getExp().accept(this);
        }
	out.println(" # load condition and branch if false \n # load a one byte expression off  stack \n pop    r24 \n #load zero into reg \n ldi    r25, 0 \n #use cp to set SREG \n cp     r24, r25 \n #WANT breq MJ_L0 \n brne  " + b + " \n jmp    "+ a);
        if(node.getThenStatement() != null)
        {
	   
	    out.println(a + ":");
            node.getThenStatement().accept(this);
	    out.println("jump " + c);
        }
        if(node.getElseStatement() != null)
        {
	     
	    out.println(b + ":");
            node.getElseStatement().accept(this);
	    out.println("jump " + c);
        }
	out.println(c + ":");
        outIfStatement(node,a,b);
    }
   //@override
   public void outIfStatement(IfStatement node, String a, String b, String c) 
   {
	//String a1 = new Label().toString();
	//String b1 = new Label().toString();
	//String c = new Label().toString();
      // out.println(" # load condition and branch if false \n # load a one byte expression off stack \n pop    r24 \n #load zero into reg \n ldi    r25, 0 \n #use cp to set SREG \n cp     r24, r25 \n #WANT breq "+ a +" \n brne   "+ b +" \n jmp    "+ a +" \n #done label for if \n "+ c +": \n ");
	//out.println(" # load condition and branch if false # load a one byte expression off \n stack pop    r24 \n #load zero into reg \n ldi    r25, 0 \n #use cp to set SREG \n cp     r24, r25 \n #WANT breq MJ_L0 \n brne  " + a + " jmp    "+ b +" ");
   }

   public void outWhileStatement(WhileStatement node)
   {
       
   }
   public void outIntegerExp(IntLiteral node)
   {
         out.println("  # Load constant int  \n ldi    r24,lo8("+ node.getLexeme() + ") \n ldi    r25,hi8(" + node.getLexeme() + ") \n # push two byte expression onto stack \n push   r25 \n push   r24 \n ");
   }
   public void outColorExp(ColorLiteral node)
    {
         out.println("  # Color expression Meggy.Color.BLUE \n ldi    r22," + node.getIntValue() + " \n  # push one byte expression onto stack \n push   r22 ");
    }
    public void outTrueExp(TrueLiteral node)
    {
        out.println(" # True/1 expression \n ldi    r22, 1 \n # push one byte expression onto stack \n push   r22 ");
    }
     public void outFalseExp(FalseLiteral node)
    {
        out.println("  # False/0 expression \n ldi    r24,0 \n # push one byte expression onto stack \n push   r24  ");
    }
}

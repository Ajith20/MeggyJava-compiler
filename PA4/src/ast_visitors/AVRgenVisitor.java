package ast_visitors;

/** 
 * AVRgenVisitor
 * 
 * This AST visitor traverses a MiniJava Abstract Syntax Tree and generates
 * AVR Code.  
 *
 *By Taghreed
 */

import ast.node.*;
import ast.visitor.DepthFirstVisitor;
import java.util.*;
import java.lang.*;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;

import symtable.SymTable;
import label.Label;
import exceptions.InternalException;
import exceptions.SemanticException;

public class AVRgenVisitor extends DepthFirstVisitor
{
    
   private SymTable mCurrentST;
   private PrintWriter out;
    private String str;
    
   public AVRgenVisitor(PrintWriter avrsout, SymTable st) {
       if(st==null) {
          throw new InternalException("unexpected null argument");
      }
       mCurrentST = st;
       out = avrsout;
       System.out.println("Generate prolog using avrH.rtl.s");
       InputStream mainPrologue=null;
       BufferedReader reader=null;
       try {
           // The syntax for loading a text resource file
           // from a jar file here:
           // http://www.rgagnon.com/javadetails/java-0077.html
           mainPrologue = this.getClass().getClassLoader().getResourceAsStream("avrH.rtl.s");
           reader = new BufferedReader(new InputStreamReader(mainPrologue));
           String line = null;
           while ((line = reader.readLine()) != null) {
               out.println(line);
           }
       }
       catch ( Exception e2) {
           e2.printStackTrace();
       }
       finally{
           try{
               if(mainPrologue!=null) mainPrologue.close();
               if(reader!=null) reader.close();
           }
           catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
   
   //========================= Overriding the visitor interface

   public void defaultOut(Node node) {
   }

    public void outMeggySetPixel(MeggySetPixel node)
    {
        out.println("   ### Meggy.setPixel(x,y,color) call");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r20");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r22");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r24");
        out.println("   call   _Z6DrawPxhhh");
        out.println("   call   _Z12DisplaySlatev");
    }
    public void outByteCast(ByteCast node){
        out.println("   # Casting int to byte by popping");
        out.println("   # 2 bytes off stack and only pushing low order bits");
        out.println("   # back on.  Low order bits are on top of stack.");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   push   r24");
    }
    
    public void outIntegerExp(IntLiteral node){
        int num = node.getIntValue();
        out.println("   # Load constant int " + num);
        out.println("   ldi    r24,lo8(" + num + ")");
        out.println("   ldi    r25,hi8(" + num + ")");
        out.println("   # push two byte expression onto stack");
        out.println("   push   r25");
        out.println("   push   r24");
    }
    public void outColorExp(ColorLiteral node){
        int num = node.getIntValue();
        out.println("   # Color expression " + num);
        out.println("   ldi    r22," + num);
        out.println("   # push one byte expression onto stack");
        out.println("   push   r22");
    }
    
    public void outButtonExp(ButtonLiteral node){
        String buttonLexeme = node.getLexeme();
        str = buttonLexeme.substring(6,buttonLexeme.length());
        str = str.replace(".","_");
    }
    
    public void outMainClass(MainClass node){
        System.out.println("Generate eipolog using avrF.rtl.s");
        InputStream mainEpilog=null;
        BufferedReader reader=null;
        try {
            // The syntax for loading a text resource file
            // from a jar file here:
            // http://www.rgagnon.com/javadetails/java-0077.html
            mainEpilog = this.getClass().getClassLoader().getResourceAsStream("avrF.rtl.s");
            reader = new BufferedReader(new InputStreamReader(mainEpilog));
            
            String line = null;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch ( Exception e2) {
            e2.printStackTrace();
        }
        finally{
            try{
                if(mainEpilog!=null) mainEpilog.close();
                if(reader!=null) reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void outMeggyDelay(MeggyDelay node)
    {
        out.println("   ### Meggy.delay() call");
        out.println("   # load delay parameter");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   call   _Z8delay_msj");
    }
    
    public void outMeggyCheckButton(MeggyCheckButton node)
    {
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        out.println("   ### MeggyCheckButton");
        out.println("   call    _Z16CheckButtonsDownv");
        out.println("   lds    r24, " + str);
        out.println("   tst    r24");
        out.println("   breq   " + l1);
        out.println(l2 + ":");
        out.println("   ldi r24, 1");
        out.println("   jmp " + l3);
        out.println(l1 + ":");
        out.println(l3 + ":");
        out.println("   # push one byte expression onto stack");
        out.println("   push   r24");
    }
    public void outMeggyGetPixel(MeggyGetPixel node)
    {
        out.println("   ### Meggy.getPixel(x,y) call");
        out.println("   pop    r22");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r24");
        out.println("   call   _Z6ReadPxhh");
        out.println("   # push one byte expression onto stack");
        out.println("   push   r24");
        
    }
    public void outPlusExp(PlusExp node)
    {
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r18");
        out.println("   pop    r19");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   # Do add operation");
        out.println("   add    r24,r18");
        out.println("   adc    r25,r19");
        out.println("   # push two byte expression onto stack");
        out.println("   push   r25");
        out.println("   push   r24");
    }
    
    public void outMulExp(MulExp node)
    {
        out.println("   # MulExp");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r18");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r22");
        out.println("   # move low byte src into dest reg");
        out.println("   mov    r24, r18");
        out.println("   # move low byte src into dest reg");
        out.println("   mov    r26, r22");
        out.println("   # Do mul operation of two input bytes");
        out.println("   muls   r24, r26");
        out.println("   # push two byte expression onto stack");
        out.println("   push   r1");
        out.println("   push   r0");
        out.println("   # clear r0 and r1, thanks Brendan!");
        out.println("   eor    r0,r0");
        out.println("   eor    r1,r1");
    }
    
    public void outMinusExp(MinusExp node)
    {
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r18");
        out.println("   pop    r19");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   # Do INT sub operation");
        out.println("   # Load constant int 2");
        out.println("   sub    r24,r18");
        out.println("   sbc    r25,r19");
        out.println("   # push hi order byte first");
        out.println("   # push two byte expression onto stack");
        out.println("   push   r25");
        out.println("   push   r24");
    }
    public void outEqualExp(EqualExp node)
    {
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        out.println("   # equality check expression");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r18");
      //  out.println("   pop    r19");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   cp    r24, r18");
       // out.println("   cpc   r25, r19");
        out.println("   breq " + l2);
        out.println("   # result is false");
        out.println(l1 + ":");
        out.println("   ldi r24, 0");
        out.println("   jmp " + l3);
        out.println("   # result is true");
        out.println(l2 + ":");
        out.println("   ldi r24, 1");
        out.println("   # store result of equal expression");
        out.println(l3 + ":");
        out.println("   # push one byte expression onto stack");
        out.println("   push r24");
        out.println("   # load condition and branch if false");
        out.println("   # load a one byte expression off stack");
         out.println("  pop    r24");
        out.println("   #load zero into reg");
        out.println("   ldi    r25, 0");

    }
    public void outNotExp(NotExp node){
        //Not Required for PA3
    }
    public void outTrueExp(TrueLiteral node)
    {
        out.println("   # True/1 expression");
        out.println("   ldi    r22, 1");
        out.println("   # push one byte expression onto stack");
        out.println("   push   r22");
    }
    public void outFalseExp(FalseLiteral node)
    {
        out.println("   # False/0 expression");
        out.println("   ldi    r21, 0");
        out.println("   # push one byte expression onto stack");
        out.println("   push   r21");
    }
    public void visitIfStatement(IfStatement node){
        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        out.println("   #### if statement");
        if(node.getExp() != null){
            node.getExp().accept(this);
        }
        out.println("   #use cp to set SREG");
        out.println("   cp     r24, r25");
        out.println("   #WANT breq " + l2);
        out.println("   brne    " + l2);
        out.println("   jmp    " + l1);
        out.println("   #then label for if");
        out.println(l2 + ":");
        if(node.getThenStatement() != null){
            node.getThenStatement().accept(this);
        }
        out.println("   jmp    " + l3);
        out.println("   # else label for if");
        out.println(l1 + ":");
        if(node.getElseStatement() != null){
            node.getElseStatement().accept(this);
        }
        out.println("    # done label for if");
        out.println(l3 + ":");
    }
    public void visitWhileStatement(WhileStatement node)
    {
        Label l0 = new Label();
        Label l1 = new Label();
        Label l2 = new Label();
        out.println("   #### while statement");
        out.println(l0 + ":");
        if(node.getExp() != null)
        {
            node.getExp().accept(this);
        }
        out.println("   pop    r24");
        out.println("   ldi    r25,0");
        out.println("   cp     r24, r25");
        out.println("   # WANT breq " + l2);
        out.println("   brne  " + l1);
        out.println("   jmp   " + l2);
        out.println("   # while loop body");
        out.println(l1 + ":");
        if(node.getStatement() != null)
        {
            node.getStatement().accept(this);
        }
        out.println("   # jump to while test");
        out.println("   jmp    " + l0);
        out.println("   # end of while");
        out.println(l2 + ":");
    }
    /* */
    public void visitAndExp(AndExp node)
    {
        out.println("   #### short-circuited && operation");
        out.println("   # &&: left operand");
        if(node.getLExp() != null)
        {
            node.getLExp().accept(this);
        }
        Label l0 = new Label();
        Label l1 = new Label();
            
        out.println("   # &&: if left operand is false do not eval right");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r24");
        out.println("   push   r24");
        out.println("   # compare left exp with zero");
        out.println("   ldi r25, 0");
        out.println("   cp    r24, r25");
        out.println("   # Want this, breq " + l0);
        out.println("   brne " + l1);
        out.println("   jmp   " + l0);
        out.println(l1 + ":");
        out.println("  # right operand");
        out.println("  # load a one byte expression off stack");
        out.println("   pop    r24");
        if(node.getRExp() != null)
        {
            node.getRExp().accept(this);
        }
        Label l12 = new Label();
        Label l13 = new Label();
        Label l14 = new Label();
        out.println("   # equality check expression");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r18");
        out.println("   pop    r19");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   cp    r24, r18");
        out.println("   cpc   r25, r19");
        out.println("   breq " + l13);
        out.println("   # result is false");
        out.println(l12 + ":");
        out.println("   ldi r24, 0");
        out.println("   jmp " + l14);
        out.println("   # result is true");
        out.println(l13 + ":");
        out.println("   ldi r24, 1");
        out.println("   # store result of equal expression");
        out.println(l14 + ":");
        out.println("   # push one byte expression onto stack");
        out.println("   push r24");
        out.println("   # load condition and branch if false");
        out.println("   # load a one byte expression off stack");
        out.println("   pop    r24");
        out.println("   #load zero into reg");
        out.println("    ldi    r25, 0");
        out.println(l0 + ":");
    }
    
    public void outNegExp(NegExp node)
    {
        out.println("  # neg int");
        out.println("   # load a two byte expression off stack");
        out.println("   pop    r24");
        out.println("   pop    r25");
        out.println("   ldi     r22, 0");
        out.println("   ldi     r23, 0");
        out.println("   sub     r22, r24");
        out.println("   sbc     r23, r25");
        out.println("   # push two byte expression onto stack");
        out.println("   push   r23");
        out.println("   push   r22");
    }

    // PA4 AVR Stubs
    public void outBoolType(BoolType node) {}
    public void outButtonType(ButtonType node) {}
    public void outByteType(ByteType node) {}
    public void outCallExp(CallExp node) {}
    public void outCallStatement(CallStatement node) {}
    public void outColorType(ColorType node) {}
    public void outFormal(Formal node) {}
    public void outIdLiteral(IdLiteral node) {}
    public void outIntType(IntType node) {}
    public void outLtExp(LtExp node) {}
	
    public void outMeggyToneStart(MeggyToneStart node) 
    {
		out.println("	### Meggy.toneStart(tone, time_ms) call");
		out.println("	# load a two byte expression off stack");
		out.println("	pop    r22");
		out.println("	pop    r23");
		out.println("	# load a two byte expression off stack");
		out.println("	pop    r24");
		out.println("	pop    r25");
		out.println("	call   _Z10Tone_Startjj");
    }
	
    public void outMethodDecl(MethodDecl node) {}
    public void outThisExp(ThisLiteral node) {}
	
    public void outToneExp(ToneLiteral node) 
	{
		String tone = node.getLexeme();
		int toneVal = node.getIntValue();
		out.println("	# Push " + tone + " onto the stack.");
		out.println("	ldi     r25, hi8(" + toneVal + ")");
		out.println("	ldi		r24, lo8(" + toneVal + ")");
		out.println("	# push two byte expression onto stack");
		out.println("	push	r25");
		out.println("	push	r24");
	}
	
    public void outToneType(ToneType node) {}
    public void outTopClassDecl(TopClassDecl node) {}
    public void outVoidType(VoidType node) {}

    public void outProgram(Program node){
        out.flush();
    }
    public void outBlockStatement(BlockStatement node){
        //do nothing
    }
    
}

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
import symtable.*;
public class AVRgenVisitor extends DepthFirstVisitor
{
    private PrintWriter out;
    private SymTable mCurrentST;
    public ClassSTE current_class;
    public int max_offset;
    public AVRgenVisitor(PrintWriter out, SymTable globalST) {
      this.out = out;
      mCurrentST = globalST;
   }
    public void inProgram(Program node)
    {   
        out.println(" .file  \"main.java\" \n __SREG__ = 0x3f \n __SP_H__ = 0x3e \n  __SP_L__ = 0x3d \n __tmp_reg__ = 0 \n __zero_reg__ = 1 \n .global __do_copy_data \n .global __do_clear_bss \n .text \n .global main \n.type   main, @function \n main: \n push r29 \n push r28 \n in r28,__SP_L__ \n in r29,__SP_H__ \n /* prologue: function */ \n call _Z18MeggyJrSimpleSetupv \n /* Need to call this so that the meggy library gets set up */\n\n\n ");
    }

    public void outProgram(Program node)
    {
       //out.println("  \n\n\n /* epilogue start */ \n endLabel:\n jmp endLabel \n ret \n .size   main, .-main ");
       out.flush();
    }
    public void visitAndExp(AndExp node)
    {
	//String a = new Label().toString();
	//String b = new Label().toString();
	//String c = new Label().toString();
	String d = new Label().toString();
	String e = new Label().toString();
	String f = new Label().toString();
	String g = new Label().toString();
	String h = new Label().toString();
        inAndExp(node);
        if(node.getLExp() != null)
        {
            node.getLExp().accept(this);
out.println( "  # if left operand is false do not eval right \n # load a one byte expression off stack \n pop    r24 \n # push one byte expression onto stack \n push   r24 \n # compare left exp with zero \n ldi r25, 0 \n cp    r24, r25 \n # Want this, breq  \n brne  "+e+" \n jmp   "+d );
        }
        if(node.getRExp() != null)
        {
	    out.println(e +": \n #right operand \n # load a one byte expression off stack \n pop    r24");
            node.getRExp().accept(this);
	    out.println(" # push one byte expression onto stack \n push   r22 \n # load a one byte expression off stack \n  pop    r24 \n # push one byte expression onto stack \n push   r24 \n "+d+": ");
        }
        outAndExp(node);
    }
   public void outAndExp(AndExp node)
   {
     
   }
  
   public void outPlusExp(PlusExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	String d = new Label().toString();
	boolean lexp1 = node.getLExp() instanceof IntLiteral;
	boolean lexp2 = node.getLExp() instanceof ByteCast;
        boolean rexp1 = node.getRExp() instanceof IntLiteral;
	boolean rexp2 = node.getRExp() instanceof ByteCast;
	 if ( lexp2 && rexp2 )
          {
		out.println("  # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+a+" \n ldi    r25, 0 \n jmp    "+b+" \n "+a+": \n ldi    r25, hi8(-1) \n "+b+": \n # promoting a byte to an int \n tst     r18 \n brlt     "+c+" \n ldi    r19, 0 \n jmp    "+d+" \n "+c+": \n ldi    r19, hi8(-1) \n "+d+": \n # Do add operation \n add    r24, r18 \n adc    r25, r19 \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
	  }
	else if (lexp1 && rexp2)
	{
		out.println("# load a one byte expression off stack \n pop    r18 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # promoting a byte to an int \n tst     r18 \n brlt     "+a+" \n ldi    r19, 0 \n jmp    "+b+" \n "+a+": \n ldi    r19, hi8(-1) \n "+b+": \n # Do add operation \n add    r24, r18 \n adc    r25, r19 \n # push two byte expression onto stack \n push   r25 \n push   r24");
	}
	else if (lexp2 && rexp1)
	{
		out.println("  # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+a+" \n ldi    r25, 0 \n jmp    "+b+" \n "+a+": \n ldi    r25, hi8(-1) \n "+b+": \n # Do add operation \n add    r24, r18 \n adc    r25, r19 \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
	}
	else
	{
       out.println(" # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # Do add operation \n add    r24, r18 \n adc    r25, r19 \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
  	} 
  }

   public void outEqualExp(EqualExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	String d = new Label().toString();
	String e = new Label().toString();
	boolean lexp1 = node.getLExp() instanceof IntLiteral;
	boolean lexp2 = node.getLExp() instanceof ByteCast;
        boolean rexp1 = node.getRExp() instanceof IntLiteral;
	boolean rexp2 = node.getRExp() instanceof ByteCast;
	boolean lexp3 = node.getLExp() instanceof ColorLiteral;
	boolean rexp3 = node.getRExp() instanceof ColorLiteral;
	Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
	 if ( lexp2 && rexp2  )
          {
		out.println("  # equality check expression \n # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r24 \n cp    r24, r18 \n breq "+b+" \n # result is false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # result is true \n "+b+": \n ldi     r24, 1 \n # store result of equal expression \n "+c+": \n # push one byte expression onto stack \n push   r24 ");
	  }
	else if ( lexp1 && rexp2  )
	{
		out.println("   # equality check expression \n # load a one byte expression off stack \n pop    r18 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # promoting a byte to an int \n tst     r18 \n brlt     "+d+" \n ldi    r19, 0 \n jmp    "+e+" \n "+d+": \n ldi    r19, hi8(-1) \n "+e+": \n cp    r24, r18 \n cpc   r25, r19 \n breq "+b+" \n # result is false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # result is true \n "+b+": \n ldi     r24, 1 \n # store result of equal expression \n "+c+": \n # push one byte expression onto stack \n push   r24 ");
	}
	else if ( lexp2 && rexp1  )
	{
		out.println(" # equality check expression \n # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+b+" \n ldi    r25, 0 \n jmp    "+e+" \n "+d+": \n ldi    r25, hi8(-1) \n "+e+": \n cp    r24, r18 \n cpc   r25, r19 \n breq "+b+" \n # result is false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # result is true \n "+b+": \n ldi     r24, 1 \n # store result of equal expression \n "+c+": \n # push one byte expression onto stack \n push   r24 ");
	}
	else if ( lexp3 || rexp3)
	{
		out.println(" # equality check expression \n # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r24 \n cp    r24, r18 \n breq "+b+" \n # result is false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # result is true \n "+b+": \n ldi     r24, 1 \n  # store result of equal expression \n "+c+": \n # push one byte expression onto stack \n push   r24 ");
	}
	else
	{
      out.println(" # equality check expression \n # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n cp    r24, r18 \n cpc   r25, r19 \n breq " + b +" \n # result is false \n " + a +": \n ldi     r24, 0 \n jmp      " + c +" \n # result is true \n " + b +": \n ldi     r24, 1 \n # store result of equal expression \n " + c +": \n # push one byte expression onto stack \n push   r24 \n ");
	}
   }
   public void inIdLiteral(IdLiteral node)
    {
       
    }

    public void outIdLiteral(IdLiteral node)
    {
	VarSTE var_ste = (VarSTE)mCurrentST.lookup(node.getLexeme());
        out.println("# IdExp0 \n  # load value for variable a \n # variable is a local or param variable \n # load a one byte variable from base+offset \n ldd    r24, Y + "+var_ste.mOffset+" \n # push one byte expression onto stack \n push   r24");
    }
   public void outLtExp(LtExp node)
    {
        String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	String d = new Label().toString();
	String e = new Label().toString();
	boolean lexp1 = node.getLExp() instanceof IntLiteral;
	boolean lexp2 = node.getLExp() instanceof ByteCast;
        boolean rexp1 = node.getRExp() instanceof IntLiteral;
	boolean rexp2 = node.getRExp() instanceof ByteCast;
	boolean lexp3 = node.getLExp() instanceof ColorLiteral;
	boolean rexp3 = node.getRExp() instanceof ColorLiteral;
	 if ( lexp2 && rexp2  )
          {
		out.println(" # less than expression \n # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r24 \n cp    r24, r18 \n brlt "+b+" \n # load false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # load true \n "+b+": \n ldi    r24, 1 \n # push result of less than \n "+c+": \n # push one byte expression onto stack \n push   r24");
	  }
	else if ( lexp1 && rexp2  )
	{
		out.println(" # less than expression \n # load a one byte expression off stack \n pop    r18 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # promoting a byte to an int \n tst     r18 \n brlt     "+d+" \n ldi    r19, 0 \n jmp    "+e+" \n "+d+": \n ldi    r19, hi8(-1) \n "+e+": \n cp    r24, r18 \n cpc   r25, r19 \n brlt "+b+" \n # load false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # load true \n "+b+": \n ldi    r24, 1 \n # push result of less than \n "+c+": \n # push one byte expression onto stack \n push   r24");
	}
	else if ( lexp2 && rexp1  )
	{
		out.println(" # less than expression \n # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+d+" \n ldi    r25, 0 \n jmp    "+e+" \n "+d+": \n ldi    r25, hi8(-1) \n "+e+": \n cp    r24, r18 \n cpc   r25, r19 \n brlt "+b+" \n # load false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # load true \n "+b+": \n ldi    r24, 1 \n # push result of less than \n "+c+": \n # push one byte expression onto stack \n push   r24");
	}
	else
	{
      		out.println("# less than expression \n # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n cp    r24, r18 \n cpc   r25, r19 \n brlt "+ b +" \n # load false \n "+a+": \n ldi     r24, 0 \n jmp      "+c+" \n # load true \n "+b+": \n ldi    r24, 1 \n # push result of less than \n "+c+": \n # push one byte expression onto stack \n push   r24");
	}
    }
   public void outMinusExp(MinusExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	String d = new Label().toString();
	
	boolean lexp1 = node.getLExp() instanceof IntLiteral;
	boolean lexp2 = node.getLExp() instanceof ByteCast;
        boolean rexp1 = node.getRExp() instanceof IntLiteral;
	boolean rexp2 = node.getRExp() instanceof ByteCast;
       if ( lexp2 && rexp2)
          {
              out.println("  # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+a+" \n ldi    r25, 0 \n jmp    "+b+" \n "+a+": \n ldi    r25, hi8(-1) \n "+b+": \n # promoting a byte to an int \n tst     r18 \n brlt     "+c+" \n ldi    r19, 0 \n jmp    "+d+" \n "+c+": \n ldi    r19, hi8(-1) \n "+d+":  ");
	       out.println("# Do INT sub operation \n sub    r24, r18 \n sbc    r25, r19 \n # push hi order byte first \n # push two byte expression onto stack \n push   r25 \n push   r24");
    }
	else if ( lexp1 && rexp2)
	{
		out.println(" # load a one byte expression off stack \n pop    r18 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # promoting a byte to an int \n tst     r18 \n brlt     "+a+" \n ldi    r19, 0 \n jmp    "+b+" \n "+a+": \n ldi    r19, hi8(-1) \n "+b+": \n # Do INT sub operation \n sub    r24, r18 \n sbc    r25, r19 \n # push hi order byte first \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
	}
	else if ( lexp2 && rexp1)
	{
		out.println(" # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+a+" \n ldi    r25, 0 \n jmp    "+b+" \n "+a+": \n ldi    r25, hi8(-1) \n "+b+": \n # Do INT sub operation \n sub    r24, r18 \n sbc    r25, r19 \n # push hi order byte first \n # push two byte expression onto stack \n push   r25 \n push   r24");
	}
	else
	{
      out.println("  # load a two byte expression off stack \n pop    r18 \n pop    r19 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n # Do INT sub operation \n sub    r24, r18 \n sbc    r25, r19 \n # push hi order byte first \n # push two byte expression onto stack \n push   r25 \n push   r24 ");
	}
   }

   public void outMulExp(MulExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	String d = new Label().toString();
	Type lexpType = this.mCurrentST.getExpType(node.getLExp());
       Type rexpType = this.mCurrentST.getExpType(node.getRExp());
       out.println("  # MulExp \n # load a one byte expression off stack \n pop    r18 \n # load a one byte expression off stack \n pop    r22 \n # move low byte src into dest reg \n mov    r24, r18 \n # move low byte src into dest reg \n mov    r26, r22 \n # Do mul operation of two input bytes \n muls   r24, r26 \n # push two byte expression onto stack \n push   r1 \n push   r0 \n # clear r0 and r1, thanks Brendan! \n eor    r0,r0 \n eor    r1,r1 ");
   }
   public void inTopClassDecl(TopClassDecl node)
    {
        String class_name = node.getName();
	STE ste = mCurrentST.lookup(class_name);
	
	
	current_class = (ClassSTE)ste;
	if(current_class != null)
	{
	this.mCurrentST.mStackScope.push(current_class.mScope);
	}
    }

    public void outTopClassDecl(TopClassDecl node)
    {
        mCurrentST.popScope();
    }
    public void inMethodDecl(MethodDecl node)
    {
        MethodSTE method_ste = (MethodSTE)mCurrentST.lookup(node.getName());
	max_offset=0;
	int r_value = 24;
	mCurrentST.mStackScope.push(method_ste.mScope);
	out.println("/* epilogue start */ \n endLabel: \n jmp endLabel \n ret \n .size   main, .-main");
	out.println(" .text \n .global _"+node.getName() +" \n .type  _"+node.getName() +", @function \n "+node.getName() +": \n push   r29 \n push   r28 \n # make space for locals and params \n ldi    r30, 0 \n");
		Iterator iterator = method_ste.mScope.scope_list.iterator();
		while(iterator.hasNext())
		{
			VarSTE ste = (VarSTE)method_ste.mScope.lookup((String)iterator.next());
            		if (!(ste instanceof VarSTE)) continue;
            		if(max_offset < ste.mOffset)
			{ max_offset = ste.mOffset; }
		}
		for(int i =0; i< max_offset; i++)
		{
			out.println(" push   r30 ");
		}
		out.println(" # Copy stack pointer to frame pointer \n in     r28,__SP_L__ \n in     r29,__SP_H__ \n # save off parameters \n ");
		iterator = method_ste.mScope.scope_list.iterator();
		out.println("std Y + 2, r25");
		while(iterator.hasNext())
		{
			VarSTE ste = (VarSTE)method_ste.mScope.lookup((String)iterator.next());
			out.println("std Y + "+ste.mOffset+", r"+ r_value);
			r_value = r_value -2;
			
		}

		out.println("/* done with function s"+ current_class.mName +"_"+node.getName() +" prologue */");
    }

    public void outMethodDecl(MethodDecl node)
    {
        mCurrentST.popScope();
	MethodSTE method_ste = (MethodSTE)mCurrentST.lookup(node.getName());
	out.println("/* epilogue start for sampletest2_testfun1 */ \n # no return value \n # pop space off stack for parameters and locals");
	for(int i =0; i< max_offset; i++)
	{
			out.println(" pop   r30 ");
	}
    	out.println("# restoring the frame pointer \n pop    r28 \n pop    r29 \n ret \n .size "+ node.getName() +", .- _"+node.getName());
    }
    public void outNewExp(NewExp node)
    {
     	out.println("# NewExp \n ldi    r24, lo8(0) \n ldi    r25, hi8(0) \n # allocating object of size 0 on heap \n call    malloc \n # push object address \n # push two byte expression onto stack \n push   r25 \n push   r24");  
    }
     public void inCallStatement(CallStatement node)
    {
        defaultIn(node);
    }

    public void outCallStatement(CallStatement node)
    {
	int r_value = 20;
	//Parameter values 
	IExp exp = node.getExp();
	String id = node.getId();
	//System.out.println(id);
	MethodSTE method_ste = mCurrentST.map.get(id);
        Signature sig_obj = method_ste.mSignature; 
	ListIterator<Type> iterator = sig_obj.formal_parameters.listIterator();
	out.println("#### function call \n # put parameter values into appropriate registers");
	while(iterator.hasNext())
	{
		if(iterator.next().getAVRTypeSize() == 2 )
		{
			out.println("# load two byte expression off stack");
			out.println("pop r"+r_value);
			r_value++;
			out.println("pop r"+r_value);
			r_value++;
		}
		else 
		{
			out.println("# load a one byte expression off stack");
			out.println("pop r"+r_value);
			r_value = r_value + 2;
		}
		/*else
		{
			out.println("# load two byte expression off stack");
			out.println("pop "+r_value);
			r_value++;
			out.println("pop "+r_value);
			r_value++;
		}*/
	}
	//LinkedList<IExp> list = node.getArgs();
	out.println("");
	
        out.println(" # receiver will be passed as first param \n # load a two byte expression off stack \n pop    r24 \n pop    r25");
	out.println("call      "+ id);
    }

   public void outNegExp(NegExp node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	boolean byte_lit = node.getExp() instanceof ByteCast;
	boolean int_lit = node.getExp() instanceof IntLiteral;
	boolean minus_lit = node.getExp() instanceof MinusExp;
	boolean plus_lit = node.getExp() instanceof PlusExp;
	boolean mul_lit = node.getExp() instanceof MulExp;
	boolean neg_lit = node.getExp() instanceof NegExp;
	if(byte_lit)
	{
		out.println(" # neg byte \n # load a one byte expression off stack \n pop    r24 \n # promoting a byte to an int \n tst     r24 \n brlt     "+a+" \n ldi    r25, 0 \n jmp    "+b+" \n "+a+": \n ldi    r25, hi8(-1) \n "+b+": \n ldi    r22, 0 \n ldi    r23, 0 \n sub     r22, r24 \n sbc     r23, r25 \n # push two byte expression onto stack \n push   r23 \n push   r22");
	}
	if(int_lit)
	{
       out.println(" # neg int \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n ldi     r22, 0 \n ldi     r23, 0 \n sub     r22, r24 \n sbc     r23, r25 \n # push two byte expression onto stack \n push   r23 \n push   r22 ");
	}
   }

   public void outNotExp(NotExp node)
   {
       out.println("  # not operation \n # load a one byte expression off stack \n pop    r24 \n ldi     r22, 1 \n eor     r24,r22 \n # push one byte expression onto stack \n push   r24  ");
   }

   public void outMeggySetPixel(MeggySetPixel node)
   {
     
      out.println(" ### Meggy.setPixel(x,y,color) call \n # load a one byte expression off stack \n pop    r20 \n # load a one byte expression off stack \n pop    r22 \n # load a one byte expression off stack \n pop    r24 \n call   _Z6DrawPxhhh \n call   _Z12DisplaySlatev ");
   }
   public void outMeggyToneStart(MeggyToneStart node)
    {
        out.println("### Meggy.toneStart(tone, time_ms) call \n # load a two byte expression off stack \n pop    r22 \n pop    r23 \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n call   _Z10Tone_Startjj");
    }
   public void outMeggyCheckButton(MeggyCheckButton node)
   {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	ButtonLiteral button = (ButtonLiteral)node.getExp();
	String button_name = "";
	
	int value = button.getIntValue();
	switch(value){
	case 1:
		button_name = "Button_B";
	break;
	case 2:
		button_name = "Button_A";
	break;
	case 4:
		button_name = "Button_Up";
	break;
	case 8:
		button_name = "Button_Down";
	break;
	case 16:
		button_name = "Button_Left";
	break;
	case 32:
		button_name = "Button_Right";
	break;
	}
      out.println("  ### MeggyCheckButton \n call    _Z16CheckButtonsDownv \n lds    r24, "+button_name+" \n # if button value is zero, push 0 else push 1 \n tst    r24 \n breq   "+a+" \n "+b+":  \n ldi    r24, 1 \n jmp    "+c+" \n "+a+": \n "+c+": \n # push one byte expression onto stack \n push   r24 ");
   }

   public void outMeggyDelay(MeggyDelay node)
   {
        out.println(" ### Meggy.delay() call \n # load delay parameter \n # load a two byte expression off stack \n pop    r24 \n pop    r25 \n call   _Z8delay_msj \n ");
   }

   public void outByteCast(ByteCast node)
   {
	//Type expType = this.mCurrentST.getExpType(node.getExp());
	boolean int_lit = node.getExp() instanceof IntLiteral;
	boolean minus_lit = node.getExp() instanceof MinusExp;
	boolean plus_lit = node.getExp() instanceof PlusExp;
	boolean mul_lit = node.getExp() instanceof MulExp;
	boolean neg_lit = node.getExp() instanceof NegExp;
	if(int_lit || minus_lit || plus_lit || mul_lit || neg_lit)
	{
       out.print("  # Casting int to byte by popping \n # 2 bytes off stack and only pushing low order bits \n # back on.  Low order bits are on top of stack. \n pop    r24 \n pop    r25 \n push   r24 \n");
	}
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
	   
	    out.println(b + ":");
            node.getThenStatement().accept(this);
	    out.println("jmp " + c);
        }
	out.println(a + ":");
        if(node.getElseStatement() != null)
        {
	     
	   // out.println(b + ":");
            node.getElseStatement().accept(this);
	    out.println("jmp " + c);
        }
	out.println(c + ":");
        outIfStatement(node);
    }

   public void outIfStatement(IfStatement node) 
   {
	
   }

    public void visitWhileStatement(WhileStatement node)
    {
	String a = new Label().toString();
	String b = new Label().toString();
	String c = new Label().toString();
	
        inWhileStatement(node);
        if(node.getExp() != null)
        {
	    out.println(a + ":");
            node.getExp().accept(this);
        }
	out.println(" # if not(condition) \n # load a one byte expression off stack \n pop    r24 \n ldi    r25,0 \n cp     r24, r25 \n# WANT breq  \n brne   "+ b +" \n jmp  "+ c);
        if(node.getStatement() != null)
        {
	    out.println(b + ":");
            node.getStatement().accept(this);
        }
	out.println(" # jump to while test \n jmp   " + a);
	out.println(c + ":");
        outWhileStatement(node);
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
         out.println("  # Color expression  \n ldi    r22," + node.getIntValue() + " \n  # push one byte expression onto stack \n push   r22 ");
    }
    public void outToneExp(ToneLiteral node)
    {
        out.println("# Push Meggy.Tone.C3 onto the stack. \n ldi    r25, hi8("+ node.getIntValue() +") \n ldi    r24, lo8("+ node.getIntValue() +") \n # push two byte expression onto stack \n push   r25 \n push   r24");
    }
    public void outTrueExp(TrueLiteral node)
    {
        out.println(" # True/1 expression \n ldi    r22, 1 \n # push one byte expression onto stack \n push   r22 ");
    }
     public void outFalseExp(FalseLiteral node)
    {
        out.println("  # False/0 expression \n ldi    r24,0 \n # push one byte expression onto stack \n push   r24  ");
    }
    public void outMeggyGetPixel(MeggyGetPixel node)
    {
        out.println("  ### Meggy.getPixel(x,y) call \n # load a one byte expression off stack \n pop    r22 \n # load a one byte expression off stack \n pop    r24 \n call   _Z6ReadPxhh \n # push one byte expression onto stack \n push   r24 ");
    }
 


}

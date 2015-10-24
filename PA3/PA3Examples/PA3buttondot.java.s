 .file  "main.java" 
 __SREG__ = 0x3f 
 __SP_H__ = 0x3e 
  __SP_L__ = 0x3d 
 __tmp_reg__ = 0 
 __zero_reg__ = 1 
 .global __do_copy_data 
 .global __do_clear_bss 
 .text 
 .global main 
.type   main, @function 
 main: 
 push r29 
 push r28 
 in r28,__SP_L__ 
 in r29,__SP_H__ 
 /* prologue: function */ 
 call _Z18MeggyJrSimpleSetupv 
 /* Need to call this so that the meggy library gets set up */


 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,2 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
MJ_L0:
 # True/1 expression 
 ldi    r22, 1 
 # push one byte expression onto stack 
 push   r22 
 # if not(condition) 
 # load a one byte expression off stack 
 pop    r24 
 ldi    r25,0 
 cp     r24, r25 
# WANT breq  
 brne   MJ_L1 
 jmp  MJ_L2
MJ_L1:
  ### MeggyCheckButton 
 call    _Z16CheckButtonsDownv 
 lds    r24, Button_A 
 # if button value is zero, push 0 else push 1 
 tst    r24 
 breq   MJ_L6 
 MJ_L7:  
 ldi    r24, 1 
 jmp    MJ_L8 
 MJ_L6: 
 MJ_L8: 
 # push one byte expression onto stack 
 push   r24 
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L4 
 jmp    MJ_L3
MJ_L4:
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,6 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
jmp MJ_L5
MJ_L3:
  ### MeggyCheckButton 
 call    _Z16CheckButtonsDownv 
 lds    r24, Button_B 
 # if button value is zero, push 0 else push 1 
 tst    r24 
 breq   MJ_L12 
 MJ_L13:  
 ldi    r24, 1 
 jmp    MJ_L14 
 MJ_L12: 
 MJ_L14: 
 # push one byte expression onto stack 
 push   r24 
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L10 
 jmp    MJ_L9
MJ_L10:
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,4 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
jmp MJ_L11
MJ_L9:
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,2 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # Color expression  
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 ### Meggy.setPixel(x,y,color) call 
 # load a one byte expression off stack 
 pop    r20 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6DrawPxhhh 
 call   _Z12DisplaySlatev 
jmp MJ_L11
MJ_L11:
jmp MJ_L5
MJ_L5:
  # Load constant int  
 ldi    r24,lo8(100) 
 ldi    r25,hi8(100) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 ### Meggy.delay() call 
 # load delay parameter 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 call   _Z8delay_msj 
 
 # jump to while test 
 jmp   MJ_L0
MJ_L2:
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

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
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do add operation 
 add    r24, r18 
 adc    r25, r19 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(1024) 
 ldi    r25,hi8(1024) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L8 
 # result is false 
 MJ_L7: 
 ldi     r24, 0 
 jmp      MJ_L9 
 # result is true 
 MJ_L8: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L9: 
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
 brne  MJ_L1 
 jmp    MJ_L0
MJ_L1:
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
jmp MJ_L2
MJ_L0:
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r22,1 
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
jmp MJ_L2
MJ_L2:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
# load a one byte expression off stack 
 pop    r18 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # promoting a byte to an int 
 tst     r18 
 brlt     MJ_L15 
 ldi    r19, 0 
 jmp    MJ_L16 
 MJ_L15: 
 ldi    r19, hi8(-1) 
 MJ_L16: 
 # Do add operation 
 add    r24, r18 
 adc    r25, r19 
 # push two byte expression onto stack 
 push   r25 
 push   r24
  # Load constant int  
 ldi    r24,lo8(5) 
 ldi    r25,hi8(5) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L20 
 # result is false 
 MJ_L19: 
 ldi     r24, 0 
 jmp      MJ_L21 
 # result is true 
 MJ_L20: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L21: 
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
 brne  MJ_L13 
 jmp    MJ_L12
MJ_L13:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
jmp MJ_L14
MJ_L12:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r22,1 
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
jmp MJ_L14
MJ_L14:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L27 
 ldi    r25, 0 
 jmp    MJ_L28 
 MJ_L27: 
 ldi    r25, hi8(-1) 
 MJ_L28: 
 # Do add operation 
 add    r24, r18 
 adc    r25, r19 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(5) 
 ldi    r25,hi8(5) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L32 
 # result is false 
 MJ_L31: 
 ldi     r24, 0 
 jmp      MJ_L33 
 # result is true 
 MJ_L32: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L33: 
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
 brne  MJ_L25 
 jmp    MJ_L24
MJ_L25:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
jmp MJ_L26
MJ_L24:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r22,1 
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
jmp MJ_L26
MJ_L26:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do add operation 
 add    r24, r18 
 adc    r25, r19 
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
 ldi    r24,lo8(5) 
 ldi    r25,hi8(5) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # equality check expression 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 cp    r24, r18 
 breq MJ_L44 
 # result is false 
 MJ_L43: 
 ldi     r24, 0 
 jmp      MJ_L45 
 # result is true 
 MJ_L44: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L45: 
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
 brne  MJ_L37 
 jmp    MJ_L36
MJ_L37:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
jmp MJ_L38
MJ_L36:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r22,1 
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
jmp MJ_L38
MJ_L38:
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(1024) 
 ldi    r25,hi8(1024) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L60 
 # result is false 
 MJ_L59: 
 ldi     r24, 0 
 jmp      MJ_L61 
 # result is true 
 MJ_L60: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L61: 
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
 brne  MJ_L49 
 jmp    MJ_L48
MJ_L49:
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
jmp MJ_L50
MJ_L48:
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r22,1 
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
jmp MJ_L50
MJ_L50:
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
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L67 
 ldi    r25, 0 
 jmp    MJ_L68 
 MJ_L67: 
 ldi    r25, hi8(-1) 
 MJ_L68: 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24
  # Load constant int  
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(544) 
 ldi    r25,hi8(544) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L76 
 # result is false 
 MJ_L75: 
 ldi     r24, 0 
 jmp      MJ_L77 
 # result is true 
 MJ_L76: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L77: 
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
 brne  MJ_L65 
 jmp    MJ_L64
MJ_L65:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
jmp MJ_L66
MJ_L64:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r22,1 
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
jmp MJ_L66
MJ_L66:
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
 # load a one byte expression off stack 
 pop    r18 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # promoting a byte to an int 
 tst     r18 
 brlt     MJ_L83 
 ldi    r19, 0 
 jmp    MJ_L84 
 MJ_L83: 
 ldi    r19, hi8(-1) 
 MJ_L84: 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(544) 
 ldi    r25,hi8(544) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L92 
 # result is false 
 MJ_L91: 
 ldi     r24, 0 
 jmp      MJ_L93 
 # result is true 
 MJ_L92: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L93: 
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
 brne  MJ_L81 
 jmp    MJ_L80
MJ_L81:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
jmp MJ_L82
MJ_L80:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r22,1 
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
jmp MJ_L82
MJ_L82:
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
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L99 
 ldi    r25, 0 
 jmp    MJ_L100 
 MJ_L99: 
 ldi    r25, hi8(-1) 
 MJ_L100: 
 # promoting a byte to an int 
 tst     r18 
 brlt     MJ_L101 
 ldi    r19, 0 
 jmp    MJ_L102 
 MJ_L101: 
 ldi    r19, hi8(-1) 
 MJ_L102:  
# Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
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
 ldi    r24,lo8(512) 
 ldi    r25,hi8(512) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(544) 
 ldi    r25,hi8(544) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 # Do INT sub operation 
 sub    r24, r18 
 sbc    r25, r19 
 # push hi order byte first 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  # equality check expression 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 cp    r24, r18 
 breq MJ_L108 
 # result is false 
 MJ_L107: 
 ldi     r24, 0 
 jmp      MJ_L109 
 # result is true 
 MJ_L108: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L109: 
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
 brne  MJ_L97 
 jmp    MJ_L96
MJ_L97:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
jmp MJ_L98
MJ_L96:
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 ldi    r22,1 
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
jmp MJ_L98
MJ_L98:
  # Load constant int  
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
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
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L116 
 ldi    r25, 0 
 jmp    MJ_L119 
 MJ_L118: 
 ldi    r25, hi8(-1) 
 MJ_L119: 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L116 
 # result is false 
 MJ_L115: 
 ldi     r24, 0 
 jmp      MJ_L117 
 # result is true 
 MJ_L116: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L117: 
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
 brne  MJ_L113 
 jmp    MJ_L112
MJ_L113:
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
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
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
jmp MJ_L114
MJ_L112:
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
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
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
 ldi    r22,1 
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
jmp MJ_L114
MJ_L114:
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
  ### Meggy.getPixel(x,y) call 
 # load a one byte expression off stack 
 pop    r22 
 # load a one byte expression off stack 
 pop    r24 
 call   _Z6ReadPxhh 
 # push one byte expression onto stack 
 push   r24 
  # Color expression  
 ldi    r22,4 
  # push one byte expression onto stack 
 push   r22 
 # equality check expression 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 cp    r24, r18 
 breq MJ_L124 
 # result is false 
 MJ_L123: 
 ldi     r24, 0 
 jmp      MJ_L125 
 # result is true 
 MJ_L124: 
 ldi     r24, 1 
  # store result of equal expression 
 MJ_L125: 
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
 brne  MJ_L121 
 jmp    MJ_L120
MJ_L121:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
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
jmp MJ_L122
MJ_L120:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
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
 ldi    r22,1 
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
jmp MJ_L122
MJ_L122:
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

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
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 brlt     MJ_L3 
 ldi    r25, 0 
 jmp    MJ_L4 
 MJ_L3: 
 ldi    r25, hi8(-1) 
 MJ_L4: 
 # Do add operation 
 add    r24, r18 
 adc    r25, r19 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
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
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # neg int 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 ldi     r22, 0 
 ldi     r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22 
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
  # MulExp 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r22 
 # move low byte src into dest reg 
 mov    r24, r18 
 # move low byte src into dest reg 
 mov    r26, r22 
 # Do mul operation of two input bytes 
 muls   r24, r26 
 # push two byte expression onto stack 
 push   r1 
 push   r0 
 # clear r0 and r1, thanks Brendan! 
 eor    r0,r0 
 eor    r1,r1 
  # Load constant int  
 ldi    r24,lo8(6) 
 ldi    r25,hi8(6) 
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
jmp MJ_L26
MJ_L24:
MJ_L26:
jmp MJ_L14
MJ_L12:
MJ_L14:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # neg int 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 ldi     r22, 0 
 ldi     r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22 
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
  # MulExp 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r22 
 # move low byte src into dest reg 
 mov    r24, r18 
 # move low byte src into dest reg 
 mov    r26, r22 
 # Do mul operation of two input bytes 
 muls   r24, r26 
 # push two byte expression onto stack 
 push   r1 
 push   r0 
 # clear r0 and r1, thanks Brendan! 
 eor    r0,r0 
 eor    r1,r1 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
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
 breq MJ_L56 
 # result is false 
 MJ_L55: 
 ldi     r24, 0 
 jmp      MJ_L57 
 # result is true 
 MJ_L56: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L57: 
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
MJ_L50:
jmp MJ_L38
MJ_L36:
MJ_L38:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # neg int 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 ldi     r22, 0 
 ldi     r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22 
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(3) 
 ldi    r25,hi8(3) 
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
 # equality check expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L68 
 # result is false 
 MJ_L67: 
 ldi     r24, 0 
 jmp      MJ_L69 
 # result is true 
 MJ_L68: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L69: 
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
 brne  MJ_L61 
 jmp    MJ_L60
MJ_L61:
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
  # MulExp 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r22 
 # move low byte src into dest reg 
 mov    r24, r18 
 # move low byte src into dest reg 
 mov    r26, r22 
 # Do mul operation of two input bytes 
 muls   r24, r26 
 # push two byte expression onto stack 
 push   r1 
 push   r0 
 # clear r0 and r1, thanks Brendan! 
 eor    r0,r0 
 eor    r1,r1 
  # Load constant int  
 ldi    r24,lo8(6) 
 ldi    r25,hi8(6) 
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
 breq MJ_L80 
 # result is false 
 MJ_L79: 
 ldi     r24, 0 
 jmp      MJ_L81 
 # result is true 
 MJ_L80: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L81: 
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
 brne  MJ_L73 
 jmp    MJ_L72
MJ_L73:
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
jmp MJ_L74
MJ_L72:
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
jmp MJ_L74
MJ_L74:
jmp MJ_L62
MJ_L60:
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
jmp MJ_L62
MJ_L62:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 # neg int 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 ldi     r22, 0 
 ldi     r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22 
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
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
 brne  MJ_L85 
 jmp    MJ_L84
MJ_L85:
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
  # MulExp 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r22 
 # move low byte src into dest reg 
 mov    r24, r18 
 # move low byte src into dest reg 
 mov    r26, r22 
 # Do mul operation of two input bytes 
 muls   r24, r26 
 # push two byte expression onto stack 
 push   r1 
 push   r0 
 # clear r0 and r1, thanks Brendan! 
 eor    r0,r0 
 eor    r1,r1 
  # Load constant int  
 ldi    r24,lo8(7) 
 ldi    r25,hi8(7) 
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
 breq MJ_L104 
 # result is false 
 MJ_L103: 
 ldi     r24, 0 
 jmp      MJ_L105 
 # result is true 
 MJ_L104: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L105: 
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
jmp MJ_L98
MJ_L96:
  # Load constant int  
 ldi    r24,lo8(2) 
 ldi    r25,hi8(2) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(1) 
 ldi    r25,hi8(1) 
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
 breq MJ_L112 
 # result is false 
 MJ_L111: 
 ldi     r24, 0 
 jmp      MJ_L113 
 # result is true 
 MJ_L112: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L113: 
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
 brne  MJ_L109 
 jmp    MJ_L108
MJ_L109:
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
jmp MJ_L110
MJ_L108:
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
jmp MJ_L110
MJ_L110:
jmp MJ_L98
MJ_L98:
jmp MJ_L86
MJ_L84:
MJ_L86:
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

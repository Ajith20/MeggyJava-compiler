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
 breq MJ_L11 
 # result is false 
 MJ_L10: 
 ldi     r24, 0 
 jmp      MJ_L12 
 # result is true 
 MJ_L11: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L12: 
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
  # Load constant int  
 ldi    r24,lo8(10) 
 ldi    r25,hi8(10) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Load constant int  
 ldi    r24,lo8(5) 
 ldi    r25,hi8(5) 
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
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
 # neg byte 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L21 
 ldi    r25, 0 
 jmp    MJ_L22 
 MJ_L21: 
 ldi    r25, hi8(-1) 
 MJ_L22: 
 ldi    r22, 0 
 ldi    r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
 # neg byte 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L24 
 ldi    r25, 0 
 jmp    MJ_L25 
 MJ_L24: 
 ldi    r25, hi8(-1) 
 MJ_L25: 
 ldi    r22, 0 
 ldi    r23, 0 
 sub     r22, r24 
 sbc     r23, r25 
 # push two byte expression onto stack 
 push   r23 
 push   r22
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
 brne  MJ_L16 
 jmp    MJ_L15
MJ_L16:
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
jmp MJ_L17
MJ_L15:
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
jmp MJ_L17
MJ_L17:
  # Load constant int  
 ldi    r24,lo8(4) 
 ldi    r25,hi8(4) 
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
 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a one byte expression off stack 
 pop    r24 
 # promoting a byte to an int 
 tst     r24 
 brlt     MJ_L42 
 ldi    r25, 0 
 jmp    MJ_L43 
 MJ_L42: 
 ldi    r25, hi8(-1) 
 MJ_L43: 
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
 breq MJ_L47 
 # result is false 
 MJ_L46: 
 ldi     r24, 0 
 jmp      MJ_L48 
 # result is true 
 MJ_L47: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L48: 
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
jmp MJ_L38
MJ_L36:
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
jmp MJ_L38
MJ_L38:
  # Load constant int  
 ldi    r24,lo8(6) 
 ldi    r25,hi8(6) 
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
 ldi    r24,lo8(5) 
 ldi    r25,hi8(5) 
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
 breq MJ_L65 
 # result is false 
 MJ_L64: 
 ldi     r24, 0 
 jmp      MJ_L66 
 # result is true 
 MJ_L65: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L66: 
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
 brne  MJ_L52 
 jmp    MJ_L51
MJ_L52:
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
jmp MJ_L53
MJ_L51:
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
jmp MJ_L53
MJ_L53:
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
 breq MJ_L77 
 # result is false 
 MJ_L76: 
 ldi     r24, 0 
 jmp      MJ_L78 
 # result is true 
 MJ_L77: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L78: 
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
 brne  MJ_L70 
 jmp    MJ_L69
MJ_L70:
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
jmp MJ_L71
MJ_L69:
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
jmp MJ_L71
MJ_L71:
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
 brlt     MJ_L84 
 ldi    r19, 0 
 jmp    MJ_L85 
 MJ_L84: 
 ldi    r19, hi8(-1) 
 MJ_L85: 
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
 breq MJ_L89 
 # result is false 
 MJ_L88: 
 ldi     r24, 0 
 jmp      MJ_L90 
 # result is true 
 MJ_L89: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L90: 
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
 brne  MJ_L82 
 jmp    MJ_L81
MJ_L82:
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
jmp MJ_L83
MJ_L81:
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
jmp MJ_L83
MJ_L83:
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
 brlt     MJ_L96 
 ldi    r25, 0 
 jmp    MJ_L97 
 MJ_L96: 
 ldi    r25, hi8(-1) 
 MJ_L97: 
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
 breq MJ_L101 
 # result is false 
 MJ_L100: 
 ldi     r24, 0 
 jmp      MJ_L102 
 # result is true 
 MJ_L101: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L102: 
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
 brne  MJ_L94 
 jmp    MJ_L93
MJ_L94:
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
jmp MJ_L95
MJ_L93:
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
jmp MJ_L95
MJ_L95:
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
 breq MJ_L113 
 # result is false 
 MJ_L112: 
 ldi     r24, 0 
 jmp      MJ_L114 
 # result is true 
 MJ_L113: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L114: 
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
 brne  MJ_L106 
 jmp    MJ_L105
MJ_L106:
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
jmp MJ_L107
MJ_L105:
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
jmp MJ_L107
MJ_L107:
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
 breq MJ_L129 
 # result is false 
 MJ_L128: 
 ldi     r24, 0 
 jmp      MJ_L130 
 # result is true 
 MJ_L129: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L130: 
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
 brne  MJ_L118 
 jmp    MJ_L117
MJ_L118:
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
jmp MJ_L119
MJ_L117:
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
jmp MJ_L119
MJ_L119:
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
 brlt     MJ_L136 
 ldi    r25, 0 
 jmp    MJ_L137 
 MJ_L136: 
 ldi    r25, hi8(-1) 
 MJ_L137: 
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
 breq MJ_L145 
 # result is false 
 MJ_L144: 
 ldi     r24, 0 
 jmp      MJ_L146 
 # result is true 
 MJ_L145: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L146: 
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
 brne  MJ_L134 
 jmp    MJ_L133
MJ_L134:
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
jmp MJ_L135
MJ_L133:
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
jmp MJ_L135
MJ_L135:
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
 brlt     MJ_L152 
 ldi    r19, 0 
 jmp    MJ_L153 
 MJ_L152: 
 ldi    r19, hi8(-1) 
 MJ_L153: 
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
 breq MJ_L161 
 # result is false 
 MJ_L160: 
 ldi     r24, 0 
 jmp      MJ_L162 
 # result is true 
 MJ_L161: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L162: 
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
 brne  MJ_L150 
 jmp    MJ_L149
MJ_L150:
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
jmp MJ_L151
MJ_L149:
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
jmp MJ_L151
MJ_L151:
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
 brlt     MJ_L168 
 ldi    r25, 0 
 jmp    MJ_L169 
 MJ_L168: 
 ldi    r25, hi8(-1) 
 MJ_L169: 
 # promoting a byte to an int 
 tst     r18 
 brlt     MJ_L170 
 ldi    r19, 0 
 jmp    MJ_L171 
 MJ_L170: 
 ldi    r19, hi8(-1) 
 MJ_L171:  
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
 breq MJ_L177 
 # result is false 
 MJ_L176: 
 ldi     r24, 0 
 jmp      MJ_L178 
 # result is true 
 MJ_L177: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L178: 
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
 brne  MJ_L166 
 jmp    MJ_L165
MJ_L166:
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
jmp MJ_L167
MJ_L165:
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
jmp MJ_L167
MJ_L167:
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
 brlt     MJ_L185 
 ldi    r25, 0 
 jmp    MJ_L188 
 MJ_L187: 
 ldi    r25, hi8(-1) 
 MJ_L188: 
 cp    r24, r18 
 cpc   r25, r19 
 breq MJ_L185 
 # result is false 
 MJ_L184: 
 ldi     r24, 0 
 jmp      MJ_L186 
 # result is true 
 MJ_L185: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L186: 
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
 brne  MJ_L182 
 jmp    MJ_L181
MJ_L182:
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
jmp MJ_L183
MJ_L181:
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
jmp MJ_L183
MJ_L183:
  # Load constant int  
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
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
 ldi    r24,lo8(32) 
 ldi    r25,hi8(32) 
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
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
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
 breq MJ_L199 
 # result is false 
 MJ_L198: 
 ldi     r24, 0 
 jmp      MJ_L200 
 # result is true 
 MJ_L199: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L200: 
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
 brne  MJ_L190 
 jmp    MJ_L189
MJ_L190:
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
jmp MJ_L191
MJ_L189:
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
jmp MJ_L191
MJ_L191:
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
 breq MJ_L207 
 # result is false 
 MJ_L206: 
 ldi     r24, 0 
 jmp      MJ_L208 
 # result is true 
 MJ_L207: 
 ldi     r24, 1 
  # store result of equal expression 
 MJ_L208: 
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
 brne  MJ_L204 
 jmp    MJ_L203
MJ_L204:
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
jmp MJ_L205
MJ_L203:
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
jmp MJ_L205
MJ_L205:
  ### MeggyCheckButton 
 call    _Z16CheckButtonsDownv 
 lds    r24, Button_A 
 # if button value is zero, push 0 else push 1 
 tst    r24 
 breq   MJ_L214 
 MJ_L215:  
 ldi    r24, 1 
 jmp    MJ_L216 
 MJ_L214: 
 MJ_L216: 
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
 brne  MJ_L212 
 jmp    MJ_L211
MJ_L212:
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
jmp MJ_L213
MJ_L211:
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
jmp MJ_L213
MJ_L213:
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

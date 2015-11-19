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


 
# NewExp 
 ldi    r24, lo8(0) 
 ldi    r25, hi8(0) 
 # allocating object of size 0 on heap 
 call    malloc 
 # push object address 
 # push two byte expression onto stack 
 push   r25 
 push   r24
#### function call 
 # put parameter values into appropriate registers

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      run
 .text 
 .global Solver_initMaze1 
 .type  Solver_initMaze1, @function 
 Solver_initMaze1: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
/* done with function sSolver_initMaze1 prologue */
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_initMaze1, .-Solver_initMaze1
 .text 
 .global Solver_initMaze2 
 .type  Solver_initMaze2, @function 
 Solver_initMaze2: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
/* done with function sSolver_initMaze2 prologue */
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_initMaze2, .-Solver_initMaze2
 .text 
 .global Solver_initMazeCool 
 .type  Solver_initMazeCool, @function 
 Solver_initMazeCool: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
/* done with function sSolver_initMazeCool prologue */
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
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
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_initMazeCool, .-Solver_initMazeCool
 .text 
 .global Solver_run 
 .type  Solver_run, @function 
 Solver_run: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
/* done with function sSolver_run prologue */
#### function call 
 # put parameter values into appropriate registers

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      initMazeCool
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
 ldi    r24,lo8(6) 
 ldi    r25,hi8(6) 
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
 ldi    r24,lo8(6) 
 ldi    r25,hi8(6) 
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
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_run, .-Solver_run
 .text 
 .global Solver_inBounds 
 .type  Solver_inBounds, @function 
 Solver_inBounds: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
/* done with function sSolver_inBounds prologue */
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L20 
 # load false 
 MJ_L19: 
 ldi     r24, 0 
 jmp      MJ_L21 
 # load true 
 MJ_L20: 
 ldi    r24, 1 
 # push result of less than 
 MJ_L21: 
 # push one byte expression onto stack 
 push   r24
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L11 
 jmp   MJ_L10
MJ_L11: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
  # Load constant int  
 ldi    r24,lo8(8) 
 ldi    r25,hi8(8) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L25 
 # load false 
 MJ_L24: 
 ldi     r24, 0 
 jmp      MJ_L26 
 # load true 
 MJ_L25: 
 ldi    r24, 1 
 # push result of less than 
 MJ_L26: 
 # push one byte expression onto stack 
 push   r24
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L10: 
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L6 
 jmp   MJ_L5
MJ_L6: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
  # Load constant int  
 ldi    r24,lo8(0) 
 ldi    r25,hi8(0) 
 # push two byte expression onto stack 
 push   r25 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L34 
 # load false 
 MJ_L33: 
 ldi     r24, 0 
 jmp      MJ_L35 
 # load true 
 MJ_L34: 
 ldi    r24, 1 
 # push result of less than 
 MJ_L35: 
 # push one byte expression onto stack 
 push   r24
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L5: 
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L1 
 jmp   MJ_L0
MJ_L1: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Load constant int  
 ldi    r24,lo8(8) 
 ldi    r25,hi8(8) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
  # Casting int to byte by popping 
 # 2 bytes off stack and only pushing low order bits 
 # back on.  Low order bits are on top of stack. 
 pop    r24 
 pop    r25 
 push   r24 
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L39 
 # load false 
 MJ_L38: 
 ldi     r24, 0 
 jmp      MJ_L40 
 # load true 
 MJ_L39: 
 ldi    r24, 1 
 # push result of less than 
 MJ_L40: 
 # push one byte expression onto stack 
 push   r24
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L0: 
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_inBounds, .-Solver_inBounds
 .text 
 .global Solver_isDark 
 .type  Solver_isDark, @function 
 Solver_isDark: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
/* done with function sSolver_isDark prologue */
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L44 
 jmp   MJ_L43
MJ_L44: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
 ldi    r22,0 
  # push one byte expression onto stack 
 push   r22 
 # equality check expression 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 cp    r24, r18 
 breq MJ_L49 
 # result is false 
 MJ_L48: 
 ldi     r24, 0 
 jmp      MJ_L50 
 # result is true 
 MJ_L49: 
 ldi     r24, 1 
  # store result of equal expression 
 MJ_L50: 
 # push one byte expression onto stack 
 push   r24 
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L43: 
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_isDark, .-Solver_isDark
 .text 
 .global Solver_isBLUE 
 .type  Solver_isBLUE, @function 
 Solver_isBLUE: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
/* done with function sSolver_isBLUE prologue */
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L54 
 jmp   MJ_L53
MJ_L54: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
 ldi    r22,5 
  # push one byte expression onto stack 
 push   r22 
 # equality check expression 
 # load a one byte expression off stack 
 pop    r18 
 # load a one byte expression off stack 
 pop    r24 
 cp    r24, r18 
 breq MJ_L59 
 # result is false 
 MJ_L58: 
 ldi     r24, 0 
 jmp      MJ_L60 
 # result is true 
 MJ_L59: 
 ldi     r24, 1 
  # store result of equal expression 
 MJ_L60: 
 # push one byte expression onto stack 
 push   r24 
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L53: 
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_isBLUE, .-Solver_isBLUE
 .text 
 .global Solver_findTargetOrMove 
 .type  Solver_findTargetOrMove, @function 
 Solver_findTargetOrMove: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
std Y + 5, r25
std Y + 6, r25
/* done with function sSolver_findTargetOrMove prologue */
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
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
 breq MJ_L72 
 # result is false 
 MJ_L71: 
 ldi     r24, 0 
 jmp      MJ_L73 
 # result is true 
 MJ_L72: 
 ldi     r24, 1 
 # store result of equal expression 
 MJ_L73: 
 # push one byte expression onto stack 
 push   r24 
 
  # if left operand is false do not eval right 
 # load a one byte expression off stack 
 pop    r24 
 # push one byte expression onto stack 
 push   r24 
 # compare left exp with zero 
 ldi r25, 0 
 cp    r24, r25 
 # Want this, breq  
 brne  MJ_L67 
 jmp   MJ_L66
MJ_L67: 
 #right operand 
 # load a one byte expression off stack 
 pop    r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
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
 
 # push one byte expression onto stack 
 push   r22 
 # load a one byte expression off stack 
  pop    r24 
 # push one byte expression onto stack 
 push   r24 
 MJ_L66: 
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L64 
 jmp    MJ_L63
MJ_L64:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,5 
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
jmp MJ_L65
MJ_L63:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
jmp MJ_L65
MJ_L65:
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_findTargetOrMove, .-Solver_findTargetOrMove
 .text 
 .global Solver_move 
 .type  Solver_move, @function 
 Solver_move: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
std Y + 5, r25
std Y + 6, r25
/* done with function sSolver_move prologue */
  # Load constant int  
 ldi    r24,lo8(256) 
 ldi    r25,hi8(256) 
 # push two byte expression onto stack 
 push   r25 
 push   r24 
 
 ### Meggy.delay() call 
 # load delay parameter 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 call   _Z8delay_msj 
 
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,5 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      findTargetOrMove
jmp MJ_L83
MJ_L81:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
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
 brne  MJ_L93 
 jmp    MJ_L92
MJ_L93:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      findTargetOrMove
jmp MJ_L94
MJ_L92:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L104 
 jmp    MJ_L103
MJ_L104:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      findTargetOrMove
jmp MJ_L105
MJ_L103:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
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
 brne  MJ_L115 
 jmp    MJ_L114
MJ_L115:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      findTargetOrMove
jmp MJ_L116
MJ_L114:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L126 
 jmp    MJ_L125
MJ_L126:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,3 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
jmp MJ_L127
MJ_L125:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
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
 brne  MJ_L137 
 jmp    MJ_L136
MJ_L137:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,3 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
jmp MJ_L138
MJ_L136:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
 # load condition and branch if false 
 # load a one byte expression off  stack 
 pop    r24 
 #load zero into reg 
 ldi    r25, 0 
 #use cp to set SREG 
 cp     r24, r25 
 #WANT breq MJ_L0 
 brne  MJ_L148 
 jmp    MJ_L147
MJ_L148:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,3 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
jmp MJ_L149
MJ_L147:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
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
 brne  MJ_L159 
 jmp    MJ_L158
MJ_L159:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
  # Color expression  
 ldi    r22,3 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 6 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3
# load a one byte expression off stack
pop r4

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      move
jmp MJ_L160
MJ_L158:
jmp MJ_L160
MJ_L160:
jmp MJ_L149
MJ_L149:
jmp MJ_L138
MJ_L138:
jmp MJ_L127
MJ_L127:
jmp MJ_L116
MJ_L116:
jmp MJ_L105
MJ_L105:
jmp MJ_L94
MJ_L94:
jmp MJ_L83
MJ_L83:
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_move, .-Solver_move
 .text 
 .global Solver_mazeRow 
 .type  Solver_mazeRow, @function 
 Solver_mazeRow: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
std Y + 5, r25
/* done with function sSolver_mazeRow prologue */
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L173 
 # load false 
 MJ_L172: 
 ldi     r24, 0 
 jmp      MJ_L174 
 # load true 
 MJ_L173: 
 ldi    r24, 1 
 # push result of less than 
 MJ_L174: 
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
 brne  MJ_L170 
 jmp    MJ_L169
MJ_L170:
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeRow
jmp MJ_L171
MJ_L169:
jmp MJ_L171
MJ_L171:
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_mazeRow, .-Solver_mazeRow
 .text 
 .global Solver_mazeCol 
 .type  Solver_mazeCol, @function 
 Solver_mazeCol: 
 push   r29 
 push   r28 
 # make space for locals and params 
 ldi    r30, 0 

 push   r30 
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 1, r25
std Y + 3, r25
std Y + 4, r25
std Y + 5, r25
/* done with function sSolver_mazeCol prologue */
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
# less than expression 
 # load a two byte expression off stack 
 pop    r18 
 pop    r19 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25 
 cp    r24, r18 
 cpc   r25, r19 
 brlt MJ_L185 
 # load false 
 MJ_L184: 
 ldi     r24, 0 
 jmp      MJ_L186 
 # load true 
 MJ_L185: 
 ldi    r24, 1 
 # push result of less than 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 3 
 # push one byte expression onto stack 
 push   r24
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 4 
 # push one byte expression onto stack 
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
# IdExp0 
  # load value for variable a 
 # variable is a local or param variable 
 # load a one byte variable from base+offset 
 ldd    r24, Y + 5 
 # push one byte expression onto stack 
 push   r24
#### function call 
 # put parameter values into appropriate registers
# load a one byte expression off stack
pop r1
# load a one byte expression off stack
pop r2
# load a one byte expression off stack
pop r3

 # receiver will be passed as first param 
 # load a two byte expression off stack 
 pop    r24 
 pop    r25
call      mazeCol
jmp MJ_L183
MJ_L181:
jmp MJ_L183
MJ_L183:
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
# restoring the frame pointer 
 pop    r28 
 pop    r29 
 ret 
 .size Solver_mazeCol, .-Solver_mazeCol
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

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


 
 .text 
 .global something_inBounds 
 .type  something_inBounds, @function 
 something_inBounds: 
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
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 0, r25
std Y + 1, r24
std Y + 2, r23
std Y + 3, r22
std Y + 4, r21
std Y + 5, r20
std Y + 6, r19
std Y + 7, r18
std Y + 8, r17
std Y + 9, r16
/* done with function ssomething_inBounds prologue */
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
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
 .size something_inBounds, .-something_inBounds
 .text 
 .global something1_inBounds1 
 .type  something1_inBounds1, @function 
 something1_inBounds1: 
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
 push   r30 
 push   r30 
 push   r30 
 push   r30 
 # Copy stack pointer to frame pointer 
 in     r28,__SP_L__ 
 in     r29,__SP_H__ 
 # save off parameters 
 
std Y + 0, r25
std Y + 1, r24
std Y + 2, r23
std Y + 3, r22
std Y + 4, r21
std Y + 5, r20
std Y + 6, r19
std Y + 7, r18
std Y + 8, r17
std Y + 9, r16
/* done with function ssomething1_inBounds1 prologue */
/* epilogue start for sampletest2_testfun1 */ 
 # no return value 
 # pop space off stack for parameters and locals
 pop   r30 
 pop   r30 
 pop   r30 
 pop   r30 
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
 .size something1_inBounds1, .-something1_inBounds1
  


 /* epilogue start */ 
 endLabel:
 jmp endLabel 
 ret 
 .size   main, .-main 

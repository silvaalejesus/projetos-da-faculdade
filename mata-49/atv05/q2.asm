%include "linux-ex/asm_io.inc"

section .bss
    ValMinutos resd 4 

section .text
    global asm_main

asm_main:
    enter 0,0
    pusha 
    mov bx, 0b111010010001011
    mov cx, bx      
    shr cx, 5       
    and cx, 0x3F    
    mov [ValMinutos], cl 

    mov eax, [ValMinutos]
    call print_int

    popa
    mov     eax, 0 
    leave
    ret
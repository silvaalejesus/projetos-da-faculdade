%include "linux-ex/asm_io.inc"

section .data
    x dd 5
    y dd 1
    
segment .bss
    subt resd 1
    soma resd 1

section .text
    global asm_main

asm_main:   
    enter 0,0
    pusha ; salva os registradores

    ; soma
    mov eax, [x]
    add eax, [y]
    mov [soma], eax
    call print_int
    call print_nl

    ; subtracao
    mov eax, [x]
    sub eax, [y]
    mov [subt], eax
    call print_int


    ; Exit
    popa
    mov     eax, 0 
    leave
    ret

%include "linux-ex/asm_io.inc"

section .bss
    resultado resd 4
section .text
    global asm_main

asm_main:
    enter 0,0
    pusha ; salva os registradores

    mov ax, 400
    mov bx, 500
    mul bx
    mov ebx, eax
    mov eax, edx
    shl eax, 16
    add eax, ebx
    mov ecx, eax

    mov [resultado], ecx
   
    call print_int

  ; Exit
    popa
    mov     eax, 0 
    leave
    ret
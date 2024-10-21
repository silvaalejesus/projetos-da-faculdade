%include "linux-ex/asm_io.inc"

section .data
    a dd 10
    b dd 20
    c dd 30

segment .bss
    soma resd 1
section .text

    global asm_main

asm_main:  
    enter 0,0
    pusha ; salva os registradores
    ; a. Carregue os valores 10, 20 e 30 em três registradores diferentes (AX, BX, CX)
    mov eax, [a]
    mov ebx, [b]
    mov ecx, [c]
    ; b. Some o valor de AX com BX, e armazene o resultado em AX.
    add eax, [b]
    ; c. Em seguida, some o valor de AX com CX.
    add eax, [c]
    ; d. O resultado final deve estar em AX.
    call print_int ; imprime o resultado final que esta em ax

    ; Exit
    popa
    mov     eax, 0           
    leave
    ret

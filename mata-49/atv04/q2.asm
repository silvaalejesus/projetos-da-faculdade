%include "linux-ex/asm_io.inc"

section .data
    ebx_value dd 10
    ecx_value dd 5

section .bss
    resultado RESD 10  

section .text
    global asm_main

asm_main:

    enter 0,0
    pusha

    mov eax, 0  ; Inicializa eax com 0
    mov ebx, [ebx_value]
    mov ecx, [ecx_value]
    ; call print_int
    ; call print_nl
loop:
    inc eax  ; Incrementa eax
    call print_int
    call print_nl
    cmp eax, ecx  ; Compara eax com ecx
    je igual  ; Se forem iguais, pula para igual if (eax == ecx):
    jmp diferente  ; Se forem diferentes, pula para diferente

igual:
    mov edx, 10
    jmp fim_loop

diferente:
    mov edx, 20  
    jmp fim_loop

fim_loop:
    cmp eax, ebx  ; Compara eax com ebx
    jl loop  ; Se eax for menor que ebx, volta para o loop
    jmp fim

fim:
    mov eax, edx
    call print_int
    popa
    mov     eax, 0 
    leave
    ret
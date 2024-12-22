; Implemente o algoritmo Bubble Sort para ordenar o seguinte vetor de números em
; ordem crescente: [5, 4, 3, 2, 1]

%include "linux-ex/asm_io.inc"

section .data
    array dd 5, 4, 3, 2, 1
    tamanho equ 5

section .text
    global asm_main

asm_main:
    enter 0,0
    pusha


    mov edx, tamanho
    dec edx

outer_loop:
 
    mov esi, array ; Índice do primeiro elemento a ser comparado
    mov ecx, edx ; Contador interno

    inner_loop:
        mov eax, [esi]
        cmp eax, [esi+4]
        jbe next ; Pula a troca se estiver em ordem
        ; jbe - salto se abaixo de ou igual a
        mov ebx, [esi+4]
        mov [esi+4], eax
        mov [esi], ebx

        next:
        add esi, 4
        loop inner_loop

    dec edx
    jnz outer_loop

    ; imprime o array ordenado
    mov esi, array
    mov ecx, tamanho
    print_loop:
        mov eax, [esi]
        call print_int
        call print_nl
        add esi, 4
        loop print_loop
        
    ; Exit
    popa
    mov eax, 0 
    leave
    ret

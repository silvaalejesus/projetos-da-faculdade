; Escreva um programa em assembly que inverte os dados armazenados no vetor1
; em um segundo vetor (vetor2 não inicializado).
; Ex:
; vet1 = [1, 2, 3, 4, 5] → vet2= [5, 4, 3, 2, 1]

%include "linux-ex/asm_io.inc"

section .data
  array dd 1, 2, 3, 4, 5
  tamanho equ 5

section .bss
  vet2 resd 5

section .text
    global asm_main

asm_main:
    enter 0,0
    pusha

    mov edx, tamanho

outer_loop:
 
    mov esi, array ; Índice do primeiro elemento a ser comparado
    mov ecx, edx ; Contador interno

    inner_loop:
        mov eax, [esi]
        cmp eax, [esi+4]
        jbe next ; Pula a troca se estiver em ordem
        ; jbe - salto se abaixo de ou igual a
        mov ebx, [esi+4]

        next:
        add esi, 4
        loop inner_loop
        
        call print_int
        call print_nl

    dec edx
    jnz outer_loop

  ; Exit
  popa
  mov eax, 0 
  leave
  ret


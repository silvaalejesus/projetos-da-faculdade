%include "linux-ex/asm_io.inc"

section .data
    vetor dd 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  ; Vetor de 10 inteiros
    tamanhoVetor equ 10                         ; Tamanho do vetor

segment .bss
    soma resd 1                                  

section .text
    global asm_main

asm_main:
    enter 0, 0                                  
    pusha                                      

    xor eax, eax                                ; Inicializa o acumulador (eax = 0)
    xor ecx, ecx                                ; Inicializa o contador (ecx = 0)
    mov esi, vetor                           ; Aponta ESI para o início do vetor

soma_loop:
    cmp ecx, tamanhoVetor                       ; Compara o contador com o tamanho do vetor
    jge fim                                     ; Se ecx >= tamanhoVetor, termina o loop

    mov edx, [esi + ecx*4]                      ; Carrega o elemento atual do vetor
    add eax, edx                                ; Soma o valor ao acumulador (eax)

    inc ecx                                     ; Incrementa o contador
    jmp soma_loop                               ; Repete o loop

fim:
    mov [soma], eax                              ; Armazena a soma na variável 'soma'

    ; imprime o resultado
    mov eax, [soma]
    call print_int
    call print_nl                              

    popa                                       
    mov eax, 0                       
    leave
    ret
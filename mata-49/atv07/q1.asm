%include "linux-ex/asm_io.inc"

section .data
    ; Definindo a matriz 3x3
    matriz dd 1, 2, 3
           dd 4, 5, 6
           dd 7, 8, 9

section .text
    global asm_main

asm_main:
enter 0,0
    pusha
    ; Inicializando registradores
    mov ecx, 0  ; Índice da diagonal
    mov ebx, 0  ; Soma da diagonal

calcular_soma:
    ; Calculando o índice da diagonal
    mov eax, ecx
    imul eax, 3
    add eax, ecx

    ; Somando o valor da diagonal
    add ebx, [matriz + eax *4]

    ; Incrementando o índice
    inc ecx
    cmp ecx, 3
    
    jl calcular_soma

    ; Armazenando a soma na variável
    mov eax, ebx
    call print_int
    
    ; Exit
    popa
    mov eax, 0 
    leave
    ret

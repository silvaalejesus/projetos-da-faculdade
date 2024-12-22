%include "linux-ex/asm_io.inc"

section .data
    ; Definindo as matrizes 3x3
    matrizA dd 1, 2, 3
            dd 4, 5, 6
            dd 7, 8, 9

    matrizB dd 9, 8, 7
            dd 6, 5, 4
            dd 3, 2, 1

section .bss
    matrizC resd 9  ; Matriz 3x3 para armazenar o resultado

section .text
    global asm_main

asm_main:

enter 0,0
    pusha
    ; Inicializando registradores
    mov esi, 0
    mov ecx, 9  ; Índice da matriz

calcular_soma:
    mov eax, [matrizA + esi * 4]
    add eax, [matrizB + esi * 4]
    mov [matrizC + esi * 4], eax
     call print_int
     call print_nl
    inc esi
    cmp esi, 9
    ; mov eax, [matrizC ]

    loop calcular_soma
        
    ; Exit
    popa
    mov eax, 0 
    leave
    ret

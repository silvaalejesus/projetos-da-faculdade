; a. R = X - (-Y + Z)
; b. R = X - (-(Y + X))
; c. R = X + Y + (Y - Z)

%include "linux-ex/asm_io.inc"
; Esses sao os resultados esperados caso os valores de x =10, y=20 e z=30
; a. R = 0
; b. R = 40
; c. R = 20
section .data
    x dd 10
    y dd 20
    z dd 30

segment .bss
  result_a resd 1
  result_b resd 1
  result_c resd 1

section .text

    global asm_main

asm_main:  
    enter 0,0
    pusha ; salva os registradores
    
    ; a. R = X - (-Y + Z)
    mov eax, [x] ; X em eax
    mov ebx, [y] ; Y em ebx
    neg ebx ; -Y
    add ebx, [z] ; -Y + Z
    sub eax, ebx ; X - (-Y + Z)
    mov [result_a], eax
    call print_int
    call print_nl

    ; b. R = X - (-(Y + X))
    mov eax, [x] ; X em eax
    mov ebx, [y] ; Y em ebx
    add ebx, eax ; Y + X
    neg ebx ; -(Y + X)
    sub eax, ebx ; X - (-(Y + X))
    mov [result_b], eax
    call print_int
    call print_nl

    ; c. R = X + Y + (Y - Z)
    mov eax, [x] ; X em eax
    mov ebx, [y] ; Y em ebx
    add eax, ebx ; X + Y
    sub ebx, [z] ; Y - Z
    add eax, ebx ; X + Y + (Y - Z)
    mov [result_c], eax
    call print_int
    call print_nl

    ; Exit
    popa
    mov     eax, 0
    mov edx, 0
    leave
    ret

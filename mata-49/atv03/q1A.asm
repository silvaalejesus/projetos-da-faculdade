; 1. Faça um programa que realiza as seguintes operações, onde X1, X2 e X3 são dados
; armazenados em variáveis:
; a. R = (X1 * 5) / (X2 - 3)
; b. R = (X1 * -5) / (-X2 % X3)

%include "linux-ex/asm_io.inc"

section .data
  x1 dd 8
  x2 dd 5
  x3 dd 3

segment .bss
  result resd 4

section .text
  global asm_main

asm_main:
  enter 0,0
  pusha

  ; multiplicacao basica
  ; mov eax, [x]
  ; imul eax, [y]
  ; call print_int

  ; a. R = (X1 * 5) / (X2 - 3)
  mov eax, [x1]
  mov ebx, 5
  imul ebx      ; (x1*5)
  mov ebx,[x2]  
  sub ebx, 3    ; (X2 - 3)
  cdq
  idiv ebx      ; (X1 * 5) / (X2 - 3)
  call print_int
  call print_nl

  ; Exit
  popa
  mov     eax, 0 
  leave
  ret
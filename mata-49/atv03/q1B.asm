; 1. Faça um programa que realiza as seguintes operações, onde X1, X2 e X3 são dados
; armazenados em variáveis:
; a. R = (X1 * 5) / (X2 - 3)
; b. R = (X1 * -5) / (-X2 % X3)

%include "linux-ex/asm_io.inc"

section .data
  x1 dd 8
  x2 dd 7
  x3 dd 2

segment .bss
  result resd 4

section .text
  global asm_main

asm_main:
  enter 0,0
  pusha

  mov eax, [x2]
  neg eax
  mov ebx, [x3]
  cdq
  idiv ebx
  ; call print_int
  ; call print_nl

  mov ebx, edx
  mov eax, -5
  mov ecx, [x1]
  imul ecx
  cdq
  idiv ebx
  call print_int

  ; Exit
  popa
  mov     eax, 0 
  leave
  ret
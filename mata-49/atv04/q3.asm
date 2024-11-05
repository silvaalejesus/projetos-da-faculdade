; Desenvolva um programa em Assembly que dado um número inteiro, verifica se ele
; é primo ou não
%include "linux-ex/asm_io.inc"

section .data
  numero dd 1   ; 8783
  msg_primo db 'O número é primo', 0
  msg_nao_primo db 'O número não é primo', 0

section .text
  global asm_main

asm_main:
  enter 0,0
  pusha
  
  mov eax, [numero]
  mov ebx, 2

; Caso especial: 2 é o único número primo par
  cmp eax, 2
  je e_primo

; Números menores que 2 não são primos
  cmp eax, 1
  jle nao_e_primo

loop:
  mov edx, 0 ; Limpa o registrador EDX para a divisão
  div ebx

 ; Se o resto da divisão for zero, o número não é primo
  cmp edx, 0
  je nao_e_primo

 ; Incrementa o divisor e verifica se já chegamos ao limite
  inc ebx
  cmp ebx, 3
  je e_primo
  jmp loop

e_primo:
  mov eax, msg_primo
  call print_string
  ; mov eax, 1
  ; call print_int
  jmp fim

nao_e_primo:
  mov eax, msg_nao_primo
  call print_string
  ; mov eax, 0
  ; call print_int
  jmp fim

; Exit
fim:
  popa
  mov     eax, 0 
  leave
  ret
; Criar um programa que dada uma string de caracteres e inverte os caracteres dessa
; string.
; Exemplo
; Entrada: atividade → edadivita

%include "linux-ex/asm_io.inc"

section .data
  string DQ 'planeta', 0  
  length equ $-string

section .bss
    reversed RESQ length 

section .text
  global asm_main

asm_main:
  enter 0,0
  pusha

  mov esi, string  ; Ponteiro para o início da string original
  mov edi, reversed + length - 1  ; Ponteiro para o final da string invertida
  dec edi  ; Ajusta para o último caractere

  mov ecx, length/2  ; Número de pares de caracteres a trocar
    
loop:
  mov al, [esi]
  mov ah, [edi]
  xchg al, ah
  mov [esi], al
  mov [edi], ah
  inc esi
  dec edi
  loop loop

  mov eax, 4
  mov ebx, 1
  mov ecx, reversed
  mov edx, length
  int 0x80

  ; Exit
  fim:
    popa
    mov     eax, 0 
    leave
    ret

; if(eax >= ebx):
;   eax = 1
; else if(eax == 0):
;   eax = -1

; CMP
; Resultado = destino – fonte

%include "linux-ex/asm_io.inc"

section .data
  x1 dd 10
  
section .text
  global asm_main

asm_main:
  enter 0,0
  pusha

  mov eax, [x1] 

  cmp eax, 5         ; compara se eax com 5
  jge maior_igual    ; verifica se é maior ou igual e se for ele entra no modulo maior_igual
  cmp eax, 0
  je  else_zero     ; se nao for maior_igual entao ele verifica se 
  jmp fim

  maior_igual:
    mov eax, 1
    call print_int
    jmp fim

  else_zero:
    mov eax, -1
    call print_int
    jmp fim        ; 

  ; Exit
  fim:
    popa
    mov     eax, 0 
    leave
    ret
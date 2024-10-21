%include "linux-ex/asm_io.inc"

;variaveis inicializadas
section .data
  hello db 'Hello, World!', 0xA  ; A string com nova linha no final

;codigo do programa
section .text
    global asm_main

asm_main:
        ;imprime a string "Hello World!"
        mov eax, hello
        call print_string
        
        leave
        ret
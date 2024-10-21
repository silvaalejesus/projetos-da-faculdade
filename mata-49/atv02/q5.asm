%include "linux-ex/asm_io.inc"

section .data
    a dd 50
    x dd 5
    mem dd 20
section .text

    global asm_main

asm_main:  
    enter 0,0
    pusha ; salva os registradores
    
    ; a. Carregue o valor 50 no registrador AX.
    mov eax, [a]
    ;  b. Subtraia o valor 20, que está armazenado em um endereço de memória [mem], do valor de AX.
    sub eax, [mem]
    ; c. Após a subtração, subtraia mais 5 diretamente do valor de AX.
    sub eax, [x]
    ; d. O valor final de AX deve ser o resultado dessas operações.
    
    call print_int ; imprime o resultado final que esta em ax

    ; Exit
    popa
    mov     eax, 0        
    leave
    ret

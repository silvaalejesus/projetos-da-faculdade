section .data
    input_str db 'Esta eh a string de entrada.', 0
    output_str times 255 db 0  ; String de saída com tamanho máximo de 255 bytes

section .text
    global asm_main

asm_main:
    mov esi, input_str  ; Carrega o endereço da string de entrada em esi
    mov edi, output_str  ; Carrega o endereço da string de saída em edi

loop_start:
    lodsb               ; Carrega o byte de esi em al e incrementa esi
    cmp al, 0           ; Verifica se o byte é o terminador nulo
    je loop_end         ; Se sim, termina o loop

    cmp al, 'a'         ; Compara o byte com 'a'
    jl store_char       ; Se menor que 'a', não é minúsculo, então armazena
    cmp al, 'z'         ; Compara o byte com 'z'
    jg store_char       ; Se maior que 'z', não é minúsculo, então armazena

    sub al, 32          ; Converte para maiúscula subtraindo 32
    
store_char:
    stosb               ; Armazena o byte de al em edi e incrementa edi
    jmp loop_start      ; Volta para o início do loop

loop_end:
    ; Imprime a string de saída 
    mov eax, 4          
    mov ebx, 1          
    mov ecx, output_str 
    mov edx, 255        
    int 0x80            

    ; Sai do programa
    mov eax, 1          
    xor ebx, ebx        
    int 0x80        
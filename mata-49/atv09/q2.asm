%include "linux-ex/asm_io.inc"

section .data
    numero dd 5       ; Número para calcular o fatorial
    msg db "Fatorial: ", 0
    divisor dd 10            ; Constante para divisão por 10
    newline db 10            ; Código ASCII para '\n'

section .bss
    resultado resd 0         ; Local para armazenar o resultado
    output resb 12           ; Buffer para armazenar número convertido em string

section .text
    global asm_main

asm_main:
    enter 0,0
    pusha                 ; salva os registradores

    mov eax, 6
    ; Salvar o valor inicial de ESP em um registrador para referência
    mov ebp, esp          ; Salva o valor inicial de ESP em EBP

    ; Carregar o número na pilha
    mov eax, [numero]      ; Carregar o número da memória
    call print_int

    cmp eax, 0             ; Verifica se o número é 0
    je .fatorial_zero     ; Se for zero, pula para armazenar 1
    push eax               ; Empilha o número inicial

    ; Inicialização para cálculo do fatorial
    mov ecx, eax          ; Contador do loop
    dec ecx               ; Começar com (n - 1)

.loop_fatorial:
    cmp ecx, 1             ; Verifica se chegou a 1
    jl .calcula_resultado  ; Se menor que 1, sai do loop
    push ecx               ; Empilha o valor
    dec ecx               ; Decrementa o contador
    jmp .loop_fatorial

.calcula_resultado:
    ; Inicializar resultado com 1
    mov eax, 1

.multiplica_pilha:
    ; Verifica se a pilha voltou para o valor inicial de ESP (ou seja, está vazia)
    cmp esp, ebp          ; Compara o ponteiro atual com o valor inicial
    je .armazenar_resultado ; Se a pilha estiver vazia, fim do cálculo
    pop ebx               ; Desempilha o valor
    imul eax, ebx          ; Multiplica o valor no acumulador
    jmp .multiplica_pilha

.fatorial_zero:
    ; Caso o número seja 0, o fatorial é 1
    mov eax, 1

.armazenar_resultado:
    ; Armazena o resultado na memória
    mov [resultado], eax

    ; Imprimir mensagem inicial
    mov eax, 4      
    mov ebx, 1      
    mov ecx, msg
    mov edx, 10     
    int 0x80

    ; imprimir o resultado
   mov eax, [resultado]      ; Carregar o resultado
    call int_to_string        ; Converter para string
    mov ecx, edi              
    mov edx, eax              
    mov eax, 4                
    mov ebx, 1                
    int 0x80

    ; Nova linha
    mov eax, 4              
    mov ebx, 1              
    mov ecx, newline
    mov edx, 1
    int 0x80

    ; Encerrar o programa
    mov eax, 1              ; exit
    xor ebx, ebx
    int 0x80

; Função para converter inteiro para string
int_to_string:
    xor ecx, ecx            ; Zera contador de dígitos
    mov edi, output + 11    ; Aponta para o final do buffer
    mov byte [edi], 0       ; Finalizador de string (NULL terminator)
    dec edi                 ; Ajustar para o próximo caractere

.convert_loop:
    xor edx, edx            ; Limpa o resto
    mov ebx, [divisor]      ; Carregar o divisor (10) para o registrador EBX
    div ebx                 ; Divide EAX por EBX (10)
    add dl, '0'             ; Converte o resto para caractere
    mov [edi], dl           ; Armazena o caractere no buffer
    dec edi                 ; Move para a posição anterior no buffer
    inc ecx                 ; Incrementa o contador
    test eax, eax           ; Verifica se o quociente é 0
    jnz .convert_loop       ; Continua se não for 0

    inc edi                 ; Ajusta o ponteiro para o início da string
    mov eax, ecx            ; Retorna o comprimento da string
    ret
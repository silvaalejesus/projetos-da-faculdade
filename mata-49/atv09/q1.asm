section .data
    vetor db 1, 2, 3, 4, 5     ; Vetor de exemplo
    tam equ 5                  ; Tamanho do vetor

section .bss
    vetor_invertido resb tam   ; Espaço para armazenar o vetor invertido

section .text
    global asm_main

asm_main:
    ; Inicialização do índice
    mov ecx, tam               ; Contador do loop
    mov esi, vetor             ; Ponteiro para o vetor original

.loop_push:
    ; Empilhar valores do vetor
    mov al, [esi]              ; Carrega o valor do vetor
    push eax                   ; Empilha o valor
    inc esi                    ; Avança para o próximo elemento
    loop .loop_push            ; Repetir até o contador zerar

    ; Inicializar ponteiro para o vetor invertido
    mov edi, vetor_invertido
    mov ecx, tam               ; Reutiliza contador para desempilhar

.loop_pop:
    ; Desempilhar valores para o vetor invertido
    pop eax                    ; Remove o valor do topo da pilha
    mov [edi], al              ; Armazena no vetor invertido
    inc edi                    ; Avança o ponteiro
    loop .loop_pop             ; Repetir até o contador zerar

    ; Encerrar o programa
    mov eax, 1                 ; Chamada do sistema para saída
    int 0x80

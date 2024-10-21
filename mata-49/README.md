Passos para Compilar e Executar:

1. Compilar linux-ex:
   Dentro do diretório linux-ex, executar:
   make

Após isso, retorne ao diretório superior.
Obs: Substitua "q1" pelo nome do aquivo que você deseja compilar

2. Compilar:
   Para compilar o código NASM em um formato de objeto executável compatível com Linux (ELF), use o seguinte comando no terminal:
   nasm -f elf32 q1.asm -o q1.o

3. Linkar o arquivo objeto
   Depois de compilar o código, você precisa linkar o arquivo objeto para criar o executável:
   gcc -m32 -o q1 q1.o linux-ex/driver.c linux-ex/asm_io.o

4. Executar o programa
   Após o processo de linkagem, você pode executar o programa:
   ./q1

Isso deve imprimir o resultado da soma e subtração no terminal.

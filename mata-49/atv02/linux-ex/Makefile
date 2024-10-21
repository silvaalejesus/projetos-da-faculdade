# Linux makefile
# Use with make 

.SUFFIXES: .o .asm .cpp .c

# Definições
AS=nasm
ASFLAGS= -f elf  # Formato para 32 bits
CFLAGS= -m32  # Compila o código C em 32 bits
CC=gcc
CXX=g++
CXXFLAGS= -m32  # Compila o código C++ em 32 bits

# Regras de sufixo
.asm.o:
	$(AS) $(ASFLAGS) $<

.cpp.o:
	$(CXX) -c $(CXXFLAGS) $<

.c.o:
	$(CC) -c $(CFLAGS) $<

# Alvo principal
all: prime math first sub1 sub2 sub3 sub4 sub5 sub6 memex dmaxt fprime quadt test_big_int

# Regras de construção
prime: driver.o prime.o asm_io.o
	$(CC) $(CFLAGS) -o prime driver.o prime.o asm_io.o

math: driver.o math.o asm_io.o
	$(CC) $(CFLAGS) -o math driver.o math.o asm_io.o

first: driver.o first.o asm_io.o
	$(CC) $(CFLAGS) -o first driver.o first.o asm_io.o

sub1: driver.o sub1.o asm_io.o
	$(CC) $(CFLAGS) -o sub1 driver.o sub1.o asm_io.o

sub2: driver.o sub2.o asm_io.o
	$(CC) $(CFLAGS) -o sub2 driver.o sub2.o asm_io.o

sub3: driver.o sub3.o asm_io.o
	$(CC) $(CFLAGS) -o sub3 driver.o sub3.o asm_io.o

sub4: driver.o sub4.o main4.o asm_io.o
	$(CC) $(CFLAGS) -o sub4 driver.o sub4.o main4.o asm_io.o

sub5: main5.o sub5.o asm_io.o
	$(CC) $(CFLAGS) -o sub5 main5.o sub5.o asm_io.o

sub6: main6.o sub6.o
	$(CC) $(CFLAGS) -o sub6 main6.o sub6.o

asm_io.o: asm_io.asm
	$(AS) $(ASFLAGS) -d ELF_TYPE asm_io.asm

array1: driver.o array1.o array1c.o
	$(CC) $(CFLAGS) -o array1 array1.o array1c.o asm_io.o

memex: memex.o memory.o
	$(CC) $(CFLAGS) -o memex memex.o memory.o

dmaxt: dmaxt.o dmax.o
	$(CC) $(CFLAGS) -o dmaxt dmaxt.o dmax.o

quadt: quadt.o quad.o
	$(CC) $(CFLAGS) -o quadt quadt.o quad.o

readt: readt.o read.o
	$(CC) $(CFLAGS) -o readt readt.o read.o

fprime: fprime.o prime2.o
	$(CC) $(CFLAGS) -o fprime fprime.o prime2.o

test_big_int: test_big_int.o big_int.o big_math.o
	$(CXX) $(CXXFLAGS) -o test_big_int test_big_int.o big_int.o big_math.o

# Dependências
big_int.o: big_int.hpp

test_big_int.o: big_int.hpp

first.o: asm_io.inc first.asm

sub1.o: asm_io.inc

sub2.o: asm_io.inc

sub3.o: asm_io.inc

sub4.o: asm_io.inc

main4.o: asm_io.inc

driver.o: driver.c

# Alvo de limpeza
clean:
	rm -f *.o prime math first sub1 sub2 sub3 sub4 sub5 sub6 memex dmaxt fprime quadt test_big_int


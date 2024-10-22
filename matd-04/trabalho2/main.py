# Versao python utilizada: Python 3.10.14

import TabelaHash

TAM_TABELA_HASH = 10
tabela_hash = TabelaHash.TabelaHash(TAM_TABELA_HASH)
comando = ''

while comando != 'e':
  comando = input()
  if comando == 'i':
    palavra = input()
    tabela_hash.inserir_palavra(palavra)
  elif comando == 'c':
    palavra = input()
    tabela_hash.consultar_palavra(palavra)
  elif comando == 'f':
    tabela_hash.imprimir_palavras_mais_consultadas()
  elif comando == 'o':
    letra1 = input()
    letra2 = input()
    tabela_hash.imprimir_palavras_em_ordem_alfabetica(letra1, letra2)
  elif comando == 'r':
    palavra = input()
    tabela_hash.remover_palavra(palavra)
  elif comando == 'n':
    nivel = int(input())
    tabela_hash.listar_palavras_na_entrada(nivel)
  elif comando == 'p':
    tabela_hash.imprimir_tabela_hash()
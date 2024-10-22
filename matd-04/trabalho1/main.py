# Versao python utilizada: Python 3.10.14
import ArvoreBinaria

arvore_binaria = ArvoreBinaria.ArvoreBinaria()
comando = ''

while comando != 'e':
  comando = input()
  if comando == 'i':
    palavra = input()
    arvore_binaria.insere_palavra(palavra)
  elif comando == 'c':
    palavra = input()
    arvore_binaria.consulta_palavra(palavra)
  elif comando == 'f':
    arvore_binaria.imprimir_mais_consultadas()
  elif comando == 'o':
    letra1 = input()
    letra2 = input()
    arvore_binaria.lista_palavras_em_ordem_alfabetica(letra1, letra2)
  elif comando == 'r':
    palavra = input()
    arvore_binaria.remove_palavra(palavra)
  elif comando == 'n':
    nivel = int(input())
    arvore_binaria.lista_palavras_em_nivel(nivel)
  elif comando == 't':
    palavra = input()
    arvore_binaria.listar_palavras_no_caminho(palavra)
  elif comando == 'p':
    arvore_binaria.imprimir_arvore_preordem()	

# insere
# arvore_binaria.insere_palavra('agua')
# arvore_binaria.insere_palavra('mar')
# arvore_binaria.insere_palavra('ouro')
# arvore_binaria.insere_palavra('novelo')
# arvore_binaria.insere_palavra('guitarra')
# arvore_binaria.insere_palavra('moradia')
# arvore_binaria.insere_palavra('lua')

# arvore_binaria.insere_palavra('lua')
# arvore_binaria.insere_palavra('guitarra')
# arvore_binaria.insere_palavra('moradia')
# arvore_binaria.insere_palavra('agua')
# arvore_binaria.insere_palavra('novelo')
# arvore_binaria.insere_palavra('mar')
# arvore_binaria.insere_palavra('ouro')

# arvore_binaria.insere_palavra('alessandra')
# arvore_binaria.insere_palavra('barbara')
# arvore_binaria.insere_palavra('jessica')
# arvore_binaria.insere_palavra('rosilda')
# arvore_binaria.insere_palavra('janice')
# arvore_binaria.insere_palavra('wilson')
# arvore_binaria.insere_palavra('marta')

# print('\n')
# print('\nconsulta\n')
# # consulta e imprime
# arvore_binaria.consulta_palavra('banana')
# arvore_binaria.consulta_palavra('banana')
# arvore_binaria.consulta_palavra('lua')
# arvore_binaria.consulta_palavra('lua')
# print('\n')
# arvore_binaria.consulta_palavra('lua')
# arvore_binaria.consulta_palavra('lua')
# arvore_binaria.consulta_palavra('lua')
# arvore_binaria.consulta_palavra('moradia')
# arvore_binaria.consulta_palavra('moradia')
# arvore_binaria.consulta_palavra('moradia')
# arvore_binaria.consulta_palavra('moradia')
# arvore_binaria.consulta_palavra('moradia')
# arvore_binaria.consulta_palavra('agua')
# arvore_binaria.consulta_palavra('agua')
# arvore_binaria.consulta_palavra('agua')
# arvore_binaria.consulta_palavra('agua')
# arvore_binaria.consulta_palavra('agua')

# print('\n')
# print('As mais consultadas\n')
# arvore_binaria.imprimir_mais_consultadas()

# print('\nOrdem alfabetica\n')
# arvore_binaria.lista_palavras_em_ordem_alfabetica('a','w')

# print('\nRemove\n')
# arvore_binaria.remove_palavra('sla')

# print('\nLista em nivel\n')
# arvore_binaria.lista_palavras_em_nivel(1)
# arvore_binaria.lista_palavras_em_nivel(2)
# arvore_binaria.lista_palavras_em_nivel(3)
# arvore_binaria.lista_palavras_em_nivel(4)
# arvore_binaria.lista_palavras_em_nivel(5)

# print('\nImpreme a arvore\n')
# arvore_binaria.imprimir_arvore_preordem()

# print('\nImprime palavras no camilho\n')
# arvore_binaria.listar_palavras_no_caminho('mar')
# palavras = ["ouro", "novelo", "moradia", "lua"]

# sla = arvore_binaria.ordenar_alfabeticamente(palavras)
# print(sla)










# print('\n')
# arvore montada
# print(arvore_binaria.ligacoes)

 # agua -> mar
 # mar -> ouro
 # ouro -> novelo
 # mar -> guitarra
 # novelo -> moradia
 # guitarra -> lua

# lua -> guitarra
# lua -> moradia
# guitarra -> agua
# moradia -> novelo
# moradia -> mar
# novelo -> ouro
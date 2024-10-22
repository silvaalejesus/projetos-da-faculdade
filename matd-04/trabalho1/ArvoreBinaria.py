import Fila
import ListaEncadeada
import Pilha


class No:

  def __init__(self, palavra):
    self.palavra = palavra
    self.esquerda = None
    self.direita = None
    self.contador = 0

  def mostra_no(self):
    print(self.palavra)


class ArvoreBinaria:

  def __init__(self):
    self.raiz = None

  # OK - QUESTAO 1 - INSERE PALAVRA
  def insere_palavra(self, palavra):
    novo_no = No(palavra)
    if self.raiz is None:
      self.raiz = novo_no
      print(f'palavra inserida: {palavra}')
    else:
      atual = self.raiz
      while True:
        if palavra < atual.palavra:
          if atual.esquerda is None:
            atual.esquerda = novo_no
            print(f'palavra inserida: {palavra}')
            break
          else:
            atual = atual.esquerda
        elif palavra > atual.palavra:
          if atual.direita is None:
            atual.direita = novo_no
            print(f'palavra inserida: {palavra}')
            break
          else:
            atual = atual.direita
        else:
          print(f'palavra ja existente: {palavra}')
          break

  # OK - QUESTAO 2 - CONSULTA PALAVRA
  def consulta_palavra(self, palavra):
    atual = self.raiz
    while atual is not None and atual.palavra != palavra:
      if palavra < atual.palavra:
        atual = atual.esquerda
      else:
        atual = atual.direita

    if atual is None:  # Se a palavra não foi encontrada na árvore  (ou se a árvore está vazia)
      print(f'palavra inexistente: {palavra}')
    else:  # Se a palavra foi encontrada na árvore
      atual.contador += 1
      print(f'palavra existente: {palavra} {atual.contador}')

  # OK - QUESTAO 3 - PALAVRAS MAIS CONSULTADAS
  def imprimir_mais_consultadas(self):
    # Verifica se a árvore está vazia
    if self.raiz is None:
      print("arvore vazia")
      return

    pilha = Pilha.Pilha()
    max_contador = -1
    palavras = ListaEncadeada.ListaEncadeada()

    # Começa da raiz
    node = self.raiz

    # Itera até que a pilha esteja vazia
    while True:
      # Percorre a subárvore esquerda
      while node is not None:
        pilha.empilhar(node)
        node = node.esquerda

      # Se a pilha estiver vazia, a travessia está completa
      if pilha.esta_vazia():
        break

      # Visita o nó no topo da pilha
      node = pilha.desempilhar()

      # Processa o nó
      if node.contador > max_contador:
        max_contador = node.contador
        palavras = ListaEncadeada.ListaEncadeada()
        palavras.inserir(node.palavra)
      elif node.contador == max_contador:
        palavras.inserir(node.palavra)

      # Percorre a subárvore direita
      node = node.direita

    # Imprime as palavras mais consultadas
    print('palavras mais consultadas:')
    print(palavras)

    # Imprime o número de acessos
    print(f"numero de acessos: {max_contador}")

  # OK - QUESTAO 4 - LISTA PALAVRAS EM ORDEM ALFABETICA
  def lista_palavras_em_ordem_alfabetica(self, primeira_letra, segunda_letra):
    # cria a pilha
    pilha = Pilha.Pilha()
    atual = self.raiz
    # Cria a lista encadeada
    lista_encadeada = ListaEncadeada.ListaEncadeada()

    while True:
      if atual is not None:
        pilha.empilhar(atual)
        atual = atual.esquerda
      elif not pilha.esta_vazia():
        atual = pilha.desempilhar()
        if primeira_letra <= atual.palavra[0] <= segunda_letra:
          lista_encadeada.inserir(atual.palavra)
        atual = atual.direita
      else:
        break

    return lista_encadeada.imprimir_lista()

    
  # OK - QUESTAO 5 - REMOVE PALAVRA
  def remove_palavra(self, palavra):
    pai = None
    atual = self.raiz
    while atual:
      if palavra < atual.palavra:
        pai = atual
        atual = atual.esquerda
      elif palavra > atual.palavra:
        pai = atual
        atual = atual.direita
      else:
        if atual.esquerda is None:
          if pai is None:
            atual = atual.direita
          elif atual == pai.esquerda:
            pai.esquerda = atual.direita
          else:
            pai.direita = atual.direita
        elif atual.direita is None:
          if pai is None:
            atual = atual.esquerda
          elif atual == pai.esquerda:
            pai.esquerda = atual.esquerda
          else:
            pai.direita = atual.esquerda
        else:
          pai_menor = atual
          menor = atual.direita
          while menor.esquerda:
            pai_menor = menor
            menor = menor.esquerda
          atual.palavra = menor.palavra
          if menor == pai_menor.esquerda:
            pai_menor.esquerda = menor.direita
          else:
            pai_menor.direita = menor.direita
        print(f"palavra removida: {palavra}")
        return atual
    print(f"palavra inexistente: {palavra}")
    return atual

  # OK - QUESTAO 6 - LISTA PALAVRAS EM NIVEL
  def lista_palavras_em_nivel(self, nivel_desejado):
    atual = self.raiz
    if atual is None:
      print(f"nao ha nos com nivel: {nivel_desejado}")
      return
    fila = Fila.Fila()
    # insere a raiz na fila e considera que a raiz começa no nivel 1
    fila.inserir((atual, 1))
    # pra verificar se tem nos no nivel desejado
    no_impresso = False

    while fila:
      no, nivel = fila.remover()

      if nivel == nivel_desejado:
        if not no_impresso:
          print(f"palavras no nivel: {nivel_desejado}")
          no_impresso = True
        print(no.palavra)

      if no.esquerda is not None:
        fila.inserir((no.esquerda, nivel + 1))
      if no.direita is not None:
        fila.inserir((no.direita, nivel + 1))

    if not no_impresso:
      print(f"nao ha nos com nivel: {nivel_desejado}")

  # OK - QUESTAO 7 - LISTA PALAVRAS EM UM CAMINHO
  def listar_palavras_no_caminho(self, palavra_alvo):
    pilha = Pilha.Pilha()
    no_atual = self.raiz

    # para quando a palavra procurada for encontrada
    while True:
      # Move para a esquerda da árvore o máximo possível e empilha todos os nós visitados
      while no_atual:
        pilha.empilhar(no_atual)
        # Se a palavra do nó atual é maior que a palavra alvo, move para a esquerda
        if no_atual.palavra > palavra_alvo:
          no_atual = no_atual.esquerda
        # Se a palavra do nó atual é menor que a palavra alvo, move para a direita
        elif no_atual.palavra < palavra_alvo:
          no_atual = no_atual.direita
        # para o loop interno
        elif no_atual.palavra == palavra_alvo:
          break

      # para o loop externo
      if no_atual and no_atual.palavra == palavra_alvo:
        break

      elif pilha.esta_vazia():
        return print(f"palavra inexistente: {palavra_alvo}")
      else:
        no_atual = pilha.desempilhar().direita

    caminho = ListaEncadeada.ListaEncadeada()

    while not pilha.esta_vazia():
      palavra = pilha.desempilhar().palavra
      no_atual = caminho.cabeca
      no_anterior = None

      while no_atual and no_atual.elemento < palavra:
        no_anterior = no_atual
        no_atual = no_atual.proximo
      # Insere a palavra na posição correta
      novo_no = ListaEncadeada.No(palavra)
      novo_no.proximo = no_atual
      if no_anterior:
        no_anterior.proximo = novo_no
      else:
        caminho.cabeca = novo_no

    return print(f"palavras no caminho:\n{caminho}")

  # OK - QUESTAO 8 - IMPRIMIR ARVORE
  def imprimir_arvore_preordem(self):
    atual = self.raiz
    if atual is None:
      print("arvore vazia")
      return
    # Cria uma pilha vazia e empilha a raiz
    pilha = Pilha.Pilha()
    pilha.empilhar(atual)

    while not pilha.esta_vazia():
      # Desempilha um nó da pilha e imprime
      no = pilha.desempilhar()
      print(
          f"palavra: {no.palavra} freq: {no.contador} fesq: {no.esquerda.palavra if no.esquerda else 'nil'} fdir: {no.direita.palavra if no.direita else 'nil'}"
      )

      # O filho da direita é empilhado antes do filho da esquerda para garantir que o filho da esquerda seja processado primeiro
      if no.direita is not None:
        pilha.empilhar(no.direita)
      if no.esquerda is not None:
        pilha.empilhar(no.esquerda)

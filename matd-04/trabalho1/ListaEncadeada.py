class No:

  def __init__(self, elemento):
    self.elemento = elemento
    self.proximo = None

  def mostra_no(self):
    print(self.elemento)


class ListaEncadeada:

  def __init__(self):
    self.cabeca = None
    self.tamanho = 0

  # ja insere em ordem alfabetica
  def inserir(self, elemento):
    novo_no = No(elemento)
    # Se a lista estiver vazia ou o elemento for menor que o primeiro elemento
    if self.cabeca is None or self.cabeca.elemento > elemento:
      novo_no.proximo = self.cabeca
      self.cabeca = novo_no
    else:
      # Encontra a posição correta para inserir o novo nó
      atual = self.cabeca
      while atual.proximo is not None and atual.proximo.elemento < elemento:
        atual = atual.proximo
      # Insere o novo nó na posição correta
      novo_no.proximo = atual.proximo
      atual.proximo = novo_no

  def imprimir_lista(self):
    atual = self.cabeca
    if atual is None:
      print('palavras em ordem:')
      print('lista vazia')
    else:
      print('palavras em ordem:')
    while atual:
      print(atual.elemento)
      atual = atual.proximo

  def __str__(self):
    str = ''
    atual = self.cabeca
    while atual:
      if str != '':
        str += '\n'
      str += atual.elemento
      atual = atual.proximo
    return str

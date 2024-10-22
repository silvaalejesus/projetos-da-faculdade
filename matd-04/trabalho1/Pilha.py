class No:
  def __init__(self, elemento):
    self.proximo = None
    self.elemento = elemento

  def mostra_no(self):
    print(self.elemento)

class Pilha:

  def __init__(self):
    self.topo = None

  def esta_vazia(self):
    return self.topo is None

  def empilhar(self, no):
    if self.esta_vazia():
      self.topo = No(no)
    else:
      novo_no = No(no)
      novo_no.proximo = self.topo
      self.topo = novo_no

  def desempilhar(self):
    if not self.esta_vazia():
      no_removido = self.topo
      self.topo = self.topo.proximo
      return no_removido.elemento
    else:
      return None
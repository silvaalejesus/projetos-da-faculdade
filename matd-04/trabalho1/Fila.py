# REVISAR ESSE CODIGO
class No:

    def __init__(self, elemento):
        self.elemento = elemento
        self.proximo = None


class Fila:

    def __init__(self):
        self.inicio = None
        self.fim = None
        self.tamanho = 0

    def inserir(self, elem):
        node = No(elem)
        if self.fim is None:
            self.fim = node
        else:
            self.fim.proximo = node
            self.fim = node

        if self.inicio is None:
            self.inicio = node

        self.tamanho = self.tamanho + 1

    def remover(self):
        if self.tamanho > 0:
            elem = self.inicio.elemento
            self.inicio = self.inicio.proximo
            if self.inicio is None:
                self.fim = None
            self.tamanho = self.tamanho - 1
            return elem

    def __repr__(self):
        if self.tamanho > 0:
            raiz = ""
            atual = self.inicio
            while (atual):
                raiz = raiz + str(atual.elemento) + " "
                atual = atual.proximo
            return raiz
        return

    def __str__(self):
        return self.__repr__()

    def __len__(self):
        return self.tamanho

   
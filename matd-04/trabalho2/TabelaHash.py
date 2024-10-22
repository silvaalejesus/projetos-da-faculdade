class TabelaHash:

    def __init__(self, TAM_TABELA_HASH):
        self.TAM_TABELA_HASH = TAM_TABELA_HASH
        self.tabela_hash = [[] for _ in range(TAM_TABELA_HASH)]

   
    def soma_ordem_letras(self, palavra):
        soma = 0
        for letra in palavra:
            soma += ord(letra) - ord('a') + 1
        # print('soma', soma)
        return soma

    # Função de hashing
    def h(self, palavra):
        # print('hash', self.soma_ordem_letras(palavra) % self.TAM_TABELA_HASH)
        return self.soma_ordem_letras(palavra) % self.TAM_TABELA_HASH

    # OK - QUESTAO 1 - INSERE PALAVRA
    def inserir_palavra(self, palavra):
        indice = self.h(palavra)
        for item in self.tabela_hash[indice]:
            if item[0] == palavra:
                print(f"palavra ja existente: {palavra}")
                return  # Palavra já existe, não insere novamente
        self.tabela_hash[indice].append([palavra, 0])
        print(f"palavra inserida: {palavra}")

    # OK - QUESTAO 2 - CONSULTA PALAVRA
    def consultar_palavra(self, palavra):
        indice = self.h(palavra)
        for item in self.tabela_hash[indice]:
            if item[0] == palavra:
                item[1] += 1
                print(f"palavra existente: {palavra} {item[1]}")
                return item[1]
        print(f"palavra inexistente: {palavra}")
        return 0  # Palavra não encontrada

    # OK - QUESTAO 3 - PALAVRAS MAIS CONSULTADAS
    def imprimir_palavras_mais_consultadas(self):
        palavras_consultadas = []
        for bucket in self.tabela_hash:
            for palavra, consultas in bucket:
                palavras_consultadas.append((palavra, consultas))

        if not palavras_consultadas:
            print("tabela vazia")
            return

        max_consultas = max(consultas for _, consultas in palavras_consultadas)
        palavras_mais_consultadas = [
            palavra for palavra, consultas in palavras_consultadas
            if consultas == max_consultas
        ]

        if max_consultas == 0:
            palavras_mais_consultadas = [
                palavra for palavra, _ in palavras_consultadas
            ]

        palavras_mais_consultadas.sort()

        print("palavras mais consultadas:")
        for palavra in palavras_mais_consultadas:
            print(palavra)

        print(f"numero de acessos: {max_consultas}")

    # OK - QUESTAO 4 - LISTA PALAVRAS EM ORDEM ALFABETICA
    def imprimir_palavras_em_ordem_alfabetica(self, l1, l2):
        palavras = []
        for bucket in self.tabela_hash:
            for palavra, _ in bucket:
                if l1 <= palavra[0] <= l2:
                    palavras.append(palavra)

        if not palavras:
            print("palavras em ordem:")
            print("lista vazia")
            return

        palavras.sort()
        print("palavras em ordem:")
        for palavra in palavras:
            print(palavra)

            
    # OK - QUESTAO 5 - REMOVE PALAVRA
    def remover_palavra(self, palavra):
        indice = self.h(palavra)
        for item in self.tabela_hash[indice]:
            if item[0] == palavra:
                self.tabela_hash[indice].remove(item)
                print(f"palavra removida: {palavra}")
                return
        print(f"palavra inexistente: {palavra}")

    
    # OK - QUESTAO 6 - LISTA PALAVRAS EM NIVEL
    def listar_palavras_na_entrada(self, n):
        if n < 0 or n >= len(self.tabela_hash):
            print(f"indice invalido: {n}")
            return

        palavras = [item[0] for item in self.tabela_hash[n]]

        if not palavras:
            print(f"nao ha palavras na lista de indice: {n}")
            return

        palavras.sort()
        print(f"palavras na entrada: {n}")
        for palavra in palavras:
            print(palavra)

    
    # OK - QUESTAO 7 - IMPRIMIR TABELA HASH
    def imprimir_tabela_hash(self):
        for indice in range(len(self.tabela_hash)):
            palavras_ordenadas = sorted(self.tabela_hash[indice])
            linha_saida = f"{indice}: "
            for palavra, consultas in palavras_ordenadas:
                linha_saida += f"{palavra} {consultas} "
            print(linha_saida.strip())

#include <iomanip>
#include <iostream>
using namespace std;
/*
Entrada
Serão dados em uma única linha o número inteiro ‘X’ de inscrição do
candidato (1 <= X <= 1000), seguido de mais 5 notas inteiras N1, N2, N3, N4
e N5 (0 <= N1, N2, N3, N4, N5 <= 10), relativas ao Tiro ao alvo, Natação,
Esgrima, Hipismo e Corrida.
Saída
A saída deve imprimir o número de inscrição do atleta seguido de sua
média final com uma casa decimal de precisão
*/
int main() {
  int X;
  int N1, N2, N3, N4, N5;
  float media;
  cin >> X >> N1 >> N2 >> N3 >> N4 >> N5;
  // static_cast<float> onverte a soma das notas em um número de ponto flutuante
  // antes de realizar a divisão
  media = static_cast<float>(N1 + N2 + N3 + N4 + N5) / 5;
  cout << fixed << setprecision(1);
  cout << X << " " << media;
  return 0;
}
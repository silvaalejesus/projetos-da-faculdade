#include <cmath>
#include <iostream>

using namespace std;

int main() {
  int ataques;
  const int danoBase = 150;
  const double percentualAumento = 0.15;

  cin >> ataques;

  double danoTotal =( danoBase * percentualAumento) +ataques;

  cout << "dano" << danoTotal;
  // Arredondar o dano total para o inteiro mais próximo
  int danoTotalInteiro = static_cast<int>(round(danoTotal));

  cout << danoTotalInteiro << endl;

  return 0;
}

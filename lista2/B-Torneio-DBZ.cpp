#include <iostream>
using namespace std;

int main() {
  int N1, N2, N3, N4, N5, soma = 0;

  cin >> N1 >> N2 >> N3 >> N4 >> N5;
  soma += N1 + N2 + N3 + N4 + N5;

  if (soma > 5000) {
    cout << "Acesso proibido";
  } else {
    cout << "Acesso liberado";
  }
  return 0;
}
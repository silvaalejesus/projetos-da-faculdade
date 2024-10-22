#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  int levi = 20;
  int soldados = 5;
  int total = levi + soldados;
  int quant_soldados = (N - levi) / soldados;
  if ((N - levi) % soldados != 0) {
    quant_soldados += 1;
  }
  cout << quant_soldados << endl;
  return 0;
}

#include <iostream>
using namespace std;

int main() {
  int N = 0;
  cin >> N;
  int horas = N / 3600;
  int minutos = (N - (horas * 3600)) / 60;
  int segundos = N % 60;

  cout << horas << "h " << minutos << "m " << segundos << "s";
}
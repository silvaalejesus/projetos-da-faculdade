#include <iostream>
using namespace std;

int main() {
  int N, XP;
 
  cin >> N >> XP;
  int XPi[3];

  int total = 0;

  for (int i = 0; i < 3; i++) {
    cin >> XPi[i];
  }

  string nomes[3] = {"Yoda", "Luke", "Ahsoka"};

  for (int i = 0; i < 3; i++) {
    total = (N * XP) + XPi[i];
    cout << nomes[i] << " " << total << "\n";
  }

  return 0;
}
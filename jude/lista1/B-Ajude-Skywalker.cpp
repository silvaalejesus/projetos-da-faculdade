#include <iostream>
using namespace std;

int main() {
  int A, B, C, D, E, total = 0;
  
  cin >> A >> B >> C >> D >> E;
  total = A-(B+C+D+E);
  
  cout << total;
  return 0;
}
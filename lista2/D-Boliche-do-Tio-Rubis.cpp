#include <iostream>
using namespace std;

int main() {
  int A, B, C;
  cin >> A >> B >> C;
  if (C/B < A) {
    cout << "S";
  } else {
    cout << "N";
  }
  return 0;
}
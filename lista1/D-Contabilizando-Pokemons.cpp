#include <iostream>
using namespace std;

int main() {
  int K, J, H;
  int QTK, QTJ, QTH;

  cin >> K >> J >> H;
  cin >> QTK >> QTJ >> QTH;
  
  int totalK = K + QTK, totalJ = J + QTJ, totalH = H + QTH;
  
  cout << totalK << " " << totalJ << " " << totalH << "\n";
}
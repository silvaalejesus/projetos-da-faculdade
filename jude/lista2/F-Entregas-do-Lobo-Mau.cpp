#include <iostream>
using namespace std;

int main() {
    int T, D, V, P;
    cin >> T >> D >> V >> P;
    int num_pedagios = T / D;
    if (T % D == 0) num_pedagios--;
    int valor_total = V * T + P * num_pedagios;
    cout << valor_total << endl;
    return 0;
}

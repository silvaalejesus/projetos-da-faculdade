#include <iostream>
using namespace std;

int main() {
    int T, X;
    cin >> T >> X;

    int pontoTermino = X % T;

    cout << pontoTermino << endl;

    return 0;
}

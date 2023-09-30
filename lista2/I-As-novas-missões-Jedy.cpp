#include <iostream>
using namespace std;

int main() {
    int N, XP;
    cin >> N >> XP;

    int xp_yoda, xp_luke, xp_ahsoka;
    cin >> xp_yoda >> xp_luke >> xp_ahsoka;

    xp_yoda += N * XP;
    xp_luke += N * XP;
    xp_ahsoka += N * XP;

    cout << "Yoda " << xp_yoda << endl;
    cout << "Luke " << xp_luke << endl;
    cout << "Ahsoka " << xp_ahsoka << endl;

    return 0;
}

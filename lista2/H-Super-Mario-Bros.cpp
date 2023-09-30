#include <iostream>
using namespace std;

int main() {
    int SC, MM, CK;
    cin >> SC >> MM >> CK;

    if (SC < 30) {
        int missao_sc = 30 - SC;
        int missao_mm = 6 - MM;
        int missao_ck = 3 - CK;
        cout << missao_sc << " " << missao_mm << " " << missao_ck << endl;
    } else {
        cout << "PROXIMO MUNDO" << endl;
    }

    return 0;
}

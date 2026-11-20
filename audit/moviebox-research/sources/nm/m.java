package nm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends c {
    @Override // nm.c, nm.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (hVar.i()) {
            char c11 = hVar.c();
            hVar.f72074f++;
            c(c11, sb2);
            if (sb2.length() % 3 == 0) {
                c.h(hVar, sb2);
                if (j.n(hVar.d(), hVar.f72074f, f()) != f()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        g(hVar, sb2);
    }

    @Override // nm.c
    public int c(char c11, StringBuilder sb2) {
        if (c11 == '\r') {
            sb2.append((char) 0);
        } else if (c11 == ' ') {
            sb2.append((char) 3);
        } else if (c11 == '*') {
            sb2.append((char) 1);
        } else if (c11 == '>') {
            sb2.append((char) 2);
        } else if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) (c11 - ','));
        } else if (c11 < 'A' || c11 > 'Z') {
            j.e(c11);
        } else {
            sb2.append((char) (c11 - '3'));
        }
        return 1;
    }

    @Override // nm.c
    public int f() {
        return 3;
    }

    @Override // nm.c
    public void g(h hVar, StringBuilder sb2) {
        hVar.p();
        int iA = hVar.g().a() - hVar.a();
        hVar.f72074f -= sb2.length();
        if (hVar.f() > 1 || iA > 1 || hVar.f() != iA) {
            hVar.r((char) 254);
        }
        if (hVar.e() < 0) {
            hVar.o(0);
        }
    }
}

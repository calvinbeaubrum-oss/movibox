package nm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements g {
    public static void b(char c11, StringBuilder sb2) {
        if (c11 >= ' ' && c11 <= '?') {
            sb2.append(c11);
        } else if (c11 < '@' || c11 > '^') {
            j.e(c11);
        } else {
            sb2.append((char) (c11 - '@'));
        }
    }

    private static String c(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(0) << 18) + ((length >= 2 ? charSequence.charAt(1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(3) : (char) 0);
        char c11 = (char) ((iCharAt >> 16) & 255);
        char c12 = (char) ((iCharAt >> 8) & 255);
        char c13 = (char) (iCharAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c11);
        if (length >= 2) {
            sb2.append(c12);
        }
        if (length >= 3) {
            sb2.append(c13);
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0081 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:3:0x0001, B:9:0x000f, B:11:0x0025, B:22:0x0049, B:28:0x005a, B:30:0x0072, B:33:0x008a, B:32:0x0081, B:36:0x0091, B:37:0x0098), top: B:40:0x0001 }] */
    public static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                hVar.o(0);
                return;
            }
            boolean z11 = true;
            if (length == 1) {
                hVar.p();
                int iA = hVar.g().a() - hVar.a();
                int iF = hVar.f();
                if (iF > iA) {
                    hVar.q(hVar.a() + 1);
                    iA = hVar.g().a() - hVar.a();
                }
                if (iF <= iA && iA <= 2) {
                    hVar.o(0);
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i11 = length - 1;
            String strC = c(charSequence);
            if (!(!hVar.i()) || i11 > 2) {
                z11 = false;
            }
            if (i11 <= 2) {
                hVar.q(hVar.a() + i11);
                if (hVar.g().a() - hVar.a() >= 3) {
                    hVar.q(hVar.a() + strC.length());
                } else if (z11) {
                    hVar.k();
                    hVar.f72074f -= i11;
                }
                hVar.s(strC);
            } else if (z11) {
                hVar.k();
                hVar.f72074f -= i11;
            } else {
                hVar.s(strC);
            }
            hVar.o(0);
        } catch (Throwable th2) {
            hVar.o(0);
            throw th2;
        }
    }

    @Override // nm.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (hVar.i()) {
            b(hVar.c(), sb2);
            hVar.f72074f++;
            if (sb2.length() >= 4) {
                hVar.s(c(sb2));
                sb2.delete(0, 4);
                if (j.n(hVar.d(), hVar.f72074f, d()) != d()) {
                    hVar.o(0);
                    break;
                }
            }
        }
        sb2.append((char) 31);
        e(hVar, sb2);
    }

    public int d() {
        return 4;
    }
}

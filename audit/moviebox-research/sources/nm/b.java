package nm;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements g {
    public static char c(char c11, int i11) {
        int i12 = c11 + ((i11 * 149) % 255) + 1;
        return i12 <= 255 ? (char) i12 : (char) (i12 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // nm.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((char) 0);
        while (hVar.i()) {
            sb2.append(hVar.c());
            hVar.f72074f++;
            if (j.n(hVar.d(), hVar.f72074f, b()) != b()) {
                hVar.o(0);
                break;
            }
        }
        int length = sb2.length() - 1;
        int iA = hVar.a() + length + 1;
        hVar.q(iA);
        boolean z11 = hVar.g().a() - iA > 0;
        if (hVar.i() || z11) {
            if (length <= 249) {
                sb2.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb2.setCharAt(0, (char) ((length / 250) + 249));
                sb2.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb2.length();
        for (int i11 = 0; i11 < length2; i11++) {
            hVar.r(c(sb2.charAt(i11), hVar.a() + 1));
        }
    }

    public int b() {
        return 5;
    }
}

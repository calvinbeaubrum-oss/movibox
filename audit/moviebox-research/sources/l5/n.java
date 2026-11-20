package l5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static int a(int i11, c0 c0Var, int i12) {
        if (i11 == 12) {
            return 240;
        }
        if (i11 == 13) {
            return 120;
        }
        if (i11 == 21 && c0Var.a() >= 8 && c0Var.f() + 8 <= i12) {
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            if (iQ >= 12 && iQ2 == 1936877170) {
                return c0Var.I();
            }
        }
        return -2147483647;
    }

    @Nullable
    public static Metadata b(c0 c0Var, int i11) {
        c0Var.V(12);
        while (c0Var.f() < i11) {
            int iF = c0Var.f();
            int iQ = c0Var.q();
            if (c0Var.q() == 1935766900) {
                if (iQ < 16) {
                    return null;
                }
                c0Var.V(4);
                int i12 = -1;
                int i13 = 0;
                for (int i14 = 0; i14 < 2; i14++) {
                    int iH = c0Var.H();
                    int iH2 = c0Var.H();
                    if (iH == 0) {
                        i12 = iH2;
                    } else if (iH == 1) {
                        i13 = iH2;
                    }
                }
                int iA = a(i12, c0Var, i11);
                if (iA == -2147483647) {
                    return null;
                }
                return new Metadata(new SmtaMetadataEntry(iA, i13));
            }
            c0Var.U(iF + iQ);
        }
        return null;
    }
}

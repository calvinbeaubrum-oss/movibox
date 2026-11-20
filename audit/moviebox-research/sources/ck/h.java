package ck;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import java.util.BitSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14950a = new h();

    public static BitSet a(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i11 : iArr) {
            bitSet.set(i11);
        }
        return bitSet;
    }

    public static boolean e(char c11) {
        return c11 == ' ' || c11 == '\t' || c11 == '\r' || c11 == '\n';
    }

    public void b(CharArrayBuffer charArrayBuffer, g gVar, BitSet bitSet, StringBuilder sb2) {
        int iB = gVar.b();
        int iC = gVar.c();
        for (int iB2 = gVar.b(); iB2 < iC; iB2++) {
            char cCharAt = charArrayBuffer.charAt(iB2);
            if ((bitSet != null && bitSet.get(cCharAt)) || e(cCharAt)) {
                break;
            }
            iB++;
            sb2.append(cCharAt);
        }
        gVar.d(iB);
    }

    public void c(CharArrayBuffer charArrayBuffer, g gVar, StringBuilder sb2) {
        if (gVar.a()) {
            return;
        }
        int iB = gVar.b();
        int iB2 = gVar.b();
        int iC = gVar.c();
        if (charArrayBuffer.charAt(iB) != '\"') {
            return;
        }
        int i11 = iB + 1;
        int i12 = iB2 + 1;
        boolean z11 = false;
        while (i12 < iC) {
            char cCharAt = charArrayBuffer.charAt(i12);
            if (z11) {
                if (cCharAt != '\"' && cCharAt != '\\') {
                    sb2.append('\\');
                }
                sb2.append(cCharAt);
                z11 = false;
            } else if (cCharAt == '\"') {
                i11++;
                break;
            } else if (cCharAt == '\\') {
                z11 = true;
            } else if (cCharAt != '\r' && cCharAt != '\n') {
                sb2.append(cCharAt);
            }
            i12++;
            i11++;
        }
        gVar.d(i11);
    }

    public void d(CharArrayBuffer charArrayBuffer, g gVar, BitSet bitSet, StringBuilder sb2) {
        int iB = gVar.b();
        int iC = gVar.c();
        for (int iB2 = gVar.b(); iB2 < iC; iB2++) {
            char cCharAt = charArrayBuffer.charAt(iB2);
            if ((bitSet != null && bitSet.get(cCharAt)) || e(cCharAt) || cCharAt == '\"') {
                break;
            }
            iB++;
            sb2.append(cCharAt);
        }
        gVar.d(iB);
    }

    public String f(CharArrayBuffer charArrayBuffer, g gVar, BitSet bitSet) {
        StringBuilder sb2 = new StringBuilder();
        loop0: while (true) {
            boolean z11 = false;
            while (true) {
                if (!gVar.a()) {
                    char cCharAt = charArrayBuffer.charAt(gVar.b());
                    if (bitSet != null && bitSet.get(cCharAt)) {
                        break loop0;
                    }
                    if (e(cCharAt)) {
                        h(charArrayBuffer, gVar);
                        z11 = true;
                    }
                } else {
                    break loop0;
                }
            }
            if (z11 && sb2.length() > 0) {
                sb2.append(' ');
            }
            b(charArrayBuffer, gVar, bitSet, sb2);
        }
        return sb2.toString();
    }

    public String g(CharArrayBuffer charArrayBuffer, g gVar, BitSet bitSet) {
        char cCharAt;
        StringBuilder sb2 = new StringBuilder();
        loop0: while (true) {
            boolean z11 = false;
            while (true) {
                if (!gVar.a()) {
                    cCharAt = charArrayBuffer.charAt(gVar.b());
                    if (bitSet != null && bitSet.get(cCharAt)) {
                        break loop0;
                    }
                    if (e(cCharAt)) {
                        h(charArrayBuffer, gVar);
                        z11 = true;
                    }
                } else {
                    break loop0;
                }
            }
            if (cCharAt == '\"') {
                if (z11 && sb2.length() > 0) {
                    sb2.append(' ');
                }
                c(charArrayBuffer, gVar, sb2);
            } else {
                if (z11 && sb2.length() > 0) {
                    sb2.append(' ');
                }
                d(charArrayBuffer, gVar, bitSet, sb2);
            }
        }
        return sb2.toString();
    }

    public void h(CharArrayBuffer charArrayBuffer, g gVar) {
        int iB = gVar.b();
        int iC = gVar.c();
        for (int iB2 = gVar.b(); iB2 < iC && e(charArrayBuffer.charAt(iB2)); iB2++) {
            iB++;
        }
        gVar.d(iB);
    }
}

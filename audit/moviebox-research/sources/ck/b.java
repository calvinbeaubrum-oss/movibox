package ck;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final b f14934a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f14935b = new b();

    public void a(CharArrayBuffer charArrayBuffer, String str, boolean z11) {
        if (!z11) {
            for (int i11 = 0; i11 < str.length() && !z11; i11++) {
                z11 = f(str.charAt(i11));
            }
        }
        if (z11) {
            charArrayBuffer.append('\"');
        }
        for (int i12 = 0; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            if (g(cCharAt)) {
                charArrayBuffer.append('\\');
            }
            charArrayBuffer.append(cCharAt);
        }
        if (z11) {
            charArrayBuffer.append('\"');
        }
    }

    public int b(o oVar) {
        if (oVar == null) {
            return 0;
        }
        int length = oVar.getName().length();
        String value = oVar.getValue();
        return value != null ? length + value.length() + 3 : length;
    }

    public int c(o[] oVarArr) {
        if (oVarArr == null || oVarArr.length < 1) {
            return 0;
        }
        int length = (oVarArr.length - 1) * 2;
        for (o oVar : oVarArr) {
            length += b(oVar);
        }
        return length;
    }

    public CharArrayBuffer d(CharArrayBuffer charArrayBuffer, o oVar, boolean z11) {
        fk.a.g(oVar, "Name / value pair");
        int iB = b(oVar);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(iB);
        } else {
            charArrayBuffer.ensureCapacity(iB);
        }
        charArrayBuffer.append(oVar.getName());
        String value = oVar.getValue();
        if (value != null) {
            charArrayBuffer.append('=');
            a(charArrayBuffer, value, z11);
        }
        return charArrayBuffer;
    }

    public CharArrayBuffer e(CharArrayBuffer charArrayBuffer, o[] oVarArr, boolean z11) {
        fk.a.g(oVarArr, "Header parameter array");
        int iC = c(oVarArr);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(iC);
        } else {
            charArrayBuffer.ensureCapacity(iC);
        }
        for (int i11 = 0; i11 < oVarArr.length; i11++) {
            if (i11 > 0) {
                charArrayBuffer.append("; ");
            }
            d(charArrayBuffer, oVarArr[i11], z11);
        }
        return charArrayBuffer;
    }

    public boolean f(char c11) {
        return " ;,:@()<>\\\"/[]?={}\t".indexOf(c11) >= 0;
    }

    public boolean g(char c11) {
        return "\"\\".indexOf(c11) >= 0;
    }
}

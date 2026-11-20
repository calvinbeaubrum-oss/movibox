package ck;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final c f14936b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f14937c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BitSet f14938d = h.a(61, 59, 44);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BitSet f14939e = h.a(59, 44);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14940a = h.f14950a;

    public static com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e[] d(String str, f fVar) throws ParseException {
        fk.a.g(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        g gVar = new g(0, str.length());
        if (fVar == null) {
            fVar = f14937c;
        }
        return fVar.a(charArrayBuffer, gVar);
    }

    @Override // ck.f
    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e[] a(CharArrayBuffer charArrayBuffer, g gVar) {
        fk.a.g(charArrayBuffer, "Char array buffer");
        fk.a.g(gVar, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!gVar.a()) {
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e eVarE = e(charArrayBuffer, gVar);
            if (eVarE.getName().length() != 0 || eVarE.getValue() != null) {
                arrayList.add(eVarE);
            }
        }
        return (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e[]) arrayList.toArray(new com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e[arrayList.size()]);
    }

    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e b(String str, String str2, o[] oVarArr) {
        return new a(str, str2, oVarArr);
    }

    public o c(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }

    public com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e e(CharArrayBuffer charArrayBuffer, g gVar) {
        fk.a.g(charArrayBuffer, "Char array buffer");
        fk.a.g(gVar, "Parser cursor");
        o oVarF = f(charArrayBuffer, gVar);
        return b(oVarF.getName(), oVarF.getValue(), (gVar.a() || charArrayBuffer.charAt(gVar.b() + (-1)) == ',') ? null : g(charArrayBuffer, gVar));
    }

    public o f(CharArrayBuffer charArrayBuffer, g gVar) {
        fk.a.g(charArrayBuffer, "Char array buffer");
        fk.a.g(gVar, "Parser cursor");
        String strF = this.f14940a.f(charArrayBuffer, gVar, f14938d);
        if (gVar.a()) {
            return new BasicNameValuePair(strF, null);
        }
        char cCharAt = charArrayBuffer.charAt(gVar.b());
        gVar.d(gVar.b() + 1);
        if (cCharAt != '=') {
            return c(strF, null);
        }
        String strG = this.f14940a.g(charArrayBuffer, gVar, f14939e);
        if (!gVar.a()) {
            gVar.d(gVar.b() + 1);
        }
        return c(strF, strG);
    }

    public o[] g(CharArrayBuffer charArrayBuffer, g gVar) {
        fk.a.g(charArrayBuffer, "Char array buffer");
        fk.a.g(gVar, "Parser cursor");
        this.f14940a.h(charArrayBuffer, gVar);
        ArrayList arrayList = new ArrayList();
        while (!gVar.a()) {
            arrayList.add(f(charArrayBuffer, gVar));
            if (charArrayBuffer.charAt(gVar.b() - 1) == ',') {
                break;
            }
        }
        return (o[]) arrayList.toArray(new o[arrayList.size()]);
    }
}

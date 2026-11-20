package nm;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SymbolShapeHint f72070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.zxing.c f72071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.google.zxing.c f72072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StringBuilder f72073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f72076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f72077i;

    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i11 = 0; i11 < length; i11++) {
            char c11 = (char) (bytes[i11] & 255);
            if (c11 == '?' && str.charAt(i11) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c11);
        }
        this.f72069a = sb2.toString();
        this.f72070b = SymbolShapeHint.FORCE_NONE;
        this.f72073e = new StringBuilder(str.length());
        this.f72075g = -1;
    }

    public int a() {
        return this.f72073e.length();
    }

    public StringBuilder b() {
        return this.f72073e;
    }

    public char c() {
        return this.f72069a.charAt(this.f72074f);
    }

    public String d() {
        return this.f72069a;
    }

    public int e() {
        return this.f72075g;
    }

    public int f() {
        return h() - this.f72074f;
    }

    public k g() {
        return this.f72076h;
    }

    public final int h() {
        return this.f72069a.length() - this.f72077i;
    }

    public boolean i() {
        return this.f72074f < h();
    }

    public void j() {
        this.f72075g = -1;
    }

    public void k() {
        this.f72076h = null;
    }

    public void l(com.google.zxing.c cVar, com.google.zxing.c cVar2) {
        this.f72071c = cVar;
        this.f72072d = cVar2;
    }

    public void m(int i11) {
        this.f72077i = i11;
    }

    public void n(SymbolShapeHint symbolShapeHint) {
        this.f72070b = symbolShapeHint;
    }

    public void o(int i11) {
        this.f72075g = i11;
    }

    public void p() {
        q(a());
    }

    public void q(int i11) {
        k kVar = this.f72076h;
        if (kVar == null || i11 > kVar.a()) {
            this.f72076h = k.l(i11, this.f72070b, this.f72071c, this.f72072d, true);
        }
    }

    public void r(char c11) {
        this.f72073e.append(c11);
    }

    public void s(String str) {
        this.f72073e.append(str);
    }
}

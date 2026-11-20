package bn;

import an.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f14288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f14289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f14290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14291d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f14292e;

    public static boolean b(int i11) {
        return i11 >= 0 && i11 < 8;
    }

    public b a() {
        return this.f14292e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f14289b = errorCorrectionLevel;
    }

    public void d(int i11) {
        this.f14291d = i11;
    }

    public void e(b bVar) {
        this.f14292e = bVar;
    }

    public void f(Mode mode) {
        this.f14288a = mode;
    }

    public void g(f fVar) {
        this.f14290c = fVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f14288a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f14289b);
        sb2.append("\n version: ");
        sb2.append(this.f14290c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f14291d);
        if (this.f14292e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f14292e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}

package nm;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k[] f72082i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static k[] f72083j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f72084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f72087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f72088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f72089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f72090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f72091h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, 174, 68, 22, 22, 4), new k(false, 204, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, PsExtractor.AUDIO_STREAM, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, 272, 22, 22, 16, 174, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, TTAdConstant.DOWNLOAD_URL_CODE, 18, 18, 36, 175, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f72082i = kVarArr;
        f72083j = kVarArr;
    }

    public k(boolean z11, int i11, int i12, int i13, int i14, int i15) {
        this(z11, i11, i12, i13, i14, i15, i11, i12);
    }

    public k(boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f72084a = z11;
        this.f72085b = i11;
        this.f72086c = i12;
        this.f72087d = i13;
        this.f72088e = i14;
        this.f72089f = i15;
        this.f72090g = i16;
        this.f72091h = i17;
    }

    public static k l(int i11, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z11) {
        for (k kVar : f72083j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.f72084a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.f72084a) && ((cVar == null || (kVar.j() >= cVar.b() && kVar.i() >= cVar.a())) && ((cVar2 == null || (kVar.j() <= cVar2.b() && kVar.i() <= cVar2.a())) && i11 <= kVar.f72085b)))) {
                return kVar;
            }
        }
        if (!z11) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i11);
    }

    public final int a() {
        return this.f72085b;
    }

    public int b(int i11) {
        return this.f72090g;
    }

    public final int c() {
        return this.f72086c;
    }

    public final int d(int i11) {
        return this.f72091h;
    }

    public final int e() {
        int i11 = this.f72089f;
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (i11 != 2 && i11 != 4) {
                if (i11 == 16) {
                    return 4;
                }
                if (i11 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i12;
    }

    public int f() {
        return this.f72085b / this.f72090g;
    }

    public final int g() {
        return k() * this.f72088e;
    }

    public final int h() {
        return e() * this.f72087d;
    }

    public final int i() {
        return g() + (k() * 2);
    }

    public final int j() {
        return h() + (e() * 2);
    }

    public final int k() {
        int i11 = this.f72089f;
        if (i11 == 1 || i11 == 2) {
            return 1;
        }
        if (i11 == 4) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f72084a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f72087d);
        sb2.append('x');
        sb2.append(this.f72088e);
        sb2.append(", symbol size ");
        sb2.append(j());
        sb2.append('x');
        sb2.append(i());
        sb2.append(", symbol data size ");
        sb2.append(h());
        sb2.append('x');
        sb2.append(g());
        sb2.append(", codewords ");
        sb2.append(this.f72085b);
        sb2.append('+');
        sb2.append(this.f72086c);
        return sb2.toString();
    }
}

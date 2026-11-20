package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements Comparable<o> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String[] f7019u = {RequestParameters.POSITION, "x", "y", "width", "height", "pathRotate"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.c f7020a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7023d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f7025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f7027i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7032n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f7033o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f7034p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7035q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7036r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f7037s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public double[] f7038t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7021b = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f7028j = Float.NaN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f7029k = Float.NaN;

    public o() {
        int i11 = d.f6866f;
        this.f7030l = i11;
        this.f7031m = i11;
        this.f7032n = Float.NaN;
        this.f7033o = null;
        this.f7034p = new LinkedHashMap<>();
        this.f7035q = 0;
        this.f7037s = new double[18];
        this.f7038t = new double[18];
    }

    public o(int i11, int i12, h hVar, o oVar, o oVar2) {
        int i13 = d.f6866f;
        this.f7030l = i13;
        this.f7031m = i13;
        this.f7032n = Float.NaN;
        this.f7033o = null;
        this.f7034p = new LinkedHashMap<>();
        this.f7035q = 0;
        this.f7037s = new double[18];
        this.f7038t = new double[18];
        if (oVar.f7031m != d.f6866f) {
            p(i11, i12, hVar, oVar, oVar2);
            return;
        }
        int i14 = hVar.f6922q;
        if (i14 == 1) {
            o(hVar, oVar, oVar2);
        } else if (i14 != 2) {
            n(hVar, oVar, oVar2);
        } else {
            q(i11, i12, hVar, oVar, oVar2);
        }
    }

    public void a(androidx.constraintlayout.widget.b.a aVar) {
        this.f7020a = androidx.constraintlayout.core.motion.utils.c.c(aVar.f7380d.f7445d);
        androidx.constraintlayout.widget.b.c cVar = aVar.f7380d;
        this.f7030l = cVar.f7446e;
        this.f7031m = cVar.f7443b;
        this.f7028j = cVar.f7450i;
        this.f7021b = cVar.f7447f;
        this.f7036r = cVar.f7444c;
        this.f7029k = aVar.f7379c.f7460e;
        this.f7032n = aVar.f7381e.D;
        for (String str : aVar.f7383g.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f7383g.get(str);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.f7034p.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull o oVar) {
        return Float.compare(this.f7023d, oVar.f7023d);
    }

    public final boolean c(float f11, float f12) {
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            return Float.isNaN(f11) != Float.isNaN(f12);
        }
        return Math.abs(f11 - f12) > 1.0E-6f;
    }

    public void d(o oVar, boolean[] zArr, String[] strArr, boolean z11) {
        boolean zC = c(this.f7024f, oVar.f7024f);
        boolean zC2 = c(this.f7025g, oVar.f7025g);
        zArr[0] = zArr[0] | c(this.f7023d, oVar.f7023d);
        boolean z12 = zC | zC2 | z11;
        zArr[1] = zArr[1] | z12;
        zArr[2] = z12 | zArr[2];
        zArr[3] = zArr[3] | c(this.f7026h, oVar.f7026h);
        zArr[4] = c(this.f7027i, oVar.f7027i) | zArr[4];
    }

    public void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.f7023d, this.f7024f, this.f7025g, this.f7026h, this.f7027i, this.f7028j};
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < 6) {
                dArr[i11] = fArr[i12];
                i11++;
            }
        }
    }

    public void h(double d11, int[] iArr, double[] dArr, float[] fArr, int i11) {
        float fSin = this.f7024f;
        float fCos = this.f7025g;
        float f11 = this.f7026h;
        float f12 = this.f7027i;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f13 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                fSin = f13;
            } else if (i13 == 2) {
                fCos = f13;
            } else if (i13 == 3) {
                f11 = f13;
            } else if (i13 == 4) {
                f12 = f13;
            }
        }
        m mVar = this.f7033o;
        if (mVar != null) {
            float[] fArr2 = new float[2];
            mVar.i(d11, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d12 = f14;
            double d13 = fSin;
            double d14 = fCos;
            fSin = (float) ((d12 + (Math.sin(d14) * d13)) - ((double) (f11 / 2.0f)));
            fCos = (float) ((((double) f15) - (d13 * Math.cos(d14))) - ((double) (f12 / 2.0f)));
        }
        fArr[i11] = fSin + (f11 / 2.0f) + 0.0f;
        fArr[i11 + 1] = fCos + (f12 / 2.0f) + 0.0f;
    }

    public void i(double d11, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f11 = this.f7024f;
        float f12 = this.f7025g;
        float f13 = this.f7026h;
        float f14 = this.f7027i;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f19 = (float) dArr[i11];
            float f21 = (float) dArr2[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f11 = f19;
                f15 = f21;
            } else if (i12 == 2) {
                f12 = f19;
                f17 = f21;
            } else if (i12 == 3) {
                f13 = f19;
                f16 = f21;
            } else if (i12 == 4) {
                f14 = f19;
                f18 = f21;
            }
        }
        float f22 = 2.0f;
        float f23 = (f16 / 2.0f) + f15;
        float fCos = (f18 / 2.0f) + f17;
        m mVar = this.f7033o;
        if (mVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            mVar.i(d11, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            float f27 = fArr4[1];
            double d12 = f11;
            double d13 = f12;
            float fSin = (float) ((((double) f24) + (Math.sin(d13) * d12)) - ((double) (f13 / 2.0f)));
            float fCos2 = (float) ((((double) f25) - (d12 * Math.cos(d13))) - ((double) (f14 / 2.0f)));
            double d14 = f15;
            double d15 = f17;
            float fSin2 = (float) (((double) f26) + (Math.sin(d13) * d14) + (Math.cos(d13) * d15));
            fCos = (float) ((((double) f27) - (d14 * Math.cos(d13))) + (Math.sin(d13) * d15));
            f23 = fSin2;
            f11 = fSin;
            f12 = fCos2;
            f22 = 2.0f;
        }
        fArr[0] = f11 + (f13 / f22) + 0.0f;
        fArr[1] = f12 + (f14 / f22) + 0.0f;
        fArr2[0] = f23;
        fArr2[1] = fCos;
    }

    public int j(String str, double[] dArr, int i11) {
        ConstraintAttribute constraintAttribute = this.f7034p.get(str);
        int i12 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i11] = constraintAttribute.e();
            return 1;
        }
        int iH = constraintAttribute.h();
        float[] fArr = new float[iH];
        constraintAttribute.f(fArr);
        while (i12 < iH) {
            dArr[i11] = fArr[i12];
            i12++;
            i11++;
        }
        return iH;
    }

    public int k(String str) {
        ConstraintAttribute constraintAttribute = this.f7034p.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    public void l(int[] iArr, double[] dArr, float[] fArr, int i11) {
        float f11 = this.f7024f;
        float fCos = this.f7025g;
        float f12 = this.f7026h;
        float f13 = this.f7027i;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            float f14 = (float) dArr[i12];
            int i13 = iArr[i12];
            if (i13 == 1) {
                f11 = f14;
            } else if (i13 == 2) {
                fCos = f14;
            } else if (i13 == 3) {
                f12 = f14;
            } else if (i13 == 4) {
                f13 = f14;
            }
        }
        m mVar = this.f7033o;
        if (mVar != null) {
            float fJ = mVar.j();
            float fK = this.f7033o.k();
            double d11 = f11;
            double d12 = fCos;
            float fSin = (float) ((((double) fJ) + (Math.sin(d12) * d11)) - ((double) (f12 / 2.0f)));
            fCos = (float) ((((double) fK) - (d11 * Math.cos(d12))) - ((double) (f13 / 2.0f)));
            f11 = fSin;
        }
        float f15 = f12 + f11;
        float f16 = f13 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i11] = f11 + 0.0f;
        fArr[i11 + 1] = fCos + 0.0f;
        fArr[i11 + 2] = f15 + 0.0f;
        fArr[i11 + 3] = fCos + 0.0f;
        fArr[i11 + 4] = f15 + 0.0f;
        fArr[i11 + 5] = f16 + 0.0f;
        fArr[i11 + 6] = f11 + 0.0f;
        fArr[i11 + 7] = f16 + 0.0f;
    }

    public boolean m(String str) {
        return this.f7034p.containsKey(str);
    }

    public void n(h hVar, o oVar, o oVar2) {
        float f11 = hVar.f6867a / 100.0f;
        this.f7022c = f11;
        this.f7021b = hVar.f6915j;
        float f12 = Float.isNaN(hVar.f6916k) ? f11 : hVar.f6916k;
        float f13 = Float.isNaN(hVar.f6917l) ? f11 : hVar.f6917l;
        float f14 = oVar2.f7026h;
        float f15 = oVar.f7026h;
        float f16 = oVar2.f7027i;
        float f17 = oVar.f7027i;
        this.f7023d = this.f7022c;
        float f18 = oVar.f7024f;
        float f19 = oVar.f7025g;
        float f21 = (oVar2.f7024f + (f14 / 2.0f)) - ((f15 / 2.0f) + f18);
        float f22 = (oVar2.f7025g + (f16 / 2.0f)) - (f19 + (f17 / 2.0f));
        float f23 = (f14 - f15) * f12;
        float f24 = f23 / 2.0f;
        this.f7024f = (int) ((f18 + (f21 * f11)) - f24);
        float f25 = (f16 - f17) * f13;
        float f26 = f25 / 2.0f;
        this.f7025g = (int) ((f19 + (f22 * f11)) - f26);
        this.f7026h = (int) (f15 + f23);
        this.f7027i = (int) (f17 + f25);
        float f27 = Float.isNaN(hVar.f6918m) ? f11 : hVar.f6918m;
        float f28 = Float.isNaN(hVar.f6921p) ? 0.0f : hVar.f6921p;
        if (!Float.isNaN(hVar.f6919n)) {
            f11 = hVar.f6919n;
        }
        float f29 = Float.isNaN(hVar.f6920o) ? 0.0f : hVar.f6920o;
        this.f7035q = 0;
        this.f7024f = (int) (((oVar.f7024f + (f27 * f21)) + (f29 * f22)) - f24);
        this.f7025g = (int) (((oVar.f7025g + (f21 * f28)) + (f22 * f11)) - f26);
        this.f7020a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f6913h);
        this.f7030l = hVar.f6914i;
    }

    public void o(h hVar, o oVar, o oVar2) {
        float f11 = hVar.f6867a / 100.0f;
        this.f7022c = f11;
        this.f7021b = hVar.f6915j;
        float f12 = Float.isNaN(hVar.f6916k) ? f11 : hVar.f6916k;
        float f13 = Float.isNaN(hVar.f6917l) ? f11 : hVar.f6917l;
        float f14 = oVar2.f7026h - oVar.f7026h;
        float f15 = oVar2.f7027i - oVar.f7027i;
        this.f7023d = this.f7022c;
        if (!Float.isNaN(hVar.f6918m)) {
            f11 = hVar.f6918m;
        }
        float f16 = oVar.f7024f;
        float f17 = oVar.f7026h;
        float f18 = oVar.f7025g;
        float f19 = oVar.f7027i;
        float f21 = (oVar2.f7024f + (oVar2.f7026h / 2.0f)) - ((f17 / 2.0f) + f16);
        float f22 = (oVar2.f7025g + (oVar2.f7027i / 2.0f)) - ((f19 / 2.0f) + f18);
        float f23 = f21 * f11;
        float f24 = f14 * f12;
        float f25 = f24 / 2.0f;
        this.f7024f = (int) ((f16 + f23) - f25);
        float f26 = f11 * f22;
        float f27 = f15 * f13;
        float f28 = f27 / 2.0f;
        this.f7025g = (int) ((f18 + f26) - f28);
        this.f7026h = (int) (f17 + f24);
        this.f7027i = (int) (f19 + f27);
        float f29 = Float.isNaN(hVar.f6919n) ? 0.0f : hVar.f6919n;
        this.f7035q = 1;
        float f31 = (int) ((oVar.f7024f + f23) - f25);
        float f32 = (int) ((oVar.f7025g + f26) - f28);
        this.f7024f = f31 + ((-f22) * f29);
        this.f7025g = f32 + (f21 * f29);
        this.f7031m = this.f7031m;
        this.f7020a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f6913h);
        this.f7030l = hVar.f6914i;
    }

    public void p(int i11, int i12, h hVar, o oVar, o oVar2) {
        float fMin;
        float f11;
        float f12 = hVar.f6867a / 100.0f;
        this.f7022c = f12;
        this.f7021b = hVar.f6915j;
        this.f7035q = hVar.f6922q;
        float f13 = Float.isNaN(hVar.f6916k) ? f12 : hVar.f6916k;
        float f14 = Float.isNaN(hVar.f6917l) ? f12 : hVar.f6917l;
        float f15 = oVar2.f7026h;
        float f16 = oVar.f7026h;
        float f17 = oVar2.f7027i;
        float f18 = oVar.f7027i;
        this.f7023d = this.f7022c;
        this.f7026h = (int) (f16 + ((f15 - f16) * f13));
        this.f7027i = (int) (f18 + ((f17 - f18) * f14));
        int i13 = hVar.f6922q;
        if (i13 == 1) {
            float f19 = Float.isNaN(hVar.f6918m) ? f12 : hVar.f6918m;
            float f21 = oVar2.f7024f;
            float f22 = oVar.f7024f;
            this.f7024f = (f19 * (f21 - f22)) + f22;
            if (!Float.isNaN(hVar.f6919n)) {
                f12 = hVar.f6919n;
            }
            float f23 = oVar2.f7025g;
            float f24 = oVar.f7025g;
            this.f7025g = (f12 * (f23 - f24)) + f24;
        } else if (i13 != 2) {
            float f25 = Float.isNaN(hVar.f6918m) ? f12 : hVar.f6918m;
            float f26 = oVar2.f7024f;
            float f27 = oVar.f7024f;
            this.f7024f = (f25 * (f26 - f27)) + f27;
            if (!Float.isNaN(hVar.f6919n)) {
                f12 = hVar.f6919n;
            }
            float f28 = oVar2.f7025g;
            float f29 = oVar.f7025g;
            this.f7025g = (f12 * (f28 - f29)) + f29;
        } else {
            if (Float.isNaN(hVar.f6918m)) {
                float f31 = oVar2.f7024f;
                float f32 = oVar.f7024f;
                fMin = ((f31 - f32) * f12) + f32;
            } else {
                fMin = Math.min(f14, f13) * hVar.f6918m;
            }
            this.f7024f = fMin;
            if (Float.isNaN(hVar.f6919n)) {
                float f33 = oVar2.f7025g;
                float f34 = oVar.f7025g;
                f11 = (f12 * (f33 - f34)) + f34;
            } else {
                f11 = hVar.f6919n;
            }
            this.f7025g = f11;
        }
        this.f7031m = oVar.f7031m;
        this.f7020a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f6913h);
        this.f7030l = hVar.f6914i;
    }

    public void q(int i11, int i12, h hVar, o oVar, o oVar2) {
        float f11 = hVar.f6867a / 100.0f;
        this.f7022c = f11;
        this.f7021b = hVar.f6915j;
        float f12 = Float.isNaN(hVar.f6916k) ? f11 : hVar.f6916k;
        float f13 = Float.isNaN(hVar.f6917l) ? f11 : hVar.f6917l;
        float f14 = oVar2.f7026h;
        float f15 = oVar.f7026h;
        float f16 = oVar2.f7027i;
        float f17 = oVar.f7027i;
        this.f7023d = this.f7022c;
        float f18 = oVar.f7024f;
        float f19 = oVar.f7025g;
        float f21 = oVar2.f7024f + (f14 / 2.0f);
        float f22 = oVar2.f7025g + (f16 / 2.0f);
        float f23 = (f14 - f15) * f12;
        this.f7024f = (int) ((f18 + ((f21 - ((f15 / 2.0f) + f18)) * f11)) - (f23 / 2.0f));
        float f24 = (f16 - f17) * f13;
        this.f7025g = (int) ((f19 + ((f22 - (f19 + (f17 / 2.0f))) * f11)) - (f24 / 2.0f));
        this.f7026h = (int) (f15 + f23);
        this.f7027i = (int) (f17 + f24);
        this.f7035q = 2;
        if (!Float.isNaN(hVar.f6918m)) {
            this.f7024f = (int) (hVar.f6918m * ((int) (i11 - this.f7026h)));
        }
        if (!Float.isNaN(hVar.f6919n)) {
            this.f7025g = (int) (hVar.f6919n * ((int) (i12 - this.f7027i)));
        }
        this.f7031m = this.f7031m;
        this.f7020a = androidx.constraintlayout.core.motion.utils.c.c(hVar.f6913h);
        this.f7030l = hVar.f6914i;
    }

    public void r(float f11, float f12, float f13, float f14) {
        this.f7024f = f11;
        this.f7025g = f12;
        this.f7026h = f13;
        this.f7027i = f14;
    }

    public void s(float f11, float f12, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f17 = (float) dArr[i11];
            double d11 = dArr2[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f13 = f17;
            } else if (i12 == 2) {
                f15 = f17;
            } else if (i12 == 3) {
                f14 = f17;
            } else if (i12 == 4) {
                f16 = f17;
            }
        }
        float f18 = f13 - ((0.0f * f14) / 2.0f);
        float f19 = f15 - ((0.0f * f16) / 2.0f);
        fArr[0] = (f18 * (1.0f - f11)) + (((f14 * 1.0f) + f18) * f11) + 0.0f;
        fArr[1] = (f19 * (1.0f - f12)) + (((f16 * 1.0f) + f19) * f12) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t(float f11, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z11) {
        float f12;
        float f13;
        float f14 = this.f7024f;
        float f15 = this.f7025g;
        float f16 = this.f7026h;
        float f17 = this.f7027i;
        if (iArr.length != 0 && this.f7037s.length <= iArr[iArr.length - 1]) {
            int i11 = iArr[iArr.length - 1] + 1;
            this.f7037s = new double[i11];
            this.f7038t = new double[i11];
        }
        Arrays.fill(this.f7037s, Double.NaN);
        for (int i12 = 0; i12 < iArr.length; i12++) {
            double[] dArr4 = this.f7037s;
            int i13 = iArr[i12];
            dArr4[i13] = dArr[i12];
            this.f7038t[i13] = dArr2[i12];
        }
        float f18 = Float.NaN;
        int i14 = 0;
        float f19 = 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        while (true) {
            double[] dArr5 = this.f7037s;
            if (i14 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i14]) && (dArr3 == null || dArr3[i14] == 0.0d)) {
                f13 = f18;
            } else {
                double d11 = dArr3 != null ? dArr3[i14] : 0.0d;
                if (!Double.isNaN(this.f7037s[i14])) {
                    d11 = this.f7037s[i14] + d11;
                }
                f13 = f18;
                float f24 = (float) d11;
                float f25 = (float) this.f7038t[i14];
                if (i14 == 1) {
                    f18 = f13;
                    f19 = f25;
                    f14 = f24;
                } else if (i14 == 2) {
                    f18 = f13;
                    f21 = f25;
                    f15 = f24;
                } else if (i14 == 3) {
                    f18 = f13;
                    f22 = f25;
                    f16 = f24;
                } else if (i14 == 4) {
                    f18 = f13;
                    f23 = f25;
                    f17 = f24;
                } else if (i14 == 5) {
                    f18 = f24;
                }
                i14++;
            }
            f18 = f13;
            i14++;
        }
        float f26 = f18;
        m mVar = this.f7033o;
        if (mVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            mVar.i(f11, fArr, fArr2);
            float f27 = fArr[0];
            float f28 = fArr[1];
            float f29 = fArr2[0];
            float f31 = fArr2[1];
            double d12 = f14;
            double d13 = f15;
            float fSin = (float) ((((double) f27) + (Math.sin(d13) * d12)) - ((double) (f16 / 2.0f)));
            f12 = f17;
            float fCos = (float) ((((double) f28) - (Math.cos(d13) * d12)) - ((double) (f17 / 2.0f)));
            double d14 = f19;
            double d15 = f21;
            float fSin2 = (float) (((double) f29) + (Math.sin(d13) * d14) + (Math.cos(d13) * d12 * d15));
            float fCos2 = (float) ((((double) f31) - (d14 * Math.cos(d13))) + (d12 * Math.sin(d13) * d15));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f26)) {
                view.setRotation((float) (((double) f26) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f14 = fSin;
            f15 = fCos;
        } else {
            f12 = f17;
            if (!Float.isNaN(f26)) {
                view.setRotation((float) (((double) 0.0f) + ((double) f26) + Math.toDegrees(Math.atan2(f21 + (f23 / 2.0f), f19 + (f22 / 2.0f)))));
            }
        }
        if (view instanceof c) {
            ((c) view).layout(f14, f15, f16 + f14, f15 + f12);
            return;
        }
        float f32 = f14 + 0.5f;
        int i15 = (int) f32;
        float f33 = f15 + 0.5f;
        int i16 = (int) f33;
        int i17 = (int) (f32 + f16);
        int i18 = (int) (f33 + f12);
        int i19 = i17 - i15;
        int i21 = i18 - i16;
        if (i19 != view.getMeasuredWidth() || i21 != view.getMeasuredHeight() || z11) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i21, 1073741824));
        }
        view.layout(i15, i16, i17, i18);
    }

    public void u(m mVar, o oVar) {
        double d11 = ((this.f7024f + (this.f7026h / 2.0f)) - oVar.f7024f) - (oVar.f7026h / 2.0f);
        double d12 = ((this.f7025g + (this.f7027i / 2.0f)) - oVar.f7025g) - (oVar.f7027i / 2.0f);
        this.f7033o = mVar;
        this.f7024f = (float) Math.hypot(d12, d11);
        if (Float.isNaN(this.f7032n)) {
            this.f7025g = (float) (Math.atan2(d12, d11) + 1.5707963267948966d);
        } else {
            this.f7025g = (float) Math.toRadians(this.f7032n);
        }
    }
}

package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static float U0 = 0.5f;
    public int A0;
    public int B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public boolean H0;
    public boolean I0;
    public int J0;
    public int K0;
    public boolean L0;
    public boolean M;
    public boolean M0;
    public float[] N0;
    public ConstraintWidget[] O0;
    public ConstraintWidget[] P0;
    public ConstraintWidget Q0;
    public ConstraintWidget R0;
    public int S0;
    public int T0;
    public ConstraintAnchor X;
    public ConstraintAnchor[] Y;
    public ArrayList<ConstraintAnchor> Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean[] f6530a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public DimensionBehaviour[] f6532b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w2.c f6533c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ConstraintWidget f6534c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2.c f6535d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f6536d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f6538e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f6540f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f6542g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f6544h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f6546i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f6548j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f6550k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f6552l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f6554m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f6556n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f6557o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f6558o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f6560p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f6562q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f6564r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Object f6566s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f6568t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f6570u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f6572v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public String f6574w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f6576x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f6578y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f6580z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6529a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WidgetRun[] f6531b = new WidgetRun[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.c f6537e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.d f6539f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean[] f6541g = {true, true};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6543h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6545i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f6547j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6549k = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6551l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6553m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u2.a f6555n = new u2.a(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6559p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6561q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6563r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f6565s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6567t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6569u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6571v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6573w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6575x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f6577y = new int[2];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6579z = 0;
    public int A = 0;
    public float B = 1.0f;
    public int C = 0;
    public int D = 0;
    public float E = 1.0f;
    public int H = -1;
    public float I = 1.0f;
    public int[] J = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    public float K = 0.0f;
    public boolean L = false;
    public boolean N = false;
    public int O = 0;
    public int P = 0;
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    public ConstraintAnchor R = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor S = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor T = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor U = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    public ConstraintAnchor V = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor W = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* JADX INFO: compiled from: source.java */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6582b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f6582b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6582b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6582b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6582b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f6581a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6581a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6581a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6581a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6581a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6581a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6581a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6581a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6581a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.X = constraintAnchor;
        this.Y = new ConstraintAnchor[]{this.Q, this.S, this.R, this.T, this.U, constraintAnchor};
        this.Z = new ArrayList<>();
        this.f6530a0 = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f6532b0 = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f6534c0 = null;
        this.f6536d0 = 0;
        this.f6538e0 = 0;
        this.f6540f0 = 0.0f;
        this.f6542g0 = -1;
        this.f6544h0 = 0;
        this.f6546i0 = 0;
        this.f6548j0 = 0;
        this.f6550k0 = 0;
        this.f6552l0 = 0;
        this.f6554m0 = 0;
        this.f6556n0 = 0;
        float f11 = U0;
        this.f6562q0 = f11;
        this.f6564r0 = f11;
        this.f6568t0 = 0;
        this.f6570u0 = 0;
        this.f6572v0 = false;
        this.f6574w0 = null;
        this.f6576x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new ConstraintWidget[]{null, null};
        this.P0 = new ConstraintWidget[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    public float A() {
        return this.f6562q0;
    }

    public final void A0(StringBuilder sb2, String str, float f11, float f12) {
        if (f11 == f12) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f11);
        sb2.append(",\n");
    }

    public int B() {
        return this.J0;
    }

    public final void B0(StringBuilder sb2, String str, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i11);
        sb2.append(",\n");
    }

    public DimensionBehaviour C() {
        return this.f6532b0[0];
    }

    public final void C0(StringBuilder sb2, String str, float f11, int i11) {
        if (f11 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f11);
        sb2.append(",");
        sb2.append(i11);
        sb2.append("");
        sb2.append("],\n");
    }

    public int D() {
        ConstraintAnchor constraintAnchor = this.Q;
        int i11 = constraintAnchor != null ? constraintAnchor.f6525g : 0;
        ConstraintAnchor constraintAnchor2 = this.S;
        return constraintAnchor2 != null ? i11 + constraintAnchor2.f6525g : i11;
    }

    public void D0(boolean z11) {
        this.f6572v0 = z11;
    }

    public int E() {
        return this.O;
    }

    public void E0(int i11) {
        this.f6556n0 = i11;
        this.L = i11 > 0;
    }

    public int F() {
        return this.P;
    }

    public void F0(Object obj) {
        this.f6566s0 = obj;
    }

    public int G(int i11) {
        if (i11 == 0) {
            return Y();
        }
        if (i11 == 1) {
            return z();
        }
        return 0;
    }

    public void G0(String str) {
        this.f6574w0 = str;
    }

    public int H() {
        return this.J[1];
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0087 A[PHI: r0
  0x0087: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:39:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0087 -> B:41:0x0088). Please report as a decompilation issue!!! */
    public void H0(String str) {
        float fAbs;
        int i11 = 0;
        if (str == null || str.length() == 0) {
            this.f6540f0 = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i12 = 0;
        int i13 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i12 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i13 = i12;
            i12 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i12);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = 0.0f;
                }
            } else {
                String strSubstring3 = str.substring(i12, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = 0.0f;
                } else {
                    float f11 = Float.parseFloat(strSubstring3);
                    float f12 = Float.parseFloat(strSubstring4);
                    if (f11 <= 0.0f || f12 <= 0.0f) {
                        fAbs = 0.0f;
                    } else {
                        fAbs = i13 == 1 ? Math.abs(f12 / f11) : Math.abs(f11 / f12);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i11 = (fAbs > i11 ? 1 : (fAbs == i11 ? 0 : -1));
        if (i11 > 0) {
            this.f6540f0 = fAbs;
            this.f6542g0 = i13;
        }
    }

    public int I() {
        return this.J[0];
    }

    public void I0(int i11) {
        if (this.L) {
            int i12 = i11 - this.f6556n0;
            int i13 = this.f6538e0 + i12;
            this.f6546i0 = i12;
            this.R.t(i12);
            this.T.t(i13);
            this.U.t(i11);
            this.f6561q = true;
        }
    }

    public int J() {
        return this.f6560p0;
    }

    public void J0(int i11, int i12) {
        if (this.f6559p) {
            return;
        }
        this.Q.t(i11);
        this.S.t(i12);
        this.f6544h0 = i11;
        this.f6536d0 = i12 - i11;
        this.f6559p = true;
    }

    public int K() {
        return this.f6558o0;
    }

    public void K0(int i11) {
        this.Q.t(i11);
        this.f6544h0 = i11;
    }

    public ConstraintWidget L(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 != 0) {
            if (i11 == 1 && (constraintAnchor2 = (constraintAnchor = this.T).f6524f) != null && constraintAnchor2.f6524f == constraintAnchor) {
                return constraintAnchor2.f6522d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6524f;
        if (constraintAnchor4 == null || constraintAnchor4.f6524f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f6522d;
    }

    public void L0(int i11) {
        this.R.t(i11);
        this.f6546i0 = i11;
    }

    public ConstraintWidget M() {
        return this.f6534c0;
    }

    public void M0(int i11, int i12) {
        if (this.f6561q) {
            return;
        }
        this.R.t(i11);
        this.T.t(i12);
        this.f6546i0 = i11;
        this.f6538e0 = i12 - i11;
        if (this.L) {
            this.U.t(i11 + this.f6556n0);
        }
        this.f6561q = true;
    }

    public ConstraintWidget N(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 != 0) {
            if (i11 == 1 && (constraintAnchor2 = (constraintAnchor = this.R).f6524f) != null && constraintAnchor2.f6524f == constraintAnchor) {
                return constraintAnchor2.f6522d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.Q;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6524f;
        if (constraintAnchor4 == null || constraintAnchor4.f6524f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f6522d;
    }

    public void N0(int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        this.f6544h0 = i11;
        this.f6546i0 = i12;
        if (this.f6570u0 == 8) {
            this.f6536d0 = 0;
            this.f6538e0 = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f6532b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i17 < (i16 = this.f6536d0)) {
            i17 = i16;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i18 < (i15 = this.f6538e0)) {
            i18 = i15;
        }
        this.f6536d0 = i17;
        this.f6538e0 = i18;
        int i19 = this.f6560p0;
        if (i18 < i19) {
            this.f6538e0 = i19;
        }
        int i21 = this.f6558o0;
        if (i17 < i21) {
            this.f6536d0 = i21;
        }
        int i22 = this.A;
        if (i22 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f6536d0 = Math.min(this.f6536d0, i22);
        }
        int i23 = this.D;
        if (i23 > 0 && this.f6532b0[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.f6538e0 = Math.min(this.f6538e0, i23);
        }
        int i24 = this.f6536d0;
        if (i17 != i24) {
            this.f6551l = i24;
        }
        int i25 = this.f6538e0;
        if (i18 != i25) {
            this.f6553m = i25;
        }
    }

    public int O() {
        return Z() + this.f6536d0;
    }

    public void O0(boolean z11) {
        this.L = z11;
    }

    public WidgetRun P(int i11) {
        if (i11 == 0) {
            return this.f6537e;
        }
        if (i11 == 1) {
            return this.f6539f;
        }
        return null;
    }

    public void P0(int i11) {
        this.f6538e0 = i11;
        int i12 = this.f6560p0;
        if (i11 < i12) {
            this.f6538e0 = i12;
        }
    }

    public void Q(StringBuilder sb2) {
        sb2.append("  " + this.f6557o + ":{\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.f6536d0);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.f6538e0);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.f6544h0);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.f6546i0);
        sb2.append("\n");
        S(sb2, TtmlNode.LEFT, this.Q);
        S(sb2, "top", this.R);
        S(sb2, TtmlNode.RIGHT, this.S);
        S(sb2, "bottom", this.T);
        S(sb2, "baseline", this.U);
        S(sb2, "centerX", this.V);
        S(sb2, "centerY", this.W);
        R(sb2, "    width", this.f6536d0, this.f6558o0, this.J[0], this.f6551l, this.f6579z, this.f6573w, this.B, this.N0[0]);
        R(sb2, "    height", this.f6538e0, this.f6560p0, this.J[1], this.f6553m, this.C, this.f6575x, this.E, this.N0[1]);
        C0(sb2, "    dimensionRatio", this.f6540f0, this.f6542g0);
        A0(sb2, "    horizontalBias", this.f6562q0, U0);
        A0(sb2, "    verticalBias", this.f6564r0, U0);
        B0(sb2, "    horizontalChainStyle", this.J0, 0);
        B0(sb2, "    verticalChainStyle", this.K0, 0);
        sb2.append("  }");
    }

    public void Q0(float f11) {
        this.f6562q0 = f11;
    }

    public final void R(StringBuilder sb2, String str, int i11, int i12, int i13, int i14, int i15, int i16, float f11, float f12) {
        sb2.append(str);
        sb2.append(" :  {\n");
        B0(sb2, "      size", i11, 0);
        B0(sb2, "      min", i12, 0);
        B0(sb2, "      max", i13, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        B0(sb2, "      matchMin", i15, 0);
        B0(sb2, "      matchDef", i16, 0);
        A0(sb2, "      matchPercent", f11, 1.0f);
        sb2.append("    },\n");
    }

    public void R0(int i11) {
        this.J0 = i11;
    }

    public final void S(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f6524f == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.f6524f);
        sb2.append("'");
        if (constraintAnchor.f6526h != Integer.MIN_VALUE || constraintAnchor.f6525g != 0) {
            sb2.append(",");
            sb2.append(constraintAnchor.f6525g);
            if (constraintAnchor.f6526h != Integer.MIN_VALUE) {
                sb2.append(",");
                sb2.append(constraintAnchor.f6526h);
                sb2.append(",");
            }
        }
        sb2.append(" ] ,\n");
    }

    public void S0(int i11, int i12) {
        this.f6544h0 = i11;
        int i13 = i12 - i11;
        this.f6536d0 = i13;
        int i14 = this.f6558o0;
        if (i13 < i14) {
            this.f6536d0 = i14;
        }
    }

    public float T() {
        return this.f6564r0;
    }

    public void T0(DimensionBehaviour dimensionBehaviour) {
        this.f6532b0[0] = dimensionBehaviour;
    }

    public int U() {
        return this.K0;
    }

    public void U0(int i11, int i12, int i13, float f11) {
        this.f6573w = i11;
        this.f6579z = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.A = i13;
        this.B = f11;
        if (f11 <= 0.0f || f11 >= 1.0f || i11 != 0) {
            return;
        }
        this.f6573w = 2;
    }

    public DimensionBehaviour V() {
        return this.f6532b0[1];
    }

    public void V0(float f11) {
        this.N0[0] = f11;
    }

    public int W() {
        int i11 = this.Q != null ? this.R.f6525g : 0;
        return this.S != null ? i11 + this.T.f6525g : i11;
    }

    public void W0(int i11, boolean z11) {
        this.f6530a0[i11] = z11;
    }

    public int X() {
        return this.f6570u0;
    }

    public void X0(boolean z11) {
        this.M = z11;
    }

    public int Y() {
        if (this.f6570u0 == 8) {
            return 0;
        }
        return this.f6536d0;
    }

    public void Y0(boolean z11) {
        this.N = z11;
    }

    public int Z() {
        ConstraintWidget constraintWidget = this.f6534c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f6544h0 : ((d) constraintWidget).f6637c1 + this.f6544h0;
    }

    public void Z0(int i11, int i12) {
        this.O = i11;
        this.P = i12;
        c1(false);
    }

    public int a0() {
        ConstraintWidget constraintWidget = this.f6534c0;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.f6546i0 : ((d) constraintWidget).f6638d1 + this.f6546i0;
    }

    public void a1(int i11) {
        this.J[1] = i11;
    }

    public boolean b0() {
        return this.L;
    }

    public void b1(int i11) {
        this.J[0] = i11;
    }

    public boolean c0(int i11) {
        if (i11 == 0) {
            return (this.Q.f6524f != null ? 1 : 0) + (this.S.f6524f != null ? 1 : 0) < 2;
        }
        return ((this.R.f6524f != null ? 1 : 0) + (this.T.f6524f != null ? 1 : 0)) + (this.U.f6524f != null ? 1 : 0) < 2;
    }

    public void c1(boolean z11) {
        this.f6545i = z11;
    }

    public final void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    public boolean d0() {
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.Z.get(i11).m()) {
                return true;
            }
        }
        return false;
    }

    public void d1(int i11) {
        if (i11 < 0) {
            this.f6560p0 = 0;
        } else {
            this.f6560p0 = i11;
        }
    }

    public void e(d dVar, androidx.constraintlayout.core.d dVar2, HashSet<ConstraintWidget> hashSet, int i11, boolean z11) {
        if (z11) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, dVar2, this);
            hashSet.remove(this);
            g(dVar2, dVar.Y1(64));
        }
        if (i11 == 0) {
            HashSet<ConstraintAnchor> hashSetD = this.Q.d();
            if (hashSetD != null) {
                Iterator<ConstraintAnchor> it = hashSetD.iterator();
                while (it.hasNext()) {
                    it.next().f6522d.e(dVar, dVar2, hashSet, i11, true);
                }
            }
            HashSet<ConstraintAnchor> hashSetD2 = this.S.d();
            if (hashSetD2 != null) {
                Iterator<ConstraintAnchor> it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    it2.next().f6522d.e(dVar, dVar2, hashSet, i11, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSetD3 = this.R.d();
        if (hashSetD3 != null) {
            Iterator<ConstraintAnchor> it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                it3.next().f6522d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetD4 = this.T.d();
        if (hashSetD4 != null) {
            Iterator<ConstraintAnchor> it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                it4.next().f6522d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
        HashSet<ConstraintAnchor> hashSetD5 = this.U.d();
        if (hashSetD5 != null) {
            Iterator<ConstraintAnchor> it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                it5.next().f6522d.e(dVar, dVar2, hashSet, i11, true);
            }
        }
    }

    public boolean e0() {
        return (this.f6551l == -1 && this.f6553m == -1) ? false : true;
    }

    public void e1(int i11) {
        if (i11 < 0) {
            this.f6558o0 = 0;
        } else {
            this.f6558o0 = i11;
        }
    }

    public boolean f() {
        return (this instanceof i) || (this instanceof f);
    }

    public boolean f0(int i11, int i12) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i11 == 0) {
            ConstraintAnchor constraintAnchor3 = this.Q.f6524f;
            return constraintAnchor3 != null && constraintAnchor3.n() && (constraintAnchor2 = this.S.f6524f) != null && constraintAnchor2.n() && (this.S.f6524f.e() - this.S.f()) - (this.Q.f6524f.e() + this.Q.f()) >= i12;
        }
        ConstraintAnchor constraintAnchor4 = this.R.f6524f;
        return constraintAnchor4 != null && constraintAnchor4.n() && (constraintAnchor = this.T.f6524f) != null && constraintAnchor.n() && (this.T.f6524f.e() - this.T.f()) - (this.R.f6524f.e() + this.R.f()) >= i12;
        return false;
    }

    public void f1(int i11, int i12) {
        this.f6544h0 = i11;
        this.f6546i0 = i12;
    }

    /* JADX WARN: Code duplicated, block: B:194:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    /* JADX WARN: Code duplicated, block: B:200:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:202:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:203:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:215:0x0318  */
    /* JADX WARN: Code duplicated, block: B:227:0x0370  */
    /* JADX WARN: Code duplicated, block: B:230:0x038a  */
    /* JADX WARN: Code duplicated, block: B:231:0x0392  */
    /* JADX WARN: Code duplicated, block: B:234:0x0398  */
    /* JADX WARN: Code duplicated, block: B:235:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:238:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:239:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:242:0x0428  */
    /* JADX WARN: Code duplicated, block: B:244:0x042e  */
    /* JADX WARN: Code duplicated, block: B:259:0x048c  */
    /* JADX WARN: Code duplicated, block: B:264:0x04a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:269:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:272:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:274:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:277:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:278:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:281:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:282:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:285:0x04db  */
    /* JADX WARN: Code duplicated, block: B:287:0x04df  */
    /* JADX WARN: Code duplicated, block: B:289:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:291:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:293:0x050c  */
    /* JADX WARN: Code duplicated, block: B:295:0x0510  */
    /* JADX WARN: Code duplicated, block: B:296:0x0518  */
    /* JADX WARN: Code duplicated, block: B:300:0x053f  */
    /* JADX WARN: Code duplicated, block: B:301:0x0542  */
    /* JADX WARN: Code duplicated, block: B:303:0x0582  */
    /* JADX WARN: Code duplicated, block: B:305:0x0588  */
    /* JADX WARN: Code duplicated, block: B:307:0x0591  */
    /* JADX WARN: Code duplicated, block: B:308:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:309:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:312:0x05bb  */
    public void g(androidx.constraintlayout.core.d dVar, boolean z11) {
        boolean z12;
        boolean z13;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z14;
        boolean z15;
        int i11;
        int i12;
        boolean z16;
        int i13;
        boolean z17;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z18;
        int i14;
        boolean z19;
        boolean z21;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int i15;
        int i16;
        char c11;
        ConstraintWidget constraintWidget3;
        boolean z22;
        ConstraintWidget constraintWidget4;
        boolean z23;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariableQ;
        ConstraintWidget constraintWidget6;
        SolverVariable solverVariableQ2;
        ConstraintAnchor constraintAnchor;
        boolean z24;
        DimensionBehaviour[] dimensionBehaviourArr;
        boolean z25;
        androidx.constraintlayout.core.widgets.analyzer.d dVar2;
        DependencyNode dependencyNode;
        ConstraintWidget constraintWidget7;
        SolverVariable solverVariableQ3;
        ConstraintWidget constraintWidget8;
        SolverVariable solverVariableQ4;
        DimensionBehaviour[] dimensionBehaviourArr2;
        boolean z26;
        androidx.constraintlayout.core.widgets.analyzer.c cVar;
        int i17;
        int i18;
        boolean zK0;
        boolean zM0;
        androidx.constraintlayout.core.widgets.analyzer.c cVar2;
        androidx.constraintlayout.core.widgets.analyzer.d dVar3;
        SolverVariable solverVariableQ5 = dVar.q(this.Q);
        SolverVariable solverVariableQ6 = dVar.q(this.S);
        SolverVariable solverVariableQ7 = dVar.q(this.R);
        SolverVariable solverVariableQ8 = dVar.q(this.T);
        SolverVariable solverVariableQ9 = dVar.q(this.U);
        ConstraintWidget constraintWidget9 = this.f6534c0;
        if (constraintWidget9 == null) {
            z12 = false;
            z13 = false;
        } else {
            boolean z27 = constraintWidget9 != null && constraintWidget9.f6532b0[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z28 = constraintWidget9 != null && constraintWidget9.f6532b0[1] == DimensionBehaviour.WRAP_CONTENT;
            int i19 = this.f6571v;
            if (i19 == 1) {
                z12 = z27;
                z13 = false;
            } else if (i19 == 2) {
                z13 = z28;
                z12 = false;
            } else if (i19 != 3) {
                z13 = z28;
                z12 = z27;
            } else {
                z12 = false;
                z13 = false;
            }
        }
        if (this.f6570u0 == 8 && !this.f6572v0 && !d0()) {
            boolean[] zArr = this.f6530a0;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z29 = this.f6559p;
        if (z29 || this.f6561q) {
            if (z29) {
                dVar.f(solverVariableQ5, this.f6544h0);
                dVar.f(solverVariableQ6, this.f6544h0 + this.f6536d0);
                if (z12 && (constraintWidget2 = this.f6534c0) != null) {
                    if (this.f6549k) {
                        d dVar4 = (d) constraintWidget2;
                        dVar4.D1(this.Q);
                        dVar4.C1(this.S);
                    } else {
                        dVar.h(dVar.q(constraintWidget2.S), solverVariableQ6, 0, 5);
                    }
                }
            }
            if (this.f6561q) {
                dVar.f(solverVariableQ7, this.f6546i0);
                dVar.f(solverVariableQ8, this.f6546i0 + this.f6538e0);
                if (this.U.m()) {
                    dVar.f(solverVariableQ9, this.f6546i0 + this.f6556n0);
                }
                if (z13 && (constraintWidget = this.f6534c0) != null) {
                    if (this.f6549k) {
                        d dVar5 = (d) constraintWidget;
                        dVar5.I1(this.R);
                        dVar5.H1(this.T);
                    } else {
                        dVar.h(dVar.q(constraintWidget.T), solverVariableQ8, 0, 5);
                    }
                }
            }
            if (this.f6559p && this.f6561q) {
                this.f6559p = false;
                this.f6561q = false;
                return;
            }
        }
        boolean z30 = androidx.constraintlayout.core.d.f6346r;
        if (z11 && (cVar2 = this.f6537e) != null && (dVar3 = this.f6539f) != null) {
            DependencyNode dependencyNode2 = cVar2.f6603h;
            if (dependencyNode2.f6593j && cVar2.f6604i.f6593j && dVar3.f6603h.f6593j && dVar3.f6604i.f6593j) {
                dVar.f(solverVariableQ5, dependencyNode2.f6590g);
                dVar.f(solverVariableQ6, this.f6537e.f6604i.f6590g);
                dVar.f(solverVariableQ7, this.f6539f.f6603h.f6590g);
                dVar.f(solverVariableQ8, this.f6539f.f6604i.f6590g);
                dVar.f(solverVariableQ9, this.f6539f.f6610k.f6590g);
                if (this.f6534c0 != null) {
                    if (z12 && this.f6541g[0] && !k0()) {
                        dVar.h(dVar.q(this.f6534c0.S), solverVariableQ6, 0, 8);
                    }
                    if (z13 && this.f6541g[1] && !m0()) {
                        dVar.h(dVar.q(this.f6534c0.T), solverVariableQ8, 0, 8);
                    }
                }
                this.f6559p = false;
                this.f6561q = false;
                return;
            }
        }
        if (this.f6534c0 != null) {
            if (h0(0)) {
                ((d) this.f6534c0).z1(this, 0);
                zK0 = true;
            } else {
                zK0 = k0();
            }
            if (h0(1)) {
                ((d) this.f6534c0).z1(this, 1);
                zM0 = true;
            } else {
                zM0 = m0();
            }
            if (!zK0 && z12 && this.f6570u0 != 8 && this.Q.f6524f == null && this.S.f6524f == null) {
                dVar.h(dVar.q(this.f6534c0.S), solverVariableQ6, 0, 1);
            }
            if (!zM0 && z13 && this.f6570u0 != 8 && this.R.f6524f == null && this.T.f6524f == null && this.U == null) {
                dVar.h(dVar.q(this.f6534c0.T), solverVariableQ8, 0, 1);
            }
            z15 = zK0;
            z14 = zM0;
        } else {
            z14 = false;
            z15 = false;
        }
        int i21 = this.f6536d0;
        int i22 = this.f6558o0;
        if (i21 >= i22) {
            i22 = i21;
        }
        int i23 = this.f6538e0;
        int i24 = this.f6560p0;
        if (i23 >= i24) {
            i24 = i23;
        }
        DimensionBehaviour[] dimensionBehaviourArr3 = this.f6532b0;
        DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr3[0];
        DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
        int i25 = i22;
        boolean z31 = dimensionBehaviour3 != dimensionBehaviour4;
        DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr3[1];
        int i26 = i24;
        SolverVariable solverVariable3 = solverVariableQ9;
        boolean z32 = dimensionBehaviour5 != dimensionBehaviour4;
        int i27 = this.f6542g0;
        this.H = i27;
        SolverVariable solverVariable4 = solverVariableQ8;
        float f11 = this.f6540f0;
        this.I = f11;
        SolverVariable solverVariable5 = solverVariableQ7;
        int i28 = this.f6573w;
        int i29 = this.f6575x;
        if (f11 <= 0.0f || this.f6570u0 == 8) {
            i28 = i28;
            i29 = i29;
            i11 = i25;
            i12 = i26;
            z16 = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour4 && i28 == 0) {
                i28 = 3;
            }
            if (dimensionBehaviour5 == dimensionBehaviour4 && i29 == 0) {
                i29 = 3;
            }
            if (dimensionBehaviour3 == dimensionBehaviour4 && dimensionBehaviour5 == dimensionBehaviour4) {
                i18 = 3;
                if (i28 == 3 && i29 == 3) {
                    s1(z12, z13, z31, z32);
                }
                i11 = i25;
                i12 = i26;
                z16 = true;
            } else {
                i18 = 3;
            }
            if (dimensionBehaviour3 == dimensionBehaviour4 && i28 == i18) {
                this.H = 0;
                i11 = (int) (f11 * i23);
                if (dimensionBehaviour5 != dimensionBehaviour4) {
                    i29 = i29;
                    i12 = i26;
                    z16 = false;
                    i28 = 4;
                } else {
                    i12 = i26;
                    z16 = true;
                }
            } else if (dimensionBehaviour5 == dimensionBehaviour4 && i29 == i18) {
                this.H = 1;
                if (i27 == -1) {
                    this.I = 1.0f / f11;
                }
                i12 = (int) (this.I * i21);
                i28 = i28;
                if (dimensionBehaviour3 != dimensionBehaviour4) {
                    i11 = i25;
                    z16 = false;
                    i29 = 4;
                } else {
                    i29 = i29;
                    i11 = i25;
                    z16 = true;
                }
            } else {
                i11 = i25;
                i12 = i26;
                z16 = true;
            }
        }
        int[] iArr = this.f6577y;
        iArr[0] = i28;
        iArr[1] = i29;
        this.f6543h = z16;
        if (z16) {
            int i31 = this.H;
            i13 = -1;
            boolean z33 = i31 == 0 || i31 == -1;
            if (z16 || !((i17 = this.H) == 1 || i17 == i13)) {
                z17 = false;
            } else {
                z17 = true;
            }
            dimensionBehaviour = this.f6532b0[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2 || !(this instanceof d)) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                i14 = 0;
            } else {
                i14 = i11;
            }
            z19 = !this.X.o();
            boolean[] zArr2 = this.f6530a0;
            boolean z34 = zArr2[0];
            z21 = zArr2[1];
            if (this.f6567t != 2 || this.f6559p) {
                solverVariable = solverVariableQ6;
                solverVariable2 = solverVariableQ5;
            } else if (!z11 || (cVar = this.f6537e) == null) {
                constraintWidget7 = this.f6534c0;
                if (constraintWidget7 != null) {
                    solverVariableQ3 = dVar.q(constraintWidget7.S);
                } else {
                    solverVariableQ3 = null;
                }
                constraintWidget8 = this.f6534c0;
                if (constraintWidget8 != null) {
                    solverVariableQ4 = dVar.q(constraintWidget8.Q);
                } else {
                    solverVariableQ4 = null;
                }
                boolean z35 = this.f6541g[0];
                dimensionBehaviourArr2 = this.f6532b0;
                DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr2[0];
                ConstraintAnchor constraintAnchor2 = this.Q;
                ConstraintAnchor constraintAnchor3 = this.S;
                int i32 = this.f6544h0;
                int i33 = this.f6558o0;
                int i34 = this.J[0];
                float f12 = this.f6562q0;
                if (dimensionBehaviourArr2[1] == dimensionBehaviour4) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                solverVariable = solverVariableQ6;
                solverVariable2 = solverVariableQ5;
                i(dVar, true, z12, z13, z35, solverVariableQ4, solverVariableQ3, dimensionBehaviour6, z18, constraintAnchor2, constraintAnchor3, i32, i14, i33, i34, f12, z33, z26, z15, z14, z34, i28, i29, this.f6579z, this.A, this.B, z19);
            } else {
                DependencyNode dependencyNode3 = cVar.f6603h;
                if (!dependencyNode3.f6593j || !cVar.f6604i.f6593j) {
                    constraintWidget7 = this.f6534c0;
                    if (constraintWidget7 != null) {
                        solverVariableQ3 = dVar.q(constraintWidget7.S);
                    } else {
                        solverVariableQ3 = null;
                    }
                    constraintWidget8 = this.f6534c0;
                    if (constraintWidget8 != null) {
                        solverVariableQ4 = dVar.q(constraintWidget8.Q);
                    } else {
                        solverVariableQ4 = null;
                    }
                    boolean z36 = this.f6541g[0];
                    dimensionBehaviourArr2 = this.f6532b0;
                    DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr2[0];
                    ConstraintAnchor constraintAnchor4 = this.Q;
                    ConstraintAnchor constraintAnchor5 = this.S;
                    int i35 = this.f6544h0;
                    int i36 = this.f6558o0;
                    int i37 = this.J[0];
                    float f13 = this.f6562q0;
                    if (dimensionBehaviourArr2[1] == dimensionBehaviour4) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    solverVariable = solverVariableQ6;
                    solverVariable2 = solverVariableQ5;
                    i(dVar, true, z12, z13, z36, solverVariableQ4, solverVariableQ3, dimensionBehaviour7, z18, constraintAnchor4, constraintAnchor5, i35, i14, i36, i37, f13, z33, z26, z15, z14, z34, i28, i29, this.f6579z, this.A, this.B, z19);
                } else if (z11) {
                    dVar.f(solverVariableQ5, dependencyNode3.f6590g);
                    dVar.f(solverVariableQ6, this.f6537e.f6604i.f6590g);
                    if (this.f6534c0 != null && z12 && this.f6541g[0] && !k0()) {
                        dVar.h(dVar.q(this.f6534c0.S), solverVariableQ6, 0, 8);
                    }
                    solverVariable = solverVariableQ6;
                    solverVariable2 = solverVariableQ5;
                } else {
                    solverVariable = solverVariableQ6;
                    solverVariable2 = solverVariableQ5;
                }
            }
            if (z11) {
                constraintWidget3 = this;
                dVar2 = constraintWidget3.f6539f;
                if (dVar2 != null) {
                    dependencyNode = dVar2.f6603h;
                    if (!dependencyNode.f6593j && dVar2.f6604i.f6593j) {
                        dVar = dVar;
                        solverVariable5 = solverVariable5;
                        dVar.f(solverVariable5, dependencyNode.f6590g);
                        solverVariable4 = solverVariable4;
                        dVar.f(solverVariable4, constraintWidget3.f6539f.f6604i.f6590g);
                        solverVariable3 = solverVariable3;
                        dVar.f(solverVariable3, constraintWidget3.f6539f.f6610k.f6590g);
                        ConstraintWidget constraintWidget10 = constraintWidget3.f6534c0;
                        if (constraintWidget10 == null || z14 || !z13) {
                            i15 = 8;
                            i16 = 0;
                            c11 = 1;
                        } else {
                            c11 = 1;
                            if (constraintWidget3.f6541g[1]) {
                                i15 = 8;
                                i16 = 0;
                                dVar.h(dVar.q(constraintWidget10.T), solverVariable4, 0, 8);
                            } else {
                                i15 = 8;
                                i16 = 0;
                            }
                        }
                        z22 = false;
                    }
                    if (constraintWidget3.f6569u == 2 && z22 && !constraintWidget3.f6561q) {
                        if (constraintWidget3.f6532b0[c11] == dimensionBehaviour2 || !(constraintWidget3 instanceof d)) {
                            z23 = false;
                        } else {
                            z23 = true;
                        }
                        if (z23) {
                            i12 = 0;
                        }
                        constraintWidget5 = constraintWidget3.f6534c0;
                        if (constraintWidget5 != null) {
                            solverVariableQ = dVar.q(constraintWidget5.T);
                        } else {
                            solverVariableQ = null;
                        }
                        constraintWidget6 = constraintWidget3.f6534c0;
                        if (constraintWidget6 != null) {
                            solverVariableQ2 = dVar.q(constraintWidget6.R);
                        } else {
                            solverVariableQ2 = null;
                        }
                        if (constraintWidget3.f6556n0 <= 0 || constraintWidget3.f6570u0 == i15) {
                            constraintAnchor = constraintWidget3.U;
                            if (constraintAnchor.f6524f != null) {
                                dVar.e(solverVariable3, solverVariable5, r(), i15);
                                dVar.e(solverVariable3, dVar.q(constraintWidget3.U.f6524f), constraintWidget3.U.f(), i15);
                                if (z13 != 0) {
                                    dVar.h(solverVariableQ, dVar.q(constraintWidget3.T), i16, 5);
                                }
                                z24 = false;
                            } else {
                                if (constraintWidget3.f6570u0 == i15) {
                                    dVar.e(solverVariable3, solverVariable5, constraintAnchor.f(), i15);
                                } else {
                                    dVar.e(solverVariable3, solverVariable5, r(), i15);
                                }
                                z24 = z19;
                            }
                        } else {
                            z24 = z19;
                        }
                        boolean z37 = constraintWidget3.f6541g[c11];
                        dimensionBehaviourArr = constraintWidget3.f6532b0;
                        DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr[c11];
                        ConstraintAnchor constraintAnchor6 = constraintWidget3.R;
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.T;
                        int i38 = constraintWidget3.f6546i0;
                        int i39 = constraintWidget3.f6560p0;
                        int i40 = constraintWidget3.J[c11];
                        float f14 = constraintWidget3.f6564r0;
                        if (dimensionBehaviourArr[0] == dimensionBehaviour4) {
                            z25 = true;
                        } else {
                            z25 = false;
                        }
                        i(dVar, false, z13, z12, z37, solverVariableQ2, solverVariableQ, dimensionBehaviour8, z23, constraintAnchor6, constraintAnchor7, i38, i12, i39, i40, f14, z17, z25, z14, z15, z21, i29, i28, constraintWidget3.C, constraintWidget3.D, constraintWidget3.E, z24);
                    }
                    if (z16) {
                        constraintWidget4 = this;
                        if (constraintWidget4.H == 1) {
                            dVar.k(solverVariable4, solverVariable5, solverVariable, solverVariable2, constraintWidget4.I, 8);
                        } else {
                            dVar.k(solverVariable, solverVariable2, solverVariable4, solverVariable5, constraintWidget4.I, 8);
                        }
                    } else {
                        constraintWidget4 = this;
                    }
                    if (constraintWidget4.X.o()) {
                        dVar.b(constraintWidget4, constraintWidget4.X.j().h(), (float) Math.toRadians(constraintWidget4.K + 90.0f), constraintWidget4.X.f());
                    }
                    constraintWidget4.f6559p = false;
                    constraintWidget4.f6561q = false;
                }
                i15 = 8;
                i16 = 0;
                c11 = 1;
            } else {
                i15 = 8;
                i16 = 0;
                c11 = 1;
                constraintWidget3 = this;
            }
            z22 = true;
            if (constraintWidget3.f6569u == 2) {
                if (constraintWidget3.f6532b0[c11] == dimensionBehaviour2) {
                    z23 = false;
                } else {
                    z23 = false;
                }
                if (z23) {
                    i12 = 0;
                }
                constraintWidget5 = constraintWidget3.f6534c0;
                if (constraintWidget5 != null) {
                    solverVariableQ = dVar.q(constraintWidget5.T);
                } else {
                    solverVariableQ = null;
                }
                constraintWidget6 = constraintWidget3.f6534c0;
                if (constraintWidget6 != null) {
                    solverVariableQ2 = dVar.q(constraintWidget6.R);
                } else {
                    solverVariableQ2 = null;
                }
                if (constraintWidget3.f6556n0 <= 0) {
                    constraintAnchor = constraintWidget3.U;
                    if (constraintAnchor.f6524f != null) {
                        dVar.e(solverVariable3, solverVariable5, r(), i15);
                        dVar.e(solverVariable3, dVar.q(constraintWidget3.U.f6524f), constraintWidget3.U.f(), i15);
                        if (z13 != 0) {
                            dVar.h(solverVariableQ, dVar.q(constraintWidget3.T), i16, 5);
                        }
                        z24 = false;
                    } else {
                        if (constraintWidget3.f6570u0 == i15) {
                            dVar.e(solverVariable3, solverVariable5, constraintAnchor.f(), i15);
                        } else {
                            dVar.e(solverVariable3, solverVariable5, r(), i15);
                        }
                        z24 = z19;
                    }
                } else {
                    constraintAnchor = constraintWidget3.U;
                    if (constraintAnchor.f6524f != null) {
                        dVar.e(solverVariable3, solverVariable5, r(), i15);
                        dVar.e(solverVariable3, dVar.q(constraintWidget3.U.f6524f), constraintWidget3.U.f(), i15);
                        if (z13 != 0) {
                            dVar.h(solverVariableQ, dVar.q(constraintWidget3.T), i16, 5);
                        }
                        z24 = false;
                    } else {
                        if (constraintWidget3.f6570u0 == i15) {
                            dVar.e(solverVariable3, solverVariable5, constraintAnchor.f(), i15);
                        } else {
                            dVar.e(solverVariable3, solverVariable5, r(), i15);
                        }
                        z24 = z19;
                    }
                }
                boolean z38 = constraintWidget3.f6541g[c11];
                dimensionBehaviourArr = constraintWidget3.f6532b0;
                DimensionBehaviour dimensionBehaviour9 = dimensionBehaviourArr[c11];
                ConstraintAnchor constraintAnchor8 = constraintWidget3.R;
                ConstraintAnchor constraintAnchor9 = constraintWidget3.T;
                int i310 = constraintWidget3.f6546i0;
                int i311 = constraintWidget3.f6560p0;
                int i41 = constraintWidget3.J[c11];
                float f15 = constraintWidget3.f6564r0;
                if (dimensionBehaviourArr[0] == dimensionBehaviour4) {
                    z25 = true;
                } else {
                    z25 = false;
                }
                i(dVar, false, z13, z12, z38, solverVariableQ2, solverVariableQ, dimensionBehaviour9, z23, constraintAnchor8, constraintAnchor9, i310, i12, i311, i41, f15, z17, z25, z14, z15, z21, i29, i28, constraintWidget3.C, constraintWidget3.D, constraintWidget3.E, z24);
            }
            if (z16) {
                constraintWidget4 = this;
                if (constraintWidget4.H == 1) {
                    dVar.k(solverVariable4, solverVariable5, solverVariable, solverVariable2, constraintWidget4.I, 8);
                } else {
                    dVar.k(solverVariable, solverVariable2, solverVariable4, solverVariable5, constraintWidget4.I, 8);
                }
            } else {
                constraintWidget4 = this;
            }
            if (constraintWidget4.X.o()) {
                dVar.b(constraintWidget4, constraintWidget4.X.j().h(), (float) Math.toRadians(constraintWidget4.K + 90.0f), constraintWidget4.X.f());
            }
            constraintWidget4.f6559p = false;
            constraintWidget4.f6561q = false;
        }
        i13 = -1;
        if (z16) {
            z17 = false;
        } else {
            z17 = false;
        }
        dimensionBehaviour = this.f6532b0[0];
        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z18 = false;
        } else {
            z18 = false;
        }
        if (z18) {
            i14 = 0;
        } else {
            i14 = i11;
        }
        z19 = !this.X.o();
        boolean[] zArr3 = this.f6530a0;
        boolean z39 = zArr3[0];
        z21 = zArr3[1];
        if (this.f6567t != 2) {
            solverVariable = solverVariableQ6;
            solverVariable2 = solverVariableQ5;
        } else {
            solverVariable = solverVariableQ6;
            solverVariable2 = solverVariableQ5;
        }
        if (z11) {
            constraintWidget3 = this;
            dVar2 = constraintWidget3.f6539f;
            if (dVar2 != null) {
                dependencyNode = dVar2.f6603h;
                if (!dependencyNode.f6593j) {
                }
            }
            i15 = 8;
            i16 = 0;
            c11 = 1;
        } else {
            i15 = 8;
            i16 = 0;
            c11 = 1;
            constraintWidget3 = this;
        }
        z22 = true;
        if (constraintWidget3.f6569u == 2) {
            if (constraintWidget3.f6532b0[c11] == dimensionBehaviour2) {
                z23 = false;
            } else {
                z23 = false;
            }
            if (z23) {
                i12 = 0;
            }
            constraintWidget5 = constraintWidget3.f6534c0;
            if (constraintWidget5 != null) {
                solverVariableQ = dVar.q(constraintWidget5.T);
            } else {
                solverVariableQ = null;
            }
            constraintWidget6 = constraintWidget3.f6534c0;
            if (constraintWidget6 != null) {
                solverVariableQ2 = dVar.q(constraintWidget6.R);
            } else {
                solverVariableQ2 = null;
            }
            if (constraintWidget3.f6556n0 <= 0) {
                constraintAnchor = constraintWidget3.U;
                if (constraintAnchor.f6524f != null) {
                    dVar.e(solverVariable3, solverVariable5, r(), i15);
                    dVar.e(solverVariable3, dVar.q(constraintWidget3.U.f6524f), constraintWidget3.U.f(), i15);
                    if (z13 != 0) {
                        dVar.h(solverVariableQ, dVar.q(constraintWidget3.T), i16, 5);
                    }
                    z24 = false;
                } else {
                    if (constraintWidget3.f6570u0 == i15) {
                        dVar.e(solverVariable3, solverVariable5, constraintAnchor.f(), i15);
                    } else {
                        dVar.e(solverVariable3, solverVariable5, r(), i15);
                    }
                    z24 = z19;
                }
            } else {
                constraintAnchor = constraintWidget3.U;
                if (constraintAnchor.f6524f != null) {
                    dVar.e(solverVariable3, solverVariable5, r(), i15);
                    dVar.e(solverVariable3, dVar.q(constraintWidget3.U.f6524f), constraintWidget3.U.f(), i15);
                    if (z13 != 0) {
                        dVar.h(solverVariableQ, dVar.q(constraintWidget3.T), i16, 5);
                    }
                    z24 = false;
                } else {
                    if (constraintWidget3.f6570u0 == i15) {
                        dVar.e(solverVariable3, solverVariable5, constraintAnchor.f(), i15);
                    } else {
                        dVar.e(solverVariable3, solverVariable5, r(), i15);
                    }
                    z24 = z19;
                }
            }
            boolean z310 = constraintWidget3.f6541g[c11];
            dimensionBehaviourArr = constraintWidget3.f6532b0;
            DimensionBehaviour dimensionBehaviour10 = dimensionBehaviourArr[c11];
            ConstraintAnchor constraintAnchor10 = constraintWidget3.R;
            ConstraintAnchor constraintAnchor11 = constraintWidget3.T;
            int i312 = constraintWidget3.f6546i0;
            int i313 = constraintWidget3.f6560p0;
            int i42 = constraintWidget3.J[c11];
            float f16 = constraintWidget3.f6564r0;
            if (dimensionBehaviourArr[0] == dimensionBehaviour4) {
                z25 = true;
            } else {
                z25 = false;
            }
            i(dVar, false, z13, z12, z310, solverVariableQ2, solverVariableQ, dimensionBehaviour10, z23, constraintAnchor10, constraintAnchor11, i312, i12, i313, i42, f16, z17, z25, z14, z15, z21, i29, i28, constraintWidget3.C, constraintWidget3.D, constraintWidget3.E, z24);
        }
        if (z16) {
            constraintWidget4 = this;
            if (constraintWidget4.H == 1) {
                dVar.k(solverVariable4, solverVariable5, solverVariable, solverVariable2, constraintWidget4.I, 8);
            } else {
                dVar.k(solverVariable, solverVariable2, solverVariable4, solverVariable5, constraintWidget4.I, 8);
            }
        } else {
            constraintWidget4 = this;
        }
        if (constraintWidget4.X.o()) {
            dVar.b(constraintWidget4, constraintWidget4.X.j().h(), (float) Math.toRadians(constraintWidget4.K + 90.0f), constraintWidget4.X.f());
        }
        constraintWidget4.f6559p = false;
        constraintWidget4.f6561q = false;
    }

    public void g0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11, int i12) {
        q(type).b(constraintWidget.q(type2), i11, i12, true);
    }

    public void g1(ConstraintWidget constraintWidget) {
        this.f6534c0 = constraintWidget;
    }

    public boolean h() {
        return this.f6570u0 != 8;
    }

    public final boolean h0(int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i12 = i11 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.Y;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i12];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6524f;
        return (constraintAnchor4 == null || constraintAnchor4.f6524f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i12 + 1]).f6524f) == null || constraintAnchor2.f6524f != constraintAnchor) ? false : true;
    }

    public void h1(float f11) {
        this.f6564r0 = f11;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0188  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:109:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:239:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:241:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:247:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:250:0x0430  */
    /* JADX WARN: Code duplicated, block: B:258:0x0452  */
    /* JADX WARN: Code duplicated, block: B:268:0x0469  */
    /* JADX WARN: Code duplicated, block: B:271:0x0483  */
    /* JADX WARN: Code duplicated, block: B:281:0x049d  */
    /* JADX WARN: Code duplicated, block: B:284:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:285:0x04a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:305:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:307:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:309:0x04d6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:315:0x04ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:316:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:317:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:319:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:320:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:322:0x0500 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:32:0x0088  */
    /* JADX WARN: Code duplicated, block: B:353:0x0548 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x0092  */
    /* JADX WARN: Code duplicated, block: B:36:0x0096  */
    /* JADX WARN: Code duplicated, block: B:382:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x010a  */
    /* JADX WARN: Code duplicated, block: B:70:0x010c  */
    /* JADX WARN: Code duplicated, block: B:72:0x010f  */
    /* JADX WARN: Code duplicated, block: B:73:0x0111  */
    /* JADX WARN: Code duplicated, block: B:80:0x011c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126  */
    /* JADX WARN: Code duplicated, block: B:86:0x012b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0134 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:91:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x013c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0144  */
    /* JADX WARN: Code duplicated, block: B:95:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x015c  */
    public final void i(androidx.constraintlayout.core.d dVar, boolean z11, boolean z12, boolean z13, boolean z14, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z15, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11, int i12, int i13, int i14, float f11, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, int i15, int i16, int i17, int i18, float f12, boolean z22) {
        int i19;
        boolean z23;
        int i21;
        int i22;
        int i23;
        int iMin;
        int i24;
        int i25;
        int i26;
        boolean z24;
        ConstraintAnchor.Type typeK;
        ConstraintAnchor.Type type;
        SolverVariable solverVariableQ;
        SolverVariable solverVariableQ2;
        ConstraintAnchor constraintAnchor3;
        int i27;
        int i28;
        boolean z25;
        boolean z26;
        int i29;
        boolean z27;
        boolean z28;
        SolverVariable solverVariable3;
        int i31;
        boolean z29;
        boolean z30;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable5;
        ConstraintWidget constraintWidget3;
        int i32;
        int i33;
        int i34;
        SolverVariable solverVariable6;
        int iF;
        int iF2;
        int iMin2;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i41 = i18;
        SolverVariable solverVariableQ3 = dVar.q(constraintAnchor);
        SolverVariable solverVariableQ4 = dVar.q(constraintAnchor2);
        SolverVariable solverVariableQ5 = dVar.q(constraintAnchor.j());
        SolverVariable solverVariableQ6 = dVar.q(constraintAnchor2.j());
        androidx.constraintlayout.core.d.x();
        boolean zO = constraintAnchor.o();
        boolean zO2 = constraintAnchor2.o();
        boolean zO3 = this.X.o();
        int i42 = zO2 ? (zO ? 1 : 0) + 1 : zO ? 1 : 0;
        if (zO3) {
            i42++;
        }
        int i43 = z16 ? 3 : i15;
        int i44 = a.f6582b[dimensionBehaviour.ordinal()];
        if (i44 != 1 && i44 != 2 && i44 != 3 && i44 == 4) {
            i19 = i43;
            z23 = i19 != 4;
            i21 = this.f6551l;
            if (i21 != -1 && z11) {
                this.f6551l = -1;
                i12 = i21;
                z23 = false;
            }
            i22 = this.f6553m;
            if (i22 != -1 || z11) {
                i22 = i12;
            } else {
                this.f6553m = -1;
                z23 = false;
            }
            i23 = i22;
            if (this.f6570u0 == 8) {
                iMin = 0;
                z23 = false;
            } else {
                iMin = i23;
            }
            if (!z22) {
                if (zO && !zO2 && !zO3) {
                    dVar.f(solverVariableQ3, i11);
                } else if (!zO && !zO2) {
                    dVar.e(solverVariableQ3, solverVariableQ5, constraintAnchor.f(), 8);
                }
            }
            if (!z23) {
                if (i42 == 2 && !z16 && (i19 == 1 || i19 == 0)) {
                    int iMax = Math.max(i17, iMin);
                    if (i41 > 0) {
                        iMax = Math.min(i41, iMax);
                    }
                    dVar.e(solverVariableQ4, solverVariableQ3, iMax, 8);
                    z24 = false;
                } else {
                    if (i17 == -2) {
                        i24 = iMin;
                    } else {
                        i24 = i17;
                    }
                    if (i41 == -2) {
                        i25 = iMin;
                    } else {
                        i25 = i41;
                    }
                    if (iMin > 0 && i19 != 1) {
                        iMin = 0;
                    }
                    if (i24 > 0) {
                        dVar.h(solverVariableQ4, solverVariableQ3, i24, 8);
                        iMin = Math.max(iMin, i24);
                    }
                    if (i25 > 0) {
                        if (z12 || i19 != 1) {
                            dVar.j(solverVariableQ4, solverVariableQ3, i25, 8);
                        }
                        iMin = Math.min(iMin, i25);
                    }
                    if (i19 == 1) {
                        if (z12) {
                            dVar.e(solverVariableQ4, solverVariableQ3, iMin, 8);
                        } else if (z18) {
                            dVar.e(solverVariableQ4, solverVariableQ3, iMin, 5);
                            dVar.j(solverVariableQ4, solverVariableQ3, iMin, 8);
                        } else {
                            dVar.e(solverVariableQ4, solverVariableQ3, iMin, 5);
                            dVar.j(solverVariableQ4, solverVariableQ3, iMin, 8);
                        }
                        i41 = i25;
                        i42 = i42 == true ? 1 : 0;
                        solverVariableQ4 = solverVariableQ4;
                        z24 = z23;
                        solverVariableQ6 = solverVariableQ6;
                        z14 = z14;
                        i26 = i24;
                        solverVariableQ5 = solverVariableQ5;
                    } else if (i19 == 2) {
                        typeK = constraintAnchor.k();
                        type = ConstraintAnchor.Type.TOP;
                        if (typeK != type || constraintAnchor.k() == ConstraintAnchor.Type.BOTTOM) {
                            solverVariableQ = dVar.q(this.f6534c0.q(type));
                            solverVariableQ2 = dVar.q(this.f6534c0.q(ConstraintAnchor.Type.BOTTOM));
                        } else {
                            solverVariableQ = dVar.q(this.f6534c0.q(ConstraintAnchor.Type.LEFT));
                            solverVariableQ2 = dVar.q(this.f6534c0.q(ConstraintAnchor.Type.RIGHT));
                        }
                        SolverVariable solverVariable7 = solverVariableQ;
                        SolverVariable solverVariable8 = solverVariableQ2;
                        androidx.constraintlayout.core.b bVarR = dVar.r();
                        int i45 = i25;
                        i42 = i42 == true ? 1 : 0;
                        solverVariableQ6 = solverVariableQ6;
                        int i46 = i24;
                        solverVariableQ5 = solverVariableQ5;
                        solverVariableQ4 = solverVariableQ4;
                        dVar.d(bVarR.k(solverVariableQ4, solverVariableQ3, solverVariable8, solverVariable7, f12));
                        if (z12) {
                            z23 = false;
                        }
                        i41 = i45;
                        i26 = i46;
                        z24 = z23;
                        z14 = z14;
                    } else {
                        int i47 = i25;
                        int i48 = i24;
                        i42 = i42 == true ? 1 : 0;
                        solverVariableQ5 = solverVariableQ5;
                        solverVariableQ4 = solverVariableQ4;
                        solverVariableQ6 = solverVariableQ6;
                        i41 = i47;
                        i26 = i48;
                        z24 = z23;
                        z14 = true;
                    }
                }
                if (z22 || z18) {
                    if (i42 >= 2 && z12 && z14) {
                        dVar.h(solverVariableQ3, solverVariable, 0, 8);
                        boolean z31 = z11 || this.U.f6524f == null;
                        if (!z11 && (constraintAnchor3 = this.U.f6524f) != null) {
                            ConstraintWidget constraintWidget6 = constraintAnchor3.f6522d;
                            if (constraintWidget6.f6540f0 == 0.0f) {
                                return;
                            }
                            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.f6532b0;
                            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                            DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                            if (dimensionBehaviour2 != dimensionBehaviour3 || dimensionBehaviourArr[1] != dimensionBehaviour3) {
                                return;
                            }
                        } else if (!z31) {
                            return;
                        }
                        dVar.h(solverVariable2, solverVariableQ4, 0, 8);
                        return;
                    }
                    return;
                }
                if (zO || zO2 || zO3) {
                    if (!zO || zO2) {
                        if (!zO && zO2) {
                            dVar.e(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), 8);
                            if (z12) {
                                if (this.f6547j && solverVariableQ3.f6313h && (constraintWidget4 = this.f6534c0) != null) {
                                    d dVar2 = (d) constraintWidget4;
                                    if (z11) {
                                        dVar2.D1(constraintAnchor);
                                    } else {
                                        dVar2.I1(constraintAnchor);
                                    }
                                } else {
                                    dVar.h(solverVariableQ3, solverVariable, 0, 5);
                                }
                            }
                        } else if (zO && zO2) {
                            ConstraintWidget constraintWidget7 = constraintAnchor.f6524f.f6522d;
                            ConstraintWidget constraintWidget8 = constraintAnchor2.f6524f.f6522d;
                            ConstraintWidget constraintWidgetM = M();
                            if (z24) {
                                if (i19 == 0) {
                                    if (i41 != 0 || i26 != 0) {
                                        i39 = 5;
                                        i40 = 5;
                                        z25 = true;
                                        z27 = false;
                                        z26 = true;
                                    } else if (solverVariableQ5.f6313h && solverVariableQ6.f6313h) {
                                        dVar.e(solverVariableQ3, solverVariableQ5, constraintAnchor.f(), 8);
                                        dVar.e(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), 8);
                                        return;
                                    } else {
                                        i39 = 8;
                                        i40 = 8;
                                        z25 = false;
                                        z27 = true;
                                        z26 = false;
                                    }
                                    if ((constraintWidget7 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                        i27 = 6;
                                        i28 = 4;
                                    } else {
                                        i28 = i40;
                                        i27 = 6;
                                    }
                                    i29 = i39;
                                } else if (i19 == 2) {
                                    if (!(constraintWidget7 instanceof androidx.constraintlayout.core.widgets.a) && !(constraintWidget8 instanceof androidx.constraintlayout.core.widgets.a)) {
                                        solverVariable2 = solverVariable2;
                                        i27 = 6;
                                        i28 = 5;
                                    }
                                    i29 = 5;
                                    z26 = true;
                                    z25 = true;
                                    z27 = false;
                                } else if (i19 == 1) {
                                    solverVariable2 = solverVariable2;
                                    i27 = 6;
                                    i28 = 4;
                                    i29 = 8;
                                    z26 = true;
                                    z25 = true;
                                    z27 = false;
                                } else if (i19 == 3) {
                                    if (this.H == -1) {
                                        if (z19) {
                                            solverVariable2 = solverVariable2;
                                            i27 = z12 ? 5 : 4;
                                        } else {
                                            solverVariable2 = solverVariable2;
                                            i27 = 8;
                                        }
                                        i28 = 5;
                                        i29 = 8;
                                    } else if (z16) {
                                        if (i16 == 2 || i16 == 1) {
                                            i37 = 5;
                                            i38 = 4;
                                        } else {
                                            i37 = 8;
                                            i38 = 5;
                                        }
                                        i29 = i37;
                                        i28 = i38;
                                        i27 = 6;
                                        z26 = true;
                                        z25 = true;
                                        z27 = true;
                                        solverVariable2 = solverVariable2;
                                    } else {
                                        if (i41 > 0) {
                                            i27 = 6;
                                            i28 = 5;
                                        } else if (i41 != 0 || i26 != 0) {
                                            i27 = 6;
                                            i28 = 4;
                                        } else if (z19) {
                                            solverVariable2 = solverVariable2;
                                            i29 = (constraintWidget7 == constraintWidgetM || constraintWidget8 == constraintWidgetM) ? 5 : 4;
                                            i27 = 6;
                                            i28 = 4;
                                        } else {
                                            i27 = 6;
                                            i28 = 8;
                                        }
                                        i29 = 5;
                                    }
                                    z26 = true;
                                    z25 = true;
                                    z27 = true;
                                } else {
                                    solverVariable2 = solverVariable2;
                                    i27 = 6;
                                    i28 = 4;
                                    i29 = 5;
                                    z26 = false;
                                    z25 = false;
                                    z27 = false;
                                }
                                if (z26 || solverVariableQ5 != solverVariableQ6 || constraintWidget7 == constraintWidgetM) {
                                    z28 = true;
                                } else {
                                    z26 = false;
                                    z28 = false;
                                }
                                if (z25) {
                                    if (z24 && !z17 && !z19 && solverVariableQ5 == solverVariable && solverVariableQ6 == solverVariable2) {
                                        z29 = false;
                                        i29 = 8;
                                        i36 = 8;
                                        z28 = false;
                                    } else {
                                        i36 = i27;
                                        z29 = z12;
                                    }
                                    solverVariable3 = solverVariableQ5;
                                    i31 = 8;
                                    dVar.c(solverVariableQ3, solverVariable3, constraintAnchor.f(), f11, solverVariableQ6, solverVariableQ4, constraintAnchor2.f(), i36);
                                } else {
                                    solverVariable3 = solverVariableQ5;
                                    i31 = 8;
                                    z29 = z12;
                                }
                                z30 = z28;
                                if (this.f6570u0 != i31 && !constraintAnchor2.m()) {
                                    return;
                                }
                                solverVariable4 = solverVariable3;
                                if (z26) {
                                    if (z29 || solverVariable4 == solverVariableQ6 || z24) {
                                        constraintWidget = constraintWidget8;
                                        constraintWidget2 = constraintWidget7;
                                    } else {
                                        constraintWidget2 = constraintWidget7;
                                        if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a) {
                                            constraintWidget = constraintWidget8;
                                        } else {
                                            constraintWidget = constraintWidget8;
                                            if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
                                            }
                                            solverVariable5 = solverVariableQ3;
                                            dVar.h(solverVariable5, solverVariable4, constraintAnchor.f(), i35);
                                            dVar.j(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), i35);
                                            i29 = i35;
                                        }
                                        i35 = 6;
                                        solverVariable5 = solverVariableQ3;
                                        dVar.h(solverVariable5, solverVariable4, constraintAnchor.f(), i35);
                                        dVar.j(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), i35);
                                        i29 = i35;
                                    }
                                    i35 = i29;
                                    solverVariable5 = solverVariableQ3;
                                    dVar.h(solverVariable5, solverVariable4, constraintAnchor.f(), i35);
                                    dVar.j(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), i35);
                                    i29 = i35;
                                } else {
                                    constraintWidget = constraintWidget8;
                                    constraintWidget2 = constraintWidget7;
                                    solverVariable5 = solverVariableQ3;
                                }
                                if (z29 || !z21 || (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.a)) {
                                    constraintWidget3 = constraintWidgetM;
                                } else {
                                    constraintWidget3 = constraintWidgetM;
                                    if (constraintWidget != constraintWidget3) {
                                        z30 = true;
                                        i32 = 6;
                                        i33 = 6;
                                    }
                                    if (z30) {
                                        if (z27 || (z19 && !z13)) {
                                            iMin2 = i32;
                                        } else {
                                            int i49 = (constraintWidget2 == constraintWidget3 || constraintWidget == constraintWidget3) ? 6 : i32;
                                            if ((constraintWidget2 instanceof f) || (constraintWidget instanceof f)) {
                                                i49 = 5;
                                            }
                                            if ((constraintWidget2 instanceof androidx.constraintlayout.core.widgets.a) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.a)) {
                                                i49 = 5;
                                            }
                                            if (z19) {
                                                i49 = 5;
                                            }
                                            iMin2 = Math.max(i49, i32);
                                        }
                                        if (z29) {
                                            iMin2 = Math.min(i33, iMin2);
                                            if (z16 && !z19 && (constraintWidget2 == constraintWidget3 || constraintWidget == constraintWidget3)) {
                                                iMin2 = 4;
                                            }
                                        }
                                        dVar.e(solverVariable5, solverVariable4, constraintAnchor.f(), iMin2);
                                        dVar.e(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), iMin2);
                                    }
                                    if (z29) {
                                        if (solverVariable == solverVariable4) {
                                            iF2 = constraintAnchor.f();
                                        } else {
                                            iF2 = 0;
                                        }
                                        if (solverVariable4 != solverVariable) {
                                            i34 = 5;
                                            dVar.h(solverVariable5, solverVariable, iF2, 5);
                                        } else {
                                            i34 = 5;
                                        }
                                    } else {
                                        i34 = 5;
                                    }
                                    if (!z29 && z24) {
                                        solverVariable6 = solverVariableQ6;
                                        if (i13 == 0 && i26 == 0) {
                                            if (z24 && i19 == 3) {
                                                iF = 0;
                                                dVar.h(solverVariableQ4, solverVariable5, 0, i31);
                                            } else {
                                                iF = 0;
                                                dVar.h(solverVariableQ4, solverVariable5, 0, i34);
                                            }
                                        }
                                    }
                                    iF = 0;
                                }
                                i32 = i28;
                                i33 = i29;
                                if (z30) {
                                    if (z27) {
                                        iMin2 = i32;
                                    } else {
                                        iMin2 = i32;
                                    }
                                    if (z29) {
                                        iMin2 = Math.min(i33, iMin2);
                                        if (z16) {
                                            iMin2 = 4;
                                        }
                                    }
                                    dVar.e(solverVariable5, solverVariable4, constraintAnchor.f(), iMin2);
                                    dVar.e(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), iMin2);
                                }
                                if (z29) {
                                    i34 = 5;
                                } else {
                                    if (solverVariable == solverVariable4) {
                                        iF2 = constraintAnchor.f();
                                    } else {
                                        iF2 = 0;
                                    }
                                    if (solverVariable4 != solverVariable) {
                                        i34 = 5;
                                        dVar.h(solverVariable5, solverVariable, iF2, 5);
                                    } else {
                                        i34 = 5;
                                    }
                                }
                                if (!z29) {
                                }
                            } else if (solverVariableQ5.f6313h && solverVariableQ6.f6313h) {
                                dVar.c(solverVariableQ3, solverVariableQ5, constraintAnchor.f(), f11, solverVariableQ6, solverVariableQ4, constraintAnchor2.f(), 8);
                                if (z12 && z14) {
                                    int iF3 = constraintAnchor2.f6524f != null ? constraintAnchor2.f() : 0;
                                    if (solverVariableQ6 != solverVariable2) {
                                        dVar.h(solverVariable2, solverVariableQ4, iF3, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            i27 = 6;
                            i28 = 4;
                            i29 = 5;
                            z26 = true;
                            z25 = true;
                            z27 = false;
                            if (z26) {
                                z28 = true;
                            } else {
                                z28 = true;
                            }
                            if (z25) {
                                if (z24) {
                                    i36 = i27;
                                    z29 = z12;
                                } else {
                                    i36 = i27;
                                    z29 = z12;
                                }
                                solverVariable3 = solverVariableQ5;
                                i31 = 8;
                                dVar.c(solverVariableQ3, solverVariable3, constraintAnchor.f(), f11, solverVariableQ6, solverVariableQ4, constraintAnchor2.f(), i36);
                            } else {
                                solverVariable3 = solverVariableQ5;
                                i31 = 8;
                                z29 = z12;
                            }
                            z30 = z28;
                            if (this.f6570u0 != i31) {
                            }
                            solverVariable4 = solverVariable3;
                            if (z26) {
                                if (z29) {
                                    constraintWidget = constraintWidget8;
                                    constraintWidget2 = constraintWidget7;
                                    i35 = i29;
                                } else {
                                    constraintWidget = constraintWidget8;
                                    constraintWidget2 = constraintWidget7;
                                    i35 = i29;
                                }
                                solverVariable5 = solverVariableQ3;
                                dVar.h(solverVariable5, solverVariable4, constraintAnchor.f(), i35);
                                dVar.j(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), i35);
                                i29 = i35;
                            } else {
                                constraintWidget = constraintWidget8;
                                constraintWidget2 = constraintWidget7;
                                solverVariable5 = solverVariableQ3;
                            }
                            if (z29) {
                                constraintWidget3 = constraintWidgetM;
                                i32 = i28;
                                i33 = i29;
                            } else {
                                constraintWidget3 = constraintWidgetM;
                                i32 = i28;
                                i33 = i29;
                            }
                            if (z30) {
                                if (z27) {
                                    iMin2 = i32;
                                } else {
                                    iMin2 = i32;
                                }
                                if (z29) {
                                    iMin2 = Math.min(i33, iMin2);
                                    if (z16) {
                                        iMin2 = 4;
                                    }
                                }
                                dVar.e(solverVariable5, solverVariable4, constraintAnchor.f(), iMin2);
                                dVar.e(solverVariableQ4, solverVariableQ6, -constraintAnchor2.f(), iMin2);
                            }
                            if (z29) {
                                i34 = 5;
                            } else {
                                if (solverVariable == solverVariable4) {
                                    iF2 = constraintAnchor.f();
                                } else {
                                    iF2 = 0;
                                }
                                if (solverVariable4 != solverVariable) {
                                    i34 = 5;
                                    dVar.h(solverVariable5, solverVariable, iF2, 5);
                                } else {
                                    i34 = 5;
                                }
                            }
                            if (!z29) {
                            }
                        }
                        solverVariable6 = solverVariableQ6;
                        i34 = 5;
                        iF = 0;
                        z29 = z12;
                    } else {
                        z29 = z12;
                        i34 = (z12 && (constraintAnchor.f6524f.f6522d instanceof androidx.constraintlayout.core.widgets.a)) ? 8 : 5;
                    }
                    solverVariable6 = solverVariableQ6;
                    iF = 0;
                } else {
                    solverVariable6 = solverVariableQ6;
                    i34 = 5;
                    iF = 0;
                    z29 = z12;
                }
                if (z29 && z14) {
                    if (constraintAnchor2.f6524f != null) {
                        iF = constraintAnchor2.f();
                    }
                    if (solverVariable6 != solverVariable2) {
                        if (!this.f6547j || !solverVariableQ4.f6313h || (constraintWidget5 = this.f6534c0) == null) {
                            dVar.h(solverVariable2, solverVariableQ4, iF, i34);
                            return;
                        }
                        d dVar3 = (d) constraintWidget5;
                        if (z11) {
                            dVar3.C1(constraintAnchor2);
                            return;
                        } else {
                            dVar3.H1(constraintAnchor2);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (z15) {
                dVar.e(solverVariableQ4, solverVariableQ3, 0, 3);
                if (i13 > 0) {
                    dVar.h(solverVariableQ4, solverVariableQ3, i13, 8);
                }
                if (i14 < Integer.MAX_VALUE) {
                    dVar.j(solverVariableQ4, solverVariableQ3, i14, 8);
                }
            } else {
                dVar.e(solverVariableQ4, solverVariableQ3, iMin, 8);
            }
            z24 = z23;
            i26 = i17;
            if (z22) {
            }
            if (i42 >= 2) {
            }
        }
        i19 = i43;
        i21 = this.f6551l;
        if (i21 != -1) {
            this.f6551l = -1;
            i12 = i21;
            z23 = false;
        }
        i22 = this.f6553m;
        if (i22 != -1) {
            i22 = i12;
        } else {
            i22 = i12;
        }
        i23 = i22;
        if (this.f6570u0 == 8) {
            iMin = 0;
            z23 = false;
        } else {
            iMin = i23;
        }
        if (!z22) {
            if (zO) {
                if (!zO) {
                }
            } else if (!zO) {
            }
        }
        if (!z23) {
            if (i42 == 2) {
            }
            if (i17 == -2) {
                i24 = iMin;
            } else {
                i24 = i17;
            }
            if (i41 == -2) {
                i25 = iMin;
            } else {
                i25 = i41;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i24 > 0) {
                dVar.h(solverVariableQ4, solverVariableQ3, i24, 8);
                iMin = Math.max(iMin, i24);
            }
            if (i25 > 0) {
                if (z12) {
                    dVar.j(solverVariableQ4, solverVariableQ3, i25, 8);
                } else {
                    dVar.j(solverVariableQ4, solverVariableQ3, i25, 8);
                }
                iMin = Math.min(iMin, i25);
            }
            if (i19 == 1) {
                if (z12) {
                    dVar.e(solverVariableQ4, solverVariableQ3, iMin, 8);
                } else if (z18) {
                    dVar.e(solverVariableQ4, solverVariableQ3, iMin, 5);
                    dVar.j(solverVariableQ4, solverVariableQ3, iMin, 8);
                } else {
                    dVar.e(solverVariableQ4, solverVariableQ3, iMin, 5);
                    dVar.j(solverVariableQ4, solverVariableQ3, iMin, 8);
                }
                i41 = i25;
                i42 = i42 == true ? 1 : 0;
                solverVariableQ4 = solverVariableQ4;
                z24 = z23;
                solverVariableQ6 = solverVariableQ6;
                z14 = z14;
                i26 = i24;
                solverVariableQ5 = solverVariableQ5;
            } else if (i19 == 2) {
                typeK = constraintAnchor.k();
                type = ConstraintAnchor.Type.TOP;
                if (typeK != type) {
                    solverVariableQ = dVar.q(this.f6534c0.q(type));
                    solverVariableQ2 = dVar.q(this.f6534c0.q(ConstraintAnchor.Type.BOTTOM));
                } else {
                    solverVariableQ = dVar.q(this.f6534c0.q(type));
                    solverVariableQ2 = dVar.q(this.f6534c0.q(ConstraintAnchor.Type.BOTTOM));
                }
                SolverVariable solverVariable9 = solverVariableQ;
                SolverVariable solverVariable10 = solverVariableQ2;
                androidx.constraintlayout.core.b bVarR2 = dVar.r();
                int i410 = i25;
                i42 = i42 == true ? 1 : 0;
                solverVariableQ6 = solverVariableQ6;
                int i411 = i24;
                solverVariableQ5 = solverVariableQ5;
                solverVariableQ4 = solverVariableQ4;
                dVar.d(bVarR2.k(solverVariableQ4, solverVariableQ3, solverVariable10, solverVariable9, f12));
                if (z12) {
                    z23 = false;
                }
                i41 = i410;
                i26 = i411;
                z24 = z23;
                z14 = z14;
            } else {
                int i412 = i25;
                int i413 = i24;
                i42 = i42 == true ? 1 : 0;
                solverVariableQ5 = solverVariableQ5;
                solverVariableQ4 = solverVariableQ4;
                solverVariableQ6 = solverVariableQ6;
                i41 = i412;
                i26 = i413;
                z24 = z23;
                z14 = true;
            }
            if (z22) {
            }
            if (i42 >= 2) {
            }
        }
        if (z15) {
            dVar.e(solverVariableQ4, solverVariableQ3, 0, 3);
            if (i13 > 0) {
                dVar.h(solverVariableQ4, solverVariableQ3, i13, 8);
            }
            if (i14 < Integer.MAX_VALUE) {
                dVar.j(solverVariableQ4, solverVariableQ3, i14, 8);
            }
        } else {
            dVar.e(solverVariableQ4, solverVariableQ3, iMin, 8);
        }
        z24 = z23;
        i26 = i17;
        if (z22) {
        }
        if (i42 >= 2) {
        }
    }

    public boolean i0() {
        return this.f6563r;
    }

    public void i1(int i11) {
        this.K0 = i11;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        k(type, constraintWidget, type2, 0);
    }

    public boolean j0(int i11) {
        return this.f6530a0[i11];
    }

    public void j1(int i11, int i12) {
        this.f6546i0 = i11;
        int i13 = i12 - i11;
        this.f6538e0 = i13;
        int i14 = this.f6560p0;
        if (i13 < i14) {
            this.f6538e0 = i14;
        }
    }

    public void k(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i11) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z11;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 != type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                if (type2 == type6 || type2 == ConstraintAnchor.Type.RIGHT) {
                    k(type6, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
                if (type2 == type7 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    k(type7, constraintWidget, type2, 0);
                    k(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    q(type5).a(constraintWidget.q(type2), 0);
                    return;
                }
                return;
            }
            ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor constraintAnchorQ = q(type8);
            ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor constraintAnchorQ2 = q(type9);
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor constraintAnchorQ3 = q(type10);
            ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor constraintAnchorQ4 = q(type11);
            boolean z12 = true;
            if ((constraintAnchorQ == null || !constraintAnchorQ.o()) && (constraintAnchorQ2 == null || !constraintAnchorQ2.o())) {
                k(type8, constraintWidget, type8, 0);
                k(type9, constraintWidget, type9, 0);
                z11 = true;
            } else {
                z11 = false;
            }
            if ((constraintAnchorQ3 == null || !constraintAnchorQ3.o()) && (constraintAnchorQ4 == null || !constraintAnchorQ4.o())) {
                k(type10, constraintWidget, type10, 0);
                k(type11, constraintWidget, type11, 0);
            } else {
                z12 = false;
            }
            if (z11 && z12) {
                q(type5).a(constraintWidget.q(type5), 0);
                return;
            }
            if (z11) {
                ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_X;
                q(type12).a(constraintWidget.q(type12), 0);
                return;
            } else {
                if (z12) {
                    ConstraintAnchor.Type type13 = ConstraintAnchor.Type.CENTER_Y;
                    q(type13).a(constraintWidget.q(type13), 0);
                    return;
                }
                return;
            }
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor constraintAnchorQ5 = q(type4);
            ConstraintAnchor constraintAnchorQ6 = constraintWidget.q(type2);
            ConstraintAnchor constraintAnchorQ7 = q(ConstraintAnchor.Type.RIGHT);
            constraintAnchorQ5.a(constraintAnchorQ6, 0);
            constraintAnchorQ7.a(constraintAnchorQ6, 0);
            q(type14).a(constraintAnchorQ6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor constraintAnchorQ8 = constraintWidget.q(type2);
            q(type3).a(constraintAnchorQ8, 0);
            q(ConstraintAnchor.Type.BOTTOM).a(constraintAnchorQ8, 0);
            q(type15).a(constraintAnchorQ8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            q(type16).a(constraintWidget.q(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            q(type17).a(constraintWidget.q(type17), 0);
            q(type14).a(constraintWidget.q(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            q(type18).a(constraintWidget.q(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            q(type19).a(constraintWidget.q(type19), 0);
            q(type15).a(constraintWidget.q(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorQ9 = q(type);
        ConstraintAnchor constraintAnchorQ10 = constraintWidget.q(type2);
        if (constraintAnchorQ9.p(constraintAnchorQ10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor constraintAnchorQ11 = q(ConstraintAnchor.Type.TOP);
                ConstraintAnchor constraintAnchorQ12 = q(ConstraintAnchor.Type.BOTTOM);
                if (constraintAnchorQ11 != null) {
                    constraintAnchorQ11.q();
                }
                if (constraintAnchorQ12 != null) {
                    constraintAnchorQ12.q();
                }
            } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor constraintAnchorQ13 = q(type20);
                if (constraintAnchorQ13 != null) {
                    constraintAnchorQ13.q();
                }
                ConstraintAnchor constraintAnchorQ14 = q(type5);
                if (constraintAnchorQ14.j() != constraintAnchorQ10) {
                    constraintAnchorQ14.q();
                }
                ConstraintAnchor constraintAnchorG = q(type).g();
                ConstraintAnchor constraintAnchorQ15 = q(type15);
                if (constraintAnchorQ15.o()) {
                    constraintAnchorG.q();
                    constraintAnchorQ15.q();
                }
            } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor constraintAnchorQ16 = q(type5);
                if (constraintAnchorQ16.j() != constraintAnchorQ10) {
                    constraintAnchorQ16.q();
                }
                ConstraintAnchor constraintAnchorG2 = q(type).g();
                ConstraintAnchor constraintAnchorQ17 = q(type14);
                if (constraintAnchorQ17.o()) {
                    constraintAnchorG2.q();
                    constraintAnchorQ17.q();
                }
            }
            constraintAnchorQ9.a(constraintAnchorQ10, i11);
        }
    }

    public boolean k0() {
        ConstraintAnchor constraintAnchor = this.Q;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
        if (constraintAnchor2 != null && constraintAnchor2.f6524f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.S;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6524f;
        return constraintAnchor4 != null && constraintAnchor4.f6524f == constraintAnchor3;
    }

    public void k1(DimensionBehaviour dimensionBehaviour) {
        this.f6532b0[1] = dimensionBehaviour;
    }

    public void l(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i11) {
        if (constraintAnchor.h() == this) {
            k(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i11);
        }
    }

    public boolean l0() {
        return this.M;
    }

    public void l1(int i11, int i12, int i13, float f11) {
        this.f6575x = i11;
        this.C = i12;
        if (i13 == Integer.MAX_VALUE) {
            i13 = 0;
        }
        this.D = i13;
        this.E = f11;
        if (f11 <= 0.0f || f11 >= 1.0f || i11 != 0) {
            return;
        }
        this.f6575x = 2;
    }

    public void m(ConstraintWidget constraintWidget, float f11, int i11) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        g0(type, constraintWidget, type, i11, 0);
        this.K = f11;
    }

    public boolean m0() {
        ConstraintAnchor constraintAnchor = this.R;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f6524f;
        if (constraintAnchor2 != null && constraintAnchor2.f6524f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.T;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f6524f;
        return constraintAnchor4 != null && constraintAnchor4.f6524f == constraintAnchor3;
    }

    public void m1(float f11) {
        this.N0[1] = f11;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.f6567t = constraintWidget.f6567t;
        this.f6569u = constraintWidget.f6569u;
        this.f6573w = constraintWidget.f6573w;
        this.f6575x = constraintWidget.f6575x;
        int[] iArr = this.f6577y;
        int[] iArr2 = constraintWidget.f6577y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f6579z = constraintWidget.f6579z;
        this.A = constraintWidget.A;
        this.C = constraintWidget.C;
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.H = constraintWidget.H;
        this.I = constraintWidget.I;
        int[] iArr3 = constraintWidget.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f6532b0 = (DimensionBehaviour[]) Arrays.copyOf(this.f6532b0, 2);
        this.f6534c0 = this.f6534c0 == null ? null : map.get(constraintWidget.f6534c0);
        this.f6536d0 = constraintWidget.f6536d0;
        this.f6538e0 = constraintWidget.f6538e0;
        this.f6540f0 = constraintWidget.f6540f0;
        this.f6542g0 = constraintWidget.f6542g0;
        this.f6544h0 = constraintWidget.f6544h0;
        this.f6546i0 = constraintWidget.f6546i0;
        this.f6548j0 = constraintWidget.f6548j0;
        this.f6550k0 = constraintWidget.f6550k0;
        this.f6552l0 = constraintWidget.f6552l0;
        this.f6554m0 = constraintWidget.f6554m0;
        this.f6556n0 = constraintWidget.f6556n0;
        this.f6558o0 = constraintWidget.f6558o0;
        this.f6560p0 = constraintWidget.f6560p0;
        this.f6562q0 = constraintWidget.f6562q0;
        this.f6564r0 = constraintWidget.f6564r0;
        this.f6566s0 = constraintWidget.f6566s0;
        this.f6568t0 = constraintWidget.f6568t0;
        this.f6570u0 = constraintWidget.f6570u0;
        this.f6572v0 = constraintWidget.f6572v0;
        this.f6574w0 = constraintWidget.f6574w0;
        this.f6576x0 = constraintWidget.f6576x0;
        this.f6578y0 = constraintWidget.f6578y0;
        this.f6580z0 = constraintWidget.f6580z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        this.F0 = constraintWidget.F0;
        this.G0 = constraintWidget.G0;
        this.H0 = constraintWidget.H0;
        this.J0 = constraintWidget.J0;
        this.K0 = constraintWidget.K0;
        this.L0 = constraintWidget.L0;
        this.M0 = constraintWidget.M0;
        float[] fArr = this.N0;
        float[] fArr2 = constraintWidget.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.O0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.O0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.P0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.P0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.Q0;
        this.Q0 = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.R0;
        this.R0 = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public boolean n0() {
        return this.N;
    }

    public void n1(int i11) {
        this.f6570u0 = i11;
    }

    public void o(androidx.constraintlayout.core.d dVar) {
        dVar.q(this.Q);
        dVar.q(this.R);
        dVar.q(this.S);
        dVar.q(this.T);
        if (this.f6556n0 > 0) {
            dVar.q(this.U);
        }
    }

    public boolean o0() {
        return this.f6545i && this.f6570u0 != 8;
    }

    public void o1(int i11) {
        this.f6536d0 = i11;
        int i12 = this.f6558o0;
        if (i11 < i12) {
            this.f6536d0 = i12;
        }
    }

    public void p() {
        if (this.f6537e == null) {
            this.f6537e = new androidx.constraintlayout.core.widgets.analyzer.c(this);
        }
        if (this.f6539f == null) {
            this.f6539f = new androidx.constraintlayout.core.widgets.analyzer.d(this);
        }
    }

    public boolean p0() {
        return this.f6559p || (this.Q.n() && this.S.n());
    }

    public void p1(int i11) {
        if (i11 < 0 || i11 > 3) {
            return;
        }
        this.f6571v = i11;
    }

    public ConstraintAnchor q(ConstraintAnchor.Type type) {
        switch (a.f6581a[type.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public boolean q0() {
        return this.f6561q || (this.R.n() && this.T.n());
    }

    public void q1(int i11) {
        this.f6544h0 = i11;
    }

    public int r() {
        return this.f6556n0;
    }

    public boolean r0() {
        return this.f6565s;
    }

    public void r1(int i11) {
        this.f6546i0 = i11;
    }

    public float s(int i11) {
        if (i11 == 0) {
            return this.f6562q0;
        }
        if (i11 == 1) {
            return this.f6564r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.f6563r = true;
    }

    public void s1(boolean z11, boolean z12, boolean z13, boolean z14) {
        if (this.H == -1) {
            if (z13 && !z14) {
                this.H = 0;
            } else if (!z13 && z14) {
                this.H = 1;
                if (this.f6542g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i11 = this.f6579z;
            if (i11 > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i11 != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public int t() {
        return a0() + this.f6538e0;
    }

    public void t0() {
        this.f6565s = true;
    }

    public void t1(boolean z11, boolean z12) {
        int i11;
        int i12;
        boolean zK = z11 & this.f6537e.k();
        boolean zK2 = z12 & this.f6539f.k();
        androidx.constraintlayout.core.widgets.analyzer.c cVar = this.f6537e;
        int i13 = cVar.f6603h.f6590g;
        androidx.constraintlayout.core.widgets.analyzer.d dVar = this.f6539f;
        int i14 = dVar.f6603h.f6590g;
        int i15 = cVar.f6604i.f6590g;
        int i16 = dVar.f6604i.f6590g;
        int i17 = i16 - i14;
        if (i15 - i13 < 0 || i17 < 0 || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE || i16 == Integer.MIN_VALUE || i16 == Integer.MAX_VALUE) {
            i15 = 0;
            i13 = 0;
            i16 = 0;
            i14 = 0;
        }
        int i18 = i15 - i13;
        int i19 = i16 - i14;
        if (zK) {
            this.f6544h0 = i13;
        }
        if (zK2) {
            this.f6546i0 = i14;
        }
        if (this.f6570u0 == 8) {
            this.f6536d0 = 0;
            this.f6538e0 = 0;
            return;
        }
        if (zK) {
            if (this.f6532b0[0] == DimensionBehaviour.FIXED && i18 < (i12 = this.f6536d0)) {
                i18 = i12;
            }
            this.f6536d0 = i18;
            int i21 = this.f6558o0;
            if (i18 < i21) {
                this.f6536d0 = i21;
            }
        }
        if (zK2) {
            if (this.f6532b0[1] == DimensionBehaviour.FIXED && i19 < (i11 = this.f6538e0)) {
                i19 = i11;
            }
            this.f6538e0 = i19;
            int i22 = this.f6560p0;
            if (i19 < i22) {
                this.f6538e0 = i22;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.f6576x0 != null) {
            str = "type: " + this.f6576x0 + " ";
        } else {
            str = "";
        }
        sb2.append(str);
        if (this.f6574w0 != null) {
            str2 = "id: " + this.f6574w0 + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.f6544h0);
        sb2.append(", ");
        sb2.append(this.f6546i0);
        sb2.append(") - (");
        sb2.append(this.f6536d0);
        sb2.append(" x ");
        sb2.append(this.f6538e0);
        sb2.append(")");
        return sb2.toString();
    }

    public Object u() {
        return this.f6566s0;
    }

    public boolean u0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f6532b0;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void u1(androidx.constraintlayout.core.d dVar, boolean z11) {
        androidx.constraintlayout.core.widgets.analyzer.d dVar2;
        androidx.constraintlayout.core.widgets.analyzer.c cVar;
        int iY = dVar.y(this.Q);
        int iY2 = dVar.y(this.R);
        int iY3 = dVar.y(this.S);
        int iY4 = dVar.y(this.T);
        if (z11 && (cVar = this.f6537e) != null) {
            DependencyNode dependencyNode = cVar.f6603h;
            if (dependencyNode.f6593j) {
                DependencyNode dependencyNode2 = cVar.f6604i;
                if (dependencyNode2.f6593j) {
                    iY = dependencyNode.f6590g;
                    iY3 = dependencyNode2.f6590g;
                }
            }
        }
        if (z11 && (dVar2 = this.f6539f) != null) {
            DependencyNode dependencyNode3 = dVar2.f6603h;
            if (dependencyNode3.f6593j) {
                DependencyNode dependencyNode4 = dVar2.f6604i;
                if (dependencyNode4.f6593j) {
                    iY2 = dependencyNode3.f6590g;
                    iY4 = dependencyNode4.f6590g;
                }
            }
        }
        int i11 = iY4 - iY2;
        if (iY3 - iY < 0 || i11 < 0 || iY == Integer.MIN_VALUE || iY == Integer.MAX_VALUE || iY2 == Integer.MIN_VALUE || iY2 == Integer.MAX_VALUE || iY3 == Integer.MIN_VALUE || iY3 == Integer.MAX_VALUE || iY4 == Integer.MIN_VALUE || iY4 == Integer.MAX_VALUE) {
            iY = 0;
            iY4 = 0;
            iY2 = 0;
            iY3 = 0;
        }
        N0(iY, iY2, iY3, iY4);
    }

    public String v() {
        return this.f6574w0;
    }

    public void v0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.f6534c0 = null;
        this.K = 0.0f;
        this.f6536d0 = 0;
        this.f6538e0 = 0;
        this.f6540f0 = 0.0f;
        this.f6542g0 = -1;
        this.f6544h0 = 0;
        this.f6546i0 = 0;
        this.f6552l0 = 0;
        this.f6554m0 = 0;
        this.f6556n0 = 0;
        this.f6558o0 = 0;
        this.f6560p0 = 0;
        float f11 = U0;
        this.f6562q0 = f11;
        this.f6564r0 = f11;
        DimensionBehaviour[] dimensionBehaviourArr = this.f6532b0;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f6566s0 = null;
        this.f6568t0 = 0;
        this.f6570u0 = 0;
        this.f6576x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f6567t = -1;
        this.f6569u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f6573w = 0;
        this.f6575x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.D = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f6579z = 0;
        this.C = 0;
        this.f6543h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.f6541g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.f6530a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f6545i = true;
        int[] iArr2 = this.f6577y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f6551l = -1;
        this.f6553m = -1;
    }

    public DimensionBehaviour w(int i11) {
        if (i11 == 0) {
            return C();
        }
        if (i11 == 1) {
            return V();
        }
        return null;
    }

    public void w0() {
        x0();
        h1(U0);
        Q0(U0);
    }

    public float x() {
        return this.f6540f0;
    }

    public void x0() {
        ConstraintWidget constraintWidgetM = M();
        if (constraintWidgetM != null && (constraintWidgetM instanceof d) && ((d) M()).Q1()) {
            return;
        }
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.Z.get(i11).q();
        }
    }

    public int y() {
        return this.f6542g0;
    }

    public void y0() {
        this.f6559p = false;
        this.f6561q = false;
        this.f6563r = false;
        this.f6565s = false;
        int size = this.Z.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.Z.get(i11).r();
        }
    }

    public int z() {
        if (this.f6570u0 == 8) {
            return 0;
        }
        return this.f6538e0;
    }

    public void z0(androidx.constraintlayout.core.c cVar) {
        this.Q.s(cVar);
        this.R.s(cVar);
        this.S.s(cVar);
        this.T.s(cVar);
        this.U.s(cVar);
        this.X.s(cVar);
        this.V.s(cVar);
        this.W.s(cVar);
    }
}

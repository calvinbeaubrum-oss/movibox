package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f7367h = {0, 4, 8};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static SparseIntArray f7368i = new SparseIntArray();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static SparseIntArray f7369j = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f7372c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7373d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f7374e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7375f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<Integer, a> f7376g = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f7379c = new d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f7380d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C0070b f7381e = new C0070b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f7382f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f7383g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0069a f7384h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static class C0069a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f7385a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f7386b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f7387c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f7388d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f7389e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f7390f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f7391g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f7392h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f7393i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f7394j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f7395k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f7396l = 0;

            public void a(int i11, float f11) {
                int i12 = this.f7390f;
                int[] iArr = this.f7388d;
                if (i12 >= iArr.length) {
                    this.f7388d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f7389e;
                    this.f7389e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f7388d;
                int i13 = this.f7390f;
                iArr2[i13] = i11;
                float[] fArr2 = this.f7389e;
                this.f7390f = i13 + 1;
                fArr2[i13] = f11;
            }

            public void b(int i11, int i12) {
                int i13 = this.f7387c;
                int[] iArr = this.f7385a;
                if (i13 >= iArr.length) {
                    this.f7385a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f7386b;
                    this.f7386b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f7385a;
                int i14 = this.f7387c;
                iArr3[i14] = i11;
                int[] iArr4 = this.f7386b;
                this.f7387c = i14 + 1;
                iArr4[i14] = i12;
            }

            public void c(int i11, String str) {
                int i12 = this.f7393i;
                int[] iArr = this.f7391g;
                if (i12 >= iArr.length) {
                    this.f7391g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f7392h;
                    this.f7392h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f7391g;
                int i13 = this.f7393i;
                iArr2[i13] = i11;
                String[] strArr2 = this.f7392h;
                this.f7393i = i13 + 1;
                strArr2[i13] = str;
            }

            public void d(int i11, boolean z11) {
                int i12 = this.f7396l;
                int[] iArr = this.f7394j;
                if (i12 >= iArr.length) {
                    this.f7394j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f7395k;
                    this.f7395k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f7394j;
                int i13 = this.f7396l;
                iArr2[i13] = i11;
                boolean[] zArr2 = this.f7395k;
                this.f7396l = i13 + 1;
                zArr2[i13] = z11;
            }

            public void e(a aVar) {
                for (int i11 = 0; i11 < this.f7387c; i11++) {
                    b.P(aVar, this.f7385a[i11], this.f7386b[i11]);
                }
                for (int i12 = 0; i12 < this.f7390f; i12++) {
                    b.O(aVar, this.f7388d[i12], this.f7389e[i12]);
                }
                for (int i13 = 0; i13 < this.f7393i; i13++) {
                    b.Q(aVar, this.f7391g[i13], this.f7392h[i13]);
                }
                for (int i14 = 0; i14 < this.f7396l; i14++) {
                    b.R(aVar, this.f7394j[i14], this.f7395k[i14]);
                }
            }
        }

        public void d(a aVar) {
            C0069a c0069a = this.f7384h;
            if (c0069a != null) {
                c0069a.e(aVar);
            }
        }

        public void e(ConstraintLayout.b bVar) {
            C0070b c0070b = this.f7381e;
            bVar.f7285e = c0070b.f7416j;
            bVar.f7287f = c0070b.f7418k;
            bVar.f7289g = c0070b.f7420l;
            bVar.f7291h = c0070b.f7422m;
            bVar.f7293i = c0070b.f7424n;
            bVar.f7295j = c0070b.f7426o;
            bVar.f7297k = c0070b.f7428p;
            bVar.f7299l = c0070b.f7430q;
            bVar.f7301m = c0070b.f7432r;
            bVar.f7303n = c0070b.f7433s;
            bVar.f7305o = c0070b.f7434t;
            bVar.f7313s = c0070b.f7435u;
            bVar.f7315t = c0070b.f7436v;
            bVar.f7317u = c0070b.f7437w;
            bVar.f7319v = c0070b.f7438x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = c0070b.H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = c0070b.I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = c0070b.J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = c0070b.K;
            bVar.A = c0070b.T;
            bVar.B = c0070b.S;
            bVar.f7323x = c0070b.P;
            bVar.f7325z = c0070b.R;
            bVar.G = c0070b.f7439y;
            bVar.H = c0070b.f7440z;
            bVar.f7307p = c0070b.B;
            bVar.f7309q = c0070b.C;
            bVar.f7311r = c0070b.D;
            bVar.I = c0070b.A;
            bVar.X = c0070b.E;
            bVar.Y = c0070b.F;
            bVar.M = c0070b.V;
            bVar.L = c0070b.W;
            bVar.O = c0070b.Y;
            bVar.N = c0070b.X;
            bVar.f7278a0 = c0070b.f7425n0;
            bVar.f7280b0 = c0070b.f7427o0;
            bVar.P = c0070b.Z;
            bVar.Q = c0070b.f7399a0;
            bVar.T = c0070b.f7401b0;
            bVar.U = c0070b.f7403c0;
            bVar.R = c0070b.f7405d0;
            bVar.S = c0070b.f7407e0;
            bVar.V = c0070b.f7409f0;
            bVar.W = c0070b.f7411g0;
            bVar.Z = c0070b.G;
            bVar.f7281c = c0070b.f7412h;
            bVar.f7277a = c0070b.f7408f;
            bVar.f7279b = c0070b.f7410g;
            ((ViewGroup.MarginLayoutParams) bVar).width = c0070b.f7404d;
            ((ViewGroup.MarginLayoutParams) bVar).height = c0070b.f7406e;
            String str = c0070b.f7423m0;
            if (str != null) {
                bVar.f7282c0 = str;
            }
            bVar.f7284d0 = c0070b.f7431q0;
            bVar.setMarginStart(c0070b.M);
            bVar.setMarginEnd(this.f7381e.L);
            bVar.c();
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f7381e.a(this.f7381e);
            aVar.f7380d.a(this.f7380d);
            aVar.f7379c.a(this.f7379c);
            aVar.f7382f.a(this.f7382f);
            aVar.f7377a = this.f7377a;
            aVar.f7384h = this.f7384h;
            return aVar;
        }

        public final void g(int i11, ConstraintLayout.b bVar) {
            this.f7377a = i11;
            C0070b c0070b = this.f7381e;
            c0070b.f7416j = bVar.f7285e;
            c0070b.f7418k = bVar.f7287f;
            c0070b.f7420l = bVar.f7289g;
            c0070b.f7422m = bVar.f7291h;
            c0070b.f7424n = bVar.f7293i;
            c0070b.f7426o = bVar.f7295j;
            c0070b.f7428p = bVar.f7297k;
            c0070b.f7430q = bVar.f7299l;
            c0070b.f7432r = bVar.f7301m;
            c0070b.f7433s = bVar.f7303n;
            c0070b.f7434t = bVar.f7305o;
            c0070b.f7435u = bVar.f7313s;
            c0070b.f7436v = bVar.f7315t;
            c0070b.f7437w = bVar.f7317u;
            c0070b.f7438x = bVar.f7319v;
            c0070b.f7439y = bVar.G;
            c0070b.f7440z = bVar.H;
            c0070b.A = bVar.I;
            c0070b.B = bVar.f7307p;
            c0070b.C = bVar.f7309q;
            c0070b.D = bVar.f7311r;
            c0070b.E = bVar.X;
            c0070b.F = bVar.Y;
            c0070b.G = bVar.Z;
            c0070b.f7412h = bVar.f7281c;
            c0070b.f7408f = bVar.f7277a;
            c0070b.f7410g = bVar.f7279b;
            c0070b.f7404d = ((ViewGroup.MarginLayoutParams) bVar).width;
            c0070b.f7406e = ((ViewGroup.MarginLayoutParams) bVar).height;
            c0070b.H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            c0070b.I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            c0070b.J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            c0070b.K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            c0070b.N = bVar.D;
            c0070b.V = bVar.M;
            c0070b.W = bVar.L;
            c0070b.Y = bVar.O;
            c0070b.X = bVar.N;
            c0070b.f7425n0 = bVar.f7278a0;
            c0070b.f7427o0 = bVar.f7280b0;
            c0070b.Z = bVar.P;
            c0070b.f7399a0 = bVar.Q;
            c0070b.f7401b0 = bVar.T;
            c0070b.f7403c0 = bVar.U;
            c0070b.f7405d0 = bVar.R;
            c0070b.f7407e0 = bVar.S;
            c0070b.f7409f0 = bVar.V;
            c0070b.f7411g0 = bVar.W;
            c0070b.f7423m0 = bVar.f7282c0;
            c0070b.P = bVar.f7323x;
            c0070b.R = bVar.f7325z;
            c0070b.O = bVar.f7321w;
            c0070b.Q = bVar.f7324y;
            c0070b.T = bVar.A;
            c0070b.S = bVar.B;
            c0070b.U = bVar.C;
            c0070b.f7431q0 = bVar.f7284d0;
            c0070b.L = bVar.getMarginEnd();
            this.f7381e.M = bVar.getMarginStart();
        }

        public final void h(int i11, Constraints.a aVar) {
            g(i11, aVar);
            this.f7379c.f7459d = aVar.f7336x0;
            e eVar = this.f7382f;
            eVar.f7463b = aVar.A0;
            eVar.f7464c = aVar.B0;
            eVar.f7465d = aVar.C0;
            eVar.f7466e = aVar.D0;
            eVar.f7467f = aVar.E0;
            eVar.f7468g = aVar.F0;
            eVar.f7469h = aVar.G0;
            eVar.f7471j = aVar.H0;
            eVar.f7472k = aVar.I0;
            eVar.f7473l = aVar.J0;
            eVar.f7475n = aVar.f7338z0;
            eVar.f7474m = aVar.f7337y0;
        }

        public final void i(ConstraintHelper constraintHelper, int i11, Constraints.a aVar) {
            h(i11, aVar);
            if (constraintHelper instanceof Barrier) {
                C0070b c0070b = this.f7381e;
                c0070b.f7417j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                c0070b.f7413h0 = barrier.getType();
                this.f7381e.f7419k0 = barrier.getReferencedIds();
                this.f7381e.f7415i0 = barrier.getMargin();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0070b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f7397r0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7406e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f7419k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f7421l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f7423m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7398a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7400b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7402c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7408f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7410g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7412h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f7414i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7416j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7418k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7420l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7422m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7424n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7426o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7428p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7430q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7432r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f7433s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f7434t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f7435u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f7436v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f7437w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f7438x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f7439y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f7440z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f7399a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f7401b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f7403c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f7405d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f7407e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f7409f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f7411g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f7413h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f7415i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f7417j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f7425n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f7427o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f7429p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f7431q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7397r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f7397r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f7397r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f7397r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f7397r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f7397r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f7397r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f7397r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f7397r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f7397r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f7397r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f7397r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f7397r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f7397r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            f7397r0.append(R$styleable.Layout_guidelineUseRtl, 90);
            f7397r0.append(R$styleable.Layout_android_orientation, 26);
            f7397r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f7397r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f7397r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f7397r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f7397r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f7397r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f7397r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f7397r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f7397r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f7397r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f7397r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f7397r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f7397r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f7397r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f7397r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f7397r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f7397r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f7397r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f7397r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f7397r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f7397r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f7397r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f7397r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f7397r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f7397r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f7397r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f7397r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f7397r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f7397r0.append(R$styleable.Layout_android_layout_width, 22);
            f7397r0.append(R$styleable.Layout_android_layout_height, 21);
            f7397r0.append(R$styleable.Layout_layout_constraintWidth, 41);
            f7397r0.append(R$styleable.Layout_layout_constraintHeight, 42);
            f7397r0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            f7397r0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            f7397r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f7397r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f7397r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f7397r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f7397r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f7397r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f7397r0.append(R$styleable.Layout_chainUseRtl, 71);
            f7397r0.append(R$styleable.Layout_barrierDirection, 72);
            f7397r0.append(R$styleable.Layout_barrierMargin, 73);
            f7397r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f7397r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(C0070b c0070b) {
            this.f7398a = c0070b.f7398a;
            this.f7404d = c0070b.f7404d;
            this.f7400b = c0070b.f7400b;
            this.f7406e = c0070b.f7406e;
            this.f7408f = c0070b.f7408f;
            this.f7410g = c0070b.f7410g;
            this.f7412h = c0070b.f7412h;
            this.f7414i = c0070b.f7414i;
            this.f7416j = c0070b.f7416j;
            this.f7418k = c0070b.f7418k;
            this.f7420l = c0070b.f7420l;
            this.f7422m = c0070b.f7422m;
            this.f7424n = c0070b.f7424n;
            this.f7426o = c0070b.f7426o;
            this.f7428p = c0070b.f7428p;
            this.f7430q = c0070b.f7430q;
            this.f7432r = c0070b.f7432r;
            this.f7433s = c0070b.f7433s;
            this.f7434t = c0070b.f7434t;
            this.f7435u = c0070b.f7435u;
            this.f7436v = c0070b.f7436v;
            this.f7437w = c0070b.f7437w;
            this.f7438x = c0070b.f7438x;
            this.f7439y = c0070b.f7439y;
            this.f7440z = c0070b.f7440z;
            this.A = c0070b.A;
            this.B = c0070b.B;
            this.C = c0070b.C;
            this.D = c0070b.D;
            this.E = c0070b.E;
            this.F = c0070b.F;
            this.G = c0070b.G;
            this.H = c0070b.H;
            this.I = c0070b.I;
            this.J = c0070b.J;
            this.K = c0070b.K;
            this.L = c0070b.L;
            this.M = c0070b.M;
            this.N = c0070b.N;
            this.O = c0070b.O;
            this.P = c0070b.P;
            this.Q = c0070b.Q;
            this.R = c0070b.R;
            this.S = c0070b.S;
            this.T = c0070b.T;
            this.U = c0070b.U;
            this.V = c0070b.V;
            this.W = c0070b.W;
            this.X = c0070b.X;
            this.Y = c0070b.Y;
            this.Z = c0070b.Z;
            this.f7399a0 = c0070b.f7399a0;
            this.f7401b0 = c0070b.f7401b0;
            this.f7403c0 = c0070b.f7403c0;
            this.f7405d0 = c0070b.f7405d0;
            this.f7407e0 = c0070b.f7407e0;
            this.f7409f0 = c0070b.f7409f0;
            this.f7411g0 = c0070b.f7411g0;
            this.f7413h0 = c0070b.f7413h0;
            this.f7415i0 = c0070b.f7415i0;
            this.f7417j0 = c0070b.f7417j0;
            this.f7423m0 = c0070b.f7423m0;
            int[] iArr = c0070b.f7419k0;
            if (iArr == null || c0070b.f7421l0 != null) {
                this.f7419k0 = null;
            } else {
                this.f7419k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f7421l0 = c0070b.f7421l0;
            this.f7425n0 = c0070b.f7425n0;
            this.f7427o0 = c0070b.f7427o0;
            this.f7429p0 = c0070b.f7429p0;
            this.f7431q0 = c0070b.f7431q0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.f7400b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                int i12 = f7397r0.get(index);
                switch (i12) {
                    case 1:
                        this.f7432r = b.G(typedArrayObtainStyledAttributes, index, this.f7432r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f7430q = b.G(typedArrayObtainStyledAttributes, index, this.f7430q);
                        break;
                    case 4:
                        this.f7428p = b.G(typedArrayObtainStyledAttributes, index, this.f7428p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f7438x = b.G(typedArrayObtainStyledAttributes, index, this.f7438x);
                        break;
                    case 10:
                        this.f7437w = b.G(typedArrayObtainStyledAttributes, index, this.f7437w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f7408f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7408f);
                        break;
                    case 18:
                        this.f7410g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7410g);
                        break;
                    case 19:
                        this.f7412h = typedArrayObtainStyledAttributes.getFloat(index, this.f7412h);
                        break;
                    case 20:
                        this.f7439y = typedArrayObtainStyledAttributes.getFloat(index, this.f7439y);
                        break;
                    case 21:
                        this.f7406e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f7406e);
                        break;
                    case 22:
                        this.f7404d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f7404d);
                        break;
                    case 23:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f7416j = b.G(typedArrayObtainStyledAttributes, index, this.f7416j);
                        break;
                    case 25:
                        this.f7418k = b.G(typedArrayObtainStyledAttributes, index, this.f7418k);
                        break;
                    case 26:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f7420l = b.G(typedArrayObtainStyledAttributes, index, this.f7420l);
                        break;
                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                        this.f7422m = b.G(typedArrayObtainStyledAttributes, index, this.f7422m);
                        break;
                    case 30:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case VungleException.WEB_CRASH /* 31 */:
                        this.f7435u = b.G(typedArrayObtainStyledAttributes, index, this.f7435u);
                        break;
                    case 32:
                        this.f7436v = b.G(typedArrayObtainStyledAttributes, index, this.f7436v);
                        break;
                    case 33:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f7426o = b.G(typedArrayObtainStyledAttributes, index, this.f7426o);
                        break;
                    case 35:
                        this.f7424n = b.G(typedArrayObtainStyledAttributes, index, this.f7424n);
                        break;
                    case 36:
                        this.f7440z = typedArrayObtainStyledAttributes.getFloat(index, this.f7440z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        b.H(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                        b.H(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i12) {
                            case 61:
                                this.B = b.G(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i12) {
                                    case 69:
                                        this.f7409f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f7411g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f7413h0 = typedArrayObtainStyledAttributes.getInt(index, this.f7413h0);
                                        break;
                                    case 73:
                                        this.f7415i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7415i0);
                                        break;
                                    case 74:
                                        this.f7421l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f7429p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7429p0);
                                        break;
                                    case 76:
                                        this.f7431q0 = typedArrayObtainStyledAttributes.getInt(index, this.f7431q0);
                                        break;
                                    case 77:
                                        this.f7433s = b.G(typedArrayObtainStyledAttributes, index, this.f7433s);
                                        break;
                                    case 78:
                                        this.f7434t = b.G(typedArrayObtainStyledAttributes, index, this.f7434t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f7399a0 = typedArrayObtainStyledAttributes.getInt(index, this.f7399a0);
                                        break;
                                    case 83:
                                        this.f7403c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7403c0);
                                        break;
                                    case 84:
                                        this.f7401b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7401b0);
                                        break;
                                    case 85:
                                        this.f7407e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7407e0);
                                        break;
                                    case ModuleDescriptor.MODULE_VERSION /* 86 */:
                                        this.f7405d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7405d0);
                                        break;
                                    case 87:
                                        this.f7425n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7425n0);
                                        break;
                                    case 88:
                                        this.f7427o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f7427o0);
                                        break;
                                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                        this.f7423m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f7414i = typedArrayObtainStyledAttributes.getBoolean(index, this.f7414i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7397r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7397r0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f7441o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7442a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7443b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7444c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f7445d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7446e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7447f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7448g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7449h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f7450i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7451j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7452k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f7453l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7454m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7455n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7441o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f7441o.append(R$styleable.Motion_pathMotionArc, 2);
            f7441o.append(R$styleable.Motion_transitionEasing, 3);
            f7441o.append(R$styleable.Motion_drawPath, 4);
            f7441o.append(R$styleable.Motion_animateRelativeTo, 5);
            f7441o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f7441o.append(R$styleable.Motion_motionStagger, 7);
            f7441o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f7441o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f7441o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c cVar) {
            this.f7442a = cVar.f7442a;
            this.f7443b = cVar.f7443b;
            this.f7445d = cVar.f7445d;
            this.f7446e = cVar.f7446e;
            this.f7447f = cVar.f7447f;
            this.f7450i = cVar.f7450i;
            this.f7448g = cVar.f7448g;
            this.f7449h = cVar.f7449h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.f7442a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                switch (f7441o.get(index)) {
                    case 1:
                        this.f7450i = typedArrayObtainStyledAttributes.getFloat(index, this.f7450i);
                        break;
                    case 2:
                        this.f7446e = typedArrayObtainStyledAttributes.getInt(index, this.f7446e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f7445d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f7445d = androidx.constraintlayout.core.motion.utils.c.f6441c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f7447f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f7443b = b.G(typedArrayObtainStyledAttributes, index, this.f7443b);
                        break;
                    case 6:
                        this.f7444c = typedArrayObtainStyledAttributes.getInteger(index, this.f7444c);
                        break;
                    case 7:
                        this.f7448g = typedArrayObtainStyledAttributes.getFloat(index, this.f7448g);
                        break;
                    case 8:
                        this.f7452k = typedArrayObtainStyledAttributes.getInteger(index, this.f7452k);
                        break;
                    case 9:
                        this.f7451j = typedArrayObtainStyledAttributes.getFloat(index, this.f7451j);
                        break;
                    case 10:
                        int i12 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i12 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f7455n = resourceId;
                            if (resourceId != -1) {
                                this.f7454m = -2;
                            }
                        } else if (i12 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f7453l = string;
                            if (string.indexOf("/") > 0) {
                                this.f7455n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f7454m = -2;
                            } else {
                                this.f7454m = -1;
                            }
                        } else {
                            this.f7454m = typedArrayObtainStyledAttributes.getInteger(index, this.f7455n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7456a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7457b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7458c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7459d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7460e = Float.NaN;

        public void a(d dVar) {
            this.f7456a = dVar.f7456a;
            this.f7457b = dVar.f7457b;
            this.f7459d = dVar.f7459d;
            this.f7460e = dVar.f7460e;
            this.f7458c = dVar.f7458c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.f7456a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f7459d = typedArrayObtainStyledAttributes.getFloat(index, this.f7459d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.f7457b = typedArrayObtainStyledAttributes.getInt(index, this.f7457b);
                    this.f7457b = b.f7367h[this.f7457b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.f7458c = typedArrayObtainStyledAttributes.getInt(index, this.f7458c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f7460e = typedArrayObtainStyledAttributes.getFloat(index, this.f7460e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f7461o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7462a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f7463b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7464c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f7465d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7466e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7467f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7468g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7469h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7470i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f7471j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7472k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f7473l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7474m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f7475n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f7461o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            f7461o.append(R$styleable.Transform_android_rotationX, 2);
            f7461o.append(R$styleable.Transform_android_rotationY, 3);
            f7461o.append(R$styleable.Transform_android_scaleX, 4);
            f7461o.append(R$styleable.Transform_android_scaleY, 5);
            f7461o.append(R$styleable.Transform_android_transformPivotX, 6);
            f7461o.append(R$styleable.Transform_android_transformPivotY, 7);
            f7461o.append(R$styleable.Transform_android_translationX, 8);
            f7461o.append(R$styleable.Transform_android_translationY, 9);
            f7461o.append(R$styleable.Transform_android_translationZ, 10);
            f7461o.append(R$styleable.Transform_android_elevation, 11);
            f7461o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f7462a = eVar.f7462a;
            this.f7463b = eVar.f7463b;
            this.f7464c = eVar.f7464c;
            this.f7465d = eVar.f7465d;
            this.f7466e = eVar.f7466e;
            this.f7467f = eVar.f7467f;
            this.f7468g = eVar.f7468g;
            this.f7469h = eVar.f7469h;
            this.f7470i = eVar.f7470i;
            this.f7471j = eVar.f7471j;
            this.f7472k = eVar.f7472k;
            this.f7473l = eVar.f7473l;
            this.f7474m = eVar.f7474m;
            this.f7475n = eVar.f7475n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.f7462a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                switch (f7461o.get(index)) {
                    case 1:
                        this.f7463b = typedArrayObtainStyledAttributes.getFloat(index, this.f7463b);
                        break;
                    case 2:
                        this.f7464c = typedArrayObtainStyledAttributes.getFloat(index, this.f7464c);
                        break;
                    case 3:
                        this.f7465d = typedArrayObtainStyledAttributes.getFloat(index, this.f7465d);
                        break;
                    case 4:
                        this.f7466e = typedArrayObtainStyledAttributes.getFloat(index, this.f7466e);
                        break;
                    case 5:
                        this.f7467f = typedArrayObtainStyledAttributes.getFloat(index, this.f7467f);
                        break;
                    case 6:
                        this.f7468g = typedArrayObtainStyledAttributes.getDimension(index, this.f7468g);
                        break;
                    case 7:
                        this.f7469h = typedArrayObtainStyledAttributes.getDimension(index, this.f7469h);
                        break;
                    case 8:
                        this.f7471j = typedArrayObtainStyledAttributes.getDimension(index, this.f7471j);
                        break;
                    case 9:
                        this.f7472k = typedArrayObtainStyledAttributes.getDimension(index, this.f7472k);
                        break;
                    case 10:
                        this.f7473l = typedArrayObtainStyledAttributes.getDimension(index, this.f7473l);
                        break;
                    case 11:
                        this.f7474m = true;
                        this.f7475n = typedArrayObtainStyledAttributes.getDimension(index, this.f7475n);
                        break;
                    case 12:
                        this.f7470i = b.G(typedArrayObtainStyledAttributes, index, this.f7470i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f7368i.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f7368i.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f7368i.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f7368i.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f7368i.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f7368i.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f7368i.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f7368i.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f7368i.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f7368i.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f7368i.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f7368i.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f7368i.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f7368i.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f7368i.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f7368i.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f7368i.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f7368i.append(R$styleable.Constraint_android_orientation, 27);
        f7368i.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f7368i.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f7368i.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f7368i.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f7368i.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f7368i.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f7368i.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f7368i.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f7368i.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f7368i.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f7368i.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f7368i.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f7368i.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f7368i.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f7368i.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f7368i.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f7368i.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f7368i.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f7368i.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f7368i.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f7368i.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f7368i.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f7368i.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f7368i.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f7368i.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f7368i.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f7368i.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f7368i.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f7368i.append(R$styleable.Constraint_android_layout_width, 23);
        f7368i.append(R$styleable.Constraint_android_layout_height, 21);
        f7368i.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f7368i.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f7368i.append(R$styleable.Constraint_android_visibility, 22);
        f7368i.append(R$styleable.Constraint_android_alpha, 43);
        f7368i.append(R$styleable.Constraint_android_elevation, 44);
        f7368i.append(R$styleable.Constraint_android_rotationX, 45);
        f7368i.append(R$styleable.Constraint_android_rotationY, 46);
        f7368i.append(R$styleable.Constraint_android_rotation, 60);
        f7368i.append(R$styleable.Constraint_android_scaleX, 47);
        f7368i.append(R$styleable.Constraint_android_scaleY, 48);
        f7368i.append(R$styleable.Constraint_android_transformPivotX, 49);
        f7368i.append(R$styleable.Constraint_android_transformPivotY, 50);
        f7368i.append(R$styleable.Constraint_android_translationX, 51);
        f7368i.append(R$styleable.Constraint_android_translationY, 52);
        f7368i.append(R$styleable.Constraint_android_translationZ, 53);
        f7368i.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f7368i.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f7368i.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f7368i.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f7368i.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f7368i.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f7368i.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f7368i.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f7368i.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f7368i.append(R$styleable.Constraint_animateRelativeTo, 64);
        f7368i.append(R$styleable.Constraint_transitionEasing, 65);
        f7368i.append(R$styleable.Constraint_drawPath, 66);
        f7368i.append(R$styleable.Constraint_transitionPathRotate, 67);
        f7368i.append(R$styleable.Constraint_motionStagger, 79);
        f7368i.append(R$styleable.Constraint_android_id, 38);
        f7368i.append(R$styleable.Constraint_motionProgress, 68);
        f7368i.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f7368i.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f7368i.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f7368i.append(R$styleable.Constraint_chainUseRtl, 71);
        f7368i.append(R$styleable.Constraint_barrierDirection, 72);
        f7368i.append(R$styleable.Constraint_barrierMargin, 73);
        f7368i.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f7368i.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f7368i.append(R$styleable.Constraint_pathMotionArc, 76);
        f7368i.append(R$styleable.Constraint_layout_constraintTag, 77);
        f7368i.append(R$styleable.Constraint_visibilityMode, 78);
        f7368i.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f7368i.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f7368i.append(R$styleable.Constraint_polarRelativeTo, 82);
        f7368i.append(R$styleable.Constraint_transformPivotTarget, 83);
        f7368i.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f7368i.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f7368i.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        f7369j.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        f7369j.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        f7369j.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f7369j.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f7369j.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f7369j.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f7369j.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f7369j.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f7369j.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f7369j.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f7369j.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f7369j.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f7369j.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f7369j.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f7369j.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f7369j.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f7369j.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f7369j.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f7369j.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f7369j.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f7369j.append(R$styleable.ConstraintOverride_drawPath, 66);
        f7369j.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f7369j.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f7369j.append(R$styleable.ConstraintOverride_android_id, 38);
        f7369j.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f7369j.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f7369j.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f7369j.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f7369j.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f7369j.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f7369j.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f7369j.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f7369j.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f7369j.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f7369j.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f7369j.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f7369j.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f7369j.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f7369j.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f7369j.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f7369j.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f7369j.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int G(TypedArray typedArray, int i11, int i12) {
        int resourceId = typedArray.getResourceId(i11, i12);
        return resourceId == -1 ? typedArray.getInt(i11, -1) : resourceId;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0031  */
    /* JADX WARN: Code duplicated, block: B:23:0x0035  */
    /* JADX WARN: Code duplicated, block: B:24:0x003a  */
    /* JADX WARN: Code duplicated, block: B:25:0x003f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:29:0x0047  */
    /* JADX WARN: Code duplicated, block: B:30:0x004c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0051  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:35:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    public static void H(Object obj, TypedArray typedArray, int i11, int i12) {
        int dimensionPixelSize;
        boolean z11;
        a.C0069a c0069a;
        C0070b c0070b;
        ConstraintLayout.b bVar;
        if (obj == null) {
            return;
        }
        int i13 = typedArray.peekValue(i11).type;
        if (i13 == 3) {
            I(obj, typedArray.getString(i11), i12);
            return;
        }
        int i14 = 0;
        if (i13 != 5) {
            dimensionPixelSize = typedArray.getInt(i11, 0);
            if (dimensionPixelSize != -4) {
                if (dimensionPixelSize != -3 && (dimensionPixelSize == -2 || dimensionPixelSize == -1)) {
                }
                z11 = false;
            } else {
                z11 = true;
                i14 = -2;
            }
            if (obj instanceof ConstraintLayout.b) {
                bVar = (ConstraintLayout.b) obj;
                if (i12 == 0) {
                    ((ViewGroup.MarginLayoutParams) bVar).width = i14;
                    bVar.f7278a0 = z11;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar).height = i14;
                    bVar.f7280b0 = z11;
                    return;
                }
            }
            if (obj instanceof C0070b) {
                c0070b = (C0070b) obj;
                if (i12 == 0) {
                    c0070b.f7404d = i14;
                    c0070b.f7425n0 = z11;
                    return;
                } else {
                    c0070b.f7406e = i14;
                    c0070b.f7427o0 = z11;
                    return;
                }
            }
            if (obj instanceof a.C0069a) {
                c0069a = (a.C0069a) obj;
                if (i12 == 0) {
                    c0069a.b(23, i14);
                    c0069a.d(80, z11);
                } else {
                    c0069a.b(21, i14);
                    c0069a.d(81, z11);
                }
            }
        }
        dimensionPixelSize = typedArray.getDimensionPixelSize(i11, 0);
        i14 = dimensionPixelSize;
        z11 = false;
        if (obj instanceof ConstraintLayout.b) {
            bVar = (ConstraintLayout.b) obj;
            if (i12 == 0) {
                ((ViewGroup.MarginLayoutParams) bVar).width = i14;
                bVar.f7278a0 = z11;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = i14;
                bVar.f7280b0 = z11;
                return;
            }
        }
        if (obj instanceof C0070b) {
            c0070b = (C0070b) obj;
            if (i12 == 0) {
                c0070b.f7404d = i14;
                c0070b.f7425n0 = z11;
                return;
            } else {
                c0070b.f7406e = i14;
                c0070b.f7427o0 = z11;
                return;
            }
        }
        if (obj instanceof a.C0069a) {
            c0069a = (a.C0069a) obj;
            if (i12 == 0) {
                c0069a.b(23, i14);
                c0069a.d(80, z11);
            } else {
                c0069a.b(21, i14);
                c0069a.d(81, z11);
            }
        }
    }

    public static void I(Object obj, String str, int i11) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i11 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    J(bVar, strTrim2);
                    return;
                }
                if (obj instanceof C0070b) {
                    ((C0070b) obj).A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0069a) {
                        ((a.C0069a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f11 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i11 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.L = f11;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.M = f11;
                        }
                    } else if (obj instanceof C0070b) {
                        C0070b c0070b = (C0070b) obj;
                        if (i11 == 0) {
                            c0070b.f7404d = 0;
                            c0070b.W = f11;
                        } else {
                            c0070b.f7406e = 0;
                            c0070b.V = f11;
                        }
                    } else if (obj instanceof a.C0069a) {
                        a.C0069a c0069a = (a.C0069a) obj;
                        if (i11 == 0) {
                            c0069a.b(23, 0);
                            c0069a.a(39, f11);
                        } else {
                            c0069a.b(21, 0);
                            c0069a.a(40, f11);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar3 = (ConstraintLayout.b) obj;
                        if (i11 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar3).width = 0;
                            bVar3.V = fMax;
                            bVar3.P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar3).height = 0;
                            bVar3.W = fMax;
                            bVar3.Q = 2;
                        }
                    } else if (obj instanceof C0070b) {
                        C0070b c0070b2 = (C0070b) obj;
                        if (i11 == 0) {
                            c0070b2.f7404d = 0;
                            c0070b2.f7409f0 = fMax;
                            c0070b2.Z = 2;
                        } else {
                            c0070b2.f7406e = 0;
                            c0070b2.f7411g0 = fMax;
                            c0070b2.f7399a0 = 2;
                        }
                    } else if (obj instanceof a.C0069a) {
                        a.C0069a c0069a2 = (a.C0069a) obj;
                        if (i11 == 0) {
                            c0069a2.b(23, 0);
                            c0069a2.b(54, 2);
                        } else {
                            c0069a2.b(21, 0);
                            c0069a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void J(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i11 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i12 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i11 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i11 = 1;
                }
                i12 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i12);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i12, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f11 = Float.parseFloat(strSubstring3);
                        float f12 = Float.parseFloat(strSubstring4);
                        if (f11 > 0.0f && f12 > 0.0f) {
                            fAbs = i11 == 1 ? Math.abs(f12 / f11) : Math.abs(f11 / f12);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.I = str;
        bVar.J = fAbs;
        bVar.K = i11;
    }

    public static void L(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0069a c0069a = new a.C0069a();
        aVar.f7384h = c0069a;
        aVar.f7380d.f7442a = false;
        aVar.f7381e.f7400b = false;
        aVar.f7379c.f7456a = false;
        aVar.f7382f.f7462a = false;
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            switch (f7369j.get(index)) {
                case 2:
                    c0069a.b(2, typedArray.getDimensionPixelSize(index, aVar.f7381e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7368i.get(index));
                    break;
                case 5:
                    c0069a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0069a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f7381e.E));
                    break;
                case 7:
                    c0069a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f7381e.F));
                    break;
                case 8:
                    c0069a.b(8, typedArray.getDimensionPixelSize(index, aVar.f7381e.L));
                    break;
                case 11:
                    c0069a.b(11, typedArray.getDimensionPixelSize(index, aVar.f7381e.R));
                    break;
                case 12:
                    c0069a.b(12, typedArray.getDimensionPixelSize(index, aVar.f7381e.S));
                    break;
                case 13:
                    c0069a.b(13, typedArray.getDimensionPixelSize(index, aVar.f7381e.O));
                    break;
                case 14:
                    c0069a.b(14, typedArray.getDimensionPixelSize(index, aVar.f7381e.Q));
                    break;
                case 15:
                    c0069a.b(15, typedArray.getDimensionPixelSize(index, aVar.f7381e.T));
                    break;
                case 16:
                    c0069a.b(16, typedArray.getDimensionPixelSize(index, aVar.f7381e.P));
                    break;
                case 17:
                    c0069a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f7381e.f7408f));
                    break;
                case 18:
                    c0069a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f7381e.f7410g));
                    break;
                case 19:
                    c0069a.a(19, typedArray.getFloat(index, aVar.f7381e.f7412h));
                    break;
                case 20:
                    c0069a.a(20, typedArray.getFloat(index, aVar.f7381e.f7439y));
                    break;
                case 21:
                    c0069a.b(21, typedArray.getLayoutDimension(index, aVar.f7381e.f7406e));
                    break;
                case 22:
                    c0069a.b(22, f7367h[typedArray.getInt(index, aVar.f7379c.f7457b)]);
                    break;
                case 23:
                    c0069a.b(23, typedArray.getLayoutDimension(index, aVar.f7381e.f7404d));
                    break;
                case 24:
                    c0069a.b(24, typedArray.getDimensionPixelSize(index, aVar.f7381e.H));
                    break;
                case 27:
                    c0069a.b(27, typedArray.getInt(index, aVar.f7381e.G));
                    break;
                case 28:
                    c0069a.b(28, typedArray.getDimensionPixelSize(index, aVar.f7381e.I));
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    c0069a.b(31, typedArray.getDimensionPixelSize(index, aVar.f7381e.M));
                    break;
                case 34:
                    c0069a.b(34, typedArray.getDimensionPixelSize(index, aVar.f7381e.J));
                    break;
                case 37:
                    c0069a.a(37, typedArray.getFloat(index, aVar.f7381e.f7440z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f7377a);
                    aVar.f7377a = resourceId;
                    c0069a.b(38, resourceId);
                    break;
                case 39:
                    c0069a.a(39, typedArray.getFloat(index, aVar.f7381e.W));
                    break;
                case 40:
                    c0069a.a(40, typedArray.getFloat(index, aVar.f7381e.V));
                    break;
                case 41:
                    c0069a.b(41, typedArray.getInt(index, aVar.f7381e.X));
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    c0069a.b(42, typedArray.getInt(index, aVar.f7381e.Y));
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    c0069a.a(43, typedArray.getFloat(index, aVar.f7379c.f7459d));
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    c0069a.d(44, true);
                    c0069a.a(44, typedArray.getDimension(index, aVar.f7382f.f7475n));
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    c0069a.a(45, typedArray.getFloat(index, aVar.f7382f.f7464c));
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    c0069a.a(46, typedArray.getFloat(index, aVar.f7382f.f7465d));
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    c0069a.a(47, typedArray.getFloat(index, aVar.f7382f.f7466e));
                    break;
                case 48:
                    c0069a.a(48, typedArray.getFloat(index, aVar.f7382f.f7467f));
                    break;
                case 49:
                    c0069a.a(49, typedArray.getDimension(index, aVar.f7382f.f7468g));
                    break;
                case 50:
                    c0069a.a(50, typedArray.getDimension(index, aVar.f7382f.f7469h));
                    break;
                case 51:
                    c0069a.a(51, typedArray.getDimension(index, aVar.f7382f.f7471j));
                    break;
                case 52:
                    c0069a.a(52, typedArray.getDimension(index, aVar.f7382f.f7472k));
                    break;
                case 53:
                    c0069a.a(53, typedArray.getDimension(index, aVar.f7382f.f7473l));
                    break;
                case 54:
                    c0069a.b(54, typedArray.getInt(index, aVar.f7381e.Z));
                    break;
                case 55:
                    c0069a.b(55, typedArray.getInt(index, aVar.f7381e.f7399a0));
                    break;
                case 56:
                    c0069a.b(56, typedArray.getDimensionPixelSize(index, aVar.f7381e.f7401b0));
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    c0069a.b(57, typedArray.getDimensionPixelSize(index, aVar.f7381e.f7403c0));
                    break;
                case 58:
                    c0069a.b(58, typedArray.getDimensionPixelSize(index, aVar.f7381e.f7405d0));
                    break;
                case 59:
                    c0069a.b(59, typedArray.getDimensionPixelSize(index, aVar.f7381e.f7407e0));
                    break;
                case 60:
                    c0069a.a(60, typedArray.getFloat(index, aVar.f7382f.f7463b));
                    break;
                case 62:
                    c0069a.b(62, typedArray.getDimensionPixelSize(index, aVar.f7381e.C));
                    break;
                case 63:
                    c0069a.a(63, typedArray.getFloat(index, aVar.f7381e.D));
                    break;
                case 64:
                    c0069a.b(64, G(typedArray, index, aVar.f7380d.f7443b));
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (typedArray.peekValue(index).type == 3) {
                        c0069a.c(65, typedArray.getString(index));
                    } else {
                        c0069a.c(65, androidx.constraintlayout.core.motion.utils.c.f6441c[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0069a.b(66, typedArray.getInt(index, 0));
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    c0069a.a(67, typedArray.getFloat(index, aVar.f7380d.f7450i));
                    break;
                case 68:
                    c0069a.a(68, typedArray.getFloat(index, aVar.f7379c.f7460e));
                    break;
                case 69:
                    c0069a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0069a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0069a.b(72, typedArray.getInt(index, aVar.f7381e.f7413h0));
                    break;
                case 73:
                    c0069a.b(73, typedArray.getDimensionPixelSize(index, aVar.f7381e.f7415i0));
                    break;
                case 74:
                    c0069a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0069a.d(75, typedArray.getBoolean(index, aVar.f7381e.f7429p0));
                    break;
                case 76:
                    c0069a.b(76, typedArray.getInt(index, aVar.f7380d.f7446e));
                    break;
                case 77:
                    c0069a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0069a.b(78, typedArray.getInt(index, aVar.f7379c.f7458c));
                    break;
                case 79:
                    c0069a.a(79, typedArray.getFloat(index, aVar.f7380d.f7448g));
                    break;
                case 80:
                    c0069a.d(80, typedArray.getBoolean(index, aVar.f7381e.f7425n0));
                    break;
                case 81:
                    c0069a.d(81, typedArray.getBoolean(index, aVar.f7381e.f7427o0));
                    break;
                case 82:
                    c0069a.b(82, typedArray.getInteger(index, aVar.f7380d.f7444c));
                    break;
                case 83:
                    c0069a.b(83, G(typedArray, index, aVar.f7382f.f7470i));
                    break;
                case 84:
                    c0069a.b(84, typedArray.getInteger(index, aVar.f7380d.f7452k));
                    break;
                case 85:
                    c0069a.a(85, typedArray.getFloat(index, aVar.f7380d.f7451j));
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 86 */:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        aVar.f7380d.f7455n = typedArray.getResourceId(index, -1);
                        c0069a.b(89, aVar.f7380d.f7455n);
                        c cVar = aVar.f7380d;
                        if (cVar.f7455n != -1) {
                            cVar.f7454m = -2;
                            c0069a.b(88, -2);
                        }
                    } else if (i12 == 3) {
                        aVar.f7380d.f7453l = typedArray.getString(index);
                        c0069a.c(90, aVar.f7380d.f7453l);
                        if (aVar.f7380d.f7453l.indexOf("/") > 0) {
                            aVar.f7380d.f7455n = typedArray.getResourceId(index, -1);
                            c0069a.b(89, aVar.f7380d.f7455n);
                            aVar.f7380d.f7454m = -2;
                            c0069a.b(88, -2);
                        } else {
                            aVar.f7380d.f7454m = -1;
                            c0069a.b(88, -1);
                        }
                    } else {
                        c cVar2 = aVar.f7380d;
                        cVar2.f7454m = typedArray.getInteger(index, cVar2.f7455n);
                        c0069a.b(88, aVar.f7380d.f7454m);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7368i.get(index));
                    break;
                case 93:
                    c0069a.b(93, typedArray.getDimensionPixelSize(index, aVar.f7381e.N));
                    break;
                case 94:
                    c0069a.b(94, typedArray.getDimensionPixelSize(index, aVar.f7381e.U));
                    break;
                case 95:
                    H(c0069a, typedArray, index, 0);
                    break;
                case 96:
                    H(c0069a, typedArray, index, 1);
                    break;
                case 97:
                    c0069a.b(97, typedArray.getInt(index, aVar.f7381e.f7431q0));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f7377a);
                        aVar.f7377a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f7378b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f7378b = typedArray.getString(index);
                    } else {
                        aVar.f7377a = typedArray.getResourceId(index, aVar.f7377a);
                    }
                    break;
                case 99:
                    c0069a.d(99, typedArray.getBoolean(index, aVar.f7381e.f7414i));
                    break;
            }
        }
    }

    public static void O(a aVar, int i11, float f11) {
        if (i11 == 19) {
            aVar.f7381e.f7412h = f11;
        }
        if (i11 == 20) {
            aVar.f7381e.f7439y = f11;
            return;
        }
        if (i11 == 37) {
            aVar.f7381e.f7440z = f11;
            return;
        }
        if (i11 == 60) {
            aVar.f7382f.f7463b = f11;
            return;
        }
        if (i11 == 63) {
            aVar.f7381e.D = f11;
            return;
        }
        if (i11 == 79) {
            aVar.f7380d.f7448g = f11;
            return;
        }
        if (i11 == 85) {
            aVar.f7380d.f7451j = f11;
            return;
        }
        if (i11 != 87) {
            if (i11 == 39) {
                aVar.f7381e.W = f11;
                return;
            }
            if (i11 == 40) {
                aVar.f7381e.V = f11;
                return;
            }
            switch (i11) {
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    aVar.f7379c.f7459d = f11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    e eVar = aVar.f7382f;
                    eVar.f7475n = f11;
                    eVar.f7474m = true;
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    aVar.f7382f.f7464c = f11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    aVar.f7382f.f7465d = f11;
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    aVar.f7382f.f7466e = f11;
                    break;
                case 48:
                    aVar.f7382f.f7467f = f11;
                    break;
                case 49:
                    aVar.f7382f.f7468g = f11;
                    break;
                case 50:
                    aVar.f7382f.f7469h = f11;
                    break;
                case 51:
                    aVar.f7382f.f7471j = f11;
                    break;
                case 52:
                    aVar.f7382f.f7472k = f11;
                    break;
                case 53:
                    aVar.f7382f.f7473l = f11;
                    break;
                default:
                    switch (i11) {
                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                            aVar.f7380d.f7450i = f11;
                            break;
                        case 68:
                            aVar.f7379c.f7460e = f11;
                            break;
                        case 69:
                            aVar.f7381e.f7409f0 = f11;
                            break;
                        case 70:
                            aVar.f7381e.f7411g0 = f11;
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            break;
                    }
                    break;
            }
        }
    }

    public static void P(a aVar, int i11, int i12) {
        if (i11 == 6) {
            aVar.f7381e.E = i12;
        }
        if (i11 == 7) {
            aVar.f7381e.F = i12;
            return;
        }
        if (i11 == 8) {
            aVar.f7381e.L = i12;
            return;
        }
        if (i11 == 27) {
            aVar.f7381e.G = i12;
            return;
        }
        if (i11 == 28) {
            aVar.f7381e.I = i12;
            return;
        }
        if (i11 == 41) {
            aVar.f7381e.X = i12;
            return;
        }
        if (i11 == 42) {
            aVar.f7381e.Y = i12;
            return;
        }
        if (i11 == 61) {
            aVar.f7381e.B = i12;
            return;
        }
        if (i11 == 62) {
            aVar.f7381e.C = i12;
            return;
        }
        if (i11 == 72) {
            aVar.f7381e.f7413h0 = i12;
            return;
        }
        if (i11 == 73) {
            aVar.f7381e.f7415i0 = i12;
            return;
        }
        switch (i11) {
            case 2:
                aVar.f7381e.K = i12;
                break;
            case 11:
                aVar.f7381e.R = i12;
                break;
            case 12:
                aVar.f7381e.S = i12;
                break;
            case 13:
                aVar.f7381e.O = i12;
                break;
            case 14:
                aVar.f7381e.Q = i12;
                break;
            case 15:
                aVar.f7381e.T = i12;
                break;
            case 16:
                aVar.f7381e.P = i12;
                break;
            case 17:
                aVar.f7381e.f7408f = i12;
                break;
            case 18:
                aVar.f7381e.f7410g = i12;
                break;
            case VungleException.WEB_CRASH /* 31 */:
                aVar.f7381e.M = i12;
                break;
            case 34:
                aVar.f7381e.J = i12;
                break;
            case 38:
                aVar.f7377a = i12;
                break;
            case 64:
                aVar.f7380d.f7443b = i12;
                break;
            case 66:
                aVar.f7380d.f7447f = i12;
                break;
            case 76:
                aVar.f7380d.f7446e = i12;
                break;
            case 78:
                aVar.f7379c.f7458c = i12;
                break;
            case 93:
                aVar.f7381e.N = i12;
                break;
            case 94:
                aVar.f7381e.U = i12;
                break;
            case 97:
                aVar.f7381e.f7431q0 = i12;
                break;
            default:
                switch (i11) {
                    case 21:
                        aVar.f7381e.f7406e = i12;
                        break;
                    case 22:
                        aVar.f7379c.f7457b = i12;
                        break;
                    case 23:
                        aVar.f7381e.f7404d = i12;
                        break;
                    case 24:
                        aVar.f7381e.H = i12;
                        break;
                    default:
                        switch (i11) {
                            case 54:
                                aVar.f7381e.Z = i12;
                                break;
                            case 55:
                                aVar.f7381e.f7399a0 = i12;
                                break;
                            case 56:
                                aVar.f7381e.f7401b0 = i12;
                                break;
                            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                aVar.f7381e.f7403c0 = i12;
                                break;
                            case 58:
                                aVar.f7381e.f7405d0 = i12;
                                break;
                            case 59:
                                aVar.f7381e.f7407e0 = i12;
                                break;
                            default:
                                switch (i11) {
                                    case 82:
                                        aVar.f7380d.f7444c = i12;
                                        break;
                                    case 83:
                                        aVar.f7382f.f7470i = i12;
                                        break;
                                    case 84:
                                        aVar.f7380d.f7452k = i12;
                                        break;
                                    default:
                                        switch (i11) {
                                            case 87:
                                                break;
                                            case 88:
                                                aVar.f7380d.f7454m = i12;
                                                break;
                                            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                                                aVar.f7380d.f7455n = i12;
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public static void Q(a aVar, int i11, String str) {
        if (i11 == 5) {
            aVar.f7381e.A = str;
            return;
        }
        if (i11 == 65) {
            aVar.f7380d.f7445d = str;
            return;
        }
        if (i11 == 74) {
            C0070b c0070b = aVar.f7381e;
            c0070b.f7421l0 = str;
            c0070b.f7419k0 = null;
        } else if (i11 == 77) {
            aVar.f7381e.f7423m0 = str;
        } else if (i11 != 87) {
            if (i11 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f7380d.f7453l = str;
            }
        }
    }

    public static void R(a aVar, int i11, boolean z11) {
        if (i11 == 44) {
            aVar.f7382f.f7474m = z11;
            return;
        }
        if (i11 == 75) {
            aVar.f7381e.f7429p0 = z11;
            return;
        }
        if (i11 != 87) {
            if (i11 == 80) {
                aVar.f7381e.f7425n0 = z11;
            } else if (i11 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f7381e.f7427o0 = z11;
            }
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R$styleable.ConstraintOverride);
        L(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public a A(int i11) {
        return w(i11);
    }

    public int B(int i11) {
        return w(i11).f7379c.f7457b;
    }

    public int C(int i11) {
        return w(i11).f7379c.f7458c;
    }

    public int D(int i11) {
        return w(i11).f7381e.f7404d;
    }

    public void E(Context context, int i11) {
        XmlResourceParser xml = context.getResources().getXml(i11);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarV = v(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarV.f7381e.f7398a = true;
                    }
                    this.f7376g.put(Integer.valueOf(aVarV.f7377a), aVarV);
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void F(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            a aVarV = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    switch (xmlPullParser.getName()) {
                        case "Constraint":
                            aVarV = v(context, Xml.asAttributeSet(xmlPullParser), false);
                            break;
                        case "ConstraintOverride":
                            aVarV = v(context, Xml.asAttributeSet(xmlPullParser), true);
                            break;
                        case "Guideline":
                            aVarV = v(context, Xml.asAttributeSet(xmlPullParser), false);
                            C0070b c0070b = aVarV.f7381e;
                            c0070b.f7398a = true;
                            c0070b.f7400b = true;
                            break;
                        case "Barrier":
                            aVarV = v(context, Xml.asAttributeSet(xmlPullParser), false);
                            aVarV.f7381e.f7417j0 = 1;
                            break;
                        case "PropertySet":
                            if (aVarV == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarV.f7379c.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Transform":
                            if (aVarV == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarV.f7382f.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Layout":
                            if (aVarV == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarV.f7381e.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Motion":
                            if (aVarV == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarV.f7380d.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "CustomAttribute":
                        case "CustomMethod":
                            if (aVarV == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            ConstraintAttribute.i(context, xmlPullParser, aVarV.f7383g);
                            break;
                            break;
                    }
                } else if (eventType == 3) {
                    String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            if (lowerCase.equals("guideline")) {
                            }
                            break;
                        case -190376483:
                            if (lowerCase.equals("constraint")) {
                            }
                            break;
                        case 426575017:
                            if (lowerCase.equals("constraintoverride")) {
                            }
                            break;
                        case 2146106725:
                            if (lowerCase.equals("constraintset")) {
                            }
                            break;
                    }
                    if (r4 == 0) {
                        return;
                    }
                    if (r4 == 1 || r4 == 2 || r4 == 3) {
                        this.f7376g.put(Integer.valueOf(aVarV.f7377a), aVarV);
                        aVarV = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } catch (XmlPullParserException e12) {
            e12.printStackTrace();
        }
    }

    public final void K(Context context, a aVar, TypedArray typedArray, boolean z11) {
        if (z11) {
            L(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                aVar.f7380d.f7442a = true;
                aVar.f7381e.f7400b = true;
                aVar.f7379c.f7456a = true;
                aVar.f7382f.f7462a = true;
            }
            switch (f7368i.get(index)) {
                case 1:
                    C0070b c0070b = aVar.f7381e;
                    c0070b.f7432r = G(typedArray, index, c0070b.f7432r);
                    break;
                case 2:
                    C0070b c0070b2 = aVar.f7381e;
                    c0070b2.K = typedArray.getDimensionPixelSize(index, c0070b2.K);
                    break;
                case 3:
                    C0070b c0070b3 = aVar.f7381e;
                    c0070b3.f7430q = G(typedArray, index, c0070b3.f7430q);
                    break;
                case 4:
                    C0070b c0070b4 = aVar.f7381e;
                    c0070b4.f7428p = G(typedArray, index, c0070b4.f7428p);
                    break;
                case 5:
                    aVar.f7381e.A = typedArray.getString(index);
                    break;
                case 6:
                    C0070b c0070b5 = aVar.f7381e;
                    c0070b5.E = typedArray.getDimensionPixelOffset(index, c0070b5.E);
                    break;
                case 7:
                    C0070b c0070b6 = aVar.f7381e;
                    c0070b6.F = typedArray.getDimensionPixelOffset(index, c0070b6.F);
                    break;
                case 8:
                    C0070b c0070b7 = aVar.f7381e;
                    c0070b7.L = typedArray.getDimensionPixelSize(index, c0070b7.L);
                    break;
                case 9:
                    C0070b c0070b8 = aVar.f7381e;
                    c0070b8.f7438x = G(typedArray, index, c0070b8.f7438x);
                    break;
                case 10:
                    C0070b c0070b9 = aVar.f7381e;
                    c0070b9.f7437w = G(typedArray, index, c0070b9.f7437w);
                    break;
                case 11:
                    C0070b c0070b10 = aVar.f7381e;
                    c0070b10.R = typedArray.getDimensionPixelSize(index, c0070b10.R);
                    break;
                case 12:
                    C0070b c0070b11 = aVar.f7381e;
                    c0070b11.S = typedArray.getDimensionPixelSize(index, c0070b11.S);
                    break;
                case 13:
                    C0070b c0070b12 = aVar.f7381e;
                    c0070b12.O = typedArray.getDimensionPixelSize(index, c0070b12.O);
                    break;
                case 14:
                    C0070b c0070b13 = aVar.f7381e;
                    c0070b13.Q = typedArray.getDimensionPixelSize(index, c0070b13.Q);
                    break;
                case 15:
                    C0070b c0070b14 = aVar.f7381e;
                    c0070b14.T = typedArray.getDimensionPixelSize(index, c0070b14.T);
                    break;
                case 16:
                    C0070b c0070b15 = aVar.f7381e;
                    c0070b15.P = typedArray.getDimensionPixelSize(index, c0070b15.P);
                    break;
                case 17:
                    C0070b c0070b16 = aVar.f7381e;
                    c0070b16.f7408f = typedArray.getDimensionPixelOffset(index, c0070b16.f7408f);
                    break;
                case 18:
                    C0070b c0070b17 = aVar.f7381e;
                    c0070b17.f7410g = typedArray.getDimensionPixelOffset(index, c0070b17.f7410g);
                    break;
                case 19:
                    C0070b c0070b18 = aVar.f7381e;
                    c0070b18.f7412h = typedArray.getFloat(index, c0070b18.f7412h);
                    break;
                case 20:
                    C0070b c0070b19 = aVar.f7381e;
                    c0070b19.f7439y = typedArray.getFloat(index, c0070b19.f7439y);
                    break;
                case 21:
                    C0070b c0070b20 = aVar.f7381e;
                    c0070b20.f7406e = typedArray.getLayoutDimension(index, c0070b20.f7406e);
                    break;
                case 22:
                    d dVar = aVar.f7379c;
                    dVar.f7457b = typedArray.getInt(index, dVar.f7457b);
                    d dVar2 = aVar.f7379c;
                    dVar2.f7457b = f7367h[dVar2.f7457b];
                    break;
                case 23:
                    C0070b c0070b21 = aVar.f7381e;
                    c0070b21.f7404d = typedArray.getLayoutDimension(index, c0070b21.f7404d);
                    break;
                case 24:
                    C0070b c0070b22 = aVar.f7381e;
                    c0070b22.H = typedArray.getDimensionPixelSize(index, c0070b22.H);
                    break;
                case 25:
                    C0070b c0070b23 = aVar.f7381e;
                    c0070b23.f7416j = G(typedArray, index, c0070b23.f7416j);
                    break;
                case 26:
                    C0070b c0070b24 = aVar.f7381e;
                    c0070b24.f7418k = G(typedArray, index, c0070b24.f7418k);
                    break;
                case 27:
                    C0070b c0070b25 = aVar.f7381e;
                    c0070b25.G = typedArray.getInt(index, c0070b25.G);
                    break;
                case 28:
                    C0070b c0070b26 = aVar.f7381e;
                    c0070b26.I = typedArray.getDimensionPixelSize(index, c0070b26.I);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    C0070b c0070b27 = aVar.f7381e;
                    c0070b27.f7420l = G(typedArray, index, c0070b27.f7420l);
                    break;
                case 30:
                    C0070b c0070b28 = aVar.f7381e;
                    c0070b28.f7422m = G(typedArray, index, c0070b28.f7422m);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    C0070b c0070b29 = aVar.f7381e;
                    c0070b29.M = typedArray.getDimensionPixelSize(index, c0070b29.M);
                    break;
                case 32:
                    C0070b c0070b30 = aVar.f7381e;
                    c0070b30.f7435u = G(typedArray, index, c0070b30.f7435u);
                    break;
                case 33:
                    C0070b c0070b31 = aVar.f7381e;
                    c0070b31.f7436v = G(typedArray, index, c0070b31.f7436v);
                    break;
                case 34:
                    C0070b c0070b32 = aVar.f7381e;
                    c0070b32.J = typedArray.getDimensionPixelSize(index, c0070b32.J);
                    break;
                case 35:
                    C0070b c0070b33 = aVar.f7381e;
                    c0070b33.f7426o = G(typedArray, index, c0070b33.f7426o);
                    break;
                case 36:
                    C0070b c0070b34 = aVar.f7381e;
                    c0070b34.f7424n = G(typedArray, index, c0070b34.f7424n);
                    break;
                case 37:
                    C0070b c0070b35 = aVar.f7381e;
                    c0070b35.f7440z = typedArray.getFloat(index, c0070b35.f7440z);
                    break;
                case 38:
                    aVar.f7377a = typedArray.getResourceId(index, aVar.f7377a);
                    break;
                case 39:
                    C0070b c0070b36 = aVar.f7381e;
                    c0070b36.W = typedArray.getFloat(index, c0070b36.W);
                    break;
                case 40:
                    C0070b c0070b37 = aVar.f7381e;
                    c0070b37.V = typedArray.getFloat(index, c0070b37.V);
                    break;
                case 41:
                    C0070b c0070b38 = aVar.f7381e;
                    c0070b38.X = typedArray.getInt(index, c0070b38.X);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    C0070b c0070b39 = aVar.f7381e;
                    c0070b39.Y = typedArray.getInt(index, c0070b39.Y);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    d dVar3 = aVar.f7379c;
                    dVar3.f7459d = typedArray.getFloat(index, dVar3.f7459d);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    e eVar = aVar.f7382f;
                    eVar.f7474m = true;
                    eVar.f7475n = typedArray.getDimension(index, eVar.f7475n);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    e eVar2 = aVar.f7382f;
                    eVar2.f7464c = typedArray.getFloat(index, eVar2.f7464c);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    e eVar3 = aVar.f7382f;
                    eVar3.f7465d = typedArray.getFloat(index, eVar3.f7465d);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    e eVar4 = aVar.f7382f;
                    eVar4.f7466e = typedArray.getFloat(index, eVar4.f7466e);
                    break;
                case 48:
                    e eVar5 = aVar.f7382f;
                    eVar5.f7467f = typedArray.getFloat(index, eVar5.f7467f);
                    break;
                case 49:
                    e eVar6 = aVar.f7382f;
                    eVar6.f7468g = typedArray.getDimension(index, eVar6.f7468g);
                    break;
                case 50:
                    e eVar7 = aVar.f7382f;
                    eVar7.f7469h = typedArray.getDimension(index, eVar7.f7469h);
                    break;
                case 51:
                    e eVar8 = aVar.f7382f;
                    eVar8.f7471j = typedArray.getDimension(index, eVar8.f7471j);
                    break;
                case 52:
                    e eVar9 = aVar.f7382f;
                    eVar9.f7472k = typedArray.getDimension(index, eVar9.f7472k);
                    break;
                case 53:
                    e eVar10 = aVar.f7382f;
                    eVar10.f7473l = typedArray.getDimension(index, eVar10.f7473l);
                    break;
                case 54:
                    C0070b c0070b40 = aVar.f7381e;
                    c0070b40.Z = typedArray.getInt(index, c0070b40.Z);
                    break;
                case 55:
                    C0070b c0070b41 = aVar.f7381e;
                    c0070b41.f7399a0 = typedArray.getInt(index, c0070b41.f7399a0);
                    break;
                case 56:
                    C0070b c0070b42 = aVar.f7381e;
                    c0070b42.f7401b0 = typedArray.getDimensionPixelSize(index, c0070b42.f7401b0);
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    C0070b c0070b43 = aVar.f7381e;
                    c0070b43.f7403c0 = typedArray.getDimensionPixelSize(index, c0070b43.f7403c0);
                    break;
                case 58:
                    C0070b c0070b44 = aVar.f7381e;
                    c0070b44.f7405d0 = typedArray.getDimensionPixelSize(index, c0070b44.f7405d0);
                    break;
                case 59:
                    C0070b c0070b45 = aVar.f7381e;
                    c0070b45.f7407e0 = typedArray.getDimensionPixelSize(index, c0070b45.f7407e0);
                    break;
                case 60:
                    e eVar11 = aVar.f7382f;
                    eVar11.f7463b = typedArray.getFloat(index, eVar11.f7463b);
                    break;
                case 61:
                    C0070b c0070b46 = aVar.f7381e;
                    c0070b46.B = G(typedArray, index, c0070b46.B);
                    break;
                case 62:
                    C0070b c0070b47 = aVar.f7381e;
                    c0070b47.C = typedArray.getDimensionPixelSize(index, c0070b47.C);
                    break;
                case 63:
                    C0070b c0070b48 = aVar.f7381e;
                    c0070b48.D = typedArray.getFloat(index, c0070b48.D);
                    break;
                case 64:
                    c cVar = aVar.f7380d;
                    cVar.f7443b = G(typedArray, index, cVar.f7443b);
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f7380d.f7445d = typedArray.getString(index);
                    } else {
                        aVar.f7380d.f7445d = androidx.constraintlayout.core.motion.utils.c.f6441c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.f7380d.f7447f = typedArray.getInt(index, 0);
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    c cVar2 = aVar.f7380d;
                    cVar2.f7450i = typedArray.getFloat(index, cVar2.f7450i);
                    break;
                case 68:
                    d dVar4 = aVar.f7379c;
                    dVar4.f7460e = typedArray.getFloat(index, dVar4.f7460e);
                    break;
                case 69:
                    aVar.f7381e.f7409f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f7381e.f7411g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    C0070b c0070b49 = aVar.f7381e;
                    c0070b49.f7413h0 = typedArray.getInt(index, c0070b49.f7413h0);
                    break;
                case 73:
                    C0070b c0070b50 = aVar.f7381e;
                    c0070b50.f7415i0 = typedArray.getDimensionPixelSize(index, c0070b50.f7415i0);
                    break;
                case 74:
                    aVar.f7381e.f7421l0 = typedArray.getString(index);
                    break;
                case 75:
                    C0070b c0070b51 = aVar.f7381e;
                    c0070b51.f7429p0 = typedArray.getBoolean(index, c0070b51.f7429p0);
                    break;
                case 76:
                    c cVar3 = aVar.f7380d;
                    cVar3.f7446e = typedArray.getInt(index, cVar3.f7446e);
                    break;
                case 77:
                    aVar.f7381e.f7423m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f7379c;
                    dVar5.f7458c = typedArray.getInt(index, dVar5.f7458c);
                    break;
                case 79:
                    c cVar4 = aVar.f7380d;
                    cVar4.f7448g = typedArray.getFloat(index, cVar4.f7448g);
                    break;
                case 80:
                    C0070b c0070b52 = aVar.f7381e;
                    c0070b52.f7425n0 = typedArray.getBoolean(index, c0070b52.f7425n0);
                    break;
                case 81:
                    C0070b c0070b53 = aVar.f7381e;
                    c0070b53.f7427o0 = typedArray.getBoolean(index, c0070b53.f7427o0);
                    break;
                case 82:
                    c cVar5 = aVar.f7380d;
                    cVar5.f7444c = typedArray.getInteger(index, cVar5.f7444c);
                    break;
                case 83:
                    e eVar12 = aVar.f7382f;
                    eVar12.f7470i = G(typedArray, index, eVar12.f7470i);
                    break;
                case 84:
                    c cVar6 = aVar.f7380d;
                    cVar6.f7452k = typedArray.getInteger(index, cVar6.f7452k);
                    break;
                case 85:
                    c cVar7 = aVar.f7380d;
                    cVar7.f7451j = typedArray.getFloat(index, cVar7.f7451j);
                    break;
                case ModuleDescriptor.MODULE_VERSION /* 86 */:
                    int i12 = typedArray.peekValue(index).type;
                    if (i12 == 1) {
                        aVar.f7380d.f7455n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f7380d;
                        if (cVar8.f7455n != -1) {
                            cVar8.f7454m = -2;
                        }
                    } else if (i12 == 3) {
                        aVar.f7380d.f7453l = typedArray.getString(index);
                        if (aVar.f7380d.f7453l.indexOf("/") > 0) {
                            aVar.f7380d.f7455n = typedArray.getResourceId(index, -1);
                            aVar.f7380d.f7454m = -2;
                        } else {
                            aVar.f7380d.f7454m = -1;
                        }
                    } else {
                        c cVar9 = aVar.f7380d;
                        cVar9.f7454m = typedArray.getInteger(index, cVar9.f7455n);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f7368i.get(index));
                    break;
                case 88:
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f7368i.get(index));
                    break;
                case 91:
                    C0070b c0070b54 = aVar.f7381e;
                    c0070b54.f7433s = G(typedArray, index, c0070b54.f7433s);
                    break;
                case 92:
                    C0070b c0070b55 = aVar.f7381e;
                    c0070b55.f7434t = G(typedArray, index, c0070b55.f7434t);
                    break;
                case 93:
                    C0070b c0070b56 = aVar.f7381e;
                    c0070b56.N = typedArray.getDimensionPixelSize(index, c0070b56.N);
                    break;
                case 94:
                    C0070b c0070b57 = aVar.f7381e;
                    c0070b57.U = typedArray.getDimensionPixelSize(index, c0070b57.U);
                    break;
                case 95:
                    H(aVar.f7381e, typedArray, index, 0);
                    break;
                case 96:
                    H(aVar.f7381e, typedArray, index, 1);
                    break;
                case 97:
                    C0070b c0070b58 = aVar.f7381e;
                    c0070b58.f7431q0 = typedArray.getInt(index, c0070b58.f7431q0);
                    break;
            }
        }
        C0070b c0070b59 = aVar.f7381e;
        if (c0070b59.f7421l0 != null) {
            c0070b59.f7419k0 = null;
        }
    }

    public void M(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7375f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7376g.containsKey(Integer.valueOf(id2))) {
                this.f7376g.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f7376g.get(Integer.valueOf(id2));
            if (aVar != null) {
                if (!aVar.f7381e.f7400b) {
                    aVar.g(id2, bVar);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f7381e.f7419k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f7381e.f7429p0 = barrier.getAllowsGoneWidget();
                            aVar.f7381e.f7413h0 = barrier.getType();
                            aVar.f7381e.f7415i0 = barrier.getMargin();
                        }
                    }
                    aVar.f7381e.f7400b = true;
                }
                d dVar = aVar.f7379c;
                if (!dVar.f7456a) {
                    dVar.f7457b = childAt.getVisibility();
                    aVar.f7379c.f7459d = childAt.getAlpha();
                    aVar.f7379c.f7456a = true;
                }
                e eVar = aVar.f7382f;
                if (!eVar.f7462a) {
                    eVar.f7462a = true;
                    eVar.f7463b = childAt.getRotation();
                    aVar.f7382f.f7464c = childAt.getRotationX();
                    aVar.f7382f.f7465d = childAt.getRotationY();
                    aVar.f7382f.f7466e = childAt.getScaleX();
                    aVar.f7382f.f7467f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f7382f;
                        eVar2.f7468g = pivotX;
                        eVar2.f7469h = pivotY;
                    }
                    aVar.f7382f.f7471j = childAt.getTranslationX();
                    aVar.f7382f.f7472k = childAt.getTranslationY();
                    aVar.f7382f.f7473l = childAt.getTranslationZ();
                    e eVar3 = aVar.f7382f;
                    if (eVar3.f7474m) {
                        eVar3.f7475n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void N(b bVar) {
        for (Integer num : bVar.f7376g.keySet()) {
            int iIntValue = num.intValue();
            a aVar = bVar.f7376g.get(num);
            if (!this.f7376g.containsKey(Integer.valueOf(iIntValue))) {
                this.f7376g.put(Integer.valueOf(iIntValue), new a());
            }
            a aVar2 = this.f7376g.get(Integer.valueOf(iIntValue));
            if (aVar2 != null) {
                C0070b c0070b = aVar2.f7381e;
                if (!c0070b.f7400b) {
                    c0070b.a(aVar.f7381e);
                }
                d dVar = aVar2.f7379c;
                if (!dVar.f7456a) {
                    dVar.a(aVar.f7379c);
                }
                e eVar = aVar2.f7382f;
                if (!eVar.f7462a) {
                    eVar.a(aVar.f7382f);
                }
                c cVar = aVar2.f7380d;
                if (!cVar.f7442a) {
                    cVar.a(aVar.f7380d);
                }
                for (String str : aVar.f7383g.keySet()) {
                    if (!aVar2.f7383g.containsKey(str)) {
                        aVar2.f7383g.put(str, aVar.f7383g.get(str));
                    }
                }
            }
        }
    }

    public void S(boolean z11) {
        this.f7375f = z11;
    }

    public void T(int i11, int i12) {
        w(i11).f7381e.f7410g = i12;
        w(i11).f7381e.f7408f = -1;
        w(i11).f7381e.f7412h = -1.0f;
    }

    public void U(boolean z11) {
        this.f7370a = z11;
    }

    public final String V(int i11) {
        switch (i11) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return AdError.UNDEFINED_DOMAIN;
        }
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7376g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f7375f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f7376g.containsKey(Integer.valueOf(id2)) && (aVar = this.f7376g.get(Integer.valueOf(id2))) != null) {
                    ConstraintAttribute.j(childAt, aVar.f7383g);
                }
            }
        }
    }

    public void h(b bVar) {
        for (a aVar : bVar.f7376g.values()) {
            if (aVar.f7384h != null) {
                if (aVar.f7378b != null) {
                    Iterator<Integer> it = this.f7376g.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarX = x(it.next().intValue());
                        String str = aVarX.f7381e.f7423m0;
                        if (str != null && aVar.f7378b.matches(str)) {
                            aVar.f7384h.e(aVarX);
                            aVarX.f7383g.putAll((HashMap) aVar.f7383g.clone());
                        }
                    }
                } else {
                    aVar.f7384h.e(x(aVar.f7377a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.b bVar, SparseArray<ConstraintWidget> sparseArray) {
        a aVar;
        int id2 = constraintHelper.getId();
        if (this.f7376g.containsKey(Integer.valueOf(id2)) && (aVar = this.f7376g.get(Integer.valueOf(id2))) != null && (constraintWidget instanceof v2.b)) {
            constraintHelper.loadParameters(aVar, (v2.b) constraintWidget, bVar, sparseArray);
        }
    }

    public void k(ConstraintLayout constraintLayout, boolean z11) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f7376g.keySet());
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!this.f7376g.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f7375f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.f7376g.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = this.f7376g.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f7381e.f7417j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(aVar.f7381e.f7413h0);
                                barrier.setMargin(aVar.f7381e.f7415i0);
                                barrier.setAllowsGoneWidget(aVar.f7381e.f7429p0);
                                C0070b c0070b = aVar.f7381e;
                                int[] iArr = c0070b.f7419k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = c0070b.f7421l0;
                                    if (str != null) {
                                        c0070b.f7419k0 = u(barrier, str);
                                        barrier.setReferencedIds(aVar.f7381e.f7419k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar.c();
                            aVar.e(bVar);
                            if (z11) {
                                ConstraintAttribute.j(childAt, aVar.f7383g);
                            }
                            childAt.setLayoutParams(bVar);
                            d dVar = aVar.f7379c;
                            if (dVar.f7458c == 0) {
                                childAt.setVisibility(dVar.f7457b);
                            }
                            childAt.setAlpha(aVar.f7379c.f7459d);
                            childAt.setRotation(aVar.f7382f.f7463b);
                            childAt.setRotationX(aVar.f7382f.f7464c);
                            childAt.setRotationY(aVar.f7382f.f7465d);
                            childAt.setScaleX(aVar.f7382f.f7466e);
                            childAt.setScaleY(aVar.f7382f.f7467f);
                            e eVar = aVar.f7382f;
                            if (eVar.f7470i != -1) {
                                View viewFindViewById = ((View) childAt.getParent()).findViewById(aVar.f7382f.f7470i);
                                if (viewFindViewById != null) {
                                    float top = (viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f;
                                    float left = (viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        float left2 = left - childAt.getLeft();
                                        float top2 = top - childAt.getTop();
                                        childAt.setPivotX(left2);
                                        childAt.setPivotY(top2);
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f7468g)) {
                                    childAt.setPivotX(aVar.f7382f.f7468g);
                                }
                                if (!Float.isNaN(aVar.f7382f.f7469h)) {
                                    childAt.setPivotY(aVar.f7382f.f7469h);
                                }
                            }
                            childAt.setTranslationX(aVar.f7382f.f7471j);
                            childAt.setTranslationY(aVar.f7382f.f7472k);
                            childAt.setTranslationZ(aVar.f7382f.f7473l);
                            e eVar2 = aVar.f7382f;
                            if (eVar2.f7474m) {
                                childAt.setElevation(eVar2.f7475n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f7376g.get(num);
            if (aVar2 != null) {
                if (aVar2.f7381e.f7417j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    C0070b c0070b2 = aVar2.f7381e;
                    int[] iArr2 = c0070b2.f7419k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = c0070b2.f7421l0;
                        if (str2 != null) {
                            c0070b2.f7419k0 = u(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f7381e.f7419k0);
                        }
                    }
                    barrier2.setType(aVar2.f7381e.f7413h0);
                    barrier2.setMargin(aVar2.f7381e.f7415i0);
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    aVar2.e(bVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, bVarGenerateDefaultLayoutParams);
                }
                if (aVar2.f7381e.f7398a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(bVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, bVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = constraintLayout.getChildAt(i12);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).f(constraintLayout);
            }
        }
    }

    public void l(int i11, ConstraintLayout.b bVar) {
        a aVar;
        if (!this.f7376g.containsKey(Integer.valueOf(i11)) || (aVar = this.f7376g.get(Integer.valueOf(i11))) == null) {
            return;
        }
        aVar.e(bVar);
    }

    public void n(int i11, int i12) {
        a aVar;
        if (!this.f7376g.containsKey(Integer.valueOf(i11)) || (aVar = this.f7376g.get(Integer.valueOf(i11))) == null) {
            return;
        }
        switch (i12) {
            case 1:
                C0070b c0070b = aVar.f7381e;
                c0070b.f7418k = -1;
                c0070b.f7416j = -1;
                c0070b.H = -1;
                c0070b.O = Integer.MIN_VALUE;
                return;
            case 2:
                C0070b c0070b2 = aVar.f7381e;
                c0070b2.f7422m = -1;
                c0070b2.f7420l = -1;
                c0070b2.I = -1;
                c0070b2.Q = Integer.MIN_VALUE;
                return;
            case 3:
                C0070b c0070b3 = aVar.f7381e;
                c0070b3.f7426o = -1;
                c0070b3.f7424n = -1;
                c0070b3.J = 0;
                c0070b3.P = Integer.MIN_VALUE;
                return;
            case 4:
                C0070b c0070b4 = aVar.f7381e;
                c0070b4.f7428p = -1;
                c0070b4.f7430q = -1;
                c0070b4.K = 0;
                c0070b4.R = Integer.MIN_VALUE;
                return;
            case 5:
                C0070b c0070b5 = aVar.f7381e;
                c0070b5.f7432r = -1;
                c0070b5.f7433s = -1;
                c0070b5.f7434t = -1;
                c0070b5.N = 0;
                c0070b5.U = Integer.MIN_VALUE;
                return;
            case 6:
                C0070b c0070b6 = aVar.f7381e;
                c0070b6.f7435u = -1;
                c0070b6.f7436v = -1;
                c0070b6.M = 0;
                c0070b6.T = Integer.MIN_VALUE;
                return;
            case 7:
                C0070b c0070b7 = aVar.f7381e;
                c0070b7.f7437w = -1;
                c0070b7.f7438x = -1;
                c0070b7.L = 0;
                c0070b7.S = Integer.MIN_VALUE;
                return;
            case 8:
                C0070b c0070b8 = aVar.f7381e;
                c0070b8.D = -1.0f;
                c0070b8.C = -1;
                c0070b8.B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void o(Context context, int i11) {
        p((ConstraintLayout) LayoutInflater.from(context).inflate(i11, (ViewGroup) null));
    }

    public void p(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f7376g.clear();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7375f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7376g.containsKey(Integer.valueOf(id2))) {
                this.f7376g.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f7376g.get(Integer.valueOf(id2));
            if (aVar != null) {
                aVar.f7383g = ConstraintAttribute.b(this.f7374e, childAt);
                aVar.g(id2, bVar);
                aVar.f7379c.f7457b = childAt.getVisibility();
                aVar.f7379c.f7459d = childAt.getAlpha();
                aVar.f7382f.f7463b = childAt.getRotation();
                aVar.f7382f.f7464c = childAt.getRotationX();
                aVar.f7382f.f7465d = childAt.getRotationY();
                aVar.f7382f.f7466e = childAt.getScaleX();
                aVar.f7382f.f7467f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f7382f;
                    eVar.f7468g = pivotX;
                    eVar.f7469h = pivotY;
                }
                aVar.f7382f.f7471j = childAt.getTranslationX();
                aVar.f7382f.f7472k = childAt.getTranslationY();
                aVar.f7382f.f7473l = childAt.getTranslationZ();
                e eVar2 = aVar.f7382f;
                if (eVar2.f7474m) {
                    eVar2.f7475n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f7381e.f7429p0 = barrier.getAllowsGoneWidget();
                    aVar.f7381e.f7419k0 = barrier.getReferencedIds();
                    aVar.f7381e.f7413h0 = barrier.getType();
                    aVar.f7381e.f7415i0 = barrier.getMargin();
                }
            }
        }
    }

    public void q(b bVar) {
        this.f7376g.clear();
        for (Integer num : bVar.f7376g.keySet()) {
            a aVar = bVar.f7376g.get(num);
            if (aVar != null) {
                this.f7376g.put(num, aVar.clone());
            }
        }
    }

    public void r(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f7376g.clear();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraints.getChildAt(i11);
            Constraints.a aVar = (Constraints.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f7375f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f7376g.containsKey(Integer.valueOf(id2))) {
                this.f7376g.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = this.f7376g.get(Integer.valueOf(id2));
            if (aVar2 != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar2.i((ConstraintHelper) childAt, id2, aVar);
                }
                aVar2.h(id2, aVar);
            }
        }
    }

    public void s(int i11, int i12, int i13, int i14) {
        if (!this.f7376g.containsKey(Integer.valueOf(i11))) {
            this.f7376g.put(Integer.valueOf(i11), new a());
        }
        a aVar = this.f7376g.get(Integer.valueOf(i11));
        if (aVar == null) {
            return;
        }
        switch (i12) {
            case 1:
                if (i14 == 1) {
                    C0070b c0070b = aVar.f7381e;
                    c0070b.f7416j = i13;
                    c0070b.f7418k = -1;
                    return;
                } else if (i14 == 2) {
                    C0070b c0070b2 = aVar.f7381e;
                    c0070b2.f7418k = i13;
                    c0070b2.f7416j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + V(i14) + " undefined");
                }
            case 2:
                if (i14 == 1) {
                    C0070b c0070b3 = aVar.f7381e;
                    c0070b3.f7420l = i13;
                    c0070b3.f7422m = -1;
                    return;
                } else if (i14 == 2) {
                    C0070b c0070b4 = aVar.f7381e;
                    c0070b4.f7422m = i13;
                    c0070b4.f7420l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
            case 3:
                if (i14 == 3) {
                    C0070b c0070b5 = aVar.f7381e;
                    c0070b5.f7424n = i13;
                    c0070b5.f7426o = -1;
                    c0070b5.f7432r = -1;
                    c0070b5.f7433s = -1;
                    c0070b5.f7434t = -1;
                    return;
                }
                if (i14 != 4) {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
                C0070b c0070b6 = aVar.f7381e;
                c0070b6.f7426o = i13;
                c0070b6.f7424n = -1;
                c0070b6.f7432r = -1;
                c0070b6.f7433s = -1;
                c0070b6.f7434t = -1;
                return;
            case 4:
                if (i14 == 4) {
                    C0070b c0070b7 = aVar.f7381e;
                    c0070b7.f7430q = i13;
                    c0070b7.f7428p = -1;
                    c0070b7.f7432r = -1;
                    c0070b7.f7433s = -1;
                    c0070b7.f7434t = -1;
                    return;
                }
                if (i14 != 3) {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
                C0070b c0070b8 = aVar.f7381e;
                c0070b8.f7428p = i13;
                c0070b8.f7430q = -1;
                c0070b8.f7432r = -1;
                c0070b8.f7433s = -1;
                c0070b8.f7434t = -1;
                return;
            case 5:
                if (i14 == 5) {
                    C0070b c0070b9 = aVar.f7381e;
                    c0070b9.f7432r = i13;
                    c0070b9.f7430q = -1;
                    c0070b9.f7428p = -1;
                    c0070b9.f7424n = -1;
                    c0070b9.f7426o = -1;
                    return;
                }
                if (i14 == 3) {
                    C0070b c0070b10 = aVar.f7381e;
                    c0070b10.f7433s = i13;
                    c0070b10.f7430q = -1;
                    c0070b10.f7428p = -1;
                    c0070b10.f7424n = -1;
                    c0070b10.f7426o = -1;
                    return;
                }
                if (i14 != 4) {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
                C0070b c0070b11 = aVar.f7381e;
                c0070b11.f7434t = i13;
                c0070b11.f7430q = -1;
                c0070b11.f7428p = -1;
                c0070b11.f7424n = -1;
                c0070b11.f7426o = -1;
                return;
            case 6:
                if (i14 == 6) {
                    C0070b c0070b12 = aVar.f7381e;
                    c0070b12.f7436v = i13;
                    c0070b12.f7435u = -1;
                    return;
                } else if (i14 == 7) {
                    C0070b c0070b13 = aVar.f7381e;
                    c0070b13.f7435u = i13;
                    c0070b13.f7436v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
            case 7:
                if (i14 == 7) {
                    C0070b c0070b14 = aVar.f7381e;
                    c0070b14.f7438x = i13;
                    c0070b14.f7437w = -1;
                    return;
                } else if (i14 == 6) {
                    C0070b c0070b15 = aVar.f7381e;
                    c0070b15.f7437w = i13;
                    c0070b15.f7438x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + V(i14) + " undefined");
                }
            default:
                throw new IllegalArgumentException(V(i12) + " to " + V(i14) + " unknown");
        }
    }

    public void t(int i11, int i12, int i13, float f11) {
        C0070b c0070b = w(i11).f7381e;
        c0070b.B = i12;
        c0070b.C = i13;
        c0070b.D = f11;
    }

    public final int[] u(View view, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < strArrSplit.length) {
            String strTrim = strArrSplit[i11].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i12] = iIntValue;
            i11++;
            i12++;
        }
        return i12 != strArrSplit.length ? Arrays.copyOf(iArr, i12) : iArr;
    }

    public final a v(Context context, AttributeSet attributeSet, boolean z11) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z11 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        K(context, aVar, typedArrayObtainStyledAttributes, z11);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public final a w(int i11) {
        if (!this.f7376g.containsKey(Integer.valueOf(i11))) {
            this.f7376g.put(Integer.valueOf(i11), new a());
        }
        return this.f7376g.get(Integer.valueOf(i11));
    }

    public a x(int i11) {
        if (this.f7376g.containsKey(Integer.valueOf(i11))) {
            return this.f7376g.get(Integer.valueOf(i11));
        }
        return null;
    }

    public int y(int i11) {
        return w(i11).f7381e.f7406e;
    }

    public int[] z() {
        Integer[] numArr = (Integer[]) this.f7376g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = numArr[i11].intValue();
        }
        return iArr;
    }
}

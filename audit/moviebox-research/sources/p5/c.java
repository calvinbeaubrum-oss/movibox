package p5;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.media3.extractor.text.SubtitleDecoderException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import o5.k;
import o5.p;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import z3.b0;
import z3.c0;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f73651g = new c0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0 f73652h = new b0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f73653i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f73654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f73655k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b[] f73656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f73657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public List<y3.a> f73658n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public List<y3.a> f73659o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public C0799c f73660p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f73661q;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<a> f73662c = new Comparator() { // from class: p5.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.a.c((c.a) obj, (c.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y3.a f73663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73664b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14, int i15) {
            y3.a.b bVarN = new y3.a.b().o(charSequence).p(alignment).h(f11, i11).i(i12).k(f12).l(i13).n(f13);
            if (z11) {
                bVarN.s(i14);
            }
            this.f73663a = bVarN.a();
            this.f73664b = i15;
        }

        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f73664b, aVar.f73664b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        public static final int[] A;
        public static final int[] B;
        public static final boolean[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int[] G;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f73665w = h(2, 2, 2, 0);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f73666x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f73667y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int[] f73668z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<SpannableString> f73669a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f73670b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f73671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f73672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f73673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f73674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f73675g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f73676h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f73677i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f73678j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f73679k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f73680l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f73681m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f73682n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f73683o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f73684p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f73685q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f73686r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f73687s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f73688t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f73689u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f73690v;

        static {
            int iH = h(0, 0, 0, 0);
            f73666x = iH;
            int iH2 = h(0, 0, 0, 3);
            f73667y = iH2;
            f73668z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public b() {
            l();
        }

        public static int g(int i11, int i12, int i13) {
            return h(i11, i12, i13, 0);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x001b  */
        public static int h(int i11, int i12, int i13, int i14) {
            int i15;
            z3.a.c(i11, 0, 4);
            z3.a.c(i12, 0, 4);
            z3.a.c(i13, 0, 4);
            z3.a.c(i14, 0, 4);
            if (i14 == 0 || i14 == 1) {
                i15 = 255;
            } else if (i14 == 2) {
                i15 = 127;
            } else if (i14 != 3) {
                i15 = 255;
            } else {
                i15 = 0;
            }
            return Color.argb(i15, i11 > 1 ? 255 : 0, i12 > 1 ? 255 : 0, i13 > 1 ? 255 : 0);
        }

        public void a(char c11) {
            if (c11 != '\n') {
                this.f73670b.append(c11);
                return;
            }
            this.f73669a.add(d());
            this.f73670b.clear();
            if (this.f73684p != -1) {
                this.f73684p = 0;
            }
            if (this.f73685q != -1) {
                this.f73685q = 0;
            }
            if (this.f73686r != -1) {
                this.f73686r = 0;
            }
            if (this.f73688t != -1) {
                this.f73688t = 0;
            }
            while (true) {
                if ((!this.f73679k || this.f73669a.size() < this.f73678j) && this.f73669a.size() < 15) {
                    return;
                } else {
                    this.f73669a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f73670b.length();
            if (length > 0) {
                this.f73670b.delete(length - 1, length);
            }
        }

        @Nullable
        public a c() {
            Layout.Alignment alignment;
            float f11;
            float f12;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i11 = 0; i11 < this.f73669a.size(); i11++) {
                spannableStringBuilder.append((CharSequence) this.f73669a.get(i11));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i12 = this.f73680l;
            if (i12 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i12 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f73680l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f73674f) {
                f11 = this.f73676h / 99.0f;
                f12 = this.f73675g / 99.0f;
            } else {
                f11 = this.f73676h / 209.0f;
                f12 = this.f73675g / 74.0f;
            }
            float f13 = (f11 * 0.9f) + 0.05f;
            float f14 = (f12 * 0.9f) + 0.05f;
            int i13 = this.f73677i;
            return new a(spannableStringBuilder, alignment2, f14, 0, i13 / 3 == 0 ? 0 : i13 / 3 == 1 ? 1 : 2, f13, i13 % 3 == 0 ? 0 : i13 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.f73683o != f73666x, this.f73683o, this.f73673e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f73670b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f73684p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f73684p, length, 33);
                }
                if (this.f73685q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f73685q, length, 33);
                }
                if (this.f73686r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f73687s), this.f73686r, length, 33);
                }
                if (this.f73688t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f73689u), this.f73688t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f73669a.clear();
            this.f73670b.clear();
            this.f73684p = -1;
            this.f73685q = -1;
            this.f73686r = -1;
            this.f73688t = -1;
            this.f73690v = 0;
        }

        public void f(boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f73671c = true;
            this.f73672d = z11;
            this.f73679k = z12;
            this.f73673e = i11;
            this.f73674f = z14;
            this.f73675g = i12;
            this.f73676h = i13;
            this.f73677i = i16;
            int i19 = i14 + 1;
            if (this.f73678j != i19) {
                this.f73678j = i19;
                while (true) {
                    if ((!z12 || this.f73669a.size() < this.f73678j) && this.f73669a.size() < 15) {
                        break;
                    } else {
                        this.f73669a.remove(0);
                    }
                }
            }
            if (i17 != 0 && this.f73681m != i17) {
                this.f73681m = i17;
                int i21 = i17 - 1;
                q(D[i21], f73667y, C[i21], 0, A[i21], B[i21], f73668z[i21]);
            }
            if (i18 == 0 || this.f73682n == i18) {
                return;
            }
            this.f73682n = i18;
            int i22 = i18 - 1;
            m(0, 1, 1, false, false, F[i22], E[i22]);
            n(f73665w, G[i22], f73666x);
        }

        public boolean i() {
            return this.f73671c;
        }

        public boolean j() {
            return !i() || (this.f73669a.isEmpty() && this.f73670b.length() == 0);
        }

        public boolean k() {
            return this.f73672d;
        }

        public void l() {
            e();
            this.f73671c = false;
            this.f73672d = false;
            this.f73673e = 4;
            this.f73674f = false;
            this.f73675g = 0;
            this.f73676h = 0;
            this.f73677i = 0;
            this.f73678j = 15;
            this.f73679k = true;
            this.f73680l = 0;
            this.f73681m = 0;
            this.f73682n = 0;
            int i11 = f73666x;
            this.f73683o = i11;
            this.f73687s = f73665w;
            this.f73689u = i11;
        }

        public void m(int i11, int i12, int i13, boolean z11, boolean z12, int i14, int i15) {
            if (this.f73684p != -1) {
                if (!z11) {
                    this.f73670b.setSpan(new StyleSpan(2), this.f73684p, this.f73670b.length(), 33);
                    this.f73684p = -1;
                }
            } else if (z11) {
                this.f73684p = this.f73670b.length();
            }
            if (this.f73685q == -1) {
                if (z12) {
                    this.f73685q = this.f73670b.length();
                }
            } else {
                if (z12) {
                    return;
                }
                this.f73670b.setSpan(new UnderlineSpan(), this.f73685q, this.f73670b.length(), 33);
                this.f73685q = -1;
            }
        }

        public void n(int i11, int i12, int i13) {
            if (this.f73686r != -1 && this.f73687s != i11) {
                this.f73670b.setSpan(new ForegroundColorSpan(this.f73687s), this.f73686r, this.f73670b.length(), 33);
            }
            if (i11 != f73665w) {
                this.f73686r = this.f73670b.length();
                this.f73687s = i11;
            }
            if (this.f73688t != -1 && this.f73689u != i12) {
                this.f73670b.setSpan(new BackgroundColorSpan(this.f73689u), this.f73688t, this.f73670b.length(), 33);
            }
            if (i12 != f73666x) {
                this.f73688t = this.f73670b.length();
                this.f73689u = i12;
            }
        }

        public void o(int i11, int i12) {
            if (this.f73690v != i11) {
                a('\n');
            }
            this.f73690v = i11;
        }

        public void p(boolean z11) {
            this.f73672d = z11;
        }

        public void q(int i11, int i12, boolean z11, int i13, int i14, int i15, int i16) {
            this.f73683o = i11;
            this.f73680l = i16;
        }
    }

    /* JADX INFO: renamed from: p5.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0799c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f73691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f73692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f73693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f73694d = 0;

        public C0799c(int i11, int i12) {
            this.f73691a = i11;
            this.f73692b = i12;
            this.f73693c = new byte[(i12 * 2) - 1];
        }
    }

    public c(int i11, @Nullable List<byte[]> list) {
        this.f73655k = i11 == -1 ? 1 : i11;
        this.f73654j = list != null && z3.e.f(list);
        this.f73656l = new b[8];
        for (int i12 = 0; i12 < 8; i12++) {
            this.f73656l[i12] = new b();
        }
        this.f73657m = this.f73656l[0];
    }

    private void C() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.f73656l[i11].l();
        }
    }

    private List<y3.a> n() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 8; i11++) {
            if (!this.f73656l[i11].j() && this.f73656l[i11].k() && (aVarC = this.f73656l[i11].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.f73662c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(((a) arrayList.get(i12)).f73663a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void A() {
        int iH = b.h(this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2));
        int iH2 = this.f73652h.h(2);
        int iG = b.g(this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2));
        if (this.f73652h.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f73652h.g();
        int iH3 = this.f73652h.h(2);
        int iH4 = this.f73652h.h(2);
        int iH5 = this.f73652h.h(2);
        this.f73652h.r(8);
        this.f73657m.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    public final void B() {
        C0799c c0799c = this.f73660p;
        if (c0799c.f73694d != (c0799c.f73692b * 2) - 1) {
            o.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f73660p.f73692b * 2) - 1) + ", but current index is " + this.f73660p.f73694d + " (sequence number " + this.f73660p.f73691a + ");");
        }
        b0 b0Var = this.f73652h;
        C0799c c0799c2 = this.f73660p;
        b0Var.o(c0799c2.f73693c, c0799c2.f73694d);
        boolean z11 = false;
        while (this.f73652h.b() > 0) {
            int iH = this.f73652h.h(3);
            int iH2 = this.f73652h.h(5);
            if (iH == 7) {
                this.f73652h.r(2);
                iH = this.f73652h.h(6);
                if (iH < 7) {
                    o.h("Cea708Decoder", "Invalid extended service number: " + iH);
                }
            }
            if (iH2 == 0) {
                if (iH == 0) {
                    break;
                }
                o.h("Cea708Decoder", "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                break;
            }
            if (iH != this.f73655k) {
                this.f73652h.s(iH2);
            } else {
                int iE = this.f73652h.e() + (iH2 * 8);
                while (this.f73652h.e() < iE) {
                    int iH3 = this.f73652h.h(8);
                    if (iH3 == 16) {
                        int iH4 = this.f73652h.h(8);
                        if (iH4 <= 31) {
                            q(iH4);
                        } else {
                            if (iH4 <= 127) {
                                v(iH4);
                            } else if (iH4 <= 159) {
                                r(iH4);
                            } else if (iH4 <= 255) {
                                w(iH4);
                            } else {
                                o.h("Cea708Decoder", "Invalid extended command: " + iH4);
                            }
                            z11 = true;
                        }
                    } else if (iH3 <= 31) {
                        o(iH3);
                    } else {
                        if (iH3 <= 127) {
                            t(iH3);
                        } else if (iH3 <= 159) {
                            p(iH3);
                        } else if (iH3 <= 255) {
                            u(iH3);
                        } else {
                            o.h("Cea708Decoder", "Invalid base command: " + iH3);
                        }
                        z11 = true;
                    }
                }
            }
        }
        if (z11) {
            this.f73658n = n();
        }
    }

    @Override // p5.e
    public k c() {
        List<y3.a> list = this.f73658n;
        this.f73659o = list;
        return new f((List) z3.a.e(list));
    }

    @Override // p5.e
    public void d(o5.o oVar) {
        ByteBuffer byteBuffer = (ByteBuffer) z3.a.e(oVar.f9780c);
        this.f73651g.S(byteBuffer.array(), byteBuffer.limit());
        while (this.f73651g.a() >= 3) {
            int iH = this.f73651g.H();
            int i11 = iH & 3;
            boolean z11 = (iH & 4) == 4;
            byte bH = (byte) this.f73651g.H();
            byte bH2 = (byte) this.f73651g.H();
            if (i11 == 2 || i11 == 3) {
                if (z11) {
                    if (i11 == 3) {
                        m();
                        int i12 = (bH & 192) >> 6;
                        int i13 = this.f73653i;
                        if (i13 != -1 && i12 != (i13 + 1) % 4) {
                            C();
                            o.h("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f73653i + " current=" + i12);
                        }
                        this.f73653i = i12;
                        int i14 = bH & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        C0799c c0799c = new C0799c(i12, i14);
                        this.f73660p = c0799c;
                        byte[] bArr = c0799c.f73693c;
                        int i15 = c0799c.f73694d;
                        c0799c.f73694d = i15 + 1;
                        bArr[i15] = bH2;
                    } else {
                        z3.a.a(i11 == 2);
                        C0799c c0799c2 = this.f73660p;
                        if (c0799c2 == null) {
                            o.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0799c2.f73693c;
                            int i16 = c0799c2.f73694d;
                            bArr2[i16] = bH;
                            c0799c2.f73694d = i16 + 2;
                            bArr2[i16 + 1] = bH2;
                        }
                    }
                    C0799c c0799c3 = this.f73660p;
                    if (c0799c3.f73694d == (c0799c3.f73692b * 2) - 1) {
                        m();
                    }
                }
            }
        }
    }

    @Override // p5.e
    @Nullable
    /* JADX INFO: renamed from: e */
    public /* bridge */ /* synthetic */ o5.o dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // p5.e
    @Nullable
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ p dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // p5.e, androidx.media3.decoder.g
    public void flush() {
        super.flush();
        this.f73658n = null;
        this.f73659o = null;
        this.f73661q = 0;
        this.f73657m = this.f73656l[0];
        C();
        this.f73660p = null;
    }

    @Override // androidx.media3.decoder.g
    public String getName() {
        return "Cea708Decoder";
    }

    @Override // p5.e
    public boolean i() {
        return this.f73658n != this.f73659o;
    }

    @Override // p5.e
    /* JADX INFO: renamed from: j */
    public /* bridge */ /* synthetic */ void queueInputBuffer(o5.o oVar) throws SubtitleDecoderException {
        super.queueInputBuffer(oVar);
    }

    public final void m() {
        if (this.f73660p == null) {
            return;
        }
        B();
        this.f73660p = null;
    }

    public final void o(int i11) {
        if (i11 != 0) {
            if (i11 == 3) {
                this.f73658n = n();
            }
            if (i11 == 8) {
                this.f73657m.b();
                return;
            }
            switch (i11) {
                case 12:
                    C();
                    break;
                case 13:
                    this.f73657m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i11 >= 17 && i11 <= 23) {
                        o.h("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i11);
                        this.f73652h.r(8);
                    } else if (i11 >= 24 && i11 <= 31) {
                        o.h("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i11);
                        this.f73652h.r(16);
                    } else {
                        o.h("Cea708Decoder", "Invalid C0 command: " + i11);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void p(int i11) {
        int i12 = 1;
        switch (i11) {
            case 128:
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
            case 131:
            case 132:
            case 133:
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                int i13 = i11 - 128;
                if (this.f73661q != i13) {
                    this.f73661q = i13;
                    this.f73657m = this.f73656l[i13];
                }
                break;
            case 136:
                while (i12 <= 8) {
                    if (this.f73652h.g()) {
                        this.f73656l[8 - i12].e();
                    }
                    i12++;
                }
                break;
            case 137:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f73652h.g()) {
                        this.f73656l[8 - i14].p(true);
                    }
                }
                break;
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                while (i12 <= 8) {
                    if (this.f73652h.g()) {
                        this.f73656l[8 - i12].p(false);
                    }
                    i12++;
                }
                break;
            case 139:
                for (int i15 = 1; i15 <= 8; i15++) {
                    if (this.f73652h.g()) {
                        b bVar = this.f73656l[8 - i15];
                        bVar.p(!bVar.k());
                    }
                }
                break;
            case 140:
                while (i12 <= 8) {
                    if (this.f73652h.g()) {
                        this.f73656l[8 - i12].l();
                    }
                    i12++;
                }
                break;
            case 141:
                this.f73652h.r(8);
                break;
            case 142:
                break;
            case 143:
                C();
                break;
            case 144:
                if (this.f73657m.i()) {
                    x();
                } else {
                    this.f73652h.r(16);
                }
                break;
            case 145:
                if (this.f73657m.i()) {
                    y();
                } else {
                    this.f73652h.r(24);
                }
                break;
            case 146:
                if (this.f73657m.i()) {
                    z();
                } else {
                    this.f73652h.r(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                o.h("Cea708Decoder", "Invalid C1 command: " + i11);
                break;
            case 151:
                if (this.f73657m.i()) {
                    A();
                } else {
                    this.f73652h.r(32);
                }
                break;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i16 = i11 - 152;
                s(i16);
                if (this.f73661q != i16) {
                    this.f73661q = i16;
                    this.f73657m = this.f73656l[i16];
                }
                break;
        }
    }

    public final void q(int i11) {
        if (i11 <= 7) {
            return;
        }
        if (i11 <= 15) {
            this.f73652h.r(8);
        } else if (i11 <= 23) {
            this.f73652h.r(16);
        } else if (i11 <= 31) {
            this.f73652h.r(24);
        }
    }

    public final void r(int i11) {
        if (i11 <= 135) {
            this.f73652h.r(32);
            return;
        }
        if (i11 <= 143) {
            this.f73652h.r(40);
        } else if (i11 <= 159) {
            this.f73652h.r(2);
            this.f73652h.r(this.f73652h.h(6) * 8);
        }
    }

    @Override // p5.e, androidx.media3.decoder.g
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s(int i11) {
        b bVar = this.f73656l[i11];
        this.f73652h.r(2);
        boolean zG = this.f73652h.g();
        boolean zG2 = this.f73652h.g();
        boolean zG3 = this.f73652h.g();
        int iH = this.f73652h.h(3);
        boolean zG4 = this.f73652h.g();
        int iH2 = this.f73652h.h(7);
        int iH3 = this.f73652h.h(8);
        int iH4 = this.f73652h.h(4);
        int iH5 = this.f73652h.h(4);
        this.f73652h.r(2);
        int iH6 = this.f73652h.h(6);
        this.f73652h.r(2);
        bVar.f(zG, zG2, zG3, iH, zG4, iH2, iH3, iH5, iH6, iH4, this.f73652h.h(3), this.f73652h.h(3));
    }

    @Override // p5.e, o5.l
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }

    public final void t(int i11) {
        if (i11 == 127) {
            this.f73657m.a((char) 9835);
        } else {
            this.f73657m.a((char) (i11 & 255));
        }
    }

    public final void u(int i11) {
        this.f73657m.a((char) (i11 & 255));
    }

    public final void v(int i11) {
        if (i11 == 32) {
            this.f73657m.a(' ');
        }
        if (i11 == 33) {
            this.f73657m.a((char) 160);
            return;
        }
        if (i11 == 37) {
            this.f73657m.a((char) 8230);
            return;
        }
        if (i11 == 42) {
            this.f73657m.a((char) 352);
            return;
        }
        if (i11 == 44) {
            this.f73657m.a((char) 338);
            return;
        }
        if (i11 == 63) {
            this.f73657m.a((char) 376);
            return;
        }
        if (i11 == 57) {
            this.f73657m.a((char) 8482);
            return;
        }
        if (i11 == 58) {
            this.f73657m.a((char) 353);
            return;
        }
        if (i11 == 60) {
            this.f73657m.a((char) 339);
            return;
        }
        if (i11 == 61) {
            this.f73657m.a((char) 8480);
            return;
        }
        switch (i11) {
            case 48:
                this.f73657m.a((char) 9608);
                break;
            case 49:
                this.f73657m.a((char) 8216);
                break;
            case 50:
                this.f73657m.a((char) 8217);
                break;
            case 51:
                this.f73657m.a((char) 8220);
                break;
            case 52:
                this.f73657m.a((char) 8221);
                break;
            case 53:
                this.f73657m.a((char) 8226);
                break;
            default:
                switch (i11) {
                    case 118:
                        this.f73657m.a((char) 8539);
                        break;
                    case 119:
                        this.f73657m.a((char) 8540);
                        break;
                    case 120:
                        this.f73657m.a((char) 8541);
                        break;
                    case 121:
                        this.f73657m.a((char) 8542);
                        break;
                    case 122:
                        this.f73657m.a((char) 9474);
                        break;
                    case 123:
                        this.f73657m.a((char) 9488);
                        break;
                    case 124:
                        this.f73657m.a((char) 9492);
                        break;
                    case 125:
                        this.f73657m.a((char) 9472);
                        break;
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                        this.f73657m.a((char) 9496);
                        break;
                    case 127:
                        this.f73657m.a((char) 9484);
                        break;
                    default:
                        o.h("Cea708Decoder", "Invalid G2 character: " + i11);
                        break;
                }
                break;
        }
    }

    public final void w(int i11) {
        if (i11 == 160) {
            this.f73657m.a((char) 13252);
            return;
        }
        o.h("Cea708Decoder", "Invalid G3 character: " + i11);
        this.f73657m.a('_');
    }

    public final void x() {
        this.f73657m.m(this.f73652h.h(4), this.f73652h.h(2), this.f73652h.h(2), this.f73652h.g(), this.f73652h.g(), this.f73652h.h(3), this.f73652h.h(3));
    }

    public final void y() {
        int iH = b.h(this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2));
        int iH2 = b.h(this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2));
        this.f73652h.r(2);
        this.f73657m.n(iH, iH2, b.g(this.f73652h.h(2), this.f73652h.h(2), this.f73652h.h(2)));
    }

    public final void z() {
        this.f73652h.r(4);
        int iH = this.f73652h.h(4);
        this.f73652h.r(2);
        this.f73657m.o(iH, this.f73652h.h(6));
    }
}

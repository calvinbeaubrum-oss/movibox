package com.applovin.impl;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z2 extends a3 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final bh f24746g = new bh();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ah f24747h = new ah();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24748i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f24749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f24750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final b[] f24751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f24752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f24753n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f24754o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private c f24755p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f24756q;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f24757c = new Comparator() { // from class: com.applovin.impl.ia0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return z2.a.a((z2.a) obj, (z2.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b5 f24758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24759b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14, int i15) {
            b5.b bVarD = new b5.b().a(charSequence).b(alignment).a(f11, i11).a(i12).b(f12).b(i13).d(f13);
            if (z11) {
                bVarD.d(i14);
            }
            this.f24758a = bVarD.a();
            this.f24759b = i15;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(a aVar, a aVar2) {
            return Integer.compare(aVar2.f24759b, aVar.f24759b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {
        private static final int[] A;
        private static final int[] B;
        private static final boolean[] C;
        private static final int[] D;
        private static final int[] E;
        private static final int[] F;
        private static final int[] G;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f24760w = a(2, 2, 2, 0);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f24761x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f24762y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final int[] f24763z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f24764a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SpannableStringBuilder f24765b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f24766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f24767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f24768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f24769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24770g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f24771h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24772i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24773j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f24774k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f24775l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f24776m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f24777n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f24778o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f24779p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f24780q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f24781r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f24782s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f24783t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f24784u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f24785v;

        static {
            int iA = a(0, 0, 0, 0);
            f24761x = iA;
            int iA2 = a(0, 0, 0, 3);
            f24762y = iA2;
            f24763z = new int[]{0, 0, 0, 0, 0, 2, 0};
            A = new int[]{0, 0, 0, 0, 0, 0, 2};
            B = new int[]{3, 3, 3, 3, 3, 3, 1};
            C = new boolean[]{false, false, false, true, true, true, false};
            D = new int[]{iA, iA2, iA, iA, iA2, iA, iA};
            E = new int[]{0, 1, 2, 3, 4, 3, 4};
            F = new int[]{0, 0, 0, 0, 0, 3, 3};
            G = new int[]{iA, iA, iA, iA, iA, iA2, iA2};
        }

        public b() {
            h();
        }

        public static int a(int i11, int i12, int i13) {
            return a(i11, i12, i13, 0);
        }

        public static int a(int i11, int i12, int i13, int i14) {
            int i15;
            b1.a(i11, 0, 4);
            b1.a(i12, 0, 4);
            b1.a(i13, 0, 4);
            b1.a(i14, 0, 4);
            if (i14 != 2) {
                i15 = i14 != 3 ? 255 : 0;
            } else {
                i15 = 127;
            }
            return Color.argb(i15, i11 > 1 ? 255 : 0, i12 > 1 ? 255 : 0, i13 > 1 ? 255 : 0);
        }

        public void a() {
            int length = this.f24765b.length();
            if (length > 0) {
                this.f24765b.delete(length - 1, length);
            }
        }

        public void a(char c11) {
            if (c11 != '\n') {
                this.f24765b.append(c11);
                return;
            }
            this.f24764a.add(c());
            this.f24765b.clear();
            if (this.f24779p != -1) {
                this.f24779p = 0;
            }
            if (this.f24780q != -1) {
                this.f24780q = 0;
            }
            if (this.f24781r != -1) {
                this.f24781r = 0;
            }
            if (this.f24783t != -1) {
                this.f24783t = 0;
            }
            while (true) {
                if ((!this.f24774k || this.f24764a.size() < this.f24773j) && this.f24764a.size() < 15) {
                    return;
                } else {
                    this.f24764a.remove(0);
                }
            }
        }

        public void a(int i11, int i12) {
            if (this.f24785v != i11) {
                a('\n');
            }
            this.f24785v = i11;
        }

        public void a(int i11, int i12, int i13, boolean z11, boolean z12, int i14, int i15) {
            if (this.f24779p != -1) {
                if (!z11) {
                    this.f24765b.setSpan(new StyleSpan(2), this.f24779p, this.f24765b.length(), 33);
                    this.f24779p = -1;
                }
            } else if (z11) {
                this.f24779p = this.f24765b.length();
            }
            if (this.f24780q == -1) {
                if (z12) {
                    this.f24780q = this.f24765b.length();
                }
            } else {
                if (z12) {
                    return;
                }
                this.f24765b.setSpan(new UnderlineSpan(), this.f24780q, this.f24765b.length(), 33);
                this.f24780q = -1;
            }
        }

        public void a(int i11, int i12, boolean z11, int i13, int i14, int i15, int i16) {
            this.f24778o = i11;
            this.f24775l = i16;
        }

        public void a(boolean z11) {
            this.f24767d = z11;
        }

        public void a(boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f24766c = true;
            this.f24767d = z11;
            this.f24774k = z12;
            this.f24768e = i11;
            this.f24769f = z14;
            this.f24770g = i12;
            this.f24771h = i13;
            this.f24772i = i16;
            int i19 = i14 + 1;
            if (this.f24773j != i19) {
                this.f24773j = i19;
                while (true) {
                    if ((!z12 || this.f24764a.size() < this.f24773j) && this.f24764a.size() < 15) {
                        break;
                    } else {
                        this.f24764a.remove(0);
                    }
                }
            }
            if (i17 != 0 && this.f24776m != i17) {
                this.f24776m = i17;
                int i21 = i17 - 1;
                a(D[i21], f24762y, C[i21], 0, A[i21], B[i21], f24763z[i21]);
            }
            if (i18 == 0 || this.f24777n == i18) {
                return;
            }
            this.f24777n = i18;
            int i22 = i18 - 1;
            a(0, 1, 1, false, false, F[i22], E[i22]);
            b(f24760w, G[i22], f24761x);
        }

        public a b() {
            Layout.Alignment alignment;
            float f11;
            float f12;
            if (f()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i11 = 0; i11 < this.f24764a.size(); i11++) {
                spannableStringBuilder.append((CharSequence) this.f24764a.get(i11));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) c());
            int i12 = this.f24775l;
            if (i12 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i12 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f24775l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f24769f) {
                f11 = this.f24771h / 99.0f;
                f12 = this.f24770g / 99.0f;
            } else {
                f11 = this.f24771h / 209.0f;
                f12 = this.f24770g / 74.0f;
            }
            float f13 = (f11 * 0.9f) + 0.05f;
            float f14 = (f12 * 0.9f) + 0.05f;
            int i13 = this.f24772i;
            int i14 = i13 / 3;
            int i15 = i13 % 3;
            return new a(spannableStringBuilder, alignment2, f14, 0, i14 == 0 ? 0 : i14 == 1 ? 1 : 2, f13, i15 == 0 ? 0 : i15 == 1 ? 1 : 2, -3.4028235E38f, this.f24778o != f24761x, this.f24778o, this.f24768e);
        }

        public void b(int i11, int i12, int i13) {
            if (this.f24781r != -1 && this.f24782s != i11) {
                this.f24765b.setSpan(new ForegroundColorSpan(this.f24782s), this.f24781r, this.f24765b.length(), 33);
            }
            if (i11 != f24760w) {
                this.f24781r = this.f24765b.length();
                this.f24782s = i11;
            }
            if (this.f24783t != -1 && this.f24784u != i12) {
                this.f24765b.setSpan(new BackgroundColorSpan(this.f24784u), this.f24783t, this.f24765b.length(), 33);
            }
            if (i12 != f24761x) {
                this.f24783t = this.f24765b.length();
                this.f24784u = i12;
            }
        }

        public SpannableString c() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f24765b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f24779p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f24779p, length, 33);
                }
                if (this.f24780q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f24780q, length, 33);
                }
                if (this.f24781r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f24782s), this.f24781r, length, 33);
                }
                if (this.f24783t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f24784u), this.f24783t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void d() {
            this.f24764a.clear();
            this.f24765b.clear();
            this.f24779p = -1;
            this.f24780q = -1;
            this.f24781r = -1;
            this.f24783t = -1;
            this.f24785v = 0;
        }

        public boolean e() {
            return this.f24766c;
        }

        public boolean f() {
            return !e() || (this.f24764a.isEmpty() && this.f24765b.length() == 0);
        }

        public boolean g() {
            return this.f24767d;
        }

        public void h() {
            d();
            this.f24766c = false;
            this.f24767d = false;
            this.f24768e = 4;
            this.f24769f = false;
            this.f24770g = 0;
            this.f24771h = 0;
            this.f24772i = 0;
            this.f24773j = 15;
            this.f24774k = true;
            this.f24775l = 0;
            this.f24776m = 0;
            this.f24777n = 0;
            int i11 = f24761x;
            this.f24778o = i11;
            this.f24782s = f24760w;
            this.f24784u = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f24788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f24789d = 0;

        public c(int i11, int i12) {
            this.f24786a = i11;
            this.f24787b = i12;
            this.f24788c = new byte[(i12 * 2) - 1];
        }
    }

    public z2(int i11, List list) {
        this.f24750k = i11 == -1 ? 1 : i11;
        this.f24749j = list != null && o3.a(list);
        this.f24751l = new b[8];
        for (int i12 = 0; i12 < 8; i12++) {
            this.f24751l[i12] = new b();
        }
        this.f24752m = this.f24751l[0];
    }

    private void a(int i11) {
        if (i11 != 0) {
            if (i11 == 3) {
                this.f24753n = l();
            }
            if (i11 == 8) {
                this.f24752m.a();
                return;
            }
            switch (i11) {
                case 12:
                    r();
                    break;
                case 13:
                    this.f24752m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i11 >= 17 && i11 <= 23) {
                        pc.d("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i11);
                        this.f24747h.d(8);
                    } else if (i11 >= 24 && i11 <= 31) {
                        pc.d("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i11);
                        this.f24747h.d(16);
                    } else {
                        pc.d("Cea708Decoder", "Invalid C0 command: " + i11);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(int i11) {
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
                if (this.f24756q != i13) {
                    this.f24756q = i13;
                    this.f24752m = this.f24751l[i13];
                }
                break;
            case 136:
                while (i12 <= 8) {
                    if (this.f24747h.f()) {
                        this.f24751l[8 - i12].d();
                    }
                    i12++;
                }
                break;
            case 137:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f24747h.f()) {
                        this.f24751l[8 - i14].a(true);
                    }
                }
                break;
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                while (i12 <= 8) {
                    if (this.f24747h.f()) {
                        this.f24751l[8 - i12].a(false);
                    }
                    i12++;
                }
                break;
            case 139:
                for (int i15 = 1; i15 <= 8; i15++) {
                    if (this.f24747h.f()) {
                        b bVar = this.f24751l[8 - i15];
                        bVar.a(!bVar.g());
                    }
                }
                break;
            case 140:
                while (i12 <= 8) {
                    if (this.f24747h.f()) {
                        this.f24751l[8 - i12].h();
                    }
                    i12++;
                }
                break;
            case 141:
                this.f24747h.d(8);
                break;
            case 142:
                break;
            case 143:
                r();
                break;
            case 144:
                if (this.f24752m.e()) {
                    m();
                } else {
                    this.f24747h.d(16);
                }
                break;
            case 145:
                if (this.f24752m.e()) {
                    n();
                } else {
                    this.f24747h.d(24);
                }
                break;
            case 146:
                if (this.f24752m.e()) {
                    o();
                } else {
                    this.f24747h.d(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                pc.d("Cea708Decoder", "Invalid C1 command: " + i11);
                break;
            case 151:
                if (this.f24752m.e()) {
                    p();
                } else {
                    this.f24747h.d(32);
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
                e(i16);
                if (this.f24756q != i16) {
                    this.f24756q = i16;
                    this.f24752m = this.f24751l[i16];
                }
                break;
        }
    }

    private void c(int i11) {
        if (i11 <= 7) {
            return;
        }
        if (i11 <= 15) {
            this.f24747h.d(8);
        } else if (i11 <= 23) {
            this.f24747h.d(16);
        } else if (i11 <= 31) {
            this.f24747h.d(24);
        }
    }

    private void d(int i11) {
        if (i11 <= 135) {
            this.f24747h.d(32);
            return;
        }
        if (i11 <= 143) {
            this.f24747h.d(40);
        } else if (i11 <= 159) {
            this.f24747h.d(2);
            this.f24747h.d(this.f24747h.a(6) * 8);
        }
    }

    private void e(int i11) {
        b bVar = this.f24751l[i11];
        this.f24747h.d(2);
        boolean zF = this.f24747h.f();
        boolean zF2 = this.f24747h.f();
        boolean zF3 = this.f24747h.f();
        int iA = this.f24747h.a(3);
        boolean zF4 = this.f24747h.f();
        int iA2 = this.f24747h.a(7);
        int iA3 = this.f24747h.a(8);
        int iA4 = this.f24747h.a(4);
        int iA5 = this.f24747h.a(4);
        this.f24747h.d(2);
        int iA6 = this.f24747h.a(6);
        this.f24747h.d(2);
        bVar.a(zF, zF2, zF3, iA, zF4, iA2, iA3, iA5, iA6, iA4, this.f24747h.a(3), this.f24747h.a(3));
    }

    private void f(int i11) {
        if (i11 == 127) {
            this.f24752m.a((char) 9835);
        } else {
            this.f24752m.a((char) (i11 & 255));
        }
    }

    private void g(int i11) {
        this.f24752m.a((char) (i11 & 255));
    }

    private void h(int i11) {
        if (i11 == 32) {
            this.f24752m.a(' ');
        }
        if (i11 == 33) {
            this.f24752m.a((char) 160);
            return;
        }
        if (i11 == 37) {
            this.f24752m.a((char) 8230);
            return;
        }
        if (i11 == 42) {
            this.f24752m.a((char) 352);
            return;
        }
        if (i11 == 44) {
            this.f24752m.a((char) 338);
            return;
        }
        if (i11 == 63) {
            this.f24752m.a((char) 376);
            return;
        }
        if (i11 == 57) {
            this.f24752m.a((char) 8482);
            return;
        }
        if (i11 == 58) {
            this.f24752m.a((char) 353);
            return;
        }
        if (i11 == 60) {
            this.f24752m.a((char) 339);
            return;
        }
        if (i11 == 61) {
            this.f24752m.a((char) 8480);
            return;
        }
        switch (i11) {
            case 48:
                this.f24752m.a((char) 9608);
                break;
            case 49:
                this.f24752m.a((char) 8216);
                break;
            case 50:
                this.f24752m.a((char) 8217);
                break;
            case 51:
                this.f24752m.a((char) 8220);
                break;
            case 52:
                this.f24752m.a((char) 8221);
                break;
            case 53:
                this.f24752m.a((char) 8226);
                break;
            default:
                switch (i11) {
                    case 118:
                        this.f24752m.a((char) 8539);
                        break;
                    case 119:
                        this.f24752m.a((char) 8540);
                        break;
                    case 120:
                        this.f24752m.a((char) 8541);
                        break;
                    case 121:
                        this.f24752m.a((char) 8542);
                        break;
                    case 122:
                        this.f24752m.a((char) 9474);
                        break;
                    case 123:
                        this.f24752m.a((char) 9488);
                        break;
                    case 124:
                        this.f24752m.a((char) 9492);
                        break;
                    case 125:
                        this.f24752m.a((char) 9472);
                        break;
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                        this.f24752m.a((char) 9496);
                        break;
                    case 127:
                        this.f24752m.a((char) 9484);
                        break;
                    default:
                        pc.d("Cea708Decoder", "Invalid G2 character: " + i11);
                        break;
                }
                break;
        }
    }

    private void i(int i11) {
        if (i11 == 160) {
            this.f24752m.a((char) 13252);
            return;
        }
        pc.d("Cea708Decoder", "Invalid G3 character: " + i11);
        this.f24752m.a('_');
    }

    private void k() {
        if (this.f24755p == null) {
            return;
        }
        q();
        this.f24755p = null;
    }

    private List l() {
        a aVarB;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 8; i11++) {
            if (!this.f24751l[i11].f() && this.f24751l[i11].g() && (aVarB = this.f24751l[i11].b()) != null) {
                arrayList.add(aVarB);
            }
        }
        Collections.sort(arrayList, a.f24757c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(((a) arrayList.get(i12)).f24758a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    private void m() {
        this.f24752m.a(this.f24747h.a(4), this.f24747h.a(2), this.f24747h.a(2), this.f24747h.f(), this.f24747h.f(), this.f24747h.a(3), this.f24747h.a(3));
    }

    private void n() {
        int iA = b.a(this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2));
        int iA2 = b.a(this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2));
        this.f24747h.d(2);
        this.f24752m.b(iA, iA2, b.a(this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2)));
    }

    private void o() {
        this.f24747h.d(4);
        int iA = this.f24747h.a(4);
        this.f24747h.d(2);
        this.f24752m.a(iA, this.f24747h.a(6));
    }

    private void p() {
        int iA = b.a(this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2));
        int iA2 = this.f24747h.a(2);
        int iA3 = b.a(this.f24747h.a(2), this.f24747h.a(2), this.f24747h.a(2));
        if (this.f24747h.f()) {
            iA2 |= 4;
        }
        boolean zF = this.f24747h.f();
        int iA4 = this.f24747h.a(2);
        int iA5 = this.f24747h.a(2);
        int iA6 = this.f24747h.a(2);
        this.f24747h.d(8);
        this.f24752m.a(iA, iA3, zF, iA2, iA4, iA5, iA6);
    }

    private void q() {
        c cVar = this.f24755p;
        if (cVar.f24789d != (cVar.f24787b * 2) - 1) {
            pc.a("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f24755p.f24787b * 2) - 1) + ", but current index is " + this.f24755p.f24789d + " (sequence number " + this.f24755p.f24786a + ");");
        }
        ah ahVar = this.f24747h;
        c cVar2 = this.f24755p;
        ahVar.a(cVar2.f24788c, cVar2.f24789d);
        int iA = this.f24747h.a(3);
        int iA2 = this.f24747h.a(5);
        if (iA == 7) {
            this.f24747h.d(2);
            iA = this.f24747h.a(6);
            if (iA < 7) {
                pc.d("Cea708Decoder", "Invalid extended service number: " + iA);
            }
        }
        if (iA2 == 0) {
            if (iA != 0) {
                pc.d("Cea708Decoder", "serviceNumber is non-zero (" + iA + ") when blockSize is 0");
                return;
            }
            return;
        }
        if (iA != this.f24750k) {
            return;
        }
        boolean z11 = false;
        while (this.f24747h.b() > 0) {
            int iA3 = this.f24747h.a(8);
            if (iA3 == 16) {
                int iA4 = this.f24747h.a(8);
                if (iA4 <= 31) {
                    c(iA4);
                } else {
                    if (iA4 <= 127) {
                        h(iA4);
                    } else if (iA4 <= 159) {
                        d(iA4);
                    } else if (iA4 <= 255) {
                        i(iA4);
                    } else {
                        pc.d("Cea708Decoder", "Invalid extended command: " + iA4);
                    }
                    z11 = true;
                }
            } else if (iA3 <= 31) {
                a(iA3);
            } else {
                if (iA3 <= 127) {
                    f(iA3);
                } else if (iA3 <= 159) {
                    b(iA3);
                } else if (iA3 <= 255) {
                    g(iA3);
                } else {
                    pc.d("Cea708Decoder", "Invalid base command: " + iA3);
                }
                z11 = true;
            }
        }
        if (z11) {
            this.f24753n = l();
        }
    }

    private void r() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.f24751l[i11].h();
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.m5
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.ol
    public /* bridge */ /* synthetic */ void a(long j11) {
        super.a(j11);
    }

    @Override // com.applovin.impl.a3
    public void a(rl rlVar) {
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(rlVar.f21655c);
        this.f24746g.a(byteBuffer.array(), byteBuffer.limit());
        while (this.f24746g.a() >= 3) {
            int iW = this.f24746g.w();
            int i11 = iW & 3;
            boolean z11 = (iW & 4) == 4;
            byte bW = (byte) this.f24746g.w();
            byte bW2 = (byte) this.f24746g.w();
            if (i11 == 2 || i11 == 3) {
                if (z11) {
                    if (i11 == 3) {
                        k();
                        int i12 = (bW & 192) >> 6;
                        int i13 = this.f24748i;
                        if (i13 != -1 && i12 != (i13 + 1) % 4) {
                            r();
                            pc.d("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f24748i + " current=" + i12);
                        }
                        this.f24748i = i12;
                        int i14 = bW & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        c cVar = new c(i12, i14);
                        this.f24755p = cVar;
                        byte[] bArr = cVar.f24788c;
                        int i15 = cVar.f24789d;
                        cVar.f24789d = i15 + 1;
                        bArr[i15] = bW2;
                    } else {
                        b1.a(i11 == 2);
                        c cVar2 = this.f24755p;
                        if (cVar2 == null) {
                            pc.b("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.f24788c;
                            int i16 = cVar2.f24789d;
                            bArr2[i16] = bW;
                            cVar2.f24789d = i16 + 2;
                            bArr2[i16 + 1] = bW2;
                        }
                    }
                    c cVar3 = this.f24755p;
                    if (cVar3.f24789d == (cVar3.f24787b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // com.applovin.impl.a3, com.applovin.impl.m5
    public void b() {
        super.b();
        this.f24753n = null;
        this.f24754o = null;
        this.f24756q = 0;
        this.f24752m = this.f24751l[0];
        r();
        this.f24755p = null;
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(rl rlVar) {
        super.a(rlVar);
    }

    @Override // com.applovin.impl.a3
    public nl e() {
        List list = this.f24753n;
        this.f24754o = list;
        return new b3((List) b1.a(list));
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ rl d() {
        return super.d();
    }

    @Override // com.applovin.impl.a3
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ sl c() {
        return super.c();
    }

    @Override // com.applovin.impl.a3
    public boolean j() {
        return this.f24753n != this.f24754o;
    }
}

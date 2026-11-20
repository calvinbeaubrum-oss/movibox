package wh;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;
import vh.i;
import vh.m;
import vh.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f79465g = new c0();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b0 f79466h = new b0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f79467i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f79468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f79469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b[] f79470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f79471m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    public List<vh.b> f79472n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public List<vh.b> f79473o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public C0891c f79474p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f79475q;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Comparator<a> f79476c = new Comparator() { // from class: wh.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return c.a.c((c.a) obj, (c.a) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vh.b f79477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f79478b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f11, int i11, int i12, float f12, int i13, float f13, boolean z11, int i14, int i15) {
            vh.b.C0875b c0875bN = new vh.b.C0875b().o(charSequence).p(alignment).h(f11, i11).i(i12).k(f12).l(i13).n(f13);
            if (z11) {
                c0875bN.s(i14);
            }
            this.f79477a = c0875bN.a();
            this.f79478b = i15;
        }

        public static /* synthetic */ int c(a aVar, a aVar2) {
            return Integer.compare(aVar2.f79478b, aVar.f79478b);
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
        public static final int f79479w = h(2, 2, 2, 0);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f79480x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f79481y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int[] f79482z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<SpannableString> f79483a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f79484b = new SpannableStringBuilder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f79485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f79486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f79487e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f79488f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f79489g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f79490h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f79491i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f79492j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f79493k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f79494l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f79495m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f79496n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f79497o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f79498p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f79499q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f79500r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f79501s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f79502t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f79503u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f79504v;

        static {
            int iH = h(0, 0, 0, 0);
            f79480x = iH;
            int iH2 = h(0, 0, 0, 3);
            f79481y = iH2;
            f79482z = new int[]{0, 0, 0, 0, 0, 2, 0};
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
            com.google.android.exoplayer2.util.a.c(i11, 0, 4);
            com.google.android.exoplayer2.util.a.c(i12, 0, 4);
            com.google.android.exoplayer2.util.a.c(i13, 0, 4);
            com.google.android.exoplayer2.util.a.c(i14, 0, 4);
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
                this.f79484b.append(c11);
                return;
            }
            this.f79483a.add(d());
            this.f79484b.clear();
            if (this.f79498p != -1) {
                this.f79498p = 0;
            }
            if (this.f79499q != -1) {
                this.f79499q = 0;
            }
            if (this.f79500r != -1) {
                this.f79500r = 0;
            }
            if (this.f79502t != -1) {
                this.f79502t = 0;
            }
            while (true) {
                if ((!this.f79493k || this.f79483a.size() < this.f79492j) && this.f79483a.size() < 15) {
                    return;
                } else {
                    this.f79483a.remove(0);
                }
            }
        }

        public void b() {
            int length = this.f79484b.length();
            if (length > 0) {
                this.f79484b.delete(length - 1, length);
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
            for (int i11 = 0; i11 < this.f79483a.size(); i11++) {
                spannableStringBuilder.append((CharSequence) this.f79483a.get(i11));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i12 = this.f79494l;
            if (i12 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i12 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.f79494l);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.f79488f) {
                f11 = this.f79490h / 99.0f;
                f12 = this.f79489g / 99.0f;
            } else {
                f11 = this.f79490h / 209.0f;
                f12 = this.f79489g / 74.0f;
            }
            float f13 = (f11 * 0.9f) + 0.05f;
            float f14 = (f12 * 0.9f) + 0.05f;
            int i13 = this.f79491i;
            return new a(spannableStringBuilder, alignment2, f14, 0, i13 / 3 == 0 ? 0 : i13 / 3 == 1 ? 1 : 2, f13, i13 % 3 == 0 ? 0 : i13 % 3 == 1 ? 1 : 2, -3.4028235E38f, this.f79497o != f79480x, this.f79497o, this.f79487e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f79484b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.f79498p != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.f79498p, length, 33);
                }
                if (this.f79499q != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.f79499q, length, 33);
                }
                if (this.f79500r != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f79501s), this.f79500r, length, 33);
                }
                if (this.f79502t != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f79503u), this.f79502t, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.f79483a.clear();
            this.f79484b.clear();
            this.f79498p = -1;
            this.f79499q = -1;
            this.f79500r = -1;
            this.f79502t = -1;
            this.f79504v = 0;
        }

        public void f(boolean z11, boolean z12, boolean z13, int i11, boolean z14, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f79485c = true;
            this.f79486d = z11;
            this.f79493k = z12;
            this.f79487e = i11;
            this.f79488f = z14;
            this.f79489g = i12;
            this.f79490h = i13;
            this.f79491i = i16;
            int i19 = i14 + 1;
            if (this.f79492j != i19) {
                this.f79492j = i19;
                while (true) {
                    if ((!z12 || this.f79483a.size() < this.f79492j) && this.f79483a.size() < 15) {
                        break;
                    } else {
                        this.f79483a.remove(0);
                    }
                }
            }
            if (i17 != 0 && this.f79495m != i17) {
                this.f79495m = i17;
                int i21 = i17 - 1;
                q(D[i21], f79481y, C[i21], 0, A[i21], B[i21], f79482z[i21]);
            }
            if (i18 == 0 || this.f79496n == i18) {
                return;
            }
            this.f79496n = i18;
            int i22 = i18 - 1;
            m(0, 1, 1, false, false, F[i22], E[i22]);
            n(f79479w, G[i22], f79480x);
        }

        public boolean i() {
            return this.f79485c;
        }

        public boolean j() {
            return !i() || (this.f79483a.isEmpty() && this.f79484b.length() == 0);
        }

        public boolean k() {
            return this.f79486d;
        }

        public void l() {
            e();
            this.f79485c = false;
            this.f79486d = false;
            this.f79487e = 4;
            this.f79488f = false;
            this.f79489g = 0;
            this.f79490h = 0;
            this.f79491i = 0;
            this.f79492j = 15;
            this.f79493k = true;
            this.f79494l = 0;
            this.f79495m = 0;
            this.f79496n = 0;
            int i11 = f79480x;
            this.f79497o = i11;
            this.f79501s = f79479w;
            this.f79503u = i11;
        }

        public void m(int i11, int i12, int i13, boolean z11, boolean z12, int i14, int i15) {
            if (this.f79498p != -1) {
                if (!z11) {
                    this.f79484b.setSpan(new StyleSpan(2), this.f79498p, this.f79484b.length(), 33);
                    this.f79498p = -1;
                }
            } else if (z11) {
                this.f79498p = this.f79484b.length();
            }
            if (this.f79499q == -1) {
                if (z12) {
                    this.f79499q = this.f79484b.length();
                }
            } else {
                if (z12) {
                    return;
                }
                this.f79484b.setSpan(new UnderlineSpan(), this.f79499q, this.f79484b.length(), 33);
                this.f79499q = -1;
            }
        }

        public void n(int i11, int i12, int i13) {
            if (this.f79500r != -1 && this.f79501s != i11) {
                this.f79484b.setSpan(new ForegroundColorSpan(this.f79501s), this.f79500r, this.f79484b.length(), 33);
            }
            if (i11 != f79479w) {
                this.f79500r = this.f79484b.length();
                this.f79501s = i11;
            }
            if (this.f79502t != -1 && this.f79503u != i12) {
                this.f79484b.setSpan(new BackgroundColorSpan(this.f79503u), this.f79502t, this.f79484b.length(), 33);
            }
            if (i12 != f79480x) {
                this.f79502t = this.f79484b.length();
                this.f79503u = i12;
            }
        }

        public void o(int i11, int i12) {
            if (this.f79504v != i11) {
                a('\n');
            }
            this.f79504v = i11;
        }

        public void p(boolean z11) {
            this.f79486d = z11;
        }

        public void q(int i11, int i12, boolean z11, int i13, int i14, int i15, int i16) {
            this.f79497o = i11;
            this.f79494l = i16;
        }
    }

    /* JADX INFO: renamed from: wh.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0891c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f79505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f79506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f79507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f79508d = 0;

        public C0891c(int i11, int i12) {
            this.f79505a = i11;
            this.f79506b = i12;
            this.f79507c = new byte[(i12 * 2) - 1];
        }
    }

    public c(int i11, @Nullable List<byte[]> list) {
        this.f79469k = i11 == -1 ? 1 : i11;
        this.f79468j = list != null && com.google.android.exoplayer2.util.f.i(list);
        this.f79470l = new b[8];
        for (int i12 = 0; i12 < 8; i12++) {
            this.f79470l[i12] = new b();
        }
        this.f79471m = this.f79470l[0];
    }

    private void A() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.f79470l[i11].l();
        }
    }

    private List<vh.b> l() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 8; i11++) {
            if (!this.f79470l[i11].j() && this.f79470l[i11].k() && (aVarC = this.f79470l[i11].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.f79476c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.add(((a) arrayList.get(i12)).f79477a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    @Override // wh.e
    public i a() {
        List<vh.b> list = this.f79472n;
        this.f79473o = list;
        return new f((List) com.google.android.exoplayer2.util.a.e(list));
    }

    @Override // wh.e
    public void b(m mVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(mVar.f33030c);
        this.f79465g.N(byteBuffer.array(), byteBuffer.limit());
        while (this.f79465g.a() >= 3) {
            int iD = this.f79465g.D();
            int i11 = iD & 3;
            boolean z11 = (iD & 4) == 4;
            byte bD = (byte) this.f79465g.D();
            byte bD2 = (byte) this.f79465g.D();
            if (i11 == 2 || i11 == 3) {
                if (z11) {
                    if (i11 == 3) {
                        k();
                        int i12 = (bD & 192) >> 6;
                        int i13 = this.f79467i;
                        if (i13 != -1 && i12 != (i13 + 1) % 4) {
                            A();
                            s.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f79467i + " current=" + i12);
                        }
                        this.f79467i = i12;
                        int i14 = bD & Utf8.REPLACEMENT_BYTE;
                        if (i14 == 0) {
                            i14 = 64;
                        }
                        C0891c c0891c = new C0891c(i12, i14);
                        this.f79474p = c0891c;
                        byte[] bArr = c0891c.f79507c;
                        int i15 = c0891c.f79508d;
                        c0891c.f79508d = i15 + 1;
                        bArr[i15] = bD2;
                    } else {
                        com.google.android.exoplayer2.util.a.a(i11 == 2);
                        C0891c c0891c2 = this.f79474p;
                        if (c0891c2 == null) {
                            s.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0891c2.f79507c;
                            int i16 = c0891c2.f79508d;
                            bArr2[i16] = bD;
                            c0891c2.f79508d = i16 + 2;
                            bArr2[i16 + 1] = bD2;
                        }
                    }
                    C0891c c0891c3 = this.f79474p;
                    if (c0891c3.f79508d == (c0891c3.f79506b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // wh.e
    @Nullable
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ m dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // wh.e
    @Nullable
    /* JADX INFO: renamed from: d */
    public /* bridge */ /* synthetic */ n dequeueOutputBuffer() throws SubtitleDecoderException {
        return super.dequeueOutputBuffer();
    }

    @Override // wh.e, com.google.android.exoplayer2.decoder.d
    public void flush() {
        super.flush();
        this.f79472n = null;
        this.f79473o = null;
        this.f79475q = 0;
        this.f79471m = this.f79470l[0];
        A();
        this.f79474p = null;
    }

    @Override // wh.e
    public boolean g() {
        return this.f79472n != this.f79473o;
    }

    @Override // wh.e
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(m mVar) throws SubtitleDecoderException {
        super.queueInputBuffer(mVar);
    }

    public final void k() {
        if (this.f79474p == null) {
            return;
        }
        z();
        this.f79474p = null;
    }

    public final void m(int i11) {
        if (i11 != 0) {
            if (i11 == 3) {
                this.f79472n = l();
            }
            if (i11 == 8) {
                this.f79471m.b();
                return;
            }
            switch (i11) {
                case 12:
                    A();
                    break;
                case 13:
                    this.f79471m.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i11 >= 17 && i11 <= 23) {
                        s.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i11);
                        this.f79466h.r(8);
                    } else if (i11 >= 24 && i11 <= 31) {
                        s.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i11);
                        this.f79466h.r(16);
                    } else {
                        s.i("Cea708Decoder", "Invalid C0 command: " + i11);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void n(int i11) {
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
                if (this.f79475q != i13) {
                    this.f79475q = i13;
                    this.f79471m = this.f79470l[i13];
                }
                break;
            case 136:
                while (i12 <= 8) {
                    if (this.f79466h.g()) {
                        this.f79470l[8 - i12].e();
                    }
                    i12++;
                }
                break;
            case 137:
                for (int i14 = 1; i14 <= 8; i14++) {
                    if (this.f79466h.g()) {
                        this.f79470l[8 - i14].p(true);
                    }
                }
                break;
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                while (i12 <= 8) {
                    if (this.f79466h.g()) {
                        this.f79470l[8 - i12].p(false);
                    }
                    i12++;
                }
                break;
            case 139:
                for (int i15 = 1; i15 <= 8; i15++) {
                    if (this.f79466h.g()) {
                        b bVar = this.f79470l[8 - i15];
                        bVar.p(!bVar.k());
                    }
                }
                break;
            case 140:
                while (i12 <= 8) {
                    if (this.f79466h.g()) {
                        this.f79470l[8 - i12].l();
                    }
                    i12++;
                }
                break;
            case 141:
                this.f79466h.r(8);
                break;
            case 142:
                break;
            case 143:
                A();
                break;
            case 144:
                if (this.f79471m.i()) {
                    v();
                } else {
                    this.f79466h.r(16);
                }
                break;
            case 145:
                if (this.f79471m.i()) {
                    w();
                } else {
                    this.f79466h.r(24);
                }
                break;
            case 146:
                if (this.f79471m.i()) {
                    x();
                } else {
                    this.f79466h.r(16);
                }
                break;
            case 147:
            case 148:
            case 149:
            case 150:
            default:
                s.i("Cea708Decoder", "Invalid C1 command: " + i11);
                break;
            case 151:
                if (this.f79471m.i()) {
                    y();
                } else {
                    this.f79466h.r(32);
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
                q(i16);
                if (this.f79475q != i16) {
                    this.f79475q = i16;
                    this.f79471m = this.f79470l[i16];
                }
                break;
        }
    }

    public final void o(int i11) {
        if (i11 <= 7) {
            return;
        }
        if (i11 <= 15) {
            this.f79466h.r(8);
        } else if (i11 <= 23) {
            this.f79466h.r(16);
        } else if (i11 <= 31) {
            this.f79466h.r(24);
        }
    }

    public final void p(int i11) {
        if (i11 <= 135) {
            this.f79466h.r(32);
            return;
        }
        if (i11 <= 143) {
            this.f79466h.r(40);
        } else if (i11 <= 159) {
            this.f79466h.r(2);
            this.f79466h.r(this.f79466h.h(6) * 8);
        }
    }

    public final void q(int i11) {
        b bVar = this.f79470l[i11];
        this.f79466h.r(2);
        boolean zG = this.f79466h.g();
        boolean zG2 = this.f79466h.g();
        boolean zG3 = this.f79466h.g();
        int iH = this.f79466h.h(3);
        boolean zG4 = this.f79466h.g();
        int iH2 = this.f79466h.h(7);
        int iH3 = this.f79466h.h(8);
        int iH4 = this.f79466h.h(4);
        int iH5 = this.f79466h.h(4);
        this.f79466h.r(2);
        int iH6 = this.f79466h.h(6);
        this.f79466h.r(2);
        bVar.f(zG, zG2, zG3, iH, zG4, iH2, iH3, iH5, iH6, iH4, this.f79466h.h(3), this.f79466h.h(3));
    }

    public final void r(int i11) {
        if (i11 == 127) {
            this.f79471m.a((char) 9835);
        } else {
            this.f79471m.a((char) (i11 & 255));
        }
    }

    @Override // wh.e, com.google.android.exoplayer2.decoder.d
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s(int i11) {
        this.f79471m.a((char) (i11 & 255));
    }

    @Override // wh.e, vh.j
    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }

    public final void t(int i11) {
        if (i11 == 32) {
            this.f79471m.a(' ');
        }
        if (i11 == 33) {
            this.f79471m.a((char) 160);
            return;
        }
        if (i11 == 37) {
            this.f79471m.a((char) 8230);
            return;
        }
        if (i11 == 42) {
            this.f79471m.a((char) 352);
            return;
        }
        if (i11 == 44) {
            this.f79471m.a((char) 338);
            return;
        }
        if (i11 == 63) {
            this.f79471m.a((char) 376);
            return;
        }
        if (i11 == 57) {
            this.f79471m.a((char) 8482);
            return;
        }
        if (i11 == 58) {
            this.f79471m.a((char) 353);
            return;
        }
        if (i11 == 60) {
            this.f79471m.a((char) 339);
            return;
        }
        if (i11 == 61) {
            this.f79471m.a((char) 8480);
            return;
        }
        switch (i11) {
            case 48:
                this.f79471m.a((char) 9608);
                break;
            case 49:
                this.f79471m.a((char) 8216);
                break;
            case 50:
                this.f79471m.a((char) 8217);
                break;
            case 51:
                this.f79471m.a((char) 8220);
                break;
            case 52:
                this.f79471m.a((char) 8221);
                break;
            case 53:
                this.f79471m.a((char) 8226);
                break;
            default:
                switch (i11) {
                    case 118:
                        this.f79471m.a((char) 8539);
                        break;
                    case 119:
                        this.f79471m.a((char) 8540);
                        break;
                    case 120:
                        this.f79471m.a((char) 8541);
                        break;
                    case 121:
                        this.f79471m.a((char) 8542);
                        break;
                    case 122:
                        this.f79471m.a((char) 9474);
                        break;
                    case 123:
                        this.f79471m.a((char) 9488);
                        break;
                    case 124:
                        this.f79471m.a((char) 9492);
                        break;
                    case 125:
                        this.f79471m.a((char) 9472);
                        break;
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                        this.f79471m.a((char) 9496);
                        break;
                    case 127:
                        this.f79471m.a((char) 9484);
                        break;
                    default:
                        s.i("Cea708Decoder", "Invalid G2 character: " + i11);
                        break;
                }
                break;
        }
    }

    public final void u(int i11) {
        if (i11 == 160) {
            this.f79471m.a((char) 13252);
            return;
        }
        s.i("Cea708Decoder", "Invalid G3 character: " + i11);
        this.f79471m.a('_');
    }

    public final void v() {
        this.f79471m.m(this.f79466h.h(4), this.f79466h.h(2), this.f79466h.h(2), this.f79466h.g(), this.f79466h.g(), this.f79466h.h(3), this.f79466h.h(3));
    }

    public final void w() {
        int iH = b.h(this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2));
        int iH2 = b.h(this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2));
        this.f79466h.r(2);
        this.f79471m.n(iH, iH2, b.g(this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2)));
    }

    public final void x() {
        this.f79466h.r(4);
        int iH = this.f79466h.h(4);
        this.f79466h.r(2);
        this.f79471m.o(iH, this.f79466h.h(6));
    }

    public final void y() {
        int iH = b.h(this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2));
        int iH2 = this.f79466h.h(2);
        int iG = b.g(this.f79466h.h(2), this.f79466h.h(2), this.f79466h.h(2));
        if (this.f79466h.g()) {
            iH2 |= 4;
        }
        boolean zG = this.f79466h.g();
        int iH3 = this.f79466h.h(2);
        int iH4 = this.f79466h.h(2);
        int iH5 = this.f79466h.h(2);
        this.f79466h.r(8);
        this.f79471m.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    public final void z() {
        C0891c c0891c = this.f79474p;
        if (c0891c.f79508d != (c0891c.f79506b * 2) - 1) {
            s.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.f79474p.f79506b * 2) - 1) + ", but current index is " + this.f79474p.f79508d + " (sequence number " + this.f79474p.f79505a + ");");
        }
        b0 b0Var = this.f79466h;
        C0891c c0891c2 = this.f79474p;
        b0Var.o(c0891c2.f79507c, c0891c2.f79508d);
        boolean z11 = false;
        while (this.f79466h.b() > 0) {
            int iH = this.f79466h.h(3);
            int iH2 = this.f79466h.h(5);
            if (iH == 7) {
                this.f79466h.r(2);
                iH = this.f79466h.h(6);
                if (iH < 7) {
                    s.i("Cea708Decoder", "Invalid extended service number: " + iH);
                }
            }
            if (iH2 == 0) {
                if (iH == 0) {
                    break;
                }
                s.i("Cea708Decoder", "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
                break;
            }
            if (iH != this.f79469k) {
                this.f79466h.s(iH2);
            } else {
                int iE = this.f79466h.e() + (iH2 * 8);
                while (this.f79466h.e() < iE) {
                    int iH3 = this.f79466h.h(8);
                    if (iH3 == 16) {
                        int iH4 = this.f79466h.h(8);
                        if (iH4 <= 31) {
                            o(iH4);
                        } else {
                            if (iH4 <= 127) {
                                t(iH4);
                            } else if (iH4 <= 159) {
                                p(iH4);
                            } else if (iH4 <= 255) {
                                u(iH4);
                            } else {
                                s.i("Cea708Decoder", "Invalid extended command: " + iH4);
                            }
                            z11 = true;
                        }
                    } else if (iH3 <= 31) {
                        m(iH3);
                    } else {
                        if (iH3 <= 127) {
                            r(iH3);
                        } else if (iH3 <= 159) {
                            n(iH3);
                        } else if (iH3 <= 255) {
                            s(iH3);
                        } else {
                            s.i("Cea708Decoder", "Invalid base command: " + iH3);
                        }
                        z11 = true;
                    }
                }
            }
        }
        if (z11) {
            this.f79472n = l();
        }
    }
}

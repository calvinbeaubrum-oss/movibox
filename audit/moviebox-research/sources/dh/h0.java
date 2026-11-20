package dh;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 implements tg.l {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final tg.r f63137t = new tg.r() { // from class: dh.g0
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return h0.v();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f63139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.google.android.exoplayer2.util.k0> f63140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f63141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseIntArray f63142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i0.c f63143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SparseArray<i0> f63144g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseBooleanArray f63145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseBooleanArray f63146i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f0 f63147j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e0 f63148k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public tg.n f63149l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f63150m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f63151n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f63152o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f63153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public i0 f63154q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f63155r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f63156s;

    /* JADX INFO: compiled from: source.java */
    public class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.b0 f63157a = new com.google.android.exoplayer2.util.b0(new byte[4]);

        public a() {
        }

        @Override // dh.b0
        public void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, i0.d dVar) {
        }

        @Override // dh.b0
        public void b(com.google.android.exoplayer2.util.c0 c0Var) {
            if (c0Var.D() == 0 && (c0Var.D() & 128) != 0) {
                c0Var.Q(6);
                int iA = c0Var.a() / 4;
                for (int i11 = 0; i11 < iA; i11++) {
                    c0Var.i(this.f63157a, 4);
                    int iH = this.f63157a.h(16);
                    this.f63157a.r(3);
                    if (iH == 0) {
                        this.f63157a.r(13);
                    } else {
                        int iH2 = this.f63157a.h(13);
                        if (h0.this.f63144g.get(iH2) == null) {
                            h0.this.f63144g.put(iH2, new c0(h0.this.new b(iH2)));
                            h0.j(h0.this);
                        }
                    }
                }
                if (h0.this.f63138a != 2) {
                    h0.this.f63144g.remove(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.b0 f63159a = new com.google.android.exoplayer2.util.b0(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<i0> f63160b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseIntArray f63161c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f63162d;

        public b(int i11) {
            this.f63162d = i11;
        }

        @Override // dh.b0
        public void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, i0.d dVar) {
        }

        @Override // dh.b0
        public void b(com.google.android.exoplayer2.util.c0 c0Var) {
            com.google.android.exoplayer2.util.k0 k0Var;
            if (c0Var.D() != 2) {
                return;
            }
            if (h0.this.f63138a == 1 || h0.this.f63138a == 2 || h0.this.f63150m == 1) {
                k0Var = (com.google.android.exoplayer2.util.k0) h0.this.f63140c.get(0);
            } else {
                k0Var = new com.google.android.exoplayer2.util.k0(((com.google.android.exoplayer2.util.k0) h0.this.f63140c.get(0)).c());
                h0.this.f63140c.add(k0Var);
            }
            if ((c0Var.D() & 128) == 0) {
                return;
            }
            c0Var.Q(1);
            int iJ = c0Var.J();
            int i11 = 3;
            c0Var.Q(3);
            c0Var.i(this.f63159a, 2);
            this.f63159a.r(3);
            int i12 = 13;
            h0.this.f63156s = this.f63159a.h(13);
            c0Var.i(this.f63159a, 2);
            int i13 = 4;
            this.f63159a.r(4);
            c0Var.Q(this.f63159a.h(12));
            if (h0.this.f63138a == 2 && h0.this.f63154q == null) {
                i0.b bVar = new i0.b(21, null, null, o0.f35613f);
                h0 h0Var = h0.this;
                h0Var.f63154q = h0Var.f63143f.a(21, bVar);
                if (h0.this.f63154q != null) {
                    h0.this.f63154q.a(k0Var, h0.this.f63149l, new i0.d(iJ, 21, 8192));
                }
            }
            this.f63160b.clear();
            this.f63161c.clear();
            int iA = c0Var.a();
            while (iA > 0) {
                c0Var.i(this.f63159a, 5);
                int iH = this.f63159a.h(8);
                this.f63159a.r(i11);
                int iH2 = this.f63159a.h(i12);
                this.f63159a.r(i13);
                int iH3 = this.f63159a.h(12);
                i0.b bVarC = c(c0Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.f63189a;
                }
                iA -= iH3 + 5;
                int i14 = h0.this.f63138a == 2 ? iH : iH2;
                if (!h0.this.f63145h.get(i14)) {
                    i0 i0VarA = (h0.this.f63138a == 2 && iH == 21) ? h0.this.f63154q : h0.this.f63143f.a(iH, bVarC);
                    if (h0.this.f63138a != 2 || iH2 < this.f63161c.get(i14, 8192)) {
                        this.f63161c.put(i14, iH2);
                        this.f63160b.put(i14, i0VarA);
                    }
                }
                i11 = 3;
                i13 = 4;
                i12 = 13;
            }
            int size = this.f63161c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int iKeyAt = this.f63161c.keyAt(i15);
                int iValueAt = this.f63161c.valueAt(i15);
                h0.this.f63145h.put(iKeyAt, true);
                h0.this.f63146i.put(iValueAt, true);
                i0 i0VarValueAt = this.f63160b.valueAt(i15);
                if (i0VarValueAt != null) {
                    if (i0VarValueAt != h0.this.f63154q) {
                        i0VarValueAt.a(k0Var, h0.this.f63149l, new i0.d(iJ, iKeyAt, 8192));
                    }
                    h0.this.f63144g.put(iValueAt, i0VarValueAt);
                }
            }
            if (h0.this.f63138a == 2) {
                if (h0.this.f63151n) {
                    return;
                }
                h0.this.f63149l.endTracks();
                h0.this.f63150m = 0;
                h0.this.f63151n = true;
                return;
            }
            h0.this.f63144g.remove(this.f63162d);
            h0 h0Var2 = h0.this;
            h0Var2.f63150m = h0Var2.f63138a == 1 ? 0 : h0.this.f63150m - 1;
            if (h0.this.f63150m == 0) {
                h0.this.f63149l.endTracks();
                h0.this.f63151n = true;
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0043  */
        /* JADX WARN: Code duplicated, block: B:24:0x0056  */
        /* JADX WARN: Code duplicated, block: B:27:0x005d  */
        public final i0.b c(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
            int iE = c0Var.e();
            int i12 = i11 + iE;
            int i13 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (c0Var.e() < i12) {
                int iD = c0Var.D();
                int iE2 = c0Var.e() + c0Var.D();
                if (iE2 > i12) {
                    break;
                }
                if (iD == 5) {
                    long jF = c0Var.F();
                    if (jF == 1094921523) {
                        i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (jF == 1161904947) {
                        i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                    } else if (jF == 1094921524) {
                        i13 = 172;
                    } else if (jF == 1212503619) {
                        i13 = 36;
                    }
                } else if (iD == 106) {
                    i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                } else if (iD == 122) {
                    i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                } else if (iD == 127) {
                    if (c0Var.D() == 21) {
                        i13 = 172;
                    }
                } else if (iD == 123) {
                    i13 = TsExtractor.TS_STREAM_TYPE_DTS;
                } else if (iD == 10) {
                    strTrim = c0Var.A(3).trim();
                } else if (iD == 89) {
                    ArrayList arrayList2 = new ArrayList();
                    while (c0Var.e() < iE2) {
                        String strTrim2 = c0Var.A(3).trim();
                        int iD2 = c0Var.D();
                        byte[] bArr = new byte[4];
                        c0Var.j(bArr, 0, 4);
                        arrayList2.add(new i0.a(strTrim2, iD2, bArr));
                    }
                    arrayList = arrayList2;
                    i13 = 89;
                } else if (iD == 111) {
                    i13 = InputDeviceCompat.SOURCE_KEYBOARD;
                }
                c0Var.Q(iE2 - c0Var.e());
            }
            c0Var.P(i12);
            return new i0.b(i13, strTrim, arrayList, Arrays.copyOfRange(c0Var.d(), iE, i12));
        }
    }

    public h0() {
        this(0);
    }

    public h0(int i11) {
        this(1, i11, 112800);
    }

    public h0(int i11, int i12, int i13) {
        this(i11, new com.google.android.exoplayer2.util.k0(0L), new j(i12), i13);
    }

    public h0(int i11, com.google.android.exoplayer2.util.k0 k0Var, i0.c cVar) {
        this(i11, k0Var, cVar, 112800);
    }

    public h0(int i11, com.google.android.exoplayer2.util.k0 k0Var, i0.c cVar, int i12) {
        this.f63143f = (i0.c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f63139b = i12;
        this.f63138a = i11;
        if (i11 == 1 || i11 == 2) {
            this.f63140c = Collections.singletonList(k0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f63140c = arrayList;
            arrayList.add(k0Var);
        }
        this.f63141d = new com.google.android.exoplayer2.util.c0(new byte[9400], 0);
        this.f63145h = new SparseBooleanArray();
        this.f63146i = new SparseBooleanArray();
        this.f63144g = new SparseArray<>();
        this.f63142e = new SparseIntArray();
        this.f63147j = new f0(i12);
        this.f63149l = tg.n.f77074l8;
        this.f63156s = -1;
        x();
    }

    public static /* synthetic */ int j(h0 h0Var) {
        int i11 = h0Var.f63150m;
        h0Var.f63150m = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ tg.l[] v() {
        return new tg.l[]{new h0()};
    }

    private void w(long j11) {
        if (this.f63152o) {
            return;
        }
        this.f63152o = true;
        if (this.f63147j.b() == C.TIME_UNSET) {
            this.f63149l.g(new tg.b0.b(this.f63147j.b()));
            return;
        }
        e0 e0Var = new e0(this.f63147j.c(), this.f63147j.b(), j11, this.f63156s, this.f63139b);
        this.f63148k = e0Var;
        this.f63149l.g(e0Var.b());
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        byte[] bArrD = this.f63141d.d();
        mVar.peekFully(bArrD, 0, 940);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= 5) {
                    mVar.skipFully(i11);
                    return true;
                }
                if (bArrD[(i12 * 188) + i11] != 71) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }

    @Override // tg.l
    public int c(tg.m mVar, tg.a0 a0Var) throws IOException {
        long length = mVar.getLength();
        if (this.f63151n) {
            if (length != -1 && this.f63138a != 2 && !this.f63147j.d()) {
                return this.f63147j.e(mVar, a0Var, this.f63156s);
            }
            w(length);
            if (this.f63153p) {
                this.f63153p = false;
                seek(0L, 0L);
                if (mVar.getPosition() != 0) {
                    a0Var.f76990a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f63148k;
            if (e0Var != null && e0Var.d()) {
                return this.f63148k.c(mVar, a0Var);
            }
        }
        if (!t(mVar)) {
            return -1;
        }
        int iU = u();
        int iF = this.f63141d.f();
        if (iU > iF) {
            return 0;
        }
        int iN = this.f63141d.n();
        if ((8388608 & iN) != 0) {
            this.f63141d.P(iU);
            return 0;
        }
        int i11 = (4194304 & iN) != 0 ? 1 : 0;
        int i12 = (2096896 & iN) >> 8;
        boolean z11 = (iN & 32) != 0;
        i0 i0Var = (iN & 16) != 0 ? this.f63144g.get(i12) : null;
        if (i0Var == null) {
            this.f63141d.P(iU);
            return 0;
        }
        if (this.f63138a != 2) {
            int i13 = iN & 15;
            int i14 = this.f63142e.get(i12, i13 - 1);
            this.f63142e.put(i12, i13);
            if (i14 == i13) {
                this.f63141d.P(iU);
                return 0;
            }
            if (i13 != ((i14 + 1) & 15)) {
                i0Var.seek();
            }
        }
        if (z11) {
            int iD = this.f63141d.D();
            i11 |= (this.f63141d.D() & 64) != 0 ? 2 : 0;
            this.f63141d.Q(iD - 1);
        }
        boolean z12 = this.f63151n;
        if (y(i12)) {
            this.f63141d.O(iU);
            i0Var.b(this.f63141d, i11);
            this.f63141d.O(iF);
        }
        if (this.f63138a != 2 && !z12 && this.f63151n && length != -1) {
            this.f63153p = true;
        }
        this.f63141d.P(iU);
        return 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f63149l = nVar;
    }

    @Override // tg.l
    public void release() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // tg.l
    public void seek(long j11, long j12) {
        e0 e0Var;
        com.google.android.exoplayer2.util.a.g(this.f63138a != 2);
        int size = this.f63140c.size();
        for (int i11 = 0; i11 < size; i11++) {
            com.google.android.exoplayer2.util.k0 k0Var = this.f63140c.get(i11);
            boolean z11 = k0Var.e() == C.TIME_UNSET;
            if (!z11) {
                long jC = k0Var.c();
                if (jC != C.TIME_UNSET && jC != 0 && jC != j12) {
                    k0Var.g(j12);
                }
            } else if (z11) {
                k0Var.g(j12);
            }
        }
        if (j12 != 0 && (e0Var = this.f63148k) != null) {
            e0Var.h(j12);
        }
        this.f63141d.L(0);
        this.f63142e.clear();
        for (int i12 = 0; i12 < this.f63144g.size(); i12++) {
            this.f63144g.valueAt(i12).seek();
        }
        this.f63155r = 0;
    }

    public final boolean t(tg.m mVar) throws IOException {
        byte[] bArrD = this.f63141d.d();
        if (9400 - this.f63141d.e() < 188) {
            int iA = this.f63141d.a();
            if (iA > 0) {
                System.arraycopy(bArrD, this.f63141d.e(), bArrD, 0, iA);
            }
            this.f63141d.N(bArrD, iA);
        }
        while (this.f63141d.a() < 188) {
            int iF = this.f63141d.f();
            int i11 = mVar.read(bArrD, iF, 9400 - iF);
            if (i11 == -1) {
                return false;
            }
            this.f63141d.O(iF + i11);
        }
        return true;
    }

    public final int u() throws ParserException {
        int iE = this.f63141d.e();
        int iF = this.f63141d.f();
        int iA = j0.a(this.f63141d.d(), iE, iF);
        this.f63141d.P(iA);
        int i11 = iA + 188;
        if (i11 > iF) {
            int i12 = this.f63155r + (iA - iE);
            this.f63155r = i12;
            if (this.f63138a == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f63155r = 0;
        }
        return i11;
    }

    public final void x() {
        this.f63145h.clear();
        this.f63144g.clear();
        SparseArray<i0> sparseArrayCreateInitialPayloadReaders = this.f63143f.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f63144g.put(sparseArrayCreateInitialPayloadReaders.keyAt(i11), sparseArrayCreateInitialPayloadReaders.valueAt(i11));
        }
        this.f63144g.put(0, new c0(new a()));
        this.f63154q = null;
    }

    public final boolean y(int i11) {
        return this.f63138a == 2 || this.f63151n || !this.f63146i.get(i11, false);
    }
}

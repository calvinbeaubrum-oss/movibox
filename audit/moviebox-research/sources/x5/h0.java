package x5;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import u4.l0;
import u4.m0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements u4.s {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Deprecated
    public static final u4.y f79981v = new u4.y() { // from class: x5.g0
        @Override // u4.y
        public /* synthetic */ u4.y a(o5.s.a aVar) {
            return u4.x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ u4.s[] b(Uri uri, Map map) {
            return u4.x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ u4.y c(boolean z11) {
            return u4.x.b(this, z11);
        }

        @Override // u4.y
        public final u4.s[] createExtractors() {
            return h0.w();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<z3.i0> f79985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final z3.c0 f79986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseIntArray f79987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i0.c f79988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o5.s.a f79989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<i0> f79990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SparseBooleanArray f79991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseBooleanArray f79992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f0 f79993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e0 f79994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u4.u f79995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f79996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f79997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f79998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f79999r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public i0 f80000s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f80001t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f80002u;

    /* JADX INFO: compiled from: source.java */
    public class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z3.b0 f80003a = new z3.b0(new byte[4]);

        public a() {
        }

        @Override // x5.b0
        public void a(z3.i0 i0Var, u4.u uVar, i0.d dVar) {
        }

        @Override // x5.b0
        public void b(z3.c0 c0Var) {
            if (c0Var.H() == 0 && (c0Var.H() & 128) != 0) {
                c0Var.V(6);
                int iA = c0Var.a() / 4;
                for (int i11 = 0; i11 < iA; i11++) {
                    c0Var.k(this.f80003a, 4);
                    int iH = this.f80003a.h(16);
                    this.f80003a.r(3);
                    if (iH == 0) {
                        this.f80003a.r(13);
                    } else {
                        int iH2 = this.f80003a.h(13);
                        if (h0.this.f79990i.get(iH2) == null) {
                            h0.this.f79990i.put(iH2, new c0(h0.this.new b(iH2)));
                            h0.k(h0.this);
                        }
                    }
                }
                if (h0.this.f79982a != 2) {
                    h0.this.f79990i.remove(0);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z3.b0 f80005a = new z3.b0(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<i0> f80006b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseIntArray f80007c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f80008d;

        public b(int i11) {
            this.f80008d = i11;
        }

        @Override // x5.b0
        public void a(z3.i0 i0Var, u4.u uVar, i0.d dVar) {
        }

        @Override // x5.b0
        public void b(z3.c0 c0Var) {
            z3.i0 i0Var;
            if (c0Var.H() != 2) {
                return;
            }
            if (h0.this.f79982a == 1 || h0.this.f79982a == 2 || h0.this.f79996o == 1) {
                i0Var = (z3.i0) h0.this.f79985d.get(0);
            } else {
                i0Var = new z3.i0(((z3.i0) h0.this.f79985d.get(0)).d());
                h0.this.f79985d.add(i0Var);
            }
            if ((c0Var.H() & 128) == 0) {
                return;
            }
            c0Var.V(1);
            int iN = c0Var.N();
            int i11 = 3;
            c0Var.V(3);
            c0Var.k(this.f80005a, 2);
            this.f80005a.r(3);
            int i12 = 13;
            h0.this.f80002u = this.f80005a.h(13);
            c0Var.k(this.f80005a, 2);
            int i13 = 4;
            this.f80005a.r(4);
            c0Var.V(this.f80005a.h(12));
            if (h0.this.f79982a == 2 && h0.this.f80000s == null) {
                i0.b bVar = new i0.b(21, null, 0, null, u0.f81843f);
                h0 h0Var = h0.this;
                h0Var.f80000s = h0Var.f79988g.a(21, bVar);
                if (h0.this.f80000s != null) {
                    h0.this.f80000s.a(i0Var, h0.this.f79995n, new i0.d(iN, 21, 8192));
                }
            }
            this.f80006b.clear();
            this.f80007c.clear();
            int iA = c0Var.a();
            while (iA > 0) {
                c0Var.k(this.f80005a, 5);
                int iH = this.f80005a.h(8);
                this.f80005a.r(i11);
                int iH2 = this.f80005a.h(i12);
                this.f80005a.r(i13);
                int iH3 = this.f80005a.h(12);
                i0.b bVarC = c(c0Var, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarC.f80036a;
                }
                iA -= iH3 + 5;
                int i14 = h0.this.f79982a == 2 ? iH : iH2;
                if (!h0.this.f79991j.get(i14)) {
                    i0 i0VarA = (h0.this.f79982a == 2 && iH == 21) ? h0.this.f80000s : h0.this.f79988g.a(iH, bVarC);
                    if (h0.this.f79982a != 2 || iH2 < this.f80007c.get(i14, 8192)) {
                        this.f80007c.put(i14, iH2);
                        this.f80006b.put(i14, i0VarA);
                    }
                }
                i11 = 3;
                i13 = 4;
                i12 = 13;
            }
            int size = this.f80007c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int iKeyAt = this.f80007c.keyAt(i15);
                int iValueAt = this.f80007c.valueAt(i15);
                h0.this.f79991j.put(iKeyAt, true);
                h0.this.f79992k.put(iValueAt, true);
                i0 i0VarValueAt = this.f80006b.valueAt(i15);
                if (i0VarValueAt != null) {
                    if (i0VarValueAt != h0.this.f80000s) {
                        i0VarValueAt.a(i0Var, h0.this.f79995n, new i0.d(iN, iKeyAt, 8192));
                    }
                    h0.this.f79990i.put(iValueAt, i0VarValueAt);
                }
            }
            if (h0.this.f79982a == 2) {
                if (h0.this.f79997p) {
                    return;
                }
                h0.this.f79995n.endTracks();
                h0.this.f79996o = 0;
                h0.this.f79997p = true;
                return;
            }
            h0.this.f79990i.remove(this.f80008d);
            h0 h0Var2 = h0.this;
            h0Var2.f79996o = h0Var2.f79982a == 1 ? 0 : h0.this.f79996o - 1;
            if (h0.this.f79996o == 0) {
                h0.this.f79995n.endTracks();
                h0.this.f79997p = true;
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x004a  */
        /* JADX WARN: Code duplicated, block: B:24:0x005d  */
        /* JADX WARN: Code duplicated, block: B:27:0x0065  */
        public final i0.b c(z3.c0 c0Var, int i11) {
            int iF = c0Var.f();
            int i12 = iF + i11;
            String str = null;
            ArrayList arrayList = null;
            int i13 = -1;
            int iH = 0;
            while (c0Var.f() < i12) {
                int iH2 = c0Var.H();
                int iF2 = c0Var.f() + c0Var.H();
                if (iF2 > i12) {
                    break;
                }
                if (iH2 == 5) {
                    long J = c0Var.J();
                    if (J == 1094921523) {
                        i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (J == 1161904947) {
                        i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                    } else if (J == 1094921524) {
                        i13 = 172;
                    } else if (J == 1212503619) {
                        i13 = 36;
                    }
                } else if (iH2 == 106) {
                    i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                } else if (iH2 == 122) {
                    i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                } else if (iH2 == 127) {
                    int iH3 = c0Var.H();
                    if (iH3 == 21) {
                        i13 = 172;
                    } else if (iH3 == 14) {
                        i13 = 136;
                    } else if (iH3 == 33) {
                        i13 = 139;
                    }
                } else if (iH2 == 123) {
                    i13 = TsExtractor.TS_STREAM_TYPE_DTS;
                } else if (iH2 == 10) {
                    String strTrim = c0Var.E(3).trim();
                    iH = c0Var.H();
                    str = strTrim;
                } else if (iH2 == 89) {
                    ArrayList arrayList2 = new ArrayList();
                    while (c0Var.f() < iF2) {
                        String strTrim2 = c0Var.E(3).trim();
                        int iH4 = c0Var.H();
                        byte[] bArr = new byte[4];
                        c0Var.l(bArr, 0, 4);
                        arrayList2.add(new i0.a(strTrim2, iH4, bArr));
                    }
                    arrayList = arrayList2;
                    i13 = 89;
                } else if (iH2 == 111) {
                    i13 = InputDeviceCompat.SOURCE_KEYBOARD;
                }
                c0Var.V(iF2 - c0Var.f());
            }
            c0Var.U(i12);
            return new i0.b(i13, str, iH, arrayList, Arrays.copyOfRange(c0Var.e(), iF, i12));
        }
    }

    public h0(int i11, int i12, o5.s.a aVar, z3.i0 i0Var, i0.c cVar, int i13) {
        this.f79988g = (i0.c) z3.a.e(cVar);
        this.f79984c = i13;
        this.f79982a = i11;
        this.f79983b = i12;
        this.f79989h = aVar;
        if (i11 == 1 || i11 == 2) {
            this.f79985d = Collections.singletonList(i0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f79985d = arrayList;
            arrayList.add(i0Var);
        }
        this.f79986e = new z3.c0(new byte[9400], 0);
        this.f79991j = new SparseBooleanArray();
        this.f79992k = new SparseBooleanArray();
        this.f79990i = new SparseArray<>();
        this.f79987f = new SparseIntArray();
        this.f79993l = new f0(i13);
        this.f79995n = u4.u.f78395m8;
        this.f80002u = -1;
        y();
    }

    public h0(int i11, o5.s.a aVar) {
        this(1, i11, aVar, new z3.i0(0L), new j(0), 112800);
    }

    public static /* synthetic */ int k(h0 h0Var) {
        int i11 = h0Var.f79996o;
        h0Var.f79996o = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ u4.s[] w() {
        return new u4.s[]{new h0(1, o5.s.a.f72352a)};
    }

    private void x(long j11) {
        if (this.f79998q) {
            return;
        }
        this.f79998q = true;
        if (this.f79993l.b() == C.TIME_UNSET) {
            this.f79995n.f(new m0.b(this.f79993l.b()));
            return;
        }
        e0 e0Var = new e0(this.f79993l.c(), this.f79993l.b(), j11, this.f80002u, this.f79984c);
        this.f79994m = e0Var;
        this.f79995n.f(e0Var.b());
    }

    @Override // u4.s
    public boolean b(u4.t tVar) throws IOException {
        byte[] bArrE = this.f79986e.e();
        tVar.peekFully(bArrE, 0, 940);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= 5) {
                    tVar.skipFully(i11);
                    return true;
                }
                if (bArrE[(i12 * 188) + i11] != 71) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }

    @Override // u4.s
    public /* synthetic */ u4.s c() {
        return u4.r.a(this);
    }

    @Override // u4.s
    public int d(u4.t tVar, l0 l0Var) throws IOException {
        long length = tVar.getLength();
        if (this.f79997p) {
            if (length != -1 && this.f79982a != 2 && !this.f79993l.d()) {
                return this.f79993l.e(tVar, l0Var, this.f80002u);
            }
            x(length);
            if (this.f79999r) {
                this.f79999r = false;
                seek(0L, 0L);
                if (tVar.getPosition() != 0) {
                    l0Var.f78322a = 0L;
                    return 1;
                }
            }
            e0 e0Var = this.f79994m;
            if (e0Var != null && e0Var.d()) {
                return this.f79994m.c(tVar, l0Var);
            }
        }
        if (!u(tVar)) {
            return -1;
        }
        int iV = v();
        int iG = this.f79986e.g();
        if (iV > iG) {
            return 0;
        }
        int iQ = this.f79986e.q();
        if ((8388608 & iQ) != 0) {
            this.f79986e.U(iV);
            return 0;
        }
        int i11 = (4194304 & iQ) != 0 ? 1 : 0;
        int i12 = (2096896 & iQ) >> 8;
        boolean z11 = (iQ & 32) != 0;
        i0 i0Var = (iQ & 16) != 0 ? this.f79990i.get(i12) : null;
        if (i0Var == null) {
            this.f79986e.U(iV);
            return 0;
        }
        if (this.f79982a != 2) {
            int i13 = iQ & 15;
            int i14 = this.f79987f.get(i12, i13 - 1);
            this.f79987f.put(i12, i13);
            if (i14 == i13) {
                this.f79986e.U(iV);
                return 0;
            }
            if (i13 != ((i14 + 1) & 15)) {
                i0Var.seek();
            }
        }
        if (z11) {
            int iH = this.f79986e.H();
            i11 |= (this.f79986e.H() & 64) != 0 ? 2 : 0;
            this.f79986e.V(iH - 1);
        }
        boolean z12 = this.f79997p;
        if (z(i12)) {
            this.f79986e.T(iV);
            i0Var.b(this.f79986e, i11);
            this.f79986e.T(iG);
        }
        if (this.f79982a != 2 && !z12 && this.f79997p && length != -1) {
            this.f79999r = true;
        }
        this.f79986e.U(iV);
        return 0;
    }

    @Override // u4.s
    public void f(u4.u uVar) {
        if ((this.f79983b & 1) == 0) {
            uVar = new o5.u(uVar, this.f79989h);
        }
        this.f79995n = uVar;
    }

    @Override // u4.s
    public void release() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // u4.s
    public void seek(long j11, long j12) {
        e0 e0Var;
        z3.a.g(this.f79982a != 2);
        int size = this.f79985d.size();
        for (int i11 = 0; i11 < size; i11++) {
            z3.i0 i0Var = this.f79985d.get(i11);
            boolean z11 = i0Var.f() == C.TIME_UNSET;
            if (!z11) {
                long jD = i0Var.d();
                if (jD != C.TIME_UNSET && jD != 0 && jD != j12) {
                    i0Var.i(j12);
                }
            } else if (z11) {
                i0Var.i(j12);
            }
        }
        if (j12 != 0 && (e0Var = this.f79994m) != null) {
            e0Var.h(j12);
        }
        this.f79986e.Q(0);
        this.f79987f.clear();
        for (int i12 = 0; i12 < this.f79990i.size(); i12++) {
            this.f79990i.valueAt(i12).seek();
        }
        this.f80001t = 0;
    }

    public final boolean u(u4.t tVar) throws IOException {
        byte[] bArrE = this.f79986e.e();
        if (9400 - this.f79986e.f() < 188) {
            int iA = this.f79986e.a();
            if (iA > 0) {
                System.arraycopy(bArrE, this.f79986e.f(), bArrE, 0, iA);
            }
            this.f79986e.S(bArrE, iA);
        }
        while (this.f79986e.a() < 188) {
            int iG = this.f79986e.g();
            int i11 = tVar.read(bArrE, iG, 9400 - iG);
            if (i11 == -1) {
                return false;
            }
            this.f79986e.T(iG + i11);
        }
        return true;
    }

    public final int v() throws ParserException {
        int iF = this.f79986e.f();
        int iG = this.f79986e.g();
        int iA = j0.a(this.f79986e.e(), iF, iG);
        this.f79986e.U(iA);
        int i11 = iA + 188;
        if (i11 > iG) {
            int i12 = this.f80001t + (iA - iF);
            this.f80001t = i12;
            if (this.f79982a == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f80001t = 0;
        }
        return i11;
    }

    public final void y() {
        this.f79991j.clear();
        this.f79990i.clear();
        SparseArray<i0> sparseArrayCreateInitialPayloadReaders = this.f79988g.createInitialPayloadReaders();
        int size = sparseArrayCreateInitialPayloadReaders.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f79990i.put(sparseArrayCreateInitialPayloadReaders.keyAt(i11), sparseArrayCreateInitialPayloadReaders.valueAt(i11));
        }
        this.f79990i.put(0, new c0(new a()));
        this.f80000s = null;
    }

    public final boolean z(int i11) {
        return this.f79982a == 2 || this.f79997p || !this.f79992k.get(i11, false);
    }
}

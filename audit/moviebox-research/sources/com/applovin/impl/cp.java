package com.applovin.impl;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class cp implements k8 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final o8 f18274t = new o8() { // from class: com.applovin.impl.wu
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return cp.c();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f18277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bh f18278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseIntArray f18279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final dp.c f18280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray f18281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseBooleanArray f18282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SparseBooleanArray f18283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final bp f18284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ap f18285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private m8 f18286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18287m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f18288n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f18289o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f18290p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private dp f18291q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f18292r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f18293s;

    /* JADX INFO: compiled from: source.java */
    public class a implements gj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ah f18294a = new ah(new byte[4]);

        public a() {
        }

        @Override // com.applovin.impl.gj
        public void a(bh bhVar) {
            if (bhVar.w() == 0 && (bhVar.w() & 128) != 0) {
                bhVar.g(6);
                int iA = bhVar.a() / 4;
                for (int i11 = 0; i11 < iA; i11++) {
                    bhVar.a(this.f18294a, 4);
                    int iA2 = this.f18294a.a(16);
                    this.f18294a.d(3);
                    if (iA2 == 0) {
                        this.f18294a.d(13);
                    } else {
                        int iA3 = this.f18294a.a(13);
                        if (cp.this.f18281g.get(iA3) == null) {
                            cp.this.f18281g.put(iA3, new hj(cp.this.new b(iA3)));
                            cp.d(cp.this);
                        }
                    }
                }
                if (cp.this.f18275a != 2) {
                    cp.this.f18281g.remove(0);
                }
            }
        }

        @Override // com.applovin.impl.gj
        public void a(ho hoVar, m8 m8Var, dp.d dVar) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements gj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ah f18296a = new ah(new byte[5]);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f18297b = new SparseArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SparseIntArray f18298c = new SparseIntArray();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f18299d;

        public b(int i11) {
            this.f18299d = i11;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x004d  */
        /* JADX WARN: Code duplicated, block: B:27:0x0054  */
        /* JADX WARN: Code duplicated, block: B:32:0x0063  */
        private dp.b a(bh bhVar, int i11) {
            int iD = bhVar.d();
            int i12 = i11 + iD;
            int i13 = -1;
            String strTrim = null;
            ArrayList arrayList = null;
            while (bhVar.d() < i12) {
                int iW = bhVar.w();
                int iD2 = bhVar.d() + bhVar.w();
                if (iD2 > i12) {
                    break;
                }
                if (iW == 5) {
                    long jY = bhVar.y();
                    if (jY == 1094921523) {
                        i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (jY == 1161904947) {
                        i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                    } else if (jY == 1094921524) {
                        i13 = 172;
                    } else if (jY == 1212503619) {
                        i13 = 36;
                    }
                } else if (iW == 106) {
                    i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                } else if (iW == 122) {
                    i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                } else if (iW == 127) {
                    if (bhVar.w() == 21) {
                        i13 = 172;
                    }
                } else if (iW == 123) {
                    i13 = TsExtractor.TS_STREAM_TYPE_DTS;
                } else if (iW == 10) {
                    strTrim = bhVar.c(3).trim();
                } else if (iW == 89) {
                    ArrayList arrayList2 = new ArrayList();
                    while (bhVar.d() < iD2) {
                        String strTrim2 = bhVar.c(3).trim();
                        int iW2 = bhVar.w();
                        byte[] bArr = new byte[4];
                        bhVar.a(bArr, 0, 4);
                        arrayList2.add(new dp.a(strTrim2, iW2, bArr));
                    }
                    arrayList = arrayList2;
                    i13 = 89;
                } else if (iW == 111) {
                    i13 = InputDeviceCompat.SOURCE_KEYBOARD;
                }
                bhVar.g(iD2 - bhVar.d());
            }
            bhVar.f(i12);
            return new dp.b(i13, strTrim, arrayList, Arrays.copyOfRange(bhVar.c(), iD, i12));
        }

        @Override // com.applovin.impl.gj
        public void a(bh bhVar) {
            ho hoVar;
            if (bhVar.w() != 2) {
                return;
            }
            if (cp.this.f18275a == 1 || cp.this.f18275a == 2 || cp.this.f18287m == 1) {
                hoVar = (ho) cp.this.f18277c.get(0);
            } else {
                hoVar = new ho(((ho) cp.this.f18277c.get(0)).a());
                cp.this.f18277c.add(hoVar);
            }
            if ((bhVar.w() & 128) == 0) {
                return;
            }
            bhVar.g(1);
            int iC = bhVar.C();
            int i11 = 3;
            bhVar.g(3);
            bhVar.a(this.f18296a, 2);
            this.f18296a.d(3);
            int i12 = 13;
            cp.this.f18293s = this.f18296a.a(13);
            bhVar.a(this.f18296a, 2);
            int i13 = 4;
            this.f18296a.d(4);
            bhVar.g(this.f18296a.a(12));
            if (cp.this.f18275a == 2 && cp.this.f18291q == null) {
                dp.b bVar = new dp.b(21, null, null, xp.f24377f);
                cp cpVar = cp.this;
                cpVar.f18291q = cpVar.f18280f.a(21, bVar);
                if (cp.this.f18291q != null) {
                    cp.this.f18291q.a(hoVar, cp.this.f18286l, new dp.d(iC, 21, 8192));
                }
            }
            this.f18297b.clear();
            this.f18298c.clear();
            int iA = bhVar.a();
            while (iA > 0) {
                bhVar.a(this.f18296a, 5);
                int iA2 = this.f18296a.a(8);
                this.f18296a.d(i11);
                int iA3 = this.f18296a.a(i12);
                this.f18296a.d(i13);
                int iA4 = this.f18296a.a(12);
                dp.b bVarA = a(bhVar, iA4);
                if (iA2 == 6 || iA2 == 5) {
                    iA2 = bVarA.f18486a;
                }
                iA -= iA4 + 5;
                int i14 = cp.this.f18275a == 2 ? iA2 : iA3;
                if (!cp.this.f18282h.get(i14)) {
                    dp dpVarA = (cp.this.f18275a == 2 && iA2 == 21) ? cp.this.f18291q : cp.this.f18280f.a(iA2, bVarA);
                    if (cp.this.f18275a != 2 || iA3 < this.f18298c.get(i14, 8192)) {
                        this.f18298c.put(i14, iA3);
                        this.f18297b.put(i14, dpVarA);
                    }
                }
                i11 = 3;
                i13 = 4;
                i12 = 13;
            }
            int size = this.f18298c.size();
            for (int i15 = 0; i15 < size; i15++) {
                int iKeyAt = this.f18298c.keyAt(i15);
                int iValueAt = this.f18298c.valueAt(i15);
                cp.this.f18282h.put(iKeyAt, true);
                cp.this.f18283i.put(iValueAt, true);
                dp dpVar = (dp) this.f18297b.valueAt(i15);
                if (dpVar != null) {
                    if (dpVar != cp.this.f18291q) {
                        dpVar.a(hoVar, cp.this.f18286l, new dp.d(iC, iKeyAt, 8192));
                    }
                    cp.this.f18281g.put(iValueAt, dpVar);
                }
            }
            if (cp.this.f18275a == 2) {
                if (cp.this.f18288n) {
                    return;
                }
                cp.this.f18286l.c();
                cp.this.f18287m = 0;
                cp.this.f18288n = true;
                return;
            }
            cp.this.f18281g.remove(this.f18299d);
            cp cpVar2 = cp.this;
            cpVar2.f18287m = cpVar2.f18275a == 1 ? 0 : cp.this.f18287m - 1;
            if (cp.this.f18287m == 0) {
                cp.this.f18286l.c();
                cp.this.f18288n = true;
            }
        }

        @Override // com.applovin.impl.gj
        public void a(ho hoVar, m8 m8Var, dp.d dVar) {
        }
    }

    public cp() {
        this(0);
    }

    public cp(int i11) {
        this(1, i11, 112800);
    }

    public cp(int i11, int i12, int i13) {
        this(i11, new ho(0L), new n6(i12), i13);
    }

    public cp(int i11, ho hoVar, dp.c cVar, int i12) {
        this.f18280f = (dp.c) b1.a(cVar);
        this.f18276b = i12;
        this.f18275a = i11;
        if (i11 == 1 || i11 == 2) {
            this.f18277c = Collections.singletonList(hoVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f18277c = arrayList;
            arrayList.add(hoVar);
        }
        this.f18278d = new bh(new byte[9400], 0);
        this.f18282h = new SparseBooleanArray();
        this.f18283i = new SparseBooleanArray();
        this.f18281g = new SparseArray();
        this.f18279e = new SparseIntArray();
        this.f18284j = new bp(i12);
        this.f18286l = m8.f20630e;
        this.f18293s = -1;
        d();
    }

    private void a(long j11) {
        if (this.f18289o) {
            return;
        }
        this.f18289o = true;
        if (this.f18284j.a() == C.TIME_UNSET) {
            this.f18286l.a(new ij.b(this.f18284j.a()));
            return;
        }
        ap apVar = new ap(this.f18284j.b(), this.f18284j.a(), j11, this.f18293s, this.f18276b);
        this.f18285k = apVar;
        this.f18286l.a(apVar.a());
    }

    private boolean a(int i11) {
        return this.f18275a == 2 || this.f18288n || !this.f18283i.get(i11, false);
    }

    private int b() throws dh {
        int iD = this.f18278d.d();
        int iE = this.f18278d.e();
        int iA = ep.a(this.f18278d.c(), iD, iE);
        this.f18278d.f(iA);
        int i11 = iA + 188;
        if (i11 > iE) {
            int i12 = this.f18292r + (iA - iD);
            this.f18292r = i12;
            if (this.f18275a == 2 && i12 > 376) {
                throw dh.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f18292r = 0;
        }
        return i11;
    }

    private boolean b(l8 l8Var) {
        byte[] bArrC = this.f18278d.c();
        if (9400 - this.f18278d.d() < 188) {
            int iA = this.f18278d.a();
            if (iA > 0) {
                System.arraycopy(bArrC, this.f18278d.d(), bArrC, 0, iA);
            }
            this.f18278d.a(bArrC, iA);
        }
        while (this.f18278d.a() < 188) {
            int iE = this.f18278d.e();
            int iA2 = l8Var.a(bArrC, iE, 9400 - iE);
            if (iA2 == -1) {
                return false;
            }
            this.f18278d.e(iE + iA2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] c() {
        return new k8[]{new cp()};
    }

    public static /* synthetic */ int d(cp cpVar) {
        int i11 = cpVar.f18287m;
        cpVar.f18287m = i11 + 1;
        return i11;
    }

    private void d() {
        this.f18282h.clear();
        this.f18281g.clear();
        SparseArray sparseArrayA = this.f18280f.a();
        int size = sparseArrayA.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f18281g.put(sparseArrayA.keyAt(i11), (dp) sparseArrayA.valueAt(i11));
        }
        this.f18281g.put(0, new hj(new a()));
        this.f18291q = null;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        long jA = l8Var.a();
        if (this.f18288n) {
            if (jA != -1 && this.f18275a != 2 && !this.f18284j.c()) {
                return this.f18284j.a(l8Var, thVar, this.f18293s);
            }
            a(jA);
            if (this.f18290p) {
                this.f18290p = false;
                a(0L, 0L);
                if (l8Var.f() != 0) {
                    thVar.f23379a = 0L;
                    return 1;
                }
            }
            ap apVar = this.f18285k;
            if (apVar != null && apVar.b()) {
                return this.f18285k.a(l8Var, thVar);
            }
        }
        if (!b(l8Var)) {
            return -1;
        }
        int iB = b();
        int iE = this.f18278d.e();
        if (iB > iE) {
            return 0;
        }
        int iJ = this.f18278d.j();
        if ((8388608 & iJ) != 0) {
            this.f18278d.f(iB);
            return 0;
        }
        int i11 = (4194304 & iJ) != 0 ? 1 : 0;
        int i12 = (2096896 & iJ) >> 8;
        boolean z11 = (iJ & 32) != 0;
        dp dpVar = (iJ & 16) != 0 ? (dp) this.f18281g.get(i12) : null;
        if (dpVar == null) {
            this.f18278d.f(iB);
            return 0;
        }
        if (this.f18275a != 2) {
            int i13 = iJ & 15;
            int i14 = this.f18279e.get(i12, i13 - 1);
            this.f18279e.put(i12, i13);
            if (i14 == i13) {
                this.f18278d.f(iB);
                return 0;
            }
            if (i13 != ((i14 + 1) & 15)) {
                dpVar.a();
            }
        }
        if (z11) {
            int iW = this.f18278d.w();
            i11 |= (this.f18278d.w() & 64) != 0 ? 2 : 0;
            this.f18278d.g(iW - 1);
        }
        boolean z12 = this.f18288n;
        if (a(i12)) {
            this.f18278d.e(iB);
            dpVar.a(this.f18278d, i11);
            this.f18278d.e(iE);
        }
        if (this.f18275a != 2 && !z12 && this.f18288n && jA != -1) {
            this.f18290p = true;
        }
        this.f18278d.f(iB);
        return 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        ap apVar;
        b1.b(this.f18275a != 2);
        int size = this.f18277c.size();
        for (int i11 = 0; i11 < size; i11++) {
            ho hoVar = (ho) this.f18277c.get(i11);
            boolean z11 = hoVar.c() == C.TIME_UNSET;
            if (!z11) {
                long jA = hoVar.a();
                if (jA != C.TIME_UNSET && jA != 0 && jA != j12) {
                    hoVar.d(j12);
                }
            } else if (z11) {
                hoVar.d(j12);
            }
        }
        if (j12 != 0 && (apVar = this.f18285k) != null) {
            apVar.b(j12);
        }
        this.f18278d.d(0);
        this.f18279e.clear();
        for (int i12 = 0; i12 < this.f18281g.size(); i12++) {
            ((dp) this.f18281g.valueAt(i12)).a();
        }
        this.f18292r = 0;
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f18286l = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        byte[] bArrC = this.f18278d.c();
        l8Var.c(bArrC, 0, 940);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= 5) {
                    l8Var.a(i11);
                    return true;
                }
                if (bArrC[(i12 * 188) + i11] != 71) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }
}

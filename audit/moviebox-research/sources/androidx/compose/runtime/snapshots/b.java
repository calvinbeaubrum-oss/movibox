package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.u0;
import androidx.compose.runtime.o1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public class b extends j {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f3642p = new a(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f3643q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f3644r = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Object, Unit> f3645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<Object, Unit> f3646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MutableScatterSet<c0> f3648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<? extends c0> f3649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SnapshotIdSet f3650l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f3651m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3653o;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(int i11, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function2) {
        super(i11, snapshotIdSet, null);
        this.f3645g = function1;
        this.f3646h = function2;
        this.f3650l = SnapshotIdSet.f3596f.a();
        this.f3651m = f3644r;
        this.f3652n = 1;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0076 A[LOOP:0: B:7:0x001e->B:24:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0079 A[EDGE_INSN: B:28:0x0079->B:25:0x0079 BREAK  A[LOOP:0: B:7:0x001e->B:24:0x0076], SYNTHETIC] */
    public final void A() {
        MutableScatterSet<c0> mutableScatterSetE = E();
        if (mutableScatterSetE != null) {
            R();
            P(null);
            int iF = f();
            Object[] objArr = mutableScatterSetE.f1898b;
            long[] jArr = mutableScatterSetE.f1897a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i11 != length) {
                            break;
                            break;
                        }
                        i11++;
                    } else {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                for (e0 firstStateRecord = ((c0) objArr[(i11 << 3) + i13]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.e()) {
                                    if (firstStateRecord.f() == iF || CollectionsKt___CollectionsKt.X(this.f3650l, Integer.valueOf(firstStateRecord.f()))) {
                                        firstStateRecord.h(0);
                                    }
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        } else if (i11 != length) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
            }
        }
        b();
    }

    public final void B() {
        J(f());
        Unit unit = Unit.f68710a;
        if (D() || e()) {
            return;
        }
        int iF = f();
        synchronized (SnapshotKt.I()) {
            int i11 = SnapshotKt.f3606e;
            SnapshotKt.f3606e = i11 + 1;
            u(i11);
            SnapshotKt.f3605d = SnapshotKt.f3605d.w(f());
        }
        v(SnapshotKt.z(g(), iF + 1, f()));
    }

    /* JADX WARN: Code duplicated, block: B:59:0x014a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x014c A[Catch: all -> 0x0141, LOOP:2: B:48:0x0117->B:60:0x014c, LOOP_END, TryCatch #0 {all -> 0x0141, blocks: (B:43:0x00fb, B:45:0x010d, B:48:0x0117, B:50:0x0123, B:52:0x012d, B:54:0x0135, B:57:0x0144, B:60:0x014c, B:62:0x0154, B:65:0x015e, B:67:0x0168, B:69:0x0172, B:71:0x017a, B:72:0x0185, B:78:0x0192, B:79:0x0195, B:81:0x0199, B:83:0x01a0, B:84:0x01ac), top: B:92:0x00fb }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0152 A[EDGE_INSN: B:99:0x0152->B:61:0x0152 BREAK  A[LOOP:2: B:48:0x0117->B:60:0x014c], SYNTHETIC] */
    public k C() {
        MutableScatterSet<c0> mutableScatterSetE;
        MutableScatterSet<c0> mutableScatterSetE2 = E();
        Map<e0, ? extends e0> mapR = mutableScatterSetE2 != null ? SnapshotKt.R((b) SnapshotKt.f3611j.get(), this, SnapshotKt.f3605d.r(((GlobalSnapshot) SnapshotKt.f3611j.get()).f())) : null;
        List listL = kotlin.collections.g.l();
        synchronized (SnapshotKt.I()) {
            try {
                SnapshotKt.g0(this);
                if (mutableScatterSetE2 == null || mutableScatterSetE2.c() == 0) {
                    c();
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) SnapshotKt.f3611j.get();
                    SnapshotKt.a0(globalSnapshot, SnapshotKt.f3602a);
                    mutableScatterSetE = globalSnapshot.E();
                    if (mutableScatterSetE == null || !mutableScatterSetE.e()) {
                        mutableScatterSetE = null;
                    } else {
                        listL = SnapshotKt.f3609h;
                    }
                } else {
                    GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) SnapshotKt.f3611j.get();
                    k kVarI = I(SnapshotKt.f3606e, mapR, SnapshotKt.f3605d.r(globalSnapshot2.f()));
                    if (!Intrinsics.b(kVarI, k.b.f3691a)) {
                        return kVarI;
                    }
                    c();
                    SnapshotKt.a0(globalSnapshot2, SnapshotKt.f3602a);
                    mutableScatterSetE = globalSnapshot2.E();
                    P(null);
                    globalSnapshot2.P(null);
                    listL = SnapshotKt.f3609h;
                }
                Unit unit = Unit.f68710a;
                this.f3653o = true;
                if (mutableScatterSetE != null) {
                    Set setA = androidx.compose.runtime.collection.d.a(mutableScatterSetE);
                    if (true ^ setA.isEmpty()) {
                        int size = listL.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            ((Function2) listL.get(i11)).invoke(setA, this);
                        }
                    }
                }
                if (mutableScatterSetE2 != null && mutableScatterSetE2.e()) {
                    Set setA2 = androidx.compose.runtime.collection.d.a(mutableScatterSetE2);
                    int size2 = listL.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        ((Function2) listL.get(i12)).invoke(setA2, this);
                    }
                }
                synchronized (SnapshotKt.I()) {
                    try {
                        r();
                        SnapshotKt.C();
                        if (mutableScatterSetE != null) {
                            Object[] objArr = mutableScatterSetE.f1898b;
                            long[] jArr = mutableScatterSetE.f1897a;
                            int length = jArr.length - 2;
                            if (length >= 0) {
                                int i13 = 0;
                                while (true) {
                                    long j11 = jArr[i13];
                                    long[] jArr2 = jArr;
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i13 != length) {
                                            break;
                                            break;
                                        }
                                        i13++;
                                        jArr = jArr2;
                                    } else {
                                        int i14 = 8 - ((~(i13 - length)) >>> 31);
                                        for (int i15 = 0; i15 < i14; i15++) {
                                            if ((j11 & 255) < 128) {
                                                SnapshotKt.U((c0) objArr[(i13 << 3) + i15]);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i14 != 8) {
                                            break;
                                        }
                                        if (i13 != length) {
                                            break;
                                        }
                                        i13++;
                                        jArr = jArr2;
                                    }
                                }
                            }
                        }
                        if (mutableScatterSetE2 != null) {
                            Object[] objArr2 = mutableScatterSetE2.f1898b;
                            long[] jArr3 = mutableScatterSetE2.f1897a;
                            int length2 = jArr3.length - 2;
                            if (length2 >= 0) {
                                int i16 = 0;
                                while (true) {
                                    long j12 = jArr3[i16];
                                    if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                        for (int i18 = 0; i18 < i17; i18++) {
                                            if ((j12 & 255) < 128) {
                                                SnapshotKt.U((c0) objArr2[(i16 << 3) + i18]);
                                            }
                                            j12 >>= 8;
                                        }
                                        if (i17 != 8) {
                                            break;
                                        }
                                    }
                                    if (i16 == length2) {
                                        break;
                                    }
                                    i16++;
                                }
                            }
                        }
                        List<? extends c0> list = this.f3649k;
                        if (list != null) {
                            int size3 = list.size();
                            for (int i19 = 0; i19 < size3; i19++) {
                                SnapshotKt.U(list.get(i19));
                            }
                        }
                        this.f3649k = null;
                        Unit unit2 = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return k.b.f3691a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final boolean D() {
        return this.f3653o;
    }

    public MutableScatterSet<c0> E() {
        return this.f3648j;
    }

    public final SnapshotIdSet F() {
        return this.f3650l;
    }

    public final int[] G() {
        return this.f3651m;
    }

    @Override // androidx.compose.runtime.snapshots.j
    /* JADX INFO: renamed from: H */
    public Function1<Object, Unit> h() {
        return this.f3645g;
    }

    public final k I(int i11, Map<e0, ? extends e0> map, SnapshotIdSet snapshotIdSet) {
        MutableScatterSet<c0> mutableScatterSet;
        List<? extends c0> listX0;
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3;
        MutableScatterSet<c0> mutableScatterSet2;
        Object[] objArr2;
        long[] jArr2;
        e0 e0VarW;
        e0 e0VarMergeRecords;
        SnapshotIdSet snapshotIdSetV = g().w(f()).v(this.f3650l);
        MutableScatterSet<c0> mutableScatterSetE = E();
        Intrinsics.d(mutableScatterSetE);
        Object[] objArr3 = mutableScatterSetE.f1898b;
        long[] jArr3 = mutableScatterSetE.f1897a;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        if (length >= 0) {
            listX0 = null;
            int i12 = 0;
            while (true) {
                long j11 = jArr3[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j11 & 255) < 128) {
                            c0 c0Var = (c0) objArr3[(i12 << 3) + i14];
                            e0 firstStateRecord = c0Var.getFirstStateRecord();
                            mutableScatterSet2 = mutableScatterSetE;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            e0 e0VarW2 = SnapshotKt.W(firstStateRecord, i11, snapshotIdSet);
                            if (e0VarW2 == null || (e0VarW = SnapshotKt.W(firstStateRecord, f(), snapshotIdSetV)) == null) {
                                snapshotIdSet3 = snapshotIdSetV;
                            } else {
                                snapshotIdSet3 = snapshotIdSetV;
                                if (e0VarW.f() != 1 && !Intrinsics.b(e0VarW2, e0VarW)) {
                                    e0 e0VarW3 = SnapshotKt.W(firstStateRecord, f(), g());
                                    if (e0VarW3 == null) {
                                        SnapshotKt.V();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (map == null || (e0VarMergeRecords = map.get(e0VarW2)) == null) {
                                        e0VarMergeRecords = c0Var.mergeRecords(e0VarW, e0VarW2, e0VarW3);
                                    }
                                    if (e0VarMergeRecords == null) {
                                        return new k.a(this);
                                    }
                                    if (!Intrinsics.b(e0VarMergeRecords, e0VarW3)) {
                                        if (Intrinsics.b(e0VarMergeRecords, e0VarW2)) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(TuplesKt.a(c0Var, e0VarW2.d()));
                                            if (listX0 == null) {
                                                listX0 = new ArrayList<>();
                                            }
                                            listX0.add(c0Var);
                                        } else {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(!Intrinsics.b(e0VarMergeRecords, e0VarW) ? TuplesKt.a(c0Var, e0VarMergeRecords) : TuplesKt.a(c0Var, e0VarW.d()));
                                        }
                                    }
                                }
                            }
                        } else {
                            snapshotIdSet3 = snapshotIdSetV;
                            mutableScatterSet2 = mutableScatterSetE;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                        }
                        j11 >>= 8;
                        i14++;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        mutableScatterSetE = mutableScatterSet2;
                        snapshotIdSetV = snapshotIdSet3;
                    }
                    snapshotIdSet2 = snapshotIdSetV;
                    mutableScatterSet = mutableScatterSetE;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i13 != 8) {
                        break;
                    }
                } else {
                    snapshotIdSet2 = snapshotIdSetV;
                    mutableScatterSet = mutableScatterSetE;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i12 == length) {
                    break;
                }
                i12++;
                objArr3 = objArr;
                jArr3 = jArr;
                mutableScatterSetE = mutableScatterSet;
                snapshotIdSetV = snapshotIdSet2;
            }
        } else {
            mutableScatterSet = mutableScatterSetE;
            listX0 = null;
        }
        if (arrayList != null) {
            B();
            int size = arrayList.size();
            for (int i15 = 0; i15 < size; i15++) {
                Pair pair = (Pair) arrayList.get(i15);
                c0 c0Var2 = (c0) pair.component1();
                e0 e0Var = (e0) pair.component2();
                e0Var.h(f());
                synchronized (SnapshotKt.I()) {
                    e0Var.g(c0Var2.getFirstStateRecord());
                    c0Var2.prependStateRecord(e0Var);
                    Unit unit = Unit.f68710a;
                }
            }
        }
        if (listX0 != null) {
            int size2 = listX0.size();
            for (int i16 = 0; i16 < size2; i16++) {
                mutableScatterSet.x(listX0.get(i16));
            }
            List<? extends c0> list = this.f3649k;
            if (list != null) {
                listX0 = CollectionsKt___CollectionsKt.x0(list, listX0);
            }
            this.f3649k = listX0;
        }
        return k.b.f3691a;
    }

    public final void J(int i11) {
        synchronized (SnapshotKt.I()) {
            this.f3650l = this.f3650l.w(i11);
            Unit unit = Unit.f68710a;
        }
    }

    public final void K(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.I()) {
            this.f3650l = this.f3650l.v(snapshotIdSet);
            Unit unit = Unit.f68710a;
        }
    }

    public final void L(int i11) {
        if (i11 >= 0) {
            this.f3651m = ArraysKt___ArraysJvmKt.y(this.f3651m, i11);
        }
    }

    public final void M(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.f3651m;
        if (iArr2.length != 0) {
            iArr = ArraysKt___ArraysJvmKt.z(iArr2, iArr);
        }
        this.f3651m = iArr;
    }

    public final void N() {
        int length = this.f3651m.length;
        for (int i11 = 0; i11 < length; i11++) {
            SnapshotKt.Y(this.f3651m[i11]);
        }
    }

    public final void O(boolean z11) {
        this.f3653o = z11;
    }

    public void P(MutableScatterSet<c0> mutableScatterSet) {
        this.f3648j = mutableScatterSet;
    }

    public b Q(Function1<Object, Unit> function1, Function1<Object, Unit> function2) {
        c cVar;
        z();
        S();
        J(f());
        synchronized (SnapshotKt.I()) {
            int i11 = SnapshotKt.f3606e;
            SnapshotKt.f3606e = i11 + 1;
            SnapshotKt.f3605d = SnapshotKt.f3605d.w(i11);
            SnapshotIdSet snapshotIdSetG = g();
            v(snapshotIdSetG.w(i11));
            cVar = new c(i11, SnapshotKt.z(snapshotIdSetG, f() + 1, i11), SnapshotKt.L(function1, h(), false, 4, null), SnapshotKt.M(function2, k()), this);
        }
        if (!D() && !e()) {
            int iF = f();
            synchronized (SnapshotKt.I()) {
                int i12 = SnapshotKt.f3606e;
                SnapshotKt.f3606e = i12 + 1;
                u(i12);
                SnapshotKt.f3605d = SnapshotKt.f3605d.w(f());
                Unit unit = Unit.f68710a;
            }
            v(SnapshotKt.z(g(), iF + 1, f()));
        }
        return cVar;
    }

    public final void R() {
        if (!this.f3653o) {
            return;
        }
        o1.b("Unsupported operation on a snapshot that has been applied");
    }

    public final void S() {
        if (!this.f3653o || this.f3689d >= 0) {
            return;
        }
        o1.b("Unsupported operation on a disposed or applied snapshot");
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void c() {
        SnapshotKt.f3605d = SnapshotKt.f3605d.r(f()).j(this.f3650l);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        n(this);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public boolean i() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public int j() {
        return this.f3647i;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public Function1<Object, Unit> k() {
        return this.f3646h;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void m(j jVar) {
        this.f3652n++;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void n(j jVar) {
        if (!(this.f3652n > 0)) {
            o1.a("no pending nested snapshots");
        }
        int i11 = this.f3652n - 1;
        this.f3652n = i11;
        if (i11 != 0 || this.f3653o) {
            return;
        }
        A();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void o() {
        if (this.f3653o || e()) {
            return;
        }
        B();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void p(c0 c0Var) {
        MutableScatterSet<c0> mutableScatterSetE = E();
        if (mutableScatterSetE == null) {
            mutableScatterSetE = u0.a();
            P(mutableScatterSetE);
        }
        mutableScatterSetE.h(c0Var);
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void r() {
        N();
        super.r();
    }

    @Override // androidx.compose.runtime.snapshots.j
    public void w(int i11) {
        this.f3647i = i11;
    }

    @Override // androidx.compose.runtime.snapshots.j
    public j x(Function1<Object, Unit> function1) {
        d dVar;
        z();
        S();
        int iF = f();
        J(f());
        synchronized (SnapshotKt.I()) {
            int i11 = SnapshotKt.f3606e;
            SnapshotKt.f3606e = i11 + 1;
            SnapshotKt.f3605d = SnapshotKt.f3605d.w(i11);
            dVar = new d(i11, SnapshotKt.z(g(), iF + 1, i11), SnapshotKt.L(function1, h(), false, 4, null), this);
        }
        if (!D() && !e()) {
            int iF2 = f();
            synchronized (SnapshotKt.I()) {
                int i12 = SnapshotKt.f3606e;
                SnapshotKt.f3606e = i12 + 1;
                u(i12);
                SnapshotKt.f3605d = SnapshotKt.f3605d.w(f());
                Unit unit = Unit.f68710a;
            }
            v(SnapshotKt.z(g(), iF2 + 1, f()));
        }
        return dVar;
    }
}

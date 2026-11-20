package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.h3;
import androidx.compose.runtime.v2;
import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SnapshotKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1<SnapshotIdSet, Unit> f3602a = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SnapshotIdSet snapshotIdSet) {
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v2<j> f3603b = new v2<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f3604c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static SnapshotIdSet f3605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f3606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f3607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v<c0> f3608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static List<? extends Function2<? super Set<? extends Object>, ? super j, Unit>> f3609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static List<? extends Function1<Object, Unit>> f3610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicReference<GlobalSnapshot> f3611j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f3612k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static AtomicInt f3613l;

    static {
        SnapshotIdSet.a aVar = SnapshotIdSet.f3596f;
        f3605d = aVar.a();
        f3606e = 2;
        f3607f = new l();
        f3608g = new v<>();
        f3609h = kotlin.collections.g.l();
        f3610i = kotlin.collections.g.l();
        int i11 = f3606e;
        f3606e = i11 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i11, aVar.a());
        f3605d = f3605d.w(globalSnapshot.f());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        f3611j = atomicReference;
        f3612k = atomicReference.get();
        f3613l = new AtomicInt(0);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa A[Catch: all -> 0x00a0, LOOP:1: B:30:0x0070->B:42:0x00aa, LOOP_END, TryCatch #0 {all -> 0x00a0, blocks: (B:25:0x0061, B:27:0x0066, B:30:0x0070, B:32:0x0080, B:34:0x008c, B:36:0x0095, B:39:0x00a2, B:42:0x00aa, B:43:0x00ad), top: B:50:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad A[EDGE_INSN: B:58:0x00ad->B:43:0x00ad BREAK  A[LOOP:1: B:30:0x0070->B:42:0x00aa], SYNTHETIC] */
    public static final <T> T A(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        MutableScatterSet<c0> mutableScatterSetE;
        T t11;
        j jVar = f3612k;
        Intrinsics.e(jVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (I()) {
            try {
                globalSnapshot = f3611j.get();
                mutableScatterSetE = globalSnapshot.E();
                if (mutableScatterSetE != null) {
                    f3613l.add(1);
                }
                t11 = (T) a0(globalSnapshot, function1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (mutableScatterSetE != null) {
            try {
                List<? extends Function2<? super Set<? extends Object>, ? super j, Unit>> list = f3609h;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    list.get(i11).invoke(androidx.compose.runtime.collection.d.a(mutableScatterSetE), globalSnapshot);
                }
                f3613l.add(-1);
            } catch (Throwable th3) {
                f3613l.add(-1);
                throw th3;
            }
        }
        synchronized (I()) {
            try {
                C();
                if (mutableScatterSetE != null) {
                    Object[] objArr = mutableScatterSetE.f1898b;
                    long[] jArr = mutableScatterSetE.f1897a;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i12 = 0;
                        while (true) {
                            long j11 = jArr[i12];
                            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                if (i12 != length) {
                                    break;
                                    break;
                                }
                                i12++;
                            } else {
                                int i13 = 8 - ((~(i12 - length)) >>> 31);
                                for (int i14 = 0; i14 < i13; i14++) {
                                    if ((255 & j11) < 128) {
                                        U((c0) objArr[(i12 << 3) + i14]);
                                    }
                                    j11 >>= 8;
                                }
                                if (i13 != 8) {
                                    break;
                                }
                                if (i12 != length) {
                                    break;
                                }
                                i12++;
                            }
                        }
                    }
                    Unit unit = Unit.f68710a;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        return t11;
    }

    public static final void B() {
        A(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
                invoke2(snapshotIdSet);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SnapshotIdSet snapshotIdSet) {
            }
        });
    }

    public static final void C() {
        v<c0> vVar = f3608g;
        int iE = vVar.e();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= iE) {
                break;
            }
            h3<c0> h3Var = vVar.f()[i11];
            c0 c0Var = h3Var != null ? h3Var.get() : null;
            if (c0Var != null && !(!T(c0Var))) {
                if (i12 != i11) {
                    vVar.f()[i12] = h3Var;
                    vVar.d()[i12] = vVar.d()[i11];
                }
                i12++;
            }
            i11++;
        }
        for (int i13 = i12; i13 < iE; i13++) {
            vVar.f()[i13] = null;
            vVar.d()[i13] = 0;
        }
        if (i12 != iE) {
            vVar.g(i12);
        }
    }

    public static final j D(j jVar, Function1<Object, Unit> function1, boolean z11) {
        boolean z12 = jVar instanceof b;
        if (z12 || jVar == null) {
            return new g0(z12 ? (b) jVar : null, function1, null, false, z11);
        }
        return new h0(jVar, function1, false, z11);
    }

    public static /* synthetic */ j E(j jVar, Function1 function1, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return D(jVar, function1, z11);
    }

    @PublishedApi
    public static final <T extends e0> T F(T t11) {
        T t12;
        j.a aVar = j.f3684e;
        j jVarC = aVar.c();
        T t13 = (T) W(t11, jVarC.f(), jVarC.g());
        if (t13 != null) {
            return t13;
        }
        synchronized (I()) {
            j jVarC2 = aVar.c();
            t12 = (T) W(t11, jVarC2.f(), jVarC2.g());
        }
        if (t12 != null) {
            return t12;
        }
        V();
        throw new KotlinNothingValueException();
    }

    @PublishedApi
    public static final <T extends e0> T G(T t11, j jVar) {
        T t12 = (T) W(t11, jVar.f(), jVar.g());
        if (t12 != null) {
            return t12;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final j H() {
        j jVarA = f3603b.a();
        return jVarA == null ? f3611j.get() : jVarA;
    }

    public static final Object I() {
        return f3604c;
    }

    public static final j J() {
        return f3612k;
    }

    public static final Function1<Object, Unit> K(final Function1<Object, Unit> function1, final Function1<Object, Unit> function2, boolean z11) {
        if (!z11) {
            function2 = null;
        }
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                function1.invoke(obj);
                function2.invoke(obj);
            }
        };
    }

    public static /* synthetic */ Function1 L(Function1 function1, Function1 function2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return K(function1, function2, z11);
    }

    public static final Function1<Object, Unit> M(final Function1<Object, Unit> function1, final Function1<Object, Unit> function2) {
        if (function1 == null || function2 == null || function1 == function2) {
            return function1 == null ? function2 : function1;
        }
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                function1.invoke(obj);
                function2.invoke(obj);
            }
        };
    }

    public static final <T extends e0> T N(T t11, c0 c0Var) {
        T t12 = (T) d0(c0Var);
        if (t12 != null) {
            t12.h(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return t12;
        }
        T t13 = (T) t11.d();
        t13.h(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        t13.g(c0Var.getFirstStateRecord());
        Intrinsics.e(t13, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        c0Var.prependStateRecord(t13);
        Intrinsics.e(t13, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t13;
    }

    public static final <T extends e0> T O(T t11, c0 c0Var, j jVar) {
        T t12;
        synchronized (I()) {
            t12 = (T) P(t11, c0Var, jVar);
        }
        return t12;
    }

    public static final <T extends e0> T P(T t11, c0 c0Var, j jVar) {
        T t12 = (T) N(t11, c0Var);
        t12.c(t11);
        t12.h(jVar.f());
        return t12;
    }

    @PublishedApi
    public static final void Q(j jVar, c0 c0Var) {
        jVar.w(jVar.j() + 1);
        Function1<Object, Unit> function1K = jVar.k();
        if (function1K != null) {
            function1K.invoke(c0Var);
        }
    }

    public static final Map<e0, e0> R(b bVar, b bVar2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i11;
        HashMap map;
        HashMap map2;
        e0 e0VarW;
        MutableScatterSet<c0> mutableScatterSetE = bVar2.E();
        int iF = bVar.f();
        HashMap map3 = null;
        if (mutableScatterSetE == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetV = bVar2.g().w(bVar2.f()).v(bVar2.F());
        Object[] objArr = mutableScatterSetE.f1898b;
        long[] jArr2 = mutableScatterSetE.f1897a;
        int length = jArr2.length - 2;
        if (length >= 0) {
            HashMap map4 = null;
            int i12 = 0;
            while (true) {
                long j11 = jArr2[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((255 & j11) < 128) {
                            c0 c0Var = (c0) objArr[(i12 << 3) + i14];
                            e0 firstStateRecord = c0Var.getFirstStateRecord();
                            e0 e0VarW2 = W(firstStateRecord, iF, snapshotIdSet);
                            if (e0VarW2 != null && (e0VarW = W(firstStateRecord, iF, snapshotIdSetV)) != null && !Intrinsics.b(e0VarW2, e0VarW)) {
                                e0 e0VarW3 = W(firstStateRecord, bVar2.f(), bVar2.g());
                                if (e0VarW3 == null) {
                                    V();
                                    throw new KotlinNothingValueException();
                                }
                                e0 e0VarMergeRecords = c0Var.mergeRecords(e0VarW, e0VarW2, e0VarW3);
                                if (e0VarMergeRecords == null) {
                                    return null;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(e0VarW2, e0VarMergeRecords);
                                map4 = map4;
                            }
                            map2 = null;
                        } else {
                            jArr2 = jArr2;
                            iF = iF;
                            map2 = map3;
                        }
                        j11 >>= 8;
                        i14++;
                        map3 = map2;
                        jArr2 = jArr2;
                        iF = iF;
                    }
                    jArr = jArr2;
                    i11 = iF;
                    map = map3;
                    if (i13 != 8) {
                        return map4;
                    }
                } else {
                    jArr = jArr2;
                    i11 = iF;
                    map = map3;
                }
                if (i12 != length) {
                    i12++;
                    map3 = map;
                    jArr2 = jArr;
                    iF = i11;
                } else {
                    map3 = map4;
                }
            }
        }
        return map3;
    }

    public static final <T extends e0> T S(T t11, c0 c0Var, j jVar, T t12) {
        T t13;
        if (jVar.i()) {
            jVar.p(c0Var);
        }
        int iF = jVar.f();
        if (t12.f() == iF) {
            return t12;
        }
        synchronized (I()) {
            t13 = (T) N(t11, c0Var);
        }
        t13.h(iF);
        if (t12.f() != 1) {
            jVar.p(c0Var);
        }
        return t13;
    }

    public static final boolean T(c0 c0Var) {
        e0 e0Var;
        int iE = f3607f.e(f3606e);
        e0 e0Var2 = null;
        e0 firstStateRecord = null;
        int i11 = 0;
        for (e0 firstStateRecord2 = c0Var.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.e()) {
            int iF = firstStateRecord2.f();
            if (iF != 0) {
                if (iF >= iE) {
                    i11++;
                } else if (e0Var2 == null) {
                    i11++;
                    e0Var2 = firstStateRecord2;
                } else {
                    if (firstStateRecord2.f() < e0Var2.f()) {
                        e0Var = e0Var2;
                        e0Var2 = firstStateRecord2;
                    } else {
                        e0Var = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = c0Var.getFirstStateRecord();
                        e0 e0Var3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = e0Var3;
                                break;
                            }
                            if (firstStateRecord.f() >= iE) {
                                break;
                            }
                            if (e0Var3.f() < firstStateRecord.f()) {
                                e0Var3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.e();
                        }
                    }
                    e0Var2.h(0);
                    e0Var2.c(firstStateRecord);
                    e0Var2 = e0Var;
                }
            }
        }
        return i11 > 1;
    }

    public static final void U(c0 c0Var) {
        if (T(c0Var)) {
            f3608g.a(c0Var);
        }
    }

    public static final Void V() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    public static final <T extends e0> T W(T t11, int i11, SnapshotIdSet snapshotIdSet) {
        T t12 = null;
        while (t11 != null) {
            if (f0(t11, i11, snapshotIdSet) && (t12 == null || t12.f() < t11.f())) {
                t12 = t11;
            }
            t11 = (T) t11.e();
        }
        if (t12 != null) {
            return t12;
        }
        return null;
    }

    public static final <T extends e0> T X(T t11, c0 c0Var) {
        T t12;
        j.a aVar = j.f3684e;
        j jVarC = aVar.c();
        Function1<Object, Unit> function1H = jVarC.h();
        if (function1H != null) {
            function1H.invoke(c0Var);
        }
        T t13 = (T) W(t11, jVarC.f(), jVarC.g());
        if (t13 != null) {
            return t13;
        }
        synchronized (I()) {
            j jVarC2 = aVar.c();
            e0 firstStateRecord = c0Var.getFirstStateRecord();
            Intrinsics.e(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t12 = (T) W(firstStateRecord, jVarC2.f(), jVarC2.g());
            if (t12 == null) {
                V();
                throw new KotlinNothingValueException();
            }
        }
        return t12;
    }

    public static final void Y(int i11) {
        f3607f.f(i11);
    }

    public static final Void Z() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T> T a0(j jVar, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T tInvoke = function1.invoke(f3605d.r(jVar.f()));
        synchronized (I()) {
            int i11 = f3606e;
            f3606e = i11 + 1;
            f3605d = f3605d.r(jVar.f());
            f3611j.set(new GlobalSnapshot(i11, f3605d));
            jVar.d();
            f3605d = f3605d.w(i11);
            Unit unit = Unit.f68710a;
        }
        return tInvoke;
    }

    public static final <T extends j> T b0(final Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (T) A(new Function1<SnapshotIdSet, T>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final j invoke(SnapshotIdSet snapshotIdSet) {
                j jVar = (j) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.I()) {
                    SnapshotKt.f3605d = SnapshotKt.f3605d.w(jVar.f());
                    Unit unit = Unit.f68710a;
                }
                return jVar;
            }
        });
    }

    public static final int c0(int i11, SnapshotIdSet snapshotIdSet) {
        int iA;
        int iU = snapshotIdSet.u(i11);
        synchronized (I()) {
            iA = f3607f.a(iU);
        }
        return iA;
    }

    public static final e0 d0(c0 c0Var) {
        int iE = f3607f.e(f3606e) - 1;
        SnapshotIdSet snapshotIdSetA = SnapshotIdSet.f3596f.a();
        e0 e0Var = null;
        for (e0 firstStateRecord = c0Var.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.e()) {
            if (firstStateRecord.f() == 0) {
                return firstStateRecord;
            }
            if (f0(firstStateRecord, iE, snapshotIdSetA)) {
                if (e0Var != null) {
                    return firstStateRecord.f() < e0Var.f() ? firstStateRecord : e0Var;
                }
                e0Var = firstStateRecord;
            }
        }
        return null;
    }

    public static final boolean e0(int i11, int i12, SnapshotIdSet snapshotIdSet) {
        return (i12 == 0 || i12 > i11 || snapshotIdSet.s(i12)) ? false : true;
    }

    public static final boolean f0(e0 e0Var, int i11, SnapshotIdSet snapshotIdSet) {
        return e0(i11, e0Var.f(), snapshotIdSet);
    }

    public static final void g0(j jVar) {
        int iE;
        if (f3605d.s(jVar.f())) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Snapshot is not open: id=");
        sb2.append(jVar.f());
        sb2.append(", disposed=");
        sb2.append(jVar.e());
        sb2.append(", applied=");
        b bVar = jVar instanceof b ? (b) jVar : null;
        sb2.append(bVar != null ? Boolean.valueOf(bVar.D()) : "read-only");
        sb2.append(", lowestPin=");
        synchronized (I()) {
            iE = f3607f.e(-1);
        }
        sb2.append(iE);
        throw new IllegalStateException(sb2.toString().toString());
    }

    @PublishedApi
    public static final <T extends e0> T h0(T t11, c0 c0Var, j jVar) {
        T t12;
        if (jVar.i()) {
            jVar.p(c0Var);
        }
        int iF = jVar.f();
        T t13 = (T) W(t11, iF, jVar.g());
        if (t13 == null) {
            V();
            throw new KotlinNothingValueException();
        }
        if (t13.f() == jVar.f()) {
            return t13;
        }
        synchronized (I()) {
            t12 = (T) W(c0Var.getFirstStateRecord(), iF, jVar.g());
            if (t12 == null) {
                V();
                throw new KotlinNothingValueException();
            }
            if (t12.f() != iF) {
                t12 = (T) P(t12, c0Var, jVar);
            }
        }
        Intrinsics.e(t12, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t13.f() != 1) {
            jVar.p(c0Var);
        }
        return t12;
    }

    public static final SnapshotIdSet z(SnapshotIdSet snapshotIdSet, int i11, int i12) {
        while (i11 < i12) {
            snapshotIdSet = snapshotIdSet.w(i11);
            i11++;
        }
        return snapshotIdSet;
    }
}

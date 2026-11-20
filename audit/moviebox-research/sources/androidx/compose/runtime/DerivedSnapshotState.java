package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class DerivedSnapshotState<T> extends androidx.compose.runtime.snapshots.d0 implements z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<T> f3279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2<T> f3280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a<T> f3281c = new a<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T> extends androidx.compose.runtime.snapshots.e0 implements z.a<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0047a f3282h = new C0047a(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3283i = 8;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f3284j = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.collection.n0<androidx.compose.runtime.snapshots.c0> f3287e = androidx.collection.o0.a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f3288f = f3284j;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3289g;

        /* JADX INFO: renamed from: androidx.compose.runtime.DerivedSnapshotState$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0047a {
            public C0047a() {
            }

            public /* synthetic */ C0047a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object a() {
                return a.f3284j;
            }
        }

        @Override // androidx.compose.runtime.z.a
        public T a() {
            return (T) this.f3288f;
        }

        @Override // androidx.compose.runtime.z.a
        public androidx.collection.n0<androidx.compose.runtime.snapshots.c0> b() {
            return this.f3287e;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public void c(androidx.compose.runtime.snapshots.e0 e0Var) {
            Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            a aVar = (a) e0Var;
            m(aVar.b());
            this.f3288f = aVar.f3288f;
            this.f3289g = aVar.f3289g;
        }

        @Override // androidx.compose.runtime.snapshots.e0
        public androidx.compose.runtime.snapshots.e0 d() {
            return new a();
        }

        public final Object j() {
            return this.f3288f;
        }

        public final boolean k(z<?> zVar, androidx.compose.runtime.snapshots.j jVar) {
            boolean z11;
            boolean z12;
            synchronized (SnapshotKt.I()) {
                z11 = true;
                z12 = (this.f3285c == jVar.f() && this.f3286d == jVar.j()) ? false : true;
            }
            if (this.f3288f == f3284j || (z12 && this.f3289g != l(zVar, jVar))) {
                z11 = false;
            }
            if (z11 && z12) {
                synchronized (SnapshotKt.I()) {
                    this.f3285c = jVar.f();
                    this.f3286d = jVar.j();
                    Unit unit = Unit.f68710a;
                }
            }
            return z11;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00a5 A[Catch: all -> 0x007c, LOOP:1: B:16:0x003c->B:38:0x00a5, LOOP_END, TryCatch #1 {all -> 0x007c, blocks: (B:13:0x002f, B:16:0x003c, B:18:0x004c, B:20:0x0058, B:22:0x0062, B:25:0x0071, B:27:0x0075, B:31:0x0086, B:30:0x007e, B:32:0x0094, B:40:0x00aa, B:38:0x00a5), top: B:62:0x002f }] */
        /* JADX WARN: Code duplicated, block: B:66:0x00a1 A[EDGE_INSN: B:66:0x00a1->B:36:0x00a1 BREAK  A[LOOP:1: B:16:0x003c->B:38:0x00a5], SYNTHETIC] */
        public final int l(z<?> zVar, androidx.compose.runtime.snapshots.j jVar) {
            androidx.collection.n0<androidx.compose.runtime.snapshots.c0> n0VarB;
            int i11;
            synchronized (SnapshotKt.I()) {
                n0VarB = b();
            }
            char c11 = 7;
            if (!n0VarB.h()) {
                return 7;
            }
            androidx.compose.runtime.collection.b<a0> bVarA = r2.a();
            int iR = bVarA.r();
            if (iR > 0) {
                a0[] a0VarArrQ = bVarA.q();
                int i12 = 0;
                do {
                    a0VarArrQ[i12].b(zVar);
                    i12++;
                } while (i12 < iR);
            }
            try {
                Object[] objArr = n0VarB.f1957b;
                int[] iArr = n0VarB.f1958c;
                long[] jArr = n0VarB.f1956a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i13 = 0;
                    int iC = 7;
                    while (true) {
                        long j11 = jArr[i13];
                        if ((((~j11) << c11) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i13 != length) {
                                break;
                                break;
                            }
                            i13++;
                            c11 = 7;
                        } else {
                            int i14 = 8 - ((~(i13 - length)) >>> 31);
                            for (int i15 = 0; i15 < i14; i15++) {
                                if ((j11 & 255) < 128) {
                                    int i16 = (i13 << 3) + i15;
                                    androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[i16];
                                    if (iArr[i16] == 1) {
                                        androidx.compose.runtime.snapshots.e0 e0VarA = c0Var instanceof DerivedSnapshotState ? ((DerivedSnapshotState) c0Var).a(jVar) : SnapshotKt.G(c0Var.getFirstStateRecord(), jVar);
                                        iC = (((iC * 31) + b.c(e0VarA)) * 31) + e0VarA.f();
                                    }
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
                            c11 = 7;
                        }
                    }
                    i11 = iC;
                } else {
                    i11 = 7;
                }
                Unit unit = Unit.f68710a;
                int iR2 = bVarA.r();
                if (iR2 <= 0) {
                    return i11;
                }
                a0[] a0VarArrQ2 = bVarA.q();
                int i17 = 0;
                do {
                    a0VarArrQ2[i17].a(zVar);
                    i17++;
                } while (i17 < iR2);
                return i11;
            } catch (Throwable th2) {
                int iR3 = bVarA.r();
                if (iR3 > 0) {
                    a0[] a0VarArrQ3 = bVarA.q();
                    int i18 = 0;
                    do {
                        a0VarArrQ3[i18].a(zVar);
                        i18++;
                    } while (i18 < iR3);
                }
                throw th2;
            }
        }

        public void m(androidx.collection.n0<androidx.compose.runtime.snapshots.c0> n0Var) {
            this.f3287e = n0Var;
        }

        public final void n(Object obj) {
            this.f3288f = obj;
        }

        public final void o(int i11) {
            this.f3289g = i11;
        }

        public final void p(int i11) {
            this.f3285c = i11;
        }

        public final void q(int i11) {
            this.f3286d = i11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedSnapshotState(Function0<? extends T> function0, q2<T> q2Var) {
        this.f3279a = function0;
        this.f3280b = q2Var;
    }

    public final androidx.compose.runtime.snapshots.e0 a(androidx.compose.runtime.snapshots.j jVar) {
        return b((a) SnapshotKt.G(this.f3281c, jVar), jVar, false, this.f3279a);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x00b4 A[EDGE_INSN: B:109:0x00b4->B:32:0x00b4 BREAK  A[LOOP:1: B:18:0x0059->B:31:0x00ad], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ad A[Catch: all -> 0x0046, LOOP:1: B:18:0x0059->B:31:0x00ad, LOOP_END, TryCatch #1 {all -> 0x0046, blocks: (B:10:0x0029, B:12:0x0039, B:15:0x0049, B:18:0x0059, B:20:0x006e, B:22:0x007a, B:24:0x0084, B:26:0x009b, B:27:0x009e, B:31:0x00ad, B:32:0x00b4), top: B:102:0x0029 }] */
    /* JADX WARN: Multi-variable type inference failed */
    public final a<T> b(a<T> aVar, androidx.compose.runtime.snapshots.j jVar, boolean z11, Function0<? extends T> function0) {
        androidx.compose.runtime.snapshots.j.a aVar2;
        q2<T> policy;
        a<T> aVar3 = aVar;
        if (!aVar3.k(this, jVar)) {
            int i11 = 0;
            final androidx.collection.i0 i0Var = new androidx.collection.i0(0, 1, null);
            final androidx.compose.runtime.internal.d dVar = (androidx.compose.runtime.internal.d) s2.f3564a.a();
            if (dVar == null) {
                dVar = new androidx.compose.runtime.internal.d(0);
                s2.f3564a.b(dVar);
            }
            final int iA = dVar.a();
            androidx.compose.runtime.collection.b<a0> bVarA = r2.a();
            int iR = bVarA.r();
            if (iR > 0) {
                a0[] a0VarArrQ = bVarA.q();
                int i12 = 0;
                while (true) {
                    a0VarArrQ[i12].b(this);
                    int i13 = i12 + 1;
                    if (i13 >= iR) {
                        break;
                    }
                    i12 = i13;
                }
            }
            try {
                dVar.b(iA + 1);
                Object objH = androidx.compose.runtime.snapshots.j.f3684e.h(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1
                    final /* synthetic */ DerivedSnapshotState<T> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        if (obj == this.this$0) {
                            throw new IllegalStateException("A derived state calculation cannot read itself".toString());
                        }
                        if (obj instanceof androidx.compose.runtime.snapshots.c0) {
                            int iA2 = dVar.a();
                            androidx.collection.i0<androidx.compose.runtime.snapshots.c0> i0Var2 = i0Var;
                            i0Var2.s(obj, Math.min(iA2 - iA, i0Var2.e(obj, Api.BaseClientBuilder.API_PRIORITY_OTHER)));
                        }
                    }
                }, null, function0);
                dVar.b(iA);
                int iR2 = bVarA.r();
                if (iR2 > 0) {
                    a0[] a0VarArrQ2 = bVarA.q();
                    do {
                        a0VarArrQ2[i11].a(this);
                        i11++;
                    } while (i11 < iR2);
                }
                synchronized (SnapshotKt.I()) {
                    try {
                        aVar2 = androidx.compose.runtime.snapshots.j.f3684e;
                        androidx.compose.runtime.snapshots.j jVarC = aVar2.c();
                        if (aVar.j() == a.f3282h.a() || (policy = getPolicy()) == 0 || !policy.b(objH, aVar.j())) {
                            aVar3 = (a) SnapshotKt.O(this.f3281c, this, jVarC);
                            aVar3.m(i0Var);
                            aVar3.o(aVar3.l(this, jVarC));
                            aVar3.n(objH);
                        } else {
                            aVar3.m(i0Var);
                            aVar3.o(aVar3.l(this, jVarC));
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                androidx.compose.runtime.internal.d dVar2 = (androidx.compose.runtime.internal.d) s2.f3564a.a();
                if (dVar2 != null && dVar2.a() == 0) {
                    aVar2.g();
                    synchronized (SnapshotKt.I()) {
                        androidx.compose.runtime.snapshots.j jVarC2 = aVar2.c();
                        aVar3.p(jVarC2.f());
                        aVar3.q(jVarC2.j());
                        Unit unit = Unit.f68710a;
                    }
                }
                return aVar3;
            } catch (Throwable th3) {
                int iR3 = bVarA.r();
                if (iR3 > 0) {
                    a0[] a0VarArrQ3 = bVarA.q();
                    do {
                        a0VarArrQ3[i11].a(this);
                        i11++;
                    } while (i11 < iR3);
                }
                throw th3;
            }
        }
        if (z11) {
            androidx.compose.runtime.collection.b<a0> bVarA2 = r2.a();
            int iR4 = bVarA2.r();
            if (iR4 > 0) {
                a0[] a0VarArrQ4 = bVarA2.q();
                int i14 = 0;
                do {
                    a0VarArrQ4[i14].b(this);
                    i14++;
                } while (i14 < iR4);
            }
            try {
                androidx.collection.n0<androidx.compose.runtime.snapshots.c0> n0VarB = aVar.b();
                androidx.compose.runtime.internal.d dVar3 = (androidx.compose.runtime.internal.d) s2.f3564a.a();
                if (dVar3 == null) {
                    dVar3 = new androidx.compose.runtime.internal.d(0);
                    s2.f3564a.b(dVar3);
                }
                int iA2 = dVar3.a();
                Object[] objArr = n0VarB.f1957b;
                int[] iArr = n0VarB.f1958c;
                long[] jArr = n0VarB.f1956a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i15 = 0;
                    while (true) {
                        long j11 = jArr[i15];
                        long[] jArr2 = jArr;
                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i15 != length) {
                                break;
                                break;
                            }
                            i15++;
                            jArr = jArr2;
                        } else {
                            int i16 = 8 - ((~(i15 - length)) >>> 31);
                            for (int i17 = 0; i17 < i16; i17++) {
                                if ((j11 & 255) < 128) {
                                    int i18 = (i15 << 3) + i17;
                                    androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[i18];
                                    dVar3.b(iA2 + iArr[i18]);
                                    Function1<Object, Unit> function1H = jVar.h();
                                    if (function1H != null) {
                                        function1H.invoke(c0Var);
                                    }
                                }
                                j11 >>= 8;
                            }
                            if (i16 != 8) {
                                break;
                            }
                            if (i15 != length) {
                                break;
                            }
                            i15++;
                            jArr = jArr2;
                        }
                    }
                }
                dVar3.b(iA2);
                Unit unit2 = Unit.f68710a;
                int iR5 = bVarA2.r();
                if (iR5 > 0) {
                    a0[] a0VarArrQ5 = bVarA2.q();
                    int i19 = 0;
                    do {
                        a0VarArrQ5[i19].a(this);
                        i19++;
                    } while (i19 < iR5);
                }
            } catch (Throwable th4) {
                int iR6 = bVarA2.r();
                if (iR6 > 0) {
                    a0[] a0VarArrQ6 = bVarA2.q();
                    int i21 = 0;
                    do {
                        a0VarArrQ6[i21].a(this);
                        i21++;
                    } while (i21 < iR6);
                }
                throw th4;
            }
        }
        return aVar3;
    }

    @Override // androidx.compose.runtime.z
    public z.a<T> d() {
        androidx.compose.runtime.snapshots.j jVarC = androidx.compose.runtime.snapshots.j.f3684e.c();
        return b((a) SnapshotKt.G(this.f3281c, jVarC), jVarC, false, this.f3279a);
    }

    public final String e() {
        a aVar = (a) SnapshotKt.F(this.f3281c);
        return aVar.k(this, androidx.compose.runtime.snapshots.j.f3684e.c()) ? String.valueOf(aVar.j()) : "<Not calculated>";
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public androidx.compose.runtime.snapshots.e0 getFirstStateRecord() {
        return this.f3281c;
    }

    @Override // androidx.compose.runtime.z
    public q2<T> getPolicy() {
        return this.f3280b;
    }

    @Override // androidx.compose.runtime.a3
    public T getValue() {
        androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
        Function1<Object, Unit> function1H = aVar.c().h();
        if (function1H != null) {
            function1H.invoke(this);
        }
        androidx.compose.runtime.snapshots.j jVarC = aVar.c();
        return (T) b((a) SnapshotKt.G(this.f3281c, jVarC), jVarC, true, this.f3279a).j();
    }

    @Override // androidx.compose.runtime.snapshots.c0
    public void prependStateRecord(androidx.compose.runtime.snapshots.e0 e0Var) {
        Intrinsics.e(e0Var, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.f3281c = (a) e0Var;
    }

    public String toString() {
        return "DerivedState(value=" + e() + ")@" + hashCode();
    }
}

package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.i0;
import androidx.collection.l0;
import androidx.collection.n0;
import androidx.compose.animation.core.j0;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.o1;
import androidx.compose.runtime.q2;
import androidx.compose.runtime.r2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class SnapshotStateObserver {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f3618k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Function0<Unit>, Unit> f3619a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3621c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f3625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f3627i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Object> f3620b = new AtomicReference<>(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<Set<? extends Object>, j, Unit> f3622d = new Function2<Set<? extends Object>, j, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, j jVar) {
            invoke2(set, jVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, j jVar) {
            this.this$0.i(set);
            if (this.this$0.m()) {
                this.this$0.r();
            }
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Object, Unit> f3623e = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
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
            if (this.this$0.f3626h) {
                return;
            }
            androidx.compose.runtime.collection.b bVar = this.this$0.f3624f;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (bVar) {
                SnapshotStateObserver.a aVar = snapshotStateObserver.f3627i;
                Intrinsics.d(aVar);
                aVar.k(obj);
                Unit unit = Unit.f68710a;
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<a> f3624f = new androidx.compose.runtime.collection.b<>(new a[16], 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3628j = -1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Object, Unit> f3629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public i0<Object> f3631c;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3638j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3632d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final androidx.compose.runtime.collection.e<Object, Object> f3633e = new androidx.compose.runtime.collection.e<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final l0<Object, i0<Object>> f3634f = new l0<>(0, 1, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final MutableScatterSet<Object> f3635g = new MutableScatterSet<>(0, 1, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final androidx.compose.runtime.collection.b<androidx.compose.runtime.z<?>> f3636h = new androidx.compose.runtime.collection.b<>(new androidx.compose.runtime.z[16], 0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final androidx.compose.runtime.a0 f3637i = new C0051a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> f3639k = new androidx.compose.runtime.collection.e<>();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final HashMap<androidx.compose.runtime.z<?>, Object> f3640l = new HashMap<>();

        /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotStateObserver$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0051a implements androidx.compose.runtime.a0 {
            public C0051a() {
            }

            @Override // androidx.compose.runtime.a0
            public void a(androidx.compose.runtime.z<?> zVar) {
                a.this.f3638j--;
            }

            @Override // androidx.compose.runtime.a0
            public void b(androidx.compose.runtime.z<?> zVar) {
                a.this.f3638j++;
            }
        }

        public a(Function1<Object, Unit> function1) {
            this.f3629a = function1;
        }

        public final void c() {
            this.f3633e.b();
            this.f3634f.h();
            this.f3639k.b();
            this.f3640l.clear();
        }

        public final void d(Object obj) {
            int i11 = this.f3632d;
            i0<Object> i0Var = this.f3631c;
            if (i0Var == null) {
                return;
            }
            long[] jArr = i0Var.f1956a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i12 = 0;
            while (true) {
                long j11 = jArr[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8 - ((~(i12 - length)) >>> 31);
                    for (int i14 = 0; i14 < i13; i14++) {
                        if ((255 & j11) < 128) {
                            int i15 = (i12 << 3) + i14;
                            Object obj2 = i0Var.f1957b[i15];
                            boolean z11 = i0Var.f1958c[i15] != i11;
                            if (z11) {
                                m(obj, obj2);
                            }
                            if (z11) {
                                i0Var.q(i15);
                            }
                        }
                        j11 >>= 8;
                    }
                    if (i13 != 8) {
                        return;
                    }
                }
                if (i12 == length) {
                    return;
                } else {
                    i12++;
                }
            }
        }

        public final void e(Object obj) {
            i0<Object> i0VarO = this.f3634f.o(obj);
            if (i0VarO == null) {
                return;
            }
            Object[] objArr = i0VarO.f1957b;
            int[] iArr = i0VarO.f1958c;
            long[] jArr = i0VarO.f1956a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                long j11 = jArr[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    for (int i13 = 0; i13 < i12; i13++) {
                        if ((255 & j11) < 128) {
                            int i14 = (i11 << 3) + i13;
                            Object obj2 = objArr[i14];
                            int i15 = iArr[i14];
                            m(obj, obj2);
                        }
                        j11 >>= 8;
                    }
                    if (i12 != 8) {
                        return;
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final Function1<Object, Unit> f() {
            return this.f3629a;
        }

        public final boolean g() {
            return this.f3634f.f();
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0044 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0046 A[LOOP:0: B:5:0x0011->B:15:0x0046, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:19:0x0049 A[EDGE_INSN: B:19:0x0049->B:16:0x0049 BREAK  A[LOOP:0: B:5:0x0011->B:15:0x0046], SYNTHETIC] */
        public final void h() {
            MutableScatterSet<Object> mutableScatterSet = this.f3635g;
            Function1<Object, Unit> function1 = this.f3629a;
            Object[] objArr = mutableScatterSet.f1898b;
            long[] jArr = mutableScatterSet.f1897a;
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
                                function1.invoke(objArr[(i11 << 3) + i13]);
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
            mutableScatterSet.m();
        }

        public final void i(Object obj, Function1<Object, Unit> function1, Function0<Unit> function0) {
            Object obj2 = this.f3630b;
            i0<Object> i0Var = this.f3631c;
            int i11 = this.f3632d;
            this.f3630b = obj;
            this.f3631c = this.f3634f.b(obj);
            if (this.f3632d == -1) {
                this.f3632d = SnapshotKt.H().f();
            }
            androidx.compose.runtime.a0 a0Var = this.f3637i;
            androidx.compose.runtime.collection.b<androidx.compose.runtime.a0> bVarA = r2.a();
            try {
                bVarA.b(a0Var);
                j.f3684e.h(function1, null, function0);
                bVarA.z(bVarA.r() - 1);
                Object obj3 = this.f3630b;
                Intrinsics.d(obj3);
                d(obj3);
                this.f3630b = obj2;
                this.f3631c = i0Var;
                this.f3632d = i11;
            } catch (Throwable th2) {
                bVarA.z(bVarA.r() - 1);
                throw th2;
            }
        }

        /* JADX WARN: Code duplicated, block: B:120:0x030a A[DONT_INVERT, PHI: r20
  0x030a: PHI (r20v40 boolean) = (r20v39 boolean), (r20v41 boolean) binds: [B:110:0x02db, B:119:0x0308] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:121:0x030c A[LOOP:6: B:109:0x02cd->B:121:0x030c, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:124:0x0317  */
        /* JADX WARN: Code duplicated, block: B:184:0x04b4  */
        /* JADX WARN: Code duplicated, block: B:221:0x05c9 A[DONT_INVERT, PHI: r20
  0x05c9: PHI (r20v11 boolean) = (r20v10 boolean), (r20v12 boolean) binds: [B:211:0x059a, B:220:0x05c7] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:222:0x05cb A[LOOP:18: B:210:0x058c->B:222:0x05cb, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:273:0x0314 A[EDGE_INSN: B:273:0x0314->B:123:0x0314 BREAK  A[LOOP:6: B:109:0x02cd->B:121:0x030c], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:278:0x02b1 A[EDGE_INSN: B:278:0x02b1->B:102:0x02b1 BREAK  A[LOOP:8: B:86:0x024e->B:98:0x028d], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:300:0x05e3 A[EDGE_INSN: B:300:0x05e3->B:226:0x05e3 BREAK  A[LOOP:18: B:210:0x058c->B:222:0x05cb], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:60:0x016a  */
        /* JADX WARN: Code duplicated, block: B:97:0x028b A[DONT_INVERT, PHI: r20
  0x028b: PHI (r20v46 boolean) = (r20v45 boolean), (r20v47 boolean) binds: [B:87:0x025c, B:96:0x0289] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:98:0x028d A[LOOP:8: B:86:0x024e->B:98:0x028d, LOOP_END] */
        public final boolean j(Set<? extends Object> set) {
            boolean z11;
            Iterator it;
            HashMap<androidx.compose.runtime.z<?>, Object> map;
            Object obj;
            String str;
            char c11;
            Object objB;
            char c12;
            HashMap<androidx.compose.runtime.z<?>, Object> map2;
            long[] jArr;
            Object[] objArr;
            Iterator it2;
            HashMap<androidx.compose.runtime.z<?>, Object> map3;
            Object obj2;
            androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar;
            long[] jArr2;
            Object[] objArr2;
            int i11;
            String str2;
            long[] jArr3;
            char c13;
            long[] jArr4;
            androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar2;
            HashMap<androidx.compose.runtime.z<?>, Object> map4;
            androidx.compose.runtime.collection.e<Object, Object> eVar3;
            Object[] objArr3;
            String str3;
            int i12;
            long[] jArr5;
            androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar4;
            HashMap<androidx.compose.runtime.z<?>, Object> map5;
            androidx.compose.runtime.collection.e<Object, Object> eVar5;
            Object[] objArr4;
            String str4;
            int i13;
            int i14;
            long j11;
            int i15;
            Object obj3;
            char c14;
            Object objB2;
            char c15;
            HashMap<androidx.compose.runtime.z<?>, Object> map6;
            Object[] objArr5;
            androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar6;
            HashMap<androidx.compose.runtime.z<?>, Object> map7;
            androidx.compose.runtime.collection.e<Object, Object> eVar7;
            String str5;
            long j12;
            Object obj4;
            Object[] objArr6;
            char c16;
            androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar8 = this.f3639k;
            HashMap<androidx.compose.runtime.z<?>, Object> map8 = this.f3640l;
            androidx.compose.runtime.collection.e<Object, Object> eVar9 = this.f3633e;
            MutableScatterSet<Object> mutableScatterSet = this.f3635g;
            String str6 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            char c17 = 7;
            long j13 = -9187201950435737472L;
            int i16 = 0;
            if (set instanceof ScatterSetWrapper) {
                ScatterSet scatterSetA = ((ScatterSetWrapper) set).a();
                Object[] objArr7 = scatterSetA.f1898b;
                long[] jArr6 = scatterSetA.f1897a;
                int length = jArr6.length - 2;
                if (length >= 0) {
                    int i17 = 0;
                    z11 = false;
                    while (true) {
                        long j14 = jArr6[i17];
                        length = length;
                        if ((((~j14) << c17) & j14 & j13) != j13) {
                            int i18 = 8 - ((~(i17 - length)) >>> 31);
                            int i19 = 0;
                            while (i19 < i18) {
                                if ((j14 & 255) < 128) {
                                    Object obj5 = objArr7[(i17 << 3) + i19];
                                    if (!(obj5 instanceof d0) || ((d0) obj5).m47isReadInh_f27i8$runtime_release(f.a(2))) {
                                        if (!eVar8.c(obj5) || (objB2 = eVar8.d().b(obj5)) == null) {
                                            jArr5 = jArr6;
                                            eVar4 = eVar8;
                                            map5 = map8;
                                            eVar5 = eVar9;
                                            objArr4 = objArr7;
                                            str4 = str6;
                                            i13 = i18;
                                            i14 = i19;
                                            j11 = j14;
                                            i15 = i17;
                                            obj3 = obj5;
                                        } else if (objB2 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) objB2;
                                            Object[] objArr8 = mutableScatterSet2.f1898b;
                                            long[] jArr7 = mutableScatterSet2.f1897a;
                                            jArr5 = jArr6;
                                            int length2 = jArr7.length - 2;
                                            if (length2 >= 0) {
                                                objArr4 = objArr7;
                                                i13 = i18;
                                                i14 = i19;
                                                int i21 = 0;
                                                while (true) {
                                                    long j15 = jArr7[i21];
                                                    long[] jArr8 = jArr7;
                                                    i15 = i17;
                                                    if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i22 = 8 - ((~(i21 - length2)) >>> 31);
                                                        int i23 = 0;
                                                        while (i23 < i22) {
                                                            if ((j15 & 255) < 128) {
                                                                objArr6 = objArr8;
                                                                androidx.compose.runtime.z<?> zVar = (androidx.compose.runtime.z) objArr8[(i21 << 3) + i23];
                                                                Intrinsics.e(zVar, str6);
                                                                str5 = str6;
                                                                Object obj6 = map8.get(zVar);
                                                                q2<?> policy = zVar.getPolicy();
                                                                if (policy == null) {
                                                                    policy = r2.j();
                                                                }
                                                                eVar6 = eVar8;
                                                                j12 = j14;
                                                                if (policy.b(zVar.d().a(), obj6)) {
                                                                    map7 = map8;
                                                                    eVar7 = eVar9;
                                                                    obj4 = obj5;
                                                                    this.f3636h.b(zVar);
                                                                } else {
                                                                    Object objB3 = eVar9.d().b(zVar);
                                                                    if (objB3 == null) {
                                                                        map7 = map8;
                                                                        eVar7 = eVar9;
                                                                        obj4 = obj5;
                                                                    } else if (objB3 instanceof MutableScatterSet) {
                                                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) objB3;
                                                                        Object[] objArr9 = mutableScatterSet3.f1898b;
                                                                        long[] jArr9 = mutableScatterSet3.f1897a;
                                                                        int length3 = jArr9.length - 2;
                                                                        if (length3 >= 0) {
                                                                            obj4 = obj5;
                                                                            int i24 = 0;
                                                                            while (true) {
                                                                                long j16 = jArr9[i24];
                                                                                long[] jArr10 = jArr9;
                                                                                map7 = map8;
                                                                                if ((((~j16) << 7) & j16 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                    int i25 = 8 - ((~(i24 - length3)) >>> 31);
                                                                                    int i26 = 0;
                                                                                    while (i26 < i25) {
                                                                                        if ((j16 & 255) < 128) {
                                                                                            mutableScatterSet.h(objArr9[(i24 << 3) + i26]);
                                                                                            c16 = '\b';
                                                                                            z11 = true;
                                                                                        } else {
                                                                                            c16 = '\b';
                                                                                        }
                                                                                        j16 >>= c16;
                                                                                        i26++;
                                                                                        eVar9 = eVar9;
                                                                                    }
                                                                                    eVar7 = eVar9;
                                                                                    if (i25 != 8) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    eVar7 = eVar9;
                                                                                }
                                                                                if (i24 == length3) {
                                                                                    break;
                                                                                }
                                                                                i24++;
                                                                                map8 = map7;
                                                                                jArr9 = jArr10;
                                                                                eVar9 = eVar7;
                                                                            }
                                                                        } else {
                                                                            map7 = map8;
                                                                            eVar7 = eVar9;
                                                                            obj4 = obj5;
                                                                        }
                                                                    } else {
                                                                        map7 = map8;
                                                                        eVar7 = eVar9;
                                                                        obj4 = obj5;
                                                                        mutableScatterSet.h(objB3);
                                                                        z11 = true;
                                                                    }
                                                                }
                                                            } else {
                                                                eVar6 = eVar8;
                                                                map7 = map8;
                                                                eVar7 = eVar9;
                                                                str5 = str6;
                                                                j12 = j14;
                                                                obj4 = obj5;
                                                                objArr6 = objArr8;
                                                            }
                                                            j15 >>= 8;
                                                            i23++;
                                                            str6 = str5;
                                                            objArr8 = objArr6;
                                                            obj5 = obj4;
                                                            eVar8 = eVar6;
                                                            j14 = j12;
                                                            map8 = map7;
                                                            eVar9 = eVar7;
                                                        }
                                                        eVar4 = eVar8;
                                                        map6 = map8;
                                                        eVar5 = eVar9;
                                                        str4 = str6;
                                                        j11 = j14;
                                                        obj3 = obj5;
                                                        objArr5 = objArr8;
                                                        if (i22 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        eVar4 = eVar8;
                                                        map6 = map8;
                                                        eVar5 = eVar9;
                                                        str4 = str6;
                                                        j11 = j14;
                                                        obj3 = obj5;
                                                        objArr5 = objArr8;
                                                    }
                                                    if (i21 == length2) {
                                                        break;
                                                    }
                                                    i21++;
                                                    i17 = i15;
                                                    jArr7 = jArr8;
                                                    str6 = str4;
                                                    objArr8 = objArr5;
                                                    obj5 = obj3;
                                                    eVar8 = eVar4;
                                                    j14 = j11;
                                                    map8 = map6;
                                                    eVar9 = eVar5;
                                                }
                                            } else {
                                                eVar4 = eVar8;
                                                map6 = map8;
                                                eVar5 = eVar9;
                                                objArr4 = objArr7;
                                                str4 = str6;
                                                i13 = i18;
                                                i14 = i19;
                                                j11 = j14;
                                                i15 = i17;
                                                obj3 = obj5;
                                            }
                                            map5 = map6;
                                        } else {
                                            jArr5 = jArr6;
                                            eVar4 = eVar8;
                                            eVar5 = eVar9;
                                            objArr4 = objArr7;
                                            str4 = str6;
                                            i13 = i18;
                                            i14 = i19;
                                            j11 = j14;
                                            i15 = i17;
                                            obj3 = obj5;
                                            androidx.compose.runtime.z<?> zVar2 = (androidx.compose.runtime.z) objB2;
                                            map5 = map8;
                                            Object obj7 = map5.get(zVar2);
                                            q2<?> policy2 = zVar2.getPolicy();
                                            if (policy2 == null) {
                                                policy2 = r2.j();
                                            }
                                            if (policy2.b(zVar2.d().a(), obj7)) {
                                                this.f3636h.b(zVar2);
                                            } else {
                                                Object objB4 = eVar5.d().b(zVar2);
                                                if (objB4 != null) {
                                                    if (objB4 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) objB4;
                                                        Object[] objArr10 = mutableScatterSet4.f1898b;
                                                        long[] jArr11 = mutableScatterSet4.f1897a;
                                                        int length4 = jArr11.length - 2;
                                                        if (length4 >= 0) {
                                                            int i27 = 0;
                                                            while (true) {
                                                                long j17 = jArr11[i27];
                                                                if ((((~j17) << 7) & j17 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                                    if (i27 != length4) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i27++;
                                                                } else {
                                                                    int i28 = 8 - ((~(i27 - length4)) >>> 31);
                                                                    for (int i29 = 0; i29 < i28; i29++) {
                                                                        if ((j17 & 255) < 128) {
                                                                            mutableScatterSet.h(objArr10[(i27 << 3) + i29]);
                                                                            c15 = '\b';
                                                                            z11 = true;
                                                                        } else {
                                                                            c15 = '\b';
                                                                        }
                                                                        j17 >>= c15;
                                                                    }
                                                                    if (i28 != 8) {
                                                                        break;
                                                                    }
                                                                    if (i27 != length4) {
                                                                        break;
                                                                    }
                                                                    i27++;
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        mutableScatterSet.h(objB4);
                                                        z11 = true;
                                                    }
                                                }
                                            }
                                        }
                                        Object objB5 = eVar5.d().b(obj3);
                                        if (objB5 != null) {
                                            if (objB5 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet5 = (MutableScatterSet) objB5;
                                                Object[] objArr11 = mutableScatterSet5.f1898b;
                                                long[] jArr12 = mutableScatterSet5.f1897a;
                                                int length5 = jArr12.length - 2;
                                                if (length5 >= 0) {
                                                    int i31 = 0;
                                                    while (true) {
                                                        long j18 = jArr12[i31];
                                                        if ((((~j18) << 7) & j18 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                            if (i31 != length5) {
                                                                break;
                                                                break;
                                                            }
                                                            i31++;
                                                        } else {
                                                            int i32 = 8 - ((~(i31 - length5)) >>> 31);
                                                            for (int i33 = 0; i33 < i32; i33++) {
                                                                if ((j18 & 255) < 128) {
                                                                    mutableScatterSet.h(objArr11[(i31 << 3) + i33]);
                                                                    c14 = '\b';
                                                                    z11 = true;
                                                                } else {
                                                                    c14 = '\b';
                                                                }
                                                                j18 >>= c14;
                                                            }
                                                            if (i32 != 8) {
                                                                break;
                                                            }
                                                            if (i31 != length5) {
                                                                break;
                                                            }
                                                            i31++;
                                                        }
                                                    }
                                                }
                                            } else {
                                                mutableScatterSet.h(objB5);
                                                z11 = true;
                                            }
                                        }
                                    } else {
                                        jArr5 = jArr6;
                                        eVar4 = eVar8;
                                        map5 = map8;
                                        eVar5 = eVar9;
                                        objArr4 = objArr7;
                                        str4 = str6;
                                        i13 = i18;
                                        i14 = i19;
                                        j11 = j14;
                                        i15 = i17;
                                    }
                                } else {
                                    jArr5 = jArr6;
                                    eVar4 = eVar8;
                                    map5 = map8;
                                    eVar5 = eVar9;
                                    objArr4 = objArr7;
                                    str4 = str6;
                                    i13 = i18;
                                    i14 = i19;
                                    j11 = j14;
                                    i15 = i17;
                                }
                                j14 = j11 >> 8;
                                i19 = i14 + 1;
                                map8 = map5;
                                jArr6 = jArr5;
                                objArr7 = objArr4;
                                i18 = i13;
                                i17 = i15;
                                str6 = str4;
                                eVar8 = eVar4;
                                eVar9 = eVar5;
                            }
                            jArr4 = jArr6;
                            eVar2 = eVar8;
                            map4 = map8;
                            eVar3 = eVar9;
                            objArr3 = objArr7;
                            str3 = str6;
                            int i34 = i17;
                            if (i18 != 8) {
                                break;
                            }
                            i12 = i34;
                        } else {
                            jArr4 = jArr6;
                            eVar2 = eVar8;
                            map4 = map8;
                            eVar3 = eVar9;
                            objArr3 = objArr7;
                            str3 = str6;
                            i12 = i17;
                        }
                        if (i12 == length) {
                            break;
                        }
                        i17 = i12 + 1;
                        map8 = map4;
                        jArr6 = jArr4;
                        objArr7 = objArr3;
                        str6 = str3;
                        eVar8 = eVar2;
                        eVar9 = eVar3;
                        c17 = 7;
                        j13 = -9187201950435737472L;
                    }
                } else {
                    z11 = false;
                }
            } else {
                androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar10 = eVar8;
                HashMap<androidx.compose.runtime.z<?>, Object> map9 = map8;
                String str7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
                Iterator it3 = set.iterator();
                z11 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (!(next instanceof d0) || ((d0) next).m47isReadInh_f27i8$runtime_release(f.a(2))) {
                        androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar11 = eVar10;
                        if (!eVar11.c(next) || (objB = eVar11.d().b(next)) == null) {
                            it = it3;
                            map = map9;
                            obj = next;
                            eVar10 = eVar11;
                            str = str7;
                        } else if (objB instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) objB;
                            Object[] objArr12 = mutableScatterSet6.f1898b;
                            long[] jArr13 = mutableScatterSet6.f1897a;
                            int length6 = jArr13.length - 2;
                            if (length6 >= 0) {
                                int i35 = 0;
                                while (true) {
                                    long j19 = jArr13[i35];
                                    if ((((~j19) << 7) & j19 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i36 = 8 - ((~(i35 - length6)) >>> 31);
                                        int i37 = 0;
                                        while (i37 < i36) {
                                            if ((j19 & 255) < 128) {
                                                androidx.compose.runtime.z<?> zVar3 = (androidx.compose.runtime.z) objArr12[(i35 << 3) + i37];
                                                str2 = str7;
                                                Intrinsics.e(zVar3, str2);
                                                it2 = it3;
                                                Object obj8 = map9.get(zVar3);
                                                q2<?> policy3 = zVar3.getPolicy();
                                                if (policy3 == null) {
                                                    policy3 = r2.j();
                                                }
                                                eVar = eVar11;
                                                jArr2 = jArr13;
                                                if (policy3.b(zVar3.d().a(), obj8)) {
                                                    map3 = map9;
                                                    obj2 = next;
                                                    objArr2 = objArr12;
                                                    i11 = length6;
                                                    this.f3636h.b(zVar3);
                                                } else {
                                                    Object objB6 = eVar9.d().b(zVar3);
                                                    if (objB6 == null) {
                                                        map3 = map9;
                                                        obj2 = next;
                                                        objArr2 = objArr12;
                                                        i11 = length6;
                                                    } else if (objB6 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet7 = (MutableScatterSet) objB6;
                                                        Object[] objArr13 = mutableScatterSet7.f1898b;
                                                        long[] jArr14 = mutableScatterSet7.f1897a;
                                                        int length7 = jArr14.length - 2;
                                                        if (length7 >= 0) {
                                                            map3 = map9;
                                                            obj2 = next;
                                                            int i38 = 0;
                                                            while (true) {
                                                                long j21 = jArr14[i38];
                                                                objArr2 = objArr12;
                                                                i11 = length6;
                                                                if ((((~j21) << 7) & j21 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                    int i39 = 8 - ((~(i38 - length7)) >>> 31);
                                                                    int i40 = 0;
                                                                    while (i40 < i39) {
                                                                        if ((j21 & 255) < 128) {
                                                                            mutableScatterSet.h(objArr13[(i38 << 3) + i40]);
                                                                            c13 = '\b';
                                                                            z11 = true;
                                                                        } else {
                                                                            c13 = '\b';
                                                                        }
                                                                        j21 >>= c13;
                                                                        i40++;
                                                                        jArr14 = jArr14;
                                                                    }
                                                                    jArr3 = jArr14;
                                                                    if (i39 != 8) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    jArr3 = jArr14;
                                                                }
                                                                if (i38 == length7) {
                                                                    break;
                                                                }
                                                                i38++;
                                                                objArr12 = objArr2;
                                                                length6 = i11;
                                                                jArr14 = jArr3;
                                                            }
                                                        } else {
                                                            map3 = map9;
                                                            obj2 = next;
                                                            objArr2 = objArr12;
                                                            i11 = length6;
                                                        }
                                                    } else {
                                                        map3 = map9;
                                                        obj2 = next;
                                                        objArr2 = objArr12;
                                                        i11 = length6;
                                                        mutableScatterSet.h(objB6);
                                                        z11 = true;
                                                    }
                                                }
                                            } else {
                                                it2 = it3;
                                                map3 = map9;
                                                obj2 = next;
                                                eVar = eVar11;
                                                jArr2 = jArr13;
                                                objArr2 = objArr12;
                                                i11 = length6;
                                                str2 = str7;
                                            }
                                            j19 >>= 8;
                                            i37++;
                                            it3 = it2;
                                            str7 = str2;
                                            next = obj2;
                                            jArr13 = jArr2;
                                            objArr12 = objArr2;
                                            length6 = i11;
                                            eVar11 = eVar;
                                            map9 = map3;
                                        }
                                        it = it3;
                                        map2 = map9;
                                        obj = next;
                                        eVar10 = eVar11;
                                        jArr = jArr13;
                                        objArr = objArr12;
                                        int i41 = length6;
                                        str = str7;
                                        if (i36 != 8) {
                                            break;
                                        }
                                        length6 = i41;
                                    } else {
                                        it = it3;
                                        map2 = map9;
                                        obj = next;
                                        eVar10 = eVar11;
                                        jArr = jArr13;
                                        objArr = objArr12;
                                        str = str7;
                                    }
                                    if (i35 == length6) {
                                        break;
                                    }
                                    i35++;
                                    it3 = it;
                                    str7 = str;
                                    next = obj;
                                    jArr13 = jArr;
                                    objArr12 = objArr;
                                    eVar11 = eVar10;
                                    map9 = map2;
                                }
                            } else {
                                it = it3;
                                map2 = map9;
                                obj = next;
                                eVar10 = eVar11;
                                str = str7;
                            }
                            map = map2;
                        } else {
                            it = it3;
                            obj = next;
                            eVar10 = eVar11;
                            str = str7;
                            androidx.compose.runtime.z<?> zVar4 = (androidx.compose.runtime.z) objB;
                            map = map9;
                            Object obj9 = map.get(zVar4);
                            q2<?> policy4 = zVar4.getPolicy();
                            if (policy4 == null) {
                                policy4 = r2.j();
                            }
                            if (policy4.b(zVar4.d().a(), obj9)) {
                                this.f3636h.b(zVar4);
                            } else {
                                Object objB7 = eVar9.d().b(zVar4);
                                if (objB7 != null) {
                                    if (objB7 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) objB7;
                                        Object[] objArr14 = mutableScatterSet8.f1898b;
                                        long[] jArr15 = mutableScatterSet8.f1897a;
                                        int length8 = jArr15.length - 2;
                                        if (length8 >= 0) {
                                            int i42 = 0;
                                            while (true) {
                                                long j22 = jArr15[i42];
                                                if ((((~j22) << 7) & j22 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                    if (i42 != length8) {
                                                        break;
                                                        break;
                                                    }
                                                    i42++;
                                                } else {
                                                    int i43 = 8 - ((~(i42 - length8)) >>> 31);
                                                    for (int i44 = 0; i44 < i43; i44++) {
                                                        if ((j22 & 255) < 128) {
                                                            mutableScatterSet.h(objArr14[(i42 << 3) + i44]);
                                                            c12 = '\b';
                                                            z11 = true;
                                                        } else {
                                                            c12 = '\b';
                                                        }
                                                        j22 >>= c12;
                                                    }
                                                    if (i43 != 8) {
                                                        break;
                                                    }
                                                    if (i42 != length8) {
                                                        break;
                                                    }
                                                    i42++;
                                                }
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.h(objB7);
                                        z11 = true;
                                    }
                                }
                            }
                        }
                        Object objB8 = eVar9.d().b(obj);
                        if (objB8 != null) {
                            if (objB8 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) objB8;
                                Object[] objArr15 = mutableScatterSet9.f1898b;
                                long[] jArr16 = mutableScatterSet9.f1897a;
                                int length9 = jArr16.length - 2;
                                if (length9 >= 0) {
                                    int i45 = 0;
                                    while (true) {
                                        long j23 = jArr16[i45];
                                        if ((((~j23) << 7) & j23 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i46 = 8 - ((~(i45 - length9)) >>> 31);
                                            for (int i47 = 0; i47 < i46; i47++) {
                                                if ((j23 & 255) < 128) {
                                                    mutableScatterSet.h(objArr15[(i45 << 3) + i47]);
                                                    c11 = '\b';
                                                    z11 = true;
                                                } else {
                                                    c11 = '\b';
                                                }
                                                j23 >>= c11;
                                            }
                                            if (i46 != 8) {
                                                break;
                                            }
                                        }
                                        if (i45 == length9) {
                                            break;
                                        }
                                        i45++;
                                    }
                                }
                            } else {
                                mutableScatterSet.h(objB8);
                                z11 = true;
                            }
                        }
                        map9 = map;
                        str7 = str;
                        it3 = it;
                    } else {
                        it = it3;
                        map = map9;
                        str = str7;
                    }
                    map9 = map;
                    str7 = str;
                    it3 = it;
                }
            }
            if (this.f3636h.u()) {
                androidx.compose.runtime.collection.b<androidx.compose.runtime.z<?>> bVar = this.f3636h;
                int iR = bVar.r();
                if (iR > 0) {
                    androidx.compose.runtime.z<?>[] zVarArrQ = bVar.q();
                    while (true) {
                        o(zVarArrQ[i16]);
                        int i48 = i16 + 1;
                        if (i48 >= iR) {
                            break;
                        }
                        i16 = i48;
                    }
                }
                this.f3636h.i();
            }
            return z11;
        }

        public final void k(Object obj) {
            Object obj2 = this.f3630b;
            Intrinsics.d(obj2);
            int i11 = this.f3632d;
            i0<Object> i0Var = this.f3631c;
            if (i0Var == null) {
                i0Var = new i0<>(0, 1, null);
                this.f3631c = i0Var;
                this.f3634f.r(obj2, i0Var);
                Unit unit = Unit.f68710a;
            }
            l(obj, i11, obj2, i0Var);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0089 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:25:0x008b A[LOOP:0: B:11:0x003b->B:25:0x008b, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:34:0x008f A[EDGE_INSN: B:34:0x008f->B:26:0x008f BREAK  A[LOOP:0: B:11:0x003b->B:25:0x008b], SYNTHETIC] */
        public final void l(Object obj, int i11, Object obj2, i0<Object> i0Var) {
            if (this.f3638j > 0) {
                return;
            }
            int iP = i0Var.p(obj, i11, -1);
            if ((obj instanceof androidx.compose.runtime.z) && iP != i11) {
                androidx.compose.runtime.z.a aVarD = ((androidx.compose.runtime.z) obj).d();
                this.f3640l.put(obj, aVarD.a());
                n0<c0> n0VarB = aVarD.b();
                androidx.compose.runtime.collection.e<Object, androidx.compose.runtime.z<?>> eVar = this.f3639k;
                eVar.g(obj);
                Object[] objArr = n0VarB.f1957b;
                long[] jArr = n0VarB.f1956a;
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
                                if ((j11 & 255) < 128) {
                                    c0 c0Var = (c0) objArr[(i12 << 3) + i14];
                                    if (c0Var instanceof d0) {
                                        ((d0) c0Var).m48recordReadInh_f27i8$runtime_release(f.a(2));
                                    }
                                    eVar.a(c0Var, obj);
                                }
                                j11 >>= 8;
                            }
                            if (i13 != 8) {
                                break;
                            } else if (i12 != length) {
                                break;
                            } else {
                                i12++;
                            }
                        }
                    }
                }
            }
            if (iP == -1) {
                if (obj instanceof d0) {
                    ((d0) obj).m48recordReadInh_f27i8$runtime_release(f.a(2));
                }
                this.f3633e.a(obj, obj2);
            }
        }

        public final void m(Object obj, Object obj2) {
            this.f3633e.f(obj2, obj);
            if (!(obj2 instanceof androidx.compose.runtime.z) || this.f3633e.c(obj2)) {
                return;
            }
            this.f3639k.g(obj2);
            this.f3640l.remove(obj2);
        }

        public final void n(Function1<Object, Boolean> function1) {
            long[] jArr;
            int i11;
            long[] jArr2;
            int i12;
            long j11;
            int i13;
            long j12;
            l0<Object, i0<Object>> l0Var = this.f3634f;
            long[] jArr3 = l0Var.f1982a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i14 = 0;
            while (true) {
                long j13 = jArr3[i14];
                long j14 = -9187201950435737472L;
                if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8 - ((~(i14 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j13 & 255) < 128) {
                            int i17 = (i14 << 3) + i16;
                            Object obj = l0Var.f1983b[i17];
                            i0 i0Var = (i0) l0Var.f1984c[i17];
                            Boolean boolInvoke = function1.invoke(obj);
                            if (boolInvoke.booleanValue()) {
                                Object[] objArr = i0Var.f1957b;
                                int[] iArr = i0Var.f1958c;
                                long[] jArr4 = i0Var.f1956a;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                if (length2 >= 0) {
                                    i13 = i15;
                                    int i18 = 0;
                                    while (true) {
                                        long j15 = jArr4[i18];
                                        i12 = i14;
                                        j11 = j13;
                                        j12 = -9187201950435737472L;
                                        if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                            for (int i21 = 0; i21 < i19; i21++) {
                                                if ((j15 & 255) < 128) {
                                                    int i22 = (i18 << 3) + i21;
                                                    Object obj2 = objArr[i22];
                                                    int i23 = iArr[i22];
                                                    m(obj, obj2);
                                                }
                                                j15 >>= 8;
                                            }
                                            if (i19 != 8) {
                                                break;
                                            }
                                        }
                                        if (i18 == length2) {
                                            break;
                                        }
                                        i18++;
                                        i14 = i12;
                                        j13 = j11;
                                    }
                                } else {
                                    i12 = i14;
                                    j11 = j13;
                                    i13 = i15;
                                    j12 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i12 = i14;
                                j11 = j13;
                                i13 = i15;
                                j12 = j14;
                            }
                            if (boolInvoke.booleanValue()) {
                                l0Var.p(i17);
                            }
                        } else {
                            jArr2 = jArr3;
                            i12 = i14;
                            j11 = j13;
                            i13 = i15;
                            j12 = j14;
                        }
                        j13 = j11 >> 8;
                        i16++;
                        j14 = j12;
                        jArr3 = jArr2;
                        i15 = i13;
                        i14 = i12;
                    }
                    jArr = jArr3;
                    int i24 = i14;
                    if (i15 != 8) {
                        return;
                    } else {
                        i11 = i24;
                    }
                } else {
                    jArr = jArr3;
                    i11 = i14;
                }
                if (i11 == length) {
                    return;
                }
                i14 = i11 + 1;
                jArr3 = jArr;
            }
        }

        public final void o(androidx.compose.runtime.z<?> zVar) {
            long[] jArr;
            i0<Object> i0Var;
            l0<Object, i0<Object>> l0Var = this.f3634f;
            int iF = SnapshotKt.H().f();
            Object objB = this.f3633e.d().b(zVar);
            if (objB == null) {
                return;
            }
            if (!(objB instanceof MutableScatterSet)) {
                i0<Object> i0VarB = l0Var.b(objB);
                if (i0VarB == null) {
                    i0VarB = new i0<>(0, 1, null);
                    l0Var.r(objB, i0VarB);
                    Unit unit = Unit.f68710a;
                }
                l(zVar, iF, objB, i0VarB);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
            Object[] objArr = mutableScatterSet.f1898b;
            long[] jArr2 = mutableScatterSet.f1897a;
            int length = jArr2.length - 2;
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                long j11 = jArr2[i11];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j11 & 255) < 128) {
                            Object obj = objArr[(i11 << 3) + i13];
                            i0<Object> i0VarB2 = l0Var.b(obj);
                            if (i0VarB2 == null) {
                                i0Var = new i0<>(0, 1, null);
                                l0Var.r(obj, i0Var);
                                Unit unit2 = Unit.f68710a;
                            } else {
                                i0Var = i0VarB2;
                            }
                            l(zVar, iF, obj, i0Var);
                        }
                        j11 >>= 8;
                        i13++;
                        jArr2 = jArr2;
                    }
                    jArr = jArr2;
                    if (i12 != 8) {
                        return;
                    }
                } else {
                    jArr = jArr2;
                }
                if (i11 == length) {
                    return;
                }
                i11++;
                jArr2 = jArr;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.f3619a = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Set<? extends Object> set) {
        Object obj;
        List listX0;
        do {
            obj = this.f3620b.get();
            if (obj == null) {
                listX0 = set;
            } else if (obj instanceof Set) {
                listX0 = kotlin.collections.g.o(obj, set);
            } else {
                if (!(obj instanceof List)) {
                    q();
                    throw new KotlinNothingValueException();
                }
                listX0 = CollectionsKt___CollectionsKt.x0((Collection) obj, kotlin.collections.f.e(set));
            }
        } while (!j0.a(this.f3620b, obj, listX0));
    }

    public final void j() {
        synchronized (this.f3624f) {
            try {
                androidx.compose.runtime.collection.b<a> bVar = this.f3624f;
                int iR = bVar.r();
                if (iR > 0) {
                    a[] aVarArrQ = bVar.q();
                    int i11 = 0;
                    do {
                        aVarArrQ[i11].c();
                        i11++;
                    } while (i11 < iR);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void k(Object obj) {
        synchronized (this.f3624f) {
            try {
                androidx.compose.runtime.collection.b<a> bVar = this.f3624f;
                int iR = bVar.r();
                int i11 = 0;
                for (int i12 = 0; i12 < iR; i12++) {
                    a aVar = bVar.q()[i12];
                    aVar.e(obj);
                    if (!aVar.g()) {
                        i11++;
                    } else if (i11 > 0) {
                        bVar.q()[i12 - i11] = bVar.q()[i12];
                    }
                }
                int i13 = iR - i11;
                ArraysKt___ArraysJvmKt.u(bVar.q(), null, i13, iR);
                bVar.D(i13);
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(Function1<Object, Boolean> function1) {
        synchronized (this.f3624f) {
            try {
                androidx.compose.runtime.collection.b<a> bVar = this.f3624f;
                int iR = bVar.r();
                int i11 = 0;
                for (int i12 = 0; i12 < iR; i12++) {
                    a aVar = bVar.q()[i12];
                    aVar.n(function1);
                    if (!aVar.g()) {
                        i11++;
                    } else if (i11 > 0) {
                        bVar.q()[i12 - i11] = bVar.q()[i12];
                    }
                }
                int i13 = iR - i11;
                ArraysKt___ArraysJvmKt.u(bVar.q(), null, i13, iR);
                bVar.D(i13);
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean m() {
        boolean z11;
        synchronized (this.f3624f) {
            z11 = this.f3621c;
        }
        if (z11) {
            return false;
        }
        boolean z12 = false;
        while (true) {
            Set<? extends Object> setP = p();
            if (setP == null) {
                return z12;
            }
            synchronized (this.f3624f) {
                try {
                    androidx.compose.runtime.collection.b<a> bVar = this.f3624f;
                    int iR = bVar.r();
                    if (iR > 0) {
                        a[] aVarArrQ = bVar.q();
                        int i11 = 0;
                        do {
                            z12 = aVarArrQ[i11].j(setP) || z12;
                            i11++;
                        } while (i11 < iR);
                    }
                    Unit unit = Unit.f68710a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final <T> a n(Function1<? super T, Unit> function1) {
        a aVar;
        androidx.compose.runtime.collection.b<a> bVar = this.f3624f;
        int iR = bVar.r();
        if (iR <= 0) {
            aVar = null;
            break;
        }
        a[] aVarArrQ = bVar.q();
        int i11 = 0;
        while (true) {
            aVar = aVarArrQ[i11];
            if (aVar.f() == function1) {
                break;
            }
            i11++;
            if (i11 >= iR) {
                aVar = null;
                break;
            }
        }
        a aVar2 = aVar;
        if (aVar2 != null) {
            return aVar2;
        }
        Intrinsics.e(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        a aVar3 = new a((Function1) TypeIntrinsics.e(function1, 1));
        this.f3624f.b(aVar3);
        return aVar3;
    }

    public final <T> void o(T t11, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        a aVarN;
        synchronized (this.f3624f) {
            aVarN = n(function1);
        }
        boolean z11 = this.f3626h;
        a aVar = this.f3627i;
        long j11 = this.f3628j;
        if (j11 != -1) {
            if (!(j11 == androidx.compose.runtime.b.a())) {
                o1.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j11 + "), currentThread={id=" + androidx.compose.runtime.b.a() + ", name=" + androidx.compose.runtime.b.b() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.f3626h = false;
            this.f3627i = aVarN;
            this.f3628j = androidx.compose.runtime.b.a();
            aVarN.i(t11, this.f3623e, function0);
        } finally {
            this.f3627i = aVar;
            this.f3626h = z11;
            this.f3628j = j11;
        }
    }

    public final Set<Object> p() {
        Object obj;
        Object objSubList;
        Set<Object> set;
        do {
            obj = this.f3620b.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    q();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!j0.a(this.f3620b, obj, objSubList));
        return set;
    }

    public final Void q() {
        androidx.compose.runtime.k.t("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    public final void r() {
        this.f3619a.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    androidx.compose.runtime.collection.b bVar = this.this$0.f3624f;
                    SnapshotStateObserver snapshotStateObserver = this.this$0;
                    synchronized (bVar) {
                        try {
                            if (!snapshotStateObserver.f3621c) {
                                snapshotStateObserver.f3621c = true;
                                try {
                                    androidx.compose.runtime.collection.b bVar2 = snapshotStateObserver.f3624f;
                                    int iR = bVar2.r();
                                    if (iR > 0) {
                                        Object[] objArrQ = bVar2.q();
                                        int i11 = 0;
                                        do {
                                            ((SnapshotStateObserver.a) objArrQ[i11]).h();
                                            i11++;
                                        } while (i11 < iR);
                                    }
                                    snapshotStateObserver.f3621c = false;
                                } catch (Throwable th2) {
                                    snapshotStateObserver.f3621c = false;
                                    throw th2;
                                }
                            }
                            Unit unit = Unit.f68710a;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                } while (this.this$0.m());
            }
        });
    }

    public final void s() {
        this.f3625g = j.f3684e.i(this.f3622d);
    }

    public final void t() {
        e eVar = this.f3625g;
        if (eVar != null) {
            eVar.dispose();
        }
    }
}

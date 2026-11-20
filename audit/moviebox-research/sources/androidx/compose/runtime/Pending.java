package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class Pending {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q0> f3296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<q0> f3299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.collection.c0<i0> f3300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f3301f;

    public Pending(List<q0> list, int i11) {
        this.f3296a = list;
        this.f3297b = i11;
        if (!(i11 >= 0)) {
            o1.a("Invalid start index");
        }
        this.f3299d = new ArrayList();
        androidx.collection.c0<i0> c0Var = new androidx.collection.c0<>(0, 1, null);
        int size = list.size();
        int iC = 0;
        for (int i12 = 0; i12 < size; i12++) {
            q0 q0Var = this.f3296a.get(i12);
            c0Var.t(q0Var.b(), new i0(i12, iC, q0Var.c()));
            iC += q0Var.c();
        }
        this.f3300e = c0Var;
        this.f3301f = LazyKt__LazyJVMKt.b(new Function0<h1<Object, q0>>() { // from class: androidx.compose.runtime.Pending$keyMap$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ h1<Object, q0> invoke() {
                return h1.a(m42invokeSAeQiB4());
            }

            /* JADX INFO: renamed from: invoke-SAeQiB4, reason: not valid java name */
            public final androidx.collection.l0 m42invokeSAeQiB4() {
                androidx.collection.l0 l0VarK = k.K(this.this$0.b().size());
                Pending pending = this.this$0;
                int size2 = pending.b().size();
                for (int i13 = 0; i13 < size2; i13++) {
                    q0 q0Var2 = pending.b().get(i13);
                    h1.f(l0VarK, k.C(q0Var2), q0Var2);
                }
                return l0VarK;
            }
        });
    }

    public final int a() {
        return this.f3298c;
    }

    public final List<q0> b() {
        return this.f3296a;
    }

    public final androidx.collection.l0 c() {
        return ((h1) this.f3301f.getValue()).h();
    }

    public final q0 d(int i11, Object obj) {
        return (q0) h1.e(c(), obj != null ? new p0(Integer.valueOf(i11), obj) : Integer.valueOf(i11));
    }

    public final int e() {
        return this.f3297b;
    }

    public final List<q0> f() {
        return this.f3299d;
    }

    public final int g(q0 q0Var) {
        i0 i0VarC = this.f3300e.c(q0Var.b());
        if (i0VarC != null) {
            return i0VarC.b();
        }
        return -1;
    }

    public final boolean h(q0 q0Var) {
        return this.f3299d.add(q0Var);
    }

    public final void i(q0 q0Var, int i11) {
        this.f3300e.t(q0Var.b(), new i0(-1, i11, 0));
    }

    public final void j(int i11, int i12, int i13) {
        char c11 = 7;
        long j11 = -9187201950435737472L;
        if (i11 > i12) {
            androidx.collection.c0<i0> c0Var = this.f3300e;
            Object[] objArr = c0Var.f1953c;
            long[] jArr = c0Var.f1951a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i14 = 0;
            while (true) {
                long j12 = jArr[i14];
                if ((((~j12) << 7) & j12 & j11) != j11) {
                    int i15 = 8 - ((~(i14 - length)) >>> 31);
                    for (int i16 = 0; i16 < i15; i16++) {
                        if ((j12 & 255) < 128) {
                            i0 i0Var = (i0) objArr[(i14 << 3) + i16];
                            int iB = i0Var.b();
                            if (i11 <= iB && iB < i11 + i13) {
                                i0Var.e((iB - i11) + i12);
                            } else if (i12 <= iB && iB < i11) {
                                i0Var.e(iB + i13);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i15 != 8) {
                        return;
                    }
                }
                if (i14 == length) {
                    return;
                }
                i14++;
                j11 = -9187201950435737472L;
            }
        } else {
            if (i12 <= i11) {
                return;
            }
            androidx.collection.c0<i0> c0Var2 = this.f3300e;
            Object[] objArr2 = c0Var2.f1953c;
            long[] jArr2 = c0Var2.f1951a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i17 = 0;
            while (true) {
                long j13 = jArr2[i17];
                if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i18 = 8 - ((~(i17 - length2)) >>> 31);
                    for (int i19 = 0; i19 < i18; i19++) {
                        if ((j13 & 255) < 128) {
                            i0 i0Var2 = (i0) objArr2[(i17 << 3) + i19];
                            int iB2 = i0Var2.b();
                            if (i11 <= iB2 && iB2 < i11 + i13) {
                                i0Var2.e((iB2 - i11) + i12);
                            } else if (i11 + 1 <= iB2 && iB2 < i12) {
                                i0Var2.e(iB2 - i13);
                            }
                        }
                        j13 >>= 8;
                    }
                    if (i18 != 8) {
                        return;
                    }
                }
                if (i17 == length2) {
                    return;
                }
                i17++;
                c11 = 7;
            }
        }
    }

    public final void k(int i11, int i12) {
        char c11 = 7;
        long j11 = -9187201950435737472L;
        if (i11 > i12) {
            androidx.collection.c0<i0> c0Var = this.f3300e;
            Object[] objArr = c0Var.f1953c;
            long[] jArr = c0Var.f1951a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i13 = 0;
            while (true) {
                long j12 = jArr[i13];
                if ((((~j12) << 7) & j12 & j11) != j11) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((j12 & 255) < 128) {
                            i0 i0Var = (i0) objArr[(i13 << 3) + i15];
                            int iC = i0Var.c();
                            if (iC == i11) {
                                i0Var.f(i12);
                            } else if (i12 <= iC && iC < i11) {
                                i0Var.f(iC + 1);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i14 != 8) {
                        return;
                    }
                }
                if (i13 == length) {
                    return;
                }
                i13++;
                j11 = -9187201950435737472L;
            }
        } else {
            if (i12 <= i11) {
                return;
            }
            androidx.collection.c0<i0> c0Var2 = this.f3300e;
            Object[] objArr2 = c0Var2.f1953c;
            long[] jArr2 = c0Var2.f1951a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i16 = 0;
            while (true) {
                long j13 = jArr2[i16];
                if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8 - ((~(i16 - length2)) >>> 31);
                    for (int i18 = 0; i18 < i17; i18++) {
                        if ((j13 & 255) < 128) {
                            i0 i0Var2 = (i0) objArr2[(i16 << 3) + i18];
                            int iC2 = i0Var2.c();
                            if (iC2 == i11) {
                                i0Var2.f(i12);
                            } else if (i11 + 1 <= iC2 && iC2 < i12) {
                                i0Var2.f(iC2 - 1);
                            }
                        }
                        j13 >>= 8;
                    }
                    if (i17 != 8) {
                        return;
                    }
                }
                if (i16 == length2) {
                    return;
                }
                i16++;
                c11 = 7;
            }
        }
    }

    public final void l(int i11) {
        this.f3298c = i11;
    }

    public final int m(q0 q0Var) {
        i0 i0VarC = this.f3300e.c(q0Var.b());
        if (i0VarC != null) {
            return i0VarC.c();
        }
        return -1;
    }

    public final boolean n(int i11, int i12) {
        int iB;
        i0 i0VarC = this.f3300e.c(i11);
        if (i0VarC == null) {
            return false;
        }
        int iB2 = i0VarC.b();
        int iA = i12 - i0VarC.a();
        i0VarC.d(i12);
        if (iA == 0) {
            return true;
        }
        androidx.collection.c0<i0> c0Var = this.f3300e;
        Object[] objArr = c0Var.f1953c;
        long[] jArr = c0Var.f1951a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            long j11 = jArr[i13];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i13 - length)) >>> 31);
                for (int i15 = 0; i15 < i14; i15++) {
                    if ((255 & j11) < 128) {
                        i0 i0Var = (i0) objArr[(i13 << 3) + i15];
                        if (i0Var.b() >= iB2 && !Intrinsics.b(i0Var, i0VarC) && (iB = i0Var.b() + iA) >= 0) {
                            i0Var.e(iB);
                        }
                    }
                    j11 >>= 8;
                }
                if (i14 != 8) {
                    return true;
                }
            }
            if (i13 == length) {
                return true;
            }
            i13++;
        }
    }

    public final int o(q0 q0Var) {
        i0 i0VarC = this.f3300e.c(q0Var.b());
        return i0VarC != null ? i0VarC.a() : q0Var.c();
    }
}

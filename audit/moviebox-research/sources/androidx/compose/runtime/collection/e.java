package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterSet;
import androidx.collection.l0;
import androidx.collection.t0;
import kotlin.Metadata;
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
public final class e<Key, Scope> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0<Object, Object> f3367a = t0.d();

    public final void a(Key key, Scope scope) {
        l0<Object, Object> l0Var = this.f3367a;
        int iK = l0Var.k(key);
        boolean z11 = iK < 0;
        Object obj = z11 ? null : l0Var.f1984c[iK];
        if (obj != null) {
            if (obj instanceof MutableScatterSet) {
                Intrinsics.e(obj, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                ((MutableScatterSet) obj).h(scope);
            } else if (obj != scope) {
                MutableScatterSet mutableScatterSet = new MutableScatterSet(0, 1, null);
                Intrinsics.e(obj, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet.h(obj);
                mutableScatterSet.h(scope);
                scope = (Scope) mutableScatterSet;
            }
            scope = (Scope) obj;
        }
        if (!z11) {
            l0Var.f1984c[iK] = scope;
            return;
        }
        int i11 = ~iK;
        l0Var.f1983b[i11] = key;
        l0Var.f1984c[i11] = scope;
    }

    public final void b() {
        this.f3367a.h();
    }

    public final boolean c(Key key) {
        return this.f3367a.a(key);
    }

    public final l0<Object, Object> d() {
        return this.f3367a;
    }

    public final int e() {
        return this.f3367a.d();
    }

    public final boolean f(Key key, Scope scope) {
        Object objB = this.f3367a.b(key);
        if (objB == null) {
            return false;
        }
        if (!(objB instanceof MutableScatterSet)) {
            if (!Intrinsics.b(objB, scope)) {
                return false;
            }
            this.f3367a.o(key);
            return true;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
        boolean zX = mutableScatterSet.x(scope);
        if (zX && mutableScatterSet.d()) {
            this.f3367a.o(key);
        }
        return zX;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056  */
    public final void g(Scope scope) {
        l0<Object, Object> l0Var = this.f3367a;
        long[] jArr = l0Var.f1982a;
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
                        Object obj = l0Var.f1983b[i14];
                        Object obj2 = l0Var.f1984c[i14];
                        if (obj2 instanceof MutableScatterSet) {
                            Intrinsics.e(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                            mutableScatterSet.x(scope);
                            if (mutableScatterSet.d()) {
                                l0Var.p(i14);
                            }
                        } else if (obj2 == scope) {
                            l0Var.p(i14);
                        }
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

    public final void h(Key key, Scope scope) {
        this.f3367a.r(key, scope);
    }
}

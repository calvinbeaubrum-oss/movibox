package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
@SourceDebugExtension
public final class h1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.l0<K, Object> f3411a;

    public /* synthetic */ h1(androidx.collection.l0 l0Var) {
        this.f3411a = l0Var;
    }

    public static final /* synthetic */ h1 a(androidx.collection.l0 l0Var) {
        return new h1(l0Var);
    }

    public static <K, V> androidx.collection.l0<K, Object> b(androidx.collection.l0<K, Object> l0Var) {
        return l0Var;
    }

    public static boolean c(androidx.collection.l0<K, Object> l0Var, Object obj) {
        return (obj instanceof h1) && Intrinsics.b(l0Var, ((h1) obj).h());
    }

    public static int d(androidx.collection.l0<K, Object> l0Var) {
        return l0Var.hashCode();
    }

    public static final V e(androidx.collection.l0<K, Object> l0Var, K k11) {
        V v11 = (V) l0Var.b(k11);
        if (v11 == null) {
            return null;
        }
        if (TypeIntrinsics.l(v11)) {
            List listC = TypeIntrinsics.c(v11);
            Object objRemove = listC.remove(0);
            if (listC.isEmpty()) {
                l0Var.o(k11);
            }
            v11 = (V) objRemove;
        } else {
            l0Var.o(k11);
        }
        Intrinsics.e(v11, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return v11;
    }

    public static final void f(androidx.collection.l0<K, Object> l0Var, K k11, V v11) {
        int iK = l0Var.k(k11);
        boolean z11 = iK < 0;
        Object obj = z11 ? null : l0Var.f1984c[iK];
        if (obj != null) {
            if (TypeIntrinsics.l(obj)) {
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List listC = TypeIntrinsics.c(obj);
                listC.add(v11);
                v11 = (V) listC;
            } else {
                v11 = (V) kotlin.collections.g.q(obj, v11);
            }
        }
        if (!z11) {
            l0Var.f1984c[iK] = v11;
            return;
        }
        int i11 = ~iK;
        l0Var.f1983b[i11] = k11;
        l0Var.f1984c[i11] = v11;
    }

    public static String g(androidx.collection.l0<K, Object> l0Var) {
        return "MutableScatterMultiMap(map=" + l0Var + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f3411a, obj);
    }

    public final /* synthetic */ androidx.collection.l0 h() {
        return this.f3411a;
    }

    public int hashCode() {
        return d(this.f3411a);
    }

    public String toString() {
        return g(this.f3411a);
    }
}

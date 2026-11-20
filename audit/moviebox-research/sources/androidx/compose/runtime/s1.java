package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class s1<T> extends q<T> {
    public s1(Function0<? extends T> function0) {
        super(function0, null);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034 A[PHI: r5
  0x0034: PHI (r5v2 java.lang.Object) = (r5v5 java.lang.Object), (r5v6 java.lang.Object) binds: [B:17:0x0044, B:12:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.compose.runtime.q
    public g3<T> b(t1<T> t1Var, g3<T> g3Var) {
        x xVar;
        c3 c3Var;
        f0 f0Var = null;
        if (g3Var instanceof f0) {
            if (t1Var.i()) {
                f0Var = (f0) g3Var;
                f0Var.b().setValue(t1Var.d());
            }
        } else if (g3Var instanceof c3) {
            if (t1Var.j()) {
                c3Var = (c3) g3Var;
                if (Intrinsics.b(t1Var.d(), c3Var.b())) {
                    Object obj = xVar;
                    obj = c3Var;
                    f0Var = (g3<T>) obj;
                }
            }
        } else if (g3Var instanceof x) {
            xVar = (x) g3Var;
            if (t1Var.c() == xVar.b()) {
                Object obj2 = xVar;
                obj2 = c3Var;
                f0Var = (g3<T>) obj2;
            }
        }
        return f0Var == null ? f(t1Var) : f0Var;
    }

    public abstract t1<T> c(T t11);

    public final t1<T> d(T t11) {
        return c(t11);
    }

    public final t1<T> e(T t11) {
        return c(t11).h();
    }

    public final g3<T> f(t1<T> t1Var) {
        if (!t1Var.i()) {
            if (t1Var.c() != null) {
                return new x(t1Var.c());
            }
            return t1Var.f() != null ? new f0(t1Var.f()) : new c3(t1Var.d());
        }
        i1<T> i1VarF = t1Var.f();
        if (i1VarF == null) {
            T tG = t1Var.g();
            q2<T> q2VarE = t1Var.e();
            if (q2VarE == null) {
                q2VarE = r2.j();
            }
            i1VarF = r2.e(tG, q2VarE);
        }
        return new f0(i1VarF);
    }
}

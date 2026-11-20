package androidx.compose.runtime;

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
public final class t {
    public static final <T> boolean a(n1 n1Var, q<T> qVar) {
        Intrinsics.e(qVar, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return n1Var.containsKey(qVar);
    }

    public static final <T> T b(n1 n1Var, q<T> qVar) {
        Intrinsics.e(qVar, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        g3<T> g3VarA = (g3<T>) n1Var.get(qVar);
        if (g3VarA == null) {
            g3VarA = qVar.a();
        }
        return (T) g3VarA.a(n1Var);
    }

    public static final n1 c(t1<?>[] t1VarArr, n1 n1Var, n1 n1Var2) {
        androidx.compose.runtime.internal.e.a aVarY = androidx.compose.runtime.internal.f.a().builder();
        for (t1<?> t1Var : t1VarArr) {
            q<?> qVarB = t1Var.b();
            Intrinsics.e(qVarB, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            s1 s1Var = (s1) qVarB;
            if (t1Var.a() || !a(n1Var, s1Var)) {
                g3 g3Var = (g3) n1Var2.get(s1Var);
                Intrinsics.e(t1Var, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
                aVarY.put(s1Var, s1Var.b(t1Var, g3Var));
            }
        }
        return aVarY.build();
    }

    public static /* synthetic */ n1 d(t1[] t1VarArr, n1 n1Var, n1 n1Var2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            n1Var2 = androidx.compose.runtime.internal.f.a();
        }
        return c(t1VarArr, n1Var, n1Var2);
    }
}

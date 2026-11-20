package androidx.compose.runtime.internal;

import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.u1;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3439a = new Object();

    public static final int a(int i11, int i12) {
        return i11 << (((i12 % 10) * 3) + 1);
    }

    public static final a b(i iVar, int i11, boolean z11, Object obj) {
        ComposableLambdaImpl composableLambdaImpl;
        iVar.C(Integer.rotateLeft(i11, 1), f3439a);
        Object objY = iVar.y();
        if (objY == i.f3413a.a()) {
            composableLambdaImpl = new ComposableLambdaImpl(i11, z11, obj);
            iVar.p(composableLambdaImpl);
        } else {
            Intrinsics.e(objY, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            composableLambdaImpl = (ComposableLambdaImpl) objY;
            composableLambdaImpl.i(obj);
        }
        iVar.O();
        return composableLambdaImpl;
    }

    public static final a c(int i11, boolean z11, Object obj) {
        return new ComposableLambdaImpl(i11, z11, obj);
    }

    public static final int d(int i11) {
        return a(2, i11);
    }

    public static final a e(int i11, boolean z11, Object obj, i iVar, int i12) {
        if (k.J()) {
            k.S(-1573003438, i12, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:628)");
        }
        Object objY = iVar.y();
        if (objY == i.f3413a.a()) {
            objY = new ComposableLambdaImpl(i11, z11, obj);
            iVar.p(objY);
        }
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) objY;
        composableLambdaImpl.i(obj);
        if (k.J()) {
            k.R();
        }
        return composableLambdaImpl;
    }

    public static final boolean f(u1 u1Var, u1 u1Var2) {
        if (u1Var != null) {
            if ((u1Var instanceof RecomposeScopeImpl) && (u1Var2 instanceof RecomposeScopeImpl)) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) u1Var;
                if (!recomposeScopeImpl.r() || Intrinsics.b(u1Var, u1Var2) || Intrinsics.b(recomposeScopeImpl.i(), ((RecomposeScopeImpl) u1Var2).i())) {
                }
            }
            return false;
        }
        return true;
    }

    public static final int g(int i11) {
        return a(1, i11);
    }
}

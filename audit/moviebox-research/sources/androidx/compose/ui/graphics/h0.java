package androidx.compose.ui.graphics;

import android.graphics.Canvas;
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
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Canvas f4147a = new Canvas();

    public static final o1 a(g4 g4Var) {
        g0 g0Var = new g0();
        g0Var.w(new Canvas(q0.b(g4Var)));
        return g0Var;
    }

    public static final o1 b(Canvas canvas) {
        g0 g0Var = new g0();
        g0Var.w(canvas);
        return g0Var;
    }

    public static final Canvas d(o1 o1Var) {
        Intrinsics.e(o1Var, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((g0) o1Var).v();
    }
}

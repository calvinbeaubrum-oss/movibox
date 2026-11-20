package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f5886a = h0.a();

    public o0 a(n0 n0Var, a0 a0Var, Function1<? super o0.b, Unit> function1, Function1<? super n0, ? extends Object> function2) {
        Typeface typefaceB;
        i iVarC = n0Var.c();
        if (iVarC == null || (iVarC instanceof f)) {
            typefaceB = this.f5886a.b(n0Var.f(), n0Var.d());
        } else if (iVarC instanceof x) {
            typefaceB = this.f5886a.a((x) n0Var.c(), n0Var.f(), n0Var.d());
        } else {
            if (!(iVarC instanceof y)) {
                return null;
            }
            k0 k0VarF = ((y) n0Var.c()).f();
            Intrinsics.e(k0VarF, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typefaceB = ((androidx.compose.ui.text.platform.g) k0VarF).a(n0Var.f(), n0Var.d(), n0Var.e());
        }
        return new o0.b(typefaceB, false, 2, null);
    }
}

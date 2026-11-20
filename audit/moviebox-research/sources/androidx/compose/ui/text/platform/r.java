package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.a3;
import kotlin.Metadata;
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
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a3<Object> f6032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f6033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6034c;

    public r(a3<? extends Object> a3Var, r rVar) {
        this.f6032a = a3Var;
        this.f6033b = rVar;
        this.f6034c = a3Var.getValue();
    }

    public final Typeface a() {
        Object obj = this.f6034c;
        Intrinsics.e(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean b() {
        r rVar;
        return this.f6032a.getValue() != this.f6034c || ((rVar = this.f6033b) != null && rVar.b());
    }
}

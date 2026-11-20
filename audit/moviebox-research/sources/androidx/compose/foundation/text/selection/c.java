package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.a0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<androidx.compose.ui.layout.m> f3008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<a0> f3009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3010d = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public c(long j11, Function0<? extends androidx.compose.ui.layout.m> function0, Function0<a0> function1) {
        this.f3007a = j11;
        this.f3008b = function0;
        this.f3009c = function1;
    }
}

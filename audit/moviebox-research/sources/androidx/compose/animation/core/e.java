package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import kotlin.Metadata;

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
public final class e<T, V extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i<T, V> f2062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimationEndReason f2063b;

    public e(i<T, V> iVar, AnimationEndReason animationEndReason) {
        this.f2062a = iVar;
        this.f2063b = animationEndReason;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.f2063b + ", endState=" + this.f2062a + ')';
    }
}

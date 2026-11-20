package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3021b;

    public m(long j11, long j12) {
        this.f3020a = j11;
        this.f3021b = j12;
    }

    public /* synthetic */ m(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long a() {
        return this.f3021b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return w1.m(this.f3020a, mVar.f3020a) && w1.m(this.f3021b, mVar.f3021b);
    }

    public int hashCode() {
        return (w1.s(this.f3020a) * 31) + w1.s(this.f3021b);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) w1.t(this.f3020a)) + ", selectionBackgroundColor=" + ((Object) w1.t(this.f3021b)) + ')';
    }
}

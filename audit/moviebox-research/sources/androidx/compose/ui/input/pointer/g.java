package androidx.compose.ui.input.pointer;

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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4698c;

    public g(long j11, long j12) {
        this.f4696a = j11;
        this.f4697b = j12;
        this.f4698c = y1.g.f81070b.c();
    }

    public g(long j11, long j12, long j13) {
        this(j11, j12, (DefaultConstructorMarker) null);
        this.f4698c = j13;
    }

    public /* synthetic */ g(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public /* synthetic */ g(long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12);
    }

    public final long a() {
        return this.f4698c;
    }

    public final long b() {
        return this.f4697b;
    }

    public final long c() {
        return this.f4696a;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.f4696a + ", position=" + ((Object) y1.g.t(this.f4697b)) + ')';
    }
}

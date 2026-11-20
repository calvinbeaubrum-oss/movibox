package lb;

import android.os.SystemClock;
import com.cloud.tmc.integration.utils.x;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f70170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f70171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f70172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f70173d = x.f31135a.a();

    public final void a() {
        this.f70172c++;
    }

    public final void b() {
        this.f70172c = 0;
    }

    public final b c() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f70171b = jElapsedRealtime;
        long j11 = this.f70170a;
        return new b(j11, jElapsedRealtime, jElapsedRealtime - j11, this.f70172c, this.f70173d);
    }

    public final void d() {
        this.f70170a = SystemClock.elapsedRealtime();
    }
}

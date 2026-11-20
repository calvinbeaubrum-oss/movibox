package f00;

import android.text.format.Formatter;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.m;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f64494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f64495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f64496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f64497f;

    public e(String path, String state, boolean z11, boolean z12) {
        long jM;
        Intrinsics.g(path, "path");
        Intrinsics.g(state, "state");
        this.f64492a = path;
        this.f64493b = state;
        this.f64494c = z11;
        this.f64495d = z12;
        long jL = 0;
        try {
            jM = m.m(path);
        } catch (Throwable unused) {
            jM = 0;
        }
        this.f64496e = jM;
        try {
            jL = m.l(path);
        } catch (Throwable unused2) {
        }
        this.f64497f = jL;
    }

    public final long a() {
        return this.f64497f;
    }

    public final String b() {
        return this.f64492a;
    }

    public final boolean c() {
        return this.f64494c;
    }

    public String toString() {
        return "SDCardInfo {path = " + this.f64492a + ", state = " + this.f64493b + ", isRemovable = " + this.f64494c + ", isEmulated = " + this.f64495d + ", totalSize = " + Formatter.formatFileSize(Utils.a(), this.f64496e) + ", availableSize = " + Formatter.formatFileSize(Utils.a(), this.f64497f) + "}";
    }
}

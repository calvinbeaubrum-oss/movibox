package je;

import android.os.Bundle;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f67993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f67994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f67995c;

    public a(int i11, String event, Bundle data) {
        Intrinsics.g(event, "event");
        Intrinsics.g(data, "data");
        this.f67993a = i11;
        this.f67994b = event;
        this.f67995c = data;
    }

    public final int a() {
        return this.f67993a;
    }

    public final Bundle b() {
        return this.f67995c;
    }

    public final String c() {
        return this.f67994b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f67993a == aVar.f67993a && Intrinsics.b(this.f67994b, aVar.f67994b) && Intrinsics.b(this.f67995c, aVar.f67995c);
    }

    public int hashCode() {
        return (((this.f67993a * 31) + this.f67994b.hashCode()) * 31) + this.f67995c.hashCode();
    }

    public String toString() {
        return "AthenaDataBean(athenaAppId=" + this.f67993a + ", event=" + this.f67994b + ", data=" + this.f67995c + ')';
    }
}

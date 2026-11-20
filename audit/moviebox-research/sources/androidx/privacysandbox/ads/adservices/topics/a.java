package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12351b;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.topics.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class C0112a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12352a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12353b = true;

        public final a a() {
            if (this.f12352a.length() > 0) {
                return new a(this.f12352a, this.f12353b);
            }
            throw new IllegalStateException("adsSdkName must be set".toString());
        }

        public final C0112a b(String adsSdkName) {
            Intrinsics.g(adsSdkName, "adsSdkName");
            this.f12352a = adsSdkName;
            return this;
        }

        public final C0112a c(boolean z11) {
            this.f12353b = z11;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public a(String adsSdkName, boolean z11) {
        Intrinsics.g(adsSdkName, "adsSdkName");
        this.f12350a = adsSdkName;
        this.f12351b = z11;
    }

    public /* synthetic */ a(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? false : z11);
    }

    public final String a() {
        return this.f12350a;
    }

    @JvmName
    public final boolean b() {
        return this.f12351b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f12350a, aVar.f12350a) && this.f12351b == aVar.f12351b;
    }

    public int hashCode() {
        return (this.f12350a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f12351b);
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.f12350a + ", shouldRecordObservation=" + this.f12351b;
    }
}

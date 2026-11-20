package androidx.compose.ui.window;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureFlagPolicy f6260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6262e;

    public c() {
        this(false, false, null, false, false, 31, null);
    }

    public c(boolean z11, boolean z12, SecureFlagPolicy secureFlagPolicy, boolean z13, boolean z14) {
        this.f6258a = z11;
        this.f6259b = z12;
        this.f6260c = secureFlagPolicy;
        this.f6261d = z13;
        this.f6262e = z14;
    }

    public /* synthetic */ c(boolean z11, boolean z12, SecureFlagPolicy secureFlagPolicy, boolean z13, boolean z14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i11 & 8) != 0 ? true : z13, (i11 & 16) != 0 ? true : z14);
    }

    public c(boolean z11, boolean z12, boolean z13) {
        this(z11, z12, SecureFlagPolicy.Inherit, z13, true);
    }

    public /* synthetic */ c(boolean z11, boolean z12, boolean z13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (i11 & 4) != 0 ? true : z13);
    }

    public final boolean a() {
        return this.f6262e;
    }

    public final boolean b() {
        return this.f6258a;
    }

    public final boolean c() {
        return this.f6259b;
    }

    public final SecureFlagPolicy d() {
        return this.f6260c;
    }

    public final boolean e() {
        return this.f6261d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6258a == cVar.f6258a && this.f6259b == cVar.f6259b && this.f6260c == cVar.f6260c && this.f6261d == cVar.f6261d && this.f6262e == cVar.f6262e;
    }

    public int hashCode() {
        return (((((((androidx.compose.foundation.e.a(this.f6258a) * 31) + androidx.compose.foundation.e.a(this.f6259b)) * 31) + this.f6260c.hashCode()) * 31) + androidx.compose.foundation.e.a(this.f6261d)) * 31) + androidx.compose.foundation.e.a(this.f6262e);
    }
}

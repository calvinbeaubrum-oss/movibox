package androidx.navigation;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
    public final int f12236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f12237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f12238c;

    @JvmOverloads
    public c(int i11, l lVar, Bundle bundle) {
        this.f12236a = i11;
        this.f12237b = lVar;
        this.f12238c = bundle;
    }

    public /* synthetic */ c(int i11, l lVar, Bundle bundle, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : lVar, (i12 & 4) != 0 ? null : bundle);
    }

    public final Bundle a() {
        return this.f12238c;
    }

    public final int b() {
        return this.f12236a;
    }

    public final l c() {
        return this.f12237b;
    }

    public final void d(Bundle bundle) {
        this.f12238c = bundle;
    }

    public final void e(l lVar) {
        this.f12237b = lVar;
    }
}

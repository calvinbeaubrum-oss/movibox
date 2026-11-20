package androidx.compose.foundation.lazy;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.n2;
import com.google.android.gms.common.api.Api;
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
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e1 f2585a = n2.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e1 f2586b = n2.a(Api.BaseClientBuilder.API_PRIORITY_OTHER);

    public final void a(int i11, int i12) {
        this.f2585a.setIntValue(i11);
        this.f2586b.setIntValue(i12);
    }
}

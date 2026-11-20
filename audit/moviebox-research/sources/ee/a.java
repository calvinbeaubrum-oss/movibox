package ee;

import android.view.View;
import android.webkit.WebChromeClient;
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
public final class a implements zc.a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zc.d f64075a;

    public a(zc.d dVar) {
        this.f64075a = dVar;
    }

    @Override // zc.a
    public void a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        zc.d dVar = this.f64075a;
        if (dVar != null) {
            dVar.a(view, customViewCallback);
        }
    }

    @Override // zc.a
    public void b() {
        zc.d dVar = this.f64075a;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // ee.d
    public void c(zc.d dVar) {
        this.f64075a = dVar;
    }
}

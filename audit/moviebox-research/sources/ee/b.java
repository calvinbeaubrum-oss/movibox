package ee;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import kotlin.Metadata;
import zc.o;

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
public final class b implements o, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zc.f f64076a;

    public b(zc.f fVar) {
        this.f64076a = fVar;
    }

    @Override // ee.f
    public void d(zc.f fVar) {
        this.f64076a = fVar;
    }

    @Override // zc.o
    public void onPageFinished(WebView webView, String str) {
        zc.f fVar = this.f64076a;
        if (fVar != null) {
            fVar.onPageFinished(webView, str);
        }
    }

    @Override // zc.o
    public void onPageStarted(WebView webView, String str) {
        zc.f fVar = this.f64076a;
        if (fVar != null) {
            fVar.onPageStarted(webView, str);
        }
    }

    @Override // zc.o
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zc.f fVar = this.f64076a;
        if (fVar != null) {
            fVar.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // zc.o
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        zc.f fVar = this.f64076a;
        if (fVar != null) {
            fVar.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // zc.o
    public Boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        zc.f fVar = this.f64076a;
        Boolean boolShouldOverrideUrlLoading = fVar != null ? fVar.shouldOverrideUrlLoading(webView, webResourceRequest) : null;
        return Boolean.valueOf(boolShouldOverrideUrlLoading == null ? false : boolShouldOverrideUrlLoading.booleanValue());
    }
}

package ee;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.cloud.tmc.kernel.engine.EngineRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zc.p;

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
public final class c implements p, e, g, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f64078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zc.h f64079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ne.b f64080d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EngineRouter f64081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f64082g;

    public c(String workerId, String renderId, zc.h hVar, ne.b bVar, EngineRouter engineRouter) {
        Intrinsics.g(workerId, "workerId");
        Intrinsics.g(renderId, "renderId");
        this.f64077a = workerId;
        this.f64078b = renderId;
        this.f64079c = hVar;
        this.f64080d = bVar;
        this.f64081f = engineRouter;
    }

    @Override // ee.h
    public void a(String renderId) {
        Intrinsics.g(renderId, "renderId");
        this.f64078b = renderId;
    }

    @Override // ee.g
    public void b(WebView webView, zc.h hVar) {
        this.f64079c = hVar;
        if (hVar != null) {
            hVar.onProgressChanged(webView, this.f64082g);
        }
    }

    @Override // ee.e
    public void c(EngineRouter engineRouter) {
        this.f64081f = engineRouter;
    }

    @Override // zc.p
    public void onConsoleMessage(String consoleMessage) {
        Intrinsics.g(consoleMessage, "consoleMessage");
        ne.b bVar = this.f64080d;
        if (bVar != null) {
            bVar.a(this.f64081f, this.f64077a, this.f64078b, consoleMessage);
        }
    }

    @Override // zc.p
    public void onProgressChanged(WebView webView, int i11) {
        this.f64082g = i11;
        zc.h hVar = this.f64079c;
        if (hVar != null) {
            hVar.onProgressChanged(webView, i11);
        }
    }

    @Override // zc.p
    public void onReceivedIcon(Bitmap bitmap) {
        zc.h hVar = this.f64079c;
        if (hVar != null) {
            hVar.onReceivedIcon(bitmap);
        }
    }

    @Override // zc.p
    public void onReceivedTitle(String str) {
        zc.h hVar = this.f64079c;
        if (hVar != null) {
            hVar.onReceivedTitle(str);
        }
    }

    @Override // zc.p
    public void onRequestFocus() {
        zc.h hVar = this.f64079c;
        if (hVar != null) {
            hVar.onRequestFocus();
        }
    }
}

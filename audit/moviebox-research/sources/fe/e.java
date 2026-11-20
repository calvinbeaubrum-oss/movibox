package fe;

import android.util.Log;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.render.system.SystemWebView;
import com.cloud.tmc.render.utils.WebViewExtensionKt;
import com.google.gson.JsonObject;
import java.util.HashMap;
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
public final class e implements ac.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f64856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, ac.d> f64857b;

    public e(WebView webView) {
        Intrinsics.g(webView, "webView");
        this.f64856a = webView;
        this.f64857b = new HashMap<>();
    }

    @Override // ac.a
    @RequiresApi(23)
    public void a(ac.b bVar, ac.d dVar) {
        WebMessagePort port0;
        TmcLogger.c("subPkg", "sendToRender mc");
        if (bVar != null) {
            bVar.a().addProperty("time", Long.valueOf(System.currentTimeMillis()));
            String str = "onMessage(" + bVar.a() + ')';
            p.a("miniapp", "nativeSendToRender MessageChannelBridge= " + str);
            try {
                WebView webView = this.f64856a;
                SystemWebView systemWebView = webView instanceof SystemWebView ? (SystemWebView) webView : null;
                if (systemWebView == null || (port0 = systemWebView.getPort0()) == null) {
                    return;
                }
                d.a();
                port0.postMessage(c.a(str));
            } catch (Exception e11) {
                Log.e("miniapp", "port post message: " + e11);
            }
        }
    }

    @Override // ac.a
    public ac.d b(String str) {
        return this.f64857b.get(str);
    }

    @Override // ac.a
    public void c(String str, JsonObject jsonObject) {
        WebViewExtensionKt.e(this.f64856a, "window." + str + " = " + jsonObject + ';', null, 2, null);
    }
}

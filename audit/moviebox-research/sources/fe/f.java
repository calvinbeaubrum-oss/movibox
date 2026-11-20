package fe;

import android.os.Build;
import android.webkit.WebView;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import zc.k;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f64858a;

    public f(k webView) {
        Intrinsics.g(webView, "webView");
        this.f64858a = webView;
    }

    public final ac.a a(WebView webView) {
        Intrinsics.g(webView, "webView");
        return d() ? new e(webView) : new a(webView);
    }

    public final void b() {
        if (Build.VERSION.SDK_INT < 23 || !d()) {
            return;
        }
        this.f64858a.registerMessageChannel();
    }

    public final void c(p pVar, String msg) {
        Intrinsics.g(msg, "msg");
        if (!d()) {
            if (pVar != null) {
                pVar.onConsoleMessage(msg);
            }
        } else if (StringsKt__StringsKt.Q(msg, "DispatchEvent", false, 2, null) && StringsKt__StringsKt.Q(msg, "renderOnMessageReady", false, 2, null) && pVar != null) {
            pVar.onConsoleMessage(msg);
        }
    }

    public final boolean d() {
        try {
            String frameworkVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion();
            return (Build.VERSION.SDK_INT < 23 || (Intrinsics.b(frameworkVersion, "1.0.0") || Intrinsics.b(frameworkVersion, "0.1.0")) || this.f64858a.getMiniAppType() == MiniAppType.SHELL.getType() || this.f64858a.getMiniAppType() == MiniAppType.SHELL_GAME.getType()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }
}

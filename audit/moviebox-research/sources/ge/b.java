package ge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.render.R$drawable;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f65480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f65481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.f f65482c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f65483a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f65483a = iArr;
        }
    }

    public b(Context context, p pVar, fe.f fVar) {
        Intrinsics.g(context, "context");
        this.f65480a = context;
        this.f65481b = pVar;
        this.f65482c = fVar;
    }

    public final void a() {
        e(null);
    }

    public Context b() {
        return this.f65480a;
    }

    public p c() {
        return this.f65481b;
    }

    public fe.f d() {
        return this.f65482c;
    }

    public void e(p pVar) {
        this.f65481b = pVar;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Bitmap defaultVideoPoster = super.getDefaultVideoPoster();
        return defaultVideoPoster == null ? BitmapFactory.decodeResource(b().getResources(), R$drawable.icon_video) : defaultVideoPoster;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        super.onCloseWindow(webView);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String strMessage;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("consoleMessage = ");
        sb2.append(consoleMessage != null ? consoleMessage.sourceId() : null);
        sb2.append(" ; ");
        sb2.append(consoleMessage != null ? consoleMessage.messageLevel() : null);
        sb2.append(" ; ");
        sb2.append(consoleMessage != null ? consoleMessage.message() : null);
        sb2.append(" ; ");
        sb2.append(consoleMessage != null ? Integer.valueOf(consoleMessage.lineNumber()) : null);
        com.cloud.tmc.kernel.utils.p.e("TmcRender", sb2.toString());
        if (consoleMessage != null && (strMessage = consoleMessage.message()) != null) {
            Intrinsics.f(strMessage, "message()");
            ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
            if (messageLevel != null && a.f65483a[messageLevel.ordinal()] == 1) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", RenderAnalyseType.ERROR, strMessage);
            } else {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", RenderAnalyseType.CONSOLE, strMessage);
            }
            TmcLogger.c("juggist", "console:" + strMessage);
            fe.f fVarD = d();
            if (fVarD != null) {
                fVarD.c(c(), strMessage);
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
        return super.onCreateWindow(webView, z11, z12, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        super.onPermissionRequest(permissionRequest);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        super.onPermissionRequestCanceled(permissionRequest);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        p pVarC = c();
        if (pVarC != null) {
            pVarC.onProgressChanged(webView, i11);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
        p pVarC = c();
        if (pVarC != null) {
            pVarC.onReceivedIcon(bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        p pVarC = c();
        if (pVarC != null) {
            pVarC.onReceivedTitle(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z11) {
        super.onReceivedTouchIconUrl(webView, str, z11);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        super.onRequestFocus(webView);
        p pVarC = c();
        if (pVarC != null) {
            pVarC.onRequestFocus();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}

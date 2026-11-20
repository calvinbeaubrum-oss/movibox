package hu;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class f extends BridgeWebView.BaseJavascriptInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BridgeWebView f66793a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BridgeWebView customWebView) {
        super(customWebView.getCallbacks());
        Intrinsics.g(customWebView, "customWebView");
        this.f66793a = customWebView;
    }

    public final String a() {
        ArrayList arrayList = new ArrayList();
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AgentPageJsBridge.HTTPS));
        ResolveInfo resolveInfoResolveActivity = applicationA.getPackageManager().resolveActivity(intent, 65536);
        String str = null;
        String str2 = (resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo : null) != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        if (str2 != null && !Intrinsics.b(str2, "android")) {
            return str2;
        }
        List<ResolveInfo> listQueryIntentActivities = applicationA.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.f(listQueryIntentActivities, "context.packageManager.q…ivities(browserIntent, 0)");
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        String str3 = null;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if ((activityInfo.flags & 1) != 0) {
                str = activityInfo.packageName;
            } else {
                str3 = activityInfo.packageName;
                arrayList.add(str3);
            }
        }
        if (arrayList.contains("com.android.chrome")) {
            return "com.android.chrome";
        }
        if (str != null) {
            str2 = str;
        }
        return str3 != null ? str3 : str2;
    }

    public final boolean b() {
        return l.v("huawei", Build.MANUFACTURER, true);
    }

    @JavascriptInterface
    public void close() {
    }

    @JavascriptInterface
    public void openBrowser(String url) {
        Intrinsics.g(url, "url");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("openBrowser() --> url = ");
        sb2.append(url);
        try {
            Intent uri = l.L(url, "intent", false, 2, null) ? Intent.parseUri(url, 1) : new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (uri != null) {
                if (b()) {
                    uri.setPackage(a());
                }
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setFlags(ASTNode.DEOP);
            }
            Utils.a().startActivity(uri);
        } catch (Exception e11) {
            Log.e("gs_log", "openBrowser() --> url = " + url + " --> e = " + e11);
        }
    }

    @Override // com.github.lzyzsd.jsbridge.BridgeWebView.BaseJavascriptInterface
    public String send(String str) {
        return "send";
    }
}

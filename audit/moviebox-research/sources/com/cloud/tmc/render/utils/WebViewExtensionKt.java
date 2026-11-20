package com.cloud.tmc.render.utils;

import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.cloud.tmc.kernel.utils.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class WebViewExtensionKt {
    public static final void b(WebView webView, ADJSI adjsi) {
        Intrinsics.g(webView, "<this>");
        Intrinsics.g(adjsi, "adjsi");
        webView.addJavascriptInterface(adjsi, "ad");
    }

    public static final void c(WebView webView, FullScreenJSI fullScreenJSI) {
        Intrinsics.g(webView, "<this>");
        Intrinsics.g(fullScreenJSI, "fullScreenJSI");
        webView.addJavascriptInterface(fullScreenJSI, "dltFullScreen");
    }

    public static final void d(final WebView webView, final String jsScript, final Function1<? super String, Unit> function1) {
        Intrinsics.g(webView, "<this>");
        Intrinsics.g(jsScript, "jsScript");
        if (jsScript.length() == 0) {
            return;
        }
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.render.utils.WebViewExtensionKt$executeJavascript$runnable$1

            /* JADX INFO: compiled from: source.java */
            @Metadata
            public static final class a implements ValueCallback<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Function1<String, Unit> f32138a;

                /* JADX WARN: Multi-variable type inference failed */
                public a(Function1<? super String, Unit> function1) {
                    this.f32138a = function1;
                }

                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    Function1<String, Unit> function1 = this.f32138a;
                    if (function1 != null) {
                        function1.invoke(str);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str = jsScript;
                if (!l.L(str, "javascript", false, 2, null)) {
                    str = "javascript:" + jsScript;
                }
                p.a("miniapp", "nativeSendToRender DefaultRenderBridge= " + str);
                try {
                    webView.evaluateJavascript(str, new a(function1));
                } catch (Exception e11) {
                    p.d("TmcRender", "evaluateJavascript error = " + e11, true);
                    webView.loadUrl(str);
                }
            }
        };
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cloud.tmc.render.utils.a
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewExtensionKt.f(function0);
                }
            });
        }
    }

    public static /* synthetic */ void e(WebView webView, String str, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        d(webView, str, function1);
    }

    public static final void f(Function0 runnable) {
        Intrinsics.g(runnable, "$runnable");
        runnable.invoke();
    }
}

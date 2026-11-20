package com.cloud.tmc.integration.bridge;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.cloud.tmc.integration.proxy.PathProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class ScreenShotBridge implements BridgeExtension {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.io.File] */
    public static final void d(App app, Ref.ObjectRef fl2, Ref.ObjectRef bitmap, int i11, Function2 callBack, int i12) {
        Intrinsics.g(app, "$app");
        Intrinsics.g(fl2, "$fl");
        Intrinsics.g(bitmap, "$bitmap");
        Intrinsics.g(callBack, "$callBack");
        if (i12 != 0) {
            callBack.invoke(null, Boolean.FALSE);
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
            String str = File.separator;
            sb2.append(str);
            sb2.append("temp_data");
            sb2.append(str);
            sb2.append("screenshot");
            sb2.append(System.currentTimeMillis());
            sb2.append(".jpg");
            String string = sb2.toString();
            fl2.element = new File(string);
            com.cloud.tmc.miniutils.util.j.l(string);
            ((Bitmap) bitmap.element).compress(Bitmap.CompressFormat.JPEG, i11, new FileOutputStream((File) fl2.element));
            callBack.invoke(fl2.element, Boolean.TRUE);
        } catch (Throwable th2) {
            TmcLogger.h("getBitmapFromWebView error", th2);
            callBack.invoke(null, Boolean.FALSE);
        }
    }

    public static /* synthetic */ File getBitmapFromWebView$default(ScreenShotBridge screenShotBridge, App app, WebView webView, int i11, Function2 function2, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 95;
        }
        return screenShotBridge.c(app, webView, i11, function2);
    }

    @RequiresApi(26)
    public final void b(Window window, View view, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i11 = iArr[0];
        PixelCopy.request(window, new Rect(i11, iArr[1], view.getWidth() + i11, iArr[1] + view.getHeight()), bitmap, onPixelCopyFinishedListener, new Handler(Looper.getMainLooper()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [T, java.io.File] */
    public final File c(final App app, WebView webView, final int i11, final Function2<? super File, ? super Boolean, Unit> function2) {
        tb.b appContext;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (webView != null) {
            Context context = null;
            if (Build.VERSION.SDK_INT >= 26) {
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                ?? CreateBitmap = Bitmap.createBitmap(webView.getWidth(), webView.getHeight(), Bitmap.Config.ARGB_8888, true);
                Intrinsics.f(CreateBitmap, "createBitmap(view2.width…p.Config.ARGB_8888, true)");
                objectRef2.element = CreateBitmap;
                if (app != null && (appContext = app.getAppContext()) != null) {
                    context = appContext.getContext();
                }
                Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
                Window window = ((Activity) context).getWindow();
                Intrinsics.f(window, "app?.appContext?.context as Activity).window");
                b(window, webView, (Bitmap) objectRef2.element, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.cloud.tmc.integration.bridge.k
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i12) {
                        ScreenShotBridge.d(app, objectRef, objectRef2, i11, function2, i12);
                    }
                });
            } else {
                webView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = webView.getDrawingCache();
                Bitmap bitmapCreateBitmap = (drawingCache == null || drawingCache.isRecycled()) ? null : Bitmap.createBitmap(drawingCache);
                if (bitmapCreateBitmap != null) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(((PathProxy) tc.a.a(PathProxy.class)).getAppBaseFilePath(app.getAppId()));
                        String str = File.separator;
                        sb2.append(str);
                        sb2.append("temp_data");
                        sb2.append(str);
                        sb2.append("screenshot");
                        sb2.append(System.currentTimeMillis());
                        sb2.append(".jpg");
                        String string = sb2.toString();
                        objectRef.element = new File(string);
                        com.cloud.tmc.miniutils.util.j.l(string);
                        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 95, new FileOutputStream((File) objectRef.element));
                        function2.invoke(objectRef.element, Boolean.TRUE);
                    } catch (Throwable th2) {
                        TmcLogger.h("getBitmapFromWebView error", th2);
                        function2.invoke(null, Boolean.FALSE);
                    }
                }
            }
        }
        return (File) objectRef.element;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a("")
    @zb.e(ExecutorType.IO)
    public final void takeScreenshot(@cc.f(App.class) final App app, @cc.f(Page.class) Page page, @cc.g(intDefault = 80, name = {"quality"}) int i11, @cc.c final bc.a aVar) {
        zc.i render;
        try {
            if (i11 < 0 || i11 > 100) {
                if (aVar != null) {
                    aVar.e(z.a().d("errMsg", "Quality must be 0..100: TS10003").e());
                    return;
                }
                return;
            }
            View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
            WebView webView = view instanceof WebView ? (WebView) view : null;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (webView == null || app == null || app.getAppId() == null) {
                return;
            }
            c(app, webView, i11, new Function2<File, Boolean, Unit>() { // from class: com.cloud.tmc.integration.bridge.ScreenShotBridge$takeScreenshot$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(File file, Boolean bool) {
                    invoke(file, bool.booleanValue());
                    return Unit.f68710a;
                }

                /* JADX WARN: Type inference failed for: r9v4, types: [T, java.lang.String] */
                public final void invoke(File file, boolean z11) {
                    if (!z11) {
                        bc.a aVar2 = aVar;
                        if (aVar2 != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("errMsg", "Failed, generate bitmap error: TS10002");
                            aVar2.e(jsonObject);
                            return;
                        }
                        return;
                    }
                    if (file != null) {
                        objectRef.element = ((IFileResourceManager) tc.a.a(IFileResourceManager.class)).generateVUrl(file.getAbsolutePath(), app.getAppId(), file.getName(), "temp_data", false);
                    } else {
                        bc.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.b();
                        }
                    }
                    bc.a aVar4 = aVar;
                    if (aVar4 != null) {
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty(NativeRequestBridge.KEY_FILE_PATH, objectRef.element);
                        aVar4.d(jsonObject2);
                    }
                }
            });
        } catch (Throwable th2) {
            TmcLogger.h("takeScreenshot error", th2);
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "Failed, unknown error: TS10001");
                aVar.e(jsonObject);
            }
        }
    }
}

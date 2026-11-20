package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.performance.innerrender.IInnerRenderPool;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.resource.FileResourceManager;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.AddHomeToScreenUtils;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.j0;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.z;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.push.PushConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import org.mvel2.ast.ASTNode;

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
@SourceDebugExtension
public final class SystemAbilityBridge implements BridgeExtension {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements wc.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaType f30582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f30583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f30584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f30585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f30586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f30587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f30588g;

        public b(String str, Function0<Unit> function0, String str2, String str3, String str4, Function0<Unit> function1) {
            this.f30583b = str;
            this.f30584c = function0;
            this.f30585d = str2;
            this.f30586e = str3;
            this.f30587f = str4;
            this.f30588g = function1;
        }

        @Override // wc.f
        public /* synthetic */ void a(String str, int i11, String str2, long j11, long j12) {
            wc.e.a(this, str, i11, str2, j11, j12);
        }

        @Override // wc.f
        public void b(String str, String str2, String str3, IOException iOException, String str4) {
            com.cloud.tmc.miniutils.util.j.n(this.f30585d);
            Function0<Unit> function0 = this.f30584c;
            if (function0 != null) {
                function0.invoke();
            }
            TmcLogger.f("SystemAbilityBridge", "onFailed url: " + str + " errorCode: " + str2 + " errorMsg: " + str3 + " callbackId: " + str4);
        }

        @Override // wc.f
        public void c(String str, String str2) {
            String str3;
            String strG;
            File file = new File(this.f30585d);
            String strSpecifyVUrl = null;
            try {
                MediaType mediaType = this.f30582a;
                String strSubtype = mediaType != null ? mediaType.subtype() : null;
                if (strSubtype != null && strSubtype.length() != 0 && (strG = FileUtil.G(file.getAbsolutePath())) != null && strG.length() != 0 && !Intrinsics.b(strSubtype, strG)) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.f(absolutePath, "downloadFile.absolutePath");
                    int iJ0 = StringsKt__StringsKt.j0(absolutePath, String.valueOf(strG), 0, false, 6, null);
                    if (iJ0 != -1) {
                        String absolutePath2 = file.getAbsolutePath();
                        Intrinsics.f(absolutePath2, "downloadFile.absolutePath");
                        String strSubstring = absolutePath2.substring(0, iJ0);
                        Intrinsics.f(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        String str4 = strSubstring + strSubtype;
                        xb.b.g(file, new File(str4), true, false);
                        file = new File(str4);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.g("SystemAbilityBridge", "Error downloading extension failed!", th2);
            }
            try {
                Uri uri = Uri.parse(this.f30586e);
                String path = uri != null ? uri.getPath() : null;
                Object objA = tc.a.a(IFileResourceManager.class);
                FileResourceManager fileResourceManager = objA instanceof FileResourceManager ? (FileResourceManager) objA : null;
                String vhost = fileResourceManager != null ? fileResourceManager.getVhost(this.f30587f) : null;
                if (path == null || !kotlin.text.l.L(path, "/", false, 2, null)) {
                    str3 = vhost + File.separator + path;
                } else {
                    str3 = vhost + path;
                }
                if (fileResourceManager != null) {
                    strSpecifyVUrl = fileResourceManager.specifyVUrl(str3, file.getAbsolutePath(), this.f30587f, false);
                }
            } catch (Throwable th3) {
                TmcLogger.h("SystemAbilityBridge", th3);
            }
            Function0<Unit> function0 = this.f30588g;
            if (function0 != null) {
                function0.invoke();
            }
            TmcLogger.c("SystemAbilityBridge", "onFinish url: " + str + " callbackId: " + str2 + " fileVUrl: " + strSpecifyVUrl);
        }

        @Override // wc.d
        public boolean d(MediaType mediaType) {
            TmcLogger.c("SystemAbilityBridge", "contentType: " + mediaType);
            if (mediaType == null) {
                return true;
            }
            this.f30582a = mediaType;
            String strType = mediaType.type();
            String str = this.f30583b;
            if (str == null) {
                return true;
            }
            return Intrinsics.b(str, strType);
        }

        @Override // wc.d
        public boolean e(Headers headers) {
            Intrinsics.g(headers, "headers");
            return true;
        }

        @Override // wc.f
        public void f(String str, int i11, String str2) {
            TmcLogger.c("SystemAbilityBridge", "onProgress url: " + str + " progress: " + i11 + " callbackId: " + str2);
        }

        @Override // wc.f
        public void g(String str, String str2) {
            Function0<Unit> function0 = this.f30584c;
            if (function0 != null) {
                function0.invoke();
            }
            TmcLogger.c("SystemAbilityBridge", "onCancel url: " + str + " callbackId: " + str2);
        }
    }

    public static final void f(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    public static final void g(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    public static final void h(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    public static final void i(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void addToHomeScreen(@cc.f(App.class) App app, @cc.g({RequestParameters.SUBRESOURCE_LOCATION}) String location, @cc.c bc.a callback) {
        Intrinsics.g(location, "location");
        Intrinsics.g(callback, "callback");
        try {
            callback.b();
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void addToHomeScreenByLogoLink(@cc.f(App.class) App app, @cc.g({PushConstants.PROVIDER_FIELD_APP_ID}) String appId, @cc.g({"appName"}) String appName, @cc.g({"appLogoLink"}) String appLogoLink, @cc.g({RequestParameters.SUBRESOURCE_LOCATION}) String location, @cc.g({"showConfirmDialog"}) boolean z11, @cc.g(booleanDefault = true, value = {"showSuccessToast"}) boolean z12, @cc.g(stringDefault = "", value = {"extraData"}) String extraData, @cc.c bc.a callback) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogoLink, "appLogoLink");
        Intrinsics.g(location, "location");
        Intrinsics.g(extraData, "extraData");
        Intrinsics.g(callback, "callback");
        try {
            TmcLogger.c("SystemAbilityBridge", "extraData->" + extraData);
            callback.b();
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void addToHomeScreenInternal(@cc.f(App.class) App app, @cc.g({RequestParameters.SUBRESOURCE_LOCATION}) String location, @cc.g({"showConfirmDialog"}) boolean z11, @cc.g(booleanDefault = true, value = {"showSuccessToast"}) boolean z12, @cc.c bc.a callback) {
        Intrinsics.g(location, "location");
        Intrinsics.g(callback, "callback");
        try {
            callback.b();
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void backExitInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        List<qb.a> interceptors;
        IBackPressedProcessor backPressedProcessor;
        Intrinsics.g(callback, "callback");
        Object obj = null;
        if (app != null) {
            try {
                IBackPressedProcessor backPressedProcessor2 = app.getBackPressedProcessor();
                if (backPressedProcessor2 != null && (interceptors = backPressedProcessor2.getInterceptors()) != null) {
                    for (Object obj2 : interceptors) {
                        if (Intrinsics.b(((qb.a) obj2).a(), "BackExitIntercept")) {
                            obj = obj2;
                            break;
                        }
                    }
                    obj = (qb.a) obj;
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject);
                return;
            }
        }
        if (obj == null || !(obj instanceof pb.a)) {
            if (app != null && (backPressedProcessor = app.getBackPressedProcessor()) != null) {
                pb.a aVar = new pb.a();
                aVar.h(callback);
                backPressedProcessor.addInterceptors(aVar);
            }
            TmcLogger.c("SystemAbilityBridge", "backExitInterceptor success");
            return;
        }
        bc.a aVarF = ((pb.a) obj).f();
        if (aVarF != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "backExitIntercept updated");
            aVarF.e(jsonObject2);
        }
        ((pb.a) obj).h(callback);
        TmcLogger.c("SystemAbilityBridge", "backExitInterceptor updated");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void cancelBackExitInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        List<qb.a> interceptors;
        Object next;
        bc.a aVarF;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                IBackPressedProcessor backPressedProcessor = app.getBackPressedProcessor();
                if (backPressedProcessor != null && (interceptors = backPressedProcessor.getInterceptors()) != null) {
                    Iterator<T> it = interceptors.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((qb.a) next).a(), "BackExitIntercept"));
                    qb.a aVar = (qb.a) next;
                    if (aVar != null) {
                        if ((aVar instanceof pb.a) && (aVarF = ((pb.a) aVar).f()) != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("errMsg", "backExitIntercept removed");
                            aVarF.e(jsonObject);
                        }
                        TmcLogger.c("SystemAbilityBridge", "cancelBackExitInterceptor success");
                        app.getBackPressedProcessor().removeInterceptors(aVar);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject2);
                return;
            }
        }
        callback.g();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0013, B:11:0x002b), top: B:16:0x0007 }] */
    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void darkThemeIsEnabled(@cc.f(App.class) App app, @cc.g({"action"}) String str, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else {
                    boolean zA = z.a(context);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("darkThemeEnableStatus", Boolean.valueOf(zA));
                    callback.d(jsonObject);
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject2);
            }
        } else {
            callback.b();
        }
    }

    public final void e(App app, String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function1) {
        if (str3 != null) {
            try {
                if (str3.length() != 0) {
                    if (NetworkUtils.r()) {
                        com.cloud.tmc.miniutils.util.j.h(str4);
                        String strA = com.cloud.tmc.integration.utils.x.f31135a.a();
                        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).downloadPackage(strA, str3, str4, kotlin.collections.s.j(TuplesKt.a(NativeRequestBridge.KEY_X_BYTE_APPID, app.getAppId())), strA, new b(str2, function1, str4, str3, str, function0));
                        return;
                    } else {
                        if (function1 != null) {
                            function1.invoke();
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                return;
            }
        }
        if (function1 != null) {
            function1.invoke();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void enableExitShortcutInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                app.getBackPressedProcessor().addInterceptors(new pb.b());
                com.cloud.tmc.integration.utils.o.f31082a.f().put(app.getAppId(), app);
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
                return;
            }
        }
        callback.g();
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getExternalDeviceSize(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            callback.d(com.cloud.tmc.integration.utils.z.a().c("externalTotalSize", Long.valueOf(com.cloud.tmc.miniutils.util.v.b())).c("externalAvailableSize", Long.valueOf(com.cloud.tmc.miniutils.util.v.a())).e());
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getInternalDeviceSize(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            callback.d(com.cloud.tmc.integration.utils.z.a().c("internalTotalSize", Long.valueOf(com.cloud.tmc.miniutils.util.v.d())).c("internalAvailableSize", Long.valueOf(com.cloud.tmc.miniutils.util.v.c())).e());
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void getMenuButtonBoundingClientRect(@cc.f(Page.class) Page page, @cc.c bc.a callback) {
        Unit unit;
        Intrinsics.g(callback, "callback");
        if (page != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("width", Integer.valueOf(page.getIntValue("capsuleWidth")));
            jsonObject.addProperty("height", Integer.valueOf(page.getIntValue("capsuleHeight")));
            jsonObject.addProperty("top", Integer.valueOf(page.getIntValue("capsuleTop")));
            jsonObject.addProperty(TtmlNode.RIGHT, Integer.valueOf(page.getIntValue("capsuleRight")));
            jsonObject.addProperty("bottom", Integer.valueOf(page.getIntValue("capsuleBottom")));
            jsonObject.addProperty(TtmlNode.LEFT, Integer.valueOf(page.getIntValue("capsuleLeft")));
            callback.d(jsonObject);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void getMovieboxInfo(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    return;
                }
                callback.d(com.cloud.tmc.integration.utils.z.a().d("login_info", ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "kv_login", "login_user")).e());
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void innerBackInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        List<qb.a> interceptors;
        IBackPressedProcessor backPressedProcessor;
        Intrinsics.g(callback, "callback");
        Object obj = null;
        if (app != null) {
            try {
                IBackPressedProcessor backPressedProcessor2 = app.getBackPressedProcessor();
                if (backPressedProcessor2 != null && (interceptors = backPressedProcessor2.getInterceptors()) != null) {
                    for (Object obj2 : interceptors) {
                        if (Intrinsics.b(((qb.a) obj2).a(), "InnerBackIntercept")) {
                            obj = obj2;
                            break;
                        }
                    }
                    obj = (qb.a) obj;
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject);
                return;
            }
        }
        if (obj == null || !(obj instanceof pb.d)) {
            if (app != null && (backPressedProcessor = app.getBackPressedProcessor()) != null) {
                pb.d dVar = new pb.d();
                dVar.e(callback);
                backPressedProcessor.addInterceptors(dVar);
            }
            TmcLogger.c("SystemAbilityBridge", "innerBackInterceptor success");
            return;
        }
        bc.a aVarD = ((pb.d) obj).d();
        if (aVarD != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "innerBackInterceptor updated");
            aVarD.e(jsonObject2);
        }
        ((pb.d) obj).e(callback);
        TmcLogger.c("SystemAbilityBridge", "innerBackInterceptor updated");
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void innerCancelBackInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        List<qb.a> interceptors;
        Object next;
        bc.a aVarD;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                IBackPressedProcessor backPressedProcessor = app.getBackPressedProcessor();
                if (backPressedProcessor != null && (interceptors = backPressedProcessor.getInterceptors()) != null) {
                    Iterator<T> it = interceptors.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((qb.a) next).a(), "InnerBackIntercept"));
                    qb.a aVar = (qb.a) next;
                    if (aVar != null) {
                        if ((aVar instanceof pb.d) && (aVarD = ((pb.d) aVar).d()) != null) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.addProperty("errMsg", "innerBackInterceptor removed");
                            aVarD.e(jsonObject);
                        }
                        TmcLogger.c("SystemAbilityBridge", "innerCancelBackInterceptor success");
                        app.getBackPressedProcessor().removeInterceptors(aVar);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject2);
                return;
            }
        }
        callback.g();
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("SystemAbilityBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("SystemAbilityBridge", "onInitialized");
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0013, B:11:0x0031), top: B:16:0x0007 }] */
    @zb.a
    @zb.e(ExecutorType.UI)
    public final void openAppAuthorizeSetting(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", context.getPackageName(), null));
                    context.startActivity(intent);
                    callback.g();
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
            }
        } else {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023 A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0013, B:11:0x0023), top: B:16:0x0007 }] */
    @zb.a
    @zb.e(ExecutorType.UI)
    public final void openSystemBluetoothSetting(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else {
                    context.startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
                    callback.g();
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
            }
        } else {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0032 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:4:0x000c, B:6:0x0012, B:8:0x0018, B:11:0x0032), top: B:16:0x000c }] */
    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void openSystemSetting(@cc.f(App.class) App app, @cc.g({"delayTimeMillis"}) String delayTimeMillis, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(delayTimeMillis, "delayTimeMillis");
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else {
                    context.getApplicationContext().startActivity(new Intent("android.settings.SETTINGS").setFlags(ASTNode.DEOP));
                    callback.g();
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject);
            }
        } else {
            callback.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #0 {all -> 0x002f, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x0013, B:11:0x0031), top: B:16:0x0007 }] */
    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void openSystemSettingWithAction(@cc.f(App.class) App app, @cc.g({"action"}) String str, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext == null || (context = appContext.getContext()) == null) {
                    callback.b();
                } else {
                    context.getApplicationContext().startActivity(new Intent(xb.e.a(str, "android.settings.SETTINGS")).setFlags(ASTNode.DEOP));
                    callback.g();
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", th2.getMessage());
                callback.e(jsonObject);
            }
        } else {
            callback.b();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void preloadAssets(@cc.f(App.class) final App app, @cc.g({"data"}) JsonArray jsonArray, @cc.c bc.a callback) {
        final CountDownLatch countDownLatch;
        String str;
        String str2;
        String str3;
        String str4;
        JsonObject asJsonObject;
        String string;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        boolean z11;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        App app2 = app;
        Intrinsics.g(callback, "callback");
        if (app2 == null || jsonArray == null || jsonArray.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: PA10001");
            callback.e(jsonObject);
            return;
        }
        TmcLogger.c("SystemAbilityBridge", "preloadAssets data: " + jsonArray);
        Iterator<JsonElement> it = jsonArray.iterator();
        do {
            String str5 = "src";
            String str6 = "type";
            String str7 = "image";
            String str8 = "font";
            String asString = null;
            if (!it.hasNext()) {
                if (!NetworkUtils.r()) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errMsg", "Network is not connected: PA10003");
                    callback.e(jsonObject2);
                    return;
                }
                CountDownLatch countDownLatch2 = new CountDownLatch(jsonArray.size());
                final LinkedHashSet linkedHashSet = new LinkedHashSet();
                final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                final ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement5 : jsonArray) {
                    if (jsonElement5 != null) {
                        try {
                            asJsonObject = jsonElement5.getAsJsonObject();
                        } catch (Throwable th2) {
                            th = th2;
                            countDownLatch = countDownLatch2;
                            str = str8;
                            str2 = str7;
                            str3 = str6;
                            str4 = str5;
                            TmcLogger.h("SystemAbilityBridge", th);
                            app2 = app;
                            countDownLatch2 = countDownLatch;
                            str8 = str;
                            str7 = str2;
                            str6 = str3;
                            str5 = str4;
                        }
                    } else {
                        asJsonObject = null;
                    }
                    final String asString2 = (asJsonObject == null || (jsonElement2 = asJsonObject.get(str6)) == null) ? null : jsonElement2.getAsString();
                    final String asString3 = (asJsonObject == null || (jsonElement = asJsonObject.get(str5)) == null) ? null : jsonElement.getAsString();
                    String strG = FileUtil.G(asString3);
                    if (strG == null) {
                        strG = FileUtil.z(2);
                    }
                    String strC = xb.e.c(asString3 != null ? xb.e.d(asString3) : null);
                    if (strC == null) {
                        strC = com.cloud.tmc.integration.utils.x.f31135a.a();
                    }
                    String strF = FileUtil.f(strC, strG);
                    if (Intrinsics.b(asString2, str8)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("assets");
                        String str9 = File.separator;
                        sb2.append(str9);
                        sb2.append(str8);
                        sb2.append(str9);
                        sb2.append(strF);
                        string = sb2.toString();
                    } else if (Intrinsics.b(asString2, str7)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("assets");
                        String str10 = File.separator;
                        sb3.append(str10);
                        sb3.append(str7);
                        sb3.append(str10);
                        sb3.append(strF);
                        string = sb3.toString();
                    } else {
                        string = "assets" + File.separator + strF;
                    }
                    final File fileW = FileUtil.w(app2, string);
                    TmcLogger.c("SystemAbilityBridge", "preloadAssets download file path: " + fileW.getAbsolutePath());
                    countDownLatch = countDownLatch2;
                    final String str11 = string;
                    str = str8;
                    str2 = str7;
                    str3 = str6;
                    str4 = str5;
                    try {
                        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadAssets$4$block$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                SystemAbilityBridge systemAbilityBridge = this.this$0;
                                App app3 = app;
                                String appId = app3.getAppId();
                                Intrinsics.f(appId, "app.appId");
                                String str12 = asString2;
                                String str13 = asString3;
                                String absolutePath = fileW.getAbsolutePath();
                                Intrinsics.f(absolutePath, "downloadFile.absolutePath");
                                final App app4 = app;
                                final File file = fileW;
                                final String str14 = str11;
                                final List<Map<String, String>> list = arrayList;
                                final String str15 = asString2;
                                final String str16 = asString3;
                                final CountDownLatch countDownLatch3 = countDownLatch;
                                final Set<String> set = linkedHashSet;
                                Function0<Unit> function1 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadAssets$4$block$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        String strGenerateVUrl = app4.getIFileResourceManager().generateVUrl(file.getAbsolutePath(), app4.getAppId(), str14, "temp_data");
                                        List<Map<String, String>> list2 = list;
                                        Pair[] pairArr = new Pair[3];
                                        String str17 = str15;
                                        if (str17 == null) {
                                            str17 = "";
                                        }
                                        pairArr[0] = TuplesKt.a("type", str17);
                                        String str18 = str16;
                                        if (str18 == null) {
                                            str18 = "";
                                        }
                                        pairArr[1] = TuplesKt.a("src", str18);
                                        pairArr[2] = TuplesKt.a("saveFilePath", strGenerateVUrl);
                                        list2.add(kotlin.collections.s.j(pairArr));
                                        countDownLatch3.countDown();
                                        set.add("");
                                    }
                                };
                                final CountDownLatch countDownLatch4 = countDownLatch;
                                final Set<String> set2 = linkedHashSet2;
                                systemAbilityBridge.e(app3, appId, str12, str13, absolutePath, function1, new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadAssets$4$block$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        countDownLatch4.countDown();
                                        set2.add("");
                                    }
                                });
                            }
                        };
                        if (com.cloud.tmc.kernel.utils.e.c()) {
                            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SystemAbilityBridge.f(function0);
                                }
                            });
                        } else {
                            function0.invoke();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        TmcLogger.h("SystemAbilityBridge", th);
                    }
                    app2 = app;
                    countDownLatch2 = countDownLatch;
                    str8 = str;
                    str7 = str2;
                    str6 = str3;
                    str5 = str4;
                }
                try {
                    TmcLogger.c("SystemAbilityBridge", "await download: " + countDownLatch2.await(3L, TimeUnit.MINUTES));
                    if (!linkedHashSet.isEmpty()) {
                        JsonObject jsonObject3 = new JsonObject();
                        jsonObject3.addProperty("result", com.cloud.tmc.miniutils.util.k.j(arrayList));
                        callback.d(jsonObject3);
                    } else {
                        JsonObject jsonObject4 = new JsonObject();
                        jsonObject4.addProperty("errMsg", "Download Failed: PA10004");
                        callback.e(jsonObject4);
                    }
                    return;
                } catch (Throwable th4) {
                    TmcLogger.h("SystemAbilityBridge", th4);
                    callback.b();
                    return;
                }
            }
            JsonElement next = it.next();
            JsonObject asJsonObject2 = next != null ? next.getAsJsonObject() : null;
            String asString4 = (asJsonObject2 == null || (jsonElement4 = asJsonObject2.get("type")) == null) ? null : jsonElement4.getAsString();
            if (asJsonObject2 != null && (jsonElement3 = asJsonObject2.get("src")) != null) {
                asString = jsonElement3.getAsString();
            }
            boolean zX = CollectionsKt___CollectionsKt.X(kotlin.collections.g.h("font", "image"), asString4);
            z11 = !(asString == null || asString.length() == 0);
            if (!zX) {
                break;
            }
        } while (z11);
        JsonObject jsonObject5 = new JsonObject();
        jsonObject5.addProperty("errMsg", "Type does not match: PA10002");
        callback.e(jsonObject5);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void preloadH5Webview(@cc.f(App.class) App app, @cc.g({"delayTimeMillis"}) long j11, @cc.c final bc.a callback) {
        Intrinsics.g(callback, "callback");
        Page activePage = app != null ? app.getActivePage() : null;
        MiniAppConfigModel.WindowBean window = activePage != null ? activePage.getWindow() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preload Webview with delayTimeMillis: ");
        sb2.append(j11);
        sb2.append(" handleWebViewPreload: ");
        sb2.append(window != null ? window.getHandleWebviewPreload() : null);
        TmcLogger.c("SystemAbilityBridge", sb2.toString());
        if (0 > j11 || j11 >= 5001) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "delayTimeMillis is not in the range 0..5000: SP10003");
            callback.e(jsonObject);
            return;
        }
        try {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadH5Webview$block$1
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
                    if (((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).createWebview()) {
                        callback.g();
                    } else {
                        callback.b();
                    }
                }
            };
            if (j11 > 0) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = com.cloud.tmc.kernel.utils.e.b();
                if (scheduledThreadPoolExecutorB != null) {
                    scheduledThreadPoolExecutorB.schedule(new Runnable() { // from class: com.cloud.tmc.integration.bridge.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            SystemAbilityBridge.g(function0);
                        }
                    }, j11, TimeUnit.MILLISECONDS);
                }
            } else {
                function0.invoke();
            }
        } catch (Throwable th2) {
            TmcLogger.g("SystemAbilityBridge", "", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NETWORK)
    public final void preloadResources(@cc.f(App.class) final App app, @cc.g({"data"}) JsonArray jsonArray, @cc.c bc.a callback) {
        String asString;
        String str;
        CountDownLatch countDownLatch;
        String str2;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.g(callback, "callback");
        String str3 = "errMsg";
        if (app == null || jsonArray == null || jsonArray.isEmpty()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "Parameter error: PA10001");
            callback.e(jsonObject);
            return;
        }
        TmcLogger.c("SystemAbilityBridge", "preloadResources data: " + jsonArray);
        Iterator<JsonElement> it = jsonArray.iterator();
        do {
            String str4 = "src";
            asString = null;
            if (!it.hasNext()) {
                if (!NetworkUtils.r()) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errMsg", "Network is not connected: PA10003");
                    callback.e(jsonObject2);
                    return;
                }
                CountDownLatch countDownLatch2 = new CountDownLatch(jsonArray.size());
                final LinkedHashSet linkedHashSet = new LinkedHashSet();
                final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                final ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement4 : jsonArray) {
                    if (jsonElement4 != null) {
                        try {
                            asJsonObject = jsonElement4.getAsJsonObject();
                        } catch (Throwable th2) {
                            th = th2;
                            str = str3;
                            countDownLatch = countDownLatch2;
                            str2 = str4;
                            TmcLogger.h("SystemAbilityBridge", th);
                            countDownLatch2 = countDownLatch;
                            str3 = str;
                            str4 = str2;
                        }
                    } else {
                        asJsonObject = null;
                    }
                    final String asString2 = (asJsonObject == null || (jsonElement2 = asJsonObject.get(str4)) == null) ? null : jsonElement2.getAsString();
                    final String asString3 = (asJsonObject == null || (jsonElement = asJsonObject.get(PushConstants.PROVIDER_FIELD_APP_ID)) == null) ? null : jsonElement.getAsString();
                    String strG = FileUtil.G(asString2);
                    if (strG == null) {
                        strG = FileUtil.z(2);
                    }
                    String strC = xb.e.c(asString2 != null ? xb.e.d(asString2) : null);
                    if (strC == null) {
                        strC = com.cloud.tmc.integration.utils.x.f31135a.a();
                    }
                    final String str5 = "assets" + File.separator + FileUtil.f(strC, strG);
                    String strC2 = xb.e.c(asString3);
                    if (strC2 == null) {
                        strC2 = app.getAppId();
                        Intrinsics.f(strC2, "app.appId");
                    }
                    final String str6 = strC2;
                    final File fileX = FileUtil.x(str6, str5);
                    TmcLogger.c("SystemAbilityBridge", "preloadResources download file path: " + fileX.getAbsolutePath());
                    final CountDownLatch countDownLatch3 = countDownLatch2;
                    str = str3;
                    countDownLatch = countDownLatch2;
                    str2 = str4;
                    try {
                        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadResources$4$block$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                SystemAbilityBridge systemAbilityBridge = this.this$0;
                                App app2 = app;
                                String str7 = str6;
                                String str8 = asString2;
                                String absolutePath = fileX.getAbsolutePath();
                                Intrinsics.f(absolutePath, "downloadFile.absolutePath");
                                final App app3 = app;
                                final File file = fileX;
                                final String str9 = str5;
                                final List<Map<String, String>> list = arrayList;
                                final String str10 = asString3;
                                final String str11 = asString2;
                                final CountDownLatch countDownLatch4 = countDownLatch3;
                                final Set<String> set = linkedHashSet;
                                Function0<Unit> function1 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadResources$4$block$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        String strGenerateVUrl = app3.getIFileResourceManager().generateVUrl(file.getAbsolutePath(), app3.getAppId(), str9, "temp_data");
                                        List<Map<String, String>> list2 = list;
                                        Pair[] pairArr = new Pair[3];
                                        String str12 = str10;
                                        if (str12 == null) {
                                            str12 = "";
                                        }
                                        pairArr[0] = TuplesKt.a(PushConstants.PROVIDER_FIELD_APP_ID, str12);
                                        String str13 = str11;
                                        if (str13 == null) {
                                            str13 = "";
                                        }
                                        pairArr[1] = TuplesKt.a("src", str13);
                                        pairArr[2] = TuplesKt.a("saveFilePath", strGenerateVUrl);
                                        list2.add(kotlin.collections.s.j(pairArr));
                                        countDownLatch4.countDown();
                                        set.add("");
                                    }
                                };
                                final CountDownLatch countDownLatch5 = countDownLatch3;
                                final Set<String> set2 = linkedHashSet2;
                                systemAbilityBridge.e(app2, str7, null, str8, absolutePath, function1, new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadResources$4$block$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                        countDownLatch5.countDown();
                                        set2.add("");
                                    }
                                });
                            }
                        };
                        if (com.cloud.tmc.kernel.utils.e.c()) {
                            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: com.cloud.tmc.integration.bridge.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SystemAbilityBridge.h(function0);
                                }
                            });
                        } else {
                            function0.invoke();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        TmcLogger.h("SystemAbilityBridge", th);
                    }
                    countDownLatch2 = countDownLatch;
                    str3 = str;
                    str4 = str2;
                }
                String str7 = str3;
                try {
                    TmcLogger.c("SystemAbilityBridge", "await download: " + countDownLatch2.await(3L, TimeUnit.MINUTES));
                    if (!linkedHashSet.isEmpty()) {
                        JsonObject jsonObject3 = new JsonObject();
                        jsonObject3.addProperty("result", com.cloud.tmc.miniutils.util.k.j(arrayList));
                        callback.d(jsonObject3);
                    } else {
                        JsonObject jsonObject4 = new JsonObject();
                        jsonObject4.addProperty(str7, "Download Failed: PA10004");
                        callback.e(jsonObject4);
                    }
                    return;
                } catch (Throwable th4) {
                    TmcLogger.h("SystemAbilityBridge", th4);
                    callback.b();
                    return;
                }
            }
            JsonElement next = it.next();
            JsonObject asJsonObject2 = next != null ? next.getAsJsonObject() : null;
            if (asJsonObject2 != null && (jsonElement3 = asJsonObject2.get("src")) != null) {
                asString = jsonElement3.getAsString();
            }
            if (asString == null) {
                break;
            }
        } while (asString.length() != 0);
        JsonObject jsonObject5 = new JsonObject();
        jsonObject5.addProperty("errMsg", "Url is empty: PA10002");
        callback.e(jsonObject5);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void preloadWebview(@cc.f(App.class) App app, @cc.g({"delayTimeMillis"}) long j11, @cc.c final bc.a callback) {
        Intrinsics.g(callback, "callback");
        Page activePage = app != null ? app.getActivePage() : null;
        MiniAppConfigModel.WindowBean window = activePage != null ? activePage.getWindow() : null;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preload Webview with delayTimeMillis: ");
        sb2.append(j11);
        sb2.append(" handleWebViewPreload: ");
        sb2.append(window != null ? window.getHandleWebviewPreload() : null);
        TmcLogger.c("SystemAbilityBridge", sb2.toString());
        if (0 > j11 || j11 >= 5001) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("errMsg", "delayTimeMillis is not in the range 0..5000: SP10003");
            callback.e(jsonObject);
            return;
        }
        try {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.cloud.tmc.integration.bridge.SystemAbilityBridge$preloadWebview$block$1
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
                    if (((IInnerRenderPool) tc.a.a(IInnerRenderPool.class)).createRender(false)) {
                        callback.g();
                    } else {
                        callback.b();
                    }
                }
            };
            if (j11 > 0) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB = com.cloud.tmc.kernel.utils.e.b();
                if (scheduledThreadPoolExecutorB != null) {
                    scheduledThreadPoolExecutorB.schedule(new Runnable() { // from class: com.cloud.tmc.integration.bridge.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            SystemAbilityBridge.i(function0);
                        }
                    }, j11, TimeUnit.MILLISECONDS);
                }
            } else {
                function0.invoke();
            }
        } catch (Throwable th2) {
            TmcLogger.g("SystemAbilityBridge", "", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void queryShortcutExists(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Intrinsics.g(callback, "callback");
        try {
            if (app == null) {
                callback.b();
                return;
            }
            tb.b appContext = app.getAppContext();
            Context context = appContext != null ? appContext.getContext() : null;
            if (context == null) {
                callback.b();
            } else if (Build.VERSION.SDK_INT < 26) {
                callback.b();
            } else {
                callback.d(com.cloud.tmc.integration.utils.z.a().b("isExist", Boolean.valueOf(AppUtils.f31011a.v(context, app.getAppId()))).e());
            }
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public final void queryShortcutListExists(@cc.f(App.class) App app, @cc.g({"appIdList"}) JsonArray appIdList, @cc.g(intDefault = 15, value = {"maxLength"}) int i11, @cc.c bc.a callback) {
        String asString;
        Intrinsics.g(appIdList, "appIdList");
        Intrinsics.g(callback, "callback");
        try {
            if (app == null) {
                callback.b();
                return;
            }
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                callback.b();
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                callback.b();
                return;
            }
            if (Build.VERSION.SDK_INT < 26) {
                callback.b();
                return;
            }
            if (!appIdList.isJsonNull() && !appIdList.isEmpty()) {
                if (appIdList.size() <= i11) {
                    i11 = appIdList.size();
                }
                TmcLogger.c("SystemAbilityBridge", "queryShortcutListExists size=" + i11);
                JsonArray jsonArray = new JsonArray();
                for (int i12 = 0; i12 < i11; i12++) {
                    JsonElement jsonElement = appIdList.get(i12);
                    if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                        boolean zV = AppUtils.f31011a.v(context, asString);
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(PushConstants.PROVIDER_FIELD_APP_ID, asString);
                        jsonObject.addProperty("isExist", Boolean.valueOf(zV));
                        jsonArray.add(jsonObject);
                    }
                }
                String strA = com.cloud.tmc.kernel.utils.o.a(jsonArray);
                TmcLogger.c("SystemAbilityBridge", "queryShortcutListExists queryResult=" + strA);
                callback.d(com.cloud.tmc.integration.utils.z.a().d("queryResult", strA).e());
                return;
            }
            callback.b();
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void removeExitShortcutInterceptor(@cc.f(App.class) App app, @cc.c bc.a callback) {
        Object next;
        Intrinsics.g(callback, "callback");
        try {
            if (app == null) {
                callback.b();
                return;
            }
            Iterator<T> it = app.getBackPressedProcessor().getInterceptors().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((qb.a) next).a(), "BackToAddHomeIntercept"));
            qb.a aVar = (qb.a) next;
            if (aVar != null) {
                TmcLogger.c("SystemAbilityBridge", "removeShortcutInterceptor success");
                app.getBackPressedProcessor().removeInterceptors(aVar);
                com.cloud.tmc.integration.utils.o.f31082a.f().remove(app.getAppId());
            }
            callback.g();
        } catch (Throwable th2) {
            TmcLogger.h("SystemAbilityBridge", th2);
            callback.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void setKeepScreenOn(@cc.f(App.class) App app, @cc.g({"keepScreenOn"}) boolean z11, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    if (z11) {
                        j0.f31066a.a(context);
                    } else {
                        j0.f31066a.b();
                    }
                    callback.g();
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
                return;
            }
        }
        callback.b();
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public final void updateAddHomeLogoAndName(@cc.f(App.class) App app, @cc.g({PushConstants.PROVIDER_FIELD_APP_ID}) String str, @cc.g({"appName"}) String appName, @cc.g({"appLogoLink"}) String appLogoLink, @cc.c bc.a callback) {
        Context context;
        Intrinsics.g(appName, "appName");
        Intrinsics.g(appLogoLink, "appLogoLink");
        Intrinsics.g(callback, "callback");
        if (app != null) {
            try {
                tb.b appContext = app.getAppContext();
                if (appContext != null && (context = appContext.getContext()) != null) {
                    if (str == null || str.length() == 0) {
                        str = app.getAppId();
                    }
                    String finalAppId = str;
                    AddHomeToScreenUtils addHomeToScreenUtils = AddHomeToScreenUtils.f30986a;
                    Intrinsics.f(finalAppId, "finalAppId");
                    addHomeToScreenUtils.k(context, finalAppId, appName, appLogoLink, callback);
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.h("SystemAbilityBridge", th2);
                callback.b();
                return;
            }
        }
        callback.b();
    }
}

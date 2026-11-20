package com.cloud.tmc.integration.bridge;

import android.content.Context;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.PermissionUtils;
import com.google.gson.JsonObject;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class ShareBridge implements BridgeExtension {
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
    public static final class b implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f30577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f30578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bc.a f30579c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a implements com.cloud.tmc.integration.utils.share.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ bc.a f30580a;

            public a(bc.a aVar) {
                this.f30580a = aVar;
            }

            @Override // com.cloud.tmc.integration.utils.share.a
            public void a(int i11, int i12) {
                if (i12 == 1) {
                    bc.a aVar = this.f30580a;
                    if (aVar != null) {
                        aVar.g();
                        return;
                    }
                    return;
                }
                bc.a aVar2 = this.f30580a;
                if (aVar2 != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "Share Failed: S10004");
                    aVar2.e(jsonObject);
                }
            }
        }

        public b(Context context, File file, bc.a aVar) {
            this.f30577a = context;
            this.f30578b = file;
            this.f30579c = aVar;
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void a() {
            bc.a aVar = this.f30579c;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "Share File Failed, no write permission : S10002");
                aVar.e(jsonObject);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.PermissionUtils.b
        public void onGranted() {
            com.cloud.tmc.integration.utils.share.g.e(this.f30577a, this.f30578b, (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? false : false, (60 & 64) == 0 ? new a(this.f30579c) : null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.cloud.tmc.integration.utils.share.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f30581a;

        public c(bc.a aVar) {
            this.f30581a = aVar;
        }

        @Override // com.cloud.tmc.integration.utils.share.a
        public void a(int i11, int i12) {
            if (i12 == 1) {
                bc.a aVar = this.f30581a;
                if (aVar != null) {
                    aVar.g();
                    return;
                }
                return;
            }
            bc.a aVar2 = this.f30581a;
            if (aVar2 != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "Share Failed: S10004");
                aVar2.e(jsonObject);
            }
        }
    }

    public final void a(Context context, File file, bc.a aVar) {
        PermissionUtils.y("STORAGE_WRITE").m(new b(context, file, aVar)).z();
    }

    public final void b(Context context, String str, bc.a aVar) {
        com.cloud.tmc.integration.utils.share.g.h(context, str, null, new c(aVar), 4, null);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
        TmcLogger.c("ShareBridge", "onFinalized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
        TmcLogger.c("ShareBridge", "onInitialized");
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public final void systemShare(@cc.f(App.class) App app, @cc.g({"shareContent"}) String shareContent, @cc.g({"shareFilePath"}) String shareFilePath, @cc.c bc.a aVar) {
        tb.b appContext;
        Intrinsics.g(shareContent, "shareContent");
        Intrinsics.g(shareFilePath, "shareFilePath");
        Context context = (app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext();
        if (context == null || (shareContent.length() == 0 && shareFilePath.length() == 0)) {
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "Parameter error: S10001");
                aVar.e(jsonObject);
                return;
            }
            return;
        }
        if (shareFilePath.length() > 0) {
            File fileH = FileUtil.H(app, shareFilePath);
            boolean zC = FileUtil.c(fileH);
            if (fileH != null && zC) {
                a(context, fileH, aVar);
                return;
            }
        }
        if (shareContent.length() > 0) {
            b(context, shareContent, aVar);
        } else if (aVar != null) {
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("errMsg", "ShareContent is empty: S10003");
            aVar.e(jsonObject2);
        }
    }
}

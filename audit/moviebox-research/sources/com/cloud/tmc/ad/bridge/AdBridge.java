package com.cloud.tmc.ad.bridge;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import cc.f;
import cc.g;
import com.cloud.tmc.ad.IAdManagerProxy;
import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdExtraBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.ad.bean.response.AdsDTO;
import com.cloud.tmc.ad.bean.response.DataDTO;
import com.cloud.tmc.ad.utils.MitNetUtil;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.i;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.n;
import com.cloud.tmc.kernel.utils.p;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.JsonObject;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import ia.c;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import zb.e;

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
public final class AdBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30339a = "AdBridge";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f30340b = "ad_show";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f30341c = "ad_click";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ia.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30343b;

        public a(bc.a aVar) {
            this.f30343b = aVar;
        }

        @Override // ia.b
        public void b(String triggerId, boolean z11) {
            Intrinsics.g(triggerId, "triggerId");
            int i11 = z11 ? 1 : 2;
            TmcLogger.c(AdBridge.this.f30339a, "fillingInterstitial -> result: " + i11);
            bc.a aVar = this.f30343b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                jsonObject.addProperty("filling_result", Integer.valueOf(i11));
                aVar.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ bc.a f30345b;

        public b(bc.a aVar) {
            this.f30345b = aVar;
        }

        @Override // ia.c
        public void a(String triggerId, AdClickBean adClickBean) {
            Intrinsics.g(triggerId, "triggerId");
            Intrinsics.g(adClickBean, "adClickBean");
            TmcLogger.c(AdBridge.this.f30339a, "showInterstitial -> closeAd: " + adClickBean);
            bc.a aVar = this.f30345b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", "ad_ssp_close_ad");
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                jsonObject.addProperty("show_duration", Long.valueOf(adClickBean.getShowDuration()));
                jsonObject.addProperty("show_area", adClickBean.getShowArea());
                jsonObject.addProperty("show_times", Integer.valueOf(adClickBean.getShowTimes()));
                aVar.d(jsonObject);
                aVar.close();
            }
        }

        @Override // ia.c
        public void c(String triggerId, boolean z11, AdShowBean adShowBean) {
            Intrinsics.g(triggerId, "triggerId");
            Intrinsics.g(adShowBean, "adShowBean");
            TmcLogger.c(AdBridge.this.f30339a, "showInterstitial -> showResult: " + z11 + " ; adShowBean: " + adShowBean);
            bc.a aVar = this.f30345b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", "ad_ssp_show");
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                jsonObject.addProperty("image_width", Integer.valueOf(adShowBean.getImageWidth()));
                jsonObject.addProperty("image_height", Integer.valueOf(adShowBean.getImageHeight()));
                jsonObject.addProperty(TrackingKey.SHOW_TS, Long.valueOf(adShowBean.getShowTs()));
                jsonObject.addProperty("is_effective_show", Integer.valueOf(adShowBean.isEffectiveShow()));
                jsonObject.addProperty("show_duration", Long.valueOf(adShowBean.getShowDuration()));
                jsonObject.addProperty("show_area", adShowBean.getShowArea());
                jsonObject.addProperty("show_report_time_type", Integer.valueOf(adShowBean.getShowReportTimeType()));
                jsonObject.addProperty("show_times", Integer.valueOf(adShowBean.getShowTimes()));
                jsonObject.addProperty("show_result", String.valueOf(z11));
                jsonObject.addProperty("is_close", String.valueOf(adShowBean.isClose()));
                aVar.d(jsonObject);
            }
        }

        @Override // ia.c
        public void d(String triggerId) {
            Intrinsics.g(triggerId, "triggerId");
            TmcLogger.c(AdBridge.this.f30339a, "showInterstitial -> click_homepage");
            c.a.a(this, triggerId);
            bc.a aVar = this.f30345b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", "click_homepage");
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                aVar.d(jsonObject);
            }
        }

        @Override // ia.c
        public void e(String triggerId) {
            Intrinsics.g(triggerId, "triggerId");
            TmcLogger.c(AdBridge.this.f30339a, "showInterstitial -> click_personalization");
            c.a.b(this, triggerId);
            bc.a aVar = this.f30345b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", "click_personalization");
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                aVar.d(jsonObject);
            }
        }

        @Override // ia.c
        public void f(String triggerId, DownUpPointBean pointBean, String str) {
            Intrinsics.g(triggerId, "triggerId");
            Intrinsics.g(pointBean, "pointBean");
            TmcLogger.c(AdBridge.this.f30339a, "showInterstitial -> ad_ssp_click");
            bc.a aVar = this.f30345b;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", "ad_ssp_click");
                jsonObject.addProperty(TrackingKey.TRIGGER_ID, triggerId);
                jsonObject.addProperty("pointData", k.j(pointBean));
                if (str != null) {
                    jsonObject.addProperty("adUrl", str);
                }
                aVar.d(jsonObject);
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030 A[Catch: all -> 0x002e, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x0020, B:12:0x0030, B:14:0x0039), top: B:20:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0039 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #0 {all -> 0x002e, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x0020, B:12:0x0030, B:14:0x0039), top: B:20:0x0004 }] */
    @zb.a("")
    @e(ExecutorType.UI)
    public final void closeAd(@g({TrackingKey.TRIGGER_ID}) String str, @f(App.class) App app, @cc.c bc.a aVar) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str) || app == null) {
                    TmcLogger.c(this.f30339a, "closeAd -> trigger_id不能为空");
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("errMsg", "trigger_id不能为空");
                        aVar.e(jsonObject);
                    }
                } else {
                    TmcLogger.c(this.f30339a, "closeAd");
                    ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).close(str, app);
                    if (aVar != null) {
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty(TrackingKey.TRIGGER_ID, str);
                        aVar.d(jsonObject2);
                    }
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("errMsg", "E:" + th2 + "!!");
                    aVar.e(jsonObject3);
                }
            }
        } else {
            TmcLogger.c(this.f30339a, "closeAd -> trigger_id不能为空");
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errMsg", "trigger_id不能为空");
                aVar.e(jsonObject4);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0035 A[Catch: all -> 0x0020, TryCatch #0 {all -> 0x0020, blocks: (B:3:0x000c, B:5:0x0012, B:9:0x0022, B:11:0x0028, B:14:0x0038, B:16:0x0043, B:17:0x0051, B:13:0x0035), top: B:21:0x000c }] */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void encryptAESBase64(@g({"data"}) String data, @cc.c bc.a callback) {
        byte[] bytes;
        Intrinsics.g(data, "data");
        Intrinsics.g(callback, "callback");
        try {
            if (TextUtils.isEmpty(data)) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "data is empty!!");
                callback.e(jsonObject);
                return;
            }
            String strA = com.cloud.tmc.integration.utils.a.a(data);
            if (strA != null) {
                bytes = strA.getBytes(Charsets.f69091b);
                Intrinsics.f(bytes, "this as java.lang.String).getBytes(charset)");
                if (bytes == null) {
                    bytes = new byte[0];
                }
            } else {
                bytes = new byte[0];
            }
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            if (TextUtils.isEmpty(strEncodeToString)) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "encrypt data is empty!!");
                callback.e(jsonObject2);
            } else {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("data", String.valueOf(strEncodeToString));
                callback.d(jsonObject3);
            }
        } catch (Throwable th2) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("errMsg", "E:" + th2 + "!!");
            callback.e(jsonObject4);
        }
    }

    @zb.a("")
    @e(ExecutorType.UI)
    public final void fillingInterstitial(@g({TrackingKey.TRIGGER_ID}) String str, @g({"adsDTO"}) String str2, @g({"mainImgPath"}) String str3, @g({"logoImgPath"}) String str4, @f(App.class) App app, @cc.c bc.a aVar) {
        try {
            if (app == null) {
                TmcLogger.c(this.f30339a, "fillingInterstitial -> 系统错误");
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "系统错误");
                    jsonObject.addProperty(TrackingKey.TRIGGER_ID, str);
                    jsonObject.addProperty("filling_result", (Number) 2);
                    aVar.d(jsonObject);
                    return;
                }
                return;
            }
            if (str == null || TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2)) {
                TmcLogger.c(this.f30339a, "fillingInterstitial -> trigger_id或adsDTO不能为空");
                if (aVar != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errMsg", "trigger_id或adsDTO不能为空");
                    jsonObject2.addProperty(TrackingKey.TRIGGER_ID, str);
                    jsonObject2.addProperty("filling_result", (Number) 2);
                    aVar.d(jsonObject2);
                    return;
                }
                return;
            }
            AdsDTO adsDTO = (AdsDTO) k.d(str2, AdsDTO.class);
            if (adsDTO != null) {
                IResourceProcessor iResourceProcessor = (IResourceProcessor) tc.a.a(IResourceProcessor.class);
                File file = iResourceProcessor.get(str3, app.getAppId());
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = iResourceProcessor.get(str4, app.getAppId());
                ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).fillingInterstitial(str, adsDTO, absolutePath, file2 != null ? file2.getAbsolutePath() : null, app, new a(aVar));
                return;
            }
            if (aVar != null) {
                JsonObject jsonObject3 = new JsonObject();
                TmcLogger.c(this.f30339a, "fillingInterstitial -> adsDTO解析失败");
                jsonObject3.addProperty("errMsg", "adsDTO解析失败");
                jsonObject3.addProperty(TrackingKey.TRIGGER_ID, str);
                jsonObject3.addProperty("filling_result", (Number) 2);
                aVar.d(jsonObject3);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errMsg", "系统错误");
                jsonObject4.addProperty(TrackingKey.TRIGGER_ID, str);
                jsonObject4.addProperty("filling_result", (Number) 2);
                aVar.d(jsonObject4);
            }
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getAdArguments(@f(App.class) App app, @cc.c bc.a aVar) {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("type", Integer.valueOf(ha.a.k()));
            jsonObject.addProperty("brand", ha.a.a());
            jsonObject.addProperty("model", ha.a.e());
            jsonObject.addProperty("maker", ha.a.b());
            jsonObject.addProperty("osType", "1");
            jsonObject.addProperty("osVersion", ha.a.f());
            jsonObject.addProperty("networkConnectionType", Integer.valueOf(MitNetUtil.f30346a.a(ws.a.a()).ordinal()));
            if (ha.a.c() == null || ha.a.d() == null) {
                jsonObject.addProperty("operatorType", "");
            } else {
                jsonObject.addProperty("operatorType", ha.a.c() + ha.a.d());
            }
            q qVar = q.f31091a;
            jsonObject.addProperty("ipAddress", qVar.h());
            jsonObject.addProperty("gaid", q.d());
            jsonObject.addProperty("screenWidth", Integer.valueOf(ha.a.i()));
            jsonObject.addProperty("screenHeight", Integer.valueOf(ha.a.h()));
            jsonObject.addProperty("screenDensity", Integer.valueOf(ha.a.g()));
            JsonObject jsonObject2 = new JsonObject();
            jsonObject2.addProperty("baseStation", qVar.g());
            jsonObject2.addProperty("latitude", Double.valueOf(ja.a.c()));
            jsonObject2.addProperty("longitude", Double.valueOf(ja.a.e()));
            jsonObject2.addProperty("coordTime", Long.valueOf(ja.a.b()));
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("installTime", i.a());
            jsonObject3.addProperty("userAgent", ha.a.l());
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.add("device", jsonObject);
                jsonObject4.add("user", jsonObject2);
                jsonObject4.add(MimeTypes.BASE_TYPE_APPLICATION, jsonObject3);
                aVar.d(jsonObject4);
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("errMsg", "E:" + th2 + "!!");
                aVar.e(jsonObject5);
            }
        }
    }

    public final String getEVENT_AD_CLICK() {
        return this.f30341c;
    }

    public final String getEVENT_AD_SHOW() {
        return this.f30340b;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0032 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0019, B:11:0x0032, B:13:0x003b), top: B:19:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x003b A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #0 {all -> 0x0030, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0019, B:11:0x0032, B:13:0x003b), top: B:19:0x0004 }] */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void getPersonalization(@g({TrackingKey.TRIGGER_ID}) String str, @f(App.class) App app, @cc.c bc.a aVar) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    TmcLogger.c(this.f30339a, "getPersonalization -> trigger_id不能为空");
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("errMsg", "trigger_id不能为空");
                        aVar.e(jsonObject);
                    }
                } else {
                    TmcLogger.c(this.f30339a, "getPersonalization");
                    int iF = q.f31091a.f();
                    if (aVar != null) {
                        JsonObject jsonObject2 = new JsonObject();
                        jsonObject2.addProperty("turnOffPerAds", Integer.valueOf(iF));
                        jsonObject2.addProperty(TrackingKey.TRIGGER_ID, str);
                        aVar.d(jsonObject2);
                    }
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("errMsg", "E: " + th2 + "!!");
                    aVar.e(jsonObject3);
                }
            }
        } else {
            TmcLogger.c(this.f30339a, "getPersonalization -> trigger_id不能为空");
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("errMsg", "trigger_id不能为空");
                aVar.e(jsonObject4);
            }
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void getServerUrls(@g({"tag"}) String tag, @g({"adsDTO"}) String adsDTO, @g({TrackingKey.TRIGGER_ID}) String trigger_id, @g({"pointData"}) String str, @f(App.class) App app, @cc.c bc.a aVar) {
        AdsDTO adsDTO2;
        List<String> listA;
        Intrinsics.g(tag, "tag");
        Intrinsics.g(adsDTO, "adsDTO");
        Intrinsics.g(trigger_id, "trigger_id");
        Intrinsics.g(app, "app");
        if (n.a(tag)) {
            p.e(this.f30339a, "tag is empty");
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("errMsg", "tag is empty");
                aVar.e(jsonObject);
                return;
            }
            return;
        }
        if (n.a(adsDTO)) {
            p.e(this.f30339a, "adsDTO is empty");
            if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("errMsg", "adsDTO is empty");
                aVar.e(jsonObject2);
                return;
            }
            return;
        }
        try {
            if (!Intrinsics.b(this.f30340b, tag)) {
                if (!Intrinsics.b(this.f30341c, tag) || (adsDTO2 = (AdsDTO) k.d(adsDTO, AdsDTO.class)) == null) {
                    return;
                }
                adsDTO2.setClickid(trigger_id);
                if (TextUtils.isEmpty(adsDTO2.getAdm())) {
                    ga.b bVar = ga.b.f65469a;
                    ArrayList<String> clickTrackingUrls = adsDTO2.getClickTrackingUrls();
                    String appId = app.getAppId();
                    Intrinsics.f(appId, "app.appId");
                    String sDKVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion();
                    Intrinsics.f(sDKVersion, "get(\n                   …             ).sdkVersion");
                    List<String> listB = bVar.b(clickTrackingUrls, adsDTO2, new AdExtraBean(appId, false, sDKVersion), adsDTO2.getClickid(), (DownUpPointBean) k.d(str, DownUpPointBean.class));
                    if (aVar != null) {
                        JsonObject jsonObject3 = new JsonObject();
                        jsonObject3.addProperty("ad_click", k.j(listB));
                        aVar.d(jsonObject3);
                        return;
                    }
                    return;
                }
                return;
            }
            AdsDTO adsDTO3 = (AdsDTO) k.d(adsDTO, AdsDTO.class);
            if (adsDTO3 != null) {
                adsDTO3.setClickid(trigger_id);
                Integer imageWidth = adsDTO3.getImageWidth();
                Intrinsics.f(imageWidth, "it.imageWidth");
                int iIntValue = imageWidth.intValue();
                Integer imageHeight = adsDTO3.getImageHeight();
                Intrinsics.f(imageHeight, "it.imageHeight");
                DownUpPointBean downUpPointBean = new DownUpPointBean(0.0f, 0.0f, 0.0f, 0.0f, iIntValue, imageHeight.intValue());
                new ArrayList();
                if (TextUtils.isEmpty(adsDTO3.getAdm())) {
                    ga.b bVar2 = ga.b.f65469a;
                    List<String> showTrackingUrls = adsDTO3.getShowTrackingUrls();
                    String appId2 = app.getAppId();
                    Intrinsics.f(appId2, "app.appId");
                    String sDKVersion2 = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion();
                    Intrinsics.f(sDKVersion2, "get(\n                   …             ).sdkVersion");
                    listA = bVar2.c(showTrackingUrls, adsDTO3, new AdExtraBean(appId2, false, sDKVersion2), downUpPointBean);
                } else {
                    listA = ga.b.f65469a.a(adsDTO3.getShowTrackingUrls());
                }
                if (aVar != null) {
                    JsonObject jsonObject4 = new JsonObject();
                    jsonObject4.addProperty("ad_show", k.j(listA));
                    aVar.d(jsonObject4);
                }
            }
        } catch (Exception e11) {
            p.c(this.f30339a, "reportAdLog  parse data fail: " + e11);
            if (aVar != null) {
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("errMsg", "reportAdLog  parse data fail: " + e11);
                aVar.e(jsonObject5);
            }
        }
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void isAppInstalled(@g({"packageName"}) String str, @f(App.class) App app, @cc.c bc.a aVar) {
        tb.b appContext;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("popularize_app_install_status", "1");
                aVar.d(jsonObject);
                return;
            }
            return;
        }
        PackageInfo packageInfo = null;
        if (((app == null || (appContext = app.getAppContext()) == null) ? null : appContext.getContext()) == null) {
            if (aVar != null) {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject2.addProperty("popularize_app_install_status", "-1");
                aVar.d(jsonObject2);
                return;
            }
            return;
        }
        try {
            tb.b appContext2 = app.getAppContext();
            Intrinsics.d(appContext2);
            Context context = appContext2.getContext();
            Intrinsics.d(context);
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intrinsics.d(str);
                packageInfo = packageManager.getPackageInfo(str, 0);
            }
            if (packageInfo == null) {
                if (aVar != null) {
                    JsonObject jsonObject3 = new JsonObject();
                    jsonObject3.addProperty("popularize_app_install_status", "3");
                    aVar.d(jsonObject3);
                    return;
                }
                return;
            }
            if (aVar != null) {
                JsonObject jsonObject4 = new JsonObject();
                jsonObject4.addProperty("popularize_app_install_status", "2");
                aVar.d(jsonObject4);
            }
        } catch (Exception unused) {
            if (aVar != null) {
                JsonObject jsonObject5 = new JsonObject();
                jsonObject5.addProperty("popularize_app_install_status", "-1");
                aVar.d(jsonObject5);
            }
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public /* bridge */ /* synthetic */ dd.f permit() {
        return (dd.f) m119permit();
    }

    /* JADX INFO: renamed from: permit, reason: collision with other method in class */
    public Void m119permit() {
        return null;
    }

    @zb.a("")
    @e(ExecutorType.IO)
    public final void responseCallback(@g({"responseData"}) String str) {
        if (str != null) {
            try {
                DataDTO dataDTO = (DataDTO) k.d(str, DataDTO.class);
                if (dataDTO != null) {
                    Intrinsics.f(dataDTO, "fromJson(it, DataDTO::class.java)");
                    ja.c.a(dataDTO);
                }
            } catch (Exception e11) {
                TmcLogger.f(this.f30339a, "responseCallback parse responseData fail: " + e11);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0033 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x002d, B:12:0x0033, B:14:0x003c), top: B:20:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x003c A[Catch: all -> 0x0031, TRY_LEAVE, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:7:0x000c, B:9:0x002d, B:12:0x0033, B:14:0x003c), top: B:20:0x0004 }] */
    @zb.a("")
    @e(ExecutorType.IO)
    public final void saveAdFrameworkVersion(@g({"ad_sdk_version"}) String str, @g({"ad_sdk_version_int"}) Long l11, @f(App.class) App app, @cc.c bc.a aVar) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str) || l11 == null) {
                    TmcLogger.c(this.f30339a, "saveAdFrameworkVersion -> ad_sdk_version/ad_sdk_version_int不能为空");
                    if (aVar != null) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("errMsg", "ad_sdk_version/ad_sdk_version_int不能为空");
                        aVar.e(jsonObject);
                    }
                } else {
                    TmcLogger.c(this.f30339a, "saveAdFrameworkVersion");
                    com.cloud.tmc.integration.utils.g gVar = com.cloud.tmc.integration.utils.g.f31057a;
                    gVar.a().p("ad_sdk_version", str);
                    gVar.a().o("ad_sdk_version_int", l11.longValue());
                    if (aVar != null) {
                        aVar.g();
                    }
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errMsg", "E:" + th2 + "!!");
                    aVar.e(jsonObject2);
                }
            }
        } else {
            TmcLogger.c(this.f30339a, "saveAdFrameworkVersion -> ad_sdk_version/ad_sdk_version_int不能为空");
            if (aVar != null) {
                JsonObject jsonObject3 = new JsonObject();
                jsonObject3.addProperty("errMsg", "ad_sdk_version/ad_sdk_version_int不能为空");
                aVar.e(jsonObject3);
            }
        }
    }

    @zb.a("")
    @e(ExecutorType.UI)
    public final void showInterstitial(@g({TrackingKey.TRIGGER_ID}) String str, @g({"adsDTO"}) String str2, @f(App.class) App app, @cc.c(isSticky = true) bc.a aVar) {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str) && str2 != null && !TextUtils.isEmpty(str2) && app != null) {
                    AdsDTO adsDTO = (AdsDTO) k.d(str2, AdsDTO.class);
                    if (adsDTO != null) {
                        ((IAdManagerProxy) tc.a.a(IAdManagerProxy.class)).showInterstitial(str, app, adsDTO, new b(aVar));
                        return;
                    }
                    if (aVar != null) {
                        TmcLogger.c(this.f30339a, "showInterstitial -> adsDTO解析失败");
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("errMsg", "adsDTO解析失败");
                        jsonObject.addProperty(TrackingKey.TRIGGER_ID, str);
                        aVar.e(jsonObject);
                        aVar.close();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (aVar != null) {
                    JsonObject jsonObject2 = new JsonObject();
                    jsonObject2.addProperty("errMsg", "E:" + th2 + "!!");
                    aVar.e(jsonObject2);
                    aVar.close();
                    return;
                }
                return;
            }
        }
        TmcLogger.c(this.f30339a, "showInterstitial -> trigger_id或adsDTO不能为空");
        if (aVar != null) {
            JsonObject jsonObject3 = new JsonObject();
            jsonObject3.addProperty("errMsg", "trigger_id或adsDTO不能为空");
            aVar.e(jsonObject3);
            aVar.close();
        }
    }
}

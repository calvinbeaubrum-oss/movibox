package com.transsion.commercialization.pslink;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f51726a = new f();

    public final void a(Map<String, String> map, RecommendInfo recommendInfo, String str) {
        ItemDetail detail;
        TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f49455a;
        map.put("gaid", tNDeviceHelper.h());
        map.put("country_code", tNDeviceHelper.e());
        String strA = com.blankj.utilcode.util.c.a();
        Intrinsics.f(strA, "getAppName()");
        map.put("media", strA);
        map.put("scene", str);
        map.put("app_name", String.valueOf((recommendInfo == null || (detail = recommendInfo.getDetail()) == null) ? null : detail.getName()));
        map.put("packageName", String.valueOf(recommendInfo != null ? recommendInfo.getPackageName() : null));
        map.put("ps_dialog_style", "B");
        map.put("plan_Name", String.valueOf(recommendInfo != null ? recommendInfo.getPlanName() : null));
        map.put("plan_id", String.valueOf(recommendInfo != null ? Long.valueOf(recommendInfo.getId()) : null));
        map.put("is_offer", String.valueOf(recommendInfo != null ? Integer.valueOf(recommendInfo.isOffer()) : null));
        map.put(CampaignEx.KEY_SHOW_TYPE, String.valueOf(recommendInfo != null ? Integer.valueOf(recommendInfo.getShowType()) : null));
        String MODEL = Build.MODEL;
        Intrinsics.f(MODEL, "MODEL");
        map.put("ua", MODEL);
        String BRAND = Build.BRAND;
        Intrinsics.f(BRAND, "BRAND");
        map.put("brand", BRAND);
        map.put("source", "ps");
        map.put("adSource", String.valueOf(recommendInfo != null ? recommendInfo.getAdSource() : null));
    }

    public final String b() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void c(int i11, RecommendInfo recommendInfo, String action, int i12) {
        Intrinsics.g(action, "action");
        HashMap map = new HashMap();
        map.put(RequestParameters.POSITION, String.valueOf(i11));
        map.put("actionType", action);
        map.put("itemType", String.valueOf(i12));
        a(map, recommendInfo, "app_center");
        a.f51724a.a(b() + " --> reportInstallClick() --> map = " + map);
        com.transsion.baselib.helper.a.f51183a.b("app_center", map);
    }

    public final void d() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_member_guide");
        com.transsion.baselib.helper.a.f51183a.b("download_intercept", linkedHashMap);
    }

    public final void e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_rewarded");
        com.transsion.baselib.helper.a.f51183a.b("download_intercept", linkedHashMap);
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_click_try_another");
        com.transsion.baselib.helper.a.f51183a.b("download_intercept", linkedHashMap);
    }

    public final void g() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "download_dialog_show");
        com.transsion.baselib.helper.a.f51183a.a("download_intercept", linkedHashMap);
    }

    public final void h(String str, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("packageName", String.valueOf(str));
        linkedHashMap.put(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11));
        com.transsion.baselib.helper.a.f51183a.c(linkedHashMap);
    }

    public final void i(int i11, RecommendInfo recommendInfo, int i12) {
        HashMap map = new HashMap();
        map.put(RequestParameters.POSITION, String.valueOf(i11));
        map.put("type", String.valueOf(i12));
        a(map, recommendInfo, "app_center");
        a.f51724a.a(b() + " --> reportItemShow() --> map = " + map);
        com.transsion.baselib.helper.a.f51183a.a("app_center", map);
    }

    public final void j() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "watch_ad_dialog_click_member_guide");
        com.transsion.baselib.helper.a.f51183a.b("download_intercept", linkedHashMap);
    }

    public final void k() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "watch_ad_dialog_show");
        com.transsion.baselib.helper.a.f51183a.a("download_intercept", linkedHashMap);
    }
}

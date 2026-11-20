package vq;

import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.ad.report.BiddingStateEnum;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f79053a = new b();

    public static /* synthetic */ void m(b bVar, String str, String str2, int i11, int i12, String str3, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = "";
        }
        bVar.l(str, str2, i11, i12, str3);
    }

    public final void a(String triggerId, String str, String str2, Integer num, String str3, int i11, boolean z11, Map<String, String> extMap, Long l11, Double d11, Long l12) {
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(extMap, "extMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", String.valueOf(num));
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put("action", "click");
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("ad_id", str3);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("ad_plan_id", str2);
        linkedHashMap.put(TrackingKey.SCENE_ID, str != null ? str : "");
        linkedHashMap.put("is_ad_show_final", String.valueOf(z11));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        linkedHashMap.put("ps_id", String.valueOf(l11));
        linkedHashMap.put("bid_ecpm_cent", String.valueOf(d11));
        linkedHashMap.put("ecpm_cent", String.valueOf(l12));
        if (!extMap.isEmpty()) {
            linkedHashMap.putAll(extMap);
        }
        if (!wq.b.f79582a.h()) {
            a.f79051a.c("ad_link", linkedHashMap, str);
            return;
        }
        com.transsion.ad.a.f(com.transsion.ad.a.f50276a, h() + " --> click --> 广告数据上报链路已关闭，不上报 -- sceneId = " + str + " -- map = " + linkedHashMap, false, 2, null);
    }

    public final void c(String triggerId, String str, String str2, long j11, String str3, int i11, boolean z11) {
        Intrinsics.g(triggerId, "triggerId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", "102");
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put("action", TrackingKey.SHOW_TIME);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("ad_id", str3);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("ad_plan_id", str2);
        linkedHashMap.put(TrackingKey.SCENE_ID, str != null ? str : "");
        linkedHashMap.put("is_ad_show_final", String.valueOf(z11));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        linkedHashMap.put("duration", String.valueOf(j11));
        a.f79051a.c("ad_link", linkedHashMap, str);
    }

    public final void e(String triggerId, String sceneId, int i11, BiddingStateEnum biddingStateEnum, String str) {
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(sceneId, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "bidding");
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put(TrackingKey.SCENE_ID, sceneId);
        linkedHashMap.put("result", biddingStateEnum != null ? biddingStateEnum.getValue() : null);
        linkedHashMap.put(NotificationCompat.CATEGORY_MESSAGE, str);
        if (!wq.b.f79582a.h()) {
            a.f79051a.c("ad_link", linkedHashMap, sceneId);
            return;
        }
        com.transsion.ad.a.f(com.transsion.ad.a.f50276a, h() + " --> biddingReport --> 广告数据上报链路已关闭，不上报 -- sceneId = " + sceneId + " -- 业务触发 -- map = " + linkedHashMap, false, 2, null);
    }

    public final void f(String triggerId, String str, String str2, Integer num, String str3, int i11, boolean z11, Map<String, String> extMap, Long l11, Double d11, Long l12) {
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(extMap, "extMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("adSource", String.valueOf(num));
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put("action", "display");
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("ad_id", str3);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("ad_plan_id", str2);
        linkedHashMap.put(TrackingKey.SCENE_ID, str != null ? str : "");
        linkedHashMap.put("is_ad_show_final", String.valueOf(z11));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        linkedHashMap.put("ps_id", String.valueOf(l11));
        linkedHashMap.put("bid_ecpm_cent", String.valueOf(d11));
        linkedHashMap.put("ecpm_cent", String.valueOf(l12));
        if (!extMap.isEmpty()) {
            linkedHashMap.putAll(extMap);
        }
        if (!wq.b.f79582a.h()) {
            a.f79051a.c("ad_link", linkedHashMap, str);
            return;
        }
        com.transsion.ad.a.f(com.transsion.ad.a.f50276a, h() + " --> display --> 广告数据上报链路已关闭，不上报 -- sceneId = " + str + " -- map = " + linkedHashMap, false, 2, null);
    }

    public final String h() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void i(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("new_version", String.valueOf(str));
        linkedHashMap.put("last_version", String.valueOf(str2));
        linkedHashMap.put("action", "receive");
        a.f79051a.c("ad_link", linkedHashMap, "ad_config");
    }

    public final void j(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("version", String.valueOf(str));
        linkedHashMap.put("action", "success");
        a.f79051a.c("ad_link", linkedHashMap, "ad_config");
    }

    public final void k(String triggerId, String sceneId, int i11, int i12, String str) {
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(sceneId, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "reject");
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put(TrackingKey.SCENE_ID, sceneId);
        linkedHashMap.put("reject_msg", str);
        linkedHashMap.put("adSource", String.valueOf(i12));
        if (!wq.b.f79582a.h()) {
            a.f79051a.c("ad_link", linkedHashMap, sceneId);
            return;
        }
        com.transsion.ad.a.f(com.transsion.ad.a.f50276a, h() + " --> trigger --> 广告数据上报链路已关闭，不上报 -- sceneId = " + sceneId + " -- 业务触发 -- map = " + linkedHashMap, false, 2, null);
    }

    public final void l(String triggerId, String sceneId, int i11, int i12, String str) {
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(sceneId, "sceneId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("action", "trigger");
        linkedHashMap.put("adType", String.valueOf(i11));
        linkedHashMap.put(TrackingKey.SCENE_ID, sceneId);
        linkedHashMap.put("plan_id", str);
        linkedHashMap.put("adSource", String.valueOf(i12));
        linkedHashMap.put(TrackingKey.TRIGGER_ID, triggerId);
        if (!wq.b.f79582a.h()) {
            a.f79051a.c("ad_link", linkedHashMap, sceneId);
            return;
        }
        com.transsion.ad.a.f(com.transsion.ad.a.f50276a, h() + " --> trigger --> 广告数据上报链路已关闭，不上报 -- sceneId = " + sceneId + " -- 业务触发 -- map = " + linkedHashMap, false, 2, null);
    }
}

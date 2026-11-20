package com.transsion.push.helper;

import android.net.Uri;
import androidx.core.app.NotificationManagerCompat;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.report.m;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.MsgStyle;
import java.util.Calendar;
import java.util.LinkedHashMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f56923a = new a();

    public final void a(String str, String str2, String str3, Uri uri, boolean z11, String str4, String moduleName) {
        Intrinsics.g(moduleName, "moduleName");
        boolean zF = f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, str);
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("source", str2);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, str3);
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put(TtmlNode.TAG_STYLE, str4);
        linkedHashMap.put("are_notify_enabled", zF ? "1" : "0");
        linkedHashMap.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, String.valueOf(uri));
        linkedHashMap.put("is_permanent", String.valueOf(z11));
        linkedHashMap.put("module_name", moduleName);
        linkedHashMap.put("action", "click");
        m.f51277a.t("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final void c(String eventSource) {
        Intrinsics.g(eventSource, "eventSource");
        boolean zF = f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("time", String.valueOf(Calendar.getInstance().get(11)));
        linkedHashMap.put("notify_enable", String.valueOf(zF));
        linkedHashMap.put("event_source", eventSource);
        linkedHashMap.put("type", "success");
        m.f51277a.t("notification", "fsnpost", linkedHashMap);
    }

    public final void d(MsgBean msgBean) {
        Intrinsics.g(msgBean, "msgBean");
        boolean zF = f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String messageId = msgBean.getMessageId();
        if (messageId == null) {
            messageId = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, messageId);
        String source = msgBean.getSource();
        if (source == null) {
            source = "";
        }
        linkedHashMap.put("source", source);
        String type = msgBean.getType();
        if (type == null) {
            type = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, type);
        linkedHashMap.put("are_notify_enabled", zF ? "1" : "0");
        String style = msgBean.getStyle();
        if (style == null) {
            style = "";
        }
        linkedHashMap.put(TtmlNode.TAG_STYLE, style);
        String deeplink = msgBean.getDeeplink();
        linkedHashMap.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, deeplink != null ? deeplink : "");
        linkedHashMap.put("is_permanent", String.valueOf(msgBean.isPermanent()));
        linkedHashMap.put("action", "exposure");
        m.f51277a.t("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final void e(MsgBean msgBean) {
        Intrinsics.g(msgBean, "msgBean");
        boolean zF = f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String messageId = msgBean.getMessageId();
        if (messageId == null) {
            messageId = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_ID, messageId);
        String source = msgBean.getSource();
        if (source == null) {
            source = "";
        }
        linkedHashMap.put("source", source);
        String type = msgBean.getType();
        if (type == null) {
            type = "";
        }
        linkedHashMap.put(PushConstants.EXTRA_PUSH_MESSAGE_TYPE, type);
        linkedHashMap.put("are_notify_enabled", zF ? "1" : "0");
        String style = msgBean.getStyle();
        if (style == null) {
            style = "";
        }
        linkedHashMap.put(TtmlNode.TAG_STYLE, style);
        String deeplink = msgBean.getDeeplink();
        linkedHashMap.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, deeplink != null ? deeplink : "");
        linkedHashMap.put("action", "receive");
        m.f51277a.t("notification", MsgStyle.SOURCE_PUSH, linkedHashMap);
    }

    public final boolean f() {
        try {
            return NotificationManagerCompat.from(Utils.a()).areNotificationsEnabled();
        } catch (Exception unused) {
            return true;
        }
    }
}

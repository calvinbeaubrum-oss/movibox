package com.mbridge.msdk.video.bt.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.bridge.NativeRequestBridge;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ar;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.bt.module.BTBaseView;
import com.mbridge.msdk.video.bt.module.MBTempContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC;
import com.mbridge.msdk.video.bt.module.MBridgeBTVideoView;
import com.mbridge.msdk.video.bt.module.MBridgeBTWebView;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f47332a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static LinkedHashMap<String, String> f47333b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static LinkedHashMap<String, CampaignEx> f47334c = new LinkedHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static LinkedHashMap<String, com.mbridge.msdk.videocommon.d.c> f47335d = new LinkedHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LinkedHashMap<String, String> f47336e = new LinkedHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static LinkedHashMap<String, Integer> f47337f = new LinkedHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static LinkedHashMap<String, Activity> f47338g = new LinkedHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f47339h = 10000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f47340i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f47341j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f47342k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f47343l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f47344m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f47345n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f47346o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f47347p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.widget.LinearLayout$LayoutParams] */
    private ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i11, int i12) {
        if (rect == null) {
            rect = new Rect(-999, -999, -999, -999);
        }
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC == null) {
            return layoutParams;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int i13 = rect.left;
            if (i13 != -999) {
                layoutParams2.leftMargin = ai.a(contextC, i13);
            }
            int i14 = rect.top;
            if (i14 != -999) {
                layoutParams2.topMargin = ai.a(contextC, i14);
            }
            int i15 = rect.right;
            if (i15 != -999) {
                layoutParams2.rightMargin = ai.a(contextC, i15);
            }
            int i16 = rect.bottom;
            if (i16 != -999) {
                layoutParams2.bottomMargin = ai.a(contextC, i16);
            }
            if (i11 > 0) {
                layoutParams2.width = ai.a(contextC, i11);
            }
            if (i12 > 0) {
                layoutParams2.height = ai.a(contextC, i12);
            }
            return layoutParams2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            int i17 = rect.left;
            if (i17 != -999) {
                layoutParams3.leftMargin = ai.a(contextC, i17);
            }
            int i18 = rect.top;
            if (i18 != -999) {
                layoutParams3.topMargin = ai.a(contextC, i18);
            }
            int i19 = rect.right;
            if (i19 != -999) {
                layoutParams3.rightMargin = ai.a(contextC, i19);
            }
            int i21 = rect.bottom;
            if (i21 != -999) {
                layoutParams3.bottomMargin = ai.a(contextC, i21);
            }
            if (i11 > 0) {
                layoutParams3.width = ai.a(contextC, i11);
            }
            if (i12 > 0) {
                layoutParams3.height = ai.a(contextC, i12);
            }
            return layoutParams3;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            int i22 = rect.left;
            if (i22 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = ai.a(contextC, i22);
            }
            int i23 = rect.top;
            if (i23 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = ai.a(contextC, i23);
            }
            int i24 = rect.right;
            if (i24 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = ai.a(contextC, i24);
            }
            int i25 = rect.bottom;
            if (i25 != -999) {
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = ai.a(contextC, i25);
            }
            if (i11 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).width = ai.a(contextC, i11);
            }
            if (i12 > 0) {
                ((LinearLayout.LayoutParams) layoutParams).height = ai.a(contextC, i12);
            }
        }
        return layoutParams;
    }

    public static /* synthetic */ void a(a aVar, String str, CampaignEx campaignEx) {
        if (com.mbridge.msdk.foundation.same.a.d.f44406j == null || TextUtils.isEmpty(campaignEx.getId())) {
            return;
        }
        com.mbridge.msdk.foundation.same.a.d.a(str, campaignEx, "reward");
    }

    private void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f47340i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            c(obj, e11.getMessage());
            ad.a("OperateViews", e11.getMessage());
        }
    }

    private void c(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f47341j);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.a("OperateViews", e11.getMessage());
        }
    }

    private String h(String str) {
        return f47333b.containsKey(str) ? f47333b.get(str) : "";
    }

    public final void A(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                ad.a("OperateViews", "playerStop failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).stop();
                a(obj, strOptString2);
                ad.a("OperateViews", "playerStop success");
            } else {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerStop failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerStop failed: " + th2.getMessage());
        }
    }

    public final void B(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "playerMute failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerMute failed: instanceId is not player");
            } else if (((MBridgeBTVideoView) view).playMute()) {
                a(obj, strOptString2);
                ad.a("OperateViews", "playerMute success");
            } else {
                c(obj, "set mute failed");
                ad.a("OperateViews", "playerMute failed set mute failed");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerMute failed: " + th2.getMessage());
        }
    }

    public final void D(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                ad.a("OperateViews", "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerUnmute failed: instanceId is not player");
            } else if (!((MBridgeBTVideoView) view).playUnMute()) {
                a(obj, "set unmute failed");
                ad.a("OperateViews", "playerUnmute failed: set unmute failed");
            } else {
                a(obj, strOptString2);
                a(obj, "onUnmute", strOptString2);
                ad.a("OperateViews", "playerUnmute successed");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerUnmute failed: " + th2.getMessage());
        }
    }

    public final void E(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTVideoView)) {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((MBridgeBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(TrackingKey.CODE, f47340i);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", strOptString2);
            jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, mute);
            jSONObject2.put("data", jSONObject3);
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            ad.a("OperateViews", "playerGetMuteState successed mute = " + mute);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerGetMuteState failed: " + th2.getMessage());
        }
    }

    public final void F(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
        }
    }

    public final void H(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBTempContainer)) {
                c(obj, "view not exist");
            } else {
                ((MBTempContainer) view).preload();
                a(obj, strOptString2);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "preloadSubPlayTemplateView failed: " + th2.getMessage());
        }
    }

    public final void I(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId or instanceId not exist");
                ad.a("OperateViews", "closeAd failed: unitId or instanceId not exist unitId = " + strOptString);
                return;
            }
            MBridgeBTContainer mBridgeBTContainer = null;
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTContainer) {
                    mBridgeBTContainer = (MBridgeBTContainer) view;
                } else if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                } else if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).getInstanceId();
                    b unused = b.a.f47365a;
                    ((MBridgeBTVideoView) view).onDestory();
                } else if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
            }
            if (mBridgeBTContainer == null) {
                c(obj, "not found MBridgeBTContainer");
                ad.a("OperateViews", "closeAd successed");
                return;
            }
            mBridgeBTContainer.onAdClose();
            f47332a.remove(linkedHashMapB);
            linkedHashMapB.clear();
            f47332a.remove(strOptString + "_" + strH);
            a(obj, strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "closeAd failed: " + th2.getMessage());
        }
    }

    public final void J(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View view : linkedHashMapB.values()) {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
                if (view instanceof MBridgeBTLayout) {
                    ((MBridgeBTLayout) view).broadcast(strOptString2, jSONObjectOptJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "broadcast failed: " + th2.getMessage());
        }
    }

    public final void K(Object obj, JSONObject jSONObject) {
        com.mbridge.msdk.videocommon.b.c cVar;
        String strOptString;
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString3 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString4 = jSONObjectOptJSONObject.optString("userId");
            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("expired");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
            String strOptString5 = jSONObjectOptJSONObject.optString("extra");
            if (jSONObjectOptJSONObject2 != null) {
                cVar = new com.mbridge.msdk.videocommon.b.c(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optInt("amount"));
                strOptString = jSONObjectOptJSONObject2.optString("id");
            } else {
                cVar = null;
                strOptString = "";
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString2, rid);
            if (linkedHashMapB.size() <= 0 || !f47336e.containsKey(strOptString3)) {
                c(obj, "unitId not exist");
                ad.a("OperateViews", "setSubPlayTemplateInfo failed: unitId not exist instanceId = " + strOptString3);
                return;
            }
            View view = linkedHashMapB.get(strOptString3);
            if (!(view instanceof MBTempContainer)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "setSubPlayTemplateInfo failed: instanceId not exist instanceId = " + strOptString3);
                return;
            }
            MBTempContainer mBTempContainer = (MBTempContainer) view;
            mBTempContainer.setReward(cVar);
            mBTempContainer.setUserId(strOptString4);
            mBTempContainer.setRewardId(strOptString);
            mBTempContainer.setCampaignExpired(zOptBoolean);
            if (!TextUtils.isEmpty(strOptString5)) {
                mBTempContainer.setDeveloperExtraData(strOptString5);
            }
            a(obj, strOptString3);
            ad.a("OperateViews", "setSubPlayTemplateInfo success instanceId = " + strOptString3);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "setSubPlayTemplateInfo failed: " + th2.getMessage());
        }
    }

    public final void L(Object obj, JSONObject jSONObject) {
        try {
            WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
            String rid = windVaneWebView != null ? windVaneWebView.getRid() : "";
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            String strOptString3 = jSONObjectOptJSONObject.optString("eventName");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("eventData");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
            if (linkedHashMapB.size() <= 0) {
                c(obj, "unitId not exist");
                ad.a("OperateViews", "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (childAt instanceof WindVaneWebView) {
                        g.a().a((WebView) childAt, strOptString3, Base64.encodeToString(jSONObjectOptJSONObject2.toString().getBytes(), 2));
                        a(obj, strOptString2);
                        ad.a("OperateViews", "webviewFireEvent instanceId = " + strOptString2);
                        return;
                    }
                }
            }
            c(obj, "instanceId not exist");
            ad.a("OperateViews", "webviewFireEvent failed: instanceId not exist instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "webviewFireEvent failed: " + th2.getMessage());
        }
    }

    public final void M(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            final CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject);
            if (campaignWithBackData == null) {
                c(obj, "data camapign is empty");
            } else {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            if (kVarA != null) {
                                if (kVarA.b(campaignWithBackData.getId())) {
                                    kVarA.a(campaignWithBackData.getId());
                                } else {
                                    com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                    gVar.a(campaignWithBackData.getId());
                                    gVar.b(campaignWithBackData.getFca());
                                    gVar.c(campaignWithBackData.getFcb());
                                    gVar.a(0);
                                    gVar.d(1);
                                    gVar.a(System.currentTimeMillis());
                                    kVarA.a(gVar);
                                }
                            }
                            a.a(a.this, campaignWithBackData.getCampaignUnitId(), campaignWithBackData);
                        } catch (Throwable th2) {
                            ad.a("OperateViews", th2.getMessage(), th2);
                        }
                    }
                }).start();
                a(obj, "");
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.json.JSONObject] */
    public final void N(Object obj, JSONObject jSONObject) {
        ?? r11;
        String str;
        String str2;
        String str3;
        int i11;
        String str4;
        String str5;
        ?? jSONObject2 = new JSONObject();
        String str6 = "message";
        String str7 = TrackingKey.CODE;
        int i12 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put(TrackingKey.CODE, 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e11) {
                ad.a("OperateViews", e11.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put(TrackingKey.CODE, 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray == null) {
                str = TrackingKey.CODE;
                r11 = 1;
                jSONObject2.put(str, 1);
                str5 = "message";
                jSONObject2.put(str5, "resource is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                r11 = str5;
                return;
            }
            try {
                if (jSONArray.length() > 0) {
                    ?? jSONArray2 = new JSONArray();
                    int length = jSONArray.length();
                    int i13 = 0;
                    while (i13 < length) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i13);
                        String strOptString = jSONObject3.optString("ref", "");
                        int i14 = jSONObject3.getInt("type");
                        ?? jSONObject4 = new JSONObject();
                        JSONArray jSONArray3 = jSONArray;
                        if (i14 != i12 || TextUtils.isEmpty(strOptString)) {
                            str2 = str6;
                            str3 = str7;
                            i11 = length;
                            if (i14 == 2 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put("type", 2);
                                jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, H5DownLoadManager.getInstance().getH5ResAddress(strOptString) == null ? "" : H5DownLoadManager.getInstance().getH5ResAddress(strOptString));
                                jSONObject4.put(strOptString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } else if (i14 == 3 && !TextUtils.isEmpty(strOptString)) {
                                try {
                                    File file = new File(strOptString);
                                    if (file.exists() && file.isFile() && file.canRead()) {
                                        ad.a("OperateViews", "getFileInfo Mraid file " + strOptString);
                                        str4 = "file:////" + strOptString;
                                    } else {
                                        str4 = "";
                                    }
                                } catch (Throwable th2) {
                                    if (MBridgeConstans.DEBUG) {
                                        th2.printStackTrace();
                                    }
                                }
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("type", 3);
                                jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str4);
                                jSONObject4.put(strOptString, jSONObject6);
                                jSONArray2.put(jSONObject4);
                            } else if (i14 == 4 && !TextUtils.isEmpty(strOptString)) {
                                JSONObject jSONObject7 = new JSONObject();
                                jSONObject7.put("type", 4);
                                jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, ah.a(strOptString) == null ? "" : ah.a(strOptString));
                                jSONObject4.put(strOptString, jSONObject7);
                                jSONArray2.put(jSONObject4);
                            }
                        } else {
                            JSONObject jSONObject8 = new JSONObject();
                            m mVarA = p.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(strOptString);
                            if (mVarA != null) {
                                i11 = length;
                                ad.a("OperateViews", "VideoBean not null");
                                jSONObject8.put("type", 1);
                                str2 = str6;
                                try {
                                    jSONObject8.put("videoDataLength", mVarA.d());
                                    String strE = mVarA.e();
                                    str3 = str7;
                                    if (TextUtils.isEmpty(strE)) {
                                        try {
                                            ad.a("OperateViews", "VideoPath null");
                                            jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "");
                                            jSONObject8.put("path4Web", "");
                                        } catch (Throwable th3) {
                                            th = th3;
                                            r11 = str2;
                                            str = str3;
                                            jSONObject2.put(str, 1);
                                            jSONObject2.put(r11, th.getLocalizedMessage());
                                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                        }
                                    } else {
                                        ad.a("OperateViews", "VideoPath not null");
                                        jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                        jSONObject8.put("path4Web", strE);
                                    }
                                    if (mVarA.b() == 5) {
                                        jSONObject8.put("downloaded", 1);
                                    } else {
                                        jSONObject8.put("downloaded", 0);
                                    }
                                    jSONObject4.put(strOptString, jSONObject8);
                                    jSONArray2.put(jSONObject4);
                                } catch (Throwable th4) {
                                    th = th4;
                                    str3 = str7;
                                    r11 = str2;
                                    str = str3;
                                    jSONObject2.put(str, 1);
                                    jSONObject2.put(r11, th.getLocalizedMessage());
                                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                                }
                            } else {
                                str2 = str6;
                                str3 = str7;
                                i11 = length;
                                ad.a("OperateViews", "VideoBean null");
                            }
                        }
                        i13++;
                        jSONArray = jSONArray3;
                        length = i11;
                        str6 = str2;
                        str7 = str3;
                        i12 = 1;
                    }
                    str2 = str6;
                    str3 = str7;
                    jSONObject2.put("resource", jSONArray2);
                    g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                }
                str = TrackingKey.CODE;
                r11 = 1;
                try {
                    try {
                        jSONObject2.put(str, 1);
                        str5 = "message";
                        try {
                            jSONObject2.put(str5, "resource is null");
                            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            r11 = str5;
                        } catch (JSONException e12) {
                            e = e12;
                            ad.a("OperateViews", e.getMessage());
                            r11 = str5;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (JSONException e13) {
                    e = e13;
                    str5 = "message";
                } catch (Throwable th6) {
                    th = th6;
                    r11 = "message";
                }
                return;
            } catch (Throwable th7) {
                th = th7;
                str2 = str6;
            }
        } catch (Throwable th8) {
            th = th8;
            r11 = "message";
            str = TrackingKey.CODE;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(r11, th.getLocalizedMessage());
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e14) {
            ad.a("OperateViews", e14.getMessage());
        }
    }

    public final void O(Object obj, JSONObject jSONObject) {
        ad.a("OperateViews", "createNativeEC:" + jSONObject);
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (cVarA != null) {
                    cVarA.a(strOptString);
                }
                MBridgeBTNativeEC mBridgeBTNativeEC = new MBridgeBTNativeEC(com.mbridge.msdk.foundation.controller.c.m().c());
                mBridgeBTNativeEC.setCampaign(campaignWithBackData);
                com.mbridge.msdk.video.signal.a.k kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignWithBackData);
                kVar.a(strOptString);
                mBridgeBTNativeEC.setJSCommon(kVar);
                mBridgeBTNativeEC.setUnitId(strOptString);
                mBridgeBTNativeEC.setRewardUnitSetting(cVarA);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                if (windVaneWebView != null) {
                    rid = windVaneWebView.getRid();
                    mBridgeBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f47333b.put(strA, rid);
                mBridgeBTNativeEC.setInstanceId(strA);
                linkedHashMapB.put(strA, mBridgeBTNativeEC);
                mBridgeBTNativeEC.preLoadData();
                if (campaignWithBackData == null) {
                    c(obj, "campaign is null");
                    ad.a("OperateViews", "createNativeEC failed");
                    return;
                }
                a(obj, strA);
                ad.a("OperateViews", "createNativeEC instanceId = " + strA);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "createNativeEC failed：" + th2.getMessage());
        }
    }

    public final CampaignEx a(String str) {
        if (f47334c.containsKey(str)) {
            return f47334c.get(str);
        }
        return null;
    }

    public final String a() {
        f47339h++;
        return String.valueOf(f47339h);
    }

    public final void a(int i11, int i12, int i13, int i14, int i15) {
        ad.a("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)));
        f47342k = r.a(i11, i12, i13, i14, i15);
        f47343l = i11;
        f47344m = i12;
        f47345n = i13;
        f47346o = i14;
        f47347p = i15;
    }

    public final void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f47341j);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            g.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            ad.a("OperateViews", e11.getMessage());
        }
    }

    public final void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f47340i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            g.a().a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            a(webView, e11.getMessage());
            ad.a("OperateViews", e11.getMessage());
        }
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TrackingKey.CODE, f47340i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            c(obj, e11.getMessage());
            ad.a("OperateViews", e11.getMessage());
        }
    }

    public final void a(final Object obj, JSONObject jSONObject) {
        final Rect rect;
        final int i11;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(strOptString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
            jSONObjectOptJSONObject.optString("fileURL");
            jSONObjectOptJSONObject.optString(NativeRequestBridge.KEY_FILE_PATH);
            jSONObjectOptJSONObject.optString("html");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect3 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect3;
                i11 = iOptInt3;
            } else {
                rect = rect2;
                i11 = 0;
                iOptInt = 0;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    String rid;
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                    if (windVaneWebView != null) {
                        rid = windVaneWebView.getRid();
                    } else {
                        rid = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> linkedHashMapB = a.this.b(strOptString, rid);
                    String strA = a.this.a();
                    a.f47333b.put(strA, rid);
                    MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                    linkedHashMapB.put(strA, mBridgeBTLayout);
                    mBridgeBTLayout.setInstanceId(strA);
                    mBridgeBTLayout.setUnitId(strOptString);
                    mBridgeBTLayout.setWebView(windVaneWebView);
                    mBridgeBTLayout.setRect(rect);
                    int i12 = i11;
                    if (i12 > 0 || iOptInt > 0) {
                        mBridgeBTLayout.setLayout(i12, iOptInt);
                    }
                    a.this.a(obj, strA);
                    ad.a("OperateViews", "create view instanceId = " + strA);
                }
            }, iOptInt2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "create view failed：" + th2.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject, boolean z11) {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
                rect = null;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
            if (z11) {
                ar.a(view);
            }
            viewGroup.addView(view, iIndexOfChild + 1, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            ad.a("OperateViews", "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "insertViewAbove failed: " + th2.getMessage());
        }
    }

    public final void a(String str, int i11) {
        f47337f.put(str, Integer.valueOf(i11));
    }

    public final void a(String str, Activity activity) {
        f47338g.put(str, activity);
    }

    public final void a(String str, String str2) {
        f47333b.put(str, str2);
    }

    public final com.mbridge.msdk.videocommon.d.c b(String str) {
        if (f47335d.containsKey(str)) {
            return f47335d.get(str);
        }
        return null;
    }

    public final synchronized LinkedHashMap<String, View> b(String str, String str2) {
        if (f47332a.containsKey(str + "_" + str2)) {
            return f47332a.get(str + "_" + str2);
        }
        LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
        f47332a.put(str + "_" + str2, linkedHashMap);
        return linkedHashMap;
    }

    public final void b(Object obj, String str) {
        ad.a("OperateViews", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                int iOptInt = jSONObject.optInt("type");
                String strA = ai.a(jSONObject.optString("url"), "&tun=", z.q() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", strA, false, iOptInt != 0);
                } else {
                    com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), (CampaignEx) null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            try {
                a(obj, "");
            } catch (Throwable th2) {
                th = th2;
                ad.a("OperateViews", "reportUrls", th);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void b(final Object obj, JSONObject jSONObject) {
        final Rect rect;
        final int i11;
        final int iOptInt;
        try {
            final String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (TextUtils.isEmpty(strOptString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("delay", 0);
            final String strOptString2 = jSONObjectOptJSONObject.optString("fileURL");
            final String strOptString3 = jSONObjectOptJSONObject.optString(NativeRequestBridge.KEY_FILE_PATH);
            final String strOptString4 = jSONObjectOptJSONObject.optString("html");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect3 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("width");
                iOptInt = jSONObjectOptJSONObject2.optInt("height");
                rect = rect3;
                i11 = iOptInt3;
            } else {
                rect = rect2;
                i11 = 0;
                iOptInt = 0;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    String rid;
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                    if (windVaneWebView != null) {
                        rid = windVaneWebView.getRid();
                    } else {
                        rid = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> linkedHashMapB = a.this.b(strOptString, rid);
                    String strA = a.this.a();
                    a.f47333b.put(strA, rid);
                    MBridgeBTWebView mBridgeBTWebView = new MBridgeBTWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                    linkedHashMapB.put(strA, mBridgeBTWebView);
                    mBridgeBTWebView.setInstanceId(strA);
                    mBridgeBTWebView.setUnitId(strOptString);
                    mBridgeBTWebView.setFileURL(strOptString2);
                    mBridgeBTWebView.setFilePath(strOptString3);
                    mBridgeBTWebView.setHtml(strOptString4);
                    mBridgeBTWebView.setRect(rect);
                    mBridgeBTWebView.setWebViewRid(rid);
                    mBridgeBTWebView.setCreateWebView(windVaneWebView);
                    int i12 = i11;
                    if (i12 > 0 || iOptInt > 0) {
                        mBridgeBTWebView.setLayout(i12, iOptInt);
                    }
                    mBridgeBTWebView.preload();
                    a.this.a(obj, strA);
                    ad.a("OperateViews", "createWebview instanceId = " + strA);
                }
            }, iOptInt2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "createWebview failed：" + th2.getMessage());
        }
    }

    public final void b(Object obj, JSONObject jSONObject, boolean z11) {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "insertViewBelow failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "insertViewBelow failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                rect = null;
                iOptInt = 0;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
            if (z11) {
                ar.a(view);
            }
            int i11 = iIndexOfChild - 1;
            viewGroup.addView(view, i11 > -1 ? i11 : 0, layoutParamsA);
            a(obj, strOptString2);
            a(obj, "onInsertViewBelow", strOptString2);
            ad.a("OperateViews", "insertViewBelow instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "insertViewBelow failed: " + th2.getMessage());
        }
    }

    public final String c(String str) {
        return f47336e.containsKey(str) ? f47336e.get(str) : "";
    }

    public final void c(Object obj, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                int iOptInt = jSONObjectOptJSONObject.optInt(TrackingKey.SHOW_TIME, 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("show_mute", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("show_close", 0);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("orientation", 1);
                int iOptInt5 = jSONObjectOptJSONObject.optInt("show_pgb", 0);
                MBridgeBTVideoView mBridgeBTVideoView = new MBridgeBTVideoView(com.mbridge.msdk.foundation.controller.c.m().c());
                mBridgeBTVideoView.setCampaign(campaignWithBackData);
                mBridgeBTVideoView.setUnitId(strOptString);
                mBridgeBTVideoView.setShowMute(iOptInt2);
                mBridgeBTVideoView.setShowTime(iOptInt);
                mBridgeBTVideoView.setShowClose(iOptInt3);
                mBridgeBTVideoView.setOrientation(iOptInt4);
                mBridgeBTVideoView.setProgressBarState(iOptInt5);
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                if (windVaneWebView != null) {
                    rid = windVaneWebView.getRid();
                    mBridgeBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f47333b.put(strA, rid);
                mBridgeBTVideoView.setInstanceId(strA);
                linkedHashMapB.put(strA, mBridgeBTVideoView);
                mBridgeBTVideoView.preLoadData();
                if (campaignWithBackData == null) {
                    c(obj, "campaign is null");
                    ad.a("OperateViews", "createPlayerView failed");
                } else {
                    a(obj, strA);
                    ad.a("OperateViews", "createPlayerView instanceId = " + strA);
                }
                b unused = b.a.f47365a;
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "createPlayerView failed：" + th2.getMessage());
        }
    }

    public final void d(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                int iOptInt = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
                String rid = "";
                CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectOptJSONObject.optJSONObject("campaign"));
                if (campaignWithBackData != null && !TextUtils.isEmpty(strOptString)) {
                    campaignWithBackData.setCampaignUnitId(strOptString);
                    rid = campaignWithBackData.getRequestId();
                }
                com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject.optJSONObject("unitSetting"));
                if (cVarA != null) {
                    cVarA.a(strOptString);
                }
                String strOptString2 = jSONObjectOptJSONObject.optString("userId");
                if (TextUtils.isEmpty(rid) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                    rid = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, rid);
                String strA = a();
                f47333b.put(strA, rid);
                MBTempContainer mBTempContainer = new MBTempContainer(com.mbridge.msdk.foundation.controller.c.m().c());
                mBTempContainer.setInstanceId(strA);
                mBTempContainer.setUnitId(strOptString);
                mBTempContainer.setCampaign(campaignWithBackData);
                mBTempContainer.setRewardUnitSetting(cVarA);
                mBTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(strOptString2)) {
                    mBTempContainer.setUserId(strOptString2);
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reward");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString3 = jSONObjectOptJSONObject2.optString("id");
                    com.mbridge.msdk.videocommon.b.c cVar = new com.mbridge.msdk.videocommon.b.c(jSONObjectOptJSONObject2.optString("name"), jSONObjectOptJSONObject2.optInt("amount"));
                    if (!TextUtils.isEmpty(strOptString3)) {
                        mBTempContainer.setRewardId(strOptString3);
                    }
                    if (!TextUtils.isEmpty(cVar.a())) {
                        mBTempContainer.setReward(cVar);
                    }
                }
                String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                if (!TextUtils.isEmpty(strOptString4)) {
                    mBTempContainer.setDeveloperExtraData(strOptString4);
                }
                mBTempContainer.setMute(iOptInt);
                linkedHashMapB.put(strA, mBTempContainer);
                f47336e.put(strA, strOptString);
                f47334c.put(strA, campaignWithBackData);
                f47335d.put(strA, cVarA);
                a(obj, strA);
                ad.a("OperateViews", "createSubPlayTemplateView instanceId = " + strA);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "createSubPlayTemplateView failed：" + th2.getMessage());
        }
    }

    public final void d(String str) {
        f47338g.remove(str);
    }

    public final int e(String str) {
        if (f47337f.containsKey(str)) {
            return f47337f.get(str).intValue();
        }
        return 2;
    }

    public final void e(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !TextUtils.isEmpty(strOptString)) {
                String strH = h(strOptString2);
                if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                    strH = windVaneWebView.getRid();
                }
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (linkedHashMapB == null || !linkedHashMapB.containsKey(strOptString2)) {
                    c(obj, "unitId or instanceId not exist");
                    ad.a("OperateViews", "destroyComponent failed");
                    return;
                }
                View view = linkedHashMapB.get(strOptString2);
                linkedHashMapB.remove(strOptString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            for (int i11 = 0; i11 < childCount; i11++) {
                                View childAt = viewGroup2.getChildAt(i11);
                                if (childAt instanceof MBridgeBTWebView) {
                                    linkedHashMapB.remove(((MBridgeBTWebView) childAt).getInstanceId());
                                    ((MBridgeBTWebView) childAt).onDestory();
                                } else if (childAt instanceof MBridgeBTVideoView) {
                                    linkedHashMapB.remove(((MBridgeBTVideoView) childAt).getInstanceId());
                                    ((MBridgeBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof MBTempContainer) {
                                    linkedHashMapB.remove(((MBTempContainer) childAt).getInstanceId());
                                    ((MBTempContainer) childAt).onDestroy();
                                }
                            }
                        }
                    }
                }
                if (view instanceof MBTempContainer) {
                    ((MBTempContainer) view).onDestroy();
                }
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).onDestory();
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).onDestory();
                }
                a(obj, strOptString2);
                a(obj, "onComponentDestroy", strOptString2);
                ad.a("OperateViews", "destroyComponent instanceId = " + strOptString2);
                return;
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "destroyComponent failed");
        }
    }

    public final void f(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                a(obj, strOptString);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
        }
    }

    public final void f(String str) {
        if (f47336e.containsKey(str)) {
            f47336e.remove(str);
        }
        if (f47335d.containsKey(str)) {
            f47335d.remove(str);
        }
        if (f47334c.containsKey(str)) {
            f47334c.remove(str);
        }
        if (f47333b.containsKey(str)) {
            f47333b.remove(str);
        }
    }

    public final void g(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            if (jSONObjectOptJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            Rect rect = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
            int iOptInt = jSONObjectOptJSONObject2.optInt("width");
            int iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "setViewRect failed: instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view is null");
                ad.a("OperateViews", "setViewRect failed: view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, iOptInt, iOptInt2));
                view.requestLayout();
            } else {
                if (view instanceof MBridgeBTWebView) {
                    ((MBridgeBTWebView) view).setRect(rect);
                    ((MBridgeBTWebView) view).setLayout(iOptInt, iOptInt2);
                }
                if (view instanceof MBridgeBTVideoView) {
                    ((MBridgeBTVideoView) view).setRect(rect);
                    ((MBridgeBTVideoView) view).setLayout(iOptInt, iOptInt2);
                }
            }
            a(obj, strOptString2);
            a(obj, "onViewRectChanged", strOptString2);
            ad.a("OperateViews", "setViewRect instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "setViewRect failed: " + th2.getMessage());
        }
    }

    public final void g(String str) {
        if (f47337f.containsKey(str)) {
            f47337f.remove(str);
        }
    }

    public final void h(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "params not enough");
                ad.a("OperateViews", "removeFromSuperView failed: params not enough instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                ad.a("OperateViews", "removeFromSuperView failed: view is null instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                ad.a("OperateViews", "removeFromSuperView failed: parent is null instanceId = " + strOptString2);
                return;
            }
            viewGroup.removeView(view);
            a(obj, strOptString2);
            a(obj, "onRemoveFromView", strOptString2);
            ad.a("OperateViews", "removeFromSuperView instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "removeFromSuperView failed: " + th2.getMessage());
        }
    }

    public final void i(Object obj, JSONObject jSONObject) {
        int iOptInt;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString3) || !linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                ad.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString2);
            View view = linkedHashMapB.get(strOptString3);
            ar.a(view);
            if (viewGroup != null && view != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                int iOptInt2 = 0;
                if (view instanceof MBTempContainer) {
                    ad.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f47343l), Integer.valueOf(f47344m), Integer.valueOf(f47345n), Integer.valueOf(f47346o), Integer.valueOf(f47347p)));
                    ((MBTempContainer) view).setNotchPadding(f47343l, f47344m, f47345n, f47346o, f47347p);
                    for (View view2 : linkedHashMapB.values()) {
                        if (view2 instanceof MBridgeBTContainer) {
                            ar.a(view);
                            ((MBridgeBTContainer) view2).appendSubView((MBridgeBTContainer) view2, (MBTempContainer) view, jSONObjectOptJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (jSONObjectOptJSONObject2 != null) {
                        Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                        iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                        iOptInt = jSONObjectOptJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        iOptInt2 = ((BTBaseView) view).getViewWidth();
                        iOptInt = ((BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        iOptInt = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt2, iOptInt);
                    ar.a(view);
                    viewGroup.addView(view, layoutParamsA);
                }
                a(obj, strOptString2);
                a(obj, "onAppendView", strOptString2);
                ad.a("OperateViews", "appendSubView parentId = " + strOptString2 + " childId = " + strOptString3);
                return;
            }
            c(obj, "view is not exist");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "appendSubView failed: " + th2.getMessage());
        }
    }

    public final void j(Object obj, JSONObject jSONObject) {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    ad.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                ar.a(view);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        for (View view2 : linkedHashMapB.values()) {
                            if (view2 instanceof MBridgeBTContainer) {
                                ar.a(view);
                                ((MBridgeBTContainer) view2).appendSubView((MBridgeBTContainer) view2, (MBTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                            iOptInt = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt = ((BTBaseView) view).getViewWidth();
                            iOptInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                            rect = null;
                            iOptInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        ViewGroup.LayoutParams layoutParamsA = a(layoutParams, rect, iOptInt, iOptInt2);
                        ar.a(view);
                        viewGroup.addView(view, layoutParamsA);
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    ad.a("OperateViews", "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "appendViewTo failed: " + th2.getMessage());
        }
    }

    public final void k(Object obj, JSONObject jSONObject) {
        int iOptInt;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("id");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString3) || !linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                ad.a("OperateViews", "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString2);
            View view = linkedHashMapB.get(strOptString3);
            if (viewGroup != null && view != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                int iOptInt2 = 0;
                if (view instanceof MBTempContainer) {
                    ad.b("OperateViews", "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(f47343l), Integer.valueOf(f47344m), Integer.valueOf(f47345n), Integer.valueOf(f47346o), Integer.valueOf(f47347p)));
                    ((MBTempContainer) view).setNotchPadding(f47343l, f47344m, f47345n, f47346o, f47347p);
                    for (View view2 : linkedHashMapB.values()) {
                        if (view2 instanceof MBridgeBTContainer) {
                            ar.a(view);
                            ((MBridgeBTContainer) view2).appendSubView((MBridgeBTContainer) view2, (MBTempContainer) view, jSONObjectOptJSONObject2);
                            break;
                        }
                    }
                } else {
                    if (jSONObjectOptJSONObject2 != null) {
                        Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                        iOptInt2 = jSONObjectOptJSONObject2.optInt("width");
                        iOptInt = jSONObjectOptJSONObject2.optInt("height");
                        rect = rect2;
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        iOptInt2 = ((BTBaseView) view).getViewWidth();
                        iOptInt = ((BTBaseView) view).getViewHeight();
                    } else {
                        rect = null;
                        iOptInt = 0;
                    }
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, iOptInt2, iOptInt));
                }
                a(obj, strOptString2);
                a(obj, "onAppendView", strOptString2);
                ad.a("OperateViews", "appendSubView parentId = " + strOptString2 + " childId = " + strOptString3);
                return;
            }
            c(obj, "view is not exist");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "appendSubView failed: " + th2.getMessage());
        }
    }

    public final void l(Object obj, JSONObject jSONObject) {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                String strOptString3 = jSONObjectOptJSONObject.optString("id");
                LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
                if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                    c(obj, "instanceId is not exist");
                    ad.a("OperateViews", "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) linkedHashMapB.get(strOptString3);
                View view = linkedHashMapB.get(strOptString2);
                if (viewGroup != null && view != null) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
                    if (view instanceof MBTempContainer) {
                        for (View view2 : linkedHashMapB.values()) {
                            if (view2 instanceof MBridgeBTContainer) {
                                ar.a(view);
                                ((MBridgeBTContainer) view2).appendSubView((MBridgeBTContainer) view2, (MBTempContainer) view, jSONObjectOptJSONObject2);
                                break;
                            }
                        }
                    } else {
                        if (jSONObjectOptJSONObject2 != null) {
                            Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                            iOptInt = jSONObjectOptJSONObject2.optInt("width");
                            iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                            rect = rect2;
                        } else if (view instanceof BTBaseView) {
                            rect = ((BTBaseView) view).getRect();
                            iOptInt = ((BTBaseView) view).getViewWidth();
                            iOptInt2 = ((BTBaseView) view).getViewHeight();
                        } else {
                            iOptInt = 0;
                            rect = null;
                            iOptInt2 = 0;
                        }
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        if (viewGroup instanceof FrameLayout) {
                            layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof RelativeLayout) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        } else if (viewGroup instanceof LinearLayout) {
                            layoutParams = new LinearLayout.LayoutParams(-1, -1);
                        }
                        viewGroup.addView(view, a(layoutParams, rect, iOptInt, iOptInt2));
                    }
                    a(obj, strOptString2);
                    a(obj, "onAppendViewTo", strOptString2);
                    ad.a("OperateViews", "appendViewTo parentId = " + strOptString3 + " childId = " + strOptString2);
                    return;
                }
                c(obj, "view is not exist");
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "appendViewTo failed: " + th2.getMessage());
        }
    }

    public final void m(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId is not exist");
                ad.a("OperateViews", "bringViewToFront failed: instanceId is not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                ad.a("OperateViews", "bringViewToFront failed: view is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                ad.a("OperateViews", "bringViewToFront failed: parent is null");
                return;
            }
            viewGroup.bringChildToFront(view);
            a(obj, strOptString2);
            a(obj, "onBringViewToFront", strOptString2);
            ad.a("OperateViews", "bringViewToFront instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "bringViewToFront failed: " + th2.getMessage());
        }
    }

    public final void n(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "hideView failed: instanceId not exist");
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "hideView failed: view not exist");
                return;
            }
            view.setVisibility(8);
            a(obj, strOptString2);
            a(obj, "onHideView", strOptString2);
            ad.a("OperateViews", "hideView instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "hideView failed: + " + th2.getMessage());
        }
    }

    public final void o(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "showView failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "showView failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setVisibility(0);
            a(obj, strOptString2);
            a(obj, "onShowView", strOptString2);
            ad.a("OperateViews", "showView instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "showView failed: " + th2.getMessage());
        }
    }

    public final void p(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString(TtmlNode.ATTR_TTS_COLOR);
            if (TextUtils.isEmpty(strOptString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "setViewBgColor failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "setViewBgColor failed: view not exist instanceId = " + strOptString2);
                return;
            }
            a(obj, strOptString2);
            view.setBackgroundColor(Color.parseColor(strOptString3));
            a(obj, "onViewBgColorChanged", strOptString2);
            ad.a("OperateViews", "setViewBgColor instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "setViewBgColor failed: " + th2.getMessage());
        }
    }

    public final void q(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "setViewAlpha failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "setViewAlpha failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setAlpha((float) dOptDouble);
            a(obj, strOptString2);
            a(obj, "onViewAlphaChanged", strOptString2);
            ad.a("OperateViews", "setViewAlpha instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "setViewAlpha failed: " + th2.getMessage());
        }
    }

    public final void r(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double dOptDouble = jSONObjectOptJSONObject.optDouble("vertical", 1.0d);
            double dOptDouble2 = jSONObjectOptJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "setViewScale failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "setViewScale failed: view not exist instanceId = " + strOptString2);
                return;
            }
            view.setScaleX((float) dOptDouble2);
            view.setScaleY((float) dOptDouble);
            a(obj, strOptString2);
            a(obj, "onViewScaleChanged", strOptString2);
            ad.a("OperateViews", "setViewScale instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "setViewScale failed: " + th2.getMessage());
        }
    }

    public final void s(Object obj, JSONObject jSONObject) {
        int iOptInt;
        int iOptInt2;
        Rect rect;
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("targetComponentId");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2) || !linkedHashMapB.containsKey(strOptString3)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "insertViewAbove failed: instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            View view2 = linkedHashMapB.get(strOptString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                ad.a("OperateViews", "insertViewAbove failed: view not exist instanceId = " + strOptString2);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(view2);
            if (jSONObjectOptJSONObject2 != null) {
                Rect rect2 = new Rect(jSONObjectOptJSONObject2.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject2.optInt("top", -999), jSONObjectOptJSONObject2.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject2.optInt("bottom", -999));
                iOptInt = jSONObjectOptJSONObject2.optInt("width");
                iOptInt2 = jSONObjectOptJSONObject2.optInt("height");
                rect = rect2;
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                iOptInt = ((BTBaseView) view).getViewWidth();
                iOptInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                iOptInt = 0;
                rect = null;
                iOptInt2 = 0;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, iIndexOfChild + 1, a(layoutParams, rect, iOptInt, iOptInt2));
            a(obj, strOptString2);
            a(obj, "onInsertViewAbove", strOptString2);
            ad.a("OperateViews", "insertViewAbove instanceId = " + strOptString2 + " brotherId = " + strOptString3);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "insertViewAbove failed: " + th2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    public final void t(Object obj, JSONObject jSONObject) {
        String str;
        Object obj2;
        String str2;
        int iOptInt;
        Rect rect;
        Object obj3;
        int i11;
        WindVaneWebView windVaneWebView;
        Object obj4 = obj;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj4).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                c(obj4, "data is empty");
                return;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(AppLovinEventTypes.USER_VIEWED_CONTENT);
            if (jSONObjectOptJSONObject2 == null) {
                c(obj4, "content is empty");
                return;
            }
            String strOptString3 = jSONObjectOptJSONObject2.optString("fileURL");
            String strOptString4 = jSONObjectOptJSONObject2.optString(NativeRequestBridge.KEY_FILE_PATH);
            String strOptString5 = jSONObjectOptJSONObject2.optString("html");
            if (TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString4) && TextUtils.isEmpty(strOptString5)) {
                c(obj4, "url is empty");
                return;
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("campaigns");
            List<CampaignEx> arrayList = new ArrayList<>();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                int i12 = 0;
                while (i12 < length) {
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONArrayOptJSONArray.getJSONObject(i12));
                    if (campaignWithBackData != null) {
                        campaignWithBackData.setCampaignUnitId(strOptString);
                        arrayList.add(campaignWithBackData);
                    }
                    i12++;
                    jSONArrayOptJSONArray = jSONArray;
                }
            }
            String strOptString6 = jSONObjectOptJSONObject2.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.c.a(jSONObjectOptJSONObject2.optJSONObject("unitSetting"));
            if (cVarA != null) {
                cVarA.a(strOptString6);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("rect");
            Rect rect2 = new Rect(-999, -999, -999, -999);
            if (jSONObjectOptJSONObject3 != null) {
                try {
                    str2 = "OperateViews";
                    try {
                        Rect rect3 = new Rect(jSONObjectOptJSONObject3.optInt(TtmlNode.LEFT, -999), jSONObjectOptJSONObject3.optInt("top", -999), jSONObjectOptJSONObject3.optInt(TtmlNode.RIGHT, -999), jSONObjectOptJSONObject3.optInt("bottom", -999));
                        int iOptInt2 = jSONObjectOptJSONObject3.optInt("width");
                        iOptInt = jSONObjectOptJSONObject3.optInt("height");
                        rect = rect3;
                        i11 = iOptInt2;
                    } catch (Throwable th2) {
                        th = th2;
                        obj3 = obj;
                        str = str2;
                        obj2 = obj3;
                        c(obj2, th.getMessage());
                        ad.a(str, "webviewLoad failed: " + th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = "OperateViews";
                    obj3 = obj;
                    str = str2;
                    obj2 = obj3;
                    c(obj2, th.getMessage());
                    ad.a(str, "webviewLoad failed: " + th.getMessage());
                }
            } else {
                str2 = "OperateViews";
                iOptInt = 0;
                i11 = 0;
                rect = rect2;
            }
            int iOptInt3 = jSONObjectOptJSONObject2.optInt("refreshCache", 0);
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            try {
                if (linkedHashMapB.containsKey(strOptString2)) {
                    View view = linkedHashMapB.get(strOptString2);
                    if (view instanceof MBridgeBTWebView) {
                        MBridgeBTWebView mBridgeBTWebView = (MBridgeBTWebView) view;
                        mBridgeBTWebView.setHtml(strOptString5);
                        mBridgeBTWebView.setFilePath(strOptString4);
                        mBridgeBTWebView.setFileURL(strOptString3);
                        mBridgeBTWebView.setRect(rect);
                        mBridgeBTWebView.setLayout(i11, iOptInt);
                        mBridgeBTWebView.setCampaigns(arrayList);
                        mBridgeBTWebView.setRewardUnitSetting(cVarA);
                        mBridgeBTWebView.webviewLoad(iOptInt3);
                        Object obj5 = obj;
                        try {
                            a(obj5, strOptString2);
                            String str3 = str2;
                            ad.a(str3, "webviewLoad instanceId = " + strOptString2);
                            i11 = obj5;
                            rect = str3;
                        } catch (Throwable th4) {
                            th = th4;
                            obj3 = obj5;
                            str = str2;
                            obj2 = obj3;
                            c(obj2, th.getMessage());
                            ad.a(str, "webviewLoad failed: " + th.getMessage());
                        }
                    } else {
                        Object obj6 = obj;
                        String str4 = str2;
                        c(obj6, "view not exist");
                        ad.a(str4, "webviewLoad failed: view not exist instanceId = " + strOptString2);
                        i11 = obj6;
                        rect = str4;
                    }
                } else {
                    Object obj7 = obj;
                    String str5 = str2;
                    c(obj7, "instanceId not exist");
                    ad.a(str5, "webviewLoad failed: instanceId not exist instanceId = " + strOptString2);
                    i11 = obj7;
                    rect = str5;
                }
            } catch (Throwable th5) {
                th = th5;
                obj2 = i11;
                str = rect;
                c(obj2, th.getMessage());
                ad.a(str, "webviewLoad failed: " + th.getMessage());
            }
        } catch (Throwable th6) {
            th = th6;
            str = "OperateViews";
            obj2 = obj4;
        }
    }

    public final void u(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "webviewReload failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                ad.a("OperateViews", "webviewReload failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewReload()) {
                a(obj, strOptString2);
                ad.a("OperateViews", "webviewReload instanceId = " + strOptString2);
                return;
            }
            c(obj, "reload failed");
            ad.a("OperateViews", "webviewReload failed reload failed instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "webviewReload failed: " + th2.getMessage());
        }
    }

    public final void v(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "webviewGoBack failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                ad.a("OperateViews", "webviewGoBack failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoBack()) {
                a(obj, strOptString2);
                ad.a("OperateViews", "webviewGoBack instanceId = " + strOptString2);
                return;
            }
            c(obj, "webviewGoBack failed");
            ad.a("OperateViews", "webviewGoBack failed instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "webviewGoBack failed: " + th2.getMessage());
        }
    }

    public final void w(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exist");
                ad.a("OperateViews", "webviewGoForward failed instanceId not exist instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (!(view instanceof MBridgeBTWebView)) {
                c(obj, "view not exist");
                ad.a("OperateViews", "webviewGoForward failed view not exist instanceId = " + strOptString2);
                return;
            }
            if (((MBridgeBTWebView) view).webviewGoForward()) {
                a(obj, strOptString2);
                ad.a("OperateViews", "webviewGoForward instanceId = " + strOptString2);
                return;
            }
            c(obj, "webviewGoForward failed");
            ad.a("OperateViews", "webviewGoForward failed instanceId = " + strOptString2);
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "webviewGoForward failed: " + th2.getMessage());
        }
    }

    public final void x(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                ad.a("OperateViews", "playerPlay failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).play();
                a(obj, strOptString2);
                ad.a("OperateViews", "playerPlay success");
            } else {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerPlay failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerPlay failed: " + th2.getMessage());
        }
    }

    public final void y(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                ad.a("OperateViews", "playerPause failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).pause();
                a(obj, strOptString2);
                ad.a("OperateViews", "playerPause success");
            } else {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerPause failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerPause failed: " + th2.getMessage());
        }
    }

    public final void z(Object obj, JSONObject jSONObject) {
        WindVaneWebView windVaneWebView;
        try {
            String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            String strOptString2 = jSONObject.optString("id");
            String strH = h(strOptString2);
            if (TextUtils.isEmpty(strH) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b) != null) {
                strH = windVaneWebView.getRid();
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> linkedHashMapB = b(strOptString, strH);
            if (!linkedHashMapB.containsKey(strOptString2)) {
                c(obj, "instanceId not exit");
                ad.a("OperateViews", "playerResume failed instanceId not exit instanceId = " + strOptString2);
                return;
            }
            View view = linkedHashMapB.get(strOptString2);
            if (view instanceof MBridgeBTVideoView) {
                ((MBridgeBTVideoView) view).resume();
                a(obj, strOptString2);
                ad.a("OperateViews", "playerResume success");
            } else {
                c(obj, "instanceId is not player");
                ad.a("OperateViews", "playerResume failed instanceId is not player instanceId = " + strOptString2);
            }
        } catch (Throwable th2) {
            c(obj, th2.getMessage());
            ad.a("OperateViews", "playerResume failed: " + th2.getMessage());
        }
    }
}

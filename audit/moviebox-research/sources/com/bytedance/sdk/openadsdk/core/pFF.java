package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        public int pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public String f28457sc;

        public sc(String str, int i11) {
            this.f28457sc = str;
            this.pFF = i11;
        }
    }

    private static FilterWord ExN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    FilterWord filterWordExN = ExN(jSONArrayOptJSONArray.optJSONObject(i11));
                    if (filterWordExN != null && filterWordExN.isValid()) {
                        filterWord.addOption(filterWordExN);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.ExN Ol(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.ExN exN = new com.bytedance.sdk.openadsdk.core.model.ExN();
        if (jSONObject == null) {
            exN.zY(0);
            exN.We(0);
            exN.pFF(new ArrayList());
            exN.ExN(0);
            exN.sc(new ArrayList());
            exN.pFF(0);
            exN.sc(0);
            return exN;
        }
        exN.zY(jSONObject.optInt("interceptor_x", 0));
        exN.We(jSONObject.optInt("interceptor_y", 0));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i11)));
            }
        }
        exN.pFF(arrayList);
        exN.ExN(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i12));
            }
        }
        exN.sc(arrayList2);
        exN.pFF(jSONObject.optInt("boc_index", 0));
        exN.sc(jSONObject.optInt("is_act", 0));
        return exN;
    }

    private static com.bytedance.sdk.openadsdk.core.model.dE Qj(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.dE dEVar = new com.bytedance.sdk.openadsdk.core.model.dE();
        if (jSONObject == null) {
            dEVar.sc(5);
            dEVar.pFF(30);
            dEVar.zY(70);
            dEVar.We(1);
            dEVar.ExN(com.bytedance.sdk.openadsdk.core.model.dE.f28442sc);
            return dEVar;
        }
        dEVar.sc(jSONObject.optInt("ceiling_time", 5));
        dEVar.pFF(jSONObject.optInt("ceiling_ratio", 30));
        dEVar.zY(jSONObject.optInt("expand_ratio", 70));
        dEVar.We(jSONObject.optInt("back_type", 1));
        dEVar.ExN(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.dE.f28442sc));
        return dEVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.zY TRI(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.zY zYVar = new com.bytedance.sdk.openadsdk.core.model.zY();
        zYVar.pFF(jSONObject.optString("app_name"));
        zYVar.zY(jSONObject.optString("package_name"));
        zYVar.sc(jSONObject.optString("download_url"));
        zYVar.sc(jSONObject.optDouble("score", -1.0d));
        zYVar.sc(jSONObject.optInt("comment_num", -1));
        zYVar.pFF(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        zYVar.We(jSONObject.optString("app_category"));
        return zYVar;
    }

    private static Map<String, Object> Tf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.UFX UFX(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.UFX ufx = new com.bytedance.sdk.openadsdk.core.model.UFX();
        ufx.sc(jSONObject.optString("deeplink_url"));
        ufx.pFF(jSONObject.optString("fallback_url"));
        ufx.sc(jSONObject.optInt("fallback_type"));
        return ufx;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.Tf WH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.Tf tf2 = new com.bytedance.sdk.openadsdk.core.model.Tf();
        tf2.sc(jSONObject.optInt("if_send_click", 0));
        return tf2;
    }

    private static com.bytedance.sdk.openadsdk.core.model.We We(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("splash_clickarea", 2);
        int iOptInt2 = jSONObject.optInt("splash_layout_id", 1);
        long jOptLong = jSONObject.optLong("load_wait_time", 0L);
        long j11 = jOptLong >= 0 ? jOptLong : 0L;
        com.bytedance.sdk.openadsdk.core.model.We we2 = new com.bytedance.sdk.openadsdk.core.model.We();
        we2.sc(iOptInt);
        we2.pFF(iOptInt2);
        we2.sc(j11);
        return we2;
    }

    private static boolean We(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return (sfl.ymG() || sfl.Pu()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c  */
    private static int pFF(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        int iSc;
        String strZY = cJ.zY(sfl.Zn());
        if (sfl.Vb() == 0) {
            iSc = sc(sfl.otH());
            com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc);
        } else {
            iSc = 200;
        }
        int iQLv = sfl.QLv();
        if (iQLv == 2 || iQLv == 3) {
            if (We(sfl) && TextUtils.isEmpty(sfl.ko())) {
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, 406);
                iSc = 406;
            }
        } else if (iQLv == 4) {
            com.bytedance.sdk.openadsdk.core.model.zY zYVarNP = sfl.NP();
            if (zYVarNP == null) {
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, TTAdConstant.DOWNLOAD_APP_INFO_CODE);
                iSc = TTAdConstant.DOWNLOAD_APP_INFO_CODE;
            } else if (TextUtils.isEmpty(zYVarNP.zY()) && TextUtils.isEmpty(zYVarNP.sc())) {
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME);
                iSc = TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME;
            } else if (TextUtils.isEmpty(zYVarNP.zY())) {
                iSc = TTAdConstant.PACKAGE_NAME_CODE;
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, TTAdConstant.PACKAGE_NAME_CODE);
            } else if (TextUtils.isEmpty(zYVarNP.sc())) {
                iSc = TTAdConstant.DOWNLOAD_URL_CODE;
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, TTAdConstant.DOWNLOAD_URL_CODE);
            }
        } else if (iQLv == 8) {
            if (We(sfl)) {
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, 406);
                iSc = 406;
            }
        }
        if (iSc == 417 || iSc == 407 || iSc == 406) {
            return iSc;
        }
        if (iSc != 200) {
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, strZY, iSc);
        }
        return 200;
    }

    public static AdSlot pFF(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int iOptInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String strOptString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setNativeAdType(iOptInt5).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(strOptString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.wjp qr(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.wjp wjpVar = new com.bytedance.sdk.openadsdk.core.model.wjp();
        if (jSONObject == null) {
            wjpVar.sc(10L);
            wjpVar.pFF(20L);
            wjpVar.zY(10L);
            wjpVar.We(20L);
            wjpVar.sc("");
            return wjpVar;
        }
        wjpVar.sc(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        wjpVar.pFF(jSONObject.optLong("straight_lp_showtime", 20L));
        wjpVar.zY(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        wjpVar.We(jSONObject.optLong("straight_agg_showtime", 20L));
        wjpVar.sc(jSONObject.optString("loading_text", ""));
        return wjpVar;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    private static int sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        int iSc;
        int iSc2;
        if (sfl == null) {
            com.bytedance.sdk.openadsdk.We.zY.zY((com.bytedance.sdk.openadsdk.core.model.Sfl) null, "", 401);
            return 401;
        }
        String strZY = cJ.zY(sfl.Zn());
        if (TextUtils.isEmpty(sfl.kDg()) || sfl.kDg().length() <= 1) {
            com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, 402);
            return 402;
        }
        if (sfl.Pu()) {
            if (sfl.Zn() < 0) {
                if (sfl.Cb() != null) {
                    sfl.Cb().getDurationSlotType();
                } else {
                    sfl.qY();
                }
            }
            if (sfl.ixT()) {
                strZY = "fullscreen_interstitial_ad";
            }
            if (TextUtils.isEmpty(sfl.VZ())) {
                com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, strZY, "load_html_fail", (JSONObject) null);
                return 401;
            }
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, strZY, "load_html_success", (JSONObject) null);
        }
        if (sfl.Vb() == 0) {
            int iDix = sfl.dix();
            if (iDix == 2 || iDix == 3 || iDix == 4) {
                iSc = sc(sfl.ht());
                if (iSc != 200) {
                    com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc);
                    return iSc;
                }
            } else if (iDix == 5 || iDix == 15) {
                iSc2 = sc(sfl.GI(), sfl.ymG());
                if (iSc2 != 200) {
                    com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc2);
                    return iSc2;
                }
            } else if (iDix == 16) {
                iSc = sc(sfl.ht());
                if (iSc != 200) {
                    com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc);
                    return iSc;
                }
            } else if (iDix == 50) {
                iSc2 = sc(sfl.GI(), sfl.ymG());
                if (iSc2 != 200) {
                    com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc2);
                    return iSc2;
                }
            }
        }
        return com.bytedance.sdk.openadsdk.core.settings.dE.ef().ds() ? zY(sfl) : pFF(sfl);
    }

    private static int sc(com.bytedance.sdk.openadsdk.core.model.UFX ufx) {
        if (ufx == null) {
            return 200;
        }
        if (TextUtils.isEmpty(ufx.sc())) {
            return 403;
        }
        if (TextUtils.isEmpty(ufx.pFF())) {
            return 404;
        }
        return (ufx.zY() == 1 || ufx.zY() == 2) ? 200 : 405;
    }

    private static int sc(com.bytedance.sdk.openadsdk.core.model.zY zYVar) {
        if (zYVar == null) {
            return TTAdConstant.DOWNLOAD_APP_INFO_CODE;
        }
        if (TextUtils.isEmpty(zYVar.sc())) {
            return TTAdConstant.DOWNLOAD_URL_CODE;
        }
        if (TextUtils.isEmpty(zYVar.zY())) {
            return TTAdConstant.PACKAGE_NAME_CODE;
        }
        return 200;
    }

    private static int sc(List<com.bytedance.sdk.openadsdk.core.model.BT> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.model.BT bt2 : list) {
            if (bt2 == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(bt2.sc())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    private static int sc(a aVar, boolean z11) {
        if (aVar == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(aVar.q())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z11 || !TextUtils.isEmpty(aVar.r())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.Tf.sc, com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc> sc(String str, int i11, int i12) {
        int iZY;
        int iWe;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i12 == 1 || i12 == 5) {
            iZY = 0;
            iWe = 0;
        } else {
            iZY = kX.zY(Xc.sc());
            iWe = kX.We(Xc.sc());
            if (i11 == 2) {
                iWe = iZY;
                iZY = iWe;
            }
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc.sc.ExN exN = new com.bytedance.sdk.openadsdk.core.Tf.sc.sc.ExN(Xc.sc(), iZY, iWe);
        return new Pair<>(exN.sc(str, new ArrayList()), exN.TRI);
    }

    @Nullable
    public static Pair<com.bytedance.sdk.openadsdk.core.model.sc, ArrayList<Integer>> sc(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.sc scVar = new com.bytedance.sdk.openadsdk.core.model.sc();
            scVar.sc(jSONObject.optString(TrackingKey.REQUEST_ID));
            scVar.sc(jSONObject.optInt("ret"));
            int i11 = 0;
            scVar.pFF(jSONObject.optInt("multi_ad_style", 0));
            scVar.pFF(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("gdid_encrypted");
            if (jSONObject.has("choose_ui_data")) {
                scVar.pFF(jSONObject.optJSONObject("choose_ui_data"));
                scVar.sc(true);
            }
            String strOptString2 = jSONObject.optString("auction_price");
            if (scVar.zY() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList2 = scVar.Tf() ? new ArrayList() : null;
                for (int i12 = 0; i12 < jSONArrayOptJSONArray.length(); i12++) {
                    com.bytedance.sdk.openadsdk.core.model.Sfl sflSc = sc(jSONArrayOptJSONArray.optJSONObject(i12), adSlot, dl2);
                    if (sflSc != null && scVar.Tf()) {
                        if (sflSc.Xc() == 30) {
                            sflSc.Ol(true);
                        } else {
                            scVar.pFF(0);
                            arrayList2 = null;
                        }
                    }
                    int iSc = sc(sflSc);
                    if (iSc != 200) {
                        if (sflSc != null) {
                            com.bytedance.sdk.openadsdk.We.zY.pFF(sflSc, cJ.zY(sflSc.Zn()), iSc);
                        } else {
                            com.bytedance.sdk.openadsdk.We.zY.pFF((com.bytedance.sdk.openadsdk.core.model.Sfl) null, "", iSc);
                        }
                        arrayList.add(Integer.valueOf(iSc));
                        if (arrayList2 != null && sflSc != null) {
                            arrayList2.add(new sc(sflSc.Kh(), iSc));
                        }
                    } else {
                        sflSc.Ol(strOptString2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            sflSc.cvk(strOptString);
                        }
                        scVar.sc(sflSc);
                    }
                }
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    sc((ArrayList<sc>) arrayList2);
                }
                i11 = length;
            }
            sc(i11, scVar, (ArrayList<Integer>) arrayList, pff);
            return new Pair<>(scVar, arrayList);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdInfoFactory", th2.getMessage());
            return null;
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.model.Sfl sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return sc(jSONObject, (AdSlot) null, (com.bytedance.sdk.openadsdk.core.model.Dl) null);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x05c5 A[PHI: r14
  0x05c5: PHI (r14v83 int) = (r14v82 int), (r14v131 int) binds: [B:134:0x05b1, B:139:0x05c2] A[DONT_GENERATE, DONT_INLINE]] */
    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.Sfl sc(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2) {
        a aVarSc;
        a aVarSc2;
        int i11;
        com.bytedance.sdk.openadsdk.core.Tf.sc scVarSc;
        com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc scVar;
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.Sfl sflZY = com.bytedance.sdk.openadsdk.core.model.Sfl.zY();
        sflZY.Sfl(jSONObject.optInt("interaction_type"));
        sflZY.wjp(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.Sfl.We, 0));
        sflZY.YIK(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.Sfl.zY, 0));
        sflZY.Dl(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.Sfl.ExN, 0));
        sflZY.Ql(jSONObject.optString("target_url"));
        sflZY.wjp(jSONObject.optString("ad_id"));
        sflZY.Sfl(jSONObject.optString("app_log_url"));
        sflZY.UFX(jSONObject.optString("source"));
        sflZY.Tf(jSONObject.optString("app_name"));
        sflZY.WP(jSONObject.optInt("dislike_control", 0));
        sflZY.Ql(jSONObject.optInt("play_bar_show_time", AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES));
        sflZY.Dl(jSONObject.optString("gecko_id"));
        if (jSONObject.has("set_click_type")) {
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("set_click_type");
            sflZY.pFF(jSONObjectOptJSONObject2.optDouble("cta", 2.0d));
            sflZY.sc(jSONObjectOptJSONObject2.optDouble("other", 1.0d));
        }
        sflZY.ExN(jSONObject.optJSONObject("extension"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(RewardPlus.ICON);
        sflZY.We(jSONObject.optBoolean("screenshot", false));
        sflZY.UFX(jSONObject.optInt("play_bar_style", 0));
        sflZY.uEA(jSONObject.optString("market_url", ""));
        sflZY.Ol(jSONObject.optInt("video_adaptation", 0));
        sflZY.TRI(jSONObject.optInt("feed_video_opentype", 0));
        sflZY.zY(jSONObject.optJSONObject("session_params"));
        sflZY.Ol(jSONObject.optString("auction_price", ""));
        sflZY.Gb(jSONObject.optInt("mrc_report", 0));
        if (jSONObject.optBoolean("isMrcReportFinish", false)) {
            sflZY.pCa();
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject4 != null) {
            sflZY.qr(jSONObjectOptJSONObject4.optInt("render_sequence", 0));
            sflZY.Qj(jSONObjectOptJSONObject4.optInt("backup_render_control", 1));
            sflZY.cD(jSONObjectOptJSONObject4.optInt("reserve_time", 100));
            sflZY.Cb(jSONObjectOptJSONObject4.optInt("render_thread", 0));
        }
        sflZY.We(jSONObject.optInt("render_control", dl2 != null ? dl2.Qj : 1));
        if (jSONObjectOptJSONObject3 != null) {
            com.bytedance.sdk.openadsdk.core.model.BT bt2 = new com.bytedance.sdk.openadsdk.core.model.BT();
            bt2.sc(jSONObjectOptJSONObject3.optString("url"));
            bt2.pFF(jSONObjectOptJSONObject3.optInt("height"));
            bt2.sc(jSONObjectOptJSONObject3.optInt("width"));
            sflZY.sc(bt2);
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject5 != null) {
            sflZY.zY(jSONObjectOptJSONObject5.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT, 0));
            sflZY.qr(jSONObjectOptJSONObject5.optString(CampaignEx.JSON_KEY_REWARD_NAME, ""));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("cover_image");
        if (jSONObjectOptJSONObject6 != null) {
            com.bytedance.sdk.openadsdk.core.model.BT bt3 = new com.bytedance.sdk.openadsdk.core.model.BT();
            bt3.sc(jSONObjectOptJSONObject6.optString("url"));
            bt3.pFF(jSONObjectOptJSONObject6.optInt("height"));
            bt3.sc(jSONObjectOptJSONObject6.optInt("width"));
            sflZY.pFF(bt3);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("image");
        if (jSONArrayOptJSONArray != null) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray.length(); i12++) {
                com.bytedance.sdk.openadsdk.core.model.BT bt4 = new com.bytedance.sdk.openadsdk.core.model.BT();
                JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray.optJSONObject(i12);
                bt4.sc(jSONObjectOptJSONObject7.optString("url"));
                bt4.pFF(jSONObjectOptJSONObject7.optInt("height"));
                bt4.sc(jSONObjectOptJSONObject7.optInt("width"));
                bt4.sc(jSONObjectOptJSONObject7.optBoolean("image_preview"));
                bt4.pFF(jSONObjectOptJSONObject7.optString("image_key"));
                sflZY.zY(bt4);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("show_url");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i13 = 0; i13 < jSONArrayOptJSONArray2.length(); i13++) {
                sflZY.idT().add(jSONArrayOptJSONArray2.optString(i13));
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(CampaignEx.JSON_KEY_CLICK_URL);
        if (jSONArrayOptJSONArray3 != null) {
            for (int i14 = 0; i14 < jSONArrayOptJSONArray3.length(); i14++) {
                sflZY.fT().add(jSONArrayOptJSONArray3.optString(i14));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("play_start");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i15 = 0; i15 < jSONArrayOptJSONArray4.length(); i15++) {
                sflZY.Bs().add(jSONArrayOptJSONArray4.optString(i15));
            }
        }
        JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("click_area");
        if (jSONObjectOptJSONObject8 != null) {
            com.bytedance.sdk.openadsdk.core.model.Ol ol2 = new com.bytedance.sdk.openadsdk.core.model.Ol();
            ol2.f28395sc = jSONObjectOptJSONObject8.optBoolean("click_upper_content_area", true);
            ol2.pFF = jSONObjectOptJSONObject8.optBoolean("click_upper_non_content_area", true);
            ol2.zY = jSONObjectOptJSONObject8.optBoolean("click_lower_content_area", true);
            ol2.We = jSONObjectOptJSONObject8.optBoolean("click_lower_non_content_area", true);
            ol2.ExN = jSONObjectOptJSONObject8.optBoolean("click_button_area", true);
            ol2.TRI = jSONObjectOptJSONObject8.optBoolean("click_video_area", true);
            sflZY.sc(ol2);
        }
        JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("adslot");
        if (jSONObjectOptJSONObject9 != null) {
            sflZY.sc(pFF(jSONObjectOptJSONObject9));
        } else {
            sflZY.sc(adSlot);
        }
        if (adSlot != null) {
            Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
            if (requestExtraMap != null && requestExtraMap.containsKey("admob_watermark")) {
                sflZY.II(String.valueOf(requestExtraMap.get("admob_watermark")));
            }
        } else {
            sflZY.II(jSONObject.optString("identificationOverlayContent"));
        }
        sflZY.Tf(jSONObject.optInt("intercept_flag", 0));
        sflZY.SR(jSONObject.optString("phone_num"));
        sflZY.BT(jSONObject.optString(CampaignEx.JSON_KEY_TITLE));
        sflZY.dE(jSONObject.optString(TrackingKey.DESCRIPTION));
        sflZY.Xc(jSONObject.optString("button_text"));
        sflZY.WH(jSONObject.optInt("ad_logo", 1));
        sflZY.YIK(jSONObject.optString("ext"));
        sflZY.dE(jSONObject.optInt("cover_click_area", 0));
        sflZY.uEA(jSONObject.optInt("image_mode"));
        sflZY.FI(jSONObject.optInt("orientation", 1));
        sflZY.sc((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        sflZY.dE(jSONObject.optInt("cover_click_area", 0));
        JSONObject jSONObjectOptJSONObject10 = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
        sflZY.sc(com.bytedance.sdk.openadsdk.core.model.uEA.sc(jSONObject.optJSONObject("oem")));
        sflZY.sc(TRI(jSONObjectOptJSONObject10));
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("interaction_method_params");
        sflZY.sc(Ol(jSONObject.optJSONObject("arbitrage_interceptor_params")));
        sflZY.sc(qr(jSONObjectOptJSONObject12));
        sflZY.sc(Qj(jSONObjectOptJSONObject12));
        sflZY.sc(UFX(jSONObjectOptJSONObject11));
        sflZY.sc(new com.bytedance.sdk.openadsdk.core.model.JPJ(jSONObject));
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i16 = 0; i16 < jSONArrayOptJSONArray5.length(); i16++) {
                FilterWord filterWordExN = ExN(jSONArrayOptJSONArray5.optJSONObject(i16));
                if (filterWordExN != null && filterWordExN.isValid()) {
                    sflZY.sc(filterWordExN);
                }
            }
        }
        sflZY.JPJ(jSONObject.optInt("count_down"));
        sflZY.pFF(jSONObject.optLong("expiration_time"));
        sflZY.kX(jSONObject.optInt("video_encode_type", 0));
        sflZY.cJ(0);
        JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject13 != null) {
            aVarSc = sc(jSONObjectOptJSONObject13, sflZY, true);
            sflZY.pFF(aVarSc);
            sflZY.pc(jSONObjectOptJSONObject13.optInt("multi_played_percent", 50));
        } else {
            aVarSc = null;
        }
        JSONObject jSONObjectOptJSONObject14 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject14 != null) {
            aVarSc2 = sc(jSONObjectOptJSONObject14, sflZY, false);
            sflZY.zY(aVarSc2);
        } else {
            aVarSc2 = null;
        }
        if (Build.VERSION.SDK_INT < 26 || sflZY.EZl() == 0) {
            sflZY.sc(aVarSc);
            sflZY.kX(0);
        } else {
            if (aVarSc2 != null && aVarSc != null) {
                if (TextUtils.isEmpty(aVarSc2.p())) {
                    aVarSc2.v(aVarSc.p());
                }
                if (TextUtils.isEmpty(aVarSc2.j())) {
                    aVarSc2.e(aVarSc.j());
                }
                if (aVarSc2.t() == -1) {
                    aVarSc2.u(aVarSc.t());
                }
            }
            if (aVarSc2 != null) {
                sflZY.sc(aVarSc2);
            } else {
                sflZY.sc(aVarSc);
            }
        }
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("download_conf");
        if (jSONObjectOptJSONObject15 != null) {
            sflZY.sc(WH(jSONObjectOptJSONObject15));
        }
        sflZY.sc(Tf(jSONObject.optJSONObject("media_ext")));
        JSONObject jSONObjectOptJSONObject16 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject16 != null) {
            com.bytedance.sdk.openadsdk.core.model.Sfl.sc scVar2 = new com.bytedance.sdk.openadsdk.core.model.Sfl.sc();
            scVar2.zY(jSONObjectOptJSONObject16.optString("id"));
            scVar2.We(jSONObjectOptJSONObject16.optString("md5"));
            scVar2.ExN(jSONObjectOptJSONObject16.optString("url"));
            scVar2.TRI(jSONObjectOptJSONObject16.optString("data"));
            scVar2.qr(jSONObjectOptJSONObject16.optString("diff_data"));
            String strOptString = jSONObjectOptJSONObject16.optString("dynamic_creative");
            scVar2.Qj(strOptString);
            scVar2.pFF(jSONObjectOptJSONObject16.optString("version"));
            scVar2.Ol(jSONObjectOptJSONObject16.optString("media_view"));
            try {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject2 = new JSONObject(strOptString);
                JSONArray jSONArrayOptJSONArray6 = jSONObject2.optJSONArray("tag_ids");
                if (jSONArrayOptJSONArray6 != null) {
                    for (int i17 = 0; i17 < jSONArrayOptJSONArray6.length(); i17++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray6.optInt(i17)));
                    }
                }
                String strOptString2 = jSONObject2.optString("music_url");
                scVar2.sc(arrayList);
                scVar2.sc(strOptString2);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.AdInfoFactory", e11.getMessage());
            }
            scVar2.WH(jSONObjectOptJSONObject16.optString("engine_version"));
            scVar2.UFX(jSONObjectOptJSONObject16.optString("ugen_url"));
            scVar2.Tf(jSONObjectOptJSONObject16.optString("ugen_md5"));
            scVar2.Ql(jSONObjectOptJSONObject16.optString("ugen_data"));
            sflZY.sc(scVar2);
        }
        JSONObject jSONObjectOptJSONObject17 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject17 != null) {
            sflZY.sc(com.bytedance.sdk.openadsdk.core.model.cvk.sc(jSONObjectOptJSONObject17));
        }
        JSONObject jSONObjectOptJSONObject18 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject18 != null) {
            sflZY.pFF(jSONObjectOptJSONObject18);
        }
        sflZY.WH(jSONObject.optString("creative_extra"));
        sflZY.ExN(jSONObject.optInt("if_block_lp", 0));
        sflZY.SR(jSONObject.optInt("cache_sort", 1));
        sflZY.BT(jSONObject.optInt("if_sp_cache", 0));
        JSONObject jSONObjectOptJSONObject19 = jSONObject.optJSONObject("splash_control");
        if (jSONObjectOptJSONObject19 != null) {
            sflZY.sc(We(jSONObjectOptJSONObject19));
        }
        sflZY.cvk(jSONObject.optInt("is_package_open", 1));
        sflZY.Qj(jSONObject.optString("ad_info", null));
        sflZY.Xc(jSONObject.optInt("ua_policy", 2));
        sflZY.II(jSONObject.optInt("playable_duration_time", 20));
        sflZY.McK(jSONObject.optInt("playable_endcard_close_time", -1));
        sflZY.HJN(jSONObject.optInt("endcard_close_time", -1));
        sflZY.sc(jSONObject.optInt("interaction_method"));
        sflZY.JPJ(jSONObject.optString("dsp_html"));
        sflZY.GI(jSONObject.optInt("image_stay", 0));
        int iOptInt = jSONObject.optInt("dsp_material_type", 0);
        if (iOptInt < 0 || iOptInt > 3) {
            iOptInt = 0;
        }
        if (iOptInt == 0) {
            if (jSONObject.optBoolean("is_vast", false)) {
                iOptInt = 1;
            }
            i11 = jSONObject.optBoolean("is_html", false) ? 2 : iOptInt;
        }
        sflZY.JoC(i11);
        if (i11 == 1 || i11 == 3) {
            int iZn = sflZY.Zn();
            if (iZn < 0) {
                iZn = sflZY.Cb() != null ? sflZY.Cb().getDurationSlotType() : sflZY.qY();
            }
            String strZY = cJ.zY(iZn);
            if (jSONObject.has("vast_json")) {
                scVarSc = com.bytedance.sdk.openadsdk.core.Tf.sc.sc(jSONObject.optJSONObject("vast_json"));
            } else {
                String strOptString3 = jSONObject.optString("dsp_vast");
                if (TextUtils.isEmpty(strOptString3)) {
                    sc(sflZY, strZY);
                    return null;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Pair<com.bytedance.sdk.openadsdk.core.Tf.sc, com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc> pairSc = sc(strOptString3, sflZY.gx(), iZn);
                if (pairSc != null) {
                    com.bytedance.sdk.openadsdk.core.Tf.sc scVar3 = (com.bytedance.sdk.openadsdk.core.Tf.sc) pairSc.first;
                    scVar = (com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc) pairSc.second;
                    scVarSc = scVar3;
                } else {
                    scVarSc = null;
                    scVar = null;
                }
                sc(sflZY, strZY, scVarSc, jCurrentTimeMillis, scVar);
            }
            if (scVarSc != null) {
                scVarSc.TRI(strZY);
            }
            if (scVarSc == null) {
                return null;
            }
            sc(scVarSc, sflZY);
        }
        sflZY.FI(jSONObject.optString("deep_link_appname", ""));
        sflZY.BR(jSONObject.optInt("landing_page_download_clicktype", 1));
        JSONObject jSONObjectOptJSONObject20 = jSONObject.optJSONObject("dsp_style");
        if (jSONObjectOptJSONObject20 != null) {
            sflZY.sc(new com.bytedance.sdk.openadsdk.core.model.Ql(jSONObjectOptJSONObject20));
        }
        JSONObject jSONObjectOptJSONObject21 = jSONObject.optJSONObject("dsp_adchoices");
        if (jSONObjectOptJSONObject21 != null) {
            sflZY.ExN(jSONObjectOptJSONObject21.optString("adchoices_icon", ""));
            sflZY.TRI(jSONObjectOptJSONObject21.optString("adchoices_url", ""));
        }
        String strOptString4 = jSONObject.optString("gdid_encrypted");
        if (!TextUtils.isEmpty(strOptString4)) {
            sflZY.cvk(strOptString4);
        }
        int iOptInt2 = jSONObject.optInt("jump_probability", 0);
        if (iOptInt2 < 0 || iOptInt2 > 100) {
            iOptInt2 = 0;
        }
        sflZY.CYO(iOptInt2);
        sflZY.OvL();
        JSONObject jSONObjectOptJSONObject22 = jSONObject.optJSONObject("ugen");
        if (jSONObjectOptJSONObject22 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject22.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD)) != null) {
            sflZY.sc(zY(jSONObjectOptJSONObject));
            JSONObject jSONObjectOptJSONObject23 = jSONObjectOptJSONObject.optJSONObject("overlay");
            if (jSONObjectOptJSONObject23 != null) {
                sflZY.pFF(zY(jSONObjectOptJSONObject23));
            }
        }
        sflZY.qKn(jSONObject.optInt("preload_h5_type", 0));
        sflZY.Qj(jSONObject.optBoolean("hasReportShow", false));
        sflZY.McK(jSONObject.optString("endcard_creative", ""));
        JSONObject jSONObjectOptJSONObject24 = jSONObject.optJSONObject("ev");
        if (jSONObjectOptJSONObject24 != null) {
            sflZY.UFX(jSONObjectOptJSONObject24.optBoolean("enable", com.bytedance.sdk.openadsdk.JPJ.sc.zY.f27102sc));
            sflZY.MxZ(jSONObjectOptJSONObject24.optInt("wait_time", com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF));
            sflZY.HJN(jSONObjectOptJSONObject24.optString("label", com.bytedance.sdk.openadsdk.JPJ.sc.zY.zY));
            sflZY.sc(new com.bytedance.sdk.openadsdk.JPJ.sc.pFF(sflZY));
        }
        return sflZY;
    }

    @Nullable
    private static a sc(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, boolean z11) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.A(jSONObject.optInt("cover_height"));
        aVar.M(jSONObject.optInt("cover_width"));
        aVar.I(jSONObject.optString("resolution"));
        aVar.H(jSONObject.optLong("size"));
        double dOptDouble = jSONObject.optDouble("video_duration", 0.0d);
        aVar.F(dOptDouble);
        int i11 = 1;
        int iOptInt = jSONObject.optInt("replay_time", 1);
        if (dOptDouble <= 15.0d && sfl.JPJ() != 1 && com.bytedance.sdk.openadsdk.core.model.Sfl.ExN(sfl)) {
            i11 = iOptInt;
        }
        aVar.s(i11);
        aVar.B(jSONObject.optString("cover_url"));
        aVar.N(jSONObject.optString(CampaignEx.JSON_KEY_VIDEO_URL));
        aVar.v(jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD));
        aVar.e(jSONObject.optString("playable_download_url"));
        aVar.o(jSONObject.optString("file_hash"));
        aVar.i(jSONObject.optInt("if_playable_loading_show", 0));
        aVar.g(jSONObject.optInt("remove_loading_page_type", 0));
        aVar.G(jSONObject.optInt("fallback_endcard_judge", 0));
        aVar.d(jSONObject.optInt("video_preload_size", 307200));
        aVar.n(jSONObject.optInt("reward_video_cached_type", 0));
        aVar.D(jSONObject.optInt("execute_cached_type", 0));
        aVar.u(z11 ? jSONObject.optInt("endcard_render", 0) : jSONObject.optInt("endcard_render", -1));
        return aVar;
    }

    private static void sc(int i11, final com.bytedance.sdk.openadsdk.core.model.sc scVar, final ArrayList<Integer> arrayList, final com.bytedance.sdk.openadsdk.core.model.pFF pff) {
        if (scVar == null || i11 < 2 || !scVar.Qj()) {
            return;
        }
        final int size = i11 - (scVar.We() != null ? scVar.We().size() : 0);
        final boolean z11 = scVar.Ol() == null;
        if (size > 0 || z11) {
            com.bytedance.sdk.openadsdk.SR.zY.sc();
            com.bytedance.sdk.openadsdk.SR.zY.sc("choose_ad_parsing_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.pFF.1
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", scVar.pFF());
                    jSONObject.put("material_error", size);
                    jSONObject.put("choose_ui_error", z11 ? 1 : 0);
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) arrayList).toString());
                    }
                    com.bytedance.sdk.openadsdk.core.model.pFF pff2 = pff;
                    if (pff2 != null) {
                        jSONObject.put("server_res_str", pff2.sc());
                    }
                    return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("choose_ad_parsing_error").pFF(jSONObject.toString());
                }
            });
        }
    }

    private static void sc(com.bytedance.sdk.openadsdk.core.Tf.sc scVar, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        scVar.sc(sfl);
        if (!sc(sfl.QLv())) {
            sfl.Sfl(2);
        }
        sfl.We(1);
        sfl.sc(scVar);
        if (!TextUtils.isEmpty(scVar.We())) {
            sfl.BT(scVar.We());
        }
        if (!TextUtils.isEmpty(scVar.ExN())) {
            sfl.dE(scVar.ExN());
        }
        sfl.Ql(scVar.TRI());
        sfl.sc((com.bytedance.sdk.openadsdk.core.model.zY) null);
        a aVarGI = sfl.GI();
        if (aVarGI == null) {
            aVarGI = new a();
        }
        aVarGI.N(scVar.qr());
        aVarGI.F(scVar.Qj());
        aVarGI.o(null);
        aVarGI.B(null);
        aVarGI.v(null);
        sfl.sc(aVarGI);
        if (scVar.pFF() != null && !TextUtils.isEmpty(scVar.pFF().ExN())) {
            com.bytedance.sdk.openadsdk.core.model.BT bt2 = new com.bytedance.sdk.openadsdk.core.model.BT();
            bt2.sc(scVar.pFF().ExN());
            bt2.sc(scVar.pFF().pFF());
            bt2.pFF(scVar.pFF().zY());
            sfl.sc(bt2);
            return;
        }
        if (sfl.qfG() == null) {
            com.bytedance.sdk.openadsdk.core.model.BT bt3 = new com.bytedance.sdk.openadsdk.core.model.BT();
            bt3.sc("https://sf16-fe-tos-sg.i18n-pglstatp.com/obj/ad-pattern-sg/static/images/2023620white.jpeg");
            bt3.sc(98);
            bt3.pFF(98);
            sfl.sc(bt3);
        }
    }

    private static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put(TrackingKey.ERROR_CODE, -1);
            com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void sc(final com.bytedance.sdk.openadsdk.core.model.Sfl sfl, final String str, final com.bytedance.sdk.openadsdk.core.Tf.sc scVar, final long j11, final com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc scVar2) {
        com.bytedance.sdk.openadsdk.We.zY.sc(new com.bytedance.sdk.component.Qj.Qj("vast_parser") { // from class: com.bytedance.sdk.openadsdk.core.pFF.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    com.bytedance.sdk.openadsdk.core.Tf.sc scVar3 = scVar;
                    String str2 = "load_vast_fail";
                    if (scVar3 == null) {
                        jSONObject.put("reason_code", -2);
                        com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc scVar4 = scVar2;
                        if (scVar4 != null) {
                            jSONObject.put(TrackingKey.ERROR_CODE, scVar4.f28234sc);
                        }
                    } else if (TextUtils.isEmpty(scVar3.Ol()) || TextUtils.isEmpty(scVar.TRI()) || scVar.Qj() <= 0.0d) {
                        jSONObject.put("reason_code", -3);
                        jSONObject.put(TrackingKey.ERROR_CODE, -3);
                    } else {
                        jSONObject.put("duration", System.currentTimeMillis() - j11);
                        com.bytedance.sdk.openadsdk.core.Tf.sc.pFF.sc scVar5 = scVar2;
                        if (scVar5 != null) {
                            jSONObject.put("wrapper_count", scVar5.pFF);
                            jSONObject.put("impression_links_null", scVar2.zY);
                        }
                        str2 = "load_vast_success";
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.Tf.sc scVar6 = scVar;
                    if (scVar6 == null || scVar6.pFF() == null || !TextUtils.isEmpty(scVar.pFF().TRI())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(TrackingKey.ERROR_CODE, 1000);
                        jSONObject2.put(TrackingKey.DESCRIPTION, "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, str, "load_vast_icon_fail", jSONObject2);
                    scVar.sc((com.bytedance.sdk.openadsdk.core.Tf.pFF) null);
                } catch (Exception unused2) {
                }
            }
        });
    }

    private static void sc(final ArrayList<sc> arrayList) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.core.pFF.3
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            @Nullable
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                for (sc scVar : arrayList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(BidResponsedEx.KEY_CID, scVar.f28457sc);
                    jSONObject2.put("error_msg", scVar.pFF);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("multiple_ads_parsing_error").pFF(jSONObject.toString());
            }
        });
    }

    private static boolean sc(int i11) {
        return i11 == 2 || i11 == 3 || i11 == 8;
    }

    private static int zY(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        int iSc;
        String strZY = cJ.zY(sfl.Zn());
        if (sfl.Vb() == 0) {
            iSc = sc(sfl.otH());
            if (iSc != 200) {
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc);
                return iSc;
            }
        } else {
            iSc = 200;
        }
        int iQLv = sfl.QLv();
        if (iQLv != 2 && iQLv != 3) {
            if (iQLv == 4) {
                int iSc2 = sc(sfl.NP());
                if (iSc2 == 200) {
                    return iSc2;
                }
                com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, iSc2);
                return iSc2;
            }
            if (iQLv != 8) {
                return iSc;
            }
        }
        if (!We(sfl) || !TextUtils.isEmpty(sfl.ko())) {
            return iSc;
        }
        com.bytedance.sdk.openadsdk.We.zY.zY(sfl, strZY, 406);
        return 406;
    }

    private static com.bytedance.sdk.openadsdk.core.UFX.TRI.sc zY(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVar = new com.bytedance.sdk.openadsdk.core.UFX.TRI.sc();
        scVar.sc(jSONObject.optString("id"));
        scVar.pFF(jSONObject.optString("md5"));
        scVar.zY(jSONObject.optString("url"));
        return scVar;
    }
}

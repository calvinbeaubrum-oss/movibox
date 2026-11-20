package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.OXF;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.baselib.db.download.DownloadException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class YIK implements Sfl<com.bytedance.sdk.openadsdk.We.sc> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f28326sc;

    /* JADX INFO: compiled from: source.java */
    public static class pFF {
        public final boolean pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        public final int f28352sc;
        public final com.bytedance.sdk.openadsdk.core.model.II zY;

        private pFF(int i11, boolean z11, com.bytedance.sdk.openadsdk.core.model.II ii2) {
            this.f28352sc = i11;
            this.pFF = z11;
            this.zY = ii2;
        }

        public static pFF sc(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt(TrackingKey.CODE);
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.II ii2 = new com.bytedance.sdk.openadsdk.core.model.II();
            if (jSONObjectOptJSONObject != null) {
                try {
                    ii2.sc(jSONObjectOptJSONObject.optInt("reason"));
                    ii2.pFF(jSONObjectOptJSONObject.optInt("corp_type"));
                    ii2.zY(jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT));
                    ii2.sc(jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_REWARD_NAME));
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", th2.getMessage());
                }
            }
            return new pFF(iOptInt, zOptBoolean, ii2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        final String ExN;
        final String Ol;

        @Nullable
        public final com.bytedance.sdk.openadsdk.core.model.sc Qj;
        final int TRI;
        final ArrayList<Integer> WH;
        final int We;
        final long pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        final String f28353qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final int f28354sc;
        final long zY;

        private sc(String str, int i11, int i12, String str2, int i13, String str3, @Nullable com.bytedance.sdk.openadsdk.core.model.sc scVar, long j11, long j12, ArrayList<Integer> arrayList) {
            this.f28354sc = i11;
            this.We = i12;
            this.ExN = str2;
            this.f28353qr = str3;
            this.Qj = scVar;
            this.Ol = str;
            this.TRI = i13;
            this.pFF = j11;
            this.zY = j12;
            this.WH = arrayList;
        }

        public static sc sc(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString(TrackingKey.REQUEST_ID);
            int iOptInt3 = jSONObject.optInt("reason");
            if (adSlot == null || adSlot.getBiddingTokens() == null) {
                return new sc(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adn_bid_result");
            com.bytedance.sdk.openadsdk.core.model.sc scVar = new com.bytedance.sdk.openadsdk.core.model.sc();
            if (jSONArrayOptJSONArray != null) {
                int i11 = 0;
                while (i11 < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString4 = jSONObjectOptJSONObject.optString("name");
                        String strOptString5 = jSONObjectOptJSONObject.optString("render_data");
                        String strOptString6 = jSONObjectOptJSONObject.optString(BidResponsed.KEY_PRICE);
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("win_notice");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("loss_notice");
                        String strOptString7 = jSONObjectOptJSONObject.optString(BidResponsedEx.KEY_CID);
                        String strOptString8 = jSONObjectOptJSONObject.optString("crid");
                        JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("adomain");
                        String strOptString9 = jSONObjectOptJSONObject.optString("adn_response_id");
                        com.bytedance.sdk.openadsdk.core.model.Qj qj2 = new com.bytedance.sdk.openadsdk.core.model.Qj();
                        qj2.sc(strOptString4);
                        qj2.pFF(strOptString5);
                        qj2.zY(strOptString6);
                        qj2.We(strOptString7);
                        qj2.ExN(strOptString8);
                        qj2.TRI(strOptString9);
                        if (jSONArrayOptJSONArray4 != null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i12 = 0; i12 < jSONArrayOptJSONArray4.length(); i12++) {
                                arrayList.add(jSONArrayOptJSONArray4.optString(i12));
                            }
                            qj2.zY(arrayList);
                        }
                        if (jSONArrayOptJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            for (int i13 = 0; i13 < jSONArrayOptJSONArray2.length(); i13++) {
                                arrayList2.add(jSONArrayOptJSONArray2.optString(i13));
                            }
                            qj2.sc(arrayList2);
                        }
                        if (jSONArrayOptJSONArray3 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i14 = 0; i14 < jSONArrayOptJSONArray3.length(); i14++) {
                                arrayList3.add(jSONArrayOptJSONArray3.optString(i14));
                            }
                            qj2.pFF(arrayList3);
                        }
                        scVar.sc(qj2);
                    }
                    i11++;
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    strOptString3 = strOptString3;
                    jOptLong2 = jOptLong2;
                    jOptLong = jOptLong;
                    iOptInt3 = iOptInt3;
                }
            }
            return new sc(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, scVar, jOptLong, jOptLong2, null);
        }

        public static sc sc(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
            Object obj;
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString(TrackingKey.REQUEST_ID);
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.sc, ArrayList<Integer>> pairSc = com.bytedance.sdk.openadsdk.core.pFF.sc(jSONObject, adSlot, dl2, pff);
            if (pairSc != null && (obj = pairSc.first) != null) {
                ((com.bytedance.sdk.openadsdk.core.model.sc) obj).sc(jSONObject.optLong("request_after"));
            }
            return pairSc == null ? new sc(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null) : new sc(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.model.sc) pairSc.first, jOptLong, jOptLong2, (ArrayList) pairSc.second);
        }
    }

    public YIK(Context context) {
        this.f28326sc = context;
    }

    private boolean ExN(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private byte[] ExN(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes("utf-8"));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e11) {
                                com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e11.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e12) {
                            e = e12;
                            gZIPOutputStream = gZIPOutputStream2;
                            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e13) {
                                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e13.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e14) {
                                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e14.toString());
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                throw th;
                            }
                            byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException e15) {
                                com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e15.toString());
                                throw th;
                            }
                        }
                    } catch (IOException e16) {
                        e = e16;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e17) {
                com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e17.toString());
            }
        } catch (IOException e18) {
            e = e18;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
        return byteArray;
    }

    @DungeonFlag
    private void TRI(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", cJ.ExN());
            jSONObject.put("version_code", cJ.TRI());
            jSONObject.put("version", cJ.qr());
        } catch (Exception unused) {
        }
    }

    @NonNull
    private Map<String, String> We(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
        if (zY(jSONObject)) {
            map.put(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
        }
        return map;
    }

    private boolean We(String str) {
        if (com.bytedance.sdk.openadsdk.core.qr.pFF.sc()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.qr.pFF.sc(str)) {
            return false;
        }
        String strPFF = com.bytedance.sdk.openadsdk.core.qr.pFF.pFF();
        if (!TextUtils.isEmpty(strPFF)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(strPFF, System.currentTimeMillis());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String pFF(int i11, String str) {
        Object obj;
        if (i11 == 3) {
            return com.bytedance.sdk.component.utils.sc.zY(str);
        }
        if (i11 == 4) {
            Pair<Integer, String> pairDecryptType4 = PangleEncryptManager.decryptType4(str);
            if (pairDecryptType4 != null && (obj = pairDecryptType4.second) != null) {
                String str2 = (String) obj;
                uEA.sc(true);
                return str2;
            }
            uEA.sc(false);
            uEA.sc(2, PangleEncryptConstant.CryptDataScene.GET_ADS, pairDecryptType4 != null ? ((Integer) pairDecryptType4.first).intValue() : 0);
        }
        return null;
    }

    private static String pFF(AdSlot adSlot) {
        String strQl = Ol.pFF().Ql();
        if (adSlot == null) {
            return TextUtils.isEmpty(strQl) ? "" : strQl;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(strQl)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return strQl;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strQl);
                int length2 = jSONArray2.length();
                for (int i12 = 0; i12 < length2; i12++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i12);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return strQl;
        }
    }

    @NonNull
    private Map<String, String> pFF() {
        HashMap map = new HashMap();
        map.put(HttpHeaders.CONTENT_TYPE, "application/octet-stream;tt-data=a");
        return map;
    }

    public static JSONArray pFF(String str) {
        try {
            Set<String> setPFF = com.bytedance.sdk.component.adexpress.sc.pFF.pFF.pFF(str);
            if (setPFF != null && setPFF.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = setPFF.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.sc.zY.pFF pffSc = com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(it.next());
                    if (pffSc != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", pffSc.pFF());
                        jSONObject.put("md5", pffSc.zY());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "getParentTplIds: ", e11);
            return null;
        }
    }

    @DungeonFlag
    private JSONObject pFF(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("extra", str);
            jSONObject2.put("filter_words", sc(list));
            jSONObject2.put("dislike_source", str4);
            if (com.bytedance.sdk.openadsdk.core.settings.dE.ef().eo() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                jSONObject2.put("creative_info", com.bytedance.sdk.component.utils.sc.sc(new JSONObject(str2)).toString());
                jSONObject2.put("feedback_type", 1);
                jSONObject2.put("user_description", str3);
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.bytedance.sdk.openadsdk.core.YIK] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.Map] */
    public void pFF(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.Dl dl2, final int i11, final Sfl.sc scVar) {
        Object pff;
        com.bytedance.sdk.openadsdk.SR.sc.ExN exN;
        if (!Xc.We().Pu()) {
            scVar.sc(40060, Qj.sc(40060));
            return;
        }
        boolean zZY = com.bytedance.sdk.openadsdk.YIK.sc.zY();
        if (!zZY) {
            SR.TRI();
        }
        final com.bytedance.sdk.openadsdk.core.model.pFF pff2 = new com.bytedance.sdk.openadsdk.core.model.pFF();
        pff2.sc(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
            if (scVar != null) {
                scVar.sc(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
                pff2.sc(1000);
                com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
                return;
            }
            return;
        }
        if (!Xc.We().pc()) {
            if (scVar != null) {
                scVar.sc(-16, Qj.sc(-16));
                pff2.sc(1001);
                com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
                return;
            }
            return;
        }
        if (scVar == null) {
            return;
        }
        if (We(adSlot.getCodeId())) {
            scVar.sc(-8, Qj.sc(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !dl2.TRI) {
            pff2.pFF(2);
            pff2.sc(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.Tf.We()) {
                a.a(adSlot.getBidAdm());
            }
            if (Xc.We().yL() && II.sc().qr() == 1) {
                cJ.sc("Pangle_Debug_Mode", adSlot.getBidAdm(), this.f28326sc);
            }
            try {
                JSONObject jSONObjectSc = sc(new JSONObject(adSlot.getBidAdm()));
                if (jSONObjectSc == null) {
                    sc(scVar, pff2);
                    return;
                }
                sc scVarSc = sc.sc(jSONObjectSc, adSlot, dl2, pff2);
                pff2.sc(scVarSc.WH);
                Tf.sc(this.f28326sc, scVarSc.Ol);
                int i12 = scVarSc.We;
                if (i12 != 20000) {
                    scVar.sc(i12, scVarSc.ExN);
                    pff2.sc(scVarSc.We);
                    com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
                    return;
                }
                com.bytedance.sdk.openadsdk.core.model.sc scVar2 = scVarSc.Qj;
                if (scVar2 == null) {
                    sc(scVar, pff2);
                    return;
                }
                if (scVar2.We() != null && scVarSc.Qj.We().size() > 0) {
                    com.bytedance.sdk.openadsdk.SR.zY.sc(scVarSc.Qj.We().get(0));
                }
                scVarSc.Qj.zY(jSONObjectSc.toString());
                scVar.sc(scVarSc.Qj, pff2);
                Map<String, com.bytedance.sdk.openadsdk.core.model.Sfl> mapSc = com.bytedance.sdk.openadsdk.core.model.sc.sc(scVarSc.Qj);
                if (mapSc != null) {
                    com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(mapSc);
                }
                sc(scVarSc.Qj);
                com.bytedance.sdk.openadsdk.core.We.sc.sc().sc(scVarSc.Qj);
                return;
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "get ad error: ", th2);
                sc(scVar, pff2);
                return;
            }
        }
        JSONObject jSONObjectSc2 = sc(adSlot, dl2, i11);
        if (jSONObjectSc2 == null) {
            scVar.sc(-9, Qj.sc(-9));
            pff2.sc(-9);
            com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
            return;
        }
        if (Xc.We().yL() && II.sc().qr() == 1) {
            cJ.sc("Pangle_Debug_Mode", jSONObjectSc2.toString(), this.f28326sc);
        }
        String strSc = cJ.sc(adSlot.getBiddingTokens() != null ? "/api/ad/union/mediation/get_ads/" : "/api/ad/union/sdk/get_ads/", true);
        com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        final com.bytedance.sdk.openadsdk.SR.sc.ExN exN2 = new com.bytedance.sdk.openadsdk.SR.sc.ExN(2);
        try {
            String strSc2 = com.bytedance.sdk.openadsdk.Qj.We.sc(wePFF, strSc);
            wePFF.pFF(strSc2);
            exN2.sc(strSc2);
        } catch (Exception unused) {
        }
        wePFF.sc(jSONObjectSc2.toString(), Xc.We().Xc());
        exN2.sc(wePFF.We()).sc();
        Map<String, String> mapSc2 = com.bytedance.sdk.openadsdk.core.Ol.zY.sc(strSc, jSONObjectSc2.toString());
        if (mapSc2 != null && mapSc2.size() > 0) {
            for (String str : mapSc2.keySet()) {
                try {
                    wePFF.pFF(str, mapSc2.get(str));
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e11.getMessage());
                }
            }
        }
        try {
            wePFF.pFF("User-Agent", cJ.zY());
            sc(wePFF, jSONObjectSc2);
        } catch (Exception unused2) {
        }
        final OXF oxfPFF = OXF.pFF();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z11 = Ol.pFF().Xc() && requestExtraMap != null;
        if (z11) {
            requestExtraMap.put("pgad_start", oxfPFF);
        }
        if (adSlot.getBiddingTokens() != null) {
            sc(adSlot, dl2, wePFF, requestExtraMap, z11, oxfPFF, scVar);
            return;
        }
        wePFF.sc(10);
        wePFF.sc("get_ad");
        com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.8
            @Override // com.bytedance.sdk.openadsdk.dE.We
            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar3 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                scVar3.pFF("get_ad");
                scVar3.zY(adSlot.getCodeId());
                scVar3.We(cJ.zY(adSlot.getDurationSlotType()));
                return scVar3;
            }
        });
        if (com.bytedance.sdk.component.utils.Tf.We()) {
            Thread.currentThread().getName();
        }
        if (!zZY) {
            final boolean z12 = z11;
            wePFF.sc(new com.bytedance.sdk.component.qr.sc.pFF() { // from class: com.bytedance.sdk.openadsdk.core.YIK.9
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff3) {
                    YIK.this.sc(pff3, exN2, z12, requestExtraMap, oxfPFF, adSlot, pff2, scVar, dl2, i11);
                }

                @Override // com.bytedance.sdk.component.qr.sc.pFF
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException, com.bytedance.sdk.component.qr.pFF pff3) {
                    YIK.this.sc(iOException, pff3, adSlot, exN2, z12, requestExtraMap, scVar, pff2);
                }
            });
            return;
        }
        try {
            com.bytedance.sdk.component.qr.pFF pffSc = wePFF.sc();
            if (pffSc == null) {
                exN = null;
                pff = new com.bytedance.sdk.component.qr.pFF(false, 5001, "RequestBody is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L);
            }
            com.bytedance.sdk.component.qr.pFF pff3 = pffSc;
            try {
                if (pff3.TRI()) {
                    sc(pff3, exN2, z11, requestExtraMap, oxfPFF, adSlot, pff2, scVar, dl2, i11);
                } else {
                    sc(new IOException(pff3.pFF()), pff3, adSlot, exN2, z11, requestExtraMap, scVar, pff2);
                }
            } catch (Throwable th3) {
                th = th3;
                sc(new IOException(th.getMessage()), new com.bytedance.sdk.component.qr.pFF(false, 5002, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, exN, z11, pff, scVar, pff2);
            }
        } catch (Throwable th4) {
            th = th4;
            pff = requestExtraMap;
            exN = exN2;
        }
    }

    private JSONArray sc(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private static JSONObject sc(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (!com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc(cryptDataScene)) {
            return com.bytedance.sdk.component.utils.sc.sc(jSONObject);
        }
        JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject, new Dl(cryptDataScene));
        uEA.sc(jSONObjectEncryptType4);
        return jSONObjectEncryptType4;
    }

    public static JSONObject sc(AdSlot adSlot) {
        JPJ jpj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", Xc.We().GI());
            jSONObject.put("lmt", DeviceUtils.zY());
            jSONObject.put("coppa", Ol.pFF().WH());
            jSONObject.put("gdpr", Ol.pFF().Ol());
            jSONObject.put("is_gdpr_user", Xc.We().CYO());
            jSONObject.put("ccpa", Ol.pFF().YIK());
            if (adSlot != null && JPJ.f28025sc.containsKey(Integer.valueOf(adSlot.getCodeId())) && (jpj = JPJ.f28025sc.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", jpj.pFF());
                jSONObject.put("lastbundle", jpj.zY());
                jSONObject.put("lastclick", jpj.We());
                jSONObject.put("lastskip", jpj.ExN());
            }
            sc(jSONObject, "keywords", Ol.pFF().Tf());
            sc(jSONObject, "data", pFF(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject sc(AdSlot adSlot, int i11, com.bytedance.sdk.openadsdk.core.model.Dl dl2) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i11);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put("ad_id", adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put(CampaignEx.JSON_KEY_CREATIVE_ID, adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (dl2 != null) {
                jSONObject.put("render_method", dl2.Qj);
                int i12 = dl2.Qj;
                if (i12 == 1) {
                    sc(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (i12 == 2) {
                    sc(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                sc(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", pFF(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", zY(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", zY(adSlot.getCodeId() + "_v3"));
            jSONObject.put("pos", AdSlot.getPosition(i11));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i11 == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (dl2 != null && (obj = dl2.f28375qr) != null) {
                jSONObject.put("session_params", obj);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i11 == 7 || i11 == 8) {
                adCount = 1;
            }
            if (dl2 != null && dl2.ExN != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put(TrackingKey.AD_COUNT, adCount);
            if (i11 == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject.put("banner", jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @DungeonFlag
    private JSONObject sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Dl dl2, int i11) {
        int i12;
        int i13;
        int i14;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strWe = (dl2 == null || TextUtils.isEmpty(dl2.f28376sc)) ? cJ.We() : dl2.f28376sc;
            if (i11 == 7) {
                if (dl2 != null && (i14 = dl2.pFF) > 0) {
                    jSONObject2.put("req_type", i14);
                }
            } else if (i11 == 8) {
                if (dl2 != null && (i13 = dl2.zY) > 0) {
                    jSONObject2.put("req_type", i13);
                }
            } else if (i11 == 3 && dl2 != null && (i12 = dl2.We) > 0) {
                jSONObject2.put("req_type", i12);
            }
            try {
                String strWH = Xc.We().WH();
                String strYIK = Xc.We().YIK();
                if (strWH != null && strYIK != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strWH);
                    jSONObject3.put("param", strYIK);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            if (adSlot != null && adSlot.getBiddingTokens() != null) {
                jSONObject2.put("bidding_param", adSlot.getBiddingTokens());
                com.bytedance.sdk.openadsdk.core.settings.pFF pffII = com.bytedance.sdk.openadsdk.core.settings.dE.ef().II(adSlot.getCodeId());
                jSONObject2.put("waterfall_id", pffII.qKn);
                jSONObject2.put("waterfall_version", pffII.f28517pc);
                jSONObject2.put("link_id", adSlot.getLinkId());
            }
            jSONObject2.put(TrackingKey.REQUEST_ID, strWe);
            cJ.sc(jSONObject2);
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("rewardedfull_link", com.bytedance.sdk.openadsdk.core.settings.dE.ef().hE() ? 1 : 0);
            jSONObject2.put("js_render_ver", com.bytedance.sdk.openadsdk.core.Qj.Tf.pFF());
            jSONObject2.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.Qj.Tf.zY());
            jSONObject2.put("source_type", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, zY());
            jSONObject2.put("device", DeviceUtils.sc(this.f28326sc, true));
            jSONObject2.put("user", sc(adSlot));
            jSONObject2.put("ua", cJ.zY());
            jSONObject2.put("channel", "main");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(sc(adSlot, i11, dl2));
            jSONObject2.put("adslots", jSONArray);
            sc(jSONObject2, dl2);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (adSlot.getCodeId() != null && strWe != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strWe);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ExN.sc(strConcat));
            if (com.bytedance.sdk.openadsdk.core.Ol.zY.ExN() != 0) {
                jSONObject2.put("pglx", String.valueOf(com.bytedance.sdk.openadsdk.core.Ol.zY.ExN()));
            }
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc(jSONObject2);
            jSONObject = sc(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject2);
            if (jSONObject != null) {
                jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject.put("oversea_version_type", 1);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.utils.Dl.pFF("body data exception", th2);
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    private void sc(com.bytedance.sdk.component.pFF.sc.WH wh2, com.bytedance.sdk.openadsdk.core.model.Dl dl2, OXF oxf, OXF oxf2, int i11, OXF oxf3, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, boolean z11) {
        if (Xc.We().qfG()) {
            JSONObject jSONObject = new JSONObject();
            long jSc = 0;
            if (dl2 != null) {
                try {
                    OXF oxf4 = dl2.Ol;
                    if (oxf4.f28736sc > 0) {
                        jSc = oxf3.sc(oxf4);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            long j11 = jSc;
            sc(wh2, dl2, oxf, oxf2, i11, oxf3, sfl, str, z11, jSONObject, false);
            com.bytedance.sdk.openadsdk.We.zY.sc(sfl, str, "load_ad_time", j11, jSONObject);
        }
    }

    private static void sc(com.bytedance.sdk.component.pFF.sc.WH wh2, com.bytedance.sdk.openadsdk.core.model.Dl dl2, OXF oxf, OXF oxf2, int i11, OXF oxf3, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, String str, boolean z11, JSONObject jSONObject, boolean z12) throws JSONException {
        if (dl2 != null) {
            OXF oxf4 = dl2.Ol;
            if (oxf4.f28736sc > 0) {
                jSONObject.put("client_start_time", oxf.sc(oxf4));
            }
        }
        jSONObject.put("network_time", oxf2.sc(oxf));
        jSONObject.put("sever_time", i11);
        jSONObject.put("client_end_time", oxf3.sc(oxf2));
        if (z11) {
            jSONObject.put("is_choose_ad", true);
        }
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", sfl.LVf() ? 1 : 0);
        }
        if (sfl != null) {
            jSONObject.put("render_control_type", sfl.JPJ());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.ExN.ExN.sc().zY());
        jSONObject.put("sync_barrier_open", z12 ? 1 : 0);
        long j11 = wh2.pFF;
        if (j11 > 0) {
            jSONObject.put("enqueue_2_run_ts", wh2.zY - j11);
            jSONObject.put("run_2_connect_end_ts", wh2.ExN - wh2.pFF);
            jSONObject.put("connect_end_2_response_end_ts", wh2.TRI - wh2.ExN);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - wh2.TRI);
        }
    }

    private void sc(com.bytedance.sdk.component.qr.pFF.We we2, JSONObject jSONObject) {
        try {
            if (zY(jSONObject) && jSONObject.optInt("cypher") == 4) {
                we2.pFF("x-pgli18n", "4");
                we2.pFF(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void sc(com.bytedance.sdk.component.qr.pFF pff, com.bytedance.sdk.openadsdk.SR.sc.ExN exN, boolean z11, Map<String, Object> map, OXF oxf, final AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pFF pff2, Sfl.sc scVar, com.bytedance.sdk.openadsdk.core.model.Dl dl2, int i11) {
        com.bytedance.sdk.openadsdk.core.model.pFF pff3;
        OXF oxf2;
        boolean z12;
        com.bytedance.sdk.openadsdk.core.model.WP wp2;
        System.currentTimeMillis();
        exN.pFF();
        if (z11) {
            map.put("pgad_end", oxf);
        }
        if (pff == null) {
            return;
        }
        if (!pff.TRI()) {
            com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.12
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar2.pFF("get_ad");
                    scVar2.zY(adSlot.getCodeId());
                    scVar2.We(cJ.zY(adSlot.getDurationSlotType()));
                    scVar2.sc(BuildConfig.VERSION_NAME);
                    return scVar2;
                }
            });
            int iSc = pff.sc();
            String strPFF = pff.pFF();
            scVar.sc(iSc, strPFF);
            pff2.sc(iSc);
            com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
            com.bytedance.sdk.openadsdk.We.sc.TRI.Qj.incrementAndGet();
            com.bytedance.sdk.openadsdk.We.sc.TRI.zY.incrementAndGet();
            com.bytedance.sdk.openadsdk.We.sc.TRI.f27389sc.incrementAndGet();
            com.bytedance.sdk.openadsdk.We.sc.TRI.ExN();
            com.bytedance.sdk.openadsdk.We.sc.TRI.sc(iSc, strPFF);
            com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
            exN.sc(false).sc(iSc).We(strPFF).zY(pff.We());
            return;
        }
        com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.11
            @Override // com.bytedance.sdk.openadsdk.dE.We
            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                scVar2.pFF("get_ad");
                scVar2.zY(adSlot.getCodeId());
                scVar2.We(cJ.zY(adSlot.getDurationSlotType()));
                scVar2.sc(BuildConfig.VERSION_NAME);
                return scVar2;
            }
        });
        com.bytedance.sdk.openadsdk.We.sc.TRI.pFF.incrementAndGet();
        com.bytedance.sdk.openadsdk.We.sc.TRI.f27389sc.incrementAndGet();
        try {
            OXF oxfPFF = OXF.pFF();
            String strWe = pff.We();
            JSONObject jSONObject = new JSONObject(strWe);
            if (Xc.We().yL() && II.sc().qr() == 1) {
                cJ.sc("Pangle_Debug_Mode", jSONObject.toString(), this.f28326sc);
            }
            pff2.sc(strWe);
            JSONObject jSONObjectSc = sc(jSONObject);
            if (jSONObjectSc == null) {
                sc(scVar, pff2);
                com.bytedance.sdk.openadsdk.We.sc.TRI.TRI.incrementAndGet();
                com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
                exN.sc(true).sc(pff.sc()).zY(strWe);
                return;
            }
            sc scVarSc = sc.sc(jSONObjectSc, adSlot, dl2, pff2);
            pff2.sc(scVarSc.WH);
            Tf.sc(this.f28326sc, scVarSc.Ol);
            int i12 = scVarSc.We;
            if (i12 != 20000) {
                pff2.sc(i12);
                if (Xc.We().Gb() || scVarSc.We != 40029) {
                    scVar.sc(scVarSc.We, scVarSc.ExN);
                } else {
                    scVar.sc(-100, Qj.sc(-100));
                }
                com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
                com.bytedance.sdk.openadsdk.We.sc.TRI.TRI.incrementAndGet();
                com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
                exN.sc(true).sc(pff.sc()).zY(strWe);
                return;
            }
            com.bytedance.sdk.openadsdk.core.model.sc scVar2 = scVarSc.Qj;
            if (scVar2 == null) {
                sc(scVar, pff2);
                com.bytedance.sdk.openadsdk.We.sc.TRI.ExN.incrementAndGet();
                com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
                exN.sc(true).sc(pff.sc()).zY(strWe);
                return;
            }
            scVar2.zY(jSONObjectSc.toString());
            scVarSc.Qj.We(strWe);
            OXF oxfPFF2 = OXF.pFF();
            if (dl2 != null && (wp2 = dl2.WH) != null) {
                wp2.sc(oxf, oxfPFF, scVarSc.f28354sc, oxfPFF2);
            }
            boolean z13 = com.bytedance.sdk.openadsdk.YIK.sc.We() && i11 == 1;
            if (!z13 || scVarSc.Qj.We() == null || scVarSc.Qj.We().isEmpty()) {
                oxf2 = oxfPFF;
            } else {
                com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVarSc.Qj.We().get(0);
                String strZY = cJ.zY(i11);
                boolean zQj = scVarSc.Qj.Qj();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                long jSc = 0;
                if (dl2 != null) {
                    try {
                        OXF oxf3 = dl2.Ol;
                        oxf2 = oxfPFF;
                        try {
                            if (oxf3.f28736sc > 0) {
                                jSc = oxfPFF2.sc(oxf3);
                            }
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        oxf2 = oxfPFF;
                    }
                } else {
                    oxf2 = oxfPFF;
                }
                long j11 = jSc;
                if (sfl != null) {
                    boolean zCYO = sfl.CYO();
                    jSONObject3.put("is_new_engine", zCYO ? 1 : 0);
                    jSONObject3.put("webview_cache_size", zCYO ? com.bytedance.sdk.component.adexpress.ExN.ExN.sc().We() : com.bytedance.sdk.component.adexpress.ExN.ExN.sc().zY());
                }
                sc(pff.qr(), dl2, oxf, oxf2, scVarSc.f28354sc, oxfPFF2, sfl, strZY, zQj, jSONObject3, true);
                jSONObject2.put("duration", j11);
                jSONObject2.put("extra_data", jSONObject3);
                jSONObject2.put("tag", strZY);
                jSONObject2.put("callback_start", oxfPFF2.sc());
                scVarSc.Qj.sc(jSONObject2);
            }
            scVar.sc(scVarSc.Qj, pff2);
            sc(scVarSc.Qj);
            com.bytedance.sdk.openadsdk.core.We.sc.sc().sc(scVarSc.Qj);
            Map<String, com.bytedance.sdk.openadsdk.core.model.Sfl> mapSc = com.bytedance.sdk.openadsdk.core.model.sc.sc(scVarSc.Qj);
            if (mapSc != null) {
                com.bytedance.sdk.openadsdk.qr.pFF.sc().sc(mapSc);
            }
            if (scVarSc.Qj.We() == null || scVarSc.Qj.We().isEmpty()) {
                strWe = strWe;
                pff3 = pff2;
                z12 = true;
            } else {
                if (z13) {
                    pff3 = pff2;
                    z12 = true;
                } else {
                    z12 = true;
                    pff3 = pff2;
                    try {
                        sc(pff.qr(), dl2, oxf, oxf2, scVarSc.f28354sc, oxfPFF2, scVarSc.Qj.We().get(0), cJ.zY(i11), scVarSc.Qj.Qj());
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "get ad error: ", th);
                        sc(scVar, pff3);
                        com.bytedance.sdk.openadsdk.We.sc.TRI.ExN.incrementAndGet();
                        com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
                        exN.sc(pff.TRI()).sc(pff.sc()).zY(pff.We()).We(th.getMessage());
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.We.sc.TRI.We.incrementAndGet();
            }
            com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
            exN.sc(z12).sc(pff.sc()).zY(strWe);
        } catch (Throwable th3) {
            th = th3;
            pff3 = pff2;
        }
    }

    private void sc(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.Dl dl2, com.bytedance.sdk.component.qr.pFF.We we2, final Map<String, Object> map, final boolean z11, final OXF oxf, final Sfl.sc scVar) {
        we2.sc(new com.bytedance.sdk.component.qr.sc.pFF() { // from class: com.bytedance.sdk.openadsdk.core.YIK.13
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                if (z11) {
                    map.put("pgad_end", oxf);
                }
                if (pff == null || !pff.TRI()) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(pff.We());
                    if (Xc.We().yL() && II.sc().qr() == 1) {
                        cJ.sc("Pangle_Debug_Mode", jSONObject.toString(), YIK.this.f28326sc);
                    }
                    JSONObject jSONObjectSc = YIK.this.sc(jSONObject);
                    if (jSONObjectSc == null) {
                        scVar.sc(-1, Qj.sc(-1));
                        return;
                    }
                    sc scVarSc = sc.sc(jSONObjectSc, adSlot, dl2);
                    if (scVarSc.We != 20000) {
                        if (Xc.We().Gb() || scVarSc.We != 40029) {
                            scVar.sc(scVarSc.We, scVarSc.ExN);
                            return;
                        } else {
                            scVar.sc(-100, Qj.sc(-100));
                            return;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.model.sc scVar2 = scVarSc.Qj;
                    if (scVar2 == null) {
                        scVar.sc(-1, Qj.sc(-1));
                        return;
                    }
                    scVar2.zY(jSONObjectSc.toString());
                    scVar.sc(scVarSc.Qj, new com.bytedance.sdk.openadsdk.core.model.pFF());
                    YIK.this.sc(scVarSc.Qj);
                    com.bytedance.sdk.openadsdk.core.We.sc.sc().sc(scVarSc.Qj);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "get ad error: ", th2);
                    scVar.sc(-1, Qj.sc(-1));
                }
            }

            @Override // com.bytedance.sdk.component.qr.sc.pFF
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException, com.bytedance.sdk.component.qr.pFF pff) {
                OXF oxfPFF = OXF.pFF();
                if (z11) {
                    map.put("pgad_end", Long.valueOf(oxfPFF.f28736sc));
                }
                if (Xc.We().yL() && II.sc().qr() == 1) {
                    cJ.sc("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, YIK.this.f28326sc);
                }
                if (pff != null) {
                    scVar.sc(pff.sc(), pff.pFF());
                } else {
                    scVar.sc(PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY, iOException != null ? iOException.getMessage() : "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Sfl.pFF pff) {
        pff.sc(-1, Qj.sc(-1));
    }

    private void sc(Sfl.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff) {
        scVar.sc(-1, Qj.sc(-1));
        pff.sc(-1);
        com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff);
    }

    private void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.openadsdk.core.model.BT bt2) {
        if (bt2 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ol.We.sc(bt2).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, bt2.sc(), new com.bytedance.sdk.component.ExN.dE() { // from class: com.bytedance.sdk.openadsdk.core.YIK.14
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i11, String str, @Nullable Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(com.bytedance.sdk.component.ExN.UFX ufx) {
            }
        }), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        List<com.bytedance.sdk.openadsdk.core.model.Sfl> listWe = scVar.We();
        if (listWe == null || listWe.size() == 0) {
            return;
        }
        for (int i11 = 0; i11 < listWe.size(); i11++) {
            com.bytedance.sdk.openadsdk.core.model.Sfl sfl = listWe.get(i11);
            if (sfl != null && sfl.Tf() == null) {
                sc("", 0, 0, sfl.qfG(), sfl);
                sc("", 0, 0, sfl.OKY(), sfl);
                List<com.bytedance.sdk.openadsdk.core.model.BT> listHt = sfl.ht();
                if (listHt != null && listHt.size() > 0) {
                    for (int i12 = 0; i12 < listHt.size(); i12++) {
                        sc(sfl, listHt.get(i12));
                    }
                }
                if (sfl.GI() != null) {
                    sc(sfl.GI().r(), sfl.GI().L(), sfl.GI().z(), (com.bytedance.sdk.openadsdk.core.model.BT) null, sfl);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(IOException iOException, com.bytedance.sdk.component.qr.pFF pff, final AdSlot adSlot, com.bytedance.sdk.openadsdk.SR.sc.ExN exN, boolean z11, Map<String, Object> map, Sfl.sc scVar, com.bytedance.sdk.openadsdk.core.model.pFF pff2) {
        String message;
        int iSc;
        com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.10
            @Override // com.bytedance.sdk.openadsdk.dE.We
            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                scVar2.pFF("get_ad");
                scVar2.zY(adSlot.getCodeId());
                scVar2.We(cJ.zY(adSlot.getDurationSlotType()));
                scVar2.sc(BuildConfig.VERSION_NAME);
                return scVar2;
            }
        });
        exN.pFF();
        if (pff != null) {
            message = pff.pFF();
        } else {
            message = iOException != null ? iOException.getMessage() : "";
        }
        OXF oxfPFF = OXF.pFF();
        if (z11) {
            map.put("pgad_end", Long.valueOf(oxfPFF.f28736sc));
        }
        if (Xc.We().yL() && II.sc().qr() == 1) {
            cJ.sc("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.f28326sc);
        }
        if (pff != null) {
            iSc = pff.sc();
        } else {
            iSc = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_IS_EMPTY : PermissionScopeBridge.ERROR_CODE_SCOPE_NAME_NOT_FOUND;
        }
        if (scVar != null) {
            scVar.sc(iSc, message);
        }
        pff2.sc(iSc);
        com.bytedance.sdk.openadsdk.core.model.pFF.sc(pff2);
        com.bytedance.sdk.openadsdk.We.sc.TRI.zY.incrementAndGet();
        com.bytedance.sdk.openadsdk.We.sc.TRI.f27389sc.incrementAndGet();
        com.bytedance.sdk.openadsdk.We.sc.TRI.f27388qr.incrementAndGet();
        com.bytedance.sdk.openadsdk.We.sc.TRI.ExN();
        com.bytedance.sdk.openadsdk.We.sc.TRI.sc(iSc, message);
        com.bytedance.sdk.openadsdk.We.sc.TRI.zY();
        exN.We(message).sc(false);
    }

    private void sc(String str, int i11, int i12, com.bytedance.sdk.openadsdk.core.model.BT bt2, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.Ol.We.sc(str).sc(i11).pFF(i12).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, str, null), 4);
        } else {
            if (bt2 == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.Ol.We.sc(bt2).zY(2).sc(new com.bytedance.sdk.openadsdk.Ol.pFF(sfl, bt2.sc(), null), 4);
        }
    }

    private void sc(Map<String, String> map, com.bytedance.sdk.component.qr.pFF.We we2) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    we2.pFF(entry.getKey(), entry.getValue());
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "ADD header exceptopn", e11.getMessage());
                }
            }
        }
        try {
            we2.pFF("User-Agent", cJ.zY());
        } catch (Exception e12) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "ADD header exceptopn", e12.getMessage());
        }
    }

    private void sc(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.Dl dl2) {
        JSONArray jSONArray;
        if (dl2 == null || (jSONArray = dl2.ExN) == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", jSONArray);
        } catch (Exception unused) {
        }
    }

    private void sc(JSONObject jSONObject, String str, float f11, float f12) {
        if (f11 < 0.0f || f12 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f11);
            jSONObject2.put("height", (int) f12);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void sc(JSONObject jSONObject, String str, int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i11);
            jSONObject2.put("height", i12);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private static void sc(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private void sc(JSONObject jSONObject, boolean z11) throws Throwable {
        Object obj;
        if (Ol.pFF().Xc()) {
            try {
                jSONObject.getJSONObject("header").put("aid", "4562");
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "reportETEvent error", e11.getMessage());
            }
            com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
            wePFF.pFF(cJ.Ql());
            byte[] bArrEncryptV3 = null;
            if (z11) {
                com.bytedance.sdk.openadsdk.core.settings.TRI triEf = com.bytedance.sdk.openadsdk.core.settings.dE.ef();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean zSc = triEf.sc(cryptDataScene);
                byte[] bArrExN = ExN(jSONObject.toString());
                if (zSc) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrExN);
                    if (pairEncryptType4WithoutBase64 == null || (obj = pairEncryptType4WithoutBase64.second) == null || ((byte[]) obj).length <= 0) {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        uEA.pFF(false);
                        uEA.sc(1, cryptDataScene, iIntValue);
                    } else {
                        bArrEncryptV3 = (byte[]) obj;
                        uEA.pFF(true);
                    }
                }
                if (bArrEncryptV3 != null) {
                    wePFF.pFF(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    wePFF.pFF("x-pgli18n", "4");
                    wePFF.sc("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrExN);
                    if (bArrEncryptV3 != null) {
                        sc(pFF(), wePFF);
                        wePFF.sc("application/octet-stream;tt-data=a", bArrEncryptV3);
                    } else {
                        com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "V3 encrypt failed");
                    }
                }
            }
            if (bArrEncryptV3 == null) {
                JSONObject jSONObjectSc = com.bytedance.sdk.component.utils.sc.sc(jSONObject);
                if (zY(jSONObjectSc)) {
                    jSONObject = jSONObjectSc;
                }
                sc(We(jSONObject), wePFF);
                wePFF.sc(jSONObject.toString(), Xc.We().Xc());
            }
            wePFF.sc(7);
            wePFF.sc("et_applog");
            wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.YIK.15
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    if (pff == null || !pff.TRI()) {
                        return;
                    }
                    pff.We();
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    iOException.getMessage();
                }
            });
        }
    }

    public static JSONArray zY(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.UFX.sc.sc> setSc = com.bytedance.sdk.openadsdk.core.UFX.sc.pFF.sc().sc(str);
            if (setSc != null && setSc.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.UFX.sc.sc scVar : setSc) {
                    if (scVar != null && !TextUtils.isEmpty(scVar.ExN())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = scVar.sc().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", scVar.pFF());
                            jSONArray.put(jSONObject);
                        } else {
                            continue;
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "getUgenParentTplIds: ", e11);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x008b A[Catch: JSONException -> 0x00bb, TryCatch #0 {JSONException -> 0x00bb, blocks: (B:3:0x0005, B:9:0x0047, B:11:0x008b, B:23:0x00ad, B:8:0x0030, B:5:0x002a), top: B:26:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x009d  */
    /* JADX WARN: Code duplicated, block: B:15:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:17:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:21:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ac  */
    @DungeonFlag
    private JSONObject zY() {
        int i11;
        int rotation;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SafeStringUtils.SP_APPID, Ol.pFF().We());
            jSONObject.put("name", Ol.pFF().TRI());
            TRI(jSONObject);
            Context contextSc = Xc.sc();
            String packageResourcePath = "";
            if (contextSc != null) {
                try {
                    packageResourcePath = contextSc.getPackageResourcePath();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "failed to get the application installation package path. error: " + th2.getMessage());
                }
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", Ol.pFF().UFX());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.pFF.qr());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - SR.sc()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.Ol(this.f28326sc));
                i11 = 0;
                jSONObject.put("is_init", SR.ExN() ? 1 : 0);
                if (contextSc != null) {
                    rotation = ((WindowManager) contextSc.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i11 = 1;
                    } else if (rotation != 1) {
                        i11 = 3;
                    } else if (rotation != 2) {
                        i11 = 2;
                    } else if (rotation != 3) {
                        i11 = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i11));
                }
            } else {
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", Ol.pFF().UFX());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.pFF.qr());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - SR.sc()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.Ol(this.f28326sc));
                i11 = 0;
                jSONObject.put("is_init", SR.ExN() ? 1 : 0);
                if (contextSc != null) {
                    rotation = ((WindowManager) contextSc.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i11 = 1;
                    } else if (rotation != 1) {
                        i11 = 3;
                    } else if (rotation != 2) {
                        i11 = 2;
                    } else if (rotation != 3) {
                        i11 = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i11));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private boolean zY(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d3 A[Catch: all -> 0x00d8, TRY_LEAVE, TryCatch #1 {all -> 0x00d8, blocks: (B:35:0x00cd, B:37:0x00d3), top: B:69:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:56:0x0100  */
    /* JADX WARN: Code duplicated, block: B:57:0x0103  */
    /* JADX WARN: Code duplicated, block: B:61:0x010b  */
    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public com.bytedance.sdk.openadsdk.We.ExN pFF(JSONObject jSONObject) {
        boolean z11;
        boolean z12;
        int iSc;
        boolean z13;
        String strWe;
        int i11;
        String strPFF = "error unknown";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.Tf.sc() || !Xc.We().Pu() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.openadsdk.SR.sc.ExN exN = new com.bytedance.sdk.openadsdk.SR.sc.ExN(4);
        JSONObject jSONObjectSc = sc(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
        com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        boolean z14 = false;
        try {
            wePFF.sc(jSONObjectSc.toString(), Xc.We().Xc());
            String strWe2 = cJ.We("/api/ad/union/sdk/stats/batch/");
            exN.sc(strWe2).sc(wePFF.We()).sc();
            wePFF.pFF(strWe2);
            sc(wePFF, jSONObjectSc);
            wePFF.pFF("User-Agent", cJ.zY());
            if (com.bytedance.sdk.openadsdk.core.settings.dE.ef().mD()) {
                wePFF.pFF("_disable_retry", "1");
            }
            com.bytedance.sdk.component.qr.pFF pffSc = wePFF.sc();
            try {
                if (pffSc == null) {
                    return new com.bytedance.sdk.openadsdk.We.ExN(false, 0, "error unknown", false);
                }
                try {
                    try {
                        if (pffSc.TRI() && !TextUtils.isEmpty(pffSc.We())) {
                            JSONObject jSONObject2 = new JSONObject(pffSc.We());
                            int iOptInt = jSONObject2.optInt(TrackingKey.CODE, -1);
                            strPFF = jSONObject2.optString("data", "");
                            z11 = iOptInt == 20000;
                            z12 = iOptInt == 60005;
                            iSc = pffSc.sc();
                            if (!pffSc.TRI()) {
                                strPFF = pffSc.pFF();
                            }
                            if (pffSc == null) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (!z13 && pffSc.TRI()) {
                                z14 = true;
                            }
                            com.bytedance.sdk.openadsdk.SR.sc.ExN exNSc = exN.sc(z14);
                            if (z13) {
                                strWe = null;
                            } else {
                                strWe = pffSc.We();
                            }
                            com.bytedance.sdk.openadsdk.SR.sc.ExN exNZY = exNSc.zY(strWe);
                            if (z13) {
                                i11 = com.bytedance.sdk.openadsdk.SR.sc.ExN.f27115sc;
                            } else {
                                i11 = iSc;
                            }
                            exNZY.sc(i11).We(z13 ? null : pffSc.pFF());
                            com.bytedance.sdk.openadsdk.We.sc.sc.sc(com.bytedance.sdk.openadsdk.We.sc.sc.pFF, z11, iSc, System.currentTimeMillis() - jCurrentTimeMillis);
                            return new com.bytedance.sdk.openadsdk.We.ExN(z11, iSc, strPFF, z12);
                        }
                        z11 = false;
                        if (!pffSc.TRI()) {
                            strPFF = pffSc.pFF();
                        }
                    } catch (Throwable unused) {
                    }
                    iSc = pffSc.sc();
                } catch (Throwable unused2) {
                    iSc = 0;
                }
                if (pffSc == null) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    z14 = true;
                }
                com.bytedance.sdk.openadsdk.SR.sc.ExN exNSc2 = exN.sc(z14);
                if (z13) {
                    strWe = null;
                } else {
                    strWe = pffSc.We();
                }
                com.bytedance.sdk.openadsdk.SR.sc.ExN exNZY2 = exNSc2.zY(strWe);
                if (z13) {
                    i11 = com.bytedance.sdk.openadsdk.SR.sc.ExN.f27115sc;
                } else {
                    i11 = iSc;
                }
                exNZY2.sc(i11).We(z13 ? null : pffSc.pFF());
                com.bytedance.sdk.openadsdk.We.sc.sc.sc(com.bytedance.sdk.openadsdk.We.sc.sc.pFF, z11, iSc, System.currentTimeMillis() - jCurrentTimeMillis);
                return new com.bytedance.sdk.openadsdk.We.ExN(z11, iSc, strPFF, z12);
            } catch (Throwable unused3) {
                z11 = false;
                z12 = false;
            }
        } catch (Throwable unused4) {
            com.bytedance.sdk.openadsdk.We.sc.sc.sc(com.bytedance.sdk.openadsdk.We.sc.sc.pFF, false, 0, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.We.ExN(false, 0, "error unknown", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public com.bytedance.sdk.component.adexpress.sc.zY.sc sc() {
        com.bytedance.sdk.component.adexpress.sc.zY.sc scVarWe = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.We.We.sc("tpl_fetch_model", "date", 0L);
        String strBR = Xc.We().BR();
        String strPFF = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tpl_fetch_model", "last_url", "");
        if (jCurrentTimeMillis <= Xc.We().McK() && jCurrentTimeMillis >= 0 && TextUtils.equals(strBR, strPFF)) {
            String strPFF2 = com.bytedance.sdk.openadsdk.multipro.We.We.pFF("tpl_fetch_model", "model", "");
            try {
                if (!TextUtils.isEmpty(strPFF2)) {
                    return com.bytedance.sdk.component.adexpress.sc.zY.sc.We(strPFF2);
                }
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
        try {
            pffZY.pFF(com.bytedance.sdk.openadsdk.Qj.We.sc(pffZY, strBR));
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e11.getMessage());
        }
        com.bytedance.sdk.component.qr.pFF pffSc = pffZY.sc();
        if (pffSc == null) {
            return null;
        }
        try {
            if (!pffSc.TRI()) {
                return null;
            }
            String strWe = pffSc.We();
            scVarWe = com.bytedance.sdk.component.adexpress.sc.zY.sc.We(strWe);
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tpl_fetch_model", "model", strWe);
            com.bytedance.sdk.openadsdk.multipro.We.We.sc("tpl_fetch_model", "last_url", strBR);
            return scVarWe;
        } catch (Exception unused2) {
            return scVarWe;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.We.ExN sc(JSONObject jSONObject, String str, boolean z11) {
        byte[] bArrEncryptV3;
        boolean z12;
        Object obj;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strPFF = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
                return null;
            }
            com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
            wePFF.pFF(str);
            if (com.bytedance.sdk.openadsdk.core.settings.dE.ef().otH()) {
                wePFF.pFF("_disable_retry", "1");
            }
            boolean z13 = true;
            if (z11) {
                com.bytedance.sdk.openadsdk.core.settings.TRI triEf = com.bytedance.sdk.openadsdk.core.settings.dE.ef();
                PangleEncryptConstant.CryptDataScene cryptDataScene = PangleEncryptConstant.CryptDataScene.APP_LOG;
                boolean zSc = triEf.sc(cryptDataScene);
                byte[] bArrExN = ExN(jSONObject.toString());
                if (zSc) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrExN);
                    if (pairEncryptType4WithoutBase64 == null || (obj = pairEncryptType4WithoutBase64.second) == null || ((byte[]) obj).length <= 0) {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        uEA.pFF(false);
                        uEA.sc(1, cryptDataScene, iIntValue);
                        bArrEncryptV3 = null;
                    } else {
                        bArrEncryptV3 = (byte[]) obj;
                        uEA.pFF(true);
                    }
                } else {
                    bArrEncryptV3 = null;
                }
                if (bArrEncryptV3 != null) {
                    wePFF.pFF(HttpHeaders.CONTENT_ENCODING, "union_sdk_encode");
                    wePFF.pFF("x-pgli18n", "4");
                    wePFF.sc("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrExN);
                    if (bArrEncryptV3 != null) {
                        sc(pFF(), wePFF);
                        wePFF.sc("application/octet-stream;tt-data=a", bArrEncryptV3);
                    } else {
                        com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "V3 encrypt failed");
                    }
                }
            } else {
                bArrEncryptV3 = null;
            }
            if (bArrEncryptV3 == null) {
                try {
                    JSONObject jSONObjectSc = com.bytedance.sdk.component.utils.sc.sc(jSONObject);
                    if (!zY(jSONObjectSc)) {
                        jSONObjectSc = jSONObject;
                    }
                    sc(We(jSONObjectSc), wePFF);
                    wePFF.sc(jSONObjectSc.toString(), Xc.We().Xc());
                } catch (OutOfMemoryError e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e11.toString());
                    return new com.bytedance.sdk.openadsdk.We.ExN(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.openadsdk.SR.sc.ExN exN = new com.bytedance.sdk.openadsdk.SR.sc.ExN(3);
            exN.sc(str).sc(wePFF.We()).sc();
            com.bytedance.sdk.component.qr.pFF pffSc = wePFF.sc();
            boolean zExN = (pffSc == null || !pffSc.TRI() || TextUtils.isEmpty(pffSc.We())) ? false : ExN(new JSONObject(pffSc.We()));
            String strPFF2 = "error unknown";
            int iSc = pffSc != null ? pffSc.sc() : 0;
            if (zExN || iSc != 200) {
                if (pffSc != null && pffSc.pFF() != null) {
                    strPFF2 = pffSc.pFF();
                }
                z12 = false;
            } else {
                strPFF2 = "server say not success";
                z12 = true;
            }
            boolean z14 = pffSc == null;
            if (z14 || !pffSc.TRI()) {
                z13 = false;
            }
            com.bytedance.sdk.openadsdk.SR.sc.ExN exNSc = exN.sc(z13).zY(z14 ? null : pffSc.We()).sc(z14 ? com.bytedance.sdk.openadsdk.SR.sc.ExN.f27115sc : iSc);
            if (!z14) {
                strPFF = pffSc.pFF();
            }
            exNSc.We(strPFF);
            sc(jSONObject, z11);
            com.bytedance.sdk.openadsdk.We.sc.sc.sc(com.bytedance.sdk.openadsdk.We.sc.sc.f27411sc, zExN, iSc, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.We.ExN(zExN, iSc, strPFF2, z12);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", "uploadEvent error", th2);
            return new com.bytedance.sdk.openadsdk.We.ExN(false, DownloadException.EXCEPTION_IO_HTTP_RETRY, "service_busy", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public JSONObject sc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            String strOptString2 = jSONObject.optString("auction_price", "");
            String strPFF = pFF(iOptInt, strOptString);
            if (TextUtils.isEmpty(strPFF)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strPFF);
            try {
                jSONObject2.put("auction_price", strOptString2);
            } catch (Throwable unused) {
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public void sc(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.Dl dl2, final int i11, Sfl.sc scVar) {
        final com.bytedance.sdk.openadsdk.core.sc.sc scVar2 = new com.bytedance.sdk.openadsdk.core.sc.sc(scVar, adSlot);
        if (dl2 != null && (dl2.pFF == 2 || dl2.zY == 2 || dl2.We == 2)) {
            adSlot.setPreload(true);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            SR.pFF().post(new com.bytedance.sdk.component.Qj.Qj("getAd") { // from class: com.bytedance.sdk.openadsdk.core.YIK.1
                @Override // java.lang.Runnable
                public void run() {
                    YIK.this.pFF(adSlot, dl2, i11, scVar2);
                }
            });
        } else {
            pFF(adSlot, dl2, i11, scVar2);
        }
        if (com.bytedance.sdk.openadsdk.YIK.sc.zY()) {
            SR.qr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public void sc(String str) {
        com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
        pffZY.pFF(str);
        pffZY.sc("upload_bidding");
        pffZY.sc(7);
        pffZY.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.YIK.6
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                pff.We();
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public void sc(@NonNull String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObjectPFF;
        if (com.bytedance.sdk.openadsdk.core.settings.Tf.sc() && (jSONObjectPFF = pFF(str, list, str2, str3, str4)) != null) {
            com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
            String strWe = cJ.We("/api/ad/union/dislike_event/");
            JSONObject jSONObjectSc = sc(PangleEncryptConstant.CryptDataScene.DISLIKE, jSONObjectPFF);
            String string = jSONObjectSc != null ? jSONObjectSc.toString() : null;
            sc(wePFF, jSONObjectSc);
            wePFF.pFF(strWe);
            wePFF.We(string);
            final com.bytedance.sdk.openadsdk.SR.sc.ExN exN = new com.bytedance.sdk.openadsdk.SR.sc.ExN(6);
            exN.sc(strWe).pFF(string).sc();
            wePFF.sc(7);
            wePFF.sc("dislike");
            com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.2
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar.pFF("dislike");
                    return scVar;
                }
            });
            wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.YIK.3
                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                    if (pff == null) {
                        exN.sc(false).sc(com.bytedance.sdk.openadsdk.SR.sc.ExN.f27115sc);
                        com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.3.3
                            @Override // com.bytedance.sdk.openadsdk.dE.We
                            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                scVar.pFF("dislike");
                                return scVar;
                            }
                        });
                        return;
                    }
                    boolean zTRI = pff.TRI();
                    exN.sc(zTRI).sc(pff.sc()).We(pff.pFF()).zY(pff.We());
                    if (zTRI) {
                        com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.3.1
                            @Override // com.bytedance.sdk.openadsdk.dE.We
                            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                scVar.pFF("dislike");
                                return scVar;
                            }
                        });
                    } else {
                        com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.3.2
                            @Override // com.bytedance.sdk.openadsdk.dE.We
                            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                scVar.pFF("dislike");
                                return scVar;
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.component.qr.sc.sc
                public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                    exN.sc(false).We(iOException != null ? iOException.getMessage() : null);
                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.3.4
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("dislike");
                            return scVar;
                        }
                    });
                }
            });
            try {
                String strOptString = new JSONObject(str).optString(BidResponsedEx.KEY_CID, "");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("dislike", strOptString, (String) null, (String) null);
            } catch (JSONException e11) {
                com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public void sc(JSONObject jSONObject, final Sfl.pFF pff) {
        if (!com.bytedance.sdk.openadsdk.core.settings.Tf.sc()) {
            if (pff != null) {
                pff.sc(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
                return;
            }
            return;
        }
        if (jSONObject == null || pff == null) {
            return;
        }
        JSONObject jSONObjectSc = sc(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
        final com.bytedance.sdk.openadsdk.SR.sc.ExN exN = new com.bytedance.sdk.openadsdk.SR.sc.ExN(5);
        com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        try {
            String strSc = com.bytedance.sdk.openadsdk.Qj.We.sc(wePFF, cJ.We("/api/ad/union/sdk/reward_video/reward/"));
            wePFF.pFF(strSc);
            exN.sc(strSc);
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e11.getMessage());
        }
        sc(wePFF, jSONObjectSc);
        wePFF.We(jSONObjectSc != null ? jSONObjectSc.toString() : "");
        exN.sc(wePFF.We()).sc();
        wePFF.sc(10);
        wePFF.sc("reward");
        com.bytedance.sdk.openadsdk.dE.zY.sc(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.4
            @Override // com.bytedance.sdk.openadsdk.dE.We
            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                scVar.pFF("reward");
                return scVar;
            }
        });
        wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.YIK.5
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff2) {
                if (pff2 == null) {
                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.5.3
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("reward");
                            return scVar;
                        }
                    });
                    exN.sc(false).sc(com.bytedance.sdk.openadsdk.SR.sc.ExN.f27115sc);
                    YIK.this.sc(pff);
                    return;
                }
                if (!pff2.TRI() || TextUtils.isEmpty(pff2.We())) {
                    exN.sc(pff2.TRI()).zY(pff2.We()).sc(pff2.sc()).We(pff2.pFF());
                    String strSc2 = Qj.sc(-2);
                    int iSc = pff2.sc();
                    if (!pff2.TRI() && !TextUtils.isEmpty(pff2.pFF())) {
                        strSc2 = pff2.pFF();
                    }
                    pff.sc(iSc, strSc2);
                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.5.2
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("reward");
                            return scVar;
                        }
                    });
                    return;
                }
                exN.sc(true).sc(pff2.sc()).zY(pff2.We());
                try {
                    JSONObject jSONObject2 = new JSONObject(pff2.We());
                    String strPFF = YIK.pFF(jSONObject2.optInt("cypher", -1), jSONObject2.optString("message"));
                    if (!TextUtils.isEmpty(strPFF)) {
                        try {
                            jSONObject2 = new JSONObject(strPFF);
                        } catch (Throwable unused) {
                        }
                    }
                    pFF pffSc = pFF.sc(jSONObject2);
                    int i11 = pffSc.f28352sc;
                    if (i11 != 20000) {
                        pff.sc(i11, Qj.sc(i11));
                    } else if (pffSc.zY == null) {
                        YIK.this.sc(pff);
                    } else {
                        pff.sc(pffSc);
                        com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.5.1
                            @Override // com.bytedance.sdk.openadsdk.dE.We
                            public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                                com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                                scVar.pFF("reward");
                                return scVar;
                            }
                        });
                    }
                } catch (JSONException e12) {
                    com.bytedance.sdk.component.utils.Tf.sc("NetApiImpl", e12.getMessage());
                    YIK.this.sc(pff);
                }
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
                String message = iOException != null ? iOException.getMessage() : "";
                exN.sc(false).We(message);
                pff.sc(-2, message);
                com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.core.YIK.5.4
                    @Override // com.bytedance.sdk.openadsdk.dE.We
                    public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                        com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                        scVar.pFF("reward");
                        return scVar;
                    }
                });
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.Sfl
    public void sc(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.qr.pFF.We wePFF = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().pFF();
        wePFF.pFF(str);
        wePFF.sc(jSONObject);
        wePFF.sc(5);
        wePFF.sc("apm_pv");
        wePFF.sc(new com.bytedance.sdk.component.qr.sc.sc() { // from class: com.bytedance.sdk.openadsdk.core.YIK.7
            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, com.bytedance.sdk.component.qr.pFF pff) {
                pff.We();
            }

            @Override // com.bytedance.sdk.component.qr.sc.sc
            public void sc(com.bytedance.sdk.component.qr.pFF.zY zYVar, IOException iOException) {
            }
        });
    }
}

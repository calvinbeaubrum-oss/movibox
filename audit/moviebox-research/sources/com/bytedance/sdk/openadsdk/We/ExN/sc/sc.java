package com.bytedance.sdk.openadsdk.We.ExN.sc;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.ExN;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.Ol;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.Qj;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.Ql;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.SR;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.TRI;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.WH;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.pFF;
import com.bytedance.sdk.openadsdk.We.qr;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import u8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<a, BT> f27320sc = Collections.synchronizedMap(new WeakHashMap());

    public static void ExN(a aVar, BT.sc scVar) {
        BT bt2;
        if (aVar == null || scVar == null || scVar.Ol() <= 0 || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jZY = scVar.zY();
        Ql ql2 = new Ql();
        ql2.sc(scVar.pFF());
        ql2.pFF(jZY);
        ql2.sc(scVar.Ol());
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, ql2);
        scVar2.sc(scVar.WH());
        sc(scVar2, "play_buffer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String We(zY zYVar) {
        return new File(zYVar.pFF(), zYVar.SR()).getAbsolutePath();
    }

    public static void We(a aVar, BT.sc scVar) {
        BT bt2;
        if (aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        pFF pff = new pFF();
        pff.sc(scVar.pFF());
        pff.pFF(jZY);
        pff.sc(scVar.We());
        pff.pFF(scVar.ExN());
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe), pff);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "endcard_skip", jSONObject);
        } catch (JSONException e11) {
            Tf.sc("TTAD.VideoEventManager", "", e11);
        }
    }

    public static void pFF(com.bytedance.sdk.openadsdk.We.ExN.pFF.sc<Ol> scVar) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("load_video_cancel", scVar);
    }

    public static void pFF(a aVar, BT.sc scVar) {
        BT bt2;
        if (aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        if (jZY <= 0 || jSc <= 0) {
            return;
        }
        ExN exN = new ExN();
        exN.sc(scVar.pFF());
        exN.pFF(jZY);
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, exN);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "feed_continue", jSONObject);
        } catch (JSONException e12) {
            Tf.sc("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void pFF(a aVar, BT.sc scVar, qr qrVar) {
        if (aVar == null || scVar == null) {
            return;
        }
        ExN(aVar, scVar);
        BT bt2 = f27320sc.get(aVar);
        if (bt2 == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        TRI tri = new TRI();
        tri.pFF(scVar.pFF());
        tri.sc(jZY);
        tri.sc(scVar.Qj());
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, tri);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "feed_over", jSONObject, qrVar);
        } catch (JSONException e12) {
            Tf.sc("TTAD.VideoEventManager", "", e12);
        }
        f27320sc.remove(aVar);
    }

    public static JSONObject sc(Sfl sfl, String str, int i11, zY zYVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i11 > 0) {
                jSONObject.put("play_type", String.valueOf(i11));
            }
            if (sfl != null) {
                x8.a aVarGI = sfl.GI();
                if (aVarGI != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, aVarGI.f());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(aVarGI.c()));
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_URL, aVarGI.q());
                    jSONObject.put("player_type", zYVar.BT());
                    jSONObject.put("video_encode_type", zYVar.UFX() ? 1 : 0);
                }
                jSONObject.put("dp_creative_type", sfl.Vb());
            }
        } catch (JSONException e11) {
            Tf.sc("TTAD.VideoEventManager", "", e11);
        }
        return jSONObject;
    }

    public static void sc(Context context, a aVar, BT.sc scVar, qr qrVar) {
        BT bt2;
        if (context == null || aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        if (!scVar.WH()) {
            sc(sflExN, zYVarWe, scVar);
        }
        Qj qj2 = new Qj();
        qj2.sc(scVar.UFX() ? 1 : 0);
        qj2.pFF(CacheDirFactory.getICacheDir(sflExN.Flm()).pFF(zYVarWe));
        qj2.sc(SystemClock.elapsedRealtime() - bt2.sc());
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, qj2);
        scVar2.sc(scVar.WH());
        sc(scVar2, "feed_play", qrVar);
    }

    public static void sc(com.bytedance.sdk.openadsdk.We.ExN.pFF.sc<WH> scVar) {
        com.bytedance.sdk.openadsdk.SR.zY.sc("load_video_error", scVar);
    }

    private static void sc(com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar, String str) {
        sc(scVar, str, (JSONObject) null, (qr) null);
    }

    private static void sc(com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar, String str, qr qrVar) {
        sc(scVar, str, (JSONObject) null, qrVar);
    }

    private static void sc(com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar, String str, JSONObject jSONObject) {
        sc(scVar, str, jSONObject, (qr) null);
    }

    private static void sc(final com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar, String str, final JSONObject jSONObject, final qr qrVar) {
        if (scVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (scVar.ExN() && !TextUtils.isEmpty(scVar.pFF())) {
            String strPFF = scVar.pFF();
            strPFF.hashCode();
            if (strPFF.equals("stream") || strPFF.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.We.zY.sc(System.currentTimeMillis(), scVar.sc(), scVar.pFF(), str2, new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.We.ExN.sc.sc.1
            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
            public JSONObject sc() {
                qr qrVar2;
                try {
                    JSONObject jSONObjectZY = scVar.zY();
                    if (scVar.We() != null) {
                        scVar.We().sc(jSONObjectZY);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (qrVar2 = qrVar) != null) {
                        qrVar2.sc(jSONObjectZY);
                    }
                    jSONObject.put("ad_extra_data", jSONObjectZY.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private static void sc(final Sfl sfl, final zY zYVar, final BT.sc scVar) {
        com.bytedance.sdk.openadsdk.SR.zY.sc();
        com.bytedance.sdk.openadsdk.SR.zY.sc("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.We.ExN.sc.sc.2
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", sc.zY(zYVar));
                jSONObject.put("player_duration", scVar.zY());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", zYVar.Ql());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, sc.We(zYVar));
                jSONObject.put("player_type", zYVar.BT());
                We weSc = We.pFF().sc("pangle_video_play_state");
                Sfl sfl2 = sfl;
                return weSc.sc(sfl2 != null ? sfl2.qY() : 0).pFF(jSONObject.toString());
            }
        });
    }

    public static void sc(Sfl sfl, a aVar, zY zYVar) {
        if (sfl == null || aVar == null || zYVar == null) {
            return;
        }
        String strSc = JPJ.sc();
        int i11 = CacheDirFactory.getICacheDir(sfl.Flm()).sc(zYVar) ? 1 : 2;
        f27320sc.put(aVar, new BT(SystemClock.elapsedRealtime(), strSc, i11, zYVar, sfl));
        JSONObject jSONObjectSc = sc(sfl, strSc, i11, zYVar);
        String strSc2 = cJ.sc(sfl);
        try {
            int i12 = zYVar.We;
            if (i12 > 0) {
                jSONObjectSc.put("play_time", i12);
            }
            jSONObjectSc.put("is_mute", zYVar.Qj() ? 1 : 0);
        } catch (JSONException e11) {
            Tf.sc("TTAD.VideoEventManager", "", e11);
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sfl, strSc2, jSONObjectSc, null);
        scVar.sc(zYVar.BT() == -1);
        sc(scVar, "play_start");
    }

    public static void sc(a aVar, BT.sc scVar) {
        BT bt2;
        if (aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        if (jZY <= 0 || jSc <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.qr qrVar = new com.bytedance.sdk.openadsdk.We.ExN.pFF.qr();
        qrVar.sc(scVar.pFF());
        qrVar.pFF(jZY);
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, qrVar);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "feed_pause", jSONObject);
        } catch (JSONException e12) {
            Tf.sc("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void sc(a aVar, BT.sc scVar, qr qrVar) {
        BT bt2;
        if (aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        com.bytedance.sdk.openadsdk.We.ExN.pFF.We we2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.We();
        we2.pFF(scVar.pFF());
        we2.sc(jZY);
        we2.sc(scVar.qr());
        we2.pFF(scVar.Qj());
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, we2);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "feed_break", jSONObject, qrVar);
        } catch (JSONException e12) {
            Tf.sc("TTAD.VideoEventManager", "", e12);
        }
    }

    public static void sc(a aVar, boolean z11) {
        BT bt2;
        if (aVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        try {
            int i11 = zYVarWe.We;
            if (i11 > 0) {
                jSONObjectSc.put("play_time", i11);
            }
            jSONObjectSc.put("is_mute", z11 ? 1 : 0);
        } catch (JSONException e11) {
            Tf.sc("TTAD.VideoEventManager", "", e11);
        }
        sc(new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, null), "mute_state_change");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long zY(zY zYVar) {
        if (zYVar == null) {
            return 0L;
        }
        x8.a aVarDl = zYVar.UFX() ? zYVar.Dl() : zYVar.YIK();
        if (aVarDl != null) {
            return Double.valueOf(aVarDl.m() * 1000.0d).longValue();
        }
        return 0L;
    }

    public static void zY(a aVar, BT.sc scVar) {
        BT bt2;
        if (aVar == null || scVar == null || (bt2 = f27320sc.get(aVar)) == null) {
            return;
        }
        zY zYVarWe = bt2.We();
        Sfl sflExN = bt2.ExN();
        if (zYVarWe == null || sflExN == null) {
            return;
        }
        long jSc = scVar.sc();
        long jZY = scVar.zY();
        SR sr2 = new SR(scVar.Tf());
        sr2.sc(scVar.pFF());
        sr2.pFF(jZY);
        JSONObject jSONObjectSc = sc(sflExN, bt2.pFF(), bt2.zY(), zYVarWe);
        int i11 = zYVarWe.We;
        if (i11 > 0) {
            try {
                jSONObjectSc.put("play_time", i11);
            } catch (JSONException e11) {
                Tf.sc("TTAD.VideoEventManager", "", e11);
            }
        }
        com.bytedance.sdk.openadsdk.We.ExN.pFF.sc scVar2 = new com.bytedance.sdk.openadsdk.We.ExN.pFF.sc(sflExN, cJ.sc(sflExN), jSONObjectSc, sr2);
        scVar2.sc(scVar.WH());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", jSc);
            jSONObject.put("percent", scVar.TRI());
            sc(scVar2, "play_error", jSONObject);
        } catch (JSONException e12) {
            Tf.sc("TTAD.VideoEventManager", "", e12);
        }
        f27320sc.remove(aVar);
    }
}

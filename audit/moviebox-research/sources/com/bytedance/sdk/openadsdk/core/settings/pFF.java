package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public int BR;
    public int BT;
    public int CYO;
    public int Cb;
    public boolean Dl;
    public int ExN;
    public int FI;
    public String GI;
    public boolean Gb;
    public boolean HJN;
    public int II;
    public List<String> JPJ;
    public int JoC;
    public int McK;
    public List<Qj> MxZ;
    public int OXF;
    public int Ol;
    public List<Qj> QLv;
    public int Qj;
    public int Ql;
    public int SR;
    public int Sfl;
    public int TRI;
    public int Tf;
    public int UFX;
    public int WH;
    public int WP;
    public int We;
    public int Xc;
    public int YIK;
    public boolean cD;
    public boolean cJ;
    public int cvk;
    public int dE;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    public JSONObject f28516eo;
    public int kX;
    public int pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public String f28517pc;
    public long qKn;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public int f28518qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public String f28519sc;
    public int uEA;
    public int wjp;
    public int zY;

    public pFF(String str, int i11) {
        this.pFF = 1;
        this.zY = 1;
        this.We = 2;
        this.ExN = 1;
        this.TRI = 100;
        this.f28518qr = 0;
        this.Qj = 2;
        this.Ol = 1;
        this.WH = 3;
        this.UFX = 30;
        this.Tf = 30;
        this.Ql = 1;
        this.SR = 1;
        this.BT = 2;
        this.dE = 1500;
        this.Xc = 2;
        this.wjp = 3500;
        this.Sfl = 0;
        this.YIK = 5;
        this.Dl = false;
        this.uEA = 0;
        this.FI = 2;
        this.WP = -1;
        this.cvk = 0;
        this.II = 0;
        this.McK = 5;
        this.HJN = true;
        this.Gb = false;
        this.cD = false;
        this.Cb = 0;
        this.OXF = -1;
        this.cJ = false;
        this.kX = 60000;
        this.BR = 2;
        this.JoC = 1000;
        this.CYO = 1;
        this.MxZ = new ArrayList();
        this.QLv = new ArrayList();
        this.f28516eo = new JSONObject();
        this.f28519sc = str;
        this.zY = i11;
    }

    public pFF(JSONObject jSONObject) {
        this.pFF = 1;
        this.zY = 1;
        this.We = 2;
        this.ExN = 1;
        this.TRI = 100;
        this.f28518qr = 0;
        this.Qj = 2;
        this.Ol = 1;
        this.WH = 3;
        this.UFX = 30;
        this.Tf = 30;
        this.Ql = 1;
        this.SR = 1;
        this.BT = 2;
        this.dE = 1500;
        this.Xc = 2;
        this.wjp = 3500;
        this.Sfl = 0;
        this.YIK = 5;
        this.Dl = false;
        this.uEA = 0;
        this.FI = 2;
        this.WP = -1;
        this.cvk = 0;
        this.II = 0;
        this.McK = 5;
        this.HJN = true;
        this.Gb = false;
        this.cD = false;
        this.Cb = 0;
        this.OXF = -1;
        this.cJ = false;
        this.kX = 60000;
        this.BR = 2;
        this.JoC = 1000;
        this.CYO = 1;
        this.MxZ = new ArrayList();
        this.QLv = new ArrayList();
        new JSONObject();
        this.f28516eo = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f28519sc = jSONObject.optString("code_id");
        this.pFF = jSONObject.optInt("auto_play", 1);
        this.OXF = jSONObject.optInt("endcard_close_time", -1);
        this.zY = jSONObject.optInt("voice_control", 1);
        this.We = jSONObject.optInt("rv_preload", 2);
        this.ExN = jSONObject.optInt("nv_preload", 1);
        this.TRI = Math.min(100, Math.max(0, jSONObject.optInt("proportion_watching", 100)));
        this.f28518qr = jSONObject.optInt("skip_time_displayed", 0);
        this.Qj = jSONObject.optInt("video_skip_result", 2);
        this.Ol = jSONObject.optInt("reg_creative_control", 1);
        this.WH = jSONObject.optInt("play_bar_show_time", 3);
        int iOptInt = jSONObject.optInt("rv_skip_time", 30);
        this.UFX = iOptInt;
        if (iOptInt < 0) {
            this.UFX = 30;
        }
        this.Ql = jSONObject.optInt("voice_control", 2);
        this.SR = jSONObject.optInt("if_show_win", 1);
        this.BT = jSONObject.optInt("sp_preload", 2);
        this.dE = jSONObject.optInt("stop_time", 1500);
        this.Xc = jSONObject.optInt("native_playable_delay", 2);
        this.wjp = jSONObject.optInt("time_out_control", -1);
        this.WP = jSONObject.optInt("playable_close_time", -1);
        this.Sfl = jSONObject.optInt("playable_reward_type", 0);
        this.uEA = jSONObject.optInt("reward_is_callback", 0);
        int iOptInt2 = jSONObject.optInt("iv_skip_time", 5);
        this.YIK = iOptInt2;
        if (iOptInt2 < 0) {
            this.YIK = 5;
        }
        sc(jSONObject.optJSONArray("parent_tpl_ids"));
        this.FI = jSONObject.optInt("slot_type", 2);
        this.Dl = jSONObject.optBoolean("close_on_click", false);
        this.cvk = jSONObject.optInt("allow_system_back", 0);
        this.II = jSONObject.optInt("splash_skip_time", 0);
        this.McK = jSONObject.optInt("splash_image_count_down_time", 5);
        this.Gb = jSONObject.optBoolean("splash_count_down_time_off", false);
        this.cD = jSONObject.optBoolean("splash_close_on_click", false);
        int iOptInt3 = jSONObject.optInt("splash_load_strategy", 0);
        this.Cb = iOptInt3;
        if (iOptInt3 < 0 || iOptInt3 > 1) {
            this.Cb = 0;
        }
        this.HJN = jSONObject.optBoolean("allow_mediaview_click", true);
        int iOptInt4 = jSONObject.optInt("total_time_out", 60000);
        this.kX = iOptInt4;
        if (iOptInt4 <= 0 || iOptInt4 > 1800000) {
            this.kX = 60000;
        }
        int iOptInt5 = jSONObject.optInt("req_parallel_num", 2);
        this.BR = iOptInt5;
        if (iOptInt5 <= 0 || iOptInt5 > 4) {
            this.BR = 2;
        }
        this.JoC = jSONObject.optInt("bidding_token_tmax", 1000);
        int iOptInt6 = jSONObject.optInt("ad_load_type", 1);
        this.CYO = iOptInt6;
        if (iOptInt6 <= 0 || iOptInt6 > 2) {
            this.CYO = 1;
        }
        boolean zOptBoolean = jSONObject.optBoolean("is_mediation", false);
        this.cJ = zOptBoolean;
        if (zOptBoolean) {
            dE.ef().Bs();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mediation_config");
            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                String strOptString = jSONObjectOptJSONObject.optString("adn_name");
                String strOptString2 = jSONObjectOptJSONObject.optString("adn_slot_id");
                int iOptInt7 = jSONObjectOptJSONObject.optInt("ad_expired_time", 3600000);
                int iOptInt8 = jSONObjectOptJSONObject.optInt("req_bidding_type", 2);
                String strOptString3 = jSONObjectOptJSONObject.optString("rit_cpm");
                int iOptInt9 = jSONObjectOptJSONObject.optInt("show_sort");
                int iOptInt10 = jSONObjectOptJSONObject.optInt("layer_time_out", 2000);
                int i12 = (iOptInt10 <= 0 || iOptInt10 > 60000) ? 2000 : iOptInt10;
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("server_params");
                if (iOptInt8 == 2) {
                    arrayList.add(new Qj(strOptString, strOptString2, iOptInt7, iOptInt8, strOptString3, iOptInt9, i12, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                } else if (iOptInt8 == 0) {
                    arrayList2.add(new Qj(strOptString, strOptString2, iOptInt7, iOptInt8, strOptString3, iOptInt9, i12, jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString()));
                }
            }
            this.MxZ = arrayList;
            this.QLv = arrayList2;
            Collections.sort(arrayList);
            Collections.sort(this.QLv);
        }
        if (!sc(this.zY)) {
            this.zY = 1;
        }
        if (!sc(this.Ql)) {
            this.Ql = 1;
        }
        this.qKn = jSONObject.optLong("waterfall_id");
        String strOptString4 = jSONObject.optString("waterfall_version");
        this.f28517pc = strOptString4;
        this.GI = strOptString4;
        this.Tf = jSONObject.optInt("multi_rv_skip_time", 30);
    }

    private static boolean sc(int i11) {
        return i11 == 1 || i11 == 2;
    }

    public void sc(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.JPJ = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                this.JPJ.add(jSONArray.get(i11).toString());
            } catch (Exception unused) {
                return;
            }
        }
    }
}

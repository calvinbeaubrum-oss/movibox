package com.bytedance.sdk.openadsdk.BT;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.component.utils.Tf;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements Comparable<sc> {
    private int ExN;
    private long SR;
    private final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27060qr;
    private int zY;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final ArrayList<Long> f27061sc = new ArrayList<>();
    private final ArrayList<Long> We = new ArrayList<>();
    private final ArrayList<Long> TRI = new ArrayList<>();
    private final ArrayList<Long> Qj = new ArrayList<>();
    private final HashMap<String, pFF> Ol = new HashMap<>();
    private int WH = 0;
    private int UFX = 0;
    private final HashMap<String, pFF> Tf = new HashMap<>();
    private int Ql = 0;
    private final ArrayList<String> BT = new ArrayList<>();

    public sc(String str) {
        this.pFF = str;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0109 A[PHI: r10 r14
  0x0109: PHI (r10v3 int) = (r10v2 int), (r10v5 int), (r10v5 int) binds: [B:34:0x00e8, B:39:0x00fc, B:41:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0109: PHI (r14v2 long) = (r14v1 long), (r14v4 long), (r14v4 long) binds: [B:34:0x00e8, B:39:0x00fc, B:41:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    private void pFF(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i11;
        int i12;
        int i13;
        long j11;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        int[] iArrTf = com.bytedance.sdk.openadsdk.TRI.sc.sc().Tf();
        long j12 = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        if (iArrTf != null) {
            int i14 = 0;
            while (i14 < iArrTf.length) {
                int i15 = iArrTf[i14];
                long j13 = jElapsedRealtime - (((long) i15) * j12);
                Iterator<String> it = this.Tf.keySet().iterator();
                long j14 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<String> it2 = it;
                    pFF pff = this.Tf.get(next);
                    if (pff != null) {
                        long jSc = pff.sc(j13, jElapsedRealtime);
                        j14 += jSc;
                        if (jSc <= 0 && i14 == iArrTf.length - 1) {
                            hashSet4.add(next);
                        }
                    }
                    it = it2;
                }
                if (j14 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i15)), j14);
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                    long jOptInt = ((long) jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i15)))) + j14;
                    if (jOptInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i15)), jOptInt);
                    }
                } else {
                    hashSet2 = hashSet4;
                    hashSet3 = hashSet5;
                }
                i14++;
                hashSet4 = hashSet2;
                hashSet5 = hashSet3;
                j12 = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
            }
        }
        HashSet hashSet6 = hashSet4;
        HashSet hashSet7 = hashSet5;
        int[] iArrQl = com.bytedance.sdk.openadsdk.TRI.sc.sc().Ql();
        if (iArrQl != null) {
            int i16 = 0;
            while (i16 < iArrQl.length) {
                int i17 = iArrQl[i16];
                long j15 = jElapsedRealtime - (((long) i17) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
                Iterator<String> it3 = this.Ol.keySet().iterator();
                int i18 = 0;
                long j16 = 0;
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    Iterator<String> it4 = it3;
                    pFF pff2 = this.Ol.get(next2);
                    if (pff2 != null) {
                        long jSc2 = pff2.sc(j15, jElapsedRealtime);
                        j16 += jSc2;
                        if (jSc2 > DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                            i18++;
                        }
                        if (jSc2 > 0 || i16 != iArrQl.length - 1) {
                            hashSet = hashSet7;
                        } else {
                            hashSet = hashSet7;
                            hashSet.add(next2);
                        }
                    } else {
                        hashSet = hashSet7;
                    }
                    hashSet7 = hashSet;
                    it3 = it4;
                }
                HashSet hashSet8 = hashSet7;
                if (j16 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i17)), j16);
                    j11 = jElapsedRealtime;
                    long jOptInt2 = ((long) jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i17)))) + j16;
                    if (jOptInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i17)), jOptInt2);
                    }
                } else {
                    j11 = jElapsedRealtime;
                }
                if (i18 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i17)), i18);
                    int iOptInt = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i17))) + i18;
                    if (iOptInt != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i17)), iOptInt);
                    }
                }
                i16++;
                hashSet7 = hashSet8;
                jElapsedRealtime = j11;
            }
        }
        HashSet hashSet9 = hashSet7;
        if (!hashSet6.isEmpty()) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                this.Tf.remove((String) it5.next());
            }
        }
        if (!hashSet9.isEmpty()) {
            Iterator it6 = hashSet9.iterator();
            while (it6.hasNext()) {
                this.Ol.remove((String) it6.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.TRI.sc.sc().BT() && (i13 = this.WH) != 0) {
            jSONObject.put("v_stay_t_s", i13);
            int iOptInt2 = jSONObject2.optInt("v_stay_t_s") + this.WH;
            if (iOptInt2 != 0) {
                jSONObject2.put("v_stay_t_s", iOptInt2);
            }
        }
        if (com.bytedance.sdk.openadsdk.TRI.sc.sc().SR() && (i12 = this.Ql) != 0) {
            jSONObject.put("lp_stay_t_s", i12);
            int iOptInt3 = jSONObject2.optInt("lp_stay_t_s") + this.Ql;
            if (iOptInt3 != 0) {
                jSONObject2.put("lp_stay_t_s", iOptInt3);
            }
        }
        if (!com.bytedance.sdk.openadsdk.TRI.sc.sc().Xc() || (i11 = this.UFX) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i11);
        int iOptInt4 = jSONObject2.optInt("v_30p_play_c_s") + this.UFX;
        if (iOptInt4 != 0) {
            jSONObject2.put("v_30p_play_c_s", iOptInt4);
        }
    }

    private void sc(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j11, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i11 = 0;
        for (int i12 : iArr) {
            long j12 = j11 - (((long) i12) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            while (size >= 0 && arrayList.get(size).longValue() >= j12) {
                i11++;
                size--;
            }
            if (i11 != 0) {
                jSONObject.put(str + i12, i11);
                int iOptInt = jSONObject2.optInt(str + i12) + i11;
                if (iOptInt != 0) {
                    jSONObject2.put(str + i12, iOptInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void sc(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i11;
        int i12;
        int i13;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        sc("show_c_", jSONObject, this.f27061sc, com.bytedance.sdk.openadsdk.TRI.sc.sc().Ol(), jElapsedRealtime, jSONObject2);
        sc("click_c_", jSONObject, this.We, com.bytedance.sdk.openadsdk.TRI.sc.sc().WH(), jElapsedRealtime, jSONObject2);
        sc("v_play_c_", jSONObject, this.TRI, com.bytedance.sdk.openadsdk.TRI.sc.sc().UFX(), jElapsedRealtime, jSONObject2);
        sc("dislike_c_", jSONObject, this.Qj, com.bytedance.sdk.openadsdk.TRI.sc.sc().dE(), jElapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.TRI.sc.sc().TRI() && (i13 = this.zY) != 0) {
            jSONObject.put("show_c_s", i13);
            int iOptInt = jSONObject2.optInt("show_c_s") + this.zY;
            if (iOptInt != 0) {
                jSONObject2.put("show_c_s", iOptInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.TRI.sc.sc().qr() && (i12 = this.ExN) != 0) {
            jSONObject.put("click_c_s", i12);
            int iOptInt2 = jSONObject2.optInt("click_c_s") + this.ExN;
            if (iOptInt2 != 0) {
                jSONObject2.put("click_c_s", iOptInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.TRI.sc.sc().Qj() || (i11 = this.f27060qr) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i11);
        int iOptInt3 = jSONObject2.optInt("v_play_c_s") + this.f27060qr;
        if (iOptInt3 != 0) {
            jSONObject2.put("v_play_c_s", iOptInt3);
        }
    }

    public String pFF() {
        return this.pFF;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(sc scVar) {
        return scVar.zY - this.zY;
    }

    public JSONObject sc(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            sc(jSONObject2, jSONObject);
            pFF(jSONObject2, jSONObject);
        } catch (Throwable th2) {
            Tf.pFF(th2.getMessage());
        }
        return jSONObject2;
    }

    public void sc() {
        this.SR = SystemClock.elapsedRealtime();
        this.UFX = 0;
        this.ExN = 0;
        this.zY = 0;
        this.Ql = 0;
        this.WH = 0;
        this.f27060qr = 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void sc(@NonNull String str, @Nullable String str2) {
        pFF pff;
        pFF pff2;
        pFF pff3;
        pFF pff4;
        pFF pff5;
        pFF pff6;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1908685858:
                if (str.equals("landingContinue")) {
                    b11 = 0;
                }
                break;
            case -1769688545:
                if (str.equals("landingPause")) {
                    b11 = 1;
                }
                break;
            case -1766371189:
                if (str.equals("landingStart")) {
                    b11 = 2;
                }
                break;
            case -1643912491:
                if (str.equals("feed_over")) {
                    b11 = 3;
                }
                break;
            case -1643892427:
                if (str.equals("feed_play")) {
                    b11 = 4;
                }
                break;
            case 3529469:
                if (str.equals(PushConstants.PUSH_SERVICE_TYPE_SHOW)) {
                    b11 = 5;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b11 = 6;
                }
                break;
            case 533457448:
                if (str.equals("feed_continue")) {
                    b11 = 7;
                }
                break;
            case 566194974:
                if (str.equals("feed_break")) {
                    b11 = 8;
                }
                break;
            case 578633749:
                if (str.equals("feed_pause")) {
                    b11 = 9;
                }
                break;
            case 695109002:
                if (str.equals("landingFinish")) {
                    b11 = 10;
                }
                break;
            case 702698279:
                if (str.equals("videoPercent30")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1338624943:
                if (str.equals("videoForceBreak")) {
                    b11 = Ascii.FF;
                }
                break;
            case 1671642405:
                if (str.equals("dislike")) {
                    b11 = Ascii.CR;
                }
                break;
            case 1912965437:
                if (str.equals("play_error")) {
                    b11 = Ascii.SO;
                }
                break;
        }
        switch (b11) {
            case 0:
                if (!TextUtils.isEmpty(str2) && (pff = this.Tf.get(str2)) != null) {
                    pff.We(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 1:
                if (!TextUtils.isEmpty(str2) && (pff2 = this.Tf.get(str2)) != null) {
                    pff2.zY(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 2:
                if (!TextUtils.isEmpty(str2) && this.Tf.get(str2) == null) {
                    pFF pff7 = new pFF();
                    this.Tf.put(str2, pff7);
                    pff7.sc(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 3:
            case 8:
            case 12:
            case 14:
                if (!TextUtils.isEmpty(str2) && (pff3 = this.Ol.get(str2)) != null && pff3.sc() != pFF.ExN) {
                    pff3.pFF(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.TRI.sc.sc().BT()) {
                        this.WH = (int) (((long) this.WH) + pff3.sc(this.SR, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 4:
                this.TRI.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.TRI.sc.sc().Qj()) {
                    this.f27060qr++;
                }
                if (!TextUtils.isEmpty(str2) && this.Ol.get(str2) == null) {
                    pFF pff8 = new pFF();
                    this.Ol.put(str2, pff8);
                    pff8.sc(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 5:
                this.f27061sc.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.TRI.sc.sc().TRI()) {
                    this.zY++;
                }
                break;
            case 6:
                if (!this.BT.contains(str2)) {
                    if (this.BT.size() > 50) {
                        this.BT.subList(0, 25).clear();
                    }
                    this.BT.add(str2);
                    this.We.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.TRI.sc.sc().qr()) {
                        this.ExN++;
                    }
                    break;
                }
                break;
            case 7:
                if (!TextUtils.isEmpty(str2) && (pff4 = this.Ol.get(str2)) != null) {
                    pff4.We(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 9:
                if (!TextUtils.isEmpty(str2) && (pff5 = this.Ol.get(str2)) != null) {
                    pff5.zY(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case 10:
                if (!TextUtils.isEmpty(str2) && (pff6 = this.Tf.get(str2)) != null && pff6.sc() != pFF.ExN) {
                    pff6.pFF(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.TRI.sc.sc().SR()) {
                        this.Ql = (int) (((long) this.Ql) + pff6.sc(this.SR, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case 11:
                if (com.bytedance.sdk.openadsdk.TRI.sc.sc().Xc()) {
                    this.UFX++;
                }
                break;
            case 13:
                this.Qj.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }
}

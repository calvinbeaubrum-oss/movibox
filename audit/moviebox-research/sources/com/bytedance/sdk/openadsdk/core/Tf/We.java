package com.bytedance.sdk.openadsdk.core.Tf;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private String Dl;
    private final sc Ql;
    private boolean Sfl;
    private Sfl Xc;
    private boolean YIK;
    private long dE;
    private boolean wjp;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> f28217sc = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> pFF = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> zY = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> We = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> ExN = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> TRI = new ArrayList();

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> f28216qr = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> Qj = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> Ol = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> WH = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF> UFX = new ArrayList();
    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.sc> Tf = new ArrayList();
    private final AtomicBoolean SR = new AtomicBoolean(false);
    private final AtomicBoolean BT = new AtomicBoolean(false);

    public We(sc scVar) {
        this.Ql = scVar;
    }

    private JSONArray pFF() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF> it = this.UFX.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().pFF());
        }
        return jSONArray;
    }

    private void pFF(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, str);
            com.bytedance.sdk.openadsdk.We.zY.pFF(this.Xc, this.Dl, "vast_play_track", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void sc(long j11, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list, com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar) {
        sc(j11, list, scVar, null);
    }

    private void sc(long j11, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list, com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar, com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF pff) {
        sc scVar2 = this.Ql;
        com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(list, scVar, j11, scVar2 != null ? scVar2.qr() : null, pff);
    }

    private void sc(final TRI tri, final int i11) {
        com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.We.1
            @Override // java.lang.Runnable
            public void run() {
                TRI tri2 = tri;
                if (tri2 != null) {
                    tri2.sc(i11);
                }
            }
        });
    }

    private JSONArray zY() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<com.bytedance.sdk.openadsdk.core.Tf.pFF.sc> it = this.Tf.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().sc());
        }
        return jSONArray;
    }

    public void ExN(long j11) {
        if (this.BT.compareAndSet(false, true)) {
            sc(j11, this.TRI, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
        }
    }

    public void ExN(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.TRI.addAll(list);
    }

    public void Ol(long j11) {
        sc(j11, this.WH, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
    }

    public void Ol(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.sc> list) {
        this.Tf.addAll(list);
        Collections.sort(this.Tf);
    }

    public void Qj(long j11) {
        sc(j11, this.Ol, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
    }

    public void Qj(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF> list) {
        this.UFX.addAll(list);
        Collections.sort(this.UFX);
    }

    public void TRI(long j11) {
        sc(j11, this.f28216qr, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
    }

    public void TRI(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.f28216qr.addAll(list);
    }

    public void Tf(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.WH.addAll(list);
    }

    public void UFX(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.Ol.addAll(list);
    }

    public void WH(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.f28217sc.addAll(list);
    }

    public void We(long j11) {
        sc(j11, this.ExN, null, new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("video_progress", this.Xc, 1.0f));
    }

    public void We(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.ExN.addAll(list);
    }

    public void pFF(long j11) {
        sc(j11, this.zY, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
    }

    public void pFF(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.zY.addAll(list);
    }

    public void qr(long j11) {
        sc(j11, this.Qj, null, new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("click", this.Xc));
    }

    public void qr(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.Qj.addAll(list);
    }

    public List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> sc(long j11, float f11) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.UFX.size(); i11++) {
            com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF pff = this.UFX.get(i11);
            if (pff.sc(f11)) {
                arrayList.add(pff);
            }
        }
        for (int i12 = 0; i12 < this.Tf.size(); i12++) {
            com.bytedance.sdk.openadsdk.core.Tf.pFF.sc scVar = this.Tf.get(i12);
            if (scVar.sc(j11)) {
                arrayList.add(scVar);
            }
        }
        return arrayList;
    }

    public JSONObject sc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.f28217sc));
        jSONObject.put("impressionTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.pFF));
        jSONObject.put("pauseTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.zY));
        jSONObject.put("resumeTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.We));
        jSONObject.put("completeTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.ExN));
        jSONObject.put("closeTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.TRI));
        jSONObject.put("skipTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.f28216qr));
        jSONObject.put("clickTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.Qj));
        jSONObject.put("muteTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.Ol));
        jSONObject.put("unMuteTrackers", com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(this.WH));
        jSONObject.put("fractionalTrackers", pFF());
        jSONObject.put("absoluteTrackers", zY());
        return jSONObject;
    }

    public void sc(long j11) {
        if (this.SR.compareAndSet(false, true)) {
            sc(j11, this.pFF, null, new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("show_impression", this.Xc));
        }
    }

    public void sc(long j11, long j12, TRI tri) {
        if (System.currentTimeMillis() - this.dE >= 1000 && j11 >= 0 && j12 > 0) {
            this.dE = System.currentTimeMillis();
            float f11 = j11 / j12;
            List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> listSc = sc(j11, f11);
            if (f11 >= 0.25f && !this.wjp) {
                pFF("firstQuartile");
                this.wjp = true;
                if (tri != null) {
                    sc(tri, 6);
                }
                f11 = 0.25f;
            } else if (f11 >= 0.5f && !this.Sfl) {
                pFF(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
                this.Sfl = true;
                if (tri != null) {
                    sc(tri, 7);
                }
                f11 = 0.5f;
            } else if (f11 >= 0.75f && !this.YIK) {
                pFF("thirdQuartile");
                this.YIK = true;
                if (tri != null) {
                    sc(tri, 8);
                }
                f11 = 0.75f;
            }
            if (f11 < 0.03f) {
                f11 = 0.0f;
            }
            sc(j11, listSc, null, new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("video_progress", this.Xc, f11));
        }
    }

    public void sc(We we2) {
        WH(we2.f28217sc);
        sc(we2.pFF);
        pFF(we2.zY);
        zY(we2.We);
        We(we2.ExN);
        ExN(we2.TRI);
        TRI(we2.f28216qr);
        qr(we2.Qj);
        UFX(we2.Ol);
        Tf(we2.WH);
        Qj(we2.UFX);
        Ol(we2.Tf);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar) {
        sc(-1L, this.f28217sc, scVar);
    }

    public void sc(Sfl sfl) {
        this.Xc = sfl;
    }

    public void sc(String str) {
        this.Dl = str;
    }

    public void sc(String str, float f11) {
        if (TextUtils.isEmpty(str) || f11 < 0.0f) {
            return;
        }
        Qj(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.Tf.pFF.pFF.sc(str, f11).sc()));
    }

    public void sc(String str, long j11) {
        if (TextUtils.isEmpty(str) || j11 < 0) {
            return;
        }
        Ol(Collections.singletonList(new com.bytedance.sdk.openadsdk.core.Tf.pFF.sc.C0291sc(str, j11).sc()));
    }

    public void sc(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.pFF.addAll(list);
    }

    public void sc(JSONObject jSONObject) {
        WH(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("errorTrackers")));
        sc(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("impressionTrackers")));
        pFF(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("pauseTrackers"), true));
        zY(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("resumeTrackers"), true));
        We(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("completeTrackers")));
        ExN(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("closeTrackers")));
        TRI(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("skipTrackers")));
        qr(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("clickTrackers")));
        UFX(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("muteTrackers"), true));
        Tf(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(jSONObject.optJSONArray("unMuteTrackers"), true));
        Qj(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF(jSONObject.optJSONArray("fractionalTrackers")));
        Ol(com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.zY(jSONObject.optJSONArray("absoluteTrackers")));
    }

    public void zY(long j11) {
        sc(j11, this.We, (com.bytedance.sdk.openadsdk.core.Tf.sc.sc) null);
    }

    public void zY(List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list) {
        this.We.addAll(list);
    }
}

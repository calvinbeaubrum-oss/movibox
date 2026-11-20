package com.bytedance.sdk.openadsdk.TRI;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.SR.zY;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.HJN;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile pFF f27272sc;
    private final ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.BT.sc> pFF = new ConcurrentHashMap<>();
    private com.bytedance.sdk.openadsdk.BT.sc zY = null;
    private volatile boolean We = false;
    private volatile HandlerThread ExN = null;
    private volatile Handler TRI = null;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f27273qr = "";
    private int Qj = 0;
    private volatile long Ol = 0;
    private final Runnable WH = new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.6
        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (sc.sc().ExN()) {
                        Set<String> setKeySet = pFF.this.pFF.keySet();
                        if (setKeySet.size() > pFF.this.Qj) {
                            pFF.this.Qj = setKeySet.size();
                        }
                        HashSet hashSet = new HashSet(5);
                        ArrayList arrayList = new ArrayList(setKeySet.size());
                        arrayList.addAll(pFF.this.pFF.values());
                        Collections.sort(arrayList);
                        for (int i11 = 0; i11 < arrayList.size() && i11 < 5; i11++) {
                            hashSet.add(((com.bytedance.sdk.openadsdk.BT.sc) arrayList.get(i11)).pFF());
                        }
                        try {
                            for (String str : setKeySet) {
                                com.bytedance.sdk.openadsdk.BT.sc scVar = (com.bytedance.sdk.openadsdk.BT.sc) pFF.this.pFF.get(str);
                                if (scVar != null) {
                                    JSONObject jSONObjectSc = scVar.sc(jSONObject2);
                                    if (hashSet.contains(str)) {
                                        jSONObject.put(str, jSONObjectSc);
                                    }
                                }
                            }
                            jSONObject.put("common", jSONObject2);
                        } catch (JSONException e11) {
                            Tf.pFF(e11.getMessage());
                        }
                    } else {
                        try {
                            if (pFF.this.zY != null) {
                                jSONObject.put("common", pFF.this.zY.sc(jSONObject2));
                            }
                        } catch (JSONException e12) {
                            Tf.pFF(e12.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    Tf.pFF(th2.getMessage());
                }
                pFF.this.f27273qr = jSONObject.toString();
                pFF pff = pFF.this;
                pff.sc(pff.WH, sc.sc().We());
            } catch (OutOfMemoryError e13) {
                Tf.pFF(e13.getMessage());
            }
        }
    };

    private pFF() {
    }

    private void ExN() {
        if (this.We) {
            return;
        }
        this.We = true;
        sc(this.WH, sc.sc().We());
    }

    private void We() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.Ol > 10000) {
            zY.sc("track_feature_result", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.1
                @Override // com.bytedance.sdk.openadsdk.SR.pFF
                @Nullable
                public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                    pFF.this.Ol = jElapsedRealtime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, String.valueOf(pFF.this.Qj));
                    return We.pFF().sc("track_feature_result").pFF(jSONObject.toString());
                }
            });
        }
    }

    public static pFF sc() {
        if (f27272sc == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.zY.class) {
                try {
                    if (f27272sc == null) {
                        f27272sc = new pFF();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27272sc;
    }

    private void sc(Runnable runnable) {
        if (HJN.f28732sc || runnable == null) {
            return;
        }
        try {
            zY().post(runnable);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Runnable runnable, long j11) {
        if (HJN.f28732sc || runnable == null) {
            return;
        }
        try {
            zY().postDelayed(runnable, j11);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(@NonNull String str, @NonNull String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && sc.sc().zY()) {
                ExN();
                if (!sc.sc().ExN()) {
                    if (this.zY == null) {
                        this.zY = new com.bytedance.sdk.openadsdk.BT.sc(str2);
                    }
                    this.zY.sc(str, str3);
                } else {
                    com.bytedance.sdk.openadsdk.BT.sc scVar = this.pFF.get(str2);
                    if (scVar == null) {
                        scVar = new com.bytedance.sdk.openadsdk.BT.sc(str2);
                    }
                    scVar.sc(str, str3);
                    this.pFF.put(str2, scVar);
                }
            }
        } catch (OutOfMemoryError e11) {
            Tf.pFF(e11.getMessage());
        }
    }

    private Handler zY() {
        if (this.ExN == null || !this.ExN.isAlive()) {
            synchronized (SR.class) {
                try {
                    if (this.ExN == null || !this.ExN.isAlive()) {
                        this.ExN = new HandlerThread("csj_feature", -1);
                        this.ExN.start();
                        this.TRI = new Handler(this.ExN.getLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (this.TRI == null) {
            synchronized (SR.class) {
                try {
                    if (this.TRI == null) {
                        this.TRI = new Handler(this.ExN.getLooper());
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return this.TRI;
    }

    public void pFF() {
        try {
            if (sc.sc().zY()) {
                sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!sc.sc().ExN()) {
                            if (pFF.this.zY != null) {
                                pFF.this.zY.sc();
                            }
                        } else {
                            Iterator it = pFF.this.pFF.keySet().iterator();
                            while (it.hasNext()) {
                                com.bytedance.sdk.openadsdk.BT.sc scVar = (com.bytedance.sdk.openadsdk.BT.sc) pFF.this.pFF.get((String) it.next());
                                if (scVar != null) {
                                    scVar.sc();
                                }
                            }
                        }
                    }
                });
            }
        } catch (OutOfMemoryError e11) {
            Tf.pFF(e11.getMessage());
        }
    }

    public void sc(@NonNull final String str, final Sfl sfl) {
        if (!TextUtils.isEmpty(str) && sc.sc().zY() && Sfl.ExN(sfl)) {
            if (!sc.sc().wjp() || sfl.Zn() == 8 || sfl.Zn() == 7 || sfl.Zn() == 3) {
                if ("videoPercent30".equals(str) || "videoForceBreak".equals(str)) {
                    sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.4
                        @Override // java.lang.Runnable
                        public void run() {
                            String strKh = sfl.Kh();
                            String strOfL = sfl.ofL();
                            if (TextUtils.isEmpty(strKh)) {
                                return;
                            }
                            pFF.this.sc(str, strKh, strOfL);
                        }
                    });
                }
            }
        }
    }

    public void sc(@NonNull final String str, final Sfl sfl, final String str2) {
        if (TextUtils.isEmpty(str) || !sc.sc().zY()) {
            return;
        }
        if ("landingStart".equals(str) || "landingFinish".equals(str) || "landingContinue".equals(str) || "landingPause".equals(str)) {
            sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.5
                @Override // java.lang.Runnable
                public void run() {
                    Sfl sfl2 = sfl;
                    if (sfl2 == null || TextUtils.isEmpty(sfl2.Kh())) {
                        return;
                    }
                    pFF.this.sc(str, sfl.Kh(), sfl.ofL() + str2);
                }
            });
        }
    }

    public void sc(@NonNull final String str, @NonNull final String str2, final String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !sc.sc().zY()) {
            return;
        }
        if (PushConstants.PUSH_SERVICE_TYPE_SHOW.equals(str) || "click".equals(str) || "dislike".equals(str)) {
            sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.2
                @Override // java.lang.Runnable
                public void run() {
                    pFF.this.sc(str, str2, str3);
                }
            });
            return;
        }
        if (sc.sc().wjp()) {
            if (TextUtils.isEmpty(str4)) {
                return;
            }
            if (!"rewarded_video".equals(str4) && !"fullscreen_interstitial_ad".equals(str4) && !"open_ad".equals(str4)) {
                return;
            }
        }
        if ("feed_play".equals(str) || "feed_pause".equals(str) || "feed_continue".equals(str) || "feed_over".equals(str) || "feed_break".equals(str) || "play_error".equals(str)) {
            sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.TRI.pFF.3
                @Override // java.lang.Runnable
                public void run() {
                    pFF.this.sc(str, str2, str3);
                }
            });
        }
    }

    public void sc(JSONObject jSONObject) {
        if (sc.sc().zY()) {
            try {
                jSONObject.put("feature_data", this.f27273qr);
                We();
            } catch (JSONException e11) {
                Tf.pFF(e11.getMessage());
            }
        }
    }
}

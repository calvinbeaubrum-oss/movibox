package com.bytedance.sdk.openadsdk.Sfl.sc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.openadsdk.Tf.ExN;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    private static volatile We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Handler f27248sc;
    private int zY = 0;
    private int We = 2;
    private int ExN = 3600000;
    private final ArrayList<pFF> TRI = new ArrayList<>();

    private We() {
        Cb.pFF(new Qj("pag_pre_render_init") { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.1
            @Override // java.lang.Runnable
            public void run() {
                We.this.zY = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_pre_render_enable", 0);
                We.this.We = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_pre_render_max_count", 2);
                if (We.this.We <= 0 || We.this.We > 4) {
                    We.this.We = 2;
                }
                We.this.ExN = com.bytedance.sdk.openadsdk.YIK.sc.sc("plb_pre_render_alive_time", 3600000);
                if (We.this.ExN <= 0 || We.this.ExN > 3600000) {
                    We.this.ExN = 3600000;
                }
            }
        });
        this.f27248sc = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                if (!(message.obj instanceof pFF)) {
                    return false;
                }
                We.this.TRI.remove(message.obj);
                ((pFF) message.obj).We();
                return true;
            }
        });
    }

    public static We sc() {
        if (pFF == null) {
            synchronized (We.class) {
                try {
                    if (pFF == null) {
                        pFF = new We();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public boolean pFF() {
        return this.zY == 1;
    }

    public pFF sc(@NonNull Sfl sfl, FrameLayout frameLayout, ExN exN) {
        pFF pff;
        if (pFF() && sfl.Cb() != null && !TextUtils.isEmpty(sfl.Cb().getBidAdm()) && JPJ.TRI(sfl) && frameLayout != null) {
            String strOfL = sfl.ofL();
            if (TextUtils.isEmpty(strOfL)) {
                return null;
            }
            int i11 = 0;
            while (true) {
                if (i11 >= this.TRI.size()) {
                    i11 = -1;
                    pff = null;
                    break;
                }
                pff = this.TRI.get(i11);
                if (strOfL.equals(pff.Qj())) {
                    break;
                }
                i11++;
            }
            if (pff != null) {
                this.f27248sc.removeMessages(strOfL.hashCode());
                this.TRI.remove(i11);
                this.TRI.size();
                sfl.WH(true);
                pff.sc(frameLayout, exN);
                com.bytedance.sdk.openadsdk.We.zY.sc(sfl, cJ.zY(sfl.Cb().getDurationSlotType()), "PL_use_pre_render", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.4
                    @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                    public JSONObject sc() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_pre_render", 1);
                        } catch (JSONException unused) {
                        }
                        return jSONObject;
                    }
                });
                return pff;
            }
        }
        return null;
    }

    public void sc(@Nullable final Sfl sfl) {
        if (pFF() && sfl != null && JPJ.TRI(sfl)) {
            final String strOfL = sfl.ofL();
            if (TextUtils.isEmpty(strOfL)) {
                return;
            }
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (We.this.TRI.size() >= We.this.We) {
                            We.this.TRI.size();
                            pFF pff = (pFF) We.this.TRI.remove(0);
                            if (pff != null) {
                                We.this.f27248sc.removeMessages(pff.Qj().hashCode());
                                pff.We();
                            }
                        }
                        sfl.WH(true);
                        Context contextSc = Xc.sc();
                        Sfl sfl2 = sfl;
                        final pFF pff2 = new pFF(contextSc, sfl2, sfl2.gx(), true, new FrameLayout(Xc.sc()), strOfL);
                        We.this.TRI.add(pff2);
                        pff2.qr();
                        Message messageObtain = Message.obtain();
                        messageObtain.what = strOfL.hashCode();
                        messageObtain.obj = pff2;
                        We.this.f27248sc.sendMessageDelayed(messageObtain, We.this.ExN);
                        pff2.sc(new sc.InterfaceC0271sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.3.1
                            @Override // com.bytedance.sdk.openadsdk.Sfl.sc.sc.InterfaceC0271sc
                            public void sc() {
                                We.this.f27248sc.removeMessages(strOfL.hashCode());
                                We.this.TRI.remove(pff2);
                                pff2.We();
                            }
                        });
                        Sfl sfl3 = sfl;
                        com.bytedance.sdk.openadsdk.We.zY.sc(sfl3, cJ.zY(sfl3.Cb().getDurationSlotType()), "PL_start_pre_render", new com.bytedance.sdk.openadsdk.SR.zY.sc() { // from class: com.bytedance.sdk.openadsdk.Sfl.sc.We.3.2
                            @Override // com.bytedance.sdk.openadsdk.SR.zY.sc
                            public JSONObject sc() {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("is_pre_render", 1);
                                } catch (JSONException unused) {
                                }
                                return jSONObject;
                            }
                        });
                    } catch (Throwable th2) {
                        th2.getMessage();
                    }
                }
            });
        }
    }
}

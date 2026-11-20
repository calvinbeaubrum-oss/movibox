package com.bytedance.adsdk.ugeno.core.sc;

import com.bytedance.adsdk.ugeno.We.pFF;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.pFF.zY;
import com.bytedance.sdk.component.uchain.action.EventChainAction;
import com.bytedance.sdk.component.uchain.listener.ICustomRouter;
import com.bytedance.sdk.component.uchain.listener.IEventChainLifeCycleListener;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements Tf {
    private volatile C0232sc ExN;
    private JSONObject We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Tf f26410sc;
    private boolean zY = true;
    private boolean TRI = false;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.core.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0232sc implements ICustomRouter {
        private Tf.pFF We;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        Tf.sc f26412sc;
        private WH zY;

        public C0232sc() {
        }

        public void sc(Tf.pFF pff) {
            this.We = pff;
        }

        public void sc(Tf.sc scVar) {
            this.f26412sc = scVar;
        }

        public void sc(WH wh2) {
            this.zY = wh2;
        }
    }

    public sc(Tf tf2) {
        this.f26410sc = tf2;
    }

    private C0232sc pFF() {
        if (this.ExN != null) {
            return this.ExN;
        }
        synchronized (C0232sc.class) {
            try {
                if (this.ExN != null) {
                    return this.ExN;
                }
                this.ExN = new C0232sc();
                return this.ExN;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void pFF(WH wh2, Tf.pFF pff, Tf.sc scVar) {
        Tf tf2 = this.f26410sc;
        if (tf2 == null) {
            return;
        }
        tf2.sc(wh2, pff, scVar);
    }

    private void zY(WH wh2, Tf.pFF pff, Tf.sc scVar) {
        if (this.ExN == null) {
            this.ExN = pFF();
        }
        this.ExN.sc(wh2);
        this.ExN.sc(pff);
        this.ExN.sc(scVar);
        JSONObject jSONObjectZY = wh2.zY();
        if (jSONObjectZY == null) {
            return;
        }
        new EventChainAction.Builder(jSONObjectZY.optString("type")).setChainData(this.We).setEventChainLifeCycleListener(new IEventChainLifeCycleListener() { // from class: com.bytedance.adsdk.ugeno.core.sc.sc.1
        }).build().run();
    }

    public void pFF(boolean z11) {
        this.TRI = z11;
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf
    public void sc(WH wh2, Tf.pFF pff, Tf.sc scVar) {
        if (sc()) {
            zY(wh2, pff, scVar);
        } else {
            pFF(wh2, pff, scVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf
    public void sc(zY zYVar, String str, pFF.sc scVar) {
        Tf tf2 = this.f26410sc;
        if (tf2 == null) {
            return;
        }
        tf2.sc(zYVar, str, scVar);
    }

    public void sc(String str) {
        this.pFF = str;
    }

    public void sc(JSONObject jSONObject) {
        this.We = jSONObject;
    }

    public void sc(boolean z11) {
        this.zY = z11;
    }

    public boolean sc() {
        String str;
        return this.zY && (str = this.pFF) != null && "3".compareTo(str) <= 0 && this.We != null;
    }
}

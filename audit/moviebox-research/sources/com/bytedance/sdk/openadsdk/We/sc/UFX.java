package com.bytedance.sdk.openadsdk.We.sc;

import android.content.Context;
import com.bytedance.sdk.component.utils.BT;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX implements com.bytedance.sdk.component.TRI.sc.ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f27392sc = "[6505]";

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public long BT() {
        long jSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("log_queue_timeout", 40000);
        if (jSc < 30000 || jSc > 120000) {
            return 40000L;
        }
        return jSc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public Executor ExN() {
        return Cb.qr();
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public String Ol() {
        return cJ.zY();
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean Qj() {
        return true;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public void Ql() {
        sc.sc(sc.TRI);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean SR() {
        return BinderPoolService.f28619sc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public int TRI() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public com.bytedance.sdk.component.TRI.sc.qr Tf() {
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public com.bytedance.sdk.component.TRI.sc.TRI UFX() {
        com.bytedance.sdk.component.TRI.sc.TRI triSc;
        synchronized (this) {
            triSc = com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc());
        }
        return triSc;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public com.bytedance.sdk.component.TRI.sc.ExN.zY WH() {
        return new qr();
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public Executor We() {
        return Cb.zY();
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public String pFF(String str) {
        return com.bytedance.sdk.component.We.sc.sc(str, com.bytedance.sdk.openadsdk.core.sc.sc());
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean pFF() {
        return false;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean qr() {
        return false;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public com.bytedance.sdk.component.TRI.sc.We.sc sc(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public String sc(String str) {
        return com.bytedance.sdk.component.We.sc.pFF(str, com.bytedance.sdk.openadsdk.core.sc.sc());
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public void sc(boolean z11) {
        sc.sc(sc.TRI, z11);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public void sc(boolean z11, int i11, long j11, com.bytedance.sdk.component.TRI.sc.TRI.We we2) {
        Runnable runnableSc;
        if (we2 == null) {
            return;
        }
        sc.sc(sc.zY, z11, i11, j11);
        if (z11) {
            com.bytedance.sdk.openadsdk.SR.zY.sc("track_link_result", false, (com.bytedance.sdk.openadsdk.SR.pFF) new Ql(true, we2));
            return;
        }
        SR srGx = dE.ef().gx();
        if (srGx == null || we2.We() >= srGx.sc(we2.TRI())) {
            com.bytedance.sdk.openadsdk.SR.zY.sc("track_link_result", false, (com.bytedance.sdk.openadsdk.SR.pFF) new Ql(false, we2));
        } else {
            if (!srGx.sc() || (runnableSc = we2.sc(com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc()), null)) == null) {
                return;
            }
            Cb.sc().schedule(runnableSc, srGx.pFF(we2.TRI()), TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean sc() {
        return false;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean sc(Context context) {
        return BT.sc(context);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public int zY(String str) {
        return dE.ef().gx().sc(str);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN
    public boolean zY() {
        return true;
    }
}

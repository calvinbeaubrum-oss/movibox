package com.bytedance.sdk.openadsdk.core.UFX.zY;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.Ol;
import com.bytedance.adsdk.ugeno.core.Ql;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.pFF.zY;
import com.bytedance.sdk.openadsdk.core.UFX.ExN.We;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements Ql, Tf {
    private Ql We;
    private zY<View> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f28314sc;
    private InterfaceC0298sc zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.UFX.zY.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0298sc {
        void sc(WH wh2);
    }

    public sc(Context context) {
        this.f28314sc = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(JSONObject jSONObject, JSONObject jSONObject2, We we2) {
        try {
            Ol ol2 = new Ol(this.f28314sc);
            zY<View> zYVarSc = ol2.sc(jSONObject);
            this.pFF = zYVarSc;
            if (zYVarSc == null) {
                if (we2 != null) {
                    we2.sc(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, "ugen render fail");
                    return;
                }
                return;
            }
            View viewOl = zYVarSc.Ol();
            if (viewOl != null) {
                viewOl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.UFX.zY.sc.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
            ol2.sc((Tf) this);
            ol2.sc((Ql) this);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("language", com.bytedance.sdk.openadsdk.core.Tf.pFF());
                    jSONObject2.put("os", "Android");
                } catch (JSONException unused) {
                }
            }
            ol2.pFF(jSONObject2);
            if (we2 != null) {
                we2.sc(this.pFF);
            }
        } catch (Exception e11) {
            if (we2 != null) {
                we2.sc(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, "ugen render fail exception is" + e11.getMessage());
            }
        }
    }

    public void sc(Ql ql2) {
        this.We = ql2;
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf
    public void sc(WH wh2, Tf.pFF pff, Tf.sc scVar) {
        InterfaceC0298sc interfaceC0298sc;
        if (wh2 == null) {
            return;
        }
        if ((wh2.pFF() == 1 || wh2.pFF() == 4) && (interfaceC0298sc = this.zY) != null) {
            interfaceC0298sc.sc(wh2);
        }
        if (pff == null || wh2.We() == null) {
            return;
        }
        pff.sc(wh2.We());
    }

    @Override // com.bytedance.adsdk.ugeno.core.Ql
    public void sc(zY zYVar, MotionEvent motionEvent) {
        Ql ql2 = this.We;
        if (ql2 != null) {
            ql2.sc(zYVar, motionEvent);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.Tf
    public void sc(zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
    }

    public void sc(InterfaceC0298sc interfaceC0298sc) {
        this.zY = interfaceC0298sc;
    }

    public void sc(final JSONObject jSONObject, final JSONObject jSONObject2, final We we2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            pFF(jSONObject, jSONObject2, we2);
        } else {
            Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.UFX.zY.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.this.pFF(jSONObject, jSONObject2, we2);
                }
            });
        }
    }
}

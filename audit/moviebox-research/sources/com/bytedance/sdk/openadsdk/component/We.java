package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.activity.TTAppOpenAdActivity;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.McK;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends PAGAppOpenAd {
    private boolean Ol;
    private boolean Qj;
    private com.bytedance.sdk.openadsdk.sc.We.pFF We;
    private final Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final boolean f27764qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f27765sc;
    private final AdSlot zY;
    private final AtomicBoolean ExN = new AtomicBoolean(false);
    private final String TRI = JPJ.sc();

    public We(Context context, @NonNull Sfl sfl, boolean z11, AdSlot adSlot) {
        this.f27765sc = context;
        this.pFF = sfl;
        this.f27764qr = z11;
        this.zY = adSlot;
    }

    private void sc() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Cb.zY(new Qj("AppOpenAd_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.We.1
                @Override // java.lang.Runnable
                public void run() {
                    IListenerManager iListenerManagerAsInterface;
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc scVarSc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc();
                    if (We.this.We == null || (iListenerManagerAsInterface = IListenerManager.Stub.asInterface(scVarSc.sc(7))) == null) {
                        return;
                    }
                    try {
                        iListenerManagerAsInterface.registerAppOpenAdListener(We.this.TRI, new com.bytedance.sdk.openadsdk.multipro.aidl.pFF.sc(We.this.We));
                        We.this.We = null;
                    } catch (RemoteException e11) {
                        Tf.sc("TTAppOpenAdImpl", e11.getMessage());
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        Sfl sfl = this.pFF;
        if (sfl == null || sfl.eoh() == null) {
            return null;
        }
        try {
            return this.pFF.eoh().get(str);
        } catch (Throwable th2) {
            Tf.sc("TTAppOpenAdImpl", th2.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        Sfl sfl = this.pFF;
        if (sfl != null) {
            return sfl.eoh();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d11, String str, String str2) {
        if (this.Ol) {
            return;
        }
        McK.sc(this.pFF, d11, str, str2);
        this.Ol = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionCallback(PAGAppOpenAdInteractionCallback pAGAppOpenAdInteractionCallback) {
        this.We = new ExN(pAGAppOpenAdInteractionCallback);
        sc();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void setAdInteractionListener(PAGAppOpenAdInteractionListener pAGAppOpenAdInteractionListener) {
        this.We = new ExN(pAGAppOpenAdInteractionListener);
        sc();
    }

    @Override // com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAd
    public void show(Activity activity) {
        int rotation;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (this.ExN.getAndSet(true)) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Tf.sc("TTAppOpenAdImpl", "showTTAppOpenAd error: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread ---- TTAppOpenAdImpl.showAppOpenAd");
        }
        IPMiBroadcastReceiver.sc(this.f27765sc, this.pFF);
        Context contextSc = activity != null ? activity : this.f27765sc;
        if (contextSc == null) {
            contextSc = Xc.sc();
        }
        try {
            rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        } catch (Exception unused) {
            rotation = 0;
        }
        Intent intent = new Intent(contextSc, (Class<?>) TTAppOpenAdActivity.class);
        intent.putExtra("orientation_angle", rotation);
        intent.putExtra("ad_source", this.f27764qr ? 1 : 2);
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.pFF.JP().toString());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_META_MD5, this.TRI);
        } else {
            FI.sc().TRI();
            FI.sc().sc(this.pFF);
            FI.sc().sc(this.We);
            this.We = null;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.component.utils.pFF.sc(contextSc, intent, new com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF() { // from class: com.bytedance.sdk.openadsdk.component.We.2
            @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
            public void sc() {
            }

            @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
            public void sc(Throwable th2) {
            }
        });
        SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.We.3
            @Override // java.lang.Runnable
            public void run() {
                if (We.this.zY != null) {
                    try {
                        if (dE.ef().WP(We.this.zY.getCodeId()) != 1 || Sfl.TRI(We.this.pFF)) {
                            return;
                        }
                        TRI triSc = TRI.sc(We.this.f27765sc);
                        triSc.qr(Integer.parseInt(We.this.zY.getCodeId()));
                        triSc.sc(We.this.zY);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d11) {
        if (this.Qj) {
            return;
        }
        McK.sc(this.pFF, d11);
        this.Qj = true;
    }
}

package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialActivity;
import com.bytedance.sdk.openadsdk.activity.TTInterstitialExpressActivity;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.McK;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class TRI extends PAGInterstitialAd {
    private boolean Ol;
    private boolean Qj;
    private final com.bytedance.sdk.openadsdk.core.model.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f27807sc;
    private com.bytedance.sdk.openadsdk.sc.zY.pFF zY;
    private final AtomicBoolean ExN = new AtomicBoolean(false);
    private boolean TRI = false;
    private boolean We = false;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f27806qr = JPJ.sc();

    public TRI(Context context, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.f27807sc = context;
        this.pFF = scVar;
    }

    private void sc(final int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Cb.zY(new com.bytedance.sdk.component.Qj.Qj("FullScreen_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.TRI.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc scVarSc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc();
                    if (i11 != 1 || TRI.this.zY == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.pFF.zY zYVar = new com.bytedance.sdk.openadsdk.multipro.aidl.pFF.zY(TRI.this.zY);
                    IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(scVarSc.sc(1));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerFullVideoListener(TRI.this.f27806qr, zYVar);
                        } catch (RemoteException e11) {
                            com.bytedance.sdk.component.utils.Tf.sc("TTFullScreenVideoAdImpl", e11.getMessage());
                        }
                    }
                }
            }, 5);
        }
    }

    private static boolean sc(Sfl sfl) {
        if (sfl == null) {
            return false;
        }
        int iXc = sfl.Xc();
        return (sfl.JPJ() != 2 || iXc == 5 || iXc == 33 || iXc == 6 || iXc == 19 || iXc == 12) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        com.bytedance.sdk.openadsdk.core.model.sc scVar = this.pFF;
        if (scVar == null || scVar.TRI() == null || this.pFF.TRI().eoh() == null) {
            return null;
        }
        try {
            return this.pFF.TRI().eoh().get(str);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTFullScreenVideoAdImpl", th2.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.model.sc scVar = this.pFF;
        if (scVar == null || scVar.TRI() == null) {
            return null;
        }
        return this.pFF.TRI().eoh();
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d11, String str, String str2) {
        if (this.Ol) {
            return;
        }
        McK.sc(this.pFF.TRI(), d11, str, str2);
        this.Ol = true;
    }

    public void sc() {
        if (this.ExN.get()) {
            return;
        }
        this.We = true;
    }

    public void sc(boolean z11) {
        this.TRI = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionCallback(PAGInterstitialAdInteractionCallback pAGInterstitialAdInteractionCallback) {
        this.zY = new com.bytedance.sdk.openadsdk.component.zY.sc(pAGInterstitialAdInteractionCallback);
        sc(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void setAdInteractionListener(PAGInterstitialAdInteractionListener pAGInterstitialAdInteractionListener) {
        this.zY = new com.bytedance.sdk.openadsdk.component.zY.sc(pAGInterstitialAdInteractionListener);
        sc(1);
    }

    @Override // com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd
    public void show(Activity activity) {
        Intent intent;
        Intent intent2;
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.Tf.sc("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        com.bytedance.sdk.openadsdk.core.model.sc scVar = this.pFF;
        if (scVar == null || !scVar.ExN()) {
            return;
        }
        boolean zQr = this.pFF.qr();
        final Sfl sflTRI = this.pFF.TRI();
        if (!a.e()) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            com.bytedance.sdk.component.utils.Tf.sc("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTFullScreenVideoAd.showFullScreenVideoAd");
        }
        List<Sfl> listWe = this.pFF.We();
        if (listWe != null) {
            Iterator<Sfl> it = listWe.iterator();
            while (it.hasNext()) {
                IPMiBroadcastReceiver.sc(this.f27807sc, it.next());
            }
        }
        if (this.ExN.get()) {
            return;
        }
        this.ExN.set(true);
        if (sflTRI == null || (sflTRI.GI() == null && sflTRI.ht() == null)) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "materialMeta error ");
            return;
        }
        Context contextSc = activity == null ? this.f27807sc : activity;
        if (contextSc == null) {
            contextSc = Xc.sc();
        }
        if (dE.ef().hE() && Qj.sc(this.pFF)) {
            intent = new Intent(contextSc, (Class<?>) TTAdActivity.class);
        } else {
            if (zQr) {
                intent2 = new Intent(contextSc, (Class<?>) TTFullScreenExpressVideoActivity.class);
            } else if (!sc(sflTRI)) {
                intent = com.bytedance.sdk.openadsdk.component.reward.pFF.Ol.sc(sflTRI) ? new Intent(contextSc, (Class<?>) TTInterstitialActivity.class) : new Intent(contextSc, (Class<?>) TTFullScreenVideoActivity.class);
            } else if (com.bytedance.sdk.openadsdk.component.reward.pFF.Ol.sc(sflTRI)) {
                intent = new Intent(contextSc, (Class<?>) TTInterstitialExpressActivity.class);
            } else {
                intent2 = new Intent(contextSc, (Class<?>) TTFullScreenExpressVideoActivity.class);
            }
            intent = intent2;
        }
        intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
        com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(intent, activity, this.We, this.pFF, this.f27806qr);
        intent.putExtra("is_verity_playable", this.TRI);
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            FI.sc().sc(this.zY);
            this.zY = null;
        }
        com.bytedance.sdk.component.utils.pFF.sc(contextSc, intent, new com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.TRI.1
            @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
            public void sc() {
                if (TRI.this.TRI) {
                    try {
                        com.bytedance.sdk.openadsdk.SR.zY.sc().sc(sflTRI.GI().p());
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
            public void sc(Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTFullScreenVideoAdImpl", "show full screen video error: ", th2);
                if (TRI.this.TRI) {
                    try {
                        com.bytedance.sdk.openadsdk.SR.zY.sc().sc(sflTRI.GI().p(), -1, th2 != null ? th2.getMessage() : "playable tool error open");
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "activity start  fail ");
            }
        }, true);
        if (zQr) {
            return;
        }
        sc.sc(this.pFF.TRI(), this.We, false);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d11) {
        if (this.Qj) {
            return;
        }
        McK.sc(this.pFF.TRI(), d11);
        this.Qj = true;
    }
}

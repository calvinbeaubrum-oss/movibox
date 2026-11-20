package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTAdActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.McK;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import x8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Qj extends PAGRewardedAd {
    private boolean ExN;
    private boolean Ol;
    private boolean Qj;
    private com.bytedance.sdk.openadsdk.sc.ExN.sc We;
    private final com.bytedance.sdk.openadsdk.core.model.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Context f27801sc;
    private final AdSlot zY;
    private final AtomicBoolean TRI = new AtomicBoolean(false);

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f27800qr = JPJ.sc();

    public Qj(Context context, com.bytedance.sdk.openadsdk.core.model.sc scVar, AdSlot adSlot) {
        this.f27801sc = context;
        this.pFF = scVar;
        this.zY = adSlot;
    }

    private void sc(final int i11) {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            Cb.zY(new com.bytedance.sdk.component.Qj.Qj("Reward_registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.component.reward.Qj.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc scVarSc = com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc();
                    if (i11 != 0 || Qj.this.We == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We we2 = new com.bytedance.sdk.openadsdk.multipro.aidl.pFF.We(Qj.this.We);
                    IListenerManager iListenerManagerAsInterface = IListenerManager.Stub.asInterface(scVarSc.sc(0));
                    if (iListenerManagerAsInterface != null) {
                        try {
                            iListenerManagerAsInterface.registerRewardVideoListener(Qj.this.f27800qr, we2);
                        } catch (RemoteException e11) {
                            com.bytedance.sdk.component.utils.Tf.sc("TTRewardVideoAdImpl", e11.getMessage());
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

    public static boolean sc(com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        Sfl sflTRI;
        a aVarGI;
        String strP;
        if (scVar == null || (sflTRI = scVar.TRI()) == null || Xc.zY(sflTRI)) {
            return false;
        }
        String strSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("rviv_new_arch_not_support_style", (String) null);
        if (TextUtils.isEmpty(strSc)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strSc);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                int i12 = jSONArray.getInt(i11);
                if (i12 != 0) {
                    if (sflTRI.Xc() == i12) {
                        return false;
                    }
                    if (i12 == 8 && (aVarGI = sflTRI.GI()) != null && (strP = aVarGI.p()) != null && Uri.parse(strP).getQueryParameterNames().contains("show_landingpage")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
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
            com.bytedance.sdk.component.utils.Tf.sc("TTRewardVideoAdImpl", th2.getMessage());
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
        if (this.TRI.get()) {
            return;
        }
        this.ExN = true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionCallback(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.We = new Ol(pAGRewardedAdInteractionCallback);
        sc(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void setAdInteractionListener(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.We = new Ol(pAGRewardedAdInteractionListener);
        sc(0);
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd
    public void show(@Nullable Activity activity) {
        Intent intent;
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.Tf.sc("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        com.bytedance.sdk.openadsdk.core.model.sc scVar = this.pFF;
        if (scVar == null || !scVar.ExN()) {
            return;
        }
        boolean zQr = this.pFF.qr();
        final Sfl sflTRI = this.pFF.TRI();
        if (!p8.a.e()) {
            com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "showFullScreenVideoAd error2: not main looper");
            com.bytedance.sdk.component.utils.Tf.sc("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("Cannot be called in a child thread —— TTRewardVideoAd.showRewardVideoAd");
        }
        List<Sfl> listWe = this.pFF.We();
        if (listWe != null) {
            Iterator<Sfl> it = listWe.iterator();
            while (it.hasNext()) {
                IPMiBroadcastReceiver.sc(this.f27801sc, it.next());
            }
        }
        if (this.TRI.compareAndSet(false, true)) {
            if (sflTRI == null || sflTRI.GI() == null) {
                com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "materialMeta error ");
                return;
            }
            Context contextSc = activity == null ? this.f27801sc : activity;
            if (contextSc == null) {
                contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
            }
            if (dE.ef().hE() && sc(this.pFF)) {
                intent = new Intent(contextSc, (Class<?>) TTAdActivity.class);
            } else if (zQr || sc(sflTRI)) {
                Intent intent2 = new Intent(contextSc, (Class<?>) TTRewardExpressVideoActivity.class);
                intent = intent2;
            } else {
                intent = new Intent(contextSc, (Class<?>) TTRewardVideoActivity.class);
            }
            com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(intent, activity, this.ExN, this.pFF, this.f27800qr);
            intent.putExtra("media_extra", this.zY.getMediaExtra());
            intent.putExtra("user_id", this.zY.getUserID());
            intent.putExtra("start_show_time", SystemClock.elapsedRealtime());
            if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                FI.sc().sc(this.We);
                this.We = null;
            }
            com.bytedance.sdk.component.utils.pFF.sc(contextSc, intent, new com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.Qj.1
                @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
                public void sc() {
                }

                @Override // com.bytedance.sdk.component.utils.pFF.InterfaceC0265pFF
                public void sc(Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTRewardVideoAdImpl", "show reward video error: ", th2);
                    com.bytedance.sdk.openadsdk.We.zY.sc(sflTRI, "fullscreen_interstitial_ad", "activity start  fail ");
                }
            }, true);
            if (zQr) {
                return;
            }
            sc.sc(this.pFF.TRI(), this.ExN, true);
        }
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

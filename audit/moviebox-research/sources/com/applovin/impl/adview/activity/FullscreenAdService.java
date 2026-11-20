package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.gc;
import com.applovin.impl.sdk.n;
import com.applovin.impl.tb;
import com.applovin.impl.yp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class FullscreenAdService extends Service {
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    /* JADX INFO: compiled from: source.java */
    public static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                tb tbVar = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (tbVar == null) {
                    if (!yp.a(1.0d)) {
                        super.handleMessage(message);
                        return;
                    }
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
                com.applovin.impl.sdk.ad.b bVarF = tbVar.f();
                int i11 = message.what;
                c cVar = c.AD;
                if (i11 == cVar.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, bVarF.getRawFullResponse());
                    Message messageObtain = Message.obtain((Handler) null, cVar.b());
                    messageObtain.setData(bundle);
                    try {
                        message.replyTo.send(messageObtain);
                        return;
                    } catch (RemoteException e11) {
                        n.c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e11);
                        return;
                    }
                }
                if (message.what == c.AD_DISPLAYED.b()) {
                    gc.a(tbVar.c(), bVarF);
                    return;
                }
                if (message.what == c.AD_CLICKED.b()) {
                    gc.a(tbVar.b(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_STARTED.b()) {
                    gc.a(tbVar.d(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_ENDED.b()) {
                    Bundle data = message.getData();
                    gc.a(tbVar.d(), bVarF, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    return;
                }
                if (message.what == c.AD_HIDDEN.b()) {
                    gc.b(tbVar.c(), bVarF);
                } else {
                    super.handleMessage(message);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17556a;

        c(int i11) {
            this.f17556a = i11;
        }

        public int b() {
            return this.f17556a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Messenger(new b()).getBinder();
    }
}

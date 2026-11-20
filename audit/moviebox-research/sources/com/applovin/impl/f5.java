package com.applovin.impl;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f5 {

    /* JADX INFO: compiled from: source.java */
    public class a implements OnSuccessListener {
        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AppSetIdInfo appSetIdInfo) {
            com.applovin.impl.sdk.k.a(new com.applovin.impl.sdk.k.b(appSetIdInfo.getId(), appSetIdInfo.getScope()));
        }
    }

    public static void a(final Context context) {
        new Thread(new Runnable() { // from class: com.applovin.impl.mv
            @Override // java.lang.Runnable
            public final void run() {
                f5.b(context);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Context context) {
        com.applovin.impl.sdk.k.a(l0.b(context));
        if (yp.a("com.google.android.gms.appset.AppSet")) {
            try {
                AppSet.getClient(context).getAppSetIdInfo().addOnSuccessListener(new a());
            } catch (Throwable unused) {
            }
        }
    }
}

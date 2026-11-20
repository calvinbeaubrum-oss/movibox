package com.applovin.impl;

import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f20475a = new HashSet(32);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f20476b = new Object();

    private ml a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (ml mlVar : this.f20475a) {
            if (str.equals(mlVar.b()) && appLovinCommunicatorSubscriber.equals(mlVar.a())) {
                return mlVar;
            }
        }
        return null;
    }

    public boolean a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber == null || !StringUtils.isValidString(str)) {
            com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
            return false;
        }
        synchronized (this.f20476b) {
            try {
                ml mlVarA = a(str, appLovinCommunicatorSubscriber);
                if (mlVarA == null) {
                    ml mlVar = new ml(str, appLovinCommunicatorSubscriber);
                    this.f20475a.add(mlVar);
                    AppLovinBroadcastManager.registerReceiver(mlVar, new IntentFilter(str));
                    return true;
                }
                com.applovin.impl.sdk.n.h("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
                if (!mlVarA.c()) {
                    mlVarA.a(true);
                    AppLovinBroadcastManager.registerReceiver(mlVarA, new IntentFilter(str));
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean a(String str) {
        synchronized (this.f20476b) {
            try {
                Iterator it = this.f20475a.iterator();
                while (it.hasNext()) {
                    if (str.equals(((ml) it.next()).b())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        ml mlVarA;
        if (StringUtils.isValidString(str)) {
            synchronized (this.f20476b) {
                mlVarA = a(str, appLovinCommunicatorSubscriber);
            }
            if (mlVarA != null) {
                mlVarA.a(false);
                AppLovinBroadcastManager.unregisterReceiver(mlVarA);
            }
        }
    }
}

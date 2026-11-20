package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.ll;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AppLovinCommunicator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AppLovinCommunicator f17149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f17150f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f17151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f17152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ll f17153c = new ll();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MessagingServiceImpl f17154d = new MessagingServiceImpl();

    private void a(String str) {
        if (this.f17152b == null || !n.a()) {
            return;
        }
        this.f17152b.a("AppLovinCommunicator", str);
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (f17150f) {
            try {
                if (f17149e == null) {
                    f17149e = new AppLovinCommunicator();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f17149e;
    }

    public void a(j jVar) {
        this.f17151a = jVar;
        this.f17152b = jVar.J();
        a("Attached SDK instance: " + jVar + "...");
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f17154d;
    }

    public boolean hasSubscriber(String str) {
        return this.f17153c.a(str);
    }

    public boolean respondsToTopic(String str) {
        return this.f17151a.p().a(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            if (!this.f17153c.a(appLovinCommunicatorSubscriber, str)) {
                a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + str);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.f17151a + '}';
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String str : list) {
            a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + str);
            this.f17153c.b(appLovinCommunicatorSubscriber, str);
        }
    }
}

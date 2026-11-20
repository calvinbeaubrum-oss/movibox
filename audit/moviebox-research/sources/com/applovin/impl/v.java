package com.applovin.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v implements AppLovinCommunicatorSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f23715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23716b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap f23717c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f23718d = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: source.java */
    public class a extends LinkedHashMap {
        public a() {
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void onCreativeIdGenerated(String str, String str2);
    }

    public v(com.applovin.impl.sdk.j jVar) {
        this.f23715a = jVar;
        if (StringUtils.isValidString(b())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.l()).subscribe(this, "safedk_ad_info");
        }
    }

    public static String a() {
        return b("getSdkKey");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, String str, String str2) {
        this.f23715a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23715a.J().a("AdReviewManager", "Notifying Ad Review creative id generated for listener: " + bVar);
        }
        bVar.onCreativeIdGenerated(str, str2);
    }

    public static String b() {
        return b("getVersion");
    }

    private static String b(String str) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.applovin.quality.AppLovinQualityService");
            } catch (Throwable unused) {
                cls = Class.forName("com.safedk.android.SafeDK");
            }
            return (String) cls.getMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused2) {
            return "";
        }
    }

    public Bundle a(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f23716b) {
            bundle = (Bundle) this.f23717c.get(str);
        }
        this.f23715a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23715a.J().a("AdReviewManager", "Retrieved ad info (" + bundle + ") for serve id: " + str);
        }
        return bundle;
    }

    public void a(b bVar) {
        this.f23718d.add(bVar);
    }

    public void b(b bVar) {
        this.f23718d.remove(bVar);
    }

    public void c(String str) {
        this.f23715a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f23715a.J().a("AdReviewManager", "Removing ad info for serve id: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f23716b) {
            this.f23717c.remove(str);
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return v.class.getSimpleName();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle == null) {
                this.f23715a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23715a.J().k("AdReviewManager", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            if (bundle2 == null) {
                this.f23715a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23715a.J().k("AdReviewManager", "Received SafeDK ad info without private data");
                    return;
                }
                return;
            }
            if (MaxAdFormat.formatFromString(bundle2.getString("ad_format")) == null) {
                this.f23715a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23715a.J().k("AdReviewManager", "Received SafeDK ad info without ad format");
                    return;
                }
                return;
            }
            final String string = bundle2.getString("id");
            if (TextUtils.isEmpty(string)) {
                this.f23715a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f23715a.J().k("AdReviewManager", "Received SafeDK ad info without serve id");
                    return;
                }
                return;
            }
            synchronized (this.f23716b) {
                try {
                    this.f23715a.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f23715a.J().a("AdReviewManager", "Storing current SafeDK ad info for serve id: " + string + ", public data: " + bundle);
                    }
                    this.f23717c.put(string, bundle);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            final String string2 = bundle.getString("ad_review_creative_id");
            this.f23715a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f23715a.J().a("AdReviewManager", "Received SafeDK ad info with Ad Review creative id: " + string2);
            }
            if (!StringUtils.isValidString(string2) || this.f23718d.isEmpty()) {
                return;
            }
            HashSet<b> hashSet = new HashSet(this.f23718d);
            this.f23715a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f23715a.J().a("AdReviewManager", "Notifying listeners: " + this.f23718d);
            }
            for (final b bVar : hashSet) {
                this.f23715a.j0().a((yl) new jn(this.f23715a, "creativeIdGenerated", new Runnable() { // from class: com.applovin.impl.e70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f18601a.a(bVar, string, string2);
                    }
                }), tm.b.OTHER);
            }
        }
    }
}

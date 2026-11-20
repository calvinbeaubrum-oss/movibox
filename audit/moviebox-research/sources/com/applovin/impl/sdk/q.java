package com.applovin.impl.sdk;

import android.adservices.measurement.MeasurementManager;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.net.Uri;
import android.os.OutcomeReceiver;
import android.text.TextUtils;
import android.view.InputEvent;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.wh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f22823b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MeasurementManager f22826e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TopicsManager f22829h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f22824c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22825d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference f22827f = new AtomicReference(new JSONArray());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f22828g = new d(this, null);

    /* JADX INFO: compiled from: source.java */
    public class a implements OutcomeReceiver {
        public a() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Failed to register impression", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Successfully registered impression");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements OutcomeReceiver {
        public b() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Failed to register click", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Successfully registered click");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements OutcomeReceiver {
        public c() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Failed to register conversion", exc);
            }
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().a("PrivacySandboxService", "Successfully registered conversion");
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements OutcomeReceiver {
        private d() {
        }

        public /* synthetic */ d(q qVar, a aVar) {
            this();
        }

        public void a(GetTopicsResponse getTopicsResponse) {
            List topics = getTopicsResponse.getTopics();
            int size = topics.size();
            q.this.f22822a.J();
            if (n.a()) {
                q.this.f22822a.J().d("PrivacySandboxService", size + " topic(s) received");
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = topics.iterator();
            while (it.hasNext()) {
                Topic topicA = androidx.privacysandbox.ads.adservices.topics.p.a(it.next());
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putInt(jSONObject, "id", topicA.getTopicId());
                JsonUtils.putLong(jSONObject, "model", topicA.getModelVersion());
                JsonUtils.putLong(jSONObject, "taxonomy", topicA.getTaxonomyVersion());
                jSONArray.put(jSONObject);
            }
            q.this.f22827f.set(jSONArray);
            q.this.b(((Boolean) q.this.f22822a.a(sj.B6)).booleanValue(), ((Long) q.this.f22822a.a(sj.f23115z6)).longValue());
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception exc) {
            String str;
            Long l11 = (Long) q.this.f22822a.a(sj.A6);
            boolean z11 = l11.longValue() == -1;
            q.this.f22822a.J();
            if (n.a()) {
                n nVarJ = q.this.f22822a.J();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to retrieve topics");
                if (z11) {
                    str = "";
                } else {
                    str = ", retrying in " + l11 + " ms";
                }
                sb2.append(str);
                nVarJ.a("PrivacySandboxService", sb2.toString(), exc);
            }
            if (z11) {
                return;
            }
            q.this.b(((Boolean) q.this.f22822a.a(sj.C6)).booleanValue(), l11.longValue());
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onResult(Object obj) {
            a(androidx.privacysandbox.ads.adservices.topics.m.a(obj));
        }
    }

    public q(j jVar) {
        this.f22822a = jVar;
        this.f22823b = jVar.j0().a();
        Context contextL = j.l();
        this.f22826e = b6.j.a(contextL.getSystemService(b6.i.a()));
        this.f22829h = androidx.privacysandbox.ads.adservices.topics.f.a(contextL.getSystemService(androidx.privacysandbox.ads.adservices.topics.e.a()));
        if (((Boolean) jVar.a(sj.f23107y6)).booleanValue()) {
            b(((Boolean) jVar.a(sj.B6)).booleanValue(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(GetTopicsRequest getTopicsRequest) {
        this.f22829h.getTopics(getTopicsRequest, this.f22823b, this.f22828g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (TextUtils.isEmpty(str) || this.f22826e == null || !wh.e(j.f22564w0)) {
            return;
        }
        this.f22822a.J();
        if (n.a()) {
            this.f22822a.J().a("PrivacySandboxService", "Registering conversion: " + str);
        }
        this.f22826e.registerTrigger(Uri.parse(str), this.f22823b, new c());
    }

    private void a(String str, Runnable runnable) {
        try {
            this.f22822a.J();
            if (n.a()) {
                this.f22822a.J().a("PrivacySandboxService", "Running operation: " + str);
            }
            runnable.run();
        } catch (Throwable th2) {
            this.f22822a.J();
            if (n.a()) {
                this.f22822a.J().a("PrivacySandboxService", "Failed to run operation: " + str, th2);
            }
            if (c(str)) {
                this.f22822a.E().a("PrivacySandboxService", str, th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list) {
        if (list == null || list.isEmpty() || this.f22826e == null || !wh.e(j.f22564w0)) {
            return;
        }
        this.f22822a.J();
        if (n.a()) {
            this.f22822a.J().a("PrivacySandboxService", "Registering impression...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f22826e.registerSource(Uri.parse((String) it.next()), null, this.f22823b, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, InputEvent inputEvent) {
        if (list == null || list.isEmpty() || this.f22826e == null || !wh.e(j.f22564w0)) {
            return;
        }
        this.f22822a.J();
        if (n.a()) {
            this.f22822a.J().a("PrivacySandboxService", "Registering click...");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f22826e.registerSource(Uri.parse((String) it.next()), inputEvent, this.f22823b, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z11, long j11) {
        if (this.f22829h == null) {
            return;
        }
        final GetTopicsRequest getTopicsRequestBuild = androidx.privacysandbox.ads.adservices.topics.h.a().setShouldRecordObservation(z11).setAdsSdkName("AppLovin").build();
        if (j11 <= 0) {
            this.f22829h.getTopics(getTopicsRequestBuild, this.f22823b, this.f22828g);
        } else {
            this.f22822a.j0().a(new jn(this.f22822a, true, "getTopics", new Runnable() { // from class: com.applovin.impl.sdk.o1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22817a.a(getTopicsRequestBuild);
                }
            }), tm.b.OTHER, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z11, final long j11) {
        a("retrieve topics", new Runnable() { // from class: com.applovin.impl.sdk.k1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22643a.a(z11, j11);
            }
        });
    }

    private boolean c(String str) {
        synchronized (this.f22825d) {
            try {
                if (this.f22824c.contains(str)) {
                    return false;
                }
                this.f22824c.add(str);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public JSONArray a() {
        return (JSONArray) this.f22827f.get();
    }

    public void b(final String str) {
        a("register conversion trigger event", new Runnable() { // from class: com.applovin.impl.sdk.m1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22667a.a(str);
            }
        });
    }

    public void b(final List list) {
        a("register impression", new Runnable() { // from class: com.applovin.impl.sdk.l1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22652a.a(list);
            }
        });
    }

    public void b(final List list, final InputEvent inputEvent) {
        a("register click", new Runnable() { // from class: com.applovin.impl.sdk.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22673a.a(list, inputEvent);
            }
        });
    }
}

package com.facebook.biddingkit.logging;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class EventLogDispatcher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile EventLogDispatcher f32456g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32457a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f32462f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f32458b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadPoolExecutor f32461e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f32459c = new Runnable() { // from class: com.facebook.biddingkit.logging.EventLogDispatcher.1
        @Override // java.lang.Runnable
        public void run() {
            EventLogDispatcher.this.g();
            EventLogDispatcher.this.f32458b.postDelayed(EventLogDispatcher.this.f32460d, EventLogDispatcher.this.f32457a);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f32460d = new Runnable() { // from class: com.facebook.biddingkit.logging.EventLogDispatcher.2
        @Override // java.lang.Runnable
        public void run() {
            if (EventLogDispatcher.this.f32461e.getQueue().isEmpty()) {
                EventLogDispatcher.this.f32461e.execute(EventLogDispatcher.this.f32459c);
            }
        }
    };

    public static EventLogDispatcher h() {
        if (f32456g == null) {
            synchronized (EventLogDispatcher.class) {
                try {
                    if (f32456g == null) {
                        f32456g = new EventLogDispatcher();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f32456g;
    }

    public static void j(i iVar) {
        h().i(iVar);
        h().k();
    }

    @SuppressLint({"CatchGeneralException"})
    public final void g() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            List<e> listE = f.e(10);
            if (listE != null && !listE.isEmpty()) {
                Iterator<e> it = listE.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().m());
                }
                jSONObject.put("tokens", a.a());
                jSONObject.put("events", jSONArray);
                uf.e eVarB = vf.b.b(this.f32462f.b(), 2000, jSONObject.toString());
                if (eVarB == null || eVarB.c() != 200) {
                    this.f32457a = this.f32462f.c();
                } else {
                    this.f32457a = this.f32462f.a();
                }
                Iterator<e> it2 = listE.iterator();
                while (it2.hasNext()) {
                    f.b(it2.next().k());
                }
            }
        } catch (Throwable th2) {
            b.b("EventLogDispatcher", "Failed dispatching events", th2);
        }
    }

    public void i(i iVar) {
        this.f32462f = iVar;
        this.f32457a = iVar.a();
    }

    public void k() {
        this.f32458b.postDelayed(this.f32460d, this.f32457a);
    }
}

package com.cloud.tmc.fps;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.cloud.tmc.fps.data.StackTraceData;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.miniutils.util.g;
import com.google.gson.Gson;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ReportManager implements ra.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f30358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentLinkedQueue<StackTraceElement[]> f30359b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f30360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f30361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f30362e;

    public ReportManager() {
        Boolean bool = Boolean.FALSE;
        this.f30360c = bool;
        this.f30361d = bool;
        this.f30362e = new Runnable() { // from class: com.cloud.tmc.fps.ReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                if (ReportManager.this.f30361d.booleanValue()) {
                    ReportManager.this.f30359b.clear();
                }
                ReportManager.this.f30359b.add(stackTrace);
                ReportManager.this.f30361d = Boolean.FALSE;
                ReportManager.this.f30358a.postDelayed(this, a.f30363a.c());
            }
        };
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName());
        handlerThread.start();
        this.f30358a = new Handler(handlerThread.getLooper());
    }

    @Override // ra.a
    public void a(long j11, long j12) {
        if (this.f30360c.booleanValue()) {
            this.f30358a.removeCallbacks(this.f30362e);
            h(j11, Long.valueOf(j12));
            this.f30361d = Boolean.TRUE;
            this.f30358a.postDelayed(this.f30362e, a.f30363a.c());
        }
    }

    @Override // ra.a
    public void b(boolean z11) {
        this.f30360c = Boolean.valueOf(z11);
    }

    public final void h(long j11, Long l11) {
        if (l11.longValue() <= a.f30363a.b() || this.f30359b.size() <= 0) {
            return;
        }
        this.f30358a.post(new Runnable() { // from class: com.cloud.tmc.fps.ReportManager.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                Iterator it = ReportManager.this.f30359b.iterator();
                while (it.hasNext()) {
                    String strC = g.c(ReportManager.this.i(2, (StackTraceElement[]) it.next()).getBytes(StandardCharsets.UTF_8));
                    int count = 0;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= arrayList.size()) {
                            i11 = -1;
                            break;
                        } else {
                            if (strC.equals(((StackTraceData) arrayList.get(i11)).getStackInfo())) {
                                count = ((StackTraceData) arrayList.get(i11)).getCount();
                                break;
                            }
                            i11++;
                        }
                    }
                    if (count == 0 || i11 <= -1) {
                        arrayList.add(new StackTraceData(1, strC));
                    } else {
                        ((StackTraceData) arrayList.get(i11)).setCount(((StackTraceData) arrayList.get(i11)).getCount() + 1);
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putString("fps_drop_stackInfo", new Gson().toJson(arrayList));
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record("", PointAnalyseType.POINT_FPS, "", bundle);
                ReportManager.this.f30359b.clear();
            }
        });
    }

    public final String i(int i11, Object[] objArr) {
        if (objArr.length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < objArr.length - i11 && i12 != (objArr.length - i11) - 1; i12++) {
            sb2.append(objArr[i12]);
            sb2.append("\n");
        }
        return sb2.toString();
    }
}

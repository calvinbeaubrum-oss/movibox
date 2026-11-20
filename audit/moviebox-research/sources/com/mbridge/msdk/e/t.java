package com.mbridge.msdk.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.hisavana.common.constant.ComConstants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile t f43941d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f43943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w f43944c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f43945e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43946f = ComConstants.AD_TIMEOUT_MILLIS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, String> f43947g = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f43942a = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.e.t.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                t.this.c();
                t.this.f43942a.removeMessages(1);
                t.this.d();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    };

    private t() {
    }

    public static t a() {
        if (f43941d == null) {
            synchronized (t.class) {
                try {
                    if (f43941d == null) {
                        f43941d = new t();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43941d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f43942a.sendEmptyMessageDelayed(1, this.f43946f);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(Context context, w wVar, int i11, JSONObject jSONObject) {
        this.f43944c = wVar;
        this.f43946f = i11;
        m mVarA = m.a("monitor", context, wVar);
        this.f43943b = mVarA;
        if (mVarA != null) {
            mVarA.a(jSONObject);
            this.f43943b.a();
        }
        b();
    }

    public final synchronized void b() {
        if (this.f43945e) {
            return;
        }
        this.f43945e = true;
        d();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005a A[Catch: Exception -> 0x0058, TRY_LEAVE, TryCatch #0 {Exception -> 0x0058, blocks: (B:5:0x0008, B:7:0x000d, B:9:0x001b, B:12:0x002e, B:15:0x003a, B:20:0x005a, B:25:0x00a6, B:22:0x0072), top: B:29:0x0008, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x005a, please report this as an issue */
    public final void c() {
        m[] mVarArrD = m.d();
        if (mVarArrD.length == 0) {
            return;
        }
        try {
            for (m mVar : mVarArrD) {
                String strC = mVar.c();
                if (!"monitor".equals(strC)) {
                    String strB = mVar.b();
                    long[] jArrG = mVar.g();
                    long j11 = jArrG[1];
                    if (j11 != 0) {
                        long j12 = jArrG[0];
                        if (this.f43947g.containsKey(strC)) {
                            if (!(j12 + "").equals(this.f43947g.get(strC))) {
                                this.f43947g.put(strC, j12 + "");
                                if (this.f43943b != null) {
                                    try {
                                        e eVar = new e("event_lib_monitor");
                                        eVar.b(1);
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("key", "m_report_rate");
                                        jSONObject.put("task_name", strC);
                                        jSONObject.put("task_count", j11);
                                        jSONObject.put("task_session_id", strB);
                                        jSONObject.put("task_ts", j12);
                                        eVar.a(jSONObject);
                                        this.f43943b.a(eVar);
                                    } catch (Exception e11) {
                                        e11.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            this.f43947g.put(strC, j12 + "");
                            if (this.f43943b != null) {
                                e eVar2 = new e("event_lib_monitor");
                                eVar2.b(1);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("key", "m_report_rate");
                                jSONObject2.put("task_name", strC);
                                jSONObject2.put("task_count", j11);
                                jSONObject2.put("task_session_id", strB);
                                jSONObject2.put("task_ts", j12);
                                eVar2.a(jSONObject2);
                                this.f43943b.a(eVar2);
                            }
                        }
                    }
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }
}

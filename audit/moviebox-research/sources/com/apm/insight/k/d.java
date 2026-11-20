package com.apm.insight.k;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.p;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile d f16886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f16887b;

    private d(@NonNull Context context) {
        this.f16887b = context;
    }

    public static d a() {
        if (f16886a == null) {
            f16886a = new d(com.apm.insight.e.g());
        }
        return f16886a;
    }

    public static boolean a(JSONObject jSONObject, File file, File file2) {
        try {
            return e.a(e.g(), jSONObject.toString(), file, file2, p.a(System.currentTimeMillis()), new File(com.apm.insight.h.b.a())).a();
        } catch (Throwable th2) {
            com.apm.insight.a.b(th2);
            return false;
        }
    }

    public final void a(JSONObject jSONObject, long j11, boolean z11) {
        File[] fileArr;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strC = e.c();
            int i11 = 0;
            File file = new File(com.apm.insight.l.j.a(this.f16887b), com.apm.insight.e.a(j11, CrashType.ANR, false, false));
            com.apm.insight.l.f.a(file, file.getName(), strC, jSONObject, e.b());
            if (z11 && !Npth.isStopUpload()) {
                jSONObject.put("upload_scene", DevicePublicKeyStringDef.DIRECT);
                jSONObject.put("crash_uuid", file.getName());
                if (com.apm.insight.runtime.a.h()) {
                    HashMap<String, p.a> mapA = p.a(j11, "anr_trace");
                    fileArr = new File[mapA.size() + 2];
                    for (Map.Entry<String, p.a> entry : mapA.entrySet()) {
                        if (!entry.getKey().equals(com.apm.insight.l.a.d(this.f16887b))) {
                            fileArr[i11] = com.apm.insight.l.j.a(this.f16887b, entry.getValue().f17107a);
                            i11++;
                        }
                    }
                } else {
                    fileArr = new File[2];
                }
                fileArr[fileArr.length - 1] = com.apm.insight.l.j.a(this.f16887b, com.apm.insight.e.f());
                fileArr[fileArr.length - 2] = p.a(j11);
                if (e.a(strC, jSONObject.toString(), fileArr).a()) {
                    com.apm.insight.l.f.a(file);
                    if (Npth.hasCrash()) {
                        return;
                    }
                    com.apm.insight.l.f.a(com.apm.insight.l.j.e(com.apm.insight.e.g()));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String strC = e.c();
                File file = new File(com.apm.insight.l.j.a(this.f16887b), com.apm.insight.l.j.a(com.apm.insight.e.e()));
                com.apm.insight.l.f.a(file, file.getName(), strC, jSONObject, e.a());
                jSONObject.put("upload_scene", DevicePublicKeyStringDef.DIRECT);
                if (!e.b(strC, jSONObject.toString()).a()) {
                    return false;
                }
                com.apm.insight.l.f.a(file);
                return true;
            } catch (Throwable th2) {
                com.apm.insight.a.b(th2);
            }
        }
        return false;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        try {
            String strF = e.f();
            File file = new File(com.apm.insight.l.j.a(this.f16887b), com.apm.insight.l.j.c());
            com.apm.insight.l.f.a(file, file.getName(), strF, jSONObject, e.b());
            if (e.a(strF, jSONObject.toString()).a()) {
                com.apm.insight.l.f.a(file);
            }
        } catch (Throwable th2) {
            com.apm.insight.a.b(th2);
        }
    }

    public final void c(final JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        n.a().a(new Runnable() { // from class: com.apm.insight.k.d.1
            @Override // java.lang.Runnable
            public final void run() {
                String strC = e.c();
                try {
                    jSONObject.put("upload_scene", DevicePublicKeyStringDef.DIRECT);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
                e.b(strC, jSONObject.toString());
            }
        });
    }
}

package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class tj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f23380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f23381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SharedPreferences f23382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f23383d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f23384e = new Object();

    public tj(com.applovin.impl.sdk.j jVar) {
        this.f23380a = jVar;
        Context contextL = com.applovin.impl.sdk.j.l();
        this.f23381b = contextL;
        this.f23382c = contextL.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(sj.class.getName());
            Class.forName(ve.class.getName());
        } catch (Throwable unused) {
        }
        d();
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Double) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    private String b() {
        return "com.applovin.sdk." + yp.e(this.f23380a.b0()) + InstructionFileId.DOT;
    }

    public sj a(String str, sj sjVar) {
        synchronized (this.f23384e) {
            try {
                for (sj sjVar2 : sj.c()) {
                    if (sjVar2.b().equals(str)) {
                        return sjVar2;
                    }
                }
                return sjVar;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Object a(sj sjVar) {
        if (sjVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.f23384e) {
            try {
                Object obj = this.f23383d.get(sjVar.b());
                if (obj == null) {
                    return sjVar.a();
                }
                return sjVar.a(obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a() {
        synchronized (this.f23384e) {
            this.f23383d.clear();
        }
        this.f23380a.a(this.f23382c);
    }

    public void a(sj sjVar, Object obj) {
        if (sjVar == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        }
        synchronized (this.f23384e) {
            this.f23383d.put(sjVar.b(), obj);
        }
    }

    public void a(JSONObject jSONObject) {
        synchronized (this.f23384e) {
            try {
                boolean zBooleanValue = JsonUtils.getBoolean(jSONObject, sj.D.b(), Boolean.FALSE).booleanValue();
                HashMap map = zBooleanValue ? new HashMap() : null;
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && next.length() > 0) {
                        try {
                            sj sjVarA = a(next, (sj) null);
                            if (sjVarA != null) {
                                Object objA = zBooleanValue ? a(sjVarA) : null;
                                Object objA2 = a(next, jSONObject, sjVarA.a());
                                this.f23383d.put(sjVarA.b(), objA2);
                                if (sjVarA == sj.C5) {
                                    this.f23383d.put(sj.D5.b(), Long.valueOf(System.currentTimeMillis()));
                                }
                                if (zBooleanValue && !objA2.equals(objA)) {
                                    map.put(sjVarA, objA);
                                }
                            }
                        } catch (JSONException e11) {
                            com.applovin.impl.sdk.n.c("SettingsManager", "Unable to parse JSON settingsValues array", e11);
                            this.f23380a.E().a("SettingsManager", "loadSettingsException", e11);
                        } catch (Throwable th2) {
                            com.applovin.impl.sdk.n.c("SettingsManager", "Unable to convert setting object ", th2);
                            this.f23380a.E().a("SettingsManager", "loadSettingsThrowable", th2);
                        }
                    }
                }
                if (zBooleanValue && map.size() > 0) {
                    qc qcVar = new qc();
                    qcVar.a("========== UPDATED SETTINGS ==========");
                    for (sj sjVar : map.keySet()) {
                        qcVar.a(sjVar.b(), a(sjVar) + " (" + map.get(sjVar) + ")");
                    }
                    qcVar.a("========== END ==========");
                    this.f23380a.J();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f23380a.J().a("SettingsManager", qcVar.toString());
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public List b(sj sjVar) {
        ArrayList arrayList = new ArrayList(6);
        Iterator it = c(sjVar).iterator();
        while (it.hasNext()) {
            arrayList.add(MaxAdFormat.formatFromString((String) it.next()));
        }
        return arrayList;
    }

    public List c(sj sjVar) {
        return CollectionUtils.explode((String) a(sjVar));
    }

    public boolean c() {
        return this.f23380a.g0().isVerboseLoggingEnabled() || ((Boolean) a(sj.f22996l)).booleanValue();
    }

    public void d() {
        String strB = b();
        synchronized (this.f23384e) {
            try {
                for (sj sjVar : sj.c()) {
                    try {
                        Object objA = this.f23380a.a(strB + sjVar.b(), null, sjVar.a().getClass(), this.f23382c);
                        if (objA != null) {
                            this.f23383d.put(sjVar.b(), objA);
                        }
                    } catch (Throwable th2) {
                        com.applovin.impl.sdk.n.c("SettingsManager", "Unable to load \"" + sjVar.b() + "\"", th2);
                        this.f23380a.E().a("SettingsManager", "initSettings", th2);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public void e() {
        String strB = b();
        synchronized (this.f23384e) {
            try {
                SharedPreferences.Editor editorEdit = this.f23382c.edit();
                for (sj sjVar : sj.c()) {
                    Object obj = this.f23383d.get(sjVar.b());
                    if (obj != null) {
                        this.f23380a.a(strB + sjVar.b(), obj, editorEdit);
                    }
                }
                editorEdit.apply();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

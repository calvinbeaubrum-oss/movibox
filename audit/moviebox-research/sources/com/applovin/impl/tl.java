package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class tl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f23388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23389b = new Object();

    public tl(JSONObject jSONObject) {
        this.f23388a = jSONObject;
    }

    public double a(String str, double d11) {
        double d12;
        synchronized (this.f23389b) {
            d12 = JsonUtils.getDouble(this.f23388a, str, d11);
        }
        return d12;
    }

    public float a(String str, float f11) {
        float f12;
        synchronized (this.f23389b) {
            f12 = JsonUtils.getFloat(this.f23388a, str, f11);
        }
        return f12;
    }

    public int a(String str, int i11) {
        int i12;
        synchronized (this.f23389b) {
            i12 = JsonUtils.getInt(this.f23388a, str, i11);
        }
        return i12;
    }

    public long a(String str, long j11) {
        long j12;
        synchronized (this.f23389b) {
            j12 = JsonUtils.getLong(this.f23388a, str, j11);
        }
        return j12;
    }

    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f23389b) {
            bool2 = JsonUtils.getBoolean(this.f23388a, str, bool);
        }
        return bool2;
    }

    public Object a(j1.a aVar) {
        Object objApply;
        synchronized (this.f23389b) {
            objApply = aVar.apply(this);
        }
        return objApply;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.f23389b) {
            string = JsonUtils.getString(this.f23388a, str, str2);
        }
        return string;
    }

    public List a(String str, List list) {
        List<Integer> integerList;
        synchronized (this.f23389b) {
            integerList = JsonUtils.getIntegerList(this.f23388a, str, list);
        }
        return integerList;
    }

    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f23389b) {
            jSONArray2 = JsonUtils.getJSONArray(this.f23388a, str, jSONArray);
        }
        return jSONArray2;
    }

    public JSONObject a() {
        JSONObject jSONObjectDeepCopy;
        synchronized (this.f23389b) {
            jSONObjectDeepCopy = JsonUtils.deepCopy(this.f23388a);
        }
        return jSONObjectDeepCopy;
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f23389b) {
            jSONObject2 = JsonUtils.getJSONObject(this.f23388a, str, jSONObject);
        }
        return jSONObject2;
    }

    public void a(androidx.core.util.a aVar) {
        synchronized (this.f23389b) {
            aVar.accept(this);
        }
    }

    public void a(String str, Object obj) {
        synchronized (this.f23389b) {
            JsonUtils.putObject(this.f23388a, str, obj);
        }
    }

    public void a(String str, boolean z11) {
        synchronized (this.f23389b) {
            JsonUtils.putBoolean(this.f23388a, str, z11);
        }
    }

    public boolean a(String str) {
        boolean zHas;
        synchronized (this.f23389b) {
            zHas = this.f23388a.has(str);
        }
        return zHas;
    }

    public Object b(String str) {
        Object objOpt;
        synchronized (this.f23389b) {
            objOpt = this.f23388a.opt(str);
        }
        return objOpt;
    }

    public List b(String str, List list) {
        List<String> stringList;
        synchronized (this.f23389b) {
            stringList = JsonUtils.getStringList(this.f23388a, str, list);
        }
        return stringList;
    }

    public void b(String str, int i11) {
        synchronized (this.f23389b) {
            JsonUtils.putInt(this.f23388a, str, i11);
        }
    }

    public void b(String str, long j11) {
        synchronized (this.f23389b) {
            JsonUtils.putLong(this.f23388a, str, j11);
        }
    }

    public void b(String str, String str2) {
        synchronized (this.f23389b) {
            JsonUtils.putString(this.f23388a, str, str2);
        }
    }

    public void c(String str) {
        synchronized (this.f23389b) {
            this.f23388a.remove(str);
        }
    }

    public String toString() {
        String string;
        synchronized (this.f23389b) {
            string = this.f23388a.toString();
        }
        return string;
    }
}

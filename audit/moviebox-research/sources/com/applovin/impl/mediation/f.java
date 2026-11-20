package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.ge;
import com.applovin.impl.pe;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f20977c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f20975a = Collections.synchronizedMap(new HashMap(16));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f20978d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f20979e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f20980f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f20981g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f20982h = new HashSet();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20983a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20984b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdFormat f20985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JSONObject f20986d;

        public a(String str, String str2, ge geVar, com.applovin.impl.sdk.j jVar) {
            this.f20983a = str;
            this.f20984b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f20986d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (geVar == null) {
                this.f20985c = null;
            } else {
                this.f20985c = geVar.getFormat();
                JsonUtils.putString(jSONObject, "format", geVar.getFormat().getLabel());
            }
        }

        public JSONObject a() {
            return this.f20986d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f20983a.equals(aVar.f20983a) || !this.f20984b.equals(aVar.f20984b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f20985c;
            MaxAdFormat maxAdFormat2 = aVar.f20985c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int iHashCode = ((this.f20983a.hashCode() * 31) + this.f20984b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f20985c;
            return iHashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f20983a + "', operationTag='" + this.f20984b + "', format=" + this.f20985c + '}';
        }
    }

    public f(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f20976b = jVar;
        this.f20977c = jVar.J();
    }

    private g a(pe peVar, Class cls, boolean z11) {
        try {
            return new g(peVar, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.f20976b.s0()), z11, this.f20976b);
        } catch (Throwable th2) {
            com.applovin.impl.sdk.n.c("MediationAdapterManager", "Failed to load adapter: " + peVar, th2);
            return null;
        }
    }

    private Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            com.applovin.impl.sdk.n.h("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public g a(pe peVar) {
        return a(peVar, false);
    }

    public g a(pe peVar, boolean z11) {
        Class clsA;
        g gVar;
        if (peVar == null) {
            throw new IllegalArgumentException("No adapter spec specified");
        }
        String strC = peVar.c();
        String strB = peVar.b();
        if (TextUtils.isEmpty(strC)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20977c.b("MediationAdapterManager", "No adapter name provided for " + strB + ", not loading the adapter ");
            }
            return null;
        }
        if (TextUtils.isEmpty(strB)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f20977c.b("MediationAdapterManager", "Unable to find default className for '" + strC + "'");
            }
            return null;
        }
        if (z11 && (gVar = (g) this.f20975a.get(strB)) != null) {
            return gVar;
        }
        synchronized (this.f20978d) {
            try {
                if (this.f20980f.contains(strB)) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20977c.a("MediationAdapterManager", "Not attempting to load " + strC + " due to prior errors");
                    }
                    return null;
                }
                if (this.f20979e.containsKey(strB)) {
                    clsA = (Class) this.f20979e.get(strB);
                } else {
                    clsA = a(strB);
                    if (clsA == null) {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f20977c.k("MediationAdapterManager", "Adapter " + strC + " could not be loaded, class " + strB + " not found");
                        }
                        this.f20980f.add(strB);
                        return null;
                    }
                }
                g gVarA = a(peVar, clsA, z11);
                if (gVarA == null) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f20977c.b("MediationAdapterManager", "Failed to load " + strC);
                    }
                    this.f20980f.add(strB);
                    return null;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20977c.a("MediationAdapterManager", "Loaded " + strC);
                }
                this.f20979e.put(strB, clsA);
                if (z11) {
                    this.f20975a.put(peVar.b(), gVarA);
                }
                return gVarA;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Collection a() {
        ArrayList arrayList;
        synchronized (this.f20981g) {
            try {
                arrayList = new ArrayList(this.f20982h.size());
                Iterator it = this.f20982h.iterator();
                while (it.hasNext()) {
                    arrayList.add(((a) it.next()).a());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public void a(String str, String str2, ge geVar) {
        synchronized (this.f20981g) {
            try {
                this.f20976b.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f20976b.J().b("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
                }
                this.f20982h.add(new a(str, str2, geVar, this.f20976b));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Collection b() {
        Set setUnmodifiableSet;
        synchronized (this.f20978d) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f20980f);
        }
        return setUnmodifiableSet;
    }

    public Collection c() {
        Set setUnmodifiableSet;
        synchronized (this.f20978d) {
            try {
                HashSet hashSet = new HashSet(this.f20979e.size());
                Iterator it = this.f20979e.values().iterator();
                while (it.hasNext()) {
                    hashSet.add(((Class) it.next()).getName());
                }
                setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return setUnmodifiableSet;
    }
}

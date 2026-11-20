package com.applovin.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qn implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f21956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f21957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f21958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f21959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f21960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f21961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f21962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f21963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f21964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f21965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f21966k;

    public qn(com.applovin.impl.sdk.j jVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.j.l());
        this.f21957b = defaultSharedPreferences;
        this.f21966k = new ArrayList();
        this.f21956a = jVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.f21958c = a(uj.f23599p.a());
        this.f21959d = a(uj.f23600q.a());
        this.f21960e = h();
        this.f21961f = (String) vj.a(uj.f23602s, (Object) null, defaultSharedPreferences, false);
        this.f21962g = (String) vj.a(uj.f23603t, (Object) null, defaultSharedPreferences, false);
        this.f21963h = (String) vj.a(uj.f23604u, (Object) null, defaultSharedPreferences, false);
        this.f21964i = (String) vj.a(uj.f23606w, (Object) null, defaultSharedPreferences, false);
        this.f21965j = (String) vj.a(uj.f23608y, (Object) null, defaultSharedPreferences, false);
        c(this.f21962g);
    }

    private Integer a(String str) {
        if (this.f21957b.contains(str)) {
            Integer num = (Integer) vj.a(str, null, Integer.class, this.f21957b, false);
            if (num != null) {
                return num;
            }
            Long l11 = (Long) vj.a(str, null, Long.class, this.f21957b, false);
            if (l11 != null && l11.longValue() >= -2147483648L && l11.longValue() <= 2147483647L) {
                return Integer.valueOf(l11.intValue());
            }
            String str2 = (String) vj.a(str, null, String.class, this.f21957b, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.f21956a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21956a.J().b("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    private String a(String str, Object obj) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\n");
        sb2.append(str);
        sb2.append(" - ");
        sb2.append(obj != null ? obj.toString() : "No value set");
        return sb2.toString();
    }

    private void a() {
        this.f21958c = null;
        this.f21960e = null;
        this.f21961f = null;
        this.f21962g = null;
        this.f21963h = null;
        Iterator it = this.f21966k.iterator();
        while (it.hasNext()) {
            ((rn) it.next()).a(null);
        }
    }

    private void b(String str) {
        for (rn rnVar : this.f21966k) {
            if (rnVar.f() == rn.a.ATP_NETWORK && rnVar.d() != null) {
                rnVar.a(tn.a(rnVar.d().intValue(), str));
            }
        }
    }

    private void c(String str) {
        this.f21956a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f21956a.J().a("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        }
        Boolean boolA = tn.a(1301, str);
        if (boolA == null) {
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
                return;
            }
            return;
        }
        if (boolA.booleanValue()) {
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
            }
            a4.b(true, com.applovin.impl.sdk.j.l());
        } else {
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
            }
            a4.b(false, com.applovin.impl.sdk.j.l());
        }
        this.f21956a.M0();
    }

    private void d(String str) {
        if (str == null) {
            Iterator it = this.f21966k.iterator();
            while (it.hasNext()) {
                ((rn) it.next()).a(null);
            }
        } else {
            for (rn rnVar : this.f21966k) {
                if (rnVar.f() == rn.a.TCF_VENDOR && rnVar.d() != null) {
                    rnVar.a(Boolean.valueOf(tn.a(str, rnVar.d().intValue() - 1)));
                }
            }
        }
    }

    private Integer h() {
        String strA = uj.f23601r.a();
        if (this.f21957b.contains(strA)) {
            Integer num = (Integer) vj.a(strA, null, Integer.class, this.f21957b, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.f21956a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21956a.J().b("TcfManager", "Integer value (" + num + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l11 = (Long) vj.a(strA, null, Long.class, this.f21957b, false);
            if (l11 != null) {
                if (l11.longValue() == 1 || l11.longValue() == 0) {
                    return Integer.valueOf(l11.intValue());
                }
                this.f21956a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21956a.J().b("TcfManager", "Long value (" + l11 + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) vj.a(strA, null, Boolean.class, this.f21957b, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) vj.a(strA, null, String.class, this.f21957b, false);
            if (str != null) {
                if ("1".equals(str) || "true".equals(str)) {
                    return 1;
                }
                if ("0".equals(str) || "false".equals(str)) {
                    return 0;
                }
                this.f21956a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21956a.J().b("TcfManager", "String value (" + str + ") for " + strA + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    public Boolean a(int i11) {
        return tn.a(i11, this.f21962g);
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f21966k.add(((ke) it.next()).t());
        }
        d(this.f21963h);
        b(this.f21962g);
    }

    public Boolean b(int i11) {
        String str = this.f21964i;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i11 - 1));
    }

    public boolean b() {
        return tn.a(this.f21962g);
    }

    public Boolean c(int i11) {
        String str = this.f21965j;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i11 - 1));
    }

    public String c() {
        return this.f21962g;
    }

    public Boolean d(int i11) {
        String str = this.f21963h;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(tn.a(str, i11 - 1));
    }

    public String d() {
        return on.a(this.f21958c);
    }

    public Integer e() {
        return this.f21958c;
    }

    public Integer f() {
        return this.f21959d;
    }

    public Integer g() {
        return this.f21960e;
    }

    public List i() {
        return this.f21966k;
    }

    public String j() {
        return a("CMP Name", d()) + a("CMP SDK ID", this.f21958c) + a("CMP SDK Version", this.f21959d) + a(uj.f23601r.a(), this.f21960e) + a(uj.f23602s.a(), this.f21961f) + a(uj.f23603t.a(), this.f21962g);
    }

    public String k() {
        return this.f21961f;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            a();
            return;
        }
        if (str.equals(uj.f23599p.a())) {
            this.f21958c = a(str);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21958c);
            }
            this.f21956a.M0();
            return;
        }
        if (str.equals(uj.f23600q.a())) {
            this.f21959d = a(str);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21959d);
                return;
            }
            return;
        }
        if (str.equals(uj.f23601r.a())) {
            this.f21960e = h();
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21960e);
                return;
            }
            return;
        }
        if (str.equals(uj.f23602s.a())) {
            this.f21961f = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21961f);
            }
            this.f21956a.M0();
            return;
        }
        if (str.equals(uj.f23603t.a())) {
            this.f21962g = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21962g);
            }
            c(this.f21962g);
            b(this.f21962g);
            return;
        }
        if (str.equals(uj.f23604u.a())) {
            this.f21963h = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21963h);
            }
            d(this.f21963h);
            return;
        }
        if (str.equals(uj.f23605v.a())) {
            String str2 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(uj.f23606w.a())) {
            this.f21964i = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21964i);
                return;
            }
            return;
        }
        if (str.equals(uj.f23607x.a())) {
            String str3 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(uj.f23608y.a())) {
            this.f21965j = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f21965j);
                return;
            }
            return;
        }
        if (str.contains("IABTCF_PublisherRestrictions")) {
            String str4 = (String) vj.a(str, (Object) null, String.class, sharedPreferences);
            this.f21956a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21956a.J().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        }
    }
}

package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AppLovinAdLoadListener f24893h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a f24894i;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends eq {
        public a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
            super(jSONObject, jSONObject2, jVar);
        }

        public void a(es esVar) {
            if (esVar == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.f18763b.add(esVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f24895j;

        public b(String str, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            this.f24895j = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            es esVarB = b(this.f24895j);
            if (esVarB != null) {
                a(esVarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to process XML: " + this.f24895j);
            }
            c(this.f24895j);
            a(fq.XML_PARSING);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final JSONObject f24896j;

        public c(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            this.f24896j = eqVar.b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.f24896j, "xml", null);
            if (!StringUtils.isValidString(string)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "No VAST response received.");
                }
                a(fq.NO_WRAPPER_RESPONSE);
                return;
            }
            if (string.length() >= ((Integer) this.f24689a.a(sj.M4)).intValue()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "VAST response is over max length");
                }
                a(fq.XML_PARSING);
                return;
            }
            es esVarB = b(string);
            if (esVarB != null) {
                a(esVarB);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to process XML: " + string);
            }
            c(string);
            a(fq.XML_PARSING);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends zm {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final es f24897j;

        public d(es esVar, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
            super(eqVar, appLovinAdLoadListener, jVar);
            if (esVar == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (eqVar == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.f24897j = esVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Processing VAST Wrapper response...");
            }
            a(this.f24897j);
        }
    }

    public zm(eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessVastResponse", jVar);
        if (eqVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f24893h = appLovinAdLoadListener;
        this.f24894i = (a) eqVar;
    }

    public static zm a(es esVar, eq eqVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new d(esVar, eqVar, appLovinAdLoadListener, jVar);
    }

    public static zm a(String str, JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new b(str, new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    public static zm a(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        return new c(new a(jSONObject, jSONObject2, jVar), appLovinAdLoadListener, jVar);
    }

    public void a(es esVar) {
        int iD = this.f24894i.d();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Finished parsing XML at depth " + iD);
        }
        this.f24894i.a(esVar);
        if (!mq.b(esVar)) {
            if (!mq.a(esVar)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "VAST response is an error");
                }
                a(fq.NO_WRAPPER_RESPONSE);
                return;
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "VAST response is inline. Rendering ad...");
                }
                this.f24689a.j0().a(new cn(this.f24894i, this.f24893h, this.f24689a));
                return;
            }
        }
        int iIntValue = ((Integer) this.f24689a.a(sj.N4)).intValue();
        if (iD < iIntValue) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "VAST response is wrapper. Resolving...");
            }
            this.f24689a.j0().a(new hn(this.f24894i, this.f24893h, this.f24689a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Reached beyond max wrapper depth of " + iIntValue);
        }
        a(fq.WRAPPER_LIMIT_REACHED);
    }

    public void a(fq fqVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Failed to process VAST response due to VAST error code " + fqVar);
        }
        mq.a(this.f24894i, this.f24893h, fqVar, -6, this.f24689a);
    }

    public es b(String str) {
        try {
            return fs.a(str, this.f24689a);
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to process VAST response", th2);
            }
            a(fq.XML_PARSING);
            return null;
        }
    }

    public void c(String str) {
        if (str == null) {
            return;
        }
        Iterator<String> it = StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f24689a.a(sj.f22962g5)), 1).iterator();
        while (it.hasNext()) {
            es esVarB = b("<VAST>" + it.next() + "</VAST>");
            if (esVarB != null) {
                this.f24894i.a(esVarB);
            }
        }
    }
}

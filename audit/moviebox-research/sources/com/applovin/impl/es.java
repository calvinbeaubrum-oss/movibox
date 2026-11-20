package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class es {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final es f18777f = new es();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final es f18778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f18780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f18781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final List f18782e;

    private es() {
        this.f18778a = null;
        this.f18779b = "";
        this.f18780c = Collections.emptyMap();
        this.f18781d = "";
        this.f18782e = Collections.emptyList();
    }

    public es(String str, Map map, es esVar) {
        this.f18778a = esVar;
        this.f18779b = str;
        this.f18780c = Collections.unmodifiableMap(map);
        this.f18782e = new ArrayList();
    }

    public List a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.f18782e.size());
        for (es esVar : this.f18782e) {
            if (str.equalsIgnoreCase(esVar.c())) {
                arrayList.add(esVar);
            }
        }
        return arrayList;
    }

    public Map a() {
        return this.f18780c;
    }

    public es b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.f18782e.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            es esVar = (es) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(esVar.c())) {
                return esVar;
            }
            arrayList.addAll(esVar.b());
        }
        return null;
    }

    public List b() {
        return Collections.unmodifiableList(this.f18782e);
    }

    public es c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (es esVar : this.f18782e) {
            if (str.equalsIgnoreCase(esVar.c())) {
                return esVar;
            }
        }
        return null;
    }

    public String c() {
        return this.f18779b;
    }

    public String d() {
        return this.f18781d;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.f18779b + "', text='" + this.f18781d + "', attributes=" + this.f18780c + '}';
    }
}

package yt;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import yt.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f81636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f81637b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SSLSocketFactory f81643h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HostnameVerifier f81644i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f81638c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f81639d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f81640e = 10000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f81641f = 10000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f81642g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f81645j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f81646k = true;

    public T a(String str, String str2) {
        this.f81638c.put(str, str2);
        return this;
    }

    public T b(int i11) {
        this.f81640e = i11;
        return this;
    }

    public T c(boolean z11) {
        this.f81639d = z11;
        return this;
    }

    public T d(int i11) {
        this.f81641f = i11;
        return this;
    }

    public T e(SSLSocketFactory sSLSocketFactory) {
        this.f81643h = sSLSocketFactory;
        return this;
    }

    public T f(String str) {
        this.f81636a = str;
        return this;
    }
}

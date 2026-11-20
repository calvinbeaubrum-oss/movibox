package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultRequest<T> implements Request<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15639a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public URI f15643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f15644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AmazonWebServiceRequest f15645g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InputStream f15647i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15648j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AWSRequestMetrics f15649k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f15650l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15640b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f15641c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f15642d = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HttpMethodName f15646h = HttpMethodName.POST;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.f15644f = str;
        this.f15645g = amazonWebServiceRequest;
    }

    @Override // com.amazonaws.Request
    public void a(InputStream inputStream) {
        this.f15647i = inputStream;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    public AWSRequestMetrics b() {
        return this.f15649k;
    }

    @Override // com.amazonaws.Request
    public void c(String str) {
        this.f15639a = str;
    }

    @Override // com.amazonaws.Request
    public String d() {
        return this.f15644f;
    }

    @Override // com.amazonaws.Request
    public void e(int i11) {
        this.f15648j = i11;
    }

    @Override // com.amazonaws.Request
    public int f() {
        return this.f15648j;
    }

    @Override // com.amazonaws.Request
    public void g(String str, String str2) {
        this.f15641c.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public InputStream getContent() {
        return this.f15647i;
    }

    @Override // com.amazonaws.Request
    public Map<String, String> getHeaders() {
        return this.f15642d;
    }

    @Override // com.amazonaws.Request
    public Map<String, String> getParameters() {
        return this.f15641c;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    public void h(AWSRequestMetrics aWSRequestMetrics) {
        if (this.f15649k != null) {
            throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
        }
        this.f15649k = aWSRequestMetrics;
    }

    @Override // com.amazonaws.Request
    public void i(String str, String str2) {
        this.f15642d.put(str, str2);
    }

    @Override // com.amazonaws.Request
    public void j(Map<String, String> map) {
        this.f15642d.clear();
        this.f15642d.putAll(map);
    }

    @Override // com.amazonaws.Request
    public String k() {
        return this.f15650l;
    }

    @Override // com.amazonaws.Request
    public boolean l() {
        return this.f15640b;
    }

    @Override // com.amazonaws.Request
    public AmazonWebServiceRequest m() {
        return this.f15645g;
    }

    @Override // com.amazonaws.Request
    public HttpMethodName n() {
        return this.f15646h;
    }

    @Override // com.amazonaws.Request
    public void o(boolean z11) {
        this.f15640b = z11;
    }

    @Override // com.amazonaws.Request
    public void p(HttpMethodName httpMethodName) {
        this.f15646h = httpMethodName;
    }

    @Override // com.amazonaws.Request
    public String q() {
        return this.f15639a;
    }

    @Override // com.amazonaws.Request
    public void r(Map<String, String> map) {
        this.f15641c.clear();
        this.f15641c.putAll(map);
    }

    @Override // com.amazonaws.Request
    public URI s() {
        return this.f15643e;
    }

    @Override // com.amazonaws.Request
    public void t(URI uri) {
        this.f15643e = uri;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(n());
        sb2.append(" ");
        sb2.append(s());
        sb2.append(" ");
        String strQ = q();
        if (strQ == null) {
            sb2.append("/");
        } else {
            if (!strQ.startsWith("/")) {
                sb2.append("/");
            }
            sb2.append(strQ);
        }
        sb2.append(" ");
        if (!getParameters().isEmpty()) {
            sb2.append("Parameters: (");
            for (String str : getParameters().keySet()) {
                String str2 = getParameters().get(str);
                sb2.append(str);
                sb2.append(": ");
                sb2.append(str2);
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb2.append("Headers: (");
            for (String str3 : getHeaders().keySet()) {
                String str4 = getHeaders().get(str3);
                sb2.append(str3);
                sb2.append(": ");
                sb2.append(str4);
                sb2.append(", ");
            }
            sb2.append(") ");
        }
        return sb2.toString();
    }
}

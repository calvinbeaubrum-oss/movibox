package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Request<T> {
    void a(InputStream inputStream);

    AWSRequestMetrics b();

    void c(String str);

    String d();

    void e(int i11);

    int f();

    void g(String str, String str2);

    InputStream getContent();

    Map<String, String> getHeaders();

    Map<String, String> getParameters();

    void h(AWSRequestMetrics aWSRequestMetrics);

    void i(String str, String str2);

    void j(Map<String, String> map);

    String k();

    boolean l();

    AmazonWebServiceRequest m();

    HttpMethodName n();

    void o(boolean z11);

    void p(HttpMethodName httpMethodName);

    String q();

    void r(Map<String, String> map);

    URI s();

    void t(URI uri);
}

package com.amazonaws.util;

import com.amazonaws.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class URIBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f16278h = Protocol.HTTPS.toString();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f16285g;

    public URIBuilder(URI uri) {
        this.f16279a = uri.getScheme();
        this.f16280b = uri.getUserInfo();
        this.f16281c = uri.getHost();
        this.f16282d = uri.getPort();
        this.f16283e = uri.getPath();
        this.f16284f = uri.getQuery();
        this.f16285g = uri.getFragment();
    }

    public static URIBuilder b(URI uri) {
        return new URIBuilder(uri);
    }

    public URI a() throws URISyntaxException {
        return new URI(this.f16279a, this.f16280b, this.f16281c, this.f16282d, this.f16283e, this.f16284f, this.f16285g);
    }

    public URIBuilder c(String str) {
        this.f16281c = str;
        return this;
    }
}

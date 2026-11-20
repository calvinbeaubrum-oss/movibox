package com.google.firebase.crashlytics.buildtools.api.net.proxy;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpVersion;
import java.net.URI;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public enum ProtocolScheme {
    HTTP,
    HTTPS,
    Other;

    private static ProtocolScheme getType(String str) {
        if (str.equalsIgnoreCase(HttpVersion.HTTP)) {
            return HTTP;
        }
        return str.equalsIgnoreCase("HTTPS") ? HTTPS : Other;
    }

    public static ProtocolScheme getType(URI uri) {
        return getType(uri.getScheme());
    }

    public static ProtocolScheme getType(URL url) {
        return getType(url.getProtocol());
    }
}

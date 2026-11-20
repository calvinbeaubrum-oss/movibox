package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class ConnectTimeoutException extends InterruptedIOException {
    private static final long serialVersionUID = -4816682903149535989L;
    private final HttpHost host;

    public ConnectTimeoutException() {
        this.host = null;
    }

    public ConnectTimeoutException(IOException iOException, HttpHost httpHost, InetAddress... inetAddressArr) {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connect to ");
        sb2.append(httpHost != null ? httpHost.toHostString() : "remote host");
        if (inetAddressArr == null || inetAddressArr.length <= 0) {
            str = "";
        } else {
            str = " " + Arrays.asList(inetAddressArr);
        }
        sb2.append(str);
        if (iOException == null || iOException.getMessage() == null) {
            str2 = " timed out";
        } else {
            str2 = " failed: " + iOException.getMessage();
        }
        sb2.append(str2);
        super(sb2.toString());
        this.host = httpHost;
        initCause(iOException);
    }

    public ConnectTimeoutException(String str) {
        super(str);
        this.host = null;
    }

    public HttpHost getHost() {
        return this.host;
    }
}

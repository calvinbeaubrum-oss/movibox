package com.squareup.okhttp.internal;

import com.squareup.okhttp.ConnectionSpec;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ConnectionSpec> f49065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f49066b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49068d;

    public a(List<ConnectionSpec> list) {
        this.f49065a = list;
    }

    public ConnectionSpec a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i11 = this.f49066b;
        int size = this.f49065a.size();
        while (true) {
            if (i11 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f49065a.get(i11);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f49066b = i11 + 1;
                break;
            }
            i11++;
        }
        if (connectionSpec != null) {
            this.f49067c = c(sSLSocket);
            c.instance.apply(connectionSpec, sSLSocket, this.f49068d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f49068d + ", modes=" + this.f49065a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f49068d = true;
        if (!this.f49067c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z11 = iOException instanceof SSLHandshakeException;
        if ((z11 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z11 || (iOException instanceof SSLProtocolException);
    }

    public final boolean c(SSLSocket sSLSocket) {
        for (int i11 = this.f49066b; i11 < this.f49065a.size(); i11++) {
            if (this.f49065a.get(i11).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}

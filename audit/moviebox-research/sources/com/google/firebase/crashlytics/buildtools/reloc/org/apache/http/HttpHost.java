package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(HttpHost httpHost) {
        fk.a.g(httpHost, "HTTP host");
        this.hostname = httpHost.hostname;
        this.lcHostname = httpHost.lcHostname;
        this.schemeName = httpHost.schemeName;
        this.port = httpHost.port;
        this.address = httpHost.address;
    }

    public HttpHost(String str) {
        this(str, -1, (String) null);
    }

    public HttpHost(String str, int i11) {
        this(str, i11, (String) null);
    }

    public HttpHost(String str, int i11, String str2) {
        this.hostname = (String) fk.a.c(str, "Host name");
        Locale locale = Locale.ROOT;
        this.lcHostname = str.toLowerCase(locale);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(locale);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i11;
        this.address = null;
    }

    public HttpHost(InetAddress inetAddress) {
        this(inetAddress, -1, (String) null);
    }

    public HttpHost(InetAddress inetAddress, int i11) {
        this(inetAddress, i11, (String) null);
    }

    public HttpHost(InetAddress inetAddress, int i11, String str) {
        this((InetAddress) fk.a.g(inetAddress, "Inet address"), inetAddress.getHostName(), i11, str);
    }

    public HttpHost(InetAddress inetAddress, String str, int i11, String str2) {
        this.address = (InetAddress) fk.a.g(inetAddress, "Inet address");
        String str3 = (String) fk.a.g(str, "Hostname");
        this.hostname = str3;
        Locale locale = Locale.ROOT;
        this.lcHostname = str3.toLowerCase(locale);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(locale);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i11;
    }

    public static HttpHost create(String str) {
        String strSubstring;
        int i11;
        fk.a.c(str, "HTTP Host");
        int iIndexOf = str.indexOf("://");
        if (iIndexOf > 0) {
            strSubstring = str.substring(0, iIndexOf);
            str = str.substring(iIndexOf + 3);
        } else {
            strSubstring = null;
        }
        int iLastIndexOf = str.lastIndexOf(":");
        if (iLastIndexOf > 0) {
            try {
                i11 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                str = str.substring(0, iLastIndexOf);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Invalid HTTP host: " + str);
            }
        } else {
            i11 = -1;
        }
        return new HttpHost(str, i11, strSubstring);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        HttpHost httpHost = (HttpHost) obj;
        if (this.lcHostname.equals(httpHost.lcHostname) && this.port == httpHost.port && this.schemeName.equals(httpHost.schemeName)) {
            InetAddress inetAddress = this.address;
            InetAddress inetAddress2 = httpHost.address;
            if (inetAddress == null) {
                if (inetAddress2 == null) {
                    return true;
                }
            } else if (inetAddress.equals(inetAddress2)) {
                return true;
            }
        }
        return false;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public int hashCode() {
        int iD = fk.e.d(fk.e.c(fk.e.d(17, this.lcHostname), this.port), this.schemeName);
        InetAddress inetAddress = this.address;
        return inetAddress != null ? fk.e.d(iD, inetAddress) : iD;
    }

    public String toHostString() {
        if (this.port == -1) {
            return this.hostname;
        }
        StringBuilder sb2 = new StringBuilder(this.hostname.length() + 6);
        sb2.append(this.hostname);
        sb2.append(":");
        sb2.append(Integer.toString(this.port));
        return sb2.toString();
    }

    public String toString() {
        return toURI();
    }

    public String toURI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.schemeName);
        sb2.append("://");
        sb2.append(this.hostname);
        if (this.port != -1) {
            sb2.append(':');
            sb2.append(Integer.toString(this.port));
        }
        return sb2.toString();
    }
}

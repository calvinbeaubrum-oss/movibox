package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.net;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.p;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i11, boolean z11) {
        this.host = str;
        this.port = i11;
        this.hasBracketlessColons = z11;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort hostAndPortFromString = fromString(str);
        l.j(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return hostAndPortFromString;
    }

    public static HostAndPort fromParts(String str, int i11) {
        l.f(isValidPort(i11), "Port out of range: %s", i11);
        HostAndPort hostAndPortFromString = fromString(str);
        l.j(!hostAndPortFromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(hostAndPortFromString.host, i11, hostAndPortFromString.hasBracketlessColons);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0030 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0032  */
    public static HostAndPort fromString(String str) {
        String strSubstring;
        String strSubstring2;
        l.n(str);
        int i11 = -1;
        boolean z11 = false;
        if (str.startsWith("[")) {
            String[] hostAndPortFromBracketedHost = getHostAndPortFromBracketedHost(str);
            strSubstring2 = hostAndPortFromBracketedHost[0];
            strSubstring = hostAndPortFromBracketedHost[1];
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf >= 0) {
                int i12 = iIndexOf + 1;
                if (str.indexOf(58, i12) == -1) {
                    strSubstring2 = str.substring(0, iIndexOf);
                    strSubstring = str.substring(i12);
                } else {
                    z11 = iIndexOf >= 0;
                    strSubstring = null;
                    strSubstring2 = str;
                }
            } else {
                if (iIndexOf >= 0) {
                }
                strSubstring = null;
                strSubstring2 = str;
            }
        }
        if (!p.a(strSubstring)) {
            l.j(!strSubstring.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i11 = Integer.parseInt(strSubstring);
                l.j(isValidPort(i11), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Unparseable port number: " + str);
            }
        }
        return new HostAndPort(strSubstring2, i11, z11);
    }

    private static String[] getHostAndPortFromBracketedHost(String str) {
        l.j(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int iIndexOf = str.indexOf(58);
        int iLastIndexOf = str.lastIndexOf(93);
        l.j(iIndexOf > -1 && iLastIndexOf > iIndexOf, "Invalid bracketed host/port: %s", str);
        String strSubstring = str.substring(1, iLastIndexOf);
        int i11 = iLastIndexOf + 1;
        if (i11 == str.length()) {
            return new String[]{strSubstring, ""};
        }
        l.j(str.charAt(i11) == ':', "Only a colon may follow a close bracket: %s", str);
        int i12 = iLastIndexOf + 2;
        for (int i13 = i12; i13 < str.length(); i13++) {
            l.j(Character.isDigit(str.charAt(i13)), "Port must be numeric: %s", str);
        }
        return new String[]{strSubstring, str.substring(i12)};
    }

    private static boolean isValidPort(int i11) {
        return i11 >= 0 && i11 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return g.a(this.host, hostAndPort.host) && this.port == hostAndPort.port && this.hasBracketlessColons == hostAndPort.hasBracketlessColons;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        l.t(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i11) {
        return hasPort() ? this.port : i11;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return g.b(this.host, Integer.valueOf(this.port), Boolean.valueOf(this.hasBracketlessColons));
    }

    public HostAndPort requireBracketsForIPv6() {
        l.j(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb2.append('[');
            sb2.append(this.host);
            sb2.append(']');
        } else {
            sb2.append(this.host);
        }
        if (hasPort()) {
            sb2.append(':');
            sb2.append(this.port);
        }
        return sb2.toString();
    }

    public HostAndPort withDefaultPort(int i11) {
        l.d(isValidPort(i11));
        return hasPort() ? this : new HostAndPort(this.host, i11, this.hasBracketlessColons);
    }
}

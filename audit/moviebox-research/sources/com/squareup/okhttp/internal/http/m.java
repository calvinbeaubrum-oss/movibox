package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Protocol f49325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f49327c;

    public m(Protocol protocol, int i11, String str) {
        this.f49325a = protocol;
        this.f49326b = i11;
        this.f49327c = str;
    }

    public static m a(String str) throws IOException {
        Protocol protocol;
        int i11;
        String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i11 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            protocol = Protocol.HTTP_1_0;
            i11 = 4;
        }
        int i12 = i11 + 3;
        if (str.length() < i12) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i13 = Integer.parseInt(str.substring(i11, i12));
            if (str.length() <= i12) {
                strSubstring = "";
            } else {
                if (str.charAt(i12) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i11 + 4);
            }
            return new m(protocol, i13, strSubstring);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f49325a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb2.append(' ');
        sb2.append(this.f49326b);
        if (this.f49327c != null) {
            sb2.append(' ');
            sb2.append(this.f49327c);
        }
        return sb2.toString();
    }
}

package ck;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.p;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.q;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final d f14941a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f14942b = new d();

    public CharArrayBuffer a(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion) {
        fk.a.g(protocolVersion, "Protocol version");
        int iE = e(protocolVersion);
        if (charArrayBuffer == null) {
            charArrayBuffer = new CharArrayBuffer(iE);
        } else {
            charArrayBuffer.ensureCapacity(iE);
        }
        charArrayBuffer.append(protocolVersion.getProtocol());
        charArrayBuffer.append('/');
        charArrayBuffer.append(Integer.toString(protocolVersion.getMajor()));
        charArrayBuffer.append('.');
        charArrayBuffer.append(Integer.toString(protocolVersion.getMinor()));
        return charArrayBuffer;
    }

    public void b(CharArrayBuffer charArrayBuffer, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d dVar) {
        String name = dVar.getName();
        String value = dVar.getValue();
        int length = name.length() + 2;
        if (value != null) {
            length += value.length();
        }
        charArrayBuffer.ensureCapacity(length);
        charArrayBuffer.append(name);
        charArrayBuffer.append(": ");
        if (value != null) {
            charArrayBuffer.ensureCapacity(charArrayBuffer.length() + value.length());
            for (int i11 = 0; i11 < value.length(); i11++) {
                char cCharAt = value.charAt(i11);
                if (cCharAt == '\r' || cCharAt == '\n' || cCharAt == '\f' || cCharAt == 11) {
                    cCharAt = ' ';
                }
                charArrayBuffer.append(cCharAt);
            }
        }
    }

    public void c(CharArrayBuffer charArrayBuffer, p pVar) {
        String method = pVar.getMethod();
        String uri = pVar.getUri();
        charArrayBuffer.ensureCapacity(method.length() + 1 + uri.length() + 1 + e(pVar.getProtocolVersion()));
        charArrayBuffer.append(method);
        charArrayBuffer.append(' ');
        charArrayBuffer.append(uri);
        charArrayBuffer.append(' ');
        a(charArrayBuffer, pVar.getProtocolVersion());
    }

    public void d(CharArrayBuffer charArrayBuffer, q qVar) {
        int iE = e(qVar.getProtocolVersion()) + 5;
        String reasonPhrase = qVar.getReasonPhrase();
        if (reasonPhrase != null) {
            iE += reasonPhrase.length();
        }
        charArrayBuffer.ensureCapacity(iE);
        a(charArrayBuffer, qVar.getProtocolVersion());
        charArrayBuffer.append(' ');
        charArrayBuffer.append(Integer.toString(qVar.getStatusCode()));
        charArrayBuffer.append(' ');
        if (reasonPhrase != null) {
            charArrayBuffer.append(reasonPhrase);
        }
    }

    public int e(ProtocolVersion protocolVersion) {
        return protocolVersion.getProtocol().length() + 4;
    }

    public CharArrayBuffer f(CharArrayBuffer charArrayBuffer, com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d dVar) {
        fk.a.g(dVar, "Header");
        if (dVar instanceof com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c) {
            return ((com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c) dVar).getBuffer();
        }
        CharArrayBuffer charArrayBufferI = i(charArrayBuffer);
        b(charArrayBufferI, dVar);
        return charArrayBufferI;
    }

    public CharArrayBuffer g(CharArrayBuffer charArrayBuffer, p pVar) {
        fk.a.g(pVar, "Request line");
        CharArrayBuffer charArrayBufferI = i(charArrayBuffer);
        c(charArrayBufferI, pVar);
        return charArrayBufferI;
    }

    public CharArrayBuffer h(CharArrayBuffer charArrayBuffer, q qVar) {
        fk.a.g(qVar, "Status line");
        CharArrayBuffer charArrayBufferI = i(charArrayBuffer);
        d(charArrayBufferI, qVar);
        return charArrayBufferI;
    }

    public CharArrayBuffer i(CharArrayBuffer charArrayBuffer) {
        if (charArrayBuffer == null) {
            return new CharArrayBuffer(64);
        }
        charArrayBuffer.clear();
        return charArrayBuffer;
    }
}

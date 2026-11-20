package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ChallengeState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.MalformedChallengeException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.l;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BufferedHeader;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import ek.c;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private static final int QOP_UNKNOWN = -1;
    private static final long serialVersionUID = 3883908186234566916L;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private String f40094a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private String f40095a2;
    private String cnonce;
    private boolean complete;
    private String lastNonce;
    private long nounceCount;

    public DigestScheme() {
        this(com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.a.f40092b);
    }

    @Deprecated
    public DigestScheme(ChallengeState challengeState) {
        super(challengeState);
    }

    public DigestScheme(Charset charset) {
        super(charset);
        this.complete = false;
    }

    public static String createCnonce() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encode(bArr);
    }

    private d createDigestHeader(xj.b bVar, l lVar) throws AuthenticationException {
        String str;
        byte b11;
        String str2;
        String str3;
        String string;
        String str4;
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        HashSet hashSet = new HashSet(8);
        String parameter7 = getParameter("qop");
        if (parameter7 != null) {
            str = "qop";
            for (StringTokenizer stringTokenizer = new StringTokenizer(parameter7, ","); stringTokenizer.hasMoreTokens(); stringTokenizer = stringTokenizer) {
                hashSet.add(stringTokenizer.nextToken().trim().toLowerCase(Locale.ROOT));
            }
            b11 = ((lVar instanceof j) && hashSet.contains("auth-int")) ? (byte) 1 : hashSet.contains("auth") ? (byte) 2 : (byte) -1;
        } else {
            str = "qop";
            b11 = 0;
        }
        if (b11 == -1) {
            throw new AuthenticationException("None of the qop methods is supported: " + parameter7);
        }
        String parameter8 = getParameter("charset");
        if (parameter8 == null) {
            parameter8 = "ISO-8859-1";
        }
        String str5 = parameter6.equalsIgnoreCase("MD5-sess") ? "MD5" : parameter6;
        try {
            MessageDigest messageDigestCreateMessageDigest = createMessageDigest(str5);
            String name = bVar.getUserPrincipal().getName();
            String password = bVar.getPassword();
            if (parameter3.equals(this.lastNonce)) {
                this.nounceCount++;
            } else {
                this.nounceCount = 1L;
                this.cnonce = null;
                this.lastNonce = parameter3;
            }
            StringBuilder sb2 = new StringBuilder(256);
            Formatter formatter = new Formatter(sb2, Locale.US);
            formatter.format("%08x", Long.valueOf(this.nounceCount));
            formatter.close();
            String string2 = sb2.toString();
            if (this.cnonce == null) {
                this.cnonce = createCnonce();
            }
            this.f40094a1 = null;
            this.f40095a2 = null;
            if (parameter6.equalsIgnoreCase("MD5-sess")) {
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                String strEncode = encode(messageDigestCreateMessageDigest.digest(fk.d.b(sb2.toString(), parameter8)));
                sb2.setLength(0);
                sb2.append(strEncode);
                sb2.append(':');
                str2 = parameter3;
                sb2.append(str2);
                sb2.append(':');
                sb2.append(this.cnonce);
                this.f40094a1 = sb2.toString();
            } else {
                str2 = parameter3;
                sb2.setLength(0);
                sb2.append(name);
                sb2.append(':');
                sb2.append(parameter2);
                sb2.append(':');
                sb2.append(password);
                this.f40094a1 = sb2.toString();
            }
            String strEncode2 = encode(messageDigestCreateMessageDigest.digest(fk.d.b(this.f40094a1, parameter8)));
            byte b12 = b11;
            if (b12 == 2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(parameter5);
                sb3.append(':');
                str3 = parameter;
                sb3.append(str3);
                this.f40095a2 = sb3.toString();
            } else {
                str3 = parameter;
                if (b12 == 1) {
                    if (lVar instanceof j) {
                        ((j) lVar).a();
                    }
                    b bVar2 = new b(messageDigestCreateMessageDigest);
                    try {
                        bVar2.close();
                        this.f40095a2 = parameter5 + ':' + str3 + ':' + encode(bVar2.a());
                    } catch (IOException e11) {
                        throw new AuthenticationException("I/O error reading entity content", e11);
                    }
                } else {
                    this.f40095a2 = parameter5 + ':' + str3;
                }
            }
            String strEncode3 = encode(messageDigestCreateMessageDigest.digest(fk.d.b(this.f40095a2, parameter8)));
            if (b12 == 0) {
                sb2.setLength(0);
                sb2.append(strEncode2);
                sb2.append(':');
                sb2.append(str2);
                sb2.append(':');
                sb2.append(strEncode3);
                string = sb2.toString();
            } else {
                sb2.setLength(0);
                sb2.append(strEncode2);
                sb2.append(':');
                sb2.append(str2);
                sb2.append(':');
                sb2.append(string2);
                sb2.append(':');
                sb2.append(this.cnonce);
                sb2.append(':');
                sb2.append(b12 == 1 ? "auth-int" : "auth");
                sb2.append(':');
                sb2.append(strEncode3);
                string = sb2.toString();
            }
            String strEncode4 = encode(messageDigestCreateMessageDigest.digest(fk.d.a(string)));
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
            if (isProxy()) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append(HttpHeaders.AUTHORIZATION);
            }
            charArrayBuffer.append(": Digest ");
            ArrayList arrayList = new ArrayList(20);
            arrayList.add(new BasicNameValuePair(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, name));
            arrayList.add(new BasicNameValuePair("realm", parameter2));
            arrayList.add(new BasicNameValuePair("nonce", str2));
            arrayList.add(new BasicNameValuePair("uri", str3));
            arrayList.add(new BasicNameValuePair("response", strEncode4));
            if (b12 != 0) {
                str4 = str;
                arrayList.add(new BasicNameValuePair(str4, b12 == 1 ? "auth-int" : "auth"));
                arrayList.add(new BasicNameValuePair(ResourceManager.KEY_MD5CHECK, string2));
                arrayList.add(new BasicNameValuePair("cnonce", this.cnonce));
            } else {
                str4 = str;
            }
            arrayList.add(new BasicNameValuePair("algorithm", parameter6));
            if (parameter4 != null) {
                arrayList.add(new BasicNameValuePair("opaque", parameter4));
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i11);
                if (i11 > 0) {
                    charArrayBuffer.append(", ");
                }
                String name2 = basicNameValuePair.getName();
                ck.b.f14935b.d(charArrayBuffer, basicNameValuePair, !(ResourceManager.KEY_MD5CHECK.equals(name2) || str4.equals(name2) || "algorithm".equals(name2)));
            }
            return new BufferedHeader(charArrayBuffer);
        } catch (UnsupportedDigestAlgorithmException unused) {
            throw new AuthenticationException("Unsuppported digest algorithm: " + str5);
        }
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            int i12 = b11 & Ascii.SI;
            int i13 = i11 * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i13] = cArr2[(b11 & 240) >> 4];
            cArr[i13 + 1] = cArr2[i12];
        }
        return new String(cArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme, xj.a
    @Deprecated
    public d authenticate(xj.b bVar, l lVar) throws AuthenticationException {
        return authenticate(bVar, lVar, new ek.a());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public d authenticate(xj.b bVar, l lVar, c cVar) throws AuthenticationException {
        fk.a.g(bVar, "Credentials");
        fk.a.g(lVar, "HTTP request");
        if (getParameter("realm") == null) {
            throw new AuthenticationException("missing realm in challenge");
        }
        if (getParameter("nonce") == null) {
            throw new AuthenticationException("missing nonce in challenge");
        }
        getParameters().put("methodname", lVar.b().getMethod());
        getParameters().put("uri", lVar.b().getUri());
        if (getParameter("charset") == null) {
            getParameters().put("charset", getCredentialsCharset(lVar));
        }
        return createDigestHeader(bVar, lVar);
    }

    public String getA1() {
        return this.f40094a1;
    }

    public String getA2() {
        return this.f40095a2;
    }

    public String getCnonce() {
        return this.cnonce;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme, xj.a
    public String getSchemeName() {
        return "digest";
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme
    public boolean isComplete() {
        if ("true".equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.RFC2617Scheme
    public boolean isConnectionBased() {
        return false;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public void processChallenge(d dVar) throws MalformedChallengeException {
        super.processChallenge(dVar);
        this.complete = true;
        if (getParameters().isEmpty()) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth.a
    public String toString() {
        return "DIGEST [complete=" + this.complete + ", nonce=" + this.lastNonce + ", nc=" + this.nounceCount + "]";
    }
}

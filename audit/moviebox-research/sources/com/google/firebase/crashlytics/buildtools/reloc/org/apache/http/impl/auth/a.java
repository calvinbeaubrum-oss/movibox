package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.auth;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.ChallengeState;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.MalformedChallengeException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.l;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import ek.c;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements xj.a {
    protected ChallengeState challengeState;

    public a() {
    }

    @Deprecated
    public a(ChallengeState challengeState) {
        this.challengeState = challengeState;
    }

    public d authenticate(xj.b bVar, l lVar, c cVar) throws AuthenticationException {
        return authenticate(bVar, lVar);
    }

    public ChallengeState getChallengeState() {
        return this.challengeState;
    }

    public boolean isProxy() {
        ChallengeState challengeState = this.challengeState;
        return challengeState != null && challengeState == ChallengeState.PROXY;
    }

    public abstract void parseChallenge(CharArrayBuffer charArrayBuffer, int i11, int i12) throws MalformedChallengeException;

    public void processChallenge(d dVar) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int valuePos;
        fk.a.g(dVar, "Header");
        String name = dVar.getName();
        if (name.equalsIgnoreCase("WWW-Authenticate")) {
            this.challengeState = ChallengeState.TARGET;
        } else {
            if (!name.equalsIgnoreCase("Proxy-Authenticate")) {
                throw new MalformedChallengeException("Unexpected header name: " + name);
            }
            this.challengeState = ChallengeState.PROXY;
        }
        if (dVar instanceof com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c) {
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c cVar = (com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c) dVar;
            charArrayBuffer = cVar.getBuffer();
            valuePos = cVar.getValuePos();
        } else {
            String value = dVar.getValue();
            if (value == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            valuePos = 0;
        }
        while (valuePos < charArrayBuffer.length() && ek.b.a(charArrayBuffer.charAt(valuePos))) {
            valuePos++;
        }
        int i11 = valuePos;
        while (i11 < charArrayBuffer.length() && !ek.b.a(charArrayBuffer.charAt(i11))) {
            i11++;
        }
        String strSubstring = charArrayBuffer.substring(valuePos, i11);
        if (strSubstring.equalsIgnoreCase(getSchemeName())) {
            parseChallenge(charArrayBuffer, i11, charArrayBuffer.length());
            return;
        }
        throw new MalformedChallengeException("Invalid scheme identifier: " + strSubstring);
    }

    public String toString() {
        String schemeName = getSchemeName();
        return schemeName != null ? schemeName.toUpperCase(Locale.ROOT) : super.toString();
    }
}

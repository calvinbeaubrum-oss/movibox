package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import ck.g;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import fk.a;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BufferedHeader implements c, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        a.g(charArrayBuffer, "Char array buffer");
        int iIndexOf = charArrayBuffer.indexOf(58);
        if (iIndexOf == -1) {
            throw new ParseException("Invalid header: " + charArrayBuffer.toString());
        }
        String strSubstringTrimmed = charArrayBuffer.substringTrimmed(0, iIndexOf);
        if (strSubstringTrimmed.length() != 0) {
            this.buffer = charArrayBuffer;
            this.name = strSubstringTrimmed;
            this.valuePos = iIndexOf + 1;
        } else {
            throw new ParseException("Invalid header: " + charArrayBuffer.toString());
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c
    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d
    public e[] getElements() throws ParseException {
        g gVar = new g(0, this.buffer.length());
        gVar.d(this.valuePos);
        return ck.c.f14937c.a(this.buffer, gVar);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getValue() {
        CharArrayBuffer charArrayBuffer = this.buffer;
        return charArrayBuffer.substringTrimmed(this.valuePos, charArrayBuffer.length());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.c
    public int getValuePos() {
        return this.valuePos;
    }

    public String toString() {
        return this.buffer.toString();
    }
}

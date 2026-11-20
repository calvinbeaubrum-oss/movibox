package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o;
import fk.a;
import fk.e;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicNameValuePair implements o, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String str, String str2) {
        this.name = (String) a.g(str, "Name");
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        BasicNameValuePair basicNameValuePair = (BasicNameValuePair) obj;
        return this.name.equals(basicNameValuePair.name) && e.a(this.value, basicNameValuePair.value);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return e.d(e.d(17, this.name), this.value);
    }

    public String toString() {
        if (this.value == null) {
            return this.name;
        }
        StringBuilder sb2 = new StringBuilder(this.name.length() + 1 + this.value.length());
        sb2.append(this.name);
        sb2.append("=");
        sb2.append(this.value);
        return sb2.toString();
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import ck.c;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ParseException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.e;
import fk.a;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicHeader implements d, Cloneable, Serializable {
    private static final e[] EMPTY_HEADER_ELEMENTS = new e[0];
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        this.name = (String) a.g(str, "Name");
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d
    public e[] getElements() throws ParseException {
        return getValue() != null ? c.d(getValue(), null) : EMPTY_HEADER_ELEMENTS;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.o
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return ck.d.f14942b.f(null, this).toString();
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message;

import ck.e;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.d;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.f;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.CharArrayBuffer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class HeaderGroup implements Cloneable, Serializable {
    private static final long serialVersionUID = 2608834160639271617L;
    private final d[] EMPTY = new d[0];
    private final List<d> headers = new ArrayList(16);

    public void addHeader(d dVar) {
        if (dVar == null) {
            return;
        }
        this.headers.add(dVar);
    }

    public void clear() {
        this.headers.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean containsHeader(String str) {
        for (int i11 = 0; i11 < this.headers.size(); i11++) {
            if (this.headers.get(i11).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HeaderGroup copy() {
        HeaderGroup headerGroup = new HeaderGroup();
        headerGroup.headers.addAll(this.headers);
        return headerGroup;
    }

    public d[] getAllHeaders() {
        List<d> list = this.headers;
        return (d[]) list.toArray(new d[list.size()]);
    }

    public d getCondensedHeader(String str) {
        d[] headers = getHeaders(str);
        if (headers.length == 0) {
            return null;
        }
        if (headers.length == 1) {
            return headers[0];
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        charArrayBuffer.append(headers[0].getValue());
        for (int i11 = 1; i11 < headers.length; i11++) {
            charArrayBuffer.append(", ");
            charArrayBuffer.append(headers[i11].getValue());
        }
        return new BasicHeader(str.toLowerCase(Locale.ROOT), charArrayBuffer.toString());
    }

    public d getFirstHeader(String str) {
        for (int i11 = 0; i11 < this.headers.size(); i11++) {
            d dVar = this.headers.get(i11);
            if (dVar.getName().equalsIgnoreCase(str)) {
                return dVar;
            }
        }
        return null;
    }

    public d[] getHeaders(String str) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < this.headers.size(); i11++) {
            d dVar = this.headers.get(i11);
            if (dVar.getName().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dVar);
            }
        }
        return arrayList != null ? (d[]) arrayList.toArray(new d[arrayList.size()]) : this.EMPTY;
    }

    public d getLastHeader(String str) {
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            d dVar = this.headers.get(size);
            if (dVar.getName().equalsIgnoreCase(str)) {
                return dVar;
            }
        }
        return null;
    }

    public f iterator() {
        return new e(this.headers, null);
    }

    public f iterator(String str) {
        return new e(this.headers, str);
    }

    public void removeHeader(d dVar) {
        if (dVar == null) {
            return;
        }
        this.headers.remove(dVar);
    }

    public void setHeaders(d[] dVarArr) {
        clear();
        if (dVarArr == null) {
            return;
        }
        Collections.addAll(this.headers, dVarArr);
    }

    public String toString() {
        return this.headers.toString();
    }

    public void updateHeader(d dVar) {
        if (dVar == null) {
            return;
        }
        for (int i11 = 0; i11 < this.headers.size(); i11++) {
            if (this.headers.get(i11).getName().equalsIgnoreCase(dVar.getName())) {
                this.headers.set(i11, dVar);
                return;
            }
        }
        this.headers.add(dVar);
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params;

import dk.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class SyncBasicHttpParams extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams, dk.b
    public synchronized Object getParameter(String str) {
        return super.getParameter(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSet(String str) {
        return super.isParameterSet(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized boolean isParameterSetLocally(String str) {
        return super.isParameterSetLocally(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized boolean removeParameter(String str) {
        return super.removeParameter(str);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams, dk.b
    public synchronized b setParameter(String str, Object obj) {
        return super.setParameter(str, obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.params.BasicHttpParams
    public synchronized void setParameters(String[] strArr, Object obj) {
        super.setParameters(strArr, obj);
    }
}

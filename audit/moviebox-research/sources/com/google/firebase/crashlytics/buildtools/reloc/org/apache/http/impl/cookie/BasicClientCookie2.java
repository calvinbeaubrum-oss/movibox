package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie;

import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class BasicClientCookie2 extends BasicClientCookie {
    private static final long serialVersionUID = -7744598295706617057L;
    private String commentURL;
    private boolean discard;
    private int[] ports;

    public BasicClientCookie2(String str, String str2) {
        super(str, str2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie
    public Object clone() throws CloneNotSupportedException {
        BasicClientCookie2 basicClientCookie2 = (BasicClientCookie2) super.clone();
        int[] iArr = this.ports;
        if (iArr != null) {
            basicClientCookie2.ports = (int[]) iArr.clone();
        }
        return basicClientCookie2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie
    public String getCommentURL() {
        return this.commentURL;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie
    public int[] getPorts() {
        return this.ports;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie, bk.a
    public boolean isExpired(Date date) {
        return this.discard || super.isExpired(date);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie
    public boolean isPersistent() {
        return !this.discard && super.isPersistent();
    }

    public void setCommentURL(String str) {
        this.commentURL = str;
    }

    public void setDiscard(boolean z11) {
        this.discard = z11;
    }

    public void setPorts(int[] iArr) {
        this.ports = iArr;
    }
}

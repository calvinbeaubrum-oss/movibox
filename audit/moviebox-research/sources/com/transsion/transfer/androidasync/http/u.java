package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class u implements w, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58839b;

    public u(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f58838a = str;
        this.f58839b = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f58838a.equals(uVar.f58838a) && TextUtils.equals(this.f58839b, uVar.f58839b);
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getName() {
        return this.f58838a;
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getValue() {
        return this.f58839b;
    }

    public int hashCode() {
        return this.f58838a.hashCode() ^ this.f58839b.hashCode();
    }

    public String toString() {
        return this.f58838a + "=" + this.f58839b;
    }
}

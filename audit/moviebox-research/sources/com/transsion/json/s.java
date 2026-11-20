package com.transsion.json;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f52987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f52988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52989c;

    public s(String str, boolean z11) {
        this.f52988b = false;
        this.f52989c = true;
        this.f52987a = str.split("\\.");
        this.f52988b = str.indexOf(42) >= 0;
        this.f52989c = z11;
    }

    public boolean a() {
        return this.f52989c;
    }

    public boolean b(r rVar) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < rVar.c()) {
            String str = rVar.b().get(i11);
            String[] strArr = this.f52987a;
            if (i12 >= strArr.length || !strArr[i12].equals("*")) {
                String[] strArr2 = this.f52987a;
                if (i12 >= strArr2.length || !strArr2[i12].equals(str)) {
                    int i13 = i12 - 1;
                    if (i13 < 0 || !this.f52987a[i13].equals("*")) {
                        return false;
                    }
                    i11++;
                } else {
                    i11++;
                }
            }
            i12++;
        }
        if (i12 <= 0 || !this.f52987a[i12 - 1].equals("*")) {
            return i11 >= rVar.c() && rVar.c() > 0;
        }
        return i11 >= rVar.c() && i12 >= this.f52987a.length;
    }

    public boolean c() {
        return this.f52988b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f52987a, ((s) obj).f52987a);
    }

    public int hashCode() {
        String[] strArr = this.f52987a;
        if (strArr != null) {
            return Arrays.hashCode(strArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i11 = 0;
        while (true) {
            String[] strArr = this.f52987a;
            if (i11 >= strArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(strArr[i11]);
            if (i11 < this.f52987a.length - 1) {
                sb2.append(",");
            }
            i11++;
        }
    }
}

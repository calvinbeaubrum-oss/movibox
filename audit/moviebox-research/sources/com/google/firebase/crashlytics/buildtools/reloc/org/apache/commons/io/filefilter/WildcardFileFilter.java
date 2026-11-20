package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.d;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class WildcardFileFilter extends a implements Serializable {
    private static final long serialVersionUID = -7426486598995782105L;
    private final IOCase caseSensitivity;
    private final String[] wildcards;

    public WildcardFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public WildcardFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public WildcardFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        String[] strArr2 = new String[strArr.length];
        this.wildcards = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        for (String str : this.wildcards) {
            if (d.g(name, str, this.caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (String str2 : this.wildcards) {
            if (d.g(str, str2, this.caseSensitivity)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("(");
        if (this.wildcards != null) {
            for (int i11 = 0; i11 < this.wildcards.length; i11++) {
                if (i11 > 0) {
                    sb2.append(",");
                }
                sb2.append(this.wildcards[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class PrefixFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 8533897440809599867L;
    private final IOCase caseSensitivity;
    private final String[] prefixes;

    public PrefixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The prefix must not be null");
        }
        this.prefixes = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public PrefixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of prefixes must not be null");
        }
        this.prefixes = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public PrefixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public PrefixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of prefixes must not be null");
        }
        String[] strArr2 = new String[strArr.length];
        this.prefixes = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        for (String str : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(name, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (String str2 : this.prefixes) {
            if (this.caseSensitivity.checkStartsWith(str, str2)) {
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
        if (this.prefixes != null) {
            for (int i11 = 0; i11 < this.prefixes.length; i11++) {
                if (i11 > 0) {
                    sb2.append(",");
                }
                sb2.append(this.prefixes[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}

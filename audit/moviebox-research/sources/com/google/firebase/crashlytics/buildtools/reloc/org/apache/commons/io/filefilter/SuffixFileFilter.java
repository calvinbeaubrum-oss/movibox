package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class SuffixFileFilter extends a implements Serializable {
    private static final long serialVersionUID = -3389157631240246157L;
    private final IOCase caseSensitivity;
    private final String[] suffixes;

    public SuffixFileFilter(String str) {
        this(str, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The suffix must not be null");
        }
        this.suffixes = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public SuffixFileFilter(List<String> list) {
        this(list, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of suffixes must not be null");
        }
        this.suffixes = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public SuffixFileFilter(String[] strArr) {
        this(strArr, IOCase.SENSITIVE);
    }

    public SuffixFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of suffixes must not be null");
        }
        String[] strArr2 = new String[strArr.length];
        this.suffixes = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        for (String str : this.suffixes) {
            if (this.caseSensitivity.checkEndsWith(name, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (String str2 : this.suffixes) {
            if (this.caseSensitivity.checkEndsWith(str, str2)) {
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
        if (this.suffixes != null) {
            for (int i11 = 0; i11 < this.suffixes.length; i11++) {
                if (i11 > 0) {
                    sb2.append(",");
                }
                sb2.append(this.suffixes[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}

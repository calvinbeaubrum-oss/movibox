package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NameFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 176844364689077340L;
    private final IOCase caseSensitivity;
    private final String[] names;

    public NameFileFilter(String str) {
        this(str, (IOCase) null);
    }

    public NameFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.names = new String[]{str};
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(List<String> list) {
        this(list, (IOCase) null);
    }

    public NameFileFilter(List<String> list, IOCase iOCase) {
        if (list == null) {
            throw new IllegalArgumentException("The list of names must not be null");
        }
        this.names = (String[]) list.toArray(new String[list.size()]);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    public NameFileFilter(String[] strArr) {
        this(strArr, (IOCase) null);
    }

    public NameFileFilter(String[] strArr, IOCase iOCase) {
        if (strArr == null) {
            throw new IllegalArgumentException("The array of names must not be null");
        }
        String[] strArr2 = new String[strArr.length];
        this.names = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        this.caseSensitivity = iOCase == null ? IOCase.SENSITIVE : iOCase;
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        for (String str : this.names) {
            if (this.caseSensitivity.checkEquals(name, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        for (String str2 : this.names) {
            if (this.caseSensitivity.checkEquals(str, str2)) {
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
        if (this.names != null) {
            for (int i11 = 0; i11 < this.names.length; i11++) {
                if (i11 > 0) {
                    sb2.append(",");
                }
                sb2.append(this.names[i11]);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}

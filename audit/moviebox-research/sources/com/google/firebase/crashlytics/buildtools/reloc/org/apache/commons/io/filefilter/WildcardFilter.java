package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.d;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class WildcardFilter extends a implements Serializable {
    private static final long serialVersionUID = -5037645902506953517L;
    private final String[] wildcards;

    public WildcardFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The wildcard must not be null");
        }
        this.wildcards = new String[]{str};
    }

    public WildcardFilter(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("The wildcard list must not be null");
        }
        this.wildcards = (String[]) list.toArray(new String[list.size()]);
    }

    public WildcardFilter(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("The wildcard array must not be null");
        }
        String[] strArr2 = new String[strArr.length];
        this.wildcards = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    @Override // wj.a, wj.b, java.io.FileFilter
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (String str : this.wildcards) {
            if (d.f(file.getName(), str)) {
                return true;
            }
        }
        return false;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (file != null && new File(file, str).isDirectory()) {
            return false;
        }
        for (String str2 : this.wildcards) {
            if (d.f(str, str2)) {
                return true;
            }
        }
        return false;
    }
}

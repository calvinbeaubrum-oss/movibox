package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.filefilter;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.regex.Pattern;
import wj.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class RegexFileFilter extends a implements Serializable {
    private static final long serialVersionUID = 4269646126155225062L;
    private final Pattern pattern;

    public RegexFileFilter(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.pattern = Pattern.compile(str);
    }

    public RegexFileFilter(String str, int i11) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.pattern = Pattern.compile(str, i11);
    }

    public RegexFileFilter(String str, IOCase iOCase) {
        if (str == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.pattern = Pattern.compile(str, (iOCase == null || iOCase.isCaseSensitive()) ? 0 : 2);
    }

    public RegexFileFilter(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern is missing");
        }
        this.pattern = pattern;
    }

    @Override // wj.a, wj.b, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }
}

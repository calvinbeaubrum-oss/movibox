package com.google.firebase.crashlytics.buildtools.reloc.afu.plume;

import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class RegexUtil$CheckedPatternSyntaxException extends Exception {
    private static final long serialVersionUID = 6266881831979001480L;
    private final PatternSyntaxException pse;

    public RegexUtil$CheckedPatternSyntaxException(String str, String str2, int i11) {
        this(new PatternSyntaxException(str, str2, i11));
    }

    public RegexUtil$CheckedPatternSyntaxException(PatternSyntaxException patternSyntaxException) {
        this.pse = patternSyntaxException;
    }

    public String getDescription() {
        return this.pse.getDescription();
    }

    public int getIndex() {
        return this.pse.getIndex();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.pse.getMessage();
    }

    public String getPattern() {
        return this.pse.getPattern();
    }
}

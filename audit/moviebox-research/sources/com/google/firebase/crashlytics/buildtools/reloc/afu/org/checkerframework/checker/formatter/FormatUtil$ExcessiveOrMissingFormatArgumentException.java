package com.google.firebase.crashlytics.buildtools.reloc.afu.org.checkerframework.checker.formatter;

import java.util.MissingFormatArgumentException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class FormatUtil$ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
    private static final long serialVersionUID = 17000126;
    private final int expected;
    private final int found;

    public FormatUtil$ExcessiveOrMissingFormatArgumentException(int i11, int i12) {
        super("-");
        this.expected = i11;
        this.found = i12;
    }

    public int getExpected() {
        return this.expected;
    }

    public int getFound() {
        return this.found;
    }

    @Override // java.util.MissingFormatArgumentException, java.lang.Throwable
    public String getMessage() {
        return String.format("Expected %d arguments but found %d.", Integer.valueOf(this.expected), Integer.valueOf(this.found));
    }
}

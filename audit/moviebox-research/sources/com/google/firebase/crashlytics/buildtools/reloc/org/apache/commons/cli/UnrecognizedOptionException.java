package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class UnrecognizedOptionException extends ParseException {
    private static final long serialVersionUID = -252504690284625623L;
    private String option;

    public UnrecognizedOptionException(String str) {
        super(str);
    }

    public UnrecognizedOptionException(String str, String str2) {
        this(str);
        this.option = str2;
    }

    public String getOption() {
        return this.option;
    }
}

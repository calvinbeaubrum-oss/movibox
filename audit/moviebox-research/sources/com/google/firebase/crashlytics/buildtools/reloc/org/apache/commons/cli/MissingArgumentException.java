package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MissingArgumentException extends ParseException {
    private static final long serialVersionUID = -7098538588704965017L;
    private Option option;

    public MissingArgumentException(Option option) {
        this("Missing argument for option: " + option.getKey());
        this.option = option;
    }

    public MissingArgumentException(String str) {
        super(str);
    }

    public Option getOption() {
        return this.option;
    }
}

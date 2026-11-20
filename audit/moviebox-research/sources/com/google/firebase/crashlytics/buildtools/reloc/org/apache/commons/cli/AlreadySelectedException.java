package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AlreadySelectedException extends ParseException {
    private static final long serialVersionUID = 3674381532418544760L;
    private OptionGroup group;
    private Option option;

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        this("The option '" + option.getKey() + "' was specified but an option from this group has already been selected: '" + optionGroup.getSelected() + "'");
        this.group = optionGroup;
        this.option = option;
    }

    public AlreadySelectedException(String str) {
        super(str);
    }

    public Option getOption() {
        return this.option;
    }

    public OptionGroup getOptionGroup() {
        return this.group;
    }
}

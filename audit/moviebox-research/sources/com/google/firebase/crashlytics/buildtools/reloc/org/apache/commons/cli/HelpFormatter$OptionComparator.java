package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class HelpFormatter$OptionComparator implements Comparator<Option>, Serializable {
    private static final long serialVersionUID = 5305467873966684014L;

    private HelpFormatter$OptionComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Option option, Option option2) {
        return option.getKey().compareToIgnoreCase(option2.getKey());
    }
}

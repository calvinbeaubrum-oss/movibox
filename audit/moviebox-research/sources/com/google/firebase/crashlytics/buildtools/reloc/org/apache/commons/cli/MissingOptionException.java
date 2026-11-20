package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MissingOptionException extends ParseException {
    private static final long serialVersionUID = 8161889051578563249L;
    private List missingOptions;

    public MissingOptionException(String str) {
        super(str);
    }

    public MissingOptionException(List list) {
        this(createMessage(list));
        this.missingOptions = list;
    }

    private static String createMessage(List<?> list) {
        StringBuilder sb2 = new StringBuilder("Missing required option");
        sb2.append(list.size() == 1 ? "" : "s");
        sb2.append(": ");
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public List getMissingOptions() {
        return this.missingOptions;
    }
}

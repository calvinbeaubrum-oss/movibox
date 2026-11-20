package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AmbiguousOptionException extends UnrecognizedOptionException {
    private static final long serialVersionUID = 5829816121277947229L;
    private final Collection<String> matchingOptions;

    public AmbiguousOptionException(String str, Collection<String> collection) {
        super(createMessage(str, collection), str);
        this.matchingOptions = collection;
    }

    private static String createMessage(String str, Collection<String> collection) {
        StringBuilder sb2 = new StringBuilder("Ambiguous option: '");
        sb2.append(str);
        sb2.append("'  (could be: ");
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb2.append("'");
            sb2.append(it.next());
            sb2.append("'");
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    public Collection<String> getMatchingOptions() {
        return this.matchingOptions;
    }
}

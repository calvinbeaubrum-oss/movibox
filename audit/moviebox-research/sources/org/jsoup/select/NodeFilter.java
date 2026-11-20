package org.jsoup.select;

import org.jsoup.nodes.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface NodeFilter {

    /* JADX INFO: compiled from: source.java */
    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }

    FilterResult a(g gVar, int i11);

    FilterResult b(g gVar, int i11);
}

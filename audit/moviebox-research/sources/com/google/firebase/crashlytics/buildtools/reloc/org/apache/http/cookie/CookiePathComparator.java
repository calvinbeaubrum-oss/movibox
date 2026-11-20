package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie;

import bk.a;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CookiePathComparator implements Serializable, Comparator<a> {
    public static final CookiePathComparator INSTANCE = new CookiePathComparator();
    private static final long serialVersionUID = 7523645369616405818L;

    private String normalizePath(a aVar) {
        String path = aVar.getPath();
        if (path == null) {
            path = "/";
        }
        if (path.endsWith("/")) {
            return path;
        }
        return path + '/';
    }

    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        String strNormalizePath = normalizePath(aVar);
        String strNormalizePath2 = normalizePath(aVar2);
        if (strNormalizePath.equals(strNormalizePath2)) {
            return 0;
        }
        if (strNormalizePath.startsWith(strNormalizePath2)) {
            return -1;
        }
        return strNormalizePath2.startsWith(strNormalizePath) ? 1 : 0;
    }
}

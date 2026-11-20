package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie;

import bk.a;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CookieIdentityComparator implements Serializable, Comparator<a> {
    private static final long serialVersionUID = 4466565437490631532L;

    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        int iCompareTo = aVar.getName().compareTo(aVar2.getName());
        if (iCompareTo == 0) {
            String domain = aVar.getDomain();
            String str = "";
            if (domain == null) {
                domain = "";
            } else if (domain.indexOf(46) == -1) {
                domain = domain + ".local";
            }
            String domain2 = aVar2.getDomain();
            if (domain2 != null) {
                if (domain2.indexOf(46) == -1) {
                    str = domain2 + ".local";
                } else {
                    str = domain2;
                }
            }
            iCompareTo = domain.compareToIgnoreCase(str);
        }
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        String path = aVar.getPath();
        if (path == null) {
            path = "/";
        }
        String path2 = aVar2.getPath();
        return path.compareTo(path2 != null ? path2 : "/");
    }
}

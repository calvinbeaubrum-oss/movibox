package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie;

import bk.a;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.cookie.BasicClientCookie;
import java.util.Comparator;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CookiePriorityComparator implements Comparator<a> {
    public static final CookiePriorityComparator INSTANCE = new CookiePriorityComparator();

    private int getPathLength(a aVar) {
        String path = aVar.getPath();
        if (path != null) {
            return path.length();
        }
        return 1;
    }

    @Override // java.util.Comparator
    public int compare(a aVar, a aVar2) {
        int pathLength = getPathLength(aVar2) - getPathLength(aVar);
        if (pathLength == 0 && (aVar instanceof BasicClientCookie) && (aVar2 instanceof BasicClientCookie)) {
            Date creationDate = ((BasicClientCookie) aVar).getCreationDate();
            Date creationDate2 = ((BasicClientCookie) aVar2).getCreationDate();
            if (creationDate != null && creationDate2 != null) {
                return (int) (creationDate.getTime() - creationDate2.getTime());
            }
        }
        return pathLength;
    }
}

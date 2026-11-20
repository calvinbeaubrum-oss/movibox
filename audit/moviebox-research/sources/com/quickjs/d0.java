package com.quickjs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d0 extends y {
    public String l0(String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            str2 = str2.replace("//", "/");
            if (str2.startsWith("./")) {
                str2 = str2.substring(2);
            }
            if (str2.charAt(0) == '/') {
                return str2;
            }
            if (str != null && str.length() != 0) {
                String strReplace = str.replace("//", "/");
                if (strReplace.startsWith("./")) {
                    strReplace = strReplace.substring(2);
                }
                if (strReplace.equals("/")) {
                    return "/" + str2;
                }
                if (strReplace.endsWith("/")) {
                    return strReplace + str2;
                }
                String[] strArrSplit = strReplace.split("/");
                String[] strArrSplit2 = str2.split("/");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Collections.addAll(arrayList, strArrSplit);
                Collections.addAll(arrayList2, strArrSplit2);
                while (!arrayList2.isEmpty() && ((String) arrayList2.get(0)).equals("..")) {
                    arrayList2.remove(0);
                    arrayList.remove(arrayList.size() - 1);
                }
                if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
                StringBuilder sb2 = new StringBuilder();
                if (strReplace.startsWith("/")) {
                    sb2.append("/");
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb2.append((String) it.next());
                    sb2.append("/");
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    sb2.append((String) it2.next());
                    sb2.append("/");
                }
                sb2.deleteCharAt(sb2.length() - 1);
                return sb2.toString();
            }
        }
        return str2;
    }

    public abstract String p0(String str);
}

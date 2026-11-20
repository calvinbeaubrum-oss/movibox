package com.transsion.transfer.androidasync.http;

import com.transsion.transfer.androidasync.util.TaggedList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Multimap f58594a = new Multimap() { // from class: com.transsion.transfer.androidasync.http.Headers.1
        @Override // com.transsion.transfer.androidasync.http.Multimap
        public List<String> newList() {
            return new TaggedList();
        }
    };

    public Headers a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.f58594a.add(lowerCase, str2);
        ((TaggedList) this.f58594a.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers b(String str) {
        if (str != null) {
            String[] strArrSplit = str.trim().split(":", 2);
            if (strArrSplit.length == 2) {
                a(strArrSplit[0].trim(), strArrSplit[1].trim());
            } else {
                a(strArrSplit[0].trim(), "");
            }
        }
        return this;
    }

    public String c(String str) {
        return this.f58594a.getString(str.toLowerCase(Locale.US));
    }

    public String d(String str) {
        List<String> listE = e(str.toLowerCase(Locale.US));
        if (listE == null || listE.size() == 0) {
            return null;
        }
        return listE.get(0);
    }

    public List<String> e(String str) {
        return this.f58594a.remove(str.toLowerCase(Locale.US));
    }

    public Headers f(String str, String str2) {
        if (str2 != null && (str2.contains("\n") || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f58594a.put(lowerCase, str2);
        ((TaggedList) this.f58594a.get(lowerCase)).tagNull(str);
        return this;
    }

    public String g(String str) {
        return h().insert(0, str + "\r\n").toString();
    }

    public StringBuilder h() {
        StringBuilder sb2 = new StringBuilder(256);
        Iterator<String> it = this.f58594a.keySet().iterator();
        while (it.hasNext()) {
            TaggedList<String> taggedList = (TaggedList) this.f58594a.get(it.next());
            for (String str : taggedList) {
                sb2.append((String) taggedList.tag());
                sb2.append(": ");
                sb2.append(str);
                sb2.append("\r\n");
            }
        }
        sb2.append("\r\n");
        return sb2;
    }

    public String toString() {
        return h().toString();
    }
}

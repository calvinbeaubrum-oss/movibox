package com.vungle.warren.utility;

import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static synchronized void a(HashSet hashSet, String str) {
        hashSet.add(str);
    }

    public static synchronized HashSet<String> b(HashSet<String> hashSet) {
        return new HashSet<>(hashSet);
    }
}

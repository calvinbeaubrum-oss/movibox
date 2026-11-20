package com.cloud.tmc.integration.permission.whitelist;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BridgeWhiteList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f30901a;

    static {
        ArrayList arrayList = new ArrayList();
        f30901a = arrayList;
        arrayList.add("remoteLog");
    }

    public static boolean isInWhiteList(String str) {
        return f30901a.contains(str);
    }
}

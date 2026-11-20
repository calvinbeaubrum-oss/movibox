package com.bytedance.sdk.component.pFF.sc;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExN extends SR {
    List<String> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    List<String> f26925sc;

    /* JADX INFO: compiled from: source.java */
    public static final class sc {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final List<String> f26926sc = new ArrayList();
        private final List<String> pFF = new ArrayList();

        public sc sc(String str, String str2) {
            this.f26926sc.add(str);
            this.pFF.add(str2);
            return this;
        }

        public ExN sc() {
            return new ExN(this.f26926sc, this.pFF);
        }
    }

    public ExN(List<String> list, List<String> list2) {
        this.f26925sc = list;
        this.pFF = list2;
    }
}

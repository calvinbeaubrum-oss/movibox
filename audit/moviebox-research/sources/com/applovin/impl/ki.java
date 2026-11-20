package com.applovin.impl;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ki implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o2.a f20254a = new o2.a() { // from class: com.applovin.impl.iz
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return ki.a(bundle);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static ki a(Bundle bundle) {
        int i11 = bundle.getInt(a(0), -1);
        if (i11 == 0) {
            return (ki) na.f21304d.a(bundle);
        }
        if (i11 == 1) {
            return (ki) gh.f19228c.a(bundle);
        }
        if (i11 == 2) {
            return (ki) cl.f18257d.a(bundle);
        }
        if (i11 == 3) {
            return (ki) co.f18267d.a(bundle);
        }
        throw new IllegalArgumentException("Encountered unknown rating type: " + i11);
    }

    private static String a(int i11) {
        return Integer.toString(i11, 36);
    }
}

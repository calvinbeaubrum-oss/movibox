package com.applovin.impl;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class po implements o2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final po f21808d = new po(new oo[0]);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o2.a f21809f = new o2.a() { // from class: com.applovin.impl.j10
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return po.a(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final oo[] f21811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21812c;

    public po(oo... ooVarArr) {
        this.f21811b = ooVarArr;
        this.f21810a = ooVarArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ po a(Bundle bundle) {
        return new po((oo[]) p2.a(oo.f21583d, bundle.getParcelableArrayList(b(0)), eb.h()).toArray(new oo[0]));
    }

    private static String b(int i11) {
        return Integer.toString(i11, 36);
    }

    public int a(oo ooVar) {
        for (int i11 = 0; i11 < this.f21810a; i11++) {
            if (this.f21811b[i11] == ooVar) {
                return i11;
            }
        }
        return -1;
    }

    public oo a(int i11) {
        return this.f21811b[i11];
    }

    public boolean a() {
        return this.f21810a == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || po.class != obj.getClass()) {
            return false;
        }
        po poVar = (po) obj;
        return this.f21810a == poVar.f21810a && Arrays.equals(this.f21811b, poVar.f21811b);
    }

    public int hashCode() {
        if (this.f21812c == 0) {
            this.f21812c = Arrays.hashCode(this.f21811b);
        }
        return this.f21812c;
    }
}

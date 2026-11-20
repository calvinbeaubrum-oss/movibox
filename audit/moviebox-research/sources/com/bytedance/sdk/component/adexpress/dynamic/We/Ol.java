package com.bytedance.sdk.component.adexpress.dynamic.We;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol {
    public float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public float f26748sc;

    public Ol(float f11, float f12) {
        this.f26748sc = f11;
        this.pFF = f12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Ol ol2 = (Ol) obj;
            if (Float.compare(ol2.f26748sc, this.f26748sc) == 0 && Float.compare(ol2.pFF, this.pFF) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f26748sc), Float.valueOf(this.pFF)});
    }
}

package com.bykv.vk.openvk.preload.a.b;

import java.math.BigDecimal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25522a;

    public f(String str) {
        this.f25522a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f25522a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        String str = this.f25522a;
        String str2 = ((f) obj).f25522a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f25522a);
    }

    public final int hashCode() {
        return this.f25522a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        try {
            try {
                return Integer.parseInt(this.f25522a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f25522a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f25522a).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        try {
            return Long.parseLong(this.f25522a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f25522a).longValue();
        }
    }

    public final String toString() {
        return this.f25522a;
    }
}

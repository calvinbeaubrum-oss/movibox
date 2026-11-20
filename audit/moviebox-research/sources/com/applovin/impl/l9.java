package com.applovin.impl;

import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l9 implements z4 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f20366d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f20367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f20368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f20369c;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z11;
        if ("Amazon".equals(xp.f24374c)) {
            String str = xp.f24375d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        f20366d = z11;
    }

    public l9(UUID uuid, byte[] bArr, boolean z11) {
        this.f20367a = uuid;
        this.f20368b = bArr;
        this.f20369c = z11;
    }
}

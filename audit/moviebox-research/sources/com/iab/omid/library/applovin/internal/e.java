package com.iab.omid.library.applovin.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.applovin.weakreference.a f42127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f42128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f42129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f42130d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f42127a = new com.iab.omid.library.applovin.weakreference.a(view);
        this.f42128b = view.getClass().getCanonicalName();
        this.f42129c = friendlyObstructionPurpose;
        this.f42130d = str;
    }

    public String a() {
        return this.f42130d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f42129c;
    }

    public com.iab.omid.library.applovin.weakreference.a c() {
        return this.f42127a;
    }

    public String d() {
        return this.f42128b;
    }
}

package com.iab.omid.library.mmadbridge.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pn.a f42361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f42362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FriendlyObstructionPurpose f42363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f42364d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f42361a = new pn.a(view);
        this.f42362b = view.getClass().getCanonicalName();
        this.f42363c = friendlyObstructionPurpose;
        this.f42364d = str;
    }

    public String a() {
        return this.f42364d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f42363c;
    }

    public pn.a c() {
        return this.f42361a;
    }

    public String d() {
        return this.f42362b;
    }
}

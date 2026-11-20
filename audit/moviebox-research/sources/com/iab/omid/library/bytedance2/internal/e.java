package com.iab.omid.library.bytedance2.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.weakreference.a f42256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f42257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f42258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f42259d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f42256a = new com.iab.omid.library.bytedance2.weakreference.a(view);
        this.f42257b = view.getClass().getCanonicalName();
        this.f42258c = friendlyObstructionPurpose;
        this.f42259d = str;
    }

    public String a() {
        return this.f42259d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f42258c;
    }

    public com.iab.omid.library.bytedance2.weakreference.a c() {
        return this.f42256a;
    }

    public String d() {
        return this.f42257b;
    }
}

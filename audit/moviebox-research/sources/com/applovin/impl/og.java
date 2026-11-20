package com.applovin.impl;

import android.view.View;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class og {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f21530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FriendlyObstructionPurpose f21531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21532c;

    public og(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f21530a = view;
        this.f21531b = friendlyObstructionPurpose;
        this.f21532c = str;
    }

    public String a() {
        return this.f21532c;
    }

    public FriendlyObstructionPurpose b() {
        return this.f21531b;
    }

    public View c() {
        return this.f21530a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        og ogVar = (og) obj;
        View view = this.f21530a;
        if (view == null ? ogVar.f21530a != null : !view.equals(ogVar.f21530a)) {
            return false;
        }
        if (this.f21531b != ogVar.f21531b) {
            return false;
        }
        String str = this.f21532c;
        String str2 = ogVar.f21532c;
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public int hashCode() {
        View view = this.f21530a;
        int iHashCode = (view != null ? view.hashCode() : 0) * 31;
        FriendlyObstructionPurpose friendlyObstructionPurpose = this.f21531b;
        int iHashCode2 = (iHashCode + (friendlyObstructionPurpose != null ? friendlyObstructionPurpose.hashCode() : 0)) * 31;
        String str = this.f21532c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }
}

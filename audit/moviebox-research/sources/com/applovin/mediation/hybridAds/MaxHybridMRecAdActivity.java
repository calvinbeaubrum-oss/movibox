package com.applovin.mediation.hybridAds;

import android.os.Bundle;
import android.view.View;
import com.applovin.impl.bd;
import com.applovin.impl.cd;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MaxHybridMRecAdActivity extends bd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f24962f;

    public void a(cd cdVar, View view, j jVar, MaxAdapterListener maxAdapterListener) {
        super.a(cdVar, jVar, maxAdapterListener);
        this.f24962f = view;
    }

    @Override // com.applovin.impl.bd, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.f24962f, "MaxHybridMRecAdActivity");
    }
}

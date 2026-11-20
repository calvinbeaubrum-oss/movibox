package com.mbridge.msdk.foundation.same.g;

import android.webkit.DownloadListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f44523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f44524b;

    public a() {
    }

    public a(CampaignEx campaignEx) {
        this.f44524b = campaignEx;
    }

    public final void a(String str) {
        this.f44523a = str;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
    }
}

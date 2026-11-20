package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k implements bj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f38084a;

    public k(l lVar, Activity activity) {
        this.f38084a = activity;
    }

    @Override // bj.a
    public final void a(IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException {
        this.f38084a.startIntentSenderForResult(intentSender, i11, intent, i12, i13, i14, bundle);
    }
}

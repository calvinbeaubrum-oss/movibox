package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import t3.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zbw implements a.InterfaceC0847a {
    final /* synthetic */ SignInHubActivity zba;

    public /* synthetic */ zbw(SignInHubActivity signInHubActivity, zbv zbvVar) {
        this.zba = signInHubActivity;
    }

    @Override // t3.a.InterfaceC0847a
    public final androidx.loader.content.a onCreateLoader(int i11, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    @Override // t3.a.InterfaceC0847a
    public final /* bridge */ /* synthetic */ void onLoadFinished(androidx.loader.content.a aVar, Object obj) {
        SignInHubActivity signInHubActivity = this.zba;
        signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
        this.zba.finish();
    }

    @Override // t3.a.InterfaceC0847a
    public final void onLoaderReset(androidx.loader.content.a aVar) {
    }
}

package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.FI;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Ql;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTAdActivity extends TTBaseActivity {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private pFF f27505sc;

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.sc((Activity) this);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        pFF pff = this.f27505sc;
        if (pff == null) {
            super.onBackPressed();
        } else {
            pff.We();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.sc.ExN.sc scVarZY = FI.sc().zY();
        com.bytedance.sdk.openadsdk.sc.zY.pFF pffWe = FI.sc().We();
        Sfl sflSc = com.bytedance.sdk.openadsdk.component.reward.sc.pFF.sc(getIntent(), bundle, (com.bytedance.sdk.openadsdk.core.Ql.We.pFF) null);
        if (sflSc == null) {
            finish();
            return;
        }
        pFF pff = new pFF(this, sflSc);
        this.f27505sc = pff;
        pff.sc(this, bundle, scVarZY, pffWe);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.ExN(this);
        }
        FI.sc().sc((com.bytedance.sdk.openadsdk.sc.ExN.sc) null);
        FI.sc().sc((com.bytedance.sdk.openadsdk.sc.zY.pFF) null);
        Ql.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.zY(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.pFF(this);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.sc(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.sc(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.We(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        pFF pff = this.f27505sc;
        if (pff != null) {
            pff.sc(z11);
        }
    }
}

package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import com.bytedance.sdk.component.utils.Tf;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTBaseActivity extends Activity {

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected boolean f27515qr = false;

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        if (Build.VERSION.SDK_INT < 33) {
            super.onPause();
            return;
        }
        try {
            super.onPause();
        } catch (IllegalArgumentException e11) {
            Tf.sc("TTBaseActivity", "super.onPause(); run fail", e11);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            } catch (Exception e12) {
                Tf.sc("TTBaseActivity", "onPause() set mCalled fail", e12);
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 28 || i11 < 24) {
            super.onResume();
            return;
        }
        try {
            super.onResume();
        } catch (IllegalArgumentException e11) {
            Tf.sc("TTBaseActivity", "super.onResume() run fail", e11);
            try {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
            } catch (Exception e12) {
                Tf.sc("TTBaseActivity", "onResume set mCalled fail", e12);
            }
        }
    }

    public void pFF(boolean z11) {
        this.f27515qr = z11;
    }
}

package com.cloud.hisavana.sdk.common.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$layout;
import com.transsion.web.api.WebConstants;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MiniAppSchemeActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29261a = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_mini_app_scheme);
        try {
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        } catch (Throwable unused) {
        }
        this.f29261a = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f29261a || getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra(WebConstants.FIELD_DEEPLINK);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            try {
                Uri uri = Uri.parse(stringExtra);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(ASTNode.DEOP);
                startActivity(intent);
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29371a.M();
                    }
                }, 1000L);
            } catch (Exception unused) {
                com.cloud.hisavana.sdk.z.a().e("MiniApp", "Failed to launch mini app from homescreen.");
            }
        } finally {
            this.f29261a = true;
        }
    }
}

package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.widget.webview.ActionWebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdvertiserLinkActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f29212b = "AdvertiserLinkActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionWebView f29213a;

    private void M() {
        if (AdManager.f() == 1) {
            setRequestedOrientation(1);
        } else if (AdManager.f() == 0) {
            setRequestedOrientation(0);
        }
    }

    public final /* synthetic */ void O(View view) {
        onBackPressed();
    }

    public final void Q() {
        try {
            this.f29213a = new ActionWebView(this);
            ((FrameLayout) findViewById(R$id.webview_container)).addView(this.f29213a);
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().e(f29212b, "create webview error: " + Log.getStackTraceString(th2));
            this.f29213a = null;
            finish();
        }
        ActionWebView actionWebView = this.f29213a;
        if (actionWebView != null) {
            actionWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.f29213a.getSettings().setSupportZoom(true);
            this.f29213a.getSettings().setUseWideViewPort(true);
            this.f29213a.getSettings().setLoadWithOverviewMode(true);
            this.f29213a.getSettings().setDisplayZoomControls(true);
            this.f29213a.getSettings().setCacheMode(-1);
            this.f29213a.getSettings().setDomStorageEnabled(true);
            this.f29213a.setWebViewClient(new x9.b());
        }
    }

    public final void R() {
        if (this.f29213a == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            com.cloud.hisavana.sdk.z.a().w(f29212b, "url is null");
            return;
        }
        com.cloud.hisavana.sdk.z.a().d(f29212b, "url is: " + stringExtra);
        this.f29213a.loadUrl(stringExtra);
    }

    public final void S() {
        ImageView imageView = (ImageView) findViewById(R$id.im_back);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f29359a.O(view);
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        M();
        super.onCreate(bundle);
        setContentView(R$layout.activity_advertiser_link);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        S();
        Q();
        R();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            ActionWebView actionWebView = this.f29213a;
            if (actionWebView != null) {
                ViewParent parent = actionWebView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f29213a);
                }
                this.f29213a.stopLoading();
                this.f29213a.getSettings().setJavaScriptEnabled(false);
                this.f29213a.setWebChromeClient(null);
                this.f29213a.clearHistory();
                this.f29213a.removeAllViews();
                this.f29213a.destroy();
                this.f29213a = null;
            }
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().d(f29212b, Log.getStackTraceString(th2));
        }
        super.onDestroy();
    }
}

package com.cloud.tmc.miniapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.cloud.tmc.component_api_ps.async.MiniAppIpcAsyncManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.R$color;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.ui.MiniSchemaFilterActivity;
import com.cloud.tmc.miniutils.util.e0;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class MiniSchemaFilterActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f31709b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f31708a = "MiniSchemaFilterActivity";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f31710c = LazyKt__LazyJVMKt.b(new OooO00o());

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<FrameLayout> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public FrameLayout invoke() {
            return (FrameLayout) MiniSchemaFilterActivity.this.findViewById(R$id.fl_base_layout);
        }
    }

    public static final void b(MiniSchemaFilterActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            ByteAppManager.INSTANCE.setSchemeInitStatus(false);
            this$0.finish();
        } catch (Throwable th2) {
            Log.e(this$0.f31708a, "MiniSchemaFilterActivity finish: ", th2);
            this$0.finish();
        }
    }

    public static final void c(MiniSchemaFilterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        TmcLogger.c(this$0.f31708a, "mFlBaseLayout click");
    }

    public final Bundle a(Object obj) {
        if (!(obj instanceof Uri)) {
            if (obj instanceof Bundle) {
                return (Bundle) obj;
            }
            return null;
        }
        Uri uri = (Uri) obj;
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : queryParameterNames) {
            bundle.putString(str, uri.getQueryParameter(str));
        }
        bundle.putString("entranceUrl", uri.toString());
        return bundle;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        TmcLogger.c(this.f31708a, "oncreat");
        super.onCreate(bundle);
        e0.c(getApplication());
        setContentView(R$layout.activity_layout_mini_scheme);
        try {
            Window window = getWindow();
            if (window != null) {
                window.clearFlags(67108864);
            }
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            if (window != null) {
                window.setStatusBarColor(getColor(R$color.mini_color_transparent));
            }
            Object value = this.f31710c.getValue();
            Intrinsics.f(value, "<get-mFlBaseLayout>(...)");
            ((FrameLayout) value).setOnClickListener(new View.OnClickListener() { // from class: qd.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniSchemaFilterActivity.c(this.f74504a, view);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.h(this.f31708a, th2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.c(this.f31708a, "onDestroy");
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        TmcLogger.c(this.f31708a, "onNewIntent");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        TmcLogger.c(this.f31708a, "onPause");
    }

    @Override // android.app.Activity
    public void onResume() {
        String string;
        super.onResume();
        try {
            TmcLogger.c(this.f31708a, "onResume");
            try {
                ByteAppManager byteAppManager = ByteAppManager.INSTANCE;
                if (byteAppManager.getSchemeInitStatus()) {
                    TmcLogger.c(this.f31708a, "launchMiniAppForId: 已拉起");
                    finish();
                    return;
                }
                byteAppManager.setSchemeInitStatus(true);
                if (this.f31709b) {
                    TmcLogger.c(this.f31708a, "launchMiniAppForId: start  已拉起");
                    byteAppManager.setSchemeInitStatus(false);
                    finish();
                    return;
                }
                this.f31709b = true;
                Intent intent = getIntent();
                if (intent == null) {
                    return;
                }
                Bundle bundleA = a(intent.getData());
                if (bundleA == null) {
                    bundleA = a(intent.getExtras());
                }
                String string2 = bundleA != null ? bundleA.getString(PushConstants.PROVIDER_FIELD_APP_ID) : null;
                if (bundleA == null || (string = bundleA.getString(TrackingKey.SCENE_ID)) == null) {
                    string = "200008";
                }
                String str = "palmplay://thirdlauncher.com?entryType=miniapp&_source=miniapps&appId=" + string2 + "&from=10&scene_id=" + string;
                TmcLogger.c(this.f31708a, "launchMiniApp: start  psDeeplink = " + str);
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW");
                intent2.addFlags(ASTNode.DEOP);
                intent2.setData(Uri.parse(str));
                getApplication().startActivity(intent2);
                MiniAppIpcAsyncManager.f30347a.f(new Runnable() { // from class: qd.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniSchemaFilterActivity.b(this.f74507a);
                    }
                }, 1000L);
            } catch (Throwable th2) {
                Log.e(this.f31708a, "MiniSchemaFilterActivity: ", th2);
            }
        } catch (Throwable th3) {
            Log.e(this.f31708a, "MiniSchemaFilterActivity:  finish ", th3);
            finish();
        }
    }
}

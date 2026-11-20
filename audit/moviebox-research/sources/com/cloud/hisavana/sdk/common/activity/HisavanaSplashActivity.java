package com.cloud.hisavana.sdk.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.r0;
import com.cloud.hisavana.sdk.u1;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class HisavanaSplashActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u1 f29255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29256c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29254a = "HisavanaSplashActivity";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29257d = false;

    private void L() {
        CountTimeView countTimeViewS0;
        u1 u1Var = this.f29255b;
        if (u1Var == null || (countTimeViewS0 = u1Var.S0()) == null) {
            return;
        }
        countTimeViewS0.setStartTime((int) this.f29256c);
        countTimeViewS0.start();
    }

    public static void M(Context context) {
        Intent intent = new Intent(context, (Class<?>) HisavanaSplashActivity.class);
        intent.setFlags(ASTNode.DEOP);
        context.startActivity(intent);
    }

    private void O() {
        r0.e().b(this);
        u1 u1VarF = r0.e().f();
        this.f29255b = u1VarF;
        if (u1VarF == null || !u1VarF.X0()) {
            finish();
            return;
        }
        setContentView(R$layout.activity_hisavana_splash);
        this.f29255b.h1((RelativeLayout) findViewById(R$id.splash_ad));
        this.f29255b.B1();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        setTitle((CharSequence) null);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        O();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        r0.e().d();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        u1 u1Var;
        CountTimeView countTimeViewS0;
        if (i11 == 4 && (u1Var = this.f29255b) != null && (countTimeViewS0 = u1Var.S0()) != null) {
            long supposeFinishTime = countTimeViewS0.getSupposeFinishTime();
            if (supposeFinishTime > 0 && supposeFinishTime > System.currentTimeMillis()) {
                return true;
            }
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.cloud.hisavana.sdk.z.a().d("HisavanaSplashActivity", "====================================再次进入");
        O();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        u1 u1Var = this.f29255b;
        if (u1Var != null) {
            CountTimeView countTimeViewS0 = u1Var.S0();
            if (countTimeViewS0 != null) {
                this.f29256c = countTimeViewS0.getRemainder() / 1000;
                countTimeViewS0.cancel();
            }
            this.f29255b.x1();
        }
        this.f29257d = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com.cloud.hisavana.sdk.z.a().d("HisavanaSplashActivity", "onResume");
        super.onResume();
        u1 u1Var = this.f29255b;
        if (u1Var != null && u1Var.V0()) {
            AdsDTO adsDTOF1 = this.f29255b.F1();
            if (adsDTOF1 != null && !adsDTOF1.isInteractiveAd()) {
                L();
            }
            this.f29255b.M0();
            this.f29255b.O0();
            this.f29257d = false;
            return;
        }
        u1 u1Var2 = this.f29255b;
        if (u1Var2 != null && u1Var2.V0() && this.f29255b.v1()) {
            L();
            this.f29257d = false;
            return;
        }
        u1 u1Var3 = this.f29255b;
        if (u1Var3 == null || !u1Var3.v1()) {
            if (this.f29257d) {
                L();
            }
            this.f29257d = true;
        } else {
            com.cloud.hisavana.sdk.z.a().d("HisavanaSplashActivity", "close ad");
            finish();
            s9.a aVarL = this.f29255b.l();
            if (aVarL != null) {
                aVarL.b();
            }
            this.f29257d = false;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.cloud.hisavana.sdk.z.a().d("HisavanaSplashActivity", "onStart");
    }
}

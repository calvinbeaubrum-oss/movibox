package com.vungle.warren;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.ui.VungleActivity;
import com.vungle.warren.ui.state.BundleOptionsState;
import com.vungle.warren.ui.view.FullAdWidget;
import java.util.concurrent.atomic.AtomicBoolean;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AdActivity extends Activity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static b10.b.a f61684k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public b10.b f61685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f61686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdRequest f61687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f61688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c10.a f61689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicBoolean f61690g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f61691h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f61692i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r.a f61693j = new d();

    /* JADX INFO: compiled from: source.java */
    public class a implements a10.a {
        public a() {
        }

        @Override // a10.a
        public void close() {
            AdActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements a10.e {
        public b() {
        }

        @Override // a10.e
        public void setOrientation(int i11) {
            AdActivity.this.setRequestedOrientation(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("command");
            stringExtra.hashCode();
            if (stringExtra.equals("stopAll")) {
                AdActivity.this.finish();
                return;
            }
            VungleLogger.j(AdActivity.class.getSimpleName() + "#connectBroadcastReceiver", String.format("Receiving Invalid Broadcast: %1$s", stringExtra));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements r.a {
        public d() {
        }

        @Override // com.vungle.warren.r.a
        public void a(@NonNull Pair<b10.a, b10.b> pair, @Nullable VungleException vungleException) {
            if (vungleException != null) {
                AdActivity.this.f61688d = null;
                AdActivity.this.m(vungleException.getExceptionCode(), AdActivity.this.f61687c);
                AdActivity.this.finish();
                return;
            }
            AdActivity.this.f61685a = (b10.b) pair.second;
            AdActivity.this.f61685a.o(AdActivity.f61684k);
            AdActivity.this.f61685a.j((b10.a) pair.first, AdActivity.this.f61689f);
            if (AdActivity.this.f61690g.getAndSet(false)) {
                AdActivity.this.p();
            }
        }
    }

    @NonNull
    public static Intent l(Context context, AdRequest adRequest) {
        Intent intent = new Intent(context, (Class<?>) VungleActivity.class);
        intent.addFlags(ASTNode.DEOP);
        Bundle bundle = new Bundle();
        bundle.putSerializable(PermissionConstant.ACTION_REQUEST, adRequest);
        intent.putExtras(bundle);
        return intent;
    }

    @Nullable
    public static AdRequest n(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return (AdRequest) extras.getSerializable(PermissionConstant.ACTION_REQUEST);
        }
        return null;
    }

    public static void o(b10.b.a aVar) {
        f61684k = aVar;
    }

    public abstract boolean j();

    public final void k() {
        this.f61686b = new c();
        u3.a.b(getApplicationContext()).c(this.f61686b, new IntentFilter("AdvertisementBus"));
    }

    public final void m(int i11, AdRequest adRequest) {
        VungleException vungleException = new VungleException(i11);
        b10.b.a aVar = f61684k;
        if (aVar != null) {
            aVar.b(vungleException, adRequest.getPlacementId());
        }
        VungleLogger.c(AdActivity.class.getSimpleName() + "#deliverError", vungleException.getLocalizedMessage());
    }

    @Override // android.app.Activity
    @SuppressLint({"ResourceType"})
    public void onBackPressed() {
        b10.b bVar = this.f61685a;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i11 = configuration.orientation;
        b10.b bVar = this.f61685a;
        if (bVar != null) {
            bVar.l();
        }
    }

    @Override // android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        AdRequest adRequest;
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(16777216, 16777216);
        this.f61687c = n(getIntent());
        t tVarF = t.f(this);
        if (!((y) tVarF.h(y.class)).isInitialized() || f61684k == null || (adRequest = this.f61687c) == null || TextUtils.isEmpty(adRequest.getPlacementId())) {
            finish();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        VungleLogger.i(true, "VungleActivity", "ttDownloadContext", String.format("Creating ad, request = %1$s, at: %2$d", this.f61687c, Long.valueOf(jCurrentTimeMillis)));
        try {
            FullAdWidget fullAdWidget = new FullAdWidget(this, getWindow());
            this.f61688d = (r) tVarF.h(r.class);
            c10.a aVar = bundle == null ? null : (c10.a) bundle.getParcelable("presenter_state");
            this.f61689f = aVar;
            this.f61688d.c(this, this.f61687c, fullAdWidget, aVar, new a(), new b(), bundle, this.f61693j);
            setContentView(fullAdWidget, fullAdWidget.getLayoutParams());
            k();
            VungleLogger.i(true, "VungleActivity", "ttDownloadContext", String.format("Ad created, request = %1$s, elapsed time: %2$dms", this.f61687c, Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        } catch (InstantiationException unused) {
            m(10, this.f61687c);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        u3.a.b(getApplicationContext()).e(this.f61686b);
        b10.b bVar = this.f61685a;
        if (bVar != null) {
            bVar.s((isChangingConfigurations() ? 1 : 0) | 2);
        } else {
            r rVar = this.f61688d;
            if (rVar != null) {
                rVar.destroy();
                this.f61688d = null;
                m(25, this.f61687c);
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        AdRequest adRequestN = n(getIntent());
        AdRequest adRequestN2 = n(intent);
        String placementId = adRequestN != null ? adRequestN.getPlacementId() : null;
        String placementId2 = adRequestN2 != null ? adRequestN2.getPlacementId() : null;
        if (placementId == null || placementId2 == null || placementId.equals(placementId2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tried to play another placement ");
        sb2.append(placementId2);
        sb2.append(" while playing ");
        sb2.append(placementId);
        m(15, adRequestN2);
        VungleLogger.j(AdActivity.class.getSimpleName() + "#onNewIntent", String.format("Tried to play another placement %1$s while playing %2$s", placementId2, placementId));
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f61692i = false;
        q();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        b10.b bVar;
        super.onRestoreInstanceState(bundle);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onRestoreInstanceState(");
        sb2.append(bundle);
        sb2.append(")");
        if (bundle == null || (bVar = this.f61685a) == null) {
            return;
        }
        bVar.n((c10.a) bundle.getParcelable("presenter_state"));
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f61692i = true;
        p();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        BundleOptionsState bundleOptionsState = new BundleOptionsState();
        b10.b bVar = this.f61685a;
        if (bVar != null) {
            bVar.p(bundleOptionsState);
            bundle.putParcelable("presenter_state", bundleOptionsState);
        }
        r rVar = this.f61688d;
        if (rVar != null) {
            rVar.d(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            p();
        } else {
            q();
        }
    }

    public final void p() {
        if (this.f61685a == null) {
            this.f61690g.set(true);
        } else if (!this.f61691h && this.f61692i && hasWindowFocus()) {
            this.f61685a.start();
            this.f61691h = true;
        }
    }

    public final void q() {
        if (this.f61685a != null && this.f61691h) {
            this.f61685a.m((isChangingConfigurations() ? 1 : 0) | (isFinishing() ? 2 : 0));
            this.f61691h = false;
        }
        this.f61690g.set(false);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i11) {
        if (j()) {
            super.setRequestedOrientation(i11);
        }
    }
}

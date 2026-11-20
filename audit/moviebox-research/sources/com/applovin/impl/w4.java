package com.applovin.impl;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w4 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x4 f24047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f24048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ListView f24049c;

    /* JADX INFO: compiled from: source.java */
    public class a implements ec.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f24050a;

        /* JADX INFO: renamed from: com.applovin.impl.w4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0204a implements r.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ lb f24052a;

            public C0204a(lb lbVar) {
                this.f24052a = lbVar;
            }

            @Override // com.applovin.impl.r.b
            public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
                maxCreativeDebuggerDisplayedAdActivity.a((w6) w4.this.f24047a.d().get(this.f24052a.a()), w4.this.f24047a.e());
            }
        }

        public a(q qVar) {
            this.f24050a = qVar;
        }

        @Override // com.applovin.impl.ec.a
        public void a(lb lbVar, dc dcVar) {
            if (lbVar.b() != x4.a.RECENT_ADS.ordinal()) {
                return;
            }
            r.a(w4.this, MaxCreativeDebuggerDisplayedAdActivity.class, this.f24050a, new C0204a(lbVar));
        }
    }

    private void a(int i11) {
        TextView textView = new TextView(this);
        textView.setGravity(17);
        textView.setTextSize(18.0f);
        textView.setText(i11);
        this.f24048b.addView(textView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f24048b.bringChildToFront(textView);
    }

    public void a(x4 x4Var, q qVar) {
        this.f24047a = x4Var;
        x4Var.a(new a(qVar));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Creative Debugger");
        setContentView(R.layout.mediation_debugger_list_view);
        this.f24048b = (FrameLayout) findViewById(android.R.id.content);
        this.f24049c = (ListView) findViewById(R.id.listView);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        x4 x4Var = this.f24047a;
        if (x4Var != null) {
            x4Var.a((ec.a) null);
            this.f24047a.g();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        x4 x4Var = this.f24047a;
        if (x4Var == null) {
            finish();
            return;
        }
        this.f24049c.setAdapter((ListAdapter) x4Var);
        x4 x4Var2 = this.f24047a;
        if (x4Var2 != null && !x4Var2.e().w().g()) {
            a(R.string.applovin_creative_debugger_disabled_text);
            return;
        }
        x4 x4Var3 = this.f24047a;
        if (x4Var3 == null || !x4Var3.f()) {
            return;
        }
        a(R.string.applovin_creative_debugger_no_ads_text);
    }
}

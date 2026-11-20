package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u6 extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w6 f23523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f23525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f23526d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f23524b.w().a(this.f23523a, (Context) this, true);
    }

    private boolean a() {
        return (this.f23523a == null || this.f23524b == null) ? false : true;
    }

    private void b() {
        qc qcVar = new qc();
        qcVar.a(this.f23524b.w().a(this.f23523a));
        String strB = this.f23524b.w().b(this.f23523a.a());
        if (strB != null) {
            qcVar.a("\nBid Response Preview:\n");
            qcVar.a(strB);
        }
        TextView textView = (TextView) findViewById(R.id.email_report_tv);
        this.f23525c = textView;
        textView.setText(qcVar.toString());
        this.f23525c.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void a(w6 w6Var, com.applovin.impl.sdk.j jVar) {
        this.f23523a = w6Var;
        this.f23524b = jVar;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!a()) {
            finish();
            return;
        }
        setTitle(this.f23523a.c() + " - " + this.f23523a.d());
        setContentView(R.layout.creative_debugger_displayed_ad_detail_activity);
        b();
        Button button = (Button) findViewById(R.id.report_ad_button);
        this.f23526d = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.n60
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21290a.a(view);
            }
        });
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.creative_debugger_displayed_ad_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!a()) {
            finish();
            return false;
        }
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f23524b.w().a(this.f23523a, (Context) this, false);
        return true;
    }
}

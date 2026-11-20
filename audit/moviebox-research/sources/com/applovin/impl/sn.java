package com.applovin.impl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sn extends se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.sdk.j f23121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23123c;

    private void a() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", this.f23123c);
        intent.putExtra("android.intent.extra.TITLE", this.f23122b);
        intent.putExtra("android.intent.extra.SUBJECT", this.f23122b);
        startActivity(Intent.createChooser(intent, null));
    }

    @Override // com.applovin.impl.se
    public com.applovin.impl.sdk.j getSdk() {
        return this.f23121a;
    }

    public void initialize(String str, String str2, com.applovin.impl.sdk.j jVar) {
        this.f23121a = jVar;
        this.f23122b = str;
        this.f23123c = str2;
    }

    @Override // com.applovin.impl.se, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mediation_debugger_text_view_activity);
        setTitle(this.f23122b);
        ((TextView) findViewById(R.id.textView)).setText(this.f23123c);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_share != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }
}

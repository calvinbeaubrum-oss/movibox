package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f20195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f20196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlertDialog f20197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f20198d;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b();

        void c();
    }

    public kb(Activity activity, com.applovin.impl.sdk.j jVar) {
        this.f20195a = jVar;
        this.f20196b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i11) {
        this.f20198d.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, final Runnable runnable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f20196b);
        builder.setTitle(bVar.a0());
        String strY = bVar.Y();
        if (AppLovinSdkUtils.isValidString(strY)) {
            builder.setMessage(strY);
        }
        builder.setPositiveButton(bVar.Z(), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.cz
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                kb.a(runnable, dialogInterface, i11);
            }
        });
        builder.setCancelable(false);
        this.f20197c = builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, DialogInterface dialogInterface, int i11) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i11) {
        this.f20198d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        AlertDialog alertDialog = this.f20197c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f20197c = new AlertDialog.Builder(this.f20196b).setTitle((CharSequence) this.f20195a.a(sj.f23062t1)).setMessage((CharSequence) this.f20195a.a(sj.f23070u1)).setCancelable(false).setPositiveButton((CharSequence) this.f20195a.a(sj.f23086w1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.fz
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f19135a.a(dialogInterface, i11);
            }
        }).setNegativeButton((CharSequence) this.f20195a.a(sj.f23078v1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.gz
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f19306a.b(dialogInterface, i11);
            }
        }).show();
    }

    public void a() {
        this.f20196b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hz
            @Override // java.lang.Runnable
            public final void run() {
                this.f19553a.c();
            }
        });
    }

    public void a(a aVar) {
        this.f20198d = aVar;
    }

    public void b(final com.applovin.impl.sdk.ad.b bVar, final Runnable runnable) {
        this.f20196b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ez
            @Override // java.lang.Runnable
            public final void run() {
                this.f18794a.a(bVar, runnable);
            }
        });
    }

    public boolean b() {
        AlertDialog alertDialog = this.f20197c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public void e() {
        this.f20196b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.dz
            @Override // java.lang.Runnable
            public final void run() {
                this.f18517a.d();
            }
        });
    }
}

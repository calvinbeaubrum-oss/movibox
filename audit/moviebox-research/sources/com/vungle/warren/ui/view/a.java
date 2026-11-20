package com.vungle.warren.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b10.b;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.ActivityManager;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T extends b10.b> implements b10.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a10.e f62526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a10.a f62527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f62528c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f62529d = getClass().getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FullAdWidget f62530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f62531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Dialog f62532h;

    /* JADX INFO: renamed from: com.vungle.warren.ui.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class DialogInterfaceOnClickListenerC0636a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f62533a;

        public DialogInterfaceOnClickListenerC0636a(DialogInterface.OnClickListener onClickListener) {
            this.f62533a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            a.this.f62532h = null;
            DialogInterface.OnClickListener onClickListener = this.f62533a;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements DialogInterface.OnDismissListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a.this.f62532h = null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            a aVar = a.this;
            aVar.f62532h.setOnDismissListener(aVar.a());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicReference<DialogInterface.OnClickListener> f62537a = new AtomicReference<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AtomicReference<DialogInterface.OnDismissListener> f62538b = new AtomicReference<>();

        public d(DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
            this.f62537a.set(onClickListener);
            this.f62538b.set(onDismissListener);
        }

        public final void b(Dialog dialog) {
            dialog.setOnDismissListener(this);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i11) {
            dialogInterface.dismiss();
            DialogInterface.OnClickListener onClickListener = this.f62537a.get();
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i11);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            DialogInterface.OnDismissListener onDismissListener = this.f62538b.get();
            if (onDismissListener != null) {
                onDismissListener.onDismiss(dialogInterface);
            }
            this.f62538b.set(null);
            this.f62537a.set(null);
        }
    }

    public a(@NonNull Context context, @NonNull FullAdWidget fullAdWidget, @NonNull a10.e eVar, @NonNull a10.a aVar) {
        this.f62530f = fullAdWidget;
        this.f62531g = context;
        this.f62526a = eVar;
        this.f62527b = aVar;
    }

    @NonNull
    public DialogInterface.OnDismissListener a() {
        return new b();
    }

    public boolean b() {
        return this.f62532h != null;
    }

    @Override // b10.a
    public void close() {
        this.f62527b.close();
    }

    @Override // b10.a
    public void destroyAdView(long j11) {
        this.f62530f.release(j11);
    }

    @Override // b10.a
    public String getWebsiteUrl() {
        return this.f62530f.getUrl();
    }

    @Override // b10.a
    public boolean hasWebView() {
        return this.f62530f.hasWebView();
    }

    @Override // b10.a
    public void open(String str, @NonNull String str2, ActivityManager.d dVar, PresenterAdOpenCallback presenterAdOpenCallback) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Opening ");
        sb2.append(str2);
        if (com.vungle.warren.utility.g.b(str, str2, this.f62531g, dVar, false, presenterAdOpenCallback)) {
            return;
        }
        Log.e(this.f62529d, "Cannot open url " + str2);
    }

    @Override // b10.a
    public void pauseWeb() {
        this.f62530f.pauseWeb();
    }

    @Override // b10.a
    public void refreshDialogIfVisible() {
        if (b()) {
            this.f62532h.setOnDismissListener(new c());
            this.f62532h.dismiss();
            this.f62532h.show();
        }
    }

    @Override // b10.a
    public void removeWebView() {
        this.f62530f.destroyWebView(0L);
    }

    @Override // b10.a
    public void resumeWeb() {
        this.f62530f.resumeWeb();
    }

    @Override // b10.a
    public void setImmersiveMode() {
        this.f62530f.setImmersiveMode();
    }

    @Override // b10.a
    public void setOrientation(int i11) {
        this.f62526a.setOrientation(i11);
    }

    @Override // b10.a
    public void showCloseButton() {
        this.f62530f.showCloseButton(true);
    }

    @Override // b10.a
    public void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener) {
        Context context = this.f62531g;
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, context.getApplicationInfo().theme));
        d dVar = new d(new DialogInterfaceOnClickListenerC0636a(onClickListener), a());
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setPositiveButton(str3, dVar);
        builder.setNegativeButton(str4, dVar);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.f62532h = alertDialogCreate;
        dVar.b(alertDialogCreate);
        this.f62532h.show();
    }
}

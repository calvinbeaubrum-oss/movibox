package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzayr implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbm)).longValue();

    @Nullable
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzazd zzj;
    private final com.google.android.gms.ads.internal.util.zzcb zzk = new com.google.android.gms.ads.internal.util.zzcb(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzayr(Context context, View view) {
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zze = application;
            this.zzj = new zzazd(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i11) {
        return (int) (i11 / this.zzo.density);
    }

    private final void zzi(Activity activity, int i11) {
        Window window;
        if (this.zzb == null || (window = activity.getWindow()) == null) {
            return;
        }
        WeakReference weakReference = this.zzb;
        View viewPeekDecorView = window.peekDecorView();
        View view = (View) weakReference.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.zzm = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:54:0x0135  */
    /* JADX WARN: Code duplicated, block: B:56:0x013a  */
    /* JADX WARN: Code duplicated, block: B:57:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0140  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzj(int i11) {
        WeakReference weakReference;
        View view;
        boolean globalVisibleRect;
        boolean localVisibleRect;
        List listEmptyList;
        boolean z11;
        boolean z12;
        if (this.zzn.isEmpty() || (weakReference = this.zzb) == null) {
            return;
        }
        View view2 = (View) weakReference.get();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view2 != null) {
            globalVisibleRect = view2.getGlobalVisibleRect(rect2);
            localVisibleRect = view2.getLocalVisibleRect(rect3);
            view2.getHitRect(rect4);
            try {
                view2.getLocationOnScreen(iArr);
                view2.getLocationInWindow(iArr2);
            } catch (Exception e11) {
                zzcec.zzh("Failure getting view location.", e11);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeM)).booleanValue()) {
                rect.left = iArr2[0];
                rect.top = iArr2[1];
            } else {
                rect.left = iArr[0];
                rect.top = iArr[1];
            }
            rect.right = rect.left + view2.getWidth();
            rect.bottom = rect.top + view2.getHeight();
            view = view2;
        } else {
            view = null;
            globalVisibleRect = false;
            localVisibleRect = false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbp)).booleanValue() || view == null) {
            listEmptyList = Collections.emptyList();
        } else {
            try {
                listEmptyList = new ArrayList();
                ViewParent parent = view.getParent();
                while (parent instanceof View) {
                    View view3 = (View) parent;
                    Rect rect5 = new Rect();
                    if (view3.isScrollContainer() && view3.getGlobalVisibleRect(rect5)) {
                        listEmptyList.add(zza(rect5));
                    }
                    parent = parent.getParent();
                }
            } catch (Exception e12) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e12, "PositionWatcher.getParentScrollViewRects");
                listEmptyList = Collections.emptyList();
            }
        }
        List list = listEmptyList;
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i12 = this.zzm;
        if (i12 != -1) {
            windowVisibility = i12;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        long jZzv = com.google.android.gms.ads.internal.util.zzt.zzv(view);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkc)).booleanValue()) {
            if (view2 != null) {
                PowerManager powerManager = this.zzg;
                KeyguardManager keyguardManager = this.zzh;
                com.google.android.gms.ads.internal.zzt.zzp();
                if (com.google.android.gms.ads.internal.util.zzt.zzR(view, powerManager, keyguardManager)) {
                    if (!globalVisibleRect) {
                        z11 = 0;
                        globalVisibleRect = false;
                    } else if (localVisibleRect) {
                        if (jZzv < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkf)).intValue() || windowVisibility != 0) {
                            z12 = false;
                        } else {
                            z12 = true;
                            windowVisibility = 0;
                        }
                        globalVisibleRect = true;
                        localVisibleRect = true;
                        z11 = z12;
                    } else {
                        z11 = 0;
                        globalVisibleRect = true;
                        localVisibleRect = false;
                    }
                }
            }
            z11 = 0;
        } else {
            if (view2 != null) {
                PowerManager powerManager2 = this.zzg;
                KeyguardManager keyguardManager2 = this.zzh;
                com.google.android.gms.ads.internal.zzt.zzp();
                if (com.google.android.gms.ads.internal.util.zzt.zzR(view, powerManager2, keyguardManager2)) {
                    if (!globalVisibleRect) {
                        z11 = 0;
                        globalVisibleRect = false;
                    } else if (localVisibleRect) {
                        if (windowVisibility == 0) {
                            z12 = true;
                            windowVisibility = 0;
                        } else {
                            z12 = false;
                        }
                        globalVisibleRect = true;
                        localVisibleRect = true;
                        z11 = z12;
                    } else {
                        z11 = 0;
                        globalVisibleRect = true;
                        localVisibleRect = false;
                    }
                }
            }
            z11 = 0;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkh)).booleanValue()) {
            PowerManager powerManager3 = this.zzg;
            KeyguardManager keyguardManager3 = this.zzh;
            com.google.android.gms.ads.internal.zzt.zzp();
            int i13 = true != com.google.android.gms.ads.internal.util.zzt.zzR(view, powerManager3, keyguardManager3) ? 0 : 64;
            int i14 = true != globalVisibleRect ? 0 : 8;
            int i15 = true != localVisibleRect ? 0 : 16;
            int i16 = windowVisibility == 0 ? 128 : 0;
            int i17 = jZzv >= ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkf)).intValue()) ? 32 : 0;
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzI(view, i17 | i16 | i13 | i14 | i15 | z11, null);
        }
        if (i11 == 1 && !this.zzk.zzb() && z11 == this.zzl) {
            return;
        }
        if (z11 == 0 && !this.zzl) {
            if (i11 == 1) {
                return;
            }
        }
        zzayp zzaypVar = new zzayp(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), this.zzg.isScreenOn(), view != null && view.isAttachedToWindow(), view != null ? view.getWindowVisibility() : 8, zza(this.zzp), zza(rect), zza(rect2), globalVisibleRect, zza(rect3), localVisibleRect, jZzv, zza(rect4), this.zzo.density, z11, list);
        Iterator it = this.zzn.iterator();
        while (it.hasNext()) {
            ((zzayq) it.next()).zzby(zzaypVar);
        }
        this.zzl = z11;
    }

    private final void zzk() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzayn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzayo(this);
            com.google.android.gms.ads.internal.zzt.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e11) {
                zzcec.zzh("Error registering activity lifecycle callbacks.", e11);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e11) {
            zzcec.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e11);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e12) {
            zzcec.zzh("Error while unregistering listeners from the ViewTreeObserver.", e12);
        }
        if (this.zza != null) {
            try {
                com.google.android.gms.ads.internal.zzt.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e13) {
                zzcec.zzh("Failed trying to unregister the receiver", e13);
            } catch (Exception e14) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e14, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e15) {
                zzcec.zzh("Error registering activity lifecycle callbacks.", e15);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzj(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzayq zzayqVar) {
        this.zzn.add(zzayqVar);
        zzj(3);
    }

    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzayq zzayqVar) {
        this.zzn.remove(zzayqVar);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j11) {
        this.zzk.zza(j11);
    }
}

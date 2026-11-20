package com.transsion.baselib.locale;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0557a f51209d = new C0557a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<b> f51210a = new SparseArray<>(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f51212c;

    /* JADX INFO: renamed from: com.transsion.baselib.locale.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0557a {
        public C0557a() {
        }

        public /* synthetic */ C0557a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f51213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Locale f51214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Locale f51215c;

        public b(Activity activity) {
            Intrinsics.g(activity, "activity");
            this.f51213a = activity;
        }

        public final Activity a() {
            return this.f51213a;
        }

        public final Locale b() {
            return this.f51215c;
        }

        public final Locale c() {
            return this.f51214b;
        }

        public final void d(Locale locale) {
            this.f51215c = locale;
        }

        public final void e(Locale locale) {
            this.f51214b = locale;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(View view) {
        if (view instanceof bs.a) {
            ((bs.a) view).changeLocal();
        } else if (view instanceof ViewGroup) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    public final void b(Activity activity) {
        uo.b.a.f(uo.b.f78622a, "LocaleManagerCB", "notifyActivityChangedLocale()-> activity = " + activity + " , waitChangedCount = " + this.f51211b, false, 4, null);
        if (this.f51211b <= 0) {
            return;
        }
        b bVar = this.f51210a.get(System.identityHashCode(activity));
        if ((bVar != null ? bVar.c() : null) == null) {
            return;
        }
        this.f51211b--;
        boolean z11 = TextUtils.getLayoutDirectionFromLocale(bVar.b()) == TextUtils.getLayoutDirectionFromLocale(bVar.c());
        bVar.d(bVar.c());
        bVar.e(null);
        if (z11) {
            return;
        }
        d(activity);
    }

    public final void c() {
        Integer num = this.f51212c;
        if (num == null) {
            return;
        }
        SparseArray<b> sparseArray = this.f51210a;
        Intrinsics.d(num);
        b bVar = sparseArray.get(num.intValue());
        if (bVar == null) {
            return;
        }
        b(bVar.a());
    }

    public final void d(Activity activity) {
        activity.finish();
        Intent intent = activity.getIntent();
        intent.putExtra("extra_language_activity_restart", true);
        activity.startActivity(intent);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0049  */
    public final void e(Locale locale) {
        int i11;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new UnsupportedOperationException();
        }
        int size = this.f51210a.size();
        if (size <= 0) {
            this.f51211b = 0;
            return;
        }
        int i12 = this.f51211b;
        int i13 = 0;
        while (i13 < size) {
            b bVarValueAt = this.f51210a.valueAt(i13);
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> localeState = " + bVarValueAt, false, 4, null);
            if (bVarValueAt == null) {
                i11 = size;
            } else {
                Activity activityA = bVarValueAt.a();
                boolean z11 = activityA.isFinishing() || activityA.isDestroyed();
                boolean z12 = z11;
                uo.b.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> activityFinished = " + z11, false, 4, null);
                if (z12) {
                    i11 = size;
                } else {
                    Locale localeB = bVarValueAt.b();
                    Intrinsics.d(localeB);
                    String language = localeB.getLanguage();
                    Intrinsics.d(locale);
                    String language2 = locale.getLanguage();
                    Locale localeC = bVarValueAt.c();
                    boolean z13 = TextUtils.getLayoutDirectionFromLocale(localeB) == TextUtils.getLayoutDirectionFromLocale(locale);
                    i11 = size;
                    uo.b.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> locale = " + locale + " , activityLocale = " + localeB + " , expectLocale = " + localeC + " , isSameDirection = " + z13, false, 4, null);
                    if (Intrinsics.b(language, language2)) {
                        bVarValueAt.e(null);
                        if (localeC != null) {
                            i12--;
                            uo.b.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount--", false, 4, null);
                        }
                    } else {
                        bVarValueAt.e(locale);
                        if (localeC == null) {
                            i12++;
                            uo.b.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount++", false, 4, null);
                        }
                        if (z13) {
                            Configuration configuration = activityA.getResources().getConfiguration();
                            Intrinsics.f(configuration, "activity.resources.configuration");
                            Resources resources = activityA.getResources();
                            Intrinsics.f(resources, "activity.resources");
                            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                            Intrinsics.f(displayMetrics, "resources.displayMetrics");
                            bVarValueAt.d(locale);
                            bVarValueAt.e(null);
                            configuration.setLocale(locale);
                            resources.updateConfiguration(configuration, displayMetrics);
                            View viewFindViewById = activityA.getWindow().getDecorView().findViewById(R.id.content);
                            if (viewFindViewById != null) {
                                a(viewFindViewById);
                            }
                        }
                    }
                }
            }
            i13++;
            size = i11;
        }
        this.f51211b = i12;
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.g(activity, "activity");
        int iIdentityHashCode = System.identityHashCode(activity);
        b bVar = new b(activity);
        bVar.d(LocaleManager.f51198f.d(activity));
        uo.b.a.f(uo.b.f78622a, "LocaleManagerCB", "onActivityCreated()-> " + activity + " , curLocale = " + bVar.b(), false, 4, null);
        this.f51210a.put(iIdentityHashCode, bVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.g(activity, "activity");
        int iIdentityHashCode = System.identityHashCode(activity);
        b bVar = this.f51210a.get(iIdentityHashCode);
        if ((bVar != null ? bVar.c() : null) != null) {
            bVar.e(null);
            this.f51211b--;
        }
        this.f51210a.remove(iIdentityHashCode);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.g(activity, "activity");
        int iIdentityHashCode = System.identityHashCode(activity);
        Integer num = this.f51212c;
        if (num == null || num == null || iIdentityHashCode != num.intValue()) {
            return;
        }
        this.f51212c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.g(activity, "activity");
        uo.b.a.f(uo.b.f78622a, "LocaleManagerCB", "onActivityResumed()-> " + activity, false, 4, null);
        this.f51212c = Integer.valueOf(System.identityHashCode(activity));
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.g(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.g(activity, "activity");
    }
}

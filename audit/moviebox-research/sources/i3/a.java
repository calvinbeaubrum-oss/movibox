package i3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.window.SplashScreenView;
import androidx.annotation.RequiresApi;
import androidx.core.splashscreen.R$attr;
import androidx.core.splashscreen.R$dimen;
import com.google.android.gms.common.api.Api;
import com.vungle.warren.error.VungleException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SuppressLint({"CustomSplashScreen"})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0705a f66893b = new C0705a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f66894a;

    /* JADX INFO: renamed from: i3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0705a {
        public C0705a() {
        }

        public /* synthetic */ C0705a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final a a(Activity activity) {
            Intrinsics.g(activity, "<this>");
            a aVar = new a(activity, null);
            aVar.b();
            return aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    @Metadata
    public static final class b extends c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f66895h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ViewGroup.OnHierarchyChangeListener f66896i;

        /* JADX INFO: renamed from: i3.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class ViewGroupOnHierarchyChangeListenerC0706a implements ViewGroup.OnHierarchyChangeListener {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Activity f66898b;

            public ViewGroupOnHierarchyChangeListenerC0706a(Activity activity) {
                this.f66898b = activity;
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (f.a(view2)) {
                    b bVar = b.this;
                    bVar.e(bVar.d(g.a(view2)));
                    ((ViewGroup) this.f66898b.getWindow().getDecorView()).setOnHierarchyChangeListener(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity) {
            super(activity);
            Intrinsics.g(activity, "activity");
            this.f66895h = true;
            this.f66896i = new ViewGroupOnHierarchyChangeListenerC0706a(activity);
        }

        @Override // i3.a.c
        public void b() {
            Resources.Theme theme = a().getTheme();
            Intrinsics.f(theme, "activity.theme");
            c(theme, new TypedValue());
            ((ViewGroup) a().getWindow().getDecorView()).setOnHierarchyChangeListener(this.f66896i);
        }

        public final boolean d(SplashScreenView child) {
            Intrinsics.g(child, "child");
            WindowInsets windowInsetsBuild = i3.c.a().build();
            Intrinsics.f(windowInsetsBuild, "Builder().build()");
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            return (windowInsetsBuild == child.getRootView().computeSystemWindowInsets(windowInsetsBuild, rect) && rect.isEmpty()) ? false : true;
        }

        public final void e(boolean z11) {
            this.f66895h = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f66899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f66900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f66901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f66902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Drawable f66903e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f66904f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f66905g;

        public c(Activity activity) {
            Intrinsics.g(activity, "activity");
            this.f66899a = activity;
            this.f66905g = new d() { // from class: i3.b
            };
        }

        public final Activity a() {
            return this.f66899a;
        }

        public void b() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme currentTheme = this.f66899a.getTheme();
            if (currentTheme.resolveAttribute(R$attr.windowSplashScreenBackground, typedValue, true)) {
                this.f66901c = Integer.valueOf(typedValue.resourceId);
                this.f66902d = Integer.valueOf(typedValue.data);
            }
            if (currentTheme.resolveAttribute(R$attr.windowSplashScreenAnimatedIcon, typedValue, true)) {
                this.f66903e = currentTheme.getDrawable(typedValue.resourceId);
            }
            if (currentTheme.resolveAttribute(R$attr.splashScreenIconSize, typedValue, true)) {
                this.f66904f = typedValue.resourceId == R$dimen.splashscreen_icon_size_with_background;
            }
            Intrinsics.f(currentTheme, "currentTheme");
            c(currentTheme, typedValue);
        }

        public final void c(Resources.Theme currentTheme, TypedValue typedValue) {
            Intrinsics.g(currentTheme, "currentTheme");
            Intrinsics.g(typedValue, "typedValue");
            if (currentTheme.resolveAttribute(R$attr.postSplashScreenTheme, typedValue, true)) {
                int i11 = typedValue.resourceId;
                this.f66900b = i11;
                if (i11 != 0) {
                    this.f66899a.setTheme(i11);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface d {
    }

    public a(Activity activity) {
        this.f66894a = Build.VERSION.SDK_INT >= 31 ? new b(activity) : new c(activity);
    }

    public /* synthetic */ a(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    public final void b() {
        this.f66894a.b();
    }
}

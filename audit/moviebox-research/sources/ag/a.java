package ag;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window f494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsetsControllerCompat f495c;

    public a(View view, Window window) {
        Intrinsics.g(view, "view");
        this.f493a = view;
        this.f494b = window;
        this.f495c = window != null ? WindowCompat.getInsetsController(window, view) : null;
    }

    @Override // ag.c
    public void a(long j11, boolean z11, Function1<? super w1, w1> transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.g(transformColorForLightContent, "transformColorForLightContent");
        f(z11);
        Window window = this.f494b;
        if (window == null) {
            return;
        }
        if (z11 && ((windowInsetsControllerCompat = this.f495c) == null || !windowInsetsControllerCompat.isAppearanceLightStatusBars())) {
            j11 = transformColorForLightContent.invoke(w1.g(j11)).u();
        }
        window.setStatusBarColor(y1.j(j11));
    }

    @Override // ag.c
    public void b(long j11, boolean z11, boolean z12, Function1<? super w1, w1> transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.g(transformColorForLightContent, "transformColorForLightContent");
        e(z11);
        d(z12);
        Window window = this.f494b;
        if (window == null) {
            return;
        }
        if (z11 && ((windowInsetsControllerCompat = this.f495c) == null || !windowInsetsControllerCompat.isAppearanceLightNavigationBars())) {
            j11 = transformColorForLightContent.invoke(w1.g(j11)).u();
        }
        window.setNavigationBarColor(y1.j(j11));
    }

    @Override // ag.c
    public /* synthetic */ void c(long j11, boolean z11, boolean z12, Function1 function1) {
        b.a(this, j11, z11, z12, function1);
    }

    public void d(boolean z11) {
        Window window;
        if (Build.VERSION.SDK_INT < 29 || (window = this.f494b) == null) {
            return;
        }
        window.setNavigationBarContrastEnforced(z11);
    }

    public void e(boolean z11) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.f495c;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z11);
    }

    public void f(boolean z11) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.f495c;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z11);
    }
}

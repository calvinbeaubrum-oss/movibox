package com.google.accompanist.systemuicontroller;

import ag.a;
import ag.c;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.runtime.i;
import androidx.compose.runtime.k;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class SystemUiControllerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32501a = y1.e(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function1<w1, w1> f32502b = new Function1<w1, w1>() { // from class: com.google.accompanist.systemuicontroller.SystemUiControllerKt$BlackScrimmed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ w1 invoke(w1 w1Var) {
            return w1.g(m145invokel2rxGTc(w1Var.u()));
        }

        /* JADX INFO: renamed from: invoke-l2rxGTc, reason: not valid java name */
        public final long m145invokel2rxGTc(long j11) {
            return y1.h(SystemUiControllerKt.f32501a, j11);
        }
    };

    public static final Window c(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.f(context, "getBaseContext(...)");
        }
        return ((Activity) context).getWindow();
    }

    public static final Window d(i iVar, int i11) {
        iVar.x(1009281237);
        if (k.J()) {
            k.S(1009281237, i11, -1, "com.google.accompanist.systemuicontroller.findWindow (SystemUiController.kt:208)");
        }
        ViewParent parent = ((View) iVar.l(AndroidCompositionLocals_androidKt.j())).getParent();
        d dVar = parent instanceof d ? (d) parent : null;
        Window window = dVar != null ? dVar.getWindow() : null;
        if (window == null) {
            Context context = ((View) iVar.l(AndroidCompositionLocals_androidKt.j())).getContext();
            Intrinsics.f(context, "getContext(...)");
            window = c(context);
        }
        if (k.J()) {
            k.R();
        }
        iVar.P();
        return window;
    }

    @Deprecated
    public static final c e(Window window, i iVar, int i11, int i12) {
        iVar.x(-715745933);
        if ((i12 & 1) != 0) {
            window = d(iVar, 0);
        }
        if (k.J()) {
            k.S(-715745933, i11, -1, "com.google.accompanist.systemuicontroller.rememberSystemUiController (SystemUiController.kt:201)");
        }
        View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
        iVar.x(-1044852491);
        boolean zQ = iVar.Q(view) | iVar.Q(window);
        Object objY = iVar.y();
        if (zQ || objY == i.f3413a.a()) {
            objY = new a(view, window);
            iVar.p(objY);
        }
        a aVar = (a) objY;
        iVar.P();
        if (k.J()) {
            k.R();
        }
        iVar.P();
        return aVar;
    }
}

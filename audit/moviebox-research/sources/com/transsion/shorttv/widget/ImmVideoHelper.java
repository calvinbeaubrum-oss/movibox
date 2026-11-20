package com.transsion.shorttv.widget;

import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.f0;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ImmVideoHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f57891d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<ImmVideoHelper> f57892e = LazyKt__LazyJVMKt.b(new Function0<ImmVideoHelper>() { // from class: com.transsion.shorttv.widget.ImmVideoHelper$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ImmVideoHelper invoke() {
            return new ImmVideoHelper();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<View> f57893a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Subject> f57894b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f57895c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImmVideoHelper a() {
            return (ImmVideoHelper) ImmVideoHelper.f57892e.getValue();
        }
    }

    public static final void f(FragmentActivity activity, ImmVideoHelper this$0) {
        View decorView;
        WindowInsets rootWindowInsets;
        Intrinsics.g(activity, "$activity");
        Intrinsics.g(this$0, "this$0");
        if (activity.isFinishing()) {
            return;
        }
        Window window = activity.getWindow();
        Insets mandatorySystemGestureInsets = (window == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null) ? null : rootWindowInsets.getMandatorySystemGestureInsets();
        if (mandatorySystemGestureInsets == null || mandatorySystemGestureInsets.bottom > f0.a(40.0f)) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "is open navigation bar 2", false, 4, null);
            return;
        }
        int i11 = mandatorySystemGestureInsets.bottom;
        this$0.f57895c = i11;
        uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "on get navigation gesture height = " + i11, false, 4, null);
    }

    public final void c() {
        this.f57894b.clear();
    }

    public final List<View> d() {
        return this.f57893a;
    }

    public final void e(final FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            this.f57895c = 0;
            return;
        }
        if (com.blankj.utilcode.util.d.a() > 50) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoHelper", "is open navigation bar", false, 4, null);
            this.f57895c = 0;
            return;
        }
        Window window = activity.getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.post(new Runnable() { // from class: com.transsion.shorttv.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoHelper.f(activity, this);
                }
            });
        }
    }
}

package xq;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.transsion.ad.strategy.AdMmkv;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f80663a = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f80664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f80665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f80666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f80667d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f80668f;

        public a(View view, float f11, float f12, float f13, int i11) {
            this.f80664a = view;
            this.f80665b = f11;
            this.f80666c = f12;
            this.f80667d = f13;
            this.f80668f = i11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f80664a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int iA = f0.a(this.f80665b);
            int iA2 = f0.a(this.f80666c);
            int iE = (d0.e() - f0.a(this.f80667d)) / this.f80668f;
            int i11 = (int) (iE * ((iA2 * 1.0f) / iA));
            ViewGroup.LayoutParams layoutParams = this.f80664a.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = i11;
            ((ViewGroup.MarginLayoutParams) bVar).width = iE;
            this.f80664a.setLayoutParams(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(c cVar, View view, float f11, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            f11 = 10.0f;
        }
        if ((i12 & 4) != 0) {
            i11 = -1;
        }
        if ((i12 & 8) != 0) {
            function1 = null;
        }
        cVar.g(view, f11, i11, function1);
    }

    public static final void i(View view, int i11, float f11) {
        Intrinsics.g(view, "$view");
        f80663a.j(view, i11, f11, false);
    }

    public static final void l(TextView this_apply) {
        String strValueOf;
        Intrinsics.g(this_apply, "$this_apply");
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = this_apply.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            if (f80663a.c(lowerCase)) {
                if (lowerCase.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    char cCharAt = lowerCase.charAt(0);
                    if (Character.isLowerCase(cCharAt)) {
                        Locale locale = Locale.getDefault();
                        Intrinsics.f(locale, "getDefault()");
                        strValueOf = kotlin.text.a.d(cCharAt, locale);
                    } else {
                        strValueOf = String.valueOf(cCharAt);
                    }
                    sb2.append((Object) strValueOf);
                    String strSubstring = lowerCase.substring(1);
                    Intrinsics.f(strSubstring, "substring(...)");
                    sb2.append(strSubstring);
                    lowerCase = sb2.toString();
                }
                this_apply.setText(lowerCase);
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final boolean c(String string) {
        Intrinsics.g(string, "string");
        return new Regex("[a-zA-Z]+").matches(string);
    }

    public final boolean d() {
        return AdMmkv.f50558a.b().getBoolean("key_downloading_play_bubble_guide", true);
    }

    public final void e(View view, float f11, float f12, float f13, int i11) {
        Intrinsics.g(view, "view");
        try {
            Result.Companion companion = Result.Companion;
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, f11, f12, f13, i11));
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void f() {
        AdMmkv.f50558a.b().putBoolean("key_downloading_play_bubble_guide", false);
    }

    public final void g(final View view, final float f11, final int i11, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(view, "view");
        view.postDelayed(new Runnable() { // from class: xq.a
            @Override // java.lang.Runnable
            public final void run() {
                c.i(view, i11, f11);
            }
        }, 10L);
    }

    public final void j(View view, int i11, float f11, boolean z11) {
        try {
            Result.Companion companion = Result.Companion;
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(i11);
                ((TextView) view).setTextSize(2, f11);
                ((TextView) view).setIncludeFontPadding(z11);
                return;
            }
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View child = ((ViewGroup) view).getChildAt(i12);
                    c cVar = f80663a;
                    Intrinsics.f(child, "child");
                    cVar.j(child, i11, f11, z11);
                }
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void k(View layout, int i11) {
        Intrinsics.g(layout, "layout");
        View viewFindViewById = layout.findViewById(i11);
        if (viewFindViewById != null && (viewFindViewById instanceof TextView)) {
            final TextView textView = (TextView) viewFindViewById;
            textView.post(new Runnable() { // from class: xq.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.l(textView);
                }
            });
        }
    }
}

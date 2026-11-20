package so;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f76443a;

    public static final void b(View view, final long j11, final Function1<? super View, Unit> action) {
        Intrinsics.g(view, "<this>");
        Intrinsics.g(action, "action");
        view.setOnClickListener(new View.OnClickListener() { // from class: so.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.d(j11, action, view2);
            }
        });
    }

    public static /* synthetic */ void c(View view, long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = 500;
        }
        b(view, j11, function1);
    }

    public static final void d(long j11, Function1 action, View it) {
        Intrinsics.g(action, "$action");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j12 = f76443a;
        if (j12 == 0 || jCurrentTimeMillis - j12 >= j11) {
            f76443a = jCurrentTimeMillis;
            Intrinsics.f(it, "it");
            action.invoke(it);
        }
    }

    public static final void e(View view) {
        Intrinsics.g(view, "<this>");
        view.setPadding(view.getPaddingStart(), view.getPaddingTop() + d.c(), view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static final boolean f() {
        String string = RoomAppMMKV.f51271a.a().getString("k_language_short_name", null);
        Locale locale = Build.VERSION.SDK_INT >= 24 ? Utils.a().getResources().getConfiguration().getLocales().get(0) : Utils.a().getResources().getConfiguration().locale;
        if (!Intrinsics.b(locale.getLanguage(), string) && string != null && string.length() > 0) {
            locale = new Locale(string, locale.getCountry());
        }
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    public static final void g(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(8);
    }

    public static final void h(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(4);
    }

    public static final boolean i(View view) {
        Intrinsics.g(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void j(View view, boolean z11) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(z11 ? 0 : 8);
    }

    public static final void k(View view) {
        Intrinsics.g(view, "<this>");
        view.setVisibility(0);
    }
}

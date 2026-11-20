package kx;

import android.content.Context;
import com.transsion.share.share.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f69643a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f69644b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function0<String> f69645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function4<? super Context, ? super String, ? super String, ? super e, Unit> f69646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function1<? super String, Unit> f69647e;

    public final String a() {
        return f69644b;
    }

    public final String b() {
        String strInvoke;
        Function0<String> function0 = f69645c;
        return (function0 == null || (strInvoke = function0.invoke()) == null) ? "" : strInvoke;
    }

    public void c(String appName, Function0<String> userId, Function4<? super Context, ? super String, ? super String, ? super e, Unit> reportShow, Function1<? super String, Unit> toastShow) {
        Intrinsics.g(appName, "appName");
        Intrinsics.g(userId, "userId");
        Intrinsics.g(reportShow, "reportShow");
        Intrinsics.g(toastShow, "toastShow");
        f69644b = appName;
        f69645c = userId;
        f69646d = reportShow;
        f69647e = toastShow;
    }

    public final void d(Context context, String str, String id2, e eVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(id2, "id");
        Function4<? super Context, ? super String, ? super String, ? super e, Unit> function4 = f69646d;
        if (function4 != null) {
            function4.invoke(context, str, id2, eVar);
        }
    }

    public final void e(String content) {
        Intrinsics.g(content, "content");
        Function1<? super String, Unit> function1 = f69647e;
        if (function1 != null) {
            function1.invoke(content);
        }
    }
}

package xq;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f80682a = new k();

    public static /* synthetic */ String b(k kVar, Long l11, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "yyyy-MM-dd";
        }
        return kVar.a(l11, str);
    }

    public final String a(Long l11, String dateFormat) {
        Intrinsics.g(dateFormat, "dateFormat");
        String str = new SimpleDateFormat(dateFormat, Locale.getDefault()).format(new Date(l11 != null ? l11.longValue() : 0L));
        Intrinsics.f(str, "sdf.format(date)");
        return str;
    }

    public final String c() {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Calendar.getInstance().getTime());
        Intrinsics.f(str, "formatter.format(currentDate)");
        return str;
    }

    public final long d() {
        return new Date().getTime();
    }
}

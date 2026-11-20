package tp;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class a {
    public static final String a(long j11, int i11) {
        if (j11 < 0) {
            return "";
        }
        if (j11 < 1024) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format(Locale.ENGLISH, "%." + i11 + "fB", Arrays.copyOf(new Object[]{Double.valueOf(j11)}, 1));
            Intrinsics.f(str, "format(...)");
            return str;
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            String str2 = String.format(Locale.ENGLISH, "%." + i11 + "fKB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1024))}, 1));
            Intrinsics.f(str2, "format(...)");
            return str2;
        }
        if (j11 < 1073741824) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f68912a;
            String str3 = String.format(Locale.ENGLISH, "%." + i11 + "fMB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1048576))}, 1));
            Intrinsics.f(str3, "format(...)");
            return str3;
        }
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f68912a;
        String str4 = String.format(Locale.ENGLISH, "%." + i11 + "fGB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1073741824))}, 1));
        Intrinsics.f(str4, "format(...)");
        return str4;
    }

    public static final String b(long j11, int i11, int i12) {
        if (j11 < 0) {
            return "";
        }
        if (j11 < 1024) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format(Locale.ENGLISH, "%." + i12 + "fB", Arrays.copyOf(new Object[]{Double.valueOf(j11)}, 1));
            Intrinsics.f(str, "format(...)");
            return str;
        }
        if (j11 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
            String str2 = String.format(Locale.ENGLISH, "%." + i12 + "fKB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1024))}, 1));
            Intrinsics.f(str2, "format(...)");
            return str2;
        }
        if (j11 < 1073741824) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f68912a;
            String str3 = String.format(Locale.ENGLISH, "%." + i11 + "fMB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1048576))}, 1));
            Intrinsics.f(str3, "format(...)");
            return str3;
        }
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f68912a;
        String str4 = String.format(Locale.ENGLISH, "%." + i11 + "fGB", Arrays.copyOf(new Object[]{Double.valueOf(j11 / ((double) 1073741824))}, 1));
        Intrinsics.f(str4, "format(...)");
        return str4;
    }
}

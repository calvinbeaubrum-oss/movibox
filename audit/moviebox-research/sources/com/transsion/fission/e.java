package com.transsion.fission;

import com.tencent.mmkv.MMKV;
import kotlin.Metadata;

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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f51915a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MMKV f51916b = MMKV.z("one_room_fission");

    public final String a() {
        MMKV mmkv = f51916b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITATION_CODE", null);
        }
        return null;
    }

    public final String b() {
        MMKV mmkv = f51916b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITE_REG", null);
        }
        return null;
    }

    public final void c(String str) {
        MMKV mmkv = f51916b;
        if (mmkv != null) {
            mmkv.putString("KEY_FISSION_INVITATION_CODE", str);
        }
    }
}

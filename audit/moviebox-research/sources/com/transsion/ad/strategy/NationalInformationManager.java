package com.transsion.ad.strategy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.ad.db.mcc.LocalMcc;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w0;

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
public final class NationalInformationManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NationalInformationManager f50580a = new NationalInformationManager();

    public final Object b(Continuation<? super List<LocalMcc>> continuation) {
        return kotlinx.coroutines.h.g(w0.b(), new NationalInformationManager$getAllNationalInformationList$2(null), continuation);
    }

    public final String c() {
        String simpleName = NationalInformationManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final String d() {
        String string;
        MMKV mmkvC = ip.a.f67589a.c();
        String strN = "";
        if (mmkvC != null && (string = mmkvC.getString("sp_code", "")) != null) {
            strN = string;
        }
        if (TextUtils.isEmpty(strN)) {
            strN = TNDeviceHelper.f49455a.n();
        }
        if (strN.length() <= 0 || strN.length() < 3) {
            return strN;
        }
        String strSubstring = strN.substring(0, 3);
        Intrinsics.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final Object e(String str, Continuation<? super LocalMcc> continuation) {
        return kotlinx.coroutines.h.g(w0.b(), new NationalInformationManager$getNationalInformation$2(str, null), continuation);
    }

    public final Object f(Context context, Continuation<? super Unit> continuation) {
        Object objG = kotlinx.coroutines.h.g(w0.b(), new NationalInformationManager$initLocalMcc$2(context, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }
}

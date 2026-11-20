package com.transsion.search.speech;

import com.blankj.utilcode.util.Utils;
import com.transsion.search.R$string;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f57672a = new c();

    public final String a(int i11) {
        if (i11 == 1 || i11 == 2) {
            String string = Utils.a().getResources().getString(R$string.search_sr_try_again);
            Intrinsics.f(string, "{\n                Utils.…_try_again)\n            }");
            return string;
        }
        if (i11 == 6 || i11 == 7) {
            String string2 = Utils.a().getResources().getString(R$string.search_sr_try_speaking_again);
            Intrinsics.f(string2, "{\n                Utils.…king_again)\n            }");
            return string2;
        }
        if (i11 != 16) {
            String string3 = Utils.a().getResources().getString(R$string.search_sr_wrong_try_again);
            Intrinsics.f(string3, "{\n                Utils.…_try_again)\n            }");
            return string3;
        }
        String string4 = Utils.a().getResources().getString(R$string.search_sr_cancelled);
        Intrinsics.f(string4, "{\n                Utils.…_cancelled)\n            }");
        return string4;
    }
}

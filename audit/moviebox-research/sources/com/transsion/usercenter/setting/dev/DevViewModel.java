package com.transsion.usercenter.setting.dev;

import androidx.lifecycle.c0;
import androidx.lifecycle.t0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class DevViewModel extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59680a = LazyKt__LazyJVMKt.b(new Function0<c0<List<String>>>() { // from class: com.transsion.usercenter.setting.dev.DevViewModel$devLiveData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0<List<String>> invoke() {
            return new c0<>();
        }
    });

    public final c0<List<String>> b() {
        return (c0) this.f59680a.getValue();
    }

    public final void c(int i11, int i12, String id2) {
        Intrinsics.g(id2, "id");
        ArrayList arrayList = new ArrayList();
        int i13 = 1;
        if (1 <= i12) {
            while (true) {
                arrayList.add("page = " + i11 + " --- pageSize = " + i12 + " --- id = " + id2);
                if (i13 == i12) {
                    break;
                } else {
                    i13++;
                }
            }
        }
        b().n(arrayList);
    }
}

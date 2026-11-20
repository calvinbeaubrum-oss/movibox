package com.transsion.ad.monopoly.manager;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import rq.a;

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
public final class AdPlansStorageManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlansStorageManager f50532a = new AdPlansStorageManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f50533b = LazyKt__LazyJVMKt.b(new Function0<a>() { // from class: com.transsion.ad.monopoly.manager.AdPlansStorageManager$adPlansDao$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            MbAdDatabase.e eVar = MbAdDatabase.f50387p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return eVar.b(applicationA).N();
        }
    });

    public static /* synthetic */ Object d(AdPlansStorageManager adPlansStorageManager, String str, String str2, Map map, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "AdShowFirst";
        }
        return adPlansStorageManager.c(str, str2, map, continuation);
    }

    public final Object a(String str, Continuation<? super Unit> continuation) {
        Object objF = e().f(str, continuation);
        return objF == kotlin.coroutines.intrinsics.a.e() ? objF : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:49:0x0112 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0113  */
    /* JADX WARN: Code duplicated, block: B:53:0x0127  */
    /* JADX WARN: Code duplicated, block: B:55:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0149  */
    /* JADX WARN: Code duplicated, block: B:60:0x017e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x013c -> B:57:0x0140). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0149 -> B:59:0x017c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object b(java.lang.String r19, java.util.Map<java.lang.String, ? extends java.lang.Object> r20, com.transsion.ad.monopoly.plan.AdPlanSourceManager.AdPlanEnum[] r21, kotlin.coroutines.Continuation<? super java.util.List<com.transsion.ad.monopoly.model.AdPlans>> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.b(java.lang.String, java.util.Map, com.transsion.ad.monopoly.plan.AdPlanSourceManager$AdPlanEnum[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b9 -> B:37:0x00bc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object c(java.lang.String r9, java.lang.String r10, java.util.Map<java.lang.String, ? extends java.lang.Object> r11, kotlin.coroutines.Continuation<? super com.transsion.ad.monopoly.model.AdPlans> r12) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.manager.AdPlansStorageManager.c(java.lang.String, java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final a e() {
        return (a) f50533b.getValue();
    }

    public final Object f(Continuation<? super List<MbAdDbPlans>> continuation) {
        return e().d(continuation);
    }

    public final Object g(Continuation<? super List<MbAdDbPlans>> continuation) {
        return e().e(continuation);
    }

    public final Object h(Continuation<? super List<MbAdDbPlans>> continuation) {
        return e().a(continuation);
    }

    public final Object i(String str, Continuation<? super MbAdDbPlans> continuation) {
        return e().g(str, continuation);
    }

    public final Object j(String str, Continuation<? super List<MbAdDbPlans>> continuation) {
        return e().i(str, continuation);
    }

    public final Object k(MbAdDbPlans mbAdDbPlans, Continuation<? super Unit> continuation) {
        Object objC = e().c(mbAdDbPlans, continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    public final Object l(List<MbAdDbPlans> list, Continuation<? super Unit> continuation) {
        Object objB = e().b(list, continuation);
        return objB == kotlin.coroutines.intrinsics.a.e() ? objB : Unit.f68710a;
    }
}

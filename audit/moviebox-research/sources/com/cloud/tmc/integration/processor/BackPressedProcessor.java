package com.cloud.tmc.integration.processor;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.collections.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import qb.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class BackPressedProcessor implements IBackPressedProcessor {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qb.a> f30902a = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c A[RETURN, SYNTHETIC] */
    public final boolean a(List<? extends qb.a> list, qb.a aVar) {
        if (!list.contains(aVar)) {
            for (Object obj : list) {
                if (Intrinsics.b(((qb.a) obj).a(), aVar.a())) {
                    if (obj != null) {
                        return false;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.cloud.tmc.integration.processor.IBackPressedProcessor
    public void addInterceptors(qb.a intercept) {
        Intrinsics.g(intercept, "intercept");
        if (a(this.f30902a, intercept)) {
            return;
        }
        int i11 = 0;
        for (Object obj : this.f30902a) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            if (intercept.getPriority() < ((qb.a) obj).getPriority()) {
                this.f30902a.add(i11, intercept);
            }
            i11 = i12;
        }
        this.f30902a.add(intercept);
    }

    @Override // com.cloud.tmc.integration.processor.IBackPressedProcessor
    public List<qb.a> getInterceptors() {
        ArrayList arrayList = new ArrayList();
        k.A(arrayList, this.f30902a);
        return arrayList;
    }

    @Override // com.cloud.tmc.integration.processor.IBackPressedProcessor
    public void removeInterceptors(qb.a intercept) {
        Object next;
        Intrinsics.g(intercept, "intercept");
        if (a(this.f30902a, intercept)) {
            Iterator<T> it = this.f30902a.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((qb.a) next).a(), intercept.a()));
            qb.a aVar = (qb.a) next;
            if (aVar != null) {
                this.f30902a.remove(aVar);
            }
        }
    }

    @Override // com.cloud.tmc.integration.processor.IBackPressedProcessor
    public qb.a.d startBackPressedInterceptorChain(qb.a.c params) {
        boolean zB;
        Intrinsics.g(params, "params");
        try {
            zB = MiniAppConfigHelper.f30370a.b("miniBackInterceptorEnable", true);
        } catch (Throwable th2) {
            TmcLogger.h("BackPressedProcessor", th2);
            zB = true;
        }
        TmcLogger.c("BackPressedProcessor", "enable: " + zB);
        if (!zB) {
            return new qb.a.d(false, 1, null);
        }
        ArrayList arrayList = new ArrayList();
        k.A(arrayList, getInterceptors());
        try {
            return new b(arrayList, 0, params).b(params);
        } catch (Throwable th3) {
            TmcLogger.h("BackPressedProcessor", th3);
            return new qb.a.d(false, 1, null);
        }
    }
}

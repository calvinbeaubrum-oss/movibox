package com.transsion.ad.monopoly.intercept;

import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlansHitResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f50526a;

    /* JADX INFO: renamed from: com.transsion.ad.monopoly.intercept.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0547a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f50527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f50528b;

        public final C0547a a(a aVar) {
            if (this.f50527a == null) {
                this.f50528b = aVar;
                this.f50527a = aVar;
                return this;
            }
            a aVar2 = this.f50528b;
            if (aVar2 != null) {
                aVar2.f(aVar);
            }
            this.f50528b = aVar;
            return this;
        }

        public final a b() {
            return this.f50527a;
        }
    }

    public abstract Object b(String str, MbAdDbPlans mbAdDbPlans, Map<String, ? extends Object> map, Continuation<? super AdPlansHitResponse> continuation);

    public final a c() {
        return this.f50526a;
    }

    public final String d() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final AdPlansHitResponse e() {
        return new AdPlansHitResponse(true, TmcEngineFactory.ENGINE_TYPE_DEFAULT);
    }

    public final void f(a aVar) {
        this.f50526a = aVar;
    }
}

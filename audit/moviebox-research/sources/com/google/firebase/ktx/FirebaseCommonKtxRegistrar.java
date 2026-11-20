package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.i1;
import rj.b0;
import rj.e;
import rj.h;
import rj.r;

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
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Keep
@Metadata
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata
    public static final class a<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f40730a = new a<>();

        @Override // rj.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(e eVar) {
            Object objE = eVar.e(b0.a(qj.a.class, Executor.class));
            Intrinsics.f(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return i1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata
    public static final class b<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f40731a = new b<>();

        @Override // rj.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(e eVar) {
            Object objE = eVar.e(b0.a(qj.c.class, Executor.class));
            Intrinsics.f(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return i1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata
    public static final class c<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f40732a = new c<>();

        @Override // rj.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(e eVar) {
            Object objE = eVar.e(b0.a(qj.b.class, Executor.class));
            Intrinsics.f(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return i1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata
    public static final class d<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f40733a = new d<>();

        @Override // rj.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(e eVar) {
            Object objE = eVar.e(b0.a(qj.d.class, Executor.class));
            Intrinsics.f(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return i1.a((Executor) objE);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<rj.c<?>> getComponents() {
        rj.c cVarD = rj.c.e(b0.a(qj.a.class, CoroutineDispatcher.class)).b(r.k(b0.a(qj.a.class, Executor.class))).f(a.f40730a).d();
        Intrinsics.f(cVarD, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        rj.c cVarD2 = rj.c.e(b0.a(qj.c.class, CoroutineDispatcher.class)).b(r.k(b0.a(qj.c.class, Executor.class))).f(b.f40731a).d();
        Intrinsics.f(cVarD2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        rj.c cVarD3 = rj.c.e(b0.a(qj.b.class, CoroutineDispatcher.class)).b(r.k(b0.a(qj.b.class, Executor.class))).f(c.f40732a).d();
        Intrinsics.f(cVarD3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        rj.c cVarD4 = rj.c.e(b0.a(qj.d.class, CoroutineDispatcher.class)).b(r.k(b0.a(qj.d.class, Executor.class))).f(d.f40733a).d();
        Intrinsics.f(cVarD4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return g.o(cVarD, cVarD2, cVarD3, cVarD4);
    }
}

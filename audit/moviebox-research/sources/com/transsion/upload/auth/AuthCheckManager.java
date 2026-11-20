package com.transsion.upload.auth;

import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.upload.bean.TstTokenEntity;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class AuthCheckManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TstTokenEntity f59257b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AuthCheckManager f59256a = new AuthCheckManager();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f59258c = LazyKt__LazyJVMKt.b(new Function0<b>() { // from class: com.transsion.upload.auth.AuthCheckManager$service$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return (b) NetServiceGenerator.f49399d.a().i(b.class);
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f59259d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f59260e = new AtomicBoolean(false);

    public final boolean f() {
        Object objM163constructorimpl;
        Long expireTime;
        try {
            Result.Companion companion = Result.Companion;
            TstTokenEntity tstTokenEntity = f59257b;
            objM163constructorimpl = Result.m163constructorimpl(Boolean.valueOf(((tstTokenEntity == null || (expireTime = tstTokenEntity.getExpireTime()) == null) ? 0L : expireTime.longValue()) - ((long) 60) > System.currentTimeMillis() / ((long) 1000)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) objM163constructorimpl).booleanValue();
    }

    public final void g(a aVar) {
        if (!f()) {
            l(aVar);
        } else if (aVar != null) {
            aVar.a(f59257b);
        }
    }

    public final String h() {
        String simpleName = AuthCheckManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final b i() {
        return (b) f59258c.getValue();
    }

    public final boolean j(a aVar) {
        AtomicBoolean atomicBoolean = f59260e;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            return false;
        }
        f59259d.add(aVar);
        vy.b.f79124a.b(h() + " --> 正在请求中...");
        return true;
    }

    public final void k() {
        f59260e.set(false);
        for (a aVar : f59259d) {
            TstTokenEntity tstTokenEntity = f59257b;
            if (tstTokenEntity == null) {
                aVar.onFail("tstToken is empty");
            } else {
                aVar.a(tstTokenEntity);
            }
        }
        f59259d.clear();
        vy.b.f79124a.b(h() + " --> notifyCallback() --> clear()");
    }

    public final void l(a aVar) {
        if (j(aVar)) {
            return;
        }
        j.d(l0.a(w0.b()), null, null, new AuthCheckManager$requestAuth$1(aVar, null), 3, null);
    }
}

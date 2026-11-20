package com.cloud.hisavana.sdk.common.util;

import com.cloud.hisavana.sdk.common.util.PolyGammaUtil;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import da.a;
import eo.s;
import ho.j;
import io.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p007do.m;

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
public final class PolyGammaUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f29515a = new Companion(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void d(Function2 tmp0, m mVar, Object obj) {
            Intrinsics.g(tmp0, "$tmp0");
            tmp0.invoke(mVar, obj);
        }

        public static final void f() {
            PolyGammaUtil.f29515a.c();
        }

        public final void c() {
            m.a aVarF = m.C().h(f.a()).f(j.ofProvider().i("ogsvc.pgoriginad.com")).f(s.ofProvider());
            final PolyGammaUtil$Companion$init$1 polyGammaUtil$Companion$init$1 = new Function2<m, Throwable, Unit>() { // from class: com.cloud.hisavana.sdk.common.util.PolyGammaUtil$Companion$init$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(m mVar, Throwable th2) {
                    invoke2(mVar, th2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(m mVar, Throwable th2) {
                    if (th2 != null) {
                        z.a().d("PolyGamma", "PolyGamma SDK initialization failed", th2);
                    } else {
                        z.a().d("PolyGamma", "PolyGamma SDK initialized successfully");
                    }
                }
            };
            aVarF.i(new c() { // from class: w9.u
                @Override // io.c
                public final void accept(Object obj, Object obj2) {
                    PolyGammaUtil.Companion.d(polyGammaUtil$Companion$init$1, (p007do.m) obj, obj2);
                }
            });
        }

        public final void e() {
            if (a.d().c("polygamma_init_enable", false)) {
                Preconditions.d(new Preconditions.a() { // from class: w9.t
                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public final void onRun() {
                        PolyGammaUtil.Companion.f();
                    }
                });
            }
        }
    }
}

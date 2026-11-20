package com.tn.lib.util;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.util.networkinfo.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0539a f49452a = new C0539a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f49453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f49454c;

    /* JADX INFO: renamed from: com.tn.lib.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0539a {
        public C0539a() {
        }

        public /* synthetic */ C0539a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Application a() {
            return a.f49453b;
        }

        public final void b(Application application) {
            Intrinsics.g(application, "application");
            a.f49452a.d(application);
            if (c()) {
                return;
            }
            e(true);
            Utils.b(application);
            f.f49475a.f();
            ActivityStackManager.f49449b.a().c(application);
        }

        public final boolean c() {
            return a.f49454c;
        }

        public final void d(Application application) {
            a.f49453b = application;
        }

        public final void e(boolean z11) {
            a.f49454c = z11;
        }
    }
}

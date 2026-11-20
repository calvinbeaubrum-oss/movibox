package com.transsion.commercialization.gameres;

import android.content.Context;
import android.view.View;
import com.transsion.bean.GameInfoType;
import com.transsion.commercialization.gameres.aha.AHAGameResLoader;
import com.transsion.commercialization.gameres.ps.PSGameResLoader;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public interface a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0560a f51659a = C0560a.f51660a;

    /* JADX INFO: renamed from: com.transsion.commercialization.gameres.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0560a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0560a f51660a = new C0560a();

        /* JADX INFO: renamed from: com.transsion.commercialization.gameres.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public /* synthetic */ class C0561a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f51661a;

            static {
                int[] iArr = new int[GameInfoType.values().length];
                try {
                    iArr[GameInfoType.AHA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GameInfoType.PS.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f51661a = iArr;
            }
        }

        public final a<?> a(GameInfoType type) {
            Intrinsics.g(type, "type");
            int i11 = C0561a.f51661a[type.ordinal()];
            if (i11 == 1) {
                return new AHAGameResLoader();
            }
            if (i11 == 2) {
                return new PSGameResLoader();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    void a(Context context, String str, String str2, Function1<? super View, Unit> function1);
}

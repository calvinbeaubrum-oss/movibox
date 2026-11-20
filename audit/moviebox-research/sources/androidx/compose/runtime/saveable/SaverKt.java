package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SaverKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<Object, Object> f3587a = a(new Function2<e, Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(e eVar, Object obj) {
            return obj;
        }
    }, new Function1<Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    });

    /* JADX INFO: Add missing generic type declarations: [Saveable, Original] */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<Original, Saveable> implements d<Original, Saveable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<e, Original, Saveable> f3588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Saveable, Original> f3589b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super e, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
            this.f3588a = function2;
            this.f3589b = function1;
        }

        @Override // androidx.compose.runtime.saveable.d
        public Saveable a(e eVar, Original original) {
            return this.f3588a.invoke(eVar, original);
        }

        @Override // androidx.compose.runtime.saveable.d
        public Original b(Saveable saveable) {
            return this.f3589b.invoke(saveable);
        }
    }

    public static final <Original, Saveable> d<Original, Saveable> a(Function2<? super e, ? super Original, ? extends Saveable> function2, Function1<? super Saveable, ? extends Original> function1) {
        return new a(function2, function1);
    }

    public static final <T> d<T, Object> b() {
        d<T, Object> dVar = (d<T, Object>) f3587a;
        Intrinsics.e(dVar, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return dVar;
    }
}

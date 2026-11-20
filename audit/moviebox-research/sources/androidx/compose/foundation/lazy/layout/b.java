package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

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
public interface b<T> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f2696c;

        public a(int i11, int i12, T t11) {
            this.f2694a = i11;
            this.f2695b = i12;
            this.f2696c = t11;
            if (i11 < 0) {
                throw new IllegalArgumentException(("startIndex should be >= 0, but was " + i11).toString());
            }
            if (i12 > 0) {
                return;
            }
            throw new IllegalArgumentException(("size should be >0, but was " + i12).toString());
        }

        public final int a() {
            return this.f2695b;
        }

        public final int b() {
            return this.f2694a;
        }

        public final T c() {
            return this.f2696c;
        }
    }

    void a(int i11, int i12, Function1<? super a<? extends T>, Unit> function1);

    a<T> get(int i11);

    int getSize();
}

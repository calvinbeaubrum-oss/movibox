package p00;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a extends PasswordTransformationMethod {

    /* JADX INFO: renamed from: p00.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class C0795a implements CharSequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f73477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f73478b;

        public C0795a(a aVar, CharSequence mSource) {
            Intrinsics.g(mSource, "mSource");
            this.f73478b = aVar;
            this.f73477a = mSource;
        }

        public char a(int i11) {
            return '*';
        }

        public int b() {
            return this.f73477a.length();
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ char charAt(int i11) {
            return a(i11);
        }

        @Override // java.lang.CharSequence
        public final /* bridge */ int length() {
            return b();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i11, int i12) {
            return this.f73477a.subSequence(i11, i12);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence source, View view) {
        Intrinsics.g(source, "source");
        Intrinsics.g(view, "view");
        return new C0795a(this, source);
    }
}

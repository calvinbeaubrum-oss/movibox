package com.transsion.usercenter;

import android.text.InputFilter;
import android.text.Spanned;
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
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC0609a f59298b;

    /* JADX INFO: renamed from: com.transsion.usercenter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0609a {
        void a();
    }

    public a(int i11) {
        this.f59297a = i11;
    }

    public final void a(InterfaceC0609a interfaceC0609a) {
        this.f59298b = interfaceC0609a;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int i11, int i12, Spanned dest, int i13, int i14) {
        Intrinsics.g(source, "source");
        Intrinsics.g(dest, "dest");
        int length = this.f59297a - (dest.length() - (i14 - i13));
        if (length > 0) {
            if (length >= i12 - i11) {
                return null;
            }
            int i15 = length + i11;
            return (Character.isHighSurrogate(source.charAt(i15 + (-1))) && (i15 = i15 + (-1)) == i11) ? "" : source.subSequence(i11, i15);
        }
        InterfaceC0609a interfaceC0609a = this.f59298b;
        if (interfaceC0609a == null) {
            return "";
        }
        interfaceC0609a.a();
        return "";
    }
}

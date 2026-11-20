package m2;

import java.text.CharacterIterator;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class d0 implements CharacterIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f70592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f70595d;

    public d0(CharSequence charSequence, int i11, int i12) {
        this.f70592a = charSequence;
        this.f70593b = i11;
        this.f70594c = i12;
        this.f70595d = i11;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i11 = this.f70595d;
        if (i11 == this.f70594c) {
            return (char) 65535;
        }
        return this.f70592a.charAt(i11);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.f70595d = this.f70593b;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.f70593b;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.f70594c;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.f70595d;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i11 = this.f70593b;
        int i12 = this.f70594c;
        if (i11 == i12) {
            this.f70595d = i12;
            return (char) 65535;
        }
        int i13 = i12 - 1;
        this.f70595d = i13;
        return this.f70592a.charAt(i13);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i11 = this.f70595d + 1;
        this.f70595d = i11;
        int i12 = this.f70594c;
        if (i11 < i12) {
            return this.f70592a.charAt(i11);
        }
        this.f70595d = i12;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i11 = this.f70595d;
        if (i11 <= this.f70593b) {
            return (char) 65535;
        }
        int i12 = i11 - 1;
        this.f70595d = i12;
        return this.f70592a.charAt(i12);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int i11) {
        int i12 = this.f70593b;
        if (i11 > this.f70594c || i12 > i11) {
            throw new IllegalArgumentException("invalid position");
        }
        this.f70595d = i11;
        return current();
    }
}

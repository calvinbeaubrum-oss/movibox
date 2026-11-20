package androidx.compose.ui.text.platform;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.emoji2.text.EmojiCompat;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a3<Boolean> f6023a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends EmojiCompat.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i1<Boolean> f6024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f6025b;

        public a(i1<Boolean> i1Var, j jVar) {
            this.f6024a = i1Var;
            this.f6025b = jVar;
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void a(Throwable th2) {
            this.f6025b.f6023a = n.f6030a;
        }

        @Override // androidx.emoji2.text.EmojiCompat.f
        public void b() {
            this.f6024a.setValue(Boolean.TRUE);
            this.f6025b.f6023a = new o(true);
        }
    }

    public j() {
        this.f6023a = EmojiCompat.i() ? c() : null;
    }

    @Override // androidx.compose.ui.text.platform.m
    public a3<Boolean> a() {
        a3<Boolean> a3Var = this.f6023a;
        if (a3Var != null) {
            Intrinsics.d(a3Var);
            return a3Var;
        }
        if (!EmojiCompat.i()) {
            return n.f6030a;
        }
        a3<Boolean> a3VarC = c();
        this.f6023a = a3VarC;
        Intrinsics.d(a3VarC);
        return a3VarC;
    }

    public final a3<Boolean> c() {
        EmojiCompat emojiCompatC = EmojiCompat.c();
        if (emojiCompatC.e() == 1) {
            return new o(true);
        }
        i1 i1VarC = u2.c(Boolean.FALSE, null, 2, null);
        emojiCompatC.t(new a(i1VarC, this));
        return i1VarC;
    }
}

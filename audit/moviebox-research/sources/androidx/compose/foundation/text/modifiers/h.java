package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.layout.m;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class h {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements androidx.compose.foundation.text.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<m> f2988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.compose.foundation.text.selection.j f2989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f2990e;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends m> function0, androidx.compose.foundation.text.selection.j jVar, long j11) {
            this.f2988c = function0;
            this.f2989d = jVar;
            this.f2990e = j11;
            y1.g.a aVar = y1.g.f81070b;
            this.f2986a = aVar.c();
            this.f2987b = aVar.c();
        }

        @Override // androidx.compose.foundation.text.c
        public void a(long j11) {
            m mVarInvoke = this.f2988c.invoke();
            if (mVarInvoke != null) {
                androidx.compose.foundation.text.selection.j jVar = this.f2989d;
                if (!mVarInvoke.D()) {
                    return;
                }
                jVar.i(mVarInvoke, j11, androidx.compose.foundation.text.selection.g.f3012a.c(), true);
                this.f2986a = j11;
            }
            if (SelectionRegistrarKt.b(this.f2989d, this.f2990e)) {
                this.f2987b = y1.g.f81070b.c();
            }
        }

        @Override // androidx.compose.foundation.text.c
        public void b(long j11) {
            m mVarInvoke = this.f2988c.invoke();
            if (mVarInvoke != null) {
                androidx.compose.foundation.text.selection.j jVar = this.f2989d;
                long j12 = this.f2990e;
                if (mVarInvoke.D() && SelectionRegistrarKt.b(jVar, j12)) {
                    long jR = y1.g.r(this.f2987b, j11);
                    this.f2987b = jR;
                    long jR2 = y1.g.r(this.f2986a, jR);
                    if (jVar.f(mVarInvoke, jR2, this.f2986a, false, androidx.compose.foundation.text.selection.g.f3012a.c(), true)) {
                        this.f2986a = jR2;
                        this.f2987b = y1.g.f81070b.c();
                    }
                }
            }
        }

        @Override // androidx.compose.foundation.text.c
        public void onCancel() {
            if (SelectionRegistrarKt.b(this.f2989d, this.f2990e)) {
                this.f2989d.g();
            }
        }

        @Override // androidx.compose.foundation.text.c
        public void onStop() {
            if (SelectionRegistrarKt.b(this.f2989d, this.f2990e)) {
                this.f2989d.g();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.compose.foundation.text.selection.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2991a = y1.g.f81070b.c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<m> f2992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.compose.foundation.text.selection.j f2993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f2994d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<? extends m> function0, androidx.compose.foundation.text.selection.j jVar, long j11) {
            this.f2992b = function0;
            this.f2993c = jVar;
            this.f2994d = j11;
        }

        @Override // androidx.compose.foundation.text.selection.b
        public void a() {
            this.f2993c.g();
        }

        @Override // androidx.compose.foundation.text.selection.b
        public boolean b(long j11) {
            m mVarInvoke = this.f2992b.invoke();
            if (mVarInvoke == null) {
                return true;
            }
            androidx.compose.foundation.text.selection.j jVar = this.f2993c;
            long j12 = this.f2994d;
            if (!mVarInvoke.D() || !SelectionRegistrarKt.b(jVar, j12)) {
                return false;
            }
            if (!jVar.f(mVarInvoke, j11, this.f2991a, false, androidx.compose.foundation.text.selection.g.f3012a.a(), false)) {
                return true;
            }
            this.f2991a = j11;
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.b
        public boolean c(long j11, androidx.compose.foundation.text.selection.g gVar) {
            m mVarInvoke = this.f2992b.invoke();
            if (mVarInvoke == null) {
                return false;
            }
            androidx.compose.foundation.text.selection.j jVar = this.f2993c;
            long j12 = this.f2994d;
            if (!mVarInvoke.D()) {
                return false;
            }
            jVar.i(mVarInvoke, j11, gVar, false);
            this.f2991a = j11;
            return SelectionRegistrarKt.b(jVar, j12);
        }

        @Override // androidx.compose.foundation.text.selection.b
        public boolean d(long j11, androidx.compose.foundation.text.selection.g gVar) {
            m mVarInvoke = this.f2992b.invoke();
            if (mVarInvoke == null) {
                return true;
            }
            androidx.compose.foundation.text.selection.j jVar = this.f2993c;
            long j12 = this.f2994d;
            if (!mVarInvoke.D() || !SelectionRegistrarKt.b(jVar, j12)) {
                return false;
            }
            if (!jVar.f(mVarInvoke, j11, this.f2991a, false, gVar, false)) {
                return true;
            }
            this.f2991a = j11;
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.b
        public boolean e(long j11) {
            m mVarInvoke = this.f2992b.invoke();
            if (mVarInvoke == null) {
                return false;
            }
            androidx.compose.foundation.text.selection.j jVar = this.f2993c;
            long j12 = this.f2994d;
            if (!mVarInvoke.D()) {
                return false;
            }
            if (jVar.f(mVarInvoke, j11, this.f2991a, false, androidx.compose.foundation.text.selection.g.f3012a.a(), false)) {
                this.f2991a = j11;
            }
            return SelectionRegistrarKt.b(jVar, j12);
        }
    }

    public static final androidx.compose.ui.f b(androidx.compose.foundation.text.selection.j jVar, long j11, Function0<? extends m> function0) {
        a aVar = new a(function0, jVar, j11);
        return SelectionGesturesKt.i(androidx.compose.ui.f.f3863a, new b(function0, jVar, j11), aVar);
    }
}

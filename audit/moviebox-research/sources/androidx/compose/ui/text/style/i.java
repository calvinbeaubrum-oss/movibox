package androidx.compose.ui.text.style;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6110b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f6111c = new i(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f6112d = new i(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f6113e = new i(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6114a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return i.f6113e;
        }

        public final i b() {
            return i.f6111c;
        }

        public final i c() {
            return i.f6112d;
        }
    }

    public i(int i11) {
        this.f6114a = i11;
    }

    public final boolean d(i iVar) {
        int i11 = this.f6114a;
        return (iVar.f6114a | i11) == i11;
    }

    public final int e() {
        return this.f6114a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f6114a == ((i) obj).f6114a;
    }

    public int hashCode() {
        return this.f6114a;
    }

    public String toString() {
        if (this.f6114a == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.f6114a & f6112d.f6114a) != 0) {
            arrayList.add("Underline");
        }
        if ((this.f6114a & f6113e.f6114a) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + s2.a.d(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}

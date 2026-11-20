package k2;

import android.content.res.Configuration;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<b, WeakReference<a>> f68204a = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.compose.ui.graphics.vector.c f68205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68206b;

        public a(androidx.compose.ui.graphics.vector.c cVar, int i11) {
            this.f68205a = cVar;
            this.f68206b = i11;
        }

        public final int a() {
            return this.f68206b;
        }

        public final androidx.compose.ui.graphics.vector.c b() {
            return this.f68205a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f68205a, aVar.f68205a) && this.f68206b == aVar.f68206b;
        }

        public int hashCode() {
            return (this.f68205a.hashCode() * 31) + this.f68206b;
        }

        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.f68205a + ", configFlags=" + this.f68206b + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources.Theme f68207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f68208b;

        public b(Resources.Theme theme, int i11) {
            this.f68207a = theme;
            this.f68208b = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f68207a, bVar.f68207a) && this.f68208b == bVar.f68208b;
        }

        public int hashCode() {
            return (this.f68207a.hashCode() * 31) + this.f68208b;
        }

        public String toString() {
            return "Key(theme=" + this.f68207a + ", id=" + this.f68208b + ')';
        }
    }

    public final void a() {
        this.f68204a.clear();
    }

    public final a b(b bVar) {
        WeakReference<a> weakReference = this.f68204a.get(bVar);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void c(int i11) {
        Iterator<Map.Entry<b, WeakReference<a>>> it = this.f68204a.entrySet().iterator();
        while (it.hasNext()) {
            a aVar = it.next().getValue().get();
            if (aVar == null || Configuration.needNewResources(i11, aVar.a())) {
                it.remove();
            }
        }
    }

    public final void d(b bVar, a aVar) {
        this.f68204a.put(bVar, new WeakReference<>(aVar));
    }
}

package androidx.compose.ui.semantics;

import androidx.compose.ui.platform.h1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

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
@SourceDebugExtension
public final class l implements q, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<SemanticsPropertyKey<?>, Object> f5687a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5689c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.q
    public <T> void a(SemanticsPropertyKey<T> semanticsPropertyKey, T t11) {
        if (!(t11 instanceof a) || !f(semanticsPropertyKey)) {
            this.f5687a.put(semanticsPropertyKey, t11);
            return;
        }
        Object obj = this.f5687a.get(semanticsPropertyKey);
        Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        a aVar = (a) obj;
        Map<SemanticsPropertyKey<?>, Object> map = this.f5687a;
        a aVar2 = (a) t11;
        String strB = aVar2.b();
        if (strB == null) {
            strB = aVar.b();
        }
        Function functionA = aVar2.a();
        if (functionA == null) {
            functionA = aVar.a();
        }
        map.put(semanticsPropertyKey, new a(strB, functionA));
    }

    public final void e(l lVar) {
        if (lVar.f5688b) {
            this.f5688b = true;
        }
        if (lVar.f5689c) {
            this.f5689c = true;
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : lVar.f5687a.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            if (!this.f5687a.containsKey(key)) {
                this.f5687a.put(key, value);
            } else if (value instanceof a) {
                Object obj = this.f5687a.get(key);
                Intrinsics.e(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                a aVar = (a) obj;
                Map<SemanticsPropertyKey<?>, Object> map = this.f5687a;
                String strB = aVar.b();
                if (strB == null) {
                    strB = ((a) value).b();
                }
                Function functionA = aVar.a();
                if (functionA == null) {
                    functionA = ((a) value).a();
                }
                map.put(key, new a(strB, functionA));
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.b(this.f5687a, lVar.f5687a) && this.f5688b == lVar.f5688b && this.f5689c == lVar.f5689c;
    }

    public final <T> boolean f(SemanticsPropertyKey<T> semanticsPropertyKey) {
        return this.f5687a.containsKey(semanticsPropertyKey);
    }

    public final boolean g() {
        Set<SemanticsPropertyKey<?>> setKeySet = this.f5687a.keySet();
        if ((setKeySet instanceof Collection) && setKeySet.isEmpty()) {
            return false;
        }
        Iterator<T> it = setKeySet.iterator();
        while (it.hasNext()) {
            if (((SemanticsPropertyKey) it.next()).b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5687a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f5688b)) * 31) + androidx.compose.foundation.e.a(this.f5689c);
    }

    public final l i() {
        l lVar = new l();
        lVar.f5688b = this.f5688b;
        lVar.f5689c = this.f5689c;
        lVar.f5687a.putAll(this.f5687a);
        return lVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        return this.f5687a.entrySet().iterator();
    }

    public final <T> T j(SemanticsPropertyKey<T> semanticsPropertyKey) {
        T t11 = (T) this.f5687a.get(semanticsPropertyKey);
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final <T> T r(SemanticsPropertyKey<T> semanticsPropertyKey, Function0<? extends T> function0) {
        T t11 = (T) this.f5687a.get(semanticsPropertyKey);
        return t11 == null ? function0.invoke() : t11;
    }

    public final <T> T s(SemanticsPropertyKey<T> semanticsPropertyKey, Function0<? extends T> function0) {
        T t11 = (T) this.f5687a.get(semanticsPropertyKey);
        return t11 == null ? function0.invoke() : t11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = "";
        if (this.f5688b) {
            sb2.append("");
            sb2.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.f5689c) {
            sb2.append(str);
            sb2.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : this.f5687a.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            sb2.append(str);
            sb2.append(key.a());
            sb2.append(" : ");
            sb2.append(value);
            str = ", ";
        }
        return h1.a(this, null) + "{ " + ((Object) sb2) + " }";
    }

    public final boolean u() {
        return this.f5689c;
    }

    public final boolean v() {
        return this.f5688b;
    }

    public final void w(l lVar) {
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : lVar.f5687a.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            Object obj = this.f5687a.get(key);
            Intrinsics.e(key, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object objC = key.c(obj, value);
            if (objC != null) {
                this.f5687a.put(key, objC);
            }
        }
    }

    public final void x(boolean z11) {
        this.f5689c = z11;
    }

    public final void y(boolean z11) {
        this.f5688b = z11;
    }
}

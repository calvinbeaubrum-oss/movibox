package androidx.navigation;

import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.w0;
import androidx.lifecycle.x0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public final class f extends t0 implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12248b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final v0.c f12249c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, x0> f12250a = new LinkedHashMap();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements v0.c {
        @Override // androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass) {
            Intrinsics.g(modelClass, "modelClass");
            return new f();
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(Class cls, r3.a aVar) {
            return w0.b(this, cls, aVar);
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
            return w0.c(this, kClass, aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final f a(x0 viewModelStore) {
            Intrinsics.g(viewModelStore, "viewModelStore");
            t0 t0VarA = new v0(viewModelStore, f.f12249c).a(f.class);
            Intrinsics.f(t0VarA, "get(VM::class.java)");
            return (f) t0VarA;
        }
    }

    @Override // androidx.navigation.p
    public x0 a(String backStackEntryId) {
        Intrinsics.g(backStackEntryId, "backStackEntryId");
        x0 x0Var = this.f12250a.get(backStackEntryId);
        if (x0Var != null) {
            return x0Var;
        }
        x0 x0Var2 = new x0();
        this.f12250a.put(backStackEntryId, x0Var2);
        return x0Var2;
    }

    public final void c(String backStackEntryId) {
        Intrinsics.g(backStackEntryId, "backStackEntryId");
        x0 x0VarRemove = this.f12250a.remove(backStackEntryId);
        if (x0VarRemove == null) {
            return;
        }
        x0VarRemove.a();
    }

    @Override // androidx.lifecycle.t0
    public void onCleared() {
        Iterator<x0> it = this.f12250a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f12250a.clear();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NavControllerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} ViewModelStores (");
        Iterator<String> it = this.f12250a.keySet().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }
}

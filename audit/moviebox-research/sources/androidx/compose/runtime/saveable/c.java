package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
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
@SourceDebugExtension
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Object, Boolean> f3590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<Object>> f3591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<Function0<Object>>> f3592c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Object> f3595c;

        public a(String str, Function0<? extends Object> function0) {
            this.f3594b = str;
            this.f3595c = function0;
        }

        @Override // androidx.compose.runtime.saveable.b.a
        public void unregister() {
            List list = (List) c.this.f3592c.remove(this.f3594b);
            if (list != null) {
                list.remove(this.f3595c);
            }
            if (list == null || !(!list.isEmpty())) {
                return;
            }
            c.this.f3592c.put(this.f3594b, list);
        }
    }

    public c(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> function1) {
        Map<String, List<Object>> mapV;
        this.f3590a = function1;
        this.f3591b = (map == null || (mapV = s.v(map)) == null) ? new LinkedHashMap<>() : mapV;
        this.f3592c = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return this.f3590a.invoke(obj).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.b
    public b.a b(String str, Function0<? extends Object> function0) {
        if (!(!SaveableStateRegistryKt.c(str))) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        Map<String, List<Function0<Object>>> map = this.f3592c;
        List<Function0<Object>> arrayList = map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(str, arrayList);
        }
        arrayList.add(function0);
        return new a(str, function0);
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map<String, List<Object>> e() {
        Map<String, List<Object>> mapV = s.v(this.f3591b);
        for (Map.Entry<String, List<Function0<Object>>> entry : this.f3592c.entrySet()) {
            String key = entry.getKey();
            List<Function0<Object>> value = entry.getValue();
            if (value.size() == 1) {
                Object objInvoke = value.get(0).invoke();
                if (objInvoke == null) {
                    continue;
                } else {
                    if (!a(objInvoke)) {
                        throw new IllegalStateException(RememberSaveableKt.b(objInvoke).toString());
                    }
                    mapV.put(key, g.h(objInvoke));
                }
            } else {
                int size = value.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i11 = 0; i11 < size; i11++) {
                    Object objInvoke2 = value.get(i11).invoke();
                    if (objInvoke2 != null && !a(objInvoke2)) {
                        throw new IllegalStateException(RememberSaveableKt.b(objInvoke2).toString());
                    }
                    arrayList.add(objInvoke2);
                }
                mapV.put(key, arrayList);
            }
        }
        return mapV;
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        List<Object> listRemove = this.f3591b.remove(str);
        if (listRemove == null || !(!listRemove.isEmpty())) {
            return null;
        }
        if (listRemove.size() > 1) {
            this.f3591b.put(str, listRemove.subList(1, listRemove.size()));
        }
        return listRemove.get(0);
    }
}

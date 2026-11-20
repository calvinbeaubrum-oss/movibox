package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class l0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8745f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Class<? extends Object>[] f8746g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f8747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, f6.c.InterfaceC0670c> f8748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f8749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, kotlinx.coroutines.flow.v0<Object>> f8750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f6.c.InterfaceC0670c f8751e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final l0 a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new l0();
                }
                HashMap map = new HashMap();
                for (String key : bundle2.keySet()) {
                    Intrinsics.f(key, "key");
                    map.put(key, bundle2.get(key));
                }
                return new l0(map);
            }
            ClassLoader classLoader = l0.class.getClassLoader();
            Intrinsics.d(classLoader);
            bundle.setClassLoader(classLoader);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj = parcelableArrayList.get(i11);
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i11));
            }
            return new l0(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : l0.f8746g) {
                Intrinsics.d(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public l0() {
        this.f8747a = new LinkedHashMap();
        this.f8748b = new LinkedHashMap();
        this.f8749c = new LinkedHashMap();
        this.f8750d = new LinkedHashMap();
        this.f8751e = new f6.c.InterfaceC0670c() { // from class: androidx.lifecycle.k0
            @Override // f6.c.InterfaceC0670c
            public final Bundle saveState() {
                return l0.d(this.f8744a);
            }
        };
    }

    public l0(Map<String, ? extends Object> initialState) {
        Intrinsics.g(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f8747a = linkedHashMap;
        this.f8748b = new LinkedHashMap();
        this.f8749c = new LinkedHashMap();
        this.f8750d = new LinkedHashMap();
        this.f8751e = new f6.c.InterfaceC0670c() { // from class: androidx.lifecycle.k0
            @Override // f6.c.InterfaceC0670c
            public final Bundle saveState() {
                return l0.d(this.f8744a);
            }
        };
        linkedHashMap.putAll(initialState);
    }

    public static final Bundle d(l0 this$0) {
        Intrinsics.g(this$0, "this$0");
        for (Map.Entry entry : kotlin.collections.s.t(this$0.f8748b).entrySet()) {
            this$0.e((String) entry.getKey(), ((f6.c.InterfaceC0670c) entry.getValue()).saveState());
        }
        Set<String> setKeySet = this$0.f8747a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(this$0.f8747a.get(str));
        }
        return androidx.core.os.c.b(TuplesKt.a("keys", arrayList), TuplesKt.a("values", arrayList2));
    }

    public final f6.c.InterfaceC0670c c() {
        return this.f8751e;
    }

    public final <T> void e(String key, T t11) {
        Intrinsics.g(key, "key");
        if (!f8745f.b(t11)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't put value with type ");
            Intrinsics.d(t11);
            sb2.append(t11.getClass());
            sb2.append(" into saved state");
            throw new IllegalArgumentException(sb2.toString());
        }
        Object obj = this.f8749c.get(key);
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            c0Var.q(t11);
        } else {
            this.f8747a.put(key, t11);
        }
        kotlinx.coroutines.flow.v0<Object> v0Var = this.f8750d.get(key);
        if (v0Var == null) {
            return;
        }
        v0Var.setValue(t11);
    }
}

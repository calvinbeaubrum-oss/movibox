package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.R$id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class DisposableSaveableStateRegistry_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<? extends Object>[] f5325a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final z0 b(View view, f6.e eVar) {
        Object parent = view.getParent();
        Intrinsics.e(parent, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) parent;
        Object tag = view2.getTag(R$id.compose_view_saveable_id_tag);
        String strValueOf = tag instanceof String ? (String) tag : null;
        if (strValueOf == null) {
            strValueOf = String.valueOf(view2.getId());
        }
        return c(strValueOf, eVar);
    }

    public static final z0 c(String str, f6.e eVar) {
        final boolean z11;
        final String str2 = androidx.compose.runtime.saveable.b.class.getSimpleName() + ':' + str;
        final f6.c savedStateRegistry = eVar.getSavedStateRegistry();
        Bundle bundleB = savedStateRegistry.b(str2);
        final androidx.compose.runtime.saveable.b bVarA = SaveableStateRegistryKt.a(bundleB != null ? h(bundleB) : null, new Function1<Object, Boolean>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(DisposableSaveableStateRegistry_androidKt.f(obj));
            }
        });
        try {
            savedStateRegistry.h(str2, new f6.c.InterfaceC0670c() { // from class: androidx.compose.ui.platform.a1
                @Override // f6.c.InterfaceC0670c
                public final Bundle saveState() {
                    return DisposableSaveableStateRegistry_androidKt.d(bVarA);
                }
            });
            z11 = true;
        } catch (IllegalArgumentException unused) {
            z11 = false;
        }
        return new z0(bVarA, new Function0<Unit>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z11) {
                    savedStateRegistry.j(str2);
                }
            }
        });
    }

    public static final Bundle d(androidx.compose.runtime.saveable.b bVar) {
        return g(bVar.e());
    }

    public static final boolean f(Object obj) {
        if (obj instanceof androidx.compose.runtime.snapshots.r) {
            androidx.compose.runtime.snapshots.r rVar = (androidx.compose.runtime.snapshots.r) obj;
            if (rVar.getPolicy() != androidx.compose.runtime.r2.g() && rVar.getPolicy() != androidx.compose.runtime.r2.j() && rVar.getPolicy() != androidx.compose.runtime.r2.h()) {
                return false;
            }
            T value = rVar.getValue();
            if (value == 0) {
                return true;
            }
            return f(value);
        }
        if ((obj instanceof Function) && (obj instanceof Serializable)) {
            return false;
        }
        for (Class<? extends Object> cls : f5325a) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public static final Bundle g(Map<String, ? extends List<? extends Object>> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, ? extends List<? extends Object>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<? extends Object> value = entry.getValue();
            bundle.putParcelableArrayList(key, value instanceof ArrayList ? (ArrayList) value : new ArrayList<>(value));
        }
        return bundle;
    }

    public static final Map<String, List<Object>> h(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(str);
            Intrinsics.e(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            linkedHashMap.put(str, parcelableArrayList);
        }
        return linkedHashMap;
    }
}

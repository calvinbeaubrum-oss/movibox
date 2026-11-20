package f6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import java.util.Map;
import kotlin.Metadata;
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
@SuppressLint({"RestrictedApi"})
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f64638g = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f64640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f64641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f6.a.b f64643e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1.b<String, InterfaceC0670c> f64639a = new i1.b<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f64644f = true;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(e eVar);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: f6.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0670c {
        Bundle saveState();
    }

    public static final void d(c this$0, u uVar, Lifecycle.Event event) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(uVar, "<anonymous parameter 0>");
        Intrinsics.g(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f64644f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f64644f = false;
        }
    }

    public final Bundle b(String key) {
        Intrinsics.g(key, "key");
        if (!this.f64642d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f64641c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f64641c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f64641c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f64641c = null;
        }
        return bundle2;
    }

    public final InterfaceC0670c c(String key) {
        Intrinsics.g(key, "key");
        for (Map.Entry<String, InterfaceC0670c> components : this.f64639a) {
            Intrinsics.f(components, "components");
            String key2 = components.getKey();
            InterfaceC0670c value = components.getValue();
            if (Intrinsics.b(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final void e(Lifecycle lifecycle) {
        Intrinsics.g(lifecycle, "lifecycle");
        if (!(!this.f64640b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new r() { // from class: f6.b
            @Override // androidx.lifecycle.r
            public final void onStateChanged(u uVar, Lifecycle.Event event) {
                c.d(this.f64637a, uVar, event);
            }
        });
        this.f64640b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f64640b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f64642d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f64641c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f64642d = true;
    }

    public final void g(Bundle outBundle) {
        Intrinsics.g(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f64641c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        i1.b<String, InterfaceC0670c>.d dVarE = this.f64639a.e();
        Intrinsics.f(dVarE, "this.components.iteratorWithAdditions()");
        while (dVarE.hasNext()) {
            Map.Entry next = dVarE.next();
            bundle.putBundle((String) next.getKey(), ((InterfaceC0670c) next.getValue()).saveState());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    public final void h(String key, InterfaceC0670c provider) {
        Intrinsics.g(key, "key");
        Intrinsics.g(provider, "provider");
        if (this.f64639a.i(key, provider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends a> clazz) {
        Intrinsics.g(clazz, "clazz");
        if (!this.f64644f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        f6.a.b bVar = this.f64643e;
        if (bVar == null) {
            bVar = new f6.a.b(this);
        }
        this.f64643e = bVar;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            f6.a.b bVar2 = this.f64643e;
            if (bVar2 != null) {
                String name = clazz.getName();
                Intrinsics.f(name, "clazz.name");
                bVar2.a(name);
            }
        } catch (NoSuchMethodException e11) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
        }
    }

    public final void j(String key) {
        Intrinsics.g(key, "key");
        this.f64639a.j(key);
    }
}

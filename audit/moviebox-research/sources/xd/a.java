package xd;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.offline.download.OfflineManager;
import com.cloud.tmc.offline.download.utils.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.g;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class a implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0902a f80475b = new C0902a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80476a;

    /* JADX INFO: renamed from: xd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0902a {
        public C0902a() {
        }

        public /* synthetic */ C0902a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f80477a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f80477a = iArr;
        }
    }

    public a(String str) {
        this.f80476a = str;
    }

    public final void a() {
        try {
            ArrayList arrayListH = g.h("100000");
            Context contextA = OfflineManager.A();
            String packageName = contextA != null ? contextA.getPackageName() : null;
            if (packageName != null) {
                arrayListH.add(packageName);
            }
            Iterator it = arrayListH.iterator();
            while (it.hasNext()) {
                f.f32092a.d((String) it.next());
            }
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppLifecycleObserve", "checkSpecialGroupsReport", th2);
        }
    }

    public final void b(Lifecycle.Event event) {
        if (b.f80477a[event.ordinal()] == 1) {
            f.f32092a.d(this.f80476a);
            a();
        }
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        try {
            b(event);
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppLifecycleObserve", "onStateChanged", th2);
        }
    }
}

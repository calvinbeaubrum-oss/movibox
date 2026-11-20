package qb;

import android.content.Context;
import com.cloud.tmc.integration.processor.IBackPressedProcessor;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: qb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface InterfaceC0816a {
        c a();

        d b(c cVar);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public static d a(a aVar, App app, boolean z11, a intercept, boolean z12) {
            IBackPressedProcessor backPressedProcessor;
            Intrinsics.g(intercept, "intercept");
            if (z12 && app != null && (backPressedProcessor = app.getBackPressedProcessor()) != null) {
                backPressedProcessor.removeInterceptors(intercept);
            }
            return new d(z11);
        }

        public static /* synthetic */ d b(a aVar, App app, boolean z11, a aVar2, boolean z12, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: backResult");
            }
            if ((i11 & 8) != 0) {
                z12 = true;
            }
            return aVar.b(app, z11, aVar2, z12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f74485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f74486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AppNode f74487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f74488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f74489e;

        public c() {
            this(null, null, null, false, 0, 31, null);
        }

        public c(Context context, String str, AppNode appNode, boolean z11, int i11) {
            this.f74485a = context;
            this.f74486b = str;
            this.f74487c = appNode;
            this.f74488d = z11;
            this.f74489e = i11;
        }

        public /* synthetic */ c(Context context, String str, AppNode appNode, boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? null : context, (i12 & 2) != 0 ? null : str, (i12 & 4) == 0 ? appNode : null, (i12 & 8) != 0 ? false : z11, (i12 & 16) != 0 ? 0 : i11);
        }

        public final AppNode a() {
            return this.f74487c;
        }

        public final String b() {
            return this.f74486b;
        }

        public final Context c() {
            return this.f74485a;
        }

        public final int d() {
            return this.f74489e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.b(this.f74485a, cVar.f74485a) && Intrinsics.b(this.f74486b, cVar.f74486b) && Intrinsics.b(this.f74487c, cVar.f74487c) && this.f74488d == cVar.f74488d && this.f74489e == cVar.f74489e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            Context context = this.f74485a;
            int iHashCode = (context == null ? 0 : context.hashCode()) * 31;
            String str = this.f74486b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            AppNode appNode = this.f74487c;
            int iHashCode3 = (iHashCode2 + (appNode != null ? appNode.hashCode() : 0)) * 31;
            boolean z11 = this.f74488d;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            return ((iHashCode3 + r11) * 31) + this.f74489e;
        }

        public String toString() {
            return "Params(context=" + this.f74485a + ", appId=" + this.f74486b + ", app=" + this.f74487c + ", autoExit=" + this.f74488d + ", fromType=" + this.f74489e + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f74490a;

        public d() {
            this(false, 1, null);
        }

        public d(boolean z11) {
            this.f74490a = z11;
        }

        public /* synthetic */ d(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? false : z11);
        }

        public final boolean a() {
            return this.f74490a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.f74490a == ((d) obj).f74490a;
        }

        public int hashCode() {
            boolean z11 = this.f74490a;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public String toString() {
            return "Result(isIntercept=" + this.f74490a + ')';
        }
    }

    String a();

    d b(App app, boolean z11, a aVar, boolean z12);

    d c(InterfaceC0816a interfaceC0816a);

    int getPriority();
}

package rx;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface a extends d {

    /* JADX INFO: renamed from: rx.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0834a {

        /* JADX INFO: renamed from: rx.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0835a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f75746a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List<d> f75747b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f75748c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f75749d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Context f75750e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ f f75751f;

            /* JADX WARN: Multi-variable type inference failed */
            public C0835a(int i11, List<? extends d> list, e eVar, a aVar, Context context, f fVar) {
                this.f75746a = i11;
                this.f75747b = list;
                this.f75748c = eVar;
                this.f75749d = aVar;
                this.f75750e = context;
                this.f75751f = fVar;
            }

            @Override // rx.e
            public void a(g result) {
                Intrinsics.g(result, "result");
                if (this.f75746a >= this.f75747b.size() - 1) {
                    this.f75748c.a(result);
                } else if (result instanceof i) {
                    this.f75748c.a(result);
                } else {
                    C0834a.b(this.f75749d, this.f75746a + 1, this.f75750e, this.f75751f, this.f75748c);
                }
            }
        }

        public static void b(a aVar, int i11, Context context, f fVar, e eVar) {
            Unit unit;
            List<d> listC = aVar.c();
            d dVar = (d) CollectionsKt___CollectionsKt.h0(listC, i11);
            if (dVar != null) {
                dVar.a(context, fVar, new C0835a(i11, listC, eVar, aVar, context, fVar));
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                eVar.a(new c(c.f75753d.a(), null, fVar));
            }
        }

        public static void c(a aVar, Context context, f params, e callback) {
            Intrinsics.g(context, "context");
            Intrinsics.g(params, "params");
            Intrinsics.g(callback, "callback");
            if (aVar.c().isEmpty()) {
                callback.a(new c(c.f75753d.a(), null, params));
            } else {
                b(aVar, 0, context, params, callback);
            }
        }
    }

    @Override // rx.d
    void a(Context context, f fVar, e eVar);

    int b(Subject subject);

    List<d> c();

    View d(ViewStub viewStub, qx.d dVar, Subject subject, e eVar);
}

package p6;

import androidx.work.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import q6.g;
import q6.h;
import r6.n;
import s6.u;

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
public final class e implements d, q6.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f73709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.c<?>[] f73710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f73711c;

    public e(c cVar, q6.c<?>[] constraintControllers) {
        Intrinsics.g(constraintControllers, "constraintControllers");
        this.f73709a = cVar;
        this.f73710b = constraintControllers;
        this.f73711c = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(n trackers, c cVar) {
        this(cVar, (q6.c<?>[]) new q6.c[]{new q6.a(trackers.a()), new q6.b(trackers.b()), new h(trackers.d()), new q6.d(trackers.c()), new g(trackers.c()), new q6.f(trackers.c()), new q6.e(trackers.c())});
        Intrinsics.g(trackers, "trackers");
    }

    @Override // p6.d
    public void a(Iterable<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
        synchronized (this.f73711c) {
            try {
                for (q6.c<?> cVar : this.f73710b) {
                    cVar.g(null);
                }
                for (q6.c<?> cVar2 : this.f73710b) {
                    cVar2.e(workSpecs);
                }
                for (q6.c<?> cVar3 : this.f73710b) {
                    cVar3.g(this);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // q6.c.a
    public void b(List<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
        synchronized (this.f73711c) {
            try {
                ArrayList<u> arrayList = new ArrayList();
                for (Object obj : workSpecs) {
                    if (d(((u) obj).f76199a)) {
                        arrayList.add(obj);
                    }
                }
                for (u uVar : arrayList) {
                    j.e().a(f.f73712a, "Constraints met for " + uVar);
                }
                c cVar = this.f73709a;
                if (cVar != null) {
                    cVar.e(arrayList);
                    Unit unit = Unit.f68710a;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // q6.c.a
    public void c(List<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
        synchronized (this.f73711c) {
            c cVar = this.f73709a;
            if (cVar != null) {
                cVar.b(workSpecs);
                Unit unit = Unit.f68710a;
            }
        }
    }

    public final boolean d(String workSpecId) {
        q6.c<?> cVar;
        boolean z11;
        Intrinsics.g(workSpecId, "workSpecId");
        synchronized (this.f73711c) {
            try {
                q6.c<?>[] cVarArr = this.f73710b;
                int length = cVarArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        cVar = null;
                        break;
                    }
                    cVar = cVarArr[i11];
                    if (cVar.d(workSpecId)) {
                        break;
                    }
                    i11++;
                }
                if (cVar != null) {
                    j.e().a(f.f73712a, "Work " + workSpecId + " constrained by " + cVar.getClass().getSimpleName());
                }
                z11 = cVar == null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    @Override // p6.d
    public void reset() {
        synchronized (this.f73711c) {
            try {
                for (q6.c<?> cVar : this.f73710b) {
                    cVar.f();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

package androidx.compose.ui.text;

import com.transsion.baselib.db.download.DownloadException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class MultiParagraphIntrinsics implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnotatedString f5711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AnnotatedString.b<t>> f5712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f5713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f5714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n> f5715e;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, e0 e0Var, List<AnnotatedString.b<t>> list, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        this.f5711a = annotatedString;
        this.f5712b = list;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f5713c = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                n nVar;
                o oVarB;
                List<n> listF = this.this$0.f();
                if (listF.isEmpty()) {
                    nVar = null;
                } else {
                    n nVar2 = listF.get(0);
                    float fC = nVar2.b().c();
                    int iN = kotlin.collections.g.n(listF);
                    int i11 = 1;
                    if (1 <= iN) {
                        while (true) {
                            n nVar3 = listF.get(i11);
                            float fC2 = nVar3.b().c();
                            if (Float.compare(fC, fC2) < 0) {
                                nVar2 = nVar3;
                                fC = fC2;
                            }
                            if (i11 == iN) {
                                break;
                            }
                            i11++;
                        }
                    }
                    nVar = nVar2;
                }
                n nVar4 = nVar;
                return Float.valueOf((nVar4 == null || (oVarB = nVar4.b()) == null) ? 0.0f : oVarB.c());
            }
        });
        this.f5714d = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                n nVar;
                o oVarB;
                List<n> listF = this.this$0.f();
                if (listF.isEmpty()) {
                    nVar = null;
                } else {
                    n nVar2 = listF.get(0);
                    float fA = nVar2.b().a();
                    int iN = kotlin.collections.g.n(listF);
                    int i11 = 1;
                    if (1 <= iN) {
                        while (true) {
                            n nVar3 = listF.get(i11);
                            float fA2 = nVar3.b().a();
                            if (Float.compare(fA, fA2) < 0) {
                                nVar2 = nVar3;
                                fA = fA2;
                            }
                            if (i11 == iN) {
                                break;
                            }
                            i11++;
                        }
                    }
                    nVar = nVar2;
                }
                n nVar4 = nVar;
                return Float.valueOf((nVar4 == null || (oVarB = nVar4.b()) == null) ? 0.0f : oVarB.a());
            }
        });
        r rVarL = e0Var.L();
        List<AnnotatedString.b<r>> listG = d.g(annotatedString, rVarL);
        ArrayList arrayList = new ArrayList(listG.size());
        int size = listG.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.b<r> bVar2 = listG.get(i11);
            AnnotatedString annotatedStringH = d.h(annotatedString, bVar2.f(), bVar2.d());
            arrayList.add(new n(p.a(annotatedStringH.i(), e0Var.H(h(bVar2.e(), rVarL)), annotatedStringH.g(), h.b(g(), bVar2.f(), bVar2.d()), eVar, bVar), bVar2.f(), bVar2.d()));
        }
        this.f5715e = arrayList;
    }

    @Override // androidx.compose.ui.text.o
    public float a() {
        return ((Number) this.f5714d.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.o
    public boolean b() {
        List<n> list = this.f5715e;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).b().b()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.o
    public float c() {
        return ((Number) this.f5713c.getValue()).floatValue();
    }

    public final AnnotatedString e() {
        return this.f5711a;
    }

    public final List<n> f() {
        return this.f5715e;
    }

    public final List<AnnotatedString.b<t>> g() {
        return this.f5712b;
    }

    public final r h(r rVar, r rVar2) {
        return !androidx.compose.ui.text.style.j.j(rVar.i(), androidx.compose.ui.text.style.j.f6115b.f()) ? rVar : rVar.a((DownloadException.EXCEPTION_IO_HTTP_RETRY & 1) != 0 ? rVar.f6043a : 0, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 2) != 0 ? rVar.f6044b : rVar2.i(), (DownloadException.EXCEPTION_IO_HTTP_RETRY & 4) != 0 ? rVar.f6045c : 0L, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 8) != 0 ? rVar.f6046d : null, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 16) != 0 ? rVar.f6047e : null, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 32) != 0 ? rVar.f6048f : null, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 64) != 0 ? rVar.f6049g : 0, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 128) != 0 ? rVar.f6050h : 0, (DownloadException.EXCEPTION_IO_HTTP_RETRY & 256) != 0 ? rVar.f6051i : null);
    }
}

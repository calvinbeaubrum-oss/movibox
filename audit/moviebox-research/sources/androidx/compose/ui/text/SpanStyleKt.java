package androidx.compose.ui.text;

import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class SpanStyleKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f5742a = q2.x.c(14);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f5743b = q2.x.c(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f5744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f5745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final androidx.compose.ui.text.style.l f5746e;

    static {
        w1.a aVar = w1.f4564b;
        f5744c = aVar.d();
        long jA = aVar.a();
        f5745d = jA;
        f5746e = androidx.compose.ui.text.style.l.f6123a.b(jA);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0035  */
    public static final y b(y yVar, long j11, l1 l1Var, float f11, long j12, androidx.compose.ui.text.font.u uVar, androidx.compose.ui.text.font.q qVar, androidx.compose.ui.text.font.r rVar, androidx.compose.ui.text.font.i iVar, String str, long j13, androidx.compose.ui.text.style.a aVar, androidx.compose.ui.text.style.m mVar, p2.i iVar2, long j14, androidx.compose.ui.text.style.i iVar3, b5 b5Var, w wVar, z1.h hVar) {
        androidx.compose.ui.text.style.m mVarU;
        long jD;
        z1.h hVarH;
        androidx.compose.ui.text.font.u uVarN = uVar;
        androidx.compose.ui.text.font.q qVarL = qVar;
        androidx.compose.ui.text.font.r rVarM = rVar;
        String strJ = str;
        androidx.compose.ui.text.style.a aVarE = aVar;
        if ((!q2.x.d(j12)) && !q2.w.e(j12, yVar.k())) {
            mVarU = mVar;
            jD = j14;
            hVarH = hVar;
        } else if ((l1Var != null || j11 == 16 || w1.m(j11, yVar.t().a())) && ((qVarL == null || Intrinsics.b(qVarL, yVar.l())) && ((uVarN == null || Intrinsics.b(uVarN, yVar.n())) && ((iVar == null || iVar == yVar.i()) && (!(!q2.x.d(j13)) || q2.w.e(j13, yVar.o())))))) {
            if ((iVar3 == null || Intrinsics.b(iVar3, yVar.s())) && Intrinsics.b(l1Var, yVar.t().d()) && ((l1Var == null || f11 == yVar.t().getAlpha()) && ((rVarM == null || Intrinsics.b(rVarM, yVar.m())) && ((strJ == null || Intrinsics.b(strJ, yVar.j())) && (aVarE == null || Intrinsics.b(aVarE, yVar.e())))))) {
                mVarU = mVar;
                if ((mVarU == null || Intrinsics.b(mVarU, yVar.u())) && (iVar2 == null || Intrinsics.b(iVar2, yVar.p()))) {
                    jD = j14;
                    if ((jD == 16 || w1.m(jD, yVar.d())) && (b5Var == null || Intrinsics.b(b5Var, yVar.r()))) {
                        hVarH = hVar;
                        if (hVarH == null || Intrinsics.b(hVarH, yVar.h())) {
                            return yVar;
                        }
                        yVar = yVar;
                    } else {
                        yVar = yVar;
                        hVarH = hVar;
                    }
                }
            } else {
                mVarU = mVar;
            }
            jD = j14;
            hVarH = hVar;
        } else {
            mVarU = mVar;
            jD = j14;
            hVarH = hVar;
        }
        androidx.compose.ui.text.style.l lVarC = yVar.t().c(l1Var != null ? androidx.compose.ui.text.style.l.f6123a.a(l1Var, f11) : androidx.compose.ui.text.style.l.f6123a.b(j11));
        androidx.compose.ui.text.font.i iVarI = iVar == null ? yVar.i() : iVar;
        long jK = !q2.x.d(j12) ? j12 : yVar.k();
        if (uVarN == null) {
            uVarN = yVar.n();
        }
        if (qVarL == null) {
            qVarL = yVar.l();
        }
        if (rVarM == null) {
            rVarM = yVar.m();
        }
        if (strJ == null) {
            strJ = yVar.j();
        }
        long jO = !q2.x.d(j13) ? j13 : yVar.o();
        if (aVarE == null) {
            aVarE = yVar.e();
        }
        if (mVarU == null) {
            mVarU = yVar.u();
        }
        p2.i iVarP = iVar2 == null ? yVar.p() : iVar2;
        if (jD == 16) {
            jD = yVar.d();
        }
        androidx.compose.ui.text.style.i iVarS = iVar3 == null ? yVar.s() : iVar3;
        b5 b5VarR = b5Var == null ? yVar.r() : b5Var;
        long j15 = jD;
        c(yVar, wVar);
        if (hVarH == null) {
            hVarH = yVar.h();
        }
        return new y(lVarC, jK, uVarN, qVarL, rVarM, iVarI, strJ, jO, aVarE, mVarU, iVarP, j15, iVarS, b5VarR, (w) null, hVarH, (DefaultConstructorMarker) null);
    }

    public static final w c(y yVar, w wVar) {
        yVar.q();
        return wVar;
    }

    public static final y d(y yVar) {
        androidx.compose.ui.text.style.l lVarB = yVar.t().b(new Function0<androidx.compose.ui.text.style.l>() { // from class: androidx.compose.ui.text.SpanStyleKt$resolveSpanStyleDefaults$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final androidx.compose.ui.text.style.l invoke() {
                return SpanStyleKt.f5746e;
            }
        });
        long jK = q2.x.d(yVar.k()) ? f5742a : yVar.k();
        androidx.compose.ui.text.font.u uVarN = yVar.n();
        if (uVarN == null) {
            uVarN = androidx.compose.ui.text.font.u.f5860b.a();
        }
        androidx.compose.ui.text.font.u uVar = uVarN;
        androidx.compose.ui.text.font.q qVarL = yVar.l();
        androidx.compose.ui.text.font.q qVarC = androidx.compose.ui.text.font.q.c(qVarL != null ? qVarL.i() : androidx.compose.ui.text.font.q.f5850b.b());
        androidx.compose.ui.text.font.r rVarM = yVar.m();
        androidx.compose.ui.text.font.r rVarB = androidx.compose.ui.text.font.r.b(rVarM != null ? rVarM.j() : androidx.compose.ui.text.font.r.f5854b.a());
        androidx.compose.ui.text.font.i iVarI = yVar.i();
        if (iVarI == null) {
            iVarI = androidx.compose.ui.text.font.i.f5821b.a();
        }
        androidx.compose.ui.text.font.i iVar = iVarI;
        String strJ = yVar.j();
        if (strJ == null) {
            strJ = "";
        }
        String str = strJ;
        long jO = q2.x.d(yVar.o()) ? f5743b : yVar.o();
        androidx.compose.ui.text.style.a aVarE = yVar.e();
        androidx.compose.ui.text.style.a aVarB = androidx.compose.ui.text.style.a.b(aVarE != null ? aVarE.h() : androidx.compose.ui.text.style.a.f6053b.a());
        androidx.compose.ui.text.style.m mVarU = yVar.u();
        if (mVarU == null) {
            mVarU = androidx.compose.ui.text.style.m.f6126c.a();
        }
        androidx.compose.ui.text.style.m mVar = mVarU;
        p2.i iVarP = yVar.p();
        if (iVarP == null) {
            iVarP = p2.i.f73512c.a();
        }
        p2.i iVar2 = iVarP;
        long jD = yVar.d();
        if (jD == 16) {
            jD = f5744c;
        }
        long j11 = jD;
        androidx.compose.ui.text.style.i iVarS = yVar.s();
        if (iVarS == null) {
            iVarS = androidx.compose.ui.text.style.i.f6110b.b();
        }
        androidx.compose.ui.text.style.i iVar3 = iVarS;
        b5 b5VarR = yVar.r();
        if (b5VarR == null) {
            b5VarR = b5.f3990d.a();
        }
        b5 b5Var = b5VarR;
        yVar.q();
        z1.h hVarH = yVar.h();
        if (hVarH == null) {
            hVarH = z1.l.f81716a;
        }
        return new y(lVarB, jK, uVar, qVarC, rVarB, iVar, str, jO, aVarB, mVar, iVar2, j11, iVar3, b5Var, (w) null, hVarH, (DefaultConstructorMarker) null);
    }
}

package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import y1.m;

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
public final class a extends View.DragShadowBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2.e f3822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<z1.g, Unit> f3824c;

    /* JADX WARN: Multi-variable type inference failed */
    public a(q2.e eVar, long j11, Function1<? super z1.g, Unit> function1) {
        this.f3822a = eVar;
        this.f3823b = j11;
        this.f3824c = function1;
    }

    public /* synthetic */ a(q2.e eVar, long j11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, j11, function1);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        z1.a aVar = new z1.a();
        q2.e eVar = this.f3822a;
        long j11 = this.f3823b;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        o1 o1VarB = h0.b(canvas);
        Function1<z1.g, Unit> function1 = this.f3824c;
        z1.a.C0925a c0925aD = aVar.D();
        q2.e eVarA = c0925aD.a();
        LayoutDirection layoutDirectionB = c0925aD.b();
        o1 o1VarC = c0925aD.c();
        long jD = c0925aD.d();
        z1.a.C0925a c0925aD2 = aVar.D();
        c0925aD2.j(eVar);
        c0925aD2.k(layoutDirection);
        c0925aD2.i(o1VarB);
        c0925aD2.l(j11);
        o1VarB.d();
        function1.invoke(aVar);
        o1VarB.k();
        z1.a.C0925a c0925aD3 = aVar.D();
        c0925aD3.j(eVarA);
        c0925aD3.k(layoutDirectionB);
        c0925aD3.i(o1VarC);
        c0925aD3.l(jD);
    }

    @Override // android.view.View.DragShadowBuilder
    public void onProvideShadowMetrics(Point point, Point point2) {
        q2.e eVar = this.f3822a;
        point.set(eVar.k0(eVar.H0(m.i(this.f3823b))), eVar.k0(eVar.H0(m.g(this.f3823b))));
        point2.set(point.x / 2, point.y / 2);
    }
}

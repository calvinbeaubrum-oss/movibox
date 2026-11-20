package y6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends g<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f81261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f81262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float[] f81263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathMeasure f81264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public i f81265m;

    public j(List<? extends h7.a<PointF>> list) {
        super(list);
        this.f81261i = new PointF();
        this.f81262j = new float[2];
        this.f81263k = new float[2];
        this.f81264l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(h7.a<PointF> aVar, float f11) {
        PointF pointF;
        i iVar = (i) aVar;
        Path pathK = iVar.k();
        if (pathK == null) {
            return aVar.f66350b;
        }
        h7.c<A> cVar = this.f81231e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(iVar.f66355g, iVar.f66356h.floatValue(), (PointF) iVar.f66350b, (PointF) iVar.f66351c, e(), f11, f())) != null) {
            return pointF;
        }
        if (this.f81265m != iVar) {
            this.f81264l.setPath(pathK, false);
            this.f81265m = iVar;
        }
        float length = this.f81264l.getLength();
        float f12 = f11 * length;
        this.f81264l.getPosTan(f12, this.f81262j, this.f81263k);
        PointF pointF2 = this.f81261i;
        float[] fArr = this.f81262j;
        pointF2.set(fArr[0], fArr[1]);
        if (f12 < 0.0f) {
            PointF pointF3 = this.f81261i;
            float[] fArr2 = this.f81263k;
            pointF3.offset(fArr2[0] * f12, fArr2[1] * f12);
        } else if (f12 > length) {
            PointF pointF4 = this.f81261i;
            float[] fArr3 = this.f81263k;
            float f13 = f12 - length;
            pointF4.offset(fArr3[0] * f13, fArr3[1] * f13);
        }
        return this.f81261i;
    }
}

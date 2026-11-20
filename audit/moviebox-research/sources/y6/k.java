package y6;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends g<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f81266i;

    public k(List<h7.a<PointF>> list) {
        super(list);
        this.f81266i = new PointF();
    }

    @Override // y6.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(h7.a<PointF> aVar, float f11) {
        return j(aVar, f11, f11, f11);
    }

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
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public PointF j(h7.a<PointF> aVar, float f11, float f12, float f13) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f66350b;
        if (pointF3 == null || (pointF = aVar.f66351c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        h7.c<A> cVar = this.f81231e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.f66355g, aVar.f66356h.floatValue(), pointF4, pointF5, f11, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f81266i;
        float f14 = pointF4.x;
        float f15 = f14 + (f12 * (pointF5.x - f14));
        float f16 = pointF4.y;
        pointF6.set(f15, f16 + (f13 * (pointF5.y - f16)));
        return this.f81266i;
    }
}

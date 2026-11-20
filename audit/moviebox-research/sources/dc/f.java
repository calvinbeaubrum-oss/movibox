package dc;

import com.cloud.tmc.kernel.bridge.extension.bind.BindException;
import com.cloud.tmc.kernel.node.Node;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements b<cc.f, Node> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f63025a;

    public f(Node node) {
        this.f63025a = node;
    }

    @Override // dc.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Node a(Class<Node> cls, cc.f fVar) throws BindException {
        Node nodeC = c(fVar.value(), this.f63025a);
        if (nodeC == null) {
            return null;
        }
        return nodeC;
    }

    public final Node c(Class<? extends com.cloud.tmc.kernel.node.d> cls, Node node) {
        Class scopeType;
        if (node == null || !(node instanceof com.cloud.tmc.kernel.node.d) || (scopeType = ((com.cloud.tmc.kernel.node.d) node).getScopeType()) == null) {
            return null;
        }
        return scopeType.equals(cls) ? node : c(cls, node.getParentNode());
    }
}

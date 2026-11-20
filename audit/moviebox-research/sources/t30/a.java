package t30;

import com.vungle.warren.error.VungleException;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.OperatorNode;
import org.mvel2.util.ASTIterator;
import org.mvel2.util.ASTLinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ASTNode f76792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f76793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f76794c;

    public a(ASTNode aSTNode) {
        this.f76792a = aSTNode;
    }

    public static a b(ASTIterator aSTIterator) {
        ASTLinkedList aSTLinkedList = new ASTLinkedList(aSTIterator.firstNode());
        a aVar = new a(aSTLinkedList.nextNode());
        while (aSTLinkedList.hasMoreNodes()) {
            ASTNode aSTNodeNextNode = aSTLinkedList.nextNode();
            if (!(aSTNodeNextNode instanceof EndOfStatement)) {
                aVar = aVar.a(aSTNodeNextNode);
            } else if (aSTLinkedList.hasMoreNodes()) {
                aVar = new a(aSTLinkedList.nextNode());
            }
        }
        return aVar;
    }

    public a a(ASTNode aSTNode) {
        if (c(this.f76792a, aSTNode) >= 0) {
            a aVar = new a(aSTNode);
            aVar.f76793b = this;
            return aVar;
        }
        if (this.f76793b == null) {
            throw new RuntimeException("Missing left node");
        }
        a aVar2 = this.f76794c;
        if (aVar2 == null) {
            this.f76794c = new a(aSTNode);
        } else {
            this.f76794c = aVar2.a(aSTNode);
        }
        return this;
    }

    public final int c(ASTNode aSTNode, ASTNode aSTNode2) {
        boolean z11 = aSTNode instanceof OperatorNode;
        if (!z11 && !(aSTNode2 instanceof OperatorNode)) {
            return 0;
        }
        if (!z11 || !(aSTNode2 instanceof OperatorNode)) {
            return z11 ? -1 : 1;
        }
        int[] iArr = org.mvel2.g.f73314a;
        return iArr[((OperatorNode) aSTNode).getOperator().intValue()] - iArr[((OperatorNode) aSTNode2).getOperator().intValue()];
    }

    public Class<?> d(boolean z11) {
        ASTNode aSTNode = this.f76792a;
        if (!(aSTNode instanceof OperatorNode)) {
            return aSTNode.getEgressType();
        }
        a aVar = this.f76793b;
        if (aVar == null || this.f76794c == null) {
            throw new RuntimeException("Malformed expression");
        }
        Class<?> clsD = aVar.d(z11);
        Class<?> clsD2 = this.f76794c.d(z11);
        int iIntValue = ((OperatorNode) this.f76792a).getOperator().intValue();
        if (iIntValue != 0) {
            if (iIntValue != 1 && iIntValue != 2 && iIntValue != 3) {
                if (iIntValue == 4) {
                    if (!z11 || d.b(clsD, clsD2)) {
                        return Integer.class;
                    }
                    throw new RuntimeException("Associative operation requires compatible types. Found " + clsD + " and " + clsD2);
                }
                if (iIntValue == 21 || iIntValue == 22) {
                    if (z11) {
                        if (clsD != Boolean.class && clsD != Boolean.TYPE) {
                            throw new RuntimeException("Left side of logical operation is not of type boolean. Found " + clsD);
                        }
                        if (clsD2 != Boolean.class && clsD2 != Boolean.TYPE) {
                            throw new RuntimeException("Right side of logical operation is not of type boolean. Found " + clsD2);
                        }
                    }
                    return Boolean.class;
                }
                switch (iIntValue) {
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        if (!z11 || d.a(clsD, clsD2)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + clsD + " and " + clsD2);
                    case 18:
                    case 19:
                        if (!z11 || d.b(clsD, clsD2)) {
                            return Boolean.class;
                        }
                        throw new RuntimeException("Comparison operation requires compatible types. Found " + clsD + " and " + clsD2);
                    default:
                        switch (iIntValue) {
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                                return Boolean.class;
                            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                if (!z11 || clsD == Boolean.class || clsD == Boolean.TYPE) {
                                    return clsD2;
                                }
                                throw new RuntimeException("Condition of ternary operator is not of type boolean. Found " + clsD);
                            case 30:
                                if (!z11 || d.b(clsD, clsD2)) {
                                    return clsD;
                                }
                                throw new RuntimeException("Associative operation requires compatible types. Found " + clsD + " and " + clsD2);
                            default:
                                return this.f76792a.getEgressType();
                        }
                }
            }
        } else if (clsD.equals(String.class) || clsD2.equals(String.class)) {
            return String.class;
        }
        if (!z11 || d.b(clsD, clsD2)) {
            return Double.class;
        }
        throw new RuntimeException("Associative operation requires compatible types. Found " + clsD + " and " + clsD2);
    }
}

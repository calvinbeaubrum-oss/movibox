package q30;

import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.res.CodeNode;
import org.mvel2.templates.res.CommentNode;
import org.mvel2.templates.res.CompiledCodeNode;
import org.mvel2.templates.res.CompiledDeclareNode;
import org.mvel2.templates.res.CompiledEvalNode;
import org.mvel2.templates.res.CompiledExpressionNode;
import org.mvel2.templates.res.CompiledForEachNode;
import org.mvel2.templates.res.CompiledIfNode;
import org.mvel2.templates.res.CompiledIncludeNode;
import org.mvel2.templates.res.CompiledNamedIncludeNode;
import org.mvel2.templates.res.CompiledTerminalExpressionNode;
import org.mvel2.templates.res.DeclareNode;
import org.mvel2.templates.res.EndNode;
import org.mvel2.templates.res.EvalNode;
import org.mvel2.templates.res.ExpressionNode;
import org.mvel2.templates.res.ForEachNode;
import org.mvel2.templates.res.IfNode;
import org.mvel2.templates.res.IncludeNode;
import org.mvel2.templates.res.NamedIncludeNode;
import org.mvel2.templates.res.Node;
import org.mvel2.templates.res.TerminalExpressionNode;
import org.mvel2.templates.res.TerminalNode;
import org.mvel2.templates.res.TextNode;
import t30.g;
import t30.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, Integer> f74277k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f74278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f74279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f74280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f74281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f74282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f74283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f74284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f74285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, Class<? extends Node>> f74286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ParserContext f74287j;

    static {
        HashMap map = new HashMap();
        f74277k = map;
        map.put("if", 1);
        map.put("else", 2);
        map.put("elseif", 2);
        map.put(TtmlNode.END, 10);
        map.put("foreach", 3);
        map.put("includeNamed", 51);
        map.put("include", 50);
        map.put("comment", 52);
        map.put(TrackingKey.CODE, 53);
        map.put("eval", 55);
        map.put("declare", 54);
        map.put("stop", 70);
    }

    public b(CharSequence charSequence, boolean z11, ParserContext parserContext) {
        this.f74285h = false;
        char[] charArray = charSequence.toString().toCharArray();
        this.f74278a = charArray;
        this.f74279b = charArray.length;
        this.f74285h = z11;
        this.f74287j = parserContext;
    }

    public static CompiledTemplate f(String str) {
        return new b(str, true, ParserContext.create()).d();
    }

    public static CompiledTemplate g(String str, ParserContext parserContext) {
        return new b(str, true, parserContext).d();
    }

    public final char[] a() {
        int i11 = this.f74281d - this.f74280c;
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = this.f74278a[this.f74280c + i12];
        }
        return cArr;
    }

    public final int b() {
        try {
            ParserContext parserContext = new ParserContext();
            char[] cArr = this.f74278a;
            int i11 = this.f74281d;
            this.f74280c = i11;
            this.f74281d = m.e(cArr, i11, this.f74279b, '{', parserContext);
            this.f74283f += parserContext.getLineCount();
            int i12 = this.f74280c + 1;
            this.f74280c = this.f74281d + 1;
            return i12;
        } catch (CompileException e11) {
            e11.setLineNumber(this.f74283f);
            e11.setColumn((this.f74281d - this.f74284g) + 1);
            throw e11;
        }
    }

    public final int c() {
        int i11 = this.f74281d + 1;
        this.f74281d = i11;
        while (true) {
            int i12 = this.f74281d;
            if (i12 == this.f74279b || !m.c0(this.f74278a[i12])) {
                break;
            }
            this.f74281d++;
        }
        int i13 = this.f74281d;
        if (i13 == this.f74279b || this.f74278a[i13] != '{') {
            return -1;
        }
        return i11;
    }

    public CompiledTemplate d() {
        return new CompiledTemplate(this.f74278a, e(null, new g()));
    }

    public Node e(Node node, g gVar) {
        Node compiledIfNode;
        Node terminus;
        this.f74283f = 1;
        Node textNode = node == null ? new TextNode(0, 0) : node;
        Node node2 = textNode;
        while (true) {
            try {
                int i11 = this.f74281d;
                if (i11 >= this.f74279b) {
                    if (!gVar.g()) {
                        CompileException compileException = new CompileException("unclosed @" + ((Node) gVar.k()).getName() + "{} block. expected @end{}", this.f74278a, this.f74281d);
                        compileException.setColumn(this.f74281d - this.f74284g);
                        compileException.setLineNumber(this.f74283f);
                        throw compileException;
                    }
                    int i12 = this.f74280c;
                    char[] cArr = this.f74278a;
                    if (i12 < cArr.length) {
                        TextNode textNode2 = new TextNode(i12, cArr.length);
                        textNode.next = textNode2;
                        textNode = textNode2;
                    }
                    textNode.next = new EndNode();
                    Node next = node2;
                    while (next.getLength() == 0 && (next = next.getNext()) != null) {
                    }
                    if (next == null || next.getLength() != this.f74278a.length - 1) {
                        return node2;
                    }
                    if (next instanceof ExpressionNode) {
                        return this.f74285h ? new CompiledTerminalExpressionNode(next, this.f74287j) : new TerminalExpressionNode(next);
                    }
                    return next;
                }
                char c11 = this.f74278a[i11];
                if (c11 == '\n') {
                    this.f74283f++;
                    this.f74284g = i11 + 1;
                } else if (c11 == '$' || c11 == '@') {
                    if (h(c11)) {
                        int i13 = this.f74281d + 1;
                        this.f74281d = i13;
                        this.f74280c = i13;
                        textNode = i(textNode);
                        textNode.setEnd(textNode.getEnd() + 1);
                        int i14 = this.f74281d + 1;
                        this.f74281d = i14;
                        this.f74282e = i14;
                        this.f74280c = i14;
                    } else {
                        int iC = c();
                        if (iC != -1) {
                            this.f74280c = iC;
                            Map<String, Integer> map = f74277k;
                            String str = new String(a());
                            Integer num = map.get(str);
                            int iIntValue = num == null ? 0 : num.intValue();
                            if (iIntValue == 1) {
                                Node nodeI = i(textNode);
                                compiledIfNode = this.f74285h ? new CompiledIfNode(this.f74280c, str, this.f74278a, b(), this.f74280c, this.f74287j) : new IfNode(this.f74280c, str, this.f74278a, b(), this.f74280c);
                                nodeI.next = compiledIfNode;
                                gVar.q(compiledIfNode);
                                compiledIfNode.setTerminus(new TerminalNode());
                            } else if (iIntValue != 2) {
                                if (iIntValue != 3) {
                                    if (iIntValue != 10) {
                                        switch (iIntValue) {
                                            case 50:
                                                Node nodeI2 = i(textNode);
                                                if (this.f74285h) {
                                                    int i15 = this.f74280c;
                                                    char[] cArr2 = this.f74278a;
                                                    int iB = b();
                                                    int i16 = this.f74281d + 1;
                                                    this.f74280c = i16;
                                                    compiledIfNode = new CompiledIncludeNode(i15, str, cArr2, iB, i16, this.f74287j);
                                                } else {
                                                    int i17 = this.f74280c;
                                                    char[] cArr3 = this.f74278a;
                                                    int iB2 = b();
                                                    int i18 = this.f74281d + 1;
                                                    this.f74280c = i18;
                                                    compiledIfNode = new IncludeNode(i17, str, cArr3, iB2, i18);
                                                }
                                                nodeI2.next = compiledIfNode;
                                                break;
                                            case 51:
                                                Node nodeI3 = i(textNode);
                                                if (this.f74285h) {
                                                    int i19 = this.f74280c;
                                                    char[] cArr4 = this.f74278a;
                                                    int iB3 = b();
                                                    int i21 = this.f74281d + 1;
                                                    this.f74280c = i21;
                                                    compiledIfNode = new CompiledNamedIncludeNode(i19, str, cArr4, iB3, i21, this.f74287j);
                                                } else {
                                                    int i22 = this.f74280c;
                                                    char[] cArr5 = this.f74278a;
                                                    int iB4 = b();
                                                    int i23 = this.f74281d + 1;
                                                    this.f74280c = i23;
                                                    compiledIfNode = new NamedIncludeNode(i22, str, cArr5, iB4, i23);
                                                }
                                                nodeI3.next = compiledIfNode;
                                                break;
                                            case 52:
                                                Node nodeI4 = i(textNode);
                                                int i24 = this.f74280c;
                                                char[] cArr6 = this.f74278a;
                                                int iB5 = b();
                                                int i25 = this.f74281d + 1;
                                                this.f74280c = i25;
                                                compiledIfNode = new CommentNode(i24, str, cArr6, iB5, i25);
                                                nodeI4.next = compiledIfNode;
                                                break;
                                            case 53:
                                                Node nodeI5 = i(textNode);
                                                if (this.f74285h) {
                                                    int i26 = this.f74280c;
                                                    char[] cArr7 = this.f74278a;
                                                    int iB6 = b();
                                                    int i27 = this.f74281d + 1;
                                                    this.f74280c = i27;
                                                    compiledIfNode = new CompiledCodeNode(i26, str, cArr7, iB6, i27, this.f74287j);
                                                } else {
                                                    int i28 = this.f74280c;
                                                    char[] cArr8 = this.f74278a;
                                                    int iB7 = b();
                                                    int i29 = this.f74281d + 1;
                                                    this.f74280c = i29;
                                                    compiledIfNode = new CodeNode(i28, str, cArr8, iB7, i29);
                                                }
                                                nodeI5.next = compiledIfNode;
                                                break;
                                            case 54:
                                                Node nodeI6 = i(textNode);
                                                if (this.f74285h) {
                                                    int i31 = this.f74280c;
                                                    char[] cArr9 = this.f74278a;
                                                    int iB8 = b();
                                                    int i32 = this.f74281d + 1;
                                                    this.f74280c = i32;
                                                    compiledIfNode = new CompiledDeclareNode(i31, str, cArr9, iB8, i32, this.f74287j);
                                                } else {
                                                    int i33 = this.f74280c;
                                                    char[] cArr10 = this.f74278a;
                                                    int iB9 = b();
                                                    int i34 = this.f74281d + 1;
                                                    this.f74280c = i34;
                                                    compiledIfNode = new DeclareNode(i33, str, cArr10, iB9, i34);
                                                }
                                                nodeI6.next = compiledIfNode;
                                                gVar.q(compiledIfNode);
                                                compiledIfNode.setTerminus(new TerminalNode());
                                                break;
                                            case 55:
                                                Node nodeI7 = i(textNode);
                                                if (this.f74285h) {
                                                    int i35 = this.f74280c;
                                                    char[] cArr11 = this.f74278a;
                                                    int iB10 = b();
                                                    int i36 = this.f74281d + 1;
                                                    this.f74280c = i36;
                                                    compiledIfNode = new CompiledEvalNode(i35, str, cArr11, iB10, i36, this.f74287j);
                                                } else {
                                                    int i37 = this.f74280c;
                                                    char[] cArr12 = this.f74278a;
                                                    int iB11 = b();
                                                    int i38 = this.f74281d + 1;
                                                    this.f74280c = i38;
                                                    compiledIfNode = new EvalNode(i37, str, cArr12, iB11, i38);
                                                }
                                                nodeI7.next = compiledIfNode;
                                                break;
                                            default:
                                                if (str.length() == 0) {
                                                    Node nodeI8 = i(textNode);
                                                    if (this.f74285h) {
                                                        int i39 = this.f74280c;
                                                        char[] cArr13 = this.f74278a;
                                                        int iB12 = b();
                                                        int i40 = this.f74281d + 1;
                                                        this.f74280c = i40;
                                                        compiledIfNode = new CompiledExpressionNode(i39, str, cArr13, iB12, i40, this.f74287j);
                                                    } else {
                                                        int i41 = this.f74280c;
                                                        char[] cArr14 = this.f74278a;
                                                        int iB13 = b();
                                                        int i42 = this.f74281d + 1;
                                                        this.f74280c = i42;
                                                        compiledIfNode = new ExpressionNode(i41, str, cArr14, iB13, i42);
                                                    }
                                                    nodeI8.next = compiledIfNode;
                                                } else {
                                                    Map<String, Class<? extends Node>> map2 = this.f74286i;
                                                    if (map2 == null || !map2.containsKey(str)) {
                                                        throw new RuntimeException("unknown token type: " + str);
                                                    }
                                                    Class<? extends Node> cls = this.f74286i.get(str);
                                                    try {
                                                        Node nodeI9 = i(textNode);
                                                        terminus = cls.newInstance();
                                                        nodeI9.next = terminus;
                                                        terminus.setBegin(this.f74280c);
                                                        terminus.setName(str);
                                                        terminus.setCStart(b());
                                                        int i43 = this.f74281d + 1;
                                                        this.f74280c = i43;
                                                        terminus.setCEnd(i43);
                                                        terminus.setEnd(terminus.getCEnd());
                                                        terminus.setContents(m.K0(this.f74278a, terminus.getCStart(), (terminus.getCEnd() - terminus.getCStart()) - 1));
                                                        if (terminus.isOpenNode()) {
                                                            gVar.q(terminus);
                                                        }
                                                    } catch (IllegalAccessException unused) {
                                                        throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                    } catch (InstantiationException unused2) {
                                                        throw new RuntimeException("unable to instantiate custom node class: " + cls.getName());
                                                    }
                                                }
                                                break;
                                        }
                                    } else {
                                        Node nodeI10 = i(textNode);
                                        Node node3 = (Node) gVar.n();
                                        terminus = node3.getTerminus();
                                        terminus.setCStart(b());
                                        int i44 = this.f74280c;
                                        this.f74282e = i44;
                                        terminus.setEnd(i44 - 1);
                                        terminus.calculateContents(this.f74278a);
                                        if (node3.demarcate(terminus, this.f74278a)) {
                                            nodeI10.next = terminus;
                                        }
                                    }
                                    textNode = terminus;
                                } else {
                                    Node nodeI11 = i(textNode);
                                    compiledIfNode = this.f74285h ? new CompiledForEachNode(this.f74280c, str, this.f74278a, b(), this.f74280c, this.f74287j) : new ForEachNode(this.f74280c, str, this.f74278a, b(), this.f74280c);
                                    nodeI11.next = compiledIfNode;
                                    gVar.q(compiledIfNode);
                                    compiledIfNode.setTerminus(new TerminalNode());
                                }
                            } else if (!gVar.g() && (gVar.k() instanceof IfNode)) {
                                Node nodeI12 = i(textNode);
                                IfNode ifNode = (IfNode) gVar.n();
                                nodeI12.next = ifNode.getTerminus();
                                ifNode.demarcate(ifNode.getTerminus(), this.f74278a);
                                textNode = this.f74285h ? new CompiledIfNode(this.f74280c, str, this.f74278a, b(), this.f74280c, this.f74287j) : new IfNode(this.f74280c, str, this.f74278a, b(), this.f74280c);
                                ifNode.next = textNode;
                                textNode.setTerminus(ifNode.getTerminus());
                                gVar.q(textNode);
                            }
                            textNode = compiledIfNode;
                        }
                    }
                }
                this.f74281d++;
            } catch (RuntimeException e11) {
                CompileException compileException2 = new CompileException(e11.getMessage(), this.f74278a, this.f74281d, e11);
                compileException2.setExpr(this.f74278a);
                if (e11 instanceof CompileException) {
                    CompileException compileException3 = (CompileException) e11;
                    if (compileException3.getCursor() != -1) {
                        compileException2.setCursor(compileException3.getCursor());
                        if (compileException3.getColumn() == -1) {
                            compileException2.setColumn(compileException2.getCursor() - this.f74284g);
                        } else {
                            compileException2.setColumn(compileException3.getColumn());
                        }
                    }
                }
                compileException2.setLineNumber(this.f74283f);
                throw compileException2;
            }
        }
    }

    public final boolean h(char c11) {
        int i11 = this.f74281d;
        return i11 != this.f74279b && this.f74278a[i11 + 1] == c11;
    }

    public final Node i(Node node) {
        int end = node.getEnd();
        int end2 = this.f74282e;
        if (end > end2) {
            end2 = node.getEnd();
        }
        int i11 = this.f74280c;
        if (end2 >= i11) {
            return node;
        }
        int i12 = i11 - 1;
        this.f74282e = i12;
        TextNode textNode = new TextNode(end2, i12);
        node.next = textNode;
        return textNode;
    }
}

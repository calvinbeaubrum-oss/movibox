package org.mvel2.compiler;

import androidx.core.view.MotionEventCompat;
import com.transsion.gslb.Utils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.CompileException;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.AssertNode;
import org.mvel2.ast.AssignmentNode;
import org.mvel2.ast.BooleanNode;
import org.mvel2.ast.DeclProtoVarNode;
import org.mvel2.ast.DeclTypedVarNode;
import org.mvel2.ast.DeepAssignmentNode;
import org.mvel2.ast.DoNode;
import org.mvel2.ast.DoUntilNode;
import org.mvel2.ast.EndOfStatement;
import org.mvel2.ast.Fold;
import org.mvel2.ast.ForEachNode;
import org.mvel2.ast.ForNode;
import org.mvel2.ast.Function;
import org.mvel2.ast.IfNode;
import org.mvel2.ast.ImportNode;
import org.mvel2.ast.IndexedAssignmentNode;
import org.mvel2.ast.IndexedDeclTypedVarNode;
import org.mvel2.ast.IndexedOperativeAssign;
import org.mvel2.ast.IndexedPostFixDecNode;
import org.mvel2.ast.IndexedPostFixIncNode;
import org.mvel2.ast.IndexedPreFixDecNode;
import org.mvel2.ast.IndexedPreFixIncNode;
import org.mvel2.ast.InlineCollectionNode;
import org.mvel2.ast.InterceptorWrapper;
import org.mvel2.ast.Invert;
import org.mvel2.ast.IsDef;
import org.mvel2.ast.LineLabel;
import org.mvel2.ast.LiteralDeepPropertyNode;
import org.mvel2.ast.LiteralNode;
import org.mvel2.ast.Negation;
import org.mvel2.ast.NewObjectNode;
import org.mvel2.ast.NewObjectPrototype;
import org.mvel2.ast.NewPrototypeNode;
import org.mvel2.ast.OperativeAssign;
import org.mvel2.ast.OperatorNode;
import org.mvel2.ast.PostFixDecNode;
import org.mvel2.ast.PostFixIncNode;
import org.mvel2.ast.PreFixDecNode;
import org.mvel2.ast.PreFixIncNode;
import org.mvel2.ast.Proto;
import org.mvel2.ast.ProtoVarNode;
import org.mvel2.ast.RedundantCodeException;
import org.mvel2.ast.RegExMatch;
import org.mvel2.ast.ReturnNode;
import org.mvel2.ast.Sign;
import org.mvel2.ast.Stacklang;
import org.mvel2.ast.StaticImportNode;
import org.mvel2.ast.Substatement;
import org.mvel2.ast.ThisWithNode;
import org.mvel2.ast.TypeCast;
import org.mvel2.ast.TypeDescriptor;
import org.mvel2.ast.TypedVarNode;
import org.mvel2.ast.Union;
import org.mvel2.ast.UntilNode;
import org.mvel2.ast.WhileNode;
import org.mvel2.ast.WithNode;
import org.mvel2.c;
import org.mvel2.integration.VariableResolverFactory;
import t30.f;
import t30.g;
import t30.h;
import t30.m;
import t30.n;
import t30.o;
import t30.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class AbstractParser implements b, Serializable {
    public static HashMap<String, Object> CLASS_LITERALS = null;
    private static final WeakHashMap<String, char[]> EX_PRECACHE = new WeakHashMap<>(15);
    protected static final int GET = 2;
    protected static final int GET_OR_CREATE = 3;
    public static final int LEVEL_0_PROPERTY_ONLY = 0;
    public static final int LEVEL_1_BASIC_LANG = 1;
    public static final int LEVEL_2_MULTI_STATEMENT = 2;
    public static final int LEVEL_3_ITERATION = 3;
    public static final int LEVEL_4_ASSIGNMENT = 4;
    public static final int LEVEL_5_CONTROL_FLOW = 5;
    public static HashMap<String, Object> LITERALS = null;
    public static HashMap<String, Integer> OPERATORS = null;
    protected static final int OP_CONTINUE = 1;
    protected static final int OP_NOT_LITERAL = -3;
    protected static final int OP_OVERFLOW = -2;
    protected static final int OP_RESET_FRAME = 0;
    protected static final int OP_TERMINATE = -1;
    protected static final int REMOVE = 1;
    protected static final int SET = 0;
    protected boolean compileMode;
    protected Object ctx;
    protected int cursor;
    protected g dStack;
    protected boolean debugSymbols;
    protected int end;
    protected char[] expr;
    protected int fields;
    protected boolean greedy;
    protected int lastLineStart;
    protected ASTNode lastNode;
    protected boolean lastWasComment;
    protected boolean lastWasIdentifier;
    protected boolean lastWasLineLabel;
    protected int length;
    protected int line;
    protected int literalOnly;
    protected ParserContext pCtx;
    protected g splitAccumulator;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    protected int f73300st;
    protected int start;
    protected g stk;
    protected VariableResolverFactory variableFactory;

    static {
        setupParser();
    }

    public AbstractParser() {
        this.greedy = true;
        this.lastWasIdentifier = false;
        this.lastWasLineLabel = false;
        this.lastWasComment = false;
        this.compileMode = false;
        this.literalOnly = -1;
        this.lastLineStart = 0;
        this.line = 0;
        this.splitAccumulator = new g();
        this.debugSymbols = false;
        this.pCtx = new ParserContext();
    }

    public AbstractParser(ParserContext parserContext) {
        this.greedy = true;
        this.lastWasIdentifier = false;
        this.lastWasLineLabel = false;
        this.lastWasComment = false;
        this.compileMode = false;
        this.literalOnly = -1;
        this.lastLineStart = 0;
        this.line = 0;
        this.splitAccumulator = new g();
        this.debugSymbols = false;
        this.pCtx = parserContext == null ? new ParserContext() : parserContext;
    }

    private ASTNode _captureBlock(ASTNode aSTNode, char[] cArr, boolean z11, int i11) {
        int i12;
        int i13;
        int iE;
        skipWhitespace();
        if (i11 == 48) {
            if (o.g()) {
                o.c(cArr, this.cursor, this.pCtx);
            }
            int i14 = this.cursor;
            captureToNextTokenJunction();
            String strX = m.x(cArr, i14, this.cursor - i14);
            if (m.o0(strX) || m.f0(strX)) {
                throw new CompileException("illegal prototype name or use of reserved word", cArr, this.cursor);
            }
            int iNextNonBlank = nextNonBlank();
            this.cursor = iNextNonBlank;
            if (cArr[iNextNonBlank] != '{') {
                throw new CompileException("expected '{' but found: " + cArr[this.cursor], cArr, this.cursor);
            }
            int i15 = iNextNonBlank + 1;
            this.cursor = m.e(cArr, i15, this.end, '{', this.pCtx);
            o oVar = new o(cArr, i15, this.cursor, strX, this.pCtx, this.fields, this.splitAccumulator);
            Proto protoI = oVar.i();
            this.pCtx.addImport(protoI);
            protoI.setCursorPosition(i15, this.cursor);
            this.cursor = oVar.e();
            o.h(protoI);
            this.lastNode = protoI;
            return protoI;
        }
        if (i11 == 100) {
            int i16 = this.cursor;
            captureToNextTokenJunction();
            int i17 = this.cursor;
            if (i17 == this.end) {
                throw new CompileException("unexpected end of statement", cArr, i16);
            }
            String strX2 = m.x(cArr, i16, i17 - i16);
            if (m.o0(strX2) || m.f0(strX2)) {
                throw new CompileException("illegal function name or use of reserved word", cArr, this.cursor);
            }
            int i18 = this.cursor;
            h hVar = new h(strX2, i18, this.end - i18, cArr, this.fields, this.pCtx, this.splitAccumulator);
            Function functionC = hVar.c();
            this.cursor = hVar.a();
            this.lastNode = functionC;
            return functionC;
        }
        if (i11 == 101) {
            int iNextNonBlank2 = nextNonBlank();
            this.cursor = iNextNonBlank2;
            if (cArr[iNextNonBlank2] != '{') {
                throw new CompileException("expected '{' but found: " + cArr[this.cursor], cArr, this.cursor);
            }
            int i19 = iNextNonBlank2 + 1;
            this.cursor = m.e(cArr, i19, this.end, '{', this.pCtx);
            Stacklang stacklang = new Stacklang(cArr, i19, this.cursor - i19, this.fields, this.pCtx);
            this.cursor++;
            this.lastNode = stacklang;
            return stacklang;
        }
        if (z11) {
            int i21 = this.cursor;
            if (cArr[i21] != '(') {
                throw new CompileException("expected '(' but encountered: " + cArr[this.cursor], cArr, this.cursor);
            }
            int iE2 = m.e(cArr, i21, this.end, '(', this.pCtx);
            this.cursor = iE2 + 1;
            i12 = i21 + 1;
            i13 = iE2;
        } else {
            i12 = 0;
            i13 = 0;
        }
        skipWhitespace();
        int i22 = this.cursor;
        int i23 = this.end;
        if (i22 >= i23) {
            throw new CompileException("unexpected end of statement", cArr, this.end);
        }
        if (cArr[i22] == '{') {
            iE = m.e(cArr, i22, i23, '{', this.pCtx);
            this.cursor = iE;
        } else {
            i22--;
            captureToEOSorEOL();
            iE = this.cursor + 1;
        }
        int i24 = iE;
        if (i11 == 2048) {
            IfNode ifNode = (IfNode) aSTNode;
            if (aSTNode == null) {
                return createBlockToken(i12, i13, i22 + 1, i24, i11);
            }
            if (z11) {
                return ifNode.setElseIf((IfNode) createBlockToken(i12, i13, trimRight(i22 + 1), trimLeft(i24), i11));
            }
            int iTrimRight = trimRight(i22 + 1);
            this.f73300st = iTrimRight;
            return ifNode.setElseBlock(cArr, iTrimRight, trimLeft(i24) - this.f73300st, this.pCtx);
        }
        if (i11 != 65536) {
            return createBlockToken(i12, i13, trimRight(i22 + 1), trimLeft(i24), i11);
        }
        this.cursor++;
        skipWhitespace();
        this.f73300st = this.cursor;
        captureToNextTokenJunction();
        int i25 = this.f73300st;
        String str = new String(cArr, i25, this.cursor - i25);
        if ("while".equals(str)) {
            skipWhitespace();
            int i26 = this.cursor;
            int iE3 = m.e(cArr, i26, this.end, '(', this.pCtx);
            this.cursor = iE3;
            return createBlockToken(i26 + 1, iE3, trimRight(i22 + 1), trimLeft(i24), i11);
        }
        if (!"until".equals(str)) {
            throw new CompileException("expected 'while' or 'until' but encountered: " + str, cArr, this.cursor);
        }
        skipWhitespace();
        int i27 = this.cursor;
        int iE4 = m.e(cArr, i27, this.end, '(', this.pCtx);
        this.cursor = iE4;
        return createBlockToken(i27 + 1, iE4, trimRight(i22 + 1), trimLeft(i24), 131072);
    }

    private static int asInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    private ASTNode captureCodeBlock(int i11) {
        ASTNode aSTNode_captureBlock = null;
        if (i11 != 2048) {
            if (i11 == 65536) {
                skipWhitespace();
                return _captureBlock(null, this.expr, false, i11);
            }
            captureToNextTokenJunction();
            skipWhitespace();
            return _captureBlock(null, this.expr, true, i11);
        }
        ASTNode aSTNode = null;
        boolean z11 = true;
        do {
            if (aSTNode_captureBlock != null) {
                captureToNextTokenJunction();
                skipWhitespace();
                char[] cArr = this.expr;
                int i12 = this.cursor;
                char c11 = cArr[i12];
                if (c11 == '{' || c11 != 'i') {
                    z11 = false;
                } else {
                    int i13 = i12 + 1;
                    this.cursor = i13;
                    if (cArr[i13] == 'f') {
                        int iIncNextNonBlank = incNextNonBlank();
                        this.cursor = iIncNextNonBlank;
                        if (cArr[iIncNextNonBlank] == '(') {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                    } else {
                        z11 = false;
                    }
                }
            }
            aSTNode_captureBlock = _captureBlock(aSTNode_captureBlock, this.expr, z11, i11);
            if (((IfNode) aSTNode_captureBlock).getElseBlock() != null) {
                this.cursor++;
                return aSTNode;
            }
            if (aSTNode == null) {
                aSTNode = aSTNode_captureBlock;
            }
            int i14 = this.cursor;
            if (i14 != this.end && this.expr[i14] != ';') {
                this.cursor = i14 + 1;
            }
        } while (ifThenElseBlockContinues());
        return aSTNode;
    }

    private ASTNode createBlockToken(int i11, int i12, int i13, int i14, int i15) {
        this.lastWasIdentifier = false;
        this.cursor++;
        if (isStatementNotManuallyTerminated()) {
            this.splitAccumulator.a(new EndOfStatement(this.pCtx));
        }
        int i16 = i12 - i11;
        int i17 = i14 - i13;
        int i18 = i17 < 0 ? 0 : i17;
        if (i15 == 2048) {
            return new IfNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
        }
        if (i15 != 4096) {
            if (i15 == 16384) {
                return new UntilNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 32768) {
                return new WhileNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 65536) {
                return new DoNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            if (i15 == 131072) {
                return new DoUntilNode(this.expr, i11, i16, i13, i18, this.pCtx);
            }
            if (i15 != 262144) {
                return new WithNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
            }
            for (int i19 = i11; i19 < i12; i19++) {
                char[] cArr = this.expr;
                char c11 = cArr[i19];
                if (c11 == ';') {
                    return new ForNode(cArr, i11, i16, i13, i18, this.fields, this.pCtx);
                }
                if (c11 == ':') {
                    break;
                }
            }
        }
        return new ForEachNode(this.expr, i11, i16, i13, i18, this.fields, this.pCtx);
    }

    private ASTNode createOperator(char[] cArr, int i11, int i12) {
        this.lastWasIdentifier = false;
        OperatorNode operatorNode = new OperatorNode(OPERATORS.get(new String(cArr, i11, i12 - i11)), cArr, i11, this.pCtx);
        this.lastNode = operatorNode;
        return operatorNode;
    }

    private ASTNode createPropertyToken(int i11, int i12) {
        if (m.n0(this.expr, i11, i12)) {
            ParserContext parserContext = this.pCtx;
            if (parserContext != null && parserContext.hasImports()) {
                int iA = t30.b.a('.', i11, i12 - i11, this.expr);
                if (iA != -1) {
                    String str = new String(this.expr, i11, iA - i11);
                    if (this.pCtx.hasImport(str)) {
                        this.lastWasIdentifier = true;
                        LiteralDeepPropertyNode literalDeepPropertyNode = new LiteralDeepPropertyNode(this.expr, iA + 1, (i12 - iA) - 1, this.fields, this.pCtx.getImport(str), this.pCtx);
                        this.lastNode = literalDeepPropertyNode;
                        return literalDeepPropertyNode;
                    }
                } else {
                    ParserContext parserContext2 = this.pCtx;
                    String str2 = new String(this.expr, i11, this.cursor - i11);
                    if (parserContext2.hasImport(str2)) {
                        this.lastWasIdentifier = true;
                        LiteralNode literalNode = new LiteralNode(this.pCtx.getStaticOrClassImport(str2), this.pCtx);
                        this.lastNode = literalNode;
                        return literalNode;
                    }
                }
            }
            HashMap<String, Object> map = LITERALS;
            String str3 = new String(this.expr, i11, i12 - i11);
            if (map.containsKey(str3)) {
                this.lastWasIdentifier = true;
                LiteralNode literalNode2 = new LiteralNode(LITERALS.get(str3), this.pCtx);
                this.lastNode = literalNode2;
                return literalNode2;
            }
            if (OPERATORS.containsKey(str3)) {
                this.lastWasIdentifier = false;
                OperatorNode operatorNode = new OperatorNode(OPERATORS.get(str3), this.expr, i11, this.pCtx);
                this.lastNode = operatorNode;
                return operatorNode;
            }
            if (this.lastWasIdentifier) {
                return procTypedNode(true);
            }
        }
        if (this.pCtx == null || !m.a0(this.expr, i11, i12) || !this.pCtx.hasImport(new String(this.expr, i11, (this.cursor - i11) - 2))) {
            this.lastWasIdentifier = true;
            ASTNode aSTNode = new ASTNode(this.expr, trimRight(i11), trimLeft(i12) - i11, this.fields, this.pCtx);
            this.lastNode = aSTNode;
            return aSTNode;
        }
        this.lastWasIdentifier = true;
        TypeDescriptor typeDescriptor = new TypeDescriptor(this.expr, i11, this.cursor - i11, this.fields);
        try {
            LiteralNode literalNode3 = new LiteralNode(typeDescriptor.getClassReference(this.pCtx), this.pCtx);
            this.lastNode = literalNode3;
            return literalNode3;
        } catch (ClassNotFoundException unused) {
            throw new CompileException("could not resolve class: " + typeDescriptor.getClassName(), this.expr, i11);
        }
    }

    private void dreduce() {
        this.stk.c(this.dStack);
        this.stk.i();
    }

    public static boolean isArithmeticOperator(int i11) {
        return i11 != -1 && i11 < 6;
    }

    public static HashMap<String, Integer> loadLanguageFeaturesByLevel(int i11) {
        HashMap<String, Integer> map = new HashMap<>();
        switch (i11) {
            case 6:
                map.put("proto", 48);
            case 5:
                map.put("if", 39);
                map.put("else", 40);
                map.put("?", 29);
                map.put("switch", 44);
                map.put("function", 100);
                map.put("def", 100);
                map.put("stacklang", 101);
            case 4:
                map.put("=", 31);
                map.put("var", 98);
                map.put("+=", 52);
                map.put("-=", 53);
                map.put("/=", 55);
                map.put("%=", 56);
            case 3:
                map.put("foreach", 38);
                map.put("while", 41);
                map.put("until", 42);
                map.put("for", 43);
                map.put(com.mbridge.msdk.foundation.entity.b.JSON_KEY_DO, 45);
            case 2:
                map.put("return", 99);
                map.put(";", 37);
            case 1:
                map.put("+", 0);
                map.put("-", 1);
                map.put("*", 2);
                map.put("**", 5);
                map.put("/", 3);
                map.put("%", 4);
                map.put("==", 18);
                map.put("!=", 19);
                map.put(">", 15);
                map.put(">=", 17);
                map.put("<", 14);
                map.put("<=", 16);
                map.put("&&", 21);
                map.put("and", 21);
                map.put("||", 22);
                map.put("or", 23);
                map.put("~=", 24);
                map.put("instanceof", 25);
                map.put("is", 25);
                map.put("contains", 26);
                map.put("soundslike", 27);
                map.put("strsim", 28);
                map.put("convertable_to", 36);
                map.put("isdef", 47);
                map.put(Utils.SEPARATOR, 20);
                map.put("&", 6);
                map.put("|", 7);
                map.put("^", 8);
                map.put("<<", 10);
                map.put("<<<", 12);
                map.put(">>", 9);
                map.put(">>>", 11);
                map.put("new", 34);
                map.put("in", 35);
                map.put("with", 46);
                map.put("assert", 97);
                map.put("import", 96);
                map.put("import_static", 95);
                map.put("++", 50);
                map.put("--", 51);
            case 0:
                map.put(":", 30);
            default:
                return map;
        }
    }

    private ASTNode procTypedNode(boolean z11) {
        while (true) {
            if (this.lastNode.getLiteralValue() instanceof String) {
                char[] charArray = ((String) this.lastNode.getLiteralValue()).toCharArray();
                try {
                    this.lastNode.setLiteralValue(TypeDescriptor.getClassReference(this.pCtx, new TypeDescriptor(charArray, 0, charArray.length, 0)));
                    this.lastNode.discard();
                } catch (Exception unused) {
                }
            }
            if (this.lastNode.isLiteral() && (this.lastNode.getLiteralValue() instanceof Class)) {
                this.lastNode.discard();
                captureToEOS();
                if (z11) {
                    g gVar = this.splitAccumulator;
                    char[] cArr = this.expr;
                    int i11 = this.f73300st;
                    String str = new String(cArr, i11, this.cursor - i11);
                    char[] cArr2 = this.expr;
                    int i12 = this.f73300st;
                    gVar.a(new DeclTypedVarNode(str, cArr2, i12, this.cursor - i12, (Class) this.lastNode.getLiteralValue(), this.fields | 128, this.pCtx));
                } else {
                    captureToEOS();
                    g gVar2 = this.splitAccumulator;
                    char[] cArr3 = this.expr;
                    int i13 = this.f73300st;
                    gVar2.a(new TypedVarNode(cArr3, i13, (this.cursor - i13) - 1, this.fields | 128, (Class) this.lastNode.getLiteralValue(), this.pCtx));
                }
            } else if (this.lastNode instanceof Proto) {
                captureToEOS();
                if (z11) {
                    g gVar3 = this.splitAccumulator;
                    char[] cArr4 = this.expr;
                    int i14 = this.f73300st;
                    gVar3.a(new DeclProtoVarNode(new String(cArr4, i14, this.cursor - i14), (Proto) this.lastNode, this.fields | 128, this.pCtx));
                } else {
                    g gVar4 = this.splitAccumulator;
                    char[] cArr5 = this.expr;
                    int i15 = this.f73300st;
                    gVar4.a(new ProtoVarNode(cArr5, i15, this.cursor - i15, this.fields | 128, (Proto) this.lastNode, this.pCtx));
                }
            } else {
                if ((this.fields & 16) != 0) {
                    throw new CompileException("unknown class or illegal statement: " + this.lastNode.getLiteralValue(), this.expr, this.cursor);
                }
                if (this.stk.k() instanceof Class) {
                    captureToEOS();
                    if (z11) {
                        g gVar5 = this.splitAccumulator;
                        char[] cArr6 = this.expr;
                        int i16 = this.f73300st;
                        String str2 = new String(cArr6, i16, this.cursor - i16);
                        char[] cArr7 = this.expr;
                        int i17 = this.f73300st;
                        gVar5.a(new DeclTypedVarNode(str2, cArr7, i17, this.cursor - i17, (Class) this.stk.n(), this.fields | 128, this.pCtx));
                    } else {
                        g gVar6 = this.splitAccumulator;
                        char[] cArr8 = this.expr;
                        int i18 = this.f73300st;
                        gVar6.a(new TypedVarNode(cArr8, i18, this.cursor - i18, this.fields | 128, (Class) this.stk.n(), this.pCtx));
                    }
                } else {
                    if (!(this.stk.k() instanceof Proto)) {
                        throw new CompileException("unknown class or illegal statement: " + this.lastNode.getLiteralValue(), this.expr, this.cursor);
                    }
                    captureToEOS();
                    if (z11) {
                        g gVar7 = this.splitAccumulator;
                        char[] cArr9 = this.expr;
                        int i19 = this.f73300st;
                        gVar7.a(new DeclProtoVarNode(new String(cArr9, i19, this.cursor - i19), (Proto) this.stk.n(), this.fields | 128, this.pCtx));
                    } else {
                        g gVar8 = this.splitAccumulator;
                        char[] cArr10 = this.expr;
                        int i21 = this.f73300st;
                        gVar8.a(new ProtoVarNode(cArr10, i21, this.cursor - i21, this.fields | 128, (Proto) this.stk.n(), this.pCtx));
                    }
                }
            }
            skipWhitespace();
            int i22 = this.cursor;
            if (i22 >= this.end || this.expr[i22] != ',') {
                return (ASTNode) this.splitAccumulator.n();
            }
            int i23 = i22 + 1;
            this.cursor = i23;
            this.f73300st = i23;
            this.splitAccumulator.a(new EndOfStatement(this.pCtx));
        }
    }

    private void reduce(int i11, int i12, int i13) {
        switch (i12) {
            case 6:
                this.stk.q(Integer.valueOf(i11 & i13));
                break;
            case 7:
                this.stk.q(Integer.valueOf(i11 | i13));
                break;
            case 8:
                this.stk.q(Integer.valueOf(i11 ^ i13));
                break;
            case 9:
                this.stk.q(Integer.valueOf(i11 >> i13));
                break;
            case 10:
                this.stk.q(Integer.valueOf(i11 << i13));
                break;
            case 11:
                this.stk.q(Integer.valueOf(i11 >>> i13));
                break;
            case 12:
                if (i11 < 0) {
                    i11 *= -1;
                }
                this.stk.q(Integer.valueOf(i11 << i13));
                break;
        }
    }

    private void reduce(int i11, int i12, long j11) {
        switch (i12) {
            case 6:
                this.stk.q(Long.valueOf(j11 & ((long) i11)));
                break;
            case 7:
                this.stk.q(Long.valueOf(j11 | ((long) i11)));
                break;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ ((long) i11)));
                break;
            case 9:
                this.stk.q(Integer.valueOf(i11 >> ((int) j11)));
                break;
            case 10:
                this.stk.q(Integer.valueOf(i11 << ((int) j11)));
                break;
            case 11:
                this.stk.q(Integer.valueOf(i11 >>> ((int) j11)));
                break;
            case 12:
                if (i11 < 0) {
                    i11 *= -1;
                }
                this.stk.q(Integer.valueOf(i11 << ((int) j11)));
                break;
        }
    }

    private void reduce(long j11, int i11, int i12) {
        switch (i11) {
            case 6:
                this.stk.q(Long.valueOf(j11 & ((long) i12)));
                break;
            case 7:
                this.stk.q(Long.valueOf(j11 | ((long) i12)));
                break;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ ((long) i12)));
                break;
            case 9:
                this.stk.q(Long.valueOf(j11 >> i12));
                break;
            case 10:
                this.stk.q(Long.valueOf(j11 << i12));
                break;
            case 11:
                this.stk.q(Long.valueOf(j11 >>> i12));
                break;
            case 12:
                if (j11 < 0) {
                    j11 *= -1;
                }
                this.stk.q(Long.valueOf(j11 << i12));
                break;
        }
    }

    private void reduce(long j11, int i11, long j12) {
        switch (i11) {
            case 6:
                this.stk.q(Long.valueOf(j11 & j12));
                break;
            case 7:
                this.stk.q(Long.valueOf(j11 | j12));
                break;
            case 8:
                this.stk.q(Long.valueOf(j11 ^ j12));
                break;
            case 9:
                this.stk.q(Long.valueOf(j11 >> ((int) j12)));
                break;
            case 10:
                this.stk.q(Long.valueOf(j11 << ((int) j12)));
                break;
            case 11:
                this.stk.q(Long.valueOf(j11 >>> ((int) j12)));
                break;
            case 12:
                if (j11 < 0) {
                    j11 *= -1;
                }
                this.stk.q(Long.valueOf(j11 << ((int) j12)));
                break;
        }
    }

    private void reduceNumeric(int i11) {
        Object objL = this.stk.l();
        Object objO = this.stk.o();
        if (objL instanceof Integer) {
            if (objO instanceof Integer) {
                reduce(((Integer) objL).intValue(), i11, ((Integer) objO).intValue());
                return;
            } else {
                reduce(((Integer) objL).intValue(), i11, ((Long) objO).longValue());
                return;
            }
        }
        if (objO instanceof Integer) {
            reduce(((Long) objL).longValue(), i11, ((Integer) objO).intValue());
        } else {
            reduce(((Long) objL).longValue(), i11, ((Long) objO).longValue());
        }
    }

    public static void setLanguageLevel(int i11) {
        OPERATORS.clear();
        OPERATORS.putAll(loadLanguageFeaturesByLevel(i11));
    }

    public static void setupParser() {
        HashMap<String, Object> map = LITERALS;
        if (map == null || map.isEmpty()) {
            LITERALS = new HashMap<>();
            CLASS_LITERALS = new HashMap<>();
            OPERATORS = new HashMap<>();
            CLASS_LITERALS.put("System", System.class);
            CLASS_LITERALS.put("String", String.class);
            CLASS_LITERALS.put("CharSequence", CharSequence.class);
            CLASS_LITERALS.put("Integer", Integer.class);
            CLASS_LITERALS.put("int", Integer.TYPE);
            CLASS_LITERALS.put("Long", Long.class);
            CLASS_LITERALS.put("long", Long.TYPE);
            CLASS_LITERALS.put("Boolean", Boolean.class);
            CLASS_LITERALS.put("boolean", Boolean.TYPE);
            CLASS_LITERALS.put("Short", Short.class);
            CLASS_LITERALS.put("short", Short.TYPE);
            CLASS_LITERALS.put("Character", Character.class);
            CLASS_LITERALS.put("char", Character.TYPE);
            CLASS_LITERALS.put("Double", Double.class);
            CLASS_LITERALS.put("double", Double.TYPE);
            CLASS_LITERALS.put("Float", Float.class);
            CLASS_LITERALS.put("float", Float.TYPE);
            CLASS_LITERALS.put("Byte", Byte.class);
            CLASS_LITERALS.put("byte", Byte.TYPE);
            CLASS_LITERALS.put("Math", Math.class);
            CLASS_LITERALS.put("Void", Void.class);
            CLASS_LITERALS.put("Object", Object.class);
            CLASS_LITERALS.put("Number", Number.class);
            CLASS_LITERALS.put("Class", Class.class);
            CLASS_LITERALS.put("ClassLoader", ClassLoader.class);
            CLASS_LITERALS.put("Runtime", Runtime.class);
            CLASS_LITERALS.put("Thread", Thread.class);
            CLASS_LITERALS.put("Compiler", Compiler.class);
            CLASS_LITERALS.put("StringBuffer", StringBuffer.class);
            CLASS_LITERALS.put("ThreadLocal", ThreadLocal.class);
            CLASS_LITERALS.put("SecurityManager", SecurityManager.class);
            CLASS_LITERALS.put("StrictMath", StrictMath.class);
            CLASS_LITERALS.put("Exception", Exception.class);
            CLASS_LITERALS.put("Array", Array.class);
            CLASS_LITERALS.put("StringBuilder", StringBuilder.class);
            LITERALS.putAll(CLASS_LITERALS);
            LITERALS.put("true", Boolean.TRUE);
            LITERALS.put("false", Boolean.FALSE);
            LITERALS.put("null", null);
            LITERALS.put("nil", null);
            LITERALS.put("empty", BlankLiteral.INSTANCE);
            setLanguageLevel(Boolean.getBoolean("mvel.future.lang.support") ? 6 : 5);
        }
    }

    private char[] subArray(int i11, int i12) {
        if (i11 >= i12) {
            return new char[0];
        }
        int i13 = i12 - i11;
        char[] cArr = new char[i13];
        for (int i14 = 0; i14 != i13; i14++) {
            cArr[i14] = this.expr[i14 + i11];
        }
        return cArr;
    }

    public void addFatalError(String str) {
        this.pCtx.addError(new c(this.expr, this.f73300st, true, str));
    }

    public void addFatalError(String str, int i11) {
        this.pCtx.addError(new c(this.expr, i11, true, str));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b9 A[PHI: r8
  0x00b9: PHI (r8v17 int) = (r8v16 int), (r8v42 int), (r8v42 int), (r8v42 int) binds: [B:16:0x005e, B:18:0x0068, B:19:0x006a, B:21:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:90:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:91:0x01bf  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x01bf, please report this as an issue */
    public int arithmeticFunctionReduction(int i11) {
        ASTNode aSTNodeNextToken = nextToken();
        if (aSTNodeNextToken != null) {
            int iIntValue = aSTNodeNextToken.getOperator().intValue();
            if (isArithmeticOperator(iIntValue)) {
                int[] iArr = org.mvel2.g.f73314a;
                if (iArr[iIntValue] > iArr[i11]) {
                    this.stk.u();
                    ASTNode aSTNodeNextToken2 = nextToken();
                    if (this.compileMode && !aSTNodeNextToken2.isLiteral()) {
                        this.splitAccumulator.r(aSTNodeNextToken2, new OperatorNode(Integer.valueOf(iIntValue), this.expr, this.f73300st, this.pCtx));
                        return -2;
                    }
                    g gVar = this.dStack;
                    Integer numValueOf = Integer.valueOf(iIntValue);
                    Object obj = this.ctx;
                    gVar.r(numValueOf, aSTNodeNextToken2.getReducedValue(obj, obj, this.variableFactory));
                    int iIntValue2 = iIntValue;
                    while (true) {
                        ASTNode aSTNodeNextToken3 = nextToken();
                        if (aSTNodeNextToken3 != null && (iIntValue2 = aSTNodeNextToken3.getOperator().intValue()) != -1 && iIntValue2 != 37) {
                            int[] iArr2 = org.mvel2.g.f73314a;
                            if (iArr2[iIntValue2] > iArr2[iIntValue]) {
                                if (this.dStack.h()) {
                                    this.stk.d(this.dStack);
                                }
                                ASTNode aSTNodeNextToken4 = nextToken();
                                if (this.compileMode && !aSTNodeNextToken4.isLiteral()) {
                                    this.splitAccumulator.r(aSTNodeNextToken4, new OperatorNode(Integer.valueOf(iIntValue2), this.expr, this.f73300st, this.pCtx));
                                    return -2;
                                }
                                g gVar2 = this.dStack;
                                Integer numValueOf2 = Integer.valueOf(iIntValue2);
                                Object obj2 = this.ctx;
                                gVar2.r(numValueOf2, aSTNodeNextToken4.getReducedValue(obj2, obj2, this.variableFactory));
                            } else if (aSTNodeNextToken3 != null) {
                            }
                            iIntValue = iIntValue2;
                        } else {
                            if (aSTNodeNextToken3 != null || iIntValue2 == -1 || iIntValue2 == 37) {
                                break;
                            }
                            int[] iArr3 = org.mvel2.g.f73314a;
                            if (iArr3[iIntValue2] == iArr3[iIntValue]) {
                                if (this.dStack.g()) {
                                    while (this.stk.h()) {
                                        this.stk.w();
                                    }
                                } else {
                                    dreduce();
                                }
                                g gVar3 = this.dStack;
                                Integer numValueOf3 = Integer.valueOf(iIntValue2);
                                ASTNode aSTNodeNextToken5 = nextToken();
                                Object obj3 = this.ctx;
                                gVar3.r(numValueOf3, aSTNodeNextToken5.getReducedValue(obj3, obj3, this.variableFactory));
                                iIntValue = iIntValue2;
                            } else {
                                while (this.dStack.t() > 1) {
                                    dreduce();
                                }
                                iIntValue = aSTNodeNextToken3.getOperator().intValue();
                                while (this.stk.t() != 1 && (this.stk.l() instanceof Integer)) {
                                    iIntValue2 = ((Integer) this.stk.l()).intValue();
                                    int[] iArr4 = org.mvel2.g.f73314a;
                                    if (iIntValue2 >= iArr4.length || iArr4[iIntValue2] < iArr4[iIntValue]) {
                                        break;
                                    }
                                    this.stk.w();
                                }
                                ASTNode aSTNodeNextToken6 = nextToken();
                                if (aSTNodeNextToken6 == null) {
                                    continue;
                                } else {
                                    if (iIntValue == 21) {
                                        if (!this.stk.m().booleanValue()) {
                                            return -1;
                                        }
                                        this.splitAccumulator.a(aSTNodeNextToken6);
                                        return 21;
                                    }
                                    if (iIntValue == 22) {
                                        if (this.stk.m().booleanValue()) {
                                            return -1;
                                        }
                                        this.splitAccumulator.a(aSTNodeNextToken6);
                                        return 22;
                                    }
                                    if (this.compileMode && !aSTNodeNextToken6.isLiteral()) {
                                        this.stk.r(Integer.valueOf(iIntValue), aSTNodeNextToken6);
                                        return -3;
                                    }
                                    g gVar4 = this.stk;
                                    Integer numValueOf4 = Integer.valueOf(iIntValue);
                                    Object obj4 = this.ctx;
                                    gVar4.r(numValueOf4, aSTNodeNextToken6.getReducedValue(obj4, obj4, this.variableFactory));
                                }
                            }
                        }
                    }
                    if (this.dStack.t() > 1) {
                        dreduce();
                    }
                    if (this.stk.h()) {
                        this.stk.u();
                    }
                } else {
                    if (aSTNodeNextToken.isOperator()) {
                        throw new CompileException("unexpected token: " + aSTNodeNextToken.getName(), this.expr, this.f73300st);
                    }
                    reduce();
                    this.splitAccumulator.q(aSTNodeNextToken);
                }
            } else {
                if (aSTNodeNextToken.isOperator()) {
                    throw new CompileException("unexpected token: " + aSTNodeNextToken.getName(), this.expr, this.f73300st);
                }
                reduce();
                this.splitAccumulator.q(aSTNodeNextToken);
            }
        }
        if (!this.stk.h()) {
            return 0;
        }
        while (true) {
            reduce();
            if (!this.stk.h()) {
                return 0;
            }
            this.stk.u();
        }
    }

    public void captureIdentifier() {
        char c11;
        if (this.cursor == this.end) {
            throw new CompileException("unexpected end of statement: EOF", this.expr, this.cursor);
        }
        boolean z11 = false;
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || (c11 = this.expr[i11]) == ';') {
                return;
            }
            if (!m.c0(c11)) {
                if (z11) {
                    return;
                }
                throw new CompileException("unexpected symbol (was expecting an identifier): " + this.expr[this.cursor], this.expr, this.cursor);
            }
            this.cursor++;
            z11 = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x002b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0038  */
    /* JADX WARN: Code duplicated, block: B:31:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x003e A[SYNTHETIC] */
    public void captureToEOS() {
        int iE;
        while (true) {
            int i11 = this.cursor;
            int i12 = this.end;
            if (i11 == i12) {
                return;
            }
            char[] cArr = this.expr;
            char c11 = cArr[i11];
            if (c11 == '\"') {
                this.cursor = m.h(c11, cArr, i11, i12);
            } else {
                if (c11 == ',' || c11 == ';') {
                    return;
                }
                if (c11 == '[' || c11 == '{') {
                    iE = m.e(cArr, i11, i12, c11, this.pCtx);
                    this.cursor = iE;
                    if (iE >= this.end) {
                        return;
                    }
                } else {
                    if (c11 == '}') {
                        return;
                    }
                    if (c11 == '\'') {
                        this.cursor = m.h(c11, cArr, i11, i12);
                    } else if (c11 != '(') {
                        continue;
                    } else {
                        iE = m.e(cArr, i11, i12, c11, this.pCtx);
                        this.cursor = iE;
                        if (iE >= this.end) {
                            return;
                        }
                    }
                }
            }
            this.cursor++;
        }
    }

    public void captureToEOSorEOL() {
        char c11;
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || (c11 = this.expr[i11]) == '\n' || c11 == '\r' || c11 == ';') {
                return;
            } else {
                this.cursor = i11 + 1;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0079 A[SYNTHETIC] */
    public void captureToEOT() {
        int i11;
        int iE;
        skipWhitespace();
        do {
            char[] cArr = this.expr;
            int i12 = this.cursor;
            char c11 = cArr[i12];
            if (c11 == '\"') {
                this.cursor = m.h('\"', cArr, i12, this.end);
            } else {
                if (c11 == ';' || c11 == '=') {
                    return;
                }
                if (c11 == '[') {
                    iE = m.e(cArr, i12, this.end, c11, this.pCtx);
                    this.cursor = iE;
                    if (iE == -1) {
                        throw new CompileException("unbalanced braces", this.expr, this.cursor);
                    }
                } else if (c11 == '.') {
                    this.cursor = i12 + 1;
                    skipWhitespace();
                    this.cursor--;
                } else {
                    if (c11 == '/') {
                        return;
                    }
                    if (c11 == '{') {
                        iE = m.e(cArr, i12, this.end, c11, this.pCtx);
                        this.cursor = iE;
                        if (iE == -1) {
                            throw new CompileException("unbalanced braces", this.expr, this.cursor);
                        }
                    } else if (c11 != '|') {
                        switch (c11) {
                            case '%':
                            case '&':
                                return;
                            case '\'':
                                this.cursor = m.h('\'', cArr, i12, this.end);
                                break;
                            case '(':
                                iE = m.e(cArr, i12, this.end, c11, this.pCtx);
                                this.cursor = iE;
                                if (iE == -1) {
                                    throw new CompileException("unbalanced braces", this.expr, this.cursor);
                                }
                                break;
                            default:
                                switch (c11) {
                                    case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                    case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                        return;
                                    default:
                                        if (m.q0(c11)) {
                                            skipWhitespace();
                                            int i13 = this.cursor;
                                            int i14 = this.end;
                                            if (i13 >= i14 || this.expr[i13] != '.') {
                                                trimWhitespace();
                                                return;
                                            } else {
                                                if (i13 != i14) {
                                                    this.cursor = i13 + 1;
                                                }
                                                skipWhitespace();
                                            }
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        return;
                    }
                }
            }
            i11 = this.cursor + 1;
            this.cursor = i11;
        } while (i11 < this.end);
    }

    public void captureToNextTokenJunction() {
        char[] cArr;
        char c11;
        while (true) {
            int i11 = this.cursor;
            int i12 = this.end;
            if (i11 == i12 || (c11 = (cArr = this.expr)[i11]) == '(') {
                return;
            }
            if (c11 != '/') {
                if (c11 != '[') {
                    if (c11 == '{' || m.q0(c11)) {
                        return;
                    } else {
                        this.cursor++;
                    }
                }
            } else if (cArr[i11 + 1] == '*') {
                return;
            }
            this.cursor = m.e(cArr, i11, i12, '[', this.pCtx) + 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0048  */
    /* JADX WARN: Code duplicated, block: B:34:0x004e A[RETURN] */
    public void expectEOS() {
        char c11;
        skipWhitespace();
        int i11 = this.cursor;
        if (i11 == this.end || (c11 = this.expr[i11]) == ';') {
            return;
        }
        if (c11 != '!') {
            if (c11 != '&') {
                if (c11 == '-' || c11 == '/') {
                    if (lookAhead() == '=') {
                        return;
                    }
                } else if (c11 != '|') {
                    if (c11 != '*' && c11 != '+') {
                        switch (c11) {
                            case '<':
                            case '>':
                                return;
                            case '=':
                                char cLookAhead = lookAhead();
                                if (cLookAhead == '*' || cLookAhead == '+' || cLookAhead == '-' || cLookAhead == '=') {
                                    return;
                                }
                                break;
                        }
                    } else if (lookAhead() == '=') {
                        return;
                    }
                } else if (lookAhead() == '|') {
                    return;
                }
            } else if (lookAhead() == '&') {
                return;
            }
        } else if (lookAhead() == '=') {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected end of statement but encountered: ");
        int i12 = this.cursor;
        sb2.append(i12 == this.end ? "<end of stream>" : Character.valueOf(this.expr[i12]));
        throw new CompileException(sb2.toString(), this.expr, this.cursor);
    }

    public void expectNextChar_IW(char c11) {
        nextNonBlank();
        int i11 = this.cursor;
        if (i11 == this.end) {
            throw new CompileException("unexpected end of statement", this.expr, this.f73300st);
        }
        if (this.expr[i11] == c11) {
            return;
        }
        throw new CompileException("unexpected character ('" + this.expr[this.cursor] + "'); was expecting: " + c11, this.expr, this.f73300st);
    }

    public int getCursor() {
        return this.cursor;
    }

    public char[] getExpression() {
        return this.expr;
    }

    public ASTNode handleSubstatement(Substatement substatement) {
        return (substatement.getStatement() == null || !substatement.getStatement().isLiteralOnly()) ? substatement : new LiteralNode(substatement.getStatement().getValue(null, null, null), this.pCtx);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    public ASTNode handleUnion(ASTNode aSTNode) {
        int i11;
        if (this.cursor != this.end) {
            skipWhitespace();
            int i12 = this.cursor;
            if (i12 >= this.end) {
                i11 = -1;
            } else {
                char c11 = this.expr[i12];
                if (c11 == '.') {
                    i12++;
                } else if (c11 != '[') {
                    i11 = -1;
                }
                i11 = i12;
            }
            if (i11 != -1) {
                captureToEOT();
                Union union = new Union(this.expr, i11, this.cursor - i11, this.fields, aSTNode, this.pCtx);
                this.lastNode = union;
                return union;
            }
        }
        this.lastNode = aSTNode;
        return aSTNode;
    }

    public boolean ifThenElseBlockContinues() {
        int i11 = this.cursor;
        if (i11 + 4 >= this.end) {
            return false;
        }
        if (this.expr[i11] != ';') {
            this.cursor = i11 - 1;
        }
        skipWhitespace();
        int i12 = this.cursor;
        if (i12 + 4 >= this.end) {
            return false;
        }
        char[] cArr = this.expr;
        if (cArr[i12] == 'e' && cArr[i12 + 1] == 'l' && cArr[i12 + 2] == 's' && cArr[i12 + 3] == 'e') {
            return m.q0(cArr[i12 + 4]) || this.expr[this.cursor + 4] == '{';
        }
        return false;
    }

    public int incNextNonBlank() {
        this.cursor++;
        return nextNonBlank();
    }

    public boolean isNextIdentifier() {
        while (true) {
            int i11 = this.cursor;
            if (i11 == this.end || !m.q0(this.expr[i11])) {
                break;
            }
            this.cursor++;
        }
        int i12 = this.cursor;
        return i12 != this.end && m.c0(this.expr[i12]);
    }

    public boolean isNextIdentifierOrLiteral() {
        int i11 = this.cursor;
        if (i11 == this.end) {
            return false;
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        if (i11 == this.end) {
            return false;
        }
        char c11 = this.expr[i11];
        return m.c0(c11) || m.b0(c11) || c11 == '\'' || c11 == '\"';
    }

    public boolean isStatementNotManuallyTerminated() {
        int i11 = this.cursor;
        if (i11 >= this.end) {
            return false;
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11 == this.end || this.expr[i11] != ';';
    }

    public boolean lastNonWhite(char c11) {
        int i11 = this.cursor - 1;
        while (m.q0(this.expr[i11])) {
            i11--;
        }
        return c11 == this.expr[i11];
    }

    public char lookAhead() {
        int i11 = this.cursor;
        if (i11 + 1 != this.end) {
            return this.expr[i11 + 1];
        }
        return (char) 0;
    }

    public char lookAhead(int i11) {
        int i12 = this.cursor;
        if (i12 + i11 >= this.end) {
            return (char) 0;
        }
        return this.expr[i12 + i11];
    }

    public char lookBehind() {
        int i11 = this.cursor;
        if (i11 == this.start) {
            return (char) 0;
        }
        return this.expr[i11 - 1];
    }

    public char lookToLast() {
        int i11 = this.cursor;
        if (i11 == this.start) {
            return (char) 0;
        }
        while (i11 != this.start) {
            i11--;
            if (!m.q0(this.expr[i11])) {
                break;
            }
        }
        return this.expr[i11];
    }

    public int nextNonBlank() {
        int i11 = this.cursor;
        if (i11 + 1 >= this.end) {
            throw new CompileException("unexpected end of statement", this.expr, this.f73300st);
        }
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x0381 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0393 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x039f A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x03a9 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x046d A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0474 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:661:0x1140 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:663:0x1149 A[Catch: CompileException -> 0x0023, ArrayIndexOutOfBoundsException -> 0x0027, StringIndexOutOfBoundsException -> 0x002b, NumberFormatException -> 0x002f, RedundantCodeException -> 0x12d2, TryCatch #4 {ArrayIndexOutOfBoundsException -> 0x0027, NumberFormatException -> 0x002f, StringIndexOutOfBoundsException -> 0x002b, CompileException -> 0x0023, RedundantCodeException -> 0x12d2, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x001a, B:9:0x001e, B:20:0x0034, B:23:0x003c, B:25:0x0042, B:26:0x004a, B:28:0x0050, B:30:0x0054, B:32:0x005c, B:34:0x0068, B:35:0x0073, B:38:0x007d, B:40:0x009b, B:42:0x00a3, B:44:0x00c2, B:45:0x00cd, B:46:0x00ce, B:47:0x00d2, B:48:0x00db, B:50:0x00e1, B:52:0x00eb, B:53:0x00f0, B:55:0x00f6, B:57:0x0100, B:61:0x0114, B:63:0x012a, B:65:0x0136, B:68:0x0148, B:69:0x014b, B:70:0x014e, B:72:0x0153, B:74:0x0158, B:76:0x0166, B:78:0x0188, B:79:0x018d, B:81:0x0199, B:83:0x019f, B:86:0x01a8, B:87:0x01b3, B:88:0x01b4, B:90:0x01c3, B:92:0x01c9, B:94:0x020a, B:96:0x0210, B:99:0x0219, B:100:0x0226, B:93:0x01e6, B:102:0x022f, B:104:0x0255, B:106:0x0276, B:108:0x0291, B:107:0x0280, B:110:0x0294, B:112:0x02c9, B:114:0x02d0, B:116:0x02ee, B:118:0x02f5, B:120:0x02fc, B:122:0x0303, B:124:0x030a, B:126:0x0312, B:127:0x031d, B:128:0x031e, B:130:0x0325, B:132:0x032c, B:134:0x0340, B:136:0x034c, B:139:0x0354, B:141:0x035a, B:142:0x035d, B:144:0x0381, B:146:0x0393, B:148:0x039f, B:150:0x03a9, B:152:0x03bd, B:154:0x03c3, B:156:0x03d1, B:158:0x03dd, B:164:0x03f3, B:166:0x040c, B:168:0x043e, B:162:0x03e7, B:163:0x03f2, B:170:0x0453, B:171:0x045e, B:172:0x045f, B:174:0x046d, B:176:0x0474, B:177:0x047f, B:178:0x0480, B:179:0x04a0, B:180:0x04a1, B:182:0x04b6, B:184:0x04bf, B:186:0x04c7, B:187:0x04d0, B:189:0x04d6, B:206:0x04fc, B:207:0x04ff, B:208:0x0502, B:210:0x0507, B:214:0x0511, B:215:0x0516, B:217:0x051c, B:219:0x0526, B:220:0x052c, B:222:0x0534, B:225:0x0542, B:226:0x0548, B:228:0x0550, B:230:0x0556, B:232:0x055e, B:234:0x0566, B:236:0x056d, B:238:0x058c, B:240:0x05ae, B:242:0x05b2, B:244:0x05b8, B:246:0x05cf, B:248:0x05f1, B:250:0x05fa, B:252:0x0601, B:254:0x0620, B:256:0x0642, B:258:0x0646, B:260:0x064c, B:262:0x0663, B:264:0x0684, B:266:0x068c, B:268:0x06ac, B:270:0x06b3, B:272:0x06b9, B:274:0x06cf, B:276:0x06f1, B:277:0x0716, B:278:0x0717, B:280:0x071f, B:282:0x073f, B:284:0x0746, B:286:0x074c, B:288:0x0762, B:290:0x0783, B:291:0x07a8, B:292:0x07a9, B:294:0x07ad, B:296:0x07b3, B:298:0x07ba, B:300:0x07da, B:302:0x07de, B:304:0x07e4, B:306:0x07e8, B:308:0x07ee, B:310:0x07f6, B:312:0x081f, B:313:0x0831, B:315:0x0834, B:317:0x084e, B:319:0x0856, B:321:0x085d, B:323:0x087c, B:325:0x089e, B:327:0x08a2, B:329:0x08a8, B:331:0x08bf, B:333:0x08e1, B:334:0x08ea, B:337:0x08f4, B:339:0x08fe, B:341:0x0902, B:343:0x090c, B:345:0x0914, B:347:0x091e, B:350:0x0928, B:352:0x0947, B:354:0x0969, B:356:0x096d, B:358:0x0973, B:360:0x0992, B:362:0x09a8, B:364:0x09bd, B:366:0x09c3, B:368:0x09d6, B:367:0x09cd, B:370:0x09e2, B:373:0x09ec, B:375:0x09f6, B:377:0x09fa, B:379:0x0a04, B:381:0x0a0c, B:383:0x0a16, B:384:0x0a1d, B:386:0x0a35, B:388:0x0a60, B:390:0x0a64, B:392:0x0a6a, B:394:0x0a8b, B:396:0x0ab7, B:398:0x0acc, B:400:0x0ad2, B:402:0x0ae5, B:401:0x0adc, B:404:0x0af1, B:407:0x0b04, B:408:0x0b0f, B:410:0x0b15, B:412:0x0b39, B:414:0x0b3f, B:416:0x0b5e, B:418:0x0b82, B:420:0x0b86, B:422:0x0b8c, B:424:0x0ba5, B:426:0x0bc8, B:427:0x0bd3, B:429:0x0bdf, B:434:0x0bed, B:435:0x0bf0, B:436:0x0bf3, B:437:0x0bf6, B:438:0x0bf9, B:439:0x0bfc, B:440:0x0c02, B:442:0x0c09, B:448:0x0c3b, B:450:0x0c45, B:453:0x0c65, B:454:0x0c68, B:444:0x0c13, B:446:0x0c1f, B:456:0x0c71, B:458:0x0c7b, B:460:0x0c86, B:462:0x0c8d, B:464:0x0c99, B:466:0x0c9f, B:468:0x0cb7, B:470:0x0cd1, B:471:0x0cf7, B:472:0x0cf8, B:474:0x0cfc, B:475:0x0d02, B:479:0x0d0c, B:481:0x0d16, B:483:0x0d20, B:484:0x0d24, B:486:0x0d2d, B:488:0x0d38, B:490:0x0d43, B:492:0x0d4d, B:494:0x0d55, B:495:0x0d59, B:498:0x0d64, B:500:0x0d6f, B:502:0x0d76, B:504:0x0d86, B:507:0x0d95, B:509:0x0dc8, B:511:0x0dd1, B:513:0x0df2, B:515:0x0df8, B:517:0x0e02, B:519:0x0e0c, B:521:0x0e12, B:523:0x0e16, B:525:0x0e1a, B:531:0x0e45, B:533:0x0e4b, B:535:0x0e4f, B:537:0x0e53, B:541:0x0e63, B:539:0x0e59, B:543:0x0e71, B:545:0x0e79, B:547:0x0e85, B:550:0x0e90, B:551:0x0e9b, B:552:0x0e9c, B:527:0x0e20, B:529:0x0e2a, B:553:0x0ea3, B:555:0x0eab, B:557:0x0ecc, B:559:0x0ed2, B:561:0x0edc, B:563:0x0ee6, B:565:0x0ef4, B:567:0x0efc, B:568:0x0f01, B:570:0x0f0f, B:571:0x0f18, B:574:0x0f22, B:578:0x0f2c, B:583:0x0f37, B:585:0x0f3d, B:623:0x102d, B:588:0x0f4a, B:589:0x0f4e, B:590:0x0f52, B:592:0x0f5c, B:594:0x0f66, B:596:0x0f6e, B:599:0x0f7a, B:601:0x0f80, B:603:0x0f86, B:619:0x1014, B:605:0x0f8b, B:607:0x0f8f, B:609:0x0f98, B:611:0x0fc1, B:612:0x0fc4, B:614:0x0fe4, B:616:0x1004, B:617:0x1007, B:618:0x100e, B:620:0x101b, B:621:0x1026, B:622:0x1027, B:626:0x1038, B:627:0x1050, B:629:0x1056, B:631:0x105e, B:632:0x1060, B:634:0x1065, B:639:0x1070, B:641:0x1076, B:646:0x1082, B:649:0x10a5, B:651:0x10d7, B:652:0x10f6, B:653:0x10f7, B:655:0x1101, B:657:0x110c, B:659:0x1113, B:661:0x1140, B:663:0x1149, B:665:0x114c, B:667:0x1155, B:669:0x1159, B:672:0x1160, B:673:0x116b, B:674:0x116c, B:676:0x1187, B:679:0x1190, B:681:0x11a5, B:683:0x11bd, B:685:0x11c7, B:689:0x11e9, B:692:0x11f3, B:694:0x11fd, B:695:0x1209, B:696:0x120a, B:698:0x1214, B:699:0x121f, B:700:0x1220, B:702:0x1231, B:704:0x1256, B:705:0x1259, B:707:0x126e, B:709:0x1287, B:713:0x128d), top: B:730:0x0002 }] */
    public ASTNode nextToken() {
        Class classReference;
        char c11;
        int iVariableIndexOf;
        int iVariableIndexOf2;
        ASTNode aSTNode;
        ASTNode aSTNode2;
        char[] cArr;
        char c12;
        int iVariableIndexOf3;
        int iVariableIndexOf4;
        int iVariableIndexOf5;
        int i11;
        int iVariableIndexOf6;
        int iVariableIndexOf7;
        int i12;
        int iVariableIndexOf8;
        int iVariableIndexOf9;
        int iVariableIndexOf10;
        int iVariableIndexOf11;
        int iVariableIndexOf12;
        int iVariableIndexOf13;
        int i13;
        int i14;
        TypeDescriptor typeDescriptor;
        int i15;
        int iVariableIndexOf14;
        try {
            if (!this.splitAccumulator.g()) {
                ASTNode aSTNode3 = (ASTNode) this.splitAccumulator.n();
                this.lastNode = aSTNode3;
                return (this.cursor < this.end || !(aSTNode3 instanceof EndOfStatement)) ? aSTNode3 : nextToken();
            }
            if (this.cursor >= this.end) {
                return null;
            }
            if ((this.fields & 16) != 0) {
                this.debugSymbols = this.pCtx.isDebugSymbols();
            }
            if (this.debugSymbols) {
                if (this.lastWasLineLabel) {
                    this.lastWasLineLabel = false;
                    this.lastWasComment = false;
                } else {
                    if (this.pCtx.getSourceFile() == null) {
                        throw new CompileException("unable to produce debugging symbols: source name must be provided.", this.expr, this.f73300st);
                    }
                    ParserContext parserContext = this.pCtx;
                    if (!parserContext.isLineMapped(parserContext.getSourceFile())) {
                        ParserContext parserContext2 = this.pCtx;
                        parserContext2.initLineMapping(parserContext2.getSourceFile(), this.expr);
                    }
                    skipWhitespace();
                    if (this.cursor >= this.end) {
                        return null;
                    }
                    ParserContext parserContext3 = this.pCtx;
                    int lineFor = parserContext3.getLineFor(parserContext3.getSourceFile(), this.cursor);
                    ParserContext parserContext4 = this.pCtx;
                    if (!parserContext4.isVisitedLine(parserContext4.getSourceFile(), this.pCtx.setLineCount(lineFor)) && !this.pCtx.isBlockSymbols()) {
                        this.lastWasLineLabel = true;
                        ParserContext parserContext5 = this.pCtx;
                        parserContext5.visitLine(parserContext5.getSourceFile(), lineFor);
                        ParserContext parserContext6 = this.pCtx;
                        LineLabel lastLineLabel = parserContext6.setLastLineLabel(new LineLabel(parserContext6.getSourceFile(), lineFor, this.pCtx));
                        this.lastNode = lastLineLabel;
                        return lastLineLabel;
                    }
                }
            }
            skipWhitespace();
            this.f73300st = this.cursor;
            boolean z11 = false;
            boolean z12 = false;
            while (true) {
                int i16 = this.cursor;
                if (i16 == this.end) {
                    int i17 = this.f73300st;
                    if (i17 == i16) {
                        return null;
                    }
                    return createPropertyToken(i17, i16);
                }
                if (m.c0(this.expr[i16])) {
                    this.cursor++;
                    while (true) {
                        int i18 = this.cursor;
                        if (i18 != this.end && m.c0(this.expr[i18])) {
                            this.cursor++;
                        }
                    }
                    z11 = true;
                }
                if (!z11) {
                    char[] cArr2 = this.expr;
                    int i19 = this.cursor;
                    char c13 = cArr2[i19];
                    if (c13 != '[') {
                        if (c13 != ']') {
                            if (c13 != '^') {
                                switch (c13) {
                                    case '!':
                                        this.cursor = i19 + 1;
                                        if (!isNextIdentifier()) {
                                            char[] cArr3 = this.expr;
                                            int i21 = this.cursor;
                                            char c14 = cArr3[i21];
                                            if (c14 == '(') {
                                                this.cursor = i21 - 1;
                                                this.f73300st = i21;
                                                captureToEOT();
                                                char[] cArr4 = this.expr;
                                                int i22 = this.f73300st;
                                                Negation negation = new Negation(cArr4, i22, this.cursor - i22, this.fields, this.pCtx);
                                                this.lastNode = negation;
                                                return negation;
                                            }
                                            if (c14 == '!') {
                                                this.cursor = i21 + 1;
                                                return nextToken();
                                            }
                                            if (c14 != '=') {
                                                throw new CompileException("unexpected operator '!'", this.expr, this.f73300st, null);
                                            }
                                            int i23 = this.f73300st;
                                            int i24 = i21 + 1;
                                            this.cursor = i24;
                                            return createOperator(cArr3, i23, i24);
                                        }
                                        ASTNode aSTNode4 = this.lastNode;
                                        if (aSTNode4 != null && !aSTNode4.isOperator()) {
                                            throw new CompileException("unexpected operator '!'", this.expr, this.f73300st);
                                        }
                                        this.f73300st = this.cursor;
                                        captureToEOT();
                                        char[] cArr5 = this.expr;
                                        int i25 = this.f73300st;
                                        String str = new String(cArr5, i25, this.cursor - i25);
                                        if (!"new".equals(str) && !"isdef".equals(str)) {
                                            char[] cArr6 = this.expr;
                                            int i26 = this.f73300st;
                                            Negation negation2 = new Negation(cArr6, i26, this.cursor - i26, this.fields, this.pCtx);
                                            this.lastNode = negation2;
                                            return negation2;
                                        }
                                        captureToEOT();
                                        char[] cArr7 = this.expr;
                                        int i27 = this.f73300st;
                                        Negation negation3 = new Negation(cArr7, i27, this.cursor - i27, this.fields, this.pCtx);
                                        this.lastNode = negation3;
                                        return negation3;
                                    case '\"':
                                        int i28 = this.f73300st + 1;
                                        int iH = m.h(c13, cArr2, i19, this.end);
                                        this.cursor = iH;
                                        this.lastNode = new LiteralNode(m.Y(m.K0(cArr2, i28, (iH - this.f73300st) - 1)), String.class, this.pCtx);
                                        this.cursor++;
                                        if (tokenContinues()) {
                                            return this.lastNode;
                                        }
                                        ASTNode aSTNodeHandleUnion = handleUnion(this.lastNode);
                                        this.lastNode = aSTNodeHandleUnion;
                                        return aSTNodeHandleUnion;
                                    case '#':
                                        break;
                                    default:
                                        switch (c13) {
                                            case '%':
                                                break;
                                            case '&':
                                                int i29 = i19 + 1;
                                                this.cursor = i29;
                                                if (cArr2[i29] != '&') {
                                                    return createOperator(cArr2, this.f73300st, i29);
                                                }
                                                int i31 = this.f73300st;
                                                int i32 = i19 + 2;
                                                this.cursor = i32;
                                                return createOperator(cArr2, i31, i32);
                                            case '\'':
                                                int i210 = this.f73300st + 1;
                                                int iH2 = m.h(c13, cArr2, i19, this.end);
                                                this.cursor = iH2;
                                                this.lastNode = new LiteralNode(m.Y(m.K0(cArr2, i210, (iH2 - this.f73300st) - 1)), String.class, this.pCtx);
                                                this.cursor++;
                                                if (tokenContinues()) {
                                                    return this.lastNode;
                                                }
                                                ASTNode aSTNodeHandleUnion2 = handleUnion(this.lastNode);
                                                this.lastNode = aSTNodeHandleUnion2;
                                                return aSTNodeHandleUnion2;
                                            case '(':
                                                this.cursor = i19 + 1;
                                                skipWhitespace();
                                                boolean z13 = true;
                                                int i33 = 1;
                                                while (true) {
                                                    int i34 = this.cursor;
                                                    int i35 = this.end;
                                                    if (i34 == i35 || i33 == 0) {
                                                        if (i33 != 0) {
                                                            throw new CompileException("unbalanced braces in expression: (" + i33 + "):", this.expr, this.f73300st);
                                                        }
                                                        if (z13) {
                                                            char[] cArr8 = this.expr;
                                                            int iTrimRight = trimRight(this.f73300st + 1);
                                                            TypeDescriptor typeDescriptor2 = new TypeDescriptor(cArr8, iTrimRight, trimLeft(this.cursor - 1) - iTrimRight, this.fields);
                                                            try {
                                                                if (typeDescriptor2.isClass() && (classReference = TypeDescriptor.getClassReference(this.pCtx, typeDescriptor2)) != null) {
                                                                    int i36 = this.cursor;
                                                                    while (true) {
                                                                        char[] cArr9 = this.expr;
                                                                        if (i36 < cArr9.length) {
                                                                            char c15 = cArr9[i36];
                                                                            if (c15 != ' ' && c15 != '\t') {
                                                                                if (m.c0(c15) || (c11 = this.expr[i36]) == '\'' || c11 == '\"' || c11 == '(') {
                                                                                    this.f73300st = this.cursor;
                                                                                    captureToEOT();
                                                                                    char[] cArr10 = this.expr;
                                                                                    int i37 = this.f73300st;
                                                                                    TypeCast typeCast = new TypeCast(cArr10, i37, this.cursor - i37, classReference, this.fields, this.pCtx);
                                                                                    this.lastNode = typeCast;
                                                                                    return typeCast;
                                                                                }
                                                                            }
                                                                            i36++;
                                                                        }
                                                                    }
                                                                }
                                                            } catch (ClassNotFoundException unused) {
                                                            }
                                                        }
                                                        char[] cArr11 = this.expr;
                                                        int iTrimRight2 = trimRight(this.f73300st + 1);
                                                        this.f73300st = iTrimRight2;
                                                        return handleUnion(handleSubstatement(new Substatement(cArr11, iTrimRight2, trimLeft(this.cursor - 1) - this.f73300st, this.fields, this.pCtx)));
                                                    }
                                                    char[] cArr12 = this.expr;
                                                    char c16 = cArr12[i34];
                                                    if (c16 == '\"') {
                                                        this.cursor = m.h('\"', cArr12, i34, i35);
                                                    } else if (c16 != 'i') {
                                                        switch (c16) {
                                                            case '\'':
                                                                this.cursor = m.h('\'', cArr12, i34, i35);
                                                                break;
                                                            case '(':
                                                                i33++;
                                                                break;
                                                            case ')':
                                                                i33--;
                                                                break;
                                                            default:
                                                                if (c16 != '.' && c16 != '[' && c16 != ']' && !m.c0(c16) && this.expr[this.cursor] != '.') {
                                                                    z13 = false;
                                                                }
                                                                break;
                                                        }
                                                    } else if (i33 == 1 && m.q0(lookBehind()) && lookAhead() == 'n' && m.q0(lookAhead(2))) {
                                                        int i38 = i33;
                                                        while (true) {
                                                            int i39 = this.cursor;
                                                            int i40 = this.end;
                                                            if (i39 == i40) {
                                                                throw new CompileException("unterminated projection; closing parathesis required", this.expr, this.f73300st);
                                                            }
                                                            char[] cArr13 = this.expr;
                                                            char c17 = cArr13[i39];
                                                            if (c17 != '\"') {
                                                                switch (c17) {
                                                                    case '\'':
                                                                        this.cursor = m.h('\'', cArr13, i39, i40);
                                                                        break;
                                                                    case '(':
                                                                        i38++;
                                                                        break;
                                                                    case ')':
                                                                        i38--;
                                                                        if (i38 < i33) {
                                                                            this.cursor = i39 + 1;
                                                                            if (!tokenContinues()) {
                                                                                Fold fold = new Fold(this.expr, trimRight(this.f73300st + 1), (this.cursor - this.f73300st) - 2, this.fields, this.pCtx);
                                                                                this.lastNode = fold;
                                                                                return fold;
                                                                            }
                                                                            this.lastNode = new Fold(this.expr, trimRight(this.f73300st + 1), (this.cursor - this.f73300st) - 2, this.fields, this.pCtx);
                                                                            char[] cArr14 = this.expr;
                                                                            int i41 = this.cursor;
                                                                            this.f73300st = i41;
                                                                            if (cArr14[i41] == '.') {
                                                                                this.f73300st = i41 + 1;
                                                                            }
                                                                            captureToEOT();
                                                                            char[] cArr15 = this.expr;
                                                                            int iTrimRight3 = trimRight(this.f73300st);
                                                                            this.f73300st = iTrimRight3;
                                                                            Union union = new Union(cArr15, iTrimRight3, this.cursor - iTrimRight3, this.fields, this.lastNode, this.pCtx);
                                                                            this.lastNode = union;
                                                                            return union;
                                                                        }
                                                                        break;
                                                                }
                                                            } else {
                                                                this.cursor = m.h('\"', cArr13, i39, i40);
                                                            }
                                                            this.cursor++;
                                                        }
                                                    }
                                                    this.cursor++;
                                                }
                                                break;
                                            case ')':
                                                break;
                                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                if (lookAhead() == '*') {
                                                    this.cursor++;
                                                }
                                                char[] cArr16 = this.expr;
                                                int i42 = this.f73300st;
                                                int i43 = this.cursor + 1;
                                                this.cursor = i43;
                                                return createOperator(cArr16, i42, i43);
                                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                if (lookAhead() != '+') {
                                                    char[] cArr17 = this.expr;
                                                    int i44 = this.f73300st;
                                                    int i45 = this.cursor + 1;
                                                    this.cursor = i45;
                                                    return createOperator(cArr17, i44, i45);
                                                }
                                                this.cursor += 2;
                                                skipWhitespace();
                                                this.f73300st = this.cursor;
                                                captureIdentifier();
                                                String str2 = new String(subArray(this.f73300st, this.cursor));
                                                ParserContext parserContext7 = this.pCtx;
                                                if (parserContext7 == null || (iVariableIndexOf = parserContext7.variableIndexOf(str2)) == -1) {
                                                    PreFixIncNode preFixIncNode = new PreFixIncNode(str2, this.pCtx);
                                                    this.lastNode = preFixIncNode;
                                                    return preFixIncNode;
                                                }
                                                IndexedPreFixIncNode indexedPreFixIncNode = new IndexedPreFixIncNode(iVariableIndexOf, this.pCtx);
                                                this.lastNode = indexedPreFixIncNode;
                                                return indexedPreFixIncNode;
                                            default:
                                                switch (c13) {
                                                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                        if (lookAhead() == '-') {
                                                            this.cursor += 2;
                                                            skipWhitespace();
                                                            this.f73300st = this.cursor;
                                                            captureIdentifier();
                                                            String str3 = new String(subArray(this.f73300st, this.cursor));
                                                            ParserContext parserContext8 = this.pCtx;
                                                            if (parserContext8 == null || (iVariableIndexOf2 = parserContext8.variableIndexOf(str3)) == -1) {
                                                                PreFixDecNode preFixDecNode = new PreFixDecNode(str3, this.pCtx);
                                                                this.lastNode = preFixDecNode;
                                                                return preFixDecNode;
                                                            }
                                                            IndexedPreFixDecNode indexedPreFixDecNode = new IndexedPreFixDecNode(iVariableIndexOf2, this.pCtx);
                                                            this.lastNode = indexedPreFixDecNode;
                                                            return indexedPreFixDecNode;
                                                        }
                                                        if ((this.cursor == this.start || ((aSTNode2 = this.lastNode) != null && ((aSTNode2 instanceof BooleanNode) || aSTNode2.isOperator()))) && !m.b0(lookAhead())) {
                                                            this.cursor++;
                                                            captureToEOT();
                                                            char[] cArr18 = this.expr;
                                                            int i46 = this.f73300st;
                                                            return new Sign(cArr18, i46, this.cursor - i46, this.fields, this.pCtx);
                                                        }
                                                        if ((this.cursor != this.start && (aSTNode = this.lastNode) != null && !(aSTNode instanceof BooleanNode) && !aSTNode.isOperator()) || !m.b0(lookAhead())) {
                                                            char[] cArr19 = this.expr;
                                                            int i47 = this.f73300st;
                                                            int i48 = this.cursor + 1;
                                                            this.cursor = i48;
                                                            return createOperator(cArr19, i47, i48);
                                                        }
                                                        int i49 = this.cursor;
                                                        if (i49 - 1 == this.start && (m.b0(this.expr[i49 - 1]) || !m.b0(lookAhead()))) {
                                                            throw new CompileException("not a statement", this.expr, this.f73300st);
                                                        }
                                                        this.cursor++;
                                                        break;
                                                        break;
                                                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                        int i50 = i19 + 1;
                                                        this.cursor = i50;
                                                        if (!m.b0(cArr2[i50])) {
                                                            expectNextChar_IW('{');
                                                            char[] cArr20 = this.expr;
                                                            int i51 = this.f73300st;
                                                            int i52 = this.cursor;
                                                            int iE = m.e(cArr20, i52, this.end, '{', this.pCtx);
                                                            this.cursor = iE + 1;
                                                            ThisWithNode thisWithNode = new ThisWithNode(cArr20, i51, (i52 - i51) - 1, i52 + 1, iE - 2, this.fields, this.pCtx);
                                                            this.lastNode = thisWithNode;
                                                            return thisWithNode;
                                                        }
                                                        z11 = true;
                                                        break;
                                                        break;
                                                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                        break;
                                                    default:
                                                        switch (c13) {
                                                            case ':':
                                                                break;
                                                            case ';':
                                                                this.cursor = i19 + 1;
                                                                this.lastWasIdentifier = false;
                                                                EndOfStatement endOfStatement = new EndOfStatement(this.pCtx);
                                                                this.lastNode = endOfStatement;
                                                                return endOfStatement;
                                                            case '<':
                                                                int i53 = i19 + 1;
                                                                this.cursor = i53;
                                                                char c18 = cArr2[i53];
                                                                if (c18 == '<') {
                                                                    int i54 = i19 + 2;
                                                                    this.cursor = i54;
                                                                    if (cArr2[i54] == '<') {
                                                                        this.cursor = i19 + 3;
                                                                    }
                                                                    return createOperator(cArr2, this.f73300st, this.cursor);
                                                                }
                                                                if (c18 != '=') {
                                                                    return createOperator(cArr2, this.f73300st, i53);
                                                                }
                                                                int i55 = this.f73300st;
                                                                int i56 = i19 + 2;
                                                                this.cursor = i56;
                                                                return createOperator(cArr2, i55, i56);
                                                            case '=':
                                                                int i57 = this.f73300st;
                                                                int i58 = i19 + 2;
                                                                this.cursor = i58;
                                                                return createOperator(cArr2, i57, i58);
                                                            case '>':
                                                                char c19 = cArr2[i19 + 1];
                                                                if (c19 == '=') {
                                                                    int i59 = this.f73300st;
                                                                    int i60 = i19 + 2;
                                                                    this.cursor = i60;
                                                                    return createOperator(cArr2, i59, i60);
                                                                }
                                                                if (c19 != '>') {
                                                                    int i61 = this.f73300st;
                                                                    int i62 = i19 + 1;
                                                                    this.cursor = i62;
                                                                    return createOperator(cArr2, i61, i62);
                                                                }
                                                                int i63 = i19 + 2;
                                                                this.cursor = i63;
                                                                if (cArr2[i63] == '>') {
                                                                    this.cursor = i19 + 3;
                                                                }
                                                                return createOperator(cArr2, this.f73300st, this.cursor);
                                                            case '?':
                                                                if (i19 == this.start) {
                                                                    this.cursor = i19 + 1;
                                                                }
                                                                break;
                                                            case '@':
                                                                this.f73300st++;
                                                                captureToEOT();
                                                                ParserContext parserContext9 = this.pCtx;
                                                                if (parserContext9 != null && parserContext9.getInterceptors() != null) {
                                                                    Map<String, l30.b> interceptors = this.pCtx.getInterceptors();
                                                                    char[] cArr21 = this.expr;
                                                                    int i64 = this.f73300st;
                                                                    String str4 = new String(cArr21, i64, this.cursor - i64);
                                                                    if (interceptors.containsKey(str4)) {
                                                                        InterceptorWrapper interceptorWrapper = new InterceptorWrapper(this.pCtx.getInterceptors().get(str4), nextToken(), this.pCtx);
                                                                        this.lastNode = interceptorWrapper;
                                                                        return interceptorWrapper;
                                                                    }
                                                                }
                                                                StringBuilder sb2 = new StringBuilder();
                                                                sb2.append("reference to undefined interceptor: ");
                                                                char[] cArr22 = this.expr;
                                                                int i65 = this.f73300st;
                                                                sb2.append(new String(cArr22, i65, this.cursor - i65));
                                                                throw new CompileException(sb2.toString(), this.expr, this.f73300st);
                                                            default:
                                                                switch (c13) {
                                                                    case '{':
                                                                        break;
                                                                    case '|':
                                                                        int i66 = i19 + 1;
                                                                        this.cursor = i66;
                                                                        if (cArr2[i66] != '|') {
                                                                            return createOperator(cArr2, this.f73300st, i66);
                                                                        }
                                                                        int i67 = this.f73300st;
                                                                        int i68 = i19 + 2;
                                                                        this.cursor = i68;
                                                                        return createOperator(cArr2, i67, i68);
                                                                    case '}':
                                                                        break;
                                                                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                                                                        this.cursor = i19 + 1;
                                                                        if (!(i19 - 1 == 0 && m.c0(lookBehind())) && m.b0(this.expr[this.cursor])) {
                                                                            this.f73300st = this.cursor;
                                                                            captureToEOT();
                                                                            char[] cArr23 = this.expr;
                                                                            int i69 = this.f73300st;
                                                                            Invert invert = new Invert(cArr23, i69, this.cursor - i69, this.fields, this.pCtx);
                                                                            this.lastNode = invert;
                                                                            return invert;
                                                                        }
                                                                        char[] cArr24 = this.expr;
                                                                        int i70 = this.cursor;
                                                                        char c21 = cArr24[i70];
                                                                        if (c21 != '(') {
                                                                            if (c21 == '=') {
                                                                                this.cursor = i70 + 1;
                                                                            }
                                                                            return createOperator(cArr24, this.f73300st, this.cursor);
                                                                        }
                                                                        this.cursor = i70 - 1;
                                                                        this.f73300st = i70;
                                                                        captureToEOT();
                                                                        char[] cArr25 = this.expr;
                                                                        int i71 = this.f73300st;
                                                                        Invert invert2 = new Invert(cArr25, i71, this.cursor - i71, this.fields, this.pCtx);
                                                                        this.lastNode = invert2;
                                                                        return invert2;
                                                                    default:
                                                                        this.cursor = i19 + 1;
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                            }
                            int i72 = this.f73300st;
                            int i73 = i19 + 1;
                            this.cursor = i73;
                            return createOperator(cArr2, i72, i73);
                        }
                        throw new CompileException("unbalanced braces", this.expr, this.f73300st);
                    }
                    this.cursor = m.e(cArr2, i19, this.end, c13, this.pCtx) + 1;
                    if (!tokenContinues()) {
                        char[] cArr26 = this.expr;
                        int i74 = this.f73300st;
                        InlineCollectionNode inlineCollectionNode = new InlineCollectionNode(cArr26, i74, this.cursor - i74, this.fields, this.pCtx);
                        this.lastNode = inlineCollectionNode;
                        return inlineCollectionNode;
                    }
                    char[] cArr27 = this.expr;
                    int i75 = this.f73300st;
                    this.lastNode = new InlineCollectionNode(cArr27, i75, this.cursor - i75, this.fields, this.pCtx);
                    this.f73300st = this.cursor;
                    captureToEOT();
                    char[] cArr28 = this.expr;
                    int i76 = this.f73300st;
                    if (cArr28[i76] == '.') {
                        this.f73300st = i76 + 1;
                    }
                    int i77 = this.f73300st;
                    Union union2 = new Union(cArr28, i77, this.cursor - i77, this.fields, this.lastNode, this.pCtx);
                    this.lastNode = union2;
                    return union2;
                }
                HashMap<String, Integer> map = OPERATORS;
                char[] cArr29 = this.expr;
                int i78 = this.f73300st;
                String str5 = new String(cArr29, i78, this.cursor - i78);
                if (map.containsKey(str5) && !Character.isDigit(this.expr[this.f73300st])) {
                    int iIntValue = OPERATORS.get(str5).intValue();
                    if (iIntValue == 26) {
                        this.lastWasIdentifier = false;
                        OperatorNode operatorNode = new OperatorNode(26, this.expr, this.f73300st, this.pCtx);
                        this.lastNode = operatorNode;
                        return operatorNode;
                    }
                    if (iIntValue == 34) {
                        char[] cArr30 = this.expr;
                        int iTrimRight4 = trimRight(this.cursor);
                        this.cursor = iTrimRight4;
                        this.f73300st = iTrimRight4;
                        if (!m.c0(cArr30[iTrimRight4])) {
                            throw new CompileException("unexpected character (expected identifier): " + this.expr[this.cursor], this.expr, this.f73300st);
                        }
                        do {
                            captureToNextTokenJunction();
                            skipWhitespace();
                            i13 = this.cursor;
                            i14 = this.end;
                            if (i13 < i14) {
                            }
                            if (i13 < i14 && !lastNonWhite(']')) {
                                captureToEOT();
                            }
                            typeDescriptor = new TypeDescriptor(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st, this.fields);
                            if (this.pCtx.getFunctions().containsKey(typeDescriptor.getClassName())) {
                                ParserContext parserContext10 = this.pCtx;
                                NewObjectPrototype newObjectPrototype = new NewObjectPrototype(parserContext10, parserContext10.getFunction(typeDescriptor.getClassName()));
                                this.lastNode = newObjectPrototype;
                                return newObjectPrototype;
                            }
                            if (this.pCtx.hasProtoImport(typeDescriptor.getClassName())) {
                                NewPrototypeNode newPrototypeNode = new NewPrototypeNode(typeDescriptor, this.pCtx);
                                this.lastNode = newPrototypeNode;
                                return newPrototypeNode;
                            }
                            this.lastNode = new NewObjectNode(typeDescriptor, this.fields, this.pCtx);
                            skipWhitespace();
                            i15 = this.cursor;
                            if (i15 != this.end || this.expr[i15] != '{') {
                                if (!((NewObjectNode) this.lastNode).getTypeDescr().isUndimensionedArray()) {
                                    throw new CompileException("array initializer expected", this.expr, this.f73300st);
                                }
                                this.f73300st = this.cursor;
                                return this.lastNode;
                            }
                            if (!((NewObjectNode) this.lastNode).getTypeDescr().isUndimensionedArray()) {
                                throw new CompileException("conflicting syntax: dimensioned array with initializer block", this.expr, this.f73300st);
                            }
                            this.f73300st = this.cursor;
                            Class egressType = this.lastNode.getEgressType();
                            if (egressType == null) {
                                try {
                                    egressType = TypeDescriptor.getClassReference(this.pCtx, typeDescriptor);
                                } catch (ClassNotFoundException e11) {
                                    throw new CompileException("could not instantiate class", this.expr, this.f73300st, e11);
                                }
                            }
                            Class cls = egressType;
                            char[] cArr31 = this.expr;
                            this.cursor = m.e(cArr31, this.f73300st, this.end, cArr31[this.cursor], this.pCtx) + 1;
                            if (!tokenContinues()) {
                                char[] cArr32 = this.expr;
                                int i79 = this.f73300st;
                                InlineCollectionNode inlineCollectionNode2 = new InlineCollectionNode(cArr32, i79, this.cursor - i79, this.fields, cls, this.pCtx);
                                this.lastNode = inlineCollectionNode2;
                                return inlineCollectionNode2;
                            }
                            char[] cArr33 = this.expr;
                            int i80 = this.f73300st;
                            this.lastNode = new InlineCollectionNode(cArr33, i80, this.cursor - i80, this.fields, cls, this.pCtx);
                            this.f73300st = this.cursor;
                            captureToEOT();
                            Union union3 = new Union(this.expr, this.f73300st + 1, this.cursor, this.fields, this.lastNode, this.pCtx);
                            this.lastNode = union3;
                            return union3;
                        } while (this.expr[i13] == '[');
                        if (i13 < i14) {
                            captureToEOT();
                        }
                        typeDescriptor = new TypeDescriptor(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st, this.fields);
                        if (this.pCtx.getFunctions().containsKey(typeDescriptor.getClassName())) {
                            ParserContext parserContext11 = this.pCtx;
                            NewObjectPrototype newObjectPrototype2 = new NewObjectPrototype(parserContext11, parserContext11.getFunction(typeDescriptor.getClassName()));
                            this.lastNode = newObjectPrototype2;
                            return newObjectPrototype2;
                        }
                        if (this.pCtx.hasProtoImport(typeDescriptor.getClassName())) {
                            NewPrototypeNode newPrototypeNode2 = new NewPrototypeNode(typeDescriptor, this.pCtx);
                            this.lastNode = newPrototypeNode2;
                            return newPrototypeNode2;
                        }
                        this.lastNode = new NewObjectNode(typeDescriptor, this.fields, this.pCtx);
                        skipWhitespace();
                        i15 = this.cursor;
                        if (i15 != this.end) {
                        }
                        if (!((NewObjectNode) this.lastNode).getTypeDescr().isUndimensionedArray()) {
                            throw new CompileException("array initializer expected", this.expr, this.f73300st);
                        }
                        this.f73300st = this.cursor;
                        return this.lastNode;
                    }
                    switch (iIntValue) {
                        case 38:
                            return captureCodeBlock(4096);
                        case 39:
                            return captureCodeBlock(2048);
                        case 40:
                            throw new CompileException("else without if", this.expr, this.f73300st);
                        case 41:
                            return captureCodeBlock(32768);
                        case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            return captureCodeBlock(16384);
                        case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            return captureCodeBlock(262144);
                        default:
                            switch (iIntValue) {
                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                    return captureCodeBlock(65536);
                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                    return captureCodeBlock(8192);
                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                    int iTrimRight5 = trimRight(this.cursor);
                                    this.cursor = iTrimRight5;
                                    this.f73300st = iTrimRight5;
                                    captureToNextTokenJunction();
                                    char[] cArr34 = this.expr;
                                    int i81 = this.f73300st;
                                    IsDef isDef = new IsDef(cArr34, i81, this.cursor - i81, this.pCtx);
                                    this.lastNode = isDef;
                                    return isDef;
                                case 48:
                                    return captureCodeBlock(48);
                                default:
                                    switch (iIntValue) {
                                        case 95:
                                            int iTrimRight6 = trimRight(this.cursor);
                                            this.cursor = iTrimRight6;
                                            this.f73300st = iTrimRight6;
                                            captureToEOS();
                                            StaticImportNode staticImportNode = new StaticImportNode(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st, this.pCtx);
                                            this.pCtx.addImport(staticImportNode.getMethod().getName(), staticImportNode.getMethod());
                                            this.lastNode = staticImportNode;
                                            return staticImportNode;
                                        case 96:
                                            int iTrimRight7 = trimRight(this.cursor);
                                            this.cursor = iTrimRight7;
                                            this.f73300st = iTrimRight7;
                                            captureToEOS();
                                            char[] cArr35 = this.expr;
                                            int i82 = this.f73300st;
                                            ImportNode importNode = new ImportNode(cArr35, i82, this.cursor - i82, this.pCtx);
                                            if (importNode.isPackageImport()) {
                                                this.pCtx.addPackageImport(importNode.getPackageImport());
                                            } else {
                                                this.pCtx.addImport(importNode.getImportClass().getSimpleName(), importNode.getImportClass());
                                            }
                                            this.lastNode = importNode;
                                            return importNode;
                                        case 97:
                                            int iTrimRight8 = trimRight(this.cursor);
                                            this.cursor = iTrimRight8;
                                            this.f73300st = iTrimRight8;
                                            captureToEOS();
                                            char[] cArr36 = this.expr;
                                            int i83 = this.f73300st;
                                            int i84 = this.cursor;
                                            this.cursor = i84 - 1;
                                            AssertNode assertNode = new AssertNode(cArr36, i83, i84 - i83, this.fields, this.pCtx);
                                            this.lastNode = assertNode;
                                            return assertNode;
                                        case 98:
                                            this.f73300st = this.cursor + 1;
                                            while (true) {
                                                captureToEOT();
                                                int i85 = this.cursor;
                                                skipWhitespace();
                                                int i86 = this.cursor;
                                                if (i86 == i85 || this.expr[i86] != '=') {
                                                    char[] cArr37 = this.expr;
                                                    int i87 = this.f73300st;
                                                    String str6 = new String(cArr37, i87, i85 - i87);
                                                    ParserContext parserContext12 = this.pCtx;
                                                    if (parserContext12 == null || (iVariableIndexOf14 = parserContext12.variableIndexOf(str6)) == -1) {
                                                        g gVar = this.splitAccumulator;
                                                        char[] cArr38 = this.expr;
                                                        int i88 = this.f73300st;
                                                        DeclTypedVarNode declTypedVarNode = new DeclTypedVarNode(str6, cArr38, i88, i85 - i88, Object.class, this.fields, this.pCtx);
                                                        this.lastNode = declTypedVarNode;
                                                        gVar.a(declTypedVarNode);
                                                    } else {
                                                        g gVar2 = this.splitAccumulator;
                                                        int i89 = this.f73300st;
                                                        IndexedDeclTypedVarNode indexedDeclTypedVarNode = new IndexedDeclTypedVarNode(iVariableIndexOf14, i89, i85 - i89, Object.class, this.pCtx);
                                                        this.lastNode = indexedDeclTypedVarNode;
                                                        gVar2.a(indexedDeclTypedVarNode);
                                                    }
                                                    int i90 = this.cursor;
                                                    if (i90 != this.end && this.expr[i90] == ',') {
                                                        this.cursor = i90 + 1;
                                                        skipWhitespace();
                                                        this.f73300st = this.cursor;
                                                    }
                                                    return (ASTNode) this.splitAccumulator.n();
                                                }
                                                int i91 = this.f73300st;
                                                this.cursor = i91;
                                                if (i85 == i91) {
                                                    throw new CompileException("illegal use of reserved word: var", this.expr, this.f73300st);
                                                }
                                            }
                                            break;
                                        case 99:
                                            int iTrimRight9 = trimRight(this.cursor);
                                            this.cursor = iTrimRight9;
                                            this.f73300st = iTrimRight9;
                                            captureToEOS();
                                            char[] cArr39 = this.expr;
                                            int i92 = this.f73300st;
                                            ReturnNode returnNode = new ReturnNode(cArr39, i92, this.cursor - i92, this.fields, this.pCtx);
                                            this.lastNode = returnNode;
                                            return returnNode;
                                        case 100:
                                            ASTNode aSTNodeCaptureCodeBlock = captureCodeBlock(100);
                                            this.lastNode = aSTNodeCaptureCodeBlock;
                                            this.f73300st = this.cursor + 1;
                                            return aSTNodeCaptureCodeBlock;
                                        case 101:
                                            return captureCodeBlock(101);
                                        default:
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                }
                skipWhitespace();
                int i93 = this.cursor;
                int i94 = this.end;
                if (i93 != i94) {
                    char[] cArr40 = this.expr;
                    if (cArr40[i93] == '(') {
                        this.cursor = m.e(cArr40, i93, i94, '(', this.pCtx) + 1;
                    }
                }
                while (true) {
                    int i95 = this.cursor;
                    int i96 = this.end;
                    if (i95 != i96 && (c12 = (cArr = this.expr)[i95]) != '!' && c12 != '\"') {
                        if (c12 != '[') {
                            if (c12 != '^') {
                                if (c12 != '~') {
                                    if (c12 != 187) {
                                        if (c12 != '{') {
                                            if (c12 != '|' && c12 != 171 && c12 != 172) {
                                                switch (c12) {
                                                    case '%':
                                                    case '&':
                                                        break;
                                                    case '\'':
                                                        break;
                                                    case '(':
                                                        this.cursor = m.e(cArr, i95, i96, '(', this.pCtx) + 1;
                                                        break;
                                                    default:
                                                        switch (c12) {
                                                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                                                break;
                                                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                                                char cLookAhead = lookAhead();
                                                                if (cLookAhead == '+') {
                                                                    String str7 = new String(subArray(this.f73300st, trimLeft(this.cursor)));
                                                                    ParserContext parserContext13 = this.pCtx;
                                                                    if (parserContext13 == null || (iVariableIndexOf4 = parserContext13.variableIndexOf(str7)) == -1) {
                                                                        this.lastNode = new PostFixIncNode(str7, this.pCtx);
                                                                    } else {
                                                                        this.lastNode = new IndexedPostFixIncNode(iVariableIndexOf4, this.pCtx);
                                                                    }
                                                                    this.cursor += 2;
                                                                    expectEOS();
                                                                    return this.lastNode;
                                                                }
                                                                if (cLookAhead == '=') {
                                                                    char[] cArr41 = this.expr;
                                                                    int i97 = this.f73300st;
                                                                    String strX = m.x(cArr41, i97, this.cursor - i97);
                                                                    int i98 = this.cursor + 2;
                                                                    this.cursor = i98;
                                                                    this.f73300st = i98;
                                                                    captureToEOS();
                                                                    if (z12) {
                                                                        char[] cArr42 = this.expr;
                                                                        int iTrimRight10 = trimRight(this.f73300st);
                                                                        this.f73300st = iTrimRight10;
                                                                        DeepAssignmentNode deepAssignmentNode = new DeepAssignmentNode(cArr42, iTrimRight10, trimLeft(this.cursor) - this.f73300st, this.fields, 0, strX, this.pCtx);
                                                                        this.lastNode = deepAssignmentNode;
                                                                        return deepAssignmentNode;
                                                                    }
                                                                    ParserContext parserContext14 = this.pCtx;
                                                                    if (parserContext14 != null && (iVariableIndexOf5 = parserContext14.variableIndexOf(strX)) != -1) {
                                                                        char[] cArr43 = this.expr;
                                                                        int i99 = this.f73300st;
                                                                        IndexedAssignmentNode indexedAssignmentNode = new IndexedAssignmentNode(cArr43, i99, this.cursor - i99, this.fields, 0, strX, iVariableIndexOf5, this.pCtx);
                                                                        this.lastNode = indexedAssignmentNode;
                                                                        return indexedAssignmentNode;
                                                                    }
                                                                    char[] cArr44 = this.expr;
                                                                    int iTrimRight11 = trimRight(this.f73300st);
                                                                    this.f73300st = iTrimRight11;
                                                                    OperativeAssign operativeAssign = new OperativeAssign(strX, cArr44, iTrimRight11, trimLeft(this.cursor) - this.f73300st, 0, this.fields, this.pCtx);
                                                                    this.lastNode = operativeAssign;
                                                                    return operativeAssign;
                                                                }
                                                                if (m.b0(lookAhead()) && (i11 = this.cursor) > 1) {
                                                                    char[] cArr45 = this.expr;
                                                                    if ((cArr45[i11 - 1] == 'E' || cArr45[i11 - 1] == 'e') && m.b0(cArr45[i11 - 2])) {
                                                                        this.cursor++;
                                                                    }
                                                                }
                                                                break;
                                                                break;
                                                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                                                break;
                                                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                                                char cLookAhead2 = lookAhead();
                                                                if (cLookAhead2 == '-') {
                                                                    String str8 = new String(subArray(this.f73300st, trimLeft(this.cursor)));
                                                                    ParserContext parserContext15 = this.pCtx;
                                                                    if (parserContext15 == null || (iVariableIndexOf6 = parserContext15.variableIndexOf(str8)) == -1) {
                                                                        this.lastNode = new PostFixDecNode(str8, this.pCtx);
                                                                    } else {
                                                                        this.lastNode = new IndexedPostFixDecNode(iVariableIndexOf6, this.pCtx);
                                                                    }
                                                                    this.cursor += 2;
                                                                    expectEOS();
                                                                    return this.lastNode;
                                                                }
                                                                if (cLookAhead2 == '=') {
                                                                    String str9 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                    int i100 = this.cursor + 2;
                                                                    this.cursor = i100;
                                                                    this.f73300st = i100;
                                                                    captureToEOS();
                                                                    if (z12) {
                                                                        char[] cArr46 = this.expr;
                                                                        int i101 = this.f73300st;
                                                                        DeepAssignmentNode deepAssignmentNode2 = new DeepAssignmentNode(cArr46, i101, this.cursor - i101, this.fields, 1, str5, this.pCtx);
                                                                        this.lastNode = deepAssignmentNode2;
                                                                        return deepAssignmentNode2;
                                                                    }
                                                                    ParserContext parserContext16 = this.pCtx;
                                                                    if (parserContext16 == null || (iVariableIndexOf7 = parserContext16.variableIndexOf(str9)) == -1) {
                                                                        char[] cArr47 = this.expr;
                                                                        int i102 = this.f73300st;
                                                                        OperativeAssign operativeAssign2 = new OperativeAssign(str9, cArr47, i102, this.cursor - i102, 1, this.fields, this.pCtx);
                                                                        this.lastNode = operativeAssign2;
                                                                        return operativeAssign2;
                                                                    }
                                                                    char[] cArr48 = this.expr;
                                                                    int i103 = this.f73300st;
                                                                    IndexedOperativeAssign indexedOperativeAssign = new IndexedOperativeAssign(cArr48, i103, this.cursor - i103, 1, iVariableIndexOf7, this.fields, this.pCtx);
                                                                    this.lastNode = indexedOperativeAssign;
                                                                    return indexedOperativeAssign;
                                                                }
                                                                if (m.b0(lookAhead()) && (i12 = this.cursor) > 1) {
                                                                    char[] cArr49 = this.expr;
                                                                    if ((cArr49[i12 - 1] == 'E' || cArr49[i12 - 1] == 'e') && m.b0(cArr49[i12 - 2])) {
                                                                        this.cursor++;
                                                                        z11 = true;
                                                                    }
                                                                }
                                                                break;
                                                                break;
                                                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                                                this.cursor = i95 + 1;
                                                                skipWhitespace();
                                                                z12 = true;
                                                                break;
                                                            default:
                                                                switch (c12) {
                                                                    case ':':
                                                                    case ';':
                                                                        break;
                                                                    case '<':
                                                                        if (lookAhead() == '<' && lookAhead(2) == '=') {
                                                                            String str10 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                            int i104 = this.cursor + 3;
                                                                            this.cursor = i104;
                                                                            this.f73300st = i104;
                                                                            captureToEOS();
                                                                            if (z12) {
                                                                                char[] cArr50 = this.expr;
                                                                                int i105 = this.f73300st;
                                                                                DeepAssignmentNode deepAssignmentNode3 = new DeepAssignmentNode(cArr50, i105, this.cursor - i105, this.fields, 10, str5, this.pCtx);
                                                                                this.lastNode = deepAssignmentNode3;
                                                                                return deepAssignmentNode3;
                                                                            }
                                                                            ParserContext parserContext17 = this.pCtx;
                                                                            if (parserContext17 == null || (iVariableIndexOf8 = parserContext17.variableIndexOf(str10)) == -1) {
                                                                                char[] cArr51 = this.expr;
                                                                                int i106 = this.f73300st;
                                                                                OperativeAssign operativeAssign3 = new OperativeAssign(str10, cArr51, i106, this.cursor - i106, 10, this.fields, this.pCtx);
                                                                                this.lastNode = operativeAssign3;
                                                                                return operativeAssign3;
                                                                            }
                                                                            char[] cArr52 = this.expr;
                                                                            int i107 = this.f73300st;
                                                                            IndexedOperativeAssign indexedOperativeAssign2 = new IndexedOperativeAssign(cArr52, i107, this.cursor - i107, 10, iVariableIndexOf8, this.fields, this.pCtx);
                                                                            this.lastNode = indexedOperativeAssign2;
                                                                            return indexedOperativeAssign2;
                                                                        }
                                                                        break;
                                                                    case '=':
                                                                        if (lookAhead() == '+') {
                                                                            String str11 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                            int i108 = this.cursor + 2;
                                                                            this.cursor = i108;
                                                                            this.f73300st = i108;
                                                                            if (!isNextIdentifierOrLiteral()) {
                                                                                throw new CompileException("unexpected symbol '" + this.expr[this.cursor] + "'", this.expr, this.f73300st);
                                                                            }
                                                                            captureToEOS();
                                                                            ParserContext parserContext18 = this.pCtx;
                                                                            if (parserContext18 == null || (iVariableIndexOf11 = parserContext18.variableIndexOf(str11)) == -1) {
                                                                                char[] cArr53 = this.expr;
                                                                                int i109 = this.f73300st;
                                                                                OperativeAssign operativeAssign4 = new OperativeAssign(str11, cArr53, i109, this.cursor - i109, 0, this.fields, this.pCtx);
                                                                                this.lastNode = operativeAssign4;
                                                                                return operativeAssign4;
                                                                            }
                                                                            char[] cArr54 = this.expr;
                                                                            int i110 = this.f73300st;
                                                                            IndexedOperativeAssign indexedOperativeAssign3 = new IndexedOperativeAssign(cArr54, i110, this.cursor - i110, 0, iVariableIndexOf11, this.fields, this.pCtx);
                                                                            this.lastNode = indexedOperativeAssign3;
                                                                            return indexedOperativeAssign3;
                                                                        }
                                                                        if (lookAhead() == '-') {
                                                                            String str12 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                            int i111 = this.cursor + 2;
                                                                            this.cursor = i111;
                                                                            this.f73300st = i111;
                                                                            if (!isNextIdentifierOrLiteral()) {
                                                                                throw new CompileException("unexpected symbol '" + this.expr[this.cursor] + "'", this.expr, this.f73300st);
                                                                            }
                                                                            captureToEOS();
                                                                            ParserContext parserContext19 = this.pCtx;
                                                                            if (parserContext19 == null || (iVariableIndexOf10 = parserContext19.variableIndexOf(str12)) == -1) {
                                                                                char[] cArr55 = this.expr;
                                                                                int i112 = this.f73300st;
                                                                                OperativeAssign operativeAssign5 = new OperativeAssign(str12, cArr55, i112, this.cursor - i112, 1, this.fields, this.pCtx);
                                                                                this.lastNode = operativeAssign5;
                                                                                return operativeAssign5;
                                                                            }
                                                                            char[] cArr56 = this.expr;
                                                                            int i113 = this.f73300st;
                                                                            IndexedOperativeAssign indexedOperativeAssign4 = new IndexedOperativeAssign(cArr56, i113, this.cursor - i113, 1, iVariableIndexOf10, this.fields, this.pCtx);
                                                                            this.lastNode = indexedOperativeAssign4;
                                                                            return indexedOperativeAssign4;
                                                                        }
                                                                        if (this.greedy && lookAhead() != '=') {
                                                                            this.cursor++;
                                                                            if (z12) {
                                                                                captureToEOS();
                                                                                char[] cArr57 = this.expr;
                                                                                int i114 = this.f73300st;
                                                                                DeepAssignmentNode deepAssignmentNode4 = new DeepAssignmentNode(cArr57, i114, this.cursor - i114, this.fields | 128, this.pCtx);
                                                                                this.lastNode = deepAssignmentNode4;
                                                                                return deepAssignmentNode4;
                                                                            }
                                                                            if (this.lastWasIdentifier) {
                                                                                return procTypedNode(false);
                                                                            }
                                                                            ParserContext parserContext20 = this.pCtx;
                                                                            if (parserContext20 == null || (iVariableIndexOf9 = parserContext20.variableIndexOf(str5)) == -1 || !this.pCtx.isIndexAllocation()) {
                                                                                captureToEOS();
                                                                                char[] cArr58 = this.expr;
                                                                                int i115 = this.f73300st;
                                                                                AssignmentNode assignmentNode = new AssignmentNode(cArr58, i115, this.cursor - i115, this.fields | 128, this.pCtx);
                                                                                this.lastNode = assignmentNode;
                                                                                return assignmentNode;
                                                                            }
                                                                            captureToEOS();
                                                                            char[] cArr59 = this.expr;
                                                                            int iTrimRight12 = trimRight(this.f73300st);
                                                                            this.f73300st = iTrimRight12;
                                                                            IndexedAssignmentNode indexedAssignmentNode2 = new IndexedAssignmentNode(cArr59, iTrimRight12, trimLeft(this.cursor) - this.f73300st, 128, iVariableIndexOf9, this.pCtx);
                                                                            if (iVariableIndexOf9 == -1) {
                                                                                ParserContext parserContext21 = this.pCtx;
                                                                                String varName = indexedAssignmentNode2.getVarName();
                                                                                parserContext21.addIndexedInput(varName);
                                                                                indexedAssignmentNode2.setRegister(this.pCtx.variableIndexOf(varName));
                                                                            }
                                                                            this.lastNode = indexedAssignmentNode2;
                                                                            return indexedAssignmentNode2;
                                                                        }
                                                                        break;
                                                                    case '>':
                                                                        if (lookAhead() == '>') {
                                                                            if (lookAhead(2) == '=') {
                                                                                String str13 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                                int i116 = this.cursor + 3;
                                                                                this.cursor = i116;
                                                                                this.f73300st = i116;
                                                                                captureToEOS();
                                                                                if (z12) {
                                                                                    char[] cArr60 = this.expr;
                                                                                    int i117 = this.f73300st;
                                                                                    DeepAssignmentNode deepAssignmentNode5 = new DeepAssignmentNode(cArr60, i117, this.cursor - i117, this.fields, 9, str5, this.pCtx);
                                                                                    this.lastNode = deepAssignmentNode5;
                                                                                    return deepAssignmentNode5;
                                                                                }
                                                                                ParserContext parserContext22 = this.pCtx;
                                                                                if (parserContext22 == null || (iVariableIndexOf13 = parserContext22.variableIndexOf(str13)) == -1) {
                                                                                    char[] cArr61 = this.expr;
                                                                                    int i118 = this.f73300st;
                                                                                    OperativeAssign operativeAssign6 = new OperativeAssign(str13, cArr61, i118, this.cursor - i118, 9, this.fields, this.pCtx);
                                                                                    this.lastNode = operativeAssign6;
                                                                                    return operativeAssign6;
                                                                                }
                                                                                char[] cArr62 = this.expr;
                                                                                int i119 = this.f73300st;
                                                                                IndexedOperativeAssign indexedOperativeAssign5 = new IndexedOperativeAssign(cArr62, i119, this.cursor - i119, 9, iVariableIndexOf13, this.fields, this.pCtx);
                                                                                this.lastNode = indexedOperativeAssign5;
                                                                                return indexedOperativeAssign5;
                                                                            }
                                                                            if (lookAhead(2) == '>' && lookAhead(3) == '=') {
                                                                                String str14 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                                                                int i120 = this.cursor + 4;
                                                                                this.cursor = i120;
                                                                                this.f73300st = i120;
                                                                                captureToEOS();
                                                                                if (z12) {
                                                                                    char[] cArr63 = this.expr;
                                                                                    int i121 = this.f73300st;
                                                                                    DeepAssignmentNode deepAssignmentNode6 = new DeepAssignmentNode(cArr63, i121, this.cursor - i121, this.fields, 11, str5, this.pCtx);
                                                                                    this.lastNode = deepAssignmentNode6;
                                                                                    return deepAssignmentNode6;
                                                                                }
                                                                                ParserContext parserContext23 = this.pCtx;
                                                                                if (parserContext23 == null || (iVariableIndexOf12 = parserContext23.variableIndexOf(str14)) == -1) {
                                                                                    char[] cArr64 = this.expr;
                                                                                    int i122 = this.f73300st;
                                                                                    OperativeAssign operativeAssign7 = new OperativeAssign(str14, cArr64, i122, this.cursor - i122, 11, this.fields, this.pCtx);
                                                                                    this.lastNode = operativeAssign7;
                                                                                    return operativeAssign7;
                                                                                }
                                                                                char[] cArr65 = this.expr;
                                                                                int i123 = this.f73300st;
                                                                                IndexedOperativeAssign indexedOperativeAssign6 = new IndexedOperativeAssign(cArr65, i123, this.cursor - i123, 11, iVariableIndexOf12, this.fields, this.pCtx);
                                                                                this.lastNode = indexedOperativeAssign6;
                                                                                return indexedOperativeAssign6;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case '?':
                                                                        if (lookToLast() == '.' || this.cursor == this.start) {
                                                                            this.cursor++;
                                                                            z12 = true;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        if (i95 != i96) {
                                                                            if (m.c0(c12)) {
                                                                                if (z12) {
                                                                                    this.cursor++;
                                                                                    while (true) {
                                                                                        int i124 = this.cursor;
                                                                                        if (i124 == this.end || !m.c0(this.expr[i124])) {
                                                                                        }
                                                                                        this.cursor++;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                int i125 = this.cursor;
                                                                                if (i125 + 1 == this.end || !m.c0(this.expr[i125 + 1])) {
                                                                                    this.cursor++;
                                                                                }
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                            }
                                        } else if (z12) {
                                            this.cursor = m.e(cArr, i95, i96, '{', this.pCtx) + 1;
                                        }
                                    }
                                } else if (lookAhead() == '=') {
                                    int i126 = this.f73300st;
                                    int i127 = this.cursor;
                                    int i128 = i127 - i126;
                                    int i129 = i127 + 2;
                                    this.cursor = i129;
                                    this.f73300st = i129;
                                    captureToEOT();
                                    char[] cArr66 = this.expr;
                                    int i130 = this.fields;
                                    int i131 = this.f73300st;
                                    RegExMatch regExMatch = new RegExMatch(cArr66, i126, i128, i130, i131, this.cursor - i131, this.pCtx);
                                    this.lastNode = regExMatch;
                                    return regExMatch;
                                }
                            }
                            if (lookAhead() == '=') {
                                String str15 = new String(this.expr, this.f73300st, trimLeft(this.cursor) - this.f73300st);
                                int i132 = this.cursor + 2;
                                this.cursor = i132;
                                this.f73300st = i132;
                                captureToEOS();
                                if (z12) {
                                    char[] cArr67 = this.expr;
                                    int i133 = this.f73300st;
                                    DeepAssignmentNode deepAssignmentNode7 = new DeepAssignmentNode(cArr67, i133, this.cursor - i133, this.fields, m.u0(c12), str5, this.pCtx);
                                    this.lastNode = deepAssignmentNode7;
                                    return deepAssignmentNode7;
                                }
                                ParserContext parserContext24 = this.pCtx;
                                if (parserContext24 == null || (iVariableIndexOf3 = parserContext24.variableIndexOf(str15)) == -1) {
                                    char[] cArr68 = this.expr;
                                    int i134 = this.f73300st;
                                    OperativeAssign operativeAssign8 = new OperativeAssign(str15, cArr68, i134, this.cursor - i134, m.u0(c12), this.fields, this.pCtx);
                                    this.lastNode = operativeAssign8;
                                    return operativeAssign8;
                                }
                                char[] cArr69 = this.expr;
                                int i135 = this.f73300st;
                                IndexedOperativeAssign indexedOperativeAssign7 = new IndexedOperativeAssign(cArr69, i135, this.cursor - i135, m.u0(c12), iVariableIndexOf3, this.fields, this.pCtx);
                                this.lastNode = indexedOperativeAssign7;
                                return indexedOperativeAssign7;
                            }
                        } else {
                            this.cursor = m.e(cArr, i95, i96, '[', this.pCtx) + 1;
                        }
                    }
                    trimWhitespace();
                    return createPropertyToken(this.f73300st, this.cursor);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e12) {
            throw new CompileException("unexpected end of statement", this.expr, this.cursor, e12);
        } catch (NumberFormatException e13) {
            throw new CompileException("badly formatted number: " + e13.getMessage(), this.expr, this.f73300st, e13);
        } catch (StringIndexOutOfBoundsException e14) {
            throw new CompileException("unexpected end of statement", this.expr, this.cursor, e14);
        } catch (CompileException e15) {
            throw f.a(e15, this.expr, this.cursor);
        } catch (RedundantCodeException unused2) {
            return nextToken();
        }
    }

    public ASTNode nextTokenSkipSymbols() {
        ASTNode aSTNodeNextToken = nextToken();
        return (aSTNodeNextToken == null || aSTNodeNextToken.getFields() != -1) ? aSTNodeNextToken : nextToken();
    }

    public void reduce() {
        try {
            int iIntValue = ((Integer) this.stk.n()).intValue();
            if (iIntValue != 0) {
                boolean z11 = true;
                if (iIntValue != 1 && iIntValue != 2 && iIntValue != 3 && iIntValue != 4 && iIntValue != 5) {
                    if (iIntValue == 36) {
                        g gVar = this.stk;
                        gVar.q(Boolean.valueOf(org.mvel2.b.a(gVar.l().getClass(), (Class) this.stk.o())));
                        return;
                    }
                    switch (iIntValue) {
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            break;
                        default:
                            switch (iIntValue) {
                                case 21:
                                    Object objN = this.stk.n();
                                    g gVar2 = this.stk;
                                    if (!((Boolean) gVar2.n()).booleanValue() || !((Boolean) objN).booleanValue()) {
                                        z11 = false;
                                    }
                                    gVar2.q(Boolean.valueOf(z11));
                                    return;
                                case 22:
                                    Object objN2 = this.stk.n();
                                    g gVar3 = this.stk;
                                    if (!((Boolean) gVar3.n()).booleanValue() && !((Boolean) objN2).booleanValue()) {
                                        z11 = false;
                                    }
                                    gVar3.q(Boolean.valueOf(z11));
                                    return;
                                case 23:
                                    Object objN3 = this.stk.n();
                                    Object objN4 = this.stk.n();
                                    if (n.j(objN4) && n.j(objN3)) {
                                        this.stk.q(null);
                                        return;
                                    }
                                    this.stk.b();
                                    g gVar4 = this.stk;
                                    if (!n.j(objN4)) {
                                        objN3 = objN4;
                                    }
                                    gVar4.q(objN3);
                                    return;
                                case 24:
                                    g gVar5 = this.stk;
                                    gVar5.q(Boolean.valueOf(Pattern.compile(String.valueOf(gVar5.n())).matcher(String.valueOf(this.stk.n())).matches()));
                                    return;
                                case 25:
                                    g gVar6 = this.stk;
                                    gVar6.q(Boolean.valueOf(((Class) gVar6.n()).isInstance(this.stk.n())));
                                    return;
                                case 26:
                                    g gVar7 = this.stk;
                                    gVar7.q(Boolean.valueOf(m.l(gVar7.l(), this.stk.o())));
                                    return;
                                case 27:
                                    g gVar8 = this.stk;
                                    gVar8.q(Boolean.valueOf(r.a(String.valueOf(gVar8.n())).equals(r.a(String.valueOf(this.stk.n())))));
                                    return;
                                case 28:
                                    g gVar9 = this.stk;
                                    gVar9.q(Float.valueOf(m.D0(String.valueOf(gVar9.n()), String.valueOf(this.stk.n()))));
                                    return;
                                default:
                                    reduceNumeric(iIntValue);
                                    return;
                            }
                    }
                }
            }
            this.stk.j(iIntValue);
        } catch (ArithmeticException e11) {
            throw new CompileException("arithmetic error: " + e11.getMessage(), this.expr, this.f73300st, e11);
        } catch (ClassCastException e12) {
            throw new CompileException("syntax error or incompatable types", this.expr, this.f73300st, e12);
        } catch (Exception e13) {
            throw new CompileException("failed to subEval expression", this.expr, this.f73300st, e13);
        }
    }

    public void setExpression(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        WeakHashMap<String, char[]> weakHashMap = EX_PRECACHE;
        synchronized (weakHashMap) {
            try {
                char[] cArr = weakHashMap.get(str);
                this.expr = cArr;
                if (cArr == null) {
                    char[] charArray = str.toCharArray();
                    this.expr = charArray;
                    int length = charArray.length;
                    this.length = length;
                    this.end = length;
                    while (true) {
                        int i11 = this.start;
                        if (i11 >= this.length || !m.q0(this.expr[i11])) {
                            break;
                        } else {
                            this.start++;
                        }
                    }
                    while (true) {
                        int i12 = this.length;
                        if (i12 == 0 || !m.q0(this.expr[i12 - 1])) {
                            break;
                        } else {
                            this.length--;
                        }
                    }
                    int i13 = this.length;
                    char[] cArr2 = new char[i13];
                    for (int i14 = 0; i14 != i13; i14++) {
                        cArr2[i14] = this.expr[i14];
                    }
                    EX_PRECACHE.put(str, cArr2);
                } else {
                    int length2 = cArr.length;
                    this.length = length2;
                    this.end = length2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setExpression(char[] cArr) {
        this.expr = cArr;
        int length = cArr.length;
        this.length = length;
        this.end = length;
        while (true) {
            int i11 = this.start;
            if (i11 >= this.length || !m.q0(this.expr[i11])) {
                break;
            } else {
                this.start++;
            }
        }
        while (true) {
            int i12 = this.length;
            if (i12 == 0 || !m.q0(this.expr[i12 - 1])) {
                return;
            } else {
                this.length--;
            }
        }
    }

    public void skipWhitespace() {
        int i11;
        int i12;
        int i13;
        while (true) {
            int i14 = this.cursor;
            int i15 = this.end;
            if (i14 == i15) {
                return;
            }
            char[] cArr = this.expr;
            char c11 = cArr[i14];
            if (c11 == '\n') {
                this.line++;
                this.lastLineStart = i14;
            } else if (c11 != '\r') {
                if (c11 == '/' && i14 + 1 != i15) {
                    char c12 = cArr[i14 + 1];
                    if (c12 == '*') {
                        int i16 = i15 - 1;
                        this.cursor = i14 + 1;
                        while (true) {
                            i13 = this.cursor;
                            if (i13 == i16) {
                                break;
                            }
                            char[] cArr2 = this.expr;
                            if (cArr2[i13] == '*' && cArr2[i13 + 1] == '/') {
                                break;
                            } else {
                                this.cursor = i13 + 1;
                            }
                        }
                        if (i13 != i16) {
                            this.cursor = i13 + 2;
                        }
                        while (i14 < this.cursor) {
                            this.expr[i14] = ' ';
                            i14++;
                        }
                    } else {
                        if (c12 != '/') {
                            return;
                        }
                        this.cursor = i14 + 1;
                        cArr[i14] = ' ';
                        while (true) {
                            i11 = this.cursor;
                            i12 = this.end;
                            if (i11 == i12) {
                                break;
                            }
                            char[] cArr3 = this.expr;
                            if (cArr3[i11] == '\n') {
                                break;
                            }
                            this.cursor = i11 + 1;
                            cArr3[i11] = ' ';
                        }
                        if (i11 != i12) {
                            this.cursor = i11 + 1;
                        }
                        this.line++;
                        this.lastLineStart = this.cursor;
                    }
                } else if (!m.q0(c11)) {
                    return;
                } else {
                    this.cursor++;
                }
            }
            this.cursor = i14 + 1;
        }
    }

    public boolean tokenContinues() {
        char c11;
        int i11 = this.cursor;
        if (i11 == this.end) {
            return false;
        }
        char c12 = this.expr[i11];
        if (c12 == '.' || c12 == '[') {
            return true;
        }
        if (m.q0(c12)) {
            int i12 = this.cursor;
            skipWhitespace();
            int i13 = this.cursor;
            if (i13 != this.end && ((c11 = this.expr[i13]) == '.' || c11 == '[')) {
                return true;
            }
            this.cursor = i12;
        }
        return false;
    }

    public int trimLeft(int i11) {
        int i12 = this.end;
        if (i11 > i12) {
            i11 = i12;
        }
        while (i11 > 0 && i11 >= this.f73300st) {
            int i13 = i11 - 1;
            if (!m.q0(this.expr[i13]) && this.expr[i13] != ';') {
                break;
            }
            i11--;
        }
        return i11;
    }

    public int trimRight(int i11) {
        while (i11 != this.end && m.q0(this.expr[i11])) {
            i11++;
        }
        return i11;
    }

    public void trimWhitespace() {
        while (true) {
            int i11 = this.cursor;
            if (i11 == 0 || !m.q0(this.expr[i11 - 1])) {
                return;
            } else {
                this.cursor--;
            }
        }
    }
}

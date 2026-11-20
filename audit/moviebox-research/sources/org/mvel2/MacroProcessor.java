package org.mvel2;

import java.util.Map;
import org.mvel2.compiler.AbstractParser;
import t30.m;
import t30.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class MacroProcessor extends AbstractParser {
    private Map<String, f> macros;

    public MacroProcessor() {
    }

    public MacroProcessor(Map<String, f> map) {
        this.macros = map;
    }

    public void captureToWhitespace() {
        while (true) {
            int i11 = this.cursor;
            if (i11 >= this.length || m.q0(this.expr[i11])) {
                return;
            } else {
                this.cursor++;
            }
        }
    }

    public Map<String, f> getMacros() {
        return this.macros;
    }

    public String parse(String str) {
        return new String(parse(str.toCharArray()));
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:65:0x0103  */
    /* JADX WARN: Code duplicated, block: B:70:0x010c  */
    /* JADX WARN: Code duplicated, block: B:71:0x010e  */
    public char[] parse(char[] cArr) {
        char c11;
        int i11;
        setExpression(cArr);
        s sVar = new s();
        boolean z11 = true;
        while (true) {
            int i12 = this.cursor;
            if (i12 >= this.length) {
                return sVar.h();
            }
            while (true) {
                int i13 = this.cursor;
                if (i13 >= this.length || !m.c0(this.expr[i13])) {
                    break;
                }
                this.cursor++;
            }
            int i14 = this.cursor;
            if (i14 > i12) {
                Map<String, f> map = this.macros;
                String str = new String(this.expr, i12, i14 - i12);
                if (map.containsKey(str) && z11) {
                    sVar.d(this.macros.get(str).a());
                } else {
                    sVar.d(str);
                }
            }
            int i15 = this.cursor;
            int i16 = this.length;
            if (i15 < i16) {
                char[] cArr2 = this.expr;
                char c12 = cArr2[i15];
                if (c12 == '\"' || c12 == '\'') {
                    int iH = m.h(c12, cArr2, i15, i16);
                    this.cursor = iH;
                    sVar.d(new String(cArr2, i15, iH - i15));
                    int i17 = this.cursor;
                    if (i17 < this.length) {
                        if (m.c0(this.expr[i17])) {
                            this.cursor--;
                        }
                        c11 = this.expr[this.cursor];
                        if (c11 == '(') {
                            z11 = true;
                        } else if (c11 != '.') {
                            z11 = false;
                        } else if (c11 != ';' || c11 == '{') {
                            z11 = true;
                        }
                        sVar.a(c11);
                    }
                } else if (c12 == '/') {
                    if (i15 + 1 != i16) {
                        char c13 = cArr2[i15 + 1];
                        if (c13 == '*') {
                            int i18 = i16 - 1;
                            while (true) {
                                i11 = this.cursor;
                                if (i11 == i18) {
                                    break;
                                }
                                char[] cArr3 = this.expr;
                                if (cArr3[i11] == '*' && cArr3[i11 + 1] == '/') {
                                    break;
                                }
                                this.cursor = i11 + 1;
                            }
                            this.cursor = i11 + 2;
                        } else if (c13 == '/') {
                            while (true) {
                                int i19 = this.cursor;
                                if (i19 == this.length || this.expr[i19] == '\n') {
                                    break;
                                }
                                this.cursor = i19 + 1;
                            }
                        }
                    }
                    int i21 = this.cursor;
                    if (i21 < this.length) {
                        this.cursor = i21 + 1;
                    }
                    sVar.d(new String(this.expr, i15, this.cursor - i15));
                    int i22 = this.cursor;
                    if (i22 < this.length) {
                        this.cursor = i22 - 1;
                    }
                } else if (c12 != '\\') {
                    c11 = this.expr[this.cursor];
                    if (c11 == '(') {
                        z11 = true;
                    } else if (c11 != '.') {
                        z11 = false;
                    } else if (c11 != ';') {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                    sVar.a(c11);
                } else {
                    this.cursor = i15 + 1;
                }
            }
            this.cursor++;
        }
    }

    public void setMacros(Map<String, f> map) {
        this.macros = map;
    }
}

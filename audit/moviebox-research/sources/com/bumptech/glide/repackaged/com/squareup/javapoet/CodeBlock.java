package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CodeBlock {
    final List<Object> args;
    final List<String> formatParts;
    private static final Pattern NAMED_ARGUMENT = Pattern.compile("\\$(?<argumentName>[\\w_]+):(?<typeChar>[\\w]).*");
    private static final Pattern LOWERCASE = Pattern.compile("[a-z]+[\\w_]*");

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        final List<Object> args;
        final List<String> formatParts;

        private Builder() {
            this.formatParts = new ArrayList();
            this.args = new ArrayList();
        }

        private void addArgument(String str, char c11, Object obj) {
            if (c11 == 'L') {
                this.args.add(argToLiteral(obj));
                return;
            }
            if (c11 == 'N') {
                this.args.add(argToName(obj));
            } else if (c11 == 'S') {
                this.args.add(argToString(obj));
            } else {
                if (c11 != 'T') {
                    throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
                }
                this.args.add(argToType(obj));
            }
        }

        private Object argToLiteral(Object obj) {
            return obj;
        }

        private String argToName(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof ParameterSpec) {
                return ((ParameterSpec) obj).name;
            }
            if (obj instanceof FieldSpec) {
                return ((FieldSpec) obj).name;
            }
            if (obj instanceof MethodSpec) {
                return ((MethodSpec) obj).name;
            }
            if (obj instanceof TypeSpec) {
                return ((TypeSpec) obj).name;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String argToString(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private TypeName argToType(Object obj) {
            if (obj instanceof TypeName) {
                return (TypeName) obj;
            }
            if (obj instanceof TypeMirror) {
                return TypeName.get((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return TypeName.get(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return TypeName.get((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        private boolean isNoArgPlaceholder(char c11) {
            return c11 == '$' || c11 == '>' || c11 == '<' || c11 == '[' || c11 == ']' || c11 == 'W';
        }

        public Builder add(CodeBlock codeBlock) {
            this.formatParts.addAll(codeBlock.formatParts);
            this.args.addAll(codeBlock.args);
            return this;
        }

        public Builder add(String str, Object... objArr) {
            int i11;
            boolean z11;
            int i12;
            char cCharAt;
            boolean z12;
            int i13;
            int[] iArr = new int[objArr.length];
            int i14 = 0;
            boolean z13 = false;
            int i15 = 0;
            boolean z14 = false;
            while (true) {
                if (i14 >= str.length()) {
                    break;
                }
                if (str.charAt(i14) != '$') {
                    int iIndexOf = str.indexOf(36, i14 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    this.formatParts.add(str.substring(i14, iIndexOf));
                    i14 = iIndexOf;
                } else {
                    int i16 = i14 + 1;
                    int i17 = i16;
                    while (true) {
                        Util.checkArgument(i17 < str.length(), "dangling format characters in '%s'", str);
                        i12 = i17 + 1;
                        cCharAt = str.charAt(i17);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i17 = i12;
                    }
                    if (isNoArgPlaceholder(cCharAt)) {
                        Util.checkArgument(i16 == i17, "$$, $>, $<, $[, $], and $W may not have an index", new Object[0]);
                        this.formatParts.add("$" + cCharAt);
                    } else {
                        if (i16 < i17) {
                            int i18 = Integer.parseInt(str.substring(i16, i17)) - 1;
                            if (objArr.length > 0) {
                                int length = i18 % objArr.length;
                                iArr[length] = iArr[length] + 1;
                            }
                            z12 = true;
                            i13 = i15;
                            i15 = i18;
                        } else {
                            z12 = z14;
                            i13 = i15 + 1;
                            z13 = true;
                        }
                        Util.checkArgument(i15 >= 0 && i15 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i15 + 1), str.substring(i14, i17 + 1), Integer.valueOf(objArr.length));
                        Util.checkArgument((z12 && z13) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        addArgument(str, cCharAt, objArr[i15]);
                        this.formatParts.add("$" + cCharAt);
                        i15 = i13;
                        z14 = z12;
                    }
                    i14 = i12;
                }
            }
            if (z13) {
                if (i15 >= objArr.length) {
                    i11 = 2;
                    z11 = true;
                } else {
                    i11 = 2;
                    z11 = false;
                }
                Object[] objArr2 = new Object[i11];
                objArr2[0] = Integer.valueOf(i15);
                objArr2[1] = Integer.valueOf(objArr.length);
                Util.checkArgument(z11, "unused arguments: expected %s, received %s", objArr2);
            }
            if (z14) {
                ArrayList arrayList = new ArrayList();
                for (int i19 = 0; i19 < objArr.length; i19++) {
                    if (iArr[i19] == 0) {
                        arrayList.add("$" + (i19 + 1));
                    }
                }
                Util.checkArgument(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", Util.join(", ", arrayList));
            }
            return this;
        }

        public Builder addStatement(String str, Object... objArr) {
            add("$[", new Object[0]);
            add(str, objArr);
            add(";\n$]", new Object[0]);
            return this;
        }

        public Builder beginControlFlow(String str, Object... objArr) {
            add(str + " {\n", objArr);
            indent();
            return this;
        }

        public CodeBlock build() {
            return new CodeBlock(this);
        }

        public Builder endControlFlow() {
            unindent();
            add("}\n", new Object[0]);
            return this;
        }

        public Builder indent() {
            this.formatParts.add("$>");
            return this;
        }

        public Builder nextControlFlow(String str, Object... objArr) {
            unindent();
            add("} " + str + " {\n", objArr);
            indent();
            return this;
        }

        public Builder unindent() {
            this.formatParts.add("$<");
            return this;
        }
    }

    private CodeBlock(Builder builder) {
        this.formatParts = Util.immutableList(builder.formatParts);
        this.args = Util.immutableList(builder.args);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static CodeBlock of(String str, Object... objArr) {
        return new Builder().add(str, objArr).build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CodeBlock.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isEmpty() {
        return this.formatParts.isEmpty();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new CodeWriter(stringWriter).emit(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}

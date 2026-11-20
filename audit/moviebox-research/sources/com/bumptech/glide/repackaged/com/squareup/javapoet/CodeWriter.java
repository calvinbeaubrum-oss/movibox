package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class CodeWriter {
    private static final String NO_PACKAGE = new String();
    private boolean comment;
    private final Map<String, ClassName> importableTypes;
    private final Map<String, ClassName> importedTypes;
    private final String indent;
    private int indentLevel;
    private boolean javadoc;
    private final LineWrapper out;
    private String packageName;
    private final Set<String> referencedNames;
    int statementLine;
    private final Set<String> staticImportClassNames;
    private final Set<String> staticImports;
    private boolean trailingNewline;
    private final List<TypeSpec> typeSpecStack;

    public CodeWriter(Appendable appendable) {
        this(appendable, "  ", Collections.emptySet());
    }

    public CodeWriter(Appendable appendable, String str, Map<String, ClassName> map, Set<String> set) {
        this.javadoc = false;
        this.comment = false;
        this.packageName = NO_PACKAGE;
        this.typeSpecStack = new ArrayList();
        this.importableTypes = new LinkedHashMap();
        this.referencedNames = new LinkedHashSet();
        this.statementLine = -1;
        this.out = new LineWrapper(appendable, str, 100);
        this.indent = (String) Util.checkNotNull(str, "indent == null", new Object[0]);
        this.importedTypes = (Map) Util.checkNotNull(map, "importedTypes == null", new Object[0]);
        this.staticImports = (Set) Util.checkNotNull(set, "staticImports == null", new Object[0]);
        this.staticImportClassNames = new LinkedHashSet();
        for (String str2 : set) {
            this.staticImportClassNames.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }

    public CodeWriter(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.emptyMap(), set);
    }

    private void emitIndentation() throws IOException {
        for (int i11 = 0; i11 < this.indentLevel; i11++) {
            this.out.append(this.indent);
        }
    }

    private void emitLiteral(Object obj) throws IOException {
        if (obj instanceof TypeSpec) {
            ((TypeSpec) obj).emit(this, null, Collections.emptySet());
            return;
        }
        if (obj instanceof AnnotationSpec) {
            ((AnnotationSpec) obj).emit(this, true);
        } else if (obj instanceof CodeBlock) {
            emit((CodeBlock) obj);
        } else {
            emitAndIndent(String.valueOf(obj));
        }
    }

    private boolean emitStaticImportMember(String str, String str2) throws IOException {
        String strSubstring = str2.substring(1);
        if (strSubstring.isEmpty() || !Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
            return false;
        }
        String str3 = str + InstructionFileId.DOT + extractMemberName(strSubstring);
        String str4 = str + ".*";
        if (!this.staticImports.contains(str3) && !this.staticImports.contains(str4)) {
            return false;
        }
        emitAndIndent(strSubstring);
        return true;
    }

    private static String extractMemberName(String str) {
        Util.checkArgument(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i11 = 1; i11 <= str.length(); i11++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i11))) {
                return str.substring(0, i11 - 1);
            }
        }
        return str;
    }

    private void importableType(ClassName className) {
        ClassName className2;
        String strSimpleName;
        ClassName classNamePut;
        if (className.packageName().isEmpty() || (classNamePut = this.importableTypes.put((strSimpleName = (className2 = className.topLevelClassName()).simpleName()), className2)) == null) {
            return;
        }
        this.importableTypes.put(strSimpleName, classNamePut);
    }

    private ClassName resolve(String str) {
        for (int size = this.typeSpecStack.size() - 1; size >= 0; size--) {
            Iterator<TypeSpec> it = this.typeSpecStack.get(size).typeSpecs.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().name, str)) {
                    return stackClassName(size, str);
                }
            }
        }
        if (this.typeSpecStack.size() > 0 && Objects.equals(this.typeSpecStack.get(0).name, str)) {
            return ClassName.get(this.packageName, str, new String[0]);
        }
        ClassName className = this.importedTypes.get(str);
        if (className != null) {
            return className;
        }
        return null;
    }

    private ClassName stackClassName(int i11, String str) {
        ClassName classNameNestedClass = ClassName.get(this.packageName, this.typeSpecStack.get(0).name, new String[0]);
        for (int i12 = 1; i12 <= i11; i12++) {
            classNameNestedClass = classNameNestedClass.nestedClass(this.typeSpecStack.get(i12).name);
        }
        return classNameNestedClass.nestedClass(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:88:0x013c  */
    public CodeWriter emit(CodeBlock codeBlock) throws IOException {
        int i11;
        ListIterator<String> listIterator = codeBlock.formatParts.listIterator();
        ClassName className = null;
        int i12 = 0;
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            next.hashCode();
            switch (next) {
                case "$$":
                    emitAndIndent("$");
                    continue;
                    break;
                case "$<":
                    unindent();
                    continue;
                    break;
                case "$>":
                    indent();
                    continue;
                    break;
                case "$L":
                    i11 = i12 + 1;
                    emitLiteral(codeBlock.args.get(i12));
                    break;
                case "$N":
                    i11 = i12 + 1;
                    emitAndIndent((String) codeBlock.args.get(i12));
                    break;
                case "$S":
                    i11 = i12 + 1;
                    String str = (String) codeBlock.args.get(i12);
                    emitAndIndent(str != null ? Util.stringLiteralWithDoubleQuotes(str, this.indent) : "null");
                    break;
                case "$T":
                    i11 = i12 + 1;
                    TypeName typeNameWithoutAnnotations = (TypeName) codeBlock.args.get(i12);
                    if (typeNameWithoutAnnotations.isAnnotated()) {
                        typeNameWithoutAnnotations.emitAnnotations(this);
                        typeNameWithoutAnnotations = typeNameWithoutAnnotations.withoutAnnotations();
                    }
                    if (!(typeNameWithoutAnnotations instanceof ClassName) || !listIterator.hasNext() || codeBlock.formatParts.get(listIterator.nextIndex()).startsWith("$")) {
                        typeNameWithoutAnnotations.emit(this);
                        break;
                    } else {
                        ClassName className2 = (ClassName) typeNameWithoutAnnotations;
                        if (!this.staticImportClassNames.contains(className2.canonicalName)) {
                            typeNameWithoutAnnotations.emit(this);
                        } else {
                            Util.checkState(className == null, "pending type for static import?!", new Object[0]);
                            className = className2;
                        }
                        break;
                    }
                    break;
                case "$W":
                    this.out.wrappingSpace(this.indentLevel + 2);
                    continue;
                    break;
                case "$[":
                    Util.checkState(this.statementLine == -1, "statement enter $[ followed by statement enter $[", new Object[0]);
                    this.statementLine = 0;
                    continue;
                    break;
                case "$]":
                    Util.checkState(this.statementLine != -1, "statement exit $] has no matching statement enter $[", new Object[0]);
                    if (this.statementLine > 0) {
                        unindent(2);
                    }
                    this.statementLine = -1;
                    continue;
                    break;
                default:
                    if (className != null) {
                        if (next.startsWith(InstructionFileId.DOT) && emitStaticImportMember(className.canonicalName, next)) {
                            className = null;
                        } else {
                            className.emit(this);
                            className = null;
                        }
                        break;
                    }
                    emitAndIndent(next);
                    continue;
                    break;
            }
            i12 = i11;
        }
        return this;
    }

    public CodeWriter emit(String str) throws IOException {
        return emitAndIndent(str);
    }

    public CodeWriter emit(String str, Object... objArr) throws IOException {
        return emit(CodeBlock.of(str, objArr));
    }

    public CodeWriter emitAndIndent(String str) throws IOException {
        String[] strArrSplit = str.split("\n", -1);
        int length = strArrSplit.length;
        int i11 = 0;
        boolean z11 = true;
        while (i11 < length) {
            String str2 = strArrSplit[i11];
            if (!z11) {
                if ((this.javadoc || this.comment) && this.trailingNewline) {
                    emitIndentation();
                    this.out.append(this.javadoc ? " *" : "//");
                }
                this.out.append("\n");
                this.trailingNewline = true;
                int i12 = this.statementLine;
                if (i12 != -1) {
                    if (i12 == 0) {
                        indent(2);
                    }
                    this.statementLine++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.trailingNewline) {
                    emitIndentation();
                    if (this.javadoc) {
                        this.out.append(" * ");
                    } else if (this.comment) {
                        this.out.append("// ");
                    }
                }
                this.out.append(str2);
                this.trailingNewline = false;
            }
            i11++;
            z11 = false;
        }
        return this;
    }

    public void emitAnnotations(List<AnnotationSpec> list, boolean z11) throws IOException {
        Iterator<AnnotationSpec> it = list.iterator();
        while (it.hasNext()) {
            it.next().emit(this, z11);
            emit(z11 ? " " : "\n");
        }
    }

    public void emitComment(CodeBlock codeBlock) throws IOException {
        this.trailingNewline = true;
        this.comment = true;
        try {
            emit(codeBlock);
            emit("\n");
        } finally {
            this.comment = false;
        }
    }

    public void emitJavadoc(CodeBlock codeBlock) throws IOException {
        if (codeBlock.isEmpty()) {
            return;
        }
        emit("/**\n");
        this.javadoc = true;
        try {
            emit(codeBlock);
            this.javadoc = false;
            emit(" */\n");
        } catch (Throwable th2) {
            this.javadoc = false;
            throw th2;
        }
    }

    public void emitModifiers(Set<Modifier> set) throws IOException {
        emitModifiers(set, Collections.emptySet());
    }

    public void emitModifiers(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (set.isEmpty()) {
            return;
        }
        for (Modifier modifier : EnumSet.copyOf((Collection) set)) {
            if (!set2.contains(modifier)) {
                emitAndIndent(modifier.name().toLowerCase(Locale.US));
                emitAndIndent(" ");
            }
        }
    }

    public void emitTypeVariables(List<TypeVariableName> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        emit("<");
        boolean z11 = true;
        for (TypeVariableName typeVariableName : list) {
            if (!z11) {
                emit(", ");
            }
            emit("$L", typeVariableName.name);
            Iterator<TypeName> it = typeVariableName.bounds.iterator();
            boolean z12 = true;
            while (it.hasNext()) {
                emit(z12 ? " extends $T" : " & $T", it.next());
                z12 = false;
            }
            z11 = false;
        }
        emit(">");
    }

    public CodeWriter emitWrappingSpace() throws IOException {
        this.out.wrappingSpace(this.indentLevel + 2);
        return this;
    }

    public Map<String, ClassName> importedTypes() {
        return this.importedTypes;
    }

    public CodeWriter indent() {
        return indent(1);
    }

    public CodeWriter indent(int i11) {
        this.indentLevel += i11;
        return this;
    }

    public String lookupName(ClassName className) {
        ClassName classNameEnclosingClassName = className;
        boolean z11 = false;
        while (classNameEnclosingClassName != null) {
            ClassName classNameResolve = resolve(classNameEnclosingClassName.simpleName());
            boolean z12 = classNameResolve != null;
            if (Objects.equals(classNameResolve, classNameEnclosingClassName)) {
                return Util.join(InstructionFileId.DOT, className.simpleNames().subList(classNameEnclosingClassName.simpleNames().size() - 1, className.simpleNames().size()));
            }
            classNameEnclosingClassName = classNameEnclosingClassName.enclosingClassName();
            z11 = z12;
        }
        if (z11) {
            return className.canonicalName;
        }
        if (Objects.equals(this.packageName, className.packageName())) {
            this.referencedNames.add(className.topLevelClassName().simpleName());
            return Util.join(InstructionFileId.DOT, className.simpleNames());
        }
        if (!this.javadoc) {
            importableType(className);
        }
        return className.canonicalName;
    }

    public CodeWriter popPackage() {
        String str = this.packageName;
        String str2 = NO_PACKAGE;
        Util.checkState(str != str2, "package already set: %s", str);
        this.packageName = str2;
        return this;
    }

    public CodeWriter popType() {
        List<TypeSpec> list = this.typeSpecStack;
        list.remove(list.size() - 1);
        return this;
    }

    public CodeWriter pushPackage(String str) {
        String str2 = this.packageName;
        Util.checkState(str2 == NO_PACKAGE, "package already set: %s", str2);
        this.packageName = (String) Util.checkNotNull(str, "packageName == null", new Object[0]);
        return this;
    }

    public CodeWriter pushType(TypeSpec typeSpec) {
        this.typeSpecStack.add(typeSpec);
        return this;
    }

    public Map<String, ClassName> suggestedImports() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.importableTypes);
        linkedHashMap.keySet().removeAll(this.referencedNames);
        return linkedHashMap;
    }

    public CodeWriter unindent() {
        return unindent(1);
    }

    public CodeWriter unindent(int i11) {
        Util.checkArgument(this.indentLevel - i11 >= 0, "cannot unindent %s from %s", Integer.valueOf(i11), Integer.valueOf(this.indentLevel));
        this.indentLevel -= i11;
        return this;
    }
}

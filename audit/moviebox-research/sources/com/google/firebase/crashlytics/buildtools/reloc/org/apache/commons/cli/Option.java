package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class Option implements Cloneable, Serializable {
    public static final int UNINITIALIZED = -1;
    public static final int UNLIMITED_VALUES = -2;
    private static final long serialVersionUID = 1;
    private String argName;
    private String description;
    private String longOpt;
    private int numberOfArgs;
    private final String opt;
    private boolean optionalArg;
    private boolean required;
    private Class<?> type;
    private List<String> values;
    private char valuesep;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f40050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f40051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f40052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f40053g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Class<?> f40054h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public char f40055i;

        public b(String str) throws IllegalArgumentException {
            this.f40053g = -1;
            this.f40054h = String.class;
            com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.b.c(str);
            this.f40047a = str;
        }
    }

    private Option(b bVar) {
        this.numberOfArgs = -1;
        this.type = String.class;
        this.values = new ArrayList();
        this.argName = bVar.f40050d;
        this.description = bVar.f40048b;
        this.longOpt = bVar.f40049c;
        this.numberOfArgs = bVar.f40053g;
        this.opt = bVar.f40047a;
        this.optionalArg = bVar.f40052f;
        this.required = bVar.f40051e;
        this.type = bVar.f40054h;
        this.valuesep = bVar.f40055i;
    }

    public Option(String str, String str2) throws IllegalArgumentException {
        this(str, null, false, str2);
    }

    public Option(String str, String str2, boolean z11, String str3) throws IllegalArgumentException {
        this.numberOfArgs = -1;
        this.type = String.class;
        this.values = new ArrayList();
        com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.b.c(str);
        this.opt = str;
        this.longOpt = str2;
        if (z11) {
            this.numberOfArgs = 1;
        }
        this.description = str3;
    }

    public Option(String str, boolean z11, String str2) throws IllegalArgumentException {
        this(str, null, z11, str2);
    }

    private void add(String str) {
        if (!acceptsArg()) {
            throw new RuntimeException("Cannot add value, list full.");
        }
        this.values.add(str);
    }

    public static b builder() {
        return builder(null);
    }

    public static b builder(String str) {
        return new b(str);
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    private void processValue(String str) {
        if (hasValueSeparator()) {
            char valueSeparator = getValueSeparator();
            int iIndexOf = str.indexOf(valueSeparator);
            while (iIndexOf != -1 && this.values.size() != this.numberOfArgs - 1) {
                add(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
                iIndexOf = str.indexOf(valueSeparator);
            }
        }
        add(str);
    }

    public boolean acceptsArg() {
        return (hasArg() || hasArgs() || hasOptionalArg()) && (this.numberOfArgs <= 0 || this.values.size() < this.numberOfArgs);
    }

    @Deprecated
    public boolean addValue(String str) {
        throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
    }

    public void addValueForProcessing(String str) {
        if (this.numberOfArgs == -1) {
            throw new RuntimeException("NO_ARGS_ALLOWED");
        }
        processValue(str);
    }

    public void clearValues() {
        this.values.clear();
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException("A CloneNotSupportedException was thrown: " + e11.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        String str = this.opt;
        if (str == null ? option.opt != null : !str.equals(option.opt)) {
            return false;
        }
        String str2 = this.longOpt;
        String str3 = option.longOpt;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public String getArgName() {
        return this.argName;
    }

    public int getArgs() {
        return this.numberOfArgs;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return getKey().charAt(0);
    }

    public String getKey() {
        String str = this.opt;
        return str == null ? this.longOpt : str;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public String getOpt() {
        return this.opt;
    }

    public Object getType() {
        return this.type;
    }

    public String getValue() {
        if (hasNoValues()) {
            return null;
        }
        return this.values.get(0);
    }

    public String getValue(int i11) throws IndexOutOfBoundsException {
        if (hasNoValues()) {
            return null;
        }
        return this.values.get(i11);
    }

    public String getValue(String str) {
        String value = getValue();
        return value != null ? value : str;
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public String[] getValues() {
        if (hasNoValues()) {
            return null;
        }
        List<String> list = this.values;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public List<String> getValuesList() {
        return this.values;
    }

    public boolean hasArg() {
        int i11 = this.numberOfArgs;
        return i11 > 0 || i11 == -2;
    }

    public boolean hasArgName() {
        String str = this.argName;
        return str != null && str.length() > 0;
    }

    public boolean hasArgs() {
        int i11 = this.numberOfArgs;
        return i11 > 1 || i11 == -2;
    }

    public boolean hasLongOpt() {
        return this.longOpt != null;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasValueSeparator() {
        return this.valuesep > 0;
    }

    public int hashCode() {
        String str = this.opt;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.longOpt;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean isRequired() {
        return this.required;
    }

    public boolean requiresArg() {
        if (this.optionalArg) {
            return false;
        }
        return this.numberOfArgs == -2 ? this.values.isEmpty() : acceptsArg();
    }

    public void setArgName(String str) {
        this.argName = str;
    }

    public void setArgs(int i11) {
        this.numberOfArgs = i11;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLongOpt(String str) {
        this.longOpt = str;
    }

    public void setOptionalArg(boolean z11) {
        this.optionalArg = z11;
    }

    public void setRequired(boolean z11) {
        this.required = z11;
    }

    public void setType(Class<?> cls) {
        this.type = cls;
    }

    @Deprecated
    public void setType(Object obj) {
        setType((Class<?>) obj);
    }

    public void setValueSeparator(char c11) {
        this.valuesep = c11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ option: ");
        sb2.append(this.opt);
        if (this.longOpt != null) {
            sb2.append(" ");
            sb2.append(this.longOpt);
        }
        sb2.append(" ");
        if (hasArgs()) {
            sb2.append("[ARG...]");
        } else if (hasArg()) {
            sb2.append(" [ARG]");
        }
        sb2.append(" :: ");
        sb2.append(this.description);
        if (this.type != null) {
            sb2.append(" :: ");
            sb2.append(this.type);
        }
        sb2.append(" ]");
        return sb2.toString();
    }
}

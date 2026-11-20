package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<String> args = new LinkedList();
    private final List<Option> options = new ArrayList();

    private Option resolveOption(String str) {
        String strA = e.a(str);
        Iterator<Option> it = this.options.iterator();
        while (it.hasNext()) {
            Option next = it.next();
            if (strA.equals(next.getOpt()) || strA.equals(next.getLongOpt())) {
                return next;
            }
        }
        return null;
    }

    public void addArg(String str) {
        this.args.add(str);
    }

    public void addOption(Option option) {
        this.options.add(option);
    }

    public List<String> getArgList() {
        return this.args;
    }

    public String[] getArgs() {
        String[] strArr = new String[this.args.size()];
        this.args.toArray(strArr);
        return strArr;
    }

    public Object getOptionObject(char c11) {
        return getOptionObject(String.valueOf(c11));
    }

    @Deprecated
    public Object getOptionObject(String str) {
        try {
            return getParsedOptionValue(str);
        } catch (ParseException e11) {
            System.err.println("Exception found converting " + str + " to desired type: " + e11.getMessage());
            return null;
        }
    }

    public Properties getOptionProperties(String str) {
        Properties properties = new Properties();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                List<String> valuesList = option.getValuesList();
                if (valuesList.size() >= 2) {
                    properties.put(valuesList.get(0), valuesList.get(1));
                } else if (valuesList.size() == 1) {
                    properties.put(valuesList.get(0), "true");
                }
            }
        }
        return properties;
    }

    public String getOptionValue(char c11) {
        return getOptionValue(String.valueOf(c11));
    }

    public String getOptionValue(char c11, String str) {
        return getOptionValue(String.valueOf(c11), str);
    }

    public String getOptionValue(String str) {
        String[] optionValues = getOptionValues(str);
        if (optionValues == null) {
            return null;
        }
        return optionValues[0];
    }

    public String getOptionValue(String str, String str2) {
        String optionValue = getOptionValue(str);
        return optionValue != null ? optionValue : str2;
    }

    public String[] getOptionValues(char c11) {
        return getOptionValues(String.valueOf(c11));
    }

    public String[] getOptionValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                arrayList.addAll(option.getValuesList());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Option[] getOptions() {
        List<Option> list = this.options;
        return (Option[]) list.toArray(new Option[list.size()]);
    }

    public Object getParsedOptionValue(String str) throws ParseException {
        String optionValue = getOptionValue(str);
        Option optionResolveOption = resolveOption(str);
        if (optionResolveOption == null || optionValue == null) {
            return null;
        }
        return d.i(optionValue, optionResolveOption.getType());
    }

    public boolean hasOption(char c11) {
        return hasOption(String.valueOf(c11));
    }

    public boolean hasOption(String str) {
        return this.options.contains(resolveOption(str));
    }

    public Iterator<Option> iterator() {
        return this.options.iterator();
    }
}

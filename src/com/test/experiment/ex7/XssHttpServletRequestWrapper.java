package com.test.experiment.ex7;

/**
 * @author tangrd
 * @date 2020/7/30 15:38
 * @description
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        } else {
            int count = values.length;
            String[] encodedValues = new String[count];

            for(int i = 0; i < count; ++i) {
                encodedValues[i] = this.cleanXSS(values[i]);
            }

            return encodedValues;
        }
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return value == null ? null : this.cleanXSS(value);
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        return value;
    }

    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> values = super.getParameterMap();
        if (values == null) {
            return null;
        } else {
            Map<String, String[]> result = new HashMap();
            Iterator i$ = values.keySet().iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                String encodedKey = this.cleanXSS(key);
                int count = ((String[])values.get(key)).length;
                String[] encodedValues = new String[count];

                for(int i = 0; i < count; ++i) {
                    encodedValues[i] = this.cleanXSS(((String[])values.get(key))[i]);
                }

                result.put(encodedKey, encodedValues);
            }

            return result;
        }
    }

    private String cleanXSS(String value) {
        String valuedecode = "";
        boolean decodeflag = false;
        String value_origin = value;
        try {
            value = value.replaceAll("\\+", "%2B");
            value = value.replaceAll(" ", "%20");
            valuedecode = URLDecoder.decode(value, "UTF-8");
            if (!valuedecode.equals(value)) {
                decodeflag = true;
                value = valuedecode;
            } else {
                value = value_origin;
            }
        } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            value = value_origin;
        }

        value = value.replaceAll("\"", "&quot;");
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']", "\"\"");
        value = value.replaceAll("script", "");
        if (decodeflag) {
            try {
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException var5) {
                var5.printStackTrace();
            }
        }

        return value;
    }
}

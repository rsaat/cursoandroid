package br.com.impacta.extra_spinner;

import java.util.HashMap;

/**
 * Created by nalmir on 01/08/2016.
 */
public class HMAuxHugo extends HashMap<String,String> {

    public static final String ID = "id";
    public static final String TEXTO_01 = "texto_01";
    public static final String TEXTO_02 = "texto_02";
    public static final String TEXTO_03 = "texto_03";
    public static final String TEXTO_04 = "texto_04";
    public static final String TEXTO_05 = "texto_05";

    @Override
    public String toString() {
        return get(HMAuxHugo.TEXTO_01);
    }
}

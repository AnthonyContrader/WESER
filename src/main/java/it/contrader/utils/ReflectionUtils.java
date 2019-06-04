package it.contrader.utils;

import it.contrader.utils.GestoreEccezioni;

public class ReflectionUtils<T> {

    public static Object instantiateClass (String nomeClasse){
        try {
            return Class.forName(nomeClasse).newInstance();
        } catch (Throwable e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }

}


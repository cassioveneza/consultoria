package br.com.consultoria.util;

public class Api {

    private final static String URL_BASE = "http://localhost:8080/api/consulta-processos";

    public static class Clientes {

        public final static String SELF = URL_BASE + "/clientes";
        public final static String SELF_ID = URL_BASE + "/clientes/{id}";
    }

    public static class Filmes {

        public final static String SELF = URL_BASE + "/filmes";
        public final static String SELF_ID = URL_BASE + "/filmes/{id}";
    }

    public static class Locacoes {

        public final static String SELF = URL_BASE + "/locacoes";
        public final static String SELF_ID = URL_BASE + "/locacoes/{id}";
        public final static String ITENS = URL_BASE + "/locacoes/{id}/itens";

        public static class Itens {

            public final static String SELF = Locacoes.SELF_ID + "/itens";
            public final static String SELF_ID = Locacoes.SELF_ID + "/itens/{id}";
        }

    }

}

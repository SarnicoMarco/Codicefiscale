package Codice;

public class Datipersona {

        private String nome;
        private String cognome;
        private String mese;
        private String anno;
        private String comune;
         private String genere;
        private int giorno;



        private String consonanti = "BCDFGHJKLMNPQRSTVWXYZ";
        private String vocali = "AEIOU";


        public Datipersona(String nome, String cognome, int giorno, String mese, String anno, String comune, String genere, String vocali, String consonanti) {
            this.nome = nome;
            this.cognome = cognome;
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
            this.comune = comune;
            this.genere = genere;
            this.vocali = vocali;
            this.consonanti = consonanti;
        }

        public Datipersona() {

        }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getConsonanti() {
        return consonanti;
    }

    public void setConsonanti(String consonanti) {
        this.consonanti = consonanti;
    }

    public String getVocali() {
        return vocali;
    }

    public void setVocali(String vocali) {
        this.vocali = vocali;
    }
}







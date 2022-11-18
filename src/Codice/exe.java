package Codice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class exe {
    public static final String FILENAME = "comuniItaliani.txt";

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var path = Path.of(FILENAME);
        Datipersona persona = new Datipersona();
        var leggi = new String();
        int leggiGiorno;
        System.out.println("Nome: ");
        leggi = sc.nextLine();
        persona.setNome(leggi);
        System.out.println("Cognome: ");;
        leggi = sc.nextLine();
        persona.setCognome(leggi);
        System.out.println("Giorno: ");
        leggiGiorno = sc.nextInt();
        persona.setGiorno(leggiGiorno);
        sc.nextLine();
        System.out.println("Mese: ");
        leggi = sc.nextLine();
        persona.setMese(leggi);
        System.out.println("Anno: ");
        leggi = sc.nextLine();
        persona.setAnno(leggi);
        System.out.println("Comune: ");
        leggi = sc.nextLine();
        persona.setComune(leggi);
        System.out.println("Genere M/F: ");
        leggi = sc.nextLine();
        persona.setGenere(leggi);



        System.out.println(calcoloCodFisc(persona));
    }

    private static String calcoloCodFisc(Datipersona persona) {
        var codicefinale = new String();

        var consonantinome = new String();
        var vocalinome = new String();
        var vocalicognome = new String();
        var consonanticognome = new String();

        var consonantiNome = getConsonantiNome(persona, consonantinome);
        var vocaliNome = getVocaliNome(persona, vocalinome);
        var nome = consonantiNome+vocaliNome;
        var vocaliCognome = getVocaliCognome(persona, vocalicognome);
        var consonantiCognome = getConsonantiCognome(persona, consonanticognome);
        var cognome = consonantiCognome+vocaliCognome;

        for (int i=0; i<3; i++) {codicefinale += cognome.charAt(i);}
        for (int i=0; i<3; i++) {codicefinale += nome.charAt(i);}
        for (int i=0; i<persona.getAnno().length(); i++) {
            if (i>=2) {
                codicefinale+= persona.getAnno().charAt(i);
            }
        }
        codicefinale += letteraMese(persona, codicefinale);

        if (persona.getGenere().equals("M")) {
            if (persona.getGiorno()<10) {
                codicefinale+=0;
            }
            codicefinale+=persona.getGiorno();
        } else {
            var day = persona.getGiorno()+40;
            codicefinale+=day;
        }

        persona.getComune().toUpperCase();
        try {

            var filePersonaReader = Files.newBufferedReader(Path.of(FILENAME));
            String stringa = filePersonaReader.readLine();
            while(stringa!=null) {
                String[] comune = stringa.split(",");
                if(comune[2].contains(" ")) comune[2] = comune[2].substring(1, comune[2].length()-1);
                if(comune[2].equals(persona.getComune())) codicefinale+=comune[0];
                stringa = filePersonaReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("File non trovato");
        }

        codicefinale += generazioneCodiceControllo(persona, codicefinale);
        codicefinale.toUpperCase();
        return codicefinale;
    }

    private static String getVocaliNome(Datipersona persona, String vocalinome) {
        for (int i=0; i<persona.getNome().length(); i++) {
            for (int n=0; n<persona.getVocali().length(); n++) {
                if (persona.getNome().charAt(i) == (persona.getVocali().charAt(n))) {
                    vocalinome += (persona.getNome().charAt(i));
                }
            }
        }
        return vocalinome;
    }

    private static String generazioneCodiceControllo(Datipersona persona, String codice) {
        int posizionepari = 0;
        int posizionedispari = 0;

        for (int i=0; i<codice.length(); i++) {
            if ((i+1)%2==0) {
                switch (codice.charAt(i)) {
                    case '0', 'A':
                        posizionepari+=0;
                        break;
                    case '1', 'B':
                        posizionepari+=1;
                        break;
                    case '2', 'C':
                        posizionepari+=2;
                        break;
                    case '3', 'D' :
                        posizionepari+=3;
                        break;
                    case '4', 'E':
                        posizionepari+=4;
                        break;
                    case '5', 'F':
                        posizionepari+=5;
                        break;
                    case '6', 'G':
                        posizionepari+=6;
                        break;
                    case '7', 'H':
                        posizionepari+=7;
                        break;
                    case '8', 'I':
                        posizionepari+=8;
                        break;
                    case '9', 'J':
                        posizionepari+=9;
                        break;
                    case 'K':
                        posizionepari+=10;
                        break;
                    case 'L':
                        posizionepari+=11;
                        break;
                    case'M':
                        posizionepari+=12;
                        break;
                    case'N':
                        posizionepari+=13;
                        break;
                    case 'O':
                        posizionepari+=14;
                        break;
                    case 'P':
                        posizionepari+=15;
                        break;
                    case'Q':
                        posizionepari+=16;
                        break;
                    case'R':
                        posizionepari+=17;
                        break;
                    case 'S':
                        posizionepari+=18;
                        break;
                    case 'T':
                        posizionepari+=19;
                        break;
                    case'U':
                        posizionepari+=20;
                        break;
                    case'V':
                        posizionepari+=21;
                        break;
                    case 'W':
                        posizionepari+=22;
                        break;
                    case 'X':
                        posizionepari+=23;
                        break;
                    case'Y':
                        posizionepari+=24;
                        break;
                    case'Z':
                        posizionepari+=25;
                }

            } else {
                switch (codice.charAt(i)) {
                    case '0', 'A':
                        posizionedispari+=1;
                        break;
                    case '1', 'B':
                        posizionedispari+=0;
                        break;
                    case '2', 'C':
                        posizionedispari+=5;
                        break;
                    case '3', 'D' :
                        posizionedispari+=7;
                        break;
                    case '4', 'E':
                        posizionedispari+=9;
                        break;
                    case '5', 'F':
                        posizionedispari+=13;
                        break;
                    case '6', 'G':
                        posizionedispari+=15;
                        break;
                    case '7', 'H':
                        posizionedispari+=17;
                        break;
                    case '8', 'I':
                        posizionedispari+=19;
                        break;
                    case '9', 'J':
                        posizionedispari+=21;
                        break;
                    case 'K':
                        posizionedispari+=2;
                        break;
                    case 'L':
                        posizionedispari+=4;
                        break;
                    case'M':
                        posizionedispari+=18;
                        break;
                    case'N':
                        posizionedispari+=20;
                        break;
                    case 'O':
                        posizionedispari+=11;
                        break;
                    case 'P':
                        posizionedispari+=3;
                        break;
                    case'Q':
                        posizionedispari+=6;
                        break;
                    case'R':
                        posizionedispari+=8;
                        break;
                    case 'S':
                        posizionedispari+=12;
                        break;
                    case 'T':
                        posizionedispari+=14;
                        break;
                    case'U':
                        posizionedispari+=16;
                        break;
                    case'V':
                        posizionedispari+=10;
                        break;
                    case 'W':
                        posizionedispari+=22;
                        break;
                    case 'X':
                        posizionedispari+=25;
                        break;
                    case'Y':
                        posizionedispari+=24;
                        break;
                    case'Z':
                        posizionedispari+=23;
                }
            }
        }
        var codicediVerifica = posizionedispari+posizionepari;
        codicediVerifica = codicediVerifica%26;
        switch (codicediVerifica) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";
            case 4:
                return "E";
            case 5:
                return "F";
            case 6:
                return "G";
            case 7:
                return "H";
            case 8:
                return "I";
            case 9:
                return "J";
            case 10:
                return "K";
            case 11:
                return "L";
            case 12:
                return "M";
            case 13:
                return "N";
            case 14:
                return "O";
            case 15:
                return "P";
            case 16:
                return "Q";
            case 17:
                return "R";
            case 18:
                return "S";
            case 19:
                return "T";
            case 20:
                return "U";
            case 21:
                return "V";
            case 22:
                return "W";
            case 23:
                return "X";
            case 24:
                return "Y";
            case 25:
                return "Z";

        }
        return String.valueOf(codicediVerifica);
    }

    private static String letteraMese(Datipersona persona, String code) {
        switch(persona.getMese()) {
            case "01":
                return "A";

            case "02":
                return "B";

            case "03":
                return "C";

            case "04":
                return "D";

            case "05":
                return "E";

            case "06":
                return "H";

            case "07":
                return "L";

            case "08":
                return "M";

            case "09":
                return "P";

            case "10":
                return "R";

            case "11":
                return "S";

            case "12":
                return "T";
        }
        return "-";
    }

    private static String getConsonantiNome(Datipersona persona, String consonantinome) {
        for (int i=0; i<persona.getNome().length(); i++) {
            for (int k=0; k<persona.getConsonanti().length(); k++) {
                if (persona.getNome().charAt(i) == (persona.getConsonanti().charAt(k))) {
                    consonantinome += (persona.getNome().charAt(i));
                }
            }
        }
        return consonantinome;
    }
    private static String getVocaliCognome(Datipersona persona, String cognome) {
        for (int i=0; i<persona.getCognome().length(); i++) {
            for (int n=0; n<persona.getVocali().length(); n++) {
                if (persona.getCognome().charAt(i) == (persona.getVocali().charAt(n))) {
                    cognome += (persona.getCognome().charAt(i));
                }
            }
        }
        return cognome;
    }

    private static String getConsonantiCognome(Datipersona persona, String consonanticognome) {
        for (int i=0; i<persona.getCognome().length(); i++) {
            for (int k=0; k<persona.getConsonanti().length(); k++) {
                if (persona.getCognome().charAt(i) == (persona.getConsonanti().charAt(k))) {
                    consonanticognome += (persona.getCognome().charAt(i));
                }
            }
        }
        return consonanticognome;
    }


}
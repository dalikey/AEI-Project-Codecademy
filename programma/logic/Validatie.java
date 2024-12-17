package programma.logic;

//import domain;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Validatie {

    public static boolean validatieUrl(String Url){
        boolean valid;
        valid = Url.matches("www.(.*)");
        return valid;
    }

    public static boolean validatieEmail(String Email){
        //Explain of the regex key
        //^	The beginning of a line
        //[] A group of
        //\\ disables in line code like \n
        //w-_.+ any letter or number and dash, underscore, dot and plus only once
        //* zero or more after this
        //() as a capturing group
        //$	The end of a line
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]*[\\w]$";
        // return outcome determined whether email matches the regex key
        return Email.matches(regex);
    }

    public static boolean validatieDatum(Date datum){
        if (datum != null && datum.before(new Date())) {
            return true;
        }
        return false;
    }

    public static boolean validatieGeslacht(String gender){
        if (gender.equals("Man") || gender.equals("Vrouw")) {
            return true;
        }else{
            return false;
        }
    }

    //check op cijfers en nummers
    public static boolean validatiePostcode(String postcode){
        if (postcode.equals(null)) {
            return false;
        } else if (postcode.length() <= 5 || postcode.length() >= 7) {
            return false;
        } else if (postcode.matches("[1-9]{1}[0-9]{3}[a-zA-Z]{2}")) {

            return true;
        } else {
            return false;
        }
    }
    public static boolean signatoryNameValidator(String signatoryName) {
        //Explain of the regex key
        //^	The beginning of a line
        //[] A group of
        //w-_.+ any letter or number and dash, underscore, dot and plus only once
        //$	The end of a line
        String regex = "^[A-z ,.'-]+$";
        // return outcome determined whether signatory name matches the regex key
        return signatoryName.matches(regex);
    }
    public static String formatPostalCode(String postalCode) {
        if (postalCode == null) {
            return "NullPointerException";
        }
        try {
            if (Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
                    Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
                    postalCode.trim().substring(4).trim().length() == 2 &&
                    'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) &&
                    postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
                    'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) &&
                    postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z') {
                String result = postalCode.trim().substring(0, 4) + " " +
                        postalCode.trim().substring(4).trim().toUpperCase();
                return result;
            }
        } catch (Exception e) {
            return "IllegalArgumentException";
        }
        return null;
    }
    public boolean gradeValidator(int number) {
        //any number lower than one is invalid
        //any number higher than ten is invalid

        if (number >= 1 && number <= 10) {
            return true;
        }

        return false;
    }
    public boolean percentageValidator(int number) {
        //any number lower than zero is invalid
        //any number higher than one hundred is invalid

        if (number >= 0 && number <= 100) {
            return true;
        }

        return false;
    }
    public boolean validateDate(int day, int month, int year) {
        try {
            switch (month) {
                case 1:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 2:
                    if (day >= 1 && day <= 29 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                        return true;
                    } else if (day >= 1 && day <= 28 && year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
                        return true;
                    }
                    break;
                case 3:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 4:
                    if (day >= 1 && day <= 30) {
                        return true;
                    }
                    break;
                case 5:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 6:
                    if (day >= 1 && day <= 30) {
                        return true;
                    }
                    break;
                case 7:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 8:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 9:
                    if (day >= 1 && day <= 30) {
                        return true;
                    }
                    break;
                case 10:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                case 11:
                    if (day >= 1 && day <= 30) {
                        return true;
                    }
                    break;
                case 12:
                    if (day >= 1 && day <= 31) {
                        return true;
                    }
                    break;
                default:
                    return false;

            }
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }

        return false;
    }
}

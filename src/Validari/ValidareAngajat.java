package Validari;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ValidareAngajat {
    public static boolean valideazaVarsta(Date dataNastere){
        Calendar calendar = Calendar.getInstance(Locale.FRANCE);
        calendar.setTime(dataNastere);
        if (LocalDate.now().getYear() - calendar.get(Calendar.YEAR) < 18)
            return false;
        return true;
    }
}

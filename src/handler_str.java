import java.util.HashMap;

public class handler_str {
    public String a = "";
    public String b = "";
    public boolean is_roman;
    public char oper;
    private static int oper_count = 0; //счетчик операторов (для ошибок)
    public static String convert_to_rom(int value) {
        int[] roman_array = new int[]{ 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman_char = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < roman_array.length; i ++) {
            while (value >= roman_array[i]) {
                value -= roman_array[i];
                res.append(roman_char[i]);
            }
        }
        return res.toString();
    }
    public static class roman_val {
        static private HashMap<Integer, String> roman = new HashMap<>();
        static private HashMap<String, String> arab = new HashMap<>();
        static private String letters = "I IV V IX X";
        static private String opers = "+-*/";
        static String a = "";
        static String b = "";
        static char oper;
        static boolean is_roman;
        private static void fill_dic() {
            roman.put(1, "I");
            roman.put(2, "II");
            roman.put(3, "III");
            roman.put(4, "IV");
            roman.put(5, "V");
            roman.put(6, "VI");
            roman.put(7, "VII");
            roman.put(8, "VIII");
            roman.put(9, "IX");
            roman.put(10, "X");

            arab.put("I", "1");
            arab.put("II", "2");
            arab.put("III", "3");
            arab.put("IV", "4");
            arab.put("V", "5");
            arab.put("VI", "6");
            arab.put("VII", "7");
            arab.put("VIII", "8");
            arab.put("IX", "9");
            arab.put("X", "10");
        }
        private static boolean check_is_rom( char[] str) throws Exception
        {
            boolean roma = false;
            int count_dig = 0;
            for(int i = 0; i < str.length; i++)
            {
                if (Character.isDigit(str[i]))
                {
                    count_dig += 1;
                }
            }
            if (count_dig == 1) {
                throw new Exception("Неправильный ввод римских цифр");
            }
            else if(count_dig >= 2)
                roma = true;
            return roma;
        }
        public static String proc_roma(String str) throws Exception
        {
            char[] str_array = str.toCharArray();
            boolean is_flag = false;
            String arab_str = "";
            fill_dic();
            if(check_is_rom(str_array) == false) {

                for (int i = 0; i < str_array.length; i++) {
                    if (opers.contains(String.valueOf(str_array[i])) == false) {
                        if (letters.contains(String.valueOf(str_array[i]))) ;
                        {
                            is_roman = true;
                        }
                        if (is_flag == false)
                            a = a + str_array[i];
                        else
                            b = b + str_array[i];
                    } else {
                        oper = str_array[i];
                        is_flag = true;
                    }
                }

                arab_str = arab.get(a) + oper + arab.get(b);
                if (arab_str.contains("null") && is_roman) {
                    throw new Exception("Римские цифры вне диапазона или их не существует");
                }
            }

            return arab_str;
        }

    }

    private void check_line() throws Exception
    {
        String opers = "+-*/";

        if (Integer.valueOf(this.a) > 10 || Integer.valueOf(this.a) < 1) {
            throw new Exception("Число " + a + " не входит в диапазон");
        }
        if (Integer.valueOf(this.b) > 10 || Integer.valueOf(this.b) < 1) {
            throw new Exception("Число " + b + " не входит в диапазон");
        }
        if (Integer.valueOf(this.a) % 1 > 0 || Integer.valueOf(this.b) % 1 > 0 ){
            throw new Exception("Было введено нецелое число");
        }
        boolean is_opers = opers.contains(String.valueOf(this.oper));
        if (is_opers != true){
            throw new Exception("Неправильный оператор!");
        }
        if (this.oper_count > 1){
            throw new Exception("Введено несколько операторов!");
        }

    }

    public void return_ags( String exp ) throws Exception {
        boolean is_flag = false; // флажок для смены операнда
        String without_space = exp.replaceAll(" ", "");
        String rom_to_arab = roman_val.proc_roma(without_space);
        this.is_roman = roman_val.is_roman;
        if(roman_val.is_roman)
        {
            without_space = rom_to_arab;
        }

        char[] str_array = without_space.toCharArray();
        for(int i = 0; i < str_array.length; i++)
        {
            if (Character.isDigit(str_array[i]))
            {
                if( is_flag == false) {
                    this.a = this.a + str_array[i];
                }
                else if (is_flag) {
                    this.b = this.b + str_array[i];
                }
            }
            else
            {
                if(this.oper_count == 0) {
                    this.oper = str_array[i];
                    this.oper_count += 1;
                    is_flag = true;
                }

            }
        }

        check_line( );

    }
}

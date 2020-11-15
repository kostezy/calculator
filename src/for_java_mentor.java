import java.io.BufferedReader;
import java.io.InputStreamReader;

public class for_java_mentor {

    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("Введите выражение для вычисления");
                String exp = reader.readLine();
                handler_str input_str = new handler_str();
                input_str.return_ags(exp);
                calculator cal1 = new calculator(input_str.a,input_str.b,input_str.oper);
                if (input_str.is_roman)
                    System.out.println(input_str.convert_to_rom(cal1.get_result(input_str.oper)));
                else
                    System.out.println(cal1.get_result(input_str.oper));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

    }

}



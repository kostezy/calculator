public class calculator implements InterfaceCalculator {
    int a;
    int b;
    char oper;

    public calculator(String a, String b, char oper)
    {
        this.a = Integer.valueOf(a);
        this.b = Integer.valueOf(b);
        this.oper = oper;
    }

    public int addition(int a, int b)
    {
        return a+b;
    }
    public int subtraction(int a, int b)
    {
        return a-b;
    }
    public int multiplication(int a, int b)
    {
        return a*b;
    }
    public int division(int a, int b)
    {
        return a/b;
    }
    public int get_result(char oper)
    {
        int result = 0;
        switch (oper)
        {
            case '+':
                result = addition(a,b);
                break;
            case '-':
                result = subtraction(a,b);
                break;
            case '*':
                result = multiplication(a,b);
                break;
            case '/':
                result = division(a,b);
                break;
        }
        return result;
    }
}


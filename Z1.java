/* Задача 1. Дана строка sql-запроса "select * from students where ". 
Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.

Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

public class Z1
{
    public void sqL()
    {
        String a = "select * from students where ";
        String b = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
        System.out.println("Параметры для фильтрации: "+ b);
        String d = "";
        String c = b.replace("{", "").replace("}", "").replace("'", "").replace(",", "").replace(":", " ");
        //System.out.println(c);

        String [] str = c.split(" ");
/*         for (String str1: str)
        {
            System.out.print(str1 + " ");
        }
        //System.out.println(); */

        for (int i = 1; i < str.length; i = i + 2 )
        {
            if (!str[i].equals("null"))
            {
                d = d + str[i-1] + " = " + str[i] + " and ";
                //System.out.println(d);
            }
        }
        StringBuffer strBuffer = new StringBuffer(d);
        String str1 = strBuffer.substring(0, strBuffer.capacity() - 16-5); //количество символов, на которые зарезервирована память, минус 5 символов (" and ")
        //System.out.println(str1);
        System.out.println("Часть WHERE запроса: " + a + str1);
    }
}
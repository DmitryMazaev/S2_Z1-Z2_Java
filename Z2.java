//Задача 2. Реализуйте алгоритм сортировки пузырьком числового массива, 
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Z2 
{
    public void mass()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int n = in.nextInt();
        in.close();
        int [] array = new int[n];
        Random r = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = r.nextInt(0, 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        try (FileOutputStream fos = new FileOutputStream("Task.txt")) 
        {
            for (int j = 0; j < array.length-1; j++)
            {
                for (int k = 0; k < array.length - j- 1; k++)
                {
                    if (array[k] > array[k+1])
                    {
                        int temp = array[k];
                        array[k] = array[k+1];
                        array[k+1] = temp;
                    }   
                }
                System.out.println(Arrays.toString(array));
                String StrArray = Arrays.toString(array);
                
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(StrArray);
                String a = "\n";
                fos.write(stringBuilder.toString().getBytes());
                fos.write(a.getBytes());
            }
            fos.close();
        } 
        catch (IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
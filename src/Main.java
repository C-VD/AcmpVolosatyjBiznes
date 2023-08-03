import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ввод данных
        int nDays = safeReadInt("На сколько дней прогноз?");
        int[] prognosis = new int[nDays];
        for (int i = 0; i < nDays; i++) {
            prognosis[i] = safeReadInt("Цена 1 см волос в день " + i);
        }

        // Расчет
        int maxIncome = calculateMaxIncome(prognosis, 0);
        // Вывод суммы
        System.out.println("Максимальная прибыль: " + maxIncome);
    }
    static int safeReadInt(String prompt) {
        int result = 0;
        System.out.println(prompt);
        boolean readSuccess = false;
        Scanner sc = new Scanner(System.in);
        while (!readSuccess) {
            if (sc.hasNextDouble()) {
                result = sc.nextInt();
                readSuccess = true;

            } else {
                System.out.println("Wrong value!");
                sc.next();
            }
        }
        return result;
    }

    static int calculateMaxIncome(int[] prognosis, int firstDay)
    {
        int income = 0;
        int m;
        if (firstDay >= prognosis.length) {
            return 0;
        }
        m = getMaxInRange(prognosis, firstDay);
        income = prognosis[m] * (m - firstDay + 1);
        income += calculateMaxIncome(prognosis, m + 1);
        return income;
    }
    
    static int getMaxInRange(int[] arr, int firstNum)
    {
        int maxNum = firstNum;
        for (int i = firstNum; i < arr.length; i++)
        {
            if (arr[i] > arr[maxNum])
            {
                maxNum = i;
            }
        }
        return maxNum;
    }
}

package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        /*
              1. Дан массив дат из 10 элементов. Добавить в массив даты с командной строки. Часы: минуты
                Найти среди этих дат минимальное
        * */

        Date[] hourDate = new Date[10];
        SimpleDateFormat hourMin = new SimpleDateFormat("HH:mm");
        for(int i = 0; i < hourDate.length; i++)
        {
            int hour = (int)(Math.random()*(24-0))+0;
            int minutes = (int)(Math.random()*(60-0))+0;

            String hourMinutes = hour+":"+minutes;

            try {
                hourDate[i] = hourMin.parse(hourMinutes);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Date minDate = hourDate[0];
        System.out.println("*************************");
        System.out.println("Dates in array: ");
        for (int i = 0; i < hourDate.length; i++)
        {
            if(minDate.after(hourDate[i]))
            {
                minDate = hourDate[i];
            }
            System.out.print(hourMin.format(hourDate[i])+" | ");

        }

        System.out.println("\n");
        System.out.println("Min date in array: " + hourMin.format(minDate));


        System.out.println("*************************");
        System.out.print("Enter size array - ");
        int arrSize = scan.nextInt();

        Employee[] employees = new Employee[arrSize];
        String[] str = new String[arrSize];
        int[] changeYear0 = new int[arrSize];
        String[] peersEmpl = new String[arrSize];
        int[] seniorEmpl = new int[arrSize];

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        for(int i = 0; i < employees.length; i++){


            System.out.println("*************************");
            System.out.print("Enter name - ");
            String name = scan.next();

            System.out.print("Enter day - ");
            int day = scan.nextInt();

            System.out.print("Enter month - ");
            int month = scan.nextInt();

            System.out.print("Enter year - ");
            int year = scan.nextInt();

            String dd = String.valueOf(day);
            String mm = String.valueOf(month);
            String yy = String.valueOf(year);

            str[i] = dd+"."+mm;
            changeYear0[i] = Integer.valueOf(yy);
            peersEmpl[i] = String.valueOf(yy);
            seniorEmpl[i] = Integer.valueOf(yy);

            String dMY = dd+"."+mm+"."+yy;
            employees[i] = new Employee(dMY, name);

        }

        /*
            День рождения сотрудников
                    Сегодня.
                    Завтра.
        * */
        SimpleDateFormat sdftoDay = new SimpleDateFormat("dd.M");
        Date toDay = new Date();
        Date tomorrow = new Date();

        String date1 = sdftoDay.format(toDay);
        String date2 = sdftoDay.format(tomorrow.getTime() + 86400000);

        System.out.println("*************************");
        System.out.println("Birth day today: ");
        for(int i = 0; i < employees.length; i++)
        {
            if(str[i].equals(date1))
            {
                System.out.println(i+ ") " + "Employee name: " + employees[i].getName());

            }
        }

        System.out.println("*************************");
        System.out.println("Birth day tomorrow: ");
        for (int i = 0; i < employees.length; i++)
        {
            if (str[i].equals(date2))
            {
                System.out.println(i+ ") " + "Employee name: " + employees[i].getName());
            }

        }


        /*
            Средний возраст сотрудников
        * */
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        Date dateYear = new Date();
        String thisYear = sdfYear.format(dateYear);
        int currentYear = Integer.valueOf(thisYear);
        int sr = 0;
        System.out.println("*************************");
        for (int i = 0; i < employees.length; i++)
        {
            sr += changeYear0[i];
        }
        System.out.println("Average age employees: " + (currentYear-(sr/arrSize)));
        System.out.println("*************************");

        /*
            Вывести самого старшего сотрудника
        * */
        System.out.print("Senior's employee birth year: ");
        int min = seniorEmpl[0];
        for (int i = 0; i < employees.length; i++)
        {
            if(min > seniorEmpl[i])
            {
                min = seniorEmpl[i];

            }
        }
        System.out.println(min);

        /*
            Найти ровестников
        * */

        System.out.println("*************************");
        System.out.println("Peers: ");
        int j =0 ,i = 0;
        for(i = 0; i < employees.length; i++)
        {
            for(j = 0; j < i; j++)
            {
                if(peersEmpl[i].equals(peersEmpl[j]))
                {
                    System.out.println(employees[i].getName()+" - "+employees[j].getName());
                }
            }
        }
        System.out.println("*************************");

    }
}

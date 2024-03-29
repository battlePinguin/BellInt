import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {

        List<Map<String, String>> employees = new ArrayList<>();
        Map<String, String> employee1 = new HashMap<>();
        employee1.put("имя", "Кирилл");
        employee1.put("возраст", "26");
        employee1.put("должность", "Middle java dev");
        employee1.put("зарплата", "150000 руб");
        Map<String, String> employee2 = new HashMap<>();
        employee2.put("имя", "Виталий");
        employee2.put("возраст", "28");
        employee2.put("должность", "Senior java automation QA");
        employee2.put("зарплата", "2000$");
        Map<String, String> employee3 = new HashMap<>();
        employee3.put("имя", "Александр");
        employee3.put("возраст", "31");
        employee3.put("должность", "junior functional tester");
        employee3.put("зарплата", "50000 руб");
        Map<String, String> employee4 = new HashMap<>();
        employee4.put("имя", "Дементий");
        employee4.put("возраст", "35");
        employee4.put("должность", "dev-ops");
        employee4.put("зарплата", "1500$");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        employees.stream()
                .filter(emp -> Integer.parseInt(emp.get("возраст")) < 30)
                .map(emp -> emp.get("имя"))
                .forEach(System.out::println);

        employees.stream()
                .filter(emp -> emp.get("зарплата").trim().endsWith("$"))
                .map(emp -> emp.get("имя"))
                .forEach(System.out::println);

        employees.stream()
                .mapToDouble(emp -> Integer.parseInt(emp.get("возраст")))
                .average()
                .ifPresent(System.out::println);

    }

    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение количества строк и столбцов матрицы ");
        int count = scanner.nextInt();
        scanner.nextLine();


        Integer[][] matrix = new Integer[count][count];
// создаем матрицу с рандомным набором
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(-100, 100 + 1);
            }
        }
// находим диагональ и сохраняем ее
        Integer[] diagonal = new Integer[count];
        for (int i = matrix.length - 1, j = 0; i >= 0 && j < matrix[0].length; i--, j++) {
            if (j == i) {
                diagonal[j] = null;
                continue;
            }
            diagonal[j] = matrix[i][j];
        }
//        печатаем искомую диагональ
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == diagonal[j] && diagonal[j] != null) {
                    System.out.print(" " + "\033[1m" + matrix[i][j] + "\033[0m");
                } else {
                    System.out.print(" " + matrix[i][j]);
                }
            }

            System.out.println();
        }
    }

    public static void task3() {

        int size_0 = 4;
        int[][] matrix_0 = new int[size_0][size_0];

        // Заполнение матрицы 4*4
        for (int i = 0; i < size_0; i++) {
            for (int j = 0; j < size_0; j++) {
                if (i == 0 || i == size_0 - 1 || j == 0 || j == size_0 - 1) {
                    matrix_0[i][j] = 1; // края заполняются 1
                } else if (i == 1 || i == size_0 - 2 || j == 1 || j == size_0 - 2) {
                    matrix_0[i][j] = 0; // внутренний квадрат заполняется 0
                }
            }
        }

        // Распечатка матрицы
        for (int i = 0; i < size_0; i++) {
            for (int j = 0; j < size_0; j++) {
                System.out.print(matrix_0[i][j] + " ");
            }
            System.out.println();
        }


        int size_1 = 6;
        int[][] matrix_1 = new int[size_1][size_1];

        // Заполнение матрицы 6*6
        for (int i = 0; i < size_1; i++) {
            for (int j = 0; j < size_1; j++) {
                if (i == 0 || i == size_1 - 1 || j == 0 || j == size_1 - 1) {
                    matrix_1[i][j] = 2; // края заполняются 2
                } else if (i == 1 || i == size_1 - 2 || j == 1 || j == size_1 - 2) {
                    matrix_1[i][j] = 1;  // 2 и 5 строки и столбцы заполняются 1
                } else if ((i == 3 && j == 3) || (i == 3 && j == size_1 - 4) || (i == size_1 - 4 && j == 3) || (i == size_1 - 4 && j == size_1 - 4)) {
                    matrix_1[i][j] = 0; // внутри квадрата из 4 нулей
                }
            }
        }
        // Распечатка матрицы
        for (int i = 0; i < size_1; i++) {
            for (int j = 0; j < size_1; j++) {
                System.out.print(matrix_1[i][j] + " ");
            }
            System.out.println();
        }

        int size_2 = 8;
        int[][] matrix_2 = new int[size_2][size_2];
        // Заполнение матрицы 8*8
        for (int i = 0; i < size_2; i++) {
            for (int j = 0; j < size_2; j++) {
                if (i == 0 || i == size_2 - 1 || j == 0 || j == size_2 - 1) {
                    matrix_2[i][j] = 3; // внешний край заполняется 3
                } else if (i == 1 || i == size_2 - 2 || j == 1 || j == size_2 - 2) {
                    matrix_2[i][j] = 2; // 2 и 7 строки и столбцы заполняются 2
                } else if (i == 2 || i == size_2 - 3 || j == 2 || j == size_2 - 3) {
                    matrix_2[i][j] = 1; // 3 и 6 строки и столбцы заполняются 1
                } else if ((i == 3 && j == 3) || (i == 3 && j == size_2 - 4) || (i == size_2 - 4 && j == 3) || (i == size_2 - 4 && j == size_2 - 4)) {
                    matrix_2[i][j] = 0; // внутри квадрат из 4 нулей
                }
            }
        }

        // Распечатка матрицы
        for (int i = 0; i < size_2; i++) {
            for (int j = 0; j < size_2; j++) {
                System.out.print(matrix_2[i][j] + " ");
            }
            System.out.println();
        }

    }
}




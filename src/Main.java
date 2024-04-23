import java.util.Scanner;

public class Main {

    public static class Employee {
        // Biến thành viên để lưu trữ thông tin nhân viên
        public int id;
        public String name;
        public int age;
        public String department;
        public String code;
        private double salary; // Khai báo private để kiểm soát quyền truy cập

        // Hàm tạo khởi tạo thông tin nhân viên
        public Employee(int empId, String empName, int empAge, String empDepartment, String empCode) {
            id = empId;
            name = empName;
            age = empAge;
            department = empDepartment;
            code = empCode;
        }

        // Phương thức đặt lương cho nhân viên
        public void setSalary(double empSal) {
            salary = empSal;
        }

        // Phương thức lấy lương của nhân viên
        public double getSalary() {
            return salary;
        }

        // Phương thức in thông tin nhân viên
        public void printEmp() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Department: " + department);
            System.out.println("Code: " + code);
            System.out.println("Salary: " + salary);
            System.out.println("--------------------");
        }
    }

    public static void main(String args[]) {
        Employee[] employees = new Employee[10]; // Khởi tạo mảng chứa 10 nhân viên

        // Khởi tạo thông tin cho 10 nhân viên
        employees[0] = new Employee(1, "John Doe", 30, "IT", "E001");
        employees[1] = new Employee(2, "Jane Smith", 35, "HR", "E002");
        employees[2] = new Employee(3, "Michael Key", 45, "Finance", "E003");
        employees[3] = new Employee(4, "Johnson", 40, "BA", "E004");
        employees[4] = new Employee(5, "Michael", 40, "Tester", "E005");
        employees[5] = new Employee(6, "Peter Johnson", 62, "Front End", "E006");
        employees[6] = new Employee(7, "Michael Jusin", 43, "Back End", "E007");
        employees[7] = new Employee(8, "Michael KeyTray", 32, "QA", "E008");
        employees[8] = new Employee(9, "Julia Johnson", 44, "UI/UX", "E009");
        employees[9] = new Employee(10, "Michael Nguyen", 45, "Bitcoin", "E010");

        // Set lương cho từng nhân viên
        employees[0].setSalary(3000);
        employees[2].setSalary(1000);
        employees[1].setSalary(3500);
        employees[3].setSalary(4000);
        employees[4].setSalary(4500);
        employees[5].setSalary(5000);
        employees[6].setSalary(5500);
        employees[7].setSalary(6000);
        employees[8].setSalary(6500);
        employees[9].setSalary(7000);

        // In ra tiêu đề bảng
        System.out.println("+----+-----------------+-----+---------------+-------+---------+");
        System.out.println("| ID |      Name       | Age |   Department  |  Code | Salary  |");
        System.out.println("+----+-----------------+-----+---------------+-------+---------+");

        // In ra thông tin của từng nhân viên
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.printf("| %-2d | %-15s | %-3d | %-13s | %-5s | %-7.2f |\n",
                        emp.id, emp.name, emp.age, emp.department, emp.code, emp.getSalary());
            }
        }

        // In ra đường kẻ dưới cùng của bảng
        System.out.println("+----+-----------------+-----+---------------+-------+---------+");

        // Mảng mới để lưu thông tin của nhân viên mới
        Employee[] newEmployees = new Employee[2];

        // Thêm nhân viên mới
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin của nhân viên mới:");

        for (int i = 0; i < 2; i++) {
            System.out.print("ID: "); // In ra lời nhắc nhập ID
            int id = scanner.nextInt(); // Đọc giá trị ID từ người dùng (kiểu số nguyên)
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số nguyên

            System.out.print("Department: ");
            String department = scanner.nextLine();

            System.out.print("Code: ");
            String code = scanner.nextLine();

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            System.out.println("--------------------");

            // Tạo đối tượng nhân viên mới với thông tin đã nhập
            newEmployees[i] = new Employee(id, name, age, department, code);
            newEmployees[i].setSalary(salary);
        }

        // In ra thông tin của nhân viên mới
        System.out.println("Thông tin của nhân viên mới khi đã được thêm vào:");
        for (Employee emp : newEmployees) {
            emp.printEmp();
        }

        // Xóa nhân viên
        System.out.print("Nhập ID của nhân viên muốn xóa: ");
        int deleteId = scanner.nextInt();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].id == deleteId) { // Kiểm tra xem phần tử có null hay không và ID có trùng khớp hay không
                employees[i] = null; // Xóa nhân viên khỏi mảng
                System.out.println("Nhân viên có ID " + deleteId + " đã được xóa.");
                break;
            }
        }

        // In ra thông tin sau khi xóa nhân viên
        System.out.println("Danh sách nhân viên sau khi xóa:");

        // In ra tiêu đề bảng
        System.out.println("+----+-----------------+-----+---------------+-------+---------+");
        System.out.println("| ID |      Name       | Age |   Department  |  Code | Salary  |");
        System.out.println("+----+-----------------+-----+---------------+-------+---------+");

        // In ra thông tin của từng nhân viên sau khi xóa nhân viên
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.printf("| %-2d | %-15s | %-3d | %-13s | %-5s | %-7.2f |\n",
                        emp.id, emp.name, emp.age, emp.department, emp.code, emp.getSalary());
            }
        }

        System.out.println("+----+-----------------+-----+---------------+-------+---------+");

        scanner.close();
    }
}

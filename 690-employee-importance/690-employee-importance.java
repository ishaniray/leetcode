/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Employee employee = findEmployee(employees, id);
        int totalImportance = employee.importance;
        for (int subordinateId : employee.subordinates) {
            totalImportance += getImportance(employees, subordinateId);
        }
        return totalImportance;
    }
    
    private Employee findEmployee(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }
}
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
        return calculateTotalImportance(mapify(employees), id);
    }
    
    private Map<Integer, Employee> mapify(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return employeeMap;
    }
    
    private int calculateTotalImportance(Map<Integer, Employee> employeeMap, int id) {
        Employee employee = employeeMap.get(id);
        int totalImportance = employee.importance;
        for (int subordinateId : employee.subordinates) {
            totalImportance += calculateTotalImportance(employeeMap, subordinateId);
        }
        return totalImportance;
    }
}
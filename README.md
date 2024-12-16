1. Java 8 Stream API practices
  1. Create an Employee class with two instance fields:
    1. a String name
    2. an Integer salary
  2. Create a List of employees (be sure to implement the equals() and hashcode()
  methods)
  3. Use Java 8 Stream and Lambda Expression to achieve the following:
    1. Calculate the average salary of the list of employees
    2. Filter for employees whose salary exceeds 80000 and print out their names
    3. Collect a Map of employees where the key is the name of employee (String) and
    the value is the employee object (Employee)
  4. Find any Employee whose name starts with the character X
    1. If such an employee exists then print out the name, if not then print “no
    such employee exists”
  5. Create a String that contains the name of every single employee in the list
    concatenated together.
2. Create a user defined exception class called NonIntResultException which is generated
when the result of dividing two integer values produces a result with a fractional
component (i.e the result is not an integer)
NonIntResultException contains:
  1. A constructor with parameter that represent the two integer values
  2. Generates an appropriate message, for example if the two integers are 7 and 2,
  the resulting exception message would be: 7 divided by 2 is not an integer

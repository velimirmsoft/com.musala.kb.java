Write a program that reads given information from a text file about compmany's staff and prints:
* The average age of the employees;
* The first three most common characters in the names of the employees;
* The average length of service of the employees;
* The maximum length of service among all employees;

Example of the file containing the data.?
The string "<<>>" is used as a separator between employees.

Variations: 
* Use Iterator pattern for reading the input file (to prevent storing all employees in memory) 
* Use Strategy pattern for the different types of calculations (to encapsulate each of the algorithms) 
* Externalize employee separators, and field keys in a separate properties file 
* Instead of using a text file, create an XML with company's staff information. Your program should be able to read that XML from a JMS queue
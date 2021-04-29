# FintechProject
This repo contains projects that relate to Financial Technology Solutions
// The Challenge:
// developing a piece of software that will automate the processing of bank statements so a Client can get better insights into their finances.
// This will be a "simple" version of our application , using csv file as bankStatement
// and we will write the application code in a single class
/**
 * This class will load a CSV file as a command-line argument to the application.
 * The Path class represents a path in our filesystem. Then we use Files.readAllLines() to return a list of lines.
 * Once we have all the lines from the file, we  parse them one at a time by:
 * Splitting the columns by commas, Extracting the amount, Parsing the amount to parseDouble
 * Once we have the amount for a given statement as a double we will add that to the current total.
 * Note: the code does not provide for and empty file, corrupted data , missing data scenarios in this form.
 *
 * What we will query from the CSV data is (The code below answers query 1&2):
 * 1.What is the total profit and loss from a list of bank statements? is it positive or negative?
 * 2.How many bank transactions are there in a particular month?
 * 3.what are the top-10 expenses?
 * 4.Which category does he spend most of his money on?
 * ==================================================
 * APPROACH
 * ==================================================
 * The Code below attempts to answer the first two queries,
 * We will not continue answering the others because we would be running the risk of creating a "God mess" or
 * anti-pattern because we will be adding more and more methods or features to this single class.
 * Given these type of concerns we will make use of SOLID principles ,the first of which will be
 * Single Responsibility Principle(SRP) :
 * this general software development guideline contributes to writing  code that is easier to manage and maintain
 * the concept SRP can be described as
 * -- A class has responsibility over a single functionality
 * -- There is only one single reason for a class to change
 * SRP is concerned with one particular behaviour,concept or category.If applied correctly will lead to robust code,
 * because there is one specific reason the code should change instead of multiple concerns.Multiple concerns are
 * problematic because it complicate maintainability by potentially introducing bugs as the application scales.
 * It can also make code harder to understand and change.
 *
 * To apply SRP, from the the code below we can extract/see responsibilities in the implementation namely
 * 1.Read input//2.Parsing the input in a given format//3.Processing the result//4.Reporting summary of the result
 *

package FinTechFirstDraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
 * We will not continue answering the others because we would be running the risk of creating a "God class" or
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
 * >>We will extract the parsing logic into a separate class called BankStatementCSVParser
 * >>create a domain class for a bank transaction called BankTransaction -- after which we can refactor the application
 *   so that it uses our
 * >>BankStatementCSVParsers' parseLineFromCSV() method in particular
 *
 */
public class BankTransactionalAnalyzerSimple {
    private static final String RESOURCES = "/Users/winstondevilliers/bank-statement-simple.csv";
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String...args) throws IOException {
    final Path path = Paths.get(RESOURCES);
    final List<String> lines = Files.readAllLines(path);
    double total = 0d;
    for(final String line:lines){
        final String[] columns = line.split(",");
        final double amount = Double.parseDouble(columns[1]);
        total += amount;
    }
    System.out.println("The total for all transactions is "+total);
    HowManyTransactionsInAMonth();
    }
    public static void HowManyTransactionsInAMonth() throws IOException {
            final Path path = Paths.get(RESOURCES);
            final List<String> lines = Files.readAllLines(path);
            double total = 0d;
            final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for(final String line:lines){
                final String[] columns = line.split(",");
                final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
                if(date.getMonth() == Month.JANUARY){
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
            System.out.println("The total for all transactions for JANUARY is "+total);
        }
    }
}

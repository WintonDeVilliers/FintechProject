package FinTechFirstDraft;

import FinTech.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class declares two methods, parseFromCSV() and parseLinesFromCSV() , that generate BankTransaction objects,
 * which is a domain class that models a bank statement
 *
 * FUNCTIONAL GROUPING (CLASS LEVEL COHESION)
 * The approach you took when writing the BankStatementCSVParser was to group the methods functionally.
 * The methods parseFrom() and parseLinesFrom() are solving a defined task: parse the lines in the CSV format. In fact,
 * the method parseLinesFrom() uses the method parseFrom(). This is generally a good way to achieve high cohesion
 * because the methods are working together, so it makes sense to group them so they are easier to locate and understand.
 * The danger with functional cohesion is that it may be tempting to have a profusion of overly simplistic classes
 * grouping only a single method. Going down the road of overly simplistic classes adds unnecessary verbosity and
 * complexity because there are many more classes to think about.
 */
public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");



    private BankTransaction parseFromCSV(final String line){
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date,amount,description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List <String> lines){
     final List<BankTransaction> bankTransactions = new ArrayList<>();
    for(final String line:lines){
         bankTransactions.add(parseFromCSV(line));
     }
     return bankTransactions;
    }
}

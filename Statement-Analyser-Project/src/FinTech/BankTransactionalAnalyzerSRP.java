package FinTech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionalAnalyzerSRP {

    private static final String RESOURCES = "/Users/winstondevilliers/bank-statement-simple.csv";
    /**
     * @param args
     * @throws IOException
     */
    public static void main(final String...args) throws IOException {

        final BankStatementCSVParserREFAC bankStatementParser = new BankStatementCSVParserREFAC();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
        }

        private static double calculateTotalAmount(final List<BankTransaction> bankTransaction){
            return bankTransaction.stream().mapToDouble(BankTransaction::getAmount).sum();
    }
    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransaction, final Month month){
        return bankTransaction.stream().filter(bankStatement -> month.equals(bankStatement.getDate().getMonth())).collect(Collectors.toList());
    }
}

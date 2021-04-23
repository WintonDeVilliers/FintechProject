package FinTech;

import java.time.Month;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class BankStatementAnalyzerSRPplus {

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
            BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

            collectSummary(bankStatementProcessor);
        }

        private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
            System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
            System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
            System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
            System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        }
}


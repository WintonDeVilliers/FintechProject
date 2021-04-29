package FinTech;

import java.io.IOException;

public class Main {
    public static void main(final String...args) throws IOException{

        final BankStatementAnalyzer bankStatementAnalyzerSRP = new BankStatementAnalyzer();
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        bankStatementAnalyzerSRP.analyse(args[0], bankStatementCSVParser);
    }
}

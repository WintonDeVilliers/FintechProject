package FinTech;

import java.time.LocalDate;

/**
 * INFORMATIONAL GROUPING(CLASS LEVEL COHESION)
 * Another reason to group methods is because they work on the same data or domain object. Say you needed a way to
 * create, read, update, and delete BankTransaction objects (CRUD operations); you may wish to have a class dedicated
 * for these operations. The code in Example 2-9 shows a class that exhibits informational cohesion with four different
 * methods. Each method throws a UnsupportedOperationException to indicate the body is currently unimplemented for the
 * purpose of the example.
 *
 * This is a typical pattern that you see often when interfacing with a database that maintains a table for a specific
 * domain object. This pattern is usually called Data Access Object (DAO) and requires some kind of ID to identify the
 * objects. DAOs essentially abstract and encapsulate access to a data source, such as a persistent database or an
 * in-memory database.
 *
 * UTILITY
 * You may be tempted to group different unrelated methods inside a class. This happens when it is not obvious where
 * the methods belong so you end up with a utility class that is a bit like a jack of all trades.
 *
 * This is generally to be avoided because you end up with low cohesion. The methods are not related, so the class as
 * a whole is harder to reason about. In addition, utility classes exhibit a poor discoverability characteristic.
 * You want your code to be easy to find and easy to understand how it is supposed to be used. Utility classes go
 * against this principle because they contain different methods that are unrelated without a clear categorization.
 *
 * LOGICAL
 * Say you needed to provide implementations for parsing from CSV, JSON, and XML. You may be tempted to group the
 * methods responsible for parsing the different format inside one class,
 * In fact, the methods are logically categorized to do “parsing.” However, they are different by nature and each of
 * the methods would be unrelated. Grouping them would also break the SRP, which you learned about earlier, because
 * the class is responsible for multiple concerns. Consequently, this approach is not recommended.
 *
 *
 *
 */
public class BankTransactionDAO {
    public BankTransaction create(final LocalDate date, final double amount, final String description){
        //..
        throw new UnsupportedOperationException();
    }
    public BankTransaction read(final long id){
        //..
        throw new UnsupportedOperationException();
    }
    public BankTransaction update(final long id){
        //..
        throw new UnsupportedOperationException();
    }
    public void delete(final BankTransaction BankTransaction){
        //..
        throw new UnsupportedOperationException();
    }
}

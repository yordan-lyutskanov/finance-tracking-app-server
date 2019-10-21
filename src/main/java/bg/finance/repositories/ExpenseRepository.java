package bg.finance.repositories;

import bg.finance.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    public List<Expense> findByUser(int user);
    public void deleteByUser(int user);
}
